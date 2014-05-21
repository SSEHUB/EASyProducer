package jess;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
public class Defrule implements Serializable, gb {

    public Defrule(String s1, String s2, Rete r) throws JessException {
    }
    
    public final int getSalience(Rete r) throws JessException {
        return 0;
    }
    
    public Value getSalienceValue() {
        return null;
    }
    
    public void setSalience(Value v, Rete r) throws JessException {
    }

    public int evalSalience(Rete r) throws JessException {
        return 0;
    }
    
    public boolean hasNonDefaultSalience() {
        return true;
    }
    
    public boolean getAutoFocus() {
        return true;
    }
    
    public void setAutoFocus(boolean b) {
    }
    
    public void addCE(gg g, Rete r) throws JessException {
    }
    
    public void callNodeLeft(int i, Token t, Context c) throws JessException {
    }
    
    public int getNActions() {
        return 0;
    }
    
    public Funcall getAction(int i) {
        return null;
    }
    
    public void addAction(Funcall f) {
    }
    
    public Object accept(Visitor v) {
        return null;
    }
    
    public void setNoLoop(boolean b) {
    }
    
    public boolean isNoLoop() {
        return false;
    }
    
    public final String getConstructType() {
        return null;
    }
    
    public boolean isRelevantChange(int i, Token t, Context c) {
        return false;
    }
    
    @SuppressWarnings("rawtypes")
    public Set getTestedSlotInfo() {
        return null;
    }
}
