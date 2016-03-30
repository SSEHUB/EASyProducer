package net.ssehub.easy.instantiation.core.model.tracing;

import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.instantiation.core.model.vilTypes.OperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.StringValueHelper;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Helper methods for the tracers.
 * 
 * @author Holger Eichelberger
 */
class TracerHelper {

    /**
     * The types excluded from tracing.
     */
    private static final Set<TypeDescriptor<?>> EXCLUDED_TYPES = new HashSet<TypeDescriptor<?>>();
    
    static {
        // don't show too much details
        EXCLUDED_TYPES.add(TypeRegistry.stringType());
        EXCLUDED_TYPES.add(TypeRegistry.integerType());
        EXCLUDED_TYPES.add(TypeRegistry.booleanType());
        EXCLUDED_TYPES.add(TypeRegistry.realType());
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
        return !EXCLUDED_TYPES.contains(descriptor.getDeclaringType()) && descriptor.trace();
    }
    
    /**
     * Turns an object into a string.
     * 
     * @param object the object to be turned into a string
     * @param quote whether a string shall be quoted
     * @return the string representation using {@link StringValueHelper#getStringValue(Object, 
     *   net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider.StringComparator)}
     */
    static String toString(Object object, boolean quote) {
        String result = StringValueHelper.getStringValue(object, null);
        if (quote && object instanceof String) {
            result = "\"" + result.replace("\r", "").replace("\n", "") + "\"";
        }
        return result;
    }

}
