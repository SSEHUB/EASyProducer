package jess;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Fact extends ValueVector implements Serializable, Modular, Visitable {

    // TODO Phani: replace initial values by real Jess constants!!!
	// DONE!

    public static final int NO = 0;
    public static final int DYNAMIC = 1;
    public static final int STATIC = 2;
    
    public Fact getIcon() {
        return null;
    }
    
    public String getName() {
        return null;
    }
    
    public int getFactId() {
        return 0;
    }
    
    public boolean isShadow() {
        return false;
    }
    
    public int getShadowMode() {
        return 0;
    }
    
    public final Deftemplate getDeftemplate() {
        return null;
    }
    
    public final String getModule() {
        return null;
    }
    
    public int getTime() {
        return 0;
    }
    
    public Value get(int i) throws JessException {
        return null;
    }
    
    public Fact(Deftemplate d) throws JessException {
    }
    
    public Fact(String s, Rete r) throws JessException {
    }
    
    public Fact(Fact f) throws JessException {
    }
    
    public final Value getSlotValue(String s) throws JessException {
        return null;
    }
    
    public final void setSlotValue(String s, Value v) throws JessException {
    }
    
    public String toStringWithParens() {
        return null;
    }
    
    public final String getConstructType() {
        return null;
    }
    
    public final String getDocstring() {
        return null;
    }
    
    public Object accept(Visitor v) {
        return null;
    }
    
    public void checkConstraints() throws JessException {
    }

}
