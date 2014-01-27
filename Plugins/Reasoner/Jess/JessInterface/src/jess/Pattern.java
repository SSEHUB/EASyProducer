package jess;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("serial")
public class Pattern implements ConditionalElement, gg, Serializable, Visitable {

    public Pattern(String s, Rete r) throws JessException {
    }
    
    public Pattern(Deftemplate d) {
    }
    
    public void setSlotLength(String s, int i) throws JessException {
    }
    
    public void addTest(Test1 t) throws JessException {
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
    public void findVariableDefinitions(int i, Map m1, Map m2) throws JessException {
    }
    
    public boolean getNegated() {
        return false;
    }
    
    public void setNegated() {
    }
    
    public void setLogical() {
    }
    
    public boolean getLogical() {
        return false;
    }
    
    public void setExplicit() {
    }
    
    public boolean getExplicit() {
        return false;
    }
    
    public boolean getBackwardChaining() {
        return false;
    }
    
    public String getName() {
        return null;
    }
    
    public void setBoundName(String s) throws JessException {
    }
    
    public String getBoundName() {
        return null;
    }
    
    public int getNSlots() {
        return 0;
    }
    
    public int getNTests(int i) throws JessException {
        return 0;
    }
    
    public int getNTests() {
        return 0;
    }
    
    public int getSlotLength(int i) {
        return 0;
    }
    
    public int getNMultifieldsInSlot(int i) throws JessException {
        return 0;
    }
    
    public boolean isMultifieldSubslot(int i, int j) throws JessException {
        return true;
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator getTests() {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator getTests(int i) throws JessException {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator getTests(String s) throws JessException {
        return null;
    }
    
    public Deftemplate getDeftemplate() {
        return null;
    }
    
    public void addToGroup(Group g) throws JessException {
    }
    
    public gg canonicalize() {
        return null;
    }
    
    public Object accept(Visitor v) {
        return null;
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
    
    public int getPatternCount() {
        return 0;
    }
    
    public gg getConditionalElementX(int i) {
        return null;
    }
    
    public boolean isBackwardChainingTrigger() {
        return false;
    }
    
    public String getBackchainingTemplateName() {
        return null;
    }
    
    public String getNameWithoutBackchainingPrefix() {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public void transformOrConjunctionsIntoOrFuncalls(int i, Map m, Rete r) throws jess.JessException {
    }
}
