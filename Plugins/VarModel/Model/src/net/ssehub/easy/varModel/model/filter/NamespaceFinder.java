/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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
 * Extracts all namespaces (project names) of a given project, including all imported projects.
 * @author El-Sharkawy
 *
 */
public class NamespaceFinder extends AbstractProjectVisitor {
    
    private List<String> namepsaces;
    
    /**
     * Constructor for getting all namespaces including all imported namepsaces.
     * @param project The root project.
     */
    public NamespaceFinder(Project project) {
        super(project, FilterType.ALL);
        namepsaces = new ArrayList<String>();
        project.accept(this);
    }
    
    /**
     * Returns the retrieved namespaces.
     * @return A list containing all namepsace, will not be <tt>null</tt>.
     */
    public List<String> getNamespaces() {
        return namepsaces;
    }

    @Override
    public void visitProject(Project project) {
        namepsaces.add(project.getName());
        super.visitProject(project);
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // TODO Auto-generated method stub
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
        // TODO Auto-generated method stub
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
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

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // this is not a namespace
    }

}
