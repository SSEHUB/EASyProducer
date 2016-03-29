package de.uni_hildesheim.sse.easy_producer.core.persistence.standard;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.Entity;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.IPersistencer;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.Model;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.ModelType;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.PersistentProject;
import de.uni_hildesheim.sse.easy_producer.core.varMod.container.ProjectContainer;
import net.ssehub.easy.reasoning.core.reasoner.AttributeException;
import net.ssehub.easy.reasoning.core.reasoner.AttributeValues;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;

/**
 * Stores the information of a {@link PersistentProject} in a {@link PLPInfo}
 * to simplify the load process.
 * @author El-Sharkawy
 *
 */
public class PersistentProject2PLPConverter implements PersistenceConstants {
    
    private IPersistencer persistencer;
    private PersistentProject project;
    
    /**
     * Sole constructor for this class.
     * @param persistencer The persistencer which is currently loading the {@link PLPInfo}.
     * @param project The {@link PersistentProject} which should be translated.
     */
    public PersistentProject2PLPConverter(IPersistencer persistencer, PersistentProject project) {
        this.persistencer = persistencer;
        this.project = project;
    }
    
    /**
     * Translates the {@link PersistentProject} into a {@link PLPInfo}.
     * @return A {@link PLPInfo} representing the given {@link PersistentProject}.
     * @throws PersistenceException Will be thrown if the {@link PersistentProject} contains invalid data.
     */
    public PLPInfo persistentProject2PLP() throws PersistenceException {
        PLPInfo plp = null;
        Model model = project.getModel(ModelType.ROOT);
        String projectID = model.getEntity(0).getAttributes().get(PTN_UUID);
        String projectname = project.getName();
        plp = SPLsManager.INSTANCE.getPLP(projectID);
        
        if (plp == null || plp.isPreliminary()) {
            File location = project.getLocation();
            ProjectContainer varModel = project.getProject();
            String version = (varModel != null && varModel.getVersion() != null)
                ? varModel.getVersion().getVersion() : null;
            plp = new PLPInfo(projectID, projectname, version, location);
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

}
