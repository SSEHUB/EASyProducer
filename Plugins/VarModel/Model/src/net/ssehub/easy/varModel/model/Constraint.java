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
import net.ssehub.easy.varModel.cst.ValidationVisitor;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.VoidType;

/**
 * Class to create a rule-based constraint.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 *
 */
public class Constraint extends ContainableModelElement implements IPartialEvaluable {
            
    private ConstraintSyntaxTree consSyntax;

    /**
     * Base type for (extensible) constraint types.
     * 
     * @author Holger Eichelberger
     */
    public interface IConstraintType {
    }
    
    /**
     * The conceptual type of the constraint.
     * 
     * @author Holger Eichelberger
     */
    public enum Type implements IConstraintType {
        
        /**
         * The usual constraint as used in IVML models.
         */
        USUAL,
        
        /**
         * Reasoner-created constraint for default values.
         */
        DEFAULT,
        
        /**
         * Reasoner-created constraint for constraint variables/values.
         */
        CONSTRAINT
    }
    
    /**
     * Constructor for a new Constraint.
     * 
     * @param parent the object, in which this specific one is embedded
     */
    public Constraint(IModelElement parent) {
        //At this time named constraints are not supported
        super("", parent);
    }

    /**
     * Constructor for a new Constraint.
     * 
     * @param name the name of a constraint
     * @param parent the object, in which this specific one is embedded
     */
    public Constraint(String name, IModelElement parent) {
        //At this time named constraints are not supported
        super(name, parent);
    }
    
    /**
     * Creates a new constraint from an already parsed syntax tree.
     * 
     * @param consSyntax the constraint syntax tree
     * @param parent the object, in which this specific one is embedded
     * @throws CSTSemanticException in case that the constraint semantics cannot be resolved
     *   or that the specified constraint does not evaluate to a boolean expression
     */
    public Constraint(ConstraintSyntaxTree consSyntax, IModelElement parent) 
        throws CSTSemanticException {
        this("", consSyntax, parent);
    }

    /**
     * Creates a new constraint from an already parsed syntax tree.
     * 
     * @param name the name of a constraint
     * @param consSyntax the constraint syntax tree
     * @param parent the object, in which this specific one is embedded
     * @throws CSTSemanticException in case that the constraint semantics cannot be resolved
     *   or that the specified constraint does not evaluate to a boolean expression
     */
    public Constraint(String name, ConstraintSyntaxTree consSyntax, IModelElement parent) 
        throws CSTSemanticException {
        super(name, parent); 
        setConsSyntax(consSyntax);
    }
    
    /**
     * Getter-Method for the ConstraintSyntaxTree.
     * @return the ConstraintSytnaxTree
     */
    public ConstraintSyntaxTree getConsSyntax() {
        return consSyntax;
    }
    
    /**
     * Changes the constraint syntax tree. [required as consequence of parent elements]
     * 
     * @param consSyntax the constraint syntax tree
     * @throws CSTSemanticException in case that the constraint semantics cannot be resolved
     *   or that the specified constraint does not evaluate to a boolean expression
     */
    public void setConsSyntax(ConstraintSyntaxTree consSyntax) throws CSTSemanticException {
        if (null != consSyntax) {
            String error = check(consSyntax);
            if (null != error) {
                throw new CSTSemanticException(error, CSTSemanticException.TYPE_MISMATCH);
            }
        }
        this.consSyntax = consSyntax;
    }
    
    /**
     * Checks a constraint syntax tree for validation properties.
     * 
     * @param cst the constraint syntax tree to be checked
     * @return <b>null</b> in case of no error, the error description in case of an error
     * @throws CSTSemanticException in case that the constraint semantics cannot be resolved
     *   or that the specified constraint does not evaluate to a boolean expression
     */
    private static String check(ConstraintSyntaxTree cst) throws CSTSemanticException {
        IDatatype type = cst.inferDatatype();
        String error = null;
        ValidationVisitor vis = new ValidationVisitor();
        cst.accept(vis);
        if (VoidType.TYPE == type) {
            if (vis.isAssignment()) {
                if (!vis.isValidAssignment()) {
                    error = "assignment is not valid";  
                } // else ok
            } else {
                error = "constraints must be of type boolean";    
            }
        } else if (BooleanType.TYPE.isAssignableFrom(type) || ConstraintType.TYPE.isAssignableFrom(type)) {
            error = null; // checkstyle
            //if (vis.isAssignment()) {
            //    error = "assignment is not valid";
            //} // else ok
        } else {
            error = "constraints must be either an assignment or of type boolean";
        }
        if (vis.getErrorCount() > 0) {
            error = vis.getErrorString();
        }
        return error;
    }

    @Override
    public void accept(IModelVisitor visitor) {
        visitor.visitConstraint(this);
    }
    
    /**
     * Returns whether this constraint is a boolean constraint.
     * 
     * @return <code>true</code> if it is a boolean constraint, <code>false</code> 
     *   otherwise (please note that <code>false</code> does not even imply that
     *   this constraint is valid)
     */
    public boolean isBooleanConstraint() {
        boolean isBoolean = false;
        if (null != consSyntax) {
            try {
                isBoolean = BooleanType.TYPE.isAssignableFrom(consSyntax.inferDatatype());
            } catch (CSTSemanticException e) {
                // result is implicitly false
            }
        }
        return isBoolean;
    }

    @Override
    public String toString() {
       // name is typically null as we don't have named constraints in IVML now
        return "constraint (type: " + getType() + ") = " 
            + (getConsSyntax() == null ? null : getConsSyntax().toString()); 
    }
    
    /**
     * Returns the conceptual type of the constraint. Reasoners may return specialized types here.
     * 
     * @return the conceptual type ({@link Type#USUAL})
     */
    public IConstraintType getType() {
        return Type.USUAL;
    }
    
    /**
     * Returns the element, e.g., type, the constraint is attached to. Reasoner may return specialized
     * values here.
     *  
     * @return the attached object (<b>null</b> always)
     */
    public Object getAttachedTo() {
        return null;
    }

}
