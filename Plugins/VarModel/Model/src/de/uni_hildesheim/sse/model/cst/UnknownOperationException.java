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
package de.uni_hildesheim.sse.model.cst;

import de.uni_hildesheim.sse.model.varModel.IvmlDatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * An exception signaling an unknown operation.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("serial")
public class UnknownOperationException extends CSTSemanticException {

    /**
     * Constructs the message for the exception.
     * 
     * @param name the name of the unknown operation
     * @param operand the operand
     * @param parameter the parameter
     * @param code the code of this message
     */
    public UnknownOperationException(String name, int code, IDatatype operand, IDatatype... parameter) {
        super(constructMessage(name, operand, parameter), code);
    }

    /**
     * Constructs the message for the exception.
     * 
     * @param name the name of the unknown operation
     * @param operand the operand
     * @param parameter the parameter
     * @return the constructed message
     */
    public static final String constructMessage(String name, IDatatype operand, IDatatype... parameter) {
        StringBuilder builder = new StringBuilder("unknown operation of signature ");
        builder.append(name);
        builder.append("(");
        boolean operandPseudo = false;
        if (null != operand) {
            operandPseudo = operand.isPseudoType();
            if (!operandPseudo) {
                builder.append(IvmlDatatypeVisitor.getUnqualifiedType(operand));
            }
        }
        if (null != parameter) {
            for (int p = 0; p < parameter.length; p++) {
                if ((operandPseudo && p > 0) || !operandPseudo) {
                    builder.append(", ");
                }
                builder.append(IvmlDatatypeVisitor.getUnqualifiedType(parameter[p]));
            }
        }
        builder.append(")");
        return builder.toString();
    }

}
