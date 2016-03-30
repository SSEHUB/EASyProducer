package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

/**
 * A filter for all elements, i.e., a filter which includes nothing.
 * 
 * @author Holger Eichelberger
 */
class AllFilter implements IConfigurationFilter {

    /**
     * The singleton instance of this filter.
     */
    public static final IConfigurationFilter INSTANCE = new AllFilter();
    
    /**
     * Prevents external creation.
     */
    private AllFilter() {
    }

    @Override
    public boolean include(IvmlElement element) {
        return false;
    }

}
