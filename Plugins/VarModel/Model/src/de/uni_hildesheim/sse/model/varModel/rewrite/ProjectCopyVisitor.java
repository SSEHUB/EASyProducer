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
public class ProjectCopyVisitor extends AbstractProjectVisitor {

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
    public ProjectCopyVisitor(Project originProject, FilterType filterType) {
        super(originProject, filterType);
        modifiers = new HashMap<Class<? extends ModelElement>, List<IModelElementFilter<?>>>();
        importModifiers = new ArrayList<IProjectImportFilter>();
        parentProjects = new ArrayDeque<Project>();
        context = new RewriteContext();
    }

    /**
     * Adds a new {@link IModelElementFilter} to this {@link ProjectCopyVisitor}. If none was specified for a given
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
        createCopy(decl);
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        createCopy(attribute);
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
                        constraint = new Constraint(constraint.getParent());
                        try {
                            constraint.setConsSyntax(call);
                        } catch (CSTSemanticException e) {
                            EASyLoggerFactory.INSTANCE.getLogger(ProjectCopyVisitor.class, Bundle.ID).exception(e);
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
                createCopy(constraint);
            }
        } else {
            context.elementWasRemoved(constraint);
        }
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        if (context.hasRemovedElementsOfType(DecisionVariableDeclaration.class)) {
            boolean removedElementsFound = false;
            ArrayList<IFreezable> copiedElements = new ArrayList<IFreezable>();
            for (int i = 0, n = freeze.getFreezableCount(); i < n; i++) {
                IFreezable frozenElement = freeze.getFreezable(i);
                if (frozenElement instanceof DecisionVariableDeclaration) {
                    DecisionVariableDeclaration frozenElementDecl = (DecisionVariableDeclaration) frozenElement;
                    
                    // Filter removed elements
                    if (!context.elementWasRemoved(frozenElementDecl)) {
                        copiedElements.add(frozenElement);
                    } else {
                        removedElementsFound = true;
                    }
                }
            }
            
            if (copiedElements.isEmpty()) {
                // No more elements to freeze, remove complete freeze block
                context.removeElement(freeze);
                freeze = null;
            } else if (removedElementsFound) {
                // Create copy with filtered elements
                freeze = new FreezeBlock(copiedElements.toArray(new IFreezable[0]), freeze.getIter(),
                    freeze.getSelector(), (Project) freeze.getParent());                
            }
            // else: Nothing do do, process original block
            
        }
        
        if (null != freeze) { 
            createCopy(freeze);
        }
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        createCopy(opdef);
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        createCopy(block);
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        createCopy(iface);
    }

    @Override
    public void visitComment(Comment comment) {
        createCopy(comment);
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        createCopy(assignment);
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        createCopy(access);
    }

    @Override
    public void visitEnum(Enum eenum) {
        createCopy(eenum);
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        createCopy(eenum);
    }

    @Override
    public void visitCompound(Compound compound) {
        createCopy(compound);
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        createCopy(datatype);
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // TODO
    }

    @Override
    public void visitReference(Reference reference) {
        createCopy(reference);
    }

    @Override
    public void visitSequence(Sequence sequence) {
        createCopy(sequence);
    }

    @Override
    public void visitSet(Set set) {
        createCopy(set);
    }

    /**
     * Method for copying/modifying the original {@link ContainableModelElement} into the copied {@link Project} while
     * using the {@link IModelElementFilter}. If none is specified for the given element, the element will be copied
     * without any modification.
     * @param original A {@link ContainableModelElement} of the {@link #currentProject} to be copied (and modified).
     */
    private void createCopy(ContainableModelElement original) {
        ContainableModelElement copy = original;
        List<IModelElementFilter<?>> modifierList = modifiers.get(original.getClass());
        if (null != modifierList) {
            for (int i = 0, n = modifierList.size(); i < n && null != copy; i++) {
                IModelElementFilter<?> currentModifier = (IModelElementFilter<?>) modifierList.get(i);
                copy = currentModifier.handleModelElement(copy, context);
            }
        }
        
        if (null != copy) {
            /*
             * Parent must be adjusted to the new parent, otherwise the resulting project would not be valid.
             * FIXME SE: Currently, this Visitor is producing only a shallow copy. Therefore, the originally project
             * won't be valid after adjusting the elements for the newly created project.
             */
            copy.setParent(currentProject);
            currentProject.add(copy);
        } else {
            // Mark that the element was completely removed.
            context.removeElement(original);
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
        
        if (project == getStartingProject() && context.elementesWereRemoved()) {
            /*
             * Elements where removed start filtering again, maybe there exist some elements pointing
             * to the removed elements.
             */
            revisit(project);
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
                EASyLoggerFactory.INSTANCE.getLogger(ProjectCopyVisitor.class, Bundle.ID).exception(e);
            }
            // In case of a ProjectImport, switch back to original project after visiting the import
            if (null != parentProjects.peekFirst()) {
                currentProject = parentProjects.removeFirst();
            }
        }
    }
}
