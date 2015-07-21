/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.persistency;

import java.io.StringWriter;

import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;

/**
 * Splits the textual output at a given <code>constraint</code>. This writer is useful
 * for embedded constraint editors. 
 * 
 * @author Holger Eichelberger
 */
public class ConstraintSplitWriter extends IVMLWriter {

    private StringWriter before = new StringWriter();
    private StringWriter constraint = new StringWriter();
    private StringWriter after = new StringWriter();
    private IConstraintFilter filter;

    /**
     * Identifies the constraint where to split at.
     * 
     * @author Holger Eichelberger
     */
    public interface IConstraintFilter {
        
        /**
         * Returns whether the split shall happen at <code>constraint</code>. Please note that the first
         * time this function returns <code>true</code> will cause the split. Further <code>true</code> as
         * return value will be ignored.
         * 
         * @param context the directly containing / using model element
         * @param constraint the constraint to check
         * @return <code>true</code> if the split shall happen at <code>constraint</code>, <code>false</code> else
         */
        public boolean splitAt(IModelElement context, ConstraintSyntaxTree constraint);
        
    }
    
    /**
     * An identity constraint filter.
     * 
     * @author Holger Eichelberger
     */
    public static class IdentityConstraintFilter implements IConstraintFilter {
        
        private ConstraintSyntaxTree constraint;
        
        /**
         * Creates a constraint filter which reacts on identity with <code>constraint</code>.
         * 
         * @param constraint the constraint to check for
         */
        public IdentityConstraintFilter(ConstraintSyntaxTree constraint) {
            this.constraint = constraint;
        }

        @Override
        public boolean splitAt(IModelElement context, ConstraintSyntaxTree constraint) {
            return this.constraint == constraint;
        }
        
    }
    
    /**
     * Creates a split writer for the given writer and splits at <code>constraint</code>.
     * 
     * @param filter the constraint filter identifying the split point
     */
    public ConstraintSplitWriter(IConstraintFilter filter) {
        super(new StringWriter());
        this.filter = filter;
        this.before = new StringWriter();
        setWriter(before);
    }

    /**
     * To be called before a potential split point (checking the filter).
     * 
     * @param context the enclosing model element
     * @param constraint the constraint to check
     * @return <code>true</code> if a split shall happen, <code>false</code> else
     */
    private boolean pre(IModelElement context, ConstraintSyntaxTree constraint) {
        boolean split = false;
        if (null != filter) {
            split = filter.splitAt(context, constraint);
        }
        if (split) {
            filter = null; // don't split again
            setWriter(this.constraint);
        }
        return split;
    }

    /**
     * To be called after a potential split point (checking the filter).
     * 
     * @param split the output of the corresponding {@link #pre(ConstraintSyntaxTree) pre} call
     */
    private void post(boolean split) {
        if (split) {
            setWriter(after);
        }
    }
    
    @Override
    protected void emitConstraintExpression(IModelElement context, ConstraintSyntaxTree constraint) {
        boolean split = pre(context, constraint);
        super.emitConstraintExpression(context, constraint);
        post(split);
    }

    @Override
    protected void emitDecisionVariableDeclarationDefault(DecisionVariableDeclaration decl, 
        ConstraintSyntaxTree defaultValue) {
        if (null != filter && ConstraintType.TYPE.isAssignableFrom(decl.getType())) {
            boolean split = pre(decl.getParent(), defaultValue);
            super.emitDecisionVariableDeclarationDefault(decl, defaultValue);
            post(split);
        } else {
            super.emitDecisionVariableDeclarationDefault(decl, defaultValue);
        }
    }
    
    /**
     * Returns the textual model representation before the constraint.
     * 
     * @return the textual model representation before the constraint
     */
    public String getBeforeText() {
        return before.toString();
    }
    
    /**
     * Returns the textual model representation of the constraint.
     * 
     * @return the textual model representation of the constraint
     */
    public String getConstraintText() {
        return constraint.toString();
    }

    /**
     * Returns the textual model representation after the constraint.
     * 
     * @return the textual model representation after the constraint
     */
    public String getAfterText() {
        return after.toString();
    }
    
    /**
     * Returns the split as needed for embedding xText editors.
     * 
     * @param trimConstraint trim the constraint from leading/trailing whitespaces
     * @param trimParenthesis trims the constraint from a leading/trailing parenthesis moving them to prefix/suffix
     * @return an array consisting of the values of {@link #getBeforeText()}, {@link #getConstraintText()} and 
     *     {@link #getAfterText()} 
     */
    public String[] getSplit(boolean trimConstraint, boolean trimParenthesis) {
        String[] result = new String[3];
        String addBefore = "";
        result[0] = getBeforeText();
        result[1] = getConstraintText();
        result[2] = getAfterText();
        if (trimConstraint) {
            String cTmp = result[1];
            int pos = 0;
            while (pos < cTmp.length() && doTrim(cTmp.charAt(pos))) {
                pos++;
            }
            if (trimParenthesis && pos < cTmp.length() && '(' == cTmp.charAt(pos)) {
                pos++;
                addBefore = "\n";
            }
            if (pos > 0) {
                result[0] += cTmp.substring(0, pos) + addBefore;
                result[1] = cTmp.substring(pos);
                cTmp = result[1];
            }
            pos = cTmp.length();
            while (pos > 0 && doTrim(cTmp.charAt(pos - 1))) {
                pos--;
            }
            if (trimParenthesis && pos > 0 && ')' == cTmp.charAt(pos - 1)) {
                pos--;
            }
            if (pos < cTmp.length()) {
                result[2] = cTmp.substring(pos) + result[2];
                result[1] = cTmp.substring(0, pos);
            }
        }
        return result;
    }

    /**
     * Returns whether <code>ch</code> shall be trimmed.
     * 
     * @param ch the character to check
     * @return <code>true</code> if <code>ch</code> shall be trimmed, <code>false</code> else
     */
    private static boolean doTrim(char ch) {
        return Character.isWhitespace(ch) || Character.LINE_SEPARATOR == ch;
    }
    
}
