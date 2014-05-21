package jess;

import java.io.Serializable;
import java.util.Collection;

@SuppressWarnings("serial")
public class ValueVector implements Cloneable, Serializable {

    public ValueVector() {
    }

    public ValueVector(int a) {
    }

    public final int size() {
        return 0;
    }
    
    public Value get(int index) throws JessException {
        return null;
    }
    
    public ValueVector cloneInto(ValueVector v) {
        return null;
    }

    public ValueVector setLength(int i) {
        return null;
    }

    public final ValueVector set(Value v, int i) throws JessException {
        return null;
    }

    public final ValueVector add(Value v) {
        return null;
    }

    public final ValueVector add(String s) throws JessException {
        return null;
    }

    public final ValueVector add(int a) throws JessException {
        return null;
    }

    public final ValueVector add(double d) throws JessException {
        return null;
    }

    public final ValueVector add(boolean b) {
        return null;
    }

    public final ValueVector add(long l) throws JessException {
        return null;
    }

    public final ValueVector add(Object o) {
        return null;
    }

    public final ValueVector remove(int i) throws JessException {
        return null;
    }

    public static void copy(ValueVector v, int i, ValueVector v1, int s, int t) {
    }

    public ValueVector addAll(ValueVector v) {
        return null;
    }

    public String toStringWithParens() {
        return null;
    }

    @SuppressWarnings("rawtypes")
    public void addAll(Collection c) {
    }
 
    public boolean contains(Value v) {
        return false;
    }
}
