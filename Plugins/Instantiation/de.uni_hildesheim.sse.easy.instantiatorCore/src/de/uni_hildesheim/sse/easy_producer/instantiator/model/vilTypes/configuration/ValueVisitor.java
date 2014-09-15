package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.model.varModel.values.BooleanValue;
import de.uni_hildesheim.sse.model.varModel.values.CompoundValue;
import de.uni_hildesheim.sse.model.varModel.values.ConstraintValue;
import de.uni_hildesheim.sse.model.varModel.values.ContainerValue;
import de.uni_hildesheim.sse.model.varModel.values.EnumValue;
import de.uni_hildesheim.sse.model.varModel.values.IValueVisitor;
import de.uni_hildesheim.sse.model.varModel.values.IntValue;
import de.uni_hildesheim.sse.model.varModel.values.MetaTypeValue;
import de.uni_hildesheim.sse.model.varModel.values.NullValue;
import de.uni_hildesheim.sse.model.varModel.values.RealValue;
import de.uni_hildesheim.sse.model.varModel.values.ReferenceValue;
import de.uni_hildesheim.sse.model.varModel.values.StringValue;

/**
 * Turns IVML values into VIL compatible values. No value was determined if
 * at least {@link #getValue()} returns null.
 * 
 * @author Holger Eichelberger
 */
class ValueVisitor implements IValueVisitor {

    private Object value;
    private String stringValue;
    private Boolean booleanValue;
    private Integer intValue;
    private Double doubleValue;
    private de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.EnumValue enumValue;
    
    /**
     * Clears this visitor for reuse.
     */
    public void clear() {
        value = null;
        stringValue = null;
        booleanValue = null;
        intValue = null;
        doubleValue = null;
        enumValue = null;
    }
    
    /**
     * Returns the obtained object value.
     * 
     * @return the obtained object value
     */
    public Object getValue() {
        return value;
    }
    
    /**
     * Returns the obtained value as int. 
     * 
     * @return the obtained value, may be <b>null</b> if the value was of another type
     */
    public Integer getIntegerValue() {
        return intValue;
    }
    
    /**
     * Returns the obtained value as string. 
     * 
     * @return the obtained value, may be <b>null</b> if the value was of another type
     */
    public String getStringValue() {
        return stringValue;
    }
    
    /**
     * Returns the obtained value as boolean. 
     * 
     * @return the obtained value, may be <b>null</b> if the value was of another type
     */
    public Boolean getBooleanValue() {
        return booleanValue;
    }
    
    /**
     * Returns the obtained value as double. 
     * 
     * @return the obtained value, may be <b>null</b> if the value was of another type
     */
    public Double getDoubleValue() {
        return doubleValue;
    }
    
    /**
     * Returns the obtained value as enum value. 
     * 
     * @return the obtained value, may be <b>null</b> if the value was of another type
     */
    public de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.EnumValue getEnumValue() {
        return enumValue;
    }
    
    @Override
    public void visitConstraintValue(ConstraintValue value) {
        // currently not relevant
    }

    @Override
    public void visitEnumValue(EnumValue value) {
        enumValue = new de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.EnumValue(value);
        this.value = enumValue;
    }

    @Override
    public void visitStringValue(StringValue value) {
        stringValue = value.getValue();
        this.value = stringValue;
    }

    @Override
    public void visitCompoundValue(CompoundValue value) {
        // via variables()
    }

    @Override
    public void visitContainerValue(ContainerValue value) {
        // via variables()
    }

    @Override
    public void visitIntValue(IntValue value) {
        intValue = value.getValue();
        this.value = intValue;
    }

    @Override
    public void visitRealValue(RealValue value) {
        doubleValue = value.getValue();
        this.value = doubleValue;
    }

    @Override
    public void visitBooleanValue(BooleanValue value) {
        booleanValue = value.getValue();
        this.value = booleanValue;
    }

    @Override
    public void visitReferenceValue(ReferenceValue referenceValue) {
    }

    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
    }

    @Override
    public void visitNullValue(NullValue value) {
        this.value = TypeRegistry.NULL;
    }

}
