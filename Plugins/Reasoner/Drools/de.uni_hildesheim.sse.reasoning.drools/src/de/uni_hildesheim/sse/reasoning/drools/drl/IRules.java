package de.uni_hildesheim.sse.reasoning.drools.drl;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.varModel.Project;

/**
 * Interface for producing the Drools Rules.
 * @author Saripalli
 *
 */
public interface IRules {
    
    /**
     * Abstract method to get the drl for the constraint validation rules.
     * @param project Project.
     * @param config Configuration.
     * @return Returns the set of drools rules representing the constraints.
     */
    public String getConstraintValidationDRL(Project project, Configuration config);

}
