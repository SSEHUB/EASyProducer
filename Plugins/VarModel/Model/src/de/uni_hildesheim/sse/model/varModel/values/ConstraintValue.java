package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;

/**
 * This class holds the value for a constraint type.
 *
 * @author Holger Eichelberger
 */
public class ConstraintValue extends BasisDatatypeValue {
    
    private ConstraintSyntaxTree value;

    /**
     * Argumentless constructor.
     */
    protected ConstraintValue() {
        super(ConstraintType.TYPE);
    }

    /**
     * Constructor.
     * @param value Value of the Datatype
     * @throws ValueDoesNotMatchTypeException in case that the given value
     *   does not match the requirements of this class, i.e. cannot be converted
     */
    protected ConstraintValue(Object value) throws ValueDoesNotMatchTypeException {
        this();
        // either it is already a CST, a Constraint which contains a
        // CST, null or (according to the grammar) a Boolean constant
        if (value instanceof ConstraintSyntaxTree) {
            this.value = (ConstraintSyntaxTree) value;
        } else if (value instanceof ConstraintValue) {
            this.value = ((ConstraintValue) value).getValue();
        } else if (value == null) {
            this.value = null;
        } else {
            this.value = new ConstantValue(new BooleanValue(value.toString()));
        }
    }
    
    /**
     * Constructor.
     * @param value Value of the Datatype
     */
    protected ConstraintValue(ConstraintSyntaxTree value) {
        this();
        this.value = value;
    }
    
    /**
     * Setter for the value.
     * @param value Value of the Datatype
     * @throws ValueDoesNotMatchTypeException if the given value does not match this type
     */
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (value instanceof ConstraintSyntaxTree) {
            this.value = (ConstraintSyntaxTree) value;
        } else {
            throw new ValueDoesNotMatchTypeException("no constraint given", 
                ValueDoesNotMatchTypeException.TYPE_MISMATCH);
        }
    }
    
    /**
     * Returns the stored value.
     * 
     * @return the stored constraint (may be <b>null</b>)
     */
    public ConstraintSyntaxTree getValue() {
        return value;
    }
    
    /** 
     * Accept method for the visitor. <br/>
     * This method is used for saving this model element.
     * @param visitor The visitor, which should save this model element.
     */
    public void accept(IValueVisitor visitor) {
        visitor.visitConstraintValue(this);
    }

    @Override
    public boolean isConfigured() {
        return value != null;
    }
    
    /**
     * {@inheritDoc}
     */
    public Value clone() {
        return new ConstraintValue(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object object) {
        return value.equals(object);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
