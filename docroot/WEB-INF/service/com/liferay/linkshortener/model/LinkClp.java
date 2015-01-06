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

import com.liferay.linkshortener.service.ClpSerializer;
import com.liferay.linkshortener.service.LinkLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Brian Wing Shun Chan
 */
public class LinkClp extends BaseModelImpl<Link> implements Link {
	public LinkClp() {
	}

	public Class<?> getModelClass() {
		return Link.class;
	}

	public String getModelClassName() {
		return Link.class.getName();
	}

	public long getPrimaryKey() {
		return _linkId;
	}

	public void setPrimaryKey(long primaryKey) {
		setLinkId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_linkId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
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

	@Override
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

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_linkRemoteModel != null) {
			try {
				Class<?> clazz = _linkRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_linkRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public long getLinkId() {
		return _linkId;
	}

	public void setLinkId(long linkId) {
		_linkId = linkId;

		if (_linkRemoteModel != null) {
			try {
				Class<?> clazz = _linkRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkId", long.class);

				method.invoke(_linkRemoteModel, linkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_linkRemoteModel != null) {
			try {
				Class<?> clazz = _linkRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_linkRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_linkRemoteModel != null) {
			try {
				Class<?> clazz = _linkRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_linkRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getLongLink() {
		return _longLink;
	}

	public void setLongLink(String longLink) {
		_longLink = longLink;

		if (_linkRemoteModel != null) {
			try {
				Class<?> clazz = _linkRemoteModel.getClass();

				Method method = clazz.getMethod("setLongLink", String.class);

				method.invoke(_linkRemoteModel, longLink);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public String getShortLink() {
		return _shortLink;
	}

	public void setShortLink(String shortLink) {
		_shortLink = shortLink;

		if (_linkRemoteModel != null) {
			try {
				Class<?> clazz = _linkRemoteModel.getClass();

				Method method = clazz.getMethod("setShortLink", String.class);

				method.invoke(_linkRemoteModel, shortLink);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;

		if (_linkRemoteModel != null) {
			try {
				Class<?> clazz = _linkRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_linkRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public boolean getAutoGen() {
		return _autoGen;
	}

	public boolean isAutoGen() {
		return _autoGen;
	}

	public void setAutoGen(boolean autoGen) {
		_autoGen = autoGen;

		if (_linkRemoteModel != null) {
			try {
				Class<?> clazz = _linkRemoteModel.getClass();

				Method method = clazz.getMethod("setAutoGen", boolean.class);

				method.invoke(_linkRemoteModel, autoGen);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLinkRemoteModel() {
		return _linkRemoteModel;
	}

	public void setLinkRemoteModel(BaseModel<?> linkRemoteModel) {
		_linkRemoteModel = linkRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _linkRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_linkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LinkLocalServiceUtil.addLink(this);
		}
		else {
			LinkLocalServiceUtil.updateLink(this);
		}
	}

	@Override
	public Link toEscapedModel() {
		return (Link)ProxyUtil.newProxyInstance(Link.class.getClassLoader(),
			new Class[] { Link.class }, new AutoEscapeBeanHandler(this));
	}

	public Link toUnescapedModel() {
		return this;
	}

	@Override
	public Object clone() {
		LinkClp clone = new LinkClp();

		clone.setUuid(getUuid());
		clone.setLinkId(getLinkId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setLongLink(getLongLink());
		clone.setShortLink(getShortLink());
		clone.setActive(getActive());
		clone.setAutoGen(getAutoGen());

		return clone;
	}

	public int compareTo(Link link) {
		long primaryKey = link.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LinkClp)) {
			return false;
		}

		LinkClp link = (LinkClp)obj;

		long primaryKey = link.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", linkId=");
		sb.append(getLinkId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", longLink=");
		sb.append(getLongLink());
		sb.append(", shortLink=");
		sb.append(getShortLink());
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", autoGen=");
		sb.append(getAutoGen());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.linkshortener.model.Link");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkId</column-name><column-value><![CDATA[");
		sb.append(getLinkId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>longLink</column-name><column-value><![CDATA[");
		sb.append(getLongLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortLink</column-name><column-value><![CDATA[");
		sb.append(getShortLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>autoGen</column-name><column-value><![CDATA[");
		sb.append(getAutoGen());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _linkId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _longLink;
	private String _shortLink;
	private boolean _active;
	private boolean _autoGen;
	private BaseModel<?> _linkRemoteModel;
}