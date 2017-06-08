/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.basics.io;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Some helpful Jar methods. Could be partially be replaced by JDK 7 FileSystem, but currently
 * this bundle is built for JDK5.
 * 
 * @author Holger Eichelberger
 */
public class JarUtils {

    /**
     * Returns whether the given <code>url</code> is a JAR URL as returned, e.g., by a classloader.
     * 
     * @param url the URL (ignored if <b>null</b>)
     * @return <code>true</code> for a JAR URL, <code>false</code> else
     */
    public static boolean isJarURL(URL url) {
        return null != url && "jar".equals(url.getProtocol());
    }
    
    /**
     * Unpacks a Jar file denoted by <code>url</code> to the given <code>target</code> folder. <code>target</code>
     * may not exist and is created then. Existing files are overwritten.
     *  
     * @param url the Jar URL
     * @param target the target folder
     * @throws MalformedURLException in case that the URL is ill formed or not a Jar URL
     * @throws IOException in case of any I/O problems
     */
    public static void unpackJar(URL url, File target) throws MalformedURLException, IOException {
        if (isJarURL(url)) {
            String path = url.getPath();
            int pos = path.indexOf('!');
            if (pos > 0 && pos + 1 < path.length()) {
                URL fileUrl = new URL(path.substring(0, pos));
                String resource = path.substring(pos + 1);
                while (resource.startsWith("/")) {
                    resource = resource.substring(1);
                }
                if (resource.isEmpty()) {
                    resource = null;
                } else if (!resource.endsWith("/")) {
                    resource += "/";
                }
                unpackJar(fileUrl, resource, target);
            } else {
                unpackJar(url, null, target);
            }
        } else {
            throw new MalformedURLException("Given URL is not a Jar URL: " + url);
        }
    }

    /**
     * Unpacks a Jar file denoted by <code>url</code> to the given <code>target</code> folder. <code>target</code>
     * may not exist and is created then. Existing files are overwritten.
     *  
     * @param url the Jar URL
     * @param resource a resource within the JAR to extract, may be a file or a folder in JAR format specification, 
     *     i.e., without leading / but trailing /
     * @param target the target folder
     * @throws MalformedURLException in case that the URL is ill formed or not a Jar URL
     * @throws IOException in case of any I/O problems
     */
    public static void unpackJar(URL url, String resource, File target) throws IOException {
        byte[] buffer = new byte[1024];
        JarInputStream jis = new JarInputStream(url.openStream());
        try {
            JarEntry entry;
            do {
                entry = jis.getNextJarEntry();
                if (null != entry) {
                    if (null == resource || entry.getName().startsWith(resource)) {
                        File targetFile = new File(target, entry.getName());
                        if (entry.isDirectory()) {
                            FileUtils.createIfNotExists(targetFile);
                        } else {
                            File parentFile = targetFile.getParentFile();
                            FileUtils.createIfNotExists(parentFile);
                            FileUtils.copyToFile(targetFile, jis, buffer);
                        }
                    }
                }
            } while (null != entry);
        } catch (IOException e) {
            FileUtils.closeQuietly(jis);
            throw e;
        }
        jis.close();
    }

}
