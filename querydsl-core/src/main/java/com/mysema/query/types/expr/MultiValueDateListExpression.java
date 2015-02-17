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

package com.mysema.query.types.expr;

import java.sql.Date;

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
public interface MultiValueDateListExpression<Q extends SimpleExpression<Date>> {

    /**
     * Create a {@code this >= right} expression
     *
     * @param right rhs of the comparison
     * @return {@code this >= right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    BooleanExpression goe(Date right);

    /**
     * Create a {@code this >= right} expression
     *
     * @param right rhs of the comparison
     * @return {@code this >= right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    BooleanExpression goe(Expression<Date> right);

    /**
     * Create a {@code this > right} expression
     *
     * @param right rhs of the comparison
     * @return {@code this > right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    BooleanExpression gt(Date right);

    /**
     * Create a {@code this > right} expression
     *
     * @param right rhs of the comparison
     * @return {@code this > right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    BooleanExpression gt(Expression<Date> right);

    /**
     * Create a {@code from <= this <= to} expression
     *
     * @param from
     * @param to
     * @return
     */
    BooleanExpression between(@Nullable Date from, @Nullable Date to);

    /**
     * Create a {@code from <= this <= to} expression
     *
     * @param from
     * @param to
     * @return
     */
    BooleanExpression between(@Nullable Expression<Date> from, @Nullable Expression<Date> to);

    /**
     * @param from
     * @param to
     * @return
     */
    BooleanExpression notBetween(Date from, Date to);

    /**
     * @param from
     * @param to
     * @return
     */
    BooleanExpression notBetween(Expression<Date> from, Expression<Date> to);

    /**
     * Create a {@code this <= right} expression
     *
     * @param right rhs of the comparison
     * @return {@code this <= right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    BooleanExpression loe(Date right);

    /**
     * Create a {@code this <= right} expression
     *
     * @param right rhs of the comparison
     * @return {@code this <= right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    BooleanExpression loe(Expression<Date> right);

    /**
     * Create a {@code this < right} expression
     *
     * @param right rhs of the comparison
     * @return {@code this < right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    BooleanExpression lt(Date right);

    /**
     * Create a {@code this < right} expression
     *
     * @param right rhs of the comparison
     * @return {@code this < right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    BooleanExpression lt(Expression<Date> right);

    /**
     * Create a {@code this = right} expression
     *
     * @param right rhs of the comparison
     * @return {@code this < right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    BooleanExpression eq(Date right);

    /**
     * Create a {@code this = right} expression
     *
     * @param right rhs of the comparison
     * @return {@code this < right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    BooleanExpression eq (Expression<Date> right);
}
