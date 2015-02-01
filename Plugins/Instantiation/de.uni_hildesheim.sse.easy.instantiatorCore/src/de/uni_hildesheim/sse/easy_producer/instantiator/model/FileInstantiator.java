package de.uni_hildesheim.sse.easy_producer.instantiator.model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.InstantiatorConstants;

/**
 * Represents an instantiator model.
 * 
 * @author gawenda
 * 
 */
public class FileInstantiator implements Cloneable {

    /**
     * The associated engine for this model.
     */
    private String engine;

    /**
     * The list of files that will be instantiated by the engine.
     */
    private List<File> filesToInstantiate = new ArrayList<File>();

    /**
     * Temporary list of files to instantiate stored with every change in the ui.
     */
    private List<File> tempFiles = new ArrayList<File>();

    /**
     * UUID of the project where this instantiator was bound.
     */
    private String projectID;

    /**
     * Contains the inheritance chain of this instantiator.
     */
    private List<String> inheritanceChain;

    /**
     * Path of the predecessor project where the files are expected to be found, if there haven't been a copy yet.
     */
    private String predecessorPath;

    /**
     * Project path of the current context of the instantiator. This path will be used to adapt the orginal filepaths
     * dynamically.
     */
    private String currentPath;

    /**
     * Internal attribute used to determine the correct relative path. See getRelativeInstantiationPath
     * {@link #getRelativeInstantiationPath(boolean)}
     */
    private boolean predecessorRequired;
    
    private IInstantiatorProjectManager projectManager;
    
    private String productID;

    /**
     * Constructor for the FileTransformator. It get's called, when the user decides to add a new instantiator. This
     * constructor is not intended to be used in the persistency layer.
     * 
     * @param projectID project where this instantiator has been created
     * @param engine the engine
     * @param projectManager A projectmanager capable of retrieving information about other projects.
     */
    public FileInstantiator(String projectID, String engine, IInstantiatorProjectManager projectManager) {
        this.projectID = projectID;
        this.engine = engine;
        this.inheritanceChain = new ArrayList<String>();
        this.projectManager = projectManager;
        // name of the project will be the first element in the inheritance
        // chain
        this.inheritanceChain.add(projectManager.getPLPName(projectID));
        this.predecessorPath = new File(projectManager.getProjectPath(projectID)).getAbsolutePath();
        this.currentPath = predecessorPath;
        productID = projectID;
    }
    
    // checkstyle: stop parameter number check

    /**
     * Constructor for the FileTransformator. Is only to be used at the persistency layer.
     * 
     * @param projectID project where this instantiator has been created
     * @param engine the engine
     * @param filesToInstantiate the files that are handled by this instantiator
     * @param paths the last known path of the direct predecessor and the last known path that was the current path in a
     *            length two String[]
     * @param depthOfInheritance the complete inheritance chain
     * @param projectManager XXX
     * @param productID XXX
     */
    public FileInstantiator(String projectID, String engine, List<File> filesToInstantiate, String[] paths,
        List<String> depthOfInheritance, IInstantiatorProjectManager projectManager, String productID) {
        // TODO @SE correct comment
        this.projectID = projectID;
        this.projectManager = projectManager;
        this.engine = engine;
        this.filesToInstantiate = filesToInstantiate;
        this.tempFiles.addAll(filesToInstantiate);
        this.predecessorPath = paths[0];
        this.currentPath = paths[1];
        this.inheritanceChain = depthOfInheritance;
        this.productID = productID;
    }

    // checkstyle: resume parameter number check

    /**
     * This method is used to check whether the context of this instantiator has been changed. In case of a change the
     * instantiator has been inherited and needs to be changed accordingly.
     * 
     * @param currentID the current context project
     */
    public void checkContext(String currentID) {
        String pathToCheck = new File(projectManager.getProjectPath(currentID)).getPath();
        System.out.println("DEBUG: contextcheck path is: " + pathToCheck);
        if (!currentPath.equals(pathToCheck)) {
            System.out.println("DEBUG: context of this instantiator changed");
            System.out.println("Debug: old path was: " + currentPath);
            this.predecessorPath = currentPath;
            this.currentPath = pathToCheck;
            checkInheritance(projectManager.getPLPName(currentID));
        }
    }

    /**
     * Checks whether the given Projectname is the last and current Project in the inheritance chain of this
     * instantiator. If it is not, it will be added to the chain.
     * 
     * @param name the name of the project
     */
    public void checkInheritance(String name) {
        if (!name.equals(inheritanceChain.get(inheritanceChain.size() - 1))) {
            // one step advanced in inheritance...
            this.inheritanceChain.add(name);
        }
    }

    /**
     * This method is used in correlation with the instantiation process to get an idea where the files are to be found
     * that have to be instantiated. e.g. in SRC/PL_8/P_l2
     * 
     * @param predecessor if no copy has been used yet, the path for the predecessor is required
     * @return a path like SRC/PL_8/P_l2 or "" if its the project, where the instantiator is defined
     */
    private String getRelativeInstantiationPath(boolean predecessor) {
        int pathAdjust = predecessor ? 2 : 1;
        String relativePath = "";
        boolean loopCondition = inheritanceChain.size() - pathAdjust > 0;
        if (loopCondition) {
            relativePath += InstantiatorConstants.FOLDER_SOURCE;
        }
        // Skip last elem, as it is the own name or even one more, if checking
        // the predecessor
        relativePath += inheritancePath(pathAdjust);
        // add a seperator to create a convenient file path
        if (loopCondition) {
            relativePath += File.separator;
        }
        System.out.println("DEBUG: : " + relativePath);
        return relativePath;
    }
    
    /**
     * Determines the name space path based on the inheritance chain
     * and whether the path is determined for the predecessor or 
     * for the current project.
     * @param pathAdjust 2 for predecessor, 1 for current context
     * @return a String with the fraction of the file path
     */
    private String inheritancePath(int pathAdjust) {
        String inheritancePath = "";
        for (int i = inheritanceChain.size() - pathAdjust - 1; i >= 0; i--) {
            inheritancePath += File.separator + inheritanceChain.get(i);
        }
        return inheritancePath;
    }
    
    /**
     * Determines the name space path for the current context project 
     * based on the inheritance chain.
     * Example1: PL_B has PL_A as namespace, output is: PL_A
     * Example2: PL_C has a complexis successor of PL_B, output is: PL_B/PL_A
     * @return the name space fraction of the path
     */
    public String getInheritancePath() {
        return inheritancePath(1);
    }

    /**
     * The operational path of an instantiator can differ depending on the availability of the files. It show's where
     * the files that will be instantiated are to be found at. This is both required for the GUI to configure an
     * instantiator as well for the instantiation process. For the instantiation process see
     * {@link #getFilesToInstantiate()}.
     * <ul>
     * <li>the project which is currently been edited</li>
     * <li>the predecessor as there has not yet been any instantiation / copy
     * </ul>
     * The path is created out of the current context project path and the determined relative instantiation path
     * {@link #getRelativeInstantiationPath(boolean)} and checked for being valid.
     * 
     * @return the operational path of the instantiator
     */
    public String getOperationalPath() {
        String path = currentPath + File.separator;
        String test = path + getRelativeInstantiationPath(false);
        System.out.println("DEBUG: Path is: " + test);
        // Tests whether the path was already instantiated and therefore a
        // relativeInstantiationpath exists
        if (!new File(test).exists()) {
            System.out.println("DEBUG: expected path invalid. Working without name space");
            String predecessorName = inheritanceChain.get(inheritanceChain.size() - 2);
            int pos = test.lastIndexOf(predecessorName);
            test = test.substring(0, pos);
            //path = predecessorPath + File.separator;
            //test = path + getRelativeInstantiationPath(true);
            //predecessorRequired = true;
            predecessorRequired = false;
        } else {
            predecessorRequired = false;
        }
        path = test;
        System.out.println("DEBUG: operationalPath determined as: " + path);
        System.out.println("DEBUG: is the operationalPath valid? " + new File(path).exists());
        return path;
    }

    /**
     * Calculates and returns a list of files respecting the current context of the instantiator. The original file path
     * of each file will be adapted to the current context path with the expected relative instantiation path. The
     * adapted paths are not stored back into the model to maintain the original files. It handles both source as well
     * as non source files. This method is not intended to be called from the persistency layer. See
     * {@link #getFilesToInstantiatePersistency()}.
     * 
     * @return the list of files with adapted paths if required by the context
     */
    public List<File> getFilesToInstantiate() {
        List<File> result = new ArrayList<File>(filesToInstantiate.size());
        boolean enteredLoop = false;
        if (inheritanceChain.size() > 1) {
            String basePath = getOperationalPath();
            System.out.print("DEBUG: building paths with following path: ");
            System.out.println(basePath);
            String relativePath = getRelativeInstantiationPath(predecessorRequired);

            for (File file : filesToInstantiate) {
                // path adaption process
                enteredLoop = true;
                String currentFilePath = file.getPath();
                int indexOfRelativePath = currentFilePath.indexOf(relativePath);
                System.out.println("DEBUG: current Filepath: " + currentFilePath);
                String adaptedPath = basePath;
                // is not -1, if there had been an instantiation(including copy
                // before)
                String[] split = null;
                if (indexOfRelativePath > -1 /* from a predecessor */) {
                    adaptedPath += currentFilePath.substring(indexOfRelativePath + relativePath.length());
                    split = currentFilePath.split(relativePath);
                } else {
                    split = currentFilePath.split(InstantiatorConstants.FOLDER_SOURCE);
                }
                // Avoid the trailing backslash
                if (split.length == 2) {
                    adaptedPath += split[1].substring(1);
                }
                // Is the new path valid?
                File adaptedFile = new File(adaptedPath);
                if (adaptedFile.exists() && adaptedFile.isFile()) {
                    result.add(adaptedFile);
                    // the file is not at the expected path, so it might be a non-source file
                    // change the path to the non source namespace container
//                } else {
//                    System.out.println("DEBUG: Adapted path invalid. Using non source folder path");
//                    String[] currentPathSplit = currentFilePath.split(inheritanceChain.get(0));
//
//                    StringTokenizer nizer = new StringTokenizer(currentPathSplit[1], "\\ /");
//                    String token = nizer.nextToken();
//                    currentPathSplit[1] = currentPathSplit[1].substring(token.length() + 1);
//                    IInstantiatorProject productPLP = projectManager.getPLP(productID);
//                    // FIXME SE: Removed CopyMechanism 
////                    ICopyMechanism currentCopyMechanism = productPLP.getCopyModel().getCopyMechanism();
//                    String tmp1 = relativePath.split(InstantiatorConstants.FOLDER_SOURCE)[1];
//                    String tmp2 = currentPathSplit[1];
////                    if (currentCopyMechanism.useNameSpace()) {
////                        adaptedPath = currentPath + File.separatorChar + token + tmp1 + tmp2.substring(1);  
////                    } else {
////                        adaptedPath = currentPath + File.separatorChar + token + tmp2;    
////                    }
//                    
//                    System.out.println("DEBUG: adapted path: " + adaptedPath);
//                    adaptedFile = new File(adaptedPath);
//                    if (adaptedFile.exists() && adaptedFile.isFile()) {
//                        result.add(adaptedFile);
//                    } else {
//                        System.out.println("DEBUG: file does not exist, discarding...");
//                        System.out.println("DEBUG: missing original file: " + currentFilePath);
//                    }
                }
                System.out.println("DEBUG: adapted Filepath: " + adaptedPath);
            }
        }
        if (!enteredLoop) {
            result = filesToInstantiate;
        }
        return result;
    }

    /**
     * Returns the unmodified list of files to store this model data. This method is to be used in the persistency
     * layer.
     * 
     * @return the list of files to instantiate without path adaption
     */
    public List<File> getFilesToInstantiatePersistency() {
        return filesToInstantiate;
    }

    /**
     * Temporary saves the files to this model.
     * 
     * @param files the files to instantiate temporarily.
     */
    public void setFilesToInstantiateTemporary(List<File> files) {
        this.tempFiles = files;
    }

    /**
     * Sets the list of files which the engine has to instantiate This method is called by the GUI, if the user wants to
     * save the configuration he has made in the instantiator view.
     * 
     */
    public void setFilesToInstantiate() {
        this.filesToInstantiate.clear();
        this.filesToInstantiate.addAll(tempFiles);
    }

    /**
     * Getter for the associated project id, where this instantiator has been created.
     * 
     * @return The ID of the current project.
     */
    public String getProjectID() {
        return projectID;
    }

    /**
     * Returns the inheritance chain of this instantiator.
     * 
     * @return the inheritance chain
     */
    public List<String> getInheritanceChain() {
        return inheritanceChain;
    }

    /**
     * Returns the path of the last known predecessor project of this instantiator.
     * 
     * @return the path
     */
    public String getPredecessorPath() {
        return predecessorPath;
    }

    /**
     * Returns the path of the last known context project of this instantiator.
     * 
     * @return the path of the project
     */
    public String getCurrentPath() {
        return currentPath;
    }

    /**
     * Returns the name of direct predecessor of the current context project or the name of the project itself if the
     * instantiator had been created at this project.
     * 
     * @return the name of the predecessor
     */
    public String getPredecessor() {
        String result = inheritanceChain.get(0);
        if (inheritanceChain.size() > 1) {
            result = inheritanceChain.get(inheritanceChain.size() - 2);
        }
        return result;
    }

    /**
     * Getter for the engine name.
     * 
     * @return the engine for this instantiator
     */
    public String getEngine() {
        return engine;
    }

    /**
     * Calculates and returns all filetypes found in the current context of the instanitator. It does ignore the files
     * directly located at the root folder of the project.
     * 
     * @return the distinct file extensions
     */
    public HashSet<String> getFileType() {
        List<File> files = getFilesToInstantiatePersistency();
        // Determine used FileType
        HashSet<String> set = new HashSet<String>(files.size());
        for (File file : files) {
            //Consider only files
            if (!file.isDirectory()) {
                String path = file.getPath();
                int index = path.lastIndexOf('.');
                if (index == -1) {
                    // File without extension
                    set.add("empty Extension");
                } else {
                    set.add(path.substring(index + 1));
                }
            }
        }
        return set;
    }

    /**
     * Collects informations of this model for the GUI.
     * 
     * @return a String[] contianing the informations
     */
    public String[] inspect() {
        List<String> result = new ArrayList<String>();
        result.add("Name:");
        result.add(this.toString());
        result.add("Origin: " + inheritanceChain.get(0));
        int filesCount = getFilesToInstantiatePersistency().size();
        if (filesCount > 0) {
            String files = "Filetype";
            HashSet<String> fileTypes = getFileType();
            if (fileTypes.size() > 1) {
                files += "s";
            }
            result.add(files + ": ");
            result.addAll(fileTypes);
        }
        result.add("Complete inheritance chain:");
        result.addAll(inheritanceChain);
        return result.toArray(new String[result.size()]);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        List<String> inheritanceChainCloned = new ArrayList<String>(inheritanceChain.size());
        for (String s : inheritanceChain) {
            inheritanceChainCloned.add(s.substring(0));
        }
        FileInstantiator inst = new FileInstantiator(projectID, engine, filesToInstantiate, new String[] {
            predecessorPath.substring(0), currentPath.substring(0)}, inheritanceChainCloned, projectManager, productID);
        return inst;
    }

    @Override
    public String toString() {
        // Name of the Project where this instantiator was bound + engine name
        return inheritanceChain.get(0) + ":" + engine;
    }

    @Override
    public int hashCode() {
        return engine.hashCode() + projectID.hashCode() + inheritanceChain.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj == null ? false : hashCode() == obj.hashCode();
    }
}