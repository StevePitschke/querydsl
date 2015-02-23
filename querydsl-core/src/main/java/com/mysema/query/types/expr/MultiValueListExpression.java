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
public interface MultiValueListExpression<E extends Number, Q extends SimpleExpression<? super E>> {

    /**
     * Create a {@code this >= right} expression
     *
     * @param <A>
     * @param right rhs of the comparison
     * @return {@code this >= right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    <A extends Number & Comparable<?>> BooleanExpression goe(A right);

    /**
     * Create a {@code this >= right} expression
     *
     * @param <A>
     * @param right rhs of the comparison
     * @return {@code this >= right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    <A extends Number & Comparable<?>> BooleanExpression goe(Expression<A> right);

    /**
     * Create a {@code this > right} expression
     *
     * @param <A>
     * @param right rhs of the comparison
     * @return {@code this > right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    <A extends Number & Comparable<?>> BooleanExpression gt(A right);

    /**
     * Create a {@code this > right} expression
     *
     * @param <A>
     * @param right rhs of the comparison
     * @return {@code this > right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    <A extends Number & Comparable<?>> BooleanExpression gt(Expression<A> right);

    /**
     * Create a {@code from <= this <= to} expression
     *
     * @param <A>
     * @param from
     * @param to
     * @return
     */
    <A extends Number & Comparable<?>> BooleanExpression between(@Nullable A from, @Nullable A to);

    /**
     * Create a {@code from <= this <= to} expression
     *
     * @param <A>
     * @param from
     * @param to
     * @return
     */
    <A extends Number & Comparable<?>> BooleanExpression between(@Nullable Expression<A> from, @Nullable Expression<A> to);

    /**
     * @param from
     * @param to
     * @return
     */
    <A extends Number & Comparable<?>> BooleanExpression notBetween(A from, A to);

    /**
     * @param from
     * @param to
     * @return
     */
    <A extends Number & Comparable<?>> BooleanExpression notBetween(Expression<A> from, Expression<A> to);

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
     * Create a {@code this <= right} expression
     *
     * @param <A>
     * @param right rhs of the comparison
     * @return {@code this <= right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    <A extends Number & Comparable<?>> BooleanExpression loe(A right);

    /**
     * Create a {@code this <= right} expression
     *
     * @param <A>
     * @param right rhs of the comparison
     * @return {@code this <= right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    <A extends Number & Comparable<?>> BooleanExpression loe(Expression<A> right);

    /**
     * Create a {@code this < right} expression
     *
     * @param <A>
     * @param right rhs of the comparison
     * @return {@code this < right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    <A extends Number & Comparable<?>> BooleanExpression lt(A right);

    /**
     * Create a {@code this < right} expression
     *
     * @param <A>
     * @param right rhs of the comparison
     * @return {@code this < right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    <A extends Number & Comparable<?>> BooleanExpression lt(Expression<A> right);

    /**
     * Create a {@code this = right} expression
     *
     * @param <A>
     * @param right rhs of the comparison
     * @return {@code this < right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    <A extends Number & Comparable<?>> BooleanExpression eq(A right);

    /**
     * Create a {@code this = right} expression
     *
     * @param <A>
     * @param right rhs of the comparison
     * @return {@code this < right}
     * @see java.lang.Comparable#compareTo(Object)
     */
    <A extends Number & Comparable<?>> BooleanExpression eq (Expression<A> right);
}