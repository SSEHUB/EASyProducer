package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;

/**
 * Represents a Python lambda expression in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeLambdaExpr extends PythonCodeExpr {
    private List<String> variables = new ArrayList<>();
    private String expr;
    private PythonCodeFnCall callExpr;

    protected PythonCodeLambdaExpr(IPythonCodeElement parent) {
        super(parent);
    }

    public PythonCodeLambdaExpr addVariable(String variable) {
        if (!variables.contains(variable)) {
            variables.add(variable);
        }

        return this;
    }

    public PythonCodeLambdaExpr addExpr(String expr) {
        this.expr = expr;
        return this;
    }

    public PythonCodeFnCall addCall(String methodName) {
        return addCall(methodName, PythonCodeImportScope.NONE);
    }

    public PythonCodeFnCall addCall(String methodName, PythonCodeImportScope scope) {
        callExpr = new PythonCodeFnCall(this, methodName, scope);
        return callExpr;
    }

    @Override
    public void store(CodeWriter out) {
        out.print("lambda ");
        out.print(IPythonCodeElement.toList(variables, ","));

        out.print(" : ");
        if (callExpr != null) {
            callExpr.store(out);
        } else {
            out.print(expr);
        }
    }
}
