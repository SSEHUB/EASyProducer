/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy.loader.framework;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XmlUtilities {

    /**
     * Creates a secure document builder factory. Resorts to default if not possible.
     * 
     * @return the document builder factory
     */
    public static DocumentBuilderFactory newSecureInstance() {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            configureSecure(dbf);
        } catch (ParserConfigurationException e) {
            System.out.println("Cannot configure secure document builder factory. Resorting to default. " 
                + e.getMessage());
        }
        return dbf;
    }
    
    /**
     * Configures {@code dbf} for security.
     * 
     * @param dbf the document builder factory
     * @return the configured document builder factory
     * @throws ParserConfigurationException if configuring fails
     */
    public static DocumentBuilderFactory configureSecure(DocumentBuilderFactory dbf) 
        throws ParserConfigurationException {
        dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
        dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        return dbf;
    }


    
}
