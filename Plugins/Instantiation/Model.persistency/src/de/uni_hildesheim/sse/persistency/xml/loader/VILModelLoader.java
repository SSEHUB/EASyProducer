package de.uni_hildesheim.sse.persistency.xml.loader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.persistency.xml.XmlIo;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.basics.messages.IMessage;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IModelLoader;
import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.instantiation.core.Bundle;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Script;

/**
 * Loader for VIL.
 * 
 * @author Sass
 *
 */
public class VILModelLoader implements IModelLoader<Script> {
    
    public static final VILModelLoader INSTANCE = new VILModelLoader();
    
    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(VILModelLoader.class,
            Bundle.ID);
    
    private List<Script> scripts;
    
    /**
     * Prevents external creation.
     */
    private VILModelLoader() {
    }
    
    @Override
    public net.ssehub.easy.basics.modelManagement.IModelLoader.LoadResult<Script> load(ModelInfo<Script> info, 
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
            net.ssehub.easy.basics.modelManagement.IModelLoader.IModelInfoHolder<Script> holder) {
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
