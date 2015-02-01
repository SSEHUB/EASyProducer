package de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes;

/**
 * List of possible models which can be stored via the <code>Model</code> class.
 * @author Kapeluch
 * @author El-Sharkawy
 */
public enum ModelType {
    ROOT("ProductLineProject"),
    PREDECESSORS("predecessors"),
    SUCCESSORS("successors"),
    
    /**
     * Further project settings, like debug on/off.
     */
    SETTINGS("settings"),
    /**
     * Settings of the reasoner configuration.
     */
    REASONERS("reasoners"),
    /**
     * Stores the chosen instantiators related to file types.
     */
    INSTANTIATORS("instantiators");

    private String denotation;

    /**
     * Sole constructor for this class.
     * @param denotation The name for a section/table name for storing the model of the specified type.
     */
    private ModelType(String denotation) {
        this.denotation = denotation;
    }

    /**
     * Getter for the section name of this ModelType.
     * @return The section name of this ModelType
     */
    public String getDenotation() {
        return denotation;
    }
}
