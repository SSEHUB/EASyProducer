package de.uni_hildesheim.sse.easy.loader.framework;

import java.io.File;
import java.io.IOException;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.regex.PatternSyntaxException;

/**
 * Implements a simple name filter filtering the symbolic name from the JAR manifests for the given regular expression.
 * 
 * @author Holger Eichelberger
 */
public class SimpleManifestNameFilter extends SimpleNameFilter {

    /**
     * Creates a simple name filter from the given Java regular expression.
     * 
     * @param regEx the regular expression to be considered
     * @throws PatternSyntaxException in case that the pattern syntax is wrong
     */
    public SimpleManifestNameFilter(String regEx) throws PatternSyntaxException {
        super(regEx);
    }
    
    @Override
    public boolean acceptJar(File jar) {
        boolean result = false;
        JarFile jarFile = null;
        try {
            jarFile = new JarFile(jar);
            Manifest manifest = jarFile.getManifest();
            Attributes attributes = BundleInfo.getAttributes(manifest);
            String name = BundleInfo.parseSymbolicName(attributes);
            result = acceptSymbolicName(name);
            jarFile.close();
        } catch (IOException e) {
            Utils.closeQuietly(jarFile);
            Log.warn("while scanning bundle in manifest filter: ", e);
        } catch (BundleException e) {
            Utils.closeQuietly(jarFile);
            Log.warn("while scanning bundle in manifest filter: ", e);
        }
        return result;
    }

}
