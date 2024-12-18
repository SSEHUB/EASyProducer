package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;

/**
 * Represents a Python function in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeFunction extends PythonCodeBlock {

    private String name;
    private PythonCodeTypeSpec retType;
    private PythonCodeDocComment comment;
    private List<PythonCodeDecorator> decorators = new ArrayList<>();
    private List<PythonCodeParamSpec> params = new ArrayList<>();

    public PythonCodeFunction(IPythonCodeElement parent, String name) {
        super(parent);
        this.name = name;
        this.comment = new PythonCodeDocComment(this);
    }

    public PythonCodeFunction(IPythonCodeElement parent, String name, String comment) {
        super(parent);
        this.name = name;
        this.comment = new PythonCodeDocComment(comment, this);
    }

    public PythonCodeFunction addParameter(String name) {
        params.add(new PythonCodeParamSpec(this, name));
        return this;
    }

    public PythonCodeFunction addParameter(String name, String type) {
        params.add(new PythonCodeParamSpec(this, name, type));
        return this;
    }

    public PythonCodeFunction addParameter(String name, PythonCodeTypeSpec type) {
        params.add(new PythonCodeParamSpec(this, name, type));
        return this;
    }

    public PythonCodeFunction addParameter(String name, String type, String comment) {
        this.comment.addParameterComment(name, type, comment);
        params.add(new PythonCodeParamSpec(this, name, type));
        return this;
    }

    public PythonCodeFunction addParameter(String name, PythonCodeTypeSpec type, String comment) {
        this.comment.addParameterComment(name, type.getOutputType(), comment);
        params.add(new PythonCodeParamSpec(this, name, type));
        return this;
    }

    public PythonCodeFunction addReturn(String expr, String comment) {
        this.comment.addReturnComment(comment);
        super.addReturn(expr);
        return this;
    }

    public PythonCodeFunction addRetType(String type) {
        return addRetType(type, null);
    }

    @OperationMeta(name = {"addRetType", "addReturnType"})
    public PythonCodeFunction addRetType(String type, String comment) {
        this.retType = new PythonCodeTypeSpec(type, this);
        if (comment != null && comment.length() > 0) {
            this.comment.addReturnComment(comment);
        }
        this.comment.addReturnType(type);
        return this;
    }

    public PythonCodeDecorator addDecorator(String name) {
        return addDecorator(name, PythonCodeImportScope.NONE);
    }

    public PythonCodeDecorator addDecorator(String name, PythonCodeImportScope scope) {
        PythonCodeDecorator dec = new PythonCodeDecorator(name, this, scope);
        decorators.add(dec);
        return dec;
    }
    
    public PythonCodeFunction setClass() {
        addDecorator("classmethod");
        if (!params.isEmpty() && "self".equals(params.get(0).getName())) {
            params.get(0).setName("cls");
        }
        return this;
    }

    public PythonCodeFunction setStatic() {
        //addDecorator("staticmethod"); // needs oktoflow tests first
        if (!params.isEmpty() && "self".equals(params.get(0).getName())) {
            params.remove(0);
        }
        return this;
    }

    @Override
    @Invisible
    public void store(CodeWriter out) {
        for (PythonCodeDecorator d : decorators) {
            d.store(out);
        }

        out.printwi("def " + name + "(");
        IPythonCodeElement.storeList(params, ", ", out);
        out.print(")");

        if (retType != null) {
            out.print(" -> " + retType.getOutputType());
        }
        out.println(":");

        out.increaseIndent();
        if (comment != null) {
            comment.store(out);
        }
        super.store(out);
        out.decreaseIndent();

        out.println();
    }
}
