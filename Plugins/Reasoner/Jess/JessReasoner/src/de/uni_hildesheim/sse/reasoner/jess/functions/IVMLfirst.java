package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;
/**
 * This is custom made Jess function for the IVML list operation first 
 * There is no direct method in Jess.
 * @author Phani
 *
 */
public class IVMLfirst implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        return vv.get(1).listValue(context).get(0).resolveValue(context);
        
    }

    @Override
    public String getName() {
        return "IVMLfirst";
    }

}
