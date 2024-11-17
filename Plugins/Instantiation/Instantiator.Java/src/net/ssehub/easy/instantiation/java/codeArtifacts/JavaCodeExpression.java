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

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.Conversion;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Basic implementation for (selected) expressions. Intentionally, this is neither a
 * {@link JavaCodeStatement} nor a {@link IJavaCodeElement}.
 * 
 * @author Holger Eichelberger
 */
public abstract class JavaCodeExpression extends JavaCodeElement {

    /**
     * Creates an instance.
     *
     * @param parent the parent
     */
    protected JavaCodeExpression(IJavaCodeElement parent) {
        super(parent);
    }
    
    /**
     * Creates an instance by conversion from {@code text}. Must be hooked in by {@link #setParent(IJavaCodeElement)} 
     * later.
     * 
     * @param text the text representing the expression/value
     * @return the instance
     * @throws VilException if the conversion fails
     */
    @Invisible
    @Conversion
    public static JavaCodeExpression convert(Object text) throws VilException {
        return JavaCodeTextExpression.create(text); // forward use!!
    }    
    
    /**
     * Helper method to conditionally set the parent of {@code elt} if {@code elt} is not <b>null</b>.
     * 
     * @param elt the element
     * @param parent the parent
     */
    protected static void setParent(IJavaCodeElement elt, IJavaCodeElement parent) {
        if (null != elt) {
            elt.setParent(parent);
        }
    }
    
    /**
     * Returns whether this expression is empty, can be ignored.
     * 
     * @return {@code true} for empty, {@code false} else
     */
    public boolean isEmpty() {
        return false;
    }
    
}
