package net.ssehub.easy.reasoning.drools2.translation;

import net.ssehub.easy.reasoning.drools2.model.ConstraintPattern;

/**
 * A factory for appending relevant translation fragments..
 * @author Sizonenko
 *
 */
public class TranslationFragmentFactory {
    
    /**
     * Method for analyzing constraint pattern and selecting an appropriate type.
     * @param cstPattern Constraint to be analyzed.
     * @return String - translation pattern.
     */
    public static String getTranslationPattern(ConstraintPattern cstPattern) {
        String fragment;
        switch (cstPattern) {
        case SIMPLE_VALIDATION:
            fragment = "Simple validation constraint";
            break;
        case SIMPLE_ASSIGNMENT:
            fragment = "Simple assignment constraint";
            break;
        case IMPLIES_VALIDATION:
            fragment = "Implies validation constraint";
            break;
        case IMPLIES_ASSIGNMENT:
            fragment = "Implies assignment constraint";
            break;
        default:
            fragment = "Unresolved constraint";
            break;
        } 
        return fragment;
    }
    
    /**
     * Method for analyzing if negation is needed.
     * @param cstPattern Constraint to be analyzed.
     * @return boolean.
     */
    private static boolean isNegationNeeded(ConstraintPattern cstPattern) {
        boolean isNeeded;
        switch (cstPattern) {
        case SIMPLE_VALIDATION:
            isNeeded = true;
            break;
        case SIMPLE_ASSIGNMENT:
            isNeeded = true;
            break;
        case IMPLIES_VALIDATION:
            isNeeded = false;
            break;
        case IMPLIES_ASSIGNMENT:
            isNeeded = false;
            break;
        default:
            isNeeded = true;
            break;
        } 
        return isNeeded;
    }
    
    /**
     * Method for opening a negation if needed.
     * @param cstPattern Constraint to be analyzed.
     * @return String.
     */
    public static String getNegationOpeningInWhen(ConstraintPattern cstPattern) {
        String fragment;
        if (!isNegationNeeded(cstPattern)) {
            fragment = "";  
        } else {
            fragment = "    !(";
        }
        return fragment;
    }
    
    /**
     * Method for closing a negation if needed.
     * @param cstPattern Constraint to be analyzed.
     * @return String.
     */
    public static String getNegationClosingInWhen(ConstraintPattern cstPattern) {
        String fragment;
        if (!isNegationNeeded(cstPattern)) {
            fragment = "";  
        } else {
            fragment = ")";
        }
        return fragment;
    }
    
    /**
     * Method for opening a negation if needed.
     * @param cstPattern Constraint to be analyzed.
     * @return String.
     */
    public static String getNegationOpeningInThen(ConstraintPattern cstPattern) {
        String fragment;
        if (isNegationNeeded(cstPattern)) {
            fragment = "";  
        } else {
            fragment = "    !(";
        }
        return fragment;
    }
    
    /**
     * Method for closing a negation if needed..
     * @param cstPattern Constraint to be analyzed.
     * @return String.
     */
    public static String getNegationClosingInThen(ConstraintPattern cstPattern) {
        String fragment;
        if (isNegationNeeded(cstPattern)) {
            fragment = "";  
        } else {
            fragment = ")";
        }
        return fragment;
    }
}
