/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.sseReasoner;

import static net.ssehub.easy.reasoning.sseReasoner.model.ReasoningUtils.getConstraintValueConstraintExpression;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.Comment;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.IConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.IfThen;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.MultiAndExpression;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.UnresolvedExpression;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ConstraintValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueVisitorAdapter;

/**
 * Visits constraints and checks for contained constraints for constraint variables. Call 
 * {@link #accept(ContainerConstraintsFinder, IModelElement, IDecisionVariable)} to use.
 * This visitor is inherently reusable as instance.
 * 
 * @author Holger Eichelberger
 */
class CheckInitializerVisitor extends ValueVisitorAdapter implements IConstraintTreeVisitor {

    private Resolver resolver;
    
    // analyze/scan variables (process = false), do not access during processing due to potential recursion
    private boolean isCompoundInitializer;
    private ConstraintSyntaxTree expression;
    private Value value;

    private boolean process;

    // process variables, set/valid only when processing (process = true)
    private IDecisionVariable variable;
    private IModelElement parent;
    private boolean substituteVars;

    /**
     * Creates the visitor.
     * 
     * @param resolver the resolver instance to use for transforming and adding constraints
     */
    public CheckInitializerVisitor(Resolver resolver) {
        this.resolver = resolver;
    }
    
    /**
     * Accepts the results of a container constraints finder and derives constraints from the 
     * contained constraints / constraint values.
     * 
     * @param cst the constraint to accept / visit
     * @param parent parent for temporary constraints
     * @param variable the actually (nested) variable, used to relate the created constraint to, may be <b>null</b>
     */
    public void accept(ConstraintSyntaxTree cst, IModelElement parent, IDecisionVariable variable) {
        process = false;
        cst.accept(this);           
        
        // save state for recurrence
        IDecisionVariable sVariable = this.variable;
        IModelElement sParent = this.parent;
        boolean sSubstituteVars = this.substituteVars;
        
        
        // set state and visit
        process = true;
        this.parent = parent;
        this.variable = variable;
        if (null != expression) {
            substituteVars = isCompoundInitializer;
            expression.accept(this);
        } else if (null != value) {
            substituteVars = false;
            value.accept(this);
        }
        
        // reset state for recurrence
        variable = sVariable;
        parent = sParent;
        substituteVars = sSubstituteVars;

        // clear
        isCompoundInitializer = false;
        expression = null;
        value = null;
    }
    
    @Override
    public void visitCompoundValue(CompoundValue value) {
        Compound cmp = (Compound) value.getType();
        for (String slot : value.getSlotNames()) {
            Value slotValue = value.getNestedValue(slot);
            if (null != slotValue) {
                DecisionVariableDeclaration slotDecl = cmp.getElement(slot);
                IDatatype slotType = slotDecl.getType();
                if (TypeQueries.isContainer(slotType)) {
                    slotValue.accept(this);
                } else if (TypeQueries.isConstraint(slotType)) {
                    createConstraintFromValue(slotValue);
                }
            }
        }
    }

    @Override
    public void visitContainerValue(ContainerValue value) {
        if (TypeQueries.isConstraint(value.getContainedType())) {
            for (int s = 0; s < value.getElementSize(); s++) {
                createConstraintFromValue(value.getElement(s));
            }
            
        } else {
            for (int s = 0; s < value.getElementSize(); s++) {
                value.getElement(s).accept(this);
            }
        }
    }
    
    @Override
    public void visitConstraintValue(ConstraintValue value) {
    }
    
    @Override
    public void visitBooleanValue(BooleanValue value) {
    }
    
    /**
     * Creates a constraint from a value.
     * 
     * @param value the value
     */
    private void createConstraintFromValue(Value value) {
        ConstraintSyntaxTree cst = getConstraintValueConstraintExpression(value);
        // no substitution/self as all entries are constant
        if (null != cst) {
            resolver.createConstraintVariableConstraint(cst, null, null, parent, null);
        }
    }

    @Override
    public void visitCompoundInitializer(CompoundInitializer compoundInit) {
        for (int i = 0; i < compoundInit.getExpressionCount(); i++) {
            ConstraintSyntaxTree initEx = compoundInit.getExpression(i);
            initEx.accept(this);
            if (process) {
                checkForConstraint(compoundInit.getSlotDeclaration(i).getType(), initEx);
            }
        }
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer containerInit) {
        for (int i = 0; i < containerInit.getExpressionCount(); i++) {
            ConstraintSyntaxTree cst = containerInit.getExpression(i);
            cst.accept(this);
            if (process) {
                checkForConstraint(containerInit.getType().getContainedType(), cst);
            }
        }
    }

    /**
     * Checks for a constraint expression. Considers {@link #substituteVars}.
     * 
     * @param type the actual data type
     * @param cst the constraint expression
     */
    private void checkForConstraint(IDatatype type, ConstraintSyntaxTree cst) {
        if (TypeQueries.isConstraint(type)) {
            if (substituteVars) {
                cst = resolver.substituteVariables(cst, null, null);
            }
            resolver.createConstraintVariableConstraint(cst, null, false, parent, variable);
        }
    }

    // not needed
    
    @Override
    public void visitConstantValue(ConstantValue value) {
    }

    @Override
    public void visitVariable(Variable variable) {
    }

    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        visitVariable(variable);
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
            if ((call.getOperand() instanceof Variable
                || call.getOperand() instanceof CompoundAccess)
                && call.getParameterCount() == 1
                && call.getOperation().equals(OclKeyWords.ASSIGNMENT)) {
                ConstraintSyntaxTree param0 = call.getParameter(0);
                if (param0 instanceof ContainerInitializer) {
                    expression = call.getParameter(0);                    
                } else if (param0 instanceof CompoundInitializer) {
                    isCompoundInitializer = true;
                    expression = call.getParameter(0);                     
                } else if (param0 instanceof ConstantValue) {
                    value = ((ConstantValue) param0).getConstantValue();
                }
            }
            call.getOperand().accept(this);
            for (int i = 0; i < call.getParameterCount(); i++) {
                call.getParameter(i).accept(this);
            }
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
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
    }

    @Override
    public void visitSelf(Self self) {
    }

    @Override
    public void visitBlockExpression(BlockExpression block) {
        for (int e = 0, n = block.getExpressionCount(); e < n; e++) {
            block.getExpression(e).accept(this);
        }
    }

    @Override
    public void visitMultiAndExpression(MultiAndExpression expression) {
        for (int e = 0; e < expression.getExpressionCount(); e++) {
            expression.getExpression(e).accept(this);
        }
    }
    
}
