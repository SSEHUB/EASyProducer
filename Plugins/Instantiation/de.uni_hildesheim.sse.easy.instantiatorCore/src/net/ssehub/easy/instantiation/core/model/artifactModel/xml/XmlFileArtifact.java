package net.ssehub.easy.instantiation.core.model.artifactModel.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.w3c.dom.CDATASection;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactCreator;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactFactory;
import net.ssehub.easy.instantiation.core.model.artifactModel.ArtifactModel;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.FragmentArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.IFileSystemArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.IArtifactRepresentation;
import net.ssehub.easy.instantiation.core.model.artifactModel.representation.Text;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.ArraySet;
import net.ssehub.easy.instantiation.core.model.vilTypes.Conversion;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Represents a parsed XML file artifact. Due to Java internal intelligent processing, it 
 * might be that the original encoding name is replaced by a normalized one. If this is not
 * intended, the official encoding table of the JDK needs to be redefined (system property
 * "com.sun.org.apache.xalan.internal.serialize.encodings"), e.g., to exclude the specific
 * encoding... with possible side effects. Please note, that there is a comment end-of-line 
 * workaround in this class which is required for proper operation on some JDKs (OpenJDK 1.7). 
 * In future, this may be circumvented by using a distinct version of XALAN instead of the builtin
 * one....
 * 
 * @author Holger Eichelberger
 * @author Patrik Pastuschek
 */
@ArtifactCreator(DefaultXmlFileArtifactCreator.class)
public class XmlFileArtifact extends FileArtifact implements IXmlContainer {

    private XmlElement rootElement; // ignore outside commend by node
    private Document doc;
    private File file;
    private DtdParser dtdParser = new DtdParser();
    private Dtd dtd;
    private boolean omitXmlDeclaration = false;
    private boolean synchronizeAttributeSequence = true;
    private int indentation = 4;
    private long lastModification = -1;
    private long lastPersisted = -1;
    
    /**
     * Creates a new XML file artifact.
     * 
     * @param file the file to read the artifact contents from
     * @param model the artifact model to create this folder artifact within
     * @throws VilException if artifact could not be created.
     */
    XmlFileArtifact(File file, ArtifactModel model) throws VilException {
        super(file, model);
        this.file = file;
        initialize();
    }

    /**
     * (Re)initializes this artifact.
     * 
     * @throws VilException if artifact could not be created.
     */
    private void initialize() throws VilException {
        readDtd();
        load(file);
        if (null != doc) {
            XmlNode rt = build(doc.getDocumentElement(), null);
            if (rt instanceof XmlElement) {
                rootElement = (XmlElement) rt;
            }
            if (null != doc.getDocumentElement()) {
                cleanTree(doc.getDocumentElement());
            }
            lastPersisted = System.currentTimeMillis();
        }
    }
    
    /**
     * Creates a temporary file artifact.
     * 
     * @return the created file artifact
     * @throws VilException in case that the creation fails
     */
    public static FileArtifact create() throws VilException {
        try {
            File file = File.createTempFile("xmlFileArtifact", "vil");
            file.deleteOnExit();
            return ArtifactFactory.createArtifact(XmlFileArtifact.class, file, null);
        } catch (IOException e) {
            throw new VilException(e, VilException.ID_IO);
        }
    }
    
    @Override
    @OperationMeta(storeArtifactsBefore = true)
    public void delete() throws VilException {
        super.delete();
        doc = null;
        rootElement = null;
    }
    
    @Override
    public void artifactChanged(Object cause) throws VilException {
        boolean fromRepresentation = cause instanceof IArtifactRepresentation; 
        if (fromRepresentation) { // change comes from text/binary - take it over as it is
            omitXmlDeclaration = true;
        }
        super.artifactChanged(cause);
        if (fromRepresentation) { // change comes from text/binary - read in structure again
            initialize();
        }
        lastModification = System.currentTimeMillis();
    }

    @Override
    public void store() throws VilException {
        if (getRepresentationChanged(true)) {
            writeToFile();
            lastPersisted = System.currentTimeMillis();
        }
    }
    
    @Override
    @OperationMeta(returnGenerics = FragmentArtifact.class)
    public Set<? extends FragmentArtifact> selectAll() {
        XmlElement[] elements = null;
        if (this.rootElement != null) {
            elements = new XmlElement[1];
            elements[0] = this.rootElement;
        }
        return new ArraySet<XmlElement>(elements, FragmentArtifact.class);
    }
    
    /**
     * Returns the Root Element.
     * 
     * @return the representation of the root element
     */
    public XmlElement getRootElement() {
        return this.rootElement;
    }
    
    /**
     * Creates a root element if it does not exist.
     * 
     * @param name the name of the root element
     * @return the actual root element
     * @throws VilException in case that creating the root element fails
     */
    public XmlElement createRootElement(String name) throws VilException {
        if (null == rootElement) {
            if (null == doc) {
                try {
                    DocumentBuilder builder = getDocumentBuilderFactory().newDocumentBuilder();
                    doc = builder.newDocument();
                } catch (ParserConfigurationException exc) {
                    EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(exc);
                    throw new VilException(file.getAbsolutePath() + ":" + exc.getMessage(), 
                        VilException.ID_RUNTIME_RESOURCE);
                }
            }
            Element elt = doc.createElement(name);
            doc.appendChild(elt);
            rootElement = new XmlRootElement(this, null, name, new XmlAttribute[0], elt);
        }
        return rootElement;
    }
    
    /**
     * Returns a set of all childs of the root element.
     * 
     * @return Set of all childs of the root element.
     * @throws VilException 
     */
    @OperationMeta(returnGenerics = XmlElement.class)
    public Set<? extends XmlElement> selectChilds() throws VilException {
        XmlElement[] elements = null;
        if (this.rootElement != null) {
            elements = new XmlElement[this.rootElement.selectAll().size()];
            Iterator<XmlElement> iter = this.rootElement.elements().iterator();
            for (int i = 0; i < elements.length; i++) {
                elements[i] = (XmlElement) iter.next();
            }
        }
        return new ArraySet<XmlElement>(elements, FragmentArtifact.class);
    }
    
    /**
     * Loads and builds the jdom-tree.
     * 
     * @param file the file that is to be parsed.
     * @throws VilException in case domTree could not be built.
     */
    private void load(File file) throws VilException {
        
        if (file != null && file.length() > 0) {
        
            DocumentBuilder builder;
            try {
                builder = getDocumentBuilderFactory().newDocumentBuilder();
                doc = builder.parse(file);
            } catch (ParserConfigurationException exc) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(exc);
                throw new VilException(file.getAbsolutePath() + ":" + exc.getMessage(), 
                    VilException.ID_RUNTIME_RESOURCE);
            } catch (SAXException exc) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(exc);
                throw new VilException(file.getAbsolutePath() + ":" + exc.getMessage(), 
                    VilException.ID_RUNTIME_RESOURCE);
            } catch (IOException exc) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(exc);
                throw new VilException(file.getAbsolutePath() + ":" + exc.getMessage(), 
                    VilException.ID_RUNTIME_RESOURCE);
            }
        
        }
                
    }
    
    /**
     * Building up the representing object structure.
     * 
     * @param node the node to parse. (Will parse all childs aswell).
     * @param parent the representation of the parent node. (Null if root element).
     * @return an array of XmlElements including all child elements.
     */
    private XmlNode build(Node node, XmlElement parent) {
        //add elements only        
        List<Integer> childIndexes = new ArrayList<Integer>();
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            short type = node.getChildNodes().item(i).getNodeType();
            if (type == Node.ELEMENT_NODE || type == Node.COMMENT_NODE) {
                childIndexes.add(i);
            }
        }
        
        XmlNode result = null;
        if (null == parent) {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                XmlAttribute[] attributes = this.createAttributes(node, null);
                result = fill(node, new XmlRootElement(this, parent, node.getNodeName(), attributes, node), 
                    childIndexes); 
            } // currently no comments here
        } else {
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                XmlAttribute[] attributes = this.createAttributes(node, null);
                result = fill(node, new XmlElement(parent, node.getNodeName(), attributes, node), childIndexes); 
            } else if (node.getNodeType() == Node.COMMENT_NODE) {
                result = fill(node, new XmlComment(parent, node));
            }
        }

        return result;
    }

    /**
     * Fills an XML element with data.
     * 
     * @param node the XML node to take the data from
     * @param element the XML element
     * @param childIndexes the child indexes indicating the children to take over
     * @return <code>element</code>
     */
    private XmlElement fill(Node node, XmlElement element, List<Integer> childIndexes) {
        //try to add textual representation
        //TODO: Test whether CDATA needs to be trimmed too.
        try {
            if (node.hasChildNodes()) {
                if (node.getFirstChild().getNodeType() == Node.CDATA_SECTION_NODE) {
                    element.setCdata(((CDATASection) node.getFirstChild()).getData());
                } else if (node.getFirstChild().getNodeType() == Node.TEXT_NODE) {
                    //trim the text, otherwise indent can cause lots of spaces in front of the text.
                    String text = node.getFirstChild().getNodeValue().trim();
                    element.getText().setText(text);
                }
            }
        } catch (VilException e1) {
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e1);
        } catch (DOMException e1) {
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e1);
        }
        
        Iterator<XmlAttribute> iter = null;
        try {
            iter = element.attributes().iterator();
        } catch (VilException e) {
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
        }
        
        if (null != iter) {
            while (iter.hasNext()) {
                iter.next().setParent(element);                
            }
        }
        
        XmlNode[] nodes = new XmlNode[childIndexes.size()];
        //build child nodes
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = build(node.getChildNodes().item(childIndexes.get(i)), element);
        }
        element.setNodes(nodes);
        return element;
    }

    /**
     * Fills an XML comment with data.
     * 
     * @param node the node to take data from
     * @param element the XML comment to fill
     * @return <code>comment</code>
     */
    private XmlComment fill(Node node, XmlComment element) {
        try {
            element.getText().setText(node.getNodeValue().trim());
        } catch (VilException e1) {
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e1);
        }
        return element;
    }

    /**
     * Return all line ended comments in sequence of their occurrence in {@link #file}. This is part of a workaround
     * as in some JDKs the line ends of comments seem to be omitted.
     * 
     * @return the line ends in sequence
     */
    private List<String> getLineEndedComments() {
        List<String> lineEndedComments = new ArrayList<String>();
        LineNumberReader reader = null;
        try {
            reader = new LineNumberReader(new FileReader(this.file));
            String line;
            do {
                line = reader.readLine();
                if (null != line && line.endsWith("-->")) {
                    lineEndedComments.add(line);
                }
            } while (null != line);
            reader.close();
        } catch (IOException e) {
            IOUtils.closeQuietly(reader);
            // don't care for exception
        }
        return lineEndedComments;
    }
    
    /**
     * Ensures line the line ends in {@link #file} according to the previously collected line ends 
     * by {@link #getLineEndedComments()}. This is part of a workaround
     * as in some JDKs the line ends of comments seem to be omitted.
     * 
     * @param lineEndedComments the line ended comments in sequence of their occurrence
     */
    private void ensureLineEndedComments(List<String> lineEndedComments) {
        try {
            final String sep = System.getProperty("line.separator");
            List<String> lines = FileUtils.readLines(file);
            int c = 0;
            int l = 0;
            int lPos = 0;
            while (c < lineEndedComments.size() && l < lines.size()) {
                String line = lines.get(l);
                String comment = lineEndedComments.get(c);
                int pos = line.indexOf(comment, lPos);
                if (pos >= 0) {
                    int ePos = pos + comment.length();
                    if (ePos < line.length()) {
                        int tmpPos = ePos;
                        while (ePos < line.length() && isLineEndChar(line.charAt(ePos))) {
                            ePos++;
                        }
                        if (tmpPos == ePos) {
                            line = line.substring(0, ePos) + sep + line.substring(ePos);
                            lines.set(l, line);
                            lPos = ePos + sep.length();
                        }
                    }
                    c++;
                } else {
                    l++;
                    lPos = 0;
                }
            }
            FileUtils.writeLines(file, lines);
        } catch (IOException e) {
            // don't care
        }
    }

    /**
     * Returns whether <code>ch</code> is a line end character.
     * 
     * @param ch the character to be analyzed
     * @return <code>true</code> if it is a line end character, <code>false</code> else
     */
    private static boolean isLineEndChar(char ch) {
        return '\r' == ch || '\n' == ch;
    }
    
    /**
     * Writes the Dom tree back to the file.
     * @exception VilException If a new file (which no {@link #doc} should be created out of {@link #getText()}
     *     and {@link #getText()} is not parseable.
     */
    private void writeToFile() throws VilException {
        // No doc, but maybe there was a valid text added via getText(), e.g. a new file was created
        Text text = null;
        boolean initializationNeeded = false;
        try {
            text = getText();
        } catch (VilException exc) {
            // Don't care, text can be null
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(exc);
        }
        if (null == doc && null != text && !text.getText().trim().isEmpty()) {
            try {
                DocumentBuilder builder = getDocumentBuilderFactory().newDocumentBuilder();
                doc = builder.parse(IOUtils.toInputStream(text.getText()));
                initializationNeeded = true;
            } catch (ParserConfigurationException exc) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(exc);
                throw new VilException(file.getAbsolutePath() + ":" + exc.getMessage(), 
                    VilException.ID_RUNTIME_RESOURCE);
            } catch (SAXException exc) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(exc);
                throw new VilException(file.getAbsolutePath() + ":" + exc.getMessage(), 
                    VilException.ID_RUNTIME_RESOURCE);
            } catch (IOException exc) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(exc);
                throw new VilException(file.getAbsolutePath() + ":" + exc.getMessage(), 
                    VilException.ID_RUNTIME_RESOURCE);
            }
        }
        
        if (null != doc) {
            List<String> lineEndedComments = getLineEndedComments();          
            DOMSource source = new DOMSource(doc);
            StreamResult result = null;
            result = new StreamResult(this.file);
            try {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                configureTransformer(transformer);
                transformer.transform(source, result);
            } catch (TransformerException exc) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(exc);
            }
            
            if (!lineEndedComments.isEmpty()) {
                ensureLineEndedComments(lineEndedComments);
            }
        
            if (this.dtd != null && this.dtd.getContent() != null && !this.dtd.getContent().isEmpty()) {
                try {
                    this.dtdParser.writeDtd(this.file, this.dtd);
                } catch (FileNotFoundException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
                }
            }            
        }
        
        if (initializationNeeded) {
            initialize();
        }
    }
    
    /**
     * Configures the transformer.
     * 
     * @param transformer the transformer to be configured
     */
    protected void configureTransformer(Transformer transformer) {
        // might be doc.getXmlEncoding();  but this is properly taken over... but may also normalized
        //transformer.setOutputProperty("encoding", encoding); 
        if (indentation >= 0) {
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", 
                String.valueOf(indentation));
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        } else {
            transformer.setOutputProperty(OutputKeys.INDENT, "no");
        }
        if (omitXmlDeclaration) {
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        }
        //transformer.setOutputProperty("{http://xml.apache.org/xalan}line-separator", "\r\n");
    }
    
    /**
     * Creates and returns all Attributes for given node and XmlElement.
     * 
     * @param node The node for which to return all attributes
     * @param element The element that represents the node.
     * @return Array with XmlAttributes
     */
    private XmlAttribute[] createAttributes(Node node, XmlElement element) {
        
        XmlAttribute[] attributes;
        
        if (null != node.getAttributes()) {
            int amountOfAtt = node.getAttributes().getLength();
            attributes = new XmlAttribute[amountOfAtt];
               
            for (int i = 0; i < amountOfAtt; i++) {
                
                attributes[i] = new XmlAttribute(element, 
                        node.getAttributes().item(i).getNodeName(),
                        node.getAttributes().item(i).getNodeValue());            
            }
        } else {
            attributes = null;
        }
        
        return attributes;
        
    }

    @Override
    @OperationMeta(returnGenerics = XmlElement.class)
    public Set<XmlElement> selectByName(String name) throws VilException {
        return this.rootElement.selectByName(name);
    }

    @Override
    @OperationMeta(returnGenerics = XmlElement.class)
    public Set<XmlElement> selectByPath(String path) throws VilException {
        return PathUtils.selectByPath(this, PathUtils.normalize(path));
    }

    @Override
    @OperationMeta(returnGenerics = XmlElement.class)
    public Set<XmlElement> selectByXPath(String path) throws VilException {
        return PathUtils.selectByXPath(path, doc, this);
    }
    
    /**
     * Returns a set of all XmlElements that start with prefix and end with suffix.
     * To get a set of all XmlElements having a certain pre- and suffix use:
     * "prefix.*suffix" (replace prefix and suffix).
     * 
     * @param regEx a regular expression specifying the elements to be selected.
     * @return Set of XmlElements matching the regEx.
     * @throws VilException in case that invalid Elements are used.
     */
    @OperationMeta(returnGenerics = XmlElement.class)
    public Set<XmlElement> selectByRegEx(String regEx) throws VilException {
        if (this.rootElement == null) {
            throw new VilException("Root Element does not exist", 30003);
        }
        return this.rootElement.selectByRegEx(regEx);
    }

    @Override
    public void update() throws VilException {
        boolean update = true;
        File file = getPath().getAbsolutePath();
        if (null != file) {
            // update only if file is somehow younger than the last state read/written
            // and there is no modification that is newer
            update = file.lastModified() > lastPersisted && !(lastModification > lastPersisted);
        }
        if (update) {
            //super.update();
            initialize(); 
        }
    }
    
    /**
     * Cleans the dom tree from empty text nodes. These nodes are used for internal indent representation.
     * These empty text nodes cause bugs in indentation if not removed.
     * @param parent The parentNode that is to clean.
     */
    private void cleanTree(Node parent) {
        Node child = parent.getFirstChild();
        while (null != child) {
            Node nextChild = child.getNextSibling();
            
            if (Node.TEXT_NODE == child.getNodeType() && !child.hasChildNodes()) {
                if (child.getNodeValue().trim().isEmpty()) {
                    parent.removeChild(child);
                }
            }
            child = nextChild;
        }
    }
    
    /**
     * Checks the base file for embedded DTDs.
     * @throws VilException If File not found.
     */
    private void readDtd() throws VilException {
        if (null != file && file.length() > 0) {
            try {
                this.dtd = dtdParser.extractDTD(file);
            } catch (FileNotFoundException e) {
                throw new VilException("File not found: " + file.getAbsolutePath(), 
                    VilException.ID_RUNTIME_RESOURCE);
            }
        }
        
    }
    
    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     * @throws VilException in case that creating the artifact fails
     */
    @Invisible
    @Conversion
    public static FileArtifact convert(String val) throws VilException {
        Path path = Path.convert(val);
        return convert(path);
    }
    
    /**
     * Conversion operation.
     * 
     * @param val the value to be converted
     * @return the converted value
     */
    @Invisible
    @Conversion
    public static XmlFileArtifact convert(IFileSystemArtifact val) {
        XmlFileArtifact convertedValue = null;
        if (val instanceof XmlFileArtifact) {
            convertedValue = (XmlFileArtifact) val;
        }
        return convertedValue;
    }
    
    /**
     * Sets the number of whitespaces to use for auto-indenting this artifact while writing/storing.
     * 
     * @param indentation the number of whitespaces (default 4), a negative value disables indentation
     */
    public void setIndentation(int indentation) {
        this.indentation = indentation;
    }
    
    /**
     * Defines whether the usual XML header declaration shall be omitted or printed while writing/storing this artifact.
     * 
     * @param omitXmlDeclaration omit if <code>true</code>, emit if <code>false</code> (default)
     */
    public void setOmitXmlDeclaration(boolean omitXmlDeclaration) {
        this.omitXmlDeclaration = omitXmlDeclaration;
    }
    
    /**
     * Returns whether the attribute sequence of XML elements shall be synchronized between document and artifact
     * fragments, i.e., the fragment sequence defines the sequence of the attributes. Else attributes are sorted
     * by name (default XALAN behavior).
     * 
     * @return <code>true</code> (default), <code>false</code> for sorted
     */
    @Invisible
    public boolean synchronizeAttributeSequence() {
        return synchronizeAttributeSequence;
    }

    /**
     * Changes whether the attribute sequence of XML elements shall be synchronized between document and artifact
     * fragments, i.e., the fragment sequence defines the sequence of the attributes. Else attributes are sorted
     * by name (default XALAN behavior).
     * 
     * @param synchronizeAttributeSequence <code>true</code> (default), <code>false</code> for sorted
     */
    public void setSynchronizeAttributeSequence(boolean synchronizeAttributeSequence) {
        this.synchronizeAttributeSequence = synchronizeAttributeSequence;
    }

    /**
     * Returns the document builder factory.
     * 
     * @return the factory
     */
    protected DocumentBuilderFactory getDocumentBuilderFactory() {
        return DocumentBuilderFactory.newInstance();
    }
    
    /**
     * Enforces re-loading, formatting and writing of this artifact.
     * 
     * @throws VilException in case that loading, formatting or writing fails
     */
    public void format() throws VilException {
        initialize(); 
        writeToFile();
        lastPersisted = System.currentTimeMillis();
    }

}