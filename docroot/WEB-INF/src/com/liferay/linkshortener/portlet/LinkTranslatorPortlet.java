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
import com.liferay.linkshortener.ShortLinkTakenException;
import com.liferay.linkshortener.model.Link;
import com.liferay.linkshortener.service.LinkLocalServiceUtil;
import com.liferay.portal.kernel.exception.NestableException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

import static com.liferay.linkshortener.portlet.LinkTranslatorConstants.LINK_ID_PARAM;

/**
 * @author Miroslav Ligas
 */
public class LinkTranslatorPortlet extends MVCPortlet {

	public void addLink(ActionRequest request, ActionResponse response) {

		Link link = bindAndValidateObject(request);

		if (SessionErrors.isEmpty(request)) {
			try {
				LinkLocalServiceUtil.addLinkWithCheck(link);
			}
			catch (SystemException e) {
				SessionErrors.add(request, "link-translator-unable-to-add");
				_LOG.error("Unable to add new entity.", e);
			}
			catch (ShortLinkTakenException e) {
				SessionErrors.add(request, "link-translator-link-taken");
				_LOG.info("Short link is already taken.");
			}
		}
	}

	public void deleteLink(ActionRequest request, ActionResponse response) {
		long linkId = ParamUtil.getLong(request, LINK_ID_PARAM, 0);

		if (linkId != 0) {
			try {
				LinkLocalServiceUtil.deleteLink(linkId);
			}
			catch (NestableException e) {
				SessionErrors.add(request, "link-translator-unable-to-delete");
				_LOG.error("Unable to delete entry with ID " + linkId, e);
			}
		}
		else {
			SessionErrors.add(request, "link-translator-wrong-entry-id");
		}
	}

	public void editLink(ActionRequest request, ActionResponse response) {
		Link link = bindAndValidateObject(request);

		if (SessionErrors.isEmpty(request)) {
			try {
				LinkLocalServiceUtil.updateLinkWithCheck(link);
			}
			catch (SystemException e) {
				SessionErrors.add(request, "link-translator-unable-to-update");
				_LOG.error(
					"Unable to update link with Id " + link.getLinkId(), e);
			}
			catch (ShortLinkTakenException e) {
				SessionErrors.add(request, "link-translator-link-taken");
				_LOG.info("Short link is already taken.");
			}
		}
	}

	private Link bindAndValidateObject(PortletRequest request) {
		Link result = LinkLocalServiceUtil.linkFactory();

		long linkId = ParamUtil.getLong(request, "linkId");
		String shortLink = ParamUtil.getString(request, "shortLink");
		String longLink = ParamUtil.getString(request, "longLink");
		boolean active = ParamUtil.getBoolean(request, "active");

		result.setLinkId(linkId);
		result.setLongLink(longLink);
		result.setShortLink(shortLink);
		result.setActive(active);
		result.setAutoGen(false);

		LinkValidator.getInstance().validate(request, result);

		return result;
	}

	private static Log _LOG = LogFactoryUtil.getLog(
		LinkTranslatorPortlet.class);

}