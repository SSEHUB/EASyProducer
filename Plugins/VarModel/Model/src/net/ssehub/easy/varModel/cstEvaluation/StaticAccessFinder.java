package net.ssehub.easy.varModel.cstEvaluation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.Comment;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.DeferInitExpression;
import net.ssehub.easy.varModel.cst.IConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.IfThen;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.MultiAndExpression;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.UnresolvedExpression;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.values.MetaTypeValue;
import net.ssehub.easy.varModel.model.values.Value;

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
    public void visitDeferInitExpression(DeferInitExpression expression) {
        expression.getExpression().accept(this);
    }

    @Override
    public void visitMultiAndExpression(MultiAndExpression expression) {
        for (int e = 0, n = expression.getExpressionCount(); e < n; e++) {
            expression.getExpression(e).accept(this);
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

    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        // TODO check whether a specific method is needed
        visitVariable(variable);
    }

    @Override
    public void visitBlockExpression(BlockExpression block) {
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            block.getExpression(e).accept(this);
        }
    }

}
