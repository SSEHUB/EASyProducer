package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents a VIL type.
 * 
 * @author Holger Eichelberger
 */
public class VilTypeExpression extends Expression {
    
    private String identifier;
    private TypeDescriptor<?> resolved;

    /**
     * Constructor for serialization.
     */
    VilTypeExpression() {
    }
    
    /**
     * Creates the representing instance.
     * 
     * @param identifier the identifier from VIL
     * @param resolved the resolved type
     */
    public VilTypeExpression(String identifier, TypeDescriptor<?> resolved) {
        this.identifier = identifier;
        this.resolved = resolved;
    }
    
    /**
     * Returns the original identifier.
     * 
     * @return the original identifier
     */
    public String getIdentifier() {
        return identifier;
    }
    
    /**
     * Returns the resolved element.
     * 
     * @return the resolved element
     */
    public TypeDescriptor<?> getResolved() {
        return resolved;
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return TypeRegistry.typeType();
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws VilException {
        return visitor.visitVilTypeExpression(this);
    }

}
