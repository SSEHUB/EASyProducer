package de.uni_hildesheim.sse.easy_producer.core.mgmt;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceUtils;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.FileInstantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.IInstantiatorController;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.TransformatorBindingRelation;

/**
 * Controller for all Instantiators(Transformators) of a PLP.
 * 
 * @author El-Sharkawy
 * @author freitag
 * @author Hundt
 * @author reller
 * @author Kapeluch
 * 
 *         TODO Dont know it the projectname is valid attribute to get the proper ProductLineProject. There for -
 *         changeFileTypeOfFileTypeTransformator - changeChosenTransformatorOfFileTypeTransformator -
 *         addFileTypeTransformator - deleteFileTypeTransformator are to be tested
 * 
 * 
 */
public class InstantiatorController extends Controller implements IInstantiatorController  {

    /**
     * HashSet avoids duplicated Instantiators.
     * 
     * @see FileInstantiator hashCode() and equals(Object)
     */
    private HashSet<FileInstantiator> transformators;
    private List<TransformatorBindingRelation> transformatorBindingtimesRelations;

    /**
     * Constructor for Transformator Container.
     */
    public InstantiatorController() {
        transformators = new HashSet<FileInstantiator>();
        transformatorBindingtimesRelations = new ArrayList<TransformatorBindingRelation>();
    }

    /**
     * Setter for the chosen file type transformers.
     * 
     * @param ftts The new list of chosen file type transformers.
     */
    public void setFileTypeTransformers(ArrayList<FileInstantiator> ftts) {
        transformators = new HashSet<FileInstantiator>(ftts);
    }

    /**
     * Getter for the transformators.
     * 
     * @return the List of File Type Transformators
     */
    public HashSet<FileInstantiator> getTransformators() {
        return transformators;
    }

    /**
     * Getter for the relevant instantiators to instantiate a product line infrastructure.
     * 
     * @return all inherited instantiators
     */
    public HashSet<FileInstantiator> getInheritedInstantiators() {
        HashSet<FileInstantiator> result = new HashSet<FileInstantiator>(getTransformators().size());
        for (FileInstantiator instantiator : getTransformators()) {
            if (instantiator.getInheritanceChain().size() > 1) {
                result.add(instantiator);
            }
        }
        return result;
    }

    /**
     * Method returns a map with each transformator. each transformator has a list with its possible binding times. Only
     * transformators with assigned binding times are in this map.
     * 
     * @return a Map with transformator names as keys and a list with its binding times a value
     */
    public List<TransformatorBindingRelation> getTransformatorBindingTimes() {
        return transformatorBindingtimesRelations;
    }

    /**
     * Checks the model for changes based on user configuration in the gui.
     * 
     * @param instantiator the model that needs to be checked
     * @param newFileList the file list provided from the InstantiatorTreeViewer
     */
    public void changeFI(FileInstantiator instantiator, List<File> newFileList) {
        List<File> oldList = instantiator.getFilesToInstantiatePersistency();
        boolean changed = false;
        if (newFileList.size() != oldList.size()) {
            changed();
            changed = true;
        } else {
            for (File file : newFileList) {
                if (!oldList.contains(file)) {
                    changed();
                    changed = true;
                    break;
                }
            }
        }
        if (changed) {
            instantiator.setFilesToInstantiateTemporary(newFileList);
        }
    }

    /**
     * Adds a new FileInstantiator to the transformatorContainer list and returns it.
     * 
     * @param projectID the origin id for the FileInstantiator
     * @param engine the associated engine
     * @return the new FileInstantiator
     */
    public FileInstantiator addFileTransformator(String projectID, String engine) {
        FileInstantiator f = new FileInstantiator(projectID, engine, SPLsManager.INSTANCE);
        getTransformators().add(f);
        changed();
        return f;
    }

    /**
     * Will be called on user wish from the instantiator view. It checks whether a single file is instantiated by
     * multiple engines.
     * 
     * @param plpName the name of the PLP is used to shorten the filepaths
     * @return a string array consisting of the conflicting files including instantiators
     */
    public String[] getListofMultipleInstantiatedFiles(String plpName) {
        List<String> result = null;

        // calculate maximum possible initial size
        int cache = 0;
        for (FileInstantiator tmp : getTransformators()) {
            cache += tmp.getFilesToInstantiatePersistency().size();
        }
        // prepare a list of all unique files with current valid filepaths
        HashSet<File> allFilesFiltered = new HashSet<File>(cache);
        result = new ArrayList<String>(cache);
        for (FileInstantiator tmp : getTransformators()) {
            allFilesFiltered.addAll(tmp.getFilesToInstantiate());
        }
        for (File file : allFilesFiltered) {
            String shared = "";
            int count = 0;
            for (FileInstantiator instantiator : getTransformators()) {
                // find a matching List (there should be at least one)
                if (instantiator.getFilesToInstantiate().contains(file)) {
                    shared += instantiator.toString() + " ";
                    count++;
                }
            }
            // Is the file shared in more than one list?
            if (count > 1) {
                String path = file.getPath();
                String[] split = path.split(plpName);
                path = split[1].substring(1);
                path += ": " + shared;
                result.add(path);
            }
        }
        return result.size() == 0 ? new String[] {PersistenceUtils.INSTANTIATOR_CONTROLLER_MULTIPLE} : result
            .toArray(new String[result.size()]);
    }

    /**
     * Deletes a file type transformator from the list.
     * 
     * @param ftt the transformator to delete
     */
    public void deleteFileTypeTransformator(FileInstantiator ftt) {
        getTransformators().remove(ftt);
        changed();
    }
}
