package de.uni_hildesheim.sse.variability.runtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Defines a global storage holding the startup and runtime values
 * of the related decisions. This class was introduced to have a 
 * global point to add (UI) listeners to and to easily generate
 * reading accessors for the decision constants. 
 * 
 * @author Holger Eichelberger
 * @since 1.00
 * @version 1.00
 */
public class UserDecisionValues {

    public static void initializeFrom(Set<?> decisions) {
    }
	
	public static Object getValue(Object decision) {
	    return null;
	}
	
	public static boolean getBooleanValue(Object decision) {
	    return true;
    }
	
	public static void setValue(Object decision, Object value) {
	}
    
}
