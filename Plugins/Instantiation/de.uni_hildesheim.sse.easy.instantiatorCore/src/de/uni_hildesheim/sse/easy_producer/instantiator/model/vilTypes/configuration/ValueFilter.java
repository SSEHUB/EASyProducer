package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

/**
 * A value filter for assigned IVML configuration values.
 * 
 * @author Holger Eichelberger
 */
class ValueFilter implements IConfigurationFilter {

    private Object value;
    private Class<? extends IvmlElement> type;
    
    /**
     * A filter for configuration values.
     * 
     * @param value the value to filter for
     * @param type an optional type for the elements to be included, e.g., 
     *   attributes only (may be <b>null</b> the elements shall not be filtered for a specific type)
     */
    public ValueFilter(Object value, Class<? extends IvmlElement> type) {
        this.type = type;
        this.value = value;
    }

    @Override
    public boolean include(IvmlElement element) {
        boolean result = false;
        if (null == type || type.isInstance(element)) {
            Object eValue = element.getValue();
            if (null == value) {
                result = (eValue == null);
            } else {
                result = value.equals(eValue);
            }
        }
        return result;
    }

}