/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.instantiation.java.codeArtifacts;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;

/**
 * Represents a code block.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeBlock extends JavaCodeStatement implements JavaCodeBlockInterface {

    private List<IJavaCodeElement> elements = new ArrayList<>();
    private boolean outputWhitespaceBefore;
    private boolean outputLnAfter;
    private boolean isLambdaBlock;
    private boolean isStatic;
    private boolean withBrackets;

    /**
     * Creates a new instance.
     * 
     * @param parent the parent element
     * @param outputWhitespaceBefore whether a whitespace shall be printed before the opening curly bracket
     * @param outputLnAfter whether a newline shall be emitted after the closing curly bracket
     */
    public JavaCodeBlock(IJavaCodeElement parent, boolean outputWhitespaceBefore, boolean outputLnAfter) {
        this(parent, outputWhitespaceBefore, outputLnAfter, false, true, false);
    }

    /**
     * Creates a new instance.
     * 
     * @param parent the parent element
     * @param outputWhitespaceBefore whether a whitespace shall be printed before the opening curly bracket
     * @param outputLnAfter whether a newline shall be emitted after the closing curly bracket
     * @param isStatic shall this be a static initializer block (supersedes {@code outputWhitespaceBefore} 
     *   and {@code withBrackets})
     * @param withBrackets shall brackets be emitted
     */
    public JavaCodeBlock(IJavaCodeElement parent, boolean outputWhitespaceBefore, boolean outputLnAfter, 
        boolean isStatic, boolean withBrackets) {
        this(parent, outputWhitespaceBefore, outputLnAfter, isStatic, withBrackets, false);
    }
    
    /**
     * Creates a new instance.
     * 
     * @param parent the parent element
     * @param outputWhitespaceBefore whether a whitespace shall be printed before the opening curly bracket
     * @param outputLnAfter whether a newline shall be emitted after the closing curly bracket
     * @param isStatic shall this be a static initializer block (supersedes {@code outputWhitespaceBefore} 
     *   and {@code withBrackets})
     * @param withBrackets shall brackets be emitted
     * @param isLambdaBlock whether special formattings for a lambda block shall be applied
     */
    public JavaCodeBlock(IJavaCodeElement parent, boolean outputWhitespaceBefore, boolean outputLnAfter, 
        boolean isStatic, boolean withBrackets, boolean isLambdaBlock) {
        super(parent);
        this.outputWhitespaceBefore = isStatic ? true : outputWhitespaceBefore;
        this.outputLnAfter = outputLnAfter;
        this.isStatic = isStatic;
        this.withBrackets = isStatic ? true : withBrackets;
        this.isLambdaBlock = isLambdaBlock;
    }

    /**
     * VIL constructor for unlinked code blocks with default settings.
     * 
     * @return the code block
     */
    public static JavaCodeBlock create() {
        return create(false, false, false, true);
    }
    
    /**
     * VIL constructor for unlinked code blocks.
     * 
     * @param outputWhitespaceBefore whether a whitespace shall be printed before the opening curly bracket
     * @param outputLnAfter whether a newline shall be emitted after the closing curly bracket
     * @param isStatic shall this be a static initializer block (supersedes {@code outputWhitespaceBefore} 
     *   and {@code withBrackets})
     * @param withBrackets shall brackets be emitted
     * @return the code block
     */
    public static JavaCodeBlock create(boolean outputWhitespaceBefore, boolean outputLnAfter, 
        boolean isStatic, boolean withBrackets) {
        return new JavaCodeBlock(new DummyJavaCodeElement(), outputWhitespaceBefore, outputLnAfter, isStatic, 
            withBrackets);
    }
    
    /**
     * Returns the parent class.
     * 
     * @return the parent class
     */
    protected JavaCodeClass getParentClass() {
        JavaCodeClass result = null;
        if (getParent() instanceof JavaCodeClass) {
            result = (JavaCodeClass) getParent();
        } else if (getParent() instanceof JavaCodeBlock) {
            result = ((JavaCodeBlock) getParent()).getParentClass();
        } else {
            IJavaCodeElement iter = JavaCodeClass.getParentCodeClass(this);
            if (null != iter) {
                result = (JavaCodeClass) iter;
            }
        }
        return result;
    }

    /**
     * Adds an element.
     * 
     * @param <E> the type of the element
     * @param element the element
     * @return {@code element}
     */
    protected <E extends IJavaCodeElement> E addElement(E element) {
        elements.add(element);
        return element;
    }

    /**
     * Adds an element.
     * 
     * @param <E> the type of the element
     * @param element the element
     * @param position the insert position
     * @return {@code element}
     */
    protected <E extends IJavaCodeElement> E add(E element, int position) {
        elements.add(position, element);
        return element;
    }
    
    /**
     * Returns the elements as stream.
     * 
     * @return the elements
     */
    protected Stream<IJavaCodeElement> elementsStream() {
        return elements.stream();
    }
    
    /**
     * Returns the number of elements.
     * 
     * @return the number of elements
     */
    protected int getElementsSize() {
        return elements.size();
    }

    @Override
    public JavaCodeBlock add(String text) {
        return add(text, false);
    }
    
    @Override
    public JavaCodeBlock addAsStatement(String text) {
        return add(text, true);
    }
    
    private JavaCodeBlock add(String text, boolean asStatement) {
        if (text != null && text.length() > 0) {
            if (asStatement && !text.endsWith(";")) {
                text = text + ";";
            }
            elements.add(new JavaCodeText(text, true, true));
        }
        return this;
    }
    
    @Override
    public JavaCodeBlock add(JavaCodeStatement stmt) {
        if (!stmt.isEmpty()) {
            elements.add(stmt);
        }
        return this;
    }

    @Override
    public JavaCodeBlock addRaw(String text) {
        if (text != null && text.length() > 0) {
            elements.add(new JavaCodeText(text, false, true));
        }
        return this;
    }
    
    @Override
    @OperationMeta(name = {"addDoLoop", "do"})
    public JavaCodeDoLoop addDoLoop(String condition) {
        return IJavaCodeElement.add(elements, new JavaCodeDoLoop(this, condition));
    }

    @Override
    @OperationMeta(name = {"addWhileLoop", "while"})
    public JavaCodeWhileLoop addWhileLoop(String condition) {
        return IJavaCodeElement.add(elements, new JavaCodeWhileLoop(this, condition));
    }

    @Override
    @OperationMeta(name = {"addForLoop", "for"})
    public JavaCodeForLoop addForLoop(String type, String variableName, String expression) {
        return addForLoop(new JavaCodeTypeSpecification(type, getParentClass()), variableName, expression);
    }
    
    //@Override
    //@OperationMeta(name = {"addForLoop", "for"})
    JavaCodeForLoop addForLoop(JavaCodeTypeSpecification type, String variableName, String expression) {
        return IJavaCodeElement.add(elements, new JavaCodeForLoop(this, type, variableName, expression));
    }

    @Override
    @OperationMeta(name = {"addForLoop", "for"})
    public JavaCodeForLoop addForLoop(String type, String variableName, String initializer, 
        String condition, String update) {
        return addForLoop(new JavaCodeTypeSpecification(type, getParentClass()), variableName, initializer, 
            condition, update);
    }

    //@Override
    //@OperationMeta(name = {"addForLoop", "for"})
    JavaCodeForLoop addForLoop(JavaCodeTypeSpecification type, String variableName, String initializer, 
        String condition, String update) {
        return IJavaCodeElement.add(elements, new JavaCodeForLoop(this, type, variableName, initializer, 
            condition, update));
    }
    
    @Override
    @OperationMeta(name = {"addIf", "if"})
    public JavaCodeAlternative addIf(String condition) {
        return IJavaCodeElement.add(elements, new JavaCodeAlternative(this, condition));
    }

    @Override
    @OperationMeta(name = {"addThrow", "throw"})
    public JavaCodeThrow addThrow(String expression) {
        return IJavaCodeElement.add(elements, new JavaCodeThrow(this, expression));
    }

    @Override
    @OperationMeta(name = {"addSwitch", "switch"})
    public JavaCodeSwitch addSwitch(JavaCodeExpression expression) {
        return IJavaCodeElement.add(elements, new JavaCodeSwitch(this, expression));
    }

    @Override
    @OperationMeta(name = {"addSynchronized", "synchronized"})
    public JavaCodeSynchronizedBlock addSynchronized() {
        return IJavaCodeElement.add(elements, new JavaCodeSynchronizedBlock(this));
    }

    @Override
    @OperationMeta(name = {"addTry", "try"})
    public JavaCodeTryBlock addTry() {
        return IJavaCodeElement.add(elements, new JavaCodeTryBlock(this));
    }

    @Override
    public JavaCodeExpressionStatement addPostfixIncrement(String variable) {
        return addPostfix(variable, true);
    }

    @Override
    public JavaCodeExpressionStatement addPostfixDecrement(String variable) {
        return addPostfix(variable, false);
    }

    private JavaCodeExpressionStatement addPostfix(String variable, boolean increment) {
        return IJavaCodeElement.add(elements, 
            JavaCodeExpressionStatement.createPostfixStatement(this, variable, increment));
    }

    @Override
    @OperationMeta(name = {"addAssignment", "addAssign", "assign"})
    public JavaCodeAssignment addAssignment(String variable) {
        return addAssignment(variable, "=", null);
    }
    
    @Override
    @OperationMeta(name = {"addAssignment", "addAssign", "assign"})
    public JavaCodeAssignment addAssignment(String variable, JavaCodeExpression expression) {
        return addAssignment(variable, "=", expression);
    }

    @Override
    @OperationMeta(name = {"addAssignment", "addAssign", "assign"})
    public JavaCodeAssignment addAssignment(String variable, String operator, JavaCodeExpression expression) {
        return IJavaCodeElement.add(elements, new JavaCodeAssignment(this, variable, operator, expression));
    }

    @Override
    @OperationMeta(name = {"addEmptyLine", "emptyLine"})
    public JavaCodeBlock addEmptyLine() {
        IJavaCodeElement.add(elements, new JavaCodeEmptyLine(this));
        return this;
    }

    @Override
    @OperationMeta(name = {"addSLComment", "SLComment"})
    public JavaCodeBlock addSLComment(String text) {
        IJavaCodeElement.add(elements, new JavaCodeSingleLineComment(this, text));
        return this;
    }

    @Override
    @OperationMeta(name = {"addSuperCall", "super"})
    public JavaCodeMethodCall addSuperCall() {
        return addCall("super");
    }

    @Override
    @OperationMeta(name = {"addThisCall", "this"})
    public JavaCodeMethodCall addThisCall() {
        return addCall("this");
    }

    @Override
    @OperationMeta(name = {"addSystemOutPrintlnCall", "SystemOutPrintln", "sysoutprintln"})
    public JavaCodeMethodCall addSystemOutPrintlnCall() {
        return addCall("System.out.println");
    }

    /**
     * Adds a JUnit assert call (as static, non-imported method).
     * 
     * @param methodName the assert method to call
     * @return the method call
     */
    public JavaCodeMethodCall addJunitAssertCall(String methodName) {
        return addCall("org.junit.Assert." + methodName, JavaCodeImportScope.CLASS);        
    }    
    
    @Override
    @OperationMeta(name = {"addCall", "call"})
    public JavaCodeMethodCall addCall(String methodName) {
        return addCall(methodName, JavaCodeImportScope.NONE);
    }

    @Override
    @OperationMeta(name = {"addCall", "call"})
    public JavaCodeMethodCall addCall(String methodName, JavaCodeImportScope scope) {
        return IJavaCodeElement.add(elements, new JavaCodeMethodCall(this, methodName, scope, true,
            ";" + System.lineSeparator()));
    }
    
    @OperationMeta(name = "callQualified")
    public JavaCodeMethodCall addCallQualified(String methodName) {
        return addCall(methodName, JavaCodeImportScope.METHOD_CLASS_IMPORT);
    }

    @Override
    @OperationMeta(name = {"addVariable", "var"})
    public JavaCodeVariableDeclaration addVariable(String type, String variableName, 
        JavaCodeExpression initializer) {
        return addVariable(type, variableName, false, initializer);
    }

    //@Override
    //@OperationMeta(name = {"addVariable", "var"})
    JavaCodeVariableDeclaration addVariable(JavaCodeTypeSpecification type, String variableName, 
        JavaCodeExpression initializer) {
        return addVariable(type, variableName, false, initializer);
    }

    @Override
    @OperationMeta(name = {"addVariable", "var"})
    public JavaCodeVariableDeclaration addVariable(String type, String variableName, 
        boolean isFinal, JavaCodeExpression initializer) {
        return IJavaCodeElement.add(elements, createVariable(type, variableName, isFinal, initializer));
    }

    //@Override
    //@OperationMeta(name = {"addVariable", "var"})
    JavaCodeVariableDeclaration addVariable(JavaCodeTypeSpecification type, String variableName, 
        boolean isFinal, JavaCodeExpression initializer) {
        return IJavaCodeElement.add(elements, new JavaCodeVariableDeclaration(this, type, variableName, 
            isFinal, initializer));
    }

    @Override
    public JavaCodeVariableDeclaration createVariable(String type, String variableName, 
        JavaCodeExpression initializer) {
        return createVariable(type, variableName, false, initializer);
    }

    @Override
    public JavaCodeVariableDeclaration createVariable(String type, String variableName, 
        boolean isFinal, JavaCodeExpression initializer) {
        JavaCodeTypeSpecification t = null == type || type.length() == 0 
            ? null : new JavaCodeTypeSpecification(type, getParentClass());
        return new JavaCodeVariableDeclaration(this, t, variableName, isFinal, initializer);
    }
    
    /**
     * Adds a return statement without Javadoc comment.
     * 
     * @param valueEx the return value
     * @return the return statement
     */
    @OperationMeta(name = {"addReturn", "return"})
    public JavaCodeBlock addReturn(JavaCodeExpression valueEx) {
        IJavaCodeElement.add(elements, new JavaCodeReturn(this, valueEx));
        return this;
    }
    
    /**
     * Adds a nested block.
     * 
     * @param outputWhitespaceBefore whether a whitespace shall be printed before the opening curly bracket
     * @param outputLnAfter whether a newline shall be emitted after the closing curly bracket
     * @param isStatic shall this be a static initializer block (supersedes {@code outputWhitespaceBefore} 
     *   and {@code withBrackets})
     * @param withBrackets shall brackets be emitted
     * @return the code block
     */
    public JavaCodeBlock addBlock(boolean outputWhitespaceBefore, boolean outputLnAfter, 
        boolean isStatic, boolean withBrackets) {
        return IJavaCodeElement.add(elements, new JavaCodeBlock(this, outputWhitespaceBefore, outputLnAfter, 
            isStatic, withBrackets));
    }
    
    /**
     * Adds a nested block.
     * 
     * @param block the added block
     * @return {@code block} for chaining
     */
    public JavaCodeBlock addBlock(JavaCodeBlock block) {
        return IJavaCodeElement.add(elements, block);
    }
    
    @Invisible
    @Override
    public void transferElementsTo(JavaCodeBlockInterface block) {
        if (block != this) { // prevent accidental endless look, stack overflow
            for (IJavaCodeElement e : elements) {
                block.add(e);
                e.setParent(block);
            }
            elements.clear();
        }
    }
    
    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        super.setParent(parent);
        elements.forEach(e -> e.setParent(this));
    }

    @Invisible
    @Override
    public void add(IJavaCodeElement element) {
        elements.add(element);
    }

    @Override
    public JavaCodeBlock addAll(JavaCodeBlockInterface block) {
        block.transferElementsTo(this);
        return this;
    }

    /**
     * Replaces all elements in this block by those from {@code block}. This allows for separating creation of 
     * {@link JavaCodeBlock} and contained code as well as for delayed decision how to handle collected code. 
     * Does not take over formatting settings from {@code block}.
     * 
     * @param block the block containing the statements
     * @return <b>this</b> for chaining
     */
    public JavaCodeBlock setBlock(JavaCodeBlock block) {
        elements.clear();
        for (IJavaCodeElement e : block.elements) {
            e.setParent(this);
            elements.add(e);
        }
        return this;
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        if (withBrackets) {
            if (isStatic) {
                out.print("static");
            }
            if (outputWhitespaceBefore) {
                out.print(" ");
            }
            out.print("{");
            if (!isLambdaBlock) { // defer this
                out.println();    
            }
        } else {
            if (outputWhitespaceBefore) {
                out.print(" ");
            }
        }
        if (elements.size() > 0) {
            if (isLambdaBlock) {
                out.println();
            }
            out.increaseIndent();
            for (IJavaCodeElement attr: elements) {
                attr.store(out);
            }
            storeBeforeBlockEnd(out);
            out.decreaseIndent();
        }
        if (withBrackets) {
            if (isLambdaBlock && elements.size() == 0) {
                out.print("}");
            } else {
                out.printwi("}");
            }
            if (outputLnAfter) {
                out.println();
            }
        }
    }
    
    protected void storeBeforeBlockEnd(CodeWriter out) {
    }

    @Override
    public int getElementCount() {
        int result = withBrackets ? 2 : 0;
        for (IJavaCodeElement a : elements) {
            result += a.getElementCount();
        }
        return result;
    }    

    /**
     * Returns whether the element is static.
     * 
     * @return {@code true} for static, {@code false} for instance
     */
    public boolean isStatic() {
        return isStatic;
    }
    
    /**
     * Sets this element's static state.
     * 
     * @param isStatic if the element is static
     * @return <b>this</b>
     */
    public JavaCodeBlock setStatic(boolean isStatic) {
        this.isStatic = isStatic;
        return this;
    }

    /**
     * Sets this element to static.
     * 
     * @return <b>this</b>
     */
    public JavaCodeBlock setStatic() {
        return setStatic(true);
    }

    @Override
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    
    @Override
    public JavaCodeBlock replaceVariable(String oldName, String newName) {
        elements.forEach(e -> e.replaceVariable(oldName, newName));
        return this;
    }

    @Override
    public JavaCodeBlock replaceMethod(String oldName, String newName) {
        elements.forEach(e -> replaceMethod(oldName, newName));
        return this;
    }
    
    /**
     * Returns whether {@code elt} is contained in this block.
     * 
     * @param elt the element to search for
     * @return {@code true} for contained, {@code false} else
     */
    protected boolean contains(IJavaCodeElement elt) {
        return elements.contains(elt);
    }
    
    protected boolean withBrackets() {
        return withBrackets;
    }
    
}
