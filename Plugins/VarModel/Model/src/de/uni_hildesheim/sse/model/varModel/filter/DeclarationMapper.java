package de.uni_hildesheim.sse.model.varModel.filter;

import java.util.HashMap;
import java.util.Map;

import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;

/**
 * This filter class searches all top level {@link DecisionVariableDeclaration}s and stores them into a Map.
 * The Map is in form of:
 * <ul>
 * <li>Key: (Not qualified) Name of the {@link DecisionVariableDeclaration}</li>
 * <li>Value: The {@link DecisionVariableDeclaration} itself</li>
 * </ul>
 * 
 * @author El-Sharkawy
 *
 */
public class DeclarationMapper extends AbstractDeclarationFinder {
    private Map<String, DecisionVariableDeclaration> declarations;
    
    /**
     * Sole constructor for this class.
     * @param project The project where the visiting shall start
     * @param filterType Specifies whether project imports shall be considered or not.
     */
    public DeclarationMapper(Project project, FilterType filterType) {
        super(project, filterType);
        declarations = new HashMap<String, DecisionVariableDeclaration>();
        project.accept(this);
    }
    
    /**
     * Returns a Hashmap of all top-level {@link DecisionVariableDeclaration}s.
     * The Map is in form of:
     * <ul>
     * <li>Key: (Not qualified) Name of the {@link DecisionVariableDeclaration}</li>
     * <li>Value: The {@link DecisionVariableDeclaration} itself</li>
     * </ul>
     * @return Hashmap of all top-level {@link DecisionVariableDeclaration}s, must not be <tt>null</tt>.
     */
    public Map<String, DecisionVariableDeclaration> getDeclarationMap() {
        return declarations;
    }


    /**
     * {@inheritDoc}
     */
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        declarations.put(decl.getName(), decl);
    }
    
    /**
     * {@inheritDoc}
     */
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // Not needed method, since this class should only find DecisionVariableDeclaration
    }

}
