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
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.BooleanOperation;
import com.mysema.query.types.expr.MultiValueStringListExpression;
import com.mysema.query.types.expr.SimpleExpression;

/**
 * @author Steve Pitschke
 */
public class MultiValueStringListPath<Q extends SimpleExpression<String>> extends CollectionPathBase<List<String>, String, Q> 
	implements MultiValueStringListExpression<SimpleExpression<String>>, MultiValueListPath {

	private static final long serialVersionUID = -1873958849624881622L;

    private final MultiValueStringListPath<Q> pathMixin;

    private final PathImpl<List<String>> parentMixin;

    private final Class<Q> queryType;

    @Nullable
    private transient Q any;    

    public MultiValueStringListPath(Class<Q> queryType, java.lang.String variable) {
        this(queryType, PathMetadataFactory.forVariable(variable));
    }
    
    public MultiValueStringListPath(Class<Q> queryType, Path<?> parent, java.lang.String property) {
        this(queryType, PathMetadataFactory.forProperty(parent, property));   
    }
    
    public MultiValueStringListPath(Class<Q> queryType, PathMetadata<?> metadata) {
        this(queryType, metadata, PathInits.DIRECT);
    }
    
    private MultiValueStringListPath(Class<Q> queryType, PathMetadata<?> metadata, MultiValueStringListPath<Q> parent, PathImpl<List<String>> mixin) {
        super(new PathImpl<List<String>>((Class)List.class, metadata), PathInits.DIRECT);
        this.queryType = queryType;
        this.pathMixin = parent;
        this.parentMixin = mixin;
    }
    
    @SuppressWarnings("unchecked")
    public MultiValueStringListPath(Class<Q> queryType, PathMetadata<?> metadata, PathInits inits) {
        super(new PathImpl<List<String>>((Class)List.class, metadata), inits);
        this.queryType = queryType;
        this.pathMixin = new MultiValueStringListPath<Q>(queryType, metadata, this, (PathImpl<List<String>>)mixin);
        this.parentMixin = (PathImpl<List<String>>)mixin;
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

    public Class<String> getElementType() {
        return (Class<String>)java.lang.String.class;
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
        return java.lang.String.class;
    }

	@Override
	public BooleanExpression like(String str) {
        return BooleanOperation.create(Ops.LIKE, this, ConstantImpl.create(str));
	}

	@Override
	public BooleanExpression like(Expression<String> str) {
        return BooleanOperation.create(Ops.LIKE, mixin, str);
	}

	@Override
	public BooleanExpression eq(String str) {
        return BooleanOperation.create(Ops.EQ, this, ConstantImpl.create(str));
	}

	@Override
	public BooleanExpression eq(Expression<String> str) {
        return BooleanOperation.create(Ops.EQ, mixin, str);
	}
}
