package net.ssehub.easy.reasoning.sseReasoner.model;

import java.util.List;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.reasoning.sseReasoner.Descriptor;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
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
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.ReferenceValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * A visitor to retrieve variables from constraints.
 *
 */
public class VariablesInNotSimpleAssignmentConstraintsFinder implements IConstraintTreeVisitor {

    private Configuration config;
    private VariablesMap constraintMap;
    private Constraint constraint;
    private boolean add = true;
    private EvaluationVisitor evaluator;
    
    /**
     * Creates a visitor instance.
     * 
     * @param constraintMap the constraint map to use for storing results
     */
    public VariablesInNotSimpleAssignmentConstraintsFinder(VariablesMap constraintMap) {
        this.constraintMap = constraintMap;
        evaluator = new EvaluationVisitor();
    }

    /**
     * Accepts and visits a constraint.
     * 
     * @param constraint the constraint to accept
     * @param config the configuration used to resolve expressions
     */
    public void accept(Constraint constraint, Configuration config) {
        this.config = config;
        this.constraint = constraint;
        evaluator.init(config, null, false, null);
        constraint.getConsSyntax().accept(this);
    }

    /**
     * Combines {@link #accept(Constraint, Configuration)} and {@link #clear()}.
     * 
     * @param constraint the constraint to accept
     * @param config the configuration used to resolve expressions
     */
    public void acceptAndClear(Constraint constraint, Configuration config) {
        acceptAndClear(constraint, config, true);
    }

    /**
     * Combines {@link #accept(Constraint, Configuration)} and {@link #clear()}.
     * 
     * @param constraint the constraint to accept
     * @param config the configuration used to resolve expressions
     * @param add add {@code true} or remove {@code false}
     */
    public void acceptAndClear(Constraint constraint, Configuration config, boolean add) {
        this.add = add;
        accept(constraint, config);
        clear();
    }

    /**
     * Combines {@link #accept(Constraint, Configuration)} and {@link #clear()} for an iterable of constraints.
     * 
     * @param constraints the constraints to accept
     * @param config the configuration used to resolve expressions
     * @param add add {@code true} or remove {@code false}
     */
    public void acceptAndClear(List<Constraint> constraints, Configuration config, boolean add) {
        this.add = add;
        this.config = config;
        evaluator.init(config, null, false, null);
        for (int c = 0; c < constraints.size(); c++) {
            this.constraint = constraints.get(c);
            this.constraint.getConsSyntax().accept(this);
        }
        clear();
    }
    
    /**
     * Clears this visitor for reuse.
     */
    public void clear() {
        config = null;
        constraint = null;
        add = true;
        evaluator.clear();
    }
    
    /**
     * Turns this finder into remove mode.
     * 
     * @return <b>this</b>
     */
    public VariablesInNotSimpleAssignmentConstraintsFinder forRemove() {
        add = false;
        return this;
    }

    @Override
    public void visitConstantValue(ConstantValue value) {
        Value constValue = value.getConstantValue();
        if (null != constValue && constValue instanceof ReferenceValue) {
            ReferenceValue rValue = (ReferenceValue) constValue;
            modifyRelation(rValue.getValue(), constraint);
        }
    }

    @Override
    public void visitVariable(Variable variable) {
        modifyRelation(variable.getVariable(), constraint);
    }

    /**
     * Modifies the relationship between {@code variable} and {@code constraint} due to {@link #add}.
     * 
     * @param variable the variable
     * @param constraint the constraint
     */
    private void modifyRelation(AbstractVariable variable, Constraint constraint) {
        if (null != variable) {
            IDecisionVariable var = config.getDecision(variable);
            if (null != var) {
                if (add) {
                    constraintMap.registerConstraint(var, constraint);
                } else {
                    constraintMap.unregisterConstraint(var, constraint);
                }
            }
            if (add) {
                constraintMap.add(variable, constraint);
            } else {
                constraintMap.remove(variable, constraint);
            }
        }
    }
    
    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        ConstraintSyntaxTree qu = variable.getQualifier();
        if (null != qu) {
            qu.accept(this);
        }
        visitVariable(variable);
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
        // Keep running/visiting
        parenthesis.getExpr().accept(this);        
    }

    @Override
    public void visitComment(Comment comment) {
        // Keep running/visiting
        comment.getExpr().accept(this);
    }

    /**
     * Returns whether the type of {@code cst} is a constraint type.
     * 
     * @param cst the constraint syntax tree to look for
     * @return {@code true} for constraint type, {@code false} else
     */
    private boolean isConstraint(ConstraintSyntaxTree cst) {
        boolean result;
        try {
            result = TypeQueries.isConstraint(cst.inferDatatype());
        } catch (CSTSemanticException e) {
            result = false; // shall not occur
        }
        return result;
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        if (null != call.getOperand()) {    
            // user def function returns operand null!
            boolean analyze = true;
            if (call.getParameterCount() == 1 && call.getOperation().equals(OclKeyWords.ASSIGNMENT)) {
                ConstraintSyntaxTree operand = call.getOperand();
                if (operand instanceof Variable || operand instanceof CompoundAccess) {
                    ConstraintSyntaxTree param0 = call.getParameter(0);
                    if (param0 instanceof ConstantValue // don't analyze "constants"
                        || param0 instanceof ContainerInitializer
                        || param0 instanceof CompoundInitializer) {
                        analyze = false; 
                    } else if (isConstraint(operand)) {
                        // we treat constraints on the right hand side as values here
                        // constraint values will be turned into constraints if assigned to variable
                        // then isSimpleAssignment may apply
                        analyze = false; 
                    }
                }
            }
            if (analyze) {
                call.getOperand().accept(this);
                for (int i = 0; i < call.getParameterCount(); i++) {
                    call.getParameter(i).accept(this);
                }
            }
        }
    }
    
    @Override
    public void visitDeferInitExpression(DeferInitExpression expression) {
        expression.getExpression().accept(this);
    }
    
    @Override
    public void visitMultiAndExpression(MultiAndExpression expression) {
        for (int e = 0; e < expression.getExpressionCount(); e++) {
            expression.getExpression(e).accept(this);
        }
    }

    @Override
    public void visitLet(Let let) {
        let.getInExpression().accept(this);
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
        ifThen.getIfExpr().accept(this);
        ifThen.getThenExpr().accept(this);
        ifThen.getElseExpr().accept(this);
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        call.getContainer().accept(this);
        call.getExpression().accept(this);
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        access.getCompoundExpression().accept(this);  
        try {
            access.inferDatatype();
        } catch (CSTSemanticException e) {
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Descriptor.BUNDLE_NAME).exception(e);
        }
        access.accept(evaluator);
        IDecisionVariable var = evaluator.getResultVariable();
        if (null != var) { // do we have a dynamic resolution
            modifyRelation(var.getDeclaration(), constraint);
        } else { // else try a static resolution of the access, we just need the declaration
            try {
                IDatatype cType = Reference.dereference(access.getCompoundExpression().inferDatatype());
                if (cType instanceof Compound) {
                    modifyRelation(((Compound) cType).getElement(access.getSlotName()), constraint);
                }
            } catch (CSTSemanticException e) {
                // no type, no action
            }
        }
        evaluator.clearResult();

    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
        ConstraintSyntaxTree nestedConstraint = expression.getActualExpression();
        if (null != nestedConstraint) {
            nestedConstraint.accept(this);
        }
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer initializer) {
        for (int i = 0; i < initializer.getExpressionCount(); i++) {
            initializer.getExpression(i).accept(this);
        }
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer initializer) {
        for (int i = 0; i < initializer.getExpressionCount(); i++) {
            initializer.getExpression(i).accept(this);
        }
    }

    @Override
    public void visitSelf(Self self) {
        // not needed
    }

    @Override
    public void visitBlockExpression(BlockExpression block) {
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            block.getExpression(e).accept(this);
        }
    }

}
