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

package com.mysema.query.types.path;

import java.lang.reflect.AnnotatedElement;
import java.sql.Date;
import java.util.List;

import javax.annotation.Nullable;

import com.mysema.query.types.ConstantImpl;
import com.mysema.query.types.Expression;
import com.mysema.query.types.Ops;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathImpl;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.PathMetadataFactory;
import com.mysema.query.types.Visitor;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.BooleanOperation;
import com.mysema.query.types.expr.MultiValueDateListExpression;
import com.mysema.query.types.expr.SimpleExpression;

/**
 * @author Steve Pitschke
 */
public class MultiValueDateListPath<Q extends SimpleExpression<Date>> extends CollectionPathBase<List<Date>, Date, Q>
	implements MultiValueDateListExpression<SimpleExpression<Date>>, MultiValueListPath {

	private static final long serialVersionUID = -1873958849624881622L;

    private final MultiValueDateListPath<Q> pathMixin;

    private final PathImpl<List<Date>> parentMixin;
    
    private final Class<Q> queryType;

    @Nullable
    private transient Q any;    

    public MultiValueDateListPath(Class<Q> queryType, String variable) {
        this(queryType, PathMetadataFactory.forVariable(variable));
    }
    
    public MultiValueDateListPath(Class<Q> queryType, Path<?> parent, String property) {
        this(queryType, PathMetadataFactory.forProperty(parent, property));   
    }
    
    public MultiValueDateListPath(Class<Q> queryType, PathMetadata<?> metadata) {
        this(queryType, metadata, PathInits.DIRECT);
    }
    
    private MultiValueDateListPath(Class<Q> queryType, PathMetadata<?> metadata, MultiValueDateListPath<Q> parent, PathImpl<List<Date>> mixin) {
        super(new PathImpl<List<Date>>((Class)List.class, metadata), PathInits.DIRECT);
        this.queryType = queryType;
        this.pathMixin = parent;
        this.parentMixin = mixin;
    }
    
    @SuppressWarnings("unchecked")
    public MultiValueDateListPath(Class<Q> queryType, PathMetadata<?> metadata, PathInits inits) {
        super(new PathImpl<List<Date>>((Class)List.class, metadata), inits);
        this.queryType = queryType;
        this.pathMixin = new MultiValueDateListPath<Q>(queryType, metadata, this, (PathImpl<List<Date>>)mixin);
        this.parentMixin = (PathImpl<List<Date>>)mixin;
    }
    
    @Override
    public final <R,C> R accept(Visitor<R,C> v, C context) {
        return v.visit(pathMixin, context);
    }
    
    @Override
    public Q any() {
        if (any == null) {
            any = newInstance(queryType, PathMetadataFactory.forCollectionAny(this));
        }
        return any;
    }

    protected PathMetadata<Integer> forListAccess(int index) {
        return PathMetadataFactory.forListAccess(this, index);
    }

    protected PathMetadata<Integer> forListAccess(Expression<Integer> index) {
        return PathMetadataFactory.forListAccess(this, index);
    }

    private Q create(int index) {
        PathMetadata<Integer> md = forListAccess(index);
        return newInstance(queryType, md);
    }

    public Class<Date> getElementType() {
        return Date.class;
    }

    @Override
    public PathMetadata<?> getMetadata() {
        return parentMixin.getMetadata();
    }

    @Override
    public Path<?> getRoot() {
        return parentMixin.getRoot();
    }

    @Override
    public AnnotatedElement getAnnotatedElement() {
        return pathMixin.getAnnotatedElement();
    }

    /* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueDateListExpression#goe(java.sql.Date)
	 */
	@Override
	public BooleanExpression goe(Date right) {
        return goe(ConstantImpl.create(right));
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueDateListExpression#goe(com.mysema.query.types.Expression)
	 */
	@Override
	public BooleanExpression goe(Expression<Date> right) {
        return BooleanOperation.create(Ops.GOE, pathMixin, right);
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueDateListExpression#gt(java.sql.Date)
	 */
	@Override
	public BooleanExpression gt(Date right) {
        return gt(ConstantImpl.create(right));
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueDateListExpression#gt(com.mysema.query.types.Expression)
	 */
	@Override
	public BooleanExpression gt(Expression<Date> right) {
        return BooleanOperation.create(Ops.GT, pathMixin, right);
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueDateListExpression#between(java.sql.Date, java.sql.Date)
	 */
	@Override
	public BooleanExpression between(Date from, Date to) {
        if (from == null) {
            if (to != null) {
                return loe(to);
            } else {
                throw new IllegalArgumentException("Either from or to needs to be non-null");
            }
        } else if (to == null) {
            return goe(from);
        } else {
            return between(ConstantImpl.create(from), ConstantImpl.create(to));
        }
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueDateListExpression#between(com.mysema.query.types.Expression, com.mysema.query.types.Expression)
	 */
	@Override
	public BooleanExpression between(Expression<Date> from, Expression<Date> to) {
        if (from == null) {
            if (to != null) {
                return BooleanOperation.create(Ops.LOE, pathMixin, to);
            } else {
                throw new IllegalArgumentException("Either from or to needs to be non-null");
            }
        } else if (to == null) {
            return BooleanOperation.create(Ops.GOE, pathMixin, from);
        } else {
            return BooleanOperation.create(Ops.BETWEEN, pathMixin, from, to);
        }
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueDateListExpression#notBetween(java.sql.Date, java.sql.Date)
	 */
	@Override
	public BooleanExpression notBetween(Date from, Date to) {
		return between(from, to).not();
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueDateListExpression#notBetween(com.mysema.query.types.Expression, com.mysema.query.types.Expression)
	 */
	@Override
	public BooleanExpression notBetween(Expression<Date> from, Expression<Date> to) {
		return between(from, to).not();
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueDateListExpression#loe(java.sql.Date)
	 */
	@Override
	public BooleanExpression loe(Date right) {
        return loe(ConstantImpl.create(right));
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueDateListExpression#loe(com.mysema.query.types.Expression)
	 */
	@Override
	public BooleanExpression loe(Expression<Date> right) {
        return BooleanOperation.create(Ops.LOE, pathMixin, right);
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueDateListExpression#lt(java.sql.Date)
	 */
	@Override
	public BooleanExpression lt(Date right) {
        return lt(ConstantImpl.create(right));
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueDateListExpression#lt(com.mysema.query.types.Expression)
	 */
	@Override
	public BooleanExpression lt(Expression<Date> right) {
        return BooleanOperation.create(Ops.LT, pathMixin, right);
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueDateListExpression#eq(java.sql.Date)
	 */
	@Override
	public BooleanExpression eq(Date right) {
        return eq(ConstantImpl.create(right));
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueDateListExpression#eq(com.mysema.query.types.Expression)
	 */
	@Override
	public BooleanExpression eq(Expression<Date> right) {
        return BooleanOperation.create(Ops.EQ, pathMixin, right);
	}

	@Override
    public Class<?> getParameter(int index) {
        return java.sql.Date.class;
    }
}
