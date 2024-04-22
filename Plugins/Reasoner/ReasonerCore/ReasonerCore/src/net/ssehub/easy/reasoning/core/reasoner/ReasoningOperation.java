package net.ssehub.easy.reasoning.core.reasoner;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.Project;

/**
 * Specifies which kind of reasoning should be performed by the reasoner.
 * @author El-Sharkawy
 * @author Sizonenko
 *
 */
public enum ReasoningOperation {
    
    /**
     * Checks whether the {@link Project} is satisfiable.
     */
    CONSITENCY_CHECK,
    
    /**
     * Checks whether the {@link Configuration} is valid, i.e.
     * all constraints are satisfied.
     */
    VALIDATION,
    
    /**
     * Performs as {@link #VALIDATION} and propagates values.
     */
    PROPAGATION;

}
