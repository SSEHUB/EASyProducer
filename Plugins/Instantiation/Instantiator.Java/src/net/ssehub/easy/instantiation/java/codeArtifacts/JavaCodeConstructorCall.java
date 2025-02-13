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
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;

/**
 * Represents a constructor call.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeConstructorCall extends JavaCodeMethodCall {

    private String generics = null;
    
    /**
     * Creates a method call with no import scope.
     * 
     * @param parent the parent
     * @param cls the class name
     * @param indent shall the call be indended
     * @param postfix the postfix, e.g., semicolon newline
     */
    public JavaCodeConstructorCall(IJavaCodeElement parent, String cls, boolean indent, String postfix) {
        this(parent, cls, JavaCodeImportScope.NONE, indent, postfix);
    }

    /**
     * Creates a method call.
     * 
     * @param parent the parent
     * @param cls the class name
     * @param scope the scope to apply
     * @param indent shall the call be indended
     * @param postfix the postfix, e.g., semicolon newline
     */
    public JavaCodeConstructorCall(IJavaCodeElement parent, String cls, JavaCodeImportScope scope, boolean indent, 
        String postfix) {
        super(parent, cls, scope, indent, postfix);
    }

    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param cls the class name
     * @return the instance
     */
    public static JavaCodeConstructorCall create(String cls) {
        return new JavaCodeConstructorCall(null, cls, false, "");
    }
    
    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param cls the class name
     * @param scope the scope of the import
     * @return the instance
     */
    public static JavaCodeConstructorCall create(String cls, JavaCodeImportScope scope) {
        return new JavaCodeConstructorCall(null, cls, scope, false, "");
    }
    
    @Override // implicitly called in setParent via parent class
    protected String validateName(IJavaCodeElement parent, String cls, JavaCodeImportScope scope) {
        String result = cls;
        if (cls.contains(".")) { // else methodName may be qualified but not by class
            if (JavaCodeImportScope.NONE == scope || parent == null || parent.getArtifact() == null) {
                JavaCodeTypeSpecification type = new JavaCodeTypeSpecification(cls, parent);
                result = type.getOutputType(); // including generics
            } else {
                result = parent.getArtifact().validateStaticName(cls, scope);
            }
        }
        return result;
    }

    @Override
    @OperationMeta(name = {"addArgument", "arg"})
    public JavaCodeConstructorCall addArgument(JavaCodeExpression arg) {
        return (JavaCodeConstructorCall) super.addArgument(arg);
    }

    @Override
    @OperationMeta(name = {"addArgument", "arg"})
    public JavaCodeConstructorCall addArgument(JavaCodeParameterSpecification param) {
        return (JavaCodeConstructorCall) super.addArgument(param);
    }
    
    @Override
    @OperationMeta(name = {"addArgument", "arg"})
    public JavaCodeConstructorCall addArgument(Object arg) {
        return (JavaCodeConstructorCall) super.addArgument(arg);
    }

    @Override
    @OperationMeta(name = {"addStringArgument", "stringArg"})
    public JavaCodeConstructorCall addStringArgument(String val) {
        return (JavaCodeConstructorCall) super.addStringArgument(val);
    }

    @Override
    @OperationMeta(name = {"addClassArgument", "classArg"})
    public JavaCodeConstructorCall addClassArgument(String cls) {
        return (JavaCodeConstructorCall) super.addClassArgument(cls);
    }

    @Override
    @OperationMeta(name = {"addArgument", "arg"})
    public JavaCodeConstructorCall addArgument(String arg) {
        return (JavaCodeConstructorCall) super.addArgument(arg);
    }

    @Override
    @OperationMeta(name = {"addArgument", "arg"})
    public JavaCodeMethodCall addArgument(String methodName, JavaCodeImportScope scope) {
        return super.addArgument(methodName, scope); // returns a method call, not this
    }
    
    @Override
    public JavaCodeConstructorCall addNew(String cls) {
        return (JavaCodeConstructorCall) super.addNew(cls);
    }
    
    /**
     * Adds generics.
     * 
     * @param generics the generics, may be <b>null</b> for no generics, empty for no generic parameters
     *
     * @return <b>this</b> for chaining
     */
    public JavaCodeConstructorCall addGenerics(String generics) {
        this.generics = generics;
        return this;
    }
     
    @Override
    protected void storeBefore(CodeWriter out) {
        out.print("new ");
    }

    @Override
    protected void storeAfterName(CodeWriter out) {
        if (null != generics) {
            out.print("<");
            out.print(generics);
            out.print(">");
        }
    }

}
