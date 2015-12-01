package de.uni_hildesheim.sse.model.confModel;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Provides access to configured variables.
 * 
 * @author Holger Eichelberger
 */
public interface IConfiguration {

    /**
     * Returns the specified {@link IDecisionVariable}.
     * 
     * @param declaration The declaration for which the configuration entity should be returned.
     * @return The {@link IDecisionVariable} for the given declaration
     */
    public IDecisionVariable getDecision(AbstractVariable declaration);
    
    /**
     * Returns all instances of <code>type</code>.
     *  
     * @param type the type to return the instances for
     * @return all instances of type in terms of a container value consisting of references (may be <b>null</b> if 
     * this is not possible, e.g., in case of Integer)
     */
    public Value getAllInstances(IDatatype type);

}
