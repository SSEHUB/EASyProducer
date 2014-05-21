package jess;

import java.io.Serializable;
import java.util.Iterator;

@SuppressWarnings("serial")
public class Deffunction implements Userfunction, Serializable, Visitable, Named {
    
    public class Argument implements java.io.Serializable{

        public String getName() {
            return null;
        }
        
        public int getType() {
            return 0;
        }
    }
    
    public final String getName() {
        return null;
    }
    
    public final String getDocstring() {
        return null;
    }
    
    public final void setDocstring(String s) {
    }
    
    public Deffunction(String s, String s1) {
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator getArguments() {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator getActions() {
        return null;
    }
    
    public void addArgument(String s, int i) throws JessException {
    }
    
    public void addArgument(Deffunction.Argument a) throws JessException {
    }
    
    public void addAction(Funcall f) throws JessException {
    }
    
    public void addValue(Value v) {
    }
    
    public Value call(ValueVector v, Context c) throws JessException {
        return null;
    }
    
    public Object accept(Visitor v) {
        return null;
    }
    
    public final String getConstructType() {
        return null;
    }

}
