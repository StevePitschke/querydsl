package com.mysema.query;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

import com.mysema.query.codegen.BeanSerializer;
import com.mysema.query.sql.codegen.MetaDataExporter;
import com.mysema.query.sql.codegen.UniVerseNameStrategy;


public class Export {
    
    public static void main(String[] args) throws Exception {
        Class.forName("com.rs.u2.jdbc.UniJDBCDriver");
        String url = "jdbc:rs-u2://localhost/C:/U2/UV/HS.ADMIN;dbmstype=UNIVERSE";
        Connection conn = DriverManager.getConnection(url, "ASCORP\\pitschke", "Ora1nge++");
        
        MetaDataExporter exporter = new MetaDataExporter();
        exporter.setNamePrefix("Query");
        exporter.setPackageName("com.altisource.circus.query");
        exporter.setTargetFolder(new File("../querydsl-universe/src/main/java"));
        exporter.setNamingStrategy(new UniVerseNameStrategy());
//        exporter.setLowerCase(true);
        exporter.setExportForeignKeys(false);
        exporter.setBeanSuffix("Entity");
        exporter.setBeanSerializer(new BeanSerializer());
        exporter.setBeanPackageName("com.altisource.circus.entity");
        exporter.export(conn.getMetaData());
        
        conn.close();
    }

}
