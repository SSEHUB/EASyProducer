package de.uni_hildesheim.sse.reasoning.core.reasoner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * An upgrader for zip and file input locations.
 * 
 * @author Holger Eichelberger
 */
public class ZipUpgrader extends FileUpgrader {

    /**
     * Creates an upgrader instance.
     * 
     * @param source the source containing the files to upgrade
     * @param dest the destination bundle location
     * @param files the file mapping describing the upgrade
     * @param marker an optional marker file within <code>dest</code> (may be <b>null</b>)
     * @param observer a progress observer, use {@link ProgressObserver#NO_OBSERVER} if no observer shall be informed
     */
    public ZipUpgrader(URI source, String dest, Map<String, String> files, String marker, 
        ProgressObserver observer) {
        super(source, dest, files, marker, observer);
    }

    /**
     * Performs the upgrade operations.
     * 
     * @param result the reasoning result to be modified as a side effect
     * @return <code>true</code> if performed, <code>false</code> if node
     */
    protected boolean doUpgrade(ReasoningResult result) {
        boolean done = false;
        if ("zip".equalsIgnoreCase(getExtension())) {
            try {
                unpackZip(new ZipInputStream(getSource().toURL().openStream()));
                done = true;
            } catch (IOException e) {
                error(result, e);
            }
        }
        if (!done) {
            done = super.doUpgrade(result);
        }
        return done;
    }
    
    /**
     * Unpacks a JESS installation zip.
     * 
     * @param zis the ZIP input stream
     * @throws IOException any occuring I/O exception
     */
    private void unpackZip(ZipInputStream zis) throws IOException {
        try {
            ZipEntry entry;
            do {
                entry = zis.getNextEntry();
                if (null != entry) {
                    String name = entry.getName();
                    String mapped = getMappedFile(name);
                    if (null != mapped) {
                        unpackEntryToInstallPath(zis, entry, mapped);
                    }
                }
            } while (null != entry);
            zis.close();
        } catch (IOException e) {
            // just to close the stream
            try {
                zis.close();
            } catch (IOException e1) {
            }
            throw e;
        }
    }
    
    /**
     * Unpacks a ZIP entry to the bundle installation path.
     * @param zis the ZIP input stream
     * @param entry the ZIP entry to unpack
     * @param targetName the relative name of the target file
     * @throws IOException any occuring I/O exception
     */
    private void unpackEntryToInstallPath(ZipInputStream zis, ZipEntry entry, String targetName) throws IOException {
        int read = 0;
        byte[] buffer = new byte[1024];
        File dest = obtainTargetFile(targetName); // cares for renaming existing files
        FileOutputStream fos = new FileOutputStream(dest);
        while ((read = zis.read(buffer)) != -1) {
            fos.write(buffer, 0, read);
        }
        fos.close();
    }

}
