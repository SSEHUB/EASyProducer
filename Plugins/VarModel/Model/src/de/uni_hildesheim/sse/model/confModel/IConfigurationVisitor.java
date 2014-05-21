package de.uni_hildesheim.sse.model.confModel;

/**
 * Defines an interface to visit a configuration.
 * 
 * @author Holger Eichelberger
 */
public interface IConfigurationVisitor {

    /**
     * Visits a configuration.
     * 
     * @param configuration the configuration to visit
     */
    public void visitConfiguration(Configuration configuration);

    /**
     * Visits a decision variable.
     * 
     * @param variable the decision variable to visit
     */
    public void visitDecisionVariable(IDecisionVariable variable);

    // TODO is there a specific reason why compound and container variables do not have visit methods here?
    
}
