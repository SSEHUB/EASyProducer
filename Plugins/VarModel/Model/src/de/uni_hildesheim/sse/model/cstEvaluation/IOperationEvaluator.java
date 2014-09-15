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

/**
 * Evaluates an IVML operation. Implementations must be stateless! Evaluators shall neither release
 * operands nor arguments.
 * 
 * @author Holger Eichelberger
 */
public interface IOperationEvaluator {
    
    /**
     * Evaluates an operation.
     * 
     * @param operand the operand value
     * @param arguments the arguments to be used for the evaluation
     * @return the result of the operation (variable or value)
     */
    public EvaluationAccessor evaluate(EvaluationAccessor operand, EvaluationAccessor[] arguments);
    
}