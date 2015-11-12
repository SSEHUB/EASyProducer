package de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.serializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.rtVil.Script;
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
 * Loader for RTVIL.
 * 
 * @author Sass
 *
 */
public class RTVILModelLoader implements IModelLoader<Script> {

    public static final RTVILModelLoader INSTANCE = new RTVILModelLoader();
    
    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(RTVILModelLoader.class,
            Bundle.ID);
    
    private List<Script> scripts;
    

    /**
     * Prevents external creation.
     */
    private RTVILModelLoader() {
    }
    
    @Override
    public de.uni_hildesheim.sse.utils.modelManagement.IModelLoader.LoadResult<Script> load(ModelInfo<Script> info, 
        ImportResolver<Script> resolver) {
        LoadResult<Script> loadResult = null;
        for (Script script : scripts) {
            if (info.getName().equals(script.getName()) && Version.equals(info.getVersion(), script.getVersion())) {
                List<Script> scriptList = new ArrayList<Script>();
                scriptList.add(script);
                loadResult = new LoadResult<Script>(scriptList, new ArrayList<IMessage>());
                break;
            }
        }
        return loadResult;
    }

    @Override
    public void scan(File location,
            de.uni_hildesheim.sse.utils.modelManagement.IModelLoader.IModelInfoHolder<Script> holder) {
        if (location.getName().endsWith(".xml")) {
            scripts = new ArrayList<Script>();
            try {
                List<IModel> models = XmlIo.read(location, false);
                for (IModel iModel : models) {
                    if (iModel instanceof Script) {
                        Script script = (Script) iModel;
                        scripts.add(script);
                        ModelInfo<Script> scriptModel = new ModelInfo<Script>(script, location.toURI(), this);
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
