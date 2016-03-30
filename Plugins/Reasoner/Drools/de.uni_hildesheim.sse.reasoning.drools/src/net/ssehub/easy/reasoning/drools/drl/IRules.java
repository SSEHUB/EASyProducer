package net.ssehub.easy.reasoning.drools.drl;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.model.Project;

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
