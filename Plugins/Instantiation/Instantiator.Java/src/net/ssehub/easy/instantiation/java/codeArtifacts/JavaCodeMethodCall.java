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

/**
 * Represents a static/non-static method call. For static method calls, imports may be created automatically.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeMethodCall extends JavaCodeExpression implements JavaCodeCallElement, JavaCodeQualifiableElement {

    private String methodName;
    private List<IJavaCodeElement> arguments = new ArrayList<>();
    private boolean indent;
    private String postfix;
    private JavaCodeMethodCall chained;
    private JavaCodeImportScope scope;
    private IJavaCodeElement qualification;

    /**
     * Creates a method call.
     * 
     * @param parent the parent
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param scope the scope of the import
     * @param indent shall the call be indended
     * @param postfix the postfix, e.g., semicolon newline
     */
    public JavaCodeMethodCall(IJavaCodeElement parent, String methodName, JavaCodeImportScope scope, boolean indent, 
        String postfix) {
        this(parent, null, methodName, scope, indent, postfix);
    }

    /**
     * Creates a method call.
     * 
     * @param parent the parent
     * @param qualification the qualification
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param scope the scope of the import
     * @param indent shall the call be indended
     * @param postfix the postfix, e.g., semicolon newline
     */
    public JavaCodeMethodCall(IJavaCodeElement parent, IJavaCodeElement qualification, String methodName, 
        JavaCodeImportScope scope, boolean indent, String postfix) {
        super(parent);
        this.scope = scope;
        this.methodName = validateMethodName(parent, methodName, scope);
        this.indent = indent;
        this.postfix = postfix;
        this.qualification = qualification;
    }

    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param methodName the method name
     * @return the instance
     */
    public static JavaCodeMethodCall create(String methodName) {
        return create(methodName, JavaCodeImportScope.NONE);
    }

    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param qualification the qualification
     * @param methodName the method name
     * @return the instance
     */
    public static JavaCodeMethodCall create(JavaCodeVariableDeclaration qualification, String methodName) {
        return create(qualification, methodName, JavaCodeImportScope.NONE);
    }

    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param qualification the qualification
     * @param methodName the method name
     * @return the instance
     */
    public static JavaCodeMethodCall create(IJavaCodeElement qualification, String methodName) {
        return create(qualification, methodName, JavaCodeImportScope.NONE);
    }

    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param methodName the method name
     * @param scope the scope of the import
     * @return the instance
     */
    public static JavaCodeMethodCall create(String methodName, JavaCodeImportScope scope) {
        return create(null, methodName, scope);
    }

    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param qualification the qualification
     * @param methodName the method name
     * @param scope the scope of the import
     * @return the instance
     */
    public static JavaCodeMethodCall create(JavaCodeVariableDeclaration qualification, String methodName, 
        JavaCodeImportScope scope) {
        return create((IJavaCodeElement) qualification, methodName, scope);
    }

    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param qualification the qualification
     * @param methodName the method name
     * @param scope the scope of the import
     * @return the instance
     */
    public static JavaCodeMethodCall create(IJavaCodeElement qualification, String methodName, 
        JavaCodeImportScope scope) {
        return new JavaCodeMethodCall(null, qualification, methodName, scope, false, "");
    }

    /**
     * Returns the method name.
     * 
     * @return the method name
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * Validates and potentially modifies the method name, e.g., by importing the prefixed qualified type.
     * 
     * @param parent the parent (may be <b>null</b> for ignore/deferred)
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param scope the scope of the import
     * @return {@code methodName} or a modified version
     */
    protected String validateMethodName(IJavaCodeElement parent, String methodName, JavaCodeImportScope scope) {
        String result = methodName;
        if (null != parent && JavaCodeImportScope.NONE != scope && methodName.contains(".")) {
            result = parent.getArtifact().validateStaticMethodCall(methodName, scope);
        }
        return result;
    }

    /**
     * Adds a call argument as raw string of {@code arg}.
     * 
     * @param arg the argument
     * @return <b>this</b> for chaining
     */
    public JavaCodeMethodCall addArgument(Object arg) {
        arguments.add(new JavaCodeText(arg.toString(), false, false));
        return this;
    }

    /**
     * Adds a call argument as potentially quoted string constant adding Java quotes before and after.
     * 
     * @param val the String value
     * @return <b>this</b> for chaining
     */
    public JavaCodeMethodCall addStringArgument(String val) {
        return addArgument(new JavaCodeStringExpression(this, val));
    }

    /**
     * Adds a call argument as class expression, i.e. potentially qualified class name optionally ending with ".class".
     * 
     * @param cls the (qualified) class name, optionally ending with ".class", ignored if <b>null</b> or empty
     * @return <b>this</b> for chaining
     */
    public JavaCodeMethodCall addClassArgument(String cls) {
        if (null != cls && cls.length() > 0) {
            if (cls.endsWith(".class")) {
                cls = cls.substring(0, cls.length() - 6);
            }
            JavaCodeTypeSpecification type = new JavaCodeTypeSpecification(cls, this);
            addArgument(new JavaCodeTypeExpression(this, type));
        }
        return this;
    }
    
    /**
     * Adds this as call argument.
     * 
     * @return <b>this</b> for chaining
     */
    public JavaCodeMethodCall addThisArgument() {
        return addArgument("this");
    }

    /**
     * Adds a call argument as raw string.
     * 
     * @param arg the argument, may be empty or <b>null</b> to ignore this argument
     * @return <b>this</b> for chaining
     */
    public JavaCodeMethodCall addArgument(String arg) {
        if (null != arg && arg.length() > 0) {
            arguments.add(new JavaCodeText(arg, false, false));
        }
        return this;
    }
    
    /**
     * Adds an expression as call argument.
     * 
     * @param ex the expression, may be <b>null</b> for none
     * @return <b>this</b> for chaining
     */
    public JavaCodeMethodCall addArgument(JavaCodeExpression ex) {
        if (null != ex) {
            ex.setParent(this);
            arguments.add(ex);
        }
        return this;
    }

    /**
     * Adds variable name as call argument.
     * 
     * @param var the variable declaration, may be <b>null</b> for none
     * @return <b>this</b> for chaining
     */
    public JavaCodeMethodCall addArgument(JavaCodeVariableDeclaration var) {
        if (null != var) {
            arguments.add(new JavaCodeVariableExpression(this, var));
        }
        return this;
    }

    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        super.setParent(parent);
        this.methodName = validateMethodName(parent, methodName, scope);
        for (IJavaCodeElement a : arguments) {
            setParent(a, this);
        }
        setParent(qualification, this);
        setParent(chained, this);
    }    

    /**
     * Adds a call argument as raw string.
     * 
     * @param arg the argument
     * @return <b>this</b> for chaining
     */
    public JavaCodeMethodCall addConstantArgument(String arg) {
        int pos = arg.lastIndexOf('.');
        if (pos > 0) {
            int classPos = arg.lastIndexOf('.', pos - 1);
            if (classPos > 0) {
                getArtifact().validateType(new JavaCodeTypeSpecification(arg.substring(0, pos), this));
                arg = arg.substring(classPos + 1);
            }
        }
        arguments.add(new JavaCodeText(arg, false, false));
        return this;
    }
    
    /**
     * Adds a lambda expression as call argument.
     * 
     * @return the lambda expression
     */
    public JavaCodeLambdaExpression addLambdaArgument() {
        return IJavaCodeElement.add(arguments, new JavaCodeLambdaExpression(this));
    }

    /**
     * Adds a method call as call argument with default scope ({@link JavaCodeImportScope#NONE}).
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @return <b>this</b> (as no arguments are provided)
     */
    public JavaCodeMethodCall addCallArgumentNoArg(String methodName) {
        addCallArgument(methodName);
        return this;
    }
    
    /**
     * Adds a method call as call argument with default scope ({@link JavaCodeImportScope#NONE}).
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @return the created method call for chaining
     */
    public JavaCodeMethodCall addCallArgument(String methodName) {
        return addCallArgument(methodName, JavaCodeImportScope.NONE);
    }

    /**
     * Adds a method call as call argument.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param scope the import scope
     * @return the created method call for chaining
     */
    public JavaCodeMethodCall addCallArgument(String methodName, JavaCodeImportScope scope) {
        return addArgument(methodName, scope); // transitioning addArgument(...)
    }
    
    /**
     * Adds a method call as call argument.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param scope the import scope
     * @return the created method call for chaining
     */
    public JavaCodeMethodCall addArgument(String methodName, JavaCodeImportScope scope) {
        return IJavaCodeElement.add(arguments, new JavaCodeMethodCall(this, methodName, scope, 
            false, ""));
    }

    /**
     * Adds a constructor call as argument.
     * 
     * @param cls the name of the class, may be qualified
     * @return the method call (for chaining)
     */
    public JavaCodeConstructorCall addNew(String cls) {
        return IJavaCodeElement.add(arguments, new JavaCodeConstructorCall(this, cls, false, ""));
    }
    
    @Override
    public JavaCodeMethodCall addCall(String methodName) {
        return addCall(methodName, JavaCodeImportScope.NONE);
    }

    @Override
    public JavaCodeMethodCall addCall(String methodName, JavaCodeImportScope scope) {
        chained = new JavaCodeMethodCall(this, methodName, scope, false, postfix);
        postfix = "";
        return chained;
    }
    
    @Override
    public JavaCodeMethodCall qualifiedBy(String qualification) {
        this.qualification = new JavaCodeTextExpression(this, qualification);
        return this;
    }

    @Override
    public JavaCodeMethodCall qualifiedByType(String type) {
        this.qualification = new JavaCodeTypeSpecification(type, this);
        return this;
    }
    
    @Override
    public JavaCodeMethodCall qualifiedBy(JavaCodeVariableDeclaration var) {
        this.qualification = new JavaCodeVariableExpression(this, var);
        return this;
    }
    
    /**
     * Returns the number of arguments of this call.
     * 
     * @return the number of arguments
     */
    public int getArgumentsCount() {
        return arguments.size();
    }
    
    @Override
    public void store(CodeWriter out) {
        if (indent) {
            out.printIndent();
        }
        storeBefore(out);
        out.print(methodName);
        storeArgumentList(out);
        if (null != chained) {
            out.print(".");
            chained.store(out);
        }
    }

    /**
     * Called as part of {@link #store(CodeWriter)} to store object specific parts before the call.
     * 
     * @param out the writer
     */
    protected void storeBefore(CodeWriter out) {
        if (null != qualification) {
            qualification.storeAsQualifier(out);
            out.print(".");
        }
    }
    
    protected void storeArgumentList(CodeWriter out) {
        out.print("(");
        IJavaCodeElement.storeList(arguments, ",", out);
        out.print(")" + postfix);
    }

}
