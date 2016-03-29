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
package net.ssehub.easy.basics.modelManagement;

/**
 * Denotes a version restriction. This abstraction is needed as individual languages may implement
 * the restrictions differently, e.g., using (different versions of) constraints, evaluation mechanisms or simplified
 * version restriction expressions.
 * 
 * @author Holger Eichelberger
 */
public interface IVersionRestriction {

    /**
     * Maps a variable to another while copying.
     * 
     * @author Holger Eichelberger
     */
    public interface IVariableMapper {

        /**
         * Maps <code>variable</code> to its copied version.
         * 
         * @param variable the variable
         * @return the mapped variable (may be <b>null</b> if there is no mapping)
         */
        IVariable map(IVariable variable);
        
    }
    
    /**
     * Emits the version restriction in terms of it's specification representation.
     * 
     * @param context the output context (interpreted by the respective implementation, 
     *   e.g., an output visitor in order to continue with the actual indentation, may 
     *   be <b>null</b> but then nothing is emitted)
     */
    public void emit(Object context);
    
    /**
     * Turns the version restriction into it's specification representation.
     * 
     * @return the specification representation
     */
    public String toSpecification();

    /**
     * Evaluates the restriction.
     * 
     * @param context the output context (interpreted by the respective implementation, 
     *   e.g., an output visitor in order to continue with the actual indentation, may 
     *   be <b>null</b> but then <b>false</b> will always be the result)
     * @param version the version (of the project) to be used for evaluation
     * @return <code>true</code> if the version matches the restriction, <code>false</code> else
     * @throws RestrictionEvaluationException in case of evaluation problems
     */
    public boolean evaluate(IRestrictionEvaluationContext context, Version version) 
        throws RestrictionEvaluationException;
    
    /**
     * Copies this version restriction for the given <code>model</code>.
     * 
     * @param model the model to copy/instantiate this version restriction for
     * @return the copied version restriction (may be <b>null</b> if no restrictions needed to be copied)
     * @throws RestrictionEvaluationException in case of evaluation/type problems
     */
    public IVersionRestriction copy(IModel model) throws RestrictionEvaluationException;

    /**
     * Copies this version restriction for the given using the given <code>mapper</code>.
     * 
     * @param mapper the variable mapper
     * @return the copied version restriction (may be <b>null</b> if no restrictions needed to be copied)
     * @throws RestrictionEvaluationException in case of evaluation/type problems
     */
    public IVersionRestriction copy(IVariableMapper mapper) throws RestrictionEvaluationException;
    
}
