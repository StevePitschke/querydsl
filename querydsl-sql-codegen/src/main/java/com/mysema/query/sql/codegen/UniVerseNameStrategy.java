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

/**
 * @author Steve Pitschke
 */
public class UniVerseNameStrategy extends DefaultNamingStrategy {

    @Override
    public String normalizeTableName(String tableName) {
        if (tableName != null) {
            tableName = tableName.replaceAll("\r", "").replaceAll("\n", " ");
            int periodT = tableName.indexOf(".T");
            if (periodT > 0) {
            	tableName = tableName.substring(0, periodT) +
            		((periodT == tableName.length() - 2) ? "" : tableName.substring(periodT + 2));
            }
            return tableName;
        } else {
            return null;
        }
    }
}
