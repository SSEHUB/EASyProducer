package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.util.Comparator;

/**
 * Provides a string value for execution of itself. This is orthogonal to
 * <code>toString()</code>.
 * 
 * @author Holger Eichelberger
 */
public interface IStringValueProvider {

    /**
     * Defines the interface for comparing individual string values. This may be necessary
     * to define an order for elements in order to facilitate testing.
     * 
     * @author Holger Eichelberger
     */
    public interface StringComparator extends Comparator<String> {
        
        /**
         * Returns whether this comparator is used within an execution tracer used
         * for testing.
         * 
         * @return <code>true</code> if this instance is used in a tracer, <code>false</code> else
         */
        public boolean inTracer();
        
    }
    
    /**
     * Returns the string value of this object.
     * 
     * @param comparator if the sequence of elements, e.g., in case of collections, shall
     *   be ordered according to the comparator, <b>null</b> if the original sequence shall
     *   be returned
     * @return the string value
     */
    @Invisible
    public String getStringValue(StringComparator comparator);
    
}
