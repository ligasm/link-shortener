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

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkPersistenceImpl
 * @see LinkUtil
 * @generated
 */
public interface LinkPersistence extends BasePersistence<Link> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LinkUtil} to access the link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the link in the entity cache if it is enabled.
	*
	* @param link the link
	*/
	public void cacheResult(com.liferay.linkshortener.model.Link link);

	/**
	* Caches the links in the entity cache if it is enabled.
	*
	* @param links the links
	*/
	public void cacheResult(
		java.util.List<com.liferay.linkshortener.model.Link> links);

	/**
	* Creates a new link with the primary key. Does not add the link to the database.
	*
	* @param linkId the primary key for the new link
	* @return the new link
	*/
	public com.liferay.linkshortener.model.Link create(long linkId);

	/**
	* Removes the link with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param linkId the primary key of the link
	* @return the link that was removed
	* @throws com.liferay.linkshortener.NoSuchLinkException if a link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link remove(long linkId)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.linkshortener.model.Link updateImpl(
		com.liferay.linkshortener.model.Link link, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the link with the primary key or throws a {@link com.liferay.linkshortener.NoSuchLinkException} if it could not be found.
	*
	* @param linkId the primary key of the link
	* @return the link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link findByPrimaryKey(long linkId)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the link with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param linkId the primary key of the link
	* @return the link, or <code>null</code> if a link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link fetchByPrimaryKey(long linkId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.linkshortener.model.Link> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.linkshortener.model.Link> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.linkshortener.model.Link> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last link in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.linkshortener.model.Link[] findByUuid_PrevAndNext(
		long linkId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the link where shortLink = &#63; and autoGen = &#63; or throws a {@link com.liferay.linkshortener.NoSuchLinkException} if it could not be found.
	*
	* @param shortLink the short link
	* @param autoGen the auto gen
	* @return the matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link findBySL_AG(
		java.lang.String shortLink, boolean autoGen)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the link where shortLink = &#63; and autoGen = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param shortLink the short link
	* @param autoGen the auto gen
	* @return the matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link fetchBySL_AG(
		java.lang.String shortLink, boolean autoGen)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the link where shortLink = &#63; and autoGen = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param shortLink the short link
	* @param autoGen the auto gen
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link fetchBySL_AG(
		java.lang.String shortLink, boolean autoGen, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the links where autoGen = &#63;.
	*
	* @param autoGen the auto gen
	* @return the matching links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.linkshortener.model.Link> findByAG(
		boolean autoGen)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.linkshortener.model.Link> findByAG(
		boolean autoGen, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.linkshortener.model.Link> findByAG(
		boolean autoGen, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first link in the ordered set where autoGen = &#63;.
	*
	* @param autoGen the auto gen
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link findByAG_First(
		boolean autoGen,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first link in the ordered set where autoGen = &#63;.
	*
	* @param autoGen the auto gen
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link fetchByAG_First(
		boolean autoGen,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last link in the ordered set where autoGen = &#63;.
	*
	* @param autoGen the auto gen
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link findByAG_Last(boolean autoGen,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last link in the ordered set where autoGen = &#63;.
	*
	* @param autoGen the auto gen
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link fetchByAG_Last(
		boolean autoGen,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.linkshortener.model.Link[] findByAG_PrevAndNext(
		long linkId, boolean autoGen,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the links where shortLink = &#63;.
	*
	* @param shortLink the short link
	* @return the matching links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.linkshortener.model.Link> findBySL(
		java.lang.String shortLink)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the links where shortLink = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param shortLink the short link
	* @param start the lower bound of the range of links
	* @param end the upper bound of the range of links (not inclusive)
	* @return the range of matching links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.linkshortener.model.Link> findBySL(
		java.lang.String shortLink, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the links where shortLink = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param shortLink the short link
	* @param start the lower bound of the range of links
	* @param end the upper bound of the range of links (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.linkshortener.model.Link> findBySL(
		java.lang.String shortLink, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first link in the ordered set where shortLink = &#63;.
	*
	* @param shortLink the short link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link findBySL_First(
		java.lang.String shortLink,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first link in the ordered set where shortLink = &#63;.
	*
	* @param shortLink the short link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link fetchBySL_First(
		java.lang.String shortLink,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last link in the ordered set where shortLink = &#63;.
	*
	* @param shortLink the short link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link findBySL_Last(
		java.lang.String shortLink,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last link in the ordered set where shortLink = &#63;.
	*
	* @param shortLink the short link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching link, or <code>null</code> if a matching link could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link fetchBySL_Last(
		java.lang.String shortLink,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the links before and after the current link in the ordered set where shortLink = &#63;.
	*
	* @param linkId the primary key of the current link
	* @param shortLink the short link
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link[] findBySL_PrevAndNext(
		long linkId, java.lang.String shortLink,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the links.
	*
	* @return the links
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.linkshortener.model.Link> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.linkshortener.model.Link> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.linkshortener.model.Link> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the links where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the link where shortLink = &#63; and autoGen = &#63; from the database.
	*
	* @param shortLink the short link
	* @param autoGen the auto gen
	* @return the link that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.linkshortener.model.Link removeBySL_AG(
		java.lang.String shortLink, boolean autoGen)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the links where autoGen = &#63; from the database.
	*
	* @param autoGen the auto gen
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAG(boolean autoGen)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the links where shortLink = &#63; from the database.
	*
	* @param shortLink the short link
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySL(java.lang.String shortLink)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the links from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of links where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching links
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of links where shortLink = &#63; and autoGen = &#63;.
	*
	* @param shortLink the short link
	* @param autoGen the auto gen
	* @return the number of matching links
	* @throws SystemException if a system exception occurred
	*/
	public int countBySL_AG(java.lang.String shortLink, boolean autoGen)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of links where autoGen = &#63;.
	*
	* @param autoGen the auto gen
	* @return the number of matching links
	* @throws SystemException if a system exception occurred
	*/
	public int countByAG(boolean autoGen)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of links where shortLink = &#63;.
	*
	* @param shortLink the short link
	* @return the number of matching links
	* @throws SystemException if a system exception occurred
	*/
	public int countBySL(java.lang.String shortLink)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of links.
	*
	* @return the number of links
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}