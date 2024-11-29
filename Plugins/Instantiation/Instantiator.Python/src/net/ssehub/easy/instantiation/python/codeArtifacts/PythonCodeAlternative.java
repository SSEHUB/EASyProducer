package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;

/**
 * Represents a Python "if" in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeAlternative extends PythonCodeBlock {
    
    private String condition;
    private PythonCodeBlock elseBlock;

    public PythonCodeAlternative(IPythonCodeElement parent, String condition) {
        super(parent);
        this.condition = condition;
    }

    public PythonCodeBlock addElse() {
        this.elseBlock = new PythonCodeBlock(this);
        return this.elseBlock;
    }

    @Override
    public void store(CodeWriter out) {
        out.printwi("if ");
        out.print(condition);
        out.println(":");

        out.increaseIndent();
        super.store(out);
        out.decreaseIndent();

        if (elseBlock != null) {
            out.printlnwi("else:");

            out.increaseIndent();
            elseBlock.store(out);
            out.decreaseIndent();
        }

        out.println();
    }
}
