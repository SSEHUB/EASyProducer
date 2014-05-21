package de.uni_hildesheim.sse.model.varModel.filter;

import java.util.HashSet;
import java.util.Set;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
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
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;

/**
 * Filter class for retrieving all {@link AbstractVariable}'s nested inside a given constraint.
 * @author El-Sharkawy
 *
 */
public class DeclrationInConstraintFinder implements IConstraintTreeVisitor {
    
    private Set<AbstractVariable> declarations;
    
    /**
     * Sole constructor for this class.
     * @param cst A constraint where all nested {@link AbstractVariable}'s should be found.
     */
    public DeclrationInConstraintFinder(ConstraintSyntaxTree cst) {
        declarations = new HashSet<AbstractVariable>();
        cst.accept(this);
    }
    
    /**
     * Returns all {@link AbstractVariable}'s inside the given {@link ConstraintSyntaxTree}.
     * @return A set of nested {@link AbstractVariable}'s (This set must not be <tt>null</tt>).
     */
    public Set<AbstractVariable> getDeclarations() {
        return declarations;
    }

    /**
     * {@inheritDoc}
     */
    public void visitConstantValue(ConstantValue value) {
        // No function needed
    }

    /**
     * {@inheritDoc}
     */
    public void visitVariable(Variable variable) {
        declarations.add(variable.getVariable());
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
    public void visitComment(Comment comment) {
        comment.getExpr().accept(this);
    }

    /**
     * {@inheritDoc}
     */
    public void visitOclFeatureCall(OCLFeatureCall call) {
        call.getOperand().accept(this);
        for (int i = 0; i < call.getParameterCount(); i++) {
            call.getParameter(i).accept(this);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitLet(Let let) {
        declarations.add(let.getVariable());
        let.getInExpression().accept(this);  
    }

    /**
     * {@inheritDoc}
     */
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        ifThen.getThenExpr().accept(this);
        ifThen.getElseExpr().accept(this);        
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerOperationCall(ContainerOperationCall call) {
        call.getContainer().accept(this);
        call.getExpression().accept(this);
        for (int i = 0; i < call.getDeclaratorsCount(); i++) {
            declarations.add(call.getDeclarator(i));
        } 
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundAccess(CompoundAccess access) {
        // access.inferDatatype() must be called before access.getResolvedSlot() can be called 
        try {
            access.inferDatatype();
        } catch (CSTSemanticException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        declarations.add(access.getResolvedSlot());
        access.getCompoundExpression().accept(this);
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitDslFragment(DslFragment fragment) {
        //TODO SE: Unsure whether we need this
    }

    /**
     * {@inheritDoc}
     */
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        // TODO Auto-generated method stub
        
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerInitializer(ContainerInitializer initializer) {
        // TODO Auto-generated method stub
        
    }
}
