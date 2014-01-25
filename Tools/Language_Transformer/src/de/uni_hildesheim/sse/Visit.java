/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.uni_hildesheim.sse;

import java.util.ArrayList;
import java.util.List;

/**
 * Visitor class containing methods if a compound has been linked to a compound already or a leaf added.<br/>
 * @author Phani S
 * @since 07.05.2012
 */ 

public class Visit {

    private List<String> compoundNameHolder = new ArrayList<String>();
    private List<CompositeCompound> compoundList = new ArrayList<CompositeCompound>();
    
    /**
    * Method takes the compound name and checks if it has already been added to the compound list.<br/>
    * @param name Name of the compound
    * @return <b>True</b> if compound has been added.
    */
    
    public boolean compoundNameAdded(String name) { 
        return compoundNameHolder.contains(name);
    }
    
    
    /**
     * Method takes the compound name and adds a compound to the list.<br/>
     * @param name Name of the compound
     */
    public void addCompoundName(String name) {
        compoundNameHolder.add(name);
    }
    
    
    /**
     * Method takes the compound and adds it to the list.<br/>
     * @param cc Compound
     */
    public void addCompound(CompositeCompound cc) {
        compoundList.add(cc);
    }
    
    /**
     * Method checks if a compound already contains a compound with a given name.<br/>
     * @param compoundOne Compound
     * @param nameOfCompound name of the compound to be checked
     * @return <b>True</b> if compound contains a compound with the given name already. 
     */
    public boolean containsCompound(CompositeCompound compoundOne, String nameOfCompound) {
        boolean contains;
        int match = 0;
        for (int i = 0; i < compoundOne.getCompoundList().size(); i++) {
            
            String compoundName = compoundOne.getCompoundList().get(i).getName();
            
            
            if (compoundName.equals(nameOfCompound)) {
                match++;
            } else {
                // do nothing
                System.out.print("");
            }
        }
        
        return (match >= 1);
    }
    
    /**
     * Method checks if a compound already contains the given leaf.<br/>
     * @param compoundOne Compound
     * @param leafOne leaf to be checked
     * @return <b>True</b> if compound contains the leaf passed. 
     */
    public boolean containsLeaf(CompositeCompound compoundOne, Leaf leafOne) {
        
        String name = leafOne.getName();
        String attr = (String) leafOne.getAttributeVal();
        int match = 0;
        for (int i = 0; i < compoundOne.getCompoundList().size(); i++) {
            Leaf l = new Leaf("x", Datatype.String, "v");
            
            if (compoundOne.getCompoundList().get(i).getClass().equals(l.getClass())) {
                String lName = ( (Leaf) compoundOne.getCompoundList().get(i) ).getName();
                String lVal =  (String) ( (Leaf) compoundOne.getCompoundList().get(i) ).getAttributeVal();
                    
                if (lName.equals(name) && lVal.equals(attr)) {
                    match++;
                } else {
                    //Do nothing
                    System.out.print("");
                }
            }
        }
        
        return (match >= 1);
    }
    
}
