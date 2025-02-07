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

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents a static/non-static method call. For static method calls, imports may be created automatically.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeMethodCall extends JavaCodeArgumentListExpression 
    implements JavaCodeCallElement, JavaCodeQualifiableElement {

    private String methodName;
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
        this.methodName = validateName(parent, methodName, scope);
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
     * Validates and potentially modifies the method/variable name, e.g., by importing the prefixed qualified type.
     * 
     * @param parent the parent (may be <b>null</b> for ignore/deferred)
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param scope the scope of the import
     * @return {@code methodName} or a modified version
     */
    protected String validateName(IJavaCodeElement parent, String methodName, JavaCodeImportScope scope) {
        String result = methodName;
        if (null != parent && JavaCodeImportScope.NONE != scope && methodName.contains(".")) {
            if (null != parent.getArtifact()) {            
                result = parent.getArtifact().validateStaticName(methodName, scope);
            }
        }
        return result;
    }

    @Override
    public JavaCodeMethodCall addArgument(Object arg) {
        return (JavaCodeMethodCall) super.addArgument(arg);
    }

    @Override
    public JavaCodeMethodCall addNullArgument() {
        return (JavaCodeMethodCall) super.addArgument("null");
    }

    @Override
    public JavaCodeMethodCall addStringArgument(String val) {
        return (JavaCodeMethodCall) super.addStringArgument(val); 
    }
    
    @Override
    public JavaCodeMethodCall addStringArgumentNotEmpty(String val) {
        return (JavaCodeMethodCall) super.addStringArgumentNotEmpty(val); 
    }    

    @Override
    public JavaCodeMethodCall addClassArgument(String cls) {
        return (JavaCodeMethodCall) super.addClassArgument(cls);
    }
    
    @Override
    public JavaCodeMethodCall addThisArgument() {
        return (JavaCodeMethodCall) super.addThisArgument();
    }

    @Override
    public JavaCodeMethodCall addArgument(String arg) {
        return (JavaCodeMethodCall) super.addArgument(arg);
    }

    @Override
    public JavaCodeMethodCall addArgument(JavaCodeExpression ex) {
        return (JavaCodeMethodCall) super.addArgument(ex);
    }
    
    @Override
    public JavaCodeMethodCall addArgument(JavaCodeVariableDeclaration var) {
        return (JavaCodeMethodCall) super.addArgument(var);
    }
    
    @Override
    public JavaCodeMethodCall addArgument(JavaCodeParameterSpecification param) {
        return (JavaCodeMethodCall) super.addArgument(param);
    }

    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
        super.setParent(parent);
        this.methodName = validateName(parent, methodName, scope);
        setParent(qualification, this);
        setParent(chained, this);
    }    

    @Override
    public JavaCodeMethodCall addConstantArgument(String arg) {
        return (JavaCodeMethodCall) super.addConstantArgument(arg);
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
        return addArgumentImpl(new JavaCodeMethodCall(this, methodName, scope, false, ""));
    }

    /**
     * Adds a constructor call as call argument.
     * 
     * @param cls the class to create an instance from
     * @return the create constructor call for chaining
     */
    public JavaCodeConstructorCall addNewArgument(String cls) {
        return addArgumentImpl(new JavaCodeConstructorCall(this, cls, false, ""));
    }
    
    public JavaCodeNewArrayExpression addNewArrayArgument(String type) {
        return addArgumentImpl(new JavaCodeNewArrayExpression(this, type));
    }
    
    /**
     * Adds a variable access as call argument.
     * 
     * @param variableName the variable name, qualified or statically qualified expression
     * @param scope the import scope
     * @return the created variable expression for chaining
     */
    public JavaCodeVariableExpression addVariableArgument(String variableName, JavaCodeImportScope scope) {
        variableName = validateName(this, variableName, scope);
        return addArgumentImpl(new JavaCodeVariableExpression(this, variableName));
    }
    
    /**
     * Adds a constructor call as argument.
     * 
     * @param cls the name of the class, may be qualified
     * @return the method call (for chaining)
     */
    public JavaCodeConstructorCall addNew(String cls) {
        return addArgumentImpl(new JavaCodeConstructorCall(this, cls, false, ""));
    }
    
    @Override
    public JavaCodeMethodCall addCall(String methodName) {
        return addCall(methodName, JavaCodeImportScope.NONE);
    }

    @Override
    public JavaCodeMethodCall addCall(String methodName, JavaCodeImportScope scope) {
        JavaCodeMethodCall result = new JavaCodeMethodCall(this, methodName, scope, false, postfix);
        if (chained == null) {
            chained = result;
            postfix = System.lineSeparator();
        } else {
            JavaCodeMethodCall last = chained;
            while (last.chained != null) {
                last = last.chained;
            }
            last.chained = result;
            result.postfix = last.postfix;
            last.postfix = System.lineSeparator();
        }
        return result;
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
    
    @Override
    public void store(CodeWriter out) {
        if (indent) {
            out.printIndent();
        }
        storeBefore(out);
        out.print(methodName);
        storeAfterName(out);
        storeArgumentList(out);
        if (null != chained) {
            out.printIndent();
            out.printIndentStep();
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
    
    /**
     * Called as part of {@link #store(CodeWriter)} to store object specific parts after the call name.
     * 
     * @param out the writer
     */
    protected void storeAfterName(CodeWriter out) {
    }

    @Override
    protected void storeArgumentList(CodeWriter out) {
        out.print("(");
        super.storeArgumentList(out);
        out.print(")" + postfix);
    }

    @Override
    public JavaCodeMethodCall replaceVariable(String oldName, String newName) {
        if (null != qualification) {
            qualification.replaceVariable(oldName, newName);
        }
        if (methodName.startsWith(oldName + ".")) {
            int pos = methodName.indexOf('.');
            methodName = newName + methodName.substring(pos);            
        }
        super.replaceVariable(oldName, newName);
        return this;
    }

    @Override
    public JavaCodeMethodCall replaceMethod(String oldName, String newName) {
        if (null != qualification) {
            qualification.replaceMethod(oldName, newName);
        }
        if (null != chained) {
            chained.replaceMethod(oldName, newName);
        }
        if (methodName.equals(oldName)) {
            methodName = newName;
        } else if (methodName.endsWith("." + oldName)) {
            int pos = methodName.lastIndexOf('.');
            methodName = methodName.substring(pos + 1) + newName;
        }
        super.replaceMethod(oldName, newName);
        return this;
    }

}
