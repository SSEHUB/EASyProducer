package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;

/**
 * Represents a Python doc comment in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeDocComment implements IPythonCodeElement {

    private String comment = "";
    @SuppressWarnings("unused")
    private IPythonCodeElement attachedTo;
    private List<ParamComment> params = new ArrayList<>();
    private ReturnComment returnComment;

    private class ParamComment {
        private String name;
        private String comment;
        private String type;

        private ParamComment(String name, String type, String comment) {
            this.name = name;
            this.comment = comment;
            this.type = type;
        }

        public void store(CodeWriter out) {
            out.printwi("- " + name);
            if (type != null && !type.isEmpty()) {
                out.print(" (" + type + ")");
            }
            if (!comment.isEmpty()) {
                out.print(" -- " + comment);
            }
            out.println();
        }
    }

    private class ReturnComment {
        private String comment;
        private String type;

        private ReturnComment(String comment) {
            this.comment = comment;
        }

        private void setType(String type) {
            this.type = type;
        }

        public void store(CodeWriter out) {
            out.printlnwi("Returns:");
            out.increaseIndent();

            if (type != null && !type.isEmpty()) {
                out.printlnwi(type);

                out.increaseIndent();
                out.printlnwi(comment);
                out.decreaseIndent();
            } else {
                out.printlnwi(comment);
            }

            out.decreaseIndent();
        }
    }

    public PythonCodeDocComment(IPythonCodeElement attachedTo) {
        this.comment = "";
        this.attachedTo = attachedTo;
    }

    public PythonCodeDocComment(String comment, IPythonCodeElement attachedTo) {
        this.comment = comment;
        this.attachedTo = attachedTo;
        if (this.comment == null) {
            this.comment = "";
        }
    }

    @Override
    public void store(CodeWriter out) {
        if (comment.isEmpty() && params.isEmpty() && returnComment == null) {
            return;
        }

        out.printwi("\"\"\"");
        if (!comment.isEmpty()) {
            out.print(comment.replace("\\n", "\n").replace("\\r", "\r"));

            if (params.isEmpty() && returnComment == null) {
                out.println("\"\"\"");
                return;
            }
        }

        out.println();

        if (!params.isEmpty()) {
            out.printlnwi("Parameters:");

            out.increaseIndent();
            for (ParamComment p : params) {
                p.store(out);
            }
            out.decreaseIndent();
        }

        if (returnComment != null) {
            returnComment.store(out);
        }

        out.printlnwi("\"\"\"");
    }

    @Override
    public int getElementCount() {
        int res = 0;

        if (comment != null) {
            int lines = comment.length() - comment.replace("\\n", "").length();
            res += 1 + lines;
        }

        return res;
    }

    public PythonCodeDocComment addParameterComment(String name, String comment) {
        params.add(new ParamComment(name, null, comment));
        return this;
    }

    public PythonCodeDocComment addParameterComment(String name, String type, String comment) {
        params.add(new ParamComment(name, type, comment));
        return this;
    }

    public PythonCodeDocComment addReturnComment(String comment) {
        if (null == returnComment) {
            returnComment = new ReturnComment(comment);
        } else {
            returnComment.comment = comment;
        }
        return this;
    }

    public PythonCodeDocComment addReturnType(String type) {
        if (null == returnComment) {
            returnComment = new ReturnComment("");
        }
        returnComment.setType(type);
        return this;
    }

    @Override
    public IPythonCodeArtifact getArtifact() {
        return null;
    }

    @Override
    public IPythonCodeElement getParent() {
        return null;
    }

    @Override
    public void setParent(IPythonCodeElement parent) {
    }
}
