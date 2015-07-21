package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.lang.reflect.Method;

/**
 * Some signature utilities.
 * 
 * @author Holger Eichelberger
 */
public class SignatureUtils {
    
    /**
     * Returns a normalized Java signature for <code>method</code>. The signature
     * consists of name and parameters. This method may be simplified in future to 
     * optimize performance (public for testing).
     * 
     * @param method the method to return the signature for
     * @param name an alias name
     * @param acceptsNamedParameter whether the method accepts named parameter
     * @return the signature
     */
    public static String getJavaSignature(Method method, String name, boolean acceptsNamedParameter) {
        return getJavaSignature(method.getName(), method.getParameterTypes(), name, acceptsNamedParameter);
    }
    
    /**
     * Returns a normalized Java signature for <code>method</code>. The signature
     * consists of name and parameters. This method may be simplified in future to 
     * optimize performance (public for testing).
     * 
     * @param methodName the actual method name
     * @param param the parameters
     * @param name an alias name
     * @param acceptsNamedParameter whether the method accepts named parameter
     * @return the signature
     */
    public static String getJavaSignature(String methodName, Class<?>[] param, String name, 
        boolean acceptsNamedParameter) {
        StringBuilder tmp = new StringBuilder(null == name ? methodName : name);
        tmp.append("(");
        if (null != param) {
            int count = param.length;
            if (acceptsNamedParameter) {
                count--;
            }
            for (int p = 0; p < count; p++) {
                tmp.append(param[p].getName());
                if (p < count - 1) {
                    tmp.append(",");
                }
            }
            if (acceptsNamedParameter) {
                if (count > 0) {
                    tmp.append(",");
                }
                tmp.append("...");
            }
        }
        tmp.append(")");
        return tmp.toString();
    }

    /**
     * Returns a normalized Java signature for <code>method</code>. The signature
     * consists of name and parameters. This method may be simplified in future to 
     * optimize performance (public for testing). This method does not consider possible
     * unnamed parameter rather than the underlying Java parameter.
     * 
     * @param method the method to return the signature for
     * @return the signature
     */
    public static String getJavaSignature(Method method) {
        return getJavaSignature(method, null, false);
    }

}
