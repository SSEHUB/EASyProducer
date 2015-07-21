package de.uni_hildesheim.sse.easy_producer.instantiator.model.common;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.AbstractCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IArgumentProvider;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IMetaOperation;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Represents the explicit execution of a model operation.
 * 
 * @param <V> the actual type of variable
 * @param <M> the actual model type
 * @param <O> the actual operation type
 * 
 * @author Holger Eichelberger
 */
public abstract class ModelCallExpression<V extends IResolvable, M extends IResolvableModel<V>, 
    O extends IResolvableOperation<V>> extends AbstractCallExpression implements IArgumentProvider {

    protected O resolved;
    private M model;
    private CallArgument[] arguments;
    private boolean isSuper;

    /**
     * Creates a new model call expression.
     * 
     * @param model the actual model to resolve the operation on
     * @param isSuper this is a super call
     * @param name the name of the operation
     * @param arguments the actual arguments
     * @throws VilException in case of illegal (qualified) names
     */
    public ModelCallExpression(M model, boolean isSuper, String name, CallArgument... arguments) 
        throws VilException {
        super(name, true);
        this.model = model;
        this.isSuper = isSuper;
        this.arguments = arguments;
    }
    
    /**
     * Creates a new model call expression for a known operation.
     * 
     * @param model the actual model <code>resolved</code> belongs to
     * @param resolved the resolved operation
     * @param arguments the actual arguments
     * @throws VilException in case of illegal (qualified) names
     */
    protected ModelCallExpression(M model, O resolved, CallArgument...arguments) throws VilException {
        this(model, false, resolved.getName(), arguments);
        this.resolved = resolved;
    }
    
    /**
     * Returns whether this call is a super script call.
     * 
     * @return <code>true</code> if is a super script call, <code>false</code> else
     */
    public boolean isSuper() {
        return isSuper;
    }
    
    /**
     * Returns the number of arguments.
     * 
     * @return the number of arguments
     */
    public int getArgumentsCount() {
        return null == arguments ? 0 : arguments.length;
    }
    
    /**
     * Returns the specified argument.
     * 
     * @param index the 0-based index of the argument to return
     * @return the argument
     * @throws IndexOutOfBoundsException in case that 
     *   <code>index &lt; 0 || index &gt;={@link #getArgumentsCount()}</code>
     */
    public CallArgument getArgument(int index) {
        if (null == arguments) {
            throw new IndexOutOfBoundsException();
        }
        return arguments[index];
    }
    
    /**
     * Returns the owning model.
     * 
     * @return the owning model
     */
    public M getModel() {
        return model;
    }
    
    /**
     * Changes the owning model. Required, if a temporary model was used
     * for resolution, e.g., in case of recursive calls.
     * 
     * @param model the new model (<b>null</b> will be ignored)
     */
    void setModel(M model) {
        if (null != model) {
            this.model = model;
        }
    }
    
    /**
     * Returns the resolved operation. {@link #inferType()} must be called before.
     * 
     * @return the resolved operation or <b>null</b> if {@link #inferType()} was not called before or the operation 
     *   cannot be resolved
     */
    public O getResolved() {
        return resolved;
    }

    /**
     * Returns the actual operation class, i.e., the class of the operation.
     * 
     * @return the operation class
     */
    protected abstract Class<? extends O> getOperationClass();

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        if (null == resolved) {
            IMetaOperation op = resolveOperation(model, getName(), arguments);
            Class<? extends O> opClass = getOperationClass();
            if (opClass.isInstance(op)) {
                resolved = opClass.cast(op);
            } else {
                throw new VilException(getInvalidOperationMessage(op), 
                    VilException.ID_CANNOT_RESOLVE);
            }
        }
        return resolved.getReturnType();
    }

    /**
     * Returns the message to be returned in case of an invalid operation.
     * 
     * @param op the invalid operation
     * @return the related message
     */
    protected String getInvalidOperationMessage(IMetaOperation op) {
        return op.getJavaSignature() + " is not a valid operation";
    }
    
    @Override
    public boolean isPlaceholder() {
        return isPlaceholder(resolved);
    }

    @Override
    public String getVilSignature() {
        return getVilSignature(resolved);
    }
    
}
