package de.uni_hildesheim.sse.model.varModel.datatypes;

import de.uni_hildesheim.sse.model.varModel.IModelElement;

/**
 * Class to specify the container and compound.
 * @author beck
 */
public abstract class StructuredDatatype extends CustomDatatype {
    
    /**
     * Constructor.
     * @param name the name of the object.
     * @param singleton the instance which knows the operations
     * @param parent the object, in which this specific one is embedded
     */
    protected StructuredDatatype(String name, DelegatingType singleton, IModelElement parent) {
        super(name, singleton, parent);
    }

}
