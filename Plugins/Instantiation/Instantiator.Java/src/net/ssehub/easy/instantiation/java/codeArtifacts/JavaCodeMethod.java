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

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeClass.Kind;

/**
 * Represents a Java code method.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeMethod extends JavaCodeAbstractVisibleElement {

    private JavaCodeTypeSpecification type;
    private JavaCodeClass enclosing;
    //private List<IJavaCodeElement> elements = new ArrayList<>();
    private JavaCodeBlock block;
    private List<JavaCodeParameterSpecification> parameter;
    private List<JavaCodeTypeSpecification> exceptions;

    /**
     * Creates a void method without comment.
     * 
     * @param name the name of the method
     * @param enclosing the enclosing class
     */
    protected JavaCodeMethod(String name, JavaCodeClass enclosing) {
        this(JavaCodeTypeSpecification.VOID, name, enclosing);
    }

    /**
     * Creates a method without comment.
     * 
     * @param type the return type
     * @param name the name of the method
     * @param enclosing the enclosing class
     */
    protected JavaCodeMethod(JavaCodeTypeSpecification type, String name, JavaCodeClass enclosing) {
        this(type, name, enclosing, null);
    }

    /**
     * Creates a method.
     * 
     * @param type the return type
     * @param name the name of the method
     * @param enclosing the enclosing class
     * @param comment the method comment, substring after {@code &commat;return} is considered as return comment
     */
    protected JavaCodeMethod(JavaCodeTypeSpecification type, String name, JavaCodeClass enclosing, String comment) {
        super(name, JavaCodeVisibility.PUBLIC, comment);
        this.enclosing = enclosing;
        this.type = type;
        this.block = new JavaCodeBlock(this, true, true);
    }

    @Invisible
    public IJavaCodeArtifact getArtifact() {
        return enclosing.getArtifact();
    }
    
    @Invisible
    public JavaCodeClass getEnclosing() {
        return enclosing;
    }

    /**
     * Adds an override annotation.
     * 
     * @return the annotation for further processing
     */
    public JavaCodeAnnotation addOverrideAnnotation() {
        return addAnnotation("Override");
    }

    /**
     * Adds a (formal) method parameter.
     * 
     * @param type the type of the parameter
     * @param name the name of the parameter
     * @return the parameter instance
     */
    public JavaCodeParameterSpecification addParameter(String type, String name) {
        return addParameter(type, name, null);
    }

    /**
     * Adds a (formal) method parameter.
     * 
     * @param type the type of the parameter
     * @param name the name of the parameter
     * @param comment the Javadoc comment to be linked to this parameter (just the text), may be <b>null</b> for none
     * @return the parameter instance
     */
    public JavaCodeParameterSpecification addParameter(String type, String name, String comment) {
        if (null == parameter) {
            parameter = new ArrayList<>();
        }
        if (null != comment && getJavadocComment() != null) {
            getJavadocComment().addParameterComment(name, comment);
        }
        return IJavaCodeElement.add(parameter, new JavaCodeParameterSpecification(type, name, this));
    }

    /**
     * Adds a (formal) method parameter.
     * 
     * @param type the type of the parameter
     * @param name the name of the parameter
     * @param comment the Javadoc comment to be linked to this parameter (just the text), may be <b>null</b> for none
     * @return the parameter instance
     */
    public JavaCodeParameterSpecification addParameter(JavaCodeTypeSpecification type, String name, String comment) {
        if (null == parameter) {
            parameter = new ArrayList<>();
        }
        if (null != comment && getJavadocComment() != null) {
            getJavadocComment().addParameterComment(name, comment);
        }
        return IJavaCodeElement.add(parameter, new JavaCodeParameterSpecification(type, name, this));
    }

    /**
     * Adds an exception without (Javadoc) comment.
     * 
     * @param type the exception type
     * @return the type specification of the exception
     */
    public JavaCodeTypeSpecification addException(String type) {
        return addException(type, null);
    }

    /**
     * Adds an exception with comment.
     * 
     * @param type the exception type
     * @param comment Javadoc description of the exception
     * @return the type specification of the exception
     */
    public JavaCodeTypeSpecification addException(String type, String comment) {
        if (null == exceptions) {
            exceptions = new ArrayList<>();
        }
        JavaCodeTypeSpecification typeSpec = new JavaCodeTypeSpecification(type, getEnclosing());
        if (null != comment && getJavadocComment() != null) {
            getJavadocComment().addExceptionComment(typeSpec.getOutputTypeName(), comment);
        }
        return IJavaCodeElement.add(exceptions, typeSpec);
    }

    /**
     * Adds text and indents it.
     * 
     * @param text the text
     */
    public void add(String text) {
        block.add(text);
    }
    
    /**
     * Adds text without indentation/pre-indended.
     * 
     * @param text the text
     */
    public void addRaw(String text) {
        block.addRaw(text);
    }
    
    /**
     * Adds a return statement without javadoc comment.
     * 
     * @param value the return value
     * @return <b>this</b> for chaining
     */
    public JavaCodeMethod addReturn(String value) {
        return addReturn(value, null);
    }
    
    /**
     * Adds a do-loop block.
     * 
     * @param condition the loop condition
     * @return the loop block
     */
    public JavaCodeDoLoop addDoLoop(String condition) {
        return block.addDoLoop(condition);
    }

    /**
     * Adds a do-loop block.
     * 
     * @param condition the loop condition
     * @return the loop block
     */
    public JavaCodeWhileLoop addWhileLoop(String condition) {
        return block.addWhileLoop(condition);
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
        return block.addForLoop(type, variableName, expression);
    }
    
    /**
     * Creates an interable-based for-loop.
     * 
     * @param type the type of the iterator variable
     * @param variableName the name of the iterator variable
     * @param expression the expression determining the iterable to loop over
     * @return the for loop block
     */
    public JavaCodeForLoop addForLoop(JavaCodeTypeSpecification type, String variableName, 
        String expression) {
        return block.addForLoop(type, variableName, expression);
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
        return block.addForLoop(type, variableName, initializer, condition, update);
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
    public JavaCodeForLoop addForLoop(JavaCodeTypeSpecification type, String variableName, 
        String initializer, String condition, String update) {
        return block.addForLoop(type, variableName, initializer, condition, update);
    }
    
    /**
     * Adds a if-then-else block.
     * 
     * @param condition the loop condition
     * @return the if-then-else block
     */
    public JavaCodeAlternative addIf(String condition) {
        return block.addIf(condition);
    }
    
    /**
     * Adds a throw statement.
     * 
     * @param expression the expression to throw
     * @return throw statement
     */
    public JavaCodeThrow addThrow(String expression) {
        return block.addThrow(expression);
    }
    
    /**
     * Adds a switch block.
     * 
     * @param expression the switch expression
     * @return the switch block
     */
    public JavaCodeSwitch addSwitch(String expression) {
        return block.addSwitch(expression);
    }

    /**
     * Adds a synchronized block.
     * 
     * @return the synchronized block
     */
    public JavaCodeSynchronizedBlock addSynchronized() {
        return block.addSynchronized();
    }

    /**
     * Adds a synchronized block.
     * 
     * @return the synchronized block
     */
    public JavaCodeTryBlock addTry() {
        return block.addTry();
    }

    /**
     * Adds an assignment.
     * 
     * @param variable the variable to change
     * @param expression the expression determining the value
     * @return the assignment
     */
    public JavaCodeAssignment addAssignment(String variable, String expression) {
        return block.addAssignment(variable, expression);
    }
    
    /**
     * Adds an empty line.
     * 
     * @return <b>this</b>
     */
    public JavaCodeMethod addEmptyLine() {
        block.addEmptyLine();
        return this;
    }

    /**
     * Adds a single-line comment.
     * 
     * @param text the comment text
     * @return <b>this</b>
     */
    public JavaCodeMethod addSLComment(String text) {
        block.addSLComment(text);
        return this;
    }
    
    /**
     * Adds a non-static method call.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addCall(String methodName) {
        return block.addCall(methodName);
    }

    /**
     * Adds a method call.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param scope the import scope
     * @return the method call (for chaining)
     */
    public JavaCodeMethodCall addCall(String methodName, JavaCodeImportScope scope) {
        return block.addCall(methodName, scope);
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
        return block.addVariable(type, variableName, initializer);
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
        return block.addVariable(type, variableName, initializer);
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
        return block.addVariable(type, variableName, isFinal, initializer);
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
        return block.addVariable(type, variableName, isFinal, initializer);
    }
    
    /**
     * Adds a return statement with javadoc comment.
     * 
     * @param value the return value
     * @param comment the javadoc comment for the return
     * @return <b>this</b> for chaining
     */
    public JavaCodeMethod addReturn(String value, String comment) {
        add("return " + value + ";"); // preliminary, may also become a class
        if (null != comment) {
            ensureJavadocComment("");
            getJavadocComment().addReturnComment(comment);
        }
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
        return block.addBlock(outputWhitespaceBefore, outputLnAfter, isStatic, withBrackets);
    }
    
    /**
     * Adds a nested block.
     * 
     * @param block the added block
     * @return {@code block} for chaining
     */
    public JavaCodeBlock addBlock(JavaCodeBlock block) {
        return block.addBlock(block);
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
        return block.setBlock(block);
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        super.store(out); // comment, annotations
        out.printwi(getModifier());
        if (null != type) { // constructor?
            type.store(out);
            out.print(" ");
        }
        out.print(getName());
        out.print("(");
        IJavaCodeElement.storeList(parameter, ", ", out);
        out.print(")");
        IJavaCodeElement.storeList(" throws ", exceptions, ", ", out);
        if (!isAbstract() || enclosing.getKind() == Kind.INTERFACE) {
            block.store(out);
        } else {
            out.println(";");
        }
    }
    
    @Override
    @Invisible(inherit = true)
    public String getTracerStringValue(StringComparator comparator) {
        return getClass().getSimpleName() + ": " + getName();
    }
    
    @Override
    public JavaCodeMethod setVisibility(String visibility) {
        super.setVisibility(visibility);
        return this;
    }

    @Override
    public JavaCodeMethod setVisibility(JavaCodeVisibility visibility) {
        super.setVisibility(visibility);
        return this;
    }
    
    @Override
    public JavaCodeMethod setPublic() {
        super.setPublic();
        return this;
    }

    @Override
    public JavaCodeMethod setPrivate() {
        super.setPrivate();
        return this;
    }

    @Override
    public JavaCodeMethod setProtected() {
        super.setProtected();
        return this;
    }

    @Override
    public JavaCodeMethod setPackage() {
        super.setPackage();
        return this;
    }

    @Override
    public JavaCodeMethod setStatic(boolean isStatic) {
        super.setStatic(isStatic);
        return this;
    }

    @Override
    public JavaCodeMethod setStatic() {
        super.setStatic();
        return this;
    }

    @Override
    public IJavaCodeElement getParent() {
        return enclosing;
    }

    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        JavaCodeClass.setParent(parent, p -> this.enclosing = p);
    }

}
