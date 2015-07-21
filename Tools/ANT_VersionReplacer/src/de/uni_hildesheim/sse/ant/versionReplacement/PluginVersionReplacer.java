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
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.jar.JarOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.eclipse.pde.internal.build.tasks.GenericVersionReplacer;

/**
 * Utility class for the {@link PluginsVersionTask}.
 * Static methods for:
 * <ul>
 * <li>Unzipping a <tt>JAR</tt> file.</li>
 * <li>Changing the version number inside an unpackaged plug-in/fragment</li>
 * <li>Re-Jarring the plug-in/fragment</li>
 * </ul>
 * @author El-Sharkawy
 *
 */
class PluginVersionReplacer {

    /**
     * Updates the version numbers of a plugin.
     * @param tmpFolder A temporary folder where files can be created and deleted.
     * Will be used for unpacking the plugin.
     * @param plugin The location of a plugin (jar file) to transform.
     * @param version The new version number of the plugin.
     * @param destinationFolder The destination folder where the transformed plugin shall be saved to.
     * @throws IOException 
     */
    static void updatePlugins(File tmpFolder, File plugin, String version, File destinationFolder)
        throws IOException {
            
        unZipIt(plugin, tmpFolder);
        GenericVersionReplacer replacer = new GenericVersionReplacer();
        replacer.setVersion(version);
        replacer.setPath(tmpFolder.getAbsolutePath());
        replacer.execute();
        
        File destFile = new File(destinationFolder, plugin.getName());
        String basePath = FilenameUtils.normalize(tmpFolder.getAbsolutePath());
        if (!basePath.endsWith(File.separator)) {
            basePath += File.separator;
        }
        try (ZipOutputStream out = new JarOutputStream(new FileOutputStream(destFile))) {
            addDir(basePath, tmpFolder, out);
        }
    }

    /**
     * Recursive method for adding contents (also sub folders) of a folder to a Zip file.
     * Code comes from:
     * <tt>http://www.java2s.com/Code/Java/File-Input-Output/
     * Makingazipfileofdirectoryincludingitssubdirectoriesrecursively.htm</tt>.
     * @param basePath The base path of the Zip folder (for creating relative folders inside the Zip archive).
     * @param directory The current directory which shall be zipped into the Zip archive.
     * @param out A Zip archive.
     * @throws IOException if an I/O error has occurred
     */
    private static void addDir(String basePath, File directory, ZipOutputStream out) throws IOException {
        File[] files = directory.listFiles();

        for (int i = 0; i < files.length; i++) {
            String entryName = makeRelative(basePath, files[i]);
            if (null != entryName && !entryName.isEmpty()) {
                if (files[i].isDirectory()) {
                    out.putNextEntry(new ZipEntry(entryName));
                    out.closeEntry();
                    addDir(basePath, files[i], out);
                } else {
                    out.putNextEntry(new ZipEntry(entryName));
                    FileInputStream in = new FileInputStream(files[i].getAbsolutePath());
                    try {
                        IOUtils.copy(in, out);
                        in.close();
                    } catch (IOException e1) {
                        IOUtils.closeQuietly(in);
                        throw e1;
                    }
                    out.closeEntry();
                }
            }
        }
    }
    
    /**
     * Makes a file path relative to the given <code>basePath</code>.
     * 
     * @param basePath the base path 
     * @param file the file to be made relative
     * @return the relative path (if <code>file</code> can be made relative)
     */
    private static String makeRelative(String basePath, File file) {
        String filePath = FilenameUtils.normalize(file.getAbsolutePath());
        if (null != basePath && filePath.startsWith(basePath) && filePath.length() > basePath.length()) {
            filePath = filePath.substring(basePath.length());
        }
        
        filePath = filePath.replace('\\', '/');
        if (file.isDirectory() && !filePath.endsWith("/")) {
            filePath = filePath + "/";
        }
        
        return filePath;
    }

    /**
     * Unpacks an existing JAR/Zip archive.
     * 
     * @param zipFile The Archive file to unzip.
     * @param outputFolder The destination folder where the unzipped content shall be saved.
     * @see <a href="http://www.mkyong.com/java/how-to-decompress-files-from-a-zip-file/">
     * http://www.mkyong.com/java/how-to-decompress-files-from-a-zip-file/</a>
     */
    private static void unZipIt(File zipFile, File outputFolder) {

        byte[] buffer = new byte[1024];

        try {

            // create output directory is not exists
            File folder = outputFolder;
            if (folder.exists()) {
                FileUtils.deleteDirectory(folder);
            }
            folder.mkdir();

            // get the zip file content
            ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile));
            // get the zipped file list entry
            ZipEntry ze = zis.getNextEntry();

            while (ze != null) {

                String fileName = ze.getName();
                File newFile = new File(outputFolder, fileName);

                // create all non exists folders
                // else you will hit FileNotFoundException for compressed folder
                new File(newFile.getParent()).mkdirs();

                if (!ze.isDirectory()) {
                    FileOutputStream fos = new FileOutputStream(newFile);
    
                    int len;
                    while ((len = zis.read(buffer)) > 0) {
                        fos.write(buffer, 0, len);
                    }
    
                    fos.close();
                }
                ze = zis.getNextEntry();
            }

            zis.closeEntry();
            zis.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
