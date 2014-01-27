package de.uni_hildesheim.sse.reasoning.core.model;

import de.uni_hildesheim.sse.reasoning.core.model.variables.ReasonerVariable;

/**
 * Interfaces for variable containers. This can be one of the following:
 * <ul>
 * <li>{@link ReasonerModel}</li>
 * <li>{@link de.uni_hildesheim.sse.reasoning.core.model.variables.CompoundVariable}</li>
 * </ul>
 * @author El-Sharkawy
 *
 */
public interface IVariableContainer {

    /**
     * Returns a {@link ReasonerVariable} stored in this {@link IVariableContainer}.
     * @param name The name of the variable, which should be returned.
     * @return The translated {@link ReasonerVariable} or <tt>null</tt>
     * if the no variables exists with the specified name.
     */
    public ReasonerVariable getVariable(String name);
}
