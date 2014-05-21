package jess;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Test1 implements TestBase, Serializable, Visitable, Cloneable {

    public Test1(int i, String s, int j, Value v, int k) {
    }
    
    public Test1(int i, String s, Value v, int k) {
    }
    
    public Test1(int i, String s, int j, Value v) {
    }
    
    public Test1(int i, String s, Value v) {
    }
    
    public int getTest() {
        return 0;
    }
    
    public Value getValue() {
        return null;
    }
    
    public int getMultiSlotIndex() {
        return 0;
    }
    
    public void setMultiSlotIndex(int i) {
    }
    
    public int getConjunction() {
        return 0;
    }
    
    public boolean doTest(Context c) throws JessException {
        return false;
    }
    
    public Object accept(Visitor v) {
        return null;
    }
    
    public void setSlotName(String s) {
    }
    
    public String getSlotName() {
        return null;
    }
}
