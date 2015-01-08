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

package com.liferay.linkshortener.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LinkService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LinkService
 * @generated
 */
public class LinkServiceWrapper implements LinkService,
	ServiceWrapper<LinkService> {
	public LinkServiceWrapper(LinkService linkService) {
		_linkService = linkService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _linkService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_linkService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _linkService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Method checks if the short link is already used. If the link is not used
	* it adds a new link to database. Also notifies the appropriate model
	* listeners.
	*
	* @param link the link
	* @return the link that was added
	* @throws com.liferay.portal.kernel.exception.SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link addLink(
		com.liferay.linkshortener.model.Link link)
		throws com.liferay.linkshortener.ShortLinkTakenException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linkService.addLink(link);
	}

	/**
	* Deletes the link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkId the primary key of the link
	* @return the link that was removed
	* @throws PortalException if a link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link deleteLink(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linkService.deleteLink(linkId);
	}

	/**
	* Returns the link with the primary key.
	*
	* @param linkId the primary key of the link
	* @return the link
	* @throws PortalException if a link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link getLink(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linkService.getLink(linkId);
	}

	/**
	* Method loads links auto-generated or explicitly created links from
	* database. Method supports paging.
	*
	* @param autoGen specifies what kind of links should be loaded
	* @param start the lower bound of the range of links
	* @param end the upper bound of the range of links (not inclusive)
	* @return the range of matching links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.linkshortener.model.Link> getLinksByAutoGen(
		boolean autoGen, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkService.getLinksByAutoGen(autoGen, start, end);
	}

	/**
	* Method returns the link which short link matches the provided value.
	*
	* @param shortLink the short link
	* @return the matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link
	could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link getLinksByShortLink(
		java.lang.String shortLink)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linkService.getLinksByShortLink(shortLink);
	}

	/**
	* Factory method for a new Link object.
	*
	* @return new object
	*/
	public com.liferay.linkshortener.model.Link linkFactory() {
		return _linkService.linkFactory();
	}

	/**
	* Method checks if the short link is already taken if it was modified. If
	* the link is free it updates the entry. Also notifies the appropriate
	* model listeners.
	*
	* @param link the link
	* @return the link that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link updateLink(
		com.liferay.linkshortener.model.Link link)
		throws com.liferay.linkshortener.ShortLinkTakenException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linkService.updateLink(link);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LinkService getWrappedLinkService() {
		return _linkService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLinkService(LinkService linkService) {
		_linkService = linkService;
	}

	public LinkService getWrappedService() {
		return _linkService;
	}

	public void setWrappedService(LinkService linkService) {
		_linkService = linkService;
	}

	private LinkService _linkService;
}