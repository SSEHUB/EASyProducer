package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.datatypes.Compound;

/**
 * Represents an IVML declaration. This class is internal and shall not be registered in the
 * type factory. It is required as the {@link Configuration} may return only frozen elements (according to the actual 
 * {@link IVariableFilter}) with value but not declarations if needed. It maps to the use of an IVML identifier.
 * 
 * @author Holger Eichelberger
 */
public class IvmlDeclaration extends IvmlElement {

    private AbstractVariable variable;
    private IvmlDeclaration[] nested;
    private IvmlDeclaration[] attributes;

    /**
     * Creates a new declaration instance.
     * 
     * @param variable the variable to create the declaration for
     */
    public IvmlDeclaration(AbstractVariable variable) {
        this.variable = variable;
    }

    @Override
    protected void initializeNested() {
        if (null == nested && variable.getType().isAssignableFrom(Compound.TYPE)) {
            Compound type = (Compound) variable.getType();
            nested = new IvmlDeclaration[type.getElementCount()];
            for (int n = 0; n < nested.length; n++) {
                nested[n] = new IvmlDeclaration(type.getElement(n));
            }
        }
    }

    @Override
    protected void initializeAttributes() {
        if (null == attributes && variable.getAttributesCount() > 0) {
            attributes = new IvmlDeclaration[variable.getAttributesCount()];
            for (int a = 0; a < attributes.length; a++) {
                attributes[a] = new IvmlDeclaration(variable.getAttribute(a));
            }
        }
    }

    @Override
    public String getName() {
        return variable.getName();
    }

    @Override
    public String getQualifiedName() {
        return variable.getQualifiedName();
    }

    @Override
    public String getType() {
        return variable.getType().getName();
    }

    @Override
    public String getQualifiedType() {
        return variable.getType().getQualifiedName();
    }

    /**
     * Returns the specified nested element.
     * 
     * @param index the index of the nested element
     * @return the nested element
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getNestedCount()}</code>
     */
    IvmlElement getNested(int index) {
        initializeNested();
        if (null == nested) {
            throw new IndexOutOfBoundsException();
        }
        return nested[index];
    }

    /**
     * Returns the number of nested elements.
     * 
     * @return the number of nested elements
     */
    int getNestedCount() {
        initializeNested();
        return null == nested ? 0 : nested.length;
    }

    @Override
    IvmlElement getAttribute(int index) {
        initializeAttributes();
        if (null == attributes) {
            throw new IndexOutOfBoundsException();
        }
        return attributes[index];
    }

    @Override
    int getAttributeCount() {
        initializeAttributes();
        return null == attributes ? 0 : attributes.length;
    }

    @Invisible
    @Override
    public Object getValue() {
        return null; // variables to not have values
    }
    
    @Override
    public int hashCode() {
        return variable.hashCode();
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof AbstractIvmlVariable && variable.equals(((AbstractIvmlVariable) object).variable);
    }

    @Override
    public IvmlElement getElement(String name) {
        IvmlElement result = search(name, nested);
        if (null == result) {
            result = search(name, attributes);
        }
        return result;
    }

    @Invisible
    @Override
    public String getStringValue() {
        return null;
    }

    @Invisible
    @Override
    public Integer getIntegerValue() {
        return null;
    }

    @Invisible
    @Override
    public Double getRealValue() {
        return null;
    }

    @Invisible
    @Override
    public Boolean getBooleanValue() {
        return null;
    }

    @Invisible
    @Override
    public EnumValue getEnumValue() {
        return null;
    }
    
}
