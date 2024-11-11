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

import org.apache.commons.lang.StringEscapeUtils;

/**
 * A text expression which cares for escaping and Java quotes.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeStringExpression extends JavaCodeTextExpression {

    /**
     * Creates an instance.
     * 
     * @param parent the parent element
     * @param text the text
     */
    protected JavaCodeStringExpression(IJavaCodeElement parent, String text) {
        super(parent, "\"" + StringEscapeUtils.escapeJava(text) + "\"");
    }
    
    /**
     * Creates an instance without parent. Must be hooked in by {@link #setParent(IJavaCodeElement)} later.
     * 
     * @param text the text
     * @return the instance
     */
    public static JavaCodeStringExpression create(String text) {
        return new JavaCodeStringExpression(null, text);
    }

}
