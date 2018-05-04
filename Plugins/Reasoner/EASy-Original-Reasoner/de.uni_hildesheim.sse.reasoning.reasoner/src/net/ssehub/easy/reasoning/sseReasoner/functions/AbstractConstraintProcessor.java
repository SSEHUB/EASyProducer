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
package net.ssehub.easy.reasoning.sseReasoner.functions;

import net.ssehub.easy.reasoning.sseReasoner.model.ContextStack;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.IModelElement;

/**
 * Interface for a generic constraint processor functor (avoid collections, process directly).
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractConstraintProcessor {

    /**
     * Expression types.
     * 
     * @author Holger Eichelberger
     */
    public enum ExpressionType {
        DEFAULT,
        ANNOTATION_DEFAULT,
        CONSTRAINT_VALUE,
        ASSIGNMENT_CONSTRAINT,
        CONSTRAINT
    }
    
    /**
     * Processes a constraint syntax tree.
     * 
     * @param cst the constraint syntax tree
     * @param type the type of <code>cst</code>
     * @param slot the slot name, only in case of {@link ExpressionType#DEFAULT} or 
     * {@link ExpressionType#ANNOTATION_DEFAULT}
     * @param parent the actual/intended parent if not determined otherwise
     * @return the processed constraint syntax tree, may be <code>cst</code>
     */
    public abstract ConstraintSyntaxTree process(ConstraintSyntaxTree cst, ExpressionType type, String slot, 
        IModelElement parent);

    /**
     * Processes a constraint (taking over the parent of <code>constraint</code>). [convenience]
     * 
     * @param constraint the constraint to be processed
     * @param type the type of the constraint
     * @return the processed constraint syntax tree, may be the one of <code>constraint</code>
     */
    public ConstraintSyntaxTree process(Constraint constraint, ExpressionType type) {
        return process(constraint.getConsSyntax(), type, null, constraint.getParent());
    }
    
    /**
     * Returns the context stack, e.g., for type exclusions.
     * 
     * @return the context stack
     */
    public abstract ContextStack getContextStack();
    
}
