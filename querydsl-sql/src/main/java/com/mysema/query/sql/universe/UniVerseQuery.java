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
package com.mysema.query.sql.universe;

import java.sql.Connection;

import com.mysema.query.DefaultQueryMetadata;
import com.mysema.query.QueryFlag.Position;
import com.mysema.query.QueryMetadata;
import com.mysema.query.sql.AbstractSQLQuery;
import com.mysema.query.sql.Configuration;
import com.mysema.query.sql.MySQLTemplates;
import com.mysema.query.sql.SQLQuery;
import com.mysema.query.sql.SQLTemplates;
import com.mysema.query.types.expr.BooleanExpression;

/**
 * UniVerseQuery provides UniVerse related extensions to SQLQuery
 *
 * @author tiwe
 * @see SQLQuery
 *
 */
public class UniVerseQuery extends AbstractSQLQuery<UniVerseQuery> {

    private static final String WHEN = "\nwhen ";

    public UniVerseQuery(Connection conn) {
        this(conn, new Configuration(new MySQLTemplates()), new DefaultQueryMetadata());
    }

    public UniVerseQuery(Connection conn, SQLTemplates templates) {
        this(conn, new Configuration(templates), new DefaultQueryMetadata());
    }

    public UniVerseQuery(Connection conn, Configuration configuration) {
        this(conn, configuration, new DefaultQueryMetadata());
    }

    public UniVerseQuery(Connection conn, Configuration configuration, QueryMetadata metadata) {
        super(conn, configuration, metadata);
    }

    /**
     * @return
     */
    public UniVerseQuery when(BooleanExpression whenClause) {
        return addFlag(Position.BEFORE_GROUP_BY, WHEN, whenClause);
    }

    @Override
    public UniVerseQuery clone(Connection conn) {
        UniVerseQuery q = new UniVerseQuery(conn, getConfiguration(), getMetadata().clone());
        q.clone(this);
        return q;
    }
    
}
