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
 * This class is a wrapper for {@link LinkLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LinkLocalService
 * @generated
 */
public class LinkLocalServiceWrapper implements LinkLocalService,
	ServiceWrapper<LinkLocalService> {
	public LinkLocalServiceWrapper(LinkLocalService linkLocalService) {
		_linkLocalService = linkLocalService;
	}

	/**
	* Adds the link to the database. Also notifies the appropriate model listeners.
	*
	* @param link the link
	* @return the link that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link addLink(
		com.liferay.linkshortener.model.Link link)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkLocalService.addLink(link);
	}

	/**
	* Creates a new link with the primary key. Does not add the link to the database.
	*
	* @param linkId the primary key for the new link
	* @return the new link
	*/
	public com.liferay.linkshortener.model.Link createLink(long linkId) {
		return _linkLocalService.createLink(linkId);
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
		return _linkLocalService.deleteLink(linkId);
	}

	/**
	* Deletes the link from the database. Also notifies the appropriate model listeners.
	*
	* @param link the link
	* @return the link that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link deleteLink(
		com.liferay.linkshortener.model.Link link)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkLocalService.deleteLink(link);
	}

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _linkLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _linkLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkLocalService.dynamicQueryCount(dynamicQuery);
	}

	public com.liferay.linkshortener.model.Link fetchLink(long linkId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkLocalService.fetchLink(linkId);
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
		return _linkLocalService.getLink(linkId);
	}

	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of links
	* @param end the upper bound of the range of links (not inclusive)
	* @return the range of links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.linkshortener.model.Link> getLinks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkLocalService.getLinks(start, end);
	}

	/**
	* Returns the number of links.
	*
	* @return the number of links
	* @throws SystemException if a system exception occurred
	*/
	public int getLinksCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkLocalService.getLinksCount();
	}

	/**
	* Updates the link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param link the link
	* @return the link that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link updateLink(
		com.liferay.linkshortener.model.Link link)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkLocalService.updateLink(link);
	}

	/**
	* Updates the link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param link the link
	* @param merge whether to merge the link with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the link that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link updateLink(
		com.liferay.linkshortener.model.Link link, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _linkLocalService.updateLink(link, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier() {
		return _linkLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_linkLocalService.setBeanIdentifier(beanIdentifier);
	}

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _linkLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Adds the link to the database. Also notifies the appropriate model
	* listeners.
	*
	* @param link the link
	* @return the link that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link addLinkWithCheck(
		com.liferay.linkshortener.model.Link link)
		throws com.liferay.linkshortener.ShortLinkTakenException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linkLocalService.addLinkWithCheck(link);
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
		return _linkLocalService.getLinksByAutoGen(autoGen, start, end);
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
		return _linkLocalService.getLinksByShortLink(shortLink);
	}

	/**
	* Factory method for a new Link object.
	*
	* @return new object
	*/
	public com.liferay.linkshortener.model.Link linkFactory() {
		return _linkLocalService.linkFactory();
	}

	/**
	* Updates the link in the database or adds it if it does not yet exist.
	* Also notifies the appropriate model listeners.
	*
	* @param link the link
	* @return the link that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link updateLinkWithCheck(
		com.liferay.linkshortener.model.Link link)
		throws com.liferay.linkshortener.ShortLinkTakenException,
			com.liferay.portal.kernel.exception.SystemException {
		return _linkLocalService.updateLinkWithCheck(link);
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedService}
	 */
	public LinkLocalService getWrappedLinkLocalService() {
		return _linkLocalService;
	}

	/**
	 * @deprecated Renamed to {@link #setWrappedService}
	 */
	public void setWrappedLinkLocalService(LinkLocalService linkLocalService) {
		_linkLocalService = linkLocalService;
	}

	public LinkLocalService getWrappedService() {
		return _linkLocalService;
	}

	public void setWrappedService(LinkLocalService linkLocalService) {
		_linkLocalService = linkLocalService;
	}

	private LinkLocalService _linkLocalService;
}