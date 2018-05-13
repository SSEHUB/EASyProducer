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
package net.ssehub.easy.varModel.cstEvaluation;

import net.ssehub.easy.varModel.cstEvaluation.EvaluationVisitor.Message;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Interface to the constraint evaluator to avoid unnecessary access when passing along an evaluation visitor.
 * 
 * @author Holger Eichelberger
 */
public interface IConstraintEvaluator {

    /**
     * Returns whether the constraint evaluation
     * indicates that the evaluated constraint was fulfilled.
     * 
     * @return <code>true</code> if the constraint is fulfilled, <code>false</code> else
     */
    public boolean constraintFulfilled();

    /**
     * Returns whether the constraint evaluation
     * indicates that the evaluated constraint failed.
     * For instance, the following should fail:
     * <pre><code>
     * a = true;
     * b = false;
     * 
     * !a or b
     * </code></pre>
     * 
     * @return <code>true</code> if the constraint failed, <code>false</code> else
     */
    public boolean constraintFailed();

    /**
     * Returns whether the constraint evaluation
     * indicates that (at least one part of) the constraint was undefined.
     * 
     * @return <code>true</code> if (at least one part of) the constraint was undefined, <code>false</code> else
     */
    public boolean constraintUndefined();
    
    /**
     * Returns whether the constraint was internally evaluated to false but finally
     * leads to a successful execution and shall lead to a warning to the user.
     * 
     * @return <code>true</code> if the constraint shall be issued as a warning, <code>false</code> else.
     */
    public boolean constraintIsAWarning();

    /**
     * Returns the evaluation result.
     * 
     * @return may be <b>null</b> in case of an expression that cannot be evaluated (shall lead to an exception)
     */
    public Value getResult();

    /**
     * Returns the number of messages.
     * 
     * @return the number of messages
     */
    public int getMessageCount();
        
    /**
     * Returns the specified evaluation message.
     * 
     * @param index the message to return
     * @return the specified message
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link getMessageCount()}</code>
     */
    public Message getMessage(int index);

}
