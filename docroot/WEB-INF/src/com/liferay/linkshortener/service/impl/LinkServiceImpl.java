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
import com.liferay.linkshortener.ShortLinkTakenException;
import com.liferay.linkshortener.model.Link;
import com.liferay.linkshortener.service.base.LinkServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the link remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the {@link
 * com.liferay.linkshortener.service.LinkService} interface.  <p> This is a
 * remote service. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be accessed
 * remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    com.liferay.linkshortener.service.base.LinkServiceBaseImpl
 * @see    com.liferay.linkshortener.service.LinkServiceUtil
 */
public class LinkServiceImpl extends LinkServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.linkshortener.service.LinkServiceUtil} to access the link remote service.
	 */

	/**
	 * Method checks if the short link is already used. If the link is used an
	 * Exception will be thrown. If the link is unused the original link will be
	 * checked if it is already in the database. If the link is found, it will
	 * be returned otherwise a new link will be stored to database and all
	 * appropriate model listeners will be notified.
	 *
	 * @param  link the link
	 * @return the link that was added
	 * @throws com.liferay.linkshortener.ShortLinkTakenException if the short
	 *         link is already taken
	 */
	@Override
	public Link addLink(Link link)
		throws ShortLinkTakenException, SystemException {

		return linkLocalService.addLinkWithCheck(link);
	}

	/**
	 * Deletes the link with the primary key from the database. Also notifies
	 * the appropriate model listeners.
	 *
	 * @param  linkId the primary key of the link
	 * @return the link that was removed
	 * @throws PortalException if a link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Link deleteLink(long linkId)
		throws PortalException, SystemException {

		return linkLocalService.deleteLink(linkId);
	}

	/**
	 * Returns the link with the primary key.
	 *
	 * @param  linkId the primary key of the link
	 * @return the link
	 * @throws PortalException if a link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Link getLink(long linkId) throws PortalException, SystemException {
		return linkLocalService.getLink(linkId);
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
	@Override
	public List<Link> getLinksByAutoGen(boolean autoGen, int start, int end)
		throws SystemException {

		return linkLocalService.getLinksByAutoGen(autoGen, start, end);
	}

	/**
	 * Method returns the link which short link matches the provided value.
	 *
	 * @param  shortLink the short link
	 * @return the matching link
	 * @throws com.liferay.linkshortener.NoSuchLinkException if a matching link
	 *         could not be found
	 * @throws SystemException if a system exception occurred.
	 */
	@Override
	public Link getLinksByShortLink(String shortLink)
		throws NoSuchLinkException, SystemException {

		return linkLocalService.getLinksByShortLink(shortLink);
	}

	/**
	 * Factory method for a new Link object.
	 *
	 * @return new object
	 */
	@Override
	public Link linkFactory() {
		return linkLocalService.linkFactory();
	}

	/**
	 * Method checks if the short link is already taken if it was modified. If
	 * the link is free it updates the entry. Also notifies the appropriate
	 * model listeners.
	 *
	 * @param  link the link
	 * @return the link that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Link updateLink(Link link)
		throws ShortLinkTakenException, SystemException {

		return linkLocalService.updateLinkWithCheck(link);
	}

}