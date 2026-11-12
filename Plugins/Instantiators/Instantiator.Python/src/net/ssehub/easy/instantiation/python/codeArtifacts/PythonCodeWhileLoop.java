package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a Python "while" loop in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeWhileLoop extends PythonCodeBlock {
    
    private String condition;

    public PythonCodeWhileLoop(IPythonCodeElement parent, String condition) {
        super(parent);
        this.condition = condition;
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        out.printlnwi("while " + condition + ":");

        out.increaseIndent();
        super.store(out);
        out.decreaseIndent();
    }
    
}
