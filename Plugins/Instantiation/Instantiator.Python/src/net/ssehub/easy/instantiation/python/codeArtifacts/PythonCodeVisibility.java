package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;

/**
 * Represents a Python visibility in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public enum PythonCodeVisibility implements IVilType {
    
    PUBLIC, 
    PROTECTED, 
    PRIVATE;

    public static PythonCodeVisibility getVisibility(String varName) {
        if (varName.startsWith("_")) {
            if (varName.startsWith("__")) {
                return PythonCodeVisibility.PRIVATE;
            }
            return PythonCodeVisibility.PROTECTED;
        } else {
            return PythonCodeVisibility.PUBLIC;
        }
    }
    
}
