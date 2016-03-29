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
 * Defines the evaluation context for version restrictions. Before {@link #setValue(IVariable, Version) setting}
 * values for variables, {@link #startEvaluation()} shall be called 
 * by {@link IVersionRestriction#evaluate(IRestrictionEvaluationContext, Version)}. {@link #unsetValue(IVariable)} shall
 * be called before ending the evaluation to clean up the variable binding. Finally 
 * {@link IVersionRestriction#evaluate(IRestrictionEvaluationContext, Version)} shall call {@link #endEvaluation()}.
 * 
 * @author Holger Eichelberger
 */
public interface IRestrictionEvaluationContext {
    
    /**
     * Defines the value for the given variable in this context. May imply
     * that the given variable is added to the context if adequate.
     * 
     * @param variable the variable to be defined
     * @param version the actual value
     * @throws RestrictionEvaluationException in case that setting the variable fails, e.g., due to type conflicts
     */
    public void setValue(IVariable variable, Version version) throws RestrictionEvaluationException;
    
    /**
     * Unsets the value for the given variable. May imply that the variable
     * is removed from the context if adequate.
     * 
     * @param variable the variable to be unset
     * @throws RestrictionEvaluationException in case that setting the variable fails, e.g., due to type conflicts
     */
    public void unsetValue(IVariable variable) throws RestrictionEvaluationException;
    
    /**
     * Notifies the context about starting the evaluation.
     * 
     * @return returns the evaluation processor
     * @throws RestrictionEvaluationException in case that a sub context cannot be created
     */
    public Object startEvaluation() throws RestrictionEvaluationException;

    /**
     * Notifies the context about the end of the evaluation.
     * 
     * @param processor the evaluation processor for release
     * @throws RestrictionEvaluationException in case that a sub context cannot be removed
     */
    public void endEvaluation(Object processor) throws RestrictionEvaluationException;
    
}