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
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.filter.DeclrationInConstraintFinder;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.rewrite.modifier.IModelCopyModifier;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;

/**
 * Visitor for creating a (modified) copy of a given project.
 * This can be used to create copies for specific demands, e.g., a {@link Project} without constraints containing
 * frozen variables.
 * @author El-Sharkawy
 *
 */
public class ProjectCopyVisitor extends AbstractProjectVisitor {

    private Map<Class<? extends ModelElement>, List<IModelCopyModifier<?>>> modifiers;
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
        modifiers = new HashMap<Class<? extends ModelElement>, List<IModelCopyModifier<?>>>();
        parentProjects = new ArrayDeque<Project>();
        context = new RewriteContext();
    }

    /**
     * Adds a new {@link IModelCopyModifier} to this {@link ProjectCopyVisitor}. If none was specified for a given
     * {@link ContainableModelElement} type, these kind of elements will be copied. If a {@link IModelCopyModifier} was
     * specified the modifier will be applied to each element of the same type. Multiple {@link IModelCopyModifier} may
     * be specified for the same {@link ContainableModelElement} type.
     * @param modifier A IModelCopyModifier for a given {@link ContainableModelElement} class,
     *     must not be <tt>null</tt>.
     */
    public void addModelCopyModifier(IModelCopyModifier<? extends ModelElement> modifier) {
        List<IModelCopyModifier<?>> modifierList = modifiers.get(modifier.getModifyingModelClass());
        if (null == modifierList) {
            modifierList = new ArrayList<IModelCopyModifier<?>>();
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
        DeclrationInConstraintFinder finder = new DeclrationInConstraintFinder(constraint.getConsSyntax());
        java.util.Set<AbstractVariable> usedDeclarations = finder.getDeclarations();
        Iterator<AbstractVariable> variablesItr = usedDeclarations.iterator();
        boolean allDeclarationsarePresent = true;
        while (variablesItr.hasNext() && allDeclarationsarePresent) {
            allDeclarationsarePresent = !context.elementWasRemoved(variablesItr.next());
        }
        
        if (allDeclarationsarePresent) {
            createCopy(constraint);
        } else {
            context.elementWasRemoved(constraint);
        }
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        createCopy(freeze);
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
     * using the {@link IModelCopyModifier}. If none is specified for the given element, the element will be copied
     * without any modification.
     * @param original A {@link ContainableModelElement} of the {@link #currentProject} to be copied (and modified).
     */
    private void createCopy(ContainableModelElement original) {
        ContainableModelElement copy = original;
        List<IModelCopyModifier<?>> modifierList = modifiers.get(original.getClass());
        if (null != modifierList) {
            for (int i = 0, n = modifierList.size(); i < n && null != copy; i++) {
                IModelCopyModifier<?> currentModifier = (IModelCopyModifier<?>) modifierList.get(i);
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
            Project tmpProject = currentProject;
            context.clear();
            currentProject = new Project(project.getName());
            clear(tmpProject);
            context.storeTranslatedProject(tmpProject, currentProject);
            super.visitProject(tmpProject);
        }
    }
    
    @Override
    public void visitProjectImport(ProjectImport pImport) {
        parentProjects.addFirst(currentProject);
        
        ProjectImport copiedImport = new ProjectImport(pImport.getName(), pImport.getInterfaceName(),
            pImport.isConflict(), false, pImport.getVersionRestriction());
        
        if (null != parentProjects.peekFirst()) {
            parentProjects.peekFirst().addImport(copiedImport);
        }
        
        super.visitProjectImport(pImport);
        try {
            copiedImport.setResolved(currentProject);
        } catch (ModelManagementException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // In case of a ProjectImport, switch back to original project after visiting the import
        if (null != parentProjects.peekFirst()) {
            currentProject = parentProjects.removeFirst();
        }
    }
}
