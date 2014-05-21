package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ModelCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.modelManagement.IVersionRestrictable;
import de.uni_hildesheim.sse.utils.modelManagement.VersionRestriction;

/**
 * Represents an instantiate expression. However, an instantiate expression can only be resolved at runtime.
 * 
 * @author Holger Eichelberger
 */
public class InstantiateExpression extends ModelCallExpression<VariableDeclaration, Script, Rule> 
    implements IVersionRestrictable {
    
    private VersionRestriction[] versionRestrictions;
    private VariableDeclaration project;

    /**
     * Creates an instantiate expression.
     * 
     * @param project the project variable
     * @param versionRestrictions optional version restrictions (may be <b>null</b>)
     * @param name the optional name of the rule to be executed (may be <b>null</b> and points then to the main rule)
     * @param arguments the rule call arguments
     * @throws ExpressionException in case that the expression cannot be resolved
     */
    public InstantiateExpression(VariableDeclaration project, VersionRestriction[] versionRestrictions, String name, 
        CallArgument... arguments) throws ExpressionException {
        super(null, false, name, arguments);
        this.project = project;
        this.versionRestrictions = versionRestrictions;
    }

    /**
     * Creates an instantiate expression.
     * 
     * @param name the (qualified) name of the rule to be called
     * @param arguments the rule call arguments
     * @throws ExpressionException in case that the expression cannot be resolved
     */
    public InstantiateExpression(String name, CallArgument... arguments) throws ExpressionException {
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

    @Override
    public int getRestrictionsCount() {
        return null == versionRestrictions ? 0 : versionRestrictions.length;
    }
    
    @Override
    public VersionRestriction getRestriction(int index) {
        if (null == versionRestrictions) {
            throw new IndexOutOfBoundsException();
        }
        return versionRestrictions[index];
    }

    @Override
    protected Class<Rule> getOperationClass() {
        return Rule.class;
    }
    
    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws ExpressionException {
        // real resolution happens at runtime!
        return TypeRegistry.voidType();
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws ExpressionException {
        Object result;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitInstantiateExpression(this);
        } else {
            result = visitor.visitExpression(this);
        }
        return result;
    }
        
}
