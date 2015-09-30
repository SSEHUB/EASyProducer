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
package de.uni_hildesheim.sse.model.varModel.datatypes;

/**
 * Provides some utility operations, also due to the split in the inheritance
 * hierarchy.
 * 
 * @author Holger Eichelberger
 */
public class TypeQueries {

    /**
     * Returns an operation defined on <code>operand</code> with
     * given <code>name</code> and <code>parameters</code>.
     * Please note that the first parameter of an operation
     * is implicitly <code>operand</code>.
     * 
     * @param operand the type the operation shall be defined for
     * @param name the name of the operation
     * @param parameter the list of parameters (excluding
     *   this data type)
     * @return the operation or <b>null</b> if none was found
     */
    public static Operation getOperation(IDatatype operand, String name, IDatatype... parameter) {
        // rather preliminary, shall be part of an abstract superclass!
        Operation result = null;
        if (null != operand) { // xtext
            for (int o = 0; null == result && o < operand.getOperationCount(); o++) {
                Operation tmp = operand.getOperation(o);
                if (tmp.getName().equals(name)) {
                    int tmpParamCount = tmp.getParameterCount();
                    if (null == parameter) {
                        if (0 == tmpParamCount) {
                            result = tmp;
                        }
                    } else if (parameter.length == tmpParamCount) {
                        boolean eq = true;
                        for (int p = 0; eq && p < tmpParamCount; p++) {
                            IDatatype specifiedType = tmp.getParameter(p);
                            IDatatype givenType = parameter[p];
                            if (null != specifiedType && null != givenType) { // xtext
                                eq = (specifiedType.isAssignableFrom(givenType)
                                    || givenType.getTypeClass() == specifiedType.getTypeClass());
                            }
                        }
                        if (eq) {
                            result = tmp;
                        }
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Returns whether the two types given are the same.
     * 
     * @param type1 the first type
     * @param type2 the second type
     * @return <code>true</code> if type1 and type2 are the same, <code>false</code> else
     */
    public static boolean sameTypes(IDatatype type1, IDatatype type2) {
        boolean same;
        // any type are special as they are assignable to everything
        if (AnyType.TYPE == type1) {
            same = AnyType.TYPE == type2;
        } else if (AnyType.TYPE == type2) {
            same = AnyType.TYPE == type1;
        } else if (type1 != null && type2 != null) { // may happen for missing generics
            // and now the usual types
            same = type1.isAssignableFrom(type2) && type2.isAssignableFrom(type1);
        } else {
            same = false;
        }
        return same;
    }

    /**
     * Returns whether <code>type</code> is an enum.
     * 
     * @param type the type to check
     * @return <code>true</code> if <code>type</code> is an enum, <code>false</code> else
     */
    public static boolean isEnum(IDatatype type) {
        return Enum.TYPE.isAssignableFrom(type);
    }
    
    /**
     * Finds the deepest generic type in <code>type</code> always trying <code>pos</code> as position for the 
     * generic type.
     * 
     * @param type the type
     * @param pos the 0-based position of the generic type to follow
     * @return the deepest generic type
     */
    public static IDatatype findDeepestGeneric(IDatatype type, int pos) {
        IDatatype result;
        if (0 <= pos && pos < type.getGenericTypeCount()) {
            result = findDeepestGeneric(type.getGenericType(pos), pos);
        } else {
            if (Container.TYPE.isAssignableFrom(type)) {
                result = AnyType.TYPE;
            } else {
                result = type;
            }
        }
        return result;
    }

    /**
     * Turns the generics of <code>type</code> into an array of types.
     * 
     * @param type the type
     * @return the generics
     */
    public static IDatatype[] toGenerics(IDatatype type) {
        int count = type.getGenericTypeCount();
        IDatatype[] param = new IDatatype[count];
        for (int g = 0; g < count; g++) {
            param[g] = type.getGenericType(g);
        }
        return param;
    }

}
