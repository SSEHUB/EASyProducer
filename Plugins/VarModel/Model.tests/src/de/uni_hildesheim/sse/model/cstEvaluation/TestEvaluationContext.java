/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.model.cstEvaluation;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IAssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Implements a test evaluation context.
 * 
 * @author Holger Eichelberger
 */
public class TestEvaluationContext extends EvaluationContext {

    private Configuration cfg;
    private boolean allowAssign;
    private IAssignmentState targetState;

    /**
     * Creates a dummy context on an empty configuration.
     */
    public TestEvaluationContext() {
        this(new Configuration(new Project("")), false, AssignmentState.ASSIGNED);
    }
    
    /**
     * Creates a context.
     * 
     * @param cfg the configuration
     * @param allowAssign assign the value
     * @param targetState the target state
     */
    public TestEvaluationContext(Configuration cfg, boolean allowAssign, IAssignmentState targetState) {
        this.cfg = cfg;
        this.allowAssign = allowAssign;
        this.targetState = targetState;
    }

    @Override
    public boolean allowAssignValues() {
        return allowAssign;
    }

    @Override
    public void notifyChangeListener(IDecisionVariable variable) {
    }

    @Override
    public IDecisionVariable getDecision(AbstractVariable variable) {
        return cfg.getDecision(variable);
    }

    @Override
    public void addMessage(EvaluationVisitor.Message message) {
        System.out.println(message.getDescription());
    }

    @Override
    public IAssignmentState getTargetState(IDecisionVariable var) {
        return targetState;
    }

    @Override
    public Value getAllInstances(IDatatype var) {
        return cfg.getAllInstances(var);
    }

    @Override
    public void issueWarning() {
    }

    @Override
    public boolean allowPropagation() {
        return true; // default before adding this method
    }

}
