package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

/**
 * A filter for deriving configurations.
 * 
 * @author Holger Eichelberger
 */
interface IConfigurationFilter {
    
    /**
     * Returns whether a given element shall be included.
     * 
     * @param element the element to be tested
     * @return <code>true</code> if <code>element</code> shall be included, <code>false</code> else
     */
    public boolean include(IvmlElement element);
    
}
