package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Class for a constant value.
 * @author jaehne
 * @author Holger Eichelberger
 *
 */
public class ConstantValue extends Leaf {
    private Value constant;
    
    /**
     * Sole constructor for the creation of a constant value.
     * @param constant Constant value to be stored.
     */
    public ConstantValue(Value constant) {
        this.constant = constant;
    }
    
    @Override
    public IDatatype inferDatatype() {
        return constant.getType();
    }
    
    /**
     * Getter-Method for the constant-value.
     * @return the value of the constant-attribute.
     */
    public Value getConstantValue() {
        return constant;
    }
    
    /**
     * {@inheritDoc}
     */
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitConstantValue(this); // no further operations!
    }
    
    @Override
    public boolean equals(Object obj) {
        //Two objects are equal if they instances of the same class and have the same hashCode
        boolean equals = false;
        
        if (obj instanceof ConstantValue) {
            equals = this.hashCode() == obj.hashCode();
        }
        
        return equals;
    }

    @Override
    public int hashCode() {
        //Two Variables are equal, if the constants are equal
        return constant.hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IDatatype getContainedType() {
        IDatatype result = null;
        Value value = getConstantValue();
        if (null != value) {
            result = value.getContainedType();
        }
        return result;
    }
    
}
