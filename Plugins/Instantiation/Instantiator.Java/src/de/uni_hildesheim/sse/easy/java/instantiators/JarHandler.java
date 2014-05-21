package de.uni_hildesheim.sse.easy.java.instantiators;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.JarInputStream;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators.ZipHandler;

/**
 * A ZIP handler for JAR files.
 * 
 * @author Holger Eichelberger
 */
public class JarHandler extends ZipHandler {

    private Manifest lastOpenedManifest;
    private File manifest;
    private boolean unpackManifest;

    /**
     * Creates a JAR handler for a JAR with default manifest and without manifest unpacking.
     */
    public JarHandler() {
        this(null, false);
    }

    /**
     * Creates a JAR handler for a JAR with default manifest.
     * 
     * @param unpackManifest whether the manifest shall be unpacked
     */
    public JarHandler(boolean unpackManifest) {
        this(null, unpackManifest);
    }
    
    /**
     * Creates a JAR handler for a given manifest file.
     * 
     * @param manifest the manifest (may be <b>null</b> for a default manifest or one taken from the
     *   underlying existing JAR file)
     * @param unpackManifest whether the manifest shall be unpacked
     */
    public JarHandler(File manifest, boolean unpackManifest) {
        this.manifest = manifest;
        this.unpackManifest = unpackManifest;
    }
    
    @Override
    protected JarInputStream createInputStream(InputStream in) throws IOException {
        JarInputStream jis = new JarInputStream(in);
        lastOpenedManifest = jis.getManifest();
        return jis;
    }
    
    @Override
    protected JarOutputStream createOutputStream(OutputStream out) throws IOException {
        JarOutputStream jos;
        if (null != manifest) {
            InputStream mfIn = new FileInputStream(manifest);
            Manifest mf = new Manifest(mfIn);
            mfIn.close();
            jos = new JarOutputStream(out, mf);
        } else {
            if (null != lastOpenedManifest) {
                jos = new JarOutputStream(out, lastOpenedManifest);
            } else {
                Manifest mf = new Manifest();
                mf.getMainAttributes().put(Attributes.Name.MANIFEST_VERSION, "1.0");
                jos = new JarOutputStream(out, mf);
            }
        }
        return jos;
    }

    @Override
    protected ZipEntry createEntry(String name) {
        return new JarEntry(name);
    }
    
    @Override
    protected boolean include(File file) {
        String path = FilenameUtils.normalize(file.getPath());
        return !path.endsWith(JarFile.MANIFEST_NAME);
    }
    
    @Override
    protected void additionalUnpacking(ZipInputStream zis, File target, List<File> files) throws IOException {
        if (unpackManifest && zis instanceof JarInputStream) {
            Manifest mf = ((JarInputStream) zis).getManifest();
            File file = new File(target, JarFile.MANIFEST_NAME);
            file.getParentFile().mkdirs();
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(file);
                mf.write(fos);
                fos.close();
            } catch (IOException e) {
                IOUtils.closeQuietly(fos);
                throw e;
            }
            files.add(file);
        }
    }

    
}
