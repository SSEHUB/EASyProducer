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

/**
 * Extended measurement statistics visitor calculating the average complexity of constraint expressions.
 * 
 * @author Holger Eichelberger
 */
class MeasurementStatisticsVistor extends DefaultConfigurationStatisticsVisitor {

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

    }

    /**
     * Calculates the complexity of a constraint. Currently, just a kind of McCabe without any empirical justification.
     * Initializers are maximized over contained complexities, constants are counted just by 1.
     * 
     * @author Holger Eichelberger
     */
    private static class ComplexityVisitor extends AbstractConstraintTreeVisitor {

        private static final double CONSTANT_COMPLEXITY = 0;
        private static final double ACCESSOR_COMPLEXITY = 0;
        private static final double OP_COMPLEXITY = 0;
        private static final double CONTAINER_COMPLEXITY = 4;
        private static final double VAR_COMPLEXITY = 1;
        private static final double OP_OPERAND_COMPLEXITY = 0; // factor
        private static final double OP_PARAM_COMPLEXITY = 1; // factor
        private double complexity = 0;
        
        /**
         * Returns the complexity of the visited constraint and clears the visitor.
         * 
         * @return the complexity
         */
        private double getComplexityAndClear() {
            double result = Math.max(1, complexity); // 1 as constants do not count
            complexity = 0;
            return result;
        }
        
        @Override
        public void visitVariable(Variable variable) {
            complexity += VAR_COMPLEXITY;
            super.visitVariable(variable);
        }

        @Override
        public void visitConstantValue(ConstantValue value) {
            complexity += CONSTANT_COMPLEXITY;
            super.visitConstantValue(value);
        }

        @Override
        public void visitParenthesis(Parenthesis parenthesis) {
            // currently just sum of contained expressions
            super.visitParenthesis(parenthesis);
        }
        
        @Override
        public void visitOclFeatureCall(OCLFeatureCall call) {
            complexity += OP_COMPLEXITY;
            complexity += (null != call.getOperand()) ? OP_OPERAND_COMPLEXITY : 0;
            complexity += OP_PARAM_COMPLEXITY * call.getParameterCount();
            super.visitOclFeatureCall(call);
        }
        
        @Override
        public void visitMultiAndExpression(MultiAndExpression expression) {
            complexity += OP_PARAM_COMPLEXITY * expression.getExpressionCount();
            super.visitMultiAndExpression(expression);
        }
        
        @Override
        public void visitContainerOperationCall(ContainerOperationCall call) {
            complexity += CONTAINER_COMPLEXITY;
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
            complexity += ACCESSOR_COMPLEXITY;
            super.visitCompoundAccess(access);
        }

        @Override
        public void visitCompoundInitializer(CompoundInitializer initializer) {
            double max = 0;
            for (int e = 0; e < initializer.getExpressionCount(); e++) {
                initializer.getExpression(e).accept(this);
                max = Math.max(max, complexity);
                complexity = 0;
            }
            complexity = max;
        }

        @Override
        public void visitContainerInitializer(ContainerInitializer initializer) {
            double max = 0;
            for (int e = 0; e < initializer.getExpressionCount(); e++) {
                initializer.getExpression(e).accept(this);
                max = Math.max(max, complexity);
                complexity = 0;
            }
            complexity = max;
        }
        
        @Override
        public void visitSelf(Self self) {
            complexity += CONSTANT_COMPLEXITY;
            // currently nothing specific
            super.visitSelf(self);
        }

        @Override
        public void visitAnnotationVariable(AttributeVariable variable) {
            complexity += ACCESSOR_COMPLEXITY;
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
    public MeasurementStatisticsVistor() {
        this(new MeasurementStatistics());
    }
    
    /**
     * Creates a statistics visitor with given statistics object (for extension, overriding).
     * 
     * @param statistics A data object to store the statistical information.
     */
    protected MeasurementStatisticsVistor(MeasurementStatistics statistics) {
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
    
}
