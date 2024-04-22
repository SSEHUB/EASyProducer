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
package net.ssehub.easy.varModel.cst;

import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;

/**
 * Utility functions for handling {@link ConstraintSyntaxTree}s.
 * @author El-Sharkawy
 *
 */
public class CSTUtils {

    /**
     * Avoid initialization.
     */
    private CSTUtils() {}
    
    /**
     * Checks whether the given {@link ConstraintSyntaxTree} is a assignment or a constraint.
     * Assignments are always instance of {@link OCLFeatureCall}.
     * 
     * @param completeCST A complete (not sub part) constraint, must not be <b>null</b>.
     * @return {@code true} if the given constraint is an assignment, {@code false} if it is a constraint. 
     */
    public static boolean isAssignment(ConstraintSyntaxTree completeCST) {
        return completeCST instanceof OCLFeatureCall
            && ((OCLFeatureCall) completeCST).getOperation().equals(OclKeyWords.ASSIGNMENT);
    }
    
    /**
     * Checks whether the given {@link ConstraintSyntaxTree} is a simple assignment 
     * (variable assigned with constant or compound/container initializer).
     * @param completeCST A complete (not sub part) constraint, must not be <b>null</b>.
     * @return {@code true} if the given constraint is a simple assignment, 
     * {@code false} if it is a complex constraint. 
     */
    public static boolean isSimpleAssignment(ConstraintSyntaxTree completeCST) {
        Boolean isSimpleAssignment = false;
        if (completeCST instanceof OCLFeatureCall) {
            OCLFeatureCall call = (OCLFeatureCall) completeCST;
            if (null != call.getOperand()) {    
                // user def function returns operand null!
                if ((call.getOperand() instanceof Variable
                    || call.getOperand() instanceof CompoundAccess)
                    && call.getParameterCount() == 1
                    && call.getOperation().equals(OclKeyWords.ASSIGNMENT)) {
                    if (call.getParameter(0) instanceof ConstantValue
                        || call.getParameter(0) instanceof ContainerInitializer
                        || call.getParameter(0) instanceof CompoundInitializer) {
                        isSimpleAssignment = true; 
                    }
                } 
            }
        }
        return isSimpleAssignment;
    }
}
