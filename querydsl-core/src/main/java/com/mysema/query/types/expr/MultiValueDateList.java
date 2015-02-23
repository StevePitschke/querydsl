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
 * @param <T>
 */
public class MultiValueDateList extends MultiValueList<Date> {

	private static final long serialVersionUID = -5280847437593738599L;

    private final ImmutableList<Expression<Date>> args;
    
    public MultiValueDateList(Expression<Date>...args) {
    	this(ImmutableList.<Expression<Date>>copyOf(args));
    }
    
    public MultiValueDateList(ImmutableList<Expression<Date>> args) {
		this.args = args;
	}

	public MultiValueDateList(Date... args) {
		this.args = ImmutableList.copyOf(convertToExpressions(args));
	}

     public final Expression<Date> getArg(int index) {
        return getArgs().get(index);
    }

    public final List<Expression<Date>> getArgs() {
        return args;
    }

	@Override
	public <R, C> R accept(Visitor<R, C> v, C context) {
        return v.visit(this, context);
	}

    private static Expression<Date>[] convertToExpressions(Date... args) {
        Expression<?>[] exprs = new Expression<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            exprs[i] = new ConstantImpl(args[i]);
        }
        return (Expression<Date>[])exprs;
    }
}