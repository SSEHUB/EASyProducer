package net.ssehub.easy.reasoning.drools2.model;

import net.ssehub.easy.reasoning.drools2.model.variables.ReasonerVariable;

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
