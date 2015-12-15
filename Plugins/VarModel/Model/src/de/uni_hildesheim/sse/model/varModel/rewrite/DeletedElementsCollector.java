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

import de.uni_hildesheim.sse.model.varModel.AbstractProjectVisitor;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.Comment;
import de.uni_hildesheim.sse.model.varModel.CompoundAccessStatement;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.OperationDefinition;
import de.uni_hildesheim.sse.model.varModel.PartialEvaluationBlock;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectInterface;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.DerivedDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.datatypes.Sequence;
import de.uni_hildesheim.sse.model.varModel.datatypes.Set;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;

/**
 * Part of the {@link ProjectRewriteVisitor}, to detect deleted elements if a complete Import was removed.
 * @author El-Sharkawy
 *
 */
class DeletedElementsCollector extends AbstractProjectVisitor {

    private RewriteContext context;
    
    /**
     * Single constructor of this class.
     * @param originProject The resolved project of the removed import.
     * @param filterType Should usually be {@link FilterType#ALL}
     * @param context The context of the {@link ProjectRewriteVisitor}.
     */
    DeletedElementsCollector(Project originProject, FilterType filterType, RewriteContext context) {
        super(originProject, filterType);
        this.context = context;
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        context.elementWasRemoved(decl);
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        context.elementWasRemoved(attribute);
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        context.elementWasRemoved(constraint);
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        context.elementWasRemoved(freeze);
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        context.elementWasRemoved(opdef);
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        context.elementWasRemoved(block);
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        context.elementWasRemoved(iface);
    }

    @Override
    public void visitComment(Comment comment) {
        context.elementWasRemoved(comment);
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        context.elementWasRemoved(assignment);
        for (int i = 0; i < assignment.getDeclarationCount(); i++) {
            assignment.getDeclaration(i).accept(this);
        }
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        context.elementWasRemoved(access);
    }

    @Override
    public void visitEnum(Enum eenum) {
        context.elementWasRemoved(eenum);
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        context.elementWasRemoved(eenum);
    }

    @Override
    public void visitCompound(Compound compound) {
        context.elementWasRemoved(compound);
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        context.elementWasRemoved(datatype);
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // Bot needed
    }

    @Override
    public void visitReference(Reference reference) {
        context.elementWasRemoved(reference);
    }

    @Override
    public void visitSequence(Sequence sequence) {
        context.elementWasRemoved(sequence);
    }

    @Override
    public void visitSet(Set set) {
        context.elementWasRemoved(set);
    }
}
