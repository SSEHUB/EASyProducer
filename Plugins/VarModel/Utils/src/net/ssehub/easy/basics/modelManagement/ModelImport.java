/*
 * Copyright 2009-2012 University of Hildesheim, Software Systems Engineering
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
 * Defines model imports and related restrictions.
 * 
 * @param <M> the specific type of model
 * 
 * @author Holger Eichelberger
 */
public class ModelImport <M extends IModel> {

    public static final String WILDCARD_POSTFIX = "*";
    
    private M resolved;
    private String name;
    private IVersionRestriction restriction;
    private boolean isConflict;
    private boolean isInsert;

    /**
     * Constructor for serialization.
     */
    ModelImport() {
    }
    
    /**
     * Creates an unrestricted (non-inserting) model import.
     * 
     * @param name The name of the project to be imported, becomes a wildcard import if {@code name} ends 
     * with {@link #WILDCARD_POSTFIX}
     */
    public ModelImport(String name) {
        this(name, false, null);
    }

    /**
     * Creates a (non-inserting) model import instance.
     * 
     * @param name the name of the model to be import, becomes a wildcard import if {@code name} ends 
     * with {@link #WILDCARD_POSTFIX}
     * @param isConflict does this object represent a conflict or an import
     * @param restriction the version restriction (or <b>null</b> if absent)
     */
    public ModelImport(String name, boolean isConflict, IVersionRestriction restriction) {
        this(name, isConflict, restriction, false);
    }
    
    /**
     * Creates a model import instance.
     * 
     * @param name the name of the model to be import, becomes a wildcard import if {@code name} ends 
     * with {@link #WILDCARD_POSTFIX}
     * @param isConflict does this object represent a conflict or an import
     * @param restriction the version restriction (or <b>null</b> if absent)
     * @param isInsert whether model elements of the resolved model shall be (virtually) insert 
     *     at the end of the importing model
     */
    public ModelImport(String name, boolean isConflict, IVersionRestriction restriction, 
        boolean isInsert) {
        this.name = name;
        this.restriction = restriction;
        this.isConflict = isConflict;
        this.isInsert = isInsert;
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
     * Returns whether the import targets multiple models to be imported.
     * 
     * @return <code>true</code> in case of a wildcard import, <code>false</code> else
     */
    public boolean isWildcard() {
        return isWildcard(name);
    }

    /**
     * Returns whether the given name targets multiple models to be imported.
     * 
     * @param name the name of the model(s) to be imported
     * @return <code>true</code> in case of a wildcard import, <code>false</code> else
     */
    public static boolean isWildcard(String name) {
        return name != null && name.endsWith(WILDCARD_POSTFIX);
    }

    /**
     * Returns whether the import aims at inserting elements at the end of the importing model.
     * 
     * @return <code>true</code> in case of an inserting import, <code>false</code> else
     */
    public boolean isInsert() {
        return isInsert;
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
    
    /**
     * Creates a copy of this import.
     * 
     * @param modelName a new model name, may be <b>null</b> for the original
     * @return the copied instance
     */
    public ModelImport<M> copy(String modelName) {
        return new ModelImport<M>(null == modelName ? name : modelName, isConflict, restriction, isInsert);
    }
 
}
