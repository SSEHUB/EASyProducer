package de.uni_hildesheim.sse.easy.ui.internal;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;

import de.uni_hildesheim.sse.easy.ui.core.GUIUtils;
import de.uni_hildesheim.sse.easy.ui.project_management.EASyJavaConfigurator;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.easy_producer.persistency.project_creation.InvalidProjectnameException;
import de.uni_hildesheim.sse.easy_producer.persistency.project_creation.ProjectAlreadyExistsException;
import de.uni_hildesheim.sse.easy_producer.persistency.project_creation.ProjectCreator;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * Wizard for the creation of a new productline project. Creates project, subfolders and files.
 * 
 * @author El-Sharkawy
 * @author Ahrens
 */
public class NewEASyProjectWizard extends Wizard implements INewWizard {
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(NewEASyProjectWizard.class,
        Activator.PLUGIN_ID);

    private NewEASyProjectWizardPage page;

    /**
     * Constructor for PLuginNewWizard.
     */
    public NewEASyProjectWizard() {
        super();
        setNeedsProgressMonitor(false);
    }

    /**
     * Adding the page to the wizard.
     */
    public void addPages() {
        page = new NewEASyProjectWizardPage();
        addPage(page);
    }

    @Override
    public boolean performFinish() {
        boolean successful = true;
 
        try {
            ProjectCreator pc = new ProjectCreator(page.getProjectName());
            ProductLineProject newPLP = pc.newPLP(new EASyJavaConfigurator());
            GUIUtils.openProductLineEditor(newPLP);
        } catch (ProjectAlreadyExistsException e) {
            successful = false;
        } catch (InvalidProjectnameException e) {
            successful = false;
        } catch (PartInitException e) {
            LOGGER.exception(e);
        }
        return successful;
    }
    
    /**
     * {@inheritDoc}
     */
    public void init(IWorkbench workbench, IStructuredSelection selection) {
        // Method from INewWizard, but not needed.
    }
}