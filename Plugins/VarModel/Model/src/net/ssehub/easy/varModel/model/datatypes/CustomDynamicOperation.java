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
package net.ssehub.easy.varModel.model.datatypes;

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;

/**
 * Implements a non-static custom operation subject to dynamic dispatch while evaluation.
 * 
 * @author Holger Eichelberger
 */
public class CustomDynamicOperation extends CustomOperation {

    /**
     * Operation Constructor.
     * 
     * @param returns result type of the operation
     * @param methodname name of the operation
     * @param operand the data type the operation is defined for (shall be a project)
     * @param function the operation calculated by this operation
     * @param parameters list of parameters for operation
     */
    public CustomDynamicOperation(IDatatype returns, String methodname, IDatatype operand, 
        ConstraintSyntaxTree function, DecisionVariableDeclaration[] parameters) {
        super(returns, methodname, operand, function, parameters);
    }
    
    @Override
    public boolean isStatic() {
        return false;
    }

}
