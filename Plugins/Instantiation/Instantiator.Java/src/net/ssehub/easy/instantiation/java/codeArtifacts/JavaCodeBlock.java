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

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a code block.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeBlock extends JavaCodeStatement {

    private List<IJavaCodeElement> elements = new ArrayList<>();
    private boolean outputWhitespaceBefore;
    private boolean outputLnAfter;
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
        this(parent, outputWhitespaceBefore, outputLnAfter, false, true);
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
        super(parent);
        this.outputWhitespaceBefore = isStatic ? true : outputWhitespaceBefore;
        this.outputLnAfter = outputLnAfter;
        this.isStatic = isStatic;
        this.withBrackets = isStatic ? true : withBrackets;
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
    protected <E extends IJavaCodeElement> E add(E element) {
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

    /**
     * Adds text and indents it.
     * 
     * @param text the text
     */
    public void add(String text) {
        elements.add(new JavaCodeText(text, true, true));
    }

    /**
     * Adds text without indentation/pre-indended.
     * 
     * @param text the text
     */
    public void addRaw(String text) {
        elements.add(new JavaCodeText(text, false, true));
    }
    
    /**
     * Adds a do-loop block.
     * 
     * @param condition the loop condition
     * @return the loop block
     */
    public JavaCodeDoLoop addDoLoop(String condition) {
        return IJavaCodeElement.add(elements, new JavaCodeDoLoop(this, condition));
    }

    /**
     * Adds a do-loop block.
     * 
     * @param condition the loop condition
     * @return the loop block
     */
    public JavaCodeWhileLoop addWhileLoop(String condition) {
        return IJavaCodeElement.add(elements, new JavaCodeWhileLoop(this, condition));
    }

    /**
     * Creates an interable-based for-loop.
     * 
     * @param type the type of the iterator variable
     * @param variableName the name of the iterator variable
     * @param expression the expression determining the iterable to loop over
     * @return the for loop block
     */
    public JavaCodeForLoop addForLoop(String type, String variableName, String expression) {
        return addForLoop(new JavaCodeTypeSpecification(type, getParentClass()), variableName, expression);
    }
    
    /**
     * Creates an interable-based for-loop.
     * 
     * @param type the type of the iterator variable
     * @param variableName the name of the iterator variable
     * @param expression the expression determining the iterable to loop over
     * @return the for loop block
     */
    public JavaCodeForLoop addForLoop(JavaCodeTypeSpecification type, String variableName, String expression) {
        return IJavaCodeElement.add(elements, new JavaCodeForLoop(this, type, variableName, expression));
    }

    /**
     * Creates a traditional for-loop.
     * 
     * @param type the type of the iterator variable
     * @param variableName the name of the iterator variable (optional, may be <b>null</b> or empty)
     * @param initializer the iterator variable initializer
     * @param condition the loop condition (optional, may be <b>null</b> or empty)
     * @param update the iterator variable update, e.g., increment, decrement (may be <b>null</b> or empty)
     * @return the for loop block
     */
    public JavaCodeForLoop addForLoop(String type, String variableName, String initializer, 
        String condition, String update) {
        return addForLoop(new JavaCodeTypeSpecification(type, getParentClass()), variableName, initializer, 
            condition, update);
    }

    /**
     * Creates a traditional for-loop.
     * 
     * @param type the type of the iterator variable
     * @param variableName the name of the iterator variable (optional, may be <b>null</b> or empty)
     * @param initializer the iterator variable initializer
     * @param condition the loop condition (optional, may be <b>null</b> or empty)
     * @param update the iterator variable update, e.g., increment, decrement (may be <b>null</b> or empty)
     * @return the for loop block
     */
    public JavaCodeForLoop addForLoop(JavaCodeTypeSpecification type, String variableName, String initializer, 
        String condition, String update) {
        return IJavaCodeElement.add(elements, new JavaCodeForLoop(this, type, variableName, initializer, 
            condition, update));
    }
    
    /**
     * Adds a if-then-else block.
     * 
     * @param condition the loop condition
     * @return the if-then-else block
     */
    public JavaCodeAlternative addIf(String condition) {
        return IJavaCodeElement.add(elements, new JavaCodeAlternative(this, condition));
    }

    /**
     * Adds a throw statement.
     * 
     * @param expression the expression to throw
     * @return throw statement
     */
    public JavaCodeThrow addThrow(String expression) {
        return IJavaCodeElement.add(elements, new JavaCodeThrow(this, expression));
    }

    /**
     * Adds a switch block.
     * 
     * @param expression the switch expression
     * @return the switch block
     */
    public JavaCodeSwitch addSwitch(String expression) {
        return IJavaCodeElement.add(elements, new JavaCodeSwitch(this, expression));
    }

    /**
     * Adds a synchronized block.
     * 
     * @return the synchronized block
     */
    public JavaCodeSynchronizedBlock addSynchronized() {
        return IJavaCodeElement.add(elements, new JavaCodeSynchronizedBlock(this));
    }

    /**
     * Adds a synchronized block.
     * 
     * @return the synchronized block
     */
    public JavaCodeTryBlock addTry() {
        return IJavaCodeElement.add(elements, new JavaCodeTryBlock(this));
    }

    /**
     * Adds an assignment.
     * 
     * @param variable the variable to change
     * @param expression the expression determining the value
     * @return the assignment
     */
    public JavaCodeAssignment addAssignment(String variable, String expression) {
        return IJavaCodeElement.add(elements, new JavaCodeAssignment(this, variable, expression));
    }

    /**
     * Adds an empty line.
     * 
     * @return <b>this</b>
     */
    public JavaCodeBlock addEmptyLine() {
        IJavaCodeElement.add(elements, new JavaCodeEmptyLine(this));
        return this;
    }

    /**
     * Adds a single-line comment.
     * 
     * @param text the comment text
     * @return <b>this</b>
     */
    public JavaCodeBlock addSLComment(String text) {
        IJavaCodeElement.add(elements, new JavaCodeSingleLineComment(this, text));
        return this;
    }

    /**
     * Adds a constructor super call.
     * 
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addSuperCall() {
        return addCall("super");
    }

    /**
     * Adds a constructor this call.
     * 
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addThisCall() {
        return addCall("this");
    }
    
    /**
     * Adds a non-static method call.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addCall(String methodName) {
        return addCall(methodName, JavaCodeImportScope.NONE);
    }

    /**
     * Adds a method call.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param scope the import scope
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addCall(String methodName, JavaCodeImportScope scope) {
        return IJavaCodeElement.add(elements, new JavaCodeMethodCall(this, methodName, scope, true,
            ";" + System.lineSeparator()));
    }

    /**
     * Creates a variable declaration.
     * 
     * @param type the type of the variable, may be <b>null</b> for auto-inference
     * @param variableName the variable name
     * @param initializer the initializer, may be <b>null</b> for none
     * @return the variable declaration (for chaining)
     */
    public JavaCodeVariableDeclaration addVariable(String type, String variableName, 
        String initializer) {
        return addVariable(type, variableName, false, initializer);
    }

    /**
     * Creates a variable declaration.
     * 
     * @param type the type of the variable, may be <b>null</b> for auto-inference
     * @param variableName the variable name
     * @param initializer the initializer, may be <b>null</b> for none
     * @return the variable declaration (for chaining)
     */
    public JavaCodeVariableDeclaration addVariable(JavaCodeTypeSpecification type, String variableName, 
        String initializer) {
        return addVariable(type, variableName, false, initializer);
    }

    /**
     * Creates a variable declaration.
     * 
     * @param type the type of the variable, may be <b>null</b> for auto-inference
     * @param variableName the variable name
     * @param isFinal whether the variable shall be final
     * @param initializer the initializer, may be <b>null</b> for none
     * @return the variable declaration (for chaining)
     */
    public JavaCodeVariableDeclaration addVariable(String type, String variableName, 
        boolean isFinal, String initializer) {
        return addVariable(null == type ? null : new JavaCodeTypeSpecification(type, getParentClass()), variableName, 
            isFinal, initializer);
    }

    /**
     * Creates a variable declaration.
     * 
     * @param type the type of the variable, may be <b>null</b> for auto-inference
     * @param variableName the variable name
     * @param isFinal whether the variable shall be final
     * @param initializer the initializer, may be <b>null</b> for none
     * @return the variable declaration (for chaining)
     */
    public JavaCodeVariableDeclaration addVariable(JavaCodeTypeSpecification type, String variableName, 
        boolean isFinal, String initializer) {
        return IJavaCodeElement.add(elements, new JavaCodeVariableDeclaration(this, type, variableName, 
            isFinal, initializer));
    }

    /**
     * Adds a return statement without javadoc comment.
     * 
     * @param value the return value
     */
    public void addReturn(String value) {
        add("return " + value + ";"); // preliminary, may also become a class
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
            out.println("{");
        } else {
            if (outputWhitespaceBefore) {
                out.print(" ");
            }
        }
        out.increaseIndent();
        for (IJavaCodeElement attr: elements) {
            attr.store(out);
        }
        out.decreaseIndent();
        if (withBrackets) {
            out.printwi("}");
            if (outputLnAfter) {
                out.println();
            }
        }
    }

    @Override
    public int getElementCount() {
        int result = withBrackets ? 2 : 0;
        for (IJavaCodeElement a : elements) {
            result += a.getElementCount();
        }
        return result;
    }    
    
}
