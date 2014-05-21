package jess;

import jess.Context;
import jess.JessException;
import jess.Value;
import jess.ValueVector;

public interface Userfunction {

    public Value call(ValueVector vv, Context context) throws JessException;

    public String getName();

}
