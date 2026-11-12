package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a Python "match" in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeMatch extends PythonCodeElement {

    private class PythonCodeCase extends PythonCodeBlock {
    
        private String condition;

        public PythonCodeCase(IPythonCodeElement parent) {
            this(parent, "_");
        }

        public PythonCodeCase(IPythonCodeElement parent, String condition) {
            super(parent);
            this.condition = condition;
        }

        @Override
        @Invisible(inherit = true)
        public String getTracerStringValue(StringComparator comparator) {
            return condition.equals("_") ? "PythonCodeDefault" : "PythonCodeCase";
        }

        @Override
        public void store(CodeWriter out) {
            out.printlnwi("case " + condition + ":");

            out.increaseIndent();
            super.store(out);
            out.decreaseIndent();
        }
    }

    private List<PythonCodeCase> cases = new ArrayList<>();
    private PythonCodeCase defaultCase;
    private String expr;

    public PythonCodeMatch(IPythonCodeElement parent, String expr) {
        super(parent);
        this.expr = expr;
    }

    public PythonCodeBlock addCase(String expr) {
        PythonCodeCase c = new PythonCodeCase(this, expr);
        if (expr.equals("_")) {
            defaultCase = c;
        } else {
            cases.add(c);
        }
        return c;
    }

    public PythonCodeBlock addDefault() {
        defaultCase = new PythonCodeCase(this);
        return defaultCase;
    }

    @Override
    public void store(CodeWriter out) {
        out.printlnwi("match " + expr + ":");

        out.increaseIndent();
        for (PythonCodeCase c : cases) {
            c.store(out);
        }

        if (defaultCase != null) {
            defaultCase.store(out);
        }
        out.decreaseIndent();
    }
}
