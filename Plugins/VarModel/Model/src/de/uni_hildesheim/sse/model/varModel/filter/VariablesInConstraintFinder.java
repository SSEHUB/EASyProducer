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
package de.uni_hildesheim.sse.model.varModel.filter;

import java.util.HashSet;
import java.util.Set;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IAssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.CompoundAccess;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.ContainerOperationCall;
import de.uni_hildesheim.sse.model.cst.Let;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;

/**
 * Searches for used {@link IDecisionVariable}s and their states inside a {@link ConstraintSyntaxTree}.
 * @author El-Sharkawy
 *
 */
public class VariablesInConstraintFinder extends AbstractVariableInConstraintFinder {

    private Set<IDecisionVariable> variables;
    private Set<IAssignmentState> states;
    private Configuration config;
    
    /**
     * Sole constructor for this class.
     * @param cst A constraint where all nested {@link IDecisionVariable}'s should be found.
     * @param config The related Configuration of the project to where the <tt>cst</tt> belongs to
     * (must not be <tt>null</tt>).
     */
    public VariablesInConstraintFinder(ConstraintSyntaxTree cst, Configuration config) {
        this.config = config;
        variables = new HashSet<IDecisionVariable>();
        states = new HashSet<IAssignmentState>();
        cst.accept(this);
    }
    
    /**
     * Returns all {@link IDecisionVariable}'s inside the given {@link ConstraintSyntaxTree}.
     * @return A set of nested {@link IDecisionVariable}'s (This set must not be <tt>null</tt>).
     */
    public Set<IDecisionVariable> getVariables() {
        return variables;
    }
    
    /**
     * Returns all {@link IAssignmentState}'s of the found {@link IDecisionVariable}s of {@link #getVariables()}.
     * @return A set of nested {@link IAssignmentState}'s (This set must not be <tt>null</tt>).
     */
    public Set<IAssignmentState> getStates() {
        return states;
    }
    
    @Override
    public void visitVariable(Variable variable) {
        addVariable(variable.getVariable());
    }

    /**
     * Adds the related {@link IDecisionVariable} and their state to the retrieval sets.
     * @param declaration A discovered declaration for which the {@link IDecisionVariable} and its state should
     * be saved.
     */
    private void addVariable(AbstractVariable declaration) {
        // TODO check local variables
        IDecisionVariable var = config.getDecision(declaration);
        if (null != var) {
            variables.add(var);
            IAssignmentState state = var.getState() != null ? var.getState() : AssignmentState.UNDEFINED;
            states.add(state);
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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        addVariable(access.getResolvedSlot());
        access.getCompoundExpression().accept(this);
    }

}
