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
}
