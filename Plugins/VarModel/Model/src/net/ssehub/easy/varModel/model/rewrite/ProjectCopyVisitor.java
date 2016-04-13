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
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IAttributableElement;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.CustomDatatype;
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
 * Creates a deep copy of a {@link Project}.
 * @author El-Sharkawy
 */
public class ProjectCopyVisitor extends AbstractProjectVisitor {

    /**
     * Tuple of (oldProject, copiedProject) containing the mapping of copied projects.
     */
    private Map<Project, Project> copiedProjects;
    /**
     * Tuple of (oldElement, copiedElement) containing the mapping of copied model elements.
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
     */
    private Deque<IModelElement> parents;
    
    /**
     * The copied projects (starting point). Will be <tt>null</tt> if only imports are translated.
     */
    private Project copiedProject;
    
    private java.util.Set<Project> allCopiedProjects;
    
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
        allCopiedProjects = new HashSet<Project>();
        parents = new ArrayDeque<IModelElement>();
    }
    
    @Override
    public void visitProject(Project project) {
        super.visitProject(project);
        // super.visitProject(project) -> calls addFirst
        parents.pollFirst();
        
        // Finally at the end of the whole translation, try to fix all the missed elements
        if (project == getStartingProject()) {
            parents.clear();
            boolean elementsResolved = false;
            
            do {
                elementsResolved = false;
                
                // Handle incomplete custom types
                elementsResolved |= resolveOutStandingTypes();
                
                // Handle incomplete declarations
                elementsResolved |= resolveOutStandingDeclarations();
                
                // Handle incomplete default values
                Iterator<AbstractVariable> declDefaultItr =
                    incompleteElements.getDeclarationsWithMissingDefaults().iterator();
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
                
                // Handle incomplete constraints
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
            } while(elementsResolved);
        }
        
    }

    /**
     * Part of the end of the coping: Tries to copy declarations, which could not be translated during
     * the regular visitation.
     * @return <tt>true</tt> if at least one element was resolved, <tt>false</tt> no elements have been resolved,
     *     maybe because there was nothing to do.
     */
    private boolean resolveOutStandingDeclarations() {
        boolean elementsResolved = false;
        
        Iterator<AbstractVariable> declItr = incompleteElements.getDeclarationsWithMissingTypes().iterator();
        while (declItr.hasNext()) {
            AbstractVariable orgDecl = declItr.next();
            parents.clear();
            // Collect parents in reverse order -> use deque as queue not as stack 
            IModelElement parent = orgDecl;
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
            if (!abort) {
                orgDecl.accept(this);
                if (null != copiedElements.get(orgDecl)) {
                    // Declaration was successfully copied
                    elementsResolved = true;
                    declItr.remove();
                }
            }
            parents.clear();
        }
        
        return elementsResolved;
    }

    /**
     * Part of the end of the coping: Tries to resolve custom data types, which could not be translated during
     * the regular visitation.
     * @return <tt>true</tt> if at least one element was resolved, <tt>false</tt> no elements have been resolved,
     *     maybe because there was nothing to do.
     */
    private boolean resolveOutStandingTypes() {
        boolean elementsResolved = false;
        
        Iterator<CustomDatatype> typeItr = incompleteElements.getUnresolvedTypes().iterator();
        while (typeItr.hasNext()) {
            CustomDatatype type = typeItr.next();
            Project copiedProject = copiedProjects.get(type.getTopLevelParent());
            parents.add(copiedProject);
            type.accept(this);
            IModelElement copiedType = copiedElements.get(type);
            if (null != copiedType) {
                elementsResolved = true;
                typeItr.remove();
            }
            parents.removeFirst();
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
        return allCopiedProjects;
    }
    
    /**
     * Adds the copied element to the current parent ({@link #parents}, considering needed class casts.
     * @param copiedElement The copied element to add to the current parent.
     */
    private void addToCurrentParent(ContainableModelElement copiedElement) {
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
                || DerivedDatatype.TYPE.isAssignableFrom(originalType)) {
                copiedType = (IDatatype) copiedElements.get(originalType);
            }
        } 
        // TODO SE: References
        
        return copiedType;
    }

    @Override
    protected void visitProject(Project project, boolean isMainProject) {
        Project copy = new Project(project.getName());
        copiedProjects.put(project, copy);
        parents.addFirst(copy);
        if (isMainProject) {
            copiedProject = copy;
        }
        allCopiedProjects.add(copy);
        
        // Handle version
        Version originalVersion = project.getVersion();
        if (null != originalVersion) {
            int[] segments = new int[originalVersion.getSegmentCount()];
            for (int i = 0; i < segments.length; i++) {
                segments[i] = originalVersion.getSegment(i);
            }
            
            copy.setVersion(new Version(segments));
        }
        
    }
    
    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        IDatatype type = getTranslatedType(decl.getType());
        if (null != type) {
            // Copy declaration
            DecisionVariableDeclaration copiedDecl = new DecisionVariableDeclaration(decl.getName(), type,
                parents.peekFirst());
            addToCurrentParent(copiedDecl);
            copiedElements.put(decl, copiedDecl);
            copiedDeclarations.put(decl, copiedDecl);
            
            // Copy default value
            copyDefaultValue(decl, copiedDecl);
            
            // TODO SE: Annotations
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
            addToCurrentParent(copiedAnnotation);
            copiedElements.put(attribute, copiedAnnotation);
            copiedDeclarations.put(attribute, copiedAnnotation);
            annotatedElement.attribute(copiedAnnotation);
            
            // Copy default value
            copyDefaultValue(attribute, copiedAnnotation);
            
            // TODO SE: Annotations
        } else {
            incompleteElements.addMissingDefault(attribute);
        }
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        Constraint copiedConstraint = new Constraint(parents.peekFirst());
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitComment(Comment comment) {
        Comment copiedComment = new Comment(comment.getName(), parents.peekFirst());
        addToCurrentParent(copiedComment);
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitEnum(Enum eenum) {
        String[] literals = new String[eenum.getLiteralCount()];
        for (int i = 0; i < literals.length; i++) {
            literals[i] = eenum.getLiteral(i).getName();
        }
        Enum copiedEnum = new Enum(eenum.getName(), (Project) parents.peekFirst(), literals);
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
            addToCurrentParent(copiedType);
            copiedElements.put(set, copiedType);
        } else {
            incompleteElements.addUnresolvedType(set);
        }
    }

}
