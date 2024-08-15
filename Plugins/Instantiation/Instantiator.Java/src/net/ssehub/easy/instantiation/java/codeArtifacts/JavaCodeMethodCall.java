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

import org.apache.commons.lang.StringEscapeUtils;

/**
 * Represents a static/non-static method call. For static method calls, imports may be created automatically.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeMethodCall extends JavaCodeStatement {

    private String methodName;
    private List<IJavaCodeElement> arguments = new ArrayList<>();
    private boolean indent;
    private String postfix;
    
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
        super(parent);
        this.methodName = validateMethodName(parent, methodName, scope);
        this.indent = indent;
        this.postfix = postfix;
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
     * @param parent the parent
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param scope the scope of the import
     * @return {@code methodName} or a modified version
     */
    protected String validateMethodName(IJavaCodeElement parent, String methodName, JavaCodeImportScope scope) {
        String result = methodName;
        if (JavaCodeImportScope.NONE != scope && methodName.contains(".")) {
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
        return addArgument("\"" + StringEscapeUtils.escapeJava(val) + "\"");
    }

    public JavaCodeMethodCall addClassArgument(String cls) {
        if (cls.endsWith(".class")) {
            cls = cls.substring(0, cls.length() - 6);
        }
        JavaCodeTypeSpecification type = new JavaCodeTypeSpecification(cls, this);
        addArgument(type.getOutputTypeName() + ".class");
        return this;
    }

    /**
     * Adds a call argument as raw string.
     * 
     * @param arg the argument
     * @return <b>this</b> for chaining
     */
    public JavaCodeMethodCall addArgument(String arg) {
        arguments.add(new JavaCodeText(arg, false, false));
        return this;
    }

    /**
     * Adds a method call as call argument.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param scope the import scope
     * @return the created method call for chaining
     */
    public JavaCodeMethodCall addArgument(String methodName, JavaCodeImportScope scope) {
        return IJavaCodeElement.add(arguments, new JavaCodeMethodCall(getParent(), methodName, scope, 
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
    }
    
    protected void storeBefore(CodeWriter out) {
    }
    
    protected void storeArgumentList(CodeWriter out) {
        out.print("(");
        IJavaCodeElement.storeList(arguments, ",", out);
        out.print(")" + postfix);
    }

}
