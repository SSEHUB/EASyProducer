package de.uni_hildesheim.sse.utils.modelManagement;

/**
 * Represents the version of an import.
 * @author Marcel Lueder
 * @author Holger Eichelberger
 * @author Pastusch
 */
public class Version implements Comparable<Version> {
    private static final String SEPARATOR = ".";
    private int[] segments;

    /**
     * Creates a new version by parsing a string.
     * @param version the version string in form i(.i)* with i integer numbers 
     * @throws VersionFormatException in case of format problems
     */
    public Version(String version) throws VersionFormatException {
        if (null != version) { // may occur during parsing
            String[] tmp = version.split("\\" + SEPARATOR);
            segments = new int[tmp.length];
            for (int i = 0; i < tmp.length; i++) {
                try {
                    segments[i] = Integer.parseInt(tmp[i]);
                } catch (NumberFormatException e) {
                    throw new VersionFormatException(version + "is not valid", 
                        VersionFormatException.INVALID_VERSION);
                }
            }
        } else {
            segments = new int[1];
            segments[0] = 0;
        }
    }
    
    /**
     * Constructor of the version class. 
     * @param version Version number
     */
    public Version(int... version) {
        segments = version;
        if (null == segments || 0 == segments.length) {
            segments = new int[1];
            segments[0] = 0;
        }
    }
    
    /**
     * Returns the version in a textual form.
     * 
     * @return the version in textual form
     */
    public String getVersion() {
        StringBuilder version = new StringBuilder();
        for (int i = 0; i < segments.length; i++) {
            if (version.length() > 0) {
                version.append(SEPARATOR);
            }
            version.append(segments[i]);
        }
        return version.toString();
    }
    
    /**
     * Returns the number of the segments.
     * 
     * @return the number of segments
     */
    public int getSegmentCount() {
        return segments.length;
    }
    
    /**
     * Returns the version segment specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the segment to be returned
     * @return the specified segment
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getSegmentCount}</code>
     */
    public int getSegment(int index) {
        return segments[index];
    }

    /**
     * Compares two versions and results in:
     * -1 : this is smaller <=> given version and this is bigger.
     *  0 : given version and this are equal.
     * +1 : this is bigger <=> given version is smaller.
     * @param version version to compare.
     * @return result in {-1, 0, 1}.
     */
    public int compareTo(Version version) {
        final int unset = 3;
        int result = unset;
        int segmentCount = Math.min(getSegmentCount(), version.getSegmentCount());
        
        if (result == unset) {
            for (int i = 0; i < segmentCount; i++) {
                if (getSegment(i) > version.getSegment(i)) {
                    result = 1;
                    break;
                } else if (getSegment(i) < version.getSegment(i)) {
                    result = -1;
                    break;
                }
            }
        }
        if (result == unset && version.getSegmentCount() < getSegmentCount()) {
            result = 1;
        } else if (result == unset && version.getSegmentCount() > getSegmentCount()) {
            result = -1;
        } else if (result == unset) {
            result = 0;
        }

        return result;
    }
    
    /**
     * Returns a textual representation of this instance.
     * 
     * @return a textual representation
     */
    public String toString() {
        return getVersion();
    }
    
    /**
     * Returns the textual version of <code>version</code> (null-safe).
     * 
     * @param version the version to be converted into text
     * @return the textual representation
     */
    public static String toString(Version version) {
        String ver;
        if (null == version) {
            ver = "";
        } else {
            ver = version.getVersion();
        }
        return ver;
    }
    
    /**
     * Returns whether two versions are equal. 
     * 
     * @param version1 the first version instance (may be <b>null</b>)
     * @param version2 the second version instance (may be <b>null</b>)
     * @return <code>true</code> if <code>version1</code> equals 
     *   <code>version2</code>, <code>false</code> else
     */
    public static boolean equals(Version version1, Version version2) {
        boolean equals = false;
        if (null == version1) {
            equals = (null == version2);
        } else {
            if (null != version2) {
                equals = (0 == version1.compareTo(version2));
            }
        }
        return equals;
    }
    
    /**
     * Returns a version that is one higher in the first segment than the actual version.
     * @return A version that is increased by one in the first segment.
     * @throws VersionFormatException in case of format problems.
     */
    public Version getIncrementedVersion() throws VersionFormatException {
        
        Version newVersion = null;
        String versionName = "";
        
        if (this.getSegmentCount() > 0) {
            versionName = versionName + (this.getSegment(0) + 1);
        
            for (int i = 1; i < this.getSegmentCount(); i++) {
            
                versionName = versionName + "." + this.getSegment(i);
            
            }
        }
        
        newVersion = new Version(versionName);
       
        return newVersion;
    }
    
}
