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

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.RestrictionEvaluationException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.AbstractProjectVisitor;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.EvaluationBlock;
import net.ssehub.easy.varModel.model.ExplicitTypeVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IAttributableElement;
import net.ssehub.easy.varModel.model.IFreezable;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IPartialEvaluable;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Creates a deep copy of a {@link Project}. <br/>
 * This visitor may change the ordering of elements inside the copied projects as it tries first to copy all elements,
 * which do not conflict and retries to copy depending elements after needed elements have been copied.
 * For instance:
 * <pre><code>
 * project p {
 *   CP1 decl;
 *   compound CP1 {}
 * }
 * </code></pre>
 * will be translated to
 * <pre><code>
 * project p {
 *   compound CP1 {}
 *   CP1 decl;
 * }
 * </code></pre>
 * @author El-Sharkawy
 */
public class ProjectCopyVisitor extends AbstractProjectVisitor {

    /**
     * Tuple of (oldProject, copiedProject) containing the mapping of copied projects.
     */
    private Map<Project, Project> copiedProjects;
    /**
     * Tuple of (oldElement, copiedElement) containing the mapping of copied model elements.
     * Needed for building parents and references, and to check whether an element was already copied or not.
     */
    private Map<ContainableModelElement, ContainableModelElement> copiedElements;
    /**
     * Sub set of {@link #copiedElements} with (oldDeclaration, copiedDeclaration).
     * This map is useful for the {@link CSTCopyVisitor}.
     */
    private Map<AbstractVariable, AbstractVariable> copiedDeclarations;
    
    /**
     * Stores elements which could not be copied (completely).
     */
    private UncopiedElementsContainer incompleteElements;

    /**
     * Already translated model elements, which should be used as current parent of a model element.
     * Used as a Stack.
     */
    private Deque<IModelElement> parents;
    
    /**
     * The copied projects (starting point). Will be <tt>null</tt> if only imports are translated.
     */
    private Project copiedProject;
    
    /**
     * Indicates that the currently visited elements shall <b>not</b> be added to the current parent, i.e., are local
     * elements.
     * <tt>true</tt>: Elements shall not be added
     * <tt>false</tt>: Usual behavior
     */
    private boolean visitLocalElements;
    
    /**
     * Dirty but needed for {@link #getTranslatedType(IDatatype)}: Tuple of (original project type, copied project).
     */
    private Map<IDatatype, Project> projectTypes;
    
    /**
     * Sole constructor for creating a copy of a {@link Project}.
     * @param originProject The project where the visiting shall start
     * @param filterType Specifies whether project imports shall be considered or not. All considered projects
     * (and imports) will be deep copied.
     */
    public ProjectCopyVisitor(Project originProject, FilterType filterType) {
        super(originProject, filterType);
        copiedProjects = new HashMap<Project, Project>();
        copiedElements = new HashMap<ContainableModelElement, ContainableModelElement>();
        copiedDeclarations = new HashMap<AbstractVariable, AbstractVariable>();
        incompleteElements = new UncopiedElementsContainer();
        projectTypes = new HashMap<IDatatype, Project>();
        parents = new ArrayDeque<IModelElement>();
        visitLocalElements = false;
    }
    
    @Override
    public void visitProjectImport(ProjectImport pImport) {
        ProjectImport copiedImport = new ProjectImport(pImport.getName(), pImport.getInterfaceName(),
            pImport.isConflict(), pImport.isCopied(), null);
        
        // Copy the created project
        super.visitProjectImport(pImport);
        
        Project orgResolved = pImport.getResolved();
        Project copyResolved = copiedProjects.get(orgResolved);
        if (null != copyResolved) {
            try {
                copiedImport.setResolved(copyResolved);
            } catch (ModelManagementException e) {
                // Should not be possible, since the original should be valid
                Bundle.getLogger(ProjectCopyVisitor.class).exception(e);
            }
            if (null != pImport.getVersionRestriction()) {
                try {
                    copiedImport.setRestrictions(pImport.copyVersionRestriction(copyResolved));
                } catch (RestrictionEvaluationException e) {
                    // Should not be possible, since the original should be valid
                    Bundle.getLogger(ProjectCopyVisitor.class).exception(e);
                }
            }
        } else if (null != pImport.getVersionRestriction() && null != orgResolved) {
            try {
                // Copy is based on the name, for this reason also the original should be ok
                copiedImport.setRestrictions(pImport.copyVersionRestriction(orgResolved));
            } catch (RestrictionEvaluationException e) {
                // Should not be possible, since the original should be valid
                Bundle.getLogger(ProjectCopyVisitor.class).exception(e);
            }
        }
        
        Project importingProject = (Project) parents.peekFirst();
        importingProject.addImport(copiedImport);
    }
    
    @Override
    public void visitProject(Project project) {
        Project copy = new Project(project.getName());
        copiedProjects.put(project, copy);
        projectTypes.put(project.getType(), copy);
        parents.addFirst(copy);
        if (project == getStartingProject()) {
            copiedProject = copy;
        }
        
        // Handle version
        Version originalVersion = project.getVersion();
        if (null != originalVersion) {
            int[] segments = new int[originalVersion.getSegmentCount()];
            for (int i = 0; i < segments.length; i++) {
                segments[i] = originalVersion.getSegment(i);
            }
            
            copy.setVersion(new Version(segments));
        }
        
        // Start visitation (imports, 
        super.visitProject(project);
        
        parents.pollFirst();
        
        // Finally at the end of the whole translation, try to fix all the missed elements
        if (project == getStartingProject()) {
            parents.clear();
            boolean elementsResolved = true;
            
            while (elementsResolved) {
                elementsResolved = false;
                
                // Handle uncopied custom types
                elementsResolved |= retryCopy(incompleteElements.getUnresolvedTypes().iterator());
                
                // Handle uncopied declarations (depending on custom types)
                elementsResolved |= retryCopy(incompleteElements.getDeclarationsWithMissingTypes().iterator());
                
                // Handle incomplete default values (depending on declarations)
                elementsResolved |= resolveIncompleteDefaultValues();
                
                // Handle incomplete constraints (depending on declarations)
                elementsResolved |= resolveIncompleteConstraints();
                
                // Handle uncopied interfaces (need that all exported declarations have been copied)
                elementsResolved |= retryCopy(incompleteElements.getUnresolvedProjectInterfaces().iterator());
                
                // Handle incomplete operations
                elementsResolved |= resolveIncompleteOperations();
                
                // Handle operations, depending on custom types
                elementsResolved |= retryCopy(incompleteElements.getUncopiedOperations().iterator());               
                
                // Handle uncopied CompoundAccesses (depending on declarations)
                visitLocalElements = true;
                elementsResolved |= retryCopy(incompleteElements.getUncopiedCompoundAccesses().iterator());
                visitLocalElements = false;
                
                // Handle uncopied FreezeBlocks (depending on declarations, CompoundAccesses and maybe on constraints)
                elementsResolved |= retryCopy(incompleteElements.getUncopiedFreezeBlocks().iterator());
            }
        }
    }
    
    /**
     * Part of the end of the coping: Tries to fix {@link ConstraintSyntaxTree}s of incomplete copied
     * {@link OperationDefinition}s.
     * @return <tt>true</tt> if at least one element was resolved, <tt>false</tt> no elements have been resolved,
     *     maybe because there was nothing to do.
     */
    private boolean resolveIncompleteOperations() {
        boolean elementsResolved = false;
        
        Iterator<OperationDefinition> opItr = incompleteElements.getIncompleteOperations().iterator();
        while (opItr.hasNext()) {
            OperationDefinition op = opItr.next();
            CustomOperation tmpCustomOp = op.getOperation();
            
            CSTCopyVisitor copyier = new CSTCopyVisitor(copiedDeclarations);
            tmpCustomOp.getFunction().accept(copyier);
            if (copyier.translatedCompletely()) {
                // Copy already copied parameters
                DecisionVariableDeclaration[] params
                = new DecisionVariableDeclaration[tmpCustomOp.getParameterCount()];
                for (int i = 0; i < params.length; i++) {
                    params[i] = tmpCustomOp.getParameterDeclaration(i);
                }
                
                // Create new custom operation
                CustomOperation finalCustomOp = new CustomOperation(tmpCustomOp.getReturns(),
                        tmpCustomOp.getName(), tmpCustomOp.getOperand(), copyier.getResult(), params);
                op.setOperation(finalCustomOp);
                
                // Remove from outstanding list
                opItr.remove();
                elementsResolved = true;
            }
        }
        return elementsResolved;
    }
    
    /**
     * Retries to copy not copied, original elements.
     * Part of the end of the copying process.
     * @param itr An iterator of {@link #incompleteElements}, pointing to original elements, which could not be copied.
     * @return <tt>true</tt> if at least one element was resolved, <tt>false</tt> no elements have been resolved,
     *     maybe because there was nothing to do.
     */
    private boolean retryCopy(Iterator<? extends IModelElement> itr) {
        boolean elementsResolved = false;
        
        while (itr.hasNext()) {
            IModelElement orgElement = itr.next();
            boolean ok = buildParents(orgElement);
            if (ok) {
                orgElement.accept(this);
                if (null != copiedElements.get(orgElement)) {
                    // Declaration was successfully copied
                    elementsResolved = true;
                    itr.remove();
                }
                
                // parents.clear is called if ok = false, therefore we called it here only inside the if
                parents.clear();
            }
        }
        return elementsResolved;
    }

    /**
     * Fills up the {@link #parents} stack in the correct order for elements which are copied at the end of the
     * visitation process as part of the {@link #visitProject(Project)} method.
     * This cleans up the current parent stack before filling it up with the currently needed parents.
     * @param orgElement The element which shall be copied in the next step, for which the parent stack shall be filled
     *   correctly.
     * @return <tt>true</tt> if the copied parents could be retrieved correctly, <tt>false</tt> if at least one needed
     *   parent was not copied and could not be added to the parent stack (in this case the stack is cleaned up).
     */
    private boolean buildParents(IModelElement orgElement) {
        parents.clear();
        // Collect parents in reverse order -> use deque as queue not as stack 
        IModelElement parent = orgElement;
        boolean abort = false;
        do {
            parent = parent.getParent();
            if (parent != null) {
                IModelElement copiedParent = null;
                if (parent instanceof Project) {
                    copiedParent = copiedProjects.get((Project) parent);
                } else {
                    copiedParent = copiedElements.get(parent);
                }
                if (null != copiedParent) {
                    parents.addLast(copiedParent);
                } else {
                    // Still missing parent
                    abort = true;
                }
            }
        } while (parent != null && !abort);
        
        if (abort) {
            parents.clear();
        }
        return !abort;
    }
    
    /**
     * Part of the end of the coping: Tries to fix default values, which could not be translated during
     * the regular visitation.
     * @return <tt>true</tt> if at least one element was resolved, <tt>false</tt> no elements have been resolved,
     *     maybe because there was nothing to do.
     */
    private boolean resolveIncompleteDefaultValues() {
        boolean elementsResolved = false;
        
        Iterator<AbstractVariable> declDefaultItr = incompleteElements.getDeclarationsWithMissingDefaults().iterator();
        while (declDefaultItr.hasNext()) {
            AbstractVariable decl = declDefaultItr.next();
            CSTCopyVisitor copyier = new CSTCopyVisitor(copiedDeclarations);
            decl.getDefaultValue().accept(copyier);
            if (copyier.translatedCompletely()) {
                try {
                    decl.setValue(copyier.getResult());
                    declDefaultItr.remove();
                    elementsResolved = true;
                } catch (ValueDoesNotMatchTypeException e) {
                    // Should not be possible, since the original was valid
                    Bundle.getLogger(ProjectCopyVisitor.class).exception(e);
                } catch (CSTSemanticException e) {
                    // Should not be possible, since the original was valid
                    Bundle.getLogger(ProjectCopyVisitor.class).exception(e);
                }
            }
        }
        return elementsResolved;
    }
    
    /**
     * Part of the end of the coping: Tries to fix constraints, which could not be translated during
     * the regular visitation.
     * @return <tt>true</tt> if at least one element was resolved, <tt>false</tt> no elements have been resolved,
     *     maybe because there was nothing to do.
     */
    private boolean resolveIncompleteConstraints() {
        boolean elementsResolved = false;
        
        Iterator<Constraint> constraintItr = incompleteElements.getUnresolvedconstraints().iterator();
        while (constraintItr.hasNext()) {
            Constraint constraint = constraintItr.next();
            CSTCopyVisitor copyier = new CSTCopyVisitor(copiedDeclarations, this);
            constraint.getConsSyntax().accept(copyier);
            if (copyier.translatedCompletely()) {
                try {
                    constraint.setConsSyntax(copyier.getResult());
                    constraintItr.remove();
                    elementsResolved = true;
                } catch (CSTSemanticException e) {
                    // Should not be possible, since the original was valid
                    Bundle.getLogger(ProjectCopyVisitor.class).exception(e);
                }
            }
        }
        return elementsResolved;
    }
    
    /**
     * Returns the copy of the visited project. This is the starting projects for all copied (imported) projects. <br/>
     * Please note that this will only return any results if the original project was visited by this visitor.
     * @return The copied project or <tt>null</tt> if {@link FilterType#ONLY_IMPORTS} was passed to this constructor.
     */
    public Project getCopiedProject() {
        return copiedProject;
    }
    
    /**
     * Returns a set of all copied projects (including copies of imported projects).
     * @return All copied projects.
     */
    public java.util.Set<Project> getAllCopiedProjects() {
        return new HashSet<Project>(copiedProjects.values());
    }
    
    /**
     * Adds the copied element to the current parent ({@link #parents}, considering needed class casts.
     * @param copiedElement The copied element to add to the current parent.
     */
    private void addToCurrentParent(ContainableModelElement copiedElement) {
        if (!visitLocalElements) {
            IModelElement parent = parents.peekFirst();
            if (parent instanceof Project) {
                ((Project) parent).add(copiedElement);
            } else if (parent instanceof Compound) {
                Compound cType = (Compound) parent;
                if (copiedElement instanceof DecisionVariableDeclaration) {
                    cType.add((DecisionVariableDeclaration) copiedElement);
                } else if (copiedElement instanceof AttributeAssignment) {
                    cType.add((AttributeAssignment) copiedElement);
                } else if (copiedElement instanceof EvaluationBlock) {
                    cType.add((EvaluationBlock) copiedElement);
                } else if (copiedElement instanceof Comment) {
                    cType.add((Comment) copiedElement);
                }
            } else if (parent instanceof PartialEvaluationBlock) {
                ((PartialEvaluationBlock) parent).addModelElement(copiedElement);
            }
        }
    }
    
    /**
     * Returns the copied {@link IDatatype} for the given one.
     * @param originalType A {@link IDatatype} used in the original project.
     * @return The copied {@link IDatatype}, the same {@link IDatatype} if it is a basis type, or <tt>null</tt> if the
     *     datatype wasn't translated so far.
     */
    private IDatatype getTranslatedType(IDatatype originalType) {
        IDatatype copiedType = null;
        
        if (null != originalType) {
            if (originalType.isPrimitive()) {
                // Real, Strings, Integers, Booleans, Constraints
                copiedType = originalType;
            } else if (Container.TYPE.isAssignableFrom(originalType)) {
                Container conType = (Container) originalType;
                IDatatype containedType = getTranslatedType(conType.getContainedType());
                Project copiedParent = copiedProjects.get(conType.getParent());
                if (null != containedType && null != copiedParent) {
                    if (Sequence.TYPE.isAssignableFrom(originalType)) {
                        copiedType = new Sequence(originalType.getName(), containedType, copiedParent);
                    } else if (Set.TYPE.isAssignableFrom(originalType)) {
                        copiedType = new Sequence(originalType.getName(), containedType, copiedParent);
                    }
                }
            } else if (Compound.TYPE.isAssignableFrom(originalType) || Enum.TYPE.isAssignableFrom(originalType)
                || DerivedDatatype.TYPE.isAssignableFrom(originalType) || originalType instanceof Reference) {
                copiedType = (IDatatype) copiedElements.get(originalType);
            } else if (null != projectTypes.get(originalType)) {
                Project copiedProject = projectTypes.get(originalType);
                copiedType = copiedProject.getType();
            }
        } 
        
        return copiedType;
    }
    
    /**
     * Helper method for copying the comment from the original to the copied element.
     * Should be called after creating the copy and before adding it to the parent.
     * @param copiedElement The currently created copy
     * @param originalElement The original from which the copy is created from.
     */
    private void setComment(ContainableModelElement copiedElement, ContainableModelElement originalElement) {
        if (null != originalElement.getComment()) {
            copiedElement.setComment(originalElement.getComment());
        }
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        IDatatype type = getTranslatedType(decl.getType());
        if (null != type) {
            // Copy declaration
            DecisionVariableDeclaration copiedDecl = null;
            
            if (decl.isDeclaratorTypeExplicit()) {
                copiedDecl = new ExplicitTypeVariableDeclaration(decl.getName(), type, parents.peekFirst());
            } else {
                copiedDecl = new DecisionVariableDeclaration(decl.getName(), type, parents.peekFirst());
            }
            setComment(copiedDecl, decl);
            addToCurrentParent(copiedDecl);
            copiedElements.put(decl, copiedDecl);
            copiedDeclarations.put(decl, copiedDecl);
            
            // Copy default value
            copyDefaultValue(decl, copiedDecl);
            
            // Annotations will be copied through copying the annotation in its visit method
        } else {
            incompleteElements.addUnresolvedDeclarationType(decl);
        }
    }

    /**
     * Copies the default value from the original declaration to the copied declaration.
     * @param decl The original declaration from where the default value shall be copied from.
     * @param copiedDecl The target declaration.
     */
    private void copyDefaultValue(AbstractVariable decl, AbstractVariable copiedDecl) {
        ConstraintSyntaxTree cst = decl.getDefaultValue();
        if (null != cst) {
            CSTCopyVisitor cstCopyier = new CSTCopyVisitor(copiedDeclarations); 
            cst.accept(cstCopyier);
            try {
                copiedDecl.setValue(cstCopyier.getResult());
                if (!cstCopyier.translatedCompletely()) {
                    incompleteElements.addMissingDefault(copiedDecl);
                }
            } catch (ValueDoesNotMatchTypeException e) {
                // Should not be possible, since the original was valid
                Bundle.getLogger(ProjectCopyVisitor.class).exception(e);
            } catch (CSTSemanticException e) {
                // Should not be possible, since the original was valid
                Bundle.getLogger(ProjectCopyVisitor.class).exception(e);
            }
        }
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        IDatatype type = getTranslatedType(attribute.getType());
        IAttributableElement annotatedElement = attribute.getElement();
        if (annotatedElement instanceof Project) {
            annotatedElement = copiedProjects.get(annotatedElement);
        } else {
            annotatedElement = (IAttributableElement) copiedElements.get(annotatedElement);
        }
        if (null != type && null != annotatedElement) {
            // Copy annotation
            Attribute copiedAnnotation = new Attribute(attribute.getName(), type, parents.peekFirst(),
                annotatedElement);
            setComment(copiedAnnotation, attribute);
            addToCurrentParent(copiedAnnotation);
            copiedElements.put(attribute, copiedAnnotation);
            copiedDeclarations.put(attribute, copiedAnnotation);
            annotatedElement.attribute(copiedAnnotation);
            
            // Copy default value
            copyDefaultValue(attribute, copiedAnnotation);
        } else {
            incompleteElements.addUnresolvedDeclarationType(attribute);
        }
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        Constraint copiedConstraint = new Constraint(parents.peekFirst());
        setComment(copiedConstraint, constraint);
        addToCurrentParent(copiedConstraint);
        copiedElements.put(constraint, copiedConstraint);
        
        // Handle the CST
        ConstraintSyntaxTree cst = constraint.getConsSyntax();
        if (cst != null) {
            CSTCopyVisitor cstCopyier = new CSTCopyVisitor(copiedDeclarations); 
            cst.accept(cstCopyier);
            try {
                copiedConstraint.setConsSyntax(cstCopyier.getResult());
                if (!cstCopyier.translatedCompletely()) {
                    incompleteElements.addUnresolvedConstraint(copiedConstraint);
                }
            } catch (CSTSemanticException e) {
                // Should not be possible, since the original was valid
                Bundle.getLogger(ProjectCopyVisitor.class).exception(e);
            }
        }
        
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        boolean allElementsFound = true;
        IFreezable[] copiedFrozenElements = new IFreezable[freeze.getFreezableCount()];
        for (int i = 0; i < copiedFrozenElements.length && allElementsFound; i++) {
            IFreezable orgFrozenElement = freeze.getFreezable(i);
            IFreezable copiedFrozenElement = (IFreezable) copiedElements.get(orgFrozenElement);
            if (orgFrozenElement instanceof CompoundAccessStatement && null == copiedFrozenElement) {
                visitLocalElements = true;
                visitCompoundAccessStatement((CompoundAccessStatement) orgFrozenElement);
                visitLocalElements = false;
                
                // Retry after copying
                copiedFrozenElement = (IFreezable) copiedElements.get(orgFrozenElement);
            }
            copiedFrozenElements[i] = copiedFrozenElement;
            allElementsFound = (null != copiedFrozenElement);
        }
        
        boolean butOK = true;
        DecisionVariableDeclaration copiedItr = null;
        ConstraintSyntaxTree copiedSelecor = null;
        if (null != freeze.getSelector()) {
            // Local iterator variable (should not have a parent)
            visitLocalElements = true;
            DecisionVariableDeclaration orgItr = freeze.getIter();
            if (null != orgItr) {
                visitDecisionVariableDeclaration(orgItr);
                copiedItr = (DecisionVariableDeclaration) copiedElements.get(orgItr);
            }
            visitLocalElements = false;
            
            // Selector expression
            CSTCopyVisitor copyier = new CSTCopyVisitor(copiedDeclarations);
            freeze.getSelector().accept(copyier);
            if (copyier.translatedCompletely()) {
                copiedSelecor = copyier.getResult();
            } else {
                butOK = false;
            }
        }
        
        if (allElementsFound && butOK) {
            FreezeBlock copiedBlock
                = new FreezeBlock(copiedFrozenElements, copiedItr, copiedSelecor, parents.peekFirst());
            setComment(copiedBlock, freeze);
            addToCurrentParent(copiedBlock);
            copiedElements.put(freeze, copiedBlock);
        } else {
            incompleteElements.addFreezeBlock(freeze);
        }
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        CustomOperation orgCustomOp = opdef.getOperation();
        
        boolean allParamTypesAvailable = true;
        for (int i = 0, end = orgCustomOp.getParameterCount(); i < end && allParamTypesAvailable; i++) {
            IDatatype orgParamType = orgCustomOp.getParameterDeclaration(i).getType();
            allParamTypesAvailable = (null != getTranslatedType(orgParamType));
        }       
        IDatatype copiedOperandType = getTranslatedType(orgCustomOp.getOperand());
        IDatatype copiedReturnType = getTranslatedType(orgCustomOp.getReturns()); 
        
        if (null != copiedOperandType && null != copiedReturnType && allParamTypesAvailable) {
            OperationDefinition copiedOP = new OperationDefinition((ModelElement) parents.peekFirst());

            // Copy parameters
            parents.addFirst(copiedOP);
            DecisionVariableDeclaration[] copiedParameters
                = new DecisionVariableDeclaration[orgCustomOp.getParameterCount()];
            for (int i = 0; i < copiedParameters.length; i++) {
                DecisionVariableDeclaration orgParamDecl = orgCustomOp.getParameterDeclaration(i);
                orgParamDecl.accept(this);
                copiedParameters[i] = (DecisionVariableDeclaration) copiedElements.get(orgParamDecl);
            } 
            parents.removeFirst();
            
            // Copy CST and create custom operation
            CSTCopyVisitor cstCopy = new CSTCopyVisitor(copiedDeclarations);
            orgCustomOp.getFunction().accept(cstCopy);
            CustomOperation copiedCustomOp = new CustomOperation(copiedReturnType, orgCustomOp.getName(),
                    copiedOperandType, cstCopy.getResult(), copiedParameters);
            copiedOP.setOperation(copiedCustomOp);
            setComment(copiedOP, opdef);
            addToCurrentParent(copiedOP);
            copiedElements.put(opdef, copiedOP);
            if (!cstCopy.translatedCompletely()) {
                // CustomOperaton was not copied completely, this must be replaced at a alter point.
                incompleteElements.addIncompleteOperation(copiedOP);
            }
        } else {
            // No copy of OperationDefinition was created -> Retry it later
            incompleteElements.addUnCopiedOperation(opdef);
        }
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        PartialEvaluationBlock copiedBlock = new PartialEvaluationBlock(block.getName(), parents.peekFirst());
        setComment(copiedBlock, block);
        addToCurrentParent(copiedBlock);
        copiedElements.put(block, copiedBlock);
        
        // Copy nested elements
        parents.addFirst(copiedBlock);
        
        /* 
         * Copy IPartialEvaluable evaluables, i.e., nested constraints and eval blocks.
         * Since they have a set method, they can be partially copied and replaced by a final copy at a later point
         */
        visitLocalElements = true;
        IPartialEvaluable[] evaluables = new IPartialEvaluable[block.getEvaluableCount()];
        for (int i = 0; i < evaluables.length; i++) {
            IPartialEvaluable orgEvaluable = block.getEvaluable(i);
            // Test whether it was already translated in an earlier step
            IPartialEvaluable copiedEvaluable = (IPartialEvaluable) copiedElements.get(orgEvaluable);
            if (null == copiedEvaluable) {
                orgEvaluable.accept(this);
                copiedEvaluable = (IPartialEvaluable) copiedElements.get(orgEvaluable);
            }
            // Add translated element
            if (null != copiedBlock) {
                evaluables[i] = copiedEvaluable;
            }
            copiedBlock.setEvaluables(evaluables);
        }
        visitLocalElements = false;
        
        // Copy nested elements like variable declarations
        for (int i = 0, end = block.getModelElementCount(); i < end; i++) {
            block.getModelElement(i).accept(this);
        }
        
        parents.removeFirst();
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        boolean allElementsCopied = true;
        DecisionVariableDeclaration[] copiedExports = new DecisionVariableDeclaration[iface.getExportsCount()];
        
        for (int i = 0; i < copiedExports.length && allElementsCopied; i++) {
            DecisionVariableDeclaration orgDecl = iface.getExport(i);
            copiedExports[i] = (DecisionVariableDeclaration) copiedElements.get(orgDecl);
            allElementsCopied = (null != copiedExports[i]);
        }
        
        if (allElementsCopied) {
            ProjectInterface copiedIface = new ProjectInterface(iface.getName(), copiedExports,
                (ModelElement) parents.peekFirst());
            setComment(copiedIface, iface);
            addToCurrentParent(copiedIface);
        } else {
            incompleteElements.addUnresolvedProjectInterface(iface);
        }
    }

    @Override
    public void visitComment(Comment comment) {
        Comment copiedComment = new Comment(comment.getName(), parents.peekFirst());
        setComment(copiedComment, comment);
        addToCurrentParent(copiedComment);
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        AbstractVariable copiedCPDecl = (AbstractVariable) copiedElements.get(access.getCompoundVariable());
        if (null != copiedCPDecl) {
            CompoundAccessStatement copiedAccess = new CompoundAccessStatement(copiedCPDecl, access.getName(),
                parents.peekFirst());
            setComment(copiedAccess, access);
            addToCurrentParent(copiedAccess);
            copiedElements.put(access, copiedAccess);
        } else {
            incompleteElements.addCompoundAccess(access);
        }
    }

    @Override
    public void visitEnum(Enum eenum) {
        String[] literals = new String[eenum.getLiteralCount()];
        for (int i = 0; i < literals.length; i++) {
            literals[i] = eenum.getLiteral(i).getName();
        }
        Enum copiedEnum = new Enum(eenum.getName(), (Project) parents.peekFirst(), literals);
        setComment(copiedEnum, eenum);
        addToCurrentParent(copiedEnum);
        copiedElements.put(eenum, copiedEnum);
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        OrderedEnum copiedEnum = new OrderedEnum(eenum.getName(), (Project) parents.peekFirst());
        for (int i = 0, end = eenum.getLiteralCount(); i < end; i++) {
            EnumLiteral originalLiteral = eenum.getLiteral(i);
            copiedEnum.add(new EnumLiteral(originalLiteral.getName(), originalLiteral.getOrdinal(), copiedEnum));
        }
        setComment(copiedEnum, eenum);
        addToCurrentParent(copiedEnum);
        copiedElements.put(eenum, copiedEnum);
    }

    @Override
    public void visitCompound(Compound compound) {
        Compound refinementBase = compound.getRefines();
        Compound copiedBase = (Compound) getTranslatedType(refinementBase);
        
        if (null != refinementBase && null == copiedBase) {
            // Refined compound was not translated so far
            incompleteElements.addUnresolvedType(compound);
        } else {
            Compound copiedCompound = new Compound(compound.getName(), (ModelElement) parents.peekFirst(),
                compound.isAbstract(), copiedBase);
            setComment(copiedCompound, compound);
            addToCurrentParent(copiedCompound);
            copiedElements.put(compound, copiedCompound);
            parents.addFirst(copiedCompound);
            for (int i = 0, end = compound.getElementCount(); i < end; i++) {
                compound.getElement(i).accept(this);
            }
            parents.removeFirst();
        }
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        IDatatype basisType = getTranslatedType(datatype.getBasisType());
        if (null != basisType) {
            DerivedDatatype copiedType = new DerivedDatatype(datatype.getName(), basisType,
                (Project) parents.peekFirst());
            setComment(copiedType, datatype);
            addToCurrentParent(copiedType);
            copiedElements.put(datatype, copiedType);
            copiedElements.put(datatype.getTypeDeclaration(), copiedType.getTypeDeclaration());
            copiedDeclarations.put(datatype.getTypeDeclaration(), copiedType.getTypeDeclaration());
            
            // Handle constraints
            parents.addFirst(copiedType);
            Constraint[] copiedConstraints = new Constraint[datatype.getConstraintCount()];
            for (int i = 0; i < copiedConstraints.length; i++) {
                Constraint orgConstraint = datatype.getConstraint(i);
                visitConstraint(orgConstraint);
                copiedConstraints[i] = (Constraint) copiedElements.get(orgConstraint);
            }
            copiedType.setConstraints(copiedConstraints);
            parents.removeFirst();
        } else {
            incompleteElements.addUnresolvedType(datatype);
        }
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // Not needed
    }

    @Override
    public void visitReference(Reference reference) {
        IDatatype basisType = getTranslatedType(reference.getType());
        if (null != basisType) {
            Reference copiedType = new Reference(reference.getName(), basisType, (Project) parents.peekFirst());
            setComment(copiedType, reference);
            addToCurrentParent(copiedType);
            copiedElements.put(reference, copiedType);
        } else {
            incompleteElements.addUnresolvedType(reference);
        }
    }

    @Override
    public void visitSequence(Sequence sequence) {
        IDatatype basisType = getTranslatedType(sequence.getContainedType());
        if (null != basisType) {
            Sequence copiedType = new Sequence(sequence.getName(), basisType, parents.peekFirst());
            setComment(copiedType, sequence);
            addToCurrentParent(copiedType);
            copiedElements.put(sequence, copiedType);
        } else {
            incompleteElements.addUnresolvedType(sequence);
        }
    }

    @Override
    public void visitSet(Set set) {
        IDatatype basisType = getTranslatedType(set.getContainedType());
        if (null != basisType) {
            Set copiedType = new Set(set.getName(), basisType, parents.peekFirst());
            setComment(copiedType, set);
            addToCurrentParent(copiedType);
            copiedElements.put(set, copiedType);
        } else {
            incompleteElements.addUnresolvedType(set);
        }
    }
}
