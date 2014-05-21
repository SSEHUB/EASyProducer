package jess;

import java.util.EventObject;

@SuppressWarnings("serial")
public class JessEvent extends EventObject {

    // TODO Phani: replace initial values by real Jess constants!!!
	//DONE!

    public static final int DEFRULE = 1;
    public static final int DEFRULE_FIRED = 2;
    public static final int ACTIVATION = 4;
    public static final int DEFFACTS = 8;
    public static final int FACT = 16;
    public static final int DEFINSTANCE = 32;
    public static final int DEFTEMPLATE = 64;
    public static final int DEFCLASS = 128;
    public static final int DEFGLOBAL = 256;
    public static final int USERFUNCTION = 512;
    public static final int USERPACKAGE = 1024;
    public static final int CLEAR = 2048;
    public static final int RESET = 4096;
    public static final int RUN = 8192;
    public static final int HALT = 16384;
    public static final int RETE_TOKEN = 32768;
    public static final int RETE_TOKEN_LEFT = 32768;
    public static final int RETE_TOKEN_RIGHT = 65536;
    public static final int USERFUNCTION_CALLED = 524288;
    public static final int FOCUS = 1048576;
    public static final int USERFUNCTION_RETURNED = 2097152;
    public static final int DEFMODULE = 4194304;
    public static final int MODIFIED = 1073741824;
    public static final int REMOVED = -2147483648;
    
    
    public JessEvent(Object o, int i, Object o1, Context c) {
        super(o);
    }
    
    public int getType() {
        return 0;
    }
    
    public int getTag() {
        return 0;
    }
    
    public Object getObject() {
        return null;
    }
    
    public Context getContext() {
        return null;
    }
    
    public static String getEventName(int i) {
        return null;
    }
}
