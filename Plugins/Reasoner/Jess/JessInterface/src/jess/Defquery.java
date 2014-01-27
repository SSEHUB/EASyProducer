package jess;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Defquery extends HasLHS implements Serializable {

    // TODO Phani: replace initial values by real Jess constants!!!
	// DONE!

    public static final java.lang.String QUERY_TRIGGER = "__query-trigger-";
    
    public Defquery(String s1, String s2, Rete r) throws JessException {
    }
    
    public int getMaxBackgroundRules() {
        return 0;
    }
    
    public void setMaxBackgroundRules(int i) {
    }

    public synchronized void callNodeLeft(int i, Token t, Context c) throws JessException {
    }
    
    public String getQueryTriggerName() {
        return null;
    }
    
    public void addQueryVariable(Variable v) {
    }
    
    public int getNVariables() {
        return 0;
    }
    
    public Variable getQueryVariable(int i) {
        return null;
    }
    
    public void addCE(gg g, Rete r) throws jess.JessException {
    }
    
    public Object accept(Visitor v) {
        return null;
    }
    
    public final String getConstructType() {
        return null;
    }
}
