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

package com.liferay.linkshortener.service.base;

import com.liferay.linkshortener.service.LinkServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class LinkServiceClpInvoker {
	public LinkServiceClpInvoker() {
		_methodName22 = "getBeanIdentifier";

		_methodParameterTypes22 = new String[] {  };

		_methodName23 = "setBeanIdentifier";

		_methodParameterTypes23 = new String[] { "java.lang.String" };

		_methodName28 = "addLink";

		_methodParameterTypes28 = new String[] {
				"com.liferay.linkshortener.model.Link"
			};

		_methodName29 = "deleteLink";

		_methodParameterTypes29 = new String[] { "long" };

		_methodName30 = "getLink";

		_methodParameterTypes30 = new String[] { "long" };

		_methodName31 = "getLinksByAutoGen";

		_methodParameterTypes31 = new String[] { "boolean", "int", "int" };

		_methodName32 = "getLinksByShortLink";

		_methodParameterTypes32 = new String[] { "java.lang.String" };

		_methodName33 = "linkFactory";

		_methodParameterTypes33 = new String[] {  };

		_methodName34 = "updateLink";

		_methodParameterTypes34 = new String[] {
				"com.liferay.linkshortener.model.Link"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName22.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes22, parameterTypes)) {
			return LinkServiceUtil.getBeanIdentifier();
		}

		if (_methodName23.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes23, parameterTypes)) {
			LinkServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName28.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes28, parameterTypes)) {
			return LinkServiceUtil.addLink((com.liferay.linkshortener.model.Link)arguments[0]);
		}

		if (_methodName29.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes29, parameterTypes)) {
			return LinkServiceUtil.deleteLink(((Long)arguments[0]).longValue());
		}

		if (_methodName30.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes30, parameterTypes)) {
			return LinkServiceUtil.getLink(((Long)arguments[0]).longValue());
		}

		if (_methodName31.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes31, parameterTypes)) {
			return LinkServiceUtil.getLinksByAutoGen(((Boolean)arguments[0]).booleanValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName32.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes32, parameterTypes)) {
			return LinkServiceUtil.getLinksByShortLink((java.lang.String)arguments[0]);
		}

		if (_methodName33.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes33, parameterTypes)) {
			return LinkServiceUtil.linkFactory();
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return LinkServiceUtil.updateLink((com.liferay.linkshortener.model.Link)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName22;
	private String[] _methodParameterTypes22;
	private String _methodName23;
	private String[] _methodParameterTypes23;
	private String _methodName28;
	private String[] _methodParameterTypes28;
	private String _methodName29;
	private String[] _methodParameterTypes29;
	private String _methodName30;
	private String[] _methodParameterTypes30;
	private String _methodName31;
	private String[] _methodParameterTypes31;
	private String _methodName32;
	private String[] _methodParameterTypes32;
	private String _methodName33;
	private String[] _methodParameterTypes33;
	private String _methodName34;
	private String[] _methodParameterTypes34;
}