/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Denotes an expression (tree) which is currently unresolved
 * due to deferred imports, e.g. model imports resolved at runtime.
 * 
 * @author Holger Eichelberger
 */
public class UnresolvedExpression extends ConstraintSyntaxTree {
    
    private ConstraintSyntaxTree actualExpression;
    @SuppressWarnings("unused")
    private ConstraintSyntaxTree expression;
    private String unresolvedLeaf;

    /**
     * Creates an unresolved expression as a (currently unknown) textual leaf.
     * 
     * @param unresolvedLeaf the the unresolved leaf
     */
    public UnresolvedExpression(String unresolvedLeaf) {
        this.unresolvedLeaf = unresolvedLeaf;
    }
    
    /**
     * Creates an unresolved expression as an inner tree node.
     * 
     * @param expression the contained (unresolved) expression
     */
    public UnresolvedExpression(ConstraintSyntaxTree expression) {
        this.expression = expression;
    }
    
    /**
     * Returns whether this tree node represents a CST leaf.
     *  
     * @return <code>true</code> if it is a leaf, <code>false</code> else
     */
    public boolean isLeaf() {
        return null != unresolvedLeaf;
    }
    
    /**
     * Returns whether this expression is actually resolved.
     * 
     * @return <code>true</code> if it is resolved, <code>false</code> else
     */
    public boolean isResolved() {
        return false; // constant for now
    }
    
    /**
     * Returns the unresolved leaf text.
     * 
     * @return the unresolved leaf text (may be <b>null</b>)
     */
    public String getUnresolvedLeaf() {
        return unresolvedLeaf;
    }
    
    /**
     * Changes the actual expression to a constant value.
     * 
     * @param value the inferred constant value
     */
    public void setConstantValue(Value value) {
        actualExpression = new ConstantValue(value);
    }
    
    /**
     * Changes the actual expression.
     * 
     * @param actualExpression the new actual expression
     */
    void setActualExpression(ConstraintSyntaxTree actualExpression) {
        this.actualExpression = actualExpression;
    }
    
    /**
     * Returns the actual expression. This may be an inferred
     * constant value or the actually resolved {@link #expression}.
     * 
     * @return the actual expression (may be <b>null</b>)
     */
    public ConstraintSyntaxTree getActualExpression() {
        return actualExpression;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitUnresolvedExpression(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        IDatatype result = null;
        if (null != actualExpression) {
            result = actualExpression.inferDatatype();
        }
        return result;
    }
    
    // for hascode and equals it is ok to rely on the built in things

}
