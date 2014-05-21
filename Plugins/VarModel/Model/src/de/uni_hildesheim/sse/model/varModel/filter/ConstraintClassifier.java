package de.uni_hildesheim.sse.model.varModel.filter;

import de.uni_hildesheim.sse.model.cst.Comment;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.DslFragment;
import de.uni_hildesheim.sse.model.cst.IConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.UnresolvedExpression;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;

/**
 * This class is able to classify a constraint in one of the following categories.
 * <ul>
 * <li>AssignmentConstraints - Assigning one value to exactly one variable</li>
 * <li>Constraints - all other constraints without the AssignmentConstraints</li>
 * </ul>
 * @author El-Sharkawy
 *
 */
class ConstraintClassifier implements IConstraintTreeVisitor {
    
    /**
     * With the aid of this enum is it possible to tell the Classifier
     * which part of a constraint is expected to be next.
     * If the read constraint do not match to the expected enum type,
     * the current constraint cannot be a AssingmentConstaint.
     *
     */
    private enum ExpectedType {
        /**
         * A Variable should be read at next.
         */
        VARIABLE,
        /**
         * An OCLFeatureCall should be read as next.
         */
        OCL_FEATURE_CALL,
        /**
         * A ConstantValue should be read at next.
         */
        CONSTANT_VALUE,
        /**
         * This is a constraint for a reference.
         */
        REFERENCE_VALUE;
    }
    
    private ExpectedType nextType;
    
    private boolean isAssingmentConstraint;
    
    /**
     * Sole constructor for this class, classifies exactly one constraint, whether it is an AssignmentConstraint.
     * @param tree The constraint which should be classified.
     */
    ConstraintClassifier(ConstraintSyntaxTree tree) {
        nextType = ExpectedType.OCL_FEATURE_CALL;
        // We expect that the current constraint is an AssingmentConstraint until the contrary is proved 
        isAssingmentConstraint = true;
        tree.accept(this);
    }
    
    /**
     * Returns whether the given ConstraintTree is an AssignmentConstraint or not.
     * @return <code>true</code> if the given constraint is an AssignmentConstraint, otherwise <code>false</code>.
     */
    boolean isAssingmentConstraint() {
        return isAssingmentConstraint;
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitConstantValue(ConstantValue value) {
        if (nextType != ExpectedType.CONSTANT_VALUE) {
            //stop here
            isAssingmentConstraint = false;
        } 
    }

    /**
     * {@inheritDoc}
     */
    public void visitVariable(Variable variable) {
        if ((nextType == ExpectedType.VARIABLE && variable.getVariable().getType() == Reference.TYPE)) {
            nextType = ExpectedType.REFERENCE_VALUE;            
        } else if (nextType != ExpectedType.VARIABLE) {
            //stop here
            isAssingmentConstraint = false;
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitParenthesis(Parenthesis parenthesis) {
        //stop here
        isAssingmentConstraint = false;
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitContainerInitializer(ContainerInitializer init) {
        // TODO check
        //stop here
        isAssingmentConstraint = false;
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitCompoundInitializer(CompoundInitializer init) {
        // TODO check
        //stop here
        isAssingmentConstraint = false;
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitComment(Comment parenthesis) {
        //stop here
        isAssingmentConstraint = false;
    }

    /**
     * {@inheritDoc}
     */
    public void visitOclFeatureCall(OCLFeatureCall call) {
        //TODO SE: check whether an AssingmentConstraint can have more than one parameter
        if (nextType == ExpectedType.OCL_FEATURE_CALL && call.getOperation().equals(OclKeyWords.ASSIGNMENT)
            && call.getParameterCount() == 1) {
            
            nextType = ExpectedType.VARIABLE;
            call.getOperand().accept(this);
            if (ExpectedType.REFERENCE_VALUE != nextType) {
                nextType = ExpectedType.CONSTANT_VALUE;
            }
            call.getParameter(0).accept(this);                
        } else {
            //stop here
            isAssingmentConstraint = false;
        } 
    }

    /**
     * {@inheritDoc}
     */
    public void visitLet(Let let) {
        //stop here
        isAssingmentConstraint = false;
    }

    /**
     * {@inheritDoc}
     */
    public void visitIfThen(IfThen ifThen) {
        //stop here
        isAssingmentConstraint = false;
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerOperationCall(ContainerOperationCall call) {
        //stop here
        isAssingmentConstraint = false; 
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundAccess(CompoundAccess access) {
        if (nextType != ExpectedType.VARIABLE) {
            //stop here
            isAssingmentConstraint = false;
        } 
    }
    /**
     * {@inheritDoc}
     */
    public void visitDslFragment(DslFragment fragment) {
        //stop here
        isAssingmentConstraint = false; 
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
