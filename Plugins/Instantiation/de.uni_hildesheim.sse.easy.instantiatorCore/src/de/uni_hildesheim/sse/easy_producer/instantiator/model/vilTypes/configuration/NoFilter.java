package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

/**
 * A no filter, i.e., a filter which includes everything.
 * 
 * @author Holger Eichelberger
 */
class NoFilter implements IConfigurationFilter {

    /**
     * The singleton instance of this filter.
     */
    public static final IConfigurationFilter INSTANCE = new NoFilter();
    
    /**
     * Prevents external creation.
     */
    private NoFilter() {
    }

    @Override
    public boolean include(IvmlElement element) {
        return true;
    }

}
