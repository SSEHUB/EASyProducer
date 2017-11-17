package net.ssehub.easy.instantiation.serializer.xml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;
import net.ssehub.easy.instantiation.core.model.templateModel.Template;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * This class offers the methods for the serialization of the model.
 * 
 * @author Sass
 * 
 */
@Instantiator("serializeModel")
public class ModelSerializer implements IVilType {

    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(ModelSerializer.class,
            Bundle.ID);
    
    protected static final ProgressObserver OBSERVER = ProgressObserver.NO_OBSERVER;

    private static final String[] VTL_FILTER = {"vtl" };

    private static final String[] VIL_FILTER = {"vil" };
    
    private static final String[] IVML_FILTER = {"ivml" };
    
    /**
     * Serialization of the model to XML file.
     * 
     * @param source
     *            the source folder of the model
     * @param target
     *            the target XML file
     */
    public static void serializeModel(Path source, Path target) {
        // Get all model files from the file system
        Collection<File> vtlFiles = FileUtils.listFiles(source.toFile(), VTL_FILTER, true);
        Collection<File> vilFiles = FileUtils.listFiles(source.toFile(), VIL_FILTER, true);
        Collection<File> ivmlFiles = FileUtils.listFiles(source.toFile(), IVML_FILTER, true);
        List<IModel> modelList = new ArrayList<IModel>();
        List<IModel> ivmlModelList = new ArrayList<IModel>();
        // Load all IVML files
        for (File file : ivmlFiles) {
            ModelInfo<Project> foundProject = VarModel.INSTANCE.availableModels().getInfo(file.toURI());
            try {
                if (null != foundProject) {
                    VarModel.INSTANCE.load(foundProject);
                    Project project = foundProject.getResolved();
                    ivmlModelList.add(project);
                }
            } catch (ModelManagementException e) {
                logger.exception(e);
            }
        }
        // Load all VTL files
        for (File file : vtlFiles) {
            ModelInfo<Template> foundTemplate = TemplateModel.INSTANCE.availableModels().getInfo(file.toURI());
            try {
                if (null != foundTemplate) {
                    TemplateModel.INSTANCE.load(foundTemplate);
                    Template template = foundTemplate.getResolved();
                    modelList.add(template);
                }
            } catch (ModelManagementException e) {
                logger.exception(e);
            }
        }
        // Load all VIL files
        for (File file : vilFiles) {
            ModelInfo<Script> foundScript = BuildModel.INSTANCE.availableModels().getInfo(file.toURI());
            try {
                if (null != foundScript) {
                    BuildModel.INSTANCE.load(foundScript);
                    Script script = foundScript.getResolved();
                    modelList.add(script);
                }
            } catch (ModelManagementException e) {
                logger.exception(e);
            }
        }
        // Load RTVIL files
        for (ISerializerPlugin<?> plugin : Extensions.getPluginList()) {
            plugin.serialize(source.toFile(), modelList);
        }
        // Define XML files
        String ivmlFileName = target.toString().replaceAll(".xml", "ivml.xml");
        File ivmlFile = new File(ivmlFileName);
        // Write model to XML file
        try {
            XmlIo.write(modelList, target.toFile(), false);
            XmlIo.write(ivmlModelList, ivmlFile, true);
        } catch (FileNotFoundException e) {
            logger.exception(e);
        } catch (IOException e) {
            logger.exception(e);
        }
    }

}
