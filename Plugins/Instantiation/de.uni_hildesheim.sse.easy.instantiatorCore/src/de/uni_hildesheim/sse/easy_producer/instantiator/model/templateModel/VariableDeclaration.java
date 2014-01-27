package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.Expression;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions.IResolvable;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Represents a variable declaration.
 * 
 * @author Christian Kröher
 * @author Holger Eichelberger
 */
public class VariableDeclaration extends 
    de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VariableDeclaration 
    implements ITemplateLangElement, ITemplateElement, IResolvable {
    
    /**
     * Creates a new variable declaration.
     * 
     * @param name the name of the variable
     * @param type the type of the variable
     */
    public VariableDeclaration(String name, TypeDescriptor<? extends IVilType> type) {
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
    public VariableDeclaration(String name, TypeDescriptor<? extends IVilType> type, boolean isConstant, 
        Expression expression) {
        super(name, type, isConstant, expression);
    }
    
    @Override
    public Object accept(IVisitor visitor) throws VilLanguageException {
        return accept((de.uni_hildesheim.sse.easy_producer.instantiator.model.common.IVisitor) visitor);
    }
    
    @Override
    public boolean isBlock() {
        return false;
    }

    @Override
    public TypeDescriptor<? extends IVilType> inferType() throws VilLanguageException {
        return TypeDescriptor.VOID;
    }

}
