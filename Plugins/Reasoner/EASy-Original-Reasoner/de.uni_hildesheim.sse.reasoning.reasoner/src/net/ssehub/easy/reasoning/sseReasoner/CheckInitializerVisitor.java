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

import net.ssehub.easy.reasoning.sseReasoner.model.ContainerConstraintsFinder;
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
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.values.BooleanValue;
import net.ssehub.easy.varModel.model.values.CompoundValue;
import net.ssehub.easy.varModel.model.values.ConstraintValue;
import net.ssehub.easy.varModel.model.values.ContainerValue;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueVisitorAdapter;

/**
 * Visits initializers and checks for contained constraints for constraint variables. Call 
 * {@link #accept(ContainerConstraintsFinder, IModelElement, IDecisionVariable)} to use.
 * This visitor is inherently reusable as instance.
 * 
 * @author Holger Eichelberger
 */
class CheckInitializerVisitor extends ValueVisitorAdapter implements IConstraintTreeVisitor {

    private Resolver resolver;
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
     * @param finder the finder instance
     * @param parent parent for temporary constraints
     * @param variable the actually (nested) variable, used to relate the created constraint to, may be <b>null</b>
     */
    public void accept(ContainerConstraintsFinder finder, IModelElement parent, IDecisionVariable variable) {

        // save state for recurrence
        IDecisionVariable sVariable = this.variable;
        IModelElement sParent = this.parent;
        boolean sSubstituteVars = this.substituteVars;
        
        // set state and visit
        this.parent = parent;
        this.variable = variable;
        if (null != finder.getExpression()) {
            substituteVars = finder.isCompoundInitializer();
            finder.getExpression().accept(this);
        } else if (null != finder.getConstantValue()) {
            substituteVars = false;
            finder.getConstantValue().accept(this);
        }
        
        // reset state for recurrence
        variable = sVariable;
        parent = sParent;
        substituteVars = sSubstituteVars;
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
            checkForConstraint(compoundInit.getSlotDeclaration(i).getType(), initEx);
        }
    }

    @Override
    public void visitContainerInitializer(ContainerInitializer containerInit) {
        for (int i = 0; i < containerInit.getExpressionCount(); i++) {
            ConstraintSyntaxTree cst = containerInit.getExpression(i);
            cst.accept(this);
            checkForConstraint(containerInit.getType().getContainedType(), cst);
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
    }

    @Override
    public void visitParenthesis(Parenthesis parenthesis) {
    }

    @Override
    public void visitComment(Comment comment) {
    }

    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
    }

    @Override
    public void visitLet(Let let) {
    }

    @Override
    public void visitIfThen(IfThen ifThen) {
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
    }

    @Override
    public void visitUnresolvedExpression(UnresolvedExpression expression) {
    }

    @Override
    public void visitSelf(Self self) {
    }

    @Override
    public void visitBlockExpression(BlockExpression block) {
    }

    @Override
    public void visitMultiAndExpression(MultiAndExpression expression) {
    }
    
}
