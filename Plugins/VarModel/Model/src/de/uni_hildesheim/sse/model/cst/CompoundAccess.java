package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.MetaType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.values.MetaTypeValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Represents an expression which accesses a compound slot where
 * the compound is specified as a {@link ConstraintSyntaxTree}.
 * 
 * @author Holger Eichelberger
 */
public class CompoundAccess extends ConstraintSyntaxTree {
    
    private ConstraintSyntaxTree compoundExpression;
    private String slotName;
    private DecisionVariableDeclaration slot; // lazy
    
    /**
     * Creates a compound access node.
     * 
     * @param compoundExpression an expression denoting a compound
     * @param slotName the name of the accessed slot
     */
    public CompoundAccess(ConstraintSyntaxTree compoundExpression, String slotName) {
        this.compoundExpression = compoundExpression;
        this.slotName = slotName;
    }

    /**
     * Searches for a slot in <code>comp</code> or its refined compounds.
     * @param comp the compound to search
     * @param slotName the name to search
     * @return the containing compound or <b>null</b>
     */
    private DecisionVariableDeclaration searchSlot(Compound comp, String slotName) {
        DecisionVariableDeclaration slot = comp.getElement(slotName);
        if (null == slot && null != comp.getRefines()) {
            slot = searchSlot(comp.getRefines(), slotName);
        }
        return slot;
    }
    
    /**
     * Returns the static type in case that this compound access is a static access.
     * 
     * @return the static type or <b>null</b>
     * @throws CSTSemanticException in case of semantic errors
     */
    public IDatatype getStaticType() throws CSTSemanticException {
        IDatatype result = null;
        IDatatype cExpression = compoundExpression.inferDatatype();
        if (cExpression.isAssignableFrom(MetaType.TYPE)) {
            if (compoundExpression instanceof ConstantValue) {
                // ugly!
                Value value = ((ConstantValue) compoundExpression).getConstantValue();
                if (value instanceof MetaTypeValue) {
                    result = ((MetaTypeValue) value).getValue();
                }
            }
        }
        return result;
    }
    
    /**
     * {@inheritDoc}
     */
    public IDatatype inferDatatype() throws CSTSemanticException {
        IDatatype result = null;
        if (null == slot) {
            IDatatype cExpression;
            IDatatype staticType = getStaticType();
            if (null != staticType) {
                cExpression = staticType;
            } else {
                cExpression = compoundExpression.inferDatatype();
            }
            cExpression = Reference.dereference(cExpression);
            if (cExpression.isAssignableFrom(MetaType.TYPE)) {
                if (cExpression instanceof ConstantValue) {
                    // ugly!
                    Value value = ((ConstantValue) cExpression).getConstantValue();
                    if (value instanceof MetaTypeValue) {
                        cExpression = ((MetaTypeValue) value).getValue();
                    }
                }
            }
            if (cExpression.isAssignableFrom(Compound.TYPE)) {
                Compound comp = (Compound) cExpression;
                slot = searchSlot(comp, slotName);
                if (null == slot) {
                    throw new CSTSemanticException("type '" + comp.getName() 
                        + "' does not have a slot named '" + slotName + "'", 
                        CSTSemanticException.UNKNOWN_ELEMENT);
                }
            } else {
                throw new CSTSemanticException("expression does not evaluate to a compound", 
                    CSTSemanticException.TYPE_MISMATCH);
            }
        } 
        if (null != slot) {
            result = slot.getType();
        }
        return result;
    }
    
    /**
     * The expression denoting the compound to access.
     * 
     * @return the compound expression
     */
    public ConstraintSyntaxTree getCompoundExpression() {
        return compoundExpression;
    }
    
    /**
     * Returns the name of the slot.
     * 
     * @return the name of the slot
     */
    public String getSlotName() {
        return slotName;
    }
    
    /**
     * Returns the resolved compound slot. The result is only valid if
     * {@link #inferDatatype()} was called before this operation.
     * 
     * @return the resolved slot, <b>null</b> if the slot cannot
     *   be resolved or {@link #inferDatatype()} was not called before
     */
    public DecisionVariableDeclaration getResolvedSlot() {
        return slot;
    }

    /**
     * {@inheritDoc}
     */
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitCompoundAccess(this); // no further operations!
    }

}
