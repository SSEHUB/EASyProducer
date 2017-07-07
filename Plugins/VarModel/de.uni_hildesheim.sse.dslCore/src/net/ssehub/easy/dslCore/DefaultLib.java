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

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
            result = ModelUtility.getResourceInitializer().resolve(result);
            url = new URL(url.toString().replaceAll(" ", "%20"));
        }
        return result;
    }
    
}
