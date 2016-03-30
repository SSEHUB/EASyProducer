package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

/**
 * Just some constants.
 * 
 * @author Holger Eichelberger
 */
public class Constants {
    
    public static final Random RANDOM = new Random();
    
    public static final String GETTER_PREFIX = "get";

    public static final String QUALIFICATION_SEPARATOR = "::";

    public static final String COLON = ":";
    
    public static final String DECLARATOR_SEPARATOR = "|";
    
    public static final String ITER_CALL = "->";
    
    public static final String ASSIGNMENT = "=";

    public static final String ADDITION = "+";

    public static final String SUBTRACTION = "-";

    public static final String MULTIPLICATION = "*";

    public static final String DIVISION = "/";

    public static final String EQUALITY = "==";

    public static final String UNEQUALITY = "!=";

    public static final String UNEQUALITY_ALIAS = "<>";
    
    public static final String NEGATION = "!";

    public static final String NEGATION_ALIAS = "not";

    public static final String LESS_THEN = "<";

    public static final String LESS_THEN_EQUALS = LESS_THEN + ASSIGNMENT;

    public static final String GREATER_THEN = ">";

    public static final String GREATER_THEN_EQUALS = GREATER_THEN + ASSIGNMENT;

    public static final String TYPE_ITERATOR = "Iterator";

    public static final String TYPE_STRING = "String";
    
    public static final String TYPE_REAL = "Real";

    public static final String TYPE_INTEGER = "Integer";

    public static final String TYPE_BOOLEAN = "Boolean";
    
    public static final String ARRAY_ACCESS = "[]";
    
    public static final String IMPLICIT_PARENT_PARAMETER_NAME = "$parent";

    public static final String IMPLICIT_PATHS_PARAMETER_NAME = "$paths";

    public static final String IMPLICIT_TERMINATOR_NAME = "$terminator";
    
    public static final java.util.Set<String> IMPLICIT_PARAMETER;
    
    static {
        java.util.Set<String> tmp = new HashSet<String>();
        tmp.add(IMPLICIT_PARENT_PARAMETER_NAME);
        tmp.add(IMPLICIT_PATHS_PARAMETER_NAME);
        tmp.add(IMPLICIT_TERMINATOR_NAME);
        IMPLICIT_PARAMETER = Collections.unmodifiableSet(tmp);
    }
}
