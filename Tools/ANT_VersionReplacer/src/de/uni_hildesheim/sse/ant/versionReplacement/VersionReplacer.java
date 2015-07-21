/*
 * Copyright 2015 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.uni_hildesheim.sse.ant.versionReplacement;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Utility methods for {@link FeatureVersionTask} and {@link UpdateSiteTask}.
 * Static method for changing the version numbers of XML documents.
 * @author El-Sharkawy
 *
 */
class VersionReplacer {

    /**
     * Changes the version numbers inside a Feature <tt>XML</tt> file.
     * @param sourceFeature A source <tt>xml</tt> file to transform. It's not necessary that the name is
     * <tt>feature.xml</tt>.
     * @param version The version number to set. Should be in the following format:<br/>
     * <tt>&lt;number&gt;'.'&lt;number&gt;['.'&lt;number&gt;]</tt>
     * @param destination The destination <tt>JAR</tt> file where the transformed <tt>feature.xml</tt> shall be saved.
     * This file must not exist.
     * @throws ParserConfigurationException If a DocumentBuilder
     * cannot be created which satisfies the configuration requested.
     * @throws SAXException If any parse errors occur.
     * @throws IOException If any IO errors occur.
     * @throws TransformerFactoryConfigurationError If the implementation
     * is not available or cannot be instantiated.
     * @throws TransformerException If it is not possible to create a <code>Transformer</code> instance.
     */
    static void createFeature(File sourceFeature, String version, File destination)
        throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError,
        TransformerException {

        // Change XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(sourceFeature);
        Node root = document.getFirstChild();
        NamedNodeMap attributes = root.getAttributes();
        Node versionAttr = attributes.getNamedItem("version");
        versionAttr.setTextContent(version);
        
        NodeList childs = root.getChildNodes();
        for (int i = 0; i < childs.getLength(); i++) {
            Node child = childs.item(i);
            if ("plugin".equalsIgnoreCase(child.getNodeName())) {
                attributes = child.getAttributes();
                versionAttr = attributes.getNamedItem("version");
                versionAttr.setTextContent(version);
            }
        }

        // Write new XML to String
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        StringWriter sWriter = new StringWriter();
        Result output = new StreamResult(sWriter);
        Source input = new DOMSource(document);
        transformer.transform(input, output);

        // Create Feature.jar
        try (ZipOutputStream out = new ZipOutputStream(new FileOutputStream(destination))) {
            ZipEntry e = new ZipEntry("feature.xml");
            out.putNextEntry(e);
            byte[] data = sWriter.toString().getBytes();
            out.write(data, 0, data.length);
            out.closeEntry();
        }
    }

    /**
     * Changes the version numbers inside a <tt>XML</tt> file.
     * @param sourceXML A source <tt>xml</tt> file to transform. It's not necessary that the name is
     * <tt>site.xml</tt>.
     * @param version The version number to set. Should be in the following format:<br/>
     * <tt>&lt;number&gt;'.'&lt;number&gt;['.'&lt;number&gt;]</tt>
     * @param destinationXML The destination <tt>XML</tt> file where the transformed content shall be saved.
     * This file must not exist.
     * @throws ParserConfigurationException If a DocumentBuilder
     * cannot be created which satisfies the configuration requested.
     * @throws SAXException If any parse errors occur.
     * @throws IOException If any IO errors occur.
     * @throws TransformerFactoryConfigurationError If the implementation
     * is not available or cannot be instantiated.
     * @throws TransformerException If it is not possible to create a <code>Transformer</code> instance.
     */
    static void createUpdateSite(File sourceXML, String version, File destinationXML)
        throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError,
        TransformerException {

        // Change XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(sourceXML);
        Node root = document.getFirstChild();
        NodeList childs = root.getChildNodes();
        for (int i = 0; i < childs.getLength(); i++) {
            Node child = childs.item(i);
            if ("feature".equalsIgnoreCase(child.getNodeName())) {
                NamedNodeMap attributes = child.getAttributes();
                Node versionAttr = attributes.getNamedItem("version");
                versionAttr.setTextContent(version);
            }
        }

        // Write new XML to String
        Transformer transformer = TransformerFactory.newInstance().newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        Result output = new StreamResult(destinationXML);
        Source input = new DOMSource(document);
        transformer.transform(input, output);
    }

}
