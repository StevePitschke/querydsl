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
package com.mysema.query.sql;

import java.sql.Types;

import com.mysema.query.types.Ops;

/**
 * HSQLDBTemplates is an SQL dialect for HSQLDB
 *
 * @author tiwe
 *
 */
public class UniVerseTemplates extends SQLTemplates {

    @SuppressWarnings("FieldNameHidesFieldInSuperclass") //Intentional
    public static final UniVerseTemplates DEFAULT = new UniVerseTemplates();

    public static Builder builder() {
        return new Builder() {
            @Override
            protected SQLTemplates build(char escape, boolean quote) {
                return new UniVerseTemplates(escape, quote);
            }
        };
    }

    public UniVerseTemplates() {
        this('\\', false);
    }

    public UniVerseTemplates(boolean quote) {
        this('\\', quote);
    }

    public UniVerseTemplates(char escape, boolean quote) {
        super("'", escape, quote);
        setLimitRequired(false);
        add(Ops.TRIM, "trim(both from {0})");
        add(Ops.NEGATE, "{0} * -1", 7);
        add(Ops.LIKE, "{0} like {1}", 26);

        addTypeNameToCode("character", Types.CHAR, true);
        addTypeNameToCode("float", Types.DOUBLE, true);
        addTypeNameToCode("real", Types.DOUBLE);
        addTypeNameToCode("nvarchar", Types.VARCHAR);
    }

    @Override
    public String getCastTypeNameForCode(int code) {
        if (code == Types.VARCHAR) {
            return "varchar(10)";
        } else {
            return super.getCastTypeNameForCode(code);
        }
    }

	/* (non-Javadoc)
	 * @see com.mysema.query.sql.SQLTemplates#quoteIdentifier(java.lang.String, boolean)
	 */
	@Override
	public String quoteIdentifier(String identifier, boolean precededByDot) {
		return identifier;
	}

	@Override
	public boolean usePreparedStatement() {
		return false;
	}
}
