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
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Represents an if-then-else alternative. The element itself is the if-block. By default, the alternative
 * does not have an else block, which must be {@link #addElse() added} explicitly.
 *
 * @author Holger Eichelberger
 */
public class JavaCodeAlternative extends JavaCodeBlock {

    private String condition;
    private JavaCodeBlock elseBlock;
    
    /**
     * Creates an if-then-else alternative.
     * 
     * @param parent the parent instance
     * @param condition the loop condition
     */
    public JavaCodeAlternative(IJavaCodeElement parent, String condition) {
        super(parent, true, false);
        this.condition = condition;
    }
    
    /**
     * Adds an else block.
     * 
     * @return the else block
     */
    public JavaCodeBlock addElse() {
        elseBlock = new JavaCodeBlock(this, true, true);
        return elseBlock;
    }

    /**
     * Add an else-if block.
     * 
     * @param condition the condition
     * @return the else-if alternative
     */
    public JavaCodeAlternative addElseIf(String condition) {
        JavaCodeAlternative result = new JavaCodeAlternative(this, condition);
        elseBlock = result;
        return result;
    }

    /**
     * Returns whether this alternative has an else-block.
     * 
     * @return {@code true} for else-block, {@code false} for none or else-block
     */
    public boolean hasElse() {
        return elseBlock instanceof JavaCodeBlock;
    }

    /**
     * Returns whether this alternative has an else-if-block.
     * 
     * @return {@code true} for else-if-block, {@code false} for none or else-block
     */
    public boolean hasElseIf() {
        return elseBlock instanceof JavaCodeAlternative;
    }

    /**
     * Converts an existing else-if-block to an else, i.e., removes the condition but transfers the block contents.
     * This may be needed for a final step incremental generation of if-then-else cascades.
     * 
     * @return <b>this</b> for chaining
     */
    public JavaCodeAlternative elseIfToElse() {
        if (elseBlock instanceof JavaCodeAlternative) {
            JavaCodeBlock tmp = new JavaCodeBlock(this, true, true);
            tmp.addAll(elseBlock);
            elseBlock = tmp;
        }
        return this;
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        if (!(getParent() instanceof JavaCodeAlternative)) {
            out.printIndent();
        } else { // else if
            out.print(" ");
        }
        out.print("if (");
        out.print(condition);
        out.print(")");
        super.store(out);
        if (elseBlock != null) {
            out.print(" else");
            elseBlock.store(out);
        } else {
            out.println();
        }
    }

}
