package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;

/**
 * Represents a Python "try" in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeTryBlock extends PythonCodeBlock {
    
    public class PythonCodeExceptBlock extends PythonCodeBlock {
        private PythonCodeTypeSpec type;
        private String name;
        private boolean star = false;

        public PythonCodeExceptBlock(IPythonCodeElement parent) {
            super(parent);
        }

        public PythonCodeExceptBlock(IPythonCodeElement parent, String type) {
            super(parent);
            this.type = new PythonCodeTypeSpec(type, parent);
        }

        public PythonCodeExceptBlock(IPythonCodeElement parent, String type, String name) {
            super(parent);
            this.type = new PythonCodeTypeSpec(type, parent);
            this.name = name;
        }

        private void setStar() {
            star = true;
        }

        @Override
        public void store(CodeWriter out) {
            out.printwi("except");
            if (star) {
                out.print("*");
            }

            if (type != null) {
                out.print(" ");
                type.store(out);
            }

            if (name != null) {
                out.print(" as " + name);
            }

            out.println(":");

            out.increaseIndent();
            super.store(out);
            out.decreaseIndent();
        }
    }

    private List<PythonCodeExceptBlock> excepts = new ArrayList<>();
    private PythonCodeBlock elseBlock;
    private PythonCodeBlock finallyBlock;

    public PythonCodeTryBlock(IPythonCodeElement parent) {
        super(parent);
    }

    public PythonCodeBlock addExcept() {
        PythonCodeExceptBlock e = new PythonCodeExceptBlock(this);
        excepts.add(e);
        return e;
    }

    public PythonCodeBlock addExcept(String type) {
        PythonCodeExceptBlock e = new PythonCodeExceptBlock(this, type);
        excepts.add(e);
        return e;
    }

    public PythonCodeBlock addExcept(String type, String name) {
        PythonCodeExceptBlock e = new PythonCodeExceptBlock(this, type, name);
        excepts.add(e);
        return e;
    }

    public PythonCodeBlock addExceptStar() {
        PythonCodeExceptBlock e = new PythonCodeExceptBlock(this);
        e.setStar();
        excepts.add(e);
        return e;
    }

    public PythonCodeBlock addExceptStar(String type) {
        PythonCodeExceptBlock e = new PythonCodeExceptBlock(this, type);
        e.setStar();
        excepts.add(e);
        return e;
    }

    public PythonCodeBlock addExceptStar(String type, String name) {
        PythonCodeExceptBlock e = new PythonCodeExceptBlock(this, type, name);
        e.setStar();
        excepts.add(e);
        return e;
    }

    public PythonCodeBlock addElse() {
        elseBlock = new PythonCodeBlock(this);
        return elseBlock;
    }

    public PythonCodeBlock addFinally() {
        finallyBlock = new PythonCodeBlock(this);
        return finallyBlock;
    }

    @Override
    public void store(CodeWriter out) {
        out.printlnwi("try:");

        out.increaseIndent();
        super.store(out);
        out.decreaseIndent();

        for (PythonCodeExceptBlock e : excepts) {
            e.store(out);
        }

        if (elseBlock != null) {
            out.printlnwi("else:");

            out.increaseIndent();
            elseBlock.store(out);
            out.decreaseIndent();
        }

        if (finallyBlock != null) {
            out.printlnwi("finally:");

            out.increaseIndent();
            finallyBlock.store(out);
            out.decreaseIndent();
        }
    }
}
