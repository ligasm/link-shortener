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

<%
	pageContext.setAttribute("shortLinkPrefix",
			ApplicationPropsValues.LINK_SHORTENER_HOSTNAME);
	pageContext.setAttribute("viewEditDetail",
			ParamUtil.getString(renderRequest, VIEW_EDIT_DETAIL_PARAM, ""));
	pageContext.setAttribute("redirect",
			ParamUtil.getString(request, "redirect"));
	long linkId = ParamUtil.getLong(renderRequest, LINK_ID_PARAM);
	Link link = null;
	if (linkId > 0) {
		link = LinkLocalServiceUtil.getLink(linkId);
	}
%>

<c:set value="false" var="formDisabled" />
<c:choose>
	<c:when test="${viewEditDetail eq 'edit'}">
		<portlet:actionURL name="editLink" var="actionURL" />
	</c:when>
	<c:when test="${viewEditDetail eq 'add'}">
		<portlet:actionURL name="addLink" var="actionURL" />
	</c:when>
	<c:otherwise>
		<c:set value="true" var="formDisabled" />
	</c:otherwise>
</c:choose>

<aui:model-context bean="<%=link%>" model="<%= Link.class %>" />
<div class="link-shortener-edit-form">
	<aui:form action="${actionURL}" method="POST" name="fm">
		<aui:fieldset>
			<c:if test="${viewEditDetail ne 'add'}">
				<aui:input name="linkId" type="hidden" value="<%= linkId %>" />
				<aui:input disabled="true" label="link-id" name="linkId" />
			</c:if>

			<aui:input disabled="${formDisabled}" label="short-link" name="shortLink" prefix="${shortLinkPrefix}/">
				<aui:validator name="required" />
				<aui:validator name="minLength"><%=MIN_SHORT_URL%></aui:validator>
			</aui:input>
			<liferay-ui:error key="short-link-required" message="short-link-required"/>
			<liferay-ui:error key="short-link-to-short" message="short-link-to-short"/>

			<aui:input disabled="${formDisabled}" label="long-link" name="longLink" required="true" />
			<liferay-ui:error key="long-link-required" message="long-link-required"/>

			<aui:input checked="<%= link == null || link.getActive() %>" disabled="${formDisabled}" label="active" name="active" type="checkbox" />

		</aui:fieldset>

		<aui:button-row>
			<c:if test="${not formDisabled}">
				<aui:button type="submit" />
			</c:if>

			<aui:button onClick="${redirect}" type="cancel" value="back" />
		</aui:button-row>
	</aui:form>
</div>