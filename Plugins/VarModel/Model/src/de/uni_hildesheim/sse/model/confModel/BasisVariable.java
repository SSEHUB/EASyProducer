package de.uni_hildesheim.sse.model.confModel;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * Class for variables which do not bear nested variables.
 * Supported data types are:
 * <ul>
 * <li><tt>BasisDatatype</tt></li>
 * <li><tt>ConstraintType</tt></li>
 * <li><tt>Enum</tt></li>
 * <li><tt>OrderedEnum</tt></li>
 * <li><tt>Reference</tt></li>
 * </ul>
 * @author El-Sharkawy
 *
 */
class BasisVariable extends DecisionVariable {

    /**
     * Sole constructor for creating {@link IDecisionVariable}'s which do not contain nested Elements.
     * @param parent the parent this variable is part of, typically the {@link Configuration}
     *   instance, but in case of compounds also the containing {@link DecisionVariable}
     * @param varDeclaration the variable declaration instantiated by this decision
     * @param isVisible Specifies whether this variables is exported by an interface or not:
     * <ul>
     * <li><tt>true</tt>: The variable is exported by an interface or there is no interface</li>.
     * <li><tt>false</tt>: There is an interface which does not export this variable</li>.
     * </ul>
     */
    protected BasisVariable(IConfigurationElement parent, AbstractVariable varDeclaration, boolean isVisible) {
        super(parent, varDeclaration, isVisible);
    }

    /**
     * {@inheritDoc}
     */
    public int getNestedElementsCount() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    public IDecisionVariable getNestedElement(int index) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void setValue(Value value, IAssignmentState state, IConfigurationElement nested)
        throws ConfigurationException {
        // Not supported by this class.
    }

    /**
     * {@inheritDoc}
     */
    public void freeze(String nestedElement) {
        // Not supported by this class.
    }

}
