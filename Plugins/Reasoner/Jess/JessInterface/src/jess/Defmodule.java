package jess;

import java.io.Serializable;
import java.util.Iterator;

@SuppressWarnings("serial")
public class Defmodule implements Serializable, Named, Visitable{

    // TODO Phani: replace initial values by real Jess constants!!!
   //	DONE!

    public static final java.lang.String MAIN = "MAIN";
    
    public Defmodule() {
    }
    
    public Defmodule(String s, String s1) {
    }
    
    public String getName() {
        return null;
    }

    public String getDocstring() {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator listDeftemplates() {
        return null;
    }

    public Deftemplate getDeftemplate(String s) {
        return null;
    }
    
    public Deftemplate addDeftemplate(Deftemplate d, Rete r) throws JessException {
        return null;
    }

    public final String getConstructType() {
        return null;
    }
    
    public Object accept(Visitor v) {
        return null;
    }
    
    public void removeDeftemplate(Deftemplate d) {
    }

    public void setAutoFocus(boolean a) {
    }
    
    public boolean getAutoFocus() {
        return false;
    }
}
