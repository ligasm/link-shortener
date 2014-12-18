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

package com.liferay.linkshortener.hook.filter;

import com.liferay.linkshortener.NoSuchLinkException;
import com.liferay.linkshortener.model.Link;
import com.liferay.linkshortener.service.LinkLocalServiceUtil;
import com.liferay.linkshortener.service.util.ShortURLUtil;
import com.liferay.linkshortener.util.ApplicationConstants;
import com.liferay.linkshortener.util.ApplicationPropsValues;
import com.liferay.portal.kernel.exception.NestableException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Miroslav Ligas
 */
public class LinkShortenerFilter implements Filter {

	@Override
	public void destroy() {
		//empty
	}

	@Override
	public void doFilter(
		ServletRequest request, ServletResponse response,
		FilterChain filterChain) throws IOException, ServletException {

		String longURL = null;
		String serverName = request.getServerName();

		if (ApplicationPropsValues.LINK_SHORTENER_HOSTNAME.equals(serverName)) {
			if (request instanceof HttpServletRequest) {
				String shortUrl = getShortURLWithoutLeadingSlash(
					(HttpServletRequest)request);

				if (isAutoShortenedURL(shortUrl)) {
					longURL = translateAutoShortenURL(shortUrl);
				}
				else {
					longURL = translateLink(shortUrl);
				}
			}
		}

		if (longURL != null) {
			forwardToLongURL(longURL, response);
		}
		else {
			filterChain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		_LOG.info("Url Shortener filter is active.");
	}

	private void forwardToLongURL(String longURL, ServletResponse response) {
		if (response instanceof HttpServletResponse) {
			HttpServletResponse httpResponse = (HttpServletResponse)response;
			try {
				httpResponse.sendRedirect(longURL);
			}
			catch (IOException e) {
				_LOG.error("Unable to redirect to long URL ", e);
			}
		}
	}

	private String getShortURLWithoutLeadingSlash(HttpServletRequest request) {
		return request.getServletPath().substring(1);
	}

	private boolean isAutoShortenedURL(String shortUrl) {
		return shortUrl.charAt(0) == ApplicationConstants.AUTO_SHORTEN_PREFIX;
	}

	private String translateAutoShortenURL(String shortUrl) {
		String result = null;
		String encodedId = shortUrl.substring(1);
		long decodeId = ShortURLUtil.decode(encodedId);
		try {
			Link link = LinkLocalServiceUtil.getLink(decodeId);
			result = link.getLongLink();
		}
		catch (NestableException e) {
			_LOG.error("Unable to load Link wth ID " + decodeId, e);
		}

		return result;
	}

	private String translateLink(String shortUrl) {
		String result = null;
		try {
			Link link = LinkLocalServiceUtil.getLinksByShortLink(shortUrl);
			result = link.getLongLink();
		}
		catch (NoSuchLinkException e) {
			_LOG.info("Link link " + shortUrl + " not found.");
		}
		catch (SystemException e) {
			_LOG.error("Unable to load link for short link " + shortUrl, e);
		}

		return result;
	}

	private static Log _LOG = LogFactoryUtil.getLog(LinkShortenerFilter.class);

}