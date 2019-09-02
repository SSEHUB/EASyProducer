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
package net.ssehub.easy.reasoning.sseReasoner.functions;

import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.reasoning.sseReasoner.Descriptor;
import net.ssehub.easy.reasoning.sseReasoner.functions.AbstractConstraintProcessor.ExpressionType;
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
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatypeVisitor;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;
import net.ssehub.easy.varModel.model.datatypes.VersionType;
import net.ssehub.easy.varModel.model.filter.ConstraintFinder;

/**
 * Generic constraint functions based on the {@link AbstractConstraintProcessor}.
 * 
 * @author Holger Eichelberger
 */
public class ConstraintFunctions {

    /**
     * Processes all constraints relevant to the given {@link Compound}.
     * 
     * @param cmpType Compound to be processed.
     * @param processor The constraint processor functor.
     * @param includeConstraintVariables <code>true</code> whether constraint variables shall be included.
     * @param includeDefaults <code>true</code> whether default value expressions shall be included.
     * @param parent the intended parent for constraints, typically the containing project
     */
    public static void allCompoundConstraints(Compound cmpType, AbstractConstraintProcessor processor, 
        boolean includeConstraintVariables, boolean includeDefaults, IModelElement parent) {
        if (!processor.getContextStack().isTypeExcluded(cmpType)) {
            for (int c = 0; c < cmpType.getConstraintsCount(); c++) {
                processor.process(cmpType.getConstraint(c), ExpressionType.CONSTRAINT);
            }
            if (includeConstraintVariables || includeDefaults) {
                for (int i = 0; i < cmpType.getElementCount(); i++) {
                    DecisionVariableDeclaration decl = cmpType.getElement(i);
                    ConstraintSyntaxTree defaultValue = decl.getDefaultValue();
                    if (null != defaultValue) {
                        if (includeConstraintVariables && TypeQueries.isConstraint(decl.getType())) {
                            processor.process(defaultValue, ExpressionType.CONSTRAINT_VALUE, decl.getName(), parent);
                        } else if (includeDefaults) {
                            processor.process(defaultValue, ExpressionType.DEFAULT, decl.getName(), parent);
                        }
                    }
                    for (int a = 0, n = decl.getAttributesCount(); includeDefaults && a < n; a++) {
                        Attribute attr = decl.getAttribute(a);
                        defaultValue = attr.getDefaultValue();
                        if (null != defaultValue) {
                            processor.process(defaultValue, ExpressionType.ANNOTATION_DEFAULT, attr.getName(), parent);
                        }
                    }
                }
            }
            for (int r = 0; r < cmpType.getRefinesCount(); r++) {
                allCompoundConstraints(cmpType.getRefines(r), processor, includeConstraintVariables, 
                    includeDefaults, parent);
            }
            for (int a = 0; a < cmpType.getAssignmentCount(); a++) {
                allAssignmentConstraints(cmpType.getAssignment(a), processor);
            }
        }
    }
    
    /**
     * Processes all assignment constraints.
     * 
     * @param assng the assignment constraint
     * @param processor the constraint processor for assignment constraints
     */
    public static void allAssignmentConstraints(AttributeAssignment assng, AbstractConstraintProcessor processor) {
        for (int c = 0; c < assng.getConstraintsCount(); c++) {
            processor.process(assng.getConstraint(c), ExpressionType.ASSIGNMENT_CONSTRAINT);
        }
        for (int a = 0; a < assng.getAssignmentCount(); a++) {
            allAssignmentConstraints(assng.getAssignment(a), processor);
        }
    }
    
    /**
     * A transitive constraint/variables finder.
     * 
     * @author Holger Eichelberger
     */
    private static class TransitiveConstraintFinder extends ConstraintFinder implements IConstraintTreeVisitor, 
        IDatatypeVisitor {
        
        private boolean add;
        private Set<AbstractVariable> variables = new HashSet<AbstractVariable>();
        private Set<AbstractVariable> scheduled = new HashSet<AbstractVariable>();
        private Set<AbstractVariable> candidates = new HashSet<AbstractVariable>();
        private Set<Object> done = new HashSet<Object>();
        private Project scope;
        private Project target;
        private IModelVisitor mVisitor;

        /**
         * Creates a finder with search scope and target project.
         * 
         * @param scope the scope
         * @param target the target project
         */
        public TransitiveConstraintFinder(Project scope, Project target) {
            super(scope);
            this.scope = scope;
            this.target = target;
            mVisitor = this;
        }
        
        @Override
        protected void startAccept(Project project) {
            // override, do nothing; allow for further init in constructor
        }

        /**
         * Call for the top-level variable to be visited.
         * 
         * @param var the variable
         */
        public void visit(AbstractVariable var) {
            addToVariables(var);
            scope.accept(this);
            while (!scheduled.isEmpty()) {
                boolean visitAgain = false;
                for (AbstractVariable v : scheduled) {
                    if (!variables.contains(v)) {
                        addToVariables(var);
                        // TODO duplicate variables, mock the target imports
                        target.add(v);
                        visitAgain = true;
                    }
                }
                scheduled.clear();
                if (visitAgain) {
                    scope.accept(this);
                }
            }
        }

        /**
         * Internal method to start visiting a datatype. Due to additional checks,
         * please do not visit the type directly.
         * 
         * @param type the type to be visited
         */
        private void visit(IDatatype type) {
            if (null != type && !done.contains(type)) {
                done.add(type);
                type.accept(this);
            }
        }
        
        /**
         * Adds a variable to {@link #variables}.
         * 
         * @param var the variable
         */
        private void addToVariables(AbstractVariable var) {
            variables.add(var);
            var.accept(mVisitor);
        }
        
        @Override
        public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
            visit(decl.getType());
            if (null != decl.getDefaultValue()) {
                int size = candidates.size();
                decl.getDefaultValue().accept(this);
                if (candidates.size() > size) { // add does not work here, default expression
                    scheduled.addAll(candidates);
                    candidates.clear();
                }
            }
        }
        
        @Override
        public void visitConstraint(Constraint constraint) {
            add = false;
            constraint.getConsSyntax().accept(this);
            if (add) {
                target.addConstraint(constraint);
                scheduled.addAll(candidates);
                candidates.clear();
            }
        }
        
        @Override
        public void visitProject(Project project) {
            Project old = target;
            String pName = project.getName();
            for (int i = 0; old == target && i < old.getImportsCount(); i++) {
                ProjectImport imp = old.getImport(i);
                if (imp.getName().equals(pName) && null != imp.getResolved()) {
                    target = imp.getResolved();
                }
            }
            if (old == target) {
                target = new Project(pName);
                ProjectImport imp = new ProjectImport(pName);
                try {
                    imp.setResolved(target);
                    old.addImport(imp);
                } catch (ModelManagementException e) {
                    EASyLoggerFactory.INSTANCE.getLogger(getClass(), Descriptor.BUNDLE_NAME);
                }
            }
            super.visitProject(project);
        }

        @Override
        public void visitConstantValue(ConstantValue value) {
        }
        
        /**
         * Handles the occurrence of a variable.
         * 
         * @param variable the variable
         */
        private void handle(AbstractVariable variable) {
            boolean found = variables.contains(variable);
            if (!found) {
                candidates.add(variable);
            }
            add |= found;
        }

        @Override
        public void visitVariable(Variable variable) {
            handle(variable.getVariable());
        }

        @Override
        public void visitAnnotationVariable(AttributeVariable variable) {
            handle(variable.getVariable());
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
            for (int p = 0; p < call.getParameterCount(); p++) {
                call.getParameter(p).accept(this);
            }
        }

        @Override
        public void visitLet(Let let) {
            let.getInExpression().accept(this);
        }

        @Override
        public void visitIfThen(IfThen ifThen) {
            ifThen.getIfExpr().accept(this);
            if (null != ifThen.getElseExpr()) {
                ifThen.getElseExpr().accept(this);
            }
        }

        @Override
        public void visitContainerOperationCall(ContainerOperationCall call) {
            call.getExpression().accept(this);
        }

        @Override
        public void visitCompoundAccess(CompoundAccess access) {
            if (null != access.getResolvedSlot()) {
                access.getResolvedSlot().accept(mVisitor);
            }
        }

        @Override
        public void visitUnresolvedExpression(UnresolvedExpression expression) {
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
        public void visitSelf(Self self) {
        }

        @Override
        public void visitBlockExpression(BlockExpression block) {
            for (int e = 0; e < block.getExpressionCount(); e++) {
                block.getExpression(e).accept(this);
            }
        }

        @Override
        public void visitMultiAndExpression(MultiAndExpression expression) {
            for (int e = 0; e < expression.getExpressionCount(); e++) {
                expression.getExpression(e).accept(this);
            }
        }

        @Override
        public void visitDatatype(IDatatype datatype) {
        }

        @Override
        public void visitAnyType(AnyType datatype) {
        }

        @Override
        public void visitMetaType(MetaType datatype) {
        }

        @Override
        public void visitDerivedType(DerivedDatatype datatype) {
            datatype.getBasisType().accept(this);
        }

        @Override
        public void visitBooleanType(BooleanType type) {
        }

        @Override
        public void visitStringType(StringType type) {
        }

        @Override
        public void visitConstraintType(ConstraintType type) {
        }

        @Override
        public void visitIntegerType(IntegerType type) {
        }

        @Override
        public void visitVersionType(VersionType type) {
        }

        @Override
        public void visitRealType(RealType type) {
        }

        @Override
        public void visitCompoundType(Compound compound) {
            for (int e = 0; e < compound.getElementCount(); e++) {
                compound.getElement(e).accept(mVisitor); 
            }
            for (int a = 0; a < compound.getAssignmentCount(); a++) {
                compound.getAssignment(a).accept(mVisitor);
            }
        }
        
        @Override
        public void visitAttributeAssignment(AttributeAssignment assignment) {
            for (int e = 0; e < assignment.getElementCount(); e++) {
                assignment.getElement(e).accept(mVisitor);
            }
            super.visitAttributeAssignment(assignment);
        }
        
        @Override
        public void visitSet(net.ssehub.easy.varModel.model.datatypes.Set set) {
            for (int g = 0; g < set.getGenericTypeCount(); g++) {
                set.getGenericType(g).accept(this);
            }
        }

        @Override
        public void visitSequence(Sequence sequence) {
            for (int g = 0; g < sequence.getGenericTypeCount(); g++) {
                sequence.getGenericType(g).accept(this);
            }
        }

        @Override
        public void visitEnumType(Enum enumType) {
        }

        @Override
        public void visitOrderedEnumType(OrderedEnum enumType) {
        }

    }
    
    /**
     * Adds constraints related to {@code var} and transitively related constraints and variables
     * in {@code scope} to {@code target} although the parent relationships of the added variables/constraints
     * are then not correct. This method is intended for creating temporary projects/configurations.
     * 
     * @param var the variable used as starting point for the transitive search
     * @param scope the search scope including imports
     * @param target the target project to add the elements to
     */
    public static void addConstraintsToProject(AbstractVariable var, Project scope, Project target) {
        new TransitiveConstraintFinder(scope, target).visit(var);
    }

}
