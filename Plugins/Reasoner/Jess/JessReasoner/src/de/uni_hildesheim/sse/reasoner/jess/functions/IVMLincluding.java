package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to implement the IVML operation including. 
 * @author Phani
 *
 */
public class IVMLincluding implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {
        ValueVector rV = new ValueVector();
        for (int i = 0; i < vv.get(1).listValue(context).size(); i++) {
            rV.add(vv.get(1).listValue(context).get(i));
        }
        rV.add(vv.get(2).resolveValue(context));
        
        return new Value(rV, RU.LIST);
    }

    @Override
    public String getName() {
        return "IVMLincluding";
    }


}
