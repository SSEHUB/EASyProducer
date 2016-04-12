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
package net.ssehub.easy.varModel.model.rewrite;

import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.datatypes.CustomDatatype;

/**
 * Stores elements of the {@link ProjectCopyVisitor}, which could not be copied completely as dependent elements
 * are not copied, yet.
 * @author El-Sharkawy
 */
class UncopiedElementsContainer {

    /**
     * Set of copied {@link AbstractVariable}s, which contain default values pointing to other elements, which are not
     * copied at this moment. Resolving should be possible after all {@link AbstractVariable}s (also from imported
     * projects) have been copied.<br/>
     * <b>Note:</b> These variables must still contain the old or a partially copied default value, so that the
     * default value can be used for copying it at a later point.
     */
    private Set<AbstractVariable> unresolvedDefaults = new HashSet<AbstractVariable>();
    
    /**
     * {@link AbstractVariable}s which could not be translated due to a missing data type.
     */
    private Set<AbstractVariable> unresolvedDeclarations = new HashSet<AbstractVariable>();
    
    /**
     * Set of copied {@link Constraint}s, which contain {@link net.ssehub.easy.varModel.cst.ConstraintSyntaxTree}s
     * pointing to other elements, which are not copied at this moment.
     * Resolving should be possible after all {@link AbstractVariable}s (also from imported projects) have been copied.
     * <br/>
     * <b>Note:</b> These {@link Constraint}s must still contain the old or a partially copied cst, so that the
     * cst can be used for copying it at a later point.
     */
    private Set<Constraint> unresolvedConstraints = new HashSet<Constraint>();
    
    /**
     * Set of custom data types which are dependent of other custom data types, not translated so far.
     */
    private Set<CustomDatatype> unresolvedDatatypes = new HashSet<CustomDatatype>();
    
    /**
     * Set of (original) annotations, which could not be translated so far.
     */
    private Set<Attribute> unresolvedAnnotations = new HashSet<Attribute>();
    
    /**
     * Adds a copied/translated {@link AbstractVariable}, from which the default value could not be translated, as
     * it is dependent of other elements, which not have been copied/translated so far. Resolving should be possible
     * after all {@link AbstractVariable}s (also from imported projects) have been copied.<br/>
     * <b>Note:</b> These variables must still contain the old or a partially copied default value, so that the
     * default value can be used for copying it at a later point.
     * @param declWithMissingDefault A copied declaration with its (uncopied) default value.
     */
    void addMissingDefault(AbstractVariable declWithMissingDefault) {
        unresolvedDefaults.add(declWithMissingDefault);
    }
    
    /**
     * Returns the set of copied/translated declarations with incomplete translated default values.
     * This set may be changed as a side effect during resolving default values.
     * @return Declarations where the default values has to be resolved.
     */
    Set<AbstractVariable> getDeclarationsWithMissingDefaults() {
        return unresolvedDefaults;
    }
    
    /**
     * Adds a copied/translated {@link Constraint}, from which the
     * {@link net.ssehub.easy.varModel.cst.ConstraintSyntaxTree} could not be translated,
     * as it is dependent of other elements, which not have been copied/translated so far. Resolving should be possible
     * after all {@link AbstractVariable}s (also from imported projects) have been copied.<br/>
     * <b>Note:</b> These constraints must still contain the old or a partially copied cst, so that the
     * cst can be used for copying it at a later point.
     * @param unresolvedConstraint A copied constraint with its (uncopied) cst.
     */
    void addUnresolvedConstraint(Constraint unresolvedConstraint) {
        unresolvedConstraints.add(unresolvedConstraint);
    }
    
    /**
     * Returns the set of copied/translated {@link Constraint}s with incomplete translated
     * {@link net.ssehub.easy.varModel.cst.ConstraintSyntaxTree}s. This set may be changed
     * as a side effect during resolving the csts.
     * @return Constraints where the csts has to be resolved.
     */
    Set<Constraint> getUnresolvedconstraints() {
        return unresolvedConstraints;
    }
    
    /**
     * Adds a custom data type which could not be translated as it is dependent of another custom data type, which
     * hasn't been copied so far.
     * @param unresolvedType The unresolved data type, which still has to be translated.
     */
    void addUnresolvedType(CustomDatatype unresolvedType) {
        unresolvedDatatypes.add(unresolvedType);
    }
    
    /**
     * Returns the set of all unresolved (original) data types which could not be translated so far.
     * @return The unresolved data types
     */
    Set<CustomDatatype> getUnresolvedTypes() {
        return unresolvedDatatypes;
    }
    
    /**
     * Adds an annotation, which could not be translated so far (due to missing attributable element or type).
     * @param originalAttribute The original attribute which could not be translated at this moment.
     */
    void addUnresolvedAnnotation(Attribute originalAttribute) {
        unresolvedAnnotations.add(originalAttribute);
    }
    
    /**
     * Adds an {@link AbstractVariable}, which could not be translated so far (due to missing type).
     * @param declWithUnresolvedType The original declaration which could not be translated at this moment.
     */
    void addUnresolvedDeclarationType(AbstractVariable declWithUnresolvedType) {
        unresolvedDeclarations.add(declWithUnresolvedType);
    }
}
