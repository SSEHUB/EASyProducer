package jess;

import java.util.Map;
import java.util.Set;

public interface gg extends ConditionalElement, Cloneable {

    public void setBoundName(String s) throws JessException;
    public void setNegated() throws JessException;
    public void setExplicit() throws JessException;
    public void setLogical() throws JessException;
    public boolean getLogical();
    public boolean getNegated();
    public boolean getBackwardChaining();
    public gg getConditionalElementX(int i);
    public int getPatternCount();
    public boolean isBackwardChainingTrigger();
    public gg canonicalize() throws JessException;
    public void addToGroup(Group g) throws JessException;
    @SuppressWarnings("rawtypes")
    public void findVariableDefinitions(int i, Map m, Map m1) throws JessException;
    @SuppressWarnings("rawtypes")
    public void addDirectlyMatchedVariables(Set s) throws jess.JessException;
    @SuppressWarnings("rawtypes")
    public int renameUnmentionedVariables(Set s, Map m, int i, String st) throws JessException;
    @SuppressWarnings("rawtypes")
    public void recordTestedSlots(Set s) throws JessException;
    @SuppressWarnings("rawtypes")
    public void transformOrConjunctionsIntoOrFuncalls(int i, Map m, Rete r) throws JessException;
}
