package jess;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("serial")
public class Group implements ConditionalElement, gg, Serializable, Visitable {
    
    // TODO Phani: replace initial values by real Jess constants!!!
	//DONE!
    
    public static final String AND = "and";
    public static final String UNIQUE = "unique";
    public static final String EXPLICIT = "explicit";
    public static final String NOT = "not";
    public static final String EXISTS = "exists";
    public static final String TEST = "test";
    public static final String OR = "or";
    //This is LOGICAL
    public static final String LOGICAL = "logical";
    public static final String FORALL = "forall";
    public static final String ACCUMULATE = "accumulate";
    
    public Group(String s) throws JessException {
    }
    
    public String getName() {
        return null;
    }

    public int getPatternCount() {
        return 0;
    }
    
    public final gg add(ConditionalElement c) throws JessException {
        return null;
    }
    
    public final gg add(gg g) throws JessException {
        return null;
    }
    
    public boolean getBackwardChaining() {
        return false;
    }
    
    public void setExplicit() throws JessException {
    }
    
    public void setLogical() throws JessException {
    }
    
    public boolean getLogical() {
        return false;
    }
    
    public boolean getNegated() {
        return false;
    }
    
    public void setNegated() throws JessException {
    }
    
    public void setBoundName(String s) throws JessException {
    }
    
    public String getBoundName() {
        return "";
    }
    
    public static boolean isNegatedName(String s) {
        return false;
    }

    public gg canonicalize() throws JessException {
        return null;
    }
    
    public void addToGroup(Group g) throws JessException {
    }
    
    public int getGroupSize() {
        return 0;
    }
    
    public boolean isGroup() {
        return false;
    }
    
    public ConditionalElement getConditionalElement(int i) {
        return null;
    }
    
    public gg getConditionalElementX(int i) {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public void addDirectlyMatchedVariables(Set s) throws JessException {
    }
    
    @SuppressWarnings("rawtypes")
    public int renameUnmentionedVariables(Set s, Map m, int i, String st) throws JessException {
        return 0;
    }
    
    @SuppressWarnings("rawtypes")
    public void recordTestedSlots(Set s) throws JessException {
    }
    
    public boolean isBackwardChainingTrigger() {
        return false;
    }
    
    public Object accept(Visitor v) {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public void findVariableDefinitions(int i, Map m1, Map m2) throws JessException {
    }
    
    @SuppressWarnings("rawtypes")
    public void transformOrConjunctionsIntoOrFuncalls(int i, Map m, Rete r) throws JessException {
    }

}
