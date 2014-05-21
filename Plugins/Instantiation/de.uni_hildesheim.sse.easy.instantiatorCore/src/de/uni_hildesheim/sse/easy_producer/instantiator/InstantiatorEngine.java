package de.uni_hildesheim.sse.easy_producer.instantiator;

import java.io.File;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.FileInstantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.IInstantiatorProject;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.IInstantiatorProjectManager;
import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;

/**
 * All wrapper classes for instantiators must extend this class. This abstract class encapsulates the instantiatormodel
 * and exports only necessary methods for the Transformator class and the specific instantiator wrappers.
 * 
 * @author gawenda
 * @author kapeluch
 */
public abstract class InstantiatorEngine {

    /**
     * The underlying model.
     */
    private FileInstantiator model;

    /**
     * The current project that the instantiation is running for.
     */
    private String projectID;
    
    /**
     * Current project, which is being instantiated.
     */
    private IInstantiatorProject plp;
 

    /**
     * The service loader requires a null argument constructor. Therefore this method is used to set the model and init
     * the wrapped engine.
     * 
     * @param model The model of source files translated by the engine.
     * @param projectID The ID of the actual product line which should be instantiated.
     * @param projectManager A class capable of retrieving information about (other) projects.
     */
    public void init(FileInstantiator model, String projectID, IInstantiatorProjectManager projectManager) {
        this.model = model;
        this.projectID = projectID;
        plp = projectManager.getPLP(projectID);
        model.checkContext(projectID);
        initEngine();
    }

    /**
     * This method is intended to be used to initialize the instantiator with the configured decisions/features.
     */
    protected abstract void initEngine();
    
    /**
     * This method is intended to be used to clear the instantiator context before it will be filled with
     * the configuration model. See {@link #prepareContext()}
     */
    protected abstract void clearContext();
    
    /**
     * This method fills the context of the instantiator with the relevant entities from the configuration model.
     * Only relevant and made instances where the namespace corresponds to the namespace of the instantiator will 
     * be considered.  
     * TODO:  write test case
     */
    protected final void prepareContext() {
        clearContext();
        
        // create namespace for the instantiator from its inheritance path
        String instantiatorNS = model.getInheritancePath();
        /*
         * TODO: muss noch mal ordentlich gemacht werden...
         * Workaround für ScaleLog
         */
        if (instantiatorNS.length() > 0) {
            instantiatorNS = instantiatorNS.substring(1, instantiatorNS.length());
            instantiatorNS = instantiatorNS.replace(File.separator, ":");            
        }
        
        /*
         * TODO: Not clear whether this is ok
         * Inheritance namespace can contain many namepsaces
         * Model element namespace can contain only one namespace
         * -> Consider only last segment of inheritance namespace
         */
        int lastSep = instantiatorNS.lastIndexOf(':');
        if (lastSep != -1) {
            instantiatorNS = instantiatorNS.substring(lastSep + 1, instantiatorNS.length());
        }
        
        for (IDecisionVariable decisionVariable : plp.getConfiguration()) {
            
            /*
             * decisionVariable.getState() == AssignmentState.FROZEN forces to consider only frozen variables,
             * which is needed for hierarchical product lines (staged instantiation)
             * Remove this part from the if clause to use all decision variables during instantiation (also not frozen)
             */
            if (null != decisionVariable.getValue() && decisionVariable.getState() == AssignmentState.FROZEN) {
                
                // adapt namespace of entity for comparing with instantiatorNS  
                String entityNS = decisionVariable.getDeclaration().getNameSpace();
                
                lastSep = entityNS.lastIndexOf(':');
                if (lastSep != -1) {
                    entityNS = entityNS.substring(0, lastSep);
                }
                
                // check relevance and add the entity to the instantiator context
                if (entityNS.equals(instantiatorNS) || instantiatorNS.length() == 0) {
                    addValue2Context(decisionVariable);
                }
            }
        }
    }
    
    /**
     * This method should insert decision variables and their concrete value to the instantiator context.
     * @param variable The decision (variable) including the configured value, which should be added to the context.
     */
    protected abstract void addValue2Context(IDecisionVariable variable);

    /**
     * This method will perform the instantiation given on the files provided by the model.
     * @throws InstantiatorException    Exception occurred while instantiation
     */
    public abstract void instantiate() throws InstantiatorException;

    /**
     * The number of files is used for user feedback(progressbar).
     * 
     * @return the number of files
     */
    public int getFilesCount() {
        return model.getFilesToInstantiatePersistency().size();
    }

    /**
     * Returns the operating context for this instantiator.
     * 
     * @return the ID of the current project
     */
    public String getProjectID() {
        return projectID;
    }

    /**
     * Returns the name of the predecessor project of the inheritance list of this instantiator.
     * 
     * @return the name of the predecessor project.
     */
    public String getPredecessor() {
        return model.getPredecessor();
    }

    /**
     * Calculates and returns the files to instantiate. The calculation and pathadaption is based on the current
     * context.
     * 
     * @return the list of contextualized files.
     */
    public List<File> getFilesToInstantiate() {
        return model.getFilesToInstantiate();
    }

    /**
     * Returns the path of the predecessor.
     * 
     * @return the path as a String
     */
    public String getPredecessorPath() {
        return model.getPredecessorPath();
    }
    
    /**
     * Returns the actual project, which is should be instantiated.
     * @return The Project which is should be instantiated.
     */
    protected IInstantiatorProject getPLP() {
        return plp;
    }
    

    @Override
    public String toString() {
        return model.toString();
    }
}
