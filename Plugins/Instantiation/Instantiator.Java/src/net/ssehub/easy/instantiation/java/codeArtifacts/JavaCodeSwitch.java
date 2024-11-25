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
 * Represents a switch block with cases and default.
 *
 * @author Holger Eichelberger
 */
public class JavaCodeSwitch extends JavaCodeBlock {

    private String expression;
    
    /**
     * A case block.
     * 
     * @author Holger Eichelberger
     */
    private class CaseBlock extends JavaCodeBlock {
    
        private String expression;
        private boolean withClosingBreak;
        
        private CaseBlock(IJavaCodeElement parent, String expression, boolean withBrackets, boolean withClosingBreak) {
            super(parent, true, true, false, withBrackets);
            this.expression = expression;
            this.withClosingBreak = withClosingBreak;
        }

        @Invisible
        @Override
        public void store(CodeWriter out) {
            if (null == expression) {
                out.printlnwi("default:");
            } else {
                out.printlnwi("case " + expression + ":");
            }
            super.store(out);
            if (withClosingBreak) {
                out.increaseIndent();
                out.printlnwi("break;");
                out.decreaseIndent();
            }
        }
        
        @Override
        @Invisible(inherit = true)
        public String getTracerStringValue(StringComparator comparator) {
            return null == expression ? "JavaCodeDefault" : "JavaCodeCase";
        }
        
        /**
         * Returns whether this case block represents the switch-default.
         * 
         * @return {@code true} for the default, {@code false} else
         */
        public boolean isDefault() {
            return null == expression;
        }
        
    }
    
    /**
     * Creates a switch block.
     * 
     * @param parent the parent instance
     * @param expression the switch expression
     */
    public JavaCodeSwitch(IJavaCodeElement parent, String expression) {
        super(parent, true, false);
        this.expression = expression;
    }
    
    public JavaCodeBlock addCase(String expression, boolean asBlock, boolean withClosingBreak) {
        return add(new CaseBlock(getParent(), expression, asBlock, withClosingBreak), caseAddPosition());
    }
    
    private int caseAddPosition() {
        int size = getElementsSize();
        return elementsStream().anyMatch(c -> ((CaseBlock) c).isDefault()) ? size - 1 : size;
    }

    public JavaCodeBlock addDefault(boolean asBlock, boolean withClosingBreak) {
        return addElement(new CaseBlock(getParent(), null, asBlock, withClosingBreak));
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        out.printwi("switch (");
        out.print(expression);
        out.print(")");
        super.store(out);
        out.println();
    }

}
