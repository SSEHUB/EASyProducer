package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents a variable declaration.
 * 
 * @author Christian Kröher
 * @author Holger Eichelberger
 */
public class VariableDeclaration extends 
    net.ssehub.easy.instantiation.core.model.common.VariableDeclaration 
    implements ITemplateLangElement, ITemplateElement {
    
    private ILanguageElement parent;
    
    /**
     * Creates a new variable declaration. Parent must be explicitly adjusted by parent instance.
     * 
     * @param name the name of the variable
     * @param type the type of the variable
     */
    public VariableDeclaration(String name, TypeDescriptor<?> type) {
        super(name, type);
    }

    /**
     * Creates a new variable declaration.
     * 
     * @param name the name of the variable
     * @param type the type of the variable
     * @param isConstant whether this variable is a constant
     * @param expression an expression denoting the initial value (may be <b>null</b>)
     */
    public VariableDeclaration(String name, TypeDescriptor<?> type, boolean isConstant, 
        Expression expression) {
        super(name, type, isConstant, expression);
    }
    
    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return accept((net.ssehub.easy.instantiation.core.model.common.IVisitor) visitor);
    }
    
    @Override
    public boolean isBlock() {
        return false;
    }

    @Override
    public TypeDescriptor<?> inferType() throws VilException {
        return TypeRegistry.voidType();
    }

    @Override
    public ILanguageElement getParent() {
        return parent;
    }
    
    /**
     * Changes the parent. Please override if children must be adjusted according.
     * Shall be called only once per instance, but there is no limitation.
     * 
     * @param parent the parent
     */
    protected void setParent(ILanguageElement parent) {
        this.parent = parent;
    }

}
