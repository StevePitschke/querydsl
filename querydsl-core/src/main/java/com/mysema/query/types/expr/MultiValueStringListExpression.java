/*
 * Copyright 2011, Mysema Ltd
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
package com.mysema.query.types.expr;

import javax.annotation.Nullable;

import com.mysema.query.types.Expression;

/**
 * NumberExpression represents a numeric expression
 *
 * @author tiwe
 *
 * @param <T> expression type
 * @see java.lang.Number
 */
public interface MultiValueStringListExpression<Q extends SimpleExpression<String>> {

    /**
     * Expr: {@code this like str}
     *
     * @param str
     * @return
     */
    BooleanExpression like(String str);

    /**
     * Expr: {@code this like str}
     *
     * @param str
     * @return
     */
    BooleanExpression like(Expression<String> str);

    /**
     * Create a {@code this = right} expression
     *
     * @param <A>
     * @param right rhs of the comparison
     * @return {@code this < right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    BooleanExpression eq(String right);

    /**
     * Create a {@code this = right} expression
     *
     * @param <A>
     * @param right rhs of the comparison
     * @return {@code this < right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    BooleanExpression eq (Expression<String> right);
}
