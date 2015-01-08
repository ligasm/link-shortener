<%--
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
--%>

<%@include file="../init.jspf" %>

<c:set var="encodedLink">
	<%= ParamUtil.getString(renderRequest, ENCODED_LINK_PARAM, "") %>
</c:set>

<liferay-ui:error key="auto-shortener-not-saved" message="auto-shortener-not-saved" />

<c:choose>
	<c:when test="${not empty encodedLink}">
		<c:out escapeXml="true" value="${encodedLink}" />
	</c:when>
	<c:otherwise>
		<portlet:actionURL name="shortenLinkAction" var="actionUrl" />
		<aui:form action="${actionUrl}" method="POST" name="fm">
			<liferay-ui:error key="link-required" message="link-required" />
			<aui:input name="<%= LINK_PARAM %>" required="true" />

			<aui:button-row>
				<aui:button type="submit" />
			</aui:button-row>
		</aui:form>
	</c:otherwise>
</c:choose>