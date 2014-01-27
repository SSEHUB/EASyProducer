package de.uni_hildesheim.sse.reasoning.core.reasoner;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;

import de.uni_hildesheim.sse.utils.messages.Status;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * An upgrader for file input locations.
 * 
 * @author Holger Eichelberger
 */
public class FileUpgrader extends IUpgrader {

    /**
     * Creates an upgrader instance.
     * 
     * @param source the source containing the files to upgrade
     * @param dest the destination bundle location
     * @param files the file mapping describing the upgrade
     * @param marker an optional marker file within <code>dest</code> (may be <b>null</b>)
     * @param observer a progress observer, use {@link ProgressObserver#NO_OBSERVER} if no observer shall be informed
     */
    public FileUpgrader(URI source, String dest, Map<String, String> files, String marker, 
        ProgressObserver observer) {
        super(source, dest, files, marker, observer);
    }
    
    /**
     * {@inheritDoc}
     */
    public ReasoningResult upgrade() {
        ReasoningResult result = new ReasoningResult();
        if (!doUpgrade(result)) {
            result.addMessage(new Message("cannot handle '" + getSource() + "'", null, Status.ERROR));
        }
        return result;
    }
    
    /**
     * Performs the upgrade operations.
     * 
     * @param result the reasoning result to be modified as a side effect
     * @return <code>true</code> if performed, <code>false</code> if node
     */
    protected boolean doUpgrade(ReasoningResult result) {
        boolean done = false;
        if (null == getExtension()) {
            File sourceDir = new File(getSource());
            Iterator<Map.Entry<String, String>> iter = allFileMappings();
            while (iter.hasNext()) {
                Map.Entry<String, String> entry = iter.next();
                File sourceFile = new File(sourceDir, entry.getKey());
                File targetFile = obtainTargetFile(entry.getValue()); // cares for renaming existing files
                try {
                    copy(sourceFile, targetFile);
                } catch (IOException e) {
                    error(result, e);
                }
            }
            done = true;
        }
        return done;
    }

    /**
     * Returns the extension of the source URI.
     * 
     * @return the extension, <b>null</b> if we assume that the source URI denotes a directory
     */
    protected String getExtension() {
        // just a heuristic
        String path = getSource().getPath();
        int lastSep = Math.max(0, path.lastIndexOf('/'));
        int extensionDot = path.lastIndexOf('.');
        String extension = null;
        if (extensionDot > lastSep) {
            // URL denotes probably a file
            extension = path.substring(extensionDot + 1);
        } 
        return extension;
    }

}
