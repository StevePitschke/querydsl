package com.altisource.circus.codegen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;


public class SelectMultiValue {
    
    public static void main(String[] args) throws Exception {
    	
        Class.forName("com.rs.u2.jdbc.UniJDBCDriver");
        String url = "jdbc:rs-u2://localhost/C:/U2/UV/HS.ADMIN;dbmstype=UNIVERSE";
        Connection conn = DriverManager.getConnection(url, "ASCORP\\pitschke", "Ora1nge++");
        
        Statement stmt = conn.createStatement();
        ResultSet results = stmt.executeQuery("SELECT * FROM UV_COLUMNS WHERE TABLE_SCHEMA='CIRCUS' AND TABLE_NAME='ACTS.T'");
        ResultSetMetaData metadata = results.getMetaData();
        int row = 1;
        
        while (results.next()) {
        	
        	for (int idx = 1; idx <= metadata.getColumnCount(); idx++) {
        		if (idx > 1) {
        			System.out.print(", ");
        		}
        		System.out.print(metadata.getColumnName(idx) + ": " + results.getObject(idx));
//        		UniJDBCColumnDesc desc =  ((UniJDBCResultSetMetaData)metadata).getColumnInfo(idx);
//        		System.out.println("ColumnInfo: " + desc + ", multivalued: " + UniJDBCColumnDesc.class.getDeclaredField("multivalued").getBoolean(desc));
//        		System.out.println("ColumnType: " + ((UniJDBCResultSetMetaData)metadata).getColumnTypeName(idx));
        	}
        	
        	System.out.println();
        }
        
        conn.close();
    }

}
