package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;

/**
 * Holding enum literals.
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public class EnumValue extends Value {
    private EnumLiteral literal;

    /**
     * Constructor for a new EnumValue.
     * @param enumType the Enum which defines the specific type of this EnumValue
     */
    protected EnumValue(Enum enumType) {
        this(enumType, null);
    }

    /**
     * Constructor for a new EnumValue.
     * @param enumType the Enum which defines the specific type of this EnumValue
     * @param literal the initial value for the literal
     */
    protected EnumValue(Enum enumType, EnumLiteral literal) {
        super(enumType);
        this.literal = literal;
    }

    /**
     * Constructor for a new EnumValue.
     * @param enumType the Enum which defines the specific type of this EnumValue
     * @param value the enum value
     * @throws ValueDoesNotMatchTypeException in case of type problems
     */
    protected EnumValue(Enum enumType, Object value) throws ValueDoesNotMatchTypeException {
        super(enumType);
        if (null == value) {
            throw new ValueDoesNotMatchTypeException("null is not a valid enum literal", 
                ValueDoesNotMatchTypeException.IS_NULL);
        } else if (value instanceof EnumLiteral) {
            EnumLiteral lit = (EnumLiteral) value;
            if (!enumType.has(lit)) {
                throw new ValueDoesNotMatchTypeException(value.toString(), enumType, 
                     ValueDoesNotMatchTypeException.NO_LITERAL);
            }
            literal = lit;
        } else {
            setValue(value);
        }
    }
    
    /**
     * Getter for the value. Not implemented yet.
     * @return null
     */
    @Override
    public EnumLiteral getValue() {
        return literal;
    }

    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitEnumValue(this);
    }
    
    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        if (null == value) {
            throw new ValueDoesNotMatchTypeException("null is not a valid enum literal", 
                ValueDoesNotMatchTypeException.IS_NULL);
        }
        
        Enum enumType = (Enum) getType(); // works by construction
        String sValue = stringValueOf(value);
        EnumLiteral lit = enumType.get(sValue);
        if (null == lit) {
            throw new ValueDoesNotMatchTypeException(sValue, enumType, 
                ValueDoesNotMatchTypeException.NO_LITERAL);
        }
        literal = lit;
    }

    @Override
    public boolean isConfigured() {
        return literal != null;
    }
    
    /**
     * {@inheritDoc}
     */
    public Value clone() {
        return new EnumValue((Enum) getType(), literal);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object object) {
        boolean result;
        if (object instanceof EnumValue) {
            result = literal.equals(((EnumValue) object).getValue());
        } else {
            result = false;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return literal.hashCode();
    }

}
