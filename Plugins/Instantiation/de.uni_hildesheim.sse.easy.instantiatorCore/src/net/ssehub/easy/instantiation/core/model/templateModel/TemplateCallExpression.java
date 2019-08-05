package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.ModelCallExpression;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.IExpressionVisitor;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaOperation;

/**
 * Represents the explicit execution of a template.
 * 
 * @author Holger Eichelberger
 */
public class TemplateCallExpression extends ModelCallExpression<VariableDeclaration, Template, Def> {

    /**
     * Constructor for serialization.
     */
    TemplateCallExpression() {
    }
    
    /**
     * Creates a new template call expression.
     * 
     * @param template the actual script to resolve the call on
     * @param isSuper this is a super call
     * @param name the name of the template
     * @param arguments the actual arguments
     * @throws VilException in case of an erroneously qualified name
     */
    public TemplateCallExpression(Template template, boolean isSuper, String name, CallArgument... arguments) 
        throws VilException {
        super(template, isSuper, name, arguments);
    }
    
    /**
     * Creates a new template call expression for a known operation.
     * 
     * @param template the actual template to containing <code>def</code>
     * @param def the resolved sub-template
     * @param arguments the actual arguments
     * @throws VilException in case of an erroneously qualified name
     */
    TemplateCallExpression(Template template, Def def, CallArgument... arguments) throws VilException {
        super(template, def, arguments);
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IVisitor) {
            result = ((IVisitor) visitor).visitTemplateCallExpression(this);
        } else {
            result = visitor.visitExpression(this);
        }
        return result;
    }

    @Override
    protected Class<Def> getOperationClass() {
        return Def.class;
    }
    
    @Override
    protected String getInvalidOperationMessage(IMetaOperation op) {
        return op.getJavaSignature() + " is not a valid template";
    }
    
    @Override
    public boolean isVisible(Template fromModel) {
        boolean isVisible = true;
        Def resolved = getResolved();
        if (resolved.isProtected()) {
            isVisible = resolved.getDeclaringType().equals(fromModel);
        }
        return isVisible;
    }

}
