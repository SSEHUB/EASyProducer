package de.uni_hildesheim.sse.easy_producer.core.persistence.standard;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration.PathKind;
import de.uni_hildesheim.sse.easy_producer.core.persistence.internal.Activator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.varModel.management.VarModel;

/**
 * Copies all EASy config files (of a predecessor project) from one folder
 * to another while keeping sub folder hierarchy.<br/>
 * This is needed for imported variability models, build scripts, and templates.
 * @author El-Sharkawy
 *
 */
public class EASyConfigFileImporter {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(EASyConfigFileImporter.class,
        Activator.PLUGIN_ID);
    
    private PLPInfo plpTarget;
    
    /**
     * Sole constructor for this class.<br/>
     * This constructor deletes all sub folders of the specified destinationPath.
     * @param plpTarget The target plp where the copied files should be saved.
     * where to store files and sub folders for imported EASy config files.
     */
    public EASyConfigFileImporter(PLPInfo plpTarget) {
        this.plpTarget = plpTarget;
        
        resetDestinationPath(plpTarget.getConfigLocation());
        resetDestinationPath(plpTarget.getScriptLocation());
        resetDestinationPath(plpTarget.getTemplateLocation());
    }
    
    /**
     * Deletes all sub folders of the destination Path for reseting this folder.
     * Should be called before importing, therefore, this method is part of the constructor of this class.
     * @param destinationPath A EASY config folder for IVML/VIL/VTL files, where all subfolders shall be deleted.
     */
    private void resetDestinationPath(File destinationPath) {
        //Find all sub folders
        File[] children = destinationPath.listFiles(new FileFilter() {
            
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        
        //Delete all found sub folders
        for (int i = 0; i < children.length; i++) {
            children[i].delete();
        }
    }
    
    /**
     * Copies all EASy config files (variability model, build scripts, and templates) of from the specified
     * sourceLocation to the specified targedLocation, while keeping sub directories. 
     * @param plpSource The predecessor project from where all EASy config files and sub folders should be copied from.
     * @param namespace A namespace, where to copy the files of the sourceLocation into a sub folder
     * inside the destination. Maybe <tt>null</tt> if no namespace should be used.
     */
    public void copyConfigFiles(PLPInfo plpSource, String namespace) {        
        // The three targets, maybe same, maybe not
        File ivmlDestination = plpTarget.getConfigLocation();
        File vilDestination = plpTarget.getScriptLocation();
        File vtlDestination = plpTarget.getTemplateLocation();

        // Optional: Append Namepsace
        if (null != namespace) {
            ivmlDestination = new File(ivmlDestination, namespace);
            vilDestination = new File(vilDestination, namespace);
            vtlDestination = new File(vtlDestination, namespace);
        }
        
        // Copy
        copyConfigFiles(plpSource.getConfigLocation(), ivmlDestination, PathKind.IVML);
        copyConfigFiles(plpSource.getScriptLocation(), vilDestination, PathKind.VIL);
        copyConfigFiles(plpSource.getTemplateLocation(), vtlDestination, PathKind.VTL);
    }
    
    /**
     * Copies all EASy config files (variability model, build scripts, or templates) of from the specified
     * source to the destination. Only on of variability model, build scripts, or templates will be copied.
     * @param source The source folder from where relevant files should be copied from.
     * @param destination The destination to where relevant files should be copied to.
     * @param configElement Specification which kind of files should be considered.
     * @see EASyConfigFileFilter#EASyConfigFileFilter(PathKind...)
     */
    private void copyConfigFiles(File source, File destination, PathKind configElement) {
        /*
         * Copies all EASy config files (variability model, build scripts, and templates) from the specified
         * sourceLocation to the specified targedLocation, while keeping sub directories.  
         */
        try {
            FileUtils.copyDirectory(source, destination, new EASyConfigFileFilter(configElement));
        } catch (IOException e1) {
            LOGGER.exception(e1);
        }
        
        // Update the relevant model
        try {
            switch (configElement) {
            case IVML:
                VarModel.INSTANCE.updateModelInformation(destination, ProgressObserver.NO_OBSERVER);                
                break;
            case VIL:
                BuildModel.INSTANCE.updateModelInformation(destination, ProgressObserver.NO_OBSERVER);
                break;
            case VTL:
                TemplateModel.INSTANCE.updateModelInformation(destination, ProgressObserver.NO_OBSERVER);
                break;
            default:
                // No action needed
                break;
            }
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
    }
}
