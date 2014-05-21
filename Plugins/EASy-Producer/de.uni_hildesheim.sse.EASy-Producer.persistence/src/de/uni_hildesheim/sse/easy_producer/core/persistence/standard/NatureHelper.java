package de.uni_hildesheim.sse.easy_producer.core.persistence.standard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * The NatureHelper supports querying and modifying Eclipse nature-like elements without having an Eclipse running.
 * 
 * @author Niko Nowatzki
 * @author Holger Eichelberger
 */
public class NatureHelper {

    public static final String FILE_NAME = ".project";
    
    private static DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

    /**
     * Implements core functionality accessing the project file. May also be implemented in <i>NatureHelper</i> but
     * shall exhibit now the responsibilities.
     * 
     * @author Holger Eichelberger
     */
    private static class ProjectHandler {
        
        private File file;
        private DocumentBuilder dBuilder;
        private Document doc;

        /**
         * Creates a handler.
         * 
         * @param project the project folder
         * @throws IOException in case that opening the project file fails for some reason
         */
        private ProjectHandler(File project) throws IOException {
            try {
                file = new File(project, FILE_NAME);
                dBuilder = dbFactory.newDocumentBuilder();
                doc = dBuilder.parse(file);
                
                // doc.getDocumentElement().normalize();
            } catch (SAXException e) {
                throw new IOException(e.getMessage(), e);
            } catch (ParserConfigurationException e) {
                throw new IOException(e.getMessage(), e);
            }
        }
        
        
        /**
         * Returns the natures node.
         * 
         * @return the natures node
         */
        private NodeList getNatures() {
            return doc.getElementsByTagName("natures");            
        }
        
        /**
         * Writes back a modified file.
         * 
         * @throws IOException in case that writing back the file fails
         */
        private void writeBack() throws IOException {
            try {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                //transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
                transformer.setOutputProperty(OutputKeys.INDENT, "no");
                transformer.setOutputProperty("{http://xml.apache.org/xalan}line-separator", "\r\n");
                transformer.setOutputProperty(OutputKeys.METHOD, "html");
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(file);
                // this is actually a hack as having empty elements and the XML header does not work together
                FileOutputStream out = new FileOutputStream(file);
                result.setOutputStream(out);
                result.setWriter(new PrintWriter(out));
                result.getWriter().append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
                transformer.transform(source, result);
            } catch (TransformerException e) {
                throw new IOException(e.getMessage(), e);
            } 
        }
        
        /**
         * Add nature-section regardless whether it exists.
         * 
         * @return the node representing the new nature section
         */
        private Node addNatureSection() {
            Node root = doc.getDocumentElement();
            
            //Create new element
            Element elem = doc.createElement("natures");
            //elem.appendChild(doc.createTextNode(" "));
            //Append!
            root.appendChild(elem);
            return elem;
        }
       
        /**
         * Adds a nature to <code>node</code> regardless whether it already exists.
         * 
         * @param node the node to add the nature to
         * @param nature the nature
         * @return the node representing the nature entry
         */
        private Node addNature(Node node, String nature) {
            Element elem = doc.createElement("nature");
            elem.appendChild(doc.createTextNode(nature));
            node.appendChild(elem);
            return elem;
        }
        
    }
    
    /**
     * Returns whether at least one of the given <code>natures</code> are attached to <code>project</code>.
     * 
     * @param project the folder representing the "Eclipse" project
     * @param natures natures which should be included in file.
     * @return <code>true</code> if the nature is attached to <code>project</code>, <code>false</code> else
     * 
     * @throws IOException if reading or writing the project file fails
     */
    public static boolean hasNature(File project, String... natures) throws IOException {
        ProjectHandler handler = new ProjectHandler(project);
        return hasNature(handler, natures);
    }

    /**
     * Returns whether at least one of the given <code>natures</code> are attached to the project represented 
     * by <code>handler</code>.
     * 
     * @param handler the hendler representing the project
     * @param natures natures which should be included in file.
     * @return <code>true</code> if the nature is attached to <code>project</code>, <code>false</code> else
     */
    private static boolean hasNature(ProjectHandler handler, String... natures) {
        boolean found = false;
        NodeList nat = handler.getNatures();
        for (int i = 0; !found && i < natures.length; i++) {
            for (int n = 0; !found && n < nat.getLength(); n++) {
                found = containsNature(nat.item(n).getChildNodes(), natures[i]);
            }
        }
        return found;
    }
    
    /**
     * Checks whether the text content of the given <code>node</code> matches the given <code>nature</code>.
     * 
     * @param node the node to be checked
     * @param nature the nature to be considered
     * @return <code>true</code> if the nature is represented by <code>node</code>, <code>false</code> else
     */
    private static boolean checkNature(Node node, String nature) {
        return node.getTextContent().trim().equals(nature);
    }
    
    /**
     * Check whether the given <code>nature</code> is represented by at least one node in <code>nodes</code>.
     * 
     * @param nodes list of nodes to be considered
     * @param nature the nature to search for
     * @return <code>true</code> if the nature is represented by at least one node in <code>nodes</code>, 
     *     <code>false</code> else
     */
    private static boolean containsNature(NodeList nodes, String nature) {
        boolean contains = false;
        for (int i = 0; !contains && i < nodes.getLength(); i++) {
            contains = checkNature(nodes.item(i), nature);
        }
        return contains;
    }
    
    /**
     * Adds a nature.
     * 
     * @param project the folder representing the "Eclipse" project
     * @param nature String which should be removed.
     * 
     * @throws IOException if reading or writing the project file fails
     */
    public static void addNature(File project, String nature) throws IOException {
        ProjectHandler handler = new ProjectHandler(project);
        if (!hasNature(handler, nature)) {
            NodeList nat = handler.getNatures();
            Node node;
            if (0 == nat.getLength()) {
                // add nature section
                node = handler.addNatureSection();
            } else {
                // handles the pathological case of multiple nature nodes -- shall not occur
                node = nat.item(0); 
            }
            handler.addNature(node, nature);
            handler.writeBack();
        }
    }
    
    /**
     * Remove a nature.
     * 
     * @param project the folder representing the "Eclipse" project
     * @param nature String which should be removed.
     * 
     * @throws IOException if reading or writing the project file fails
     */
    public static void removeNature(File project, String nature) throws IOException {
        ProjectHandler handler = new ProjectHandler(project);
        NodeList natures = handler.getNatures();
        for (int i = 0; i < natures.getLength(); i++) {
            // root.item(i).getTextContent().replaceAll(" ", "");
            //if (root.item(i).getTextContent().contains(nature)) {
            removeElements(natures.item(i), nature);
            //}
        }
        handler.writeBack();
    }
    
    /** 
     * Removes all elements with a given nature (as content).
     * 
     * @param parent the parent node to start at
     * @param nature the nature as content to be removed
     */  
    private static void removeElements(Node parent, String nature) {  
        NodeList children = parent.getChildNodes();  
        //Go over all children
        for (int i = 0; i < children.getLength(); i++ ) {  
        
            Node child = children.item(i);  
       
            //only interested in elements  
            if (child.getNodeType() == Node.ELEMENT_NODE ) {  
                // remove elements with matching content/nature  
                if (checkNature(child, nature)) {  
                    parent.removeChild(child);
                } else {  
                    removeElements(child, nature);  
                }    
            } 
        }  
    }
    
}
