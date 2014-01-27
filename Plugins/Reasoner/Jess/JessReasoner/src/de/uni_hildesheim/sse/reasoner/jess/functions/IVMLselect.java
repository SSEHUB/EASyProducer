package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * An additional method supporting IVML operations SELECT & REJECT.
 * @author Phani
 *
 */
public class IVMLselect implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {

        ValueVector list = vv.get(1).listValue(context);
        ValueVector v2 = vv.get(2).listValue(context);
        
        ValueVector returnList = new ValueVector();
        
        for (int i = 0; i < list.size(); i++) {
            returnList.add(v2.get(list.get(i).intValue(context)));
        }
        
        
        return new Value(returnList, RU.LIST);
    }

    @Override
    public String getName() {
        return "IVMLselect";
    }

}
