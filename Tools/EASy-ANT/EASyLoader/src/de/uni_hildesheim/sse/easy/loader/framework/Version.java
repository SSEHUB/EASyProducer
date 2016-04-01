package de.uni_hildesheim.sse.easy.loader.framework;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a version number.
 * 
 * @author Holger Eichelberger
 */
public class Version {
    
    private static final String SEPARATOR = ".";
    private int[] segments;
    private String[] suffixes;

    /**
     * Creates a new version by parsing a string.
     * 
     * @param version the version string in form i(.i)* with i integer numbers 
     * @throws BundleException in case of format problems
     */
    public Version(String version) throws BundleException {
        if (null != version) { // may occur during parsing
            String[] tmp = version.split("\\" + SEPARATOR);
            List<Integer> segs = new ArrayList<Integer>();
            List<String> sufs = new ArrayList<String>();
            int i = 0;
            try {
                while (i < tmp.length) {
                    segs.add(Integer.parseInt(tmp[i]));
                    i++; // inc if successful
                }
            } catch (NumberFormatException e) {
                while (i < tmp.length) {
                    sufs.add(tmp[i++]);
                }
            }
            if (segs.isEmpty()) {
                throw new BundleException("illegal version number " + version);
            }
            segments = new int[segs.size()];
            for (i = 0; i < segs.size(); i++) {
                segments[i] = segs.get(i);
            }
            suffixes = new String[sufs.size()];
            sufs.toArray(suffixes);
        } else {
            throw new BundleException("illegal version number null");
        }
    }
    
    /**
     * Returns a textual representation of this instance.
     * 
     * @return a textual representation
     */
    public String toString() {
        StringBuilder version = new StringBuilder();
        for (int i = 0; i < segments.length; i++) {
            if (version.length() > 0) {
                version.append(SEPARATOR);
            }
            version.append(segments[i]);
        }
        for (int i = 0; i < suffixes.length; i++) {
            if (version.length() > 0) {
                version.append(SEPARATOR);
            }
            version.append(suffixes[i]);
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
     * 
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
     * Checks whether the version is within a certain range of versions.
     * @param min Minimal version that is allowed. Can be null to represent no minimum.
     * @param max Maximal version that is allowed. Can be null to represent no maximum.
     * @return boolean True if version is within the range.
     */
    public boolean isInRange(Version min, Version max) {
        boolean result = true;
        if (min != null && this.compareTo(min) == -1) {
            result = false;
        }
        if (max != null && this.compareTo(max) == 1) {
            result = false;
        }
        return result;
    }
    
}
