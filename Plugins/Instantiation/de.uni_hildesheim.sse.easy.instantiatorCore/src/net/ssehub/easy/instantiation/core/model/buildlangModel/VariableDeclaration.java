package net.ssehub.easy.instantiation.core.model.buildlangModel;

import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.expressions.IResolvable;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Represents a variable declaration. Parent instances are responsible for setting the right parent.
 * 
 * @author Christian Kröher
 * @author Holger Eichelberger
 */
public class VariableDeclaration 
    extends net.ssehub.easy.instantiation.core.model.common.VariableDeclaration
    implements IBuildlangElement, IRuleElement, IResolvable {
    
    private ILanguageElement parent;
    
    /**
     * Constructor for serializer.
     */
    VariableDeclaration() {
        super(null, null);
    }
    
    /**
     * Creates a new variable declaration.
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
