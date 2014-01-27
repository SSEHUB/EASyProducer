package de.uni_hildesheim.sse.reasoner.jess.functions;
import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to implement the IVML operation isDefined.
 * @author Phani
 *
 */
public class IVMLisDefined implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {

        boolean isDefined = true;
        System.out.println("in isdefined class");
        isDefined = (vv.get(1).resolveValue(context).resolveValue(context) != null);
        if (vv.get(1).resolveValue(context).type() == RU.LIST) {
            isDefined = (vv.get(1).listValue(context).size()) != 0;
        } else if (vv.get(1).resolveValue(context).type() == RU.FACT) {
            System.out.println("");
        } else {
            isDefined = (vv.get(1).resolveValue(context).type() == RU.NONE);
        }

        return new Value(isDefined);
    }

    @Override
    public String getName() {
        return "IVMLisDefined";
    }

}
