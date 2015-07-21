package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.lang.annotation.Annotation;

/**
 * Generic type operations.
 * 
 * @author Holger Eichelberger
 */
public class TypeHelper {

    /**
     * Prevents external instantiation.
     */
    private TypeHelper() {
    }
    
    /**
     * Returns the more specific operation based on the first parameter.
     * 
     * @param <O> the type of the operation class
     * 
     * @param op1 the first operation
     * @param op2 the second operation
     * @return <ul>
     *     <li><code>op1</code> if the type of the first parameter of <code>op1</code> is more 
     *       specific than the type of the first parameter of <code>op2</code></li>
     *     <li><code>op2</code> if the type of the first parameter of <code>op2</code> is more 
     *       specific than the type of the first parameter of <code>op1</code></li>
     *     <li><code>op1</code> if the type of the first parameter of <code>op1</code> is not 
     *       a basic type while the first parameter of <code>op2</code> is a basic type</li>
     *     <li><code>op2</code> if the type of the first parameter of <code>op2</code> is not 
     *       a basic type while the first parameter of <code>op1</code> is a basic type</li>
     *     <li><code>op2</code> if <code>op1</code> is <b>null</b></li>
     *     <li><code>op1</code> if <code>op2</code> is <b>null</b></li>
     *     <li><code>op1</code> in any other case</li>
     *   </ul>
     */
    public static final <O extends IMetaOperation> O getMoreSpecificParam1(O op1, O op2) {
        O result = op1;
        if (null == op1) {
            result = op2;
        } else { // null != op1
            if (null == op2) {
                result = op1;
            } else {
                if (1 == op1.getParameterCount() && 1 == op2.getParameterCount()) {
                    IMetaType param1 = op1.getParameterType(0);
                    IMetaType param2 = op2.getParameterType(0);
                    if (param1.isAssignableFrom(param2)) {
                        result = op2;
                    } else if (param2.isAssignableFrom(param1)) {
                        result = op1;
                    } else {
                        if (param1.isBasicType() && !param2.isBasicType()) {
                            result = op2;
                        } else if (!param1.isBasicType() && param2.isBasicType()) {
                            result = op1;
                        }
                    }
                }
            }
        }
        return result;
    }

    /**
     * Tries to find a conversion among the given types. Defined conversions on both
     * types are taken into account.
     * 
     * @param argType the argument type
     * @param paramType the parameter type
     * @return the conversion operation or <b>null</b> if there is none
     */
    public static IMetaOperation findConversion(IMetaType argType, IMetaType paramType) {
        IMetaOperation c1 = argType.findConversion(argType, paramType);
        IMetaOperation c2 = paramType.findConversion(argType, paramType);
        return TypeHelper.getMoreSpecificParam1(c1, c2);
    }

    /**
     * Returns whether the given <code>cls</code> represents a basic type.
     * 
     * @param cls the class to be tested
     * @return <code>true</code> if <code>cls</code> represents a basic type, <code>false</code> else
     */
    public static boolean isBasicType(Class<?> cls) {
        return cls == PseudoBoolean.class || cls == PseudoInteger.class 
            || cls == PseudoReal.class || cls == PseudoString.class;
    }
    
    /**
     * Returns the QM generic annotation if defined.
     * 
     * @param <T> the annotation type to search for
     * @param annotations the parameter annotations to consider
     * @param index the index of the parameter
     * @param cls the annotation class to return
     * @return the annotation or <b>null</b>
     */
    public static <T extends Annotation> T getParameterAnnotation(Annotation[][] annotations, int index, 
        Class<T> cls) {
        T result = null;
        if (null != annotations) {
            Annotation[] tmp = annotations[index];
            if (null != tmp) {
                for (int a = 0; null == result && a < tmp.length; a++) {
                    if (cls.isInstance(tmp[a])) {
                        result = cls.cast(tmp[a]);
                    }
                }
            }
        }
        return result;
    }

}
