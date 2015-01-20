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

import com.liferay.linkshortener.NoSuchLinkException;
import com.liferay.linkshortener.model.Link;
import com.liferay.linkshortener.model.impl.LinkImpl;
import com.liferay.linkshortener.model.impl.LinkModelImpl;

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkPersistence
 * @see LinkUtil
 * @generated
 */
public class LinkPersistenceImpl extends BasePersistenceImpl<Link>
	implements LinkPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LinkUtil} to access the link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LinkImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			LinkModelImpl.UUID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_SL_AG = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBySL_AG",
			new String[] { String.class.getName(), Boolean.class.getName() },
			LinkModelImpl.SHORTLINK_COLUMN_BITMASK |
			LinkModelImpl.AUTOGEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SL_AG = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySL_AG",
			new String[] { String.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LL_AG = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLL_AG",
			new String[] {
				String.class.getName(), Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LL_AG = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLL_AG",
			new String[] { String.class.getName(), Boolean.class.getName() },
			LinkModelImpl.SHORTLINK_COLUMN_BITMASK |
			LinkModelImpl.AUTOGEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LL_AG = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLL_AG",
			new String[] { String.class.getName(), Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_AG = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByAG",
			new String[] {
				Boolean.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AG = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByAG",
			new String[] { Boolean.class.getName() },
			LinkModelImpl.AUTOGEN_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_AG = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByAG",
			new String[] { Boolean.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SL = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySL",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SL = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySL",
			new String[] { String.class.getName() },
			LinkModelImpl.SHORTLINK_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SL = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySL",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, LinkImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the link in the entity cache if it is enabled.
	 *
	 * @param link the link
	 */
	public void cacheResult(Link link) {
		EntityCacheUtil.putResult(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkImpl.class, link.getPrimaryKey(), link);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SL_AG,
			new Object[] { link.getShortLink(), Boolean.valueOf(
					link.getAutoGen()) }, link);

		link.resetOriginalValues();
	}

	/**
	 * Caches the links in the entity cache if it is enabled.
	 *
	 * @param links the links
	 */
	public void cacheResult(List<Link> links) {
		for (Link link : links) {
			if (EntityCacheUtil.getResult(LinkModelImpl.ENTITY_CACHE_ENABLED,
						LinkImpl.class, link.getPrimaryKey()) == null) {
				cacheResult(link);
			}
			else {
				link.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all links.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(LinkImpl.class.getName());
		}

		EntityCacheUtil.clearCache(LinkImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the link.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Link link) {
		EntityCacheUtil.removeResult(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkImpl.class, link.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(link);
	}

	@Override
	public void clearCache(List<Link> links) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Link link : links) {
			EntityCacheUtil.removeResult(LinkModelImpl.ENTITY_CACHE_ENABLED,
				LinkImpl.class, link.getPrimaryKey());

			clearUniqueFindersCache(link);
		}
	}

	protected void cacheUniqueFindersCache(Link link) {
		if (link.isNew()) {
			Object[] args = new Object[] {
					link.getShortLink(), Boolean.valueOf(link.getAutoGen())
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SL_AG, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SL_AG, args, link);
		}
		else {
			LinkModelImpl linkModelImpl = (LinkModelImpl)link;

			if ((linkModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_SL_AG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						link.getShortLink(), Boolean.valueOf(link.getAutoGen())
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SL_AG, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SL_AG, args, link);
			}
		}
	}

	protected void clearUniqueFindersCache(Link link) {
		LinkModelImpl linkModelImpl = (LinkModelImpl)link;

		Object[] args = new Object[] {
				link.getShortLink(), Boolean.valueOf(link.getAutoGen())
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SL_AG, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SL_AG, args);

		if ((linkModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SL_AG.getColumnBitmask()) != 0) {
			args = new Object[] {
					linkModelImpl.getOriginalShortLink(),
					Boolean.valueOf(linkModelImpl.getOriginalAutoGen())
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SL_AG, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SL_AG, args);
		}
	}

	/**
	 * Creates a new link with the primary key. Does not add the link to the database.
	 *
	 * @param linkId the primary key for the new link
	 * @return the new link
	 */
	public Link create(long linkId) {
		Link link = new LinkImpl();

		link.setNew(true);
		link.setPrimaryKey(linkId);

		String uuid = PortalUUIDUtil.generate();

		link.setUuid(uuid);

		return link;
	}

	/**
	 * Removes the link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linkId the primary key of the link
	 * @return the link that was removed
	 * @throws com.liferay.linkshortener.NoSuchLinkException if a link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link remove(long linkId) throws NoSuchLinkException, SystemException {
		return remove(Long.valueOf(linkId));
	}

	/**
	 * Removes the link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the link
	 * @return the link that was removed
	 * @throws com.liferay.linkshortener.NoSuchLinkException if a link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Link remove(Serializable primaryKey)
		throws NoSuchLinkException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Link link = (Link)session.get(LinkImpl.class, primaryKey);

			if (link == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(link);
		}
		catch (NoSuchLinkException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Link removeImpl(Link link) throws SystemException {
		link = toUnwrappedModel(link);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, link);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(link);

		return link;
	}

	@Override
	public Link updateImpl(com.liferay.linkshortener.model.Link link,
		boolean merge) throws SystemException {
		link = toUnwrappedModel(link);

		boolean isNew = link.isNew();

		LinkModelImpl linkModelImpl = (LinkModelImpl)link;

		if (Validator.isNull(link.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			link.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, link, merge);

			link.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LinkModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((linkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { linkModelImpl.getOriginalUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { linkModelImpl.getUuid() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((linkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LL_AG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						linkModelImpl.getOriginalShortLink(),
						Boolean.valueOf(linkModelImpl.getOriginalAutoGen())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LL_AG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LL_AG,
					args);

				args = new Object[] {
						linkModelImpl.getShortLink(),
						Boolean.valueOf(linkModelImpl.getAutoGen())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LL_AG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LL_AG,
					args);
			}

			if ((linkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AG.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						Boolean.valueOf(linkModelImpl.getOriginalAutoGen())
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AG,
					args);

				args = new Object[] { Boolean.valueOf(linkModelImpl.getAutoGen()) };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_AG, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AG,
					args);
			}

			if ((linkModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SL.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						linkModelImpl.getOriginalShortLink()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SL,
					args);

				args = new Object[] { linkModelImpl.getShortLink() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SL, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SL,
					args);
			}
		}

		EntityCacheUtil.putResult(LinkModelImpl.ENTITY_CACHE_ENABLED,
			LinkImpl.class, link.getPrimaryKey(), link);

		clearUniqueFindersCache(link);
		cacheUniqueFindersCache(link);

		return link;
	}

	protected Link toUnwrappedModel(Link link) {
		if (link instanceof LinkImpl) {
			return link;
		}

		LinkImpl linkImpl = new LinkImpl();

		linkImpl.setNew(link.isNew());
		linkImpl.setPrimaryKey(link.getPrimaryKey());

		linkImpl.setUuid(link.getUuid());
		linkImpl.setLinkId(link.getLinkId());
		linkImpl.setCreateDate(link.getCreateDate());
		linkImpl.setModifiedDate(link.getModifiedDate());
		linkImpl.setLongLink(link.getLongLink());
		linkImpl.setShortLink(link.getShortLink());
		linkImpl.setActive(link.isActive());
		linkImpl.setAutoGen(link.isAutoGen());

		return linkImpl;
	}

	/**
	 * Returns the link with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the link
	 * @return the link
	 * @throws com.liferay.portal.NoSuchModelException if a link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Link findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the link with the primary key or throws a {@link com.liferay.linkshortener.NoSuchLinkException} if it could not be found.
	 *
	 * @param linkId the primary key of the link
	 * @return the link
	 * @throws com.liferay.linkshortener.NoSuchLinkException if a link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link findByPrimaryKey(long linkId)
		throws NoSuchLinkException, SystemException {
		Link link = fetchByPrimaryKey(linkId);

		if (link == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + linkId);
			}

			throw new NoSuchLinkException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				linkId);
		}

		return link;
	}

	/**
	 * Returns the link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the link
	 * @return the link, or <code>null</code> if a link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Link fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey(((Long)primaryKey).longValue());
	}

	/**
	 * Returns the link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linkId the primary key of the link
	 * @return the link, or <code>null</code> if a link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link fetchByPrimaryKey(long linkId) throws SystemException {
		Link link = (Link)EntityCacheUtil.getResult(LinkModelImpl.ENTITY_CACHE_ENABLED,
				LinkImpl.class, linkId);

		if (link == _nullLink) {
			return null;
		}

		if (link == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				link = (Link)session.get(LinkImpl.class, Long.valueOf(linkId));
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (link != null) {
					cacheResult(link);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(LinkModelImpl.ENTITY_CACHE_ENABLED,
						LinkImpl.class, linkId, _nullLink);
				}

				closeSession(session);
			}
		}

		return link;
	}

	/**
	 * Returns all the links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching links
	 * @throws SystemException if a system exception occurred
	 */
	public List<Link> findByUuid(String uuid) throws SystemException {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Link> findByUuid(String uuid, int start, int end)
		throws SystemException {
		return findByUuid(uuid, start, end, null);
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
	public List<Link> findByUuid(String uuid, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<Link> list = (List<Link>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Link link : list) {
				if (!Validator.equals(uuid, link.getUuid())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_LINK_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				list = (List<Link>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Link findByUuid_First(String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		Link link = fetchByUuid_First(uuid, orderByComparator);

		if (link != null) {
			return link;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkException(msg.toString());
	}

	/**
	 * Returns the first link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link, or <code>null</code> if a matching link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link fetchByUuid_First(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		List<Link> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Link findByUuid_Last(String uuid, OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		Link link = fetchByUuid_Last(uuid, orderByComparator);

		if (link != null) {
			return link;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkException(msg.toString());
	}

	/**
	 * Returns the last link in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link, or <code>null</code> if a matching link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link fetchByUuid_Last(String uuid,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUuid(uuid);

		List<Link> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Link[] findByUuid_PrevAndNext(long linkId, String uuid,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		Link link = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			Link[] array = new LinkImpl[3];

			array[0] = getByUuid_PrevAndNext(session, link, uuid,
					orderByComparator, true);

			array[1] = link;

			array[2] = getByUuid_PrevAndNext(session, link, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Link getByUuid_PrevAndNext(Session session, Link link,
		String uuid, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LINK_WHERE);

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else {
			if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (uuid != null) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(link);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Link> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public Link findBySL_AG(String shortLink, boolean autoGen)
		throws NoSuchLinkException, SystemException {
		Link link = fetchBySL_AG(shortLink, autoGen);

		if (link == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("shortLink=");
			msg.append(shortLink);

			msg.append(", autoGen=");
			msg.append(autoGen);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchLinkException(msg.toString());
		}

		return link;
	}

	/**
	 * Returns the link where shortLink = &#63; and autoGen = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param shortLink the short link
	 * @param autoGen the auto gen
	 * @return the matching link, or <code>null</code> if a matching link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link fetchBySL_AG(String shortLink, boolean autoGen)
		throws SystemException {
		return fetchBySL_AG(shortLink, autoGen, true);
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
	public Link fetchBySL_AG(String shortLink, boolean autoGen,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { shortLink, autoGen };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_SL_AG,
					finderArgs, this);
		}

		if (result instanceof Link) {
			Link link = (Link)result;

			if (!Validator.equals(shortLink, link.getShortLink()) ||
					(autoGen != link.getAutoGen())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LINK_WHERE);

			if (shortLink == null) {
				query.append(_FINDER_COLUMN_SL_AG_SHORTLINK_1);
			}
			else {
				if (shortLink.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SL_AG_SHORTLINK_3);
				}
				else {
					query.append(_FINDER_COLUMN_SL_AG_SHORTLINK_2);
				}
			}

			query.append(_FINDER_COLUMN_SL_AG_AUTOGEN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (shortLink != null) {
					qPos.add(shortLink);
				}

				qPos.add(autoGen);

				List<Link> list = q.list();

				result = list;

				Link link = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SL_AG,
						finderArgs, list);
				}
				else {
					link = list.get(0);

					cacheResult(link);

					if ((link.getShortLink() == null) ||
							!link.getShortLink().equals(shortLink) ||
							(link.getAutoGen() != autoGen)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_SL_AG,
							finderArgs, link);
					}
				}

				return link;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_SL_AG,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (Link)result;
			}
		}
	}

	/**
	 * Returns all the links where shortLink = &#63; and autoGen = &#63;.
	 *
	 * @param shortLink the short link
	 * @param autoGen the auto gen
	 * @return the matching links
	 * @throws SystemException if a system exception occurred
	 */
	public List<Link> findByLL_AG(String shortLink, boolean autoGen)
		throws SystemException {
		return findByLL_AG(shortLink, autoGen, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the links where shortLink = &#63; and autoGen = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param shortLink the short link
	 * @param autoGen the auto gen
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @return the range of matching links
	 * @throws SystemException if a system exception occurred
	 */
	public List<Link> findByLL_AG(String shortLink, boolean autoGen, int start,
		int end) throws SystemException {
		return findByLL_AG(shortLink, autoGen, start, end, null);
	}

	/**
	 * Returns an ordered range of all the links where shortLink = &#63; and autoGen = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	 * </p>
	 *
	 * @param shortLink the short link
	 * @param autoGen the auto gen
	 * @param start the lower bound of the range of links
	 * @param end the upper bound of the range of links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching links
	 * @throws SystemException if a system exception occurred
	 */
	public List<Link> findByLL_AG(String shortLink, boolean autoGen, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LL_AG;
			finderArgs = new Object[] { shortLink, autoGen };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LL_AG;
			finderArgs = new Object[] {
					shortLink, autoGen,
					
					start, end, orderByComparator
				};
		}

		List<Link> list = (List<Link>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Link link : list) {
				if (!Validator.equals(shortLink, link.getShortLink()) ||
						(autoGen != link.getAutoGen())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LINK_WHERE);

			if (shortLink == null) {
				query.append(_FINDER_COLUMN_LL_AG_SHORTLINK_1);
			}
			else {
				if (shortLink.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LL_AG_SHORTLINK_3);
				}
				else {
					query.append(_FINDER_COLUMN_LL_AG_SHORTLINK_2);
				}
			}

			query.append(_FINDER_COLUMN_LL_AG_AUTOGEN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (shortLink != null) {
					qPos.add(shortLink);
				}

				qPos.add(autoGen);

				list = (List<Link>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first link in the ordered set where shortLink = &#63; and autoGen = &#63;.
	 *
	 * @param shortLink the short link
	 * @param autoGen the auto gen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link
	 * @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link findByLL_AG_First(String shortLink, boolean autoGen,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		Link link = fetchByLL_AG_First(shortLink, autoGen, orderByComparator);

		if (link != null) {
			return link;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("shortLink=");
		msg.append(shortLink);

		msg.append(", autoGen=");
		msg.append(autoGen);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkException(msg.toString());
	}

	/**
	 * Returns the first link in the ordered set where shortLink = &#63; and autoGen = &#63;.
	 *
	 * @param shortLink the short link
	 * @param autoGen the auto gen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link, or <code>null</code> if a matching link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link fetchByLL_AG_First(String shortLink, boolean autoGen,
		OrderByComparator orderByComparator) throws SystemException {
		List<Link> list = findByLL_AG(shortLink, autoGen, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last link in the ordered set where shortLink = &#63; and autoGen = &#63;.
	 *
	 * @param shortLink the short link
	 * @param autoGen the auto gen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link
	 * @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link findByLL_AG_Last(String shortLink, boolean autoGen,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		Link link = fetchByLL_AG_Last(shortLink, autoGen, orderByComparator);

		if (link != null) {
			return link;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("shortLink=");
		msg.append(shortLink);

		msg.append(", autoGen=");
		msg.append(autoGen);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkException(msg.toString());
	}

	/**
	 * Returns the last link in the ordered set where shortLink = &#63; and autoGen = &#63;.
	 *
	 * @param shortLink the short link
	 * @param autoGen the auto gen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link, or <code>null</code> if a matching link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link fetchByLL_AG_Last(String shortLink, boolean autoGen,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByLL_AG(shortLink, autoGen);

		List<Link> list = findByLL_AG(shortLink, autoGen, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the links before and after the current link in the ordered set where shortLink = &#63; and autoGen = &#63;.
	 *
	 * @param linkId the primary key of the current link
	 * @param shortLink the short link
	 * @param autoGen the auto gen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next link
	 * @throws com.liferay.linkshortener.NoSuchLinkException if a link with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link[] findByLL_AG_PrevAndNext(long linkId, String shortLink,
		boolean autoGen, OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		Link link = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			Link[] array = new LinkImpl[3];

			array[0] = getByLL_AG_PrevAndNext(session, link, shortLink,
					autoGen, orderByComparator, true);

			array[1] = link;

			array[2] = getByLL_AG_PrevAndNext(session, link, shortLink,
					autoGen, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Link getByLL_AG_PrevAndNext(Session session, Link link,
		String shortLink, boolean autoGen, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LINK_WHERE);

		if (shortLink == null) {
			query.append(_FINDER_COLUMN_LL_AG_SHORTLINK_1);
		}
		else {
			if (shortLink.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_LL_AG_SHORTLINK_3);
			}
			else {
				query.append(_FINDER_COLUMN_LL_AG_SHORTLINK_2);
			}
		}

		query.append(_FINDER_COLUMN_LL_AG_AUTOGEN_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (shortLink != null) {
			qPos.add(shortLink);
		}

		qPos.add(autoGen);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(link);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Link> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the links where autoGen = &#63;.
	 *
	 * @param autoGen the auto gen
	 * @return the matching links
	 * @throws SystemException if a system exception occurred
	 */
	public List<Link> findByAG(boolean autoGen) throws SystemException {
		return findByAG(autoGen, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Link> findByAG(boolean autoGen, int start, int end)
		throws SystemException {
		return findByAG(autoGen, start, end, null);
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
	public List<Link> findByAG(boolean autoGen, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_AG;
			finderArgs = new Object[] { autoGen };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_AG;
			finderArgs = new Object[] { autoGen, start, end, orderByComparator };
		}

		List<Link> list = (List<Link>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Link link : list) {
				if ((autoGen != link.getAutoGen())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_LINK_WHERE);

			query.append(_FINDER_COLUMN_AG_AUTOGEN_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(autoGen);

				list = (List<Link>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public Link findByAG_First(boolean autoGen,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		Link link = fetchByAG_First(autoGen, orderByComparator);

		if (link != null) {
			return link;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("autoGen=");
		msg.append(autoGen);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkException(msg.toString());
	}

	/**
	 * Returns the first link in the ordered set where autoGen = &#63;.
	 *
	 * @param autoGen the auto gen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link, or <code>null</code> if a matching link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link fetchByAG_First(boolean autoGen,
		OrderByComparator orderByComparator) throws SystemException {
		List<Link> list = findByAG(autoGen, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Link findByAG_Last(boolean autoGen,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		Link link = fetchByAG_Last(autoGen, orderByComparator);

		if (link != null) {
			return link;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("autoGen=");
		msg.append(autoGen);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkException(msg.toString());
	}

	/**
	 * Returns the last link in the ordered set where autoGen = &#63;.
	 *
	 * @param autoGen the auto gen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link, or <code>null</code> if a matching link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link fetchByAG_Last(boolean autoGen,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByAG(autoGen);

		List<Link> list = findByAG(autoGen, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public Link[] findByAG_PrevAndNext(long linkId, boolean autoGen,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		Link link = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			Link[] array = new LinkImpl[3];

			array[0] = getByAG_PrevAndNext(session, link, autoGen,
					orderByComparator, true);

			array[1] = link;

			array[2] = getByAG_PrevAndNext(session, link, autoGen,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Link getByAG_PrevAndNext(Session session, Link link,
		boolean autoGen, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LINK_WHERE);

		query.append(_FINDER_COLUMN_AG_AUTOGEN_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(autoGen);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(link);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Link> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the links where shortLink = &#63;.
	 *
	 * @param shortLink the short link
	 * @return the matching links
	 * @throws SystemException if a system exception occurred
	 */
	public List<Link> findBySL(String shortLink) throws SystemException {
		return findBySL(shortLink, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<Link> findBySL(String shortLink, int start, int end)
		throws SystemException {
		return findBySL(shortLink, start, end, null);
	}

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
	public List<Link> findBySL(String shortLink, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SL;
			finderArgs = new Object[] { shortLink };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SL;
			finderArgs = new Object[] { shortLink, start, end, orderByComparator };
		}

		List<Link> list = (List<Link>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Link link : list) {
				if (!Validator.equals(shortLink, link.getShortLink())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(2);
			}

			query.append(_SQL_SELECT_LINK_WHERE);

			if (shortLink == null) {
				query.append(_FINDER_COLUMN_SL_SHORTLINK_1);
			}
			else {
				if (shortLink.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SL_SHORTLINK_3);
				}
				else {
					query.append(_FINDER_COLUMN_SL_SHORTLINK_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (shortLink != null) {
					qPos.add(shortLink);
				}

				list = (List<Link>)QueryUtil.list(q, getDialect(), start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first link in the ordered set where shortLink = &#63;.
	 *
	 * @param shortLink the short link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link
	 * @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link findBySL_First(String shortLink,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		Link link = fetchBySL_First(shortLink, orderByComparator);

		if (link != null) {
			return link;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("shortLink=");
		msg.append(shortLink);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkException(msg.toString());
	}

	/**
	 * Returns the first link in the ordered set where shortLink = &#63;.
	 *
	 * @param shortLink the short link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching link, or <code>null</code> if a matching link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link fetchBySL_First(String shortLink,
		OrderByComparator orderByComparator) throws SystemException {
		List<Link> list = findBySL(shortLink, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last link in the ordered set where shortLink = &#63;.
	 *
	 * @param shortLink the short link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link
	 * @throws com.liferay.linkshortener.NoSuchLinkException if a matching link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link findBySL_Last(String shortLink,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		Link link = fetchBySL_Last(shortLink, orderByComparator);

		if (link != null) {
			return link;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("shortLink=");
		msg.append(shortLink);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLinkException(msg.toString());
	}

	/**
	 * Returns the last link in the ordered set where shortLink = &#63;.
	 *
	 * @param shortLink the short link
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching link, or <code>null</code> if a matching link could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public Link fetchBySL_Last(String shortLink,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countBySL(shortLink);

		List<Link> list = findBySL(shortLink, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	public Link[] findBySL_PrevAndNext(long linkId, String shortLink,
		OrderByComparator orderByComparator)
		throws NoSuchLinkException, SystemException {
		Link link = findByPrimaryKey(linkId);

		Session session = null;

		try {
			session = openSession();

			Link[] array = new LinkImpl[3];

			array[0] = getBySL_PrevAndNext(session, link, shortLink,
					orderByComparator, true);

			array[1] = link;

			array[2] = getBySL_PrevAndNext(session, link, shortLink,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Link getBySL_PrevAndNext(Session session, Link link,
		String shortLink, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LINK_WHERE);

		if (shortLink == null) {
			query.append(_FINDER_COLUMN_SL_SHORTLINK_1);
		}
		else {
			if (shortLink.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_SL_SHORTLINK_3);
			}
			else {
				query.append(_FINDER_COLUMN_SL_SHORTLINK_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (shortLink != null) {
			qPos.add(shortLink);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(link);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Link> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the links.
	 *
	 * @return the links
	 * @throws SystemException if a system exception occurred
	 */
	public List<Link> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<Link> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	public List<Link> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Link> list = (List<Link>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_LINK);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LINK;
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<Link>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);
				}
				else {
					list = (List<Link>)QueryUtil.list(q, getDialect(), start,
							end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the links where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByUuid(String uuid) throws SystemException {
		for (Link link : findByUuid(uuid)) {
			remove(link);
		}
	}

	/**
	 * Removes the link where shortLink = &#63; and autoGen = &#63; from the database.
	 *
	 * @param shortLink the short link
	 * @param autoGen the auto gen
	 * @return the link that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public Link removeBySL_AG(String shortLink, boolean autoGen)
		throws NoSuchLinkException, SystemException {
		Link link = findBySL_AG(shortLink, autoGen);

		return remove(link);
	}

	/**
	 * Removes all the links where shortLink = &#63; and autoGen = &#63; from the database.
	 *
	 * @param shortLink the short link
	 * @param autoGen the auto gen
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByLL_AG(String shortLink, boolean autoGen)
		throws SystemException {
		for (Link link : findByLL_AG(shortLink, autoGen)) {
			remove(link);
		}
	}

	/**
	 * Removes all the links where autoGen = &#63; from the database.
	 *
	 * @param autoGen the auto gen
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByAG(boolean autoGen) throws SystemException {
		for (Link link : findByAG(autoGen)) {
			remove(link);
		}
	}

	/**
	 * Removes all the links where shortLink = &#63; from the database.
	 *
	 * @param shortLink the short link
	 * @throws SystemException if a system exception occurred
	 */
	public void removeBySL(String shortLink) throws SystemException {
		for (Link link : findBySL(shortLink)) {
			remove(link);
		}
	}

	/**
	 * Removes all the links from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (Link link : findAll()) {
			remove(link);
		}
	}

	/**
	 * Returns the number of links where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching links
	 * @throws SystemException if a system exception occurred
	 */
	public int countByUuid(String uuid) throws SystemException {
		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_UUID,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LINK_WHERE);

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else {
				if (uuid.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_UUID_UUID_3);
				}
				else {
					query.append(_FINDER_COLUMN_UUID_UUID_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (uuid != null) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_UUID,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of links where shortLink = &#63; and autoGen = &#63;.
	 *
	 * @param shortLink the short link
	 * @param autoGen the auto gen
	 * @return the number of matching links
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySL_AG(String shortLink, boolean autoGen)
		throws SystemException {
		Object[] finderArgs = new Object[] { shortLink, autoGen };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SL_AG,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LINK_WHERE);

			if (shortLink == null) {
				query.append(_FINDER_COLUMN_SL_AG_SHORTLINK_1);
			}
			else {
				if (shortLink.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SL_AG_SHORTLINK_3);
				}
				else {
					query.append(_FINDER_COLUMN_SL_AG_SHORTLINK_2);
				}
			}

			query.append(_FINDER_COLUMN_SL_AG_AUTOGEN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (shortLink != null) {
					qPos.add(shortLink);
				}

				qPos.add(autoGen);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SL_AG,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of links where shortLink = &#63; and autoGen = &#63;.
	 *
	 * @param shortLink the short link
	 * @param autoGen the auto gen
	 * @return the number of matching links
	 * @throws SystemException if a system exception occurred
	 */
	public int countByLL_AG(String shortLink, boolean autoGen)
		throws SystemException {
		Object[] finderArgs = new Object[] { shortLink, autoGen };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LL_AG,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LINK_WHERE);

			if (shortLink == null) {
				query.append(_FINDER_COLUMN_LL_AG_SHORTLINK_1);
			}
			else {
				if (shortLink.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_LL_AG_SHORTLINK_3);
				}
				else {
					query.append(_FINDER_COLUMN_LL_AG_SHORTLINK_2);
				}
			}

			query.append(_FINDER_COLUMN_LL_AG_AUTOGEN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (shortLink != null) {
					qPos.add(shortLink);
				}

				qPos.add(autoGen);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LL_AG,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of links where autoGen = &#63;.
	 *
	 * @param autoGen the auto gen
	 * @return the number of matching links
	 * @throws SystemException if a system exception occurred
	 */
	public int countByAG(boolean autoGen) throws SystemException {
		Object[] finderArgs = new Object[] { autoGen };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_AG,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LINK_WHERE);

			query.append(_FINDER_COLUMN_AG_AUTOGEN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(autoGen);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_AG, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of links where shortLink = &#63;.
	 *
	 * @param shortLink the short link
	 * @return the number of matching links
	 * @throws SystemException if a system exception occurred
	 */
	public int countBySL(String shortLink) throws SystemException {
		Object[] finderArgs = new Object[] { shortLink };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SL,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LINK_WHERE);

			if (shortLink == null) {
				query.append(_FINDER_COLUMN_SL_SHORTLINK_1);
			}
			else {
				if (shortLink.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_SL_SHORTLINK_3);
				}
				else {
					query.append(_FINDER_COLUMN_SL_SHORTLINK_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (shortLink != null) {
					qPos.add(shortLink);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SL, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of links.
	 *
	 * @return the number of links
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LINK);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the link persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.linkshortener.model.Link")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Link>> listenersList = new ArrayList<ModelListener<Link>>();

				for (String listenerClassName : listenerClassNames) {
					Class<?> clazz = getClass();

					listenersList.add((ModelListener<Link>)InstanceFactory.newInstance(
							clazz.getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(LinkImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = LinkPersistence.class)
	protected LinkPersistence linkPersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_LINK = "SELECT link FROM Link link";
	private static final String _SQL_SELECT_LINK_WHERE = "SELECT link FROM Link link WHERE ";
	private static final String _SQL_COUNT_LINK = "SELECT COUNT(link) FROM Link link";
	private static final String _SQL_COUNT_LINK_WHERE = "SELECT COUNT(link) FROM Link link WHERE ";
	private static final String _FINDER_COLUMN_UUID_UUID_1 = "link.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "link.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(link.uuid IS NULL OR link.uuid = ?)";
	private static final String _FINDER_COLUMN_SL_AG_SHORTLINK_1 = "link.shortLink IS NULL AND ";
	private static final String _FINDER_COLUMN_SL_AG_SHORTLINK_2 = "link.shortLink = ? AND ";
	private static final String _FINDER_COLUMN_SL_AG_SHORTLINK_3 = "(link.shortLink IS NULL OR link.shortLink = ?) AND ";
	private static final String _FINDER_COLUMN_SL_AG_AUTOGEN_2 = "link.autoGen = ?";
	private static final String _FINDER_COLUMN_LL_AG_SHORTLINK_1 = "link.shortLink IS NULL AND ";
	private static final String _FINDER_COLUMN_LL_AG_SHORTLINK_2 = "link.shortLink = ? AND ";
	private static final String _FINDER_COLUMN_LL_AG_SHORTLINK_3 = "(link.shortLink IS NULL OR link.shortLink = ?) AND ";
	private static final String _FINDER_COLUMN_LL_AG_AUTOGEN_2 = "link.autoGen = ?";
	private static final String _FINDER_COLUMN_AG_AUTOGEN_2 = "link.autoGen = ?";
	private static final String _FINDER_COLUMN_SL_SHORTLINK_1 = "link.shortLink IS NULL";
	private static final String _FINDER_COLUMN_SL_SHORTLINK_2 = "link.shortLink = ?";
	private static final String _FINDER_COLUMN_SL_SHORTLINK_3 = "(link.shortLink IS NULL OR link.shortLink = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "link.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Link exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Link exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(LinkPersistenceImpl.class);
	private static Link _nullLink = new LinkImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Link> toCacheModel() {
				return _nullLinkCacheModel;
			}
		};

	private static CacheModel<Link> _nullLinkCacheModel = new CacheModel<Link>() {
			public Link toEntityModel() {
				return _nullLink;
			}
		};
}