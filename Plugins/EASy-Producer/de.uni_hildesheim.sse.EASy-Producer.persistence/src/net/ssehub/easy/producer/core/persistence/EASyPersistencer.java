package net.ssehub.easy.producer.core.persistence;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.producer.core.mgmt.GenericProductLineProject;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.mgmt.SPLsManager;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;
import net.ssehub.easy.producer.core.persistence.datatypes.Entity;
import net.ssehub.easy.producer.core.persistence.datatypes.IPersistencer;
import net.ssehub.easy.producer.core.persistence.datatypes.IProjectCreationResult;
import net.ssehub.easy.producer.core.persistence.datatypes.Model;
import net.ssehub.easy.producer.core.persistence.datatypes.ModelType;
import net.ssehub.easy.producer.core.persistence.datatypes.PathEnvironment;
import net.ssehub.easy.producer.core.persistence.datatypes.PersistentProject;
import net.ssehub.easy.producer.core.persistence.standard.PersistenceConstants;
import net.ssehub.easy.producer.core.persistence.standard.Persistencer;
import net.ssehub.easy.producer.core.varMod.container.ProjectContainer;
import net.ssehub.easy.producer.core.varMod.container.ScriptContainer;
import net.ssehub.easy.reasoning.core.reasoner.AttributeException;
import net.ssehub.easy.reasoning.core.reasoner.AttributeValues;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.varModel.model.Project;

/**
 * Abstraction Layer for saving/reading persistent EASy-Producer information.
 * @author El-Sharkawy
 *
 */
public class EASyPersistencer implements PersistenceConstants {
    
    private IPersistencer persistencer;

    /**
     * Creates a specialized EASy persistencer without underlying project.
     * @param projectFolder The location of the {@link ProductLineProject}.
     */
    public EASyPersistencer(File projectFolder) {
        PathEnvironment pathEnv = new PathEnvironment(projectFolder.getParentFile());
        File ivmlFolder = PersistenceUtils.getLocationFile(projectFolder, PathKind.IVML);
        persistencer = new Persistencer(pathEnv, projectFolder, ivmlFolder.getAbsolutePath(), 
            ProgressObserver.NO_OBSERVER);
    }
    
    /**
     * Creates a specialized EASy persistencer without underlying project.
     * @param persistencer the persistencer to use
     */
    protected EASyPersistencer(IPersistencer persistencer) {
        this.persistencer = persistencer;
    }

    /**
     * Reads the persistent data and transforms them into a {@link ProductLineProject}.
     * @return A {@link ProductLineProject} or <code>null</code>.
     * @throws PersistenceException Will be thrown if the data is invalid or an IOException occur,
     * while reading the persistent data.
     */
    public PLPInfo load() throws PersistenceException {
        PLPInfo plp = null;
        PersistentProject project = persistencer.load();
        plp = persistentProject2PLP(project);
        PersistenceUtils.refreshModels(plp);
        return plp;
    }
    
    /**
     * (Re-)Loads all variability models of the specified {@link ProductLineProject} from the file system.
     * @param plp A {@link ProductLineProject} containing saved models which should be (re-) loaded from the file system
     */
    public static void refreshModels(PLPInfo plp) {
        PersistenceUtils.refreshModels(plp);
    }
    
    /**
     * Returns the location of the main ivml file for the given {@link ProductLineProject}.
     * @param plp The {@link ProductLineProject} holding the ivml file for which this method looks for.
     * @return The location of the ivml file or <code>null</code> if the location could not be determined.
     */
    public static File projectPath(PLPInfo plp) {
        //File configFolder = configLocation(plp.getProjectLocation());
        Configuration config = PersistenceUtils.getConfiguration(plp.getProjectLocation());
        File configFolder = config.getPathFile(PathKind.IVML, 0);
        String filename = PersistenceUtils.ivmlFileLocation(plp.getProject(), configFolder.getAbsolutePath());
        
        return new File(filename);
    }

    /**
     * Creates a PLP.
     * 
     * @param projectID The ID of the product line project
     * @param projectName The name of the product line project
     * @param project An already existent variability model for this {@link ProductLineProject}.
     * @param projectLocation The top level location of the whole ProductLineProject
     * @param mainBuildScript The main build script for building the project (starting point of the instantiation).
     * @return the created PLP
     */
    protected GenericProductLineProject createPLP(String projectID, String projectName, ProjectContainer project,
        File projectLocation, ScriptContainer mainBuildScript) {
        return new GenericProductLineProject(projectID, projectName, project, projectLocation, mainBuildScript);
    }
    
    /**
     * Translates the {@link PersistentProject} into a {@link ProductLineProject}.
     * @param project The {@link PersistentProject} which should be translated.
     * @return A {@link ProductLineProject} representing the given {@link PersistentProject}.
     * @throws PersistenceException Will be thrown if the {@link PersistentProject} contains invalid data.
     */
    private PLPInfo persistentProject2PLP(PersistentProject project) throws PersistenceException {
        PLPInfo plp = null;
        Model model = project.getModel(ModelType.ROOT);
        String projectID = model.getEntity(0).getAttributes().get(PTN_UUID);
        String projectname = project.getName();
        plp = (PLPInfo) SPLsManager.INSTANCE.getPLP(projectID);
        
        if (plp == null || plp.isPreliminary()) {
            File location = project.getLocation();
            ProjectContainer varModel = project.getProject();
            plp = createPLP(projectID, projectname, varModel, location, project.getMainBuildScript());
        }
        
        for (int i = 0; i < project.getModelCount(); i++) {
            model = project.getModel(i);
            switch(model.getModelType()) {
            case PREDECESSORS: 
                plp.getMemberController().setPredecessors(model2Relatives(model));
                break;
            case SUCCESSORS: 
                plp.getMemberController().setSuccessors(model2Relatives(model));
                break;
            case INSTANTIATORS:
                // Not longer supported -> Functionality moved to VIL
                break;
            case REASONERS:
                createReasonerConfiguration(plp, model);
                break;
            case SETTINGS:
                if (model.getEntityCount() > 0) {
                    String debug = model.getEntity(0).getAttributeValue(SETTINGS_DEBUG);
                    plp.setSaveDebugInformation(Boolean.valueOf(debug));
                }
                break;
            default:
                break;
            }
        }
        
        if (null != plp.getProject() && null != plp.getReasonerConfig().getAttributeValues()) {
            try {
                plp.getReasonerConfig().getAttributeValues().resolveUsing(plp.getProject(), true);
            } catch (AttributeException e) {
                // failed resolving the configuration, bad luck
            }
        }
        return plp;
    }
    
    /**
     * Creates ReasoningConfiguration.
     * @param model A model of type {@link ModelType#INSTANTIATORS} holding all instantiator information.
     * @param plp The {@link ProductLineProject} where the instantiators should be saved
     */
    private void createReasonerConfiguration(PLPInfo plp, Model model) {
        ReasonerConfiguration reasonerConfig = new ReasonerConfiguration();
        
        for (int i = 0; i < model.getEntityCount(); i++) {
            Entity entity = model.getEntity(i);
            
            if (null != entity.getAttributeValue(REASONER_TIMEOUT)) {
                reasonerConfig.setTimeout(Integer.valueOf(entity.getAttributeValue(REASONER_TIMEOUT)));
            }
            if (null != entity.getAttributeValue(REASONER_ATTRIBUTE)) {
                String attribute = entity.getAttributeValue(REASONER_ATTRIBUTE);
                String values = entity.getAttributeValue(REASONER_VALUES);
                if (null != values) {
                    List<String> attributeValues = new ArrayList<String>();
                    StringTokenizer tokens = new StringTokenizer(values, REASONER_VALUE_SEPARATOR);
                    while (tokens.hasMoreTokens()) {
                        attributeValues.add(tokens.nextToken());
                    }
                    AttributeValues attributes = reasonerConfig.getAttributeValues();
                    if (null == attributes) {
                        attributes = new AttributeValues();
                        reasonerConfig.setAttributeValues(attributes);
                    }
                    attributes.addUnresolved(attribute, attributeValues);
                }
            }
        }
        
        plp.setReasonerConfig(reasonerConfig);
    }

    /**
     * Creates information related to relative projects..
     * @param model A model of type {@link ModelType#PREDECESSORS} or
     * {@link ModelType#SUCCESSORS} holding all Prede-/Successor information.
     * @return The Predecessors/Successor-List
     */
    private List<PLPInfo> model2Relatives(Model model) {
        List<PLPInfo> relatives = new LinkedList<PLPInfo>();
        for (int j = 0; j < model.getEntityCount(); j++) {
            Entity entity = model.getEntity(j);
            String id = entity.getAttributeValue(PRESUCCESSOR_UUID);
            String memberName = entity.getAttributeValue(PRESUCCESSOR_MEMEBERNAME);
            String version = entity.getAttributeValue(PRESUCCESSOR_VERSION);
            File location;
            String tmp = entity.getAttributeFileString(PRESUCCESSOR_LOCATION);
            if (null != tmp) {
                location = persistencer.getPathEnvironment().makeAbsolute(tmp);
            } else {
                location = null;
            }
            // before: just new PLPInfo - does not support predecessors across 1 hierarchy level
            // TODO SE: check whether other attributes must be set anyway
            PLPInfo info = SPLsManager.INSTANCE.getPLP(id);
            if (null == info) {
                info = new PLPInfo(id, memberName, version, location);
                SPLsManager.INSTANCE.addPLP(info);
            }
            relatives.add(info);
        }
        
        return relatives;
    }
    
    /**
     * Saves the given {@link ProductLineProject} persistently.
     * @param plp The {@link ProductLineProject} which should be saved.
     * @throws PersistenceException Will be thrown if an exception occurs while accessing the file system.
     */
    public void save(PLPInfo plp) throws PersistenceException {
        persistencer.save(plp);
    }
    
    /**
     * Returns the ID of a given pl project.
     * 
     * @return the id or <b>null</b> if the specified project has no configuration file.
     */
    public String getProjectID() {
        return persistencer.getProjectID();
    }
    
    /**
     * Creates an empty EASy project without any eclipse specific stuff.
     * @param projectName The name of the project, which should be created.
     * @param parentFolder The parentFolder, where the project should be created.
     * @param projectID The unique ID of the project which should be created.
     * @param lazy if <code>true</code>, create only required parts, else assume that project does not exist before
     * @throws PersistenceException Will be thrown if the System cannot create folders and files in the parentFolder.
     * @return IProjectCreationResult Information of newly created items.
     */
    public IProjectCreationResult createProject(String projectName, File parentFolder, String projectID, boolean lazy)
            throws PersistenceException {
        File ivmlFolder = PersistenceUtils.getLocationFile(persistencer.getProjectFolder(), PathKind.IVML);
        ivmlFolder.mkdirs();
        IProjectCreationResult result = persistencer.createProject(projectName, parentFolder, projectID, lazy);
        return result;
    }

    /**
     * Populates an empty EASY project. Call {@link #createProject(String, File, String, boolean)} before.
     * 
     * @param pcr the project creation result
     * @return the PLP#
     * @see #populateEasyProject(String, String, File, Project)
     */
    public GenericProductLineProject populateEasyProject(IProjectCreationResult pcr) {
        return populateEasyProject(pcr.getProjectID(), pcr.getProjectFolder().getName(), pcr.getProjectFolder(), 
            pcr.getVarModel());
    }

    /**
     * Populates an empty EASY project. Call {@link #createProject(String, File, String, boolean)} before.
     * 
     * @param projectID the projectID
     * @param projectName the project name
     * @param projectFolder the project folder
     * @param ivmlModel the IVML model
     * @return the PLP
     */
    public GenericProductLineProject populateEasyProject(String projectID, String projectName, File projectFolder, 
        Project ivmlModel) {
        // at least called when importing / creating a new project
        Script mainBuildScript = new Script(projectName, Script.createDefaultParameter());
        Version version = ivmlModel.getVersion();
        if (null != version) {
            mainBuildScript.setVersion(version);
        }
        
        Configuration location = PersistenceUtils.getConfiguration(projectFolder);
        ProjectContainer varModel = new ProjectContainer(ivmlModel, location);
        ScriptContainer instantiationModel = new ScriptContainer(mainBuildScript, location);
        instantiationModel.setEdited(true);
        
        return createPLP(projectID, projectName, varModel, projectFolder, instantiationModel);
    }

}
