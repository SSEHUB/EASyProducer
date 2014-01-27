package jess;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Iterator;

@SuppressWarnings("serial")
public abstract class Node implements Serializable {

    // TODO Phani: replace initial values by real Jess constants!!!
	//DONE!

    public static final int TYPE_NONE = 0;
    public static final int TYPE_NODE1 = 1;
    public static final int TYPE_NODE2 = 2;
    public static final int TYPE_NODENOT2 = 3;
    public static final int TYPE_TERMINAL = 5;
    public static final int TYPE_ADAPTER = 6;
    public static final int TYPE_TEST = 4;

    public Node() {
    }
    
    @SuppressWarnings("rawtypes")
    public Enumeration getSuccessors() {
        return null;
    }
    
    @SuppressWarnings("rawtypes")
    public Iterator successors()  {
        return null;
    }
    
    public synchronized void addJessListener(JessListener l) {
    }
    
    public synchronized void removeJessListener(JessListener l) {
    }
    
    public abstract int getNodeType();
}
