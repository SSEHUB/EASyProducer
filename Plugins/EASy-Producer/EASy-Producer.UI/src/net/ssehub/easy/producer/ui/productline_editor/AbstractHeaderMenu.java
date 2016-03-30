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
package net.ssehub.easy.producer.ui.productline_editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import net.ssehub.easy.producer.eclipse.model.ProductLineProject;

/**
 * Abstract super class for header menus (buttons), which are parts different editor pages.
 * @author El-Sharkawy
 *
 */
public abstract class AbstractHeaderMenu extends Composite {
    private ProductLineProject plp;

    /**
     * Sole constructor for this class.
     * @param parent The parent holding this menu.
     * @param plp The current edited {@link ProductLineProject}
     */
    protected AbstractHeaderMenu(Composite parent, ProductLineProject plp) {
        super(parent, SWT.NONE);
        this.plp = plp;
        setBackground(parent.getBackground());
        setLayout();
    }
    
    /**
     * Sets the Layout for this Composite.
     */
    protected void setLayout() {
        GridLayout headerButtonCompositeLayout = new GridLayout();
        setLayout(headerButtonCompositeLayout);
        headerButtonCompositeLayout.numColumns = 4;
    }
    
    /**
     * Returns the current edited {@link ProductLineProject}.
     * @return The current edited {@link ProductLineProject}
     */
    protected final ProductLineProject getProductLineProject() {
        return plp;
    }
    
    /**
     * Enables or disables the buttons, depending on whether a the related action is possible.
     * This check should be performed whenever the page becomes activated.
     */
    public abstract void revalidateButtons();
    
    /**
     * Closes the header menu.
     */
    public void close() {
    }
    
}
