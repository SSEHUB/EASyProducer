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
package net.ssehub.easy.instantiation.core.model.vilTypes.configuration;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationType;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;

/**
 * Represents the comparison operation for ordered IVML enums.
 * 
 * @author Holger Eichelberger
 */
public class IvmlOrderedEnumComparisonOperationDescriptor extends IvmlOperationDescriptor {

    /**
     * The operation kinds.
     * 
     * @author Holger Eichelberger
     */
    public enum OperationKind {
        LESS(OclKeyWords.LESS),
        LESS_EQUALS(OclKeyWords.LESS_EQUALS),
        GREATER(OclKeyWords.GREATER),
        GREATER_EQUALS(OclKeyWords.GREATER_EQUALS);
        
        private String opName;
        
        /**
         * Creates a constant.
         * 
         * @param opName the VIL name of the operation 
         */
        private OperationKind(String opName) {
            this.opName = opName;
        }
        
        /**
         * Returns the VIL name of the operation.
         * 
         * @return the VIL name of the operation 
         */
        public String getOperationName() {
            return opName;
        }
        
    }

    private OperationKind operation;

    /**
     * Creates a new comparison operation descriptor.
     * 
     * @param declaringType the declaring type
     * @param operation the kind of operation to execute
     */
    IvmlOrderedEnumComparisonOperationDescriptor(TypeDescriptor<?> declaringType, OperationKind operation) {
        super(declaringType, operation.getOperationName(), false);
        this.operation = null == operation ? OperationKind.LESS : operation;
        List<TypeDescriptor<?>> parameters = new ArrayList<TypeDescriptor<?>>();
        parameters.add(declaringType);
        parameters.add(declaringType);
        setParameters(parameters, false, false);
        setReturnType(TypeRegistry.booleanType());
        setCharacteristics(OperationType.INFIX, AliasType.NONE, false, operation.getOperationName());
        
    }

    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        return CompatibilityResult.COMPATIBLE;
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        Object result = null;
        if (null != args && args.length == 2) {
            EnumValue a0 = convertArgument(args[0], EnumValue.class);
            EnumValue a1 = convertArgument(args[1], EnumValue.class);
            if (a0 != null && a1 != null) {
                int o0 = a0.getOrdinal();
                int o1 = a1.getOrdinal();
                switch (operation) {
                case LESS:
                    result = o0 < o1; 
                    break;
                case LESS_EQUALS:
                    result = o0 <= o1; 
                    break;
                case GREATER:
                    result = o0 > o1; 
                    break;
                case GREATER_EQUALS:
                    result = o0 >= o1; 
                    break;
                default:
                    break;
                }
            }
        }
        return result;
    }

}
