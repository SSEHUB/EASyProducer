package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Represents a compound access statement, e.g., within a freeze block.
 * 
 * @author Holger Eichelberger
 */
public class CompoundAccessStatement extends ContainableModelElement implements IFreezable {

    private AbstractVariable compoundVariable;
    private String slotName;

    /**
     * Creates a compound access statement.
     * 
     * @param compoundVariable the compound variable the access happens on
     * @param slotName the name of the slot within the compound variable
     * @param parent the parent element
     */
    public CompoundAccessStatement(AbstractVariable compoundVariable, String slotName, 
        IModelElement parent) {
        super("", parent);
        this.compoundVariable = compoundVariable;
        this.slotName = slotName;
    }
    
    /**
     * Returns the slot name.
     * 
     * @return the slot name
     */
    public String getSlotName() {
        return slotName;
    }
    
    /**
     * Returns the underlying compound variable.
     * 
     * @return the compound variable
     */
    public AbstractVariable getCompoundVariable() {
        return compoundVariable;
    }
    
    @Override
    public void accept(IModelVisitor visitor) {
        visitor.visitCompoundAccessStatement(this);
    }

    @Override
    public IDatatype getType() {
        IDatatype result = AnyType.TYPE; // shall not happen
        AbstractVariable slotVar = getSlotDeclaration();
        if (null != slotVar) {
            result = slotVar.getType();
        }
        return result;
    }
    
    /**
     * Returns the slot declaration.
     * 
     * @return the variable declaration for the referenced compound slot, <b>null</b> if not found
     */
    public AbstractVariable getSlotDeclaration() {
        AbstractVariable result = null;
        if (compoundVariable.getType() instanceof Compound) {
            Compound type = (Compound) compoundVariable.getType();
            result = type.getElement(slotName);
        }
        return result;
    }

    @Override
    public int getAttributesCount() {
        AbstractVariable var = getSlotDeclaration();
        return null == var ? 0 : var.getAttributesCount();
    }

    @Override
    public Attribute getAttribute(String name) {
        AbstractVariable var = getSlotDeclaration();
        return null == var ? null : var.getAttribute(name);
    }

    @Override
    public Attribute getAttribute(int index) {
        AbstractVariable var = getSlotDeclaration();
        return null == var ? null : var.getAttribute(index);
    }

}
