package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * An expression denoting that a variable is used.
 * 
 * @author Holger Eichelberger
 */
public class VariableExpression extends Expression {

    private VariableDeclaration variable;
    private String qualifiedName;
    
    /**
     * Creates a variable expression node.
     * 
     * @param variable the variable declaration used as variable here
     */
    public VariableExpression(VariableDeclaration variable) {
        this(variable, null);
    }

    /**
     * Creates a variable expression node.
     * 
     * @param variable the variable declaration used as variable here
     * @param qualifiedName in case that not the variable itself but a qualified access to the variable is used (may 
     *     be <b>null</b>)
     */
    public VariableExpression(VariableDeclaration variable, String qualifiedName) {
        this.variable = variable;
        this.qualifiedName = qualifiedName;
    }
    
    /**
     * The qualified name in case that not the variable itself but a qualified access to the variable was used.
     * 
     * @return the qualified name, may be <b>null</b>
     */
    public String getQualifiedName() {
        return qualifiedName;
    }
    
    /**
     * Returns the name of the variable beyond this node.
     * 
     * @return the name of the variable
     */
    public String getName() {
        return variable.getName();
    }
    
    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws ExpressionException {
        return variable.getType();
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws ExpressionException {
        return visitor.visitVariableExpression(this);
    }
    
    /**
     * Returns the variable declaration beyond this node.
     * 
     * @return the variable declaration
     */
    public VariableDeclaration getDeclaration() {
        return variable;
    }

}
