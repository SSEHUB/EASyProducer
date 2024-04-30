package net.ssehub.easy.producer.core.varMod.container;

import java.io.File;

import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.management.VarModel;
import net.ssehub.easy.varModel.model.Project;

/**
 * {@link ModelContainer} for holding a Project and its configuration.
 * @author El-Sharkawy
 *
 */
public class ProjectContainer extends ModelContainer<Project> {

    private Configuration config;
    
    /**
     * Default constructor for a created of loaded {@link Project}.
     * @param project A valid project, which shall be managed by this {@link ModelContainer}.
     * @param location The location (folder) of the managed project.
     */
    public ProjectContainer(Project project,
        net.ssehub.easy.producer.core.persistence.Configuration location) {
        
        this(project, null, location);
    }
    
    /**
     * Constructor if an Exception occurred during parsing the {@link Project}.
     * The {@link Project} can be used but not be saved, as long the semantic error is not solved.
     * @param project The {@link Project}, which should be managed by this container.
     * @param description description A description of an occurred semantic error while parsing the {@link Project}.
     *     Can be <code>null</code>.
     * @param location The location (folder) of the managed project.
     */
    public ProjectContainer(Project project, SemanticErrorDescription description,
        net.ssehub.easy.producer.core.persistence.Configuration location) {
        
        super(project, description, VarModel.INSTANCE, location);
        VarModel.INSTANCE.events().addModelListener(project, this);
        config = new Configuration(project);
    }
    
    /**
     * {@inheritDoc}
     */
    public void notifyReplaced(Project oldProject, Project newProject) {
        super.notifyReplaced(oldProject, newProject);
        config.notifyReplaced(oldProject, newProject);
    }
    
    /**
     * Returns the configuration related to the stored {@link Project}.
     * @return the configuration related to the stored {@link Project}.
     * @see #getModel()
     */
    public Configuration getConfiguration() {
        return config;
    }
    
    @Override
    public void setMainModel(ModelInfo<Project> newMainModel) {
        Project oldModel = getModel();
        
        super.setMainModel(newMainModel);
        
        if (null != newMainModel.getResolved()) {
            notifyReplaced(oldModel, newMainModel.getResolved());
            getConfiguration().notifyReplaced(oldModel, newMainModel.getResolved());              
        }
    }

    @Override
    public File getLocation() {
        return getLocation(PathKind.IVML);
    }
}
