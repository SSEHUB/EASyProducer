package de.uni_hildesheim.sse.model.varModel;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Implements a decision variable.
 * 
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public class DecisionVariableDeclaration extends AbstractVariable implements IFreezable, IAttributableElement {

    // lazy initialization
    private List<Attribute> attributes;
    
    /**
     * Constructor for decision variable declaration.
     * @param name Name of the decision variable declaration
     * @param type type of the new VariableDeclaration
     * @param parent the object, in which this specific one is embedded
     */
    public DecisionVariableDeclaration(String name, IDatatype type, IModelElement parent) {
        super(name, type, null, parent);
    }
    
    /** 
     * Accept method for the visitor.
     * 
     * @param visitor The visitor, which should process this model element.
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitDecisionVariableDeclaration(this);
    }

    /**
     * Adds an attribute.
     * 
     * @param attribute the attribute to be added
     * @return <code>true</code> if the operation was successful,
     *   <code>false</code> if the element is about being attributed 
     *   multiple times with the same attribute
     */
    private boolean addAttribute(Attribute attribute) {
        if (null == attributes) {
            attributes = new ArrayList<Attribute>();
        }
        boolean found = false;
        for (int a = 0; !found && a < attributes.size(); a++) {
            found = attributes.get(a).getName().equals(attribute.getName());
            // consider namespace?
        }
        if (!found) {
            attributes.add(attribute);
        }
        return !found;
    }
    
    /**
     * Attributes this element.
     * 
     * @param attribute the attribute to be added
     * @return <code>true</code> if the operation was successful,
     *   <code>false</code> if the element is about being attributed 
     *   multiple times with the same attribute
     */
    public boolean attribute(Attribute attribute) {
        return addAttribute(attribute);
    }
    
    /**
     * Returns the number of attributes.
     * 
     * @return the number of attributes
     */
    public int getAttributesCount() {
        return null == attributes ? 0 : attributes.size();
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
        if (null == attributes) {
            throw new IndexOutOfBoundsException();
        }
        return attributes.get(index);
    }
    
    /**
     * Returns a specific attribute.
     * 
     * @param name the name of the attribute
     * @return the attribute (or <b>null</b> if not found)
     */
    public Attribute getAttribute(String name) {
        Attribute result = null;
        if (null != attributes) {
            for (int a = 0; null == result && a < attributes.size(); a++) {
                Attribute attr = attributes.get(a);
                if (attr.getName().equals(name)) {
                    result = attr;
                }
            }
        }
        return result;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTemporaryVariable() {
        return getParent() instanceof Constraint; // not nice :(
    }
    
    /**
     * Returns whether this variable is an attribute.
     * 
     * @return <code>true</code> if it is an attribute, <code>false</code> else
     */
    public boolean isAttribute() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean propagateAttribute(Attribute attribute) {
        return addAttribute(new Attribute(attribute.getName(), attribute.getType(), getParent(), this));
    }
    
}
