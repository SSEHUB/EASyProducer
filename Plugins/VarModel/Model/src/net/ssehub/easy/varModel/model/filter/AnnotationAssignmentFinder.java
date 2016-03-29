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
 * Searches for all assignment blocks of annotations.
 * @author El-Sharkawy
 */
public class AnnotationAssignmentFinder extends AbstractProjectVisitor {

    private List<AttributeAssignment> assignmentBlocks;
    private boolean onlyToplevel;
    
    /**
     * Single constructor for this class.
     * @param originProject The project where the visiting shall start
     * @param filterType Specifies whether project imports shall be considered or not.
     * @param onlyToplevel <tt>true</tt> Only non nested assignment blocks will be found,
     * <tt>false</tt> all assignment blocks will be found.
     */
    public AnnotationAssignmentFinder(Project originProject, FilterType filterType, boolean onlyToplevel) {
        super(originProject, filterType);
        this.onlyToplevel = onlyToplevel;
        assignmentBlocks = new ArrayList<AttributeAssignment>();
        originProject.accept(this);
    }
    
    /**
     * Returns the found assignments blocks.
     * @return A list of assignment blocks, will not be <tt>null</tt>.
     */
    public List<AttributeAssignment> getAssignmentBlocks() {
        return assignmentBlocks;
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // Cannot contain any assignment blocks
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // Cannot contain any assignment blocks
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        // Cannot contain any assignment blocks
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // Cannot contain any assignment blocks
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        // Cannot contain any assignment blocks
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        // Cannot contain any assignment blocks
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        // Cannot contain any assignment blocks
    }

    @Override
    public void visitComment(Comment comment) {
        // Cannot contain any assignment blocks
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        assignmentBlocks.add(assignment);
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // Cannot contain any assignment blocks
    }

    @Override
    public void visitEnum(Enum eenum) {
        // Cannot contain any assignment blocks
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        // Cannot contain any assignment blocks
    }

    @Override
    public void visitCompound(Compound compound) {
        if (!onlyToplevel) {
            for (int i = 0; i < compound.getAssignmentCount(); i++) {
                assignmentBlocks.add(compound.getAssignment(i));
            }
        }
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // Cannot contain any assignment blocks
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // Cannot contain any assignment blocks
    }

    @Override
    public void visitReference(Reference reference) {
        // Cannot contain any assignment blocks
    }

    @Override
    public void visitSequence(Sequence sequence) {
        // Cannot contain any assignment blocks
    }

    @Override
    public void visitSet(Set set) {
        // Cannot contain any assignment blocks
    }

}
