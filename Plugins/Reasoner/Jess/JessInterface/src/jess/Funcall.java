package jess;

import java.io.Serializable;
import java.util.Iterator;

@SuppressWarnings("serial")
public class Funcall implements Serializable, Visitable {

    // puhh! no finals :) null doesn't matter here
    public static Value TRUE = null;
    public static Value FALSE = null;
    public static Value NIL = null;
    public static Value NILLIST = null;
    public static Value EOF = null;
    public static Value CRLF = null;
    public static Value T = null;

    public String toStringWithParens() {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public static Iterator listIntrinsics() {
        return null;
    }
    
    public Funcall(String s, Rete r) throws JessException {
    }
    
    public String getName() {
        return null;
    }
    public Value execute(Context c) throws JessException {
        return null;
    }
    
    public Userfunction getUserfunction(Rete r) throws JessException {
        return null;
    }
    
    public Funcall arg(Value v) {
        return null;
    }
    
    public Funcall arg(String s) throws JessException {
        return null;
    }
    
    public Funcall arg(int i) throws JessException {
        return null;
    }
    
    public Funcall arg(double d) throws JessException {
        return null;
    }
    
    public Funcall arg(long l) throws JessException {
        return null;
    }
    
    public Funcall arg(Funcall f) throws JessException {
        return null;
    }
    
    public Funcall arg(Object o) {
        return null;
    } 

    public Value get(int i) throws JessException {
        return null;
    }
    
    public Object accept(Visitor v) {
        return null;
    }

    public void reset() {
    }
}
