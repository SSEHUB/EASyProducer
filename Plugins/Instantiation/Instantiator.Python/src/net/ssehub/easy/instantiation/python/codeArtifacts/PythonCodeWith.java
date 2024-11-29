package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;

/**
 * Represents a Python "with" in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeWith extends PythonCodeBlock {
    
    private class PythonCodeWithItem extends PythonCodeElement {
        private String expr;
        private String varName;

        protected PythonCodeWithItem(IPythonCodeElement parent, String expr) {
            super(parent);
            this.expr = expr;
        }

        protected PythonCodeWithItem(IPythonCodeElement parent, String expr, String varName) {
            super(parent);
            this.expr = expr;
            this.varName = varName;
        }

        @Override
        public void store(CodeWriter out) {
            out.print(expr);
            if (varName != null) {
                out.print(" as " + varName);
            }
        }
    }

    private List<PythonCodeWithItem> withItems = new ArrayList<>();

    public PythonCodeWith(IPythonCodeElement parent, String expr) {
        super(parent);
        withItems.add(new PythonCodeWithItem(this, expr));
    }

    public PythonCodeWith(IPythonCodeElement parent, String expr, String varName) {
        super(parent);
        withItems.add(new PythonCodeWithItem(this, expr, varName));
    }

    public PythonCodeWith addWithItem(String expr) {
        withItems.add(new PythonCodeWithItem(this, expr));
        return this;
    }

    public PythonCodeWith addWithItem(String expr, String varName) {
        withItems.add(new PythonCodeWithItem(this, expr, varName));
        return this;
    }

    @Override
    public void store(CodeWriter out) {
        out.printwi("with ");
        IPythonCodeElement.storeList(withItems, ",", out);
        out.println(":");

        out.increaseIndent();
        super.store(out);
        out.decreaseIndent();
    }
}
