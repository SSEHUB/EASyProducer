package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;
/**
 * This is custom made Jess function for asSequence.. 
 * There is no direct method in Jess.
 * @author Phani
 *
 */
public class IVMLasSequence implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        ValueVector v = vv.get(1).listValue(context);
        ValueVector v1 = new ValueVector();
        v1.addAll(v);
       
        return new Value(v1, RU.LIST);
    }

    @Override
    public String getName() {
        return "IVMLasSequence";
    }

}