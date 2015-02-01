package loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel.Template;
import de.uni_hildesheim.sse.persistency.xml.XmlIo;
import de.uni_hildesheim.sse.utils.messages.IMessage;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.IModelLoader;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * Loader for VTL.
 * @author Sass
 *
 */
public class VTLModelLoader implements IModelLoader<Template> {

    private List<Template> templates = new ArrayList<Template>();

    @Override
    public de.uni_hildesheim.sse.utils.modelManagement.IModelLoader.LoadResult<Template> load(
        ModelInfo<Template> info) {
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
            FileInputStream in;
            try {
                in = new FileInputStream(location);
                List<IModel> models = XmlIo.read(in);
                for (IModel iModel : models) {
                    if (iModel instanceof Template) {
                        Template template = (Template) iModel;
                        templates.add(template);
                        ModelInfo<Template> scriptModel = new ModelInfo<Template>(template, location.toURI(), this);
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
