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
package net.ssehub.easy.varModel.cst;

import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Class for a variable value.
 * 
 * @author jaehne
 * @author Holger Eichelberger
 */
public class Variable extends Leaf {

    private AbstractVariable nestedVariable;
    
    /**
     * Constructor for serialization.
     */
    Variable() {
    }
    
    /**
     * The constructor for this class.
     * @param nestedVariable The nested variable should be embedded in the current constraint.
     */
    public Variable(AbstractVariable nestedVariable) {
        this.nestedVariable = nestedVariable;
    }

    /**
     * Getter for the nestedVariable.
     * @return The nested variable should not be null.
     */
    public AbstractVariable getVariable() {
        return nestedVariable;
    }
    
    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        IDatatype result = nestedVariable.getType();
        // this does not work using a visitor due to the implicit
        // dispatch of the delegating types :(
        // define a method in IDatatype for this???
        if (result instanceof DerivedDatatype) {
            result = ((DerivedDatatype) result).getBasisType();
        } /*else if (result instanceof Reference) {
            result = ((Reference) result).getType();
        }*/
        return result;
    }
    
    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitVariable(this); // no further operations!
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        
        if (obj instanceof Variable) {
            equals = nestedVariable.equals(((Variable) obj).nestedVariable);
        }
        
        return equals;
    }

    @Override
    public int hashCode() {
        return nestedVariable.hashCode();
    }
    
    @Override
    public int getAttributesCount() {
        return nestedVariable.getAttributesCount();
    }
    
    @Override
    public Attribute getAttribute(int index) {
        return nestedVariable.getAttribute(index);
    }

    @Override
    public String toString() {
        return nestedVariable.toString();
    }
    
    /**
     * Returns the qualifier for accessing the variable, e.g., an expression
     * to be put before. For usual variables, the qualifier is always <b>null</b>.
     * 
     * @return the qualifier (may be <b>null</b>)
     */
    public ConstraintSyntaxTree getQualifier() {
        return null;
    }
    
    /**
     * Returns the resolved decision variable.
     * 
     * @return the decision variable (may be <b>null</b>)
     */
    public IDecisionVariable getResolved() {
        return null;
    }
    
    @Override
    public boolean isSemanticallyEqual(ConstraintSyntaxTree otherTree) {
        boolean equals = false;
        
        if (otherTree instanceof Variable) {
            equals = nestedVariable.equals(((Variable) otherTree).nestedVariable);
        }
        
        return equals;
    }
}
