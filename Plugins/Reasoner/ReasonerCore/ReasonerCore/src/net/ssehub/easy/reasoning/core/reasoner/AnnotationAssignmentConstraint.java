/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.core.reasoner;

import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.Constraint.Type;

/**
 * Reasoner specific constraint type indicating a {@link Type#ANNOTATION_ASSIGNMENT} constraint. This shall avoid 
 * requiring an attribute for this purpose for all constraints and using it just for temporary reasoning ones.
 * 
 * @author Holger Eichelberger
 */
public class AnnotationAssignmentConstraint extends Constraint {

    /**
     * Creates a new constraint from an already parsed syntax tree.
     * 
     * @param consSyntax the constraint syntax tree
     * @param parent the object, in which this specific one is embedded
     * @throws CSTSemanticException in case that the constraint semantics cannot be resolved
     *   or that the specified constraint does not evaluate to a boolean expression
     */
    public AnnotationAssignmentConstraint(ConstraintSyntaxTree consSyntax, IModelElement parent) 
        throws CSTSemanticException {
        super(consSyntax, parent);
    }

    /**
     * Returns the conceptual type of the constraint.
     * 
     * @return the conceptual type ({@link Type#ANNOTATION_ASSIGNMENT})
     */
    public IConstraintType getType() {
        return Type.ANNOTATION_ASSIGNMENT;
    }

}
