package de.uni_hildesheim.sse.easy_producer.core.persistence.standard;

import java.io.File;
import java.util.HashSet;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.core.mgmt.InstantiatorController;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.persistence.PersistenceException;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.Entity;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.IPersistencer;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.Model;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.ModelType;
import de.uni_hildesheim.sse.easy_producer.core.persistence.datatypes.PersistentProject;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.FileInstantiator;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.reasoning.core.reasoner.AttributeValues;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;

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
        
        // Instantiators
        Model model = project.getModel(ModelType.INSTANTIATORS);
        instantiators2Model(model, plp.getInstantiatorController());

        // predecessors
        model = project.getModel(ModelType.PREDECESSORS);
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

        // CopyMechanism
        model = project.getModel(ModelType.COPY);
        Entity entity = new Entity();
        entity.createAttribute(COPY_ID, plp.getCopyModel().getID());
        model.addEntity(entity);
        
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
    
    /**
     * This method converts the chosen instantiators to a model for the save method.
     * 
     * @param instantiatorModel The model, which should store the whole information of the chosen instantiators
     * @param container The container of chosen instantiators to be stored
     */
    private void instantiators2Model(Model instantiatorModel, InstantiatorController container) {
        HashSet<FileInstantiator> chosenInstantiators = container.getTransformators();

        /*
         * Only run this method if there is chosen at least one instantiator, otherwise the for loop will throw a
         * nullpointer exception
         */
        if (null != chosenInstantiators) {
            for (FileInstantiator instantiator : chosenInstantiators) {
                Entity entity = instantiator2Entity(instantiator);
                instantiatorModel.addEntity(entity);
            }
        }
    }
    
    /**
     * This method converts an instantiator and all of its data to an entity.
     * 
     * @param instantiator The chosen instantiator to be converted.
     * @return the entity, representing the instantiator
     */
    private Entity instantiator2Entity(FileInstantiator instantiator) {
        Entity entity = new Entity();
        entity.createAttribute(INSTANTIATOR_ENGINE, instantiator.getEngine());
        entity.createAttribute(INSTANTIATOR_UUID, instantiator.getProjectID().toString());
        String paths = instantiator.getPredecessorPath() + INSTANTIATOR_PATH_REGEX + instantiator.getCurrentPath();
        entity.createAttribute(INSTANTIATOR_PATHS, paths);
        // The inheritancechain
        List<String> projects = instantiator.getInheritanceChain();
        String inheritanceAsString = "";
        for (int i = 0; i < projects.size(); i++) {
            inheritanceAsString += projects.get(i) + INSTANTIATOR_PATH_REGEX;
        }
        entity.createAttribute(INSTANTIATOR_INHERITED, inheritanceAsString);
        // The files
        instantiator.setFilesToInstantiate();
        List<File> files = instantiator.getFilesToInstantiatePersistency();
        String filesAsString = "";
        for (File file : files) {
            filesAsString += file.getAbsolutePath() + INSTANTIATOR_PATH_REGEX;
        }
        entity.createAttribute(INSTANTIATOR_FILE, filesAsString);
        return entity;
    }
}
