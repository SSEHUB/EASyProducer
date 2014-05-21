package jess;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Defglobal implements Serializable, Visitable, Named {

    public Defglobal(String s, Value v) {
    }

    public void reset(Rete r) throws JessException {
    }

    public String getName() {
        return null;
    }
    
    public Value getInitializationValue() {
        return null;
    }
    
    public Object accept(Visitor v) {
        return null;
    }
    
    public final String getConstructType() {
        return null;
    }
    
    public final String getDocstring() {
        return null;
    }
}
