package jess;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RU implements Serializable {

    // TODO Phani: replace initial values by real Jess constants!!!
	// DONE!
    
    public static final int DT_SLOT_NAME = 0;
    public static final int DT_DFLT_DATA = 1;
    public static final int DT_DATA_TYPE = 2;
    public static final int DT_SLOT_SIZE = 3;
    public static final int NONE = 0;
    public static final int ATOM = 1;
    public static final int SYMBOL = 1;
    public static final int STRING = 2;
    public static final int INTEGER = 4;
    public static final int VARIABLE = 8;
    public static final int FACT = 16;
    public static final int FLOAT = 32;
    public static final int FUNCALL = 64;
    public static final int LIST = 512;
    public static final int JAVA_OBJECT = 2048;
    public static final int LEXEME = 3;
    public static final int ANY = -1;
    public static final int EXTERNAL_ADDRESS = 2048;
    public static final int BINDING = 4096;
    public static final int MULTIVARIABLE = 8192;
    public static final int SLOT = 16384;
    public static final int MULTISLOT = 32768;
    public static final int LONG = 65536;
    public static final int LAMBDA = 131072;
    public static final int NUMBER = 65572;
    public static final int LOCAL = -2;
    public static final int GLOBAL = -3;
    public static final int ACCUM_RESULT = -4;
    public static final int PATTERN = -1;
    public static final int AND = 1;
    public static final int OR = 2;
    public static final String DEFAULT_SLOT_NAME = "__data";
    public static final String ROOT_DEFTEMPLATE = "__fact";
    public static final String NO_SLOT = "";
    public static String getTypeName(int a) {
        return null;
    }
    public static int getTypeCode(String a) throws JessException {
        return 0;
    }
    
    public static synchronized String gensym(String a) {
        return null;
    }
    
    public static String getProperty(String a) {
        return null;
    }
    
    public static String tagName(int a) {
        return null;
    }
    
    public static String removePrefix(String s) {
        return null;
    }
    
    @SuppressWarnings("rawtypes") 
    public static Object valueToObject(Class c, Value v, Context x) throws IllegalArgumentException, JessException {
        return null;
    }
    
    @SuppressWarnings("rawtypes") 
    public static Object valueToObject(Class c, Value v, Context x, boolean b) throws IllegalArgumentException, JessException {
        return null;
    }
    
    @SuppressWarnings("rawtypes") 
    public static Value objectToValue(Class c, Object o) throws JessException {
        return null;
    }
    
}
