package de.uni_hildesheim.sse.easy_producer.persistence.standard;

import java.io.File;
import java.io.FilenameFilter;

import de.uni_hildesheim.sse.persistency.PersistencyConstants;

/**
 * {@link FilenameFilter} for EASy config files (variability model, build scripts, and templates).
 * @author El-Sharkawy
 * @since 24.07.2012
 */
public class EASyConfigFileFilter implements FilenameFilter {
    
    /**
     * Denotes whether a given filename is an IVML file.
     * @param filename The name of the file, which should be checked.
     * @return <tt>true</tt> if the ending of the filename matches to a specified ivml file type,
     * otherwise <tt>false</tt>.
     */
    private boolean isEASyConfigFile(String filename) {
        String file = filename.toLowerCase();
        
        return file.endsWith(PersistencyConstants.PROJECT_FILE_ENDING)
            || file.endsWith(PersistencyConstants.COMMENT_FILE_ENDING) || file.endsWith(
                de.uni_hildesheim.sse.easy_producer.instantiator.model.PersistencyConstants.SCRIPT_FILE_ENDING)
            || file.endsWith(
                de.uni_hildesheim.sse.easy_producer.instantiator.model.PersistencyConstants.TEMPLATE_FILE_ENDING);     
    }
    
    @Override
    public boolean accept(File file, String filename) {
        return new File(file, filename).isDirectory() ^ isEASyConfigFile(filename);
    }
}