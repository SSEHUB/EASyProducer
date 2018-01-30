/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model;

import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;

/**
 * An empty implementation of {@link IModelVisitor}.
 * 
 * @author Holger Eichelberger
 */
public class ModelVisitorAdapter implements IModelVisitor {

    @Override
    public void visitEnum(Enum eenum) {
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
    }

    @Override
    public void visitCompound(Compound compound) {
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
    }

    @Override
    public void visitReference(Reference reference) {
    }

    @Override
    public void visitSequence(Sequence sequence) {
    }

    @Override
    public void visitSet(Set set) {
    }

    @Override
    public void visitProject(Project project) {
    }

    @Override
    public void visitProjectImport(ProjectImport pImport) {
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
    }

    @Override
    public void visitAttribute(Attribute attribute) {
    }

    @Override
    public void visitConstraint(Constraint constraint) {
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
    }

    @Override
    public void visitComment(Comment comment) {
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
    }

}
