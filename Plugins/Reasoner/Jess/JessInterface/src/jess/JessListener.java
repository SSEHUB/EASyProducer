package jess;

import java.util.EventListener;

public interface JessListener extends EventListener  {

    public void eventHappened(JessEvent e) throws JessException;
}
