package de.uni_hildesheim.sse.easy.loader.framework;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * Representation of a Feature parsed from a XML-document. 
 * @author pastuschek
 *
 */

/**
 * Represents a feature.
 * @author Patu
 *
 */
public class Feature {
    
    private DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    private Document doc;
    private File file;
    
    private String id;
    private Version version;

    private Map<String, EasyDependency> plugins;
    private List<EasyDependency> requiredFeatures;
    
    /**
     * Constructor.
     * @param file The file of the underlying feature.
     */
    public Feature(File file) {
    
        this.requiredFeatures = new ArrayList<EasyDependency>();
        this.file = file;
        initialize();
    
    }
    
    /**
     * Initializes the feature by parsing it.
     */
    private void initialize() {
        load(this.file);
        this.plugins = new HashMap<String, EasyDependency>();
        if (this.doc != null) {
            build(this.doc.getDocumentElement());
        }
    }
    
    /**
     * Loads and builds the jdom-tree.
     * 
     * @param file the file that is to be parsed.
     */
    private void load(File file) {
    
        if (file != null && file.length() > 0) {
        
            DocumentBuilder builder;
            try {
                builder = factory.newDocumentBuilder();
                doc = builder.parse(file);
            } catch (ParserConfigurationException exc) {
                exc.printStackTrace();
            } catch (SAXException exc) {
                exc.printStackTrace();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        
        }
                
    }
    
    /**
     * Gathers necessary information from the feature-file.
     * @param node The node to build from.
     */
    private void build(Node node) {
    
        if (node.getNodeName().equals("feature")) {    
            this.id = node.getAttributes().getNamedItem("id").getNodeValue();
            try {
                this.version = new Version(node.getAttributes().getNamedItem("version").getNodeValue());
            } catch (DOMException e) {
                e.printStackTrace();
            } catch (BundleException e) {
                e.printStackTrace();
            }
        }
         
        if (node.getNodeName().equalsIgnoreCase("import") 
                || node.getNodeName().equalsIgnoreCase("include")) {
    
            boolean isImport = node.getNodeName().equalsIgnoreCase("import") ? true : false;
            EasyDependency newDependency = new EasyDependency();
            
            try {
                if (isImport && node.getAttributes().getNamedItem("feature") != null) {
                    newDependency.setName(node.getAttributes().getNamedItem("feature").getNodeValue());
                } else if (!isImport && node.getAttributes().getNamedItem("id") != null) {
                    newDependency.setName(node.getAttributes().getNamedItem("id").getNodeValue());
                }
                if (node.getAttributes().getNamedItem("version") != null) {
                    String vers = node.getAttributes().getNamedItem("version").getNodeValue();
                    String[] versions = EasyDependency.getRange(vers);
                    if (versions != null) {
                        newDependency.setBundleVersionMin(new Version(versions[0]));
                        if (versions.length > 1) {
                            newDependency.setBundleVersionMax(new Version(versions[1]));
                        } else {
                            newDependency.setBundleVersionMax(new Version(versions[0]));
                        }
                    }
                    
                    if (null != node.getAttributes().getNamedItem("match")) {
                        if (node.getAttributes().getNamedItem("match").getNodeValue().equals("greaterThan")) {
                            newDependency.setBundleVersionMax(null);
                        } else if (node.getAttributes().getNamedItem("match").getNodeValue().equals("smallerThan")) {
                            newDependency.setBundleVersionMin(null);
                        }
                    } else {
                        newDependency.setBundleVersionMax(null);
                        newDependency.setBundleVersionMin(null);
                    }
                }
            } catch (DOMException e) {
                e.printStackTrace();
            } catch (BundleException e) {
                e.printStackTrace();
            }
            
            this.requiredFeatures.add(newDependency);
        }
        
        if (node.getNodeName().equals("plugin")) {
            
            this.plugins.put(node.getAttributes().getNamedItem("id").getNodeValue(), 
                new EasyDependency("bundle-symbolic-name:=" + node.getAttributes().getNamedItem("id").getNodeValue() 
                    + ";" + "bundle-version:=[" 
                    + node.getAttributes().getNamedItem("version").getNodeValue() + "]"));
        }
        
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            build(node.getChildNodes().item(i));
        }
        
    }
    
    /**
     * Simple test.
     * @param args stuff.
     */
    public static void main(String[] args) {
        
        Feature test = new Feature(new File("C:/Users/Patu/Desktop/feature.xml"));
        System.out.println(test.id);
        System.out.println(test.version.toString());
        
        Object[] keys = test.plugins.keySet().toArray();
        
        for (int i = 0; i < keys.length; i++) {
        
            System.out.println(test.plugins.get(keys[i]).getBundleSymbolicName() + " " 
                + test.plugins.get(keys[i]).getBundleVersionMin() + " " 
                + test.plugins.get(keys[i]).getBundleVersionMax());
        
        }
        
    }
    
    /**
     * Returns the dependencies aka plugins needed.
     * @return A map with the dependencies.
     */
    public Map<String, EasyDependency> getDependencies() {
        return this.plugins;
    }
    
    /**
     * Returns the requirements aka features needed.
     * @return A list with all requirements.
     */
    public List<EasyDependency> getRequirements() {
        return this.requiredFeatures;
    }
    
    /**
     * Returns the id of the feature.
     * @return The Id of the feature.
     */
    public String getId() {
        return this.id;
    }
    
    @Override
    public String toString() {
        return this.id;
    }
    
}
