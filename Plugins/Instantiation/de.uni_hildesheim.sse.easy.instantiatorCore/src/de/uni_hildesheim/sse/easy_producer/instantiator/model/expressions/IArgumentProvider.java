package de.uni_hildesheim.sse.easy_producer.instantiator.model.expressions;

/**
 * Marks a class which stores / provides arguments.
 * 
 * @author Holger Eichelberger
 */
public interface IArgumentProvider {

    /**
     * Returns the number of arguments.
     * 
     * @return the number of arguments
     */
    public int getArgumentsCount();
    
    /**
     * Returns the specified argument.
     * 
     * @param index the index of the argument to be returned
     * @return the argument
     * @throws IndexOutOfBoundsException in case of 
     * <code>index &lt; 0 || index &gt;= {@link #getArgumentsCount()}</code>.
     */
    public CallArgument getArgument(int index);

}
