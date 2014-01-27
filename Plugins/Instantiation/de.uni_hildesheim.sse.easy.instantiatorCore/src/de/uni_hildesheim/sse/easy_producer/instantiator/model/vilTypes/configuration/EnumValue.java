package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

/**
 * Represents an IVML enum value.
 * 
 * @author Holger Eichelberger
 */
public class EnumValue extends IvmlElement {

    private de.uni_hildesheim.sse.model.varModel.values.EnumValue value;

    /**
     * Creates a new enum value.
     * 
     * @param value the IVML enum literal
     */
    EnumValue(de.uni_hildesheim.sse.model.varModel.values.EnumValue value) {
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
        return null;
    }

    @Override
    public Double getRealValue() {
        return null;
    }

    @Override
    public Boolean getBooleanValue() {
        return null;
    }

    @Override
    public EnumValue getEnumValue() {
        return null;
    }

    @Override
    protected void initializeAttributes() {
        // has no nested elements
    }

    @Override
    protected void initializeNested() {
        // has no attributes
    }
    
}
