package de.uni_hildesheim.sse.easy_producer.instantiator.model;

import java.util.HashSet;

/**
 * Common interface for instantiator controller.
 * @author El-Sharkawy
 *
 */
public interface IInstantiatorController {

    /**
     * Getter for the relevant instantiators to instantiate a product line infrastructure.
     * 
     * @return all inherited instantiators
     */
    public HashSet<FileInstantiator> getInheritedInstantiators();
    
    /**
     * Returns all transformators (file instantiators).
     * 
     * @return the transformators
     */
    public HashSet<FileInstantiator> getTransformators();
    // TODO: muss noch mal ordentlich gemacht werden..., Workaround für ScaleLog
    
}
