package de.uni_hildesheim.sse.reasoner.jess;

import java.net.MalformedURLException;
import java.net.URL;

import jess.JessVersion;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerDescriptor;

/**
 * A specific reasoner descriptor for Jess.
 * 
 * @author Holger Eichelberger
 */
public class JessReasonerDescriptor extends ReasonerDescriptor {

    static final String NAME = "JessRules";
    
    /**
     * Creates a new reasoner descriptor.
     */
    public JessReasonerDescriptor() {
        //This way it would be valid until the license expires, then it would create a problem.
        //Passing just regular strings in the future would be safe.
        super(NAME, JessVersion.VERSION_STRING, JessVersion.COPYRIGHT_STRING
                + "\nJess is not available for Open Source licensing under any GPL license.\n" 
                + "To license and download Jess, please visit the Jess website at: www.jessrules.com ", 
                "Jess may be provided by a timely limited license.", getJessURL());
    }
    
    /**
     * Returns the download URL for Jess.
     * 
     * @return the download URL
     */
    private static URL getJessURL() {
        String site = "http://www.jessrules.com/jess/download.shtml";
        URL url = null;
        try {
            url = new URL(site);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return url;
    }
    
    /**
     * Returns whether this reasoner is licensed and valid so that it may be used.
     * 
     * @return <code>true</code> if it is licensed and ready for use, <code>true</code> if it is not ready, e.g., due to
     *         license restriction and a version shall be obtained via {@link #getDownloadSource()}
     */
    public boolean isReadyForUse() {
        boolean result;
        try {
            // check for class marker of wrapper implementation
            Class.forName("jess.SSE");
            result = false;
        } catch (ClassNotFoundException e) {
            result = JessLicense.isLicenseValid(); 
        }
        return result;
    }
    
}
