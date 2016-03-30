package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CompositeExpression;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Implements a statement which contains content.
 * 
 * @author Holger Eichelberger
 */
public class ContentStatement implements ITemplateElement {

    private CompositeExpression content;
    private String terminal;
    private Expression indentExpression;
    private boolean printLineEnd;
    
    /**
     * Creates a new content statement.
     * 
     * @param content the content
     * @param terminal the limiting terminal (at start and end)
     * @param indentExpression an optional integer expression determining the additional 
     *     indentation, e.g., in loops or recursions
     * @param printLineEnd whether a line end shall be emitted
     * @throws VilException in case that the expression cannot be resolved or does not evaluate to an integer
     */
    public ContentStatement(CompositeExpression content, String terminal, Expression indentExpression, 
        boolean printLineEnd) 
        throws VilException {
        this.printLineEnd = printLineEnd;
        this.content = content;
        this.terminal = terminal;
        this.indentExpression = indentExpression;
        if (null != this.indentExpression) {
            if (this.indentExpression.inferType() != TypeRegistry.integerType()) {
                throw new VilException("indent expression must result in an Integer", 
                    VilException.ID_SEMANTIC);
            }
        }
    }
    
    /**
     * Returns whether a line end shall be emitted.
     * 
     * @return <code>true</code> if a line end shall be emitted, <code>false</code> else
     */
    public boolean printLineEnd() {
        return printLineEnd;
    }
    
    /**
     * Returns the content.
     * 
     * @return the content
     */
    public CompositeExpression getContent() {
        return content;
    }
    
    /**
     * Returns the terminal to encapsulate the content in the underlying template.
     * 
     * @return the terminal
     */
    public String getTerminal() {
        return terminal;
    }
    
    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitContentStatement(this);
    }
    
    @Override
    public boolean isBlock() {
        return false;
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return TypeRegistry.stringType();
    }
    
    /**
     * Returns the integer expression specifying the additional indentation.
     * 
     * @return the indent expression (may be <b>null</b>)
     */
    public Expression getIndentExpression() {
        return indentExpression;
    }

}
