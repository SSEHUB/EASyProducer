package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.basics.modelManagement.IVersionRestriction;
import net.ssehub.easy.instantiation.core.model.common.ModelCallExpression;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents an instantiate expression. However, an instantiate expression can only be resolved at runtime.
 * 
 * @author Holger Eichelberger
 */
public class InstantiateExpression extends ModelCallExpression<VariableDeclaration, Script, Rule> {
    
    private IVersionRestriction restriction;
    private VariableDeclaration project;

    /**
     * Creates an instantiate expression.
     * 
     * @param project the project variable
     * @param restriction optional version restrictions (may be <b>null</b>)
     * @param name the optional name of the rule to be executed (may be <b>null</b> and points then to the main rule)
     * @param arguments the rule call arguments
     * @throws VilException in case that the expression cannot be resolved
     */
    public InstantiateExpression(VariableDeclaration project, IVersionRestriction restriction, String name, 
        CallArgument... arguments) throws VilException {
        super(null, false, name, arguments);
        this.project = project;
        this.restriction = restriction;
    }

    /**
     * Creates an instantiate expression.
     * 
     * @param name the (qualified) name of the rule to be called
     * @param arguments the rule call arguments
     * @throws VilException in case that the expression cannot be resolved
     */
    public InstantiateExpression(String name, CallArgument... arguments) throws VilException {
        super(null, false, name, arguments);
    }

    /**
     * Returns the project variable.
     * 
     * @return the project variable (may be <b>null</b> if a name-based call is given)
     * 
     */
    public VariableDeclaration getProject() {
        return project;
    }

    /**
     * Returns the version restriction.
     * 
     * @return the version restriction (may be <b>null</b> if absent)
     */
    public IVersionRestriction getVersionRestriction() {
        return restriction;
    }

    @Override
    protected Class<? extends Rule> getOperationClass() {
        return Rule.class;
    }
    
    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        // real resolution happens at runtime!
        return TypeRegistry.voidType();
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitInstantiateExpression(this);
        } else {
            result = visitor.visitExpression(this);
        }
        return result;
    }

    @Override
    public boolean isVisible(Script fromModel) {
        return true;
    }
        
}
