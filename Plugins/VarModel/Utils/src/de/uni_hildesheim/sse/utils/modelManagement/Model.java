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
package de.uni_hildesheim.sse.utils.modelManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the type of models to be managed.
 * 
 * @author Holger Eichelberger
 */
public abstract class Model implements IModel {
    private Version version;
    private List<ModelImport<?>> imports;
    private String name;

    /**
     * Creates a model instance.
     * 
     * @param name the name of the model
     */
    public Model(String name) {
        this(name, null);
    }

    /**
     * Creates a model instance.
     * 
     * @param name the name of the model
     * @param version the version of the model (may be <b>null</b> if there is none)
     */
    public Model(String name, Version version) {
        this.name = name;
        this.version = version;
        imports = new ArrayList<ModelImport<?>>();
    }

    /**
     * Changes the version of this model.
     * 
     * @param version Version to set
     */
    public void setVersion(Version version) {
        this.version = version;
    }
    
    /**
     * Returns the version of this model.
     * 
     * @return the version or <code>null</code> if no version is specified for this model.
     */
    public Version getVersion() {
        return version;
    }

    /** 
     * Returns the name of the model element.
     * 
     * @return the name of this model element.
     */
    public String getName() {
        return name;
    }
    
    /**
     * Adds an import to this model. Conflicts are added always,
     * imports are checked for duplicates.
     * 
     * @param pimport The import
     * @return <code>true</code> if the addition was successful, 
     *   <code>false</code> else due to duplicated names
     */
    public boolean addImport(ModelImport<?> pimport) {
        boolean found = false;
        if (!pimport.isConflict()) {
            for (int i = 0; !found && i < imports.size(); i++) {
                ModelImport<?> tmp = imports.get(i);
                found = (tmp.getName().equals(pimport.getName()));
            }
        }
        if (!found) {
            imports.add(pimport);
        }
        return !found; // use exception?
    }

    /**
     * Returns the number of imports.
     * 
     * @return the number of imports
     */
    public int getImportsCount() {
        return imports.size();
    }
    
    /**
     * Returns the model import specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the import to be returned
     * @return the model import
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getImportsCount()}</code>
     */
    public ModelImport<?> getImport(int index) {
        return imports.get(index);
    }

    @Override
    public void dispose() {
    }

}
