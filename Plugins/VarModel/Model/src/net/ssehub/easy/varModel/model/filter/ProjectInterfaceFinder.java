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
package net.ssehub.easy.varModel.model.filter;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.varModel.model.AbstractProjectVisitor;
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
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;

/**
 * Searches for defined {@link ProjectInterface}s.
 * @author Sascha El-Sharkawy
 *
 */
public class ProjectInterfaceFinder extends AbstractProjectVisitor {

    private List<ProjectInterface> interfaces;
    private boolean onlyUsedInterfaces;
    
    private String usedInterfaceName;
    
    /**
     * Constructor for getting all {@link ProjectInterface}s.
     * @param project The root project.
     * @param filterType Specifies whether project imports shall be considered or not.
     */
    public ProjectInterfaceFinder(Project project, FilterType filterType) {
        this(project, filterType, false);
    }
    
    /**
     * Constructor for getting all {@link ProjectInterface}s.
     * @param project The root project.
     * @param filterType Specifies whether project imports shall be considered or not.
     * @param onlyUsedInterfaces Optional: Consider only interfaces of imported projects, which are used inside
     *     the project import.
     */
    public ProjectInterfaceFinder(Project project, FilterType filterType, boolean onlyUsedInterfaces) {
        super(project, filterType);
        interfaces = new ArrayList<ProjectInterface>();
        this.onlyUsedInterfaces = onlyUsedInterfaces;
        usedInterfaceName = null;
        project.accept(this);
    }
    
    @Override
    public void visitProjectImport(ProjectImport pImport) {
        if (onlyUsedInterfaces) {
            usedInterfaceName = pImport.getInterfaceName();
        } else {
            usedInterfaceName = null;
        }
        if (null != pImport.getResolved()) {
            pImport.getResolved().accept(this);
        }
    }
    
    /**
     * Returns the found {@link ProjectInterface}s.
     * @return A list of project interfaces. Maybe empty, but not <b>null</b>.
     */
    public List<ProjectInterface> getProjectInterfaces() {
        return interfaces;
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // Not needed
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // Not needed
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        // Not needed
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // Not needed
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        // Not needed
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        // Not needed
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        if (!onlyUsedInterfaces || (null != usedInterfaceName && usedInterfaceName.equals(iface.getName()))) {
            interfaces.add(iface);
        }
    }

    @Override
    public void visitComment(Comment comment) {
        // Not needed
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // Not needed
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // Not needed
    }

    @Override
    public void visitEnum(Enum eenum) {
        // Not needed
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        // Not needed
    }

    @Override
    public void visitCompound(Compound compound) {
        // Not needed
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // Not needed
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // Not needed
    }

    @Override
    public void visitReference(Reference reference) {
        // Not needed
    }

    @Override
    public void visitSequence(Sequence sequence) {
        // Not needed
    }

    @Override
    public void visitSet(Set set) {
        // Not needed
    }
}
