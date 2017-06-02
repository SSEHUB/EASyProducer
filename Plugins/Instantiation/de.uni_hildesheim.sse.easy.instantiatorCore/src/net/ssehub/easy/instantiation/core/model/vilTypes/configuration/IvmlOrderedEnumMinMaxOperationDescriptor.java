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
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;

/**
 * Represents the minimum or maximum operation for ordered IVML enums.
 * 
 * @author Holger Eichelberger
 */
public class IvmlOrderedEnumMinMaxOperationDescriptor extends IvmlOperationDescriptor {

    /**
     * The operation kinds.
     * 
     * @author Holger Eichelberger
     */
    public enum OperationKind {
        MIN(OclKeyWords.MIN),
        MAX(OclKeyWords.MAX);
        
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
     * Creates a new min/max operation descriptor.
     * 
     * @param declaringType the declaring type
     * @param operation the kind of operation to execute
     */
    IvmlOrderedEnumMinMaxOperationDescriptor(TypeDescriptor<?> declaringType, OperationKind operation) {
        super(declaringType, operation.getOperationName(), false);
        this.operation = null == operation ? OperationKind.MIN : operation;
        List<TypeDescriptor<?>> parameters = new ArrayList<TypeDescriptor<?>>();
        parameters.add(declaringType);
        parameters.add(declaringType);
        setParameters(parameters, false, false);
        setReturnType(declaringType);
        setCharacteristics(OperationType.FUNCTION, AliasType.NONE, false, operation.getOperationName());
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
                switch (operation) {
                case MIN:
                    result = min(a0, a1);
                    break;
                case MAX:
                    result = max(a0, a1);
                    break;
                default:
                    result = null;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * Returns the minimum enumeration value.
     * 
     * @param v1 the first value to compare
     * @param v2 the second value to compare
     * @return the minimum of both values
     */
    private EnumValue min(EnumValue v1, EnumValue v2) {
        EnumValue result;
        if (v1.getOrdinal() <= v2.getOrdinal()) {
            result = v1;
        } else {
            result = v2;
        }
        return result;
    }

    /**
     * Returns the maximum enumeration value.
     * 
     * @param v1 the first value to compare
     * @param v2 the second value to compare
     * @return the maximum of both values
     */
    private EnumValue max(EnumValue v1, EnumValue v2) {
        EnumValue result;
        if (v1.getOrdinal() >= v2.getOrdinal()) {
            result = v1;
        } else {
            result = v2;
        }
        return result;
    }

}
