package de.uni_hildesheim.sse.easy_producer.persistence.internal.util;

import java.io.File;

/**
 * Some basic file utilities.
 *
 * @author Holger Eichelberger
 */
public class FileUtils {

    public static final char SEPARATOR = '/';
    
    /**
     * Prevents initialization of this utility class.
     */
    private FileUtils() {
    }
    
    /**
     * Makes a given location absolute if required.
     * 
     * @param baseFolder the base folder to be prepended if necessary
     * @param location the location to be made absolute
     * @return the absolute location
     */
    public static final File makeAbsoluteFile(File baseFolder, String location) {
        File result;
        if (null == location) {
            result = null;
        } else {
            result = new File(location);
            if (!result.isAbsolute()) {
                result = new File(baseFolder, location);
            }
        }
        return result;
    }

    /**
     * Makes a given location absolute if required.
     * 
     * @param baseFolder the base folder to be prepended if necessary
     * @param location the location to be made absolute
     * @return the absolute location as String
     */
    public static final String makeAbsolute(File baseFolder, String location) {
        String result;
        File tmp = makeAbsoluteFile(baseFolder, location);
        if (null != tmp) {
            result = tmp.getAbsolutePath();
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Make a <code>location</code> relative to <code>baseFolder</code> if possible.
     * 
     * @param baseFolder the base folder
     * @param location the location to be made relative
     * @return the relative location as String
     */
    public static final String makeRelative(File baseFolder, File location) {
        String tmp;
        if (null != location) {
            tmp = location.getAbsolutePath();
            if (null != baseFolder) {
                String baseTmp = baseFolder.getAbsolutePath();
                if (tmp.startsWith(baseTmp) && tmp.length() > baseTmp.length()) {
                    tmp = tmp.substring(baseTmp.length() + 1);
                }
            }
        } else {
            tmp = null;
        }
        return tmp;
    }

    /**
     * Make a <code>location</code> relative to <code>baseFolder</code> if possible.
     * 
     * @param baseFolder the base folder
     * @param location the location to be made relative
     * @return the relative location as String
     */
    public static final File makeRelativeFile(File baseFolder, File location) {
        File result;
        String tmp = makeRelative(baseFolder, location);
        if (null == tmp) {
            result = null;
        } else {
            result = new File(tmp);
        }
        return result;
    }

    /**
     * Converts a file into a string using a system independent separator.
     * 
     * @param file the file to be converted
     * @return the converted string
     */
    public static final String fromIndependent(String file) {
        String result;
        if (null != file) {
            // however, java.io.File does not care but it looks better in the file
            result = file.replace(SEPARATOR, File.separatorChar);
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Converts a file into a string using a system independent separator.
     * 
     * @param file the file to be converted
     * @return the converted string
     */
    public static final String fromIndependent(File file) {
        String result;
        if (null != file) {
            // however, java.io.File does not care but it looks better in the file
            result = fromIndependent(file.getAbsolutePath());
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Converts a string into a file using a system independent separator.
     * 
     * @param file the string to be converted
     * @return the converted file
     */
    public static final File toIndependentFile(String file) {
        File result;
        String tmp = toIndependent(file);
        if (null != tmp) {
            // however, java.io.File does not care but it looks better in the file
            result = new File(tmp);
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Converts a string into a file using a system independent separator.
     * 
     * @param file the string to be converted
     * @return the converted file name
     */
    public static final String toIndependent(String file) {
        String result;
        if (null != file) {
            // however, java.io.File does not care but it looks better in the file
            result = file.replace(File.separatorChar, SEPARATOR);
        } else {
            result = null;
        }
        return result;
    }

}
