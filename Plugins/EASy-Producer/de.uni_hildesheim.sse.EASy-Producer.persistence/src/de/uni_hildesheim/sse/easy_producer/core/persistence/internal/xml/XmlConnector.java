
package de.uni_hildesheim.sse.easy_producer.core.persistence.internal.xml;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.Entity;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.Model;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.ModelType;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.PathEnvironment;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.PersistentProject;
import de.uni_hildesheim.sse.easy_producer.core.persistence.internal.StorageConnector;
import de.uni_hildesheim.sse.easy_producer.core.persistence.standard.PersistenceConstants;

/**
 * This class implements a StorageConnector for XML-file-based storages.
 * 
 * @author Kapeluch
 * @author El-Sharkawy
 */
public class XmlConnector implements StorageConnector {

    private String xmlFilePath;
    private PathEnvironment pathEnv;

    /**
     * Sole constructor for this class.
     * @param xmlFilePath The absolute path for retrieving the xml configuration file.
     * @param pathEnv a path environment for making files and paths relative
     */
    public XmlConnector(String xmlFilePath, PathEnvironment pathEnv) {
        this.xmlFilePath = xmlFilePath;
        this.pathEnv = pathEnv;
    }

    @Override
    public void loadModels(PersistentProject project) throws PersistenceException {
        Model[] models = new Model[project.getModelCount()];
        for (int i = 0; i < models.length; i++) {
            models[i] = project.getModel(i);
        }
        loadModels(models);
    }

    @Override
    public void loadModels(Model...models) throws PersistenceException {

        XPathFactory factory = XPathFactory.newInstance();
        XPath xPath = factory.newXPath();
        XPathExpression expr = null;
        Document doc = createXMLDocument();

        for (int i = 0; i < models.length; i++) {
            Model model = models[i];

            String path = null;
            if (model.getModelType() == ModelType.ROOT) {
                path = XMLConstants.PATH_4_ROOT_NODE;
            } else {
                path = XMLConstants.path4Models(model.getModelType()).toString();
            }

            // compile node path
            Object result = null;
            try {
                expr = xPath.compile(path);
                result = expr.evaluate(doc, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }

            Node nodes = (Node) result;
            if (ModelType.ROOT == model.getModelType()) {
                Entity entity = new Entity();
                Element element = (Element) nodes;
                for (int j = 0; j < element.getAttributes().getLength(); j++) {
                    String attrName = element.getAttributes().item(j).getNodeName();
                    String attrValue = element.getAttributes().item(j).getNodeValue();
                    entity.createAttribute(attrName, attrValue);
                }
                model.addEntity(entity);
            }  else if (null != nodes) {
                createEntities(nodes, model);
            }
        }
    }

    /**
     * Creates an object model for the xml document, which should be parsed.
     * @return A new DOM Document object.
     * @throws PersistenceException If an error occurred while parsing the xml document.
     */
    private Document createXMLDocument() throws PersistenceException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;

        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new PersistenceException(e);
        }

        Document doc;
        try {
            doc = db.parse(xmlFilePath);
        } catch (SAXException e) {
            throw new PersistenceException(e);
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
        doc.normalize();
        return doc;
    }

    /**
     * Parsed the xml structure, created {@link Entity}s and adds them to the given {@link Model}.
     * @param node the node within the current xml document representing the given model.
     * @param model The model related to the given node for saving the read entities.
     * @since 14.09.2011
     */
    private void createEntities(Node node, Model model) {

        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node entityNode = node.getChildNodes().item(i);
            
            // create attributes from attributes of node
            if (entityNode.getNodeType() != Node.TEXT_NODE) {
                Entity entity = new Entity();
                Element element = (Element) entityNode;

                for (int j = 0; j < element.getAttributes().getLength(); j++) {
                    String attrName = element.getAttributes().item(j).getNodeName();
                    String attrValue = element.getAttributes().item(j).getNodeValue();
                    entity.createAttribute(attrName, attrValue);
                }
                model.addEntity(entity);
            }
        }
    }

    @Override
    public void saveModels(PersistentProject project) throws PersistenceException {
        String indent = "\t\t";
        StringBuffer xml = new StringBuffer();
        xml.append(XMLConstants.startTag(project, pathEnv));
        for (int j = 0; j < project.getModelCount(); j++) {
            Model model = project.getModel(j);
            if (model.getModelType() != ModelType.ROOT) {
                StringBuffer openingTag = XMLConstants.startingTag(model.getModelType());
                StringBuffer endingTag = XMLConstants.closingTag(model.getModelType());
                xml.append(openingTag);
                for (int i = 0; i < model.getEntityCount(); i++) {
                    Entity entity = model.getEntity(i);
                    xml.append(getXmlFromEntity(entity, indent));
                }
                xml.append(endingTag);
            }
        }

        xml.append(XMLConstants.CLOSING_ROOT);
        FileWriter writer;
        try {
            writer = new FileWriter(xmlFilePath);
            writer.append(xml.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new PersistenceException(e);
        }
    }

    /**
     * Returns xml-formatted string from given entity.
     * 
     * @param entity The entity to generate xml-code from
     * @param indent The indent of the current level
     * @return XML-string
     * @since 22.09.2011
     */
    private String getXmlFromEntity(Entity entity, String indent) {
        StringBuffer xml = new StringBuffer();
        xml.append(indent + "<entity ");
        for (Entry<String, String> attr : entity.getAttributes().entrySet()) {
            appendAttribute(xml, attr);
        }
        xml.deleteCharAt(xml.length() - 1);

        xml.append(" />");
        xml.append(XMLConstants.LINEFEED);
        
        return xml.toString();
    }

    /**
     * Appends a given attribute to an existing xml String.
     * 
     * @param xml The xml string, which should be extended
     * @param attr The attribute, which should be inserted into the xml string.
     */
    private void appendAttribute(StringBuffer xml, Entry<String, String> attr) {
        String attName = attr.getKey().replaceAll("&", XMLConstants.AMP);
        String attValue = attr.getValue().replaceAll("&", XMLConstants.AMP);

        attName = attName.replaceAll("\"", XMLConstants.QUOTES);
        attValue = attr.getValue().replaceAll("\"", XMLConstants.QUOTES);

        attName = attName.replaceAll(">", XMLConstants.GREATERTHAN);
        attValue = attValue.replaceAll(">", XMLConstants.GREATERTHAN);

        attName = attName.replaceAll("<", XMLConstants.LESSTHAN);
        attValue = attValue.replaceAll("<", XMLConstants.LESSTHAN);

        xml.append(attName);
        xml.append("=\"");
        xml.append(attValue);
        xml.append("\" ");
    }

    @Override
    public String getProjectID() {
        String id = null;
        File configFile = new File(xmlFilePath);

        if (configFile.exists()) {
            XPathFactory factory = XPathFactory.newInstance();
            XPath xPath = factory.newXPath();
            XPathExpression expr = null;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = null;

            try {
                db = dbf.newDocumentBuilder();
            } catch (ParserConfigurationException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            Document doc = null;
            try {
                doc = db.parse(configFile);
            } catch (SAXException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            doc.normalize();
            String path = XMLConstants.PATH_4_ROOT_NODE;
            Object result = null;
            try {
                expr = xPath.compile(path);
                result = expr.evaluate(doc, XPathConstants.NODE);
            } catch (XPathExpressionException e) {
                e.printStackTrace();
            }

            Node nodes = (Node) result;
            Entity entity = new Entity();
            Element element = (Element) nodes;
            for (int j = 0; j < element.getAttributes().getLength(); j++) {
                String attrName = element.getAttributes().item(j).getNodeName();
                String attrValue = element.getAttributes().item(j).getNodeValue();
                entity.createAttribute(attrName, attrValue);
                if (PersistenceConstants.PTN_UUID.equals(attrName)) {
                    id = attrValue;
                }
            }
        }
        return id;
    }
    
    @Override
    public PathEnvironment getPathEnvironment() {
        return pathEnv;
    }

}