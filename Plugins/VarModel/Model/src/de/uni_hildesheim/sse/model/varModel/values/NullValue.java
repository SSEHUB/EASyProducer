package de.uni_hildesheim.sse.model.varModel.values;

import de.uni_hildesheim.sse.model.varModel.datatypes.AnyType;

/**
 * Defines the <b>null</b> value. The null value is instance of {@link AnyType}.
 * 
 * @author Holger Eichelberger
 */
public final class NullValue extends Value {

    /**
     * The only instance of the null value.
     */
    public static final Value INSTANCE = new NullValue();
    
    /**
     * The value to be returned by {@link #getValue()}. <b>null</b> would be
     * an alternative but this may break existing code.
     */
    public static final Object VALUE = new Object();
    
    /**
     * Creates a null value. Not visible due to singlton constant character.
     */
    private NullValue() {
        super(AnyType.TYPE);
    }
    
    @Override
    public Object getValue() {
        return VALUE;
    }

    @Override
    public void accept(IValueVisitor visitor) {
        visitor.visitNullValue(this);
    }

    @Override
    public void setValue(Object value) throws ValueDoesNotMatchTypeException {
        throw new ValueDoesNotMatchTypeException("cannot assign a value to 'null' (constant)", 
            ValueDoesNotMatchTypeException.IS_CONSTANT);
    }

    @Override
    public boolean isConfigured() {
        return true;
    }

    @Override
    public Value clone() {
        return this;
    }

}
