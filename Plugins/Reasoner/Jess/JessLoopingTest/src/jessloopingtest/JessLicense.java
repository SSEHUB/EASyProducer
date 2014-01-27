package jessloopingtest;

import jess.Rete;

/**
 * This class provides a single static method for checking whether the Jess license is
 * valid or if it is expired.
 *  
 * @author kroeher
 *
 */
public class JessLicense {

    /**
     * This method checks whether the Jess license is valid or not by
     * catching an "ThreadDeath" error. This is caused by creating a new
     * Rete-object while the license is expired.
     * 
     * @return true if the license is valid, false if the license is expired
     */
    public static boolean isLicenseValid() {
        boolean isValid = true;
        
        try {
            Rete engine = new Rete();
        } catch (ThreadDeath td) {
            isValid = false;
        }
        
        return isValid;
    }
}
