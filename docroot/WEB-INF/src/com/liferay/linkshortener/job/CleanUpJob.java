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

package com.liferay.linkshortener.job;

import com.liferay.linkshortener.service.LinkLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import java.util.Date;

import static com.liferay.linkshortener.util.ApplicationPropsValues.LINK_SHORTENER_CLEANUP_LIMIT;
import static com.liferay.linkshortener.util.ApplicationPropsValues.LINK_SHORTENER_LINK_TTL;

/**
 * @author Miroslav Ligas
 */
public class CleanUpJob extends BaseMessageListener {

	@Override
	protected void doReceive(Message message) throws Exception {

		int totalRecords = LinkLocalServiceUtil.getLinksCount();

		if (totalRecords > LINK_SHORTENER_CLEANUP_LIMIT) {
			if (_LOG.isInfoEnabled()) {
				_LOG.info("Cleaning up Links.");
			}

			long linkTll = LINK_SHORTENER_LINK_TTL * 30 * 24 * 60 * 60 * 1000l;

			Date linkTllDate = new Date(new Date().getTime() - linkTll);

			LinkLocalServiceUtil.deleteOldRecords(linkTllDate);
		}
	}

	private static Log _LOG = LogFactoryUtil.getLog(CleanUpJob.class);

}