package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.IvmlElement;

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
    public TypeDescriptor<? extends IVilType> inferType() throws ExpressionException {
        return TypeRegistry.DEFAULT.getType(IvmlElement.class);
    }

    @Override
    public Object accept(IExpressionVisitor visitor) throws ExpressionException {
        return visitor.visitVarModelIdentifierExpression(this);
    }

}
