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
import com.mysema.query.types.path.MultiValueNumberListPath;

/**
 * NumberExpression represents a numeric expression
 *
 * @author tiwe
 *
 * @param <E> expression type
 * @see java.lang.Number
 */
public interface MultiValueNumberListExpression<E extends Number & Comparable<?>, Q extends SimpleExpression<? super E>> {

    /**
     * Get the absolute value of this expression
     *
     * @return abs(this)
     */
	NumberExpression<E> abs();

    /**
     * Get the sum of this and right
     *
     * @param right
     * @return this + right
     */
	NumberExpression<E> add(Expression<E> right);

    /**
     * Get the sum of this and right
     *
     * @param right
     * @return this + right
     */
	NumberExpression<E> add(E right);

    /**
     * Get the sum of this and right
     *
     * @param right
     * @return this + right
     */
	<N extends MultiValueNumberListPath<E, Q>> NumberExpression<E> add(N right);

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
    
   /*  
    * Get the square root of this numeric expressions
    *
    * @return sqrt(this)
    */
   NumberExpression<Double> sqrt();

   /**
    * Get the difference of this and right
    *
    * @param right
    * @return this - right<E>
    */
   NumberExpression<E> subtract(Expression<E> right);

   /**
    * Get the difference of this and right
    *
    * @param right
    * @return this - right
    */
   NumberExpression<E> subtract(E right);

   /**
    * Get the sum of this and right
    *
    * @param right
    * @return this + right
    */
	<N extends MultiValueNumberListPath<E, Q>> NumberExpression<E> subtract(N right);

   /**
    * Get the sum of this expression (aggregation)
    *
    * @return sum(this)
    */;
   NumberExpression<E> sum();
}
