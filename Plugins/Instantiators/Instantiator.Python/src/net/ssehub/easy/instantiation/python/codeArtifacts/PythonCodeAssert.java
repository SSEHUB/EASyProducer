package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;

/**
 * Represents a Python "assert" in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeAssert extends PythonCodeElement {
    
    private String expr;
    private String msg;

    public PythonCodeAssert(IPythonCodeElement parent, String expr) {
        super(parent);
        this.expr = expr;
    }

    public PythonCodeAssert(IPythonCodeElement parent, String expr, String msg) {
        super(parent);
        this.expr = expr;
        this.msg = msg;
    }

    @Override
    public void store(CodeWriter out) {
        out.printwi("assert " + expr);

        if (msg != null) {
            out.print(", \"" + msg + "\"");
        }

        out.println();
    }
    
}
