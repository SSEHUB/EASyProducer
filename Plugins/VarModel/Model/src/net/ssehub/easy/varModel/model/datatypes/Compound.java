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
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

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
import net.ssehub.easy.varModel.model.ModelQuery;
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
    public static final Operation NOTEQUALS_ALIAS = Operation.createInfixOperator(BooleanType.TYPE, 
            OclKeyWords.UNEQUALS_ALIAS, TYPE, TYPE);    
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
        DTYPE.addOperation(NOTEQUALS_ALIAS);
        DTYPE.addOperation(ASSIGNMENT);
        DTYPE.addOperation(IS_DEFINED);
    }

    private boolean isAbstract;
    private Compound[] refines;
    // stores the contained elements in sequence for proper output

    // TODO revise dependency direction
    private BasicDecisionVariableContainer container = new BasicDecisionVariableContainer();

    /**
     * Creates the singleton instance for {@link #TYPE}.
     */
    private Compound() {
        this("<Compound>", null, (Compound[]) null);
    }
    
    /**
     * Constructor for a non-abstract compound.
     * 
     * @param name name of the compound
     * @param parent the object, in which this specific one is embedded
     */
    public Compound(String name, ModelElement parent) {
        this(name, parent, (Compound[]) null);
    }

    /**
     * Constructor for a non-abstract (potentially refined) compound. [convenience]
     * 
     * @param name name of the compound
     * @param parent the object, in which this specific one is embedded
     * @param refines the super compound (may be <b>null</b> if there is no refinement).
     */
    public Compound(String name, ModelElement parent, Compound refines) {
        this(name, parent, null == refines ? null : new Compound[] {refines});
    }

    /**
     * Constructor for a non-abstract (potentially refined) compound.
     * 
     * @param name name of the compound
     * @param parent the object, in which this specific one is embedded
     * @param refines the super compounds (may be <b>null</b> if there is no refinement, no entry must be <b>null</b>).
     */
    public Compound(String name, ModelElement parent, Compound... refines) {
        super(name, DTYPE, parent);
        this.refines = refines;
    }

    /**
     * Constructor for a (potentially abstract, refined) compound. [convenience]
     * 
     * @param name name of the compound
     * @param isAbstract whether this compound is abstract
     * @param parent the object, in which this specific one is embedded
     * @param refines the super compound (may be <b>null</b> if there is no refinement)
     */
    public Compound(String name, ModelElement parent, boolean isAbstract, Compound refines) {
        this(name, parent, isAbstract, null == refines ? null : new Compound[] {refines});
    }
    
    /**
     * Constructor for a (potentially abstract, refined) compound.
     * 
     * @param name name of the compound
     * @param isAbstract whether this compound is abstract
     * @param parent the object, in which this specific one is embedded
     * @param refines the super compound(s) (may be <b>null</b> if there is no refinement, no entry must be <b>null</b>)
     */
    public Compound(String name, ModelElement parent, boolean isAbstract, Compound... refines) {
        super(name, DTYPE, parent);
        this.isAbstract = isAbstract;
        this.refines = refines;
    }
    
    /**
     * Setter for the parent/ super compound of a refinement.
     * This method is for incremental build during parsing a IVML file.
     * 
     * @param refines The super/parent compounds of this compound (may be <b>null</b>, no entry must be <b>null</b>).
     */
    public void setRefines(Compound[] refines) {
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
     * The number of refines.
     * 
     * @return the number of refines
     */
    public int getRefinesCount() {
        return null == refines ? 0 : refines.length;
    }

    /**
     * Returns the compound which is refined by this compound.
     * 
     * @param index the index of the refined compound to return
     * @return the refined compound
     * @throws IndexOutOfBoundsException if <code>index < 0 || index&gt;={@link #getRefinesCount()}</code>
     */
    public Compound getRefines(int index) {
        if (null == refines) {
            throw new IndexOutOfBoundsException();
        }
        return refines[index];
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
                cmpMatches = ((Compound) type).isRefinedFrom(this, true);
            }
            result = classMatches && cmpMatches;
        }
        return result;
    }
    
    // --------------------------------- delegation part --------------------------------------
    
    @Override
    public boolean add(DecisionVariableDeclaration elem) {
        boolean alreadyIn = false;
        //avoid direct overlaps, false for shadowing
        //alreadyIn = containsByNameRefines(elem.getName());
        if (!alreadyIn) {
            // Was already in if container.add returns false
            alreadyIn = !container.add(elem);
        }
        return !alreadyIn;
    }

    /**
     * Returns whether <code>name</code> is already contained in this or a refined compound.
     * 
     * @param name the name of the element
     * @return <code>true</code> for contained, <code>false</code> else
     */
    public boolean containsByNameRefines(String name) {
        boolean contains = container.containsByName(name);
        for (int r = 0; !contains && r < getRefinesCount(); r++) {
            contains = getRefines(r).containsByName(name);
        }
        return contains;
    }
    
    /**
     * Whether this compound is directly or indirectly refined from <code>cmp</code>.
     * 
     * @param cmp the cmp to look for
     * @param transitive whether refines of refines shall be considered
     * @return <code>true</code> if this compound is directly or indirectly refined from <code>cmp</code>
     */
    public boolean isRefinedFrom(Compound cmp, boolean transitive) {
        boolean refined = false;
        for (int r = 0; !refined && r < getRefinesCount(); r++) {
            refined = getRefines(r) == cmp || (transitive && getRefines(r).isRefinedFrom(cmp, true));
        }
        return refined;
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
        for (int r = 0; r < getRefinesCount(); r++) {
            elementCount += getRefines(r).getInheritedElementCount();
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
        for (int r = 0; null == element && r < getRefinesCount(); r++) {
            Compound ref = getRefines(r);
            int last = inheritedCount;
            inheritedCount += ref.getInheritedElementCount();
            if (index < inheritedCount) {
                element = ref.getInheritedElement(index - last);
            }
        }
        if (index >= inheritedCount) {
            element = getDeclaration(index - inheritedCount);
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
        for (int r = 0; null == decl && r < getRefinesCount(); r++) {
            decl = getRefines(r).getElement(name);
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

    @Override
    public void forceUpdate() {
        container.forceUpdate();
        if (null != refines) {
            for (int r = 0; r < getRefinesCount(); r++) {
                getRefines(r).forceUpdate();
            }
        }
    }

    /**
     * Determines the (absolute) refinement distance from <b>this</b> to <code>cmp</code> considering <b>this</b> or 
     * <code>cmp</code> as alternative bases to search the hierarchy for.
     * 
     * @param cmp the compound to determine the distance to
     * @return the (absolute) refines distance between <b>this</b> and <code>cmp</code>, <code>0</code> for the same, 
     * <code>-1</code> for no common refinement hierarchy
     */
    public int getRefinesDistanceTo(Compound cmp) {
        return getRefinesDistanceTo(cmp, true);
    }

    /**
     * Determines the (absolute) refinement distance from <b>this</b> to <code>cmp</code> optionally considering 
     * <b>this</b> or <code>cmp</code> as alternative bases to search the hierarchy for.
     * 
     * @param cmp the compound to determine the distance to
     * @param checkOpposite if also the distance between <code>cmp</code> and <b>this</b> shall be considered as 
     *     result (top-level non-recursive call)
     * @return the (absolute) refines distance between <b>this</b> and <code>cmp</code>, <code>0</code> for the same, 
     * <code>-1</code> for no common refinement hierarchy
     */
    private int getRefinesDistanceTo(Compound cmp, boolean checkOpposite) {
        int result = -1;
        if (TypeQueries.sameTypes(cmp, this)) {
            result = 0;
        } else {
            result = this.findRefinesDistanceTo(result, cmp);
            if (checkOpposite) {
                result = cmp.findRefinesDistanceTo(result, this);
            }
        }
        return result;        
    }

    /**
     * Iterates over {@link #getRefines(int)} to identify the refines distance from <b>this</b> to <code>cmp</code>
     * using <code>res</code> as initial result. No search is performed if <code>res</code> is not negative, i.e., 
     * already a distance was determined.
     * 
     * @param res the initial result to start with
     * @param cmp the compound to search the refines hierarchy in a recursive manner
     * @return the refines distance, <code>0</code> for the same, <code>-1</code> for no common refinement hierarchy
     */
    private int findRefinesDistanceTo(int res, Compound cmp) {
        int result = res;
        for (int r = 0; result < 0 && r < cmp.getRefinesCount(); r++) {
            int tmp = getRefinesDistanceTo(cmp.getRefines(r), false);
            if (tmp >= 0) {
                result = tmp + 1; // +1 distance from this to refines
            }
        }
        return result;
    }
    
    /**
     * Finds all implementing compound types for this compound searching within <code>scope</code> and transitive 
     * imports.
     * 
     * @param scope the scope to search for
     * @return the implementing compound types including <b>this</b>
     * @see ModelQuery#findRefining(IResolutionScope, Compound)
     */
    public Collection<Compound> allImplementing(IResolutionScope scope) {
        Collection<Compound> candidates = ModelQuery.findRefining(scope, this);
        candidates.add(this);
        return candidates;
    }

    /**
     * Finds the implementing non-abstract types for this compound, i.e., the ones that may instantiate this compound.
     * Searches within <code>scope</code> and transitive imports.
     * 
     * @param scope the scope to search for
     * @return the implementing non-abstract compound types considering <b>this</b>
     * @see #allImplementing(IResolutionScope)
     */
    public Collection<Compound> implementingNonAbstract(IResolutionScope scope) {
        return pruneAbstract(allImplementing(scope));
    }

    /**
     * Prunes abstract compounds from <code>compounds</code>.
     * 
     * @param compounds the compounds to consider (may be <b>null</b>, the the result is also <b>null</b>)
     * @return <code>compounds</code> without abstract compounds (modifies <code>compounds</code>)
     */
    public static Collection<Compound> pruneAbstract(Collection<Compound> compounds) {
        return prune(compounds, true);
    }

    /**
     * Prunes non-abstract compounds from <code>compounds</code>.
     * 
     * @param compounds the compounds to consider (may be <b>null</b>, the the result is also <b>null</b>)
     * @return <code>compounds</code> without non-abstract compounds (modifies <code>compounds</code>)
     */
    public static Collection<Compound> pruneNonAbstract(Collection<Compound> compounds) {
        return prune(compounds, false);
    }

    /**
     * Prunes from <code>compounds</code>.
     * 
     * @param compounds the compounds to consider (may be <b>null</b>, the the result is also <b>null</b>)
     * @param pruneAbstract if <code>true</code> prune abstract compounds, if <code>false</code> prune non-abstract 
     *     compounds
     * @return <code>compounds</code> without those to be pruned (modifies <code>compounds</code>)
     */
    private static Collection<Compound> prune(Collection<Compound> compounds, boolean pruneAbstract) {
        if (null != compounds) {
            Iterator<Compound> iter = compounds.iterator();
            while (iter.hasNext()) {
                Compound cmp = iter.next();
                if ((pruneAbstract && cmp.isAbstract()) || (!pruneAbstract && !cmp.isAbstract())) {
                    iter.remove();
                }
            }
        }
        return compounds;
    }

    /**
     * Returns the compounds from <code>compounds</code> that have minimum 
     * {@link #getRefinesDistanceTo(Compound) refines distance} to <b>this</b>.
     * 
     * @param compounds the compounds to analyze
     * @return the selected compounds, may be empty
     * @see #getRefinesDistanceTo(Compound)
     */
    public Collection<Compound> closestRefining(Collection<Compound> compounds) {
        int minDist = -1;
        List<Compound> result = new ArrayList<Compound>();
        for (Compound c : compounds) {
            int dist = this.getRefinesDistanceTo(c);
            if (dist >= 0) { // ignore non-related
                if (minDist < 0 || dist < minDist) { // rest if new minimum
                    minDist = dist;
                    result.clear();
                    result.add(c);
                } else if (dist == minDist) { // add if also at current minimum
                    result.add(c);
                }
            }
        }
        return result;
    }

    // avoid (further) type queries here -> TypeQueries

}
