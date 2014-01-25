package de.uni_hildesheim.sse;

/**Class for Leaf.<br/>
 * This class contains:
 * <ul>
 * <li>Class Constructor</li>
 * <li>Methods to get leaf#s name, type and value</li>
 * </ul>
 * 
 * @author Phani
 */
public class Leaf implements Compound {

    private String name;
    private String leafVal;
    private Datatype type;
    //private AttributeValues val;

    /**
     * Constructor: TThe constructor creates a new Leaf.<br/>
     * @param name The name of the leaf.
     * @param type The leaf type.
     * @param leafVal Value that leaf contains.
     */
    public Leaf(String name, Datatype type, String leafVal) {
        this.name = name;
        this.type = type;
        this.leafVal = leafVal;
    }

    /**
     * Method to get leaf's name.<br/>
     * @return name
     * 
     */
    public String getName() {

        return name;
    }

    /**
     * Method to get leaf's type.<br/>
     * @return type
     * 
     */
    public Datatype getType() {
        return type;
    }

    /*Currently not implemented or used, 
     * public AttributeValues getVal() {

        return val;
    }*/

    /**
     * Method to get leaf's attribute value.<br/>
     * @return Attribute value
     * 
     */
    public String getAttributeVal() {
        return leafVal;
    }

}
