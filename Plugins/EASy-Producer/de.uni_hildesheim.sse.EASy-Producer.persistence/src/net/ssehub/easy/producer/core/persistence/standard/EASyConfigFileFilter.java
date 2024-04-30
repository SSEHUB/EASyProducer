package net.ssehub.easy.producer.core.persistence.standard;

import java.io.File;
import java.io.FileFilter;

import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;
import net.ssehub.easy.varModel.persistency.PersistencyConstants;

/**
 * {@link FileFilter} for EASy config files (variability model, build scripts, and templates).
 * @author El-Sharkawy
 * @since 24.07.2012
 */
public class EASyConfigFileFilter implements FileFilter {
    
    private boolean copyIVML = false;
    private boolean copyVIL = false;
    private boolean copyVTL = false;
    
    /**
     * Sole constructor for the {@link EASyConfigFileFilter}.
     * @param elementsToCopy Specification which IVML, VIL, VTL files should be considered.
     *     If <code>null</code> or an empty array, all config files will be considered.
     */
    public EASyConfigFileFilter(PathKind... elementsToCopy) {
        if (null == elementsToCopy || 0 == elementsToCopy.length) {
            copyIVML = true;
            copyVIL = true;
            copyVTL = true;
        } else {
            for (int i = 0; i < elementsToCopy.length; i++) {
                switch (elementsToCopy[i]) {
                case IVML:
                    copyIVML = true;
                    break;
                case VIL:
                    copyVIL = true;
                    break;
                case VTL:
                    copyVTL = true;
                    break;
                default:
                    // Not needed
                    break;
                }
            }
        }
    }
    
    /**
     * Checks whether the given file is an IVML file and should be considered.
     * @param file The name of the file (in lower case).
     * @return <code>true</code> if IVML files should be considered <b>and</b> the file is an IVML file,
     *     <code>false</code> otherwise.
     */
    private boolean considerIVMLFiles(String file) {
        return copyIVML && (file.endsWith(PersistencyConstants.PROJECT_FILE_ENDING)
                            || file.endsWith(PersistencyConstants.COMMENT_FILE_ENDING));
    }
    
    /**
     * Checks whether the given file is an VIL file and should be considered.
     * @param file The name of the file (in lower case).
     * @return <code>true</code> if VIL files should be considered <b>and</b> the file is an VIL file,
     *     <code>false</code> otherwise.
     */
    private boolean considerVILFiles(String file) {
        return copyVIL && file.endsWith(
            net.ssehub.easy.instantiation.core.model.PersistencyConstants.SCRIPT_FILE_ENDING);
    }
    
    /**
     * Checks whether the given file is an VTL file and should be considered.
     * @param file The name of the file (in lower case).
     * @return <code>true</code> if VTL files should be considered <b>and</b> the file is an VTL file,
     *     <code>false</code> otherwise.
     */
    private boolean considerVTLFiles(String file) {
        return copyVTL && file.endsWith(
                net.ssehub.easy.instantiation.core.model.PersistencyConstants.TEMPLATE_FILE_ENDING);
    }
    
    /**
     * Denotes whether a given filename is an IVML file.
     * @param filename The name of the file, which should be checked.
     * @return <code>true</code> if the ending of the filename matches to a specified ivml file type,
     * otherwise <code>false</code>.
     */
    private boolean isEASyConfigFile(String filename) {
        String file = filename.toLowerCase();
        
        return considerIVMLFiles(file) || considerVILFiles(file) || considerVTLFiles(file);
    }
    
    @Override
    public boolean accept(File file) {
        return file.isDirectory() ^ isEASyConfigFile(file.getName());
    }
}