package de.uni_hildesheim.sse.model.varModel.filter;

import java.util.List;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.model.varModel.filter.DeclarationFinder.VisibilityType;

/**
 * Class for finding relevant {@link AbstractVariable}s mathicng to the data type of a given {@link Reference}.
 * @author El-Sharkawy
 *
 */
public class ReferenceValuesFinder {

    /**
     * Searches inside the whole {@link Project} for {@link AbstractVariable}s, which can be referenced by
     * {@link de.uni_hildesheim.sse.model.confModel.IDecisionVariable}s of the given {@link Reference} type.
     * @param project The project which should contain all relevant possible variable, which cen be used
     *     to configure the given {@link Reference} variable.
     * @param refType A given {@link Reference}, for which relevant/possible {@link AbstractVariable}s should be
     *     found.
     * @return A list of all relevant {@link AbstractVariable} found in the given project with the correct data type.
     *     This list is maybe empty, but not <tt>null</tt>.
     */
    public static List<AbstractVariable> findPossibleValues(Project project, Reference refType) {
        DeclarationFinder finder = new DeclarationFinder(project, FilterType.ALL, refType.getType());
        
        /*
         * Slots of a compound are currently not supported by
         * IVML, thus, the user should not be able to configure this.
         */
        return finder.getVariableDeclarations(VisibilityType.ONLY_EXPORTED);
    }
}
