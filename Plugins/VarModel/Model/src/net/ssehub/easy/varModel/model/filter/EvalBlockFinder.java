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
 * This class locates all {@link PartialEvaluationBlock} in a project.
 * @author El-Sharkawy
 *
 */
public class EvalBlockFinder extends AbstractProjectVisitor {
    private List<PartialEvaluationBlock> evalBlocks;
    
    /**
     * Sole constructor for this class.
     * Searches inside the specified project for {@link PartialEvaluationBlock}s.
     * @param project The project which should be inspected.
     * @param filtertype Specifies whether imports shall be considered or not.
     */
    public EvalBlockFinder(Project project, FilterType filtertype) {
        super(project, filtertype);
        evalBlocks = new ArrayList<PartialEvaluationBlock>();
        project.accept(this);
    }
    
    /**
     * Returns all discovered {@link PartialEvaluationBlock}s.
     * @return All {@link PartialEvaluationBlock}s.
     */
    public List<PartialEvaluationBlock> getEvalBlocks() {
        return evalBlocks;
    }

    @Override
    public void visitEnum(Enum eenum) {
        // Not needed here
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        // Not needed here
    }

    @Override
    public void visitCompound(Compound compound) {
        // Not needed here
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        // Not needed here
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        // Not needed here
    }

    @Override
    public void visitReference(Reference reference) {
        // Not needed here
    }

    @Override
    public void visitSequence(Sequence sequence) {
        // Not needed here
    }

    @Override
    public void visitSet(Set set) {
        // Not needed here
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        // Not needed here
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        // Not needed here
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        // Not needed here
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        // Not needed here
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        // Not needed here
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        evalBlocks.add(block);
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        // Not needed here
    }
    
    @Override
    public void visitComment(Comment comment) {
        // Not needed here
    }
    
    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // this is not an eval block
    }

}
