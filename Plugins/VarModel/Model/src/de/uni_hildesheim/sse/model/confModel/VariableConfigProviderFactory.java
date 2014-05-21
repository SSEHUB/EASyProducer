package de.uni_hildesheim.sse.model.confModel;

/**
 * Factory class for creating {@link VariableConfigProvider}s.
 * The correct {@link VariableConfigProvider} will be created depending whether the related {@link IDecisionVariable}
 * is a nested inside a compound/container or directly inside the configuration.
 * @author El-Sharkawy
 *
 */
class VariableConfigProviderFactory {
    
    /**
     * Returns the correct {@link VariableConfigProvider} depending on the related {@link IDecisionVariable}.
     * @param relatedVariable The {@link IDecisionVariable} which will use this {@link VariableConfigProvider}.
     * @return The correct {@link VariableConfigProvider} depending on the related {@link IDecisionVariable}
     *     (must not be <tt>null</tt>.
     */
    static VariableConfigProvider createDelegate(IDecisionVariable relatedVariable) {
        VariableConfigProvider delegate = null;
        if (!relatedVariable.isNested()) {
            delegate = new ToplevelVarConfigProvider(relatedVariable, null, AssignmentState.UNDEFINED);
        } else {
            if (relatedVariable.getDeclaration().isAttribute()) {
                // this is always just a basis variable
                // bugfix ScaleLog 11.04.2013
                delegate = new ToplevelVarConfigProvider(relatedVariable, null, AssignmentState.UNDEFINED);
            } else {
                IDecisionVariable parent = (IDecisionVariable) relatedVariable.getParent();
                if (parent instanceof CompoundVariable) {
                    delegate = new CompoundItemConfigProvider((CompoundVariable) parent,
                        relatedVariable.getDeclaration().getName());
                } else if (parent instanceof ContainerVariable) {
                    ContainerVariable containerParent = (ContainerVariable) parent;
                    int countItems = containerParent.getNestedElementsCount();
                    for (int i = 0; null == delegate && i < countItems; i++) {
                        String thisName = relatedVariable.getDeclaration().getName();
                        String nameInParent = containerParent.getNestedElement(i).getDeclaration().getName();
                        if (nameInParent.equals(thisName)) {
                            delegate = new ContainerItemConfigProvider(containerParent, i);
                        }
                    }
                    if (null == delegate) {
                        if (!relatedVariable.getDeclaration().isAttribute()) {
                            containerParent.addNestedElement(relatedVariable);
                        }
                        delegate = new ContainerItemConfigProvider(containerParent, countItems);
                    }
                } else if (parent instanceof BasisVariable) {
                    // this can only happen if relatedVariable is an attribute
                    // TODO attributes of nested Variables
                    delegate = new ToplevelVarConfigProvider(relatedVariable, null, AssignmentState.UNDEFINED);
                }
            }
        }
        
        return delegate;
    }
}
