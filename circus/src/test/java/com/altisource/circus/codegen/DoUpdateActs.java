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
import java.util.List;

import com.altisource.circus.entity.InventoryEntity;
import com.altisource.circus.query.QueryActs;
import com.altisource.circus.query.QueryInventory;
import com.altisource.circus.query.QueryLivestock;
import com.altisource.circus.query.impl.QueryActsAnimalIdImpl;
import com.mysema.query.Tuple;
import com.mysema.query.sql.SQLBindings;
import com.mysema.query.sql.SQLSubQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.sql.UniVerseTemplates;
import com.mysema.query.sql.dml.SQLInsertClause;
import com.mysema.query.sql.dml.SQLUpdateClause;
import com.mysema.query.sql.universe.UniVerseQuery;
import com.mysema.query.types.expr.MultiValueNumberList;

/**
 * @author Steve Pitschke
 */
public class DoUpdateActs {

    public static void main(String[] args) throws Exception {
    	
        Class.forName("com.rs.u2.jdbc.UniJDBCDriver");
        String url = "jdbc:rs-u2://localhost/C:/U2/UV/HS.ADMIN;dbmstype=UNIVERSE";
        Connection conn = DriverManager.getConnection(url, "ASCORP\\pitschke", "Ora1nge++");
        
        QueryActs acts = new QueryActs("c");

        SQLTemplates dialect = new UniVerseTemplates(); // SQL-dialect
        SQLUpdateClause update = new SQLUpdateClause(conn, dialect, acts);
        
        update.set(acts.equipCode, new MultiValueNumberList(43, 22))
        	.where(acts.description.like("The%"));
        
        SQLBindings sql = update.getSQL().get(0);
        String str = sql.getSQL();
        System.out.println(str);
        
        update.execute();
        conn.close();
    }
}