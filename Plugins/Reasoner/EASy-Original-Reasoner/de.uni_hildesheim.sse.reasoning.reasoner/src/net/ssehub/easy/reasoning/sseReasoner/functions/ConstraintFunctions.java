/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.sseReasoner.functions;

import net.ssehub.easy.reasoning.sseReasoner.functions.AbstractConstraintProcessor.ExpressionType;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;

/**
 * Generic constraint functions based on the {@link AbstractConstraintProcessor}.
 * 
 * @author Holger Eichelberger
 */
public class ConstraintFunctions {

    /**
     * Processes all constraints relevant to the given {@link Compound}.
     * 
     * @param cmpType Compound to be processed.
     * @param processor The constraint processor functor.
     * @param includeConstraintVariables <code>true</code> whether constraint variables shall be included.
     * @param includeDefaults <code>true</code> whether default value expressions shall be included.
     * @param parent the intended parent for constraints, typically the containing project
     */
    public static void allCompoundConstraints(Compound cmpType, AbstractConstraintProcessor processor, 
        boolean includeConstraintVariables, boolean includeDefaults, IModelElement parent) {
        for (int c = 0; c < cmpType.getConstraintsCount(); c++) {
            processor.process(cmpType.getConstraint(c), ExpressionType.CONSTRAINT);
        }
        if (includeConstraintVariables || includeDefaults) {
            for (int i = 0; i < cmpType.getElementCount(); i++) {
                DecisionVariableDeclaration decl = cmpType.getElement(i);
                ConstraintSyntaxTree defaultValue = decl.getDefaultValue();
                if (null != defaultValue) {
                    if (includeConstraintVariables && TypeQueries.isConstraint(decl.getType())) {
                        processor.process(defaultValue, ExpressionType.CONSTRAINT_VALUE, decl.getName(), parent);
                    } else if (includeDefaults) {
                        processor.process(defaultValue, ExpressionType.DEFAULT, decl.getName(), parent);
                    }
                }
                for (int a = 0, n = decl.getAttributesCount(); includeDefaults && a < n; a++) {
                    Attribute attr = decl.getAttribute(a);
                    defaultValue = attr.getDefaultValue();
                    if (null != defaultValue) {
                        processor.process(defaultValue, ExpressionType.ANNOTATION_DEFAULT, attr.getName(), parent);
                    }
                }
            }
        }
        for (int r = 0; r < cmpType.getRefinesCount(); r++) {
            allCompoundConstraints(cmpType.getRefines(r), processor, includeConstraintVariables, 
                includeDefaults, parent);
        }
        for (int a = 0; a < cmpType.getAssignmentCount(); a++) {
            allAssignmentConstraints(cmpType.getAssignment(a), processor);
        }
    }
    
    /**
     * Processes all assignment constraints.
     * 
     * @param assng the assignment constraint
     * @param processor the constraint processor for assignment constraints
     */
    public static void allAssignmentConstraints(AttributeAssignment assng, AbstractConstraintProcessor processor) {
        for (int c = 0; c < assng.getConstraintsCount(); c++) {
            processor.process(assng.getConstraint(c), ExpressionType.ASSIGNMENT_CONSTRAINT);
        }
        for (int a = 0; a < assng.getAssignmentCount(); a++) {
            allAssignmentConstraints(assng.getAssignment(a), processor);
        }
    }    

}
