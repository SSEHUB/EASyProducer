package jess;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Value implements Serializable {

    public Value(int a, int b) throws JessException {
    }

    public Value(Value v) {
    }
    
    public Value(String s, int a) throws JessException {
    }
    
    public Value(ValueVector v, int a) throws JessException {
    }
    
    public Value(double d, int i) throws JessException {
    }

    public Value(boolean b) {
    }

    public Value(java.lang.Object o) {
    }
    
    public Value(jess.Userfunction u) {
    }
    
    public Object externalAddressValue(Context c) throws JessException {
        return null;
    }
    
    public Object javaObjectValue(Context c) throws JessException {
        return null;
    }
    
    public Funcall funcallValue(Context c) throws JessException {
        return null;
    }
    
    public Fact factValue(Context c) throws JessException {
        return null;
    }
    
    public ValueVector listValue(Context c) throws JessException {
        return null;
    }
    
    public double numericValue(Context c) throws JessException {
        return 0.0;
    }

    public int intValue(Context c) throws JessException {
        return 0;
    }
    
    public long longValue(Context c) throws JessException {
        return 0L;
    }
    
    public double floatValue(Context c) throws JessException {
        return 0.0;
    }
    
    public final String atomValue(Context c) throws JessException {
        return null;
    }
    
    public String symbolValue(Context c) throws JessException {
        return null;
    }
    
    public String variableValue(Context c) throws JessException {
        return null;
    }
    
    public String stringValue(Context c) throws JessException {
        return null;
    }
    
    public Userfunction functionValue(Context c) throws JessException {
        return null;
    }
    
    public String toStringWithParens() {
        return null;
    }
    
    public int type() {
        return 0;
    }

    public boolean equals(Value v) {
        return false;
    }

    public boolean equalsStar(Value v) {
        return false;
    }
    
    public Value resolveValue(Context c) throws JessException {
        return null;
    }

    public boolean isNumeric(Context c) throws JessException {
        return false;
    }
    
    public boolean isLexeme(Context c) throws JessException {
        return false;
    }
    
    public boolean isLiteral() {
        return false;
    }
    
    public boolean isVariable() {
        return false;
    }

}
