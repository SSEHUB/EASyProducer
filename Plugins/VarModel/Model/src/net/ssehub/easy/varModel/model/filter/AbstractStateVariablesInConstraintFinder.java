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
package net.ssehub.easy.varModel.model.filter;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor;
import net.ssehub.easy.varModel.model.AbstractVariable;

/**
 * Searches for used {@link IDecisionVariable}s and their states inside a {@link ConstraintSyntaxTree}. For reuse,
 * call {@link #setConfiguration(Configuration)} first, then visit the respective constraint,  
 * and finally {@link #clear()}.
 * 
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
public abstract class AbstractStateVariablesInConstraintFinder extends AbstractVariableInConstraintFinder {

    private Configuration config;
    private EvaluationVisitor evaluator;

    /**
     * Creates a constraint finder for reuse. Call {@link #setConfiguration(Configuration)} first, accept then the 
     * constraint to be analyzed and call {@link #clear()} afterwards to make the visitor instance ready for reuse.
     * 
     * (must not be <tt>null</tt>).
     */
    public AbstractStateVariablesInConstraintFinder() {
        super(false);
        evaluator = new EvaluationVisitor();
        clear();
    }

    /**
     * Creates a constraint finder for single use directly on <code>cst</code>.
     * 
     * @param cst A constraint where all nested {@link IDecisionVariable}'s should be found.
     * @param config The related Configuration of the project to where the <tt>cst</tt> belongs to
     * (must not be <tt>null</tt>).
     */
    public AbstractStateVariablesInConstraintFinder(ConstraintSyntaxTree cst, Configuration config) {
        this();
        setConfiguration(config);
        cst.accept(this);
    }

    /**
     * Defines the configuration to work on.
     * 
     * @param config the configuration
     */
    public void setConfiguration(Configuration config) {
        this.config = config;
        evaluator.init(config, null, false, null);
    }

    /**
     * Clears this visitor for reuse.
     */
    public void clear() {
        evaluator.clear();
    }
    
    @Override
    public void visitVariable(Variable variable) {
        addVariable(variable.getVariable());
    }
    
    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        ConstraintSyntaxTree qu = variable.getQualifier();
        if (null != qu) {
            qu.accept(this);
        }
        visitVariable(variable);
    }

    /**
     * Adds the related {@link IDecisionVariable} and their state to the result.
     * 
     * @param declaration A discovered declaration for which the {@link IDecisionVariable} and its state should
     * be saved.
     * @see #addVariable(IDecisionVariable)
     */
    protected void addVariable(AbstractVariable declaration) {
        addVariable(config.getDecision(declaration));
    }

    /**
     * Adds the related {@link IDecisionVariable} and their state to the result.
     * 
     * @param var the variable to be added, may be <b>null</b>, ignored then
     */
    protected abstract void addVariable(IDecisionVariable var); 

    @Override
    public void visitLet(Let let) {
        addVariable(let.getVariable());
    }

    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        call.getContainer().accept(this);
        call.getExpression().accept(this);
        for (int i = 0; i < call.getDeclaratorsCount(); i++) {
            addVariable(call.getDeclarator(i));
        }
    }

    @Override
    public void visitCompoundAccess(CompoundAccess access) {
        // access.inferDatatype() must be called before access.getResolvedSlot() can be called 
        try {
            access.inferDatatype();
        } catch (CSTSemanticException e) {
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
        }
        access.accept(evaluator);
        addVariable(evaluator.getResultVariable());
        evaluator.clearResult();
    }
    
    /**
     * Returns the evaluator. Only initialized after {@link #setConfiguration(Configuration)} and before 
     * {@link #clear()}.
     * 
     * @return the evaluator
     */
    protected EvaluationVisitor getEvaluator() {
        return evaluator;
    }
    
    /**
     * Returns the assigned configuration. Only initialized after {@link #setConfiguration(Configuration)} and before 
     * {@link #clear()}.
     * 
     * @return the configuration
     */
    protected Configuration getConfiguration() {
        return config;
    }

}
