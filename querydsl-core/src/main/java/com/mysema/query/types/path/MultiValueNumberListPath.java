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
import com.mysema.query.types.Ops.MathOps;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.BooleanOperation;
import com.mysema.query.types.expr.MultiValueNumberListExpression;
import com.mysema.query.types.expr.NumberExpression;
import com.mysema.query.types.expr.NumberOperation;
import com.mysema.query.types.expr.SimpleExpression;
import com.mysema.util.MathUtils;

/**
 * @author Steve Pitschke
 */
public class MultiValueNumberListPath<E extends Number & Comparable<?>, Q extends SimpleExpression<? super E>> extends CollectionPathBase<List<E>, E, Q> 
	implements MultiValueNumberListExpression<E, Q>, MultiValueListPath {

	private static final long serialVersionUID = -1873958849624881622L;

    private final Class<E> elementType;

    private final MultiValueNumberListPath<E, Q> pathMixin;
    
    private final PathImpl<List<E>> parentMixin;
    
    private final Class<Q> queryType;

    @Nullable
    private transient Q any;
    
    @Nullable
    private volatile NumberExpression<E> abs, sum;

    @Nullable
    private volatile NumberExpression<Double> sqrt;

    public MultiValueNumberListPath(Class<? super E> elementType, Class<Q> queryType, String variable) {
        this(elementType, queryType, PathMetadataFactory.forVariable(variable));
    }
    
    public MultiValueNumberListPath(Class<? super E> elementType, Class<Q> queryType, Path<?> parent, String property) {
        this(elementType, queryType, PathMetadataFactory.forProperty(parent, property));   
    }
    
    public MultiValueNumberListPath(Class<? super E> elementType, Class<Q> queryType, PathMetadata<?> metadata) {
        this(elementType, queryType, metadata, PathInits.DIRECT);
    }
    
    private MultiValueNumberListPath(Class<? super E> elementType, Class<Q> queryType, PathMetadata<?> metadata, MultiValueNumberListPath<E, Q> parent, PathImpl<List<E>> mixin) {
        super(new PathImpl<List<E>>((Class)List.class, metadata), PathInits.DIRECT);
        this.elementType = (Class<E>)elementType;
        this.queryType = queryType;
        this.pathMixin = parent;
        this.parentMixin = mixin;
    }
    
    @SuppressWarnings("unchecked")
    public MultiValueNumberListPath(Class<? super E> elementType, Class<Q> queryType, PathMetadata<?> metadata, PathInits inits) {
        super(new PathImpl<List<E>>((Class)List.class, metadata), inits);
        this.elementType = (Class<E>)elementType;
        this.queryType = queryType;
        this.pathMixin = new MultiValueNumberListPath<E, Q>(elementType, queryType, metadata, this, (PathImpl<List<E>>)mixin);
        this.parentMixin = (PathImpl<List<E>>)mixin;
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

    public Class<E> getElementType() {
        return elementType;
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

    @Override
    public Class<?> getParameter(int index) {
        if (index == 0) {
            return elementType;
        } else {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
    }

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueNumberListExpression#abs()
	 */
	@Override
	public NumberExpression<E> abs() {
        if (abs == null) {
            abs = NumberOperation.create(elementType, MathOps.ABS, pathMixin);
        }
        return abs;
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueNumberListExpression#add(com.mysema.query.types.Expression)
	 */
	@Override
	public NumberExpression<E> add(Expression<E> right) {
        return NumberOperation.create(elementType, Ops.ADD, pathMixin, right);
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueNumberListExpression#add(java.lang.Number)
	 */
	@Override
	public NumberExpression<E> add(E right) {
        return NumberOperation.create(elementType, Ops.ADD, pathMixin, ConstantImpl.create(cast(right)));
	}

	@Override
	public <N extends MultiValueNumberListPath<E, Q>> NumberExpression<E> add(N right) {
        return NumberOperation.create(elementType, Ops.ADD, pathMixin, right);
	}

	@Override
	public <A extends Number & Comparable<?>> BooleanExpression goe(A right) {
        return goe(ConstantImpl.create(cast(right)));
	}

	@Override
	public <A extends Number & Comparable<?>> BooleanExpression goe(Expression<A> right) {
        return BooleanOperation.create(Ops.GOE, pathMixin, right);
	}

	@Override
	public <A extends Number & Comparable<?>> BooleanExpression gt(A right) {
        return gt(ConstantImpl.create(cast(right)));
	}

	@Override
	public <A extends Number & Comparable<?>> BooleanExpression gt(Expression<A> right) {
        return BooleanOperation.create(Ops.GT, pathMixin, right);
	}

	@Override
	public <A extends Number & Comparable<?>> BooleanExpression between(A from, A to) {
        if (from == null) {
            if (to != null) {
                return loe(to);
            } else {
                throw new IllegalArgumentException("Either from or to needs to be non-null");
            }
        } else if (to == null) {
            return goe(from);
        } else {
            return between(ConstantImpl.create(cast(from)), ConstantImpl.create(cast(to)));
        }
	}

	@Override
	public <A extends Number & Comparable<?>> BooleanExpression between(Expression<A> from, Expression<A> to) {
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

	@Override
	public <A extends Number & Comparable<?>> BooleanExpression notBetween(A from, A to) {
        return between(from, to).not();
	}

	@Override
	public <A extends Number & Comparable<?>> BooleanExpression notBetween(Expression<A> from, Expression<A> to) {
        return between(from, to).not();
	}

	@Override
	public BooleanExpression like(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BooleanExpression like(Expression<String> str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <A extends Number & Comparable<?>> BooleanExpression loe(A right) {
        return loe(ConstantImpl.create(cast(right)));
	}

	@Override
	public <A extends Number & Comparable<?>> BooleanExpression loe(Expression<A> right) {
        return BooleanOperation.create(Ops.LOE, pathMixin, right);
	}

	@Override
	public <A extends Number & Comparable<?>> BooleanExpression lt(A right) {
        return lt(ConstantImpl.create(cast(right)));
	}

	@Override
	public <A extends Number & Comparable<?>> BooleanExpression lt(Expression<A> right) {
        return BooleanOperation.create(Ops.LT, pathMixin, right);
	}

	@Override
	public <A extends Number & Comparable<?>> BooleanExpression eq(A right) {
        return eq(ConstantImpl.create(cast(right)));
	}

	@Override
	public <A extends Number & Comparable<?>> BooleanExpression eq(Expression<A> right) {
        return BooleanOperation.create(Ops.EQ, pathMixin, right);
	}

    private E cast(Number num) {    	
    	return MathUtils.cast(num, elementType);
    }

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueNumberListExpression#sqrt()
	 */
	@Override
	public NumberExpression<Double> sqrt() {
        if (sqrt == null) {
            sqrt = NumberOperation.create(Double.class, MathOps.SQRT, pathMixin);
        }
        return sqrt;
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueNumberListExpression#subtract(com.mysema.query.types.Expression)
	 */
	@Override
	public NumberExpression<E> subtract(Expression<E> right) {
        return NumberOperation.create(elementType, Ops.SUB, pathMixin, right);
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueNumberListExpression#subtract(java.lang.Number)
	 */
	@Override
	public NumberExpression<E> subtract(E right) {
        return NumberOperation.create(elementType, Ops.SUB, pathMixin, ConstantImpl.create(cast(right)));
	}

	@Override
	public <N extends MultiValueNumberListPath<E, Q>> NumberExpression<E> subtract(N right) {
        return NumberOperation.create(elementType, Ops.SUB, pathMixin, right);
	}

	/* (non-Javadoc)
	 * @see com.mysema.query.types.expr.MultiValueNumberListExpression#sum()
	 */
	@Override
	public NumberExpression<E> sum() {
        if (sum == null) {
            sum = NumberOperation.create(elementType, Ops.AggOps.SUM_AGG, pathMixin);
        }
        return sum;
	}
}
