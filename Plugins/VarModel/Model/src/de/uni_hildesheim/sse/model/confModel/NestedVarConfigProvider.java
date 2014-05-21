package de.uni_hildesheim.sse.model.confModel;

/**
 * 
 * {@link VariableConfigProvider} for nested variables of a {@link StructuredVariable}.
 * 
 * @author El-Sharkawy
 *
 */
abstract class NestedVarConfigProvider extends VariableConfigProvider {

    private StructuredVariable parent;
    
    /**
     * Sole constructor for this class.
     * @param parent A {@link StructuredVariable} which will hold the
     * nested {@link IDecisionVariable} where this provider belongs to.
     */
    protected NestedVarConfigProvider(StructuredVariable parent) {
        super();
        this.parent = parent;
    }
    
    /**
     * Returns the {@link StructuredVariable} which hold the related {@link IDecisionVariable}
     * where this provider belongs to.
     * @return The {@link StructuredVariable} which hold the related {@link IDecisionVariable}.
     */
    protected StructuredVariable getParent() {
        return parent;
    }

    @Override
    protected final Configuration getConfiguration() {
        return parent.getConfiguration();
    }
    
    @Override
    protected final boolean isStateChangeAllowed() {
        return parent.allowsNestedStates();
    }

}
