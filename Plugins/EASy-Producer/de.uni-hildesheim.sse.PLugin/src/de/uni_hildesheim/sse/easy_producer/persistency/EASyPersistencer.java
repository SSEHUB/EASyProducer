package de.uni_hildesheim.sse.easy_producer.persistency;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration;
import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration.PathKind;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceUtils;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.Entity;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.IPersistencer;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.Model;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.ModelType;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.PersistentProject;
import de.uni_hildesheim.sse.easy_producer.core.persistence.standard.PersistenceConstants;
import de.uni_hildesheim.sse.easy_producer.core.varMod.container.ProjectContainer;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.reasoning.core.reasoner.AttributeException;
import de.uni_hildesheim.sse.reasoning.core.reasoner.AttributeValues;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;

/**
 * Abstraction Layer for saving/reading persistent EASy-Producer information.
 * @author El-Sharkawy
 *
 */
public class EASyPersistencer implements PersistenceConstants {
    
    private IPersistencer persistencer;
    
    /**
     * Sole constructor for this class.
     * @param projectFolder The location of the {@link ProductLineProject}.
     */
    public EASyPersistencer(File projectFolder) {
        persistencer = PersistencerFactory.getPersistencer(projectFolder);
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
        ResourcesMgmt.INSTANCE.refreshProject(plp.getProjectName());
        PersistenceUtils.refreshModels(plp);
    }
    
    /**
     * Returns the location of the main ivml file for the given {@link ProductLineProject}.
     * @param plp The {@link ProductLineProject} holding the ivml file for which this method looks for.
     * @return The location of the ivml file or <tt>null</tt> if the location could not be determined.
     */
    public static File projectPath(PLPInfo plp) {
        //File configFolder = configLocation(plp.getProjectLocation());
        Configuration config = PersistenceUtils.getConfiguration(plp.getProjectLocation());
        File configFolder = config.getPathFile(PathKind.IVML);
        String filename = PersistenceUtils.ivmlFileLocation(plp.getProject(), configFolder.getAbsolutePath());
        
        return new File(filename);
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
            plp = new ProductLineProject(projectID, projectname, varModel, location, project.getMainBuildScript());
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
        
        reasonerConfig.setFreshConfiguration(false);
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
}
