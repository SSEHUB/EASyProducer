package loader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.persistency.xml.XmlIo;
import de.uni_hildesheim.sse.utils.messages.IMessage;
import de.uni_hildesheim.sse.utils.modelManagement.IModel;
import de.uni_hildesheim.sse.utils.modelManagement.IModelLoader;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.Version;

/**
 * Loader to load IVML files.
 * 
 * @author Sass
 *
 */
public class IVMLModelLoader implements IModelLoader<Project> {
    
    private List<Project> projects = new ArrayList<Project>();
    
    @Override
    public de.uni_hildesheim.sse.utils.modelManagement.IModelLoader.LoadResult<Project> load(ModelInfo<Project> info) {
        LoadResult<Project> loadResult = null;
        for (Project project : projects) {
            if (info.getName().equals(project.getName()) && Version.equals(info.getVersion(), project.getVersion())) {
                List<Project> projectList = new ArrayList<>();
                projectList.add(project);
                loadResult = new LoadResult<Project>(projectList, new ArrayList<IMessage>());
                break;
            }
        }
        return loadResult;
    }

    @Override
    public void scan(File location,
            de.uni_hildesheim.sse.utils.modelManagement.IModelLoader.IModelInfoHolder<Project> holder) {
        if (location.getName().endsWith(".xml")) {
            FileInputStream in;
            try {
                in = new FileInputStream(location);
                List<IModel> models = XmlIo.read(in);
                for (IModel iModel : models) {
                    if (iModel instanceof Project) {
                        Project project = (Project) iModel;
                        projects.add(project);
                        ModelInfo<Project> projectModel = new ModelInfo<Project>(project, location.toURI(), this);
                        holder.addResult(projectModel);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            
        }
        
    }

}
