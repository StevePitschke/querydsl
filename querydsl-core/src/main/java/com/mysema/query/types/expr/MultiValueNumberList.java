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
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mysema.query.types.ConstantImpl;
import com.mysema.query.types.Expression;
import com.mysema.query.types.Visitor;


/**
 * @author Steve Pitschke
 * @param <E>
 */
public class MultiValueNumberList<E extends Number> extends MultiValueList<E> {

	private static final long serialVersionUID = -5280847437593738599L;

    private final Class<E> elementType;

    private final ImmutableList<Expression<E>> args;
    
    public MultiValueNumberList(Expression<E>...args) {
    	this((Class<E>)args[0].getType(), ImmutableList.copyOf(args));
    }
    
    public MultiValueNumberList(Class<E> elementType, Expression<E>...args) {
    	this(elementType, ImmutableList.<Expression<E>>copyOf(args));
    }
    
    public MultiValueNumberList(Class<E> elementType, ImmutableList<Expression<E>> args) {
    	this.elementType = elementType;
		this.args = args;
	}

    @SuppressWarnings("unchecked")
	@SafeVarargs
	public MultiValueNumberList(E... args) {
		this.elementType = (Class<E>)args[0].getClass();
		this.args = ImmutableList.copyOf(convertToExpressions(args));
	}

	public final Expression<E> getArg(int index) {
        return getArgs().get(index);
    }

    public final List<Expression<E>> getArgs() {
        return args;
    }

	@Override
	public <R, C> R accept(Visitor<R, C> v, C context) {
        return v.visit(this, context);
	}

    private static <T extends Number> Expression<T>[] convertToExpressions(T... args) {
        Expression<?>[] exprs = new Expression<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof Expression) {
                exprs[i] = (Expression)args[i];
            } else {
                exprs[i] = new ConstantImpl(args[i]);
            }
        }
        return (Expression<T>[])exprs;
    }
}
