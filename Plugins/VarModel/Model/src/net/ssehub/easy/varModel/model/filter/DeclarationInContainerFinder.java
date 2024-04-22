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

import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.IModelVisitor;
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
 * Tests whether a {@link ContainableModelElement} is a {@link DecisionVariableDeclaration} or an
 * {@link AttributeAssignment}. In case of a {@link DecisionVariableDeclaration} the {@link DecisionVariableDeclaration}
 * will be returned. In case of an {@link AttributeAssignment} all nested {@link DecisionVariableDeclaration}s will be
 * returned.
 * @author El-Sharkawy
 *
 */
public class DeclarationInContainerFinder implements IModelVisitor {
    
    private List<DecisionVariableDeclaration> declarations;

    /**
     * Sole constructor for this class.
     * @param element the element to be checked.
     */
    public DeclarationInContainerFinder(ContainableModelElement element) {
        declarations = new ArrayList<DecisionVariableDeclaration>();
        element.accept(this);
    }
    
    /**
     * Returns
     * <ul>
     * <li>The parameter of the constructor call if the element was a {@link DecisionVariableDeclaration}</li>
     * <li>Returns a list of {@link DecisionVariableDeclaration} if the parameter of the constrcutor call
     * was an {@link AttributeAssignment} (This list maybe empty)</li>
     * <li>Otherwise an empty list will be returned</li>
     * </ul>.
     * @return A List of {@link DecisionVariableDeclaration} (must not be <b>null</b>).
     */
    public List<DecisionVariableDeclaration> getDeclarations() {
        return declarations;
    }
    
    @Override
    public void visitEnum(Enum eenum) {
        //No action needed
    }

    @Override
    public void visitOrderedEnum(OrderedEnum eenum) {
        //No action needed
    }

    @Override
    public void visitCompound(Compound compound) {
        //No action needed
    }

    @Override
    public void visitDerivedDatatype(DerivedDatatype datatype) {
        //No action needed
    }

    @Override
    public void visitEnumLiteral(EnumLiteral literal) {
        //No action needed
    }

    @Override
    public void visitReference(Reference reference) {
        //No action needed
    }

    @Override
    public void visitSequence(Sequence sequence) {
        //No action needed
    }

    @Override
    public void visitSet(Set set) {
        //No action needed
    }

    @Override
    public void visitProject(Project project) {
        //No action needed
    }

    @Override
    public void visitProjectImport(ProjectImport pImport) {
        //No action needed
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        declarations.add(decl);
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        //No action needed
    }

    @Override
    public void visitConstraint(Constraint constraint) {
        //No action needed
    }

    @Override
    public void visitFreezeBlock(FreezeBlock freeze) {
        //No action needed
    }

    @Override
    public void visitOperationDefinition(OperationDefinition opdef) {
        //No action needed
    }

    @Override
    public void visitPartialEvaluationBlock(PartialEvaluationBlock block) {
        //No action needed
    }

    @Override
    public void visitProjectInterface(ProjectInterface iface) {
        //No action needed
    }

    @Override
    public void visitComment(Comment comment) {
        //No action needed
    }

    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        for (int i = 0; i < assignment.getModelElementCount(); i++) {
            assignment.getModelElement(i).accept(this);
        }
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // this is no declaration
    }

}
