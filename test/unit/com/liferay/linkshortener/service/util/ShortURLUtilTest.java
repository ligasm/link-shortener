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

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Miroslav Ligas
 */
public class ShortURLUtilTest {

	@Before
	public void setup() {
		_random = new Random();
	}

	@Test
	public void testDecode() throws Exception {
		String value = "22";
		long decoded = ShortURLUtil.decode(value);
		assertEquals(55l, decoded);

		value = "21";
		decoded = ShortURLUtil.decode(value);
		assertEquals(54l, decoded);

		value = "_";
		decoded = ShortURLUtil.decode(value);
		assertEquals(53l, decoded);

		value = "2";
		decoded = ShortURLUtil.decode(value);
		assertEquals(1l, decoded);

		value = "QMmnKztQyLt";
		decoded = ShortURLUtil.decode(value);
		assertEquals(Long.MAX_VALUE, decoded);
	}

	@Test
	public void testEncode() throws Exception {
		long value = 0;
		String encoded = ShortURLUtil.encode(value);
		assertEquals("", encoded);

		value = 1;
		encoded = ShortURLUtil.encode(value);
		assertEquals("2", encoded);

		value = 53;
		encoded = ShortURLUtil.encode(value);
		assertEquals("_", encoded);

		value = 54;
		encoded = ShortURLUtil.encode(value);
		assertEquals("21", encoded);

		value = 55;
		encoded = ShortURLUtil.encode(value);
		assertEquals("22", encoded);

		value = Long.MAX_VALUE;
		encoded = ShortURLUtil.encode(value);
		assertEquals("QMmnKztQyLt", encoded);
	}

	@Test
	public void testEncodeDecode() throws Exception {
		for (int i = 0; i < 2000; i++) {
			long value = _random.nextLong();

			if (value > 0) {
				String encoded = ShortURLUtil.encode(value);
				long decoded = ShortURLUtil.decode(encoded);
				assertEquals(value, decoded);
			}
		}
	}

	private Random _random;

}