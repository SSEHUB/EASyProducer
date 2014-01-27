package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to define custom function IVMLexists for the operator exists.
 * @author Phani
 *
 */
public class IVMLexists implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context engine) throws JessException {

        ValueVector v = vv.get(1).listValue(engine);
        int matchInc = 0;
        
        for (int i = 0; i < v.size(); i++) {
            if (v.get(i).symbolValue(engine).equals("TRUE")) {
                matchInc++;
            }
        }
        
        
        
        return new Value(matchInc != 0);
    }

    @Override
    public String getName() {
        return "IVMLexists";
    }

}
