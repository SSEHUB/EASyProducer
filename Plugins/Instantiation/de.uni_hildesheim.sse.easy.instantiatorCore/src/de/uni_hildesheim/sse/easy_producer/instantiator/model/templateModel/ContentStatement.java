package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.ExpressionException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Implements a statement which contains content.
 * 
 * @author Holger Eichelberger
 */
public class ContentStatement implements ITemplateElement {

    private String content;
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
     * @throws VilLanguageException in case that the expression cannot be resolved or does not evaluate to an integer
     */
    public ContentStatement(String content, String terminal, Expression indentExpression, boolean printLineEnd) 
        throws VilLanguageException {
        this.printLineEnd = printLineEnd;
        this.content = content;
        this.terminal = terminal;
        this.indentExpression = indentExpression;
        if (null != this.indentExpression) {
            try {
                if (this.indentExpression.inferType() != TypeRegistry.integerType()) {
                    throw new VilLanguageException("indent expression must result in an Integer", 
                        VilLanguageException.ID_SEMANTIC);
                }
            } catch (ExpressionException e) {
                throw new VilLanguageException(e);
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
    public String getContent() {
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
    public Object accept(IVisitor visitor) throws VilLanguageException {
        return visitor.visitContentStatement(this);
    }
    
    @Override
    public boolean isBlock() {
        return false;
    }

    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws VilLanguageException {
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
