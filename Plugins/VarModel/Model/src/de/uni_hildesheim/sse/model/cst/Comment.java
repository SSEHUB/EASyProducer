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

/**
 * Represents a comment in a parse tree. This can be placed before any other CST node.
 * 
 * @author Holger Eichelberger
 */
public class Comment extends ConstraintSyntaxTree {

    /**
     * Stores the commented expression.
     */
    private ConstraintSyntaxTree expr;
    
    private String comment; 
    
    /**
     * Creates a new comment node.
     * 
     * @param expr the commented expression
     * @param comment the comment text
     */
    public Comment(ConstraintSyntaxTree expr, String comment) {
        this.expr = expr;
        this.comment = comment;
    }

    /**
     * Returns the commented expression.
     * 
     * @return the commented expression
     */
    public ConstraintSyntaxTree getExpr() {
        return expr;
    }

    /**
     * {@inheritDoc}
     */
    public IDatatype inferDatatype() throws CSTSemanticException {
        return expr.inferDatatype();
    }
    
    /**
     * {@inheritDoc}
     */
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitComment(this); // no further operations!
    }
    
    /**
     * Returns the comment text.
     * 
     * @return the comment text
     */
    public String getComment() {
        return comment;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj instanceof Comment) {
            Comment otherComment = (Comment) obj;
            boolean equalExpr = expr.equals(otherComment.getExpr());
            boolean equalComt = false;
            if (null == comment) {
                equalComt = null == otherComment.getComment();
            } else {
                equalComt = comment.equals(otherComment.comment);
            }
            equals = equalExpr && equalComt;
        }
        return equals;        
    }
    
    @Override
    public int hashCode() {
        int hashCode = expr.hashCode();
        if (null != comment && 0 != comment.hashCode()) {
            hashCode = hashCode * comment.hashCode();
        }
        return hashCode;        
    }

}
