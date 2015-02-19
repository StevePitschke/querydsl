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

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.mysema.query.types.ConstantImpl;
import com.mysema.query.types.Expression;
import com.mysema.query.types.Visitor;

/**
 * @author Steve Pitschke
 * @param <T>
 */
public class MultiValueStringList extends MultiValueList<String> {

	private static final long serialVersionUID = -5280847437593738599L;
	
    private final ImmutableList<Expression<String>> args;
    
    public MultiValueStringList(Expression<String>...args) {
    	this(ImmutableList.<Expression<String>>copyOf(args));
    }
    
    public MultiValueStringList(ImmutableList<Expression<String>> args) {
		this.args = args;
	}

	public MultiValueStringList(String... args) {
		this.args = ImmutableList.copyOf(convertToExpressions(args));
	}

     public final Expression<String> getArg(int index) {
        return getArgs().get(index);
    }

    public final List<Expression<String>> getArgs() {
        return args;
    }

	@Override
	public <R, C> R accept(Visitor<R, C> v, C context) {
        return v.visit(this, context);
	}

    private static Expression<String>[] convertToExpressions(String... args) {
        Expression<?>[] exprs = new Expression<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            exprs[i] = new ConstantImpl(args[i]);
        }
        return (Expression<String>[])exprs;
    }
}
