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

    private JavaCodeExpression expression;
    
    /**
     * A case block.
     * 
     * @author Holger Eichelberger
     */
    public class JavaCodeCaseBlock extends JavaCodeBlock {
    
        private JavaCodeExpression expression;
        private boolean withClosingBreak;
        
        private JavaCodeCaseBlock(IJavaCodeElement parent, JavaCodeExpression expression, boolean withBrackets, 
            boolean withClosingBreak) {
            super(parent, withBrackets, true, false, withBrackets);
            this.expression = expression;
            this.withClosingBreak = withClosingBreak;
        }

        @Invisible
        @Override
        public void store(CodeWriter out) {
            if (null == expression) {
                out.printwi("default:");
            } else {
                out.printwi("case ");
                expression.store(out);
                out.print(":");
            }
            if (!withBrackets()) {
                out.println();
            }
            super.store(out);
        }
        
        @Override
        protected void storeBeforeBlockEnd(CodeWriter out) {
            if (withClosingBreak) {
                out.printlnwi("break;");
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
    public JavaCodeSwitch(IJavaCodeElement parent, JavaCodeExpression expression) {
        super(parent, true, false);
        this.expression = expression;
    }
    
    public JavaCodeBlock addStringCase(String expression, boolean asBlock, boolean withClosingBreak) {
        return add(new JavaCodeCaseBlock(getParent(), new JavaCodeStringExpression(this, expression), asBlock, 
            withClosingBreak), caseAddPosition());
    }
    
    public JavaCodeBlock addCase(JavaCodeExpression expression, boolean asBlock, boolean withClosingBreak) {
        return add(new JavaCodeCaseBlock(getParent(), expression, asBlock, withClosingBreak), caseAddPosition());
    }
    
    private int caseAddPosition() {
        int size = getElementsSize();
        return elementsStream().anyMatch(c -> ((JavaCodeCaseBlock) c).isDefault()) ? size - 1 : size;
    }

    public JavaCodeBlock addDefault(boolean asBlock, boolean withClosingBreak) {
        return addElement(new JavaCodeCaseBlock(getParent(), null, asBlock, withClosingBreak));
    }

    @Invisible
    @Override
    public void store(CodeWriter out) {
        out.printwi("switch (");
        expression.store(out);
        out.print(")");
        super.store(out);
        out.println();
    }

}
