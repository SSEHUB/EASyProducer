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

import java.util.Comparator;

import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.BasicDecisionVariableContainer;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.EvaluationBlock;
import net.ssehub.easy.varModel.model.IConstraintHolder;
import net.ssehub.easy.varModel.model.IDecisionVariableContainer;
import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.ProjectImport;

/**
 * A compound type groups multiple types into a single named unit.
 * 
 * So far we refrained from defining (multiple) recursive iterators (over the assignments) due to different style and
 * potential performance issues of the generic code.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/
public class Compound extends StructuredDatatype implements IResolutionScope, IDecisionVariableContainer, 
    IConstraintHolder {

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
    
    public static final Operation IS_DEFINED = new Operation(BooleanType.TYPE, OclKeyWords.IS_DEFINED, TYPE)
         .markAsAcceptsNull();    
    // checkstyle: resume declaration order check

    static {
        DTYPE.setDelegate(new Compound());
        DTYPE.addOperation(TYPE_OF);
        DTYPE.addOperation(EQUALS);
        DTYPE.addOperation(NOTEQUALS);
        DTYPE.addOperation(ASSIGNMENT);
        DTYPE.addOperation(IS_DEFINED);
    }

    private boolean isAbstract;
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
     * Constructor for a non-abstract compound.
     * 
     * @param name name of the compound
     * @param parent the object, in which this specific one is embedded
     */
    public Compound(String name, ModelElement parent) {
        this(name, parent, null);
    }
    
    /**
     * Constructor for a non-abstract (potentially refined) compound.
     * 
     * @param name name of the compound
     * @param parent the object, in which this specific one is embedded
     * @param refines the super compound (may be <b>null</b> if there is no refinement).
     */
    public Compound(String name, ModelElement parent, Compound refines) {
        super(name, DTYPE, parent);
        this.refines = refines;
    }
    
    /**
     * Constructor for a (potentially abstract, refined) compound.
     * 
     * @param name name of the compound
     * @param isAbstract whether this compound is abstract
     * @param parent the object, in which this specific one is embedded
     * @param refines the super compound (may be <b>null</b> if there is no refinement)
     */
    public Compound(String name, ModelElement parent, boolean isAbstract, Compound refines) {
        super(name, DTYPE, parent);
        this.isAbstract = isAbstract;
        this.refines = refines;
    }
    
    /**
     * Setter for the parent/ super compound of a refinement.
     * This method is for incremental build during parsing a ivml file.
     * @param refines The super/parent compound of this compound.
     */
    public void setRefines(Compound refines) {
        this.refines = refines;
    }

    @Override
    public int getImportsCount() {
        return 0;
    }

    @Override
    public ProjectImport getImport(int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean hasInterfaces() {
        return false;
    }

    @Override
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
    
    /**
     * Returns the refinement basis, i.e., the topmost refined compound.
     * 
     * @return the topmost refined compound or <b>this</b> if this compound does not refine another compound
     */
    public Compound getRefinementBasis() {
        Compound basis = this;
        while (null != basis.getRefines()) {
            basis = basis.getRefines();
        }
        return basis;
    }
    
    // --------------------------------- delegation part --------------------------------------
    
    @Override
    public boolean add(DecisionVariableDeclaration elem) {
        boolean alreadyIn = false;
        Compound basisCP = getRefines();
        while (null != basisCP && !alreadyIn) {
            alreadyIn = basisCP.container.containsByName(elem.getName());
            basisCP = basisCP.getRefines();
        }
        
        if (!alreadyIn) {
            // Was already in if container.add returns false
            alreadyIn = !container.add(elem);
        }
        
        return !alreadyIn;
    }
    
    @Override
    public int getElementCount() {
        return container.getElementCount();
    }
    
    @Override
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
    
    @Override
    public boolean contains(DecisionVariableDeclaration var) {
        return container.contains(var);
    }
    
    @Override
    public DecisionVariableDeclaration getElement(String name) {
        DecisionVariableDeclaration decl = container.getElement(name);
        if (null == decl && null != refines) {
            decl = refines.getElement(name);
        }
        return decl;
    }

    @Override
    public void addConstraint(Constraint constraint, boolean internal) {
        container.addConstraint(constraint, internal);
    }
    
    @Override
    public int getConstraintsCount() {
        return container.getConstraintsCount();
    }
    
    @Override
    public Constraint getConstraint(int index) {
        return container.getConstraint(index);
    }
    
    @Override
    public void sortContainedElements(Comparator<ContainableModelElement> comp) {
        container.sortContainedElements(comp);
    }
    
    @Override
    public ContainableModelElement getModelElement(int index) {
        return container.getModelElement(index);
    }

    @Override
    public int getModelElementCount() {
        return container.getModelElementCount();
    }
    
    @Override
    public void add(Comment comment) {
        container.add(comment);
    }

    @Override
    public void add(AttributeAssignment assignment) {
        container.add(assignment);
    }
    
    @Override
    public int getAssignmentCount() {
        return container.getAssignmentCount();
    }
    
    @Override
    public AttributeAssignment getAssignment(int index) {
        return container.getAssignment(index);
    }
    
    @Override
    public boolean propagateAttribute(Attribute attribute) {
        return container.propagateAttribute(attribute);
    }

    @Override
    public int getRealizingCount() {
        return container.getRealizingCount();
    }
    
    @Override
    public Constraint getRealizing(int index) {
        return container.getRealizing(index);
    }

    @Override
    public int getDeclarationCount() {
        return container.getDeclarationCount();
    }

    @Override
    public DecisionVariableDeclaration getDeclaration(int index) {
        return container.getDeclaration(index);
    }
    
    /**
     * Returns whether this compound is abstract, i.e., whether it can be instantiated.
     * 
     * @return <code>true</code> if this compound is abstract, <code>false</code> else
     */
    public boolean isAbstract() {
        return isAbstract;
    }

    @Override
    public void addConstraint(Constraint constraint) {
        addConstraint(constraint, false);
    }
    
    /**
     * Removes the specified model element from this compound (if it exists).
     * @param element The {@link Constraint}, {@link DecisionVariableDeclaration}, or {@link AttributeAssignment}
     * to remove. If <tt>null</tt> nothing will happen.
     * @return <tt>true</tt> if the model element was part of this compound and was removed successfully.
     */
    public boolean removeConstraint(ContainableModelElement element) {
        return container.removeModelElement(element);
    }

    @Override
    public void add(EvaluationBlock eval) {
        container.add(eval);
    }
    
    @Override
    public boolean containsByName(String name) {
        return container.containsByName(name);
    }

}
