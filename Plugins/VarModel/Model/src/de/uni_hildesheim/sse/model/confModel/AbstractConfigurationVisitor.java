package de.uni_hildesheim.sse.model.confModel;

import java.util.Iterator;

/**
 * Provides a basic implementation of the visitor interface for visiting the
 * decisions in the sequence of storage.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractConfigurationVisitor implements IConfigurationVisitor {
    
    /**
     * Visits a configuration.
     * 
     * @param configuration the configuration to visit
     */
    public void visitConfiguration(Configuration configuration) {
        Iterator<IDecisionVariable> variableIterator = configuration.iterator();
        while (variableIterator.hasNext()) {
            variableIterator.next().accept(this);
        }
    }

}
