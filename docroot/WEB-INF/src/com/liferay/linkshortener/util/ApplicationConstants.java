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

package com.liferay.linkshortener.util;

/**
 * @author Miroslav Ligas
 */
public class ApplicationConstants {

	public static final String AUTO_SHORTEN_PREFIX = "OAU";

	public static final String LINK_SHORTENER_CLEANUP_LIMIT =
		"link.shortener.cleanup.limit";

	public static final String LINK_SHORTENER_HOSTNAME =
		"link.shortener.hostname";

	public static final String LINK_SHORTENER_LINK_TTL =
		"link.shortener.link.ttl";

	public static final short MIN_SHORT_URL = 4;

	public static final int PREFIX_SIZE = AUTO_SHORTEN_PREFIX.length();

}