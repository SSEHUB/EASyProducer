package net.ssehub.easy.reasonerCore.reasoner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.reasonerCore.Bundle;

/**
 * Defines the interface to an installation upgrade mechanism.
 * 
 * @author Holger Eichelberger
 */
public abstract class IUpgrader {

    private static final String PROTOCOL_REFERENCE = "reference:"; 
    private static final String PROTOCOL_FILE = "file:"; 

    private URI source;
    private String bundleLocation;
    private File dest; 
    private Map<String, String> files;
    private String marker; 
    private ProgressObserver observer;
    private long timeStamp = System.currentTimeMillis();
    
    /**
     * Creates an upgrader instance.
     * 
     * @param source the source containing the files to upgrade
     * @param dest the destination bundle location
     * @param files the file mapping describing the upgrade
     * @param marker an optional marker file within <code>dest</code> (may be <b>null</b>)
     * @param observer a progress observer, use {@link ProgressObserver#NO_OBSERVER} if no observer shall be informed
     */
    protected IUpgrader(URI source, String dest, Map<String, String> files, String marker, 
        ProgressObserver observer) {
        this.source = source;
        this.bundleLocation = dest;
        this.dest = bundleLocationToFile(dest);
        this.files = files;
        this.marker = marker;
    }
    
    /**
     * Returns a pseudo bundle location derived from file.
     * 
     * @param file the file to be converted
     * @return the file location
     * @throws MalformedURLException in case of translation problems
     */
    public static String toBundleLocation(File file) throws MalformedURLException {
        return PROTOCOL_REFERENCE + file.toURI().toURL().toString();
    }
    
    /**
     * Converts a bundle location to a file.
     * 
     * @param location the location
     * @return the file
     */
    public static File bundleLocationToFile(String location) {
        File result = null;
        if (null != location) {
            if (location.startsWith(PROTOCOL_REFERENCE)) {
                String part = location.substring(PROTOCOL_REFERENCE.length());
                if (part.startsWith(PROTOCOL_FILE)) {
                    part = part.substring(PROTOCOL_FILE.length());
                }
                result = new File(part);
                if (!result.isAbsolute()) {
                    // not nice, possibly not portable in shared installations
                    String eLocation = System.getProperty("eclipse.home.location"); 
                    if (eLocation.startsWith(PROTOCOL_FILE)) {
                        eLocation = eLocation.substring(PROTOCOL_FILE.length());
                    }
                    result = new File(eLocation, part);
                }
            }
        }
        if (null == result) {
            EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(IUpgrader.class, Bundle.ID);
            logger.error("unknown location type" + location);
        }
        return result;
    }
            
    /**
     * Executes the upgrade.
     * 
     * @return messages about upgrade problems
     * @see #doUpgrade(ReasoningResult)
     */
    public ReasoningResult upgrade() {
        ReasoningResult result = new ReasoningResult();
        if (null == dest) {
            result.addMessage(new Message("location '" + bundleLocation + "'cannot be determined", null, Status.ERROR));
        } else {
            if (!doUpgrade(result)) {
                result.addMessage(new Message("cannot handle '" + getSource() + "'", null, Status.ERROR));
            }
        }
        return result;
    }

    /**
     * Performs the upgrade operations.
     * 
     * @param result the reasoning result to be modified as a side effect
     * @return <code>true</code> if performed, <code>false</code> if node
     */
    protected abstract boolean doUpgrade(ReasoningResult result);

    /**
     * Returns the source URI.
     * 
     * @return the source URI
     */
    protected URI getSource() {
        return source;
    }

    /**
     * Returns a mapped file name.
     * 
     * @param input the input file name
     * @return the output file name, may be <b>null</b> if <code>input</code> is not mapped
     */
    protected String getMappedFile(String input) {
        return files.get(input);
    }

    /**
     * Returns the marker file.
     * 
     * @return the marker file or <b>null</b> if unknown
     */
    protected String getMarker() {
        return marker;
    }

    /**
     * Returns the progress observer instance.
     * 
     * @return the progress observer
     */
    protected ProgressObserver getObserver() {
        return observer;
    }
    
    /**
     * Returns an iterator over all known file mappings.
     * 
     * @return an iterator with original names in source as 
     *   keys and target names as values
     */
    protected Iterator<Map.Entry<String, String>> allFileMappings() {
        return files.entrySet().iterator();
    }
    
    /**
     * Obtains a file descriptor for <code>targetName</code> and cares
     * for uniquely renaming existing files.
     * 
     * @param targetName the target name (within {@link #dest})
     * @return the file descriptor representing <code>targetName</code>
     */
    protected File obtainTargetFile(String targetName) {
        File result = new File(dest, targetName);
        if (result.exists()) {
            String destName;
            int pos = targetName.lastIndexOf('.');
            if (pos < 0) {
                destName = targetName + "." + timeStamp;
            } else {
                destName = targetName.substring(0, pos) + "." + timeStamp + targetName.substring(pos);
            }
            File destFile = new File(dest, destName);
            result.renameTo(destFile);
        }
        return result;
    }

    /**
     * Adds an I/O error to <code>result</code>.
     * 
     * @param result the reasoning result to be modified as a side effect
     * @param ex the exception denoting the error
     */
    protected void error(ReasoningResult result, IOException ex) {
        result.addMessage(new Message("I/O problem: " + ex.getMessage(), null, Status.ERROR));
    }
    
    /**
     * Copies <code>source</code> to <code>target</code>.
     * 
     * @param source the source file
     * @param target the target file
     * @throws IOException in case of any I/O problems
     */
    protected void copy(File source, File target) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream(source);
            out = new FileOutputStream(target);
            in.getChannel().transferTo(0, source.length(), out.getChannel());
            out.close();
            out = null;
            in.close();
        } catch (IOException e) {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e1) {
                    // already in exception handling
                }
            }
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e1) {
                    // already in exception handling
                }
            }
            throw e;
        }
    }
    

}
