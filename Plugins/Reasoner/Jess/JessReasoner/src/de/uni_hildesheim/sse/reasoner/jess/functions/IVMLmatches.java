package de.uni_hildesheim.sse.reasoner.jess.functions;
import jess.Context;
import jess.JessException;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Method to implement the IVML String operation matches.
 */
public class IVMLmatches implements Userfunction {
    

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {

        String s1 = vv.get(1).stringValue(context);
        String s2 = vv.get(2).stringValue(context);
        int result = s1.compareToIgnoreCase(s2);
        return new Value(result == 0);
    }

    @Override
    public String getName() {
        // TODO Auto-generated method stub
        return "IVMLmatches";
    }

}
