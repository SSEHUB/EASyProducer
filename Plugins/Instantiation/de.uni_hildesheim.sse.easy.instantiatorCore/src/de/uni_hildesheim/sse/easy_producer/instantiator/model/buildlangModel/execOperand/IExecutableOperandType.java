package de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.execOperand;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;

/**
 * Operates on the first operand of a 
 * {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.StrategyCallExpression} in mode 
 * {@link de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.StrategyCallExpression.Type#EXECUTE}.
 * 
 * @author Holger Eichelberger
 */
public interface IExecutableOperandType {

    /**
     * Converts an evaluated object into a string representing the name of the program to execute.
     * 
     * @param object the evaluated object
     * @return the string representing the external program
     * @throws VilException in case that something fails
     */
    public String convert(Object object) throws VilException;
    
    /**
     * Returns whether the given <code>type</code> is the same as this class can process.
     * 
     * @param type the type to be checked
     * @return <code>true</code> if it is the same, <code>false</code> else
     */
    public boolean sameType(TypeDescriptor<?> type);

    /**
     * Returns whether the object is of the same <code>type</code> as this class can process.
     * 
     * @param object tht object to be checked
     * @return <code>true</code> if it is the same, <code>false</code> else
     */
    public boolean sameType(Object object);
    
}
