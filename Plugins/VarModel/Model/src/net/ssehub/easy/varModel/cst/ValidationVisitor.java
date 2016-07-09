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
package net.ssehub.easy.varModel.cst;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;

/**
 * Visits a given expression and returns whether this is a valid assignment.
 * 
 * @author Holger Eichelberger
 */
public class ValidationVisitor implements IConstraintTreeVisitor {

    /**
     * Stores the number of assignments (to be derived while
     * visiting a constraint tree).
     */
    private int assignmentCount;

    // for future extension
    private List<String> errors = new ArrayList<String>();

    /**
     * Creates a new assignment check visitor.
     */
    public ValidationVisitor() {
        reset();
    }

    /**
     * Clears the errors.
     */
    public void clear() {
        assignmentCount = 0;
        errors.clear();
    }
    
    /**
     * Returns the number of errors.
     * 
     * @return the number of errors
     */
    public int getErrorCount() {
        return errors.size();
    }
    
    /**
     * Returns the specified error.
     * 
     * @param index the index of the error
     * @return the error
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getErrorCount()}</code>
     */
    public String getError(int index) {
        return errors.get(index);
    }
    
    /**
     * Returns the errors as a comma separated string.
     * 
     * @return the errors as a comma separated string, an empty string if there are no errors
     */
    public String getErrorString() {
        StringBuilder errors = new StringBuilder();
        for (int e = 0; e < getErrorCount(); e++) {
            if (e > 0) {
                errors.append(", ");
            }
            errors.append(getError(e));
        }
        return errors.toString();
    }
    
    /**
     * Returns whether the visited tree represents an assignment.
     * 
     * @return <code>true</code> if it is an assignment, <code>false</code> else
     */
    public boolean isAssignment() {
        return assignmentCount > 0;
    }
    
    /**
     * Returns whether the visited tree represents a valid assignment.
     * 
     * @return <code>true</code> if it is a valid assignment, <code>false</code> else
     */
    public boolean isValidAssignment() {
        return 1 == assignmentCount; //&& 0 == otherCount;
    }
    
    /**
     * Resets this instance.
     */
    public void reset() {
        assignmentCount = 0;
    }
    
    @Override
    public void visitConstantValue(ConstantValue value) {
    }

    @Override
    public void visitVariable(Variable variable) {
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        for (int e = 0; e < initializer.getExpressionCount(); e++) {
            initializer.getExpression(e).accept(this);
        }
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        for (int e = 0; e < initializer.getExpressionCount(); e++) {
            initializer.getExpression(e).accept(this);
        }
    }
    
    @Override
    public void visitComment(Comment comment) {
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (null != call.getOperand()) {
            call.getOperand().accept(this);
        }
        for (int p = 0; p < call.getParameterCount(); p++) {
            call.getParameter(p).accept(this);
        }
        String op = call.getOperation();
        if (op.equals(OclKeyWords.ASSIGNMENT)) {
            assignmentCount++;
        } /*else {
            // unclear: which operations are permitted?
        }*/
    }

    @Override
    public void visitLet(Let let) {
        let.getInExpression().accept(this);
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        ifThen.getElseExpr().accept(this);
        ifThen.getThenExpr().accept(this);
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        call.getContainer().accept(this);
        call.getExpression().accept(this);
        for (int d = 0; d < call.getDeclaratorsCount(); d++) {
            if (null != call.getDeclarator(d).getDefaultValue()) {
                call.getDeclarator(d).getDefaultValue().accept(this);
            }
        }
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
    }

    @Override
    public void visitSelf(Self self) {
    }

    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO check whether a specific method is needed
        visitVariable(variable);
    }

    @Override
    public void visitBlockExpression(BlockExpression block) {
        for (int e = 0; e < block.getExpressionCount(); e++) {
            block.getExpression(e).accept(this);
        }
    }

}
