package de.uni_hildesheim.sse.easy_producer.instantiator.model;

/**
 * Instantiator and Binding time relation: Models which instantiator is able to handle which binding time.
 * @author Reuss
 *
 */
public class TransformatorBindingRelation {
    private String bindingTime;
    private String transformator;

    /**
     * Sole constructor for this class.
     * @param transformator The instantiator which should be configured.
     * @param bindingTime The Binding time which should be set to the specified instantiator
     */
    public TransformatorBindingRelation(String transformator, String bindingTime) {
        this.bindingTime = bindingTime;
        this.transformator = transformator;
    }

    /**
     * Getter for the binding time.
     * @return The binding time
     */
    public String getBindingTime() {
        return bindingTime;
    }

    /**
     * Getter for the instantiator.
     * @return The instantiator
     */
    public String getTransformator() {
        return transformator;
    }
}
