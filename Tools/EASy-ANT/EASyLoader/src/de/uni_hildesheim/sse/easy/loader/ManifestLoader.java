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
package de.uni_hildesheim.sse.easy.loader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.StringTokenizer;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * Experimental: Loader that identifies the available services/activators from Manifests.
 * 
 * @author Holger Eichelberger
 */
public class ManifestLoader extends AbstractStartupInfoLoader {
    
    /**
     * The default (relative) manifest path: {@value}.
     */
    public static final String MF_PATH = "META-INF/MANIFEST.MF";

    /**
     * Creates a manifest loader with initially non-verbose output.
     * 
     * @throws IOException if loading fails
     */
    public ManifestLoader() throws IOException {
        this(false);
    }

    /**
     * Creates a manifest loader with initially non-verbose output.
     * 
     * @param loader the resource/bundle loader, may be <b>null</b> for default (this class/this thread context)
     * @throws IOException if loading fails
     */
    public ManifestLoader(ClassLoader loader) throws IOException {
        this(false, loader);
    }

    /**
     * Creates a manifest loader.
     * 
     * @param verbose whether verbose output shall be produced
     * @throws IOException if loading fails
     */
    public ManifestLoader(boolean verbose) throws IOException {
        this(verbose, null);
    }

    /**
     * Creates a manifest loader.
     * 
     * @param verbose whether verbose output shall be produced
     * @param loader the resource/bundle loader, may be <b>null</b> for default (this class/this thread context)
     * @throws IOException if loading fails
     */
    public ManifestLoader(boolean verbose, ClassLoader loader) throws IOException {
        super(loadManifests(verbose, loader));
        setVerbose(verbose);
        super.setLoader(loader); // otherwise reloads
    }

    @Override
    public void setLoader(ClassLoader loader) {
        super.setLoader(loader);
        if (null != loader) {
            try {
                setStartupSequence(loadManifests(isVerbose(), loader));
            } catch (IOException e) {
                System.err.println("Error reading manifests: " + e.getMessage());
            }
        }
    }
    
    /**
     * Loads the available manifests.
     * 
     * @param verbose whether verbose output shall be produced
     * @param loader the classloader to get the manifest resources from, may be <b>null</b> for this thread context
     * @return information instances about the loaded services/activators
     * @throws IOException if loading fails
     */
    public static List<StartupInfo> loadManifests(boolean verbose, ClassLoader loader) throws IOException {
        try {
            List<StartupInfo> reasoning = new ArrayList<>();
            List<StartupInfo> ivml = new ArrayList<>();
            List<StartupInfo> instantiationCore = new ArrayList<>();
            List<StartupInfo> vilVtl = new ArrayList<>();
            List<StartupInfo> instantiators = new ArrayList<>();
            List<StartupInfo> rest = new ArrayList<>();
            ClassLoader resourceLoader = null == loader ? Thread.currentThread().getContextClassLoader() : loader;
            final Enumeration<URL> resources =  resourceLoader.getResources(MF_PATH);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            while (resources.hasMoreElements()) {
                URL url = resources.nextElement();
                if (verbose) {
                    System.out.println("Reading manifest: " + url);
                }
                StartupInfo info = loadManifest(url, builder);
                if (null != info) {
                    String cls = info.getClassName();
                    if (cls.contains("reasoning")) {
                        reasoning.add(info);
                    } else if (cls.contains("Ivml")) {
                        ivml.add(info);
                    } else if (cls.contains("instantiation.core")) {
                        instantiationCore.add(info);
                    } else if (cls.contains("Vtl") || cls.contains("Vil")) {
                        vilVtl.add(info);
                    } else if (cls.contains("instantiation")) {
                        instantiators.add(info);
                    } else if (!cls.startsWith("org.")) { // no full start: eclipse, apache felix
                        rest.add(info);
                    }
                }
            }
            
            // a known working startup sequence, may be with less plugins
            List<StartupInfo> result = new ArrayList<>();
            result.addAll(reasoning);
            result.addAll(instantiationCore);
            result.addAll(ivml);
            result.addAll(vilVtl);
            result.addAll(instantiators);
            result.addAll(rest);
            return result;
        } catch (ParserConfigurationException e) {
            throw new IOException(e.getMessage());
        }
    }
    
    /**
     * Load a given manifest.
     * 
     * @param url the URL of the manifest
     * @param builder a re-usable document builder
     * @return information instances about the loaded services/activators
     * @throws IOException if loading fails
     */
    public static StartupInfo loadManifest(URL url, DocumentBuilder builder) throws IOException {
        StartupInfo result = null;
        Manifest mf = new Manifest(url.openStream());
        Attributes attr = mf.getMainAttributes();
        String serviceComponent = attr.getValue("Service-Component");
        if (null != serviceComponent) {
            StringTokenizer components = new StringTokenizer(serviceComponent, ",");
            while (components.hasMoreTokens()) {
                String component = components.nextToken().trim();
                String tmp = url.toString();
                tmp = tmp.substring(0, tmp.length() - MF_PATH.length());
                while (tmp.endsWith("/")) {
                    tmp = tmp.substring(0, tmp.length() - 1);
                }
                if (!component.startsWith("/")) {
                    component = "/" + component;
                }
                tmp += component;
                URL scUrl = new URL(tmp);
                try {
                    Document doc = builder.parse(scUrl.openStream());
                    NodeList implList = doc.getElementsByTagName("implementation");
                    for (int i = 0; i < implList.getLength(); i++) {
                        Node implNode = implList.item(i);
                        Node clsNode = implNode.getAttributes().getNamedItem("class");
                        if (null != clsNode) {
                            result = new StartupInfo(InitType.DS, clsNode.getNodeValue());
                        }
                    }
                } catch (IOException | SAXException e) {
                    System.err.println("Cannot read " + tmp + ": " + e.getMessage() + " Ignoring.");
                }
            }
        } else {
            String activator = attr.getValue("Bundle-Activator");
            if (null != activator) {
                result = new StartupInfo(InitType.ACTIVATOR, activator);
            }
        }
        return result;
    }

}
