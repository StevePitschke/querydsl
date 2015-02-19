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

import java.util.ArrayList;
import java.util.List;

import com.mysema.query.types.Expression;
import com.mysema.query.types.Path;

/**
 * @author Steve Pitschke
 * @param <T>
 */
public abstract class MultiValueList<E> implements Expression<List<E>> {
	
	private static final long serialVersionUID = 5082526845087177862L;
	
	private List<E> type = new ArrayList<E>(0);
	
	private Path<?> lhs = null;

	public abstract Expression<?> getArg(int i);

	public abstract List<Expression<E>> getArgs();
	
	public final void setLhs(Path<?> lhs) {
		this.lhs = lhs;
	}
	
	public final Path<?> getLhs() {
		return lhs;
	}

    @Override
    public final Class<? extends List<E>> getType() {
        return (Class<? extends List<E>>) type.getClass();
    }
}
