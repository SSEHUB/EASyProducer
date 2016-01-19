/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.model.varModel.rewrite;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstantValue;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.cst.CopyVisitor;
import de.uni_hildesheim.sse.model.cst.OCLFeatureCall;
import de.uni_hildesheim.sse.model.varModel.AbstractProjectVisitor;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.CompoundAccessStatement;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.ModelElement;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.OclKeyWords;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.filter.DeclrationInConstraintFinder;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.rewrite.modifier.IModelElementFilter;
import de.uni_hildesheim.sse.model.varModel.rewrite.modifier.IProjectImportFilter;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;

/**
 * Visitor for creating a (modified) copy of a given project.
 * This can be used to create copies for specific demands, e.g., a {@link Project} without constraints containing
 * frozen variables.
 * @author El-Sharkawy
 *
 */
public class ProjectRewriteVisitor extends AbstractProjectVisitor {

    private Map<Class<? extends ModelElement>, List<IModelElementFilter<?>>> modifiers;
    private List<IProjectImportFilter> importModifiers;
    private Project currentProject;
    private Deque<Project> parentProjects;
    private RewriteContext context;
    
    /**
     * Default constructor for this class.
     * @param originProject The project where the visiting shall start
     * @param filterType Specifies whether project imports shall be considered or not.
     */
    public ProjectRewriteVisitor(Project originProject, FilterType filterType) {
        super(originProject, filterType);
        modifiers = new HashMap<Class<? extends ModelElement>, List<IModelElementFilter<?>>>();
        importModifiers = new ArrayList<IProjectImportFilter>();
        parentProjects = new ArrayDeque<Project>();
        context = new RewriteContext();
    }
    
    /**
     * Resets the {@link ProjectRewriteVisitor} to use it for a new visitation.
     * This will keep the internal knowledge and, thus, enable the removal of removed elements in other projects. 
     * @param originProject The project where the visiting shall start
     * @param filterType Specifies whether project imports shall be considered or not.
     */
    public void reset(Project originProject, FilterType filterType) {
        modifiers.clear();
        importModifiers.clear();
        parentProjects.clear();
        super.clear(originProject, filterType);
        context.newRun();
    }

    /**
     * Adds a new {@link IModelElementFilter} to this {@link ProjectRewriteVisitor}. If none was specified for a given
     * {@link ContainableModelElement} type, these kind of elements will be copied. If a {@link IModelElementFilter} was
     * specified the modifier will be applied to each element of the same type. Multiple {@link IModelElementFilter} may
     * be specified for the same {@link ContainableModelElement} type.
     * @param modifier A IModelCopyModifier for a given {@link ContainableModelElement} class,
     *     must not be <tt>null</tt>.
     */
    public void addModelCopyModifier(IModelElementFilter<? extends ModelElement> modifier) {
        List<IModelElementFilter<?>> modifierList = modifiers.get(modifier.getModifyingModelClass());
        if (null == modifierList) {
            modifierList = new ArrayList<IModelElementFilter<?>>();
            modifiers.put(modifier.getModifyingModelClass(), modifierList);
        }
        modifierList.add(modifier);
    }
    
    /**
     * Adds a new modifier for filtering {@link ProjectImport}s. 
     * @param modifier A modifier for filtering {@link ProjectImport}s.
     */
    public void addImportModifier(IProjectImportFilter modifier) {
        importModifiers.add(modifier);
    }

    /**
     * Returns the copied and modified {@link Project} after the visiting method of the project was called.
     * {@link Project#accept(de.uni_hildesheim.sse.model.varModel.IModelVisitor)} must be called before.<br/>
     * <b><font color="red">Attention:</font></b> This method creates a modified, shallow copy of the visited project.
     * Thus, the original project becomes invalid through this visitation. This visitor should only be used if the
     * original is no longer needed, e.g., for performance tweaks in a automated setup which does not save any data.
     * <br/>
     * <b>FIXME SE:</b> Create a deep copy if a real copy mechanism is needed.
     * @return The copied and modified version of the given {@link Project}.
     */
    public Project getCopyiedProject() {
        return currentProject;
    }
    
    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        addCopiedElement(filter(decl));
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        addCopiedElement(filter(attribute));
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        ConstraintSyntaxTree cst = constraint.getConsSyntax();
        DeclrationInConstraintFinder finder = new DeclrationInConstraintFinder(cst);
        java.util.Set<AbstractVariable> usedDeclarations = finder.getDeclarations();
        Iterator<AbstractVariable> variablesItr = usedDeclarations.iterator();
        boolean allDeclarationsarePresent = true;
        while (variablesItr.hasNext() && allDeclarationsarePresent) {
            allDeclarationsarePresent = !context.elementWasRemoved(variablesItr.next());
        }
        
        // Remove constraint, if constraint used removed declarations
        if (allDeclarationsarePresent) {
            if (cst instanceof OCLFeatureCall && OclKeyWords.ASSIGNMENT.equals(((OCLFeatureCall) cst).getOperation())) {
                OCLFeatureCall call = (OCLFeatureCall) cst;
                ConstraintSyntaxTree param = call.getParameter(0);
                if (param instanceof ConstantValue) {
                    ValueCopy copy = new ValueCopy(context, ((ConstantValue) param).getConstantValue());
                    if (copy.valuesOmitted() && null != copy.getValue()) {
                        // Filtered Value was created
                        call = new OCLFeatureCall(call.getOperand(), call.getOperation(),
                            new ConstantValue(copy.getValue()));
                        try {
                            // Needed for setting the correct operation
                            call.inferDatatype();
                        } catch (CSTSemanticException e1) {
                            EASyLoggerFactory.INSTANCE.getLogger(ProjectRewriteVisitor.class, Bundle.ID).exception(e1);
                        }
                        constraint = new Constraint(constraint.getParent());
                        try {
                            constraint.setConsSyntax(call);
                        } catch (CSTSemanticException e) {
                            EASyLoggerFactory.INSTANCE.getLogger(ProjectRewriteVisitor.class, Bundle.ID).exception(e);
                        }
                    } else if (copy.valuesOmitted() && null == copy.getValue()) {
                        // Value was completely filtered -> remove assignment constraint
                        context.elementWasRemoved(constraint);
                        constraint = null;
                    }
                    // Else: Constraint is as it was before -> process it
                }
            }
            if (null != constraint) {
                addCopiedElement(filter(constraint));
            }
        } else {
            context.elementWasRemoved(constraint);
        }
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // First check whether the freezeblock shall be filtered
        FreezeBlock copiedfreeze = (FreezeBlock) filter(freeze);
        
        if (null != copiedfreeze) {
            // Determine which elements of the block still exist.
            ArrayList<IFreezable> copiedElements = new ArrayList<IFreezable>();
            for (int i = 0, n = copiedfreeze.getFreezableCount(); i < n; i++) {
                IFreezable frozenElement = copiedfreeze.getFreezable(i);
                if (frozenElement instanceof DecisionVariableDeclaration) {
                    DecisionVariableDeclaration frozenElementDecl = (DecisionVariableDeclaration) frozenElement;
                    
                    // Filter removed elements
                    if (!context.elementWasRemoved(frozenElementDecl)) {
                        copiedElements.add(frozenElement);
                    }
                }
            }
            
            if (copiedElements.isEmpty()) {
                // No more elements to freeze, remove complete freeze block
                context.removeElement(freeze);
            } else {
                DecisionVariableDeclaration orginalIterator = copiedfreeze.getIter();
                ConstraintSyntaxTree selectorCST = copiedfreeze.getSelector();
                IFreezable[] frozenElements = copiedElements.toArray(new IFreezable[0]);
                
                /* 
                 * Create copy with filtered elements.
                 * Even if no elements where filtered, the block must be recreated to adjust the selector.
                 * Otherwise the selector maybe invalid (or not parseable at all)
                 */
                copiedfreeze = adaptFreezeBlock(frozenElements, orginalIterator, selectorCST,
                    (Project) freeze.getParent());
            }
        }
        
        if (null != copiedfreeze) { 
            addCopiedElement(copiedfreeze);
        }
    }

    /**
     * Creates a copy of a freezeblock with an adjusted selector.
     * @param frozenElements The frozen elements to be added to the freezeblock.
     * @param orginalIterator The iterator of the original freezeblock (maybe <tt>null</tt> if none was specified).
     * @param selectorCST The selector constraint of the original freezeblock (maybe <tt>null</tt>
     *     if none was specified).
     * @param parent The parent project of the freezeblock.
     * @return The copied freezeblock.
     */
    private FreezeBlock adaptFreezeBlock(IFreezable[] frozenElements, DecisionVariableDeclaration orginalIterator,
        ConstraintSyntaxTree selectorCST, Project parent) {
        
        DecisionVariableDeclaration copiedIterator = null;
        
        if (null != orginalIterator) {
            IModelElement originalParent = orginalIterator.getParent();
            IModelElement copiedParent = originalParent;
            
            if (null != originalParent && originalParent instanceof Project) {
                copiedParent = context.getTranslatedProject((Project) originalParent);
            }
            
            copiedIterator = new DecisionVariableDeclaration(orginalIterator.getName(), orginalIterator.getType(),
                copiedParent);
        }
        
        // Replace iterator in selector constraint.
        ConstraintSyntaxTree copiedSelector = null;
        if (null != selectorCST) {
            Map<AbstractVariable, AbstractVariable> declMapping = new HashMap<AbstractVariable,
                AbstractVariable>();
            declMapping.put(orginalIterator, copiedIterator);
            CopyVisitor cstCopier = new CopyVisitor(declMapping);
            selectorCST.accept(cstCopier);
            copiedSelector = cstCopier.getResult();
            try {
                // Needed for setting the correct operation
                copiedSelector.inferDatatype();
            } catch (CSTSemanticException e) {
                EASyLoggerFactory.INSTANCE.getLogger(ProjectRewriteVisitor.class, Bundle.ID).exception(e);
            }
        }
        
        // Copied Freezeblock with corrected selector
        return new FreezeBlock(frozenElements, copiedIterator, copiedSelector, context.getTranslatedProject(parent));
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        addCopiedElement(filter(opdef));
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        addCopiedElement(filter(block));
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        addCopiedElement(filter(iface));
    }

    @Override
    public void visitComment(Comment comment) {
        addCopiedElement(filter(comment));
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        addCopiedElement(filter(assignment));
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        addCopiedElement(filter(access));
    }

    @Override
    public void visitEnum(Enum eenum) {
        addCopiedElement(filter(eenum));
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        addCopiedElement(filter(eenum));
    }

    @Override
    public void visitCompound(Compound compound) {
        compound = (Compound) filter(compound);
        if (null != compound) {
            boolean somethingFiltered = false;
            // Iterating down avoid IndexOutOfBoundsExceptions
            for (int i = compound.getModelElementCount() - 1; i >= 0; i--) {
                ContainableModelElement elemBefore = compound.getModelElement(i);
                ContainableModelElement elemAfter = filter(elemBefore);
                if (null == elemAfter) {
                    somethingFiltered = true;
                    compound.removeConstraint(elemBefore);
                }
            }
            
            if (somethingFiltered) {
                context.elementesWereRemoved();
            }
        }
        addCopiedElement(compound);
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        addCopiedElement(filter(datatype));
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // Not needed
    }

    @Override
    public void visitReference(Reference reference) {
        addCopiedElement(filter(reference));
    }

    @Override
    public void visitSequence(Sequence sequence) {
        addCopiedElement(filter(sequence));
    }

    @Override
    public void visitSet(Set set) {
        addCopiedElement(filter(set));
    }

    /**
     * Method for filtering (and modifying) the original {@link ContainableModelElement} 
     * using the {@link IModelElementFilter}. If none is specified for the given element type, the element will be
     * returned without any modification.
     * The returned element must be added to the {@link #currentProject} through the
     * {@link #addCopiedElement(ContainableModelElement)} method. This methods are splitted into two methods,
     * to enable further processing between the filtering and the add method,
     * i.e., adapting to the {@link #currentProject}.
     * @param original A {@link ContainableModelElement} of the {@link #currentProject} to be filtered (and modified).
     * @return The modified instance (maybe the same instance) or <tt>null</tt> if it was completely filtered.
     * @see #addCopiedElement(ContainableModelElement)
     */
    private ContainableModelElement filter(ContainableModelElement original) {
        ContainableModelElement copy = original;
        List<IModelElementFilter<?>> modifierList = modifiers.get(original.getClass());
        if (null != modifierList) {
            for (int i = 0, n = modifierList.size(); i < n && null != copy; i++) {
                IModelElementFilter<?> currentModifier = (IModelElementFilter<?>) modifierList.get(i);
                copy = currentModifier.handleModelElement(copy, context);
            }
        }
        
        if (null == copy) {
            // Mark that the element was completely removed.
            context.removeElement(original);
        }
        
        return copy;
    }
    
    /**
     * Adds a modified and filtered element to the {@link #currentProject}, part of the
     * {@link #filter(ContainableModelElement)} method.
     * @param copy The copied instance, maybe <tt>null</tt> if filtered completely.
     */
    private void addCopiedElement(ContainableModelElement copy) {
        if (null != copy) {
            /*
             * Parent must be adjusted to the new parent, otherwise the resulting project would not be valid.
             * FIXME SE: Currently, this Visitor is producing only a shallow copy. Therefore, the originally project
             * won't be valid after adjusting the elements for the newly created project.
             */
            copy.setParent(currentProject);
            currentProject.add(copy);
        }
    }
    
    /**
     * {@inheritDoc} <br/>
     * <b><font color="red">Attention:</font></b> This method creates a modified, shallow copy of the visited project.
     * Thus, the original project becomes invalid through this visitation. This visitor should only be used if the
     * original is no longer needed, e.g., for performance tweaks in a automated setup which does not save any data.
     * <br/>
     * <b>FIXME SE:</b> Create a deep copy if a real copy mechanism is needed.
     */
    @Override
    public void visitProject(Project project) {
        currentProject = new Project(project.getName());
        context.storeTranslatedProject(project, currentProject);
        super.visitProject(project);
        
        if (project == getStartingProject()) {
            context.removeElementsOfRemovedImports();
            if (context.elementesWereRemoved()) {
                /*
                 * Elements where removed start filtering again, maybe there exist some elements pointing
                 * to the removed elements.
                 */
                revisit(project);
            }
        }
    }

    /**
     * Starts a new visitation to clean up inconsistent data.
     * @param project The original project which was used to start the whole visitation process.
     */
    private void revisit(Project project) {
        Project tmpProject = currentProject;
        context.clear();
        currentProject = new Project(project.getName());
        clear(tmpProject, FilterType.ALL);
        context.storeTranslatedProject(tmpProject, currentProject);
        
        // Stop modification, clean up inconsistent data.
        modifiers.clear();
        importModifiers.clear();
        
        super.visitProject(tmpProject);
    }
    
    @Override
    public void visitProjectImport(ProjectImport pImport) {
        ProjectImport copy = pImport;
        for (int i = 0, n = importModifiers.size(); i < n && null != copy; i++) {
            IProjectImportFilter currentModifier = importModifiers.get(i);
            copy = currentModifier.handleImport(copy, context);
        }

        if (null != copy) {
            // TODO check whether copy or pImport should be used inside this if
            parentProjects.addFirst(currentProject);
            
            ProjectImport copiedImport = new ProjectImport(copy.getName(), copy.getInterfaceName(),
                copy.isConflict(), false, copy.getVersionRestriction());
            
            if (null != parentProjects.peekFirst()) {
                parentProjects.peekFirst().addImport(copiedImport);
            }
            
            super.visitProjectImport(copy);
            try {
                copiedImport.setResolved(currentProject);
            } catch (ModelManagementException e) {
                EASyLoggerFactory.INSTANCE.getLogger(ProjectRewriteVisitor.class, Bundle.ID).exception(e);
            }
            // In case of a ProjectImport, switch back to original project after visiting the import
            if (null != parentProjects.peekFirst()) {
                currentProject = parentProjects.removeFirst();
            }
        } else {
            // Collect removed elements
            // TODO SE: Check behavior if two imports contain similar elements but only one is removed.
            Project removedProject = pImport.getResolved();
            if (null != removedProject) {
                DeletedElementsCollector collector = new DeletedElementsCollector(removedProject, FilterType.ALL,
                    context);
                removedProject.accept(collector);
            }
        }
    }
}
