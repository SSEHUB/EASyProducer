package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Represents a VIL type.
 * 
 * @author Holger Eichelberger
 */
public class VilTypeExpression extends Expression {
    
    private String identifier;
    private TypeDescriptor<? extends IVilType> resolved;

    /**
     * Creates the representing instance.
     * 
     * @param identifier the identifier from VIL
     * @param resolved the resolved type
     */
    public VilTypeExpression(String identifier, TypeDescriptor<? extends IVilType> resolved) {
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
    public TypeDescriptor<? extends IVilType> getResolved() {
        return resolved;
    }

    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws ExpressionException {
        return TypeRegistry.typeType();
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws ExpressionException {
        return visitor.visitVilTypeExpression(this);
    }

}
