/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.altisource.circus.codegen;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import com.altisource.circus.entity.ActsEntity;
import com.altisource.circus.query.QueryActs;
import com.mysema.query.Tuple;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.UniVerseTemplates;
import com.mysema.query.sql.universe.UniVerseQuery;

/**
 * @author Steve Pitschke
 */
public class DoQueryActs {

    public static void main(String[] args) throws Exception {
    	
        Class.forName("com.rs.u2.jdbc.UniJDBCDriver");
        String url = "jdbc:rs-u2://localhost/C:/U2/UV/HS.ADMIN;dbmstype=UNIVERSE";
        Connection conn = DriverManager.getConnection(url, "ASCORP\\pitschke", "XXX");
        
        QueryActs acts = new QueryActs("c");

        SQLTemplates dialect = new UniVerseTemplates(); // SQL-dialect
        UniVerseQuery query = new UniVerseQuery(conn, dialect); 
        List<ActsEntity> results = query.from(acts)
            .where(acts.description.like("%the%"))
            .list(acts.getProjection());
        
        for (ActsEntity row : results) {
        	System.out.println(row.getActNo() + "\t" + row.getDescription());
        }
        
        conn.close();
    }
}
