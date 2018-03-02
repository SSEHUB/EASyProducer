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
     * Processes a constraint syntax tree.
     * 
     * @param cst the constraint syntax tree
     * @param parent the actual/intended parent if not determined otherwise
     * @return the processed constraint syntax tree, may be <code>cst</code>
     */
    public abstract ConstraintSyntaxTree process(ConstraintSyntaxTree cst, IModelElement parent);

    /**
     * Processes a constraint (taking over the parent of <code>constraint</code>). [convenience]
     * 
     * @param constraint the constraint to be processed
     * @return the processed constraint syntax tree, may be the one of <code>constraint</code>
     */
    public ConstraintSyntaxTree process(Constraint constraint) {
        return process(constraint.getConsSyntax(), constraint.getParent());
    }
}
