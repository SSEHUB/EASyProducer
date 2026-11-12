package net.ssehub.easy.instantiation.python.codeArtifacts;

/**
 * Interface for a Python import.
 * 
 * @author Kevin Schaperjahn
 */
public interface IPythonCodeImport extends IPythonCodeElement {
    
    public String getName();

    public String getModule();

    public boolean isWildcard();

    public String getAlias();

    public boolean match(IPythonCodeImport other);
    
}
