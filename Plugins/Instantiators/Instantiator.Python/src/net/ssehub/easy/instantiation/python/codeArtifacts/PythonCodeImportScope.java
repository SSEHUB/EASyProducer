package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;

/**
 * Represents a Python import scope in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public enum PythonCodeImportScope implements IVilType {
    
    /**
     * No scope, no import.
     */
    NONE,
    
    // TODO: HERE no CLASS and FUNC instead of METHOD because in python function exist as well (more overarching term)

    /**
     * import a public function from a module.
     */
    FUNC,

    /**
     * import a module.
     */
    MODULE
    
}