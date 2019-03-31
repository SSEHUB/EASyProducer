/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model;

import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;


/**
 * Constraints for instances of an {@link DerivedDatatype}.
 * @author El-Sharkawy
 *
 */
public class InternalConstraint extends Constraint {
    
    private DerivedDatatype originType;

    /**
     * Creates a new internal constraint from an already parsed syntax tree.
     * 
     * @param originType The source of this constraint.
     * @param consSyntax the constraint syntax tree
     * @param parent the object, in which this specific one is embedded
     * @throws CSTSemanticException in case that the constraint semantics cannot be resolved
     *   or that the specified constraint does not evaluate to a boolean expression
     */
    public InternalConstraint(DerivedDatatype originType, ConstraintSyntaxTree consSyntax, IModelElement parent)
        throws CSTSemanticException {
        
        super(originType.getName(), consSyntax, parent);
        this.originType = originType;
    }
    
    /**
     * Returns the {@link DerivedDatatype} where this constraints belongs to.
     * @return The source of this constraint.
     */
    public DerivedDatatype getDerivedDatatype() {
        return originType;
    }
    
    @Override
    public Constraint createConstraint(ConstraintSyntaxTree consSyntax) throws CSTSemanticException {
        return new InternalConstraint(originType, consSyntax, getParent());
    }

}
