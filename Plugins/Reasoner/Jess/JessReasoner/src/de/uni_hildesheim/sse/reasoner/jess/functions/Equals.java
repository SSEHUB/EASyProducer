package de.uni_hildesheim.sse.reasoner.jess.functions;

import jess.Context;
import jess.Fact;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * Class to implement IVML operation equals.
 * @author Phani
 *
 */
public class Equals implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {

        boolean equals = true;
        if (vv.get(1).resolveValue(context).type() != vv.get(2).resolveValue(context).type()) {
            equals = false;
        } else {
            if (vv.get(1).resolveValue(context).type() == RU.FACT) {
                Fact f1 = vv.get(1).factValue(context);
                Fact f2 = vv.get(2).factValue(context);
                removeInstanceSlots(f1, context);
                removeInstanceSlots(f2, context);
                equals = f1.equals(f2);
            } else if (vv.get(1).resolveValue(context).type() == RU.LIST) {
//                System.out.println("Two lists");
                ValueVector v1 = vv.get(1).listValue(context);
                ValueVector v2 = vv.get(2).listValue(context);
                checkListValue(v1, context);
                checkListValue(v2, context);
//                System.out.println("lists are " + v1.toString() + " -- " + v2.toString());
                equals = v1.equals(v2);
                
            } else {
                equals = vv.get(1).resolveValue(context).equals(vv.get(2).resolveValue(context));
            }
        }
        
        return new Value(equals);
    }
    
    /**
     * Private method to set the value of instance slots to zero.
     * @param fact A jess fact.
     * @param context Context.
     * @throws JessException  Jess Exception.
     */
    private void removeInstanceSlots(Fact fact, Context context) throws JessException {
        for (int i = 1; i < fact.size(); i++) {
            if (fact.getDeftemplate().getSlotName(i).contains("instance")) {
                fact.set(new Value(0, RU.INTEGER), i);
            } else if (fact.get(i).type() == RU.FACT) {
                removeInstanceSlots(fact.get(i).factValue(context), context);
            }
        }
    }
    
    /**
     * Private method to process list values. 
     * @param list List
     * @param context Jess Context.
     * @throws JessException Jess Exception.
     */
    private void checkListValue(ValueVector list, Context context) throws JessException {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).resolveValue(context).type() == RU.FACT) {
                removeInstanceSlots(list.get(i).factValue(context), context);
            } else if (list.get(i).resolveValue(context).type() == RU.LIST) {
                checkListValue(list.get(i).listValue(context), context);
            }
        }
    }

    @Override
    public String getName() {
        return "Equals";
    }

}
