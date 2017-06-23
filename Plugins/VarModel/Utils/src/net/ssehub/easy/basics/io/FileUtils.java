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

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

/**
 * Some file utility methods (may partially be taken from commons.io but this is currently no defined as dependency 
 * of this bundle - see standalone).
 * 
 * @author Holger Eichelberger
 */
public class FileUtils {

    /**
     * Returns whether the given <code>uri</code> is a file URI as returned, e.g., by a File.
     * 
     * @param uri the URI (ignored if <b>null</b>)
     * @return <code>true</code> for a file URI, <code>false</code> else
     */
    public static boolean isFileURI(URI uri) {
        return null != uri && "file".equals(uri.getScheme());
    }
    
    /**
     * Returns whether the given <code>url</code> is a JAR URL as returned, e.g., by a classloader.
     * 
     * @param url the URL (ignored if <b>null</b>)
     * @return <code>true</code> for a JAR URL, <code>false</code> else
     */
    public static boolean isFileURL(URL url) {
        return null != url && "file".equals(url.getProtocol());
    }
    
    /**
     * Copies the contents of <code>in</code> at the current position to <code>file</code>.
     * Does not attempt to close <code>in</code>. Uses a default buffer of size 1024.
     * 
     * @param file the file to write to
     * @param in the input stream
     * @throws IOException in any case of I/O problem, trying to close <code>file</code> before if possible
     */
    public static void copyToFile(File file, InputStream in) throws IOException {
        copyToFile(file, in, null);
    }

    /**
     * Copies the contents of <code>in</code> at the current position to <code>file</code>.
     * Does not attempt to close <code>in</code>. Uses a default buffer of size 1024.
     * 
     * @param file the file to write to
     * @param in the input stream
     * @param buffer a copy buffer (if <b>null</b> a default one of size 1024 is used)
     * @throws IOException in any case of I/O problem, trying to close <code>file</code> before if possible
     */
    public static void copyToFile(File file, InputStream in, byte[] buffer) throws IOException {
        if (null == buffer) {
            buffer = new byte[1024];
        }
        FileOutputStream fos = new FileOutputStream(file);
        try {
            int read;
            do {
                read = in.read(buffer);
                if (read > 0) {
                    fos.write(buffer, 0, read);
                }
            } while (read > 0);
        } catch (IOException e) {
            closeQuietly(fos);
            throw e;
        }
        fos.close();
    }

    /**
     * Closes a closeable quietly, i.e., without exception.
     * 
     * @param closeable the closeable
     */
    public static void closeQuietly(Closeable closeable) {
        if (null != closeable) {
            try {
                closeable.close();
            } catch (IOException e1) {
            }
        }
    }
    
    /**
     * Creates a (physical) file if it does not exist.
     * 
     * @param file the file (may be <b>null</b>, ignored then)
     */
    public static void createIfNotExists(File file) {
        if (null != file && !file.exists()) {
            file.mkdirs();
        }
    }
    
    /**
     * Creates a temporary directory and deletes an existing one if it already exists. Deletion on exit of JVM is 
     * enabled for the resulting directory.
     * 
     * @param name the name of the directory within the standard temporary folder 
     * @return the temporary directory
     */
    public static File createTmpDir(String name) {
        return createTmpDir(name, true);
    }

    /**
     * Creates a temporary directory. Deletion on exit of JVM is enabled for the resulting
     * directory.
     * 
     * @param name the name of the directory within the standard temporary folder 
     * @param deleteIfExists delete an existing one if it already exists
     * @return the temporary directory
     */
    public static File createTmpDir(String name, boolean deleteIfExists) {
        File result;
        String tmp = System.getProperty("java.io.tempdir");
        if (null == tmp) {
            try {
                File f = File.createTempFile("easy", "tmp");
                result = f.getParentFile();
                f.delete();
            } catch (IOException e) {
                result = new File("tmp");
                result.mkdirs();
            }
        } else {
            result = new File(tmp);
        }
        if (null != name) {
            result = new File(result, name);
        }
        if (deleteIfExists && result.exists()) {
            result.delete();
        }
        createIfNotExists(result);
        result.deleteOnExit();
        return result;
    }

}
