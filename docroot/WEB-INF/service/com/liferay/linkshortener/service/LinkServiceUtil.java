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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * The utility for the link remote service. This utility wraps {@link com.liferay.linkshortener.service.impl.LinkServiceImpl} and is the primary access point for service operations in application layer code running on a remote server.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinkService
 * @see com.liferay.linkshortener.service.base.LinkServiceBaseImpl
 * @see com.liferay.linkshortener.service.impl.LinkServiceImpl
 * @generated
 */
public class LinkServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.linkshortener.service.impl.LinkServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* Method checks if the short link is already used. If the link is not used
	* it adds a new link to database. Also notifies the appropriate model
	* listeners.
	*
	* @param link the link
	* @return the link that was added
	*/
	public static com.liferay.linkshortener.model.Link addLink(
		com.liferay.linkshortener.model.Link link)
		throws com.liferay.linkshortener.ShortLinkTakenException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addLink(link);
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
	public static com.liferay.linkshortener.model.Link deleteLink(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteLink(linkId);
	}

	/**
	* Returns the link with the primary key.
	*
	* @param linkId the primary key of the link
	* @return the link
	* @throws PortalException if a link with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.linkshortener.model.Link getLink(long linkId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLink(linkId);
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
	public static java.util.List<com.liferay.linkshortener.model.Link> getLinksByAutoGen(
		boolean autoGen, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getLinksByAutoGen(autoGen, start, end);
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
	public static com.liferay.linkshortener.model.Link getLinksByShortLink(
		java.lang.String shortLink)
		throws com.liferay.linkshortener.NoSuchLinkException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getLinksByShortLink(shortLink);
	}

	/**
	* Factory method for a new Link object.
	*
	* @return new object
	*/
	public static com.liferay.linkshortener.model.Link linkFactory() {
		return getService().linkFactory();
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
	public static com.liferay.linkshortener.model.Link updateLink(
		com.liferay.linkshortener.model.Link link)
		throws com.liferay.linkshortener.ShortLinkTakenException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().updateLink(link);
	}

	public static void clearService() {
		_service = null;
	}

	public static LinkService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					LinkService.class.getName());

			if (invokableService instanceof LinkService) {
				_service = (LinkService)invokableService;
			}
			else {
				_service = new LinkServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(LinkServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated
	 */
	public void setService(LinkService service) {
	}

	private static LinkService _service;
}