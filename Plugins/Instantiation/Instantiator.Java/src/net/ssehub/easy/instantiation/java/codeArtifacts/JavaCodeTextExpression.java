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
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;

/**
 * Represents raw text/value as an expression.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeTextExpression extends JavaCodeParsedExpression {

    private Object text;

    /**
     * Creates an instance.
     * 
     * @param parent the parent element
     * @param text the text representing the expression/value
     */
    protected JavaCodeTextExpression(IJavaCodeElement parent, Object text) {
        super(parent);
        this.text = text;
    }

    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param text the text representing the expression/value
     * @return the instance
     */
    public static JavaCodeTextExpression create(Object text) {
        if (text instanceof IJavaCodeElement) {
            text = ((IJavaCodeElement) text).toCode();
        }
        return new JavaCodeTextExpression(null, IVilType.convertVilValue(text));
    }
    
    @Override
    public void store(CodeWriter out) {
        if (null != text) {
            out.print(text.toString());
        }
    }
    
    @Override
    public boolean isEmpty() {
        return null == text || text.toString().length() == 0;
    }
    
    @Override
    public JavaCodeTextExpression replaceVariable(String oldName, String newName) {
        if (null != text) {
            text = text.toString().replace(oldName, newName);
        }
        return this;
    }
    
    JavaCodeTextExpression append(String text) {
        if (text != null) {
            if (null == this.text) {
                this.text = "";
            }
            this.text = text.toString() + " " + text;
        }
        return this;
    }

}
