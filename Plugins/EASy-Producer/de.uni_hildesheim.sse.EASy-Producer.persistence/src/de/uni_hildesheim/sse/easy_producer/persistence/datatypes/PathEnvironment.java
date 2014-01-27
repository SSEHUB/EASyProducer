package de.uni_hildesheim.sse.easy_producer.persistence.datatypes;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.persistence.internal.util.FileUtils;

/**
 * An environment for transparently making paths relative and absolute. All
 * paths to be persisted shall be relative, all paths to be used within EASy
 * shall be absolute. Basically, this class makes locations absolute and relative
 * with respect to a given base folder (typically the workspace folder). 
 * Further, sets of paths may be given along with an identifying symbolic name, such
 * as "classpath" and external classpath entires as path. In that case, the external
 * folder will be stripped and replaced by "classpath:" while making a location relative
 * and while making it absolute the local classpath will be considered (to map to
 * a different user / machine). However, currently we only consider the file name
 * in such mapping paths so that also the names of the files within one mapping 
 * must be unique.
 * 
 * @author Holger Eichelberger
 */
public class PathEnvironment {
    
    public static final String NAME_SEPARATOR = ":";
    
    private File baseFolder;

    /**
     * Defines a mapping entry consisting of an unique symbolic name and a set of paths.
     * 
     * @author Holger Eichelberger
     */
    private class Entry {
        private String name;
        private String[] paths;

        /**
         * Creates a new entry.
         * 
         * @param name the unique name of the entry (at least within one Eclipse programming language support)
         * @param paths the paths to map to/from <code>name</code>
         */
        Entry(String name, String[] paths) {
            this.name = name;
            this.paths = new String[paths.length];
            System.arraycopy(paths, 0, this.paths, 0, paths.length);
            convertPaths(this.paths);
        }
        
        /**
         * Converts the paths to independent paths.
         * 
         * @param paths the pats to be converted
         */
        private void convertPaths(String[] paths) {
            for (int p = 0; p < paths.length; p++) {
                paths[p] = FileUtils.toIndependent(paths[p]);
            }
        }
        
        /**
         * Makes the given location relative.
         * 
         * @param location the location to make relative
         * @return the relative location or <b>null</b> if the location cannot be made relative by this entry
         */
        String makeRelative(File location) {
            String result = null;
            String tmp = FileUtils.toIndependent(location.getAbsolutePath());
            for (int p = 0; null == result && p < paths.length; p++) {
                if (null != paths[p] && paths[p].equals(tmp)) {
                    result = name + location.getName();
                }
            }
            return result;
        }

        /**
         * Makes the given location absolute.
         * 
         * @param location the location to make absolute
         * @return the absolute location or <b>null</b> if the location cannot be made absolute by this entry
         */
        File makeAbsolute(String location) {
            File result = null;
            if (location.startsWith(name)) {
                location = location.substring(name.length());
                String searchString = FileUtils.SEPARATOR + location;
                int len = location.length();
                for (int p = 0; null == result && p < paths.length; p++) {
                    if (paths[p].endsWith(searchString) && paths[p].length() > len) {
                        result = new File(paths[p].substring(0, paths[p].length() - len) + location);
                    }
                }
            }
            return result;
        }
        
        /**
         * Returns the name of this mapping.
         * 
         * @return the name
         */
        String getName() {
            return name;
        }
        
        /**
         * Adds the given paths.
         * 
         * @param paths the paths to add
         */
        void add(String[] paths) {
            if (null != paths) {
                String[] tmp = new String[this.paths.length + paths.length];
                System.arraycopy(this.paths, 0, tmp, 0, this.paths.length);
                System.arraycopy(paths, 0, tmp, this.paths.length, paths.length);
                convertPaths(tmp);
                this.paths = tmp;
            }
        }
        
        /**
         * Returns a textual representation of this object.
         * 
         * @return a textual representation
         */
        public String toString() {
            return name + Arrays.toString(paths);
        }
        
    }
    
    private List<Entry> mapping = new ArrayList<Entry>();
    
    /**
     * Creates a new path environment.
     * 
     * @param baseFolder an optional folder to make locations relative
     */
    public PathEnvironment(File baseFolder) {
        this.baseFolder = baseFolder;
    }
    
    /**
     * Adds a set of <code>paths</code> to be made relative with the given <code>name</code>.
     * 
     * @param name the name representing the paths
     * @param paths the paths to be made relative
     */
    public void addMapping(String name, String... paths) {
        if (null != name && name.length() > 0 && null != paths) {
            if (!name.endsWith(NAME_SEPARATOR)) {
                name = name + NAME_SEPARATOR;
            }
            Entry entry = null;
            for (int m = 0; null == entry && m < mapping.size(); m++) {
                Entry tmp = mapping.get(m);
                if (tmp.getName().equals(name)) {
                    entry = tmp;
                }
            }
            if (null == entry) {
                mapping.add(new Entry(name, paths));
            } else {
                entry.add(paths);
            }
        }
    }
    
    /**
     * Removes a specific mapping.
     * 
     * @param name the name of the mapping to remove
     */
    public void removeMapping(String name) {
        if (null != name) {
            for (int m = mapping.size() - 1; m >= 0; m--) {
                if (mapping.get(m).getName().equals(name)) {
                    mapping.remove(m);
                }
            }
        }
    }
    
    /**
     * Clears the mappings.
     */
    public void clear() {
        mapping.clear();
    }
    
    /**
     * Returns the base folder.
     * 
     * @return the base folder
     */
    public File getBaseFolder() {
        return baseFolder;
    }
    
    /**
     * Makes a file location relative with respect to the known paths in this instance.
     * 
     * @param location the location to be turned into a relative location
     * @return the relative location
     */
    public String makeRelative(File location) {
        String result = null;
        int size = mapping.size();
        if (size > 0) {
            for (int m = 0; null == result && m < size; m++) {
                result = mapping.get(m).makeRelative(location);
            }
        }
        if (null == result) {
            result = FileUtils.makeRelative(baseFolder, location);
        }
        return result;
    }
    
    /**
     * Makes a file location absolute with respect to the known paths in this instance.
     * 
     * @param location the location to be turned into an absolute location
     * @return the absolute location
     */
    public File makeAbsolute(String location) {
        File result = null;
        int size = mapping.size();
        if (size > 0) {
            for (int m = 0; null == result && m < size; m++) {
                result = mapping.get(m).makeAbsolute(location);
            }
        }
        if (null == result) {
            result = FileUtils.makeAbsoluteFile(baseFolder, location);
        }
        return result;
    }
    
}
