package de.uni_hildesheim.sse.model.cst;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;

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
    
    /**
     * {@inheritDoc}
     */
    public void visitConstantValue(ConstantValue value) {
    }

    /**
     * {@inheritDoc}
     */
    public void visitVariable(Variable variable) {
    }

    /**
     * {@inheritDoc}
     */
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        for (int e = 0; e < initializer.getExpressionCount(); e++) {
            initializer.getExpression(e).accept(this);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerInitializer(ContainerInitializer initializer) {
        for (int e = 0; e < initializer.getExpressionCount(); e++) {
            initializer.getExpression(e).accept(this);
        }
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitComment(Comment comment) {
    }

    /**
     * {@inheritDoc}
     */
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

    /**
     * {@inheritDoc}
     */
    public void visitLet(Let let) {
        let.getInExpression().accept(this);
    }

    /**
     * {@inheritDoc}
     */
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        ifThen.getElseExpr().accept(this);
        ifThen.getThenExpr().accept(this);
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerOperationCall(ContainerOperationCall call) {
        call.getContainer().accept(this);
        call.getExpression().accept(this);
        for (int d = 0; d < call.getDeclaratorsCount(); d++) {
            if (null != call.getDeclarator(d).getDefaultValue()) {
                call.getDeclarator(d).getDefaultValue().accept(this);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);
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
    }

}
