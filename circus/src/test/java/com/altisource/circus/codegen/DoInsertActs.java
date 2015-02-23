package com.altisource.circus.codegen;
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




import java.sql.Connection;
import java.sql.DriverManager;

import com.altisource.circus.query.QueryActs;
import com.mysema.query.sql.SQLBindings;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.UniVerseTemplates;
import com.mysema.query.sql.dml.SQLInsertClause;
import com.mysema.query.types.expr.MultiValueNumberList;

/**
 * @author Steve Pitschke
 */
public class DoInsertActs {

    public static void main(String[] args) throws Exception {
    	
        Class.forName("com.rs.u2.jdbc.UniJDBCDriver");
        String url = "jdbc:rs-u2://localhost/C:/U2/UV/HS.ADMIN;dbmstype=UNIVERSE";
        Connection conn = DriverManager.getConnection(url, "ASCORP\\pitschke", "Ora1nge++");
        
        QueryActs acts = new QueryActs("c");

        SQLTemplates dialect = new UniVerseTemplates(); // SQL-dialect
        SQLInsertClause insert = new SQLInsertClause(conn, dialect, acts);
        
        insert.set(acts.actNo, 405)
        	.set(acts.description, "The Bearded Lady")
        	.set(acts.equipCode, new MultiValueNumberList(22, 43));
        
        SQLBindings sql = insert.getSQL().get(0);
        String str = sql.getSQL();
        System.out.println(str);
        
        insert.execute();
        conn.close();
    }
}