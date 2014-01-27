package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class implementing the IVML operation floor.
 * @author Phani
 *
 */
public class IVMLfloor implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {

        int type = vv.get(1).resolveValue(context).type();
        Value v = null;
        if (type == RU.INTEGER) {
            v = new Value(Math.floor(vv.get(1).intValue(context)), type);
        } else {
            v = new Value(Math.floor(vv.get(1).floatValue(context)), type);
        }
        return v;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "IVMLfloor";
    }

}
