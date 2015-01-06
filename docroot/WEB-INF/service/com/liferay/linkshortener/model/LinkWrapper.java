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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Link}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Link
 * @generated
 */
public class LinkWrapper implements Link, ModelWrapper<Link> {
	public LinkWrapper(Link link) {
		_link = link;
	}

	public Class<?> getModelClass() {
		return Link.class;
	}

	public String getModelClassName() {
		return Link.class.getName();
	}

	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("linkId", getLinkId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("longLink", getLongLink());
		attributes.put("shortLink", getShortLink());
		attributes.put("active", getActive());
		attributes.put("autoGen", getAutoGen());

		return attributes;
	}

	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long linkId = (Long)attributes.get("linkId");

		if (linkId != null) {
			setLinkId(linkId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String longLink = (String)attributes.get("longLink");

		if (longLink != null) {
			setLongLink(longLink);
		}

		String shortLink = (String)attributes.get("shortLink");

		if (shortLink != null) {
			setShortLink(shortLink);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Boolean autoGen = (Boolean)attributes.get("autoGen");

		if (autoGen != null) {
			setAutoGen(autoGen);
		}
	}

	/**
	* Returns the primary key of this link.
	*
	* @return the primary key of this link
	*/
	public long getPrimaryKey() {
		return _link.getPrimaryKey();
	}

	/**
	* Sets the primary key of this link.
	*
	* @param primaryKey the primary key of this link
	*/
	public void setPrimaryKey(long primaryKey) {
		_link.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this link.
	*
	* @return the uuid of this link
	*/
	public java.lang.String getUuid() {
		return _link.getUuid();
	}

	/**
	* Sets the uuid of this link.
	*
	* @param uuid the uuid of this link
	*/
	public void setUuid(java.lang.String uuid) {
		_link.setUuid(uuid);
	}

	/**
	* Returns the link ID of this link.
	*
	* @return the link ID of this link
	*/
	public long getLinkId() {
		return _link.getLinkId();
	}

	/**
	* Sets the link ID of this link.
	*
	* @param linkId the link ID of this link
	*/
	public void setLinkId(long linkId) {
		_link.setLinkId(linkId);
	}

	/**
	* Returns the create date of this link.
	*
	* @return the create date of this link
	*/
	public java.util.Date getCreateDate() {
		return _link.getCreateDate();
	}

	/**
	* Sets the create date of this link.
	*
	* @param createDate the create date of this link
	*/
	public void setCreateDate(java.util.Date createDate) {
		_link.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this link.
	*
	* @return the modified date of this link
	*/
	public java.util.Date getModifiedDate() {
		return _link.getModifiedDate();
	}

	/**
	* Sets the modified date of this link.
	*
	* @param modifiedDate the modified date of this link
	*/
	public void setModifiedDate(java.util.Date modifiedDate) {
		_link.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the long link of this link.
	*
	* @return the long link of this link
	*/
	public java.lang.String getLongLink() {
		return _link.getLongLink();
	}

	/**
	* Sets the long link of this link.
	*
	* @param longLink the long link of this link
	*/
	public void setLongLink(java.lang.String longLink) {
		_link.setLongLink(longLink);
	}

	/**
	* Returns the short link of this link.
	*
	* @return the short link of this link
	*/
	public java.lang.String getShortLink() {
		return _link.getShortLink();
	}

	/**
	* Sets the short link of this link.
	*
	* @param shortLink the short link of this link
	*/
	public void setShortLink(java.lang.String shortLink) {
		_link.setShortLink(shortLink);
	}

	/**
	* Returns the active of this link.
	*
	* @return the active of this link
	*/
	public boolean getActive() {
		return _link.getActive();
	}

	/**
	* Returns <code>true</code> if this link is active.
	*
	* @return <code>true</code> if this link is active; <code>false</code> otherwise
	*/
	public boolean isActive() {
		return _link.isActive();
	}

	/**
	* Sets whether this link is active.
	*
	* @param active the active of this link
	*/
	public void setActive(boolean active) {
		_link.setActive(active);
	}

	/**
	* Returns the auto gen of this link.
	*
	* @return the auto gen of this link
	*/
	public boolean getAutoGen() {
		return _link.getAutoGen();
	}

	/**
	* Returns <code>true</code> if this link is auto gen.
	*
	* @return <code>true</code> if this link is auto gen; <code>false</code> otherwise
	*/
	public boolean isAutoGen() {
		return _link.isAutoGen();
	}

	/**
	* Sets whether this link is auto gen.
	*
	* @param autoGen the auto gen of this link
	*/
	public void setAutoGen(boolean autoGen) {
		_link.setAutoGen(autoGen);
	}

	public boolean isNew() {
		return _link.isNew();
	}

	public void setNew(boolean n) {
		_link.setNew(n);
	}

	public boolean isCachedModel() {
		return _link.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_link.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _link.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _link.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_link.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _link.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_link.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LinkWrapper((Link)_link.clone());
	}

	public int compareTo(Link link) {
		return _link.compareTo(link);
	}

	@Override
	public int hashCode() {
		return _link.hashCode();
	}

	public com.liferay.portal.model.CacheModel<Link> toCacheModel() {
		return _link.toCacheModel();
	}

	public Link toEscapedModel() {
		return new LinkWrapper(_link.toEscapedModel());
	}

	public Link toUnescapedModel() {
		return new LinkWrapper(_link.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _link.toString();
	}

	public java.lang.String toXmlString() {
		return _link.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_link.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LinkWrapper)) {
			return false;
		}

		LinkWrapper linkWrapper = (LinkWrapper)obj;

		if (Validator.equals(_link, linkWrapper._link)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public Link getWrappedLink() {
		return _link;
	}

	public Link getWrappedModel() {
		return _link;
	}

	public void resetOriginalValues() {
		_link.resetOriginalValues();
	}

	private Link _link;
}