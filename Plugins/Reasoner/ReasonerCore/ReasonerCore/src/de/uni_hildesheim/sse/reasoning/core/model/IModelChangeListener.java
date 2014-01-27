package de.uni_hildesheim.sse.reasoning.core.model;

import de.uni_hildesheim.sse.reasoning.core.model.variables.ReasonerVariable;

/**
 * Interface for the variable updater listener.
 * @author Sizonenko
 *
 */
public interface IModelChangeListener {
    
    /**
     * Method to be caled when a {@link ReasonerVariable} is changed in the reasoning process.
     * @param changedVariable changed {@link ReasonerVariable}.
     */
    public void variableChanged(ReasonerVariable changedVariable);

}
