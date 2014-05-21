package jess;

import java.io.Serializable;
import java.util.Iterator;

@SuppressWarnings("serial")
public class Deffacts implements Serializable, Visitable, Named {

    public final String getName() {
        return null;
    }
    
    public final String getModule() {
        return null;
    }
    
    public final String getDocstring() {
        return null;
    }
    
    public Deffacts(String s1, String s2, Rete r) throws JessException {
    }
    
    public void addFact(Fact f) {
    }
    
    public int getNFacts() {
        return 0;
    }
    
    public Fact getFact(int i) {
        return null;
    }
    
    public void reset(Rete r) throws JessException {
    }
    
    public Object accept(Visitor v){
        return null;
    }
    
    public final String getConstructType(){
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator listFacts() {
        return null;
    }
}
