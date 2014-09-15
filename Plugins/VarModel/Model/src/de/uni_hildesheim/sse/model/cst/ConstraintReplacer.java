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

/**
 * Class to copy a OCLFeatureCall. May be superseded by {@link CopyVisitor}.
 * @author beck
 *
 */
public class ConstraintReplacer implements IConstraintTreeVisitor {

    private Leaf oldLeaf;
    
    private Leaf newLeaf;
    
    private ConstraintSyntaxTree copiedConstraint;
    private ConstraintSyntaxTree origin;
    
    /**
     * Creates a ConstraintReplacer witch is needed to copy a OCLFeatureCall.
     * @param origin ConstraintSyntaxTree witch should be copied
     */
    public ConstraintReplacer(ConstraintSyntaxTree origin) {
        this.origin = origin;
    }
    
    /**
     * Copies a ConstraintSyntaxTree and replaces all occurrences of oldLeaf with newLeaf.
     * @param oldLeaf Variables and Constants witch should be replaced
     * @param newLeaf Replacement of oldLeaf
     * @return returns a new ConstraintSyntaxTree
     */
    public ConstraintSyntaxTree replaceVariable(Leaf oldLeaf, Leaf newLeaf) {
        this.oldLeaf = oldLeaf;
        this.newLeaf = newLeaf;
        origin.accept(this);
        return copiedConstraint;
    }

    /**
     * {@inheritDoc}
     */
    public void visitConstantValue(ConstantValue value) {
        if (value.equals(newLeaf)) {
            copiedConstraint = newLeaf;
        } else {
            copiedConstraint = value;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitVariable(Variable variable) {
        if (variable.equals(oldLeaf)) {
            copiedConstraint = newLeaf;
        } else {
            copiedConstraint = variable;
        }      
    }

    /**
     * {@inheritDoc}
     */
    public void visitParenthesis(Parenthesis parenthesis) {
        // TODO check whether contained expression shall be visited
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        // TODO check whether contained expression shall be visited
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerInitializer(ContainerInitializer initializer) {
        // TODO check whether contained expression shall be visited
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitComment(Comment comment) {
        // TODO check whether contained expression shall be visited
    }

    /**
     * {@inheritDoc}
     */
    public void visitOclFeatureCall(OCLFeatureCall call) {
        call.getOperand().accept(this);
        ConstraintSyntaxTree operand = copiedConstraint;
        ConstraintSyntaxTree[] parameters = new ConstraintSyntaxTree[call.getParameterCount()];
        for (int i = 0; i < call.getParameterCount(); i++) {
            call.getParameter(i).accept(this);
            parameters[i] = copiedConstraint;
        }
        
        copiedConstraint = new OCLFeatureCall(operand, call.getOperation(), parameters);             
    }

    /**
     * {@inheritDoc}
     */
    public void visitLet(Let let) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitIfThen(IfThen ifThen) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerOperationCall(ContainerOperationCall call) {
        // TODO Auto-generated method stub
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitCompoundAccess(CompoundAccess access) {
        // TODO Auto-generated method stub
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitDslFragment(DslFragment fragment) {
    }

    /**
     * {@inheritDoc}
     */
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        ConstraintSyntaxTree actual = expression.getActualExpression();
        if (null != actual) {
            actual.accept(this);
        }
    }
    
}
