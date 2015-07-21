/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Replaces the version in a product specification (assuming for now that relevant features / bundles are
 * linked without version).
 * 
 * @author Holger Eichelberger
 */
public class ProductVersionTask extends Task {

    private String version;
    private File productFile;
    private File destinationFile;

    /**
     * The version number to set.
     * @param version Should be in the following format:<br/>
     * <tt>&lt;number&gt;'.'&lt;number&gt;['.'&lt;number&gt;]</tt>
     */
    public void setVersion(String version) {
        this.version = version;
    }
    
    /**
     * The version to set.
     * @return The version to set.
     */
    protected String getVersion() {
        return version;
    }
    
    /**
     * Defines the product file to modify.
     * 
     * @param productFile the product file
     */
    public void setProductFile(String productFile) {
        this.productFile = new File(productFile);
    }

    /**
     * Returns the product file to modify.
     * 
     * @return the product file
     */
    protected File getProductFile() {
        return productFile;
    }
    
    /**
     * Defines the destination file where to write to.
     * 
     * @param destinationFile the destination product file
     */
    public void setDestinationFile(String destinationFile) {
        this.destinationFile = new File(destinationFile);
    }
    
    @Override
    public void execute() throws BuildException {
        if (null == version || version.isEmpty()) {
            throw new BuildException("No version specified.");
        }
        if (null == productFile) {
            throw new BuildException("No product file specified.");
        }
        if (!productFile.exists()) {
            throw new BuildException("Product file does not exist.");
        }
        if (productFile.isDirectory()) {
            throw new BuildException("Product file is a directory.");
        }
        if (null == destinationFile) {
            throw new BuildException("No destination file specified.");
        }
        
        try {
            // TODO unify with VersionReplacer?
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(productFile);
    
            NodeList roots = document.getElementsByTagName("product");
            if (null == roots || 0 == roots.getLength()) {
                throw new BuildException("no \"product\" root element");
            }
            for (int n = 0; n < roots.getLength(); n++) {
                Node root = roots.item(n);
                NamedNodeMap attributes = root.getAttributes();
                Node versionAttr = attributes.getNamedItem("version");
                if (null != versionAttr) {
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
            
            try (FileOutputStream out = new FileOutputStream(destinationFile)) {
                byte[] data = sWriter.toString().getBytes();
                out.write(data, 0, data.length);
                out.close();
            }
            log("Created file: " + destinationFile);
        } catch (ParserConfigurationException e) {
            throw new BuildException(e);
        } catch (IOException e) {
            throw new BuildException(e);
        } catch (SAXException e) {
            throw new BuildException(e);
        } catch (TransformerConfigurationException e) {
            throw new BuildException(e);
        } catch (TransformerException e) {
            throw new BuildException(e);
        }
    }

}
