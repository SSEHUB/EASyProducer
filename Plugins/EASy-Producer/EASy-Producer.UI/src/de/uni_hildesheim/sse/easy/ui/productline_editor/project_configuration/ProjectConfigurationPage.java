package de.uni_hildesheim.sse.easy.ui.productline_editor.project_configuration;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Section;

import de.uni_hildesheim.sse.easy.ui.productline_editor.AbstractEASyEditorPage;
import de.uni_hildesheim.sse.easy.ui.productline_editor.EditorConstants;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;

/**
 * Page for editing the current project. Possible actions are:
 * <ul>
 * <li>Validating the variability model (not the configuration).</li>
 * <li>Pulling the information form predecessor projects (variability model, configuration, instantiators, ...).</li>
 * <li>Adding/Deleting Predecessor projects.</li>
 * <li>Derive new PL members.</li>
 * </ul>
 * @author El-Sharkawy
 *
 */
public class ProjectConfigurationPage extends AbstractEASyEditorPage {

    private ProductLineHeaderMenu plHeaderMenu;
    private CopyCombobox copyComboMenu;
    private ReasonerSettings reasonerSettings;
    private ModelCombobox modelSelection;
   
    /**
     * Sole constructor for this class.
     * 
     * @param plp The ProductLineProject which will be edited
     * @param parent the parent control
     */
    public ProjectConfigurationPage(ProductLineProject plp, Composite parent) {
        super(plp, EditorConstants.PROJECT_SETTINGS_PAGE, parent);
        plHeaderMenu = new ProductLineHeaderMenu(getContentPane(), plp, this);
        
        // The section will be folded
        Composite pnlAdvanced = createSection("Advanced Settings", "Advanced projects settings for this project"
            + " (will not be inherited to further product line members).",
            Section.TITLE_BAR | Section.TWISTIE | Section.DESCRIPTION, GridData.FILL_HORIZONTAL);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        pnlAdvanced.setLayout(layout);
        
        Composite pnlModelSelection = createSection("Model Selection", "Model settings for this project.", 
            GridData.FILL_HORIZONTAL);
        layout = new GridLayout();
        layout.numColumns = 3;
        pnlModelSelection.setLayout(layout);
        
        modelSelection = new ModelCombobox(pnlModelSelection, this.getProductLineProject(), this);
        
        copyComboMenu = new CopyCombobox(pnlAdvanced, plp.getCopyModel(), this);
        reasonerSettings = new ReasonerSettings(pnlAdvanced, plp.getReasonerConfig(), this);
    }
    
    @Override
    public void propertyChanged(Object source, int propId) {
        // No action needed
    }

    @Override
    public void refresh() {
        plHeaderMenu.revalidateButtons(); 
        copyComboMenu.refresh();
        reasonerSettings.refresh();
        modelSelection.refresh();
    }

    @Override
    public String getPageText() {
        return EditorConstants.PROJECT_SETTINGS_PAGE;
    }

    @Override
    protected void pageActivated() {
        refresh();
    }

    @Override
    public void close() {
        // No action needed
    }

}
