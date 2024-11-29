package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a Python parameter in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeParamSpec extends PythonCodeElement {
    private String name;
    private PythonCodeTypeSpec type = null;

    protected PythonCodeParamSpec(PythonCodeFunction parentFunc, String name) {
        super(parentFunc);
        this.name = name;
    }

    protected PythonCodeParamSpec(PythonCodeFunction parentFunc, String name, String type) {
        super(parentFunc);
        this.name = name;
        if (type != null && !type.isEmpty()) {
            this.type = new PythonCodeTypeSpec(type, parentFunc);
        }
    }

    protected PythonCodeParamSpec(PythonCodeFunction parentFunc, String name, PythonCodeTypeSpec type) {
        super(parentFunc);
        this.name = name;
        this.type = type;
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        out.print(name);
        if (type != null) {
            out.print(": ");
            type.store(out);
        }
    }
}
