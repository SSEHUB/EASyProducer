package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.instantiation.core.model.buildlangModel.execOperand.ExecutableOperand;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.CallExpression;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Implements a strategy call.
 * 
 * @author Holger Eichelberger
 */
public class StrategyCallExpression extends CallExpression {

    /**
     * Defines some exclusive types of strategy calls.
     * 
     * @author Holger Eichelberger
     */
    public enum Type {
        
        /**
         * A "normal" instantiator call.
         */
        INSTANTIATOR,
                
        /**
         * A system call execution.
         */
        EXECUTE;
    }
    
    private Type type;
    private boolean execResolved;
    private VariableDeclaration nameVar;
    private transient TypeRegistry typeRegistry = TypeRegistry.DEFAULT;

    /**
     * Constructor for serialization.
     * 
     * @throws VilException shall not happen
     */ 
    StrategyCallExpression() throws VilException {
    }
    
    /**
     * Creates a new instantiator strategy call.
     * 
     * @param parent the parent language unit (if given used as optional parameter during calls)
     * @param name the name of the call
     * @param arguments the parameter for the call
     * @throws VilException in case that no argument is given
     */
    public StrategyCallExpression(Object parent, String name, Expression... arguments) throws VilException {
        this(parent, name, CallArgument.createUnnamedArguments(arguments));
    }

    /**
     * Creates a new instantator strategy call.
     * 
     * @param parent the parent language unit (if given used as optional parameter during calls)
     * @param name the name of the call
     * @param arguments the parameter for the call
     * @throws VilException in case that no argument is given
     */
    public StrategyCallExpression(Object parent, String name, CallArgument... arguments) throws VilException {
        super(parent, name, arguments);
        this.type = Type.INSTANTIATOR;
    }
    
    /**
     * Creates a new system execution strategy call.
     * 
     * @param nameVar the variable holding the actual name/path of the executable
     * @param arguments the parameter for the call
     * @throws VilException in case that no argument is given
     */
    public StrategyCallExpression(VariableDeclaration nameVar, Expression... arguments) throws VilException {
        this(nameVar, CallArgument.createUnnamedArguments(arguments));
    }

    /**
     * Creates a new system execution strategy call.
     * 
     * @param nameVar the variable holding the actual name/path of the executable
     * @param arguments the parameter for the call
     * @throws VilException in case that no argument is given
     */
    public StrategyCallExpression(VariableDeclaration nameVar, CallArgument... arguments) throws VilException {
        super(null, nameVar.getName(), arguments);
        this.type = Type.EXECUTE;
        this.nameVar = nameVar;
    }
    
    /**
     * Defines the type registry to be used for resolving this call. The type registry is transient and
     * used only during resolution of instantiator calls.
     * 
     * @param registry the type registry to use
     */
    public void setTypeRegistry(TypeRegistry registry) {
        if (null != registry) {
            this.typeRegistry = registry;
        }
    }

    /**
     * Returns the variable declaration holding the actual name.
     * 
     * @return the variable declaration holding the actual name
     */
    public VariableDeclaration getNameVariable() {
        return nameVar;
    }
    
    /**
     * Returns whether the zero argument test shall be applied.
     * 
     * @return <code>true</code> if the test shall be applied, <code>false</code> else
     */
    @Override
    protected boolean doZeroArgumentTest() {
        return false;
    }
    
    /**
     * Returns the type of this call.
     * 
     * @return the type of this call
     */
    public Type getType() {
        return type;
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        TypeDescriptor<?> result;
        switch (type) {
        case EXECUTE:
            result = inferTypeExecute();
            break;
        case INSTANTIATOR:
            result = super.inferType(); // via determineOperand!
            break;
        default:
            throw new VilException("illegal strategy type " + type, VilException.ID_INTERNAL);
        }
        return result;
    }
    
    /**
     * Resolves the expression for system call execution.
     *  
     * @return the type of executing a system call
     * @throws VilException in case that the operands are not compatible
     */
    private TypeDescriptor<?> inferTypeExecute() throws VilException {
        if (!execResolved) {
            for (int a = 0; a < getArgumentsCount(); a++) {
                getArgument(a).inferType();
            }
            if (getArgumentsCount() > 0) {
                TypeDescriptor<?> arg0Type = getArgument(0).inferType();
                if (null == ExecutableOperand.getExecutableType(arg0Type)) {
                    throw new VilException("cannot execute system call on " + arg0Type.getName(), 
                        VilException.ID_CANNOT_RESOLVE);
                }
            }
            execResolved = true;
        }
        return TypeRegistry.voidType(); // cannot return something
    }

    @Override
    protected TypeDescriptor<?> determineOperand() throws VilException {
        TypeDescriptor<?> instantiator = typeRegistry.getInstantiator(getName());
        if (null == instantiator) {
            throw new VilException("unknown instantiator " + getName(), 
                VilException.ID_CANNOT_RESOLVE);
        }
        return instantiator;
    }
    
    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitStrategyCallExpression(this);
        } else {
            result = visitor.visitExpression(this);
        }
        return result;
    }
    
    @Override
    public boolean isPlaceholder() {
        boolean isPlaceholder;
        if (Type.EXECUTE == type) {
            isPlaceholder = false;
        } else {
            isPlaceholder = super.isPlaceholder();
        }
        return isPlaceholder;
    }

}
