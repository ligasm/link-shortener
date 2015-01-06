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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.linkshortener.service.http.LinkServiceSoap}.
 *
 * @author    Brian Wing Shun Chan
 * @see       com.liferay.linkshortener.service.http.LinkServiceSoap
 * @generated
 */
public class LinkSoap implements Serializable {
	public static LinkSoap toSoapModel(Link model) {
		LinkSoap soapModel = new LinkSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setLinkId(model.getLinkId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLongLink(model.getLongLink());
		soapModel.setShortLink(model.getShortLink());
		soapModel.setActive(model.getActive());
		soapModel.setAutoGen(model.getAutoGen());

		return soapModel;
	}

	public static LinkSoap[] toSoapModels(Link[] models) {
		LinkSoap[] soapModels = new LinkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LinkSoap[][] toSoapModels(Link[][] models) {
		LinkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LinkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LinkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LinkSoap[] toSoapModels(List<Link> models) {
		List<LinkSoap> soapModels = new ArrayList<LinkSoap>(models.size());

		for (Link model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LinkSoap[soapModels.size()]);
	}

	public LinkSoap() {
	}

	public long getPrimaryKey() {
		return _linkId;
	}

	public void setPrimaryKey(long pk) {
		setLinkId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getLinkId() {
		return _linkId;
	}

	public void setLinkId(long linkId) {
		_linkId = linkId;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getLongLink() {
		return _longLink;
	}

	public void setLongLink(String longLink) {
		_longLink = longLink;
	}

	public String getShortLink() {
		return _shortLink;
	}

	public void setShortLink(String shortLink) {
		_shortLink = shortLink;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public boolean getAutoGen() {
		return _autoGen;
	}

	public boolean isAutoGen() {
		return _autoGen;
	}

	public void setAutoGen(boolean autoGen) {
		_autoGen = autoGen;
	}

	private String _uuid;
	private long _linkId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _longLink;
	private String _shortLink;
	private boolean _active;
	private boolean _autoGen;
}