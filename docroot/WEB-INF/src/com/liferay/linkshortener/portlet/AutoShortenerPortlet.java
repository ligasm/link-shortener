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
import com.liferay.linkshortener.service.LinkLocalServiceUtil;
import com.liferay.linkshortener.service.util.ShortURLUtil;
import com.liferay.portal.kernel.exception.NestableException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import static com.liferay.linkshortener.portlet.AutoShortenerConstants.AUTO_SHORTEN_PREFIX;
import static com.liferay.linkshortener.portlet.AutoShortenerConstants.ENCODED_LINK_PARAM;
import static com.liferay.linkshortener.portlet.AutoShortenerConstants.LINK_PARAM;
import static com.liferay.linkshortener.util.ApplicationPropsValues.LINK_SHORTENER_HOSTNAME;

/**
 * @author Miroslav Ligas
 */
public class AutoShortenerPortlet extends MVCPortlet {

	public void shortenLinkAction(
		ActionRequest request, ActionResponse response) {

		try {
			Link link = storeLongLink(request);

			String encodedLink = getEncodedLink(link.getLinkId());
			response.setRenderParameter(ENCODED_LINK_PARAM, encodedLink);
		}
		catch (NestableException e) {
			SessionErrors.add(request, "auto-shortener-not-saved");
			_LOG.error("Unable to store the new link.", e);
		}
	}

	private String getEncodedLink(long linkId) {
		return LINK_SHORTENER_HOSTNAME + StringPool.FORWARD_SLASH +
			AUTO_SHORTEN_PREFIX + ShortURLUtil.encode(linkId);
	}

	private Link storeLongLink(PortletRequest request)
		throws NestableException {

		String longLink = ParamUtil.getString(request, LINK_PARAM);

		Link link = LinkLocalServiceUtil.linkFactory();
		link.setLongLink(longLink);
		link.setAutoGen(true);

		return LinkLocalServiceUtil.addLinkWithCheck(link);
	}

	private static Log _LOG = LogFactoryUtil.getLog(AutoShortenerPortlet.class);

}