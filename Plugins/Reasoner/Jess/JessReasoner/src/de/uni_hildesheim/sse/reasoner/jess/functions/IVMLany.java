package de.uni_hildesheim.sse.reasoner.jess.functions;

import java.util.Random;

import jess.Context;
import jess.JessException;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to implement the IVML container operation <b>any</b>..
 * @author Phani
 *
 */
public class IVMLany implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {

        ValueVector list = vv.get(1).listValue(context);
        ValueVector v2 = vv.get(2).listValue(context);
        
        ValueVector returnList = new ValueVector();
        
        for (int i = 0; i < list.size(); i++) {
            returnList.add(v2.get(list.get(i).intValue(context)));
        }
        
        return v2.get(list.get(new Random().nextInt(list.size())).intValue(context)).resolveValue(context);
    }

    @Override
    public String getName() {
        return "IVMLany";
    }

}
