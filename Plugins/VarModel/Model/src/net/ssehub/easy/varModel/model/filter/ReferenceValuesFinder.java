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
package net.ssehub.easy.varModel.model.filter;

import java.util.List;

import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.filter.DeclarationFinder.VisibilityType;

/**
 * Class for finding relevant {@link AbstractVariable}s matching to the data type of a given {@link Reference}.
 * @author El-Sharkawy
 *
 */
public class ReferenceValuesFinder {

    /**
     * Searches inside the whole {@link Project} for {@link AbstractVariable}s, which can be referenced by
     * {@link net.ssehub.easy.varModel.confModel.IDecisionVariable}s of the given {@link Reference} type.
     * @param project The project which should contain all relevant possible variable, which can be used
     *     to configure the given {@link Reference} variable.
     * @param refType A given {@link Reference}, for which relevant/possible {@link AbstractVariable}s should be
     *     found.
     * @return A list of all relevant {@link AbstractVariable} found in the given project with the correct data type.
     *     This list is maybe empty, but not <tt>null</tt>.
     */
    public static List<AbstractVariable> findPossibleValues(Project project, Reference refType) {
        return findPossibleValues(project, refType.getType());
    }
    
    /**
     * Searches inside the whole {@link Project} for {@link AbstractVariable}s, which are of the specified 
     * <code>type</code>.
     * @param project The project which should contain all relevant possible variable, which can be used
     *     to configure the given {@link Reference} variable.
     * @param type A given type for which relevant/possible {@link AbstractVariable}s should be found.
     * @return A list of all relevant {@link AbstractVariable} found in the given project with the correct data type.
     *     This list is maybe empty, but not <tt>null</tt>.
     */
    public static List<AbstractVariable> findPossibleValues(Project project, IDatatype type) {
        DeclarationFinder finder = new DeclarationFinder(project, FilterType.ALL, type);
        
        /*
         * Slots of a compound are currently not supported by
         * IVML, thus, the user should not be able to configure this.
         */
        return finder.getVariableDeclarations(VisibilityType.ONLY_EXPORTED);
    }

}
