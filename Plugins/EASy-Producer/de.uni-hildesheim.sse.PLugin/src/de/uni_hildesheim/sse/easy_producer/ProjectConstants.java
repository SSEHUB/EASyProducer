package de.uni_hildesheim.sse.easy_producer;


/**
 * Constants which are globally used.
 * 
 * @author El-Sharkawy
 * @author Ahrens
 * @author Kapeluch
 * @author Kröher
 * 
 */
public abstract class ProjectConstants {

    /**
     * Folder for internal libs inside a PL-Project.
     */
    public static final String FOLDER_LIBS = "lib";
    
    /**
     * Folder for persistent configuration files.
     */
    public static final String EASY_FILES = "EASy";
    
    /**
     * Sub folder of {@link #EASY_FILES} holding ivml projects of imported projects.
     */
    public static final String IMPORTED_PROJECTS = "imported";

    /**
     * Folder for internal resources inside a PL-Project.
     */
    public static final String FOLDER_RES = "resources";

    /*
     * Constant for instantantiation
     */
    /**
     * Name of the main source folder where the other sourcefolders will be migrated to in the process of instantiation.
     * Default is "src" to match the java naming convention of the main source folder.
     */
    public static final String FOLDER_SOURCE = "src";

    /* ************************************************************************
     * Product Line ***********************************************************************
     */

    /**
     * Qualified name for the UUID Project Property.
     */
    public static final String UUID_PROPERTY_QNAME = "de.uni-hildesheim.sse.easy_producer.projectuuid";
}
