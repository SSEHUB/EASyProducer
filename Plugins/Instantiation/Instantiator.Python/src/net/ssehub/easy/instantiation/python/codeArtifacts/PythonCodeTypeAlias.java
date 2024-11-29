package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;

/**
 * Represents a Python type alias in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeTypeAlias extends PythonCodeElement {
    
    private String name;
    private String expr;

    public PythonCodeTypeAlias(IPythonCodeElement parent, String name, String expr) {
        super(parent);
        this.name = name;
        this.expr = expr;

    }

    @Override
    public void store(CodeWriter out) {
        out.printlnwi("type " + name + " = " + expr);
        PythonCodeTypeSpec.create(name, this);
    }
    
}
