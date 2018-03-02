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

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;

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
     * @param topLevelCall <code>true</code> for top-level calls, i.e., <code>cmpType</code> is the type where the 
     *     collection starts, <code>false</code> else.
     * @param parent the intended parent for constraints, typically the containing project
     */
    public static void allCompoundConstraints(Compound cmpType, 
        AbstractConstraintProcessor processor, boolean topLevelCall, IModelElement parent) {
        for (int c = 0; c < cmpType.getConstraintsCount(); c++) {
            processor.process(cmpType.getConstraint(c));
        }
        if (topLevelCall) {
            for (int i = 0; i < cmpType.getInheritedElementCount(); i++) {
                DecisionVariableDeclaration decl = cmpType.getInheritedElement(i);
                ConstraintSyntaxTree defaultValue = decl.getDefaultValue();
                if (null != defaultValue) {
                    if (ConstraintType.TYPE.isAssignableFrom(decl.getType())) {
                        processor.process(defaultValue, parent);
                    }
                } 
            }            
        }
        for (int r = 0; r < cmpType.getRefinesCount(); r++) {
            allCompoundConstraints(cmpType.getRefines(r), processor, false, parent);
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
            processor.process(assng.getConstraint(c));
        }
        for (int a = 0; a < assng.getAssignmentCount(); a++) {
            allAssignmentConstraints(assng.getAssignment(a), processor);
        }
    }    

}
