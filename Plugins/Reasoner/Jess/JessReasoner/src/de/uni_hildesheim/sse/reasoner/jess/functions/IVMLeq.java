package de.uni_hildesheim.sse.reasoner.jess.functions;
import jess.Context;
import jess.Fact;
import jess.JessException;
import jess.RU;
import jess.Userfunction;
import jess.Value;
import jess.ValueVector;


/**
 * Implementation for the IVML operation equals (=).
 * @author Phani
 *
 */
public class IVMLeq implements Userfunction {

    @Override
    public Value call(ValueVector vv, Context context) throws JessException {

        boolean isEqual = true;
        if (vv.get(1).resolveValue(context).type() != vv.get(2).resolveValue(context).type()) {
            
            isEqual = false;
        } else {
            if (vv.get(1).resolveValue(context).type() == RU.FACT) {
                Fact f1 = vv.get(1).factValue(context);
                Fact f2 = vv.get(2).factValue(context);

                isEqual = isEqualFacts(isEqual, f1, f2, context);

            } else if (vv.get(1).resolveValue(context).type() == RU.LIST) {
                System.out.println(" List values - containers!");
                ValueVector listOne = vv.get(1).listValue(context);
                ValueVector listTwo = vv.get(2).listValue(context);
                isEqual = isEqualLists(context, isEqual, listOne, listTwo);
            } else {
                
                isEqual = vv.get(1).resolveValue(context).equals(vv.get(2).resolveValue(context));
            }
        }

        return new Value(isEqual);
    }

    /**
    * Private method to check equality of lists.
    * @param context Jess context.
    * @param isEqual Equality.
    * @param listOne List one.
    * @param listTwo List two.
    * @return <b>True</b> if the lists are equal.
    * @throws JessException Should not occur.
    */
    private boolean isEqualLists(Context context, boolean isEqual,
            ValueVector listOne, ValueVector listTwo) throws JessException {
        if (listOne.size() != listTwo.size()) {
            isEqual = false;
        } else if ((listOne.size() == 0) || (listTwo.size() == 0)) {
            isEqual = false;
        } else if (listOne.get(0).resolveValue(context).type() != RU.FACT) {
            for (int i = 0; i < listOne.size(); i++) {
                if (listOne.get(i) != listTwo.get(i)) {
                    isEqual = false;
                    break;
                }
            }
        } else if (listOne.get(0).resolveValue(context).type() != listOne.get(0).resolveValue(context).type()) {
            isEqual = false;
        } else if (listOne.get(0).resolveValue(context).type() == RU.FACT) {
            for (int i = 0; i < listOne.size(); i++) {
                Fact f1 = listOne.get(i).factValue(context);
                Fact f2 = listTwo.get(i).factValue(context);
                if (!isEqualFacts(true, f1, f2, context)) {
                    isEqual = false;
                    break;
                }
            }
        }
        return isEqual;
    }

    /**
     * A private method to check if two facts are equal.
     * @param isEqual the result.
     * @param f1 Fact one.
     * @param f2 Fact two.
     * @param context Jess context.
     * @return <b>True</b> if the two facts are equal.
     * @throws JessException Should not occur.
     */
    private boolean isEqualFacts(boolean isEqual, Fact f1, Fact f2, Context context)
        throws JessException {
        if (f1.getDeftemplate().getBaseName() != f2.getDeftemplate().getBaseName()) {
            isEqual = false;
        } else {
            for (int sl = 1; sl < f1.size(); sl++) {
                if (f1.getDeftemplate().getSlotName(sl).contains("instance")) {
                    f1.set(new Value(0, RU.INTEGER), sl);
                }
            }
            for (int sl = 1; sl < f2.size(); sl++) {
                if (f2.getDeftemplate().getSlotName(sl).contains("instance")) {
                    f2.set(new Value(0, RU.INTEGER), sl);
                }
            }    
//            System.out.println("f1 and f2 " + f1.toString() + f2.toString() + " .. " + f1.equals(f2));
                
            if (f1.get(0).resolveValue(context).type() != RU.FACT) {
            
                isEqual = f1.equals(f2);
                
            } else {
                for (int i = 1; i < f1.size() && i < f2.size(); i++) {
                    if (f1.get(i).resolveValue(context).type() == RU.FACT) {
                        if (!isEqualFacts(true, f1.get(i).factValue(context), f2.get(i).factValue(context), context)) {
                            isEqual = false;
                            break;
                        }
                    } else if (f1.get(i).resolveValue(context).type() == RU.LIST) {
                        System.out.println("slot containts list ");
                        if (!isEqualLists(context, true, f1.get(i).listValue(context), f2.get(i).listValue(context))) {
                            isEqual = false;
                            break;
                        }
                    }
                }
            }
        }
        return isEqual;
    }

    @Override
    public String getName() {
        return "IVMLeq";
    }

}
