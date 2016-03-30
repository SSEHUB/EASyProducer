package net.ssehub.easy.producer.core.persistence.standard;

import java.util.List;

import net.ssehub.easy.producer.core.mgmt.PLPInfo;
import net.ssehub.easy.producer.core.persistence.PersistenceException;
import net.ssehub.easy.producer.core.persistence.datatypes.Entity;
import net.ssehub.easy.producer.core.persistence.datatypes.IPersistencer;
import net.ssehub.easy.producer.core.persistence.datatypes.Model;
import net.ssehub.easy.producer.core.persistence.datatypes.ModelType;
import net.ssehub.easy.producer.core.persistence.datatypes.PersistentProject;
import net.ssehub.easy.reasoning.core.reasoner.AttributeValues;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerConfiguration;
import net.ssehub.easy.varModel.confModel.ConfigurationException;
import net.ssehub.easy.varModel.model.Attribute;

/**
 * Stores the information of a {@link PLPInfo} in a {@link PersistentProject}
 * to simplify the save process.
 * @author El-Sharkawy
 *
 */
public class PLP2ProjectConverter implements PersistenceConstants {
    
    private PLPInfo plp;
    private IPersistencer persistencer;
    
    /**
     * Sole constructor for this class.
     * @param plp The {@link PLPInfo} which shall be saved.
     * @param persistencer The {@link IPersistencer} which shall save the
     * {@link PLPInfo}.
     */
    public PLP2ProjectConverter(PLPInfo plp, IPersistencer persistencer) {
        this.plp = plp;
        this.persistencer = persistencer;
    }

    /**
     * Converts the given {@link PLPInfo} into a {@link PersistentProject}.
     * @return The converted {@link PLPInfo}.
     * @throws PersistenceException In case of any configuration errors
     */
    @SuppressWarnings("deprecation")
    public PersistentProject plp2PersistentProject() throws PersistenceException {
        PersistentProject project = new PersistentProject(plp.getProjectLocation());

        // predecessors
        Model model = project.getModel(ModelType.PREDECESSORS);
        for (PLPInfo member : plp.getMemberController().getPredecessors()) {
            Entity entity = relative2Entity(member);
            model.addEntity(entity);
        }

        // successors
        model = project.getModel(ModelType.SUCCESSORS);
        for (PLPInfo member : plp.getMemberController().getSuccessors()) {
            Entity entity = relative2Entity(member);
            model.addEntity(entity);
        }
        
        // Reasoners
        model = project.getModel(ModelType.REASONERS);
        reasoner2Model(model, plp.getReasonerConfig());
        
        // Project settings
        model = project.getModel(ModelType.SETTINGS);
        Entity entitySettings = new Entity();
        entitySettings.createAttribute(SETTINGS_DEBUG, Boolean.toString(plp.getSaveDebugInformation()));
        model.addEntity(entitySettings);
        
        // Add data of the configuration to related project.
        ConfigurationException configException = null;
        try {
            plp.getConfiguration().toProject(false);
        } catch (ConfigurationException e) {
            configException = e;
        }
//        project.setProject(plp.getProject(), plp.getPathConfiguration());
        project.setVarModel(plp.getProjectContainer());
        project.setID(plp.getProjectID());
        project.setName(plp.getProjectName());
//        project.setScript(plp.getBuildScript(), plp.getPathConfiguration());
        project.setScript(plp.getScriptContainer());
        
        if (null != configException) {
            throw new PersistenceException(configException.getLocalizedMessage());
        }
        
        return project;
    }
    
    /**
     * Converts a <tt>ReasonerConfiguration</tt> to a persistent model.
     * @param reasonerModel The persistent model, where the configuration should be stored to.
     * @param reasonerConfig The origin data which should be saved persistencly.
     */
    private void reasoner2Model(Model reasonerModel, ReasonerConfiguration reasonerConfig) {
        Entity timeoutEntity = new Entity();
        timeoutEntity.createAttribute(REASONER_TIMEOUT, String.valueOf(reasonerConfig.getTimeout()));
        reasonerModel.addEntity(timeoutEntity);
        
        AttributeValues attributes = reasonerConfig.getAttributeValues();
        if (null != attributes) {
            List<Attribute> attributeList = attributes.getAttributesAsList();
            for (int i = 0; i < attributeList.size(); i++) {
                Entity attributeEntity = new Entity();
                Attribute currentAttribute = attributeList.get(i);
                attributeEntity.createAttribute(REASONER_ATTRIBUTE, currentAttribute.getName());
                StringBuffer values = new StringBuffer();
                for (int j = 0; j < attributes.getAttributeValuesCount(currentAttribute); j++) {
                    if (j > 0) {
                        values.append(REASONER_VALUE_SEPARATOR);
                    }
                    values.append(AttributeValues.toString(attributes.getAttributeValue(currentAttribute, j)));
                }
                attributeEntity.createAttribute(REASONER_VALUES, values.toString());
                reasonerModel.addEntity(attributeEntity);
            }
        }
    }
    
    /**
     * This method converts a predecessor or and successor to an entity.
     * 
     * @param info the predecessor or successor
     * @return An entity representing the given relative plp
     */
    private Entity relative2Entity(PLPInfo info) {
        Entity entity = new Entity();
        entity.createAttribute(PRESUCCESSOR_UUID, info.getProjectID());
        entity.createAttribute(PRESUCCESSOR_MEMEBERNAME, info.getProjectName());
        if (null != info.getVersion()) {
            entity.createAttribute(PRESUCCESSOR_VERSION, info.getVersion().toString());
        }
        String tmp = persistencer.getPathEnvironment().makeRelative(info.getProjectLocation());
        if (null != tmp) {
            entity.createAttributeFileString(PRESUCCESSOR_LOCATION, tmp);
        }
        return entity;
    }
}
