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

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;

/**
 * @author Miroslav Ligas
 */
public class ApplicationPropsValues {

	public static final String LINK_SHORTENER_HOSTNAME = GetterUtil.getString(
		PropsUtil.get(ApplicationConstants.LINK_SHORTENER_HOSTNAME));

	public static final int LINK_SHORTENER_LINK_TTL = GetterUtil.getInteger(
		PropsUtil.get(ApplicationConstants.LINK_SHORTENER_LINK_TTL), 6);

}