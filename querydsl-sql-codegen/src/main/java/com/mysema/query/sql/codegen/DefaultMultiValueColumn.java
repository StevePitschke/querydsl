/*
 * © 2015 Altisource Solutions S.à r.l.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mysema.query.sql.codegen;

import java.sql.Connection;

/**
 * @author Steve Pitschke
 */
public class DefaultMultiValueColumn implements MultiValueColumn {

	/* (non-Javadoc)
	 * @see com.mysema.query.sql.codegen.MultiValueColumn#isMultiValue(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isMultiValue(Connection conn, String schema, String tableName, String columnName) {
		return false;
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.sql.codegen.MultiValueColumn#isBaseTable(java.sql.Connection, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isBaseTable(Connection conn, String schema, String tableName) {
		return true;
	}
}
