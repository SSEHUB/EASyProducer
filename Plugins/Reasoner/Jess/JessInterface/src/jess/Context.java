package jess;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Stack;

@SuppressWarnings("serial")
public class Context implements Serializable {

    //public final jess.Token getToken();
    public final Fact getFact() {
        return null;
    }
    
    //public final synchronized jess.e7 getLogicalSupportNode();
    
    public Context(Context c) {
    }
    
    public Context(Context c, Rete r) {
    }
    
    public final synchronized boolean returning() {
        return false;
    }
    
    public final synchronized Value setReturnValue(Value v) {
        return null;
    }
    
    public final synchronized Value getReturnValue() {
        return null;
    }
    
    public final synchronized void clearReturnValue() {
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator getVariableNames() {
        return null;
    }
    
    public final Rete getEngine() {
        return null;
    }
    
    public Context push() {
        return null;
    }
    
    public synchronized Context pop() {
        return null;
    }
    
    public Context getParent() {
        return null;
    }
    
    public Value getVariable(String s) throws JessException {
        return null;
    }
    
    public boolean isVariableDefined(String s) {
        return false;
    }
    
    public synchronized void setVariable(String s, Value v) throws JessException {
    }
    
    public void setExistingVariable(String s, Value v) throws JessException {
    }
    
    public synchronized void pushStackFrame(Funcall f) throws JessException {
    }
    
    @SuppressWarnings("rawtypes")
    public synchronized Stack getStackData() throws JessException {
        return null;
    }
    
    public synchronized void popStackFrame(Funcall f) throws JessException {
    }

    public synchronized Funcall getFuncall() throws JessException {
        return null;
    }
    
    //public synchronized jess.server.LineNumberRecord getLineNumberRecord() throws jess.JessException;
    
    public synchronized Value getBindingVariable(String s) throws JessException {
        return null;
    }
    
    public synchronized void removeVariable(String s) {
    }
}
