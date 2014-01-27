package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.ModelCallExpression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.CallArgument;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IExpressionVisitor;

/**
 * Represents the explicit execution of a template.
 * 
 * @author Holger Eichelberger
 */
public class TemplateCallExpression extends ModelCallExpression<VariableDeclaration, Template, Def> {

    /**
     * Creates a new template call expression.
     * 
     * @param template the actual script to resolve the call on
     * @param isSuper this is a super call
     * @param name the name of the template
     * @param arguments the actual arguments
     * @throws ExpressionException in case of an erroneously qualified name
     */
    public TemplateCallExpression(Template template, boolean isSuper, String name, CallArgument... arguments) 
        throws ExpressionException {
        super(template, isSuper, name, arguments);
    }
    
    /**
     * Creates a new template call expression for a known operation.
     * 
     * @param template the actual template to containing <code>def</code>
     * @param def the resolved sub-template
     * @param arguments the actual arguments
     * @throws ExpressionException in case of an erroneously qualified name
     */
    TemplateCallExpression(Template template, Def def, CallArgument... arguments) throws ExpressionException {
        super(template, def, arguments);
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws ExpressionException {
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
    
}
