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
import net.ssehub.easy.varModel.model.Project;

/**
 * Loader to load IVML files.
 * 
 * @author Sass
 *
 */
public class IVMLModelLoader implements IModelLoader<Project> {
    
    public static final IVMLModelLoader INSTANCE = new IVMLModelLoader();

    protected static EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(IVMLModelLoader.class,
            Bundle.ID);
    
    private List<Project> projects;
    
    /**
     * Prevents external creation.
     */
    private IVMLModelLoader() {
    }
    
    @Override
    public net.ssehub.easy.basics.modelManagement.IModelLoader.LoadResult<Project> load(ModelInfo<Project> info, 
        ImportResolver<Project> resolver) {
        LoadResult<Project> loadResult = null;
        for (Project project : projects) {
            if (info.getName().equals(project.getName()) && Version.equals(info.getVersion(), project.getVersion())) {
                List<Project> projectList = new ArrayList<Project>();
                projectList.add(project);
                loadResult = new LoadResult<Project>(projectList, new ArrayList<IMessage>());
                break;
            }
        }
        return loadResult;
    }

    @Override
    public void scan(File location,
            net.ssehub.easy.basics.modelManagement.IModelLoader.IModelInfoHolder<Project> holder) {
        if (location.getName().endsWith(".xml")) {
            projects = new ArrayList<Project>();
            try {
                List<IModel> models = XmlIo.read(location, true);
                for (IModel iModel : models) {
                    if (iModel instanceof Project) {
                        Project project = (Project) iModel;
                        projects.add(project);
                        ModelInfo<Project> projectModel = new ModelInfo<Project>(project, location.toURI(), this);
                        holder.addResult(projectModel);
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
