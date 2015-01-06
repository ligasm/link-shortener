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

package com.liferay.linkshortener.model.impl;

import com.liferay.linkshortener.model.Link;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Link in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Link
 * @generated
 */
public class LinkCacheModel implements CacheModel<Link>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", linkId=");
		sb.append(linkId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", longLink=");
		sb.append(longLink);
		sb.append(", shortLink=");
		sb.append(shortLink);
		sb.append(", active=");
		sb.append(active);
		sb.append(", autoGen=");
		sb.append(autoGen);
		sb.append("}");

		return sb.toString();
	}

	public Link toEntityModel() {
		LinkImpl linkImpl = new LinkImpl();

		if (uuid == null) {
			linkImpl.setUuid(StringPool.BLANK);
		}
		else {
			linkImpl.setUuid(uuid);
		}

		linkImpl.setLinkId(linkId);

		if (createDate == Long.MIN_VALUE) {
			linkImpl.setCreateDate(null);
		}
		else {
			linkImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			linkImpl.setModifiedDate(null);
		}
		else {
			linkImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (longLink == null) {
			linkImpl.setLongLink(StringPool.BLANK);
		}
		else {
			linkImpl.setLongLink(longLink);
		}

		if (shortLink == null) {
			linkImpl.setShortLink(StringPool.BLANK);
		}
		else {
			linkImpl.setShortLink(shortLink);
		}

		linkImpl.setActive(active);
		linkImpl.setAutoGen(autoGen);

		linkImpl.resetOriginalValues();

		return linkImpl;
	}

	public String uuid;
	public long linkId;
	public long createDate;
	public long modifiedDate;
	public String longLink;
	public String shortLink;
	public boolean active;
	public boolean autoGen;
}