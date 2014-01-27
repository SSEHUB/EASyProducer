package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilLanguageException;

/**
 * A specific runtime environment containing the OTHERPROJECTS variable.
 * 
 * @author Holger Eichelberger
 */
public class RuntimeEnvironment extends 
    de.uni_hildesheim.sse.easy_producer.instantiator.model.common.RuntimeEnvironment {

    /**
     * Defines the other project variable, currently as a local set implementation using
     * a hash set. This variable is global across the entire execution starting at 
     * a certain script including imported scripts etc.
     */
    private OtherProjects otherProjects = new OtherProjects();
    /**
     * Registers the given script, in particular the implicit variables.
     * 
     * @param script the script to be registered
     * @throws VilLanguageException in case that accidentally a constant shall be modified
     */
    public void register(Script script) throws VilLanguageException {
        VariableDeclaration var = script.getVariableDeclaration(Script.NAME_OTHERPROJECTS);
        if (null != var) {
            addValue(var, otherProjects);
        }
    }

    /**
     * Returns the other projects variable (for package internal use only).
     * 
     * @return the other projects variable
     */
    OtherProjects getOtherProjects() {
        return otherProjects;
    }
    
}
