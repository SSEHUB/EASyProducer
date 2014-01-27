package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to implement the IVML operations at and Index_Access.
 * @author Phani
 *
 */
public class IVMLindexAccess implements Userfunction {

    @Override
    public Value call(ValueVector arg0, Context context) throws JessException {

        ValueVector v1 = arg0.get(1).listValue(context);
        int index = arg0.get(2).intValue(context);
        Value v = null;
        if (arg0.get(1).listValue(context).get(0).type() == RU.FACT) {
            v = arg0.get(1).listValue(context).get(index).resolveValue(context);
        } else {
            v = v1.get(index).resolveValue(context);
        }
        return v;
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "IVMLindexAccess";
    }

}
