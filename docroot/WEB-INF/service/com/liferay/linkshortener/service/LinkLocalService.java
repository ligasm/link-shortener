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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the link local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkLocalServiceUtil
 * @see com.liferay.linkshortener.service.base.LinkLocalServiceBaseImpl
 * @see com.liferay.linkshortener.service.impl.LinkLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LinkLocalService extends BaseLocalService, InvokableLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LinkLocalServiceUtil} to access the link local service. Add custom service methods to {@link com.liferay.linkshortener.service.impl.LinkLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the link to the database. Also notifies the appropriate model listeners.
	*
	* @param link the link
	* @return the link that was added
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link addLink(
		com.liferay.linkshortener.model.Link link)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new link with the primary key. Does not add the link to the database.
	*
	* @param linkId the primary key for the new link
	* @return the new link
	*/
	public com.liferay.linkshortener.model.Link createLink(long linkId);

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
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the link from the database. Also notifies the appropriate model listeners.
	*
	* @param link the link
	* @return the link that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link deleteLink(
		com.liferay.linkshortener.model.Link link)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery();

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
		throws com.liferay.portal.kernel.exception.SystemException;

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
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.linkshortener.model.Link fetchLink(long linkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the link with the primary key.
	*
	* @param linkId the primary key of the link
	* @return the link
	* @throws PortalException if a link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.linkshortener.model.Link getLink(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.linkshortener.model.Link> getLinks(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of links.
	*
	* @return the number of links
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLinksCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param link the link
	* @return the link that was updated
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link updateLink(
		com.liferay.linkshortener.model.Link link)
		throws com.liferay.portal.kernel.exception.SystemException;

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
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	/**
	* Method checks if the short link is already used. If the link is used an
	* Exception will be thrown. If the link is unused the original link will be
	* checked if it is already in the database. If the link is found, it will
	* be returned otherwise a new link will be stored to database and all
	* appropriate model listeners will be notified.
	*
	* @param link the link
	* @return the link that was added
	* @throws com.liferay.portal.kernel.exception.SystemException if a system exception occurred
	* @throws com.liferay.linkshortener.ShortLinkTakenException if the short link is already taken
	*/
	public com.liferay.linkshortener.model.Link addLinkWithCheck(
		com.liferay.linkshortener.model.Link link)
		throws com.liferay.linkshortener.ShortLinkTakenException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes all the Links that were not modified after the specified date.
	*
	* @param olderThen boundary date for the deletion.
	*/
	public void deleteOldRecords(java.util.Date olderThen);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.linkshortener.model.Link> getLinksByAutoGen(
		boolean autoGen, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Method returns the link which short link matches the provided value.
	*
	* @param shortLink the short link
	* @return the matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link
	could not be found
	* @throws SystemException if a system exception occurred
	* @throws NoSuchLinkException if the link does not exist.
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.linkshortener.model.Link getLinksByShortLink(
		java.lang.String shortLink)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Factory method for a new Link object.
	*
	* @return new object
	*/
	public com.liferay.linkshortener.model.Link linkFactory();

	/**
	* Method checks if the short link is already taken if it was modified. If
	* the link is free it updates the entry. Also notifies the appropriate
	* model listeners.
	*
	* @param link the link
	* @return the link that was updated
	* @throws SystemException if a system exception occurred
	* @throws ShortLinkTakenException if the link is already taken
	*/
	public com.liferay.linkshortener.model.Link updateLinkWithCheck(
		com.liferay.linkshortener.model.Link link)
		throws com.liferay.linkshortener.ShortLinkTakenException,
			com.liferay.portal.kernel.exception.SystemException;
}