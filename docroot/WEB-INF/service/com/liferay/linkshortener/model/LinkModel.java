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

package com.liferay.linkshortener.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Link service. Represents a row in the &quot;LinkShortener_Link&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.linkshortener.model.impl.LinkModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.linkshortener.model.impl.LinkImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Link
 * @see com.liferay.linkshortener.model.impl.LinkImpl
 * @see com.liferay.linkshortener.model.impl.LinkModelImpl
 * @generated
 */
public interface LinkModel extends BaseModel<Link> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a link model instance should use the {@link Link} interface instead.
	 */

	/**
	 * Returns the primary key of this link.
	 *
	 * @return the primary key of this link
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this link.
	 *
	 * @param primaryKey the primary key of this link
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this link.
	 *
	 * @return the uuid of this link
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this link.
	 *
	 * @param uuid the uuid of this link
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the link ID of this link.
	 *
	 * @return the link ID of this link
	 */
	public long getLinkId();

	/**
	 * Sets the link ID of this link.
	 *
	 * @param linkId the link ID of this link
	 */
	public void setLinkId(long linkId);

	/**
	 * Returns the group ID of this link.
	 *
	 * @return the group ID of this link
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this link.
	 *
	 * @param groupId the group ID of this link
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this link.
	 *
	 * @return the company ID of this link
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this link.
	 *
	 * @param companyId the company ID of this link
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this link.
	 *
	 * @return the create date of this link
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this link.
	 *
	 * @param createDate the create date of this link
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this link.
	 *
	 * @return the modified date of this link
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this link.
	 *
	 * @param modifiedDate the modified date of this link
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the long link of this link.
	 *
	 * @return the long link of this link
	 */
	@AutoEscape
	public String getLongLink();

	/**
	 * Sets the long link of this link.
	 *
	 * @param longLink the long link of this link
	 */
	public void setLongLink(String longLink);

	/**
	 * Returns the short link of this link.
	 *
	 * @return the short link of this link
	 */
	@AutoEscape
	public String getShortLink();

	/**
	 * Sets the short link of this link.
	 *
	 * @param shortLink the short link of this link
	 */
	public void setShortLink(String shortLink);

	/**
	 * Returns the active of this link.
	 *
	 * @return the active of this link
	 */
	public boolean getActive();

	/**
	 * Returns <code>true</code> if this link is active.
	 *
	 * @return <code>true</code> if this link is active; <code>false</code> otherwise
	 */
	public boolean isActive();

	/**
	 * Sets whether this link is active.
	 *
	 * @param active the active of this link
	 */
	public void setActive(boolean active);

	/**
	 * Returns the auto gen of this link.
	 *
	 * @return the auto gen of this link
	 */
	public boolean getAutoGen();

	/**
	 * Returns <code>true</code> if this link is auto gen.
	 *
	 * @return <code>true</code> if this link is auto gen; <code>false</code> otherwise
	 */
	public boolean isAutoGen();

	/**
	 * Sets whether this link is auto gen.
	 *
	 * @param autoGen the auto gen of this link
	 */
	public void setAutoGen(boolean autoGen);

	public boolean isNew();

	public void setNew(boolean n);

	public boolean isCachedModel();

	public void setCachedModel(boolean cachedModel);

	public boolean isEscapedModel();

	public Serializable getPrimaryKeyObj();

	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	public ExpandoBridge getExpandoBridge();

	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	public Object clone();

	public int compareTo(Link link);

	public int hashCode();

	public CacheModel<Link> toCacheModel();

	public Link toEscapedModel();

	public Link toUnescapedModel();

	public String toString();

	public String toXmlString();
}