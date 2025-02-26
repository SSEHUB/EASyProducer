package net.ssehub.easy.instantiation.python.codeArtifacts;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;

/**
 * Represents a Python code block in VTL.
 * 
 * @author Kevin Schaperjahn
 */
public class PythonCodeBlock extends PythonCodeStmt {
    
    private List<IPythonCodeElement> elements = new ArrayList<>();
    private IPythonCodeArtifact artifact;

    public PythonCodeBlock(IPythonCodeElement parent) {
        super(parent);
    }

    public PythonCodeBlock(IPythonCodeArtifact artifact) {
        super(null);
        this.artifact = artifact;
    }

    protected <T extends IPythonCodeElement> T addElt(T elt) {
        return IPythonCodeElement.add(elements, elt);
    }

    protected <T extends IPythonCodeElement> T addElt(T elt, boolean importToFront) {
        int lastImport = -1;
        if (importToFront && elt instanceof IPythonCodeImport) {
            for (int e = 0; e < elements.size(); e++) {
                IPythonCodeElement tmp = elements.get(e);
                if (tmp instanceof IPythonCodeImport) {
                    lastImport = e;
                }
            }
        }
        T result;
        if (lastImport < 0) {
            if (importToFront) {
                result = IPythonCodeElement.add(elements, elt, 0);
            } else {
                result = IPythonCodeElement.add(elements, elt);
            }
        } else {
            result = IPythonCodeElement.add(elements, elt, lastImport + 1);
        }
        return result;
    }
    
    public void add(String text) {
        elements.add(new PythonCodeText(text, true, true));
    }

    public void addRaw(String text, boolean indent) {
        elements.add(new PythonCodeText(text, indent, true));
    }

    public void addEmptyLine() {
        add("");
    }

    /**
     * Adds a class without comment.
     * 
     * @param name the name of the class
     * @return the class for chaining
     */
    public PythonCodeClass addClass(String name) {
        return addElt(new PythonCodeClass(this, name));
    }

    /**
     * Adds a class with comment.
     * 
     * @param name the name of the class
     * @param comment the comment for the class
     * @return the class for chaining
     */
    public PythonCodeClass addClass(String name, String comment) {
        return addElt(new PythonCodeClass(this, name, comment));
    }

    /**
     * Adds an enum without comment.
     * 
     * @param name the name of the enum
     * @return the enum for chaining
     */
    public PythonCodeEnum addEnum(String name) {
        return addElt(new PythonCodeEnum(this, name));
    }

    /**
     * Adds an enum with comment.
     * 
     * @param name the name of the enum
     * @param comment the comment for the enum
     * @return the enum for chaining
     */
    public PythonCodeEnum addEnum(String name, String comment) {
        return addElt(new PythonCodeEnum(this, name, comment));
    }

    public PythonCodeFunction addFunc(String name) {
        return addElt(new PythonCodeFunction(this, name));
    }

    public PythonCodeFunction addFunc(String name, String comment) {
        return addElt(new PythonCodeFunction(this, name, comment));
    }

    public PythonCodeTypeAlias addTypeAlias(String name, String expr) {
        return addElt(new PythonCodeTypeAlias(this, name, expr));
    }

    @OperationMeta(name = {"addAssign", "addAssignment", "assign"})
    public PythonCodeAssign addAssign(String varName, String expr) {
        return addElt(new PythonCodeAssign(this, varName, expr));
    }

    @OperationMeta(name = {"addAssign", "addAssignment", "assign"})
    public PythonCodeAssign addAssign(String varName, String type, String expr) {
        return addElt(new PythonCodeAssign(this, varName, type, expr));
    }

    public PythonCodeFnCall addCall(String name) {
        return addCall(name, PythonCodeImportScope.NONE);
    }

    /**
     * Adds a call to "super()".
     * 
     * @param name the name of the function
     * @return the function call for chaining
     */
    public PythonCodeFnCall addSuperCall(String name) {
        return addCall("super").addCall(name);
    }

    /**
     * Adds a call to "super().__init__(...)".
     * 
     * @return the function call for chaining
     */
    public PythonCodeFnCall addSuperConstructorCall() {
        return addSuperCall("__init__");
    }

    /**
     * Adds a call to "self.".
     * 
     * @param name the name of the function
     * @return the function for chaining
     */
    public PythonCodeFnCall addSelfCall(String name) {
        return addCall("self." + name);
    }
    
    public PythonCodeFnCall addCall(String name, PythonCodeImportScope scope) {
        return addElt(new PythonCodeFnCall(this, name, scope, true));
    }

    public PythonCodeAlternative addIf(String condition) {
        return addElt(new PythonCodeAlternative(this, condition));
    }

    public PythonCodeMatch addMatch(String expr) {
        return addElt(new PythonCodeMatch(this, expr));
    }

    public PythonCodeWhileLoop addWhile(String condition) {
        return addElt(new PythonCodeWhileLoop(this, condition));
    }

    public PythonCodeForLoop addFor(String element, String array) {
        return addElt(new PythonCodeForLoop(this, element, array));
    }

    public PythonCodeForLoop addFor(String element, String rangeStart, String rangeEnd) {
        return addElt(new PythonCodeForLoop(this, element, rangeStart, rangeEnd));
    }

    public PythonCodeForLoop addFor(String element, String rangeStart, String rangeEnd, String rangeStep) {
        return addElt(new PythonCodeForLoop(this, element, rangeStart, rangeEnd, rangeStep));
    }

    public PythonCodeWith addWith(String expr) {
        return addElt(new PythonCodeWith(this, expr));
    }

    public PythonCodeWith addWith(String expr, String varName) {
        return addElt(new PythonCodeWith(this, expr, varName));
    }

    public PythonCodeTryBlock addTry() {
        return addElt(new PythonCodeTryBlock(this));
    }

    public PythonCodeRaise addRaise(String expression) {
        return addElt(new PythonCodeRaise(this, expression));
    }

    public PythonCodeBlock addComment(String comment) {
        addElt(new PythonCodeDocComment(comment, this));
        return this;
    }

    public PythonCodeBlock addSLComment(String comment) {
        return addSLComment(comment, false);
    }

    public PythonCodeBlock addSLComment(String comment, boolean enclosed) {
        addElt(new PythonCodeSingleLineComment(this, comment, enclosed));
        return this;
    }

    public PythonCodeDelete addDelete(String varName) {
        return addElt(new PythonCodeDelete(this, varName));
    }

    public PythonCodeNonLocal addNonLocal(String varName) {
        return addElt(new PythonCodeNonLocal(this, varName));
    }

    public PythonCodeGlobal addGlobal(String varName) {
        return addElt(new PythonCodeGlobal(this, varName));
    }

    public PythonCodeAssert addAssert(String expr) {
        return addElt(new PythonCodeAssert(this, expr));
    }

    public PythonCodeAssert addAssert(String expr, String msg) {
        return addElt(new PythonCodeAssert(this, expr, msg));
    }

    public void addReturn(String value) {
        add("return " + value);
    }

    /**
     * Adds a "continue" statement.
     */
    public void addContinue() {
        add("continue");
    }

    /**
     * Adds a "break" statement.
     */
    public void addBreak() {
        add("break");
    }

    /**
     * Adds a "pass" statement.
     */
    public void addPass() {
        add("pass");
    }

    /**
     * Adds a "print" function call.
     * 
     * @return the function call
     */
    public PythonCodeFnCall addPrint() {
        return addCall("print");
    }

    public PythonCodeBlock setBlock(PythonCodeBlock block) {
        elements.clear();
        for (IPythonCodeElement e : block.elements) {
            e.setParent(this);
            elements.add(e);
        }
        return this;
    }

    @Override
    public void store(CodeWriter out) {
        IPythonCodeElement last = null;
        for (IPythonCodeElement e : elements) {
            if (e.isClass() && !(last != null && last.isEmptyLine())) {
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
    public int getElementCount() {
        int result = 0;

        for (int e = 0; e < elements.size(); e++) {
            result += elements.get(e).getElementCount();
        }

        return result;
    }

    protected PythonCodeClass getParentClass() {
        PythonCodeClass result = null;
        if (getParent() instanceof PythonCodeClass) {
            result = (PythonCodeClass) getParent();
        } else if (getParent() instanceof PythonCodeBlock) {
            result = ((PythonCodeBlock) getParent()).getParentClass();
        } else {
            IPythonCodeElement iter = PythonCodeClass.getParentCodeClass(this);
            if (null != iter) {
                result = (PythonCodeClass) iter;
            }
        }
        return result;
    }

    @Invisible
    @Override
    public IPythonCodeArtifact getArtifact() {
        if (artifact == null) {
            return getParent().getArtifact();
        }

        return artifact;
    }
}
