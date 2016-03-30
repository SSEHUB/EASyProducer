package net.ssehub.easy.producer.core.persistence.internal;

import java.io.PrintWriter;
import java.io.Writer;

/**
 * A print writer with indentation.
 * 
 * @author Holger Eichelberger
 */
public class IndentationPrintWriter extends PrintWriter {
    
    private String indentationStep;
    private String indentation = "";
    
    /**
     * Creates an indentation print writer with default indentation (4 whitespaces).
     * 
     * @param writer the writer to write to
     */
    public IndentationPrintWriter(Writer writer) {
        this(writer, "    ");
    }

    /**
     * Creates an indentation print writer.
     * 
     * @param writer the writer to write to
     * @param indentationStep the indentation step (appended in {@link #increaseIndentation()})
     */
    public IndentationPrintWriter(Writer writer, String indentationStep) {
        super(writer);
        this.indentationStep = indentationStep;
    }
    
    /**
     * Increases the indentation.
     */
    public void increaseIndentation() {
        indentation += indentationStep;
    }
    
    /**
     * Emits the indentation.
     */
    public void printIndentation() {
        print(indentation);
    }
    
    /**
     * Decreases the indentation.
     */
    public void decreaseIndentation() {
        int iLen = indentation.length();
        int iStepLen = indentationStep.length();
        if (iLen >= iStepLen) {
            indentation = indentation.substring(0, iLen - iStepLen);
        }
    }

}
