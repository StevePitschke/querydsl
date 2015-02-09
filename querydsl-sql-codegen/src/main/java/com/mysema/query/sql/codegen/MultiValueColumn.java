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
import java.util.List;

/**
 * @author Steve Pitschke
 */
public interface MultiValueColumn {
	
	/**
	 * Determine if column is multi-column
	 * 
	 * @param conn
	 * @param schema
	 * @param tableName
	 * @param columnName
	 * @return <code>true</code> if column is a multi-value one.
	 */
	boolean isMultiValue(Connection conn, String schema, String tableName, String columnName);
	
	/**
	 * Determine if table is a base table
	 * 
	 * @param conn
	 * @param schema
	 * @param tableName
	 * @return <code>true</code> if table is a base table.
	 */
	boolean isBaseTable(Connection conn, String schema, String tableName);
	
	/**
	 * Determine the list of keynames from the base table that should be removed from
	 * the nested table columns
	 * 
	 * @param conn
	 * @param schema
	 * @param tableName
	 * @return list of base table key names
	 */
	List<String> baseTableKeyNames(Connection conn, String schema, String tableName);
	
	/**
	 * Determine if candidate sub-table is the one corresponding to multi-valued
	 * column name
	 * 
	 * @param baseTable
	 * @param columnName
	 * @param subTable
	 * @return <code>true</code> if sub-table is the sub-table for current multi-valued
	 * column
	 */
	boolean isSubTable(String baseTable, String columnName, String subTable);
}
