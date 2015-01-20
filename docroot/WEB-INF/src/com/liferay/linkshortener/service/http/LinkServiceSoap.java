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

package com.liferay.linkshortener.service.http;

import com.liferay.linkshortener.service.LinkServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * <p>
 * This class provides a SOAP utility for the
 * {@link com.liferay.linkshortener.service.LinkServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 * </p>
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a {@link java.util.List}, that
 * is translated to an array of {@link com.liferay.linkshortener.model.LinkSoap}.
 * If the method in the service utility returns a
 * {@link com.liferay.linkshortener.model.Link}, that is translated to a
 * {@link com.liferay.linkshortener.model.LinkSoap}. Methods that SOAP cannot
 * safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at
 * http://localhost:8080/api/secure/axis. Set the property
 * <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LinkServiceHttp
 * @see       com.liferay.linkshortener.model.LinkSoap
 * @see       com.liferay.linkshortener.service.LinkServiceUtil
 * @generated
 */
public class LinkServiceSoap {
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
	public static com.liferay.linkshortener.model.LinkSoap addLink(
		com.liferay.linkshortener.model.LinkSoap link)
		throws RemoteException {
		try {
			com.liferay.linkshortener.model.Link returnValue = LinkServiceUtil.addLink(com.liferay.linkshortener.model.impl.LinkModelImpl.toModel(
						link));

			return com.liferay.linkshortener.model.LinkSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Deletes the link with the primary key from the database. Also notifies
	* the appropriate model listeners.
	*
	* @param linkId the primary key of the link
	* @return the link that was removed
	* @throws PortalException if a link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.LinkSoap deleteLink(
		long linkId) throws RemoteException {
		try {
			com.liferay.linkshortener.model.Link returnValue = LinkServiceUtil.deleteLink(linkId);

			return com.liferay.linkshortener.model.LinkSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Returns the link with the primary key.
	*
	* @param linkId the primary key of the link
	* @return the link
	* @throws PortalException if a link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.LinkSoap getLink(long linkId)
		throws RemoteException {
		try {
			com.liferay.linkshortener.model.Link returnValue = LinkServiceUtil.getLink(linkId);

			return com.liferay.linkshortener.model.LinkSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
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
	public static com.liferay.linkshortener.model.LinkSoap[] getLinksByAutoGen(
		boolean autoGen, int start, int end) throws RemoteException {
		try {
			java.util.List<com.liferay.linkshortener.model.Link> returnValue = LinkServiceUtil.getLinksByAutoGen(autoGen,
					start, end);

			return com.liferay.linkshortener.model.LinkSoap.toSoapModels(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Method returns the link which short link matches the provided value.
	*
	* @param shortLink the short link
	* @return the matching link
	* @throws com.liferay.linkshortener.NoSuchLinkException if a matching link
	could not be found
	* @throws SystemException if a system exception occurred.
	* @throws NoSuchLinkException if the link does not exist.
	*/
	public static com.liferay.linkshortener.model.LinkSoap getLinksByShortLink(
		java.lang.String shortLink) throws RemoteException {
		try {
			com.liferay.linkshortener.model.Link returnValue = LinkServiceUtil.getLinksByShortLink(shortLink);

			return com.liferay.linkshortener.model.LinkSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	* Factory method for a new Link object.
	*
	* @return new object
	*/
	public static com.liferay.linkshortener.model.LinkSoap linkFactory()
		throws RemoteException {
		try {
			com.liferay.linkshortener.model.Link returnValue = LinkServiceUtil.linkFactory();

			return com.liferay.linkshortener.model.LinkSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

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
	public static com.liferay.linkshortener.model.LinkSoap updateLink(
		com.liferay.linkshortener.model.LinkSoap link)
		throws RemoteException {
		try {
			com.liferay.linkshortener.model.Link returnValue = LinkServiceUtil.updateLink(com.liferay.linkshortener.model.impl.LinkModelImpl.toModel(
						link));

			return com.liferay.linkshortener.model.LinkSoap.toSoapModel(returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LinkServiceSoap.class);
}