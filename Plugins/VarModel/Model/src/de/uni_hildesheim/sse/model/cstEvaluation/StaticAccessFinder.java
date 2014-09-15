package de.uni_hildesheim.sse.model.cstEvaluation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import de.uni_hildesheim.sse.model.cst.Comment;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
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
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.values.MetaTypeValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Finds variables with static access in the given expression.
 * 
 * @author Holger Eichelberger
 */
public class StaticAccessFinder implements IConstraintTreeVisitor {

    private Set<DecisionVariableDeclaration> result = new HashSet<DecisionVariableDeclaration>();
    private Set<DecisionVariableDeclaration> defined = new HashSet<DecisionVariableDeclaration>();

    /**
     * Returns the static accesses found.
     * 
     * @return the static accesses
     */
    public Iterator<DecisionVariableDeclaration> getResults() {
        return result.iterator();
    }
    
    /**
     * Clears this visitor for reuse.
     */
    public void clear() {
        result.clear();
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
        AbstractVariable var = variable.getVariable();
        if (!defined.contains(var) && null == variable.getQualifier()) {
            // unqualified compound slot use in constraint in compound
            if (var instanceof DecisionVariableDeclaration) {
                IModelElement par = var.getParent();
                while (null != par && par instanceof AttributeAssignment) {
                    par = par.getParent();
                }
                if (par instanceof Compound) {
                    result.add((DecisionVariableDeclaration) var);
                }
            }
        }
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
    }

    /**
     * {@inheritDoc}
     */
    public void visitOclFeatureCall(OCLFeatureCall call) {
        call.getOperand().accept(this);
        for (int p = 0, n = call.getParameterCount(); p < n; p++) {
            call.getParameter(p).accept(this);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitLet(Let let) {
        defined.add(let.getVariable());
        let.getInExpression().accept(this);
        defined.remove(let.getVariable());
    }

    /**
     * {@inheritDoc}
     */
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        ifThen.getThenExpr().accept(this);
        if (null != ifThen.getElseExpr()) {
            ifThen.getElseExpr().accept(this);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerOperationCall(ContainerOperationCall call) {
        for (int d = 0; d < call.getDeclaratorsCount(); d++) {
            defined.add(call.getDeclarator(d));
        }
        call.getContainer().accept(this);
        call.getExpression().accept(this);
        for (int d = 0; d < call.getDeclaratorsCount(); d++) {
            defined.remove(call.getDeclarator(d));
        }   
    }

    /**
     * {@inheritDoc}
     */
    public void visitCompoundAccess(CompoundAccess access) {
        DecisionVariableDeclaration decl = access.getResolvedSlot();
        if (!defined.contains(decl)) {
            if (access.getCompoundExpression() instanceof ConstantValue) {
                // qualified compound access
                ConstantValue cValue = (ConstantValue) access.getCompoundExpression();
                Value value = cValue.getConstantValue();
                if (value instanceof MetaTypeValue) {
                    result.add(decl);
                }
            }
        }
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

    /**
     * {@inheritDoc}
     */
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        for (int i = 0, n = initializer.getExpressionCount(); i < n; i++) {
            initializer.getExpression(i).accept(this);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void visitContainerInitializer(ContainerInitializer initializer) {
        for (int i = 0, n = initializer.getExpressionCount(); i < n; i++) {
            initializer.getExpression(i).accept(this);
        }
    }

}
