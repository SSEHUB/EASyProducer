package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.util.ArrayList;

import java.util.List;
import java.util.function.Consumer;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.PseudoString;

/**
 * Represents a Python "class" in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeClass extends PythonCodeElement {
    
    private String name;
    private List<IPythonCodeElement> elements = new ArrayList<>();
    private List<PythonCodeTypeSpec> bases = new ArrayList<>();
    private PythonCodeDocComment comment;

    /**
     * Creates a class.
     * 
     * @param parent the parent code element
     * @param name the class name
     */
    PythonCodeClass(IPythonCodeElement parent, String name) {
        super(parent);
        this.name = name;
        PythonCodeTypeSpec.create(name, this);
    }

    /**
     * Creates a class with comment.
     * 
     * @param parent the parent code element
     * @param name the class name
     * @param comment the comment
     */
    PythonCodeClass(IPythonCodeElement parent, String name, String comment) {
        super(parent);
        this.name = name;
        this.comment = new PythonCodeDocComment(comment, this);
        PythonCodeTypeSpec.create(name, this);
    }
    
    /**
     * Returns the class name.
     * 
     * @return the class name
     */
    public String getName() {
        return name;
    }

    public PythonCodeClass add(String text) {
        IPythonCodeElement.add(elements, new PythonCodeText(text, true, true));
        return this;
    }

    public PythonCodeClass addEmptyLine() {
        return add("");
    }

    public PythonCodeClass addClass(String name) {
        return add(new PythonCodeClass(this, name));
    }

    public PythonCodeAssign addAttribute(String name, String initExpr) {
        return add(new PythonCodeAssign(this, name, initExpr));
    }

    public PythonCodeAssign addAttribute(String name, String type, String initExpr) {
        return add(new PythonCodeAssign(this, name, type, initExpr));
    }
    
    protected <T extends IPythonCodeElement> T add(T element) {
        return IPythonCodeElement.add(elements, element);
    }
    
    public PythonCodeClass addBase(String type) {
        return addBase(type, PythonCodeImportScope.MODULE);
    }

    public PythonCodeClass addBase(String type, PythonCodeImportScope scope) {
        if (type != null && type.length() > 0) {
            bases.add(PythonCodeTypeSpec.create(type, this, scope));
        }
        return this;
    }

    @OperationMeta(name = {"addMethod", "addFunc"})
    public PythonCodeFunction addMethod(String name) {
        PythonCodeFunction func = add(new PythonCodeFunction(this, name));
        func.addParameter("self");
        return func;
    }
    
    @OperationMeta(name = {"addMethod", "addFunc"})
    public PythonCodeFunction addMethod(String name, String comment) {
        PythonCodeFunction func = add(new PythonCodeFunction(this, name, comment));
        func.addParameter("self");
        return func;
    }

    public PythonCodeFunction addGetter(String varName) {
        String funcName = "get" + PseudoString.firstToUpperCase(varName);
        String funcComment = "Returns the value of " + varName + ".";

        PythonCodeFunction func = add(new PythonCodeFunction(this, funcName, funcComment));
        func.addParameter("self");
        func.addReturn("self." + varName, "return value of " + varName);
        return func;
    }

    public PythonCodeFunction addGetter(String varName, String type) {
        String funcName = "get" + PseudoString.firstToUpperCase(varName);
        String funcComment = "Returns the value of " + varName + ".";

        PythonCodeFunction func = add(new PythonCodeFunction(this, funcName, funcComment));
        func.addParameter("self");
        func.addReturn("self." + varName, "return value of " + varName);
        func.addRetType(type);
        return func;
    }

    public PythonCodeFunction addSetter(String varName) {
        String funcName = "set" + PseudoString.firstToUpperCase(varName);
        String funcComment = "Sets the value of " + varName + ".";

        PythonCodeFunction func = add(new PythonCodeFunction(this, funcName, funcComment));
        func.addParameter("self");
        func.addParameter(varName, "", "the new value");
        func.addAssign("self." + varName, varName);
        return func;
    }

    public PythonCodeFunction addSetter(String varName, String type) {
        String funcName = "set" + PseudoString.firstToUpperCase(varName);
        String funcComment = "Sets the value of " + varName + ".";

        PythonCodeFunction func = add(new PythonCodeFunction(this, funcName, funcComment));
        func.addParameter("self");
        func.addParameter(varName, type, "the new value");
        func.addAssign("self." + varName, varName);
        return func;
    }

    public PythonCodeFunction addConstructor() {
        return addConstructor(null);
    }

    public PythonCodeFunction addConstructor(String comment) {
        PythonCodeFunction func = add(new PythonCodeFunction(this, "__init__", comment));
        func.addParameter("self");
        return func;
    }

    public PythonCodeClass addComment(String comment) {
        add(new PythonCodeDocComment(comment, this));
        return this;
    }

    public PythonCodeClass addSLComment(String comment) {
        return addSLComment(comment, false);
    }

    public PythonCodeClass addSLComment(String comment, boolean enclosed) {
        add(new PythonCodeSingleLineComment(this, comment, enclosed));
        return this;
    }

    static void setParent(IPythonCodeElement parent, Consumer<PythonCodeClass> consumer) {
        IPythonCodeElement.setParent(parent, PythonCodeClass.class, consumer);
    }

    static PythonCodeClass getParentCodeClass(IPythonCodeElement element) {
        if (element == null) {
            return null;
        }

        IPythonCodeElement iter = element.getParent();
        while (iter != null && !(iter instanceof PythonCodeClass)) {
            iter = iter.getParent();
        }
        return iter instanceof PythonCodeClass ? (PythonCodeClass) iter : null;
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        out.printwi("class " + name);
        if (!bases.isEmpty()) {
            IPythonCodeElement.storeList("(", bases, ", ", out);
            out.print(")");
        }
        out.println(":");

        out.increaseIndent();
        if (comment != null) {
            comment.store(out);
            out.println();
        }
        storeElements(out);
        out.decreaseIndent();

        out.println();
    }

    @Invisible
    public void storeElements(CodeWriter out) {
        IPythonCodeElement last = null;
        for (IPythonCodeElement e : elements) {
            if (last != null && (last.isAttribute() && !e.isAttribute())) {
                out.println();
            }
            e.store(out);
            last = e;
        }

        if (elements.isEmpty()) {
            out.printlnwi("pass");
        }
    }
    
    @Override
    public boolean isClass() {
        return true;
    }
    
}
