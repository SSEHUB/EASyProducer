package net.ssehub.easy.varModel.cstEvaluation;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.pool.IPoolManager;
import net.ssehub.easy.basics.pool.Pool;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.model.values.ValueFactory;

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
            IDatatype declType = DerivedDatatype.resolveToBasis(decl.getType());
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
                    new CollectionElementVariable(decl, contained, variable.getResolutionPath(), index));
            }
        } catch (ValueDoesNotMatchTypeException e) {
            result = null;
        }
        return result;
    }

}
