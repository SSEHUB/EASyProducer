package de.uni_hildesheim.sse.model.cstEvaluation;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.ICollectionElementVariable;
import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.pool.IPoolManager;
import de.uni_hildesheim.sse.utils.pool.Pool;

/**
 * Implements an accessor for index access. May lead to a constant value after evaluation.
 * 
 * @author Holger Eichelberger
 */
class IndexAccessor extends AbstractDecisionVariableEvaluationAccessor {

    public static final Pool<IndexAccessor> POOL = new Pool<IndexAccessor>(new IPoolManager<IndexAccessor>() {

        public IndexAccessor create() {
            return new IndexAccessor();
        }

        public void clear(IndexAccessor instance) {
            instance.clear();
        }
    });
    
    private int index;
    
    /**
     * Creates an instance. Private due to pooling.
     */
    private IndexAccessor() {
    }
    
    /**
     * Binds this accessor.
     * 
     * @param variable the underlying variable
     * @param context the evaluation context
     * @param index the index into the variable
     * @return <b>this</b> (builder pattern)
     */
    protected IndexAccessor bind(IDecisionVariable variable, EvaluationContext context, int index) {
        super.bind(variable, context);
        this.index = index;
        return this;
    }
    
    @Override
    public Value getValue() {
        Value result = null;
        IDecisionVariable variable = getVariable();
        if (Container.TYPE.isAssignableFrom(variable.getDeclaration().getType())) {
            ContainerValue value = (ContainerValue) variable.getValue();
            if (null != value) {
                result = ((ContainerValue) variable.getValue()).getElement(index);
            }
        }
        return result;
    }

    @Override
    public boolean setValue(Value value) {
        boolean done = false;
        IDecisionVariable variable = getVariable();
        if (Container.TYPE.isAssignableFrom(variable.getDeclaration().getType())) {
            ContainerValue val = (ContainerValue) variable.getValue();
            if (null != val) {
                try {
                    val.setValue(index, value);
                    done = true;
                } catch (ValueDoesNotMatchTypeException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(IndexAccessor.class, Bundle.ID).exception(e);
                }
            }
        }
        return done;
    }
    
    @Override
    public boolean isAssignable() {
        return true;
    }

    @Override
    public void release() {
        POOL.releaseInstance(this);
    }
    
    @Override
    public Value getReferenceValue() {
        Value result;
        try {
            IDecisionVariable variable = getVariable();
            AbstractVariable decl = variable.getDeclaration();
            IDatatype declType = decl.getType();
            IDatatype contained;
            if (Container.TYPE.isAssignableFrom(declType)) {
                contained = ((Container) declType).getContainedType();
            } else {
                contained = declType;
            }
            if (Reference.TYPE.isAssignableFrom(contained)) {
                // avoid accidental references of references
                result = ((ContainerValue) variable.getValue()).getElement(index);
            } else {
                result = ValueFactory.createValue(new Reference("", contained, null), 
                    new CollectionElementVariable(decl, contained, index));
            }
        } catch (ValueDoesNotMatchTypeException e) {
            result = null;
        }
        return result;
    }
    
    /**
     * A temporary variable representing a value of a container. By design decision, container 
     * do not have contained decision variables. Anyway, references to container variables can
     * be defined and are resolved via this temporary variable.
     * 
     * @author Holger Eichelberger
     */
    private static class CollectionElementVariable extends AbstractVariable implements ICollectionElementVariable {
        
        private AbstractVariable base;
        private int index;
        
        /**
         * Creates a collection element variable.
         * 
         * @param base the base the collection variable
         * @param type the contained type
         * @param index the index within <code>base</code>
         */
        CollectionElementVariable(AbstractVariable base, IDatatype type, int index) {
            super(String.valueOf(index), type, base);
            this.base = base;
            this.index = index;
        }

        @Override
        public int getAttributesCount() {
            return base.getAttributesCount();
        }

        @Override
        public Attribute getAttribute(String name) {
            return base.getAttribute(name);
        }

        @Override
        public Attribute getAttribute(int index) {
            return base.getAttribute(index);
        }

        @Override
        public void accept(IModelVisitor visitor) {
            // nothing to visit
        }

        @Override
        public int getIndex() {
            return index;
        }

        @Override
        public AbstractVariable getBaseVariable() {
            return base;
        }

        @Override
        public boolean isTemporaryVariable() {
            return false;
        }

        @Override
        public boolean isAttribute() {
            return false;
        }
        
    }

}
