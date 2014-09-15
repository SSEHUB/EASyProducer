package de.uni_hildesheim.sse.easy.loader.framework;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Contains dependancy information for a bundle.
 * @author Patrik Pastuschek
 */
public class EasyDependency {

    private boolean isMandatory = true;
    private Version versionMin = null;
    private Version versionMax = null;
    private String specificationVersion = "";
    private String bundleSymbolicName = "";
    private Version bundleVersionMin = null;
    private Version bundleVersionMax = null;
    private List<String> reqBundles = new ArrayList<String>();
    
    
    /**
     * Standard Constructor. Creates an empty dependancy.
     */
    public EasyDependency() { }
    
    /**
     * Constructor. Creates a dependancy.
     * @param info String with dependancy infos that are to be parsed.
     */
    public EasyDependency(String info) {
        
        String[] information = info.split(";");
    
        for (int i = 0; i < information.length; i++) {
            
            String piece = information[i];
                
            if (piece.toLowerCase().contains("resolution")) {
                
                this.isMandatory = (!piece.toLowerCase().contains("optional"));
                
            } else if (piece.toLowerCase().contains("specification-version")) {
                
                this.specificationVersion = piece.split("=")[1];
                
            } else if (piece.toLowerCase().contains("bundle-symbolic-name")) {
                
                this.bundleSymbolicName = piece.split("=")[1];
                
            } else if (piece.toLowerCase().contains("require-bundle")) {
                
                String[] req = piece.split(",");
                
                for (int j = 0; j < req.length; j++) {
                    this.reqBundles.add(req[j]);
                }
                
            } else if (piece.toLowerCase().contains("bundle-version")) {
                
                String[] range = getRange(piece);
                try {
                    if (range != null && range.length > 0) {
                        this.bundleVersionMin = new Version(range[0]);
                        if (range.length > 1) {
                            this.bundleVersionMax = new Version(range[1]);
                        }
                    }
                } catch (BundleException e) {
                    System.out.println("Version Error in EasyDependancy");
                }
                
            } else if (piece.toLowerCase().contains("version")) {
                
                String[] range = getRange(piece);
                try {
                    if (range != null && range.length > 0) {
                        this.versionMin = new Version(range[0]);
                        if (range.length > 1) {
                            this.versionMax = new Version(range[1]);
                        }
                    }
                } catch (BundleException e) {
                    System.out.println("Version Error in EasyDependancy");
                }
                
            }
        }
        
    }
    
    /**
     * Getter returns true if mandatory.
     * @return true if mandatory
     */
    public boolean getMandatory() {
        return isMandatory;
    }
    
    /**
     * Getter returns true if mandatory.
     * @return true if mandatory
     */
    public Version getVersionMin() {
        return versionMin;
    }
    
    /**
     * Getter returns true if mandatory.
     * @return true if mandatory
     */
    public Version getVersionMax() {
        return versionMax;
    }
    
    /**
     * Getter returns true if mandatory.
     * @return true if mandatory
     */
    public String getSpecVersion() {
        return specificationVersion;
    }
    
    /**
     * Getter returns true if mandatory.
     * @return true if mandatory
     */
    public Version getBundleVersionMin() {
        return bundleVersionMin;
    }
    
    /**
     * Getter returns true if mandatory.
     * @return true if mandatory
     */
    public Version getBundleVersionMax() {
        return bundleVersionMax;
    }
    
    /**
     * Getter returns true if mandatory.
     * @return true if mandatory
     */
    public String getBundleSymbolicName() {
        return bundleSymbolicName;
    }
    
    /**
     * Getter for the required bundles.
     * @return A List of Strings.
     */
    public List<String> getRequiredBundles() {
        return reqBundles;
    }
    
    /**
     * Main test method. 
     *
     * @param args main standard.
     */
    public static void main(String[] args) {
        EasyDependency test = new EasyDependency(
                "ResolUtion:=mandaTORY;specification-version=7;version:=[1.35,1.78];"
                + "bundle-symbolic-name:=a.test.bundle;bundle-version:=[1.44,1.89]");
        System.out.println("Mandatory: " + test.getMandatory());
        System.out.println("VersionMin: " + test.getVersionMin());
        System.out.println("VersionMax: " + test.getVersionMax());
        System.out.println("SpecificationVersion: " + test.getSpecVersion());
        System.out.println("BundleVersionMin: " + test.getBundleVersionMin());
        System.out.println("BundleVersionMax: " + test.getBundleVersionMax());
        System.out.println("BundleSymbolicName: " + test.getBundleSymbolicName());
    }
    
    /**
     * Splits a range into two strings.
     * @param range The unsplit string.
     * @return Array of split strings.
     */
    public static String[] getRange(String range) {
        
        String[] result = null;
        
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(range);
        if (matcher.find()) {
            String sub = matcher.group(1);

            if (sub.toLowerCase().contains(",")) {
                result = sub.split(",");
            } else {
                result = new String[1];
                result[0] = (matcher.group(1));
            }

        }
        
        if (null == result || result.length == 0) {
            
            Pattern pattern2 = Pattern.compile("\\[(.*?)\\)");
            Matcher matcher2 = pattern2.matcher(range);
            if (matcher2.find()) {
                String sub = matcher2.group(1);

                if (sub.toLowerCase().contains(",")) {
                    result = sub.split(",");
                } else {
                    result = new String[1];
                    result[0] = (matcher2.group(1));
                }

            } 
            
        }
        
        return result;
        
    }
    
    /**
     * Sets a min version for the bundle.
     * @param min minimal Version
     */
    public void setBundleVersionMin(Version min) {
        this.bundleVersionMin = min;
    }
    
    /**
     * Sets a max version for the bundle.
     * @param max maximal Version
     */
    public void setBundleVersionMax(Version max) {
        this.bundleVersionMax = max;
    }
    
    /**
     * Merges two dependencies if possible.
     * @param other The second dependency to merge with.
     */
    public void mergeVersions(EasyDependency other) {
        if (null != other) {
            if (this.bundleVersionMin != null) {
                if (other.getBundleVersionMin() != null 
                        && this.bundleVersionMin.compareTo(other.getBundleVersionMin()) == -1) {
                    this.setBundleVersionMin(other.getBundleVersionMin());
                }
            } else {
                this.bundleVersionMin = other.getBundleVersionMin();
            }
            if (this.bundleVersionMax != null) {
                if (other.getBundleVersionMax() != null 
                        && this.bundleVersionMax.compareTo(other.getBundleVersionMax()) == -1) {
                    this.setBundleVersionMax(other.getBundleVersionMax());
                }
            } else {
                this.bundleVersionMax = other.getBundleVersionMax();
            }
        }
    }
    

}
