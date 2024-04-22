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
package test.de.uni_hildesheim.sse.cycletest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.AbstractProjectVisitor;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.OperationDefinition;
import net.ssehub.easy.varModel.model.PartialEvaluationBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectInterface;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.CustomDatatype;
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

/**
 * Locates used {@link Project}s (imported and parents of {@link net.ssehub.easy.varModel.model.ModelElement}s).
 * Open cases may be filled if needed, but problematic part of qualimaster is already covered by this test.
 * @author El-Sharkawy
 */
class UsedProjectFinder extends AbstractProjectVisitor implements IUsedProjectFinder {

    private java.util.Set<Project> usedProjects;
    
    /**
     * Default constructor. 
     * @param originProject The project where the visiting shall start
     * @param filterType Specifies whether project imports shall be considered or not.
     */
    UsedProjectFinder(Project originProject, FilterType filterType) {
        super(originProject, filterType);
        usedProjects = new HashSet<Project>();
    }

    /**
     * Locates all {@link Project} usages inside the given {@link ConstraintSyntaxTree}.
     * @param cst A constraint to analyze
     * @param usedProjects The used {@link Project}s (from used declarations and types), will be changed
     *     as side effect.
     */
    private static void visitCST(ConstraintSyntaxTree cst, java.util.Set<Project> usedProjects) {
        if (null != cst) {
            ProjectsInCSTFinder subFinder = new ProjectsInCSTFinder();
            cst.accept(subFinder);
            usedProjects.addAll(subFinder.getUsedProjects());
        }
    }
    
    /**
     * Recursive function to detect used {@link Project}s in a data type.
     * @param type The type to analyse
     * @param usedProjects The used {@link Project}s, will be changed as side effect.
     */
    static void visitType(IDatatype type, java.util.Set<Project> usedProjects) {
        if (null != type) {
            if (type instanceof CustomDatatype) {
                usedProjects.add(((CustomDatatype) type).getProject());
            }
            
            if (type instanceof Reference) {
                visitType(((Reference) type).getType(), usedProjects);
            }
        }
    }
    
    /**
     * Detects used projects for a declaration (Projects used for data type, default value and where the
     * declaration itself was defined in).
     * @param decl The declaration to analyze
     * @param usedProjects The used {@link Project}s, will be changed as side effect.
     */
    static void visitAbstractDeclaration(AbstractVariable decl, java.util.Set<Project> usedProjects) {
        if (null != decl) {
            usedProjects.add(decl.getProject());
            usedProjects.add((Project) decl.getTopLevelParent());
            visitType(decl.getType(), usedProjects);
            visitCST(decl.getDefaultValue(), usedProjects);
        }
    }
    
    @Override
    public void visitProjectImport(ProjectImport pImport) {
        usedProjects.add(pImport.getResolved());
        super.visitProjectImport(pImport);
    }
    
    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        visitAbstractDeclaration(decl, usedProjects);
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        visitAbstractDeclaration(attribute, usedProjects);
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        usedProjects.add(constraint.getProject());
        visitCST(constraint.getConsSyntax(), usedProjects);
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        usedProjects.add(opdef.getProject());
        CustomOperation op = opdef.getOperation();
        visitType(op.getReturns(), usedProjects);
        
        for (int i = 0, end = op.getParameterCount(); i < end; i++) {
            visitAbstractDeclaration(op.getParameterDeclaration(i), usedProjects);
        }
        visitCST(op.getFunction(), usedProjects);
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
        // TODO Auto-generated method stub
        
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
        usedProjects.add(compound.getProject());
        for (int i = 0, end = compound.getModelElementCount(); i < end; i++) {
            compound.getModelElement(i).accept(this);
        }
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

    @Override
    public java.util.Set<Project> getUsedProjects() {
        return usedProjects;
    }
    
    /**
     * Creates a map ion form of (project name, list of instances) for all found projects.
     * @return A map of used {@link Project} instances, will not be <b>null</b> unless
     * the main {@link Project} was not visited before.
     */
    public Map<String, List<Project>> createProjectMap() {
        Map<String, List<Project>> projectMap = new HashMap<String, List<Project>>();
        for (Project project : usedProjects) {
            List<Project> projects = projectMap.get(project.getName());
            if (null == projects) {
                projects = new ArrayList<Project>();
                projectMap.put(project.getName(), projects);
            }
            projects.add(project);
        }
        
        return projectMap;
    }

}
