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

/**
 * Represents a static/non-static method call. For static method calls, imports may be created automatically.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeMethodCall extends JavaCodeStatement {

    private String methodName;
    private List<IJavaCodeElement> arguments = new ArrayList<>();
    
    /**
     * Creates a method call.
     * 
     * @param parent the parent
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param considerStatic whether the call is static
     */
    public JavaCodeMethodCall(IJavaCodeElement parent, String methodName, boolean considerStatic) {
        super(parent);
        this.methodName = methodName;
        if (considerStatic && methodName.contains(".")) { // else methodName may be qualified but not by class
            parent.getArtifact().validateStaticMethodCall(methodName);
        }
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
     * @param considerStatic whether the call is static
     * @return the created method call for chaining
     */
    public JavaCodeMethodCall addArgument(String methodName, boolean considerStatic) {
        return IJavaCodeElement.add(arguments, new JavaCodeMethodCall(getParent(), methodName, considerStatic));
    }

    @Override
    public void store(CodeWriter out) {
        out.printwi(methodName);
        out.print("(");
        IJavaCodeElement.storeList(arguments, ",", out);
        out.println(");");
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return "MethodCall";
    }

}
