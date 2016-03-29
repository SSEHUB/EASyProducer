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
package net.ssehub.easy.dslCore.ui.editors;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.jface.text.source.IAnnotationModelListener;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditor;
import org.eclipse.xtext.ui.editor.embedded.EmbeddedEditorModelAccess;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.IXtextDocumentContentObserver;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.validation.XtextAnnotation;
import org.eclipse.xtext.diagnostics.Severity;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.dslCore.ui.Activator;

/**
 * Represents an embedded Xtext editor.
 * 
 * @author Holger Eichelberger
 */
@SuppressWarnings("restriction")
class EmbeddedXtextSourceEditor implements IEmbeddedEditor, IUpdatableEditor {

    private EmbeddedEditor embeddedEditor;
    private XtextSourceViewer viewer;
    private EmbeddedEditorModelAccess partialEditorModelAccess;
    private Map<IValidationStateListener, IAnnotationModelListener> validationStateListeners 
        = new HashMap<IValidationStateListener, IAnnotationModelListener>();
    private Map<IDocumentStateListener, IXtextDocumentContentObserver> documentStateListeners 
        = new HashMap<IDocumentStateListener, IXtextDocumentContentObserver>();
    private AbstractModelChangeListener modelListener;
    private boolean dirty = false;
    private boolean skipNextUpdateEvent = true;
    private IResource resource;
    
    /**
     * Creates an editor representation instance.
     * 
     * @param embeddedEditor the embedded editor
     * @param viewer the underlying source viewer
     * @param partialEditorModelAccess the model access
     * @param requireWorkspaceResource whether the editor requires a workspace resource and shall complain at least in 
     *   the logs or whether it shall be silent
     */
    public EmbeddedXtextSourceEditor(EmbeddedEditor embeddedEditor, XtextSourceViewer viewer, 
        EmbeddedEditorModelAccess partialEditorModelAccess, boolean requireWorkspaceResource) {
        this.embeddedEditor = embeddedEditor;
        this.viewer = viewer;
        this.partialEditorModelAccess = partialEditorModelAccess;

        try {
            URI uri = embeddedEditor.getDocument().getResourceURI();
            java.net.URI netURI = new java.net.URI(uri.toString());
            IFile[] files = ResourcesPlugin.getWorkspace().getRoot().findFilesForLocationURI(netURI);
            if (null != files && files.length > 0) {
                resource = files[0];
            } else {
                if (requireWorkspaceResource) {
                    getLogger().error("No resource for " + uri);
                }
            }
        } catch (URISyntaxException e) {
            getLogger().exception(e);
        }

        viewer.getAnnotationModel().addAnnotationModelListener(new IAnnotationModelListener() {
            
            @Override
            public void modelChanged(IAnnotationModel model) {
                if (!skipNextUpdateEvent) { // loading / updating the model
                    dirty = true;
                }
                skipNextUpdateEvent = false;
            }
        });
    }

    /**
     * Returns the logger of this class.
     * 
     * @return the logger
     */
    private EASyLogger getLogger() {
        return EASyLoggerFactory.INSTANCE.getLogger(getClass(), Activator.PLUGIN_ID);
    }
    
    @Override
    public Viewer getViewer() {
        return viewer;
    }
    
    @Override
    public boolean setContent(String[] content) {
        boolean result = false;
        if (null != content) {
            try {
                // official method is protected but we need it
                Method method = EmbeddedXtextSourceEditor.class.getMethod("setModel", XtextDocument.class, String.class,
                    String.class, String.class);
                method.setAccessible(true);
                method.invoke(partialEditorModelAccess, embeddedEditor.getDocument(), content[0], content[1], 
                    content[2]);
                result = true;
            } catch (NoSuchMethodException e) {
                getLogger().exception(e);
            } catch (IllegalAccessException e) {
                getLogger().exception(e);
            } catch (IllegalArgumentException e) {
                getLogger().exception(e);
            } catch (InvocationTargetException e) {
                getLogger().exception(e);
            }
        }
        return result;
    }

    @Override
    public void refresh() {
        // called by refresh but without annotation model
        viewer.setDocument(viewer.getDocument(), viewer.getAnnotationModel(), -1, -1);
    }

    @Override
    public void addValidationStateListener(IValidationStateListener listener) {
        if (null != listener) {
            IAnnotationModelListener delegatingListener = new ValidationStateListener(listener);
            validationStateListeners.put(listener, delegatingListener);
            viewer.getAnnotationModel().addAnnotationModelListener(delegatingListener);
        }
    }

    @Override
    public void removeValidationStateListener(IValidationStateListener listener) {
        if (null != listener) {
            IAnnotationModelListener delegatingListener =  validationStateListeners.remove(listener);
            if (null != delegatingListener && null != viewer) {
                IAnnotationModel model = viewer.getAnnotationModel();
                if (null != model) {
                    model.removeAnnotationModelListener(delegatingListener);
                }
            }
        }
    }
    
    @Override
    public void addDocumentStateListener(IDocumentStateListener listener) {
        if (null != listener) {
            IXtextDocumentContentObserver delegatingListener = new DocumentContextObserver(listener);
            documentStateListeners.put(listener, delegatingListener);
            embeddedEditor.getDocument().addXtextDocumentContentObserver(delegatingListener);
        }
    }

    @Override
    public void removeDocumentStateListener(IDocumentStateListener listener) {
        if (null != listener) {
            IXtextDocumentContentObserver delegatingListener =  documentStateListeners.remove(listener);
            if (null != delegatingListener && null != embeddedEditor) {
                XtextDocument doc = embeddedEditor.getDocument();
                if (null != doc) {
                    doc.removeXtextDocumentContentObserver(delegatingListener);
                }
            }
        }
    }

    @Override
    public void setModelListener(AbstractModelChangeListener modelListener) {
        this.modelListener = modelListener;
        if (null != this.modelListener) {
            this.modelListener.register(this);
        }
    }
    
    /**
     * Implements a delegating validation state listener.
     * 
     * @author Holger Eichelberger
     */
    private class ValidationStateListener implements IAnnotationModelListener {

        private IValidationStateListener listener;
        
        /**
         * Creates a validate state listener.
         * 
         * @param listener the external listener to inform about changes in the validation state
         */
        private ValidationStateListener(IValidationStateListener listener) {
            this.listener = listener;
        }
        
        @Override
        public void modelChanged(IAnnotationModel model) {
            boolean hasErrors = false;
            @SuppressWarnings("rawtypes")
            Iterator iter = model.getAnnotationIterator();
            while (!hasErrors && null != iter && iter.hasNext()) {
                Object tmp = iter.next();
                if (tmp instanceof XtextAnnotation) {
                    XtextAnnotation annotation = (XtextAnnotation) tmp;
                    hasErrors = (Severity.ERROR == annotation.getIssue().getSeverity());
                }
            }
            listener.notifyValidationState(hasErrors);
        }
        
    }
    
    /**
     * Implements a delegating document context observer.
     * 
     * @author Holger Eichelberger
     */
    private static class DocumentContextObserver implements IXtextDocumentContentObserver {
        
        private IDocumentStateListener listener;

        /**
         * Creates a document state listener.
         * 
         * @param listener the external listener to inform about changes in the validation state
         */        
        private DocumentContextObserver(IDocumentStateListener listener) {
            this.listener = listener;
        }

        @Override
        public void documentChanged(DocumentEvent event) {
            listener.notifyDocumentChanged();
        }

        @Override
        public void documentAboutToBeChanged(DocumentEvent event) {
        }

        @Override
        public boolean performNecessaryUpdates(Processor processor) {
            // TODO Auto-generated method stub
            return false;
        }

        @Override
        public boolean hasPendingUpdates() {
            // TODO Auto-generated method stub
            return false;
        }
    }
    
    @Override
    public String getEditableContent() {
        return partialEditorModelAccess.getEditablePart();
    }
    
    @Override
    public String getContent() {
        return partialEditorModelAccess.getSerializedModel();
    }

    @Override
    public boolean doSave() {
        boolean saved = false;
        if (dirty) {
            URI uri = embeddedEditor.getDocument().getResourceURI();
            if (uri.isFile()) {
                File file = new File(uri.toFileString());
                Writer out = null;
                try {
                    out = new BufferedWriter(new FileWriter(file));
                    out.write(partialEditorModelAccess.getSerializedModel());
                    out.close();
                    saved = true;
                    if (null != modelListener) {
                        modelListener.buildModel(embeddedEditor.getDocument());
                    }
                } catch (IOException e ) {
                    if (null != out) {
                        try {
                            out.close();
                        } catch (IOException e1) {
                        }
                    }
                    getLogger().exception(e);
                }
            }
        }
        return saved;
    }

    @Override
    public void updateEditor() {
        skipNextUpdateEvent = true;
        embeddedEditor.getViewer().refresh();
    }

    @Override
    public IResource getResource() {
        return resource;
    }

    @Override
    public void buildModel(IXtextDocument doc) {
        skipNextUpdateEvent = true;
        embeddedEditor.getViewer().setDocument(doc);
    }

    @Override
    public void setEditable(boolean editable) {
        viewer.setEditable(editable);
    }

}