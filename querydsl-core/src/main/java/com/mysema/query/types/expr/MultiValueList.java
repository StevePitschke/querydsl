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

import com.mysema.query.types.Expression;
import com.mysema.query.types.Visitor;

/**
 * @author Steve Pitschke
 * @param <T>
 */
public interface MultiValueList<E> extends Expression<E> {
	
	Expression<?> getArg(int i);

    List<Expression<E>> getArgs();

	@Override
	<R, C> R accept(Visitor<R, C> v, C context);

	@Override
	Class<E> getType();

}
