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


/**
 * Defines model imports and related restrictions.
 * 
 * @param <M> the specific type of model
 * 
 * @author Holger Eichelberger
 */
public class ModelImport <M extends IModel> {

    private M resolved;
    private String name;
    private IVersionRestriction restriction;
    private boolean isConflict;

    /**
     * Creates an unrestricted script import.
     * 
     * @param name The name of the project to be imported.
     */
    public ModelImport(String name) {
        this(name, false, null);
    }
    
    /**
     * Creates a model import instance.
     * 
     * @param name the name of the model to be import
     * @param isConflict does this object represent a conflict or an import
     * @param restriction the version restriction (or <b>null</b> if absent)
     */
    public ModelImport(String name, boolean isConflict, IVersionRestriction restriction) {
        this.name = name;
        this.restriction = restriction;
        this.isConflict = isConflict;
    }
    
    /**
     * Returns the name of the model to be imported.
     * 
     * @return Name of the import
     */
    public String getName() {
        return name;
    }

    /**
     * Does this object represent an import or a conflict.
     * 
     * @return <code>true</code> in case of a conflict, 
     *   <code>false</code> in case of an import
     */
    public boolean isConflict() {
        return isConflict;
    }

    /**
     * Setter for setting the version restrictions.
     * 
     * @param restriction the version restriction to this import or <code>null</code> if absent.
     */
    public void setRestrictions(IVersionRestriction restriction) {
        this.restriction = restriction;
    }

    /**
     * Returns the resolved model instance.
     * 
     * @return the resolved instance
     */
    public M getResolved() {
        return resolved;
    }
    
    /**
     * Returns whether the related model was already resolved.
     * 
     * @return <code>true</code> if it was resolved, <code>false</code> else
     */
    public boolean isResolved() {
        return null != resolved;
    }

    /**
     * Defines the resolved model instance.
     * 
     * @param resolved the resolved instance or <b>null</b>
     * @throws ModelManagementException in case of violated model access restrictions
     */
    public void setResolved(M resolved) throws ModelManagementException {
        // set resolved
        this.resolved = resolved;
    }
    
    /**
     * Evaluates the restrictions against <code>version</code>.
     * 
     * @param context the output context (interpreted by the respective implementation, 
     *   e.g., an output visitor in order to continue with the actual indentation, may 
     *   be <b>null</b> but then <b>false</b> will always be the result)
     * @param version the version to evaluate against
     * @return <code>true</code> if the restrictions are fulfilled (also if none restrictions
     *   were given), <code>false</code> if the restrictions were not fulfilled
     * @throws RestrictionEvaluationException in case of evaluation problems
     */
    public boolean evaluateRestrictions(IRestrictionEvaluationContext context, Version version) 
        throws RestrictionEvaluationException {
        return null != restriction ? restriction.evaluate(context, version) : true;
    }
    
    /**
     * Returns the version restriction.
     * 
     * @return the version restriction (may be <b>null</b>)
     */
    public IVersionRestriction getVersionRestriction() {
        return restriction;
    }
    
    /**
     * Copies the version restriction.
     * 
     * @param model the model to instantiate the copied version restriction for
     * @return the copied version restriction or <b>null</b> if no restriction was specified before
     * @throws RestrictionEvaluationException in case of type/structural problems
     */
    public IVersionRestriction copyVersionRestriction(M model) throws RestrictionEvaluationException {
        return null != restriction ? restriction.copy(model) : null;
    }
 
}
