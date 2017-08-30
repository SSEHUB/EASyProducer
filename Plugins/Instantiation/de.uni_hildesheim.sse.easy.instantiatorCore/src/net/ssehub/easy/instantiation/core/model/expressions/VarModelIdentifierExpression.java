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
    private IvmlElement element;

    /**
     * Creates the representing instance without related/resolved IVML element.
     * 
     * @param identifier the identifier from VIL
     */
    public VarModelIdentifierExpression(String identifier) {
        this(identifier, null);
    }
    
    /**
     * Creates the representing instance.
     * 
     * @param identifier the identifier from VIL
     * @param element the related IVML element (may be <b>null</b> if unknown, unresolved identifier)
     */
    public VarModelIdentifierExpression(String identifier, IvmlElement element) {
        this.identifier = identifier;
        this.element = element;
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
     * Returns the related variability model element.
     * 
     * @return the variability model element (may be <b>null</b> if unknown, unresolved identifier)
     */
    public IvmlElement getElement() {
        return element;
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        TypeDescriptor<?> type = null;
        if (null != element) {
            type = element.getType();
        }
        if (null == type) {
            type = TypeRegistry.DEFAULT.getType(IvmlElement.class);
        }
        return type;
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
