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
    
    /**
     * Maximum nesting to search for fallback locations.
     */
    public static final int DEFAULT_MAX_NESTING = 3;

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
            EASyLoggerFactory.INSTANCE.getLogger(DefaultLib.class, BundleId.ID).info(
                "Added defalut library URL: " + url);
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
            try {
                result = FileLocator.resolve(result);
            } catch (NullPointerException e) {
                // may occur when running outside eclipse, e.g., in test cases
            }
            url = new URL(url.toString().replaceAll(" ", "%20"));
        }
        return result;
    }

    /**
     * Tries to find the default lib URL. The first pass uses the class loader. If this fails, we use 
     * {@link #findFallbackLibFolder(String, String)}, which searches for <code>parentFolder</code> 
     * containing {@link #DEFAULT_LIB_FOLDER_NAME} starting at the current folder walking up to the root
     * folder. This method limits the path to a nesting level of {@value #DEFAULT_MAX_NESTING}. This complicated 
     * approach may be needed in standalone/CI testing.
     * 
     * @param loader the class loader for holding the default lib
     * @param parentFolderName name of the parent folder,
     * @return the default lib URL or <b>null</b>
     * @throws IOException in case of I/O problems or problems constructing the result URL
     * @see #findDefaultLibURL(ClassLoader, String, String)
     */
    public static URL findDefaultLibURL(ClassLoader loader, String... parentFolderName) throws IOException {
        return findDefaultLibURL(loader, DefaultLib.DEFAULT_MAX_NESTING, DefaultLib.DEFAULT_LIB_FOLDER_NAME, 
            parentFolderName);
    }

    /**
     * Tries to find the default lib URL. The first pass uses the class loader. If this fails, we use 
     * {@link #findFallbackLibFolder(String, String)}, which searches for <code>parentFolder</code> 
     * containing <code>defaultLibFolderName</code> starting at the current folder walking up to the root
     * folder. This complicated approach may be needed in standalon/CI testing.
     * 
     * @param loader the class loader for holding the default lib
     * @param maxNesting the maximum file path nesting to search for, <code>0</code> is none, negative is unlimited
     * @param defaultLibFolderName name of the contained default lib folder
     * @param parentFolderName name(s) of the parent folder(s), may be full names, paths or prefix search patterns 
     *     (ending with a star), see e.g., {@link #composePluginPattern(String)}.
     * @return the default lib URL or <b>null</b>
     * @throws IOException in case of I/O problems or problems constructing the result URL
     */
    public static URL findDefaultLibURL(ClassLoader loader, int maxNesting, String defaultLibFolderName, 
        String... parentFolderName) throws IOException {
        URL dfltUrl = loader.getResource(defaultLibFolderName);
        if (null == dfltUrl) { // fallback if unpacked / in standalone jUnit testing
            File f = findFallbackLibFolder(maxNesting, defaultLibFolderName, parentFolderName);
            if (null != f) {
                dfltUrl = f.getAbsoluteFile().toURI().toURL();
            }
        }
        return dfltUrl;
    }

    /**
     * Tries to Find a fallback in the actual folder or its recursive (for Jenkins) parent folders.
     * 
     * @param maxNesting the maximum file path nesting to search for, <code>0</code> is none, negative is unlimited
     * @param defaultLibFolderName name of the contained default lib folder
     * @param parentFolderName name(s) of the parent folder(s), may be full names, paths or prefix search patterns 
     *     (ending with a star), see e.g., {@link #composePluginPattern(String)}.
     * @return the fallback folder or <b>null</b> if there is none
     */
    public static File findFallbackLibFolder(int maxNesting, String defaultLibFolderName, String... parentFolderName) {
        File result = new File(defaultLibFolderName).getAbsoluteFile();
        if (!result.exists()) {
            result = null;
            File startFolder = new File(".").getAbsoluteFile();
            if (null != startFolder) {
                startFolder = startFolder.getParentFile();
                for (int i = 0; null != startFolder && null == result && i < parentFolderName.length; i++) {
                    String par = parentFolderName[i];
                    File f = startFolder;
                    boolean prefix = false;
                    int sepPos = par.lastIndexOf('/');
                    if (sepPos > 0) {
                        f = new File(startFolder, par.substring(0, sepPos));
                        if (!f.exists()) {
                            f = null;
                        }
                        par = sepPos + 1 < par.length() ? par.substring(sepPos + 1) : null;
                    }
                    if (null != par && par.endsWith("*")) {
                        prefix = true;
                        par = par.substring(0, par.length() - 1);
                    }
                    if (null != f && par != null) {
                        result = findFallbackLibFolder(f, maxNesting, par, prefix, defaultLibFolderName);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Finds a fallback in <code>file</code> or its recursive (for Jenkins) parent folders.
     * 
     * @param maxNesting the maximum file path nesting to search for, <code>0</code> is none, negative is unlimited
     * @param file the file/folder to search
     * @param folderName the folder name to search for, <b>null</b> to search for <code>defaultLibFolderName</code> 
     *     (second pass)
     * @param prefix whether <code>folderName</code> shall be considered as a file name prefix or a full file name
     * @param defaultLibFolderName the default lib folder name
     * @return the fallback folder or <b>null</b> if the is none
     */
    private static File findFallbackLibFolder(File file, int maxNesting, String folderName, boolean prefix, 
        String defaultLibFolderName) {
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
                    } else if (maxNesting != 0) {
                        boolean matches;
                        if (prefix) {
                            matches = files[i].getName().startsWith(folderName);
                        } else {
                            matches = folderName.equals(files[i].getName());
                        }
                        if (matches) {
                            result = findFallbackLibFolder(files[i], maxNesting - 1, null, prefix, 
                                 defaultLibFolderName);
                        } else {
                            result = findFallbackLibFolder(files[i], maxNesting - 1, folderName, prefix, 
                                defaultLibFolderName);
                        }                            
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Returns a plugin pattern for searching for the default library.
     * 
     * @param pluginId the plugin id
     * @return the plugin pattern
     */
    public static String composePluginPattern(String pluginId) {
        return "plugins/" + pluginId + "*";
    }

}
