package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a Python "for" in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeForLoop extends PythonCodeBlock {

    private String element;
    private String array;

    public PythonCodeForLoop(IPythonCodeElement parent, String element, String array) {
        super(parent);
        this.element = element;
        this.array = array;
    }

    public PythonCodeForLoop(IPythonCodeElement parent, String iterator, String rangeStart, String rangeEnd) {
        super(parent);
        this.element = iterator;
        this.array = "range(" + rangeStart + ", " + rangeEnd + ")";
    }

    public PythonCodeForLoop(IPythonCodeElement parent, String iterator, String rangeStart, String rangeEnd,
                    String rangeStep) {
        super(parent);
        this.element = iterator;
        this.array = "range(" + rangeStart + ", " + rangeEnd + ", " + rangeStep + ")";
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        out.printlnwi("for " + element + " in " + array + ":");

        out.increaseIndent();
        super.store(out);
        out.decreaseIndent();
    }
}
