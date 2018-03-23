/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.dslCore;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;

/**
 * Collects URLs representing the IVML/VIL/VTL default library. Sequence of registered URLs
 * is relevant as loading happens along that sequence. Files of default library must be exported
 * by the containing bundle and shall be registered by the respective bundle. Given URLs are resolved and prepared
 * using {@link IResourceInitializer#resolve(URL)}.
 * 
 * @author Holger Eichelberger
 */
public class DefaultLib {
    
    /**
     * The usual name of the default lib folder.
     */
    public static final String DEFAULT_LIB_FOLDER_NAME = "defaultLib";

    private static List<URL> urls = new ArrayList<URL>();

    /**
     * Appends a given URL to the list of default library URLs.
     * 
     * @param url the URL to append (may be <b>null</b>, is ignored then)
     * @throws IOException in case that resolving the given URL (if not <b>null</b>) fails
     */
    public static void appendURL(URL url) throws IOException {
        url = prepare(url);
        if (null != url && !urls.contains(url)) {
            urls.add(url);
        }
    }
    
    /**
     * Appends a given URL to the list of default library URLs. This operation logs occurred exceptions.
     * 
     * @param url the URL to append (may be <b>null</b>, is ignored then)
     * @throws IOException in case that resolving the given URL (if not <b>null</b>) fails
     */
    public static void appendURLQuietly(URL url) {
        try {
            appendURL(url);
        } catch (IOException e) {
            EASyLoggerFactory.INSTANCE.getLogger(DefaultLib.class, BundleId.ID).exception(e);
        }
    }

    /**
     * Prepends a given URL to the list of default library URLs.
     * 
     * @param url the URL to prepend (may be <b>null</b>, is ignored then)
     * @throws IOException in case that resolving the given URL (if not <b>null</b>) fails
     */
    public static void prependURL(URL url) throws IOException  {
        url = prepare(url);
        if (null != url && !urls.contains(url)) {
            urls.add(0, url);
        }
    }
    
    /**
     * Appends a given URL to the list of default library URLs. This operation logs occurred exceptions.
     * 
     * @param url the URL to append (may be <b>null</b>, is ignored then)
     */
    public static void prependURLQuietly(URL url) {
        try {
            prependURL(url);
        } catch (IOException e) {
            EASyLoggerFactory.INSTANCE.getLogger(DefaultLib.class, BundleId.ID).exception(e);
        }
    }
    
    /**
     * Removes a given URL.
     * 
     * @param url the URL to remove (may be <b>null</b>, is ignored then)
     * @throws IOException in case that resolving the given URL (if not <b>null</b>) fails
     */
    public static void removeURL(URL url) throws IOException {
        url = prepare(url);
        if (null != url) {
            urls.remove(url);
        }
    }
    
    /**
     * Removes a given URL. This operation logs occurred exceptions.
     * 
     * @param url the URL to remove (may be <b>null</b>, is ignored then)
     * @throws IOException in case that resolving the given URL (if not <b>null</b>) fails
     */
    public static void removeURLQuietly(URL url) {
        try {
            removeURL(url);
        } catch (IOException e) {
            EASyLoggerFactory.INSTANCE.getLogger(DefaultLib.class, BundleId.ID).exception(e);
        }
    }

    /**
     * Returns an iterable to all registered URLs.
     * 
     * @return the iterable
     */
    public static Iterable<URL> urls() {
        return urls;
    }
    
    /**
     * Appends all registered URLs.
     * 
     * @param target the target collection to be modified as a side effect
     */
    public static void appendAll(List<URL> target) {
        target.addAll(urls);
    }
    
    /**
     * Adds <code>url</code> to <code>target</code>. [helper]
     * 
     * @param target the target collection to be modified as a side effect
     * @param url the URL to remove (may be <b>null</b>, is ignored then)
     * @throws IOException in case that resolving the given URL (if not <b>null</b>) fails
     */
    public static void append(List<URL> target, URL url) throws IOException {
        url = prepare(url);
        if (null != url) {
            target.add(url);
        }
    }
    
    /**
     * Adds <code>url</code> to <code>target</code>.  This operation logs occurred exceptions. [helper]
     * 
     * @param target the target collection to be modified as a side effect
     * @param url the URL to remove (may be <b>null</b>, is ignored then)
     */
    public static void appendQuietly(List<URL> target, URL url) {
        try {
            append(target, url);
        } catch (IOException e) {
            EASyLoggerFactory.INSTANCE.getLogger(DefaultLib.class, BundleId.ID).exception(e);
        }
    }

    /**
     * Prepares a given <code>url</code>.
     * 
     * @param url the URL to be prepared (ignored if <b>null</b>)
     * @return the prepared URL (may be <b>null</b>)
     * @throws IOException in case that resolving the given URL (if not <b>null</b>) fails
     */
    private static URL prepare(URL url) throws IOException {
        URL result = url;
        if (null != result) {
            // ResourceInitializer might work, but would fail in testing. As we have a dependency
            // to org.eclipse.core.runtime, we can also directly use the FileLocator
            result = FileLocator.resolve(result);
            url = new URL(url.toString().replaceAll(" ", "%20"));
        }
        return result;
    }

    /**
     * Tries to find the default lib URL. The first pass uses the class loader. If this fails, we use 
     * {@link #findFallbackLibFolder(String, String)}, which searches for <code>parentFolder</code> 
     * containing {@link #DEFAULT_LIB_FOLDER_NAME} starting at the current folder walking up to the root
     * folder. This complicated approach may be needed in standalon/CI testing.
     * 
     * @param loader the class loader for holding the default lib
     * @param parentFolderName name of the parent folder,
     * @return the default lib URL or <b>null</b>
     * @throws IOException in case of I/O problems or problems constructing the result URL
     * @see #findDefaultLibURL(ClassLoader, String, String)
     */
    public static URL findDefaultLibURL(ClassLoader loader, String parentFolderName) throws IOException {
        return findDefaultLibURL(loader, parentFolderName, DEFAULT_LIB_FOLDER_NAME);
    }

    /**
     * Tries to find the default lib URL. The first pass uses the class loader. If this fails, we use 
     * {@link #findFallbackLibFolder(String, String)}, which searches for <code>parentFolder</code> 
     * containing <code>defaultLibFolderName</code> starting at the current folder walking up to the root
     * folder. This complicated approach may be needed in standalon/CI testing.
     * 
     * @param loader the class loader for holding the default lib
     * @param parentFolderName name of the parent folder,
     * @param defaultLibFolderName name of the contained default lib folder
     * @return the default lib URL or <b>null</b>
     * @throws IOException in case of I/O problems or problems constructing the result URL
     */
    public static URL findDefaultLibURL(ClassLoader loader, String parentFolderName, 
        String defaultLibFolderName) throws IOException {
        URL dfltUrl = loader.getResource(defaultLibFolderName);
        if (null == dfltUrl) { // fallback if unpacked / in standalone jUnit testing
            File f = findFallbackLibFolder(parentFolderName, defaultLibFolderName);
            if (null != f) {
                dfltUrl = f.getAbsoluteFile().toURI().toURL();
            }
        }
        return dfltUrl;
    }

    /**
     * Tries to Find a fallback in the actual folder or its recursive (for Jenkins) parent folders.
     * 
     * @param parentFolderName name of the parent folder,
     * @param defaultLibFolderName name of the contained default lib folder
     * @return the fallback folder or <b>null</b> if there is none
     */
    public static File findFallbackLibFolder(String parentFolderName, String defaultLibFolderName) {
        File result = new File(defaultLibFolderName).getAbsoluteFile();
        if (!result.exists()) {
            result = null;
            File f = new File(".").getAbsoluteFile();
            do {
                if (null != f) {
                    f = f.getParentFile();
                    result = findFallbackLibFolder(f, parentFolderName, defaultLibFolderName);
                }
            } while (null != f && null == result);
        }
        return result;
    }

    /**
     * Finds a fallback in <code>file</code> or its recursive (for Jenkins) parent folders.
     * 
     * @param file the file/folder to search
     * @param folderName the folder name to search for, <b>null</b> to search for <code>defaultLibFolderName</code> 
     *     (second pass)
     * @param defaultLibFolderName the default lib folder name
     * @return the fallback folder or <b>null</b> if the is none
     */
    private static File findFallbackLibFolder(File file, String folderName, String defaultLibFolderName) {
        File result = null;
        File[] files = null == file ? null : file.listFiles();
        if (null != files) {
            for (int i = 0; null == result && i < files.length; i++) {
                if (files[i].isDirectory()) {
                    String fName = files[i].getName();
                    if (null == folderName) {
                        if (defaultLibFolderName.equals(fName)) {
                            result = files[i];
                        }
                    } else {
                        if (folderName.equals(files[i].getName())) {
                            result = findFallbackLibFolder(files[i], null, defaultLibFolderName);
                        } else {
                            result = findFallbackLibFolder(files[i], folderName, defaultLibFolderName);
                        }                            
                    }
                }
            }
        }
        return result;
    }

}
