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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.model.AbstractProjectVisitor;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IFreezable;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.filter.DeclrationInConstraintFinder;
import net.ssehub.easy.varModel.model.filter.FilterType;
import net.ssehub.easy.varModel.model.rewrite.modifier.AbstractFrozenChecker;
import net.ssehub.easy.varModel.model.rewrite.modifier.IModelElementFilter;
import net.ssehub.easy.varModel.model.rewrite.modifier.IProjectImportFilter;

/**
 * Visitor for modifying a (copied) project.
 * This can be used to filter a project for specific demands, e.g., a {@link Project} without constraints containing
 * frozen variables.<br/>
 * This visitor modifies the given project. For this reason, it is recommended to use the {@link ProjectCopyVisitor}
 * before to create a copy first. <br/><br/>
 * <b>Usage</b>
 * <ol>
 *   <li>Create visitor for the desired {@link Project} and specify whether imported projects shall also
 *   be rewritten (cf. {@link FilterType})</li>
 *   <li>Add desired {@link IModelElementFilter} and {@link ProjectImport} filters</li>
 *   <li>Call {@link Project#accept(net.ssehub.easy.varModel.model.IModelVisitor)}</li>
 *   <li>project will be affected through this visitation and should not be saved.</li>
 * </ol>
 * 
 * <b>For instance:</b>
 * <pre><code>
 * Project project = ...
 * Configuration config = new Configuration(project); // Needed for some filter
 * ProjectRewriteVisitor rewriter = new ProjectRewriteVisitor(project, FilterType.ALL);
 * rewriter.addModelCopyModifier(new ModelElementFilter(Comment.class));
 * rewriter.addModelCopyModifier(new FrozenConstraintsFilter(config));
 * rewriter.addModelCopyModifier(new FrozenTypeDefResolver(config));
 * rewriter.addModelCopyModifier(new FrozenConstraintVarFilter(config));
 * rewriter.addModelCopyModifier(new FrozenCompoundConstraintsOmitter(config));
 * project.accept(rewriter);
 * </code></pre>
 * 
 * @author El-Sharkawy
 *
 */
public class ProjectRewriteVisitor extends AbstractProjectVisitor {

    private Map<Class<? extends ModelElement>, List<IModelElementFilter<?>>> modifiers;
    private List<IProjectImportFilter> importModifiers;
    private Project currentProject;
    private java.util.Set<Project> done;
    private RewriteContext context;
    
    /**
     * Default constructor for this class.
     * @param originProject The project where the visiting shall start
     * @param filterType Specifies whether project imports shall be considered or not.
     */
    public ProjectRewriteVisitor(Project originProject, FilterType filterType) {
        super(originProject, filterType);
        done = new HashSet<Project>();
        modifiers = new HashMap<Class<? extends ModelElement>, List<IModelElementFilter<?>>>();
        importModifiers = new ArrayList<IProjectImportFilter>();
        context = new RewriteContext();
        
        // Create initial structure table, for faster lookup during rewriting
        InitialStructureCollector initializer = new InitialStructureCollector(originProject, filterType,
            context.getLookUpTable());
        originProject.accept(initializer);
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
        
        if (modifier instanceof AbstractFrozenChecker) {
            context.getLookUpTable().init(((AbstractFrozenChecker<?>) modifier).getConfiguration());
        }
    }
    
    /**
     * Adds a new modifier for filtering {@link ProjectImport}s. 
     * @param modifier A modifier for filtering {@link ProjectImport}s.
     */
    public void addImportModifier(IProjectImportFilter modifier) {
        importModifiers.add(modifier);
    }
    
    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        DecisionVariableDeclaration copiedDecl = (DecisionVariableDeclaration) filter(decl);
        addCopiedElement(copiedDecl);
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
                IFreezable[] frozenElements = copiedElements.toArray(new IFreezable[0]);
                copiedfreeze = new FreezeBlock(frozenElements, copiedfreeze.getIter(), copiedfreeze.getSelector(),
                    copiedfreeze.getParent());
            }
        }
        
        if (null != copiedfreeze) { 
            addCopiedElement(copiedfreeze);
        }
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        OperationDefinition copyDef = (OperationDefinition) filter(opdef);
        addCopiedElement(copyDef);
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
            currentProject.add(copy);
        }
    }
    
    /**
     * {@inheritDoc} <br/>
     * <b><font color="red">Attention:</font></b> This method will modify the visited project. If the original project
     * should not be modified, it is necessary to create a copy first via the {@link ProjectCopyVisitor}.
     * <br/>
     */
    @Override
    public void visitProject(Project project) {
        if (!done.contains(project)) {
            done.add(project);
            
            
            // Remove all elements from project
            ProjectImport[] pImports = new ProjectImport[project.getImportsCount()];
            for (int i = 0; i < pImports.length; i++) {
                pImports[i] = project.getImport(i);
            } 
            ContainableModelElement[] unfilteredElements = new ContainableModelElement[project.getElementCount()];
            for (int i = 0; i < unfilteredElements.length; i++) {
                unfilteredElements[i] = project.getElement(i);
            }
            project.clear();
            
            // visit all elements to check which shall be kept and add them again
            for (int i = 0; i < pImports.length; i++) {
                ProjectImport unfilteredImport = pImports[i];
                for (int j = 0, n = importModifiers.size(); j < n && null != pImports[i]; j++) {
                    IProjectImportFilter currentModifier = importModifiers.get(j);
                    pImports[i] = currentModifier.handleImport(pImports[i], context);
                }
                if (null != pImports[i]) {
                    project.addImport(pImports[i]);
                    Project importedProject = pImports[i].getResolved();
                    if (null != importedProject) {
                        visitProject(importedProject);
                    }
                } else {
                    Project removedProject = unfilteredImport.getResolved();
                    if (null != removedProject) {
                        DeletedElementsCollector collector = new DeletedElementsCollector(removedProject,
                            FilterType.ALL, context);
                        removedProject.accept(collector);
                    }
                }
            }
            currentProject = project;
            for (int i = 0; i < unfilteredElements.length; i++) {
                unfilteredElements[i].accept(this);
            }
            
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
    }

    /**
     * Starts a new visitation to clean up inconsistent data.
     * @param project The original project which was used to start the whole visitation process.
     */
    private void revisit(Project project) {
        done.clear();
        context.clear();
        clear(project, FilterType.ALL);
        
        // Stop modification, clean up inconsistent data.
        modifiers.clear();
        importModifiers.clear();
        
        this.visitProject(project);
    }
}
