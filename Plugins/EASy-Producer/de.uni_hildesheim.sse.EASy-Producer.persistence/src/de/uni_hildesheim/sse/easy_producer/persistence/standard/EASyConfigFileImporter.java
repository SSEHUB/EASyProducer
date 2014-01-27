package de.uni_hildesheim.sse.easy_producer.persistence.standard;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.easy_producer.persistence.internal.Activator;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.ModelManagementException;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

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
    
    private File destinationPath;
    private boolean addToVarModel;
    
    /**
     * Sole constructor for this class.<br/>
     * This constructor deletes all sub folders of the specified destinationPath.
     * @param destinationPath Absolute path inside the file system,
     * where to store files and sub folders for imported EASy config files.
     */
    public EASyConfigFileImporter(File destinationPath) {
        this.destinationPath = destinationPath;
        resetDestinationPath();
    }
    
    /**
     * Deletes all sub folders of the destination Path for reseting this folder.
     * Should be called before importing, therefore, this method is part of the constructor of this class.
     */
    private void resetDestinationPath() {
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
     * @param sourceLocation The sourceLocation where all EASy config files and sub folders should be copied from.
     * @param namespace A namespace, where to copy the files of the sourceLocation into a sub folder
     * inside the destinationPath. Maybe <tt>null</tt> if no namespace should be used.
     */
    public void copyIVMLFiles(File sourceLocation, String namespace) {        
        File destinationLocation = destinationPath;
        if (null != namespace) {
            destinationLocation = new File(destinationPath, namespace);
        }
        try {
            copyDirectory(sourceLocation, destinationLocation);
        } catch (IOException e) {
            LOGGER.exception(e);
        }
        try {
            VarModel.INSTANCE.updateModelInformation(destinationLocation, ProgressObserver.NO_OBSERVER);
            BuildModel.INSTANCE.updateModelInformation(destinationLocation, ProgressObserver.NO_OBSERVER);
            TemplateModel.INSTANCE.updateModelInformation(destinationLocation, ProgressObserver.NO_OBSERVER);
        } catch (ModelManagementException e) {
            LOGGER.exception(e);
        }
    }
    
    /**
     * Copies all ivml files of from the specified sourceLocation to the specified targedLocation,
     * while keeping sub directories. 
     * @param sourceLocation The sourceLocation where all ivml files and sub folders should be copied from.
     * @param targetLocation The output location for copied ivml files and sub folders.
     * @throws IOException If an I/O error occurred
     */
    private void copyDirectory(File sourceLocation, File targetLocation) throws IOException {
        if (sourceLocation.isDirectory()) {
            //Copy folders
            if (!targetLocation.exists()) {
                targetLocation.mkdir();
            }
            
            String[] children = sourceLocation.list(new EASyConfigFileFilter());
            for (int i = 0; i < children.length; i++) {
                //Recursive call for copying nested files and (sub) folders.
                copyDirectory(new File(sourceLocation, children[i]), new File(targetLocation, children[i]));
            }
        } else {
            //Copy files
            if (!targetLocation.exists()) {
                targetLocation.createNewFile();
            }
            
            FileInputStream source = new FileInputStream(sourceLocation);
            FileOutputStream destination = new FileOutputStream(targetLocation);
     
            FileChannel sourceFileChannel = source.getChannel();
            FileChannel destinationFileChannel = destination.getChannel();
     
            long size = sourceFileChannel.size();
            sourceFileChannel.transferTo(0, size, destinationFileChannel);
            
            if (addToVarModel) {
                try {
                    VarModel.INSTANCE.locations().addLocation(targetLocation, ProgressObserver.NO_OBSERVER);
                    BuildModel.INSTANCE.locations().addLocation(targetLocation, ProgressObserver.NO_OBSERVER);
                    TemplateModel.INSTANCE.locations().addLocation(targetLocation, ProgressObserver.NO_OBSERVER);
                } catch (ModelManagementException e) {
                    LOGGER.exception(e);
                }
            }
        }
    }
}
