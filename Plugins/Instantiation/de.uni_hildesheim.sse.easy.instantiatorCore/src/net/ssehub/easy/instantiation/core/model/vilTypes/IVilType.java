package net.ssehub.easy.instantiation.core.model.vilTypes;

import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.DecisionVariable;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.EnumValue;

/**
 * Represents the hierarchy of all types usable in VIL and its languages.
 * 
 * @author Holger Eichelberger
 */
public interface IVilType {

    /**
     * Converts an object value (potentially an IVML/VIL value) to a Java value.
     * 
     * @param val the value
     * @return {@code val} or the converted value
     */
    public static Object convertVilValue(Object val) {
        if (val instanceof DecisionVariable) {
            val = ((DecisionVariable) val).getValue();
        }
        if (val instanceof EnumValue) {
            val = ((EnumValue) val).getName();
        }
        return val;
    }
    
}
