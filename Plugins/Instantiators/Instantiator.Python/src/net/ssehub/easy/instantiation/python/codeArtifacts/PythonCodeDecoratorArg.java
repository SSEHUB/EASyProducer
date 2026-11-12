package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a Python decorator argument in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeDecoratorArg implements IPythonCodeElement {

    private String value;
    private PythonCodeDecorator decorator;

    public PythonCodeDecoratorArg(String value, PythonCodeDecorator decorator) {
        this.value = value;
        this.decorator = decorator;
    }

    @Invisible(inherit = true)
    @Override
    public String getTracerStringValue(StringComparator comparator) {
        return getClass().getSimpleName() + " (" + value + ")";
    }

    @Override
    public int getElementCount() {
        return 0;
    }

    @Override
    public IPythonCodeArtifact getArtifact() {
        return decorator.getArtifact();
    }

    @Override
    public IPythonCodeElement getParent() {
        return decorator;
    }

    @Invisible
    @Override
    public void setParent(IPythonCodeElement parent) {
        IPythonCodeElement.setParent(parent, PythonCodeDecorator.class, p -> this.decorator = p);
    }

    @Override
    public void store(CodeWriter out) {
        out.print(value);
    }
}
