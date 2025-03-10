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

import org.apache.commons.lang.StringUtils;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;
import net.ssehub.easy.instantiation.core.model.vilTypes.PseudoString;

/**
 * Represents raw text. The raw text may consist of multiple lines. If no indentation is requested, 
 * the raw text is emitted as given. Applies {@link PseudoString#content(String)} to handle empty 
 * content expressions.
 * 
 * @author Holger Eichelberger
 */
public class JavaCodeText implements IJavaCodeElement {

    private String text;
    private boolean indent;
    private boolean endWithNewline;

    /**
     * Creates a raw text instance.
     * 
     * @param text the text
     * @param indent does the text include an indentation or shall the text be indended by default
     * @param endWithNewline end the text with a newline
     */
    JavaCodeText(String text, boolean indent, boolean endWithNewline) {
        this.text = text;
        this.indent = indent;
        this.endWithNewline = endWithNewline;
    }
    
    @Override
    public void store(CodeWriter out) {
        boolean done = false;
        if (indent) {
            done = out.printLinesWi(text, false, endWithNewline);
        }
        if (!done) {
            if (indent) {
                out.printIndent();
            } 
            out.print(text);
            if (endWithNewline) {
                out.println();
            }
        }
    }

    @Invisible
    @Override
    public IJavaCodeArtifact getArtifact() {
        return null;
    }

    @Override
    public IJavaCodeElement getParent() {
        return null;
    }

    @Invisible
    @Override
    public void setParent(IJavaCodeElement parent) {
    }
    
    @Override
    public int getElementCount() {
        return StringUtils.countMatches(text, "\\n") + (endWithNewline ? 1 : 0);
    }    

    @Override
    public JavaCodeText replaceVariable(String oldName, String newName) {
        if (text.equals(oldName)) {
            text = newName;
        }
        return this;
    }

    @Override
    public JavaCodeText replaceMethod(String oldName, String newName) {
        if (text.equals(oldName)) {
            text = newName;
        }
        return this;
    }    

}
