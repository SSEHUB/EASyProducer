package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Conversion;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Represents an IVML enum value.
 * 
 * @author Holger Eichelberger
 */
public class EnumValue extends IvmlElement {

    private net.ssehub.easy.varModel.model.values.EnumValue value;

    /**
     * Creates a new enum value.
     * 
     * @param value the IVML enum literal
     */
    public EnumValue(net.ssehub.easy.varModel.model.values.EnumValue value) {
        this.value = value;
    }
    
    /**
     * Returns the name of the enum literal.
     * 
     * @return the name of the literal
     */
    public String getName() {
        return value.getValue().getName();
    }

    /**
     * Returns the qualified name of the enum literal.
     * 
     * @return the qualified name of the literal
     */
    public String getQualifiedName() {
        return value.getValue().getQualifiedName();
    }
    
    /**
     * Returns the IVML data type.
     * 
     * @return the IVML data type
     */
    @Invisible
    public IDatatype getDatatype() {
        return value.getType();
    }

    @Override
    public String getType() {
        return value.getType().getName();
    }

    @Override
    public String getQualifiedType() {
        return value.getType().getQualifiedName();
    }

    @Override
    Attribute getAttribute(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    int getAttributeCount() {
        return 0;
    }
   
    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof EnumValue && value.equals(((EnumValue) object).value);
    }

    @Override
    public Object getValue() {
        return this;
    }

    @Override
    public IvmlElement getElement(String name) {
        return null;
    }

    @Override
    public String getStringValue() {
        return getName();
    }

    @Override
    public Integer getIntegerValue() {
        return value.getValue().getOrdinal();
    }
    
    /**
     * Returns the ordinal of the enum value.
     * 
     * @return the ordinal
     */
    public int getOrdinal() {
        return value.getValue().getOrdinal();
    }

    @Override
    public Double getRealValue() {
        return (double) value.getValue().getOrdinal();
    }

    @Override
    @Invisible
    public Boolean getBooleanValue() {
        return null;
    }

    @Override
    public EnumValue getEnumValue() {
        return this;
    }

    @Override
    protected void initializeAttributes() {
        // has no nested elements
    }

    @Override
    protected void initializeNested() {
        // has no attributes
    }
    
    /**
     * Converts an Enum value to a String by returning its (qualified) name.
     * 
     * @param value the value to be converted
     * @return the qualified name
     */
    @Conversion
    public static String convert(EnumValue value) {
        return value.getQualifiedName();
    }
    
}
