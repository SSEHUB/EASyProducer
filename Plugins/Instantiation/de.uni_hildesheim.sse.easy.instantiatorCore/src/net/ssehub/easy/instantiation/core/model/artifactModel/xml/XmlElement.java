package net.ssehub.easy.instantiation.core.model.artifactModel.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import net.ssehub.easy.instantiation.core.model.artifactModel.CompositeFragmentArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.FragmentArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactChangedListener;
import net.ssehub.easy.instantiation.core.model.artifactModel.IArtifactVisitor;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Binary;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Text;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Represents a parsed XML element with contained attributes.
 * 
 * @author Holger Eichelberger
 * @author Patrik Pastuschek
 */
public class XmlElement extends CompositeFragmentArtifact implements IXmlContainer, IStringValueProvider, 
    IArtifactChangedListener {

    private XmlElement[] elements;
    private XmlAttribute[] attributes; // lazy, elements may be null if deleted
    private String name;
    private XmlElement parent;
    private Text text;
    private Text cdata;
    private Node node;
    
    /**
     * Creates a new XML element fragment artifact.
     * 
     * @param parent the parent artifact
     * @param name the name of the element
     * @param attributes the attributes
     * @param node the node that is represented by this XmlElement
     */
    XmlElement(XmlElement parent, String name, XmlAttribute[] attributes, Node node) {
        this.parent = parent;
        this.name = name;
        this.attributes = attributes;
        this.node = node;
    }

    /**
     * Creates a new XmlElement as child of given parent, with given name.
     * @param parent The parent of the new XmlElement.
     * @param name The name of the new XmlElement.
     * @return The created XmlElement.
     * @throws VilException if element could not be created.
     */
    public static XmlElement create(XmlElement parent, String name) throws VilException {
        XmlElement newElement = null;
        if (null == parent) {
            throw new VilException("Can not append child from NULL element!", VilException.ID_IS_NULL);
        }
        try {
            Element newNode = parent.getNode().getOwnerDocument().createElement(name);
            parent.getNode().appendChild(newNode); // notifies change
            newElement = new XmlElement(parent, name, null, newNode);
            parent.addChild(newElement); // notifies change
        } catch (DOMException exc) {
            throw new VilException("Invalid character, name or ID!", VilException.ID_INVALID);
        }
        return newElement;
    }
    
    /**
     * Creates a new XmlElement as child of the root element of the given file artifact, with given name.
     * @param parent The parent of the new XmlElement.
     * @param name The name of the new XmlElement.
     * @return The created XmlElement.
     * @throws VilException if element could not be created.
     */
    public static XmlElement create(XmlFileArtifact parent, String name) throws VilException {
        return create(parent.getRootElement(), name); // notifies change
    }
    
    @Override
    public void delete() throws VilException {
        checkValidity();
        checkRoot();
        parent.deleteChild(this);
        this.node.getParentNode().removeChild(this.node);
        this.node = null;
        this.parent = null;
    }
    
    /**
     * Removes a child from this Element.
     * @param child the child that is to be removed.
     */
    void deleteChild(XmlElement child) {
        for (int i = 0; i < this.elements.length; i++) {
            if (elements[i] == child) {
                elements[i] = null;
                XmlElement[] newElements = new XmlElement[this.elements.length - 1];
                for (int j = 0; j < newElements.length; j++) {
                    if (j < i) {
                        newElements[j] = elements[j];
                    } else {
                        newElements[j] = elements[j + 1];
                    }
                }
                i = this.elements.length;
                this.elements = newElements;
                notifyChange();
            }
        }        
    }

    @Override
    public String getName() throws VilException {
        //checkValidity();
        return name;
    }

    @Override
    public void rename(String name) throws VilException {
        //checkValidity();
        checkRoot();
        this.name = name;
        Element newNode = (node.getOwnerDocument().createElement(name));
        newNode.setNodeValue(this.node.getNodeValue());
        if (this.text != null) {
            newNode.setTextContent(this.node.getTextContent());
        } else if (this.cdata != null) {
            newNode.appendChild((node.getOwnerDocument().createCDATASection(this.cdata.getText())));
        }
        for (int i = 0; i < elements.length; i++) {
            newNode.appendChild(elements[i].getNode());
        }
        for (int i = 0; i < attributes.length; i++) {
            newNode.setAttribute(attributes[i].getName(), attributes[i].getValue());
        }
        this.node.getParentNode().insertBefore(newNode, this.node);
        this.node.getParentNode().removeChild(this.node);
        this.node = newNode;
        notifyChange();
    }

    @Override
    public Text getText() throws VilException {
        //checkValidity();
        if (null == this.text) {
            this.text = new Text(true);
        }
        return this.text;
    }
    
    @Override
    public Binary getBinary() throws VilException {
        //checkValidity();
        return new Binary("", true); // TODO to be replaced by parsed text
    }

    @Override
    public void accept(IArtifactVisitor visitor) {
        visitor.visitCompositeFragmentArtifact(this);
    }

    @Override
    @OperationMeta(returnGenerics = FragmentArtifact.class)
    public Set<? extends FragmentArtifact> selectAll() throws VilException {
        //checkValidity();
        return new ArraySet<XmlAttribute>(attributes, FragmentArtifact.class);
    }
    
    @Override
    public boolean exists() {
        boolean exists = true;
        try {
            checkValidity();
        } catch (VilException exc) {
            exists = false;
        }
        return exists;
    }

    /**
     * Returns all attributes.
     * 
     * @return the attributes
     * @throws VilException in case that access is not possible
     */
    @OperationMeta(returnGenerics = XmlAttribute.class)
    public Set<XmlAttribute> attributes() throws VilException {
        //checkValidity();
        return new ArraySet<XmlAttribute>(attributes, XmlAttribute.class);
    }

    /**
     * Returns all elements.
     * 
     * @return the elements
     * @throws VilException in case that access is not possible
     */
    @OperationMeta(returnGenerics = XmlElement.class)
    public Set<XmlElement> elements() throws VilException {
        //checkValidity();         
        return new ArraySet<XmlElement>(elements, XmlElement.class);
    }
    
    /**
     * Returns a specific attribute.
     * 
     * @param name the name of the attribute (may be a regular expression)
     * @return the attribute or <b>null</b> if there is none
     * @throws VilException in case of already deleted attributes
     */
    public XmlAttribute getAttribute(String name) throws VilException {
        //checkValidity();
        XmlAttribute result = null;
        if (null != attributes) {
            List<VilException> caught = null;
            Pattern pattern;
            try {
                pattern = Pattern.compile(name);
            } catch (PatternSyntaxException e) {
                pattern = null;
            }
            for (int a = 0; null == result && a < attributes.length; a++) {
                XmlAttribute attr = attributes[a];
                if (null != attr) {
                    try {
                        String aName = attr.getName();
                        if (aName.equals(name)) {
                            result = attr;
                        } else if (null != pattern) {
                            if (pattern.matcher(aName).matches()) {
                                result = attr;
                            }
                        }
                    } catch (VilException e) {
                        if (null == caught) {
                            caught = new ArrayList<VilException>();
                        }
                        caught.add(e);
                    }
                }
            }
            if (null != caught && !caught.isEmpty()) {
                throw new VilException(caught);
            }
        }
        return result;
    }
    
    /**
     * Directly modifies an attribute. [convenience]
     * 
     * @param name the name of the attribute
     * @param value the new value of the attribute
     * @throws VilException in case that the attribute cannot be found
     */
    public void setAttribute(String name, String value) throws VilException {
        //checkValidity();
        checkRoot();
        if (null != attributes) {
            for (int a = 0; a < attributes.length; a++) {
                XmlAttribute attr = attributes[a];
                if (null != attr) {
                    String aName = attr.getName();
                    if (aName.equals(name)) {
                        attr.setValue(value);
                        if (this.node.getNodeType() == Node.ELEMENT_NODE) {
                            Element element = (Element) this.getNode();
                            element.setAttribute(name,  value);
                            notifyChange();
                        }
                        break;
                    }
                }
            }
        }
    }

    /**
     * Returns a specific attribute.
     * 
     * @param regEx a regular expression specifying the attributes to be selected
     * @return the set of attribute, being empty if there is none
     * @throws VilException in case that <code>regEx</code> is invalid
     */
    @OperationMeta(returnGenerics = XmlAttribute.class)
    public Set<XmlAttribute> selectAttributeByRegex(String regEx) throws VilException {
        //checkValidity();
        List<XmlAttribute> result = new ArrayList<XmlAttribute>();
        Pattern pattern;
        try {
            pattern = Pattern.compile(regEx);
        } catch (PatternSyntaxException e) {
            throw new VilException(e, VilException.ID_PATTERN);
        }
        if (null != attributes) {
            for (int a = 0; a < attributes.length; a++) {
                XmlAttribute attr = attributes[a];
                if (null != attr) {
                    String aName = attr.getName();
                    if (pattern.matcher(aName).matches()) {
                        result.add(attr);
                    }
                }
            }
        }
        return new ListSet<XmlAttribute>(result, XmlAttribute.class);
    }
    
    @Override
    @OperationMeta(returnGenerics = XmlElement.class)
    public Set<XmlElement> selectByName(String name) throws VilException {
        return selectByName(name, true);
    }
    
    @Override
    @OperationMeta(returnGenerics = XmlElement.class)
    public Set<XmlElement> selectByPath(String path) throws VilException {
        return PathUtils.selectByPath(this, PathUtils.normalize(path));
    }
    
    @Override
    @OperationMeta(returnGenerics = XmlElement.class)
    public Set<XmlElement> selectByXPath(String path) throws VilException {
        return PathUtils.selectByXPath(path, node, this);
    }
    
    /**
     * Returns a Set with all XmlElements matching name. Childs are processed aswell. <br>
     * Case sensitivity can be set.
     * 
     * @param name The required name.
     * @param caseSensitive True if case-sensitive, false otherwise.
     * @return set with matching XmlElements.
     * @throws VilException in case that invalid Elements are used.
     */
    @OperationMeta(returnGenerics = XmlElement.class)
    public Set<XmlElement> selectByName(String name, boolean caseSensitive) throws VilException {
        //checkValidity();
        List<XmlElement> result = new ArrayList<XmlElement>();
        if (caseSensitive) {
            if (this.name.equals(name)) {
                result.add(this);
            }
        } else {
            if (this.name.equalsIgnoreCase(name)) {
                result.add(this);
            }
        }
        if (null != this.elements) {
            for (int i = 0; i < this.elements.length; i++) {
                if (this.elements[i] != null) {
                    Iterator<XmlElement> subIterator = this.elements[i].selectByName(name, caseSensitive).iterator();
                    while (subIterator.hasNext()) {
                        result.add(subIterator.next());
                    }
                }
//                Iterator<XmlElement> subIterator = this.elements[i].selectByName(name, caseSensitive).iterator();
//                while (subIterator.hasNext()) {
//                    result.add(subIterator.next());
//                }
            }
        }
        return new ListSet<XmlElement>(result, XmlElement.class);
    }
    
    /**
     * Returns a set of all XmlElements specified by regEx. Childs are processed aswell. <br><br>
     * To get a set of all XmlElements having a certain pre- and suffix use: <br>
     * &emsp; <b>prefix.*suffix</b> <i>(replace prefix and suffix)</i>. <br>
     * To enable case insensitivity use <b>(?i)</b> : <br>
     * &emsp; <b>(?i) cASe iS noT imPORtaNt</b>
     * 
     * @param regEx a regular expression specifying the elements to be selected
     * @return Set of XmlElements matching the regEx.
     * @throws VilException in case that invalid Elements are used.
     */
    @OperationMeta(returnGenerics = XmlElement.class)
    public Set<XmlElement> selectByRegEx(String regEx) throws VilException {
        //checkValidity();
        List<XmlElement> result = new ArrayList<XmlElement>();
        Pattern pattern;
        try {
            pattern = Pattern.compile(regEx);
        } catch (PatternSyntaxException e) {
            throw new VilException(e, VilException.ID_PATTERN);
        }
        if (pattern.matcher(this.getName()).matches()) {
            result.add(this);
        }
        for (int i = 0; i < this.elements.length; i++) {
            Iterator<XmlElement> subIterator = this.elements[i].selectByRegEx(regEx).iterator();
            while (subIterator.hasNext()) {
                result.add(subIterator.next());
            }
        }
        return new ListSet<XmlElement>(result, XmlElement.class);
    }
    
    /**
     * Deletes an attribute (internal function, called from attribute).
     * 
     * @param attribute the attribute to be deleted.
     */
    void deleteAttribute(XmlAttribute attribute) {
        if (null != attributes) {
            for (int a = 0; a < attributes.length; a++) {
                if (attributes[a] == attribute) {
                    try {
                        this.node.getAttributes().removeNamedItem(attribute.getName());
                    } catch (DOMException e) {
                        e.printStackTrace();
                    } catch (VilException e) {
                        e.printStackTrace();
                    }
                    attributes[a] = null;
                    notifyChange();
                    break;
                }
            }
        }
    }

    /**
     * Renames an Attribute (internal called from XmlAttribute).
     * 
     * @param attribute the attribute to be renamed.
     * @param name the new name of this attribute
     * @throws VilException in case that invalid attributes are used
     */
    void renameAttribute(XmlAttribute attribute, String name) throws VilException {
        if (null != attributes) {
            List<VilException> caught = null;
            boolean foundAttribute = false;
            boolean foundName = false;
            for (int a = 0; a < attributes.length; a++) {
                XmlAttribute attr = attributes[a];
                foundAttribute |= (attr == attribute);
                try {
                    foundName |= (attr != attribute && attr.getName().equals(name));
                } catch (VilException e) {
                    if (null == caught) {
                        caught = new ArrayList<VilException>();
                    }
                    caught.add(e);
                }
            }
            if (foundAttribute && !foundName) {
                this.node.getAttributes().removeNamedItem(attribute.getName());
                Element element = (Element) this.node;
                element.setAttribute(name, attribute.getValue());
                attribute.setName(name);
                notifyChange(attribute);
            }
            if (null != caught && !caught.isEmpty()) {
                throw new VilException(caught);
            }
        }
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
     * Checks the validity of this object.
     * 
     * @throws VilException in case that this object is invalid
     */
    private void checkValidity() throws VilException {
        if (null == this.node) {
            throw new VilException("element already deleted", VilException.ID_INVALID);
        }
    }
    
    /**
     * Checks if this object represents the Root element. Root elements can not be changed.
     * @throws VilException in case that this object is the root element.
     */
    private void checkRoot() throws VilException {
        if (null != this.node && this.node.getOwnerDocument().getDocumentElement() == this.node) {
            throw new VilException("root element can not be changed", VilException.ID_SECURITY);
        }        
    }

    /**
     * Changes the name of this element.
     * @param name the new name of this element.
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Replaces the "sub-elements" of this element.
     * @param elements An array with all elements.
     */
    void setElements(XmlElement[] elements) {
        this.elements = elements;
    }
    
    /**
     * Returns the node that is represented by this object.
     * @return The represented node.
     */
    Node getNode() {
        return this.node;   
    }
    
    /**
     * Sets the cdata of the element.
     * 
     * @param cdata String of the cdata to store
     * @throws VilException in case that reading fails for some reason
     */
    public void setCdata(String cdata) throws VilException {
        if (null == this.cdata) {
            this.cdata = new Text(cdata, true);
            this.cdata.getListeners().registerListener(this);
        } else {
            this.cdata.setText(cdata);
        }
    }
    
    /**
     * Returns the cdata of the element.
     * @return the cdata information of this element. Null if there is no cdata
     * @throws VilException if element is invalid.
     */
    public Text getCdata() throws VilException {
        if (null == cdata) {
            setCdata("");
        }
        //checkValidity();
        return this.cdata;
    }
    
    /**
     * Checks whether this element has child as a child.
     * @param child the child element to check for.
     * @return true if child is a child. false otherwise.
     */
    boolean hasChild(XmlElement child) {
        boolean has = false;
        for (int i = 0; i < this.elements.length; i++) {
            if (elements[i] == child) {
                has = true;
                i = this.elements.length;
            }
        }
        return has;
    }
    
    @Override
    public void update() throws VilException {
        //Method not needed at the moment.
    }
    
    //TODO We should really consider to change the arrays to some sort of list for better performance!!!
    /**
     * Adds a child XmlElement to this XmlElement.
     * @param child The new child.
     * @throws VilException If child could not be added.
     */
    void addChild(XmlElement child) throws VilException {
        if (null == child) {
            throw new VilException("NULL can not be added as a child of an XmlElement!", 
                VilException.ID_IS_NULL);
        }
        XmlElement[] newElements;
        if (null != this.elements) {
            newElements = new XmlElement[this.elements.length + 1];
        } else {
            newElements = new XmlElement[1];
        }
        for (int i = 0; i < (newElements.length - 1); i++) {
            newElements[i] = this.elements[i];
        }
        newElements[newElements.length - 1] = child;
        this.elements = newElements;
        notifyChange();
    }
    
    /**
     * Appends a new child. Default position is after last child of the parent.
     * 
     * @param child The new child XmlElement.
     * @param childNode The new child Node.
     * @return The created XmlElement.
     * @throws VilException If child could not be appended.
     */
    XmlElement appendChild(XmlElement child, Node childNode) throws VilException {
        if (null == child || null == childNode) {
            throw new VilException("NULL can not be added as a child of an XmlElement!", 
                VilException.ID_IS_NULL);
        }
        this.insertElement(child, this.elements[this.elements.length - 1]);
        try {
            this.node.appendChild(childNode);
        } catch (DOMException exc) {
            throw new VilException("Unable to append a child from a " + this.node.getNodeName() + " Node!", 
                VilException.ID_INVALID);
        }
        notifyChange();
        return child;
    }
    
    /**
     * Adds an attribute to this XmlElement.
     * 
     * @param name The name of the new attribute.
     * @param value The value of the new attribute.
     * @return The created attribute.
     * @throws VilException If attribute could not be added.
     */
    XmlAttribute addAttribute(String name, String value) throws VilException {
        return addAttribute(name, value, true);
    }
    
    /**
     * Adds an attribute to this XmlElement. Overwrites by default.
     * 
     * @param name The name of the new attribute.
     * @param value The value of the new attribute.
     * @param forceOverwrite True if existing attributes with same name shall be overwritten. Default = true.
     * @return The created attribute.
     * @throws VilException If attribute could not be added.
     */
    XmlAttribute addAttribute(String name, String value, boolean forceOverwrite) throws VilException {
        XmlAttribute previousAtt = this.getAttribute(name);
        XmlAttribute newAtt = null;
        if (previousAtt == null) {
            XmlAttribute[] newAttributes;
            if (null != this.attributes) {
                newAttributes = new XmlAttribute[this.attributes.length + 1];
            } else {
                newAttributes = new XmlAttribute[1];
            }
            for (int i = 0; i < (newAttributes.length - 1); i++) {
                newAttributes[i] = this.attributes[i];
            }
            newAtt = new XmlAttribute(this, name, value);
            newAttributes[newAttributes.length - 1] = newAtt;
            this.attributes = newAttributes;
        } else {
            previousAtt.setValue(value);
            ((Element) this.getNode()).setAttribute(name, value);
            newAtt = previousAtt;
        }  
        notifyChange();
        return newAtt;
    }
    
    /**
     * Inserts an XmlElement at a certain position.
     * @param elem The XmlElement that is to be inserted.
     * @param previous The XmlElement previous to the new XmlElement. If null, XmlElement will be inserted as first.
     * @throws VilException if XmlElement could not be inserted for whatever reason.
     */
    private void insertElement(XmlElement elem, XmlElement previous) throws VilException {
        if (null == elem) {
            throw new VilException("Tried to insert NULL element as child!", VilException.ID_IS_NULL);
        }
        XmlElement[] newElements;
        if (null != this.elements) {
            newElements = new XmlElement[this.elements.length + 1];
        } else {
            newElements = new XmlElement[1];
        }
        for (int i = 0; i < (newElements.length - 1); i++) {
            newElements[i] = this.elements[i];
            if (null != previous && newElements[i].equals(previous)) {
                newElements[i + 1] = elem;
                i++;
            }
        }
        if (null == previous) {
            newElements[newElements.length - 1] = elem;
        }
        this.elements = newElements;
        notifyChange();
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "xmlElement \"" + name + "\"";
    }

    @Invisible
    @Override
    public void artifactChanged(Object cause) throws VilException {
        node.setTextContent(cdata.getText());
        notifyChange(this);
    }

    /**
     * Returns the parent XML file artifact.
     * 
     * @return the parent file artifact, may be <b>null</b>
     */
    @Invisible
    XmlFileArtifact getFile() {
        return null != parent ? parent.getFile() : null;
    }

    /**
     * Notifies the containing file about a change through this object.
     */
    protected void notifyChange() {
        notifyChange(this);
    }
    
    /**
     * Notifies the containing file about a change.
     * 
     * @param cause the causing object
     */
    void notifyChange(Object cause) {
        XmlFileArtifact file = getFile();
        if (null != file) {
            try { 
                file.artifactChanged(cause);
            } catch (VilException e) {
            }
        }
    }
    
}
