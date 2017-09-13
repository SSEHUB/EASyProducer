package net.ssehub.easy.instantiation.core.model.expressions;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ITypedModel;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlElement;

/**
 * Represents an identifier in a variability model. This expression 
 * does not need to carry resolved information as it will be resolved at runtime. It can 
 * carry an optional type to enable type-safe resolution of expresions.
 * 
 * @author Holger Eichelberger
 */
public class VarModelIdentifierExpression extends Expression {
    
    private String identifier;
    private TypeDescriptor<?> type;
    private ITypedModel model;

    /**
     * Creates the representing instance.
     * 
     * @param identifier the identifier from VIL
     * @param type the related type (may be <b>null</b> if unknown/unresolved, then {@link IvmlElement} is assumed)
     * @param model the model this expression was created for (for further resolution, may be <b>null</b>)
     */
    public VarModelIdentifierExpression(String identifier, TypeDescriptor<?> type, IModel model) {
        this(identifier, type, model instanceof ITypedModel ? (ITypedModel) model : null);
    }
    
    /**
     * Creates the representing instance.
     * 
     * @param identifier the identifier from VIL
     * @param type the related type (may be <b>null</b> if unknown/unresolved, then {@link IvmlElement} is assumed)
     * @param model the model this expression was created for (for further resolution, may be <b>null</b>)
     */
    public VarModelIdentifierExpression(String identifier, TypeDescriptor<?> type, ITypedModel model) {
        this.identifier = identifier;
        this.type = null == type ? TypeRegistry.DEFAULT.getType(IvmlElement.class) : type;
        this.model = model;
    }
    
    /**
     * Returns the model.
     * 
     * @return the model, may be <b>null</b>
     */
    public ITypedModel getModel() {
        return model;
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
     * Returns the related type (without potential exception).
     * 
     * @return the type of the represented variability model element (may be {@link IvmlElement} if unknown/unresolved)
     */
    public TypeDescriptor<?> getType() {
        return type;
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
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
