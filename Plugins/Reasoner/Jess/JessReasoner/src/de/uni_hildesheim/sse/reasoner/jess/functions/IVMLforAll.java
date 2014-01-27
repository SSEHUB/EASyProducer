package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to define custom function IVMLforall for the container operator forall/foreach.
 * @author Phani
 *
 */
public class IVMLforAll implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context engine) throws JessException {

        ValueVector v = vv.get(1).listValue(engine);
        ValueVector v1 = vv.get(2).listValue(engine);
        
        return new Value(v.size() == v1.size());
    }

    @Override
    public String getName() {
        return "IVMLforAll";
    }

}
