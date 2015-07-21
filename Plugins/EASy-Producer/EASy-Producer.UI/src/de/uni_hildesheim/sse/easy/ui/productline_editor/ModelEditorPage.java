/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.easy.ui.productline_editor;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;

import de.uni_hildesheim.sse.dslcore.ui.EditorEmbedderFactory;
import de.uni_hildesheim.sse.dslcore.ui.editors.IEmbeddedEditor;
import de.uni_hildesheim.sse.dslcore.ui.editors.IEmbeddedEditor.IDocumentStateListener;
import de.uni_hildesheim.sse.dslcore.ui.editors.IEmbeddedEditor.IValidationStateListener;
import de.uni_hildesheim.sse.dslcore.ui.editors.ModelEditorConfigurer.IHeader;
import de.uni_hildesheim.sse.dslcore.ui.editors.ModelEditorConfigurer.IModelEditorConfigurer;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;

/**
 * A model editor page for the product line editor which shows an embedded editor.
 * 
 * @author Holger Eichelberger
 */
public class ModelEditorPage extends AbstractEASyEditorPage implements IValidationStateListener, 
    IDocumentStateListener {

    private static final boolean EDITABLE = true; // as long as we have trouble with editor synchronization
    private IEmbeddedEditor editor;
    private String pageTitle;
    private HeaderMenu headerMenu;

    /**
     * Creates a model editor page.
     * 
     * @param plp The {@link ProductLineProject} edited in this editor page.
     * @param configurer the editor configurer
     * @param parent The parent, holding this editor page.
     * @param info the actual model info
     */
    public ModelEditorPage(ProductLineProject plp, IModelEditorConfigurer configurer, Composite parent, 
        ModelInfo<?> info) {
        super(plp, configurer.getEditorTitle(EDITABLE), parent);
        this.pageTitle = configurer.getPageTitle(EDITABLE);
        if (configurer.hasHeader()) {
            headerMenu = new HeaderMenu(getContentPane(), plp, configurer, info);
        }
    }
    
    /**
     * Implements a generic header menu.
     * 
     * @author Holger Eichelberger
     */
    private class HeaderMenu extends AbstractHeaderMenu {
        
        private IHeader header;
        private boolean hasErrors = false;

        /**
         * Creates a generic header menu from the given <code>configurer</code>.
         * 
         * @param parent the parent composite
         * @param plp the product line project being edited
         * @param configurer the configurer
         * @param info the actual model info
         */
        protected HeaderMenu(Composite parent, ProductLineProject plp, IModelEditorConfigurer configurer, 
            ModelInfo<?> info) {
            super(parent, plp);
            header = configurer.createHeader(this, plp.getConfiguration(), plp.getProjectLocation(), info);
        }

        @Override
        public void revalidateButtons() {
            header.revalidateComponents(hasErrors);
        }
        
        @Override
        public void close() {
            header.close();
        }
        
    }
    
    /**
     * Defines the editor.
     * 
     * @param editor the actual viewer containing the editor
     */
    private void setEditor(IEmbeddedEditor editor) {
        this.editor = editor;
    }

    /**
     * Creates the editor page only if the underlying model resource as well as the embedded editor 
     * are available.
     * 
     * @param plp the {@link ProductLineProject} edited in this editor page.
     * @param parent the parent, holding this editor page.
     * @param configurer the editor configurer
     * @param info the model info
     * @return the editor if it was possible to create it, <b>null</b> if not
     */
    public static ModelEditorPage createPage(ProductLineProject plp, Composite parent, 
        IModelEditorConfigurer configurer, ModelInfo<?> info) {
        ModelEditorPage result = null;
        if (null != info && info.isResolved()) {
            result = new ModelEditorPage(plp, configurer, parent, info);
            IEmbeddedEditor editor = EditorEmbedderFactory.embedEditor(info.getLocation(), result.getContentPane());
            if (null != editor) {
                result.setEditor(editor);
                editor.addValidationStateListener(result);
                editor.addDocumentStateListener(result);
                editor.setModelListener(configurer.getModelChangeListener());
                editor.setEditable(EDITABLE);
            } else {
                result = null;
            }
        }
        return result;
    }

    @Override
    public void propertyChanged(Object source, int propId) {
        // This is called when the page becomes dirty.
    }

    @Override
    public String getPageText() {
        return pageTitle;
    }

    @Override
    public void refresh() {
        /*if (null != editor) { // TODO still seems to cause NPEs
            editor.refresh(); 
        }*/
    }

    @Override
    protected void pageActivated() {
        refresh();
        if (null != headerMenu) {
            headerMenu.revalidateButtons();
        }
    }

    @Override
    public void close() {
        if (null != editor) {
            editor.removeValidationStateListener(this);
            editor.removeDocumentStateListener(this);
        }
        if (null != headerMenu) {
            headerMenu.close();
        }
    }

    @Override
    public void notifyValidationState(boolean hasErrors) {
        if (null != headerMenu) {
            headerMenu.hasErrors = hasErrors;
            Display.getDefault().asyncExec(new Runnable() {

                @Override
                public void run() {
                    headerMenu.revalidateButtons();
                }
                
            });
        }
    }

    @Override
    public void notifyDocumentChanged() {
        setDirty();
    }

    @Override
    protected boolean doSave() {
        return editor.doSave();
    }

}
