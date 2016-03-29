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
package net.ssehub.easy.varModel.cstEvaluation;

import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.confModel.IFreezeSelector;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;

/**
 * Implements a freeze selector based on expression evaluation.
 * 
 * @author Holger Eichelberger
 */
public class FreezeEvaluator implements IFreezeSelector {
    
    private EvaluationVisitor eval;
    private FreezeBlock freeze;
    
    /**
     * Creates a freeze evaluator for the given configuration.
     * 
     * @param config the configuration
     */
    public FreezeEvaluator(Configuration config) {
        eval = new EvaluationVisitor(config, null, false, null);
    }

    /**
     * Defines the current freeze block to evaluate.
     * 
     * @param freeze the freeze block
     */
    public void setFreeze(FreezeBlock freeze) {
        this.freeze = freeze;
    }
    
    @Override
    public boolean shallFreeze(IDecisionVariable variable) {
        ConstraintSyntaxTree selector = null;
        DecisionVariableDeclaration var = null;
        if (null != freeze) {
            selector = freeze.getSelector();
            var = freeze.getIter();
        }
        boolean result = true; // no limitation
        if (null != selector && null != var) {
            eval.addMapping(var, variable);
            eval.visit(selector);
            if (eval.constraintFulfilled()) { // limitation fulfilled - do not freeze
                result = false;
            }
            eval.clearResult();
            eval.removeMapping(var);
        }
        return result;
    }

}
