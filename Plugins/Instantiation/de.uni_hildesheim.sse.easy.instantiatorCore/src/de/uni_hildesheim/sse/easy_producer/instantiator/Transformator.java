package de.uni_hildesheim.sse.easy_producer.instantiator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import de.uni_hildesheim.sse.easy.instantiator.copy.core.ICopyMechanism;
import de.uni_hildesheim.sse.easy_producer.instantiator.internal.NoInstantiatorStateObserver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.FileInstantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.IInstantiatorProject;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.IInstantiatorProjectManager;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.IInstantiatorStateObserver;

/**
 * This class manages the instantiation process. It
 * <ul>
 * <li>loads the available engines</li>
 * <li>checks whether all instantiators from the current project have corresponding engines</li>
 * <li>checks whether the predecessor defined by the current instantiator is available</li>
 * <li>starts the copy and instantiation mechanisms</li>
 * <li>
 * meanwhile it shows progressbars and notifications depending on the current state</li>
 * </ul>
 * 
 * @author gawenda
 * 
 */
public class Transformator implements Runnable {
    
    /**
     * For displaying user information of each instantiator in the console of
     * the running Eclipse-instance.
     */
    private static IInstantiatorStateObserver logger = new NoInstantiatorStateObserver();
    
    /**
     * Loads all available engines.
     */
    private static List<InstantiatorEngine> engines = new ArrayList<InstantiatorEngine>();

    /**
     * The current product line project.
     */
    private IInstantiatorProject currentPLP;
    
    private IInstantiatorProjectManager projectManager;
    
    private ICopyMechanism resourceMgmt;

    /**
     * The handle back to the gui to update progress and show necessary warnings.
     */
    private TranformatorNotificationDelegate delegate;
    
    private List<InstantiatorEngine> toUseEngines;

    /**
     * Sole constructor for the instantiation process. It's called from the GUI on user request.
     * 
     * @param currentUUID the current project
     * @param delegate the handle for user notifications
     * @param projectManager A class capable of retrieving information about (other) projects.
     * @param resourceMgmt A abstraction layer for consistent file system operations.
     */
    public Transformator(String currentUUID, TranformatorNotificationDelegate delegate,
        IInstantiatorProjectManager projectManager, ICopyMechanism resourceMgmt) {
        this.projectManager = projectManager;
        this.delegate = delegate;
        this.resourceMgmt = resourceMgmt;
        this.currentPLP = projectManager.getPLP(currentUUID);
        // start the instantiation process
    }
    
    /**
     * Executes the transformation.
     * 
     * @return <code>true</code> if some processing was done, <code>false</code> if no transformators were defined
     */
    public boolean execute() {
        // could also have worked via ConfigurationHeaderMenu.isTransformable()
        boolean processingDone = false;
        toUseEngines = getToUseEngines();
        if (!toUseEngines.isEmpty()) {
            new Thread(this).start();
            processingDone = true;
        } 
        return processingDone;
    }
    
    /**
     * Method for setting the state observer that enables instantiators to send messages
     * to the console of the running Eclipse-instance.
     * 
     * @param observer the observer that listens for new messages
     */
    public static void setInstantiatorStateObserver(IInstantiatorStateObserver observer) {
        logger = observer;
    }
    
    /**
     *  Method for getting the current observer that enables instantiators to send messages
     *  to the console of the running Eclipse-instance.
     *  
     *  @return the current oberver
     */
    public static IInstantiatorStateObserver getInstantiatorStateObserver() {
        return logger;
    }
    
    /**
     * Method for adding new instantiators via OSGi descriptive services.
     * @param engine The instantiator to add
     */
    public static void addEngine(InstantiatorEngine engine) {
        engines.add(engine);
    }

    /**
     * Method for removing new instantiators via OSGi descriptive services.
     * @param engine The instantiator to remove
     */
    public static void removeEngine(InstantiatorEngine engine) {
        engines.remove(engine);
    }
    
    /**
     * Specified by interface: <b>Runnable</b>. {@inheritDoc}
     */
    public void run() {        
        // 1. check whether all engines are available and prepare them
        //List<InstantiatorEngine> toUseEngines = getToUseEngines();
        // done by execute
        /*
         * In ScaleLog a specific order of the instantiators is requrired. Thus, reorder!
         */
        List<InstantiatorEngine> reorderedEngines = reorderEngines(toUseEngines);
        if (reorderedEngines != null) {
            toUseEngines = reorderedEngines;   
        }
        
        // 2. Userfeedback, show a progressbar
        int filesCount = 0;
        for (InstantiatorEngine engine : toUseEngines) {
            filesCount += engine.getFilesCount();
        }
        delegate.tranformatorDidStart(filesCount);

        List<String> copied = new ArrayList<String>(toUseEngines.size());
        List<String> failures = new ArrayList<String>();
        // handle the instantiators
        for (InstantiatorEngine engine : toUseEngines) {
            // 3.Copy all files from predecessor to current project
            String predecessor = engine.getPredecessor();
            // Doublecheck: is the project a valid predecessor and hasn't it yet
            // been copied?
            if (resourceMgmt.isPLPInWorkspace(predecessor) && !copied.contains(predecessor)) {
                resourceMgmt.copy(predecessor, currentPLP.getProjectName());
                copied.add(predecessor);
            }
            // 4. Begin instantiation process
            if (copied.contains(predecessor)) {
                try {
                    engine.instantiate();
                } catch (InstantiatorException e) {
                    delegate.transformatorDidFail(e.getLocalizedMessage());
                }
                
            } else {
                failures.add(engine.toString() + " for " + predecessor);
            }
            
            // update the progressbar for userconvenience
            delegate.transformatorDidFinishInQueue(engine.getFilesCount());
        }
        
        delegate.tranformatorDidFinish();

        // show failed instantiations due to missing predecessors
        if (failures.size() > 0) {
            delegate.showInfoDialog("At least one instantiation was skipped due to missing predecessor project.\n"
                    + "Failed engines for missing project:\n" + failures.toString());
        }
        //Refresh file system in eclipse (package explorer)
        resourceMgmt.refreshProject(currentPLP.getProjectName());
    }
    
    /**
     * Reorders the engines in a way that a Gradle instantiator is last.
     * 
     * @param engineList the list of engines
     * @return the reordered list of engines
     */
    private List<InstantiatorEngine> reorderEngines(List<InstantiatorEngine> engineList) {
        List<InstantiatorEngine> orderedList = null;
        if (engineList != null && engineList.size() > 0) {
            orderedList = new ArrayList<InstantiatorEngine>();
            InstantiatorEngine temp = null;
            for (InstantiatorEngine engine : engineList) {
                if (engine.toString().contains("Gradle")) {
                    temp = engine;
                } else {
                    orderedList.add(engine);
                }
            }
            if (temp != null) {
                orderedList.add(temp);   
            }
        }
        return orderedList;
    }
    

    /**
     * Returns a list of names of all available instantiator engines.
     * 
     * @return the names of the available engines
     */
    public static List<String> getAvailableInstantiators() {
        ArrayList<String> result = new ArrayList<String>();

        for (InstantiatorEngine e : engines) {
            String className = e.getClass().toString();
            result.add(className.substring(className.lastIndexOf(".") + 1));
        }
        return result;
    }

    /**
     * Checks which instantiators were configured in the current project and initializes them with the instantiator
     * model. If a engine is not available as required per instantiator model a warning is presented to the user.
     * 
     * @return the initialized engines
     */
    private List<InstantiatorEngine> getToUseEngines() {
        List<InstantiatorEngine> result = new ArrayList<InstantiatorEngine>();
        HashSet<FileInstantiator> models = currentPLP.getInstantiatorController().getInheritedInstantiators();
        /*
         * TODO: muss noch mal ordentlich gemacht werden...
         * Workaround für ScaleLog
         */
        if (models.isEmpty()) {
            models.addAll(currentPLP.getInstantiatorController().getTransformators());
        }
        
        List<String> missingEngines = new ArrayList<String>();
        // check whether there is an engine for each model available and
        // initialize them
        for (FileInstantiator model : models) {
            int currentSize = result.size();
            String configuredEngine = model.getEngine();
            for (InstantiatorEngine e : engines) {
                if (e.getClass().toString().contains(configuredEngine)) {
                    // Set the model and init with the product
                    e.init(model, currentPLP.getProjectID(), projectManager);
                    result.add(e);
                    break; // match found, leave inner for loop
                }
            }
            // engine not found?
            if (currentSize == result.size()) {
                missingEngines.add(configuredEngine);
            }
        }
        // if an instantiator engine hasn't been found, alarm the user
        if (models.size() != result.size()) {
            delegate.showInfoDialog("At least one required instantiator engine is missing and will be skipped.\n"
                    + "Missing engines:\n" + missingEngines.toString());
        }
        // TODO future work
        // prepare the List by assuming a compareable(sortable)
        // bindingtimerelation
        // get the BindingTimeRelation and create a sorted List according to
        // binding times
        // as the result.
        return result;
    }
}
