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

package com.liferay.linkshortener.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Link service. Represents a row in the &quot;LinkShortener_Link&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LinkModel
 * @see com.liferay.linkshortener.model.impl.LinkImpl
 * @see com.liferay.linkshortener.model.impl.LinkModelImpl
 * @generated
 */
public interface Link extends LinkModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.linkshortener.model.impl.LinkImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
}