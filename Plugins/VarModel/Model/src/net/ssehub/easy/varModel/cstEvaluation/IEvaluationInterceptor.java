/*
 * Copyright 2009-2021 University of Hildesheim, Software Systems Engineering
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

import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * An evaluation interceptor may step into the expression evaluation at certain points in
 * time to modify setting/getting values. Such a mechanism is needed, as the underlying 
 * configuration model assumes interaction in a certain manner, in particular regarding 
 * compound default values, which may not fit to an incremental application of the expression
 * evaluator, e.g., in the context of a reasoner. More specifically, if default value expressions
 * are evaluated as individual constraints to handle variable interactions, a value assignment may 
 * accidentally overwrite previously set default values (the way that the value factory creates 
 * values and the configuration model applying these values) while in the mean time changing the 
 * assignment state to assigned although default values are not completely applied.  
 * 
 * Currently, the interceptor us used only within compounds, but may be extended to other model 
 * elements in the future.
 * 
 * @author Holger Eichelberger
 */
public interface IEvaluationInterceptor {
    
    // var may be null -> result null
    public Value getValue(IDecisionVariable var);
    
    // var may be null -> result false
    public boolean setValue(IDecisionVariable var, Value val, boolean asAssignment, EvaluationAccessor acc);

}
