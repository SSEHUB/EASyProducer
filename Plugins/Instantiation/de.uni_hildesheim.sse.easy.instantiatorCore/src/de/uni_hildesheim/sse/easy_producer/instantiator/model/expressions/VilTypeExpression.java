package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Represents a VIL type.
 * 
 * @author Holger Eichelberger
 */
public class VilTypeExpression extends Expression {
    
    private String identifier;
    private TypeDescriptor<?> resolved;

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
