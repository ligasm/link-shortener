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

package com.liferay.linkshortener.service.impl;

import com.liferay.linkshortener.NoSuchLinkException;
import com.liferay.linkshortener.model.Link;
import com.liferay.linkshortener.service.base.LinkLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the link local service. <p/>
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the {@link
 * com.liferay.linkshortener.service.LinkLocalService} interface. <p/> <p> This
 * is a local service. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 * </p>
 *
 * @author Miroslav Ligas
 * @see    com.liferay.linkshortener.service.base.LinkLocalServiceBaseImpl
 * @see    com.liferay.linkshortener.service.LinkLocalServiceUtil
 */
public class LinkLocalServiceImpl extends LinkLocalServiceBaseImpl {

	/**
	 * Adds the link to the database. Also notifies the appropriate model
	 * listeners.
	 *
	 * @param  link the link
	 * @return the link that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Link addLink(Link link) throws SystemException {

		long linkId = counterLocalService.increment(Link.class.getName());
		Date now = new Date();

		Link newLink = linkPersistence.create(linkId);
		newLink.setCreateDate(now);
		newLink.setModifiedDate(now);
		newLink.setAutoGen(link.getAutoGen());
		newLink.setShortLink(link.getShortLink());
		newLink.setLongLink(link.getLongLink());
		newLink.setActive(true);

		return super.addLink(newLink);
	}

	/**
	 * Method loads links auto-generated or explicitly created links from
	 * database. Method supports paging.
	 *
	 * @param  autoGen specifies what kind of links should be loaded
	 * @param  start the lower bound of the range of links
	 * @param  end the upper bound of the range of links (not inclusive)
	 * @return the range of matching links
	 * @throws SystemException if a system exception occurred
	 */
	public List<Link> getLinksByAutoGen(boolean autoGen, int start, int end)
		throws SystemException {

		return linkPersistence.findByAG(autoGen, start, end);
	}

	/**
	 * Method returns the link which short link matches the provided value.
	 *
	 * @param  shortLink the short link
	 * @return the matching link
	 * @throws com.liferay.linkshortener.NoSuchLinkException if a matching link
	 *         could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link getLinksByShortLink(String shortLink)
		throws NoSuchLinkException, SystemException {

		return linkPersistence.findBySL_AG(shortLink, false);
	}

	/**
	 * Factory method for a new Link object.
	 *
	 * @return new object
	 */
	public Link linkFactory() {
		return this.createLink(0);
	}

	/**
	 * Updates the link in the database or adds it if it does not yet exist.
	 * Also notifies the appropriate model listeners.
	 *
	 * @param  link the link
	 * @return the link that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Link updateLink(Link link) throws SystemException {
		Link updatedLink = fetchLink(link.getLinkId());
		updatedLink.setShortLink(link.getShortLink());
		updatedLink.setLongLink(link.getLongLink());
		updatedLink.setActive(link.getActive());
		updatedLink.setModifiedDate(new Date());
		return super.updateLink(updatedLink);
	}

}