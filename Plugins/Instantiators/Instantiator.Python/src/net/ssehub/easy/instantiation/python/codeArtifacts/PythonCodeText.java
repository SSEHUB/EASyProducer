package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.PseudoString;

/**
 * Represents a not further refined/refinable text Python expression/statement in VTL. The raw text may consist of 
 * multiple lines. If no indentation is requested, the raw text is emitted as given. Applies 
 * {@link PseudoString#content(String)} to handle empty content expressions.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeText implements IPythonCodeElement {
    
    private String rawText;
    private boolean indent;
    private boolean endWithNewline;

    public PythonCodeText(String rawText, boolean indent, boolean endWithNewline) {
        this.rawText = PseudoString.content(rawText);
        this.indent = indent;
        this.endWithNewline = endWithNewline;
    }

    @Override
    public void store(CodeWriter out) {
        boolean done = false;
        if (indent) {
            done = out.printLinesWi(rawText, false, endWithNewline);
        }
        if (!done) {
            if (indent) {
                out.printIndent();
            }
            out.print(rawText);
            if (endWithNewline) {
                out.println();
            }
        }
    }

    @Invisible
    @Override
    public IPythonCodeArtifact getArtifact() {
        return null;
    }

    @Override
    public IPythonCodeElement getParent() {
        return null;
    }

    @Invisible
    @Override
    public void setParent(IPythonCodeElement parent) {
    }

    @Override
    public int getElementCount() {
        int lines = rawText.length() - rawText.replace("\\n", "").length();
        return lines + (endWithNewline ? 1 : 0);
    }

    @Override
    public boolean isEmptyLine() {
        return rawText != null && rawText.isEmpty();
    }
    
}
