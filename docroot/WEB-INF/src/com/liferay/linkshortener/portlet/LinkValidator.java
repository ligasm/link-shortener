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

import com.liferay.linkshortener.model.Link;
import com.liferay.linkshortener.util.ApplicationConstants;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.StringPool;

import javax.portlet.PortletRequest;

/**
 * @author Miroslav Ligas
 */
public class LinkValidator {

	public static LinkValidator getInstance() {
		return _INSTANCE;
	}

	public void validate(PortletRequest request, Link link) {
		String shortLink = link.getShortLink();

		if ((shortLink == null) || shortLink.trim().equals(StringPool.BLANK)) {
			SessionErrors.add(request, "short-link-required");
		}
		else if (shortLink.length() < ApplicationConstants.MIN_SHORT_URL) {
			SessionErrors.add(request, "short-link-to-short");
		}

		String longLink = link.getLongLink();

		if ((longLink == null) || longLink.trim().equals(StringPool.BLANK)) {
			SessionErrors.add(request, "long-link-required");
		}
	}

	private static final LinkValidator _INSTANCE = new LinkValidator();

}