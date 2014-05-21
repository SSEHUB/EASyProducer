package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.xml;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FragmentArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.IArtifactVisitor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;

/**
 * Represents a parsed XML attribute.
 * 
 * @author Holger Eichelberger
 */
public class XmlAttribute extends FragmentArtifact {

    private XmlElement parent;
    private String name;
    private String value;
    
    /**
     * Creates a new XML attribute.
     * 
     * @param parent the parent element
     * @param name the name of the attribute
     * @param value the name of the value
     */
    XmlAttribute(XmlElement parent, String name, String value) {
        this.parent = parent;
        this.name = name;
        this.value = value;
    }
    
    /**
     * Creates a new Attribute for given XmlElement, with given name and value.
     * @param parent The XmlElement the attribute is for.
     * @param name The name of the new attribute.
     * @param value The value of the new attribute.
     * @return The created XmlAttribute.
     * @throws ArtifactException if attribute could not be created.
     */
    public static XmlAttribute create(XmlElement parent, String name, String value) throws ArtifactException {       
        return create(parent, name, value, true);
    }
    
    /**
     * Creates a new Attribute for given XmlElement, with given name and value.
     * Overwrites by default.
     * 
     * @param parent The XmlElement the attribute is for.
     * @param name The name of the attribute.
     * @param value The value of the new attribute.
     * @param forceOverwrite True if existing attributes with same name shall be overwritten. Default = true.
     * @return The created XmlAttribute. The existing attribute if forceOverwrite is false.
     * @throws ArtifactException if attribute could not be created for different reason then pre-existance.
     */
    public static XmlAttribute create(XmlElement parent, String name, String value, boolean forceOverwrite) 
        throws ArtifactException {
        
        XmlAttribute newAttribute = null;
        
        if (null == parent) {
            throw new ArtifactException("Can not add attribute to NULL element!", ArtifactException.ID_IS_NULL);
        }
        
        Element parentElem = (Element) parent.getNode();
        if (forceOverwrite || !parentElem.hasAttribute(name)) {
            try {
                parentElem.setAttribute(name, value);
                newAttribute = parent.addAttribute(name, value);
            } catch (DOMException exc) {
                throw new ArtifactException("Invalid character, name or ID!", ArtifactException.ID_INVALID_CHARACTER);
            }
        } else {
            newAttribute = parent.getAttribute(name);
        }

        return newAttribute;
        
    }
    
    @Override
    public void delete() throws ArtifactException {
        checkValidity();
        parent.deleteAttribute(this);
        this.parent = null;
    }

    @Override
    public String getName() throws ArtifactException {
        checkValidity();
        return name;
    }
    
    /**
     * Returns the value of this attribute.
     * 
     * @return the value of this attribute
     * @throws ArtifactException in case that this object is invalid (was deleted)
     */
    public String getValue() throws ArtifactException {
        checkValidity();
        return value;
    }
    
    /**
     * Changes the value of this attribute.
     * 
     * @param value the new value of this attribute
     * @throws ArtifactException in case that this object is invalid (was deleted)
     */
    public void setValue(String value) throws ArtifactException {
        checkValidity();
        this.value = value;
        this.parent.getNode().getAttributes().getNamedItem(this.name).setNodeValue(value);
    }

    @Override
    public void rename(String name) throws ArtifactException {
        checkValidity();
        parent.renameAttribute(this, name);
    }

    @Override
    public Text getText() throws ArtifactException {
        checkValidity();
        return Text.CONSTANT_EMPTY;
    }

    @Override
    public Binary getBinary() throws ArtifactException {
        checkValidity();
        return Binary.CONSTANT_EMPTY;
    }

    @Override
    public void accept(IArtifactVisitor visitor) {
        visitor.visitFragmentArtifact(this);
    }
    
    /**
     * Returns the parent of this fragment.
     * 
     * @return the parent of this fragment
     */
    XmlElement getParent() {
        return parent;
    }
    
    /**
     * Sets a new parent for this fragment.
     * 
     * @param parent the new parent.
     */
    void setParent(XmlElement parent) {
        this.parent = parent;
    }
    
    /**
     * Checks the validity of this object.
     * 
     * @throws ArtifactException in case that this object is invalid
     */
    private void checkValidity() throws ArtifactException {
        if (null == parent) {
            throw new ArtifactException("attribute already deleted", ArtifactException.ID_INVALID);
        }
    }
    
    /**
     * Changes the name of this attribute.
     * @param name the new name of this attribute
     */
    void setName(String name) {
        this.name = name;
    }

    @Override
    public void update() throws ArtifactException {
        // TODO Auto-generated method stub
    }
    
}