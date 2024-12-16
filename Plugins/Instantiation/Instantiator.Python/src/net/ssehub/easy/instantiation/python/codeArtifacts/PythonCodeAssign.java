package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;

/**
 * Represents a Python value assign in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeAssign extends PythonCodeStmt {
    
    private String varName;
    private PythonCodeTypeSpec type;
    private String expr;
    private PythonCodeFnCall call = null;

    public PythonCodeAssign(IPythonCodeElement parent, String varName, String expr) {
        super(parent);
        this.varName = varName;
        this.expr = expr;
    }

    public PythonCodeAssign(IPythonCodeElement parent, String varName, String type, String expr) {
        super(parent);
        this.varName = varName;
        this.expr = expr;
        this.type = new PythonCodeTypeSpec(type, parent);
    }

    public PythonCodeFnCall addCall(String fnName) {
        return addCall(fnName, PythonCodeImportScope.NONE);
    }

    public PythonCodeFnCall addCall(String fnName, PythonCodeImportScope scope) {
        call = new PythonCodeFnCall(this, fnName, scope);
        return call;
    }

    public PythonCodeConstructorCall addConstructorCall(String cls) {
        call = new PythonCodeConstructorCall(this, cls);
        return (PythonCodeConstructorCall) call;
    }

    @Override
    public void store(CodeWriter out) {
        out.printwi(varName);
        if (type != null) {
            out.print(": ");
            type.store(out);
        }

        out.print(" = ");
        if (call != null) {
            call.store(out);
        } else {
            out.print(expr);
        }
        out.println();
    }
    
    @Override
    public boolean isAttribute() {
        return getParent() instanceof PythonCodeClass;
    }
    
}
