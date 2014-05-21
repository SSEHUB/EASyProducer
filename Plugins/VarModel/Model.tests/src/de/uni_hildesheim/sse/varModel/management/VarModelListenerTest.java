package de.uni_hildesheim.sse.varModel.management;

import java.io.File;
import java.net.URI;

import org.junit.Assert;
import org.junit.Test;

import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.IProjectListener;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.BooleanType;

/**
 * Emulates the use of the {@link VarModel} and the {@link IProjectListener} from
 * EaSY-Producer.
 * 
 * @author Holger Eichelberger
 */
public class VarModelListenerTest implements IProjectListener {

    private static final String PROJECT_NAME = "myProject";
    private static final URI PROJECT_URI = new File("./1.ivml").toURI();

    private Project project;
    
    /**
     * Tests the listener functionality.
     */
    @Test
    public void testListener() {
        // as done in EaSY
        initialize();
        // ADD
        emulateEditor();
        // REPLACE
        emulateEditor();
    }
    
    /**
     * Emulates the editor by creating a new project.
     */
    private void emulateEditor() {
        Project newProject = createProject();
        newProject.add(new DecisionVariableDeclaration("var", BooleanType.TYPE, newProject));
        VarModel.INSTANCE.updateModel(newProject, PROJECT_URI);
        Assert.assertTrue(project == newProject);
    }

    /**
     * Factory method for project instances.
     * 
     * @return the created project
     */
    private static Project createProject() {
        Project project = new Project(PROJECT_NAME);
        //project.setVersion(new Version( 0 ));
        return project;
    }
    
    /**
     * Initializes the project. Simplified version from EasY.
     */
    private void initialize() {
        Project project = createProject();
        VarModel.INSTANCE.updateModel(project, PROJECT_URI); // @SE this is missing
        setProject(project);
    }

    /**
     * Changes the current project project. From EaSY.
     * 
     * @param project the project to be stored
     */
    private void setProject(Project project) {
        if (null == this.project) {
            VarModel.INSTANCE.events().addModelListener(project, this);
        }
        this.project = project;
    }

    /**
     * {@inheritDoc}
     */
    public void notifyReplaced(Project oldProject, Project newProject) {
        setProject(newProject);
    }
    
}
