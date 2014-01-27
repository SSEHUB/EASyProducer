package jess;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FactIDValue extends jess.Value implements Serializable {

    public FactIDValue(Fact f) throws JessException {
        super(f);
    }
    
    public int intValue(Context c) {
        return 0;
    }
    
    public double numericValue(Context c) {
        return 0;
    }
    
    public Fact factValue(Context c) throws JessException {
        return null;
    }
    
    public int getFactId() {
        return 0;
    }
    
    public boolean equals(Value v) {
        return true;
    }
    
}
