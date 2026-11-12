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

    /**
     * Creates an assignment statement.
     * 
     * @param parent the parent
     * @param varName the variable name
     * @param expr the value expression
     */
    public PythonCodeAssign(IPythonCodeElement parent, String varName, String expr) {
        super(parent);
        this.varName = varName;
        this.expr = expr;
    }

    /**
     * Creates an assignment statement.
     * 
     * @param parent the parent
     * @param varName the variable name
     * @param type the type (for annotation)
     * @param expr the value expression
     */
    public PythonCodeAssign(IPythonCodeElement parent, String varName, String type, String expr) {
        super(parent);
        this.varName = varName;
        this.expr = expr;
        this.type = new PythonCodeTypeSpec(type, parent);
    }

    /**
     * Moves this assignment to the attributes at the beginning of the containing class if there is a containing class. 
     * By default, the assignment occurs wherever it is added.
     * 
     * @return <b>this</b> for chaining
     */
    public PythonCodeAssign toAttributes() {
        IPythonCodeElement cls = getTopClass();
        if (null != cls) {
            cls.moveToAttributes(this);
        }
        return this;
    }

    /**
     * Moves this assignment conditionally to the attributes at the beginning of the containing class if there is a 
     * containing class. By default, the assignment occurs wherever it is added.
     *
     * @param apply whether this attribute shall be moved
     * @return <b>this</b> for chaining
     */
    public PythonCodeAssign toAttributes(boolean apply) {
        if (apply) {
            toAttributes();
        }
        return this;
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
