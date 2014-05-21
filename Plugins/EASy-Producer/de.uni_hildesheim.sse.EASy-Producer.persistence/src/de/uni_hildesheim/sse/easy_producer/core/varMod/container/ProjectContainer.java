package de.uni_hildesheim.sse.easy_producer.core.varMod.container;

import java.io.File;

import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration.PathKind;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;

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
        de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration location) {
        
        this(project, null, location);
    }
    
    /**
     * Constructor if an Exception occurred during parsing the {@link Project}.
     * The {@link Project} can be used but not be saved, as long the semantic error is not solved.
     * @param project The {@link Project}, which should be managed by this container.
     * @param description description A description of an occurred semantic error while parsing the {@link Project}.
     *     Can be <tt>null</tt>, then this constructor has the same behavior as {@link #ProjectContainer(Project)}.
     * @param location The location (folder) of the managed project.
     */
    public ProjectContainer(Project project, SemanticErrorDescription description,
        de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration location) {
        
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
