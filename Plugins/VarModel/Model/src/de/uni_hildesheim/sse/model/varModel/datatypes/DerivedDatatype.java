package de.uni_hildesheim.sse.model.varModel.datatypes;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstraintReplacer;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.Variable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.InternalConstraint;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.Project;

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
                ConstraintSyntaxTree copiedCST = replacer.replaceVariable(origin, replacement);
                // Should be in same project as the declaration belongs to
                constraintInstances[i] = new InternalConstraint(this, copiedCST, declaration.getTopLevelParent());
            }
        }
        return constraintInstances;
    }
    
    @Override
    public boolean isAssignableFrom(IDatatype type) {
        IDatatype baseType = getBasisType();
        IDatatype otherType = type;
        while (baseType instanceof DerivedDatatype) {
            baseType = ((DerivedDatatype) baseType).getBasisType();
        }
        while (otherType instanceof DerivedDatatype) {
            otherType = ((DerivedDatatype) otherType).getBasisType();
        }
        return baseType.isAssignableFrom(otherType);
    }
}
