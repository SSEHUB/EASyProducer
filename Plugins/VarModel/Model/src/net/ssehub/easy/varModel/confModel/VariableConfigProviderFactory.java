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
package net.ssehub.easy.varModel.confModel;

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
     *     (must not be <b>null</b>.
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
