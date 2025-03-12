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


/**
 * Represents the type of models to be managed.
 * 
 * @author Holger Eichelberger
 */
public interface IModel extends IModelData {

    /**
     * Changes the version of this model.
     * 
     * @param version Version to set
     */
    public void setVersion(Version version);
    
    /**
     * Returns the version of this model.
     * 
     * @return the version or <code>null</code> if no version is specified for this model.
     */
    public Version getVersion();

    /** 
     * Returns the name of the model element.
     * @return the name of this model element.
     */
    public String getName();

    /**
     * Returns the number of imports.
     * 
     * @return the number of imports
     */
    public int getImportsCount(); 
    
    /**
     * Returns the model import specified by <code>index</code>.
     * 
     * @param index a 0-based index specifying the import to be returned
     * @return the model import
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getImportsCount()}</code>
     */
    public ModelImport<?> getImport(int index);
    
    /**
     * Returns the reference to the super model (if it exists).
     * 
     * @return the super model (in terms of a model import/reference, may be <b>null</b>)
     */
    public ModelImport<?> getSuper();

    /**
     * Returns the indentation configuration for this model. The indentation
     * configuration is considered to be immutable.
     * 
     * @return the indentation configuration (disabled if <b>null</b>)
     */
    public IndentationConfiguration getIndentationConfiguration();

    /**
     * Shall be called at the end of the lifetime of the model in order 
     * to clean up references such as listeners.
     */
    public void dispose();

    /**
     * Returns the context for evaluating import / conflict restrictions.
     * This context shall only contain the information that is necessary
     * to evaluate restriction information.
     * 
     * @return the evaluation context
     */
    public IRestrictionEvaluationContext getRestrictionEvaluationContext();
    
    /**
     * Returns the last modification timestamp.
     * 
     * @return the last modification timestamp, invalid if {@code 0}
     */
    public long getLastModification();
    
}
