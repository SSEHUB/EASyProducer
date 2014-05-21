package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Reference value class.
 * @author lueder
 *
 */
public class ReferenceValue extends Value {
    
    private DecisionVariableDeclaration value; // the declaration the reference goes to

    /**
     * Constructor for a new ReferenceValue.
     * @param origin Reference which extends this ReferenceValue
     * @param ref the reference of this value
     * @throws ValueDoesNotMatchTypeException if one of the default values do not comply
     *   to the respective types
     */
    protected ReferenceValue(IDatatype origin, Object... ref) throws ValueDoesNotMatchTypeException {
        super(origin);
        if (null != ref && ref.length > 0) {
            setValue(ref[0]);
        } else {
            throw new ValueDoesNotMatchTypeException("null is not a valid reference", 
                ValueDoesNotMatchTypeException.IS_NULL);
        }
    }

    @Override
    public DecisionVariableDeclaration getValue() {
        return value;
    }

    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitReferenceValue(this);
    }
    
    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (value instanceof DecisionVariableDeclaration) {
            DecisionVariableDeclaration decl = (DecisionVariableDeclaration) value;
            this.value = decl;
        } else if (value == null) {
            // TODO check - IVML has an explicit null value!!!
            throw new ValueDoesNotMatchTypeException("null is not a valid reference", 
                ValueDoesNotMatchTypeException.IS_NULL);
        } else {
            throw new ValueDoesNotMatchTypeException("given value '" + value + "' does not match reference type " 
                + getType(), ValueDoesNotMatchTypeException.TYPE_MISMATCH);
        }
    }

    @Override
    public boolean isConfigured() {
        return null != value;
    }

    @Override
    public Value clone() {
        // TODO Auto-generated method stub
        return null;
    }
}
