package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;


import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Section;

import de.uni_hildesheim.sse.easy.ui.productline_editor.AbstractEASyEditorPage;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;

/**
 * Editor for displaying and editing the configuration of the current project.
 * @author El-Sharkawy
 *
 */
public class ConfigurationPage extends AbstractEASyEditorPage {
    private ConfigurationTableEditor configEditor;
    private ConfigurationHeaderMenu configHeaderMenu;
    private FilterMenu filterMenu;
    
    /**
     * Sole constructor for this class.
     * @param plp The {@link ProductLineProject} edited in this editor page.
     * @param parent The parent, holding this editor page
     */
    public ConfigurationPage(ProductLineProject plp, Composite parent) {
        super(plp, "Product Configuration Editor", parent);
        GridData data = new GridData();
        data.heightHint = 600;
        setData(data);

        //Create Menus
        configHeaderMenu = new ConfigurationHeaderMenu(getContentPane(), plp, this);
        Composite filterSection = createSection("Filtering Options",
            "Filters are enabled/disabled by entering criteria",
            Section.TITLE_BAR | Section.TWISTIE | Section.DESCRIPTION, GridData.FILL_HORIZONTAL);
        GridLayout filterLayout = new GridLayout();
        filterLayout.numColumns = 6;
        filterLayout.marginWidth = 2;
        filterLayout.marginHeight = 2;
        filterSection.setLayout(filterLayout);
        filterMenu = new FilterMenu(filterSection, plp);
        
        //Create TreeTable
        configEditor = new ConfigurationTableEditor(plp.getConfiguration(), this);
        
        // Set IGUIContainer
        configHeaderMenu.setGUIConfiguration(configEditor);
        filterMenu.setGUIConfiguration(configEditor);
    }
    
    @Override
    public void refresh() {
        configEditor.refresh();
    }

    @Override
    public final String getPageText() {
        return "IVML Configuration Editor";
    }

    @Override
    protected void pageActivated() {
        refresh();      
        configHeaderMenu.revalidateButtons();       
    }

    @Override
    public void propertyChanged(Object source, int propId) {
        // TODO SE: check whether we need this
        // This is called when the page becomes dirty.
    }

    @Override
    public void close() {
        configEditor.close();
    }
}
