package net.ssehub.easy.instantiation.core.model.vilTypes;

import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.DecisionVariable;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Common operations for sequences.
 * 
 * @author Holger Eichelberger
 */
public class SequenceOperations {
    
    /**
     * Maps the elements of <code>seq1</code> to the elements of <code>seq2</code>
     * and returns the mapping pairs (based on the equals operation) in the given sequence. Please note that
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
        if (null != seq1 && null != seq2 && 1 == seq1.getGenericParameterCount() 
            && 1 == seq2.getGenericParameterCount()) {
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
            TypeDescriptor<?>[] params = TypeDescriptor.createArray(2);
            params[0] = seq1.getGenericParameterType(0);
            params[1] = seq2.getGenericParameterType(0);
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
                        if (equals(elt1, elt2)) {
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
    
    /**
     * Compares two elements for equality using values for decision variables.
     * 
     * @param <T> the element type
     * @param elt1 the first element to be compared
     * @param elt2 the second element to be compared
     * @return <code>true</code> if <code>elt1</code> and <code>elt2</code> are considered to be equal, 
     *     <code>false</code> else
     */
    private static <T> boolean equals(T elt1, T elt2) {
        boolean equals;
        if (elt1 instanceof DecisionVariable && elt2 instanceof DecisionVariable) {
            Value val1 = ((DecisionVariable) elt1).getDecisionVariable().getValue();
            Value val2 = ((DecisionVariable) elt2).getDecisionVariable().getValue();
            equals = val1.equals(val2);
        } else {
            equals = elt1.equals(elt2);
        }
        return equals;
    }

    /**
     * Maps the elements of <code>seq1</code> to the elements of <code>seq2</code>
     * and returns the mapping pairs (based on the equals operation) regardless of their sequence. Please note that
     * both sequences must have exactly one type parameter. 
     *
     * @param <T> the element type
     * @param seq1 the first sequence to map
     * @param seq2 the second sequence to map against
     * 
     * @return the mapping (key is taken from this sequence, value from <code>other</code>)
     */
    public static <T> Map<T, T> mapAny(Sequence<T> seq1, Sequence<T> seq2) {
        Map<T, T> result;
        if (null != seq1 && null != seq2 && 1 == seq1.getGenericParameterCount() 
            && 1 == seq2.getGenericParameterCount()) {
            TypeDescriptor<?>[] params = TypeDescriptor.createArray(2);
            params[0] = seq1.getGenericParameterType(0);
            params[1] = seq2.getGenericParameterType(0);
            result = new Map<T, T>(params, Math.max(seq1.size(), seq2.size()));
            // this is inefficient, but difficult due to the conditional comparison
            for (int s1 = 0; s1 < seq1.size(); s1++) {
                T elt1 = seq1.get(s1);
                if (elt1 != null) {
                    for (int s2 = 0; s2 < seq2.size(); s2++) {
                        T elt2 = seq2.get(s2);
                        if (elt2 != null && equals(elt1, elt2)) {
                            result.add(elt1, elt2);
                        }
                    }
                }
            }
        }  else {
            result = null;
        }
        return result;
    }

    /**
     * Adds all elements from <code>seq</code> to <code>list</code>. Valid indexes 
     * are assumed. No check happens
     *   
     * @param <T> the element type
     * @param list the list to add all elements to 
     * @param seq the sequence to take the elements from
     * @param lower the lower 0-based index where to start adding
     * @param upper the upper 0-based index where to end adding (including)
     */
    private static <T> void addAll(java.util.List<T> list, Sequence<T> seq, int lower, int upper) {
        for (int i = lower; i <= upper; i++) {
            list.add(seq.get(i));
        }
    }
    
    /**
     * Adds all elements from <code>seq</code> to <code>list</code>.
     *   
     * @param <T> the element type
     * @param list the list to add all elements to 
     * @param seq the sequence to take the elements from
     */
    private static <T> void addAll(java.util.List<T> list, Sequence<T> seq) {
        addAll(list, seq, 0, seq.size() - 1);
    }

    /**
     * Returns the concatenated sequence of <code>seq1</code> and <code>seq2</code>.
     * 
     * @param <T> the element type
     * @param seq1 the first sequence
     * @param seq2 the second sequence
     * @return the concatenated sequence
     */
    public static <T> java.util.List<T> union(Sequence<T> seq1, Sequence<T> seq2) {
        java.util.List<T> result = new java.util.ArrayList<T>(seq1.size() + seq2.size());
        addAll(result, seq1);
        addAll(result, seq2);
        return result;
    }

    /**
     * Returns the combined sequence of <code>object</code> appended before <code>seq</code>.
     * 
     * @param <T> the element type
     * @param seq the sequence
     * @param object the object to prepend
     * @return the combined sequence
     */
    public static <T> java.util.List<T> append(Sequence<T> seq, T object) {
        java.util.List<T> result = new java.util.ArrayList<T>(seq.size() + 1);
        addAll(result, seq);
        result.add(object);
        return result;
    }
    
    /**
     * Returns the combined sequence of <code>object</code> prepended before <code>seq</code>.
     * 
     * @param <T> the element type
     * @param seq the sequence
     * @param object the object to prepend
     * @return the combined sequence
     */
    public static <T> java.util.List<T> prepend(Sequence<T> seq, T object) {
        java.util.List<T> result = new java.util.ArrayList<T>(seq.size() + 1);
        result.add(object);
        addAll(result, seq);
        return result;
    }

    /**
     * Returns the sequence having <code>object</code> inserted at position <code>index</code> into <code>seq</code>.
     * 
     * @param <T> the element type
     * @param seq the sequence
     * @param index the index to insert at
     * @param object the object to insert
     * @return the combined sequence
     */
    public static <T> java.util.List<T> insertAt(Sequence<T> seq, int index, T object) {
        java.util.List<T> result = null;
        if (0 <= index && index <= seq.size()) {
            result = new java.util.ArrayList<T>(seq.size());
            addAll(result, seq);
            result.add(index, object);
        }
        return result;
    }

    /**
     * Returns the sub-sequence of <code>seq</code>.
     * 
     * @param <T> the element type
     * @param seq the sequence to derive the sub-sequence from
     * @param lower the lower index where the sub-sequence shall start
     * @param upper the end index where the sub-sequence shall end
     * @return the sub-sequence
     */
    public static <T> java.util.List<T> subSequence(Sequence<T> seq, int lower, int upper) {
        int l = Math.max(0, lower);
        int u = Math.min(upper, seq.size() - 1);
        java.util.List<T> result = new java.util.ArrayList<T>(u - l + 1);
        addAll(result, seq, l, u);
        return result;
    }

}