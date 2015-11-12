package de.uni_hildesheim.sse.persistency.xml.loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.persistency.xml.XmlIo;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.messages.IMessage;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.IModelLoader;
import de.uni_hildesheim.sse.utils.modelManagement.ImportResolver;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * Loader for VTL.
 * @author Sass
 *
 */
public class VTLModelLoader implements IModelLoader<Template> {
    
    public static final VTLModelLoader INSTANCE = new VTLModelLoader();
    
    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(VTLModelLoader.class,
            Bundle.ID);

    private List<Template> templates;
    
    /**
     * Prevents external creation.
     */
    private VTLModelLoader() {
    }

    @Override
    public de.uni_hildesheim.sse.utils.modelManagement.IModelLoader.LoadResult<Template> load(
        ModelInfo<Template> info, ImportResolver<Template> resolver) {
        LoadResult<Template> loadResult = null;
        for (Template template : templates) {
            if (info.getName().equals(template.getName()) && Version.equals(info.getVersion(), template.getVersion())) {
                List<Template> templateList = new ArrayList<Template>();
                templateList.add(template);
                loadResult = new LoadResult<Template>(templateList, new ArrayList<IMessage>());
                break;
            }
        }
        return loadResult;
    }

    @Override
    public void scan(File location,
            de.uni_hildesheim.sse.utils.modelManagement.IModelLoader.IModelInfoHolder<Template> holder) {
        if (location.getName().endsWith(".xml")) {
            templates = new ArrayList<Template>();
            try {
                List<IModel> models = XmlIo.read(location, false);
                for (IModel iModel : models) {
                    if (iModel instanceof Template) {
                        Template template = (Template) iModel;
                        templates.add(template);
                        ModelInfo<Template> scriptModel = new ModelInfo<Template>(template, location.toURI(), this);
                        holder.addResult(scriptModel);
                    }
                }
            } catch (FileNotFoundException e) {
                logger.exception(e);
            } catch (IOException e) {
                logger.exception(e);
            }

        }

    }
}