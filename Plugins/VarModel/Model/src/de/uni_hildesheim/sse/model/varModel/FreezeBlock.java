package de.uni_hildesheim.sse.model.varModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles frozen elements.
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public class FreezeBlock extends EvaluationBlock {
    
    private IFreezable[] freezables;
    private String[] buts;
    private IFreezable[] frozen;
    
    /**
     * Constructor for containable model element.
     * 
     * @param freezables the elements which may be frozen (depends on <code>buts</code>)
     * @param buts the qualified names (possibly ending with a "*" as a wild card" which
     *   exclude matching freezables (may be <b>null</b>)
     * @param parent the object, in which this specific one is embedded
     */
    public FreezeBlock(IFreezable[] freezables, String[] buts, IModelElement parent) {
        super(null, parent);
        this.freezables = freezables;
        this.buts = buts;
        
        if (buts != null) {
            // construct the list of frozen elements from the freezables
            List<IFreezable> frozen = new ArrayList<IFreezable>();
            for (IFreezable freezable : freezables) {
                frozen.add(freezable);
            }
            for (int b = 0; b < buts.length; b++) {
                String match;
                boolean prefix;
                if (buts[b].endsWith("*")) {
                    match = buts[b].substring(0, buts[b].length() - 1);
                    prefix = true;
                } else {
                    match = buts[b];
                    prefix = false;
                }
                if (match.length() > 0) {
                    for (int f = frozen.size() - 1; f >= 0; f--) {
                        String name = frozen.get(f).getName();
                        boolean remove;
                        if (prefix) {
                            remove = name.startsWith(match);
                        } else {
                            remove = name.equals(match);
                        }
                        if (remove) {
                            frozen.remove(f);
                        }
                    }
                }
            }
            this.frozen = new IFreezable[frozen.size()];
            frozen.toArray(this.frozen);
        } else {
            // no buts, all freezables shall be frozen
            this.frozen = this.freezables;
        }
    }

    /** 
     * {@inheritDoc}
     */
    public void accept(IModelVisitor visitor) {
        visitor.visitFreezeBlock(this);
    }
    
    /**
     * Returns the number of freezables.
     * 
     * @return the number of freezables
     */
    public int getFreezableCount() {
        return freezables.length;
    }
    
    /**
     * Returns a specific freezable.
     * 
     * @param index the index of the freezable
     * @return the freezable
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getFreezableCount()}</code>
     */
    public IFreezable getFreezable(int index) {
        return freezables[index];
    }
    
    /**
     * Returns the number of "buts".
     * 
     * @return the number of "buts"
     */
    public int getButCount() {
        return null == buts ? 0 : buts.length;
    }
    
    /**
     * Returns a specific "but".
     * 
     * @param index the index of the "but"
     * @return the "but"
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getButCount()}</code>
     */
    public String getBut(int index) {
        if (null == buts) {
            throw new IndexOutOfBoundsException();
        }
        return buts[index];
    }
    
    /**
     * Returns the number of frozen elements (subset of freezables 
     * considering the "buts").
     * 
     * @return the number of frozen elements
     */
    public int getFrozenCount() {
        return frozen.length;
    }
    
    /**
     * Returns a specific frozen element (subset of freezables 
     * considering the "buts").
     * 
     * @param index the index of the frozen element
     * @return the frozen element
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getFrozenCount()}</code>
     */
    public IFreezable getFrozen(int index) {
        return frozen[index];
    }

}
