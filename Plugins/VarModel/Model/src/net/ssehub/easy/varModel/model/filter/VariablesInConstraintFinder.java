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
package net.ssehub.easy.varModel.model.filter;

import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;

/**
 * Searches for used {@link IDecisionVariable}s and their states inside a {@link ConstraintSyntaxTree}.
 * @author El-Sharkawy
 *
 */
public class VariablesInConstraintFinder extends AbstractStateVariablesInConstraintFinder {

    private Set<IDecisionVariable> variables;
    private Set<IAssignmentState> states;

    /**
     * Creates a constraint finder for reuse. Call {@link #setConfiguration(Configuration)} first, accept then the 
     * constraint to be analyzed and call {@link #clear()} afterwards to make the visitor instance ready for reuse.
     * 
     * (must not be <tt>null</tt>).
     */
    public VariablesInConstraintFinder() {
        super();
    }

    /**
     * Creates a constraint finder for single use directly on <code>cst</code>.
     * 
     * @param cst A constraint where all nested {@link IDecisionVariable}'s should be found.
     * @param config The related Configuration of the project to where the <tt>cst</tt> belongs to
     * (must not be <tt>null</tt>).
     */
    public VariablesInConstraintFinder(ConstraintSyntaxTree cst, Configuration config) {
        super(cst, config);
    }

    /**
     * Clears this visitor for reuse.
     */
    public void clear() {
        super.clear();
        variables = new HashSet<IDecisionVariable>();
        states = new HashSet<IAssignmentState>();
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
    protected void addVariable(IDecisionVariable var) {
        // TODO check local variables
        if (null != var) {
            variables.add(var);
            IAssignmentState state = var.getState() != null ? var.getState() : AssignmentState.UNDEFINED;
            states.add(state);
        }
    }

}
