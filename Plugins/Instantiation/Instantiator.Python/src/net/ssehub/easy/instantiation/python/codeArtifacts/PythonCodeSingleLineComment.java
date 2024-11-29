package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;

/**
 * Represents a Python single line comment in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeSingleLineComment extends PythonCodeElement {
    
    public static final String DOC_COMMENT_LITERAL = "\"\"\"";
    
    private String comment;
    private boolean enclosed = false;

    public PythonCodeSingleLineComment(IPythonCodeElement parent, String comment, boolean enclosed) {
        super(parent);
        this.comment = comment;
        this.enclosed = enclosed;
    }

    @Override
    public void store(CodeWriter out) {
        if (enclosed) {
            out.printwi(DOC_COMMENT_LITERAL);
            out.print(" ");
            out.print(comment);
            out.print(" ");
            out.println(DOC_COMMENT_LITERAL);
        } else {
            out.printwi("# ");
            out.println(comment);
        }
    }
}
