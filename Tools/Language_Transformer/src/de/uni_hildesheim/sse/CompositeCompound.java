package de.uni_hildesheim.sse;

import java.util.List;
import java.util.ArrayList;


/**
 * Class responsible for creation of compounds.<br/>
 * 
 * @author Phani S
 * @since 02.05.2012
 */

public class CompositeCompound implements Compound {

    private List<Compound> childCompound = new ArrayList<Compound>();
    private String name;

    /**
     * Constructor for the class.<br/>
     * Each compound contains a name.<br/>
     * @param name Compound name
     */
    public CompositeCompound(String name) {
        this.name = name;
    }

    /**
     * Method to add a compound or a leaf (entity).<br/>
     * @param compoundPassed compound or a leaf
     * 
     */
    public void add(Compound compoundPassed) {
        childCompound.add(compoundPassed);

    }
    
    /**
     * Method to retrieve the list of compounds/leaves.<br/>
     * @return childCompound returns the list of compounds/leaves added.
     * 
     */
    
    public List<Compound> getCompoundList() {
        return childCompound;
    }

    /**
     * Method to remove a compound or a leaf (entity).<br/>
     * @param compoundPassed compound or a leaf
     * 
     */
    public void remove(Compound compoundPassed) {
        childCompound.remove(compoundPassed);
    }

    /**
     * Method to retrieve a compound/leaf at the index passed.<br/>
     * @param childIndex Index of a compound/leaf within the compound.<br/>
     * @return The compound at the index.<br/>
     */
    public Compound getChild(int childIndex) {
        return childCompound.get(childIndex);
    }

    /**
     * Method to retrieve name.<br/>
     * @return Name of the compound.<br/>
     */
    public String getName() {
        return name;
    }

    /**
     * Method to retrieve if .<br/>
     * @return <b>True</b> if it has a child, else <b>False</b>
     */
    public boolean hasChild() {
        boolean has;
        if (childCompound.size() > 0) {
            has = true;
        } else {
            has = false;
        }

        return has;
    }

}
