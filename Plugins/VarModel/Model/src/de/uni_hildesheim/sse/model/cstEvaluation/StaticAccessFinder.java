package de.uni_hildesheim.sse.model.cstEvaluation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import de.uni_hildesheim.sse.model.cst.Comment;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.CompoundInitializer;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.ContainerInitializer;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.IConstraintTreeVisitor;
import de.uni_hildesheim.sse.model.cst.IfThen;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.cst.Parenthesis;
import de.uni_hildesheim.sse.model.cst.Self;
import de.uni_hildesheim.sse.model.cst.UnresolvedExpression;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.values.MetaTypeValue;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Finds variables with static access in the given expression.
 * 
 * @author Holger Eichelberger
 */
public class StaticAccessFinder implements IConstraintTreeVisitor {

    private Self self = null;
    private Set<AbstractVariable> result = new HashSet<AbstractVariable>();
    private Set<DecisionVariableDeclaration> defined = new HashSet<DecisionVariableDeclaration>();

    /**
     * Returns the static accesses found.
     * 
     * @return the static accesses
     */
    public Iterator<AbstractVariable> getResults() {
        return result.iterator();
    }
    
    /**
     * Returns the "self" instance if used.
     * 
     * @return the self instance of <b>null</b>
     */
    public Self getSelf() {
        return self;
    }
    
    /**
     * Clears this visitor for reuse.
     */
    public void clear() {
        result.clear();
        self = null;
    }
    
    @Override
    public void visitConstantValue(ConstantValue value) {
    }

    @Override
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

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        parenthesis.getExpr().accept(this);
    }

    @Override
    public void visitComment(Comment comment) {
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (null != call.getOperand()) {
            call.getOperand().accept(this);
        }
        for (int p = 0, n = call.getParameterCount(); p < n; p++) {
            call.getParameter(p).accept(this);
        }
    }

    @Override
    public void visitLet(Let let) {
        defined.add(let.getVariable());
        let.getInExpression().accept(this);
        defined.remove(let.getVariable());
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        ifThen.getThenExpr().accept(this);
        if (null != ifThen.getElseExpr()) {
            ifThen.getElseExpr().accept(this);
        }
    }

    @Override
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

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        AbstractVariable decl = access.getResolvedSlot();
        if (!defined.contains(decl)) {
            ConstraintSyntaxTree cEx = access.getCompoundExpression();
            if (cEx instanceof ConstantValue) {
                // qualified compound access
                ConstantValue cValue = (ConstantValue) cEx;
                Value value = cValue.getConstantValue();
                if (value instanceof MetaTypeValue) {
                    result.add(decl);
                }
            }
        }
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        Compound type = initializer.getType();
        for (int i = 0, n = initializer.getExpressionCount(); i < n; i++) {
            String slotName = initializer.getSlot(i);
            DecisionVariableDeclaration decl = type.getElement(slotName);
            if (!ConstraintType.TYPE.isAssignableFrom(decl.getType())) {
                // don't evaluate constraint variables in initializers - deferred (see EvaluationVisitor)
                initializer.getExpression(i).accept(this);
            }
        }
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        if (!Container.isContainer(initializer.getType(), ConstraintType.TYPE)) {
            // dont' evaluate constraint container - deferred (see EvaluationVisitor)
            for (int i = 0, n = initializer.getExpressionCount(); i < n; i++) {
                initializer.getExpression(i).accept(this);
            }
        }
    }

    @Override
    public void visitSelf(Self self) {
        this.self = self;
    }

}
