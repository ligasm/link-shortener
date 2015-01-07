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

<c:set var="shortURLHostname"><%= ApplicationPropsValues.LINK_SHORTENER_HOSTNAME %>
</c:set>
<c:set var="pattern"><liferay-ui:message key="date-pattern" /></c:set>

<portlet:renderURL var="redirect" />

<liferay-ui:error key="link-translator-unable-to-add" message="link-translator-unable-to-add"/>
<liferay-ui:error key="link-translator-unable-to-delete" message="link-translator-unable-to-delete"/>
<liferay-ui:error key="link-translator-wrong-entry-id" message="link-translator-wrong-entry-id"/>
<liferay-ui:error key="link-translator-unable-to-update" message="link-translator-unable-to-update"/>
<liferay-ui:error key="link-translator-link-taken" message="link-translator-link-taken"/>

<div class="link-shortener-content">

	<aui:button-row>
		<portlet:renderURL var="addURL">
			<portlet:param name="mvcPath" value="/html/translator/view_add_edit.jsp" />
			<portlet:param name="<%= VIEW_EDIT_DETAIL_PARAM %>" value="add" />
			<portlet:param name="redirect" value="${redirect}" />
		</portlet:renderURL>
		<aui:button name="addLinkButton" onClick="${addURL}" value="add-link" />
	</aui:button-row>

	<liferay-ui:search-container emptyResultsMessage="empty-results-message">
		<liferay-ui:search-container-results
				results="<%= LinkLocalServiceUtil.getLinksByAutoGen(false, searchContainer.getStart(), searchContainer.getEnd()) %>"
				total="<%= LinkLocalServiceUtil.getLinksCount() %>"
		/>

		<liferay-ui:search-container-row
				className="com.liferay.linkshortener.model.Link"
				escapedModel="<%= true %>"
				keyProperty="linkId"
				modelVar="link"
		>

			<portlet:renderURL var="rowURL">
				<portlet:param name="mvcPath" value="/html/translator/view_add_edit.jsp" />
				<portlet:param name="<%= LINK_ID_PARAM %>" value="${link.linkId}" />
				<portlet:param name="<%= VIEW_EDIT_DETAIL_PARAM %>" value="view" />
				<portlet:param name="redirect" value="${redirect}" />
			</portlet:renderURL>

			<liferay-ui:search-container-column-text href="${rowURL}" name="link-id" property="linkId" />

			<fmt:formatDate pattern="${pattern}" type="date" value="${link.createDate}" var="createDateFm" />
			<liferay-ui:search-container-column-text name="create-date" value="${createDateFm}" />

			<fmt:formatDate pattern="${pattern}" type="date" value="${link.modifiedDate}" var="modifiedDateFm" />
			<liferay-ui:search-container-column-text name="modified-date" value="${modifiedDateFm}" />

			<liferay-ui:search-container-column-text href="//${shortURLHostname}/${link.shortLink}" name="short-link"
													 property="shortLink" />

			<liferay-ui:search-container-column-text href="${link.longLink}" name="long-link" property="longLink" />

			<liferay-ui:search-container-column-text name="active">
				<c:choose>
					<c:when test="${link.active}">
						<liferay-ui:icon image="activate" />
					</c:when>
					<c:otherwise>
						<liferay-ui:icon image="deactivate" />
					</c:otherwise>
				</c:choose>
			</liferay-ui:search-container-column-text>
			<%--TODO: shortcut to activate/deactivate entry--%>
			<liferay-ui:search-container-column-text name="actions">
				<liferay-ui:icon-menu>
					<portlet:renderURL var="editURL">
						<portlet:param name="mvcPath" value="/html/translator/view_add_edit.jsp" />
						<portlet:param name="<%= LINK_ID_PARAM %>" value="${link.linkId}" />
						<portlet:param name="<%= VIEW_EDIT_DETAIL_PARAM %>" value="edit" />
						<portlet:param name="redirect" value="${redirect}" />
					</portlet:renderURL>
					<liferay-ui:icon image="edit" url="${editURL}" />

					<portlet:actionURL name="deleteLink" var="deleteURL">
						<portlet:param name="<%= LINK_ID_PARAM %>" value="${link.linkId}" />
						<portlet:param name="redirect" value="${redirect}" />
					</portlet:actionURL>
					<liferay-ui:icon image="delete" url="${deleteURL}" />

				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator/>
	</liferay-ui:search-container>
</div>