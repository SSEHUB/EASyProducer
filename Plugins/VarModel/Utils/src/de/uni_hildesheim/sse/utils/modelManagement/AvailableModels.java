/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
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

package de.uni_hildesheim.sse.utils.modelManagement;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Stores information about available models, i.e., the relation between model
 * names and all available model information objects. This class provides several
 * methods to query model information objects.
 * 
 * @param <M> the specific type of model
 * 
 * @author Holger Eichelberger
 */
public class AvailableModels<M extends IModel> {

    private IModelManagementRepository<M> repository;
    private Map<String, List<VersionedModelInfos<M>>> availableModels 
        = new HashMap<String, List<VersionedModelInfos<M>>>();

    /**
     * Creates an instance of this class.
     * 
     * @param repository the underlying repository instance
     */
    AvailableModels(IModelManagementRepository<M> repository) {
        this.repository = repository;
    }
    
    /**
     * Returns all versioned model information objects.
     * 
     * @return all known versioned model information objects
     */
    Collection<List<VersionedModelInfos<M>>> versionedModelInfos() {
        return availableModels.values();
    }
    
    /**
     * Updates the list of available models.
     * 
     * @param info the model information to be added/updated
     * @return <code>true</code> in case of inconsistencies, <code>false</code>
     */
    boolean updateAvailableModel(ModelInfo<M> info) {
        boolean inconsistent = false;
        String name = info.getName();
        Version version = info.getVersion();
        List<VersionedModelInfos<M>> infoSameName = availableModels.get(name);
        if (null == infoSameName) {
            infoSameName = new ArrayList<VersionedModelInfos<M>>();
            availableModels.put(name, infoSameName);
        }
        boolean found = false;
        VersionedModelInfos<M> vInfos = VersionedModelInfos.find(infoSameName, version);
        if (null == vInfos) {
            vInfos = new VersionedModelInfos<M>(version);
            infoSameName.add(vInfos);
        }
        for (int i = 0; !found && i < vInfos.size(); i++) {
            ModelInfo<M> tmp = vInfos.get(i);
            if (Utils.matches(info, tmp)) {
                if (tmp.getLoader() == info.getLoader() 
                        && tmp.getLocation().equals(info.getLocation())) {
                    found = true; 
                } /*else {
                    // disabled due to hierarchical import convention
                    inconsistent = true;
                }*/
            }
        }
        if (!found) {
            vInfos.add(info);
        }
        return inconsistent;
    }
    
    /**
     * Returns the number of different model information objects known in this class.
     *  
     * @param differURIs if the result should count different URIs or just different versions
     * @return the number of different model information objects
     */
    public synchronized int getModelInfoCount(boolean differURIs) {
        int count = 0;
        for (List<VersionedModelInfos<M>> vInfos : availableModels.values()) {
            if (differURIs) {
                for (int v = 0; v < vInfos.size(); v++) {
                    count += vInfos.get(v).size();
                }
            } else {
                count += vInfos.size();
            }
        }
        return count;
    }
    
    /**
     * Returns the (visible) information object at <code>uri</code>.
     * @param uri the URI to look for
     * @return the found information object or <b>null</b> if not found
     */
    public ModelInfo<M> getInfo(URI uri) {
        List<ModelInfo<M>> visible = getVisibleModelInfo(uri);
        ModelInfo<M> found = null;
        for (int v = 0; null == found && v < visible.size(); v++) {
            if (visible.get(v).getLocation().equals(uri)) {
                found = visible.get(v);
            }
        }
        return found;
    }

    /**
     * Returns the available model information objects which are available for and 
     * visible from the given URI, i.e. either same path, containing or contained path.
     * 
     * @param uri the URI to match
     * @return the available information objects matching <code>uri</code>
     */
    public List<ModelInfo<M>> getVisibleModelInfo(URI uri) {
        return getVisibleModelInfo(null, null, uri);
    }
    
    /**
     * Returns the available model information objects which are available for and 
     * visible from the given URI, i.e. either same path, containing or contained path.
     *
     * @param name the name of the model (may be <b>null</b> but then <code>version</code> is ignored and all
     *   visible model information objects are returned as done in {@link #getVisibleModelInfo(URI)}). 
     * @param version the version of the model (may be <b>null</b>)
     * @param uri the URI to match
     * @return the available information objects matching <code>uri</code>
     */
    public synchronized List<ModelInfo<M>> getVisibleModelInfo(String name, Version version, URI uri) {
        List<ModelInfo<M>> result = new ArrayList<ModelInfo<M>>();
        for (List<VersionedModelInfos<M>> vInfos : availableModels.values()) {
            int vInfosSize = vInfos.size();
            for (int i = 0; i < vInfosSize; i++) {
                // currently we do not have model paths ;)
                ModelInfo<M> info = vInfos.get(i).getByClosestUri(uri, repository.paths().getModelPath(uri));
                if (null != info) {
                    if ((null == name) || (name.equals(info.getName()) && Version.equals(info.getVersion(), version))) {
                        result.add(info);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Returns the available model information objects which are located at <code>uri</code>.
     * 
     * @param uri the URI to match
     * @return the available information objects matching <code>uri</code>
     */
    List<ModelInfo<M>> getModelInfoWith(URI uri) {
        List<ModelInfo<M>> result = null;
        if (null != uri) {
            for (List<VersionedModelInfos<M>> vInfos : availableModels.values()) {
                int vInfosSize = vInfos.size();
                for (int i = 0; i < vInfosSize; i++) {
                    List<ModelInfo<M>> tmp = vInfos.get(i).getByEqualUri(uri);
                    if (null != tmp) {
                        if (null == result) {
                            result = new ArrayList<ModelInfo<M>>();
                        }
                        result.addAll(tmp);
                    }
                }
            }
        }
        return result;
    }

    /**
     * Returns the model information object for <code>model</code> while considering
     * <code>uri</code> as location of <code>model</code>. This method emulates an import. 
     * 
     * @param model the model to search the info for
     * @param uri the URI to consider as starting point
     * @return the model information object or <b>null</b> if there is none
     */
    public synchronized ModelInfo<M> getResolvedModelInfo(M model, URI uri) {
        ModelInfo<M> result = null;
        if (null != model) {
            VersionedModelInfos<M> vInfo = VersionedModelInfos.find(
                availableModels.get(model.getName()), model.getVersion());
            if (null != vInfo) {
                result = vInfo.getByClosestUri(uri, repository.paths().getModelPath(uri));
            }
        }
        return result;
    }

    /**
     * Returns the model information object for the given model by considering resolved
     * models.
     *  
     * @param model the model to search an information object for which resolves <code>model</code>
     * @return the related model information object or <b>null</b> if there is none
     */
    public synchronized ModelInfo<M> getResolvedModelInfo(M model) {
        ModelInfo<M> result = null;
        if (null != model) {
            VersionedModelInfos<M> vInfo = VersionedModelInfos.find(
                availableModels.get(model.getName()), model.getVersion());
            if (null != vInfo) {
                result = vInfo.get(model);
            }
        }
        return result;
    }
    
    /**
     * Returns a known model information object via its URI.
     *
     * @param name the name of the model to search for
     * @param version the version of the model to search for
     * @param uri the URI to search for
     * @return the related model information object (or <b>null</b> if not found)
     */
    public synchronized ModelInfo<M> getModelInfo(String name, Version version, URI uri) {
        ModelInfo<M> foundInfo = null;
        
        List<VersionedModelInfos<M>> vList = availableModels.get(name);
        VersionedModelInfos<M> vInfos = VersionedModelInfos.find(vList, version);
        if (null != vInfos) {
            foundInfo = vInfos.find(uri);
        }
        return foundInfo;
    }

    /**
     * Returns the model information objects for the specified model.
     * 
     * @param name the name of the model to search for
     * @param version the version of the model to search for
     * @return the model information objects (may have different URLs) or 
     *   <b>null</b> if unknown
     */
    public synchronized List<ModelInfo<M>> getModelInfo(String name, Version version) {
        List<ModelInfo<M>> result = null;
        VersionedModelInfos<M> vInfo = VersionedModelInfos.find(availableModels.get(name), version);
        if (null != vInfo) {
            result = new ArrayList<ModelInfo<M>>();
            vInfo.toList(result);
        }
        return result;
    }
    
    /**
     * Returns the model information objects for the specified model. However, unless the information
     * objects are not directly tested for a reference to <code>model</code>, all those with matching name / version
     * will be returned.
     * 
     * @param model the model to search for
     * @return the model information objects (may have different URLs) or 
     *   <b>null</b> if unknown
     */
    public synchronized List<ModelInfo<M>> getModelInfos(M model) {
        return getModelInfo(model.getName(), model.getVersion());
    }
    
    /**
     * Returns the model information object for the specified model.
     * 
     * @param model the model to search for
     * @return the model information pointing to <code>model</code>, <b>null</b> if unknown
     */
    public synchronized ModelInfo<M> getModelInfo(M model) {
        ModelInfo<M> result = null;
        List<ModelInfo<M>> info = getModelInfos(model);
        int size = info.size();
        for (int i = 0; null == result && i < size; i++) {
            ModelInfo<M> pInfo = info.get(i);
            // no early termination just to be sure
            if (pInfo.getResolved() == model) {
                result = pInfo;
            }
        }
        return result;
    }

    /**
     * Returns the model information object for the specified model.
     * 
     * @param name the name of the model to search for
     * @param version the version of the model to search for
     * @return the model information objects (may have different URLs) or <b>null</b> if unknown
     * @throws VersionFormatException in case of an erroneous version string
     */
    public synchronized List<ModelInfo<M>> getModelInfo(String name, String version) throws VersionFormatException {
        return getModelInfo(name, new Version(version));
    }

    /**
     * Returns whether there are known model information objects for the specified model.
     * 
     * @param name the name of the model
     * @return <code>true</code> if model information is known (at least on model but
     *   multiple in different versions may exist), <code>false</code> else
     */
    public synchronized boolean hasModelInfo(String name) {
        return availableModels.containsKey(name);
    }

    /**
     * Returns all known model information objects for the specified model.
     * 
     * @param name the name of the model
     * @return the available information objects (may be unmodifiable) or <b>null</b>
     */
    public synchronized List<ModelInfo<M>> getModelInfo(String name) {
        List<ModelInfo<M>> result;
        List<VersionedModelInfos<M>> vInfo = availableModels.get(name);
        if (null != vInfo && vInfo.size() > 0) {
            result = new ArrayList<ModelInfo<M>>();
            for (int i = 0; i < vInfo.size(); i++) {
                vInfo.get(i).toList(result);
            }
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Returns the matching available model information instance. This
     * method does not consider the loader. This method is helpful when
     * a model information object is created twice and shall be 
     * internalized with respect to the available model information 
     * objects.
     * 
     * @param info the information object to be internalized
     * @return the matching object or <b>null</b> if unknown
     */
    public synchronized ModelInfo<M> getModelInfo(ModelInfo<M> info) {
        ModelInfo<M> result = null;
        VersionedModelInfos<M> vInfo = VersionedModelInfos.find(
            availableModels.get(info.getName()), info.getVersion());
        if (null != vInfo) {
            result = vInfo.get(info.getLocation());
        }
        return result;
    }
    
    /**
     * Returns a known model object via its URI.
     * 
     * @param name the name of the model to search for
     * @param version the version of the model to search for
     * @param uri the URI to search for
     * @return the related model object (or <b>null</b> if not found or not yet resolved)
     * @throws VersionFormatException in case that <code>version</code> is in wrong format 
     *   (see {@link Version}
     */
    public synchronized M getModel(String name, String version, URI uri) throws VersionFormatException {
        M result;
        ModelInfo<M> info = getModelInfo(name, version, uri);
        if (null != info) {
            result = info.getResolved();
        } else {
            result = null;
        }
        return result;
    }

    /**
     * Returns a known model object via its URI.
     * 
     * @param name the name of the model to search for
     * @param version the version of the model to search for
     * @param uri the URI to search for
     * @return the related model object (or <b>null</b> if not found or not yet resolved)
     * @throws VersionFormatException in case that <code>version</code> is in wrong format 
     *   (see {@link Version}
     */
    public synchronized M getModel(String name, Version version, URI uri) throws VersionFormatException {
        M result;
        ModelInfo<M> info = getModelInfo(name, version, uri);
        if (null != info) {
            result = info.getResolved();
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Returns a known model information object via its URI.
     * 
     * @param name the name of the model to search for
     * @param version the version of the model to search for
     * @param uri the URI to search for
     * @return the related model information object (or <b>null</b> if not found)
     * @throws VersionFormatException in case that <code>version</code> is in wrong format 
     *   (see {@link Version}
     */
    public synchronized ModelInfo<M> getModelInfo(String name, String version, URI uri) 
        throws VersionFormatException {
        Version ver;
        if (null == version) {
            ver = null;
        } else {
            ver = new Version(version);
        }
        return getModelInfo(name, ver, uri);
    }

    /**
     * Returns models available for a given model <code>name</code>.
     * 
     * @param name the name to search for
     * 
     * @return the available models or <b>null</b>
     */
    List<VersionedModelInfos<M>> getAvailable(String name) {
        return availableModels.get(name);
    }

    /**
     * Puts available model information objects for a given model name.
     * @param name the name of the model
     * @param infos the associated model information objects
     */
    void putAvailable(String name, List<VersionedModelInfos<M>> infos) {
        availableModels.put(name, infos);
    }

}
