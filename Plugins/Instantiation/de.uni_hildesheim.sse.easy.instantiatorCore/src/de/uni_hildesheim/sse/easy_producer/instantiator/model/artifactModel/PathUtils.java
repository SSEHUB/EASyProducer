package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import java.io.File;

import org.apache.commons.io.FilenameUtils;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;

/**
 * Some path utilities.
 * 
 * @author Holger Eichelberger
 */
public class PathUtils {

    /**
     * Prevents external creation.
     */
    private PathUtils() {
    }

    /**
     * Normalizes the path of the given file to a VIL path string (slash-separated).
     * 
     * @param file the file to be normalized
     * @return the normalized string
     */
    @Invisible
    public static final String normalize(File file) {
        return FilenameUtils.normalize(file.getPath(), true);
    }
    
    /**
     * Normalizes the path of the given file to a VIL path string (slash-separated).
     * 
     * @param file the file to be normalized
     * @return the normalized string
     */
    @Invisible
    public static final String normalize(String file) {
        return FilenameUtils.normalize(file, true);
    }
    
    /**
     * Normalizes the given time in order to make it portable
     * across known operating systems. However, the "approximate" precision of
     * Windows file systems is closer to the real time than Linux file systems (1s precision).
     * Thus, this method normalizes the time by setting the milliseconds to zero.
     * Please note that comparisons for more recent file / timestamps shall include equality
     * to the reduced precision of caused by this method.
     * 
     * @param time the time stamp to be normalized
     * @return the normalized time
     */
    @Invisible
    public static final long normalizeTime(long time) {
        return time / 1000 * 1000;
    }

    /**
     * Normalizes the last modification time of <code>file</code>. This method calls {@link #normalizeTime(long)}.
     * 
     * @param file the file to return the normalized time for
     * @return the normalized time
     */
    @Invisible
    public static final long normalizeTime(File file) {
        return normalizeTime(file.lastModified());
    }
    
    /**
     * Normalizes the current system time by calling {@link #normalizeTime(long)}.
     * 
     * @return the normalized system time
     */
    @Invisible
    public static final long normalizedTime() {
        return normalizeTime(System.currentTimeMillis());
    }

    /**
     * Returns whether (the path to) <code>file</code> is a pattern (ANT).
     * 
     * @param file the file to the path shall be analyzed
     * @return <code>true</code> if <code>file</code> is a pattern, <code>false</code> if the path to <code>file</code> 
     *   is a true path
     */
    static boolean isPattern(File file) {
        boolean result = false;
        if (null != file) {
            result = isPattern(file.getPath());
        }
        return result;
    }
    
    /**
     * Returns whether the given <code>path</code> is a pattern (ANT).
     * 
     * @param path the path to be analyzed
     * @return <code>true</code> if <code>path</code> is a pattern, <code>false</code> if <code>path</code> 
     *   is a true path
     */
    static boolean isPattern(String path) {
        boolean isPattern = false;
        if (null != path) {
            for (int i = 0; !isPattern && i < path.length(); i++) {
                char c = path.charAt(i);
                isPattern = (c == '*' || c == '?');
            }
        }
        return isPattern;
    }

}
