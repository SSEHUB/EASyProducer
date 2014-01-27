package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;

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

    /**
     * Returns the Datatype of this Value. The datatype should match to the type of this value.
     * @return Related datatype of this value.
     */
    public IDatatype getType() {
        IDatatype result;
        if (null == value) {
            result = super.getType();
        } else {
            result = value.getType();
            // indirection, access via reference
            if (result instanceof Reference) {
                result = ((Reference) result).getType();
            }
        }
        return result;        
    }
    
    /**
     * Returns whether this value is used to define a reference to some variable
     * declaration.
     * 
     * @return <code>true</code> if it is used to define, <code>false</code> else
     */
    public boolean isReferenceDefinition() {
        return null != value && !Reference.TYPE.isAssignableFrom(value.getType());
    }

    /**
     * Returns whether this value is used to apply a reference in order to use it.
     * 
     * @return <code>true</code> if it is used to apply, <code>false</code> else
     */
    public boolean isReferenceUse() {
        return null != value && Reference.TYPE.isAssignableFrom(value.getType());
    }
    
    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (value instanceof DecisionVariableDeclaration) {
            DecisionVariableDeclaration decl = (DecisionVariableDeclaration) value;
            this.value = decl;
        } else if (value == null) {
            throw new ValueDoesNotMatchTypeException("null is not a valid reference", 
                ValueDoesNotMatchTypeException.IS_NULL);
        } else {
            throw new ValueDoesNotMatchTypeException("given value does not match", 
                ValueDoesNotMatchTypeException.TYPE_MISMATCH);
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
