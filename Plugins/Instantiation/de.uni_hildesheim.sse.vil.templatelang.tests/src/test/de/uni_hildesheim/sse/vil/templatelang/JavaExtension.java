package test.de.uni_hildesheim.sse.vil.templatelang;

/**
 * For testing Java extensions.
 * 
 * @author Holger Eichelberger
 */
public class JavaExtension {
    
    /**
     * Returns the hashcode of <code>s</code>.
     * 
     * @param string the string to return the hashcode for
     * @return the hashcode of <code>s</code>
     */
    public static int hashcode(String string) {
        return string.hashCode();
    }

}
