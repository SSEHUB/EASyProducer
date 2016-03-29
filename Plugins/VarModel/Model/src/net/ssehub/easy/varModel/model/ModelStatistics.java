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
package net.ssehub.easy.varModel.model;

import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;

/**
 * This class provides some methods to access statistical information about a given project.
 * 
 * @author Holger Eichelberger
 */
public class ModelStatistics {

    private int constraintsCount = 0;
    private int variablesCount = 0;
    private int declaredDataTypesCount = 0;

    /**
     * Creates a new model statistics object. Please note that we explicitly separated
     * the creation of this object from the {@link #collect(Project) collection of data}
     * as we expect further, more complex statistical operations on subelements (such as 
     * the average depth of constraint trees) which shall explicitly be enabled before
     * data collection.
     */
    public ModelStatistics() {
    }
    
    /**
     * Collects statistics about <code>project</code>.
     * 
     * @param project the project to collect statistics about
     */
    public void collect(Project project) {
        project.accept(new StatisticsVisitor());
    }

    /**
     * Visits the elements in the given project. Note, that currently only basic elements are considered.
     * 
     * @author Holger Eichelberger
     */
    private class StatisticsVisitor extends AbstractVisitor {

        @Override
        public void visitEnum(Enum eenum) {
            declaredDataTypesCount++;
            super.visitEnum(eenum);
        }

        @Override
        public void visitOrderedEnum(OrderedEnum eenum) {
            declaredDataTypesCount++;
            super.visitOrderedEnum(eenum);
        }

        @Override
        public void visitDerivedDatatype(DerivedDatatype datatype) {
            declaredDataTypesCount++;
        }

        @Override
        public void visitEnumLiteral(EnumLiteral literal) {
        }

        @Override
        public void visitReference(Reference reference) {
            declaredDataTypesCount++;
        }

        @Override
        public void visitSequence(Sequence sequence) {
            declaredDataTypesCount++;
        }

        @Override
        public void visitSet(Set set) {
            declaredDataTypesCount++;
        }

        @Override
        public void visitProjectImport(ProjectImport pImport) {
        }

        @Override
        public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
            variablesCount++;
        }

        @Override
        public void visitAttribute(Attribute attribute) {
        }

        @Override
        public void visitConstraint(Constraint constraint) {
            constraintsCount++;
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

    /**
     * Returns the number of declared constraints.
     * 
     * @return the number of declared constraints
     */
    public int getDeclaredConstraintsCount() {
        return constraintsCount;
    }

    /**
     * Returns the number of declared decision variables.
     * 
     * @return the number of declared decision variables
     */
    public int getDeclaredVariablesCount() {
        return variablesCount;
    }

    /**
     * Returns the number of declared data types.
     * 
     * @return the number of declared data types
     */
    protected int getDeclaredDataTypesCount() {
        return declaredDataTypesCount;
    }

}
