package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;
/**
 * This is custom made Jess function for the IVML list operation last 
 * There is no direct method in Jess.
 * @author Phani
 *
 */
public class IVMLlast implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        
        ValueVector v = vv.get(1).listValue(context);
        return new Value(v.get(v.size() - 1).resolveValue(context));
    }

    @Override
    public String getName() {
        return "IVMLlast";
    }

}
