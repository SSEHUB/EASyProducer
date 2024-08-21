/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.basics.modelManagement;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.ssehub.easy.basics.io.FileUtils;
import net.ssehub.easy.basics.progress.ObservableTask;
import net.ssehub.easy.basics.progress.ProgressObserver;

/**
 * Manages the model locations. Locations are stored in terms of a list, which also defines 
 * the model resolution sequence. This class is not intended to be instantiated directly rather than
 * being created from {@link ModelManagement}. Please not that each individual location is considered 
 * recursively, i.e., nested folders will be considered automatically and do not need to be added
 * separately. 
 * 
 * @param <M> the specific model type
 * 
 * @author Holger Eichelberger
 */
public class ModelLocations <M extends IModel> {

    /**
     * Represents a location with dependent locations (to be considered while loading a model).
     * 
     * @author Holger Eichelberger
     */
    public static class Location {
        
        private File location;
        private List<Location> dependent;
        private Location depending;
        
        /**
         * Creates a new location. This constructor is not visible as {@link ModelLocations} acts as a factory
         * for instances of this class.
         * 
         * @param location the file location to be represented by this class
         */
        private Location(File location) {
            this.location = location;
        }
        
        /**
         * Returns the file location represented by this instance.
         * 
         * @return the file location
         */
        public File getLocation() {
            return location;
        }
        
        /**
         * Returns the number of dependent locations.
         * 
         * @return the number of dependent locations
         */
        public int getDependentLocationCount() {
            return null == dependent ? 0 : dependent.size();
        }
        
        /**
         * The specified dependent locations.
         * 
         * @param index the index of the location to be returned
         * @return the dependent location
         * @throws IndexOutOfBoundsException in case that 
         *   <code>index &lt; 0 || index &gt;={@link #getDependentLocationCount()}</code>
         */
        public Location getDependentLocation(int index) {
            return dependent.get(index);
        }
        
        /**
         * Adds a dependent location, i.e., a related location also containing model files, usually for testing.
         * 
         * @param location the location to be added
         */
        public void addDependentLocation(Location location) {
            if (null != location && location != this) { // prevent accidental self-loop
                if (null == dependent) {
                    dependent = new ArrayList<Location>();
                }
                if (!dependent.contains(location)) {
                    dependent.add(location);
                }
                location.depending = this;
            }
        }
        
        /**
         * Returns the location this location is depending on.
         * 
         * @return the depending location, may be <b>null</b> for none, else set if this location was added as a 
         *     dependent location to the depending location
         */
        public Location getDepending() {
            return depending;
        }

        /**
         * Counts the files in this and dependent locations.
         * 
         * @param excludedLocations locations not to be considered
         * @param done already processed locations (required to excluded circles)
         * @return the number of files in this and related locations (excluding given and already processed locations)
         */
        private int countFilesInLocations(Set<File> excludedLocations, Set<Location> done) {
            int count = 0;
            if (!done.contains(this)) {
                done.add(this);
                count = count(location, excludedLocations);
                if (null != dependent) {
                    for (int d = 0; d < dependent.size(); d++) {
                        count += dependent.get(d).countFilesInLocations(excludedLocations, done);
                    }
                }
            }
            return count;
        }

        /**
         * Returns whether this location contains the given <code>file</code> (based
         * on name inclusion).
         * 
         * @param file the file to check for
         * @return <code>true</code> if <code>file</code> is contained in this location,
         *   <code>false</code> else
         */
        private boolean contains(File file) {
            boolean result;
            try {
                String sFile = file.toString();
                result = (location.length() > 0 && sFile.startsWith(location.toString())) 
                    || sFile.startsWith(location.getCanonicalPath().toString());
            } catch (IOException e) {
                result = false;
            }
            return result;
        }
        
        /**
         * Removes <code>location</code> from the dependent locations.
         * 
         * @param location the location to be removed
         * @param processed the already processed locations (in order to avoid loops)
         */
        private void removeFromDependentLocations(Location location, Set<Location> processed) {
            if (!processed.contains(location)) {
                processed.add(location);
                if (null != dependent) {
                    dependent.remove(location);
                    for (int d = 0; d < dependent.size(); d++) {
                        dependent.get(d).removeFromDependentLocations(location, processed);
                    }
                }
            }
        }

        /**
         * Returns whether <code>location</code> is a dependent location.
         * 
         * @param location the location to be searched for
         * @param processed the already processed locations (in order to avoid loops)
         * @return <code>true</code> if <code>location</code> is a dependent location, <code>false</code> else
         */
        private boolean isDependentLocation(Location location, Set<Location> processed) {
            boolean found = false;
            if (!processed.contains(location)) {
                processed.add(location);
                if (null != dependent) {
                    for (int d = 0; !found && d < dependent.size(); d++) {
                        Location dep = dependent.get(d);
                        found = (location == dep) || dep.isDependentLocation(location, processed);
                    }
                }
            }
            return found;
        }

        @Override
        public String toString() {
            return "Location: " + location + " " + dependent;
        }
 
    }
    
    private Map<String, Location> knownLocations = new HashMap<String, Location>();
    private IModelManagementRepository<M> repository;
    private List<Location> locations = new ArrayList<Location>();
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
     * Removes all known model locations.
     */
    void clear() {
        knownLocations.clear();
        locations.clear();
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
     * Returns the location for <code>uri</code>.
     * 
     * @param uri the URI to search for
     * @return the related location
     */
    public Location getLocationFor(URI uri) {
        Location result = null;
        try {
            if (FileUtils.isFileURI(uri)) {
                File f = new File(uri).getCanonicalFile();
                while (null == result) {
                    for (int l = 0; l < locations.size(); l++) {
                        Location tmp = locations.get(l);
                        if (tmp.contains(f)) {
                            if (null == result || tmp.contains(result.getLocation())) {
                                // current assumption: return the most general location!
                                result = tmp;
                            }
                        }
                    }
                    if (null != result || null == f.getParentFile()) {
                        break;
                    }
                    f = f.getParentFile();
                }
            }
        } catch (IOException e) {
        }
        return result;
    }

    /**
     * Returns the location for <code>file</code>.
     * 
     * @param file the file to return the location for
     * @return the location (or <b>null</b> if the related location is currently not known)
     * @throws ModelManagementException in case that <code>file</code> cannot be accessed / resolved
     * 
     * @see #getLocationFor(File, boolean)
     */
    private Location getLocationFor(File file) throws ModelManagementException {
        return getLocationFor(file, false);
    }
    
    /**
     * Returns the location for <code>file</code>.
     * 
     * @param file the file to return the location for
     * @param create <code>true</code> if a location shall be created for <code>file</code> if no location is known, 
     *     <code>false</code> if no new location shall be created
     * @return the location related to <code>file</code>, may be <b>null</b> depending on <code>create</code>
     * @throws ModelManagementException in case that <code>file</code> cannot be accessed / resolved
     */
    private synchronized Location getLocationFor(File file, boolean create) throws ModelManagementException {
        try {
            File cFile = file.getCanonicalFile();
            String key = cFile.toString();
            Location location = knownLocations.get(key);
            if (null == location && create) {
                location = new Location(file);
                knownLocations.put(key, location);
            }
            return location;
        } catch (IOException e) {
            throw new ModelManagementException(e.getMessage(), ModelManagementException.INTERNAL);
        }
    }

    /**
     * Adds a file location to the end of the list of locations, i.e., a location from where models can be loaded. 
     * Please note that <code>file</code> is considered recursively, i.e., nested folders will be considered 
     * automatically and do not need to be added separately.
     * 
     * @param file the file location (<b>null</b> is ignored)
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @return the actual location object corresponding to <code>file</code>
     * @throws ModelManagementException in case that the available information
     *   may be come inconsistent due to the new location or that <code>file</code> cannot be accessed / resolved
     */
    public synchronized Location addLocation(File file, ProgressObserver observer) 
        throws ModelManagementException {
        return addLocation(file, false, observer);
    }

    /**
     * Adds a file location, i.e., a location from where models can be loaded. Please not that <code>file</code> 
     * is considered recursively, i.e., nested folders will be considered automatically and do not need to be added
     * separately.
     * 
     * @param file the file location (<b>null</b> is ignored)
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @return the actual location object corresponding to <code>file</code>
     * @throws ModelManagementException in case that the available information
     *   may be come inconsistent due to the new location or that <code>file</code> cannot be accessed / resolved
     */
    public synchronized Location addLocationToFront(File file, ProgressObserver observer) 
        throws ModelManagementException {
        return addLocation(file, true, observer);
    }
    
    /**
     * Adds a file location, i.e., a location from where models can be loaded. Please not that <code>file</code> 
     * is considered recursively, i.e., nested folders will be considered automatically and do not need to be added
     * separately.
     * 
     * @param file the file location (<b>null</b> is ignored)
     * @param front add to the front or the end of the list of locations
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @return the actual location object corresponding to <code>file</code>
     * @throws ModelManagementException in case that the available information
     *   may be come inconsistent due to the new location or that <code>file</code> cannot be accessed / resolved
     */
    private Location addLocation(File file, boolean front, ProgressObserver observer) throws ModelManagementException {
        Location location = null;
        if (null != file) {
            location = getLocationFor(file, true);
            if (!locations.contains(location)) {
                if (front) {
                    locations.add(0, location);
                } else {
                    locations.add(location);
                }
            }
            repository.updateModelInformation(file, observer);
        }
        return location;
    }

    /**
     * Removes a location, i.e. a location from where models can be loaded.
     * 
     * @param location the location (<b>null</b> is ignored)
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @throws ModelManagementException in case that <code>file</code> cannot be accessed
     */
    public synchronized void removeLocation(Location location, ProgressObserver observer) 
        throws ModelManagementException {
        if (null != location) {
            repository.clearLocation(location.getLocation(), observer); 
            // supposed to call removeLocationFor as clearLocation is public!
        }
    }
    
    /**
     * Removes a file location, i.e. a location from where models can be loaded.
     * 
     * @param file the file location (<b>null</b> is ignored)
     * @param observer an optional progress observer (use {@link ProgressObserver#NO_OBSERVER} but 
     *   not <b>null</b> in case that no observation is intended)
     * @throws ModelManagementException in case that <code>file</code> cannot be accessed
     */
    public synchronized void removeLocation(File file, ProgressObserver observer) throws ModelManagementException {
        if (null != file) {
            Location location = getLocationFor(file, false);
            removeLocation(location, observer);
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
     *   may be come inconsistent due to the new location or <code>file</code> cannot be accessed
     */
    public synchronized void updateLocation(File file, ProgressObserver observer) throws ModelManagementException {
        if (null != file) {
            Location location = getLocationFor(file, false);
            if (null != location && locations.contains(location)) {
                repository.updateModelInformation(file, observer);
            }
        }
    }
    
    /**
     * Returns whether the specified location is already known.
     * 
     * @param file the location to search for
     * @return <code>true</code> if it is known, <code>false</code> else
     */
    public synchronized boolean isLocationKnown(File file) {
        boolean found = false;
        for (int l = 0; l < locations.size(); l++) {
            found = locations.get(l).getLocation().equals(file);
        }
        return found;
    }
    
    /**
     * Returns the number of files in the given location.
     * 
     * @param location the location to scan
     * @param excludedLocations explicitly excluded locations (may be <b>null</b> if no locations shall be excluded)
     * @return the number of files
     */
    private static int count(File location, Set<File> excludedLocations) {
        int count = 0;
        if (null != location && (null == excludedLocations || !excludedLocations.contains(location))) {
            if (location.isDirectory()) {
                File[] files = location.listFiles();
                /*
                 * If an IOException occurs, e.g. in case java has no rights to open the directory,
                 * location.listFiles() can return null.
                 */
                if (null != files) {
                    for (int f = 0; f < files.length; f++) {
                        count += count(files[f], excludedLocations);
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
        Set<Location> done = new HashSet<Location>();
        for (int f = 0; f < locations.size(); f++) {
            count += locations.get(f).countFilesInLocations(excludedLocations, done);
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
    public synchronized Location getLocation(int index) {
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

    /**
     * Removes the location for <code>file</code> from the set of model locations of this instance as well as from all 
     * dependent locations.
     * 
     * @param file the file pointing to the location
     * @throws ModelManagementException in case that <code>file</code> cannot be resolved
     */
    synchronized void removeLocationFor(File file) throws ModelManagementException {
        Location location = getLocationFor(file);
        removeLocation(location);
    }
    
    /**
     * Removes the given location from the set of model locations of this instance as well as from all 
     * dependent locations.
     * 
     * @param location the location to be removed
     */
    synchronized void removeLocation(Location location) {
        if (null != location) {
            Set<Location> done = new HashSet<Location>();

            // remove from locations
            locations.remove(location);

            // remove from remaining locations
            for (int l = 0; l < locations.size(); l++) {
                locations.get(l).removeFromDependentLocations(location, done);
                done.clear();
            }
            
            // check whether location is left over... and remove from knownLocations if no references exist
            String toRemove = null;
            boolean depsExist = false;
            for (Map.Entry<String, Location> entry : knownLocations.entrySet()) {
                Location loc = entry.getValue();
                if (loc == location) {
                    toRemove = entry.getKey();
                } else {
                    depsExist = loc.isDependentLocation(location, done);
                    done.clear();
                }
            }
            if (!depsExist && null != toRemove) {
                knownLocations.remove(toRemove);
            }
        }
    }
    
    /**
     * Updates all model information for all locations.
     * 
     * @throws ModelManagementException in case that updating fails for some reason
     */
    public void updateModelInformation() throws ModelManagementException {
        ModelManagementException ex = null;
        for (int l = 0; l < locations.size(); l++) {
            try {
                repository.updateModelInformation(locations.get(l).getLocation(), ProgressObserver.NO_OBSERVER);
            } catch (ModelManagementException e) {
                if (null == ex) {
                    ex = e;
                }
            }
        }
        if (null != ex) {
            throw ex;
        }
    }
    
}