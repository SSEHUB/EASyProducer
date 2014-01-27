package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Method to implement IVML mod.
 * @author Phani
 *
 */
public class IVMLmod implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {

        double remainder = vv.get(1).numericValue(context) % vv.get(2).numericValue(context);
        return new Value((int) remainder, RU.INTEGER);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "IVMLmod";
    }

}
