package de.uni_hildesheim.sse.persistency.xml;

import java.io.File;
import java.nio.file.Path;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.BuildModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.TemplateModel;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Invisible;
import de.uni_hildesheim.sse.persistency.xml.loader.IVMLModelLoader;
import de.uni_hildesheim.sse.persistency.xml.loader.VILModelLoader;
import de.uni_hildesheim.sse.persistency.xml.loader.VTLModelLoader;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.varModel.management.VarModel;

/**
 * This class offers the methods for the deserialization of the model.
 * 
 * @author Sass
 * 
 */
@Instantiator("deserializeModel")
public class ModelDeserializer implements IVilType {

    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(ModelDeserializer.class,
            Bundle.ID);
    
    protected static final ProgressObserver OBSERVER = ProgressObserver.NO_OBSERVER;

    /**
     * Deserializes the model from a XML file.
     * 
     * @param xmlFile 
     */
    public static void deserializeModel(Path xmlFile) {
        try {
            String ivmlXmlFileName = xmlFile.toString().replaceAll(".xml", "ivml.xml");
            File ivmlXml = new File(ivmlXmlFileName);
            VarModel.INSTANCE.loaders().registerLoader(IVMLModelLoader.INSTANCE, OBSERVER);
            VarModel.INSTANCE.locations().addLocation(ivmlXml, OBSERVER);
            BuildModel.INSTANCE.loaders().registerLoader(VILModelLoader.INSTANCE, OBSERVER);
            BuildModel.INSTANCE.locations().addLocation(xmlFile.toFile(), OBSERVER);
            TemplateModel.INSTANCE.loaders().registerLoader(VTLModelLoader.INSTANCE, OBSERVER);
            TemplateModel.INSTANCE.locations().addLocation(xmlFile.toFile(), OBSERVER);
            for (ISerializerPlugin<?> plugin : Extensions.getPluginList()) {
                plugin.deserialize(xmlFile.toFile());
            }
        } catch (ModelManagementException e1) {
            logger.exception(e1);
        }
    }

    /**
     * Deserializes the model from a XML file.
     * 
     * @param xmlFile
     *            xml file of model
     */
    @Invisible
    public static void deserializeModel(File xmlFile) {
        deserializeModel(xmlFile.toPath());
    }

}
