package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to implment IVML operation round.
 * @author Phani
 *
 */
public class IVMLround implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        double roundV = vv.get(1).floatValue(context);
        
        return new Value(Math.round(roundV), RU.FLOAT);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "IVMLround";
    }

}
