package de.uni_hildesheim.sse.easy_producer.persistence.standard;

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
     * CopyMechanisms
     */
    /**
     * <b>CopyMechanism Configuration:</b> The ID of the chosen mechanism.
     */
    static final String COPY_ID = "copyID";
    
    /*
     * Reasoner Values
     */
    /**
     * <b>Reasoner Configuration:</b> Specifies the timeout for reasoning.
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

    /*
     * Binding Time Values
     */
    /**
     * <b>Binding Times:</b> Denotes the name for the attached Binding Time.
     */
    static final String BINDINGTIME_NAME = "name";

    /*
     * Group Values
     */
    /**
     * <b>Group:</b> Denotes the name for the group.
     */
    static final String GROUP_NAME = "name";
    /**
     * <b>Group:</b> Denotes the UUID for the group.
     */
    static final String GROUP_UUID = "id";
    /**
     * <b>Group:</b> Denotes the UUID of the PTN the group is linked with.
     */
    static final String GROUP_PTNUUID = "ptn";
    /**
     * <b>Group:</b> Attaches Decisions to Groups.
     */
    static final String GROUP_PARENT = "parent";

    /*
     * Decision Values
     */
    /**
     * <b>Decision:</b> Denotes the name of the decision.
     */
    static final String DECISION_NAME = "name";
    /**
     * <b>Decision:</b> Denotes the type of the decision.
     */
    static final String DECISION_TYPE = "type";
    /**
     * <b>Decision:</b> Denotes the name of the PTN the decision is linked with.
     */
    static final String DECISION_PTNUUID = "ptn";
    /**
     * <b>Decision:</b> Denotes the id of the decision.
     */
    static final String DECISION_UUID = "id";
    /**
     * <b>Decision:</b> Denotes the cardinality of the decision.
     */
    static final String DECISION_CARDINALITY = "cardinality";
    /**
     * <b>Decision:</b> Denotes the possible values the decision can adopt.
     */
    static final String DECISION_POSSIBELVALUES = "possiblevalues";
    /**
     * <b>Decision:</b> Denotes the group the decision is attached to.
     */
    static final String DECISION_GROUP = "group";
    /**
     * <b>Decision:</b> Denotes the binding times linked with the decision.
     */
    static final String DECISION_BINDINGTIMES = "bindingtimes";
    /**
     * <b>Decision:</b> Denotes how possible binding times are separated inside the data model.
     */
    static final String DECISION_BINDINGTIME_SEPARATOR = ",";

    /*
     * Dependency Model Values
     */
    /**
     * <b>Decision:</b> Denotes the rule for the dependency model.
     */
    static final String DEPENDENCYMODEL_RULE = "rule";

    /*
     * ModelEntity Values
     */
    /**
     * <b>ModelEntity:</b> Denotes the inheritanceChain for the model entity.
     */
    static final String MODELENTITY_INHERITANCECHAIN = "inheritanceChain";

    /**
     * <b>ModelEntity:</b> Denotes the inheritanceChain for the model entity.
     */
    static final String MODELENTITY_NAME = "name";

    /**
     * <b>ModelEntity:</b> Denotes the inheritanceChain for the model entity.
     */
    static final String MODELENTITY_ENTITYID = "entityID";

    /**
     * <b>ModelEntity:</b> Separates the individual plps inside the inheritanceChain.
     */
    static final String MODELENTITY_INTERITANCE_SEPERATOR = ";";

    /*
     * Configuration Values
     */
    /**
     * <b>Configuration:</b> Denotes the type for the configuration if it is a decision or a group.
     */
    static final String CONFIGURATION_TYPE = "type";
    /**
     * <b>Configuration:</b> Denotes the model for the configuration.
     */
    static final String CONFIGURATION_MODEL = "model";
    /**
     * <b>Configuration:</b> Denotes the value for the configuration.
     */
    static final String CONFIGURATION_VALUE = "value";
    /**
     * <b>Configuration:</b> Denotes the UUID for the PTN the configuration is linked with.
     */
    static final String CONFIGURATION_PTNUUID = "ptn";
    /**
     * <b>Configuration:</b> Denotes the Type for the Configuration if its a decision.
     */
    static final String CONFIGURATION_TYPE_DECISION = "decision";
    /**
     * <b>Configuration:</b> Denotes the Type for the Configuration if its a group.
     */
    static final String CONFIGURATION_TYPE_GROUP = "group";
    /**
     * <b>Configuration:</b> Denotes the Type for the Configuration if its a element.
     */
    static final String CONFIGURATION_TYPE_ELEMENT = "element";
    /**
     * <b>Configuration:</b> Denotes if the Configuration is unchecked.
     */
    static final String CONFIGURATION_UNCHECKED = "unchecked";
}
