/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.linkshortener.portlet;

import com.liferay.compat.util.bridges.mvc.MVCPortlet;
import com.liferay.linkshortener.model.Link;
import com.liferay.linkshortener.service.LinkServiceUtil;
import com.liferay.portal.kernel.exception.NestableException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import static com.liferay.linkshortener.portlet.AutoShortenerConstants.ENCODED_LINK_PARAM;
import static com.liferay.linkshortener.portlet.AutoShortenerConstants.LINK_PARAM;
import static com.liferay.linkshortener.util.ApplicationPropsValues.LINK_SHORTENER_HOSTNAME;

/**
 * @author Miroslav Ligas
 */
public class AutoShortenerPortlet extends MVCPortlet {

	public void shortenLinkAction(
		ActionRequest request, ActionResponse response) {

		String longLink = getAndValidateData(request);

		try {
			if (longLink != null) {
				Link link = storeLongLink(longLink);

				String encodedLink = addHostName(link.getShortLink());
				response.setRenderParameter(ENCODED_LINK_PARAM, encodedLink);
			}
		}
		catch (NestableException e) {
			SessionErrors.add(request, "auto-shortener-not-saved");
			_LOG.error("Unable to store the new link.", e);
		}
	}

	private String addHostName(String shortLink) {
		return LINK_SHORTENER_HOSTNAME + StringPool.FORWARD_SLASH + shortLink;
	}

	private String getAndValidateData(ActionRequest request) {
		String result = ParamUtil.getString(
			request, LINK_PARAM, StringPool.BLANK).trim();

		if (result.equals(StringPool.BLANK)) {
			SessionErrors.add(request, "link-required");
		}

		return result;
	}

	private Link storeLongLink(String longLink) throws NestableException {
		Link link = LinkServiceUtil.linkFactory();
		link.setLongLink(longLink);
		link.setAutoGen(true);

		return LinkServiceUtil.addLink(link);
	}

	private static Log _LOG = LogFactoryUtil.getLog(AutoShortenerPortlet.class);

}