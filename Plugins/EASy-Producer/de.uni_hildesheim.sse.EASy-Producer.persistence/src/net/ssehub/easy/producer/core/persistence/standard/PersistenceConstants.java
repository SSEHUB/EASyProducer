package net.ssehub.easy.producer.core.persistence.standard;

/**
 * Constants related to the persistence layer.
 * 
 * @author El-Sharkawy
 */
public interface PersistenceConstants {
    /*
     * General Constants associated to this plug-in. 
     */
    /**
     * Default folder name for persistent configuration files.
     */
    public static final String EASY_FILES_DEFAULT = "EASy";
    
    /**
     * Name of the non ivml configuration file.
     */
    static final String CONFIG_FILE = ".EASyConfig";
    
    /*
     * Reasoner Values
     */
    /**
     * <b>Reasoner Configuration:</b> Specifies the timeout for reasoning in ms.
     */
    static final String REASONER_TIMEOUT = "timeout";
    /**
     * <b>Reasoner Configuration:</b> One attribute.
     */
    static final String REASONER_ATTRIBUTE = "attribute";
    /**
     * <b>Reasoner Configuration:</b> Values of an attribute.
     */
    static final String REASONER_VALUES = "values";
    /**
     * <b>Reasoner Configuration:</b> Separates values of an attribute.
     */
    static final String REASONER_VALUE_SEPARATOR = ";";
    
    /*
     * Project Settings
     */
    /**
     * <b>Project Settings:</b> Specification whether debug information shall be stored or not.
     */
    static final String SETTINGS_DEBUG = "debug";
    
    /*
     * Instantiator Values
     */
    /**
     * <b>Instantiator:</b> Denotes which instantiator should be used.
     */
    static final String INSTANTIATOR_ENGINE = "engine";

    /**
     * <b>Instantiator:</b> Denotes all files to instantiate ny this instantiator.
     */
    static final String INSTANTIATOR_FILE = "file";

    /**
     * <b>Instantiator:</b> Denotes for which UUID is connected with the given instantiator.
     */
    static final String INSTANTIATOR_UUID = "originid";

    /**
     * <b>Instantiator:</b> Denotes the inheritance chain of the instantiator.
     */
    static final String INSTANTIATOR_INHERITED = "inheritence";

    /**
     * <b>Instantiator:</b> Denotes the last known path of the predecessor project and the path of the current context
     * project of an instantiator.
     */
    static final String INSTANTIATOR_PATHS = "paths";

    /**
     * <b>Instantiator:</b> Denotes the regular expression to split the file and project paths that were saved as
     * concatenations of Strings into the persistancy layer.
     */
    static final String INSTANTIATOR_PATH_REGEX = "//;//;//";

    /*
     * PTN Values
     */
    /**
     * <b>PTN:</b> Denotes the UUID for the given PTN.
     */
    static final String PTN_UUID = "id";

    /**
     * <b>PTN:</b> Denotes the name for the given PTN.
     */
    static final String PTN_PROJECTNAME = "name";
   
    /**
     * <b>PLP:</b> Denotes the current version of the product line project.
     */
    static final String PLP_VERSION = "version";

    /**
     * <b>PLP:</b> Denotes the physical location of the product line project.
     */
    static final String PLP_LOCATION = "location";

    /*
     * Predecessor and Successor Values
     */
    /**
     * <b>Predecessor and Successor:</b> Denotes the UUID for the linked Predecessor or Successor.
     */
    static final String PRESUCCESSOR_UUID = "id";
    /**
     * <b>Predecessor and Successor:</b> Denotes the member name for the linked Predecessor or Successor.
     */
    static final String PRESUCCESSOR_MEMEBERNAME = "name";
    /**
     * <b>Predecessor and Successor:</b> Denotes the version for the linked Predecessor or Successor.
     */
    static final String PRESUCCESSOR_VERSION = "version";
    /**
     * <b>Predecessor and Successor:</b> Denotes the location for the linked Predecessor or Successor.
     */
    static final String PRESUCCESSOR_LOCATION = "location";
}
