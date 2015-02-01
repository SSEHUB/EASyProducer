package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration.DecisionVariable;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Common operations for sequences.
 * 
 * @author Holger Eichelberger
 */
public class SequenceOperations {
    
    /**
     * Maps the elements of <code>seq1</code> to the elements of <code>seq2</code>
     * and returns the mapping pairs (based on the equals operation). Please note that
     * both sequences must have exactly one type parameter. 
     *
     * @param <T> the element type
     * @param seq1 the first sequence to map
     * @param seq2 the second sequence to map against
     * 
     * @return the mapping (key is taken from this sequence, value from <code>other</code>)
     */
    public static <T> Map<T, T> mapSequence(Sequence<T> seq1, Sequence<T> seq2) {
        Map<T, T> result;
        if (null != seq1 && null != seq2 
            && 1 == seq1.getDimensionCount() && 1 == seq2.getDimensionCount()) {
            int s1 = 0;
            int s2 = 0;
            boolean reverse = false;
            if (seq1.size() < seq2.size()) {
                Sequence<T> tmp = seq1;
                seq1 = seq2;
                seq2 = tmp;
                reverse = true;
            }
            int count1 = seq1.size();
            int count2 = seq2.size();
            TypeDescriptor<? extends IVilType>[] params = TypeDescriptor.createArray(2);
            params[0] = seq1.getDimensionType(0);
            params[1] = seq2.getDimensionType(0);
            result = new Map<T, T>(params, Math.max(count1, count2));
            while (s1 < count1 && s2 < count2) {
                T elt1 = seq1.get(s1);
                T elt2 = seq2.get(s2);
                if (elt1 == null) {
                    if (elt2 == null) {
                        s2++;
                    }
                    s1++;
                } else {
                    if (null == elt2) {
                        s2++;
                    } else {
                        boolean equals;
                        if (elt1 instanceof DecisionVariable && elt2 instanceof DecisionVariable) {
                            Value val1 = ((DecisionVariable) elt1).getDecisionVariable().getValue();
                            Value val2 = ((DecisionVariable) elt2).getDecisionVariable().getValue();
                            equals = val1.equals(val2);
                        } else {
                            equals = elt1.equals(elt2);
                        }
                        if (equals) {
                            if (reverse) {
                                result.add(elt1, elt2);
                            } else {
                                result.add(elt2, elt1);
                            }
                            s1++;
                            s2++;
                        } else {
                            s1++;  
                        }
                        
                    }
                }
            }
        } else {
            result = null;
        }
        return result;
    }

}
