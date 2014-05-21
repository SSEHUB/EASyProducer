package de.uni_hildesheim.sse.easy_producer.core.varMod.tracing;

import java.util.HashSet;
import java.util.Set;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.StringValueHelper;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Helper meethods for the tracers.
 * 
 * @author Holger Eichelberger
 */
class TracerHelper {

    /**
     * The types excluded from tracing.
     */
    private static final Set<TypeDescriptor<?>> EXCLUDED_TYPES = new HashSet<TypeDescriptor<?>>();
    private static final Set<OperationType> EXCLUDED_OPERATIONS = new HashSet<OperationType>();
    
    static {
        // don't show too much details
        EXCLUDED_TYPES.add(TypeRegistry.stringType());
        EXCLUDED_TYPES.add(TypeRegistry.integerType());
        EXCLUDED_TYPES.add(TypeRegistry.booleanType());
        EXCLUDED_TYPES.add(TypeRegistry.realType());
        
        // don't show too much details
        EXCLUDED_OPERATIONS.add(OperationType.INFIX);
        EXCLUDED_OPERATIONS.add(OperationType.POSTFIX);
        EXCLUDED_OPERATIONS.add(OperationType.PREFIX);
    }
    
    /**
     * Prevents external creation. [utility class]
     */
    private TracerHelper() {
    }
    
    /**
     * Returns whether the given <code>descriptor</code> shall be traced.
     * 
     * @param descriptor the descriptor to be traced
     * @return <code>true</code> if the descriptor shall be traced, <code>false</code> else
     */
    static boolean trace(OperationDescriptor descriptor) {
        return !descriptor.isConversion() && !EXCLUDED_TYPES.contains(descriptor.getDeclaringType()) 
            && !EXCLUDED_OPERATIONS.contains(descriptor.getOperationType());
    }
    
    /**
     * Turns an object into a string.
     * 
     * @param object the object to be turned into a string
     * @param quote whether a string shall be quoted
     * @return the string representation using {@link StringValueHelper#getStringValue(Object, 
     *   de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IStringValueProvider.StringComparator)}
     */
    static String toString(Object object, boolean quote) {
        String result = StringValueHelper.getStringValue(object, null);
        if (quote && object instanceof String) {
            result = "\"" + result.replace("\r", "").replace("\n", "") + "\"";
        }
        return result;
    }

}
