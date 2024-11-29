package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Interface for a Python type specification.
 * 
 * @author Kevin Schaperjahn
 */
public interface IPythonCodeTypeSpec extends Storable {
    @Invisible(inherit = true)
    public String getOutputTypeName();

    @Invisible(inherit = true)
    public void setOutputTypeName(String typeName);
}
