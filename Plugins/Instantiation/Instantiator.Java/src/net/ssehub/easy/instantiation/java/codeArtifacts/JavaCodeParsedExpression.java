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
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Intermediary expression type indicating that it may be delivered by code parsing.
 * VTL conversion from string to this type enforces parsing.
 * 
 * @author Holger Eichelberger
 */
public abstract class JavaCodeParsedExpression extends JavaCodeExpression {
    
    /**
     * Creates an instance.
     *
     * @param parent the parent, may be <b>null</b> ({@see #setParent(IJavaCodeElement)})
     */
    protected JavaCodeParsedExpression(IJavaCodeElement parent) {
        super(parent);
    }
    
    /**
     * Creates an instance by conversion from {@code text}, if possible by parsing. Must be hooked in 
     * by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param text the text representing the expression/value
     * @return the instance
     * @throws VilException if the conversion fails
     */
    @Invisible
    @Conversion
    public static JavaCodeParsedExpression convert(Object text) throws VilException {
        JavaCodeParsedExpression result = null;
        Object tmp = IVilType.convertVilValue(text);
        if (null != tmp) {
            result = create(tmp.toString());
        }
        if (null == result) {
            JavaCodeTextExpression.create(text); // forward use!!
        }
        return result;
    }    
    
    /**
     * Creates a temporary instance without parent by parsing it from {@code text}.
     * 
     * @param text the text to parse from
     * @return the parsed class, may just contain default values if text cannot be parsed
     * @throws VilException if parsing fails
     */
    public static JavaCodeParsedExpression create(String text) throws VilException {
        return AST2ArtifactVisitor.parseExpression(text, AST2ArtifactVisitor.logConsumer()).getExpression();
    }    

}
