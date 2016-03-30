package net.ssehub.easy.producer.ui.internal;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PartInitException;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.eclipse.persistency.project_creation.InvalidProjectnameException;
import net.ssehub.easy.producer.eclipse.persistency.project_creation.ProjectAlreadyExistsException;
import net.ssehub.easy.producer.eclipse.persistency.project_creation.ProjectCreator;
import net.ssehub.easy.producer.ui.core.GUIUtils;
import net.ssehub.easy.producer.ui.project_management.EASyJavaConfigurator;

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