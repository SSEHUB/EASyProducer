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
package net.ssehub.easy.varModel.model.rewrite;

import java.util.ArrayDeque;
import java.util.Deque;

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
import net.ssehub.easy.varModel.model.filter.FilterType;

/**
 * Part of the {@link ProjectRewriteVisitor}, to detect deleted elements if a complete Import was removed.
 * @author El-Sharkawy
 *
 */
class DeletedElementsCollector extends AbstractProjectVisitor {

    private RewriteContext context;
    private Deque<Project> parentProjects;
    
    /**
     * Single constructor of this class.
     * @param originProject The resolved project of the removed import.
     * @param filterType Should usually be {@link FilterType#ALL}
     * @param context The context of the {@link ProjectRewriteVisitor}.
     */
    DeletedElementsCollector(Project originProject, FilterType filterType, RewriteContext context) {
        super(originProject, filterType);
        this.context = context;
        parentProjects = new ArrayDeque<Project>();
        parentProjects.addFirst(originProject);
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        context.markForImportRemoval(parentProjects.peekFirst(), decl);
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        context.markForImportRemoval(parentProjects.peekFirst(), attribute);
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        context.markForImportRemoval(parentProjects.peekFirst(), constraint);
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        context.markForImportRemoval(parentProjects.peekFirst(), freeze);
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        context.markForImportRemoval(parentProjects.peekFirst(), opdef);
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        context.markForImportRemoval(parentProjects.peekFirst(), block);
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        context.markForImportRemoval(parentProjects.peekFirst(), iface);
    }

    @Override
    public void visitComment(Comment comment) {
        context.markForImportRemoval(parentProjects.peekFirst(), comment);
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        context.markForImportRemoval(parentProjects.peekFirst(), assignment);
        for (int i = 0; i < assignment.getDeclarationCount(); i++) {
            assignment.getDeclaration(i).accept(this);
        }
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        context.markForImportRemoval(parentProjects.peekFirst(), access);
    }

    @Override
    public void visitEnum(Enum eenum) {
        context.markForImportRemoval(parentProjects.peekFirst(), eenum);
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        context.markForImportRemoval(parentProjects.peekFirst(), eenum);
    }

    @Override
    public void visitCompound(Compound compound) {
        context.markForImportRemoval(parentProjects.peekFirst(), compound);
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        context.markForImportRemoval(parentProjects.peekFirst(), datatype);
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // Not needed
    }

    @Override
    public void visitReference(Reference reference) {
        context.markForImportRemoval(parentProjects.peekFirst(), reference);
    }

    @Override
    public void visitSequence(Sequence sequence) {
        context.markForImportRemoval(parentProjects.peekFirst(), sequence);
    }

    @Override
    public void visitSet(Set set) {
        context.markForImportRemoval(parentProjects.peekFirst(), set);
    }
    
    @Override
    public void visitProject(Project project) {
        boolean projectIsStillPart = context.projectIsStillPresent(project);
        
        // Visit this project only if it was maybe deleted.
        if (!projectIsStillPart) {
            super.visitProject(project);
        }
    }
    
    @Override
    public void visitProjectImport(ProjectImport pImport) {
        Project resolved = pImport.getResolved();
        if (null != resolved) {
            parentProjects.addFirst(resolved);
            super.visitProjectImport(pImport);
            parentProjects.removeFirst();
        }
    }
}
