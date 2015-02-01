/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.uni_hildesheim.sse.utils.modelManagement;

import java.util.regex.Pattern;

/**
 * Represents the version of an import.
 * @author Marcel Lueder
 * @author Holger Eichelberger
 * @author Pastusch
 */
public class Version implements Comparable<Version> {
    
    public static final Version NULL_VALUE = new Version();
    private static final Pattern PATTERN = Pattern.compile("v\\d+(\\.\\d+)*");
    private static final String SEPARATOR = ".";
    private int[] segments;

    /**
     * Represents the null-Version (not given).
     */
    private Version() {
        segments = new int[0];
    }
    
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
     * Returns whether the given <code>string</code> denotes a version.
     * 
     * @param string the string to be tested
     * @return <code>true</code>if <code>string</code> is a version, <code>false</code> else
     */
    public static final boolean isVersion(String string) {
        boolean isVersion;
        if (null == string) {
            isVersion = false;
        } else {
            isVersion = PATTERN.matcher(string).matches();
        }
        return isVersion;
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
        if (NULL_VALUE == version1) {
            version1 = null;
        }
        if (NULL_VALUE == version2) {
            version2 = null;
        }
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
     * Compares two versions considering <b>null</b> for both parameters and results in:
     * -1 : this is smaller <=> given version and this is bigger.
     *  0 : given version and this are equal.
     * +1 : this is bigger <=> given version is smaller.
     * @param version1 the first version to compare.
     * @param version2 the second version to compare.
     * @return result in {-1, 0, 1}.
     */
    public static int compare(Version version1, Version version2) {
        int result;
        if (NULL_VALUE == version1) {
            version1 = null;
        }
        if (NULL_VALUE == version2) {
            version2 = null;
        }
        if (null == version1) {
            if (null == version2) {
                result = 0;
            } else {
                result = -1;
            }
        } else if (null == version2) {
            result = 1;
        } else {
            result = version1.compareTo(version2);
        }
        return result;
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
