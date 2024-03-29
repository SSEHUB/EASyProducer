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
package net.ssehub.easy.varModel.varModel.testSupport;

import net.ssehub.easy.varModel.confModel.DefaultConfigurationStatisticsVisitor;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.AbstractConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.BlockExpression;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.CompoundInitializer;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerInitializer;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.IfThen;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.MultiAndExpression;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Parenthesis;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Extended measurement statistics visitor calculating the average complexity of constraint expressions.
 * 
 * @author Holger Eichelberger
 */
class MeasurementStatisticsVisitor extends DefaultConfigurationStatisticsVisitor {

    private static final double EXPR_CONSTANT_COMPLEXITY = 0.25;
    private static final double EXPR_ACCESSOR_COMPLEXITY = 1;
    private static final double EXPR_OP_COMPLEXITY = 0;
    private static final double EXPR_CONTAINER_COMPLEXITY = 5;
    private static final double EXPR_VAR_COMPLEXITY = 0.25;

    private static final double TYPE_VARIABLE_COMPLEXITY = 1;
    private static final double TYPE_COMPOUND_COMPLEXITY = 2;
    private static final double TYPE_CONTAINER_COMPLEXITY = 2;

    /**
     * Extended measurement statistics.
     * 
     * @author Holger Eichelberger
     */
    public static class MeasurementStatistics extends ConfigStatistics {
        
        /**
         * All variables (non constraint variables + constraint variables), without nested variables.
         */
        private double constraintComplexitySum = 0;
        private int constraintComplexityCount = 0;
        private double variableComplexitySum = 0;
        private int variableComplexityCount = 0;
        
        /**
         * Returns the average constraint complexity.
         * 
         * @return the average constraint complexity
         */
        public double getAverageConstraintComplexity() {
            return 0 == constraintComplexityCount ? 0 : (constraintComplexitySum / constraintComplexityCount);
        }

        /**
         * Returns the model constraint complexity (sum of all constraints).
         * 
         * @return the model constraint complexity  (sum of all constraints)
         */
        public double getConstraintComplexity() {
            return constraintComplexitySum;
        }

        /**
         * Returns the average model variable complexity (sum of all variables).
         * 
         * @return the average model variable complexity  (sum of all variables)
         */
        public double getAverageVariableComplexity() {
            return 0 == variableComplexityCount ? 0 : variableComplexitySum / variableComplexityCount;
        }

        /**
         * Returns the model variable complexity (sum of all variables).
         * 
         * @return the model variable complexity  (sum of all variables)
         */
        public double getVariableComplexity() {
            return variableComplexitySum;
        }
        
        /**
         * Returns the model complexity as sum of {@link #getVariableComplexity()} and {@link #getModelComplexity()}.
         * 
         * @return the model complexity
         */
        public double getModelComplexity() {
            return variableComplexitySum + constraintComplexitySum;
        }

    }

    /**
     * Calculates the complexity of a constraint. Currently, just a kind of McCabe without any empirical justification.
     * Initializers are maximized over contained complexities, constants are counted just by 1.
     * 
     * @author Holger Eichelberger
     */
    private static class ComplexityVisitor extends AbstractConstraintTreeVisitor {

        private double complexity = 0;
        
        /**
         * Returns the complexity of the visited constraint and clears the visitor.
         * 
         * @return the complexity
         */
        private double getComplexityAndClear() {
            double result = complexity;
            complexity = 0;
            return result;
        }
        
        @Override
        public void visitVariable(Variable variable) {
            complexity += EXPR_VAR_COMPLEXITY;
            super.visitVariable(variable);
        }

        @Override
        public void visitConstantValue(ConstantValue value) {
            complexity += EXPR_CONSTANT_COMPLEXITY;
            super.visitConstantValue(value);
        }

        @Override
        public void visitParenthesis(Parenthesis parenthesis) {
            // currently just sum of contained expressions
            super.visitParenthesis(parenthesis);
        }
        
        @Override
        public void visitOclFeatureCall(OCLFeatureCall call) {
            complexity += EXPR_OP_COMPLEXITY;
            super.visitOclFeatureCall(call);
        }
        
        @Override
        public void visitMultiAndExpression(MultiAndExpression expression) {
            // currently just sum of contained expressions
            super.visitMultiAndExpression(expression);
        }
        
        @Override
        public void visitContainerOperationCall(ContainerOperationCall call) {
            complexity += EXPR_CONTAINER_COMPLEXITY;
            super.visitContainerOperationCall(call);
        }

        @Override
        public void visitLet(Let let) {
            // currently just sum of contained expressions
            super.visitLet(let);
        }

        @Override
        public void visitIfThen(IfThen ifThen) {
            // currently just sum of contained expressions
            super.visitIfThen(ifThen);
        }

        @Override
        public void visitCompoundAccess(CompoundAccess access) {
            complexity += EXPR_ACCESSOR_COMPLEXITY;
            super.visitCompoundAccess(access);
        }

        @Override
        public void visitCompoundInitializer(CompoundInitializer initializer) {
            // currently just sum of contained expressions
            super.visitCompoundInitializer(initializer);
        }

        @Override
        public void visitContainerInitializer(ContainerInitializer initializer) {
            // currently just sum of contained expressions
            super.visitContainerInitializer(initializer);
        }
        
        @Override
        public void visitSelf(Self self) {
            complexity += EXPR_CONSTANT_COMPLEXITY;
            // currently nothing specific
            super.visitSelf(self);
        }

        @Override
        public void visitAnnotationVariable(AttributeVariable variable) {
            complexity += EXPR_ACCESSOR_COMPLEXITY;
            super.visitAnnotationVariable(variable);
        }

        @Override
        public void visitBlockExpression(BlockExpression block) {
            // currently just sum of contained expressions
            super.visitBlockExpression(block);
        }
        
    };

    private MeasurementStatistics statistics;
    private ComplexityVisitor complexityVisitor = new ComplexityVisitor();
    
    /**
     * Creates an instance with a statistics object of type {@link MeasurementStatistics}.
     */
    public MeasurementStatisticsVisitor() {
        this(new MeasurementStatistics());
    }
    
    /**
     * Creates a statistics visitor with given statistics object (for extension, overriding).
     * 
     * @param statistics A data object to store the statistical information.
     */
    protected MeasurementStatisticsVisitor(MeasurementStatistics statistics) {
        super(statistics);
        this.statistics = statistics;
    }

    @Override
    public MeasurementStatistics getStatistics() {
        return statistics; // could be avoided if parent type would be parameterized
    }
    
    @Override
    protected void visitConstraint(Constraint constraint) {
        processConstraintSyntaxTree(constraint.getConsSyntax());
    }

    @Override
    protected void visitDefaultValue(ConstraintSyntaxTree constraint) {
        processConstraintSyntaxTree(constraint);
    }

    @Override
    protected void visitOperationDefinition(OperationDefinition opdef) {
        processConstraintSyntaxTree(opdef.getOperation().getFunction());
    }

    /**
     * Processes a constraint syntax tree.
     * 
     * @param cst the constraint syntax tree, may be <b>null</b>
     */
    private void processConstraintSyntaxTree(ConstraintSyntaxTree cst) {
        if (null != cst) {
            cst.accept(complexityVisitor);
            double tmp = complexityVisitor.getComplexityAndClear();
            statistics.constraintComplexitySum += tmp;
            statistics.constraintComplexityCount++;
        }
    }
    
    @Override
    public void visitVariable(IDecisionVariable variable, boolean nestedInContainer) {
        super.visitVariable(variable, nestedInContainer);
        IDatatype type = variable.getDeclaration().getType();
        if (Compound.TYPE.isAssignableFrom(type)) {
            statistics.variableComplexitySum += TYPE_COMPOUND_COMPLEXITY; 
        } else if (Container.TYPE.isAssignableFrom(type)) {
            statistics.variableComplexitySum += TYPE_CONTAINER_COMPLEXITY; 
        } else {
            statistics.variableComplexitySum += TYPE_VARIABLE_COMPLEXITY; 
        }
        statistics.variableComplexityCount++;
    }
    
}
