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

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.java.codeArtifacts.JavaCodeClass.Kind;

/**
 * Represents a Java code method.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeMethod extends JavaCodeAbstractVisibleElement implements JavaCodeBlockInterface {

    private JavaCodeTypeSpecification type;
    private JavaCodeClass enclosing;
    private JavaCodeBlock block;
    private List<JavaCodeParameterSpecification> parameter;
    private List<JavaCodeTypeSpecification> exceptions;
    private boolean forceJavadoc;
    private boolean dflt;
    private List<String> generics;

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
    
    /**
     * Creates a temporary instance without parent.
     * 
     * @return the instance
     */
    public static JavaCodeMethod create() {
        return new JavaCodeMethod("", null);
    }    
    
    /**
     * Overrides the original type specification. This may lead to unintended imports.
     * 
     * @param type the type
     * @return <b>this</b>
     */
    public JavaCodeMethod setType(String type) {
        this.type = JavaCodeTypeSpecification.create(type, getClassParent());
        return this;
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
     * Adds a generic parameter specification.
     * 
     * @param generic the generic
     * @param comment optional comment, may be <b>null</b> or empty for none
     * @return <b>this</b> for chaining
     */
    @OperationMeta(name = {"addGeneric", "generic"})
    public JavaCodeMethod addGeneric(String generic, String comment) {
        if (null != generic && generic.length() > 0) {
            if (null == generics) {
                generics = new ArrayList<>();
            }
            generic = generic.trim();
            if (generic.startsWith("<")) {
                generic = generic.substring(1);
            }
            if (generic.endsWith(">")) {
                generic = generic.substring(0, generic.length() - 1);
            }
            JavaCodeTypeSpecification tmp = new JavaCodeTypeSpecification(generic, this);
            generics.add(generic);
            if (null != comment && comment.length() > 0) {
                getJavadocComment().addGenericComment(tmp.getOutputTypeName(), comment);
            }
        }
        return this;
    }

    /**
     * Directly changes the method Javadoc comment.
     * 
     * @param comment the new comment
     * @return <b>this</b> for chaining
     */
    public JavaCodeMethod setJavadocComment(String comment) {
        getJavadocComment().setComment(comment);
        return this;
    }

    /**
     * Adds the given string to the method Javadoc comment.
     * 
     * @param comment the comment addition
     * @return <b>this</b> for chaining
     */
    public JavaCodeMethod addToJavadocComment(String comment) {
        JavaCodeJavadocComment c = getJavadocComment();
        c.setComment(c.getComment() + comment);
        return this;
    }

    /**
     * Adds an override annotation.
     * 
     * @return the annotation for further processing
     */
    @OperationMeta(name = {"addOverrideAnnotation", "override"})
    public JavaCodeAnnotation addOverrideAnnotation() {
        return addAnnotation(Override.class.getSimpleName());
    }

    /**
     * Adds a suppress warnings annotation.
     * 
     * @return the annotation for further processing
     */
    @OperationMeta(name = {"addSuppressWarningsUncheckedAnnotation", "suppressUnchecked"})
    public JavaCodeAnnotation addSuppressWarningsUncheckedAnnotation() {
        return addSuppressWarningsAnnotation().addStringArgument("unchecked");
    }

    /**
     * Adds a JUnit Test annotation.
     * 
     * @return the annotation for further processing
     */
    @OperationMeta(name = {"addJunitTestAnnotation", "junitTest"})
    public JavaCodeAnnotation addJunitTestAnnotation() {
        return addAnnotation("org.junit.Test");
    }
    
    /**
     * Adds a JUnit assert call (as static, non-imported method).
     * 
     * @param methodName the assert method to call
     * @return the method call
     */
    @OperationMeta(name = {"addJunitAssertCall", "junitAssert"})
    public JavaCodeMethodCall addJunitAssertCall(String methodName) {
        return block.addJunitAssertCall(methodName);        
    }

    /**
     * Adds a JUnit Before annotation.
     * 
     * @return the annotation for further processing
     */
    @OperationMeta(name = {"addJunitBeforeAnnotation", "junitBefore"})
    public JavaCodeAnnotation addJunitBeforeAnnotation() {
        return addAnnotation("org.junit.Before");
    }

    /**
     * Adds a JUnit After annotation.
     * 
     * @return the annotation for further processing
     */
    @OperationMeta(name = {"addJunitAfterAnnotation", "junitAfter"})
    public JavaCodeAnnotation addJunitAfterAnnotation() {
        return addAnnotation("org.junit.After");
    }

    /**
     * Adds a (formal) method parameter.
     * 
     * @param type the type of the parameter
     * @param name the name of the parameter
     * @return the parameter instance
     */
    @OperationMeta(name = {"addParameter", "param"})
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
    @OperationMeta(name = {"addParameter", "param"})
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
    //@OperationMeta(name = {"addParameter", "param"})
    JavaCodeParameterSpecification addParameter(JavaCodeTypeSpecification type, String name, String comment) {
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
    @OperationMeta(name = {"addException", "addThrows", "throws"})
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
    @OperationMeta(name = {"addException", "addThrows", "throws"})
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

    @Override
    public JavaCodeMethod add(String text) {
        block.add(text);
        return this;
    }

    @Override
    @OperationMeta(name = {"addAsStatement", "statement"})
    public JavaCodeMethod addAsStatement(String text) {
        block.addAsStatement(text);
        return this;
    }

    @Override
    public JavaCodeMethod add(JavaCodeStatement stmt) {
        block.add(stmt);
        return this;
    }

    @Override
    public JavaCodeMethod add(JavaCodeExpression expr) {
        block.add(expr);
        return this;
    }

    @Override
    public JavaCodeMethod addRaw(String text, boolean indent) {
        block.addRaw(text, indent);
        return this;
    }
    
    @Override
    @OperationMeta(name = {"addDoLoop", "do"})
    public JavaCodeDoLoop addDoLoop(String condition) {
        return block.addDoLoop(condition);
    }

    @Override
    @OperationMeta(name = {"addWhileLoop", "while"})
    public JavaCodeWhileLoop addWhileLoop(String condition) {
        return block.addWhileLoop(condition);
    }

    @Override
    @OperationMeta(name = {"addForLoop", "for"})
    public JavaCodeForLoop addForLoop(String type, String variableName, String expression) {
        return block.addForLoop(type, variableName, expression);
    }
    
    //@Override
    //@OperationMeta(name = {"addForLoop", "for"})
    JavaCodeForLoop addForLoop(JavaCodeTypeSpecification type, String variableName, 
        String expression) {
        return block.addForLoop(type, variableName, expression);
    }

    @Override
    @OperationMeta(name = {"addForLoop", "for"})
    public JavaCodeForLoop addForLoop(String type, String variableName, String initializer, 
        String condition, String update) {
        return block.addForLoop(type, variableName, initializer, condition, update);
    }

    //@Override
    //@OperationMeta(name = {"addForLoop", "for"})
    JavaCodeForLoop addForLoop(JavaCodeTypeSpecification type, String variableName, 
        String initializer, String condition, String update) {
        return block.addForLoop(type, variableName, initializer, condition, update);
    }
    
    @Override
    @OperationMeta(name = {"addIf", "if"})
    public JavaCodeAlternative addIf(String condition) {
        return block.addIf(condition);
    }
    
    @Override
    @OperationMeta(name = {"addThrow", "throw"})
    public JavaCodeThrow addThrow(String expression) {
        return block.addThrow(expression);
    }
    
    @Override
    @OperationMeta(name = {"addSwitch", "switch"})
    public JavaCodeSwitch addSwitch(JavaCodeExpression expression) {
        return block.addSwitch(expression);
    }

    @Override
    @OperationMeta(name = {"addSynchronized", "synchronized"})
    public JavaCodeSynchronizedBlock addSynchronized() {
        return block.addSynchronized();
    }

    @Override
    @OperationMeta(name = {"addTry", "try"})
    public JavaCodeTryBlock addTry() {
        return block.addTry();
    }
    
    @Override
    public JavaCodeExpressionStatement addPostfixIncrement(String variable) {
        return block.addPostfixIncrement(variable);
    }

    @Override
    public JavaCodeExpressionStatement addPostfixDecrement(String variable) {
        return block.addPostfixDecrement(variable);
    }

    @OperationMeta(name = {"addAssignment", "addAssign", "assign"})
    @Override
    public JavaCodeAssignment addAssignment(String variable) {
        return block.addAssignment(variable);
    }

    @OperationMeta(name = {"addAssignment", "addAssign", "assign"})
    @Override
    public JavaCodeAssignment addAssignment(String variable, JavaCodeExpression expression) {
        return block.addAssignment(variable, expression);
    }

    @OperationMeta(name = {"addAssignment", "addAssign", "assign"})
    @Override
    public JavaCodeAssignment addAssignment(String variable, String operator, JavaCodeExpression expression) {
        return block.addAssignment(variable, operator, expression);
    }

    @Override
    @OperationMeta(name = {"addEmptyLine", "emptyLine"})
    public JavaCodeMethod addEmptyLine() {
        block.addEmptyLine();
        return this;
    }

    @Override
    @OperationMeta(name = {"addSLComment", "SLComment"})
    public JavaCodeMethod addSLComment(String text) {
        block.addSLComment(text);
        return this;
    }
    
    @Override
    @OperationMeta(name = {"addSuperCall", "super"})
    public JavaCodeMethodCall addSuperCall() {
        return block.addSuperCall();
    }

    @Override
    @OperationMeta(name = {"addThisCall", "this"})
    public JavaCodeMethodCall addThisCall() {
        return block.addThisCall();
    }    
    
    @Override
    @OperationMeta(name = {"addSystemOutPrintlnCall", "SystemOutPrintln", "sysoutprintln"})
    public JavaCodeMethodCall addSystemOutPrintlnCall() {
        return block.addSystemOutPrintlnCall();
    }    
    
    @Override
    @OperationMeta(name = {"addCall", "call"})
    public JavaCodeMethodCall addCall(String methodName) {
        return block.addCall(methodName);
    }

    @Override
    @OperationMeta(name = {"addCall", "call"})
    public JavaCodeMethodCall addCall(String methodName, JavaCodeImportScope scope) {
        return block.addCall(methodName, scope);
    }
    
    @OperationMeta(name = "callQualified")
    public JavaCodeMethodCall addCallQualified(String methodName) {
        return block.addCallQualified(methodName);
    }

    @Override
    @OperationMeta(name = {"addVariable", "var"})
    public JavaCodeVariableDeclaration addVariable(String type, String variableName, 
        JavaCodeExpression initializer) {
        return block.addVariable(type, variableName, initializer);
    }

    //@Override
    //@OperationMeta(name = {"addVariable", "var"})
    JavaCodeVariableDeclaration addVariable(JavaCodeTypeSpecification type, String variableName, 
        JavaCodeExpression initializer) {        
        return block.addVariable(type, variableName, initializer);
    }

    @Override
    @OperationMeta(name = {"addVariable", "var"})
    public JavaCodeVariableDeclaration addVariable(String type, String variableName, 
        boolean isFinal, JavaCodeExpression initializer) {
        return block.addVariable(type, variableName, isFinal, initializer);
    }

    //@Override
    //@OperationMeta(name = {"addVariable", "var"})
    JavaCodeVariableDeclaration addVariable(JavaCodeTypeSpecification type, String variableName, 
        boolean isFinal, JavaCodeExpression initializer) {
        return block.addVariable(type, variableName, isFinal, initializer);
    }
    
    @Override
    public JavaCodeVariableDeclaration createVariable(String type, String variableName, 
        JavaCodeExpression initializer) {
        return block.createVariable(type, variableName, false, initializer);
    }

    @Override
    public JavaCodeVariableDeclaration createVariable(String type, String variableName, 
        boolean isFinal, JavaCodeExpression initializer) {
        return block.createVariable(type, variableName, isFinal, initializer);
    }
    
    /**
     * Adds a return statement without Javadoc comment.
     * 
     * @param valueEx the return value
     * @return the return statement
     */
    @OperationMeta(name = {"addReturn", "return"})
    public JavaCodeMethod addReturn(JavaCodeExpression valueEx) {
        return addReturn(valueEx, null);
    }

    /**
     * Adds a class return statement without Javadoc comment.
     * 
     * @param cls the (qualified) class name, optionally ending with ".class", ignored if <b>null</b> or empty
     * @return <b>this</b>
     */
    @OperationMeta(name = {"addReturnClass", "returnClass"})
    public JavaCodeMethod addReturnClass(String cls) {
        return addReturnClass(cls, null);
    }

    /**
     * Adds a class return statement with Javadoc comment.
     * 
     * @param cls the (qualified) class name, optionally ending with ".class", ignored if <b>null</b> or empty
     * @param comment the Javadoc comment for the return
     * @return <b>this</b>
     */
    @OperationMeta(name = {"addReturnClass", "returnClass"})
    public JavaCodeMethod addReturnClass(String cls, String comment) {
        JavaCodeTypeSpecification type = JavaCodeTypeSpecification.toClassType(cls, this);
        if (null != type) {
            addReturn(new JavaCodeTypeExpression(this, type), null);
        }
        return this;
    }
    
    /**
     * Adds a return statement with Javadoc comment.
     * 
     * @param valueEx the return value expression
     * @param comment the Javadoc comment for the return
     * @return <b>this</b>
     */
    @OperationMeta(name = {"addReturn", "return"})
    public JavaCodeMethod addReturn(JavaCodeExpression valueEx, String comment) {
        valueEx.setParent(this);
        block.addReturn(valueEx);
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
    @OperationMeta(name = {"addBlock", "block"})
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
    @OperationMeta(name = {"addBlock", "block"})
    public JavaCodeBlock addBlock(JavaCodeBlock block) {
        return block.addBlock(block);
    }
    
    @Invisible
    @Override
    public void transferElementsTo(JavaCodeBlockInterface block) {
        block.transferElementsTo(this);
    }

    @Invisible
    @Override
    public void add(IJavaCodeElement element) {
        block.add(element);
    }

    @Override
    public JavaCodeMethod addAll(JavaCodeBlockInterface block) {
        this.block.addAll(block);
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
    public JavaCodeMethod setBlock(JavaCodeBlock block) {
        block.setBlock(block);
        return this;
    }
    
    /**
     * Forces the output of javadoc even in the presence of an Override annotation.
     * 
     * @return <b>this</b> for chaining
     */
    public JavaCodeMethod forceJavadoc() {
        forceJavadoc = true;
        return this;
    }

    @Override
    protected boolean enableStoreComment() {
        return forceJavadoc || !hasAnnotation(Override.class.getSimpleName(), Override.class.getName());
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        super.store(out); // comment, annotations
        out.printwi(getModifier());
        boolean enclosingIsInterface = enclosing.getKind() == Kind.INTERFACE;
        if (!isConstructor()) {
            if (enclosingIsInterface && isDefault()) {
                out.print("default");
                out.print(" ");
            }
            if (null != generics) {
                out.print("<");
                out.print(IJavaCodeElement.toList(generics, ", "));
                out.print("> ");
            }
            if (null != type) { // constructor?
                type.store(out);
                out.print(" ");
            }
        }
        out.print(getName());
        out.print("(");
        IJavaCodeElement.storeList(parameter, ", ", out);
        out.print(")");
        IJavaCodeElement.storeList(" throws ", exceptions, ", ", out);
        boolean signatureOnly = isAbstract() || (enclosingIsInterface && (!isDefault() || !isStatic()));
        if (signatureOnly) {
            out.println(";");
        } else {
            block.store(out);
        }
    }
    
    @Override
    @Invisible(inherit = true)
    public String getTracerStringValue(StringComparator comparator) {
        return getClass().getSimpleName() + ": " + getName();
    }
    
    @Override
    @OperationMeta(name = {"setVisibility", "visibility"})
    public JavaCodeMethod setVisibility(String visibility) {
        super.setVisibility(visibility);
        return this;
    }

    @Override
    @OperationMeta(name = {"setVisibility", "visibility"})
    public JavaCodeMethod setVisibility(JavaCodeVisibility visibility) {
        super.setVisibility(visibility);
        return this;
    }
    
    @Override
    @OperationMeta(name = {"setPublic", "public"})
    public JavaCodeMethod setPublic() {
        super.setPublic();
        return this;
    }

    @Override
    @OperationMeta(name = {"setPrivate", "private"})
    public JavaCodeMethod setPrivate() {
        super.setPrivate();
        return this;
    }

    @Override
    @OperationMeta(name = {"setProtected", "protected"})
    public JavaCodeMethod setProtected() {
        super.setProtected();
        return this;
    }

    @Override
    @OperationMeta(name = {"setPackage", "package"})
    public JavaCodeMethod setPackage() {
        super.setPackage();
        return this;
    }

    @Override
    @OperationMeta(name = {"setStatic", "static"})
    public JavaCodeMethod setStatic(boolean isStatic) {
        super.setStatic(isStatic);
        return this;
    }

    @Override
    @OperationMeta(name = {"setStatic", "static"})
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
        super.setParent(parent);
        JavaCodeClass.setParent(parent, p -> this.enclosing = p);
    }

    @Override
    public boolean isConstructor() {
        return null == type;
    }
    
    @Override
    public boolean isMethod() {
        return null != type;
    }
    
    /**
     * Sets this method to default.
     */
    @OperationMeta(name = {"setDefault", "dflt"})
    public void setDefault() {
        dflt = true;
    }
    
    /**
     * Sets this method's default state.
     * 
     * @param isDefault if the method is method
     */
    @OperationMeta(name = {"setDefault", "dflt"})
    public void setDefault(boolean isDefault) {
        this.dflt = isDefault;
    }

    /**
     * Returns whether the element is default.
     * 
     * @return {@code true} for default, {@code false} for not default
     */
    public boolean isDefault() {
        return dflt;
    }

    /**
     * Returns the code block of this method.
     * 
     * @return the block
     */
    public JavaCodeBlock getBlock() {
        return block;
    }
    
}
