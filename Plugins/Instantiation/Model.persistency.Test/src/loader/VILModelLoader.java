package loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.buildlangModel.Script;
import de.uni_hildesheim.sse.persistency.xml.XmlIo;
import de.uni_hildesheim.sse.utils.messages.IMessage;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.IModelLoader;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * Loader for VIL.
 * 
 * @author Sass
 *
 */
public class VILModelLoader implements IModelLoader<Script> {
    
    private List<Script> scripts = new ArrayList<Script>();
    
    @Override
    public de.uni_hildesheim.sse.utils.modelManagement.IModelLoader.LoadResult<Script> load(ModelInfo<Script> info) {
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
            FileInputStream in;
            try {
                in = new FileInputStream(location);
                List<IModel> models = XmlIo.read(in);
                for (IModel iModel : models) {
                    if (iModel instanceof Script) {
                        Script script = (Script) iModel;
                        scripts.add(script);
                        ModelInfo<Script> scriptModel = new ModelInfo<Script>(script, location.toURI(), this);
                        holder.addResult(scriptModel);
                    }
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
    }

}
