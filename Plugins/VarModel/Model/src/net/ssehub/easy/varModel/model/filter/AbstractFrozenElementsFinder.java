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

import net.ssehub.easy.varModel.model.AbstractProjectVisitor;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
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
 * Abstract superclass for {@link FreezeBlockFinder} and {@link FrozenElementsFinder} for discovering frozen elements.
 * @author El-Sharkawy
 *
 */
abstract class AbstractFrozenElementsFinder extends AbstractProjectVisitor {
    /**
     * Sole constructor for this class.
     * @param originProject The project on where the filtering was started.
     * @param filterType Specifies whether imports shall be considered or not.
     */
    protected AbstractFrozenElementsFinder(Project originProject, FilterType filterType) {
        super(originProject, filterType);
    }
    
    @Override
    public void visitEnum(Enum eenum) {
        // No action needed
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        // No action needed
    }

    @Override
    public void visitCompound(Compound compound) {
        // No action needed
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // No action needed
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // No action needed
    }

    @Override
    public void visitReference(Reference reference) {
        // No action needed
    }

    @Override
    public void visitSequence(Sequence sequence) {
        // No action needed
    }

    @Override
    public void visitSet(Set set) {
        // No action needed
    }
    
    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // No action needed
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // No action needed
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        // No action needed
    }
    
    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        // No action needed
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        // No action needed
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        // No action needed
    }

    @Override
    public void visitComment(Comment comment) {
        // No action needed
    }
    
    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // No action needed
    }

}
