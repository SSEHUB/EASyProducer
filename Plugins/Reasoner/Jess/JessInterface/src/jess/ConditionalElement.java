package jess;

import java.io.Serializable;

public interface ConditionalElement extends Serializable {

    public String getName();
    public String getBoundName();
    public int getGroupSize();
    public boolean isGroup();
    public ConditionalElement getConditionalElement(int i);
    
}
