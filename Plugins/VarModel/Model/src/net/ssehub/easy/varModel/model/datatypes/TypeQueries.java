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
package net.ssehub.easy.varModel.model.datatypes;

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
        Operation result = null;
        Operation fallBack = null;
        if (null != operand) { // xtext
            // constraintType operations are checked explicitly, must not be AnyType operations
            boolean noAny = operand instanceof ConstraintType;
            for (int o = 0; null == result && o <= operand.getOperationCount() - 1; o++) {
                Operation tmp = operand.getOperation(o);
                if (tmp.getName().equals(name)) {
                    int tmpParamCount = tmp.getParameterCount();
                    if (null == parameter) {
                        if (0 == tmpParamCount) {
                            result = tmp;
                        }
                    } else if (parameter.length == tmpParamCount) {
                        boolean eq = (noAny && tmp.getOperand() != AnyType.TYPE) || !noAny;
                        for (int p = 0; eq && p < tmpParamCount; p++) {
                            IDatatype specifiedType = tmp.getParameterType(p);
                            IDatatype givenType = parameter[p];
                            if (null != specifiedType && null != givenType) { // xtext
                                eq = specifiedType.isAssignableFrom(givenType) 
                                    || (givenType.getTypeClass() == specifiedType.getTypeClass());
                            }
                        }
                        // register just for checkstyle
                        boolean register = eq && null == result;
                        if (register && tmp.isFallback()) {
                            fallBack = tmp;
                        } else if (register) {
                            result = tmp;
                        }
                    }
                }
            }
        }
        if (null == result) {
            result = fallBack;
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
            same = isAnyType(type2); 
        } else if (AnyType.TYPE == type2) {
            same = isAnyType(type1); // second for real vs. delegating type
        } else if (type1 != null && type2 != null) { // may happen for missing generics
            // and now the usual types
            same = type1.isAssignableFrom(type2) && type2.isAssignableFrom(type1);
        } else {
            same = false;
        }
        return same;
    }
    
    /**
     * Returns whether <code>type</code> is {@link AnyType}.
     * 
     * @param type the type to check
     * @return <code>true</code> for {@link AnyType}, <code>false</code> else
     */
    public static boolean isAnyType(IDatatype type) {
        return AnyType.TYPE == type || type instanceof AnyType; // second for real vs. delegating type
    }

    /**
     * Returns whether <code>type</code> is an enum.
     * 
     * @param type the type to check
     * @return <code>true</code> if <code>type</code> is an enum, <code>false</code> else
     */
    public static boolean isEnum(IDatatype type) {
        return Enum.TYPE.isAssignableFrom(type) && AnyType.TYPE != type;
    }

    /**
     * Returns whether <code>type</code> is a freeze variable.
     * 
     * @param type the type to check
     * @return <code>true</code> if <code>type</code> is a a freeze variable, <code>false</code> else
     */
    public static boolean isFreezeVariableType(IDatatype type) {
        return FreezeVariableType.TYPE.isAssignableFrom(type) && AnyType.TYPE != type;
    }

    /**
     * Returns whether <code>type</code> is a reference.
     * 
     * @param type the type to check
     * @return <code>true</code> if <code>type</code> is a reference, <code>false</code> else
     */
    public static boolean isReference(IDatatype type) {
        return Reference.TYPE.isAssignableFrom(type) && AnyType.TYPE != type;
    }
    
    /**
     * Returns whether <code>type</code> is a constraint (in the sense of a constraint variable).
     * 
     * @param type the type to check
     * @return <code>true</code> if <code>type</code> is a constraint, <code>false</code> else
     */
    public static boolean isConstraint(IDatatype type) {
        boolean isConstraint = ConstraintType.TYPE.isAssignableFrom(type) && AnyType.TYPE != type;
        if (isConstraint) { // comes from an old hack making ConstraintType and Boolean assignable :(
            IDatatype res = resolveFully(type.getType());
            isConstraint = !(res == BooleanType.TYPE || res == BooleanType.TYPE.getType());
        }
        return isConstraint;
    }
    
    /**
     * Returns whether <code>type</code> is a compound type.
     * 
     * @param type the type
     * @return <code>true</code> for compound, <code>false</code> else
     */
    public static boolean isCompound(IDatatype type) {
        return Compound.TYPE.isAssignableFrom(type) && AnyType.TYPE != type;
    }

    /**
     * Returns whether <code>type</code> is a container.
     * 
     * @param type the type to check for
     * @return <code>true</code> if <code>type</code> is a container, <code>false</code> else
     */
    public static boolean isContainer(IDatatype type) {
        return Container.TYPE.isAssignableFrom(type) && AnyType.TYPE != type;
    }

    /**
     * Returns whether <code>type</code> is a set.
     * 
     * @param type the type to check for
     * @return <code>true</code> if <code>type</code> is a container, <code>false</code> else
     */
    public static boolean isSet(IDatatype type) {
        return Set.TYPE.isAssignableFrom(type) && AnyType.TYPE != type;
    }

    /**
     * Returns whether <code>type</code> is a sequence.
     * 
     * @param type the type to check for
     * @return <code>true</code> if <code>type</code> is a container, <code>false</code> else
     */
    public static boolean isSequence(IDatatype type) {
        return Set.TYPE.isAssignableFrom(type) && AnyType.TYPE != type;
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
    
    /**
     * Resolves to the most basic type, i.e., even across nested references/derived types.
     * 
     * @param type the type to resolve
     * @return the most basic type
     */
    public static IDatatype resolveFully(IDatatype type) {
        IDatatype iter = type;
        IDatatype result;
        do {
            result = Reference.dereference(DerivedDatatype.resolveToBasis(iter));
            if (iter == result) {
                break;
            }
            iter = result;
        } while (true);
        return result;
    }

}
