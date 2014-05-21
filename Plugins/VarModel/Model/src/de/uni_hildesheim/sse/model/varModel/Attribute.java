package de.uni_hildesheim.sse.model.varModel;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Defines an attribute.
 * 
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public class Attribute extends AbstractVariable {

    private IAttributableElement element;
    private List<Attribute> series;
    
    /**
     * Constructor for an attribute.
     * @param name Name of the attribute
     * @param type the type of the attribute
     * @param parent the object, in which this specific one is embedded
     * @param element the element being attributed
     */
    public Attribute(String name, IDatatype type, IModelElement parent, IAttributableElement element) {
        super(name, type, parent);
        this.element = element;
    }
    
    /** 
     * {@inheritDoc}
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitAttribute(this);
    }
    
    /**
     * Returns the attributed element.
     * 
     * @return the attributed element
     */
    public IAttributableElement getElement() {
        return element;
    }

    /**
     * Returns the number of attributes.
     * 
     * @return the number of attributes
     */
    public int getAttributesCount() {
        return 0; // nested attributes are not supported
    }
    
    /**
     * Returns a specific attribute.
     * 
     * @param index the index of the attribute
     * @return the attribute
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getAttributesCount()}</code>
     */
    public Attribute getAttribute(int index) {
        throw new IndexOutOfBoundsException(); // nested attributes are not supported
    }
    
    /**
     * Returns a specific attribute.
     * 
     * @param name the name of the attribute
     * @return the attribute (or <b>null</b> if not found)
     */
    public Attribute getAttribute(String name) {
        return null;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTemporaryVariable() {
        return false; // attributes are never temporary
    }
    
    /**
     * Returns whether this variable is an attribute.
     * 
     * @return <code>true</code> if it is an attribute, <code>false</code> else
     */
    public boolean isAttribute() {
        return true;
    }
    
    /**
     * Adds an attribute to this as the first one declared in the same statement.
     * Used for output only.
     * 
     * @param attribute the attribute to be added
     */
    public void addSeries(Attribute attribute) {
        assert null != attribute;
        if (null == series) {
            series = new ArrayList<Attribute>();
        }
        series.add(attribute);
    }

    /**
     * Returns the number of series entries.
     * 
     * @return the number of series entries
     */
    public int getSeriesCount() {
        return null == series ? 0 : series.size();
    }
    
    /**
     * Returns the specified series element.
     * 
     * @param index the index of the element to return
     * @return the specified series element
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getSeriesCount()}</code>
     */
    public Attribute getSeries(int index) {
        return series.get(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        //Following the overridden hashcode in AbstractVariable
        int hashCode = super.hashCode() * getElement().hashCode();
        /*
        if (null != getDefaultValue()) {
            hashCode *= getDefaultValue().hashCode();
        }*/
        return hashCode;
    }
    
    /**
     * Returns a textual representation of this element.
     * 
     * @return a textual representation
     */
    @Override
    public String toString() {
        return getElement().getName() + "." + getName();
    }
    
}
