package de.uni_hildesheim.sse.reasoning.core.reasoner;

import java.net.URL;

/**
 * Represents descriptive information about a reasoner. This class is intended to be subclassed in order to provide
 * information about specific licensing mechanisms.
 * 
 * @author Holger Eichelberger
 */
public class ReasonerDescriptor {

    private URL downloadSource;
    private String name;
    private String version;
    private String license;
    private String licenseRestriction;

    /**
     * Creates a new reasoner descriptor.
     * 
     * @param name
     *            the name of the reasoner
     * @param version
     *            a version description of the integrated reasoner (may be <b>null</b>)
     * @param license
     *            the license (may be <b>null</b>)
     * @param licenseRestriction
     *            a restriction of the license to be displayed, e.g. "valid until March 2020" (may be <b>null</b>)
     * @param downloadSource
     *            the source for downloading a licensed version (may be <b>null</b> if the implementation is complete)
     */
    public ReasonerDescriptor(String name, String version, String license, String licenseRestriction,
        URL downloadSource) {
        
        this.name = name;
        this.version = version;
        this.license = license;
        this.downloadSource = downloadSource;
    }

    /**
     * Returns the source for downloading a licensed version.
     * 
     * @return the source (may be <b>null</b>), this may point to a file, an Eclipse update site or just a web site
     *         describing how to obtain the implementation
     */
    public URL getDownloadSource() {
        return downloadSource;
    }

    /**
     * Returns the name of the reasoner.
     * 
     * @return the name of the reasoner
     */
    public String getName() {
        return name;
    }

    /**
     * Returns a textual form of the currently integrated version.
     * 
     * @return the version (may be <b>null</b>)
     */
    public String getVersion() {
        return version;
    }

    /**
     * Returns a textual form of the license of the reasoner.
     * 
     * @return the license as text (may be empty or <b>null</b> if there is none)
     */
    public String getLicense() {
        return license;
    }

    /**
     * Returns a license restriction in textual form, e.g. "valid until March 2020".
     * 
     * @return the license restriction (or <b>null</b> if there is none)
     */
    public String getLicenseRestriction() {
        return licenseRestriction;
    }

    /**
     * Returns whether this reasoner is licensed and valid so that it may be used.
     * 
     * @return <code>true</code> if it is licensed and ready for use, <code>true</code> if it is not ready, e.g., due to
     *         license restriction and a version shall be obtained via {@link #getDownloadSource()}
     */
    public boolean isReadyForUse() {
        return true;
    }
}
