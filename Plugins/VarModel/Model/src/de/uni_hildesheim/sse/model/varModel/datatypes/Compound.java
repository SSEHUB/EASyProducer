package de.uni_hildesheim.sse.model.varModel.datatypes;

import java.util.Comparator;

import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.BasicDecisionVariableContainer;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IDecisionVariableContainer;
import de.uni_hildesheim.sse.model.varModel.IModelVisitor;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;

/**
 * A compound type groups multiple types into a single named unit.
 * 
 * So far we refrained from defining (multiple) recursive iterators (over the assignments) due to different style and
 * potential performance issues of the generic code.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/
public class Compound extends StructuredDatatype implements IResolutionScope, IDecisionVariableContainer {

    // DO !NOT! touch the // checkstyle: comments!

    // checkstyle: stop declaration order check
    static final DelegatingType DTYPE = new DelegatingType(AnyType.DTYPE);
    
    /**
     * This constant represents the common type of all compounds. Each specific compound type 
     * is assignable to this type.
     */
    public static final IDatatype TYPE = DTYPE;

    // basic from any
    public static final Operation TYPE_OF = new Operation(MetaType.TYPE, OclKeyWords.TYPE_OF, TYPE);
    // we assume normalized operations to OCL -> simplifies reasoner translation
    public static final Operation EQUALS = Operation.createInfixOperator(BooleanType.TYPE, 
         OclKeyWords.EQUALS, TYPE, TYPE).markAsAssignableParameterOperation();
    public static final Operation NOTEQUALS = Operation.createInfixOperator(BooleanType.TYPE, 
         OclKeyWords.UNEQUALS, TYPE, TYPE);    
    public static final Operation ASSIGNMENT = Operation.createInfixOperator(BooleanType.TYPE, 
         OclKeyWords.ASSIGNMENT, TYPE, TYPE);
    
    public static final Operation IS_DEFINED = new Operation(BooleanType.TYPE, OclKeyWords.IS_DEFINED, TYPE);    
    // checkstyle: resume declaration order check

    static {
        DTYPE.setDelegate(new Compound());
        DTYPE.addOperation(TYPE_OF);
        DTYPE.addOperation(EQUALS);
        DTYPE.addOperation(NOTEQUALS);
        DTYPE.addOperation(ASSIGNMENT);
        DTYPE.addOperation(IS_DEFINED);
    }

    private Compound refines;
    // stores the contained elements in sequence for proper output

    // TODO revise dependency direction
    private BasicDecisionVariableContainer container = new BasicDecisionVariableContainer();

    /**
     * Creates the singleton instance for {@link #TYPE}.
     */
    private Compound() {
        this("<Compound>", null, null);
    }
    
    /**
     * Constructor for the compound.
     * @param name Name of the compound
     * @param parent the object, in which this specific one is embedded
     */
    public Compound(String name, ModelElement parent) {
        this(name, parent, null);
    }
    
    /**
     * Constructor for the compound, which initializes the attribute refins.
     * @param name name of the compound
     * @param parent the object, in which this specific one is embedded
     * @param refines the super Compound.
     */
    public Compound(String name, ModelElement parent, Compound refines) {
        super(name, DTYPE, parent);
        this.refines = refines;
    }

    /**
     * {@inheritDoc}
     */
    public int getImportsCount() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public ProjectImport getImport(int index) {
        throw new IndexOutOfBoundsException();
    }

    /**
     * {@inheritDoc}
     */
    public boolean hasInterfaces() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    public boolean isInterface() {
        return false;
    }

    /**
     * Returns the compound which is refined by this compound.
     * 
     * @return the refined compound (or <b>null</b> if there is none)
     */
    public Compound getRefines() {
        return refines;
    }
        
    /** 
     * Accept method for the visitor.
     * 
     * @param visitor The visitor, which should process this model element.
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitCompound(this);
    }
    
    /**
     * Accepts a specialized visitor for creating a textual representation
     * of the identity of this type.
     *  
     * @param visitor the visitor to accept
     */
    public void accept(IDatatypeVisitor visitor) {
        visitor.visitCompoundType(this);
    }
    
    /**
    * Determines if the data type represented by this
    * object is either the same as, or is a supertype of 
    * <code>type</code>.
    * 
    * @param type the type being checked
    * @return <code>true</code> if this type is either the same or a 
    *   supertype of <code>type</code>, <code>true</code> else
    */
    @Override
    public boolean isAssignableFrom(IDatatype type) {
        boolean result = false;
        // not nice but working for now
        boolean classMatches = super.isAssignableFrom(type);
        boolean isMetaType = this.getType() == TYPE.getType() || type.getType() == TYPE.getType();
        boolean isTypeNull = AnyType.TYPE.getType() == type.getType();
        boolean cmpMatches = this == type || isMetaType || isTypeNull;
        if (isTypeNull) {
            result = true;
        } else {
            // Check whether one of the parents match
            if (!cmpMatches && type instanceof Compound) {
                Compound tmpCmp = (Compound) type;
                while (!cmpMatches && null != tmpCmp.getRefines()) {
                    cmpMatches |= tmpCmp.getRefines() == this;
                    tmpCmp = tmpCmp.getRefines();
                }   
            }
            
            result = classMatches && cmpMatches;
        }
        return result;
    }
    
    // --------------------------------- delegation part --------------------------------------
    
    /**
     * {@inheritDoc}
     */
    public boolean add(DecisionVariableDeclaration elem) {
        return container.add(elem);
    }
    
    /**
     * {@inheritDoc} 
     */
    public int getElementCount() {
        return container.getElementCount();
    }
    
    /**
     * {@inheritDoc} 
     */
    public DecisionVariableDeclaration getElement(int index) {
        return container.getElement(index);
    }
    
    /**
     * Same behavior as {@link #getElementCount()}, but also considers inherited elements if this
     * compound is a refinement of another compound.
     * @return The number of contained elements
     */
    public int getInheritedElementCount() {
        int elementCount = container.getDeclarationCount();
        
        if (null != getRefines()) {
            elementCount += getRefines().getInheritedElementCount();
        }
            
        
        return elementCount;
    }
    
    /**
     * Same behavior as {@link #getElement(int)} but also considers inherited elements if this
     * compound is a refinement of another compound.
     * 
     * @param index a 0-based index specifying the nested element to be returned,
     *     inherited elements come first, elements of this compound at the end
     * @return the contained element
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getElementCount()}</code>
     */
    public DecisionVariableDeclaration getInheritedElement(int index) {
        DecisionVariableDeclaration element = null;
        int inheritedCount = 0;
        
        if (null != getRefines()) {
            inheritedCount = getRefines().getInheritedElementCount();
        }
        
        if (index < inheritedCount) {
            element = getRefines().getInheritedElement(index);
        } else {
            index -= inheritedCount;
            element = getDeclaration(index);
        }
        
        
        return element;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean contains(DecisionVariableDeclaration var) {
        return container.contains(var);
    }
    
    /**
     * {@inheritDoc}
     */
    public DecisionVariableDeclaration getElement(String name) {
        DecisionVariableDeclaration decl = container.getElement(name);
        if (null == decl && null != refines) {
            decl = refines.getElement(name);
        }
        return decl;
    }

    /**
     * {@inheritDoc}
     */
    public void addConstraint(Constraint constraint, boolean internal) {
        container.addConstraint(constraint, internal);
    }
    
    /**
     * {@inheritDoc}
     */
    public int getConstraintsCount() {
        return container.getConstraintsCount();
    }
    
    /**
     * {@inheritDoc}
     */
    public Constraint getConstraint(int index) {
        return container.getConstraint(index);
    }
    
    /**
     * {@inheritDoc}
     */
    public void sortContainedElements(Comparator<ContainableModelElement> comp) {
        container.sortContainedElements(comp);
    }
    
    /**
     * {@inheritDoc}
     */
    public ContainableModelElement getModelElement(int index) {
        return container.getModelElement(index);
    }

    /**
     * {@inheritDoc}
     */
    public int getModelElementCount() {
        return container.getModelElementCount();
    }
    
    /**
     * {@inheritDoc}
     */
    public void add(Comment comment) {
        container.add(comment);
    }

    /**
     * {@inheritDoc}
     */
    public void add(AttributeAssignment assignment) {
        container.add(assignment);
    }
    
    /**
     * {@inheritDoc}
     */
    public int getAssignmentCount() {
        return container.getAssignmentCount();
    }
    
    /**
     * {@inheritDoc}
     */
    public AttributeAssignment getAssignment(int index) {
        return container.getAssignment(index);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean propagateAttribute(Attribute attribute) {
        return container.propagateAttribute(attribute);
    }

    /**
     * {@inheritDoc}
     */
    public int getRealizingCount() {
        return container.getRealizingCount();
    }
    
    /**
     * {@inheritDoc}
     */
    public Constraint getRealizing(int index) {
        return container.getRealizing(index);
    }

    /**
     * {@inheritDoc}
     */
    public int getDeclarationCount() {
        return container.getDeclarationCount();
    }

    /**
     * {@inheritDoc}
     */
    public DecisionVariableDeclaration getDeclaration(int index) {
        return container.getDeclaration(index);
    }

}
