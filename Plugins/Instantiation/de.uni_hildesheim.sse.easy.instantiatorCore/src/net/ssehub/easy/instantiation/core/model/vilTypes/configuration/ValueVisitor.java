package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ConstraintValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.EnumValue;
import net.ssehub.easy.varModel.model.values.IValueVisitor;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.MetaTypeValue;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.RealValue;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.StringValue;
import net.ssehub.easy.varModel.model.values.VersionValue;

/**
 * Turns IVML values into VIL compatible values. No value is determined if
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
    private net.ssehub.easy.instantiation.core.model.vilTypes.configuration.EnumValue enumValue;
    
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
        Double result = doubleValue;
        // IVML can assign an integer to a real, which may cause problems in instantiator code
        // do implicit conversion here
        if (null == result && null != intValue) {
            result = Double.valueOf(intValue);
        }
        return result;
    }
    
    /**
     * Returns the obtained value as enum value. 
     * 
     * @return the obtained value, may be <b>null</b> if the value was of another type
     */
    public net.ssehub.easy.instantiation.core.model.vilTypes.configuration.EnumValue getEnumValue() {
        return enumValue;
    }
    
    @Override
    public void visitConstraintValue(ConstraintValue value) {
        // currently not relevant
    }

    @Override
    public void visitEnumValue(EnumValue value) {
        enumValue = new net.ssehub.easy.instantiation.core.model.vilTypes.configuration.EnumValue(value);
        this.value = enumValue;
    }

    @Override
    public void visitStringValue(StringValue value) {
        stringValue = value.getValue();
        this.value = stringValue;
    }

    @Override
    public void visitCompoundValue(CompoundValue value) {
        this.value = value;
    }

    @Override
    public void visitContainerValue(ContainerValue value) {
        this.value = value;
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
        // typed value via implicit dereferencing
        this.value = referenceValue; 
    }

    @Override
    public void visitMetaTypeValue(MetaTypeValue value) {
        // shall not occur
    }

    @Override
    public void visitNullValue(NullValue value) {
        this.value = TypeRegistry.NULL;
    }

    @Override
    public void visitVersionValue(VersionValue value) {
        // actually an internal, variables cannot have this type...
        stringValue = Version.toString(value.getValue());
        this.value = stringValue;
    }

}
