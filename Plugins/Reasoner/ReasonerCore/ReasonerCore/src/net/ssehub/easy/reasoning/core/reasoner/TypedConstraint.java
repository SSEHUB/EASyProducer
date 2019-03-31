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

/**
 * Reasoner specific constraint type indicating a typed constraint, e.g., a default constraint or a constraint
 * originating from a constraint variable.
 * 
 * @author Holger Eichelberger
 */
public class TypedConstraint extends Constraint {

    private IConstraintType type;
    
    /**
     * Creates a new constraint from an already parsed syntax tree.
     * 
     * @param consSyntax the constraint syntax tree
     * @param type the constraint type
     * @param parent the object, in which this specific one is embedded
     * @throws CSTSemanticException in case that the constraint semantics cannot be resolved
     *   or that the specified constraint does not evaluate to a boolean expression
     */
    public TypedConstraint(ConstraintSyntaxTree consSyntax, IConstraintType type, IModelElement parent) 
        throws CSTSemanticException {
        super(consSyntax, parent);
        this.type = type;
    }

    @Override
    public IConstraintType getType() {
        return type;
    }

    @Override
    public Constraint createConstraint(ConstraintSyntaxTree consSyntax) throws CSTSemanticException {
        return new TypedConstraint(consSyntax, type, getParent());
    }

}
