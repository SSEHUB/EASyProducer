package net.ssehub.easy.instantiation.python.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;

/**
 * Represents a Python "raise" in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeRaise extends PythonCodeElement {
    
    private String msg;
    private String exceptionType;

    public PythonCodeRaise(IPythonCodeElement parent, String exceptionType) {
        super(parent);
        this.exceptionType = exceptionType;
    }

    public PythonCodeRaise addMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public void store(CodeWriter out) {
        out.printwi("raise " + exceptionType);
        if (msg != null) {
            out.print("(\"" + msg + "\")");
        }
        out.println();
    }
}
