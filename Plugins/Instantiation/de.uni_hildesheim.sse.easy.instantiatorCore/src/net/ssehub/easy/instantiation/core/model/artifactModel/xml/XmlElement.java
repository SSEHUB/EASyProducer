package net.ssehub.easy.instantiation.core.model.artifactModel.xml;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.artifactModel.FragmentArtifact;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.ParameterMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Represents a parsed XML element with contained attributes.
 * 
 * @author Holger Eichelberger
 * @author Patrik Pastuschek
 */
public class XmlElement extends XmlNode implements IXmlContainer {

    private XmlNode[] nodes;
    private XmlAttribute[] attributes; // lazy, elements may be null if deleted
    private String name;
    
    /**
     * Creates a new XML element fragment artifact.
     * 
     * @param parent the parent artifact
     * @param name the name of the element
     * @param attributes the attributes
     * @param node the node that is represented by this XmlElement
     */
    XmlElement(XmlElement parent, String name, XmlAttribute[] attributes, Node node) {
        super(parent, node);
        this.name = name;
        this.attributes = attributes;
    }

    /**
     * Creates a new XmlElement as child of given parent, with given name.
     * @param parent The parent of the new XmlElement.
     * @param name The name of the new XmlElement.
     * @param contents optional initial contents, ignored if empty
     * @return The created XmlElement.
     * @throws VilException if element could not be created.
     */
    public static XmlElement create(XmlElement parent, String name, 
        @ParameterMeta(name = "contents") String contents) throws VilException {
        XmlElement newElement = null;
        if (null == parent) {
            throw new VilException("Can not append child from NULL element!", VilException.ID_IS_NULL);
        }
        try {
            Element newNode = parent.getNode().getOwnerDocument().createElement(name);
            parent.getNode().appendChild(newNode); // notifies change
            newElement = new XmlElement(parent, name, null, newNode);
            parent.addChild(newElement); // notifies change
            parent.synchronizeAttributeSequence();
        } catch (DOMException exc) {
            throw new VilException("Invalid character, name or ID!", VilException.ID_INVALID);
        }
        if (null != contents && contents.length() > 0) {
            newElement.setCdata(contents);
        }
        return newElement;
    }
    
    /**
     * Creates a new XmlElement as child of the root element of the given file artifact, with given name.
     * @param parent The parent of the new XmlElement.
     * @param name The name of the new XmlElement.
     * @param contents optional initial contents, ignored if empty
     * @return The created XmlElement.
     * @throws VilException if element could not be created.
     */
    public static XmlElement create(XmlFileArtifact parent, String name, 
        @ParameterMeta(name = "contents") String contents) throws VilException {
        return create(parent.getRootElement(), name, contents); // notifies change
    }

    /**
     * Findes a field called <code>name</code> in <code>cls</code> or one of its super
     * classes except for Object (not needed here).
     * 
     * @param cls the class to search
     * @param name the name of the field
     * @return the field or <b>null</b> if not found
     */
    private Field findField(Class<?> cls, String name) {
        Field result = null;
        if (null != cls && Object.class != cls) {
            try {
                result = cls.getDeclaredField(name);
            } catch (NoSuchFieldException e) {
                result = findField(cls.getSuperclass(), name);
            }
        }
        return result;
    }

    /**
     * Synchronizes the attribute sequence. This is a horrible hack. Reason: Extending 
     * JDK-Xalan is not really possible (restricted access, implementation requires certain
     * class hierarchy preventing delegation) and we do not want to extend the EASy deployment
     * by Eclipse-Xalan and its dependency. So access the attribute implementation and sort
     * the nodes in there accordingly.
     */
    void synchronizeAttributeSequence() {
        XmlFileArtifact artifact = getFile();
        boolean synchronize = null != artifact ? artifact.synchronizeAttributeSequence() : true;
        if (synchronize && null != attributes && attributes.length > 1) {
            NamedNodeMap attr = getNode().getAttributes();
            Class<?> nnmClass = attr.getClass();
            Field fNodes = findField(nnmClass, "nodes");
            Object nnmNodes = null;
            if (null != fNodes) {
                fNodes.setAccessible(true);
                try {
                    nnmNodes = fNodes.get(attr);
                } catch (SecurityException e) {
                    logSequenceException("Security", e);
                } catch (IllegalArgumentException e) {
                    logSequenceException("Illegal argument", e);
                } catch (IllegalAccessException e) {
                    logSequenceException("Illegal access", e);
                }
            } else {
                logSequenceException("No nodes field", null);
            }
            if (nnmNodes instanceof List) {
                @SuppressWarnings("unchecked")
                List<Node> lNodes = (List<Node>) nnmNodes;
                Collections.sort(lNodes, new NodeComparator(attributes));
            }
        }
    }

    /**
     * Logs a sequence synchronization exception.
     * 
     * @param text the text indicating the problem stated by the exception
     * @param ex the exception detailing the problem (may be <b>null</b>)
     */
    private void logSequenceException(String text, Exception ex) {
        String name;
        try {
            name = getName();
        } catch (VilException e) {
            name = "?";
        }
        EASyLoggerFactory.INSTANCE.getLogger(XmlElement.class, Bundle.ID).error(
            "Cannot change sequence of XML attributes for element " + name + ": " + text 
            + (null == ex ? "" : " " + ex.getMessage()));
    }
    
    /**
     * A (attribute) node comparator based on XML attributes.
     * 
     * @author Holger Eichelberger
     */
    private static class NodeComparator implements Comparator<Node> {

        private HashMap<String, Integer> pos = new HashMap<String, Integer>();
        
        /**
         * Creates the comparator.
         * 
         * @param attributes the attributes in sequence
         */
        private NodeComparator(XmlAttribute[] attributes) {
            for (int a = 0; a < attributes.length; a++) {
                try {
                    pos.put(attributes[a].getName(), a);
                } catch (VilException e) {
                }
            }
        }
        
        @Override
        public int compare(Node o1, Node o2) {
            int result;
            Integer p1 = pos.get(o1.getNodeName());
            Integer p2 = pos.get(o2.getNodeName());
            if (p1 != null && pos != null) {
                result = Integer.compare(p1, p2);
            } else {
                result = 1;
            }
            return result;
        }
        
    }

    @Override
    void deleteChild(XmlNode child) {
        for (int i = 0; i < this.nodes.length; i++) {
            if (nodes[i] == child) {
                nodes[i] = null;
                XmlNode[] newElements = new XmlNode[this.nodes.length - 1];
                for (int j = 0; j < newElements.length; j++) {
                    if (j < i) {
                        newElements[j] = nodes[j];
                    } else {
                        newElements[j] = nodes[j + 1];
                    }
                }
                i = this.nodes.length;
                this.nodes = newElements;
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
        Element newNode = (getNode().getOwnerDocument().createElement(name));
        newNode.setNodeValue(getNode().getNodeValue());
        if (this.getTextDirect() != null) {
            newNode.setTextContent(getNode().getTextContent());
        } else if (getCdataDirect() != null) {
            newNode.appendChild((getNode().getOwnerDocument().createCDATASection(getCdataDirect().getText())));
        }
        for (int i = 0; i < nodes.length; i++) {
            newNode.appendChild(nodes[i].getNode());
        }
        for (int i = 0; i < attributes.length; i++) {
            newNode.setAttribute(attributes[i].getName(), attributes[i].getValue());
        }
        getNode().getParentNode().insertBefore(newNode, getNode());
        getNode().getParentNode().removeChild(getNode());
        setNode(newNode);
        notifyChange();
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
    public Sequence<XmlAttribute> attributes() throws VilException {
        //checkValidity();
        return new ArraySequence<XmlAttribute>(attributes, XmlAttribute.class);
    }

    /**
     * Returns all nested nodes in sequence.
     * 
     * @return the nodes
     * @throws VilException in case that access is not possible
     */
    @OperationMeta(returnGenerics = XmlNode.class)
    public Set<XmlNode> nodes() throws VilException {
        //checkValidity();         
        return new ArraySet<XmlNode>(nodes, XmlNode.class);
    }

    /**
     * Returns all nested comments in sequence.
     * 
     * @return the elements
     * @throws VilException in case that access is not possible
     */
    @OperationMeta(returnGenerics = XmlComment.class)
    public Sequence<XmlComment> comments() {
        return projectNodes(XmlComment.class);
    }
    
    /**
     * Returns all nested elements in sequence.
     * 
     * @return the elements
     * @throws VilException in case that access is not possible
     */
    @OperationMeta(returnGenerics = XmlElement.class)
    public Sequence<XmlElement> elements() throws VilException {
        return projectNodes(XmlElement.class);
    }

    /**
     * Projects nodes to a node type.
     * 
     * @param <T> the target element type
     * @param type the type to project to
     * @return the projected elements (may be empty)
     */
    private <T> Sequence<T> projectNodes(Class<? extends T> type) {
        //checkValidity();         
        List<T> elts = new ArrayList<T>();
        for (int i = 0; i < nodes.length; i++) {
            if (type.isInstance(nodes[i])) {
                elts.add(type.cast(nodes[i]));
            }
        }
        return new ListSequence<T>(elts, type);
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
                        if (getNode().getNodeType() == Node.ELEMENT_NODE) {
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
        return PathUtils.selectByXPath(path, getNode(), this);
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
        if (null != this.nodes) {
            for (int i = 0; i < this.nodes.length; i++) {
                if (this.nodes[i] instanceof XmlElement) {
                    Iterator<XmlElement> subIterator = ((XmlElement) this.nodes[i])
                        .selectByName(name, caseSensitive).iterator();
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
        for (int i = 0; i < this.nodes.length; i++) {
            if (this.nodes[i] instanceof XmlElement) {
                Iterator<XmlElement> subIterator = ((XmlElement) this.nodes[i]).selectByRegEx(regEx).iterator();
                while (subIterator.hasNext()) {
                    result.add(subIterator.next());
                }
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
                        getNode().getAttributes().removeNamedItem(attribute.getName());
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
                getNode().getAttributes().removeNamedItem(attribute.getName());
                Element element = (Element) getNode();
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
     * Changes the name of this element.
     * @param name the new name of this element.
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Replaces the child nodes of this element.
     * @param nodes An array with all child nodes.
     */
    void setNodes(XmlNode[] nodes) {
        this.nodes = nodes;
    }
    
    /**
     * Checks whether this element has child as a child.
     * @param child the child element to check for.
     * @return true if child is a child. false otherwise.
     */
    boolean hasChild(XmlElement child) {
        boolean has = false;
        for (int i = 0; i < this.nodes.length; i++) {
            if (nodes[i] == child) {
                has = true;
                i = this.nodes.length;
            }
        }
        return has;
    }
    
    //TODO We should really consider to change the arrays to some sort of list for better performance!!!
    /**
     * Adds a child XmlElement to this XmlElement.
     * @param child The new child.
     * @throws VilException If child could not be added.
     */
    void addChild(XmlNode child) throws VilException {
        if (null == child) {
            throw new VilException("NULL can not be added as a child of an XmlElement!", 
                VilException.ID_IS_NULL);
        }
        XmlNode[] newElements;
        if (null != this.nodes) {
            newElements = new XmlNode[this.nodes.length + 1];
        } else {
            newElements = new XmlNode[1];
        }
        for (int i = 0; i < (newElements.length - 1); i++) {
            newElements[i] = this.nodes[i];
        }
        newElements[newElements.length - 1] = child;
        this.nodes = newElements;
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
        this.insertElement(child, this.nodes[this.nodes.length - 1]);
        try {
            getNode().appendChild(childNode);
        } catch (DOMException exc) {
            throw new VilException("Unable to append a child from a " + getNode().getNodeName() + " Node!", 
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
    private void insertElement(XmlNode elem, XmlNode previous) throws VilException {
        if (null == elem) {
            throw new VilException("Tried to insert NULL element as child!", VilException.ID_IS_NULL);
        }
        XmlNode[] newElements;
        if (null != this.nodes) {
            newElements = new XmlNode[this.nodes.length + 1];
        } else {
            newElements = new XmlNode[1];
        }
        for (int i = 0; i < (newElements.length - 1); i++) {
            newElements[i] = this.nodes[i];
            if (null != previous && newElements[i].equals(previous)) {
                newElements[i + 1] = elem;
                i++;
            }
        }
        if (null == previous) {
            newElements[newElements.length - 1] = elem;
        }
        this.nodes = newElements;
        notifyChange();
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "xmlElement \"" + name + "\"";
    }
    
}
