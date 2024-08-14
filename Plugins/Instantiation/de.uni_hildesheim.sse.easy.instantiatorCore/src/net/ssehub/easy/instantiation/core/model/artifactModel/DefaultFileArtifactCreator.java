package net.ssehub.easy.instantiation.core.model.artifactModel;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import net.ssehub.easy.basics.messages.Message;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Defines the default file artifact creator. Subclasses may override 
 * <ul>
 *  <li>{@link #handlesFileImpl(File)}</li>
 *  <li>{@link #getArtifactClass()}</li>
 *  <li>{@link #createArtifactInstance(Object, ArtifactModel)}</li>
 * </ul>
 * 
 * @author Holger Eichelberger
 */
public class DefaultFileArtifactCreator implements IArtifactCreator {

    private Pattern[] patterns;
    private boolean considerBuiltInCheck = true;
    
    /**
     * Returns whether <code>file</code> ends with <code>suffix</code>.
     * @param file the file to be tested
     * @param suffix the suffix
     * @return <code>true</code> if <code>file</code> ends with <code>suffix</code>, 
     *   <code>false</code> else
     */
    public static final boolean checkSuffix(File file, String suffix) {
        return file.getName().endsWith(suffix);
    }
    
    /**
     * Returns whether this create handles <code>file</code>.
     * 
     * @param file the file to be handled
     * @return <code>true</code> if it handles <code>file</code>, <code>false</code> else
     */
    private boolean handlesFile(File file) {
        boolean handles = FileUtils.isFile(file) && !PathUtils.isPattern(file);
        if (considerBuiltInCheck) {
            handles &= handlesFileImpl(file);
        }
        if (null != patterns) {
            String path = file.getAbsolutePath();
            for (int p = 0; !handles && p < patterns.length; p++) {
                handles |= patterns[p].matcher(path).matches();
            }
        }
        return handles;
    }

    /**
     * May specify additional properties of a file. It is already guaranteed that 
     * <code>file</code> is a file and not a directory.
     * 
     * @param file the file to be handled
     * @return <code>true</code> if it handles <code>file</code>, <code>false</code> else
     */
    protected boolean handlesFileImpl(File file) {
        return true;
    }
    
    @Override
    public Class<? extends IArtifact> getArtifactClass() {
        return FileArtifact.class;
    }
    
    @Override
    public boolean handlesArtifact(Class<? extends IArtifact> kind, Object real) {
        // handle self and those I inherit from (e.g., interfaces)
        return kind.isAssignableFrom(getArtifactClass()) && real instanceof File 
            && (handlesFile((File) real) || handlesFallback(kind, (File) real));
    }
    
    /**
     * Allows for fallback if the primary decision, e.g., based on file name extensions is not sufficient.
     * 
     * @param kind the kind of artifact, may be the exact class to look for
     * @param file the file, e.g., must be a file rather than a folder
     * @return {@code true} if this artifact creator handles the request as fallback, {@code false} else
     */
    public boolean handlesFallback(Class<? extends IArtifact> kind, File file) {
        return false;
    }

    @Override
    public IFileSystemArtifact createArtifactInstance(Object real, ArtifactModel model) throws VilException {
        return new FileArtifact((File) real, model);
    }

    @Override
    public void configure(Properties properties, List<Message> messages) {
        Class<?> artifactClass = getArtifactClass();
        if (null != artifactClass) {
            String cfg = properties.getProperty(artifactClass.getSimpleName(), null);
            if (null != cfg) {
                StringTokenizer tokens = new StringTokenizer(cfg, ",");
                if (tokens.hasMoreTokens()) {
                    List<Pattern> tmpPatterns = new ArrayList<Pattern>();
                    considerBuiltInCheck = false;
                    while (tokens.hasMoreTokens()) {
                        String token = tokens.nextToken();
                        if (DEFAULT_PATTERN.equals(token)) {
                            considerBuiltInCheck = true;
                        } else {
                            try {
                                tmpPatterns.add(Pattern.compile(token));
                            } catch (PatternSyntaxException e) {
                                messages.add(new Message(e.getMessage(), Status.WARNING));
                            }
                        }
                    }
                    if (!tmpPatterns.isEmpty()) {
                        patterns = new Pattern[tmpPatterns.size()];
                        tmpPatterns.toArray(patterns);
                    }
                }
            }
        }
    }
    
}
