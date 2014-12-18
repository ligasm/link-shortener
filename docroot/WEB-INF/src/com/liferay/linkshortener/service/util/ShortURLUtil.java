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

package com.liferay.linkshortener.service.util;

import com.liferay.compat.portal.kernel.util.StringUtil;

/**
 * Bijective conversion between natural numbers (IDs) and short strings
 *
 * Removed characters (a,e,i,o,u) to prevent offensive words
 *
 * @author Miroslav Ligas
 */
public class ShortURLUtil {

	public static final String ALPHABET =
		"1234567890bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ-_";

	public static final int BASE = ALPHABET.length();

	public static final int BUFFER_SIZE = 15;

	public static long decode(String str) {
		long num = 0;

		for (int i = 0; i < str.length(); i++) {
			int index = ALPHABET.indexOf(str.charAt(i));
			num = num * BASE + index;
		}

		return num;
	}

	public static String encode(long num) {
		char[] buffer = new char[BUFFER_SIZE];
		int i = 0;
		while (num > 0) {
			int index = (int) (num % BASE);
			buffer[i] = ALPHABET.charAt(index);
			num = num / BASE;
			i++;
		}

		String result = new String(buffer).trim();
		return StringUtil.reverse(result);
	}

}