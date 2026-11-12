package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Declares a code artifact.
 * 
 * @author Kevin Schaperjahn
 */
public interface IPythonCodeArtifact {
    public void validateType(IPythonCodeTypeSpec type);

    // eqivalent to validateStaticMethodCall for Java code artifacts
    public String validateFuncCall(String name, PythonCodeImportScope scope);

    @Invisible
    public void registerImport(IPythonCodeImport imp, boolean explicit);
    
    /**
     * Adds a simple import.
     * 
     * @param imp the import
     * @return the import (for chaining)
     */
    public PythonCodeImport addImport(String imp);

    /**
     * Adds a module-based import.
     * 
     * @param from the owning module
     * @param imp the import
     * @return the import (for chaining)
     */
    public PythonCodeImport addImport(String from, String imp);
    
    /**
     * Adds a function.
     * 
     * @param name the name of the function
     * @return the function (for chaining)
     */
    public PythonCodeFunction addFunc(String name);

    /**
     * Adds a function.
     * 
     * @param name the name of the function
     * @param comment the documentation comment of the function
     * @return the function (for chaining)
     */
    public PythonCodeFunction addFunc(String name, String comment);

    
    /**
     * Moves the given import after the last import at the beginning of (this) artifact, or, if there are no 
     * imports, to the front.
     * 
     * @param imp the import to move
     */
    @Invisible
    public void moveToImports(IPythonCodeImport imp);
    
}
