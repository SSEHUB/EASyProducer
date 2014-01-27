package jess;

@SuppressWarnings("serial")
public class Variable extends Value {

    public Variable(String s, int i) throws JessException {
        super(s, i);
    }
    
    public Value resolveValue(Context c) throws JessException {
        return null;
    }
    
    public final Object javaObjectValue(Context c) throws JessException {
        return null;
    }
    
    public final Fact factValue(Context c) throws JessException {
        return null;
    }
    
    public final ValueVector listValue(Context c) throws JessException {
        return null;
    }
    
    public final int intValue(Context c) throws JessException {
        return 0;
    }
    
    public final double floatValue(Context c) throws JessException {
        return 0;
    }
    
    public final double numericValue(Context c) throws JessException {
        return 0;
    }
    
    public final String symbolValue(Context c) throws JessException {
        return null;
    }
    
    public final String variableValue(Context c) {
        return null;
    }
    
    public final String stringValue(Context c) throws JessException {
        return null;
    }
    
    public boolean isVariable() {
        return false;
    }
    
}
