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
package net.ssehub.easy.reasoning.sseReasoner.model;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.reasoning.sseReasoner.Descriptor;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.AttributeVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.Let;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.filter.AbstractVariableInConstraintFinder;

/**
 * Searches for used {@link IDecisionVariable}s and their states inside a {@link ConstraintSyntaxTree}. For reuse,
 * call {@link #setConfiguration(Configuration)} first, then visit the respective constraint, call one of the getters
 * to obtain the result, e.g., {@link #isConstraintFrozen()} and finally {@link #clear()}.
 * 
 * @author El-Sharkawy
 * @author Holger Eichelberger
 */
public class VariablesInConstraintFinder extends AbstractVariableInConstraintFinder {

    private int variablesCount;
    private int frozenVariablesCount;
    private int localVariablesCount;
    private Configuration config;

    /**
     * Creates a constraint finder for reuse. Call {@link #setConfiguration(Configuration)} first, accept then the 
     * constraint to be analyzed and call {@link #clear()} afterwards to make the visitor instance ready for reuse.
     * 
     * (must not be <tt>null</tt>).
     */
    public VariablesInConstraintFinder() {
        super(false);
        clear();
    }

    /**
     * Creates a constraint finder for single use directly on <code>cst</code>.
     * 
     * @param cst A constraint where all nested {@link IDecisionVariable}'s should be found.
     * @param config The related Configuration of the project to where the <tt>cst</tt> belongs to
     * (must not be <tt>null</tt>).
     */
    public VariablesInConstraintFinder(ConstraintSyntaxTree cst, Configuration config) {
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
    }

    /**
     * Clears this visitor for reuse.
     */
    public void clear() {
        variablesCount = 0;
        localVariablesCount = 0;
        frozenVariablesCount = 0;
    }
    
    /**
     * Returns the number of frozen variables used in the visited constraint.
     * 
     * @return the number of variables
     */
    public int getFrozenVariablesCount() {
        return frozenVariablesCount;
    }
    
    /**
     * Returns the number of local variables used in the visited constraint.
     * 
     * @return the number of variables
     */
    public int getLocalVariablesCount() {
        return localVariablesCount;
    }

    /**
     * Returns the number of variables used in the visited constraint.
     * 
     * @return the number of variables
     */
    public int getVariablesCount() {
        return variablesCount;
    }

    /**
     * Returns whether there are only {@link #getLocalVariablesCount() local variables} and 
     * {@link #getFrozenVariablesCount() frozen variables} in the visited constraint.
     * 
     * @return <code>true</code> for a frozen constraint, <code>false</code> else
     */
    public boolean isConstraintFrozen() {
        return getVariablesCount() == getLocalVariablesCount() + getFrozenVariablesCount();
    }
    
    @Override
    public void visitVariable(Variable variable) {
        addVariable(variable.getVariable());
    }
    
    @Override
    public void visitAnnotationVariable(AttributeVariable variable) {
        variable.getQualifier().accept(this);
        visitVariable(variable);
    }

    /**
     * Adds the related {@link IDecisionVariable} and their state to the retrieval sets.
     * @param declaration A discovered declaration for which the {@link IDecisionVariable} and its state should
     * be saved.
     */
    protected void addVariable(AbstractVariable declaration) {
        IDecisionVariable var = config.getDecision(declaration);
        if (null != var) {
            variablesCount++;
            IAssignmentState state = var.getState() != null ? var.getState() : AssignmentState.UNDEFINED;
            if (var.isLocal()) {
                localVariablesCount++;
            } else if (AssignmentState.FROZEN == state) {
                frozenVariablesCount++;
            }
        }
    }

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
            EASyLoggerFactory.INSTANCE.getLogger(getClass(), Descriptor.BUNDLE_NAME).exception(e);
        }
        addVariable(access.getResolvedSlot());
        access.getCompoundExpression().accept(this);
    }

}
