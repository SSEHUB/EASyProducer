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
package de.uni_hildesheim.sse.dslcore.ui.editors;

import org.eclipse.jface.viewers.Viewer;

/**
 * Represents an embedded editor.
 * 
 * @author Holger Eichelberger
 */
public interface IEmbeddedEditor {

    /**
     * Informs interested parties about the actual validation state of the editor.
     * 
     * @author Holger Eichelberger
     */
    public interface IValidationStateListener {

        /**
         * Notifies about a validation state change.
         * 
         * @param hasErrors <code>true</code> if the document validation indicates errors, <code>false</code> in case 
         *     of no errors
         */
        public void notifyValidationState(boolean hasErrors);
        
    }
    
    /**
     * Informs interested parties about actual document changes.
     * 
     * @author Holger Eichelberger
     */
    public interface IDocumentStateListener {

        /**
         * Notifies about a changed document.
         */
        public void notifyDocumentChanged();
        
    }
    
    /**
     * Returns the actual viewer implementing the editor.
     * 
     * @return the actiall viewer
     */
    public Viewer getViewer();
    
    /**
     * Changes the content of the embedded editor.
     * 
     * @param content the actual editable content in terms of prefix not to be shown [0], content to be displayed [1] 
     *   and postfix not to be shown[2]
     * @return whether the operation was successful (<code>true</code>) or not (<code>false</code>)
     */
    public boolean setContent(String[] content);
    
    /**
     * Refreshes the editor.
     */
    public void refresh();
    
    /**
     * Adds a validation state listener.
     * 
     * @param listener the listener to be added
     */
    public void addValidationStateListener(IValidationStateListener listener);
    
    /**
     * Removes the given validation state listener.
     * 
     * @param listener the listener to be removed
     */
    public void removeValidationStateListener(IValidationStateListener listener);

    /**
     * Adds a document state listener.
     * 
     * @param listener the listener to be added
     */
    public void addDocumentStateListener(IDocumentStateListener listener);
    
    /**
     * Removes the given document state listener.
     * 
     * @param listener the listener to be removed
     */
    public void removeDocumentStateListener(IDocumentStateListener listener);
 
    /**
     * Save the editor content to the original resource if content changed.
     * 
     * @return <code>true</code> if the content was saved, <code>false</code> else
     */
    public boolean doSave();
    
    /**
     * Defines the model listener being called in {@link #doSave()}.
     * 
     * @param modelListener the model listener (<b>null</b> for ignore it)
     */
    public void setModelListener(AbstractModelChangeListener modelListener);

    /**
     * Returns the editable content in this editor.
     * 
     * @return the editable content
     */
    public String getEditableContent();
    
    /**
     * Returns the full content of the editor, including potential context such as prefix and postfix.
     * 
     * @return the full content
     */
    public String getContent();

    /**
     * Changes whether the editor is enabled for editing.
     * 
     * @param editable <code>true</code> if editing is enabled, <code>false</code> if only viewing is supported
     */
    public void setEditable(boolean editable);
}