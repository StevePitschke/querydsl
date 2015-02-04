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
        Connection conn = DriverManager.getConnection(url, "ASCORP\\pitschke", "XXX");
        
        Statement stmt = conn.createStatement();
        ResultSet results = stmt.executeQuery("SELECT * FROM RIDES.T, RIDES.T_OPERATOR, RIDES.T_EQUIP_CODE WHERE RIDES.T.RIDE_ID = RIDES.T_OPERATOR.RIDE_ID AND RIDES.T.RIDE_ID = RIDES.T_EQUIP_CODE.RIDE_ID AND (RIDES.T_OPERATOR.@ASSOC_ROW IS NULL OR RIDES.T_EQUIP_CODE.@ASSOC_ROW IS NULL OR RIDES.T_OPERATOR.@ASSOC_ROW = RIDES.T_EQUIP_CODE.@ASSOC_ROW) ORDER BY RIDES.T.RIDE_ID");
        ResultSetMetaData metadata = results.getMetaData();
        int row = 1;
        
        while (results.next()) {
        	
        	System.out.println("Row: " + row++);
        	
        	for (int idx = 1; idx <= metadata.getColumnCount(); idx++) {
        		System.out.println(metadata.getTableName(idx) + '.' + metadata.getColumnName(idx) + ": " + results.getObject(idx));
//        		UniJDBCColumnDesc desc =  ((UniJDBCResultSetMetaData)metadata).getColumnInfo(idx);
//        		System.out.println("ColumnInfo: " + desc + ", multivalued: " + UniJDBCColumnDesc.class.getDeclaredField("multivalued").getBoolean(desc));
//        		System.out.println("ColumnType: " + ((UniJDBCResultSetMetaData)metadata).getColumnTypeName(idx));
        	}
        	
//        	break;
        }
        
        conn.close();
    }

}
