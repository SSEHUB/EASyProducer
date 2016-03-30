/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.ssehub.easy.producer.ui.productline_editor.configuration;


import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.widgets.Section;

import net.ssehub.easy.producer.eclipse.model.ProductLineProject;
import net.ssehub.easy.producer.ui.productline_editor.AbstractEASyEditorPage;

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
        filterMenu.revalidateButtons();
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
