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
 * Represents raw text as an expression.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeTextExpression extends JavaCodeExpression {

    private String text;

    /**
     * Creates an instance.
     * 
     * @param parent the parent element
     * @param text the text representing the expression
     */
    protected JavaCodeTextExpression(IJavaCodeElement parent, String text) {
        super(parent);
        this.text = text;
    }

    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param text the text representing the expression
     * @return the instance
     */
    public static JavaCodeTextExpression create(String text) {
        return new JavaCodeTextExpression(null, text);
    }
    
    @Override
    public void store(CodeWriter out) {
        out.print(text);
    }

}
