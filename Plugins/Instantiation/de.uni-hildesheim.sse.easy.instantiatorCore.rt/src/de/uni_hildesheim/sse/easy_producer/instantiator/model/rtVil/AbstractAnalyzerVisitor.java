/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasoningResult;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationAccessor;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.IntValue;
import net.ssehub.easy.varModel.model.values.RealValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Extends the evaluation visitor to do some simple constraint deviation analyses.
 * 
 * @param <V> the type capturing a constraint violation
 * @author Holger Eichelberger
 */
public abstract class AbstractAnalyzerVisitor<V> extends EvaluationVisitor {

    private static Set<String> oclOp1ParamDeviation = new HashSet<String>();

    private List<IDecisionVariable> relevant = new ArrayList<IDecisionVariable>();
    private List<V> violating = new ArrayList<V>();
    private boolean allowUpdateRelevant = false;
    
    static {
        oclOp1ParamDeviation.add(OclKeyWords.LESS);
        oclOp1ParamDeviation.add(OclKeyWords.LESS_EQUALS);
        oclOp1ParamDeviation.add(OclKeyWords.GREATER);
        oclOp1ParamDeviation.add(OclKeyWords.GREATER_EQUALS);
        oclOp1ParamDeviation.add(OclKeyWords.EQUALS);
    }
    
    /**
     * Creates a violating instance.
     * 
     * @param var the variable causing the violation
     * @param operation the operation causing the violation (may be <b>null</b> if unknown)
     * @param deviation the deviation from the expected value (may be negative/positive, may be <b>null</b> if unknown)
     * @param deviationPercentage the deviation in percent (may be negative/positive, may be NaN, may be <b>null</b> if 
     *     unknown)
     * @return the violating instance (may be <b>null</b> if none shall be recorded)
     */
    protected abstract V createViolationInstance(IDecisionVariable var, String operation, Double deviation, 
        Double deviationPercentage);
    
    @Override
    public void clearResult() {
        super.clearResult();
        relevant.clear();
        violating.clear();
    }
    
    /**
     * Returns the violating clauses.
     * 
     * @return the violating clauses (copy of list)
     */
    public List<V> getViolatingClauses() {
        List<V> result = new ArrayList<V>();
        if (violating.isEmpty()) {
            Set<IDecisionVariable> tmp = new HashSet<IDecisionVariable>();
            tmp.addAll(relevant);
            for (IDecisionVariable var : tmp) {
                addViolatingInstance(createViolationInstance(var, null, null, null));
            }
        } 
        result.addAll(violating);
        return result;
    }
    
    @Override
    public void visitOclFeatureCall(OCLFeatureCall call) {
        super.visitOclFeatureCall(call);

        EvaluationAccessor operand = null;
        EvaluationAccessor[] parameter = new EvaluationAccessor[call.getParameterCount()];
        int startRelSize = relevant.size();
        allowUpdateRelevant = true;
        if (null != call.getOperand()) {
            call.getOperand().accept(this);
            operand = getResultAccessor(true);
        }
        int opRelSize = relevant.size();
        for (int p = 0; p < call.getParameterCount(); p++) {
            call.getParameter(p).accept(this);
            parameter[p] = getResultAccessor(true);
        }
        allowUpdateRelevant = false;
        ConstraintSyntaxTree[] cst = getFailedExpression();
        // this is just a very limited form of analysis - just for the beginning
        if (null != cst && contains(cst, call) && 1 == parameter.length) {
            int startIndex;
            int endIndex;
            boolean operandRelevant;
            if (startRelSize < opRelSize) {
                operandRelevant = true; // there was a relevant variable while evaluating operand
                startIndex = startRelSize;
                endIndex = opRelSize - 1;
            } else {
                operandRelevant = false;
                startIndex = opRelSize;
                endIndex = relevant.size() - 1;
            }
            Double op = toDouble(operand);
            Double param = toDouble(parameter[0]);
            Double deviation = null;
            Double deviationPercentage = null;
            String opName = call.getOperation();
            if (null != op && null != param) {
                if (oclOp1ParamDeviation.contains(opName)) {
                    if (operandRelevant) { 
                        deviation = param - op;
                        deviationPercentage = deviation / op;
                    } else {
                        deviation = op - param;
                        deviationPercentage = deviation / param;
                    }
                }
            }
            for (int r = startIndex; r <= endIndex; r++) {
                IDecisionVariable var = relevant.get(r);
                addViolatingInstance(createViolationInstance(var, opName, deviation, deviationPercentage));
            }
        }
        release(operand);
        for (int p = 0; p < parameter.length; p++) {
            release(parameter[p]);
        }
    }
    
    /**
     * Adds a violating instance to {@link #violating}.
     * 
     * @param instance the instance (may be <b>null</b>, ignored then)
     */
    private void addViolatingInstance(V instance) {
        if (null != instance) {
            violating.add(instance);
        }
    }
    
    /**
     * Releases the given accessor.
     * 
     * @param accessor the accessor (may be <b>null</b>, then nothing happens)
     */
    private void release(EvaluationAccessor accessor) {
        if (null != accessor) {
            accessor.release();
        }
    }
    
    /**
     * Returns whether <code>var</code> is a relevant variable for monitoring reasoning analysis, i.e., 
     * a runtimeVariable.
     * 
     * @param var the variable to analyze (may be <b>null</b>)
     * @return <code>true</code> if it is relevant, <code>false</code> else
     */
    protected abstract boolean isRelevantVariable(IDecisionVariable var);
    
    /**
     * Update the set of relevant variables.
     */
    private void updateRelevant() {
        if (allowUpdateRelevant) {
            EvaluationAccessor eval = getResultAccessor(false);
            if (null != eval) {
                IDecisionVariable var = eval.getVariable();
                if (isRelevantVariable(var)) {
                    relevant.add(var);
                }
            }
        }
    }
    
    @Override
    public void visitVariable(Variable variable) {
        super.visitVariable(variable);
        updateRelevant();
    }
   
    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        super.visitCompoundAccess(access);
        updateRelevant();
    }
    
    /**
     * Turns an evaluation <code>accessor</code> into its double value if possible.
     * 
     * @param accessor the accessor (may be <b>null</b> resulting in <b>null</b>)
     * @return the double value or <b>null</b> if the conversion is not possible
     */
    private Double toDouble(EvaluationAccessor accessor) {
        Double result = null;
        if (null != accessor) {
            Value value = accessor.getValue();
            if (value instanceof IntValue) {
                result = ((IntValue) value).getValue().doubleValue();
            } else if (value instanceof RealValue) {
                result = ((RealValue) value).getValue();
            }
        }
        return result;
    }

    /**
     * Analyzes the given constraint (part) and tries to identify deviations.
     * 
     * @param config the configuration to evaluate on
     * @param cst the constraint part to be analyzed
     * @param constraint the full constraint containing <code>cst</code>, may be <b>null</b>
     * @return a violating clause in case that a deviation can be identified, <code>false</code> else
     */
    public List<V> analyze(Configuration config, ConstraintSyntaxTree cst, Constraint constraint) {
        init(config, null, false, null);
        cst.accept(this);
        List<V> result = getViolatingClauses();
        clear();
        return result;
    }

    /**
     * Analyzes the <code>reasoningResult</code> and turns it if required into violating clauses hinting the 
     * adaptation layer towards the current deviations and the required adaptations.
     * 
     * @param config the configuration used for reasoning
     * @param reasoningResult the (failing) reasoning result
     * @return the violating clauses (may be <b>null</b> or empty if there are none) as an individual list instance,
     *   i.e., calling this method again returns a different list instance and the result is independent of / not 
     *   influenced by {@link #clear()} 
     */
    public List<V> analyze(Configuration config, ReasoningResult reasoningResult) {
        List<V> result = null;
        for (int m = 0; m < reasoningResult.getMessageCount(); m++) {
            de.uni_hildesheim.sse.reasoning.core.reasoner.Message msg = reasoningResult.getMessage(m);
            List<Set<IDecisionVariable>> probVars = msg.getProblemVariables();
            List<ConstraintSyntaxTree> probConstraintParts = msg.getProblemConstraintParts();
            List<Constraint> probConstraints = msg.getProblemConstraints();
            if (null != probVars && probVars.size() > 0 && null != probConstraintParts 
                && probConstraintParts.size() > 0) {
                int count = 0;
                for (Set<IDecisionVariable> set : probVars) {
                    for (IDecisionVariable var : set) {
                        if (isRelevantVariable(var)) {
                            count++;
                        }
                    }
                }
                if (count > 0) { // contains relevant variables
                    for (int c = 0; c < probConstraintParts.size(); c++) {
                        ConstraintSyntaxTree cst = probConstraintParts.get(c);
                        Constraint constraint = c < probConstraints.size() ? probConstraints.get(c) : null;
                        List<V> clauses = analyze(config, cst, constraint);
                        if (null != clauses) {
                            if (null == result) {
                                result = new ArrayList<V>();
                            }
                            result.addAll(clauses);
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Returns whether an array contains a certain value.
     * 
     * @param <T> the element type
     * @param array the array
     * @param value the value
     * @return <code>true</code> if <code>array</code> contains <code>value</code>
     */
    public static <T> boolean contains(T[] array, T value) {
        boolean result;
        if (array == null || array.length == 0) {
            result = false;
        } else {
            result = java.util.Arrays.asList(array).contains(value);
        }
        return result;
    }

}
