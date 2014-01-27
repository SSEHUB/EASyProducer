package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;
/**
 * This is custom made Jess function for isEmpty - a list operation. 
 * There is no direct method in Jess.
 * @author Phani
 *
 */
public class IVMLisEmpty implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        ValueVector v = vv.get(1).listValue(context);
        String result = "";
        if (v.size() == 0) {
            result = "TRUE";
        } else {
            result = "FALSE";
        }
       
        return new Value(result, RU.SYMBOL); 
    }

    @Override
    public String getName() {
        return "IVMLisEmpty";
    }

}
