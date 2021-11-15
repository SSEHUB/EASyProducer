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
 * Reasoner specific constraint type indicating a {@link Type#DEFAULT} constraint. This shall avoid requiring an 
 * attribute for this purpose for all constraints and using it just for temporary reasoning ones.
 * 
 * @author Holger Eichelberger
 */
public class DefaultConstraint extends Constraint {

    private ConstraintList defaultConstraints;
    private ConstraintList deferredDefaultConstraints;
    
    /**
     * Creates a new constraint from an already parsed syntax tree.
     * 
     * @param consSyntax the constraint syntax tree
     * @param parent the object, in which this specific one is embedded
     * @throws CSTSemanticException in case that the constraint semantics cannot be resolved
     *   or that the specified constraint does not evaluate to a boolean expression
     */
    public DefaultConstraint(ConstraintSyntaxTree consSyntax, IModelElement parent) 
        throws CSTSemanticException {
        super(consSyntax, parent);
    }

    /**
     * Sets the default constraint list explicitly. Default constraints can be evaluated directly without further 
     * constraint/variable dependencies. The attached constraints are temporary.
     * 
     * @param defaultConstraints the default constraints, may be <b>null</b> for none
     */
    public void setDefaultConstraints(ConstraintList defaultConstraints) {
        this.defaultConstraints = defaultConstraints;
    }
    
    /**
     * Sets the deferred default constraint list explicitly. Default constraints have dependencies and shall be 
     * evaluated (initially) after the default constraints. The attached constraints are temporary.
     * 
     * @param deferredDefaultConstraints the deferred default constraints, may be <b>null</b> for none
     */
    public void setDeferredDefaultConstraints(ConstraintList deferredDefaultConstraints) {
        this.deferredDefaultConstraints = deferredDefaultConstraints;
    }

    /**
     * Returns the default constraint list explicitly. Default constraints can be evaluated directly without further 
     * constraint/variable dependencies. The attached constraints are temporary.
     * 
     * @return the default constraints, may be <b>null</b> for none
     */
    public ConstraintList getDefaultConstraints() {
        return defaultConstraints;
    }

    /**
     * Returns the deferred default constraint list explicitly. Default constraints have dependencies and shall be 
     * evaluated (initially) after the default constraints. The attached constraints are temporary.
     * 
     * @return the deferred default constraints, may be <b>null</b> for none
     */
    public ConstraintList getDeferredDefaultConstraints() {
        return deferredDefaultConstraints;
    }
    
    /**
     * Returns the number of attached constraints. The attached constraints are temporary. 
     * 
     * @return the number of attached constraints
     */
    public int getAttachedConstraintsSize() {
        int result = 0;
        if (defaultConstraints != null) {
            result += defaultConstraints.size();
        }
        if (deferredDefaultConstraints != null) {
            result += deferredDefaultConstraints.size();
        }
        return result;
    }

    /**
     * Returns the conceptual type of the constraint.
     * 
     * @return the conceptual type ({@link Type#DEFAULT})
     */
    public IConstraintType getType() {
        return Type.DEFAULT;
    }

    @Override
    public Constraint createConstraint(ConstraintSyntaxTree consSyntax) throws CSTSemanticException {
        return new DefaultConstraint(consSyntax, getParent());
    }

}
