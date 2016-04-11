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
import java.util.Map;

import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.CopyVisitor;
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
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.BasisDatatype;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
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
     * This map is useful for the {@link CopyVisitor}.
     */
    private Map<AbstractVariable, AbstractVariable> copiedDeclarations;
    
    /**
     * Elements which where found during visitation, but could not be translated yet, e.g., as the parent is missing.
     */
    private java.util.Set<ContainableModelElement> openElements;
    
    /**
     * Already translated model elements, which should be used as current parent of a model element.
     */
    private Deque<IModelElement> parents;
    
    /**
     * The copied projects (starting point). Will be <tt>null</tt> if only imports are translated.
     */
    private Project copiedProject;
    
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
        openElements = new HashSet<ContainableModelElement>();
        parents = new ArrayDeque<IModelElement>();
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
     * Adds the copied element to the current parent ({@link #parents}, considering needed class casts.
     * @param copiedElement The copied element to add to the current parent.
     */
    private void addToCurrentParent(ContainableModelElement copiedElement) {
        IModelElement parent = parents.peekFirst();
        if (parent instanceof Project) {
            ((Project) parent).add(copiedElement);
        }
    }
    
    /**
     * Returns the copied {@link IDatatype} for the given one.
     * @param originalType A {@link IDatatype} used in the original project.
     * @return The copied {@link IDatatype}, the same {@link IDatatype} if it is a basis type, or <tt>null</tt> if the
     *     datatype wasn't translated so far.
     */
    private IDatatype getTranslatedType(IDatatype originalType) {
        IDatatype delegatingType = originalType.getType();
        IDatatype copiedType = null;
        
        if (delegatingType instanceof BasisDatatype) {
            copiedType = originalType;
        } else if (delegatingType instanceof Container) {
            Container conType = (Container) originalType;
            IDatatype containedType = getTranslatedType(conType.getContainedType());
            Project copiedParent = copiedProjects.get(conType.getParent());
            if (null != containedType && null != copiedParent) {
                if (delegatingType instanceof Sequence) {
                    copiedType = new Sequence(originalType.getName(), containedType, copiedParent);
                } else if (delegatingType instanceof Set) {
                    copiedType = new Sequence(originalType.getName(), containedType, copiedParent);
                }
            }
        }
        // TODO SE: references, enums, compounds
        
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
            ConstraintSyntaxTree cst = decl.getDefaultValue();
            if (null != cst) {
                CopyVisitor cstCopyier = new CopyVisitor(copiedDeclarations); 
                cst.accept(cstCopyier);
                try {
                    copiedDecl.setValue(cstCopyier.getResult());
                } catch (ValueDoesNotMatchTypeException e) {
                    // Should not be possible, since the original was valid
                    Bundle.getLogger(ProjectCopyVisitor.class).exception(e);
                } catch (CSTSemanticException e) {
                    // Should not be possible, since the original was valid
                    Bundle.getLogger(ProjectCopyVisitor.class).exception(e);
                }
            }
            
            // TODO SE: Annotations
        } else {
            openElements.add(decl);
        }
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        // TODO Auto-generated method stub
        
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitCompound(Compound compound) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitReference(Reference reference) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitSequence(Sequence sequence) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitSet(Set set) {
        // TODO Auto-generated method stub
        
    }

}
