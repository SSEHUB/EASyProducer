/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.maven;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;

import org.eclipse.core.runtime.FileLocator;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;

/**
 * An explicit bundle activator providing access to the resources of this bundle.
 * 
 * @author Holger Eichelberger
 */
public class Activator implements BundleActivator {

    public static final String PROTOCOL_FILE = "file";
    public static final String BUNDLE_ID = "net.ssehub.easy.instantiation.maven";
    private static Bundle bundle;

    //checkstyle: stop exception type check

    @Override
    public void start(BundleContext context) throws Exception {
        bundle = context.getBundle();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
    }

    //checkstyle: resume exception type check

    /**
     * Returns all library jars.
     * 
     * @return all library jars (may be <b>null</b> if not found or not running 
     *   as OSGi bundle)
     */
    public static URL[] getJars() {
        URL[] result = null;
        if (null != bundle) {
            Enumeration<URL> e = bundle.findEntries("lib", "*.jar", true);
            if (null != e && e.hasMoreElements()) { // avoid result != null
                ArrayList<URL> tmp = new ArrayList<URL>();
                while (e.hasMoreElements()) {
                    try {
                        tmp.add(FileLocator.resolve(e.nextElement()));
                    } catch (IOException e1) {
                    }
                }
                result = new URL[tmp.size()];
                tmp.toArray(result);
            }
        }
        return result;
    }
    
    /**
     * Returns whether <code>url</code> is using a file protocol.
     * 
     * @param url the URL
     * @return <code>true</code> if protocol is file, <code>false</code> else
     */
    public static boolean isFileProtocol(URL url) {
        return null != url && url.getProtocol().equals(PROTOCOL_FILE);
    }

    /**
     * Resolves an URL.
     * 
     * @param url the URL to be resolved
     * @return the resolved URL
     */
    public static URL resolve(URL url) {
        if (null != url && !isFileProtocol(url)) { // avoid resolution outside Eclipse / in Standalone
            try {
                url = FileLocator.resolve(url);
            } catch (IOException e) {
                EASyLoggerFactory.INSTANCE.getLogger(Activator.class, BUNDLE_ID).exception(e);
            }
        }
        return url;
    }

}
