package de.uni_hildesheim.sse.reasoner.jess.functions;
import jess.Context;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;

/**
 * This is custom made Jess function for IVML union on sequences. 
 * There is no direct method in Jess.
 * @author Phani
 *
 */
public class IVMLUnion implements Userfunction {

    @Override
    public Value call(ValueVector arg0, Context context) throws JessException {

        ValueVector listOne = arg0.get(1).listValue(context);
        ValueVector listTwo = arg0.get(3).listValue(context);
        
        ValueVector list = new ValueVector();
        ValueVector union = new ValueVector();
        
        for (int i = 0; i < listOne.size(); i++) {
            list.add(listOne.get(i).resolveValue(context));
        }
        
        for (int i = 0; i < listTwo.size(); i++) {
            list.add(listTwo.get(i).resolveValue(context));
        }
        if (arg0.get(2).numericValue(context) == 2) {
            for (int i = 0; i < list.size(); i++) {
                if (!union.contains(list.get(i).resolveValue(context))) {
                    union.add(list.get(i).resolveValue(context));
                }
            }
        } else {
            union.addAll(list);
        }
        return new Value(union, RU.LIST);
    }

    @Override
    public String getName() {
        return "IVMLUnion";
    }

}
