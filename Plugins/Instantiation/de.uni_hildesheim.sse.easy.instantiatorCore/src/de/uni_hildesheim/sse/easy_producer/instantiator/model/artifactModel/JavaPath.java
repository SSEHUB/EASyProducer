package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;

/**
 * Represents a Java path. {@link Path paths} can be converted to Java paths
 * under certain circumstances and v.v.
 * 
 * @author Holger Eichelberger
 */
public class JavaPath extends Path {

    private String path;

    /**
     * Creates a new java path from a given path.
     * 
     * @param path the path to create this java path from
     * @throws ArtifactException in case that path cannot be converted
     */
    protected JavaPath(Path path) throws ArtifactException {
        this(path, null);
    }
    
    /**
     * Creates a new java path from a given path.
     * 
     * @param path the path to create this java path from
     * @param prefixRegEx an optional regular expression (intended for prefixes) to be 
     *   replaced by the empty string (may be <b>null</b>)
     * @throws ArtifactException in case that path cannot be converted
     */
    protected JavaPath(Path path, String prefixRegEx) throws ArtifactException {
        super(path.getPath(), path.getArtifactModel());
        String tmp = path.getPath();
        if (null != prefixRegEx) {
            tmp = tmp.replaceAll(prefixRegEx, "");
        }
        if (FileUtils.isFile(tmp)) {
            int pos = tmp.lastIndexOf('.');
            if (pos > 0) {
                tmp = tmp.substring(0, pos);
            }
        }
        this.path = tmp.replace(SEPARATOR, ".").replace("\\", ".");
        checkJavaPath(this.path);
    }
    
    /**
     * Creates a path from the given string representation. A path may be 
     * a (regular) pattern!
     * 
     * @param path the path to construct the path object from
     * @return the created path object
     * @throws ArtifactException in case that the path does not comply to Java conventions
     */
    /*public static JavaPath create(String path) throws ArtifactException {
        return new JavaPath(path);
    }*/
    
    /**
     * Checks the given path for compliance to Java path conventions.
     * @param path the path to be checked
     * @return <code>path</code>
     * @throws ArtifactException in case that the path does not comply to Java conventions
     */
    private static String checkJavaPath(String path) throws ArtifactException {
        // we allow empty paths!
        boolean atIdentifierStart = true;
        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (atIdentifierStart) {
                if (!Character.isJavaIdentifierStart(c)) {
                    throw new ArtifactException("Java identifer must not start with '" + c + "'", 
                        ArtifactException.ID_INVALID_CHARACTER);
                }
                atIdentifierStart = false;
            } else {
                if ('.' == c) {
                    atIdentifierStart = true;
                } else {
                    if (!Character.isJavaIdentifierPart(c)) {
                        throw new ArtifactException("Java identifier must not contain '" + c + "'", 
                            ArtifactException.ID_INVALID_CHARACTER);
                    }
                }
            }
        }
        if (0 == path.length() && atIdentifierStart) {
            throw new ArtifactException("Java path must not end with '.'", ArtifactException.ID_INVALID_CHARACTER);
        }
        return path;
    }
    
    //@Invisible
    //@Override
    //public Path exclude(String pattern) {
    //    return this; // disabled
    //}
    
    @Invisible
    @Override
    public JavaPath toJavaPath() throws ArtifactException {
        return this; // disabled
    }
    
    /**
     * Deletes all files in the given path.
     */
    public void deleteAll() {
        // TODO semantics unclear
    }
    
    /**
     * Creates the directories pointing to path.
     */
    public void mkdir() {
        // TODO semantics unclear
    }
    
    @Override
    public String getPath() {
        return path;
    }
    
    @Override
    public String getName() throws ArtifactException {
        String name;
        int pos = path.lastIndexOf('.');
        if (pos > 0) {
            name = path.substring(pos + 1);
        } else {
            name = path;
        }
        return name;
    }

    @Override
    public String getPathSegments() {
        return getPackage();
    }

    /**
     * Returns the package part of this path.
     * 
     * @return the package part
     */
    public String getPackage() {
        String pkg;
        int pos = path.lastIndexOf('.');
        if (pos > 0) {
            pkg = path.substring(0, pos);
        } else {
            pkg = path;
        }
        return pkg;
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return path;
    }
    
}
