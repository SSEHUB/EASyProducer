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

/**
 * Represents a constructor call.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeConstructorCall extends JavaCodeMethodCall {
    
    /**
     * Creates a method call.
     * 
     * @param parent the parent
     * @param cls the class name
     * @param indent shall the call be indended
     * @param postfix the postfix, e.g., semicolon newline
     */
    public JavaCodeConstructorCall(IJavaCodeElement parent, String cls, boolean indent, String postfix) {
        super(parent, cls, JavaCodeImportScope.NONE, indent, postfix);
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
    
    @Override
    protected String validateMethodName(IJavaCodeElement parent, String methodName, JavaCodeImportScope scope) {
        String result = methodName;
        if (methodName.contains(".")) { // else methodName may be qualified but not by class
            JavaCodeTypeSpecification type = new JavaCodeTypeSpecification(methodName, parent);
            result = type.getOutputType(); // including generics
        }
        return result;
    }

    @Override
    public JavaCodeConstructorCall addArgument(Object arg) {
        return (JavaCodeConstructorCall) super.addArgument(arg);
    }

    @Override
    public JavaCodeConstructorCall addStringArgument(String val) {
        return (JavaCodeConstructorCall) super.addStringArgument(val);
    }

    @Override
    public JavaCodeConstructorCall addClassArgument(String cls) {
        return (JavaCodeConstructorCall) super.addClassArgument(cls);
    }

    @Override
    public JavaCodeConstructorCall addArgument(String arg) {
        return (JavaCodeConstructorCall) super.addArgument(arg);
    }

    @Override
    public JavaCodeConstructorCall addArgument(String methodName, JavaCodeImportScope scope) {
        return (JavaCodeConstructorCall) super.addArgument(methodName, scope);
    }
    
    @Override
    public JavaCodeConstructorCall addNew(String cls) {
        return (JavaCodeConstructorCall) super.addNew(cls);
    }
    
    protected void storeBefore(CodeWriter out) {
        out.print("new ");
    }

}
