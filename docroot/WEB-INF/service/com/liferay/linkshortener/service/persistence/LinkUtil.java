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

package com.liferay.linkshortener.service.persistence;

import com.liferay.linkshortener.model.Link;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import java.util.List;

/**
 * The persistence utility for the link service. This utility wraps {@link LinkPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkPersistence
 * @see LinkPersistenceImpl
 * @generated
 */
public class LinkUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Link link) {
		getPersistence().clearCache(link);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Link> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Link> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Link> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static Link update(Link link, boolean merge)
		throws SystemException {
		return getPersistence().update(link, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static Link update(Link link, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(link, merge, serviceContext);
	}

	/**
	* Caches the link in the entity cache if it is enabled.
	*
	* @param link the link
	*/
	public static void cacheResult(com.liferay.linkshortener.model.Link link) {
		getPersistence().cacheResult(link);
	}

	/**
	* Caches the links in the entity cache if it is enabled.
	*
	* @param links the links
	*/
	public static void cacheResult(
		java.util.List<com.liferay.linkshortener.model.Link> links) {
		getPersistence().cacheResult(links);
	}

	/**
	* Creates a new link with the primary key. Does not add the link to the database.
	*
	* @param linkId the primary key for the new link
	* @return the new link
	*/
	public static com.liferay.linkshortener.model.Link create(long linkId) {
		return getPersistence().create(linkId);
	}

	/**
	* Removes the link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkId the primary key of the link
	* @return the link that was removed
	* @throws com.liferay.linkshortener.NoSuchLinkException if a link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link remove(long linkId)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().remove(linkId);
	}

	public static com.liferay.linkshortener.model.Link updateImpl(
		com.liferay.linkshortener.model.Link link, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(link, merge);
	}

	/**
	* Returns the link with the primary key or throws a {@link com.liferay.linkshortener.NoSuchLinkException} if it could not be found.
	*
	* @param linkId the primary key of the link
	* @return the link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link findByPrimaryKey(
		long linkId)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByPrimaryKey(linkId);
	}

	/**
	* Returns the link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param linkId the primary key of the link
	* @return the link, or <code>null</code> if a link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link fetchByPrimaryKey(
		long linkId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(linkId);
	}

	/**
	* Returns all the links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.linkshortener.model.Link> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the links where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of links
	* @param end the upper bound of the range of links (not inclusive)
	* @return the range of matching links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.linkshortener.model.Link> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the links where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of links
	* @param end the upper bound of the range of links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.linkshortener.model.Link> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the links before and after the current link in the ordered set where uuid = &#63;.
	*
	* @param linkId the primary key of the current link
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link[] findByUuid_PrevAndNext(
		long linkId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_PrevAndNext(linkId, uuid, orderByComparator);
	}

	/**
	* Returns the link where uuid = &#63; and groupId = &#63; or throws a {@link com.liferay.linkshortener.NoSuchLinkException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the link where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Returns the link where shortLink = &#63; and autoGen = &#63; or throws a {@link com.liferay.linkshortener.NoSuchLinkException} if it could not be found.
	*
	* @param shortLink the short link
	* @param autoGen the auto gen
	* @return the matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link findBySL_AG(
		java.lang.String shortLink, boolean autoGen)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBySL_AG(shortLink, autoGen);
	}

	/**
	* Returns the link where shortLink = &#63; and autoGen = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param shortLink the short link
	* @param autoGen the auto gen
	* @return the matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link fetchBySL_AG(
		java.lang.String shortLink, boolean autoGen)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchBySL_AG(shortLink, autoGen);
	}

	/**
	* Returns the link where shortLink = &#63; and autoGen = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param shortLink the short link
	* @param autoGen the auto gen
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link fetchBySL_AG(
		java.lang.String shortLink, boolean autoGen, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchBySL_AG(shortLink, autoGen, retrieveFromCache);
	}

	/**
	* Returns all the links where autoGen = &#63;.
	*
	* @param autoGen the auto gen
	* @return the matching links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.linkshortener.model.Link> findByAG(
		boolean autoGen)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAG(autoGen);
	}

	/**
	* Returns a range of all the links where autoGen = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param autoGen the auto gen
	* @param start the lower bound of the range of links
	* @param end the upper bound of the range of links (not inclusive)
	* @return the range of matching links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.linkshortener.model.Link> findByAG(
		boolean autoGen, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAG(autoGen, start, end);
	}

	/**
	* Returns an ordered range of all the links where autoGen = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param autoGen the auto gen
	* @param start the lower bound of the range of links
	* @param end the upper bound of the range of links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.linkshortener.model.Link> findByAG(
		boolean autoGen, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAG(autoGen, start, end, orderByComparator);
	}

	/**
	* Returns the first link in the ordered set where autoGen = &#63;.
	*
	* @param autoGen the auto gen
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link findByAG_First(
		boolean autoGen,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAG_First(autoGen, orderByComparator);
	}

	/**
	* Returns the first link in the ordered set where autoGen = &#63;.
	*
	* @param autoGen the auto gen
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link fetchByAG_First(
		boolean autoGen,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAG_First(autoGen, orderByComparator);
	}

	/**
	* Returns the last link in the ordered set where autoGen = &#63;.
	*
	* @param autoGen the auto gen
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link findByAG_Last(
		boolean autoGen,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAG_Last(autoGen, orderByComparator);
	}

	/**
	* Returns the last link in the ordered set where autoGen = &#63;.
	*
	* @param autoGen the auto gen
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link fetchByAG_Last(
		boolean autoGen,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByAG_Last(autoGen, orderByComparator);
	}

	/**
	* Returns the links before and after the current link in the ordered set where autoGen = &#63;.
	*
	* @param linkId the primary key of the current link
	* @param autoGen the auto gen
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link[] findByAG_PrevAndNext(
		long linkId, boolean autoGen,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAG_PrevAndNext(linkId, autoGen, orderByComparator);
	}

	/**
	* Returns all the links.
	*
	* @return the links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.linkshortener.model.Link> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.linkshortener.model.Link> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the links.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of links
	* @param end the upper bound of the range of links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of links
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.linkshortener.model.Link> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the links where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes the link where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the link that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Removes the link where shortLink = &#63; and autoGen = &#63; from the database.
	*
	* @param shortLink the short link
	* @param autoGen the auto gen
	* @return the link that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link removeBySL_AG(
		java.lang.String shortLink, boolean autoGen)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().removeBySL_AG(shortLink, autoGen);
	}

	/**
	* Removes all the links where autoGen = &#63; from the database.
	*
	* @param autoGen the auto gen
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAG(boolean autoGen)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAG(autoGen);
	}

	/**
	* Removes all the links from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the number of links where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of links where shortLink = &#63; and autoGen = &#63;.
	*
	* @param shortLink the short link
	* @param autoGen the auto gen
	* @return the number of matching links
	* @throws SystemException if a system exception occurred
	*/
	public static int countBySL_AG(java.lang.String shortLink, boolean autoGen)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBySL_AG(shortLink, autoGen);
	}

	/**
	* Returns the number of links where autoGen = &#63;.
	*
	* @param autoGen the auto gen
	* @return the number of matching links
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAG(boolean autoGen)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAG(autoGen);
	}

	/**
	* Returns the number of links.
	*
	* @return the number of links
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LinkPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LinkPersistence)PortletBeanLocatorUtil.locate(com.liferay.linkshortener.service.ClpSerializer.getServletContextName(),
					LinkPersistence.class.getName());

			ReferenceRegistry.registerReference(LinkUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated
	 */
	public void setPersistence(LinkPersistence persistence) {
	}

	private static LinkPersistence _persistence;
}