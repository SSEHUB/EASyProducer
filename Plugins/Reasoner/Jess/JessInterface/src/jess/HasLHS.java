package jess;

import java.io.Serializable;
import java.util.Iterator;

@SuppressWarnings("serial")
public abstract class HasLHS extends Node implements Serializable, Visitable, Modular, fb {

    public int getGroupSize() {
        return 1;
    }
    
    public ConditionalElement getConditionalElements() {
        return null;
    }
    
    public String listNodes() {
        return null;
    }
    
    public HasLHS getNext() {
        return null;
    }
    
    public int getPatternCount() {
        return 0;
    }
    
    public void setLHS(Group g, Rete r) throws JessException {
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator getBindingNames() {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator getNodes() {
        return null;
    }
    
    public int getNodeCount() {
        return 0;
    }
    
    public void addNode(Node n) throws JessException {
    }
    
    public void setNodeIndexHash(int i) {
    }
    
    public int getNodeIndexHash() {
        return 0;
    }
    
    public final String getName() {
        return null;
    }
    
    public String getDisplayName() {
        return null;
    }
    
    public final String getDocstring() {
        return null;
    }

    public abstract java.lang.Object accept(Visitor v);
    
    public String getModule() {
        return null;
    }
    
    public int getNodeType() {
        return 0;
    }
    
}
