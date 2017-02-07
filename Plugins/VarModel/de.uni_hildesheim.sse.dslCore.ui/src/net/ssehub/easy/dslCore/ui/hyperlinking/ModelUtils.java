/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.dslCore.ui.hyperlinking;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.ModelImport;
import net.ssehub.easy.basics.modelManagement.ModelManagement;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.Version;
import net.ssehub.easy.basics.modelManagement.VersionedModelInfos;
import net.ssehub.easy.dslCore.BundleId;

/**
 * Some utilities on model side.
 * 
 * @author Holger Eichelberger
 */
public class ModelUtils {

    private static final Comparator<VersionedModelInfos<?>> DESC_VERSION_COMPARATOR 
        = new Comparator<VersionedModelInfos<?>>() {

            @Override
            public int compare(VersionedModelInfos<?> o1, VersionedModelInfos<?> o2) {
                return -Version.compare(o1.getVersion(), o2.getVersion());
            }
        
        };
    
    /**
     * A model finder for a certain model. Model imports are handled by caller.
     * 
     * @param <M> the model type
     * @param <E> the model element type
     * @author Holger Eichelberger
     */
    public interface IModelFinder<M extends IModel, E> {
        
        /**
         * Tries to find an element declaration for <code>name</code>.
         * 
         * @param model the model
         * @param name the name to search for
         * @return the declaration or <b>null</b>
         */
        public E findElement(M model, String name);
        
    }

    /**
     * Tries to find a model element declaration for a given element name and a given project/model name. Handles
     * imports.
     * 
     * @param <E> the model element type
     * @param <M> the model type
     *
     * @param selectedElement the element name
     * @param selectedElementsProjectName the project/model name
     * @param mgt the model management instance
     * @param finder the element finder
     * @return the declaration or <b>null</b>
     */
    public static <M extends IModel, E> E getModelElement(String selectedElement, String selectedElementsProjectName, 
        ModelManagement<M> mgt, IModelFinder<M, E> finder) {
        E modelElement = null;
        if (selectedElement != null && !selectedElement.isEmpty() && selectedElementsProjectName != null
                && !selectedElementsProjectName.isEmpty()) {
            int modelCount = mgt.getModelCount();
            int modelCounter = 0;
            while (modelElement == null && modelCounter < modelCount) {
                if (mgt.getModel(modelCounter).getName().equals(selectedElementsProjectName)) {
                    Set<M> done = new HashSet<M>();
                    modelElement = findElement(mgt.getModel(modelCounter), selectedElement, finder, done);
                }
                modelCounter++;
            }
            if (0 == modelCounter && !mgt.getAvailable(selectedElementsProjectName).isEmpty()) {
                List<VersionedModelInfos<M>> available = mgt.getAvailable(selectedElementsProjectName);
                if (null != available && !available.isEmpty()) {
                    // heuristic
                    Collections.sort(available, DESC_VERSION_COMPARATOR);
                    VersionedModelInfos<M> infos = available.get(0);
                    if (infos.size() > 0) {
                        Set<M> done = new HashSet<M>();
                        try {
                            modelElement = findElement(mgt.load(infos.get(0)), selectedElement, finder, done);
                        } catch (ModelManagementException e) {
                            EASyLoggerFactory.INSTANCE.getLogger(ModelUtils.class, BundleId.ID).error(e.getMessage());
                        }
                    }
                }
            }
        }
        return modelElement;
    }
    
    /**
     * Recursively finds an element also in the imports if not found in <code>model</code>.
     * 
     * @param <E> the model element type
     * @param <M> the model type
     * 
     * @param model the model to search within
     * @param selectedElement the element name
     * @param finder the element finder
     * @param done already visited models for avoiding loops
     * @return the found element or <b>null</b>
     */
    @SuppressWarnings("unchecked")
    private static <M extends IModel, E> E findElement(M model, String selectedElement, IModelFinder<M, E> finder, 
        Set<M> done) {
        E result = null;
        if (!done.contains(model)) {
            done.add(model);
            result = finder.findElement(model, selectedElement);
            if (null == result) {
                for (int i = 0; null == result && i < model.getImportsCount(); i++) {
                    ModelImport<?> imp = model.getImport(i);
                    if (null != imp.getResolved()) {
                        result = findElement((M) imp.getResolved(), selectedElement, finder, done);
                    }
                }
            }
        }
        return result;
    }
    
}
