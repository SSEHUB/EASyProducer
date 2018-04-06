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
package net.ssehub.easy.varModel.model.datatypes;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintReplacer;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.InternalConstraint;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.Project;

/** 
 * DerivedDatatype allows the user to create new data types based on existing types. 
 * 
 * @author heiko beck
 * 
 **/
public class DerivedDatatype extends CustomDatatype {

    // DO !NOT! touch the // checkstyle: comments!

    // checkstyle: stop declaration order check

    static final DelegatingType DTYPE = new DelegatingType();
    
    /**
     * This constant represents the common type of all derived datatypes. Each specific derived type 
     * is assignable to this type.
     */
    public static final IDatatype TYPE = DTYPE;
    

    // operations go here

    // checkstyle: resume declaration order check

    static {
        DTYPE.setDelegate(new DerivedDatatype());
        // operation registering goes here
    }
    private DecisionVariableDeclaration typeDeclaration;
    
    private Constraint[] constraints;
    
    private IDatatype basisType;
    
    private List<IDerivedDatatypeListener> listeners;

    /**
     * Creates the singleton instance for {@link #TYPE}.
     */
    private DerivedDatatype() {
        this("<DerivedDatatype>", null, null);
    }

    /**
     * Constructor for the derived data type.
     * @param name the name of the derived data type
     * @param basisType the type the this datatype is derived from
     * @param parent the object, in which this specific one is embedded
     */
    public DerivedDatatype(String name, IDatatype basisType, ModelElement parent) {
        this(name, basisType, parent, (Constraint[]) null);
    }
    
    /**
     * Constructor for the derived data type.
     * @param name the name of the derived data type
     * @param basisType the type the this datatype is derived from
     * @param parent the object, in which this specific one is embedded
     * @param constraints restricting constraints on <code>basisType</code>, may be <b>null</b>
     */
    public DerivedDatatype(String name, IDatatype basisType, ModelElement parent, Constraint... constraints) {
        super(name, DTYPE, parent);
        listeners = new ArrayList<IDerivedDatatypeListener>();
        this.constraints = constraints;
        this.basisType = basisType;
        this.typeDeclaration = new DecisionVariableDeclaration(name, this, this);
    }
    
    /**
     * Changes the derivation constraints. [required as consequence of parent elements]
     * 
     * @param constraints restricting constraints on <code>basisType</code>, may be <b>null</b>
     */
    public void setConstraints(Constraint[] constraints) {
        // remove old internal constraint instances from project
        if (null != this.constraints) {
            Project project = (Project) getTopLevelParent();
            // TODO when this is removed, also Constraint [] constraints; can become Constraint constraint;
            // multiple ones are not needed anymore; Check whether ConstraintSyntaxTree would also be ok
            project.removeInternalConstraints(this);
        }
  
        this.constraints = constraints;
        
        //Notify all Declarations of this type, that the constraints have changed.
        for (int i = 0; i < listeners.size(); i++) {
            listeners.get(i).constraintsChanged();
        }
    }
    
    /**
     * Registers a new {@link IDerivedDatatypeListener} to this type.
     * @param listener An instance of this type.
     */
    public void register(IDerivedDatatypeListener listener) {
        listeners.add(listener);
    }
    
    /**
     * Unregisters an existing {@link IDerivedDatatypeListener} to this type.
     * @param listener An instance of this type.
     * @return <tt>true</tt> if this type contained the specified listener
     */
    public boolean unregister(IDerivedDatatypeListener listener) {
        return listeners.remove(listener);
    }

    /**
     * Returns the number of constraints.
     * 
     * @return the number of constraints
     */
    public int getConstraintCount() {
        return constraints == null ? 0 : constraints.length;
    }
    
    /**
     * This typeDeclaration is needed for the constraints.
     * @return typeDeclaration related to this datatype
     */
    public DecisionVariableDeclaration getTypeDeclaration() {
        return typeDeclaration;
    }
    
    /**
     * Returns a specific constraint.
     * 
     * @param index the index of the constraint
     * @return the specified constraint
     * @throws IndexOutOfBoundsException if 
     *     <code>0&lt;index || index&gt;{@link #getConstraintCount()}</code>
     */
    public Constraint getConstraint(int index) {
        return constraints[index];
    }
    
    /**
     * Returns the basis type.
     * 
     * @return the basis type
     */
    public IDatatype getBasisType() {
        return basisType;
    }

    @Override
    public void accept(IModelVisitor visitor) {
        visitor.visitDerivedDatatype(this);
    }
    
    @Override
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitDerivedType(this);
    }
    
    @Override
    public final InternalConstraint[] createConstraints(AbstractVariable declaration) throws CSTSemanticException {
        InternalConstraint[] constraintInstances = null;
        if (null != constraints && typeDeclaration != declaration) {
            constraintInstances = new InternalConstraint[constraints.length];
            
            //Copy and replace each instance of the internal declaration with the given instance
            for (int i = 0; i < constraints.length; i++) {
                ConstraintSyntaxTree oneConstraint = constraints[i].getConsSyntax();
                ConstraintReplacer replacer = new ConstraintReplacer(oneConstraint);
                Variable origin = new Variable(typeDeclaration);
                Variable replacement = new Variable(declaration);
                ConstraintSyntaxTree copiedCST =
                    (null != oneConstraint) ? replacer.replaceVariable(origin, replacement) : null;
                // Should be in same project as the declaration belongs to
                constraintInstances[i] = new InternalConstraint(this, copiedCST, declaration.getTopLevelParent());
            }
        }
        return constraintInstances;
    }
    
    @Override
    public boolean isAssignableFrom(IDatatype type) {
        IDatatype baseType = resolveToBasis(getBasisType());
        IDatatype otherType = resolveToBasis(type);
        boolean result;
        if (null != baseType) {
            result = baseType.isAssignableFrom(otherType);
        } else {
            // basic assignment compatibility
            result = (DTYPE.getDelegate() == this || TYPE == this) && type instanceof DerivedDatatype;
        }
        return result;
    }
    
    /**
     * Resolves the given type to its innermost basis datatype.
     * We cannot do this automatically, as otherwise the tests for assignable types, e.g. to Compounds, would fail.
     * 
     * @param type the type to be resolved
     * @return the innermost basis datatype, <code>type</code> if <code>type</code> is
     *    not a {@link DerivedDatatype}.
     */
    public static final IDatatype resolveToBasis(IDatatype type) {
        while (type instanceof DerivedDatatype) {
            type = ((DerivedDatatype) type).getBasisType();
        }
        return type;
    }
}
