package jess;

import java.io.Serializable;

@SuppressWarnings("serial")
public class JessVersion implements Userfunction, Serializable {
    
    public static final java.lang.String VERSION_STRING = "7.1";
    public static final double VERSION_NUMBER = 7.1;
    public static final java.lang.String COPYRIGHT_STRING = "Jess Mockup interface\n" 
        + "Please obtain a valid Jess license using the upgrade mechanism\n" 
        + "(C) 2012 SSE University of Hildesheim";

    public String getName() {
        return "version";
    }
    
    public Value call(ValueVector v, Context c) throws JessException {
        return null;
    }

}
