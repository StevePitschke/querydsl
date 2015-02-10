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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Steve Pitschke
 */
public class UniVerseMultiValueColumn implements MultiValueColumn {

	@Override
	public boolean isMultiValue(Connection conn, String schema, String tableName, String columnName) {
		
		try {
			
			Statement stmt = conn.createStatement();
	        ResultSet results = stmt.executeQuery("SELECT MULTI_VALUE FROM UV_COLUMNS WHERE TABLE_SCHEMA='" + schema +
	        		"' AND TABLE_NAME='" + tableName + "' AND COLUMN_NAME='" + columnName + "'");
	        
	        while (results.next()) {
	        	return "M".equals(results.getString("MULTI_VALUE"));
	        }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.sql.codegen.MultiValueColumn#isBaseTable(java.sql.Connection, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isBaseTable(Connection conn, String schema, String tableName) {
		
		try {
			
			Statement stmt = conn.createStatement();
	        ResultSet results = stmt.executeQuery("SELECT TABLE_TYPE FROM UV_TABLES WHERE TABLE_SCHEMA='" + schema +
	        		"' AND TABLE_NAME='" + tableName + "'");
	        
	        while (results.next()) {
	        	return "BASE TABLE".equals(results.getString("TABLE_TYPE"));
	        }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.sql.codegen.MultiValueColumn#baseTableKeyNames(java.sql.Connection, java.lang.String, java.lang.String)
	 */
	@Override
	public List<String> baseTableKeyNames(Connection conn, String schema,
			String tableName) {

		List<String> results = new ArrayList<String>();
		
		results.add("@ASSOC_ROW"); // Not exactly a key, but should be removed from nested tables;
		
		try {
			
			Statement stmt = conn.createStatement();
	        ResultSet resultSet = stmt.executeQuery("SELECT COLUMN_NAME FROM UV_COLUMNS WHERE TABLE_SCHEMA='" + schema +
	        		"' AND TABLE_NAME='" + tableName + "' AND KEY_SEQ>0");
	        
	        while (resultSet.next()) {
	        	results.add(resultSet.getString("COLUMN_NAME"));
	        }
	        
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return results;
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.sql.codegen.MultiValueColumn#isSubTable(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public boolean isSubTable(Connection conn, String schema, String baseTable, String columnName,
			String subTable) {
		
		String association = null;
		
		try {
			
			Statement stmt = conn.createStatement();
	        ResultSet results = stmt.executeQuery("SELECT IN_ASSOCIATION FROM UV_COLUMNS WHERE TABLE_SCHEMA='" + schema +
	        		"' AND TABLE_NAME='" + baseTable + "' AND COLUMN_NAME='" + columnName + "'");
	        
	        while (results.next()) {	        	
	        	association = results.getString("IN_ASSOCIATION");
	        	break;
	        }
	        
		} catch (SQLException e) {
			// XXX - ignore
		}
		
		if (association != null && association.length() > 0) {
			columnName = association;
		}
		
		return subTable.equals(baseTable + "_" + columnName);
	}
}
