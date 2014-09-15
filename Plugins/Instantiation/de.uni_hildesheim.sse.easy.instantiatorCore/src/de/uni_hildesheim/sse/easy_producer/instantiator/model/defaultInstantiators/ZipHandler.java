package de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.tools.ant.types.selectors.SelectorUtils;

/**
 * Implements a handler function for ZIP files (which is prepared for handling JAR files in a similar way).
 * 
 * @author Holger Eichelberger
 * @author kroeher
 * 
 */
public class ZipHandler {

    /**
     * Adds a set of <code>files</code> (relative to <code>base</code>) to the ZIP file <code>zip</code>.
     * If <code>zip</code> exists, <code>files</code> are added to <code>zip</code>, i.e., <code>zip</code>
     * is overwritten with an updated version. If <code>zip</code> does not exist, a new <code>zip</code>
     * archive will be created.
     * 
     * @param base the base directory used for making <code>files</code> relative
     * @param files the files to be put into <code>zip</code>
     * @param zip the ZIP file
     * @return the modified files (actually only ZIP)
     * @throws IOException in case that serious I/O problems occurred
     */
    public List<File> add(File base, List<File> files, File zip) throws IOException {
        File tmp = null;
        if (zip.exists()) {
            tmp = unpack(zip, null, null, null);
        } else {
            zip.getParentFile().mkdirs();
        }
        ZipOutputStream zos = null;
        try {
            zos = createOutputStream(new FileOutputStream(zip));
            String basePath;
            if (null != base) {
                basePath = FilenameUtils.normalize(base.getAbsolutePath());
                if (!basePath.endsWith(File.separator)) {
                    basePath += File.separator;
                }
            } else {
                basePath = null;
            }
            Set<String> done = new HashSet<String>();
            for (File file : files) {
                String filePath = makeRelative(basePath, file);
                ZipEntry entry = createEntry(filePath, file);
                zos.putNextEntry(entry);
                FileInputStream in = null;
                try {
                    in = new FileInputStream(file);
                    IOUtils.copy(in, zos);
                    in.close();
                } catch (IOException e1) {
                    IOUtils.closeQuietly(in);
                    throw e1;
                }
                zos.closeEntry();
                done.add(filePath);
            }
            if (null != tmp) {
                packInto(tmp.getAbsolutePath(), tmp, zos, done);
                FileUtils.deleteQuietly(tmp);
            }
            zos.close();
        } catch (IOException e) {
            IOUtils.closeQuietly(zos);
            throw e;
        }
        List<File> result = new ArrayList<File>();
        result.add(zip);
        return result;
    }
    
    /**
     * Makes a file path relative to the given <code>basePath</code>.
     * 
     * @param basePath the base path 
     * @param file the file to be made relative
     * @return the relative path (if <code>file</code> can be made relative)
     */
    private String makeRelative(String basePath, File file) {
        String filePath = FilenameUtils.normalize(file.getAbsolutePath());
        if (null != basePath && filePath.startsWith(basePath) && filePath.length() > basePath.length()) {
            filePath = filePath.substring(basePath.length());
        }
        return filePath;
    }
    
    /**
     * Creates a ZIP input stream for <code>in</code>. This method shall be overridden
     * for specialized ZIP types, e.g., JAR.
     * 
     * @param in the input stream to create the ZIP stream for.
     * @return the ZIP input stream
     * @throws IOException in case that creating the input stream fails
     */
    protected ZipInputStream createInputStream(InputStream in) throws IOException {
        return new ZipInputStream(in);
    }

    /**
     * Creates a ZIP output stream for <code>out</code>. This method shall be overridden
     * for specialized ZIP types, e.g., JAR.
     * 
     * @param out the output stream to create the ZIP stream for.
     * @return the ZIP output stream
     * @throws IOException in case that creating the output stream fails
     */
    protected ZipOutputStream createOutputStream(OutputStream out) throws IOException {
        return new ZipOutputStream(out);
    }
    
    /**
     * Creates a ZIP entry. This method shall be overridden
     * for specialized ZIP types, e.g., JAR.
     * 
     * @param name the name of the entry
     * @param file the underlying file
     * @return the ZIP entry
     */
    protected ZipEntry createEntry(String name, File file) {
        return new ZipEntry(name);
    }
    
    /**
     * Unpacks an ZIP file to <code>target</code>.
     * 
     * @param zip the ZIP file to be unpacked (nothing happens if <code>zip</code> does not exist)
     * @param target the target directory where to unpack (a temporary directory is created if 
     *   <code>target</code> is <b>null</b>)
     * @param pattern an optional ANT pattern used as a filter expression, typically a specific folder or package. 
     *   May be <code>null</code> if no filter is required.
     * @param files the unpacked files (may contain directories, modified as a side effect, may be 
     *   <b>null</b> if the unpacked files shall not be collected)
     * @return the target directory, in particular a newly created temporary directory
     * @throws IOException in case that unpacking fails for some reason
     */
    public File unpack(File zip, File target, String pattern, List<File> files) throws IOException {
        if (zip.exists()) {
            if (null == target) {
                target = File.createTempFile("easy", "jar");
                target.delete();
                target.mkdirs();
            }
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(zip);
                ZipInputStream zis = createInputStream(fis);
                ZipEntry entry = zis.getNextEntry();
                while (null != entry) {
                    if (!entry.isDirectory() && matches(entry, pattern)) {
                        FileOutputStream fos = null;
                        try {
                            File out = new File(target, entry.getName());
                            out.getParentFile().mkdirs();
                            fos = new FileOutputStream(out);
                            IOUtils.copy(zis, fos);
                            fos.close();
                            if (null != files) {
                                files.add(out);
                            }
                        } catch (IOException e1) {
                            IOUtils.closeQuietly(fos);
                            throw e1;
                        }
                    }
                    entry = zis.getNextEntry();
                }
                additionalUnpacking(zis, target, files);
                fis.close();
            } catch (IOException e) {
                IOUtils.closeQuietly(fis);
                throw e;
            }
        }
        return target;
    }
    
    /**
     * Checks whether an <code>entry</code> matches a <code>filter</code> expression.
     * 
     * @param entry the Zip entry
     * @param pattern an optional ANT pattern used as a filter expression, typically a specific folder or package. 
     *   May be <code>null</code> if no filter is required.
     * @return <code>true</code> if <code>entry</code> matches <code>filter</code> or
     *   <code>filter</code> is <code>null</code>, <code>false</code> otherwise
     */
    private static boolean matches(ZipEntry entry, String pattern) {
        boolean matches = false;
        if (pattern == null) {
            matches = true;
        } else {
            if (entry != null && pattern.length() > 0) {
                matches = SelectorUtils.matchPath(pattern, entry.getName());
            }
        }
        return matches;
    }

    /**
     * Performs additional unpacking (called by {@link #unpack(File, File, String, List)}).
     * 
     * @param zis the ZIP input stream
     * @param target the target directory where to unpack (a temporary directory is created if 
     *   <code>target</code> is <b>null</b>)
     * @param files the unpacked files (may contain directories, modified as a side effect, may be 
     *   <b>null</b> if the unpacked files shall not be collected)
     * @throws IOException in case that unpacking fails for some reason
     */
    protected void additionalUnpacking(ZipInputStream zis, File target, List<File> files) throws IOException {
    }
    
    /**
     * Packs the files in <code>source</code> into <code>out</code>.
     * 
     * @param basePath the base path (shall be the absolute path of <code>source</code> for the first call
     * @param source the source directory to take the files from
     * @param out the ZIP output stream to write the files into
     * @param done already processed ZIP paths
     * @throws IOException in case that reading or creating files fails
     */
    private void packInto(String basePath, File source, ZipOutputStream out, Set<String> done) throws IOException {
        if (source.isDirectory()) {
            File[] files = source.listFiles();
            if (null != files) {
                for (File f: files) {
                    packInto(basePath, f, out, done);
                }
            }
        } else {
            if (include(source)) {
                String sourcePath = makeRelative(basePath, source);
                while (sourcePath.startsWith("/") || sourcePath.startsWith("\\")) {
                    sourcePath = sourcePath.substring(1);
                }
                if (!done.contains(sourcePath)) {
                    ZipEntry entry = createEntry(sourcePath, source);
                    out.putNextEntry(entry);
                    FileInputStream fis = null;
                    try {
                        fis = new FileInputStream(source);
                        IOUtils.copy(fis, out);
                        fis.close();
                    } catch (IOException e) {
                        IOUtils.closeQuietly(fis);
                        throw e;
                    }
                    out.closeEntry();
                    done.add(sourcePath);
                }
            }
        }
    }
    
    /**
     * Returns whether <code>file</code> shall be included in repackaging a JAR file.
     * 
     * @param file the file to be considered
     * @return <code>true</code> if <code>file</code> shall be packed, <code>false</code> else
     */
    protected boolean include(File file) {
        return true;
    }

}
