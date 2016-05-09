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
package net.ssehub.easy.basics.modelManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A set of algorithms to enable recursive model updates along the imports.
 * This implementation is initial as it rebuilds the importing model structure 
 * (to be turned into an incremental version later).
 *  
 * @author Holger Eichelberger
 */
class ModelUpdateUtils {

    /**
     * Collects all importing models.
     * 
     * @param <M> the type of model
     * @param models the models to be considered
     * @return all importing models, key is model, value is importing models
     */
    static <M extends IModel> Map<M, List<M>> collectImporting(List<M> models) {
        Map<M, List<M>> result = new HashMap<M, List<M>>();
        for (int m = 0; m < models.size(); m++) {
            M model = models.get(m);
            if (null != model) {
                for (int i = 0; i < model.getImportsCount(); i++) {
                    @SuppressWarnings("unchecked")
                    M imported = (M) model.getImport(i).getResolved();
                    if (null != imported) {
                        List<M> importing = result.get(imported);
                        if (null == importing) {
                            importing = new ArrayList<M>();
                            result.put(imported, importing);
                        }
                        importing.add(model);
                    }
                }
            }
        }
        return result;
    }
    
    /**
     * Determines the update sequence for <code>model</code> based on the importing models in <code>using</code>.
     * This method follows all imports and gives the imported model a sequence number. Revisited models receive
     * a higher number in order to be later in sequence.
     *
     * @param <M> the type of model
     * @param model the model to determine the update sequence for 
     * @param using the actual importing models
     * @return the update sequence (may contain <b>null</b> in case of models shifted in sequence)
     */
    static <M extends IModel> List<M> determineUpdateSeqence(M model, Map<M, List<M>> using) {
        List<M> result = new ArrayList<M>();
        Map<M, Integer> updateSequence = new HashMap<M, Integer>();
        int max = followImporting(model, using, updateSequence, 0, new HashSet<M>());
        while (result.size() < max) {
            result.add(null);
        }
        for (Map.Entry<M, Integer> entry : updateSequence.entrySet()) {
            result.set(entry.getValue(), entry.getKey());
        }
        return result;
    }

    /**
     * Recursively follows the importing models provided by <code>using</code> from <code>model</code>
     * and enumerates them from <code>start</code>. Revisited models receive a higher number and, thus,
     * will be later in the update sequence.
     *  
     * @param <M> the type of model
     * @param model the model to start the recursive traversal
     * @param using the actual importing models
     * @param sequence the importing models and their assigned sequence number
     * @param start the start sequence number
     * @param done already processed models - cycle prevention
     * @return the updated start sequence number
     */
    private static <M extends IModel> int followImporting(M model, Map<M, List<M>> using, Map<M, Integer> sequence, 
        int start, Set<M> done) {
        if (!done.contains(model)) { // prevent cycles
            done.add(model);
            List<M> importing = using.get(model);
            if (null != importing) {
                for (int i = 0; i < importing.size(); i++) {
                    M tmp = importing.get(i);
                    if (tmp != model) { // prevent further cycles
                        sequence.put(tmp, start++);
                        start = followImporting(tmp, using, sequence, start, done);
                    }
                }
            }
        }
        return start;
    }
    
}
