package de.uni_hildesheim.sse.model.confModel;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;

/**
 * Abstract super class for variables of <tt>StructuredDatatype</tt>'s.
 * Specialized classes are:
 * <ul>
 * <li>{@link ContainerVariable}</li>
 * <li>{@link CompoundVariable}</li>
 * </ul>
 * @author El-Sharkawy
 *
 */
abstract class StructuredVariable extends DecisionVariable {
    
    /**
     * Sole constructor for this class.
     * @param parent the parent this variable is part of, typically the {@link Configuration}
     *   instance, but in case of compounds/container also the containing {@link IDecisionVariable}
     * @param varDeclaration the variable declaration instantiated by this decision
     * @param isVisible Specifies whether this variables is exported by an interface or not:
     * <ul>
     * <li><tt>true</tt>: The variable is exported by an interface or there is no interface</li>.
     * <li><tt>false</tt>: There is an interface which does not export this variable</li>.
     * </ul>
     */
    protected StructuredVariable(IConfigurationElement parent, AbstractVariable varDeclaration, boolean isVisible) {
        super(parent, varDeclaration, isVisible);
    }
    
    /**
     * Returns whether this variable support individual states for nested items. 
     * @return <tt>true</tt> if nested items can have their own states, otherwise <tt>false</tt>.
     */
    abstract boolean allowsNestedStates();
}
