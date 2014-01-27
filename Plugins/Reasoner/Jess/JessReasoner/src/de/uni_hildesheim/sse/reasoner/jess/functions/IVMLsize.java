package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;
/**
 * Class to implement the IVML operations string size and list size.
 * @author Phani
 *
 */
public class IVMLsize implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        int size = 0;
        if (vv.get(1).resolveValue(context).type() == RU.LIST) {
            size = vv.get(1).listValue(context).size();
        } else if (vv.get(1).resolveValue(context).type() == RU.STRING) {
            size = vv.get(1).stringValue(context).length();
        }
        return (new Value(size, RU.INTEGER));
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "IVMLsize";
    }

}
