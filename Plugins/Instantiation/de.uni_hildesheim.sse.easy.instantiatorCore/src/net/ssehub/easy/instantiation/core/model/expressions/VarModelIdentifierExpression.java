package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlElement;

/**
 * Represents an identifier in a variability model. This expression 
 * does not carry resolved information as it will be resolved at runtime.
 * 
 * @author Holger Eichelberger
 */
public class VarModelIdentifierExpression extends Expression {
    
    private String identifier;

    /**
     * Creates the representing instance.
     * 
     * @param identifier the identifier from VIL
     */
    public VarModelIdentifierExpression(String identifier) {
        this.identifier = identifier;
    }
    
    /**
     * Returns the original identifier.
     * 
     * @return the original identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return TypeRegistry.DEFAULT.getType(IvmlElement.class);
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return visitor.visitVarModelIdentifierExpression(this);
    }
    
    /**
     * Marks this identifier expression as resolved and not needed anymore!
     */
    public void markAsResolved() {
        identifier = "";
    }
    
    /**
     * Returns whether {@link #markAsResolved()} was called on this instance.
     * 
     * @return <code>true</code> if resolved, <code>false</code> else
     */
    public boolean isMarkedAsResolved() {
        return null != identifier && 0 == identifier.length();
    }

}
