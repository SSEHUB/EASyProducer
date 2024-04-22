/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model.rewrite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.AttributeAssignment.Assignment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.CustomDatatype;

/**
 * Stores elements of the {@link ProjectCopyVisitor}, which could not be copied completely as dependent elements
 * are not copied, yet. <br/>
 * Each element type is stored in a separate set to facilitate individual treatment and to allow that the elements
 * can be processed in an optimized order.
 * @author El-Sharkawy
 */
class UncopiedElementsContainer {
    
    /**
     * Container for holding {@link Assignment}, which could not copied so far.
     * @author El-Sharkawy
     *
     */
    static class UnresolvedAnnotationAssignment {
        private Assignment orgAssignment;
        private AttributeAssignment copiedParentBlock;
        
        /**
         * Returns the original {@link Assignment}, which could not be copied.
         * @return The original {@link Assignment} which still needs to be copied.
         */
        Assignment getUnresolvedAssignment() {
            return orgAssignment;
        }
        
        /**
         * Returns the target/copied {@link AttributeAssignment}.
         * @return The already copied parent.
         */
        AttributeAssignment getCopiedParent() {
            return copiedParentBlock;
        }
    }
    
    /**
     * Fallback for resolving elements containing constraint syntax trees
     * This container is a tuple of (translated parent, original default value).
     * @author El-Sharkawy
     *
     */
    static class UnresolvedSyntaxContainer {
        private ContainableModelElement copiedParent;
        private ConstraintSyntaxTree uncopiedCST;
        
        /**
         * Returns the already translated parent to which the default belongs to.
         * @return The {@link AbstractVariable} or {@link net.ssehub.easy.varModel.model.Constraint}
         * at where the cst shall be added to.
         */
        ContainableModelElement getCopiedParent() {
            return copiedParent;
        }
        
        /**
         * Returns the uncopied {@link ConstraintSyntaxTree}, which must still be translated.
         * @return The original cst
         */
        ConstraintSyntaxTree getOriginalSyntax() {
            return uncopiedCST;
        }
        
        @Override
        public String toString() {
            String result = copiedParent instanceof AbstractVariable ? copiedParent.getName() + " = " : "";
            return result + uncopiedCST.toString();
        }
    }
   
    /**
     * Set of copied {@link AbstractVariable}s, and their default values. Contrary to unresolvedDefaults,
     * these defaults could not be translated as some data types are still missing.
     */
    private Set<UnresolvedSyntaxContainer> uncopyableCSTs = new HashSet<UnresolvedSyntaxContainer>();
    
    /**
     * {@link AbstractVariable}s which could not be translated due to a missing data type.
     */
    private Set<AbstractVariable> unresolvedDeclarations = new HashSet<AbstractVariable>();
    
    /**
     * Set of custom data types which are dependent of other custom data types, not translated so far.
     */
    private Set<CustomDatatype> unresolvedDatatypes = new HashSet<CustomDatatype>();
    
    /**
     * Set of (original) annotations, which could not be translated so far.
     */
    private Set<Attribute> unresolvedAnnotations = new HashSet<Attribute>();
    
    /**
     * Set of (original) {@link ProjectInterface}s, which could not be copied as some of the exported declarations
     * are not already copied.
     */
    private Set<ProjectInterface> unresolvedInterfaces = new HashSet<ProjectInterface>();
    
    /**
     * {@link OperationDefinition}s, which are copied (also its parameter and so on), but of which the
     * {@link net.ssehub.easy.varModel.model.datatypes.CustomOperation} could not be copied due the nested
     * {@link net.ssehub.easy.varModel.cst.ConstraintSyntaxTree}.
     */
    private Set<OperationDefinition> incompleteOperations = new HashSet<OperationDefinition>();
    
    /**
     * {@link OperationDefinition}s, which are <b>not</b> copied due to missing dependencies, i.e., types. 
     */
    private Set<OperationDefinition> notCopiedOperations = new HashSet<OperationDefinition>();

    /**
     * Set of {@link FreezeBlock}s which could not be translated as some frozen elements or the
     * {@link FreezeBlock#getSelector()} could not be translated. Contains the original elements.
     */
    private Set<FreezeBlock> uncopiedFreezeBlocks = new HashSet<FreezeBlock>();
    
    /**
     * Set of {@link CompoundAccessStatement}s which could not be translated because the compound variable
     * was not copied so far.
     */
    private Set<CompoundAccessStatement> uncopiedCompoundAccesses = new HashSet<CompoundAccessStatement>();
    
    /**
     * Set of (copied parent, original assignment) for {@link Assignment}s, which could not be copied so far.
     */
    private Set<UnresolvedAnnotationAssignment> unresolvedAssignments = new HashSet<UnresolvedAnnotationAssignment>();
    
    /**
     * Adds a custom data type which could not be translated as it is dependent of another custom data type, which
     * hasn't been copied so far.
     * @param unresolvedType The unresolved data type, which still has to be translated.
     */
    void addUnresolvedType(CustomDatatype unresolvedType) {
        unresolvedDatatypes.add(unresolvedType);
    }
    
    /**
     * Returns the set of all unresolved (original) data types which could not be translated so far.
     * @return The unresolved data types
     */
    Set<CustomDatatype> getUnresolvedTypes() {
        return unresolvedDatatypes;
    }
    
    /**
     * Adds an annotation, which could not be translated so far (due to missing attributable element or type).
     * @param originalAttribute The original attribute which could not be translated at this moment.
     */
    void addUnresolvedAnnotation(Attribute originalAttribute) {
        unresolvedAnnotations.add(originalAttribute);
    }
    
    /**
     * Adds an {@link AbstractVariable}, which could not be translated so far (due to missing type).
     * @param declWithUnresolvedType The original declaration which could not be translated at this moment.
     */
    void addUnresolvedDeclarationType(AbstractVariable declWithUnresolvedType) {
        unresolvedDeclarations.add(declWithUnresolvedType);
    }
    
    /**
     * Returns the set of original declarations, which could not be translated due to missing {@link CustomDatatype}s.
     * This set may be changed as a side effect during resolving default values.
     * @return Declarations which could not be translated.
     */
    Set<AbstractVariable> getDeclarationsWithMissingTypes() {
        return unresolvedDeclarations;
    }
    
    /**
     * Adds an original {@link ProjectInterface}, which could not be copied, as some of the exported declarations
     * are not already copied.
     * @param orgInterface The original project interface, which must be copied at a later point.
     */
    void addUnresolvedProjectInterface(ProjectInterface orgInterface) {
        unresolvedInterfaces.add(orgInterface);
    }
    
    /**
     * Returns the set of uncopied project interfaces, which still has to be copied.
     * This set may be changed as a side effect during successful copying.
     * @return The set of outstanding interfaces.
     */
    Set<ProjectInterface> getUnresolvedProjectInterfaces() {
        return unresolvedInterfaces;
    }
    
    /**
     * Adds a copied {@link OperationDefinition}, of which the nested
     * {@link net.ssehub.easy.varModel.cst.ConstraintSyntaxTree} could not be copied.
     * @param incompleteOperation The incomplete {@link OperationDefinition} of which the cst must be fixed at a later
     *     time.
     */
    void addIncompleteOperation(OperationDefinition incompleteOperation) {
        incompleteOperations.add(incompleteOperation);
    }
    
    /**
     * Returns the set of incompletely copied {@link OperationDefinition}s of which the nested
     * {@link net.ssehub.easy.varModel.cst.ConstraintSyntaxTree} must be corrected.
     * @return The set of incomplete {@link OperationDefinition}s.
     */
    Set<OperationDefinition> getIncompleteOperations() {
        return incompleteOperations;
    }
    
    /**
     * Adds an original {@link OperationDefinition}, which could not be copied at all.
     * @param notCopiedOperation An original and not copied operation definition, which must be copied at a later time.
     */
    void addUnCopiedOperation(OperationDefinition notCopiedOperation) {
        notCopiedOperations.add(notCopiedOperation);
    }
    
    /**
     * Returns the set of {@link OperationDefinition}s, which could not be copied (also not partially), due to missing
     * types. The complete {@link OperationDefinition} must still be copied.
     * @return The set original {@link OperationDefinition}s which still have to be copied.
     */
    Set<OperationDefinition> getUncopiedOperations() {
        return notCopiedOperations;
    }
    
    
    /**
     * Adds an original {@link FreezeBlock}, which could not be copied at all. This block is depending on uncopied
     * frozen elements or on an uncopyable {@link FreezeBlock#getIter()}
     * @param notCopiedBlock An original and not copied {@link FreezeBlock}.
     */
    void addFreezeBlock(FreezeBlock notCopiedBlock) {
        uncopiedFreezeBlocks.add(notCopiedBlock);
    }
    
    /**
     * Returns the set of {@link FreezeBlock}s, which could not be copied.
     * @return The set original {@link FreezeBlock}s which still have to be copied.
     */
    Set<FreezeBlock> getUncopiedFreezeBlocks() {
        return uncopiedFreezeBlocks;
    }
    
    /**
     * Adds an original {@link CompoundAccessStatement}, which could not be copied at all. This access is depending on
     * a {@link AbstractVariable} which was not copied so far.
     * @param notCopiedCompoundAccess An original and not copied {@link CompoundAccessStatement}.
     */
    void addCompoundAccess(CompoundAccessStatement notCopiedCompoundAccess) {
        uncopiedCompoundAccesses.add(notCopiedCompoundAccess);
    }
    
    /**
     * Returns the set of {@link CompoundAccessStatement}s, which could not be copied.
     * @return The set original {@link CompoundAccessStatement}s which still have to be copied.
     */
    Set<CompoundAccessStatement> getUncopiedCompoundAccesses() {
        return uncopiedCompoundAccesses;
    }
    
    /**
     * Adds an {@link Assignment}, which could not be copied so far.
     * @param copiedParent The already copied parent block for the assignment.
     * @param uncopiedAssignment The original {@link Assignment}, which still has to be copied.
     */
    void addUncopiedAssignment(AttributeAssignment copiedParent, Assignment uncopiedAssignment) {
        UnresolvedAnnotationAssignment outstandingAssignment = new UnresolvedAnnotationAssignment();
        outstandingAssignment.orgAssignment = uncopiedAssignment;
        outstandingAssignment.copiedParentBlock = copiedParent;
        unresolvedAssignments.add(outstandingAssignment);
    }
    
    /**
     * Returns the set of uncopied {@link Assignment}s.
     * @return tuple of (copied parent, original assignment) for {@link Assignment}s, which could not be copied so far
     */
    Set<UnresolvedAnnotationAssignment> getUncopiedAnnotationAssignments() {
        return unresolvedAssignments;
    }
    
    /**
     * Adds an CST which could not be copied so far, also not partially.
     * @param copiedParent The already copied declaration or constraint to where the cst belongs to
     * @param originalCST The original syntax, which can not be copied (even partially)
     */
    void addUncopyableCST(ContainableModelElement copiedParent, ConstraintSyntaxTree originalCST) {
        UnresolvedSyntaxContainer unresolvedDefault = new UnresolvedSyntaxContainer();
        unresolvedDefault.copiedParent = copiedParent;
        unresolvedDefault.uncopiedCST = originalCST;
        uncopyableCSTs.add(unresolvedDefault);
    }
    
    /**
     * Returns the set of uncopied constraint syntax trees.
     * @return tuple of (copied parent (AbstractVariable or Constraint), original CST)
     */
    Set<UnresolvedSyntaxContainer> getUncopyableCSTs() {
        return uncopyableCSTs;
    }
    
    /**
     * Maybe called after {@link ProjectCopyVisitor#getCopiedProject()} to verify that all elements could
     * successfully be copied.
     * @return A list of failing elements, should be empty if copying was successful.
     */
    List<UncopiedElement> getUnresolvedElements() {
        List<UncopiedElement> unrelsovedElements = new ArrayList<UncopiedElement>();
        addAll(unrelsovedElements, unresolvedDatatypes);
        addAll(unrelsovedElements, unresolvedDeclarations);
        if (!uncopyableCSTs.isEmpty()) {
            for (UnresolvedSyntaxContainer uncopyableCST : uncopyableCSTs) {
                unrelsovedElements.add(new UncopiedElement(uncopyableCST));
            }
        }
        addAll(unrelsovedElements, unresolvedAnnotations);
        addAll(unrelsovedElements, unresolvedInterfaces);
        addAll(unrelsovedElements, incompleteOperations);
        addAll(unrelsovedElements, notCopiedOperations);
        addAll(unrelsovedElements, uncopiedFreezeBlocks);
        addAll(unrelsovedElements, uncopiedCompoundAccesses);       
        if (!unresolvedAssignments.isEmpty()) {
            for (UnresolvedAnnotationAssignment unresolvedAssignment : unresolvedAssignments) {
                unrelsovedElements.add(new UncopiedElement(unresolvedAssignment));
            }
        }
        
        return unrelsovedElements;
    }
    
    /**
     * Converts {@link ContainableModelElement}s into {@link UncopiedElement}s and adds them to
     * {@code unrelsovedElements}.
     * Part of {@link #getUnresolvedElements()}.
     * @param unrelsovedElements The list where to add the elements.
     * @param elementsToAdd An attribute of this class, maybe empty.
     */
    private void addAll(List<UncopiedElement> unrelsovedElements,
        Collection<? extends ContainableModelElement> elementsToAdd) {
        
        if (!elementsToAdd.isEmpty()) {
            for (ContainableModelElement element : elementsToAdd) {
                unrelsovedElements.add(new UncopiedElement(element));
            }
        }
    }
}
