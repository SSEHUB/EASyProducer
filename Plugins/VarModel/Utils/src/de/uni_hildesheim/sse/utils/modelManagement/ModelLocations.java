package de.uni_hildesheim.sse.utils.modelManagement;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import de.uni_hildesheim.sse.utils.progress.ObservableTask;
import de.uni_hildesheim.sse.utils.progress.ProgressObserver;

/**
 * Manages the model locations. This class is not intended to be instantiated directly rather than
 * being created from {@link ModelManagement}. Please not that each individual location is considered 
 * recursively, i.e., nested folders will be considered automatically and do not need to be added
 * separately. 
 * 
 * @param <M> the specific model type
 * 
 * @author Holger Eichelberger
 */
public class ModelLocations <M extends IModel> {

    private IModelManagementRepository<M> repository;
    private List<File> locations = new ArrayList<File>();
    private Set<File> excludedLocations = new HashSet<File>();

    /**
     * Prevents this class from being instantiated from outside this package.
     * 
     * @param repository the model management repository for callbacks
     */
    ModelLocations(IModelManagementRepository<M> repository) {
        this.repository = repository;
    }
    
    /**
     * Adds an excluded model location. The location disables all
     * contained locations and will be considered with the next update
     * of the file information (already known models will not be discarded).
     * 
     * @param location the location to be excluded
     */
    public synchronized void addExcludedLocation(File location) {
        if (!excludedLocations.contains(location)) {
            excludedLocations.add(location);
        }
    }
    
    /**
     * Removes an excluded model location.
     * 
     * @param location the location to be discarded
     */
    public synchronized void removeExcludedLocation(File location) {
        excludedLocations.remove(location);
    }
    
    /**
     * Adds a file location, i.e., a location from where models can be loaded. Please not that <code>file</code> 
     * is considered recursively, i.e., nested folders will be considered automatically and do not need to be added
     * separately.
     * 
     * @param file the file location (<b>null</b> is ignored)
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @throws ModelManagementException in case that the available information
     *   may be come inconsistent due to the new location
     */
    public synchronized void addLocation(File file, ProgressObserver observer) throws ModelManagementException {
        if (null != file && !locations.contains(file)) {
            locations.add(file);
            repository.updateModelInformation(file, observer);
        }
    }
    
    /**
     * Removes a file location, i.e. a location from where models can be loaded.
     * 
     * @param file the file location (<b>null</b> is ignored)
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     */
    public synchronized void removeLocation(File file, ProgressObserver observer) {
        if (null != file) {
            locations.remove(file);
            repository.clearLocation(file, observer);
        }
    }
    
    /**
     * Updates a file location, i.e., a location from where models can be loaded. The location must be registered
     * beforehand using {@link #addLocation(File, ProgressObserver)}.
     * 
     * @param file the file location (<b>null</b> is ignored)
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @throws ModelManagementException in case that the available information
     *   may be come inconsistent due to the new location
     */
    public synchronized void updateLocation(File file, ProgressObserver observer) throws ModelManagementException {
        if (null != file && locations.contains(file)) {
            repository.updateModelInformation(file, observer);
        }
    }
    
    /**
     * Returns whether the specified location is already known.
     * 
     * @param file the location to search for
     * @return <code>true</code> if it is known, <code>false</code> else
     */
    public synchronized boolean isLocationKnown(File file) {
        return locations.contains(file);
    }
    
    /**
     * Returns the number of files in the given location.
     * 
     * @param location the location to scan
     * @return the number of files
     */
    private int count(File location) {
        int count = 0;
        if (null != location && !excludedLocations.contains(location)) {
            if (location.isDirectory()) {
                File[] files = location.listFiles();
                /*
                 * If an IOException occurs, e.g. in case java has no rights to open the directory,
                 * location.listFiles() can return null.
                 */
                if (null != files) {
                    for (int f = 0; f < files.length; f++) {
                        count += count(files[f]);
                    }
                }
            } else {
                count = 1;
            }
        }
        return count;
    }
    
    /**
     * Returns the number of files in all locations.
     * 
     * @return the number of files in all locations
     */
    int countFilesInLocations() {
        int count = 0;
        for (int f = 0; f < locations.size(); f++) {
            count += count(locations.get(f));
        }
        return count;
    }
    
    /**
     * Returns the number of locations configured.
     * 
     * @return the number of locations
     */
    public synchronized int getLocationCount() {
        return locations.size();
    }
    
    /**
     * Returns the specified location.
     * 
     * @param index the index pointing to the desired location
     * @return the specified location
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getLocationCount()}</code>
     */
    public synchronized File getLocation(int index) {
        return locations.get(index);
    }
    
    /**
     * Scans the given location for model information objects.
     * 
     * @param location the location to scan
     * @param holder the combined information and result collection instance
     * @param loader the specific loader to consider (may be <b>null</b>)
     * @param task the task to be informed
     * @param done records visited directories in order to avoid unintended looping
     */
    synchronized void scan(File location, ModelInfoHolder<M> holder, IModelLoader<M> loader, ObservableTask task, 
        Set<File> done) {
        if (null != location && !excludedLocations.contains(location)) {
            if (location.isDirectory()) {
                if (!done.contains(location)) {
                    done.add(location);
                    File[] files = location.listFiles();
                    if (null != files) {
                        for (int f = 0; f < files.length; f++) {
                            scan(files[f], holder, loader, task, done);
                        }
                    }
                }
            } else {
                if (null != loader) {
                    loader.scan(location, holder);
                } else {
                    repository.loaders().scanAll(location, holder);
                }
                task.notifyProgress();
            }
        }
    }
    
}
