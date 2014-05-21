package jess;

import java.util.Map;
import java.util.Set;

@SuppressWarnings("serial")
public class Accumulate implements ConditionalElement, gg, Visitable {

    // TODO Phani: replace initial values by real Jess constants!!!
	//Done!
    
    public static final java.lang.String RESULT = "accumulate-result";
    
    public Accumulate() throws JessException {
    }
    
    public void setBoundName(String s) throws JessException {
    }
    
    public void setNegated() throws JessException {
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
    
    public gg canonicalize() throws JessException {
        return null;        
    }
    
    public boolean getBackwardChaining() {
        return false;        
    }
    
    public void addToGroup(Group g) throws JessException {
    }
    
    @SuppressWarnings("rawtypes")
    public void addDirectlyMatchedVariables(Set s) throws JessException {
    }
    
    @SuppressWarnings("rawtypes")
    public int renameUnmentionedVariables(Set s, Map m, int i, String s1) throws JessException {
        return 0;        
    }
    
    @SuppressWarnings("rawtypes")
    public void recordTestedSlots(Set s) throws JessException {
    }
    
    @SuppressWarnings("rawtypes")
    public void transformOrConjunctionsIntoOrFuncalls(int i, Map m, Rete r) throws JessException {
    }
    
    public boolean isBackwardChainingTrigger() {
        return false;
    }
    
    public int getPatternCount() {
        return 0;
    }
    
    public String getName() {
        return null;
    }
    
    public String getBoundName() {
        return null;    
    }
    
    public int getGroupSize() {
        return 0;    
    }
    
    public gg getConditionalElementX(int i) {
        return null;    
    }
    
    public boolean isGroup() {
        return false;    
    }
    
    public void add(gg g) throws JessException {
    }
    
    public ConditionalElement getConditionalElement(int i) {
        return null;    
    }
    
    public void setBody(Value v) {
    }
    
    public Value getBody() {
        return null;    
    }
    
    public Value getInitializer() {
        return null;
    }
    
    public Value getReturn() {
        return null;
    }
    
    public void setInitializer(Value v) {
    }
    
    public void setReturn(Value v) {
    }
    
    public java.lang.Object accept(Visitor v) {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public void findVariableDefinitions(int i, Map m1, Map m2) throws JessException {
    }
    
}
