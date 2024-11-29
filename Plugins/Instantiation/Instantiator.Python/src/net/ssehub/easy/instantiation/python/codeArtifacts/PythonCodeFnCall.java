package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringEscapeUtils;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;

/**
 * Represents a Python function call in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeFnCall extends PythonCodeExpr {

    private String name;
    private List<IPythonCodeElement> arguments = new ArrayList<>();
    private PythonCodeFnCall chained;
    private boolean usedAsStmt;
    
    private static class NamedArgument extends PythonCodeElement {
        
        private String pName;
        private IPythonCodeElement value;
        
        protected NamedArgument(IPythonCodeElement parent, String pName, IPythonCodeElement value) {
            super(parent);
            this.pName = pName;
            this.value = value;
        }

        @Override
        public void store(CodeWriter out) {
            if (null != pName && pName.length() > 0) {
                out.print(pName);
                out.print("=");
            }
            value.store(out);
        }
        
    }

    public PythonCodeFnCall(IPythonCodeElement parent, String name, PythonCodeImportScope scope) {
        super(parent);
        this.usedAsStmt = false;
        this.name = validateFuncName(parent, name, scope);
    }

    public PythonCodeFnCall(IPythonCodeElement parent, String name, PythonCodeImportScope scope, boolean usedAsStmt) {
        super(parent);
        this.usedAsStmt = usedAsStmt;
        this.name = validateFuncName(parent, name, scope);
    }
    
    public int getArgumentsCount() {
        return arguments.size();
    }

    public String getFuncName() {
        return name;
    }

    protected String validateFuncName(IPythonCodeElement parent, String name, PythonCodeImportScope scope) {
        if (scope != PythonCodeImportScope.NONE && name.contains(".")) {
            return parent.getArtifact().validateFuncCall(name, scope);
        }

        return name;
    }

    public PythonCodeFnCall addArgument(Object arg) {
        return addArgument(null, arg);
    }

    public PythonCodeFnCall addArgument(String pName, Object arg) {
        if (Boolean.TRUE == arg) {
            arg = "True";
        } else if (Boolean.FALSE == arg) {
            arg = "False";
        }
        wrapNAdd(pName, new PythonCodeText(arg.toString(), false, false));
        return this;
    }

    public PythonCodeFnCall addArgument(String arg) {
        return addArgument(null, arg);
    }

    public PythonCodeFnCall addArgument(String pName, String arg) {
        wrapNAdd(pName, new PythonCodeText(arg, false, false));
        return this;
    }

    public PythonCodeFnCall addArgument(String fnName, PythonCodeImportScope scope) {
        return addArgument(null, fnName, scope);
    }

    public PythonCodeFnCall addArgument(String pName, String fnName, PythonCodeImportScope scope) {
        return wrapNAdd(pName, new PythonCodeFnCall(this, fnName, scope));
    }

    public PythonCodeFnCall addStringArgument(String val) {
        return addStringArgument(null, val);
    }

    public PythonCodeFnCall addStringArgument(String pName, String val) {
        return addArgument(pName, "\"" + StringEscapeUtils.escapeJava(val) + "\"");
    }

    public PythonCodeLambdaExpr addLambdaArgument() {
        return addLambdaArgument(null);
    }

    public PythonCodeLambdaExpr addLambdaArgument(String pName) {
        return wrapNAdd(pName, new PythonCodeLambdaExpr(this));
    }

    public PythonCodeConstructorCall addConstructorCall(String cls) {
        return addConstructorCall(null, cls);
    }

    public PythonCodeConstructorCall addConstructorCall(String pName, String cls) {
        return wrapNAdd(pName, new PythonCodeConstructorCall(this, cls));
    }
    
    private <T extends IPythonCodeElement> T wrapNAdd(String pName, T elt) {
        arguments.add(null == pName || pName.length() == 0 ? elt : new NamedArgument(this, pName, elt));
        return elt;
    }

    public PythonCodeFnCall addCall(String fnName) {
        return addCall(fnName, PythonCodeImportScope.NONE);
    }

    public PythonCodeFnCall addCall(String fnName, PythonCodeImportScope scope) {
        chained = new PythonCodeFnCall(this, fnName, scope);
        return chained;
    }

    @Override
    public void store(CodeWriter out) {
        if (usedAsStmt) {
            out.printwi("");
        }
        out.print(name);
        storeArgumentList(out);

        if (chained != null) {
            out.print(".");
            chained.store(out);
        }

        if (usedAsStmt) {
            out.println();
        }
    }

    protected void storeArgumentList(CodeWriter out) {
        out.print("(");
        IPythonCodeElement.storeList(arguments, ",", out);
        out.print(")");
    }
}
