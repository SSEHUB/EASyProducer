/*
 * Copyright 2016 University of Hildesheim, Software Systems Engineering
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

import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Reference;

/**
 * Visitor for a {@link Configuration} to generate statistics of the configuration.
 * @author El-Sharkawy
 *
 */
public abstract class AbstractConfigurationStatisticsVisitor extends AbstractConfigurationVisitor {
    
    /**
     * Gathered statistical information of the visited configuration.
     * @author El-Sharkawy
     *
     */
    public static class ConfigStatistics {

        /**
         * All variables (non constraint variables + constraint variables), without nested variables.
         */
        private int nToplevelVariables = 0;
        
        /**
         * All variables (non constraint variables + constraint variables), including nested variables.
         */
        private int nVariables = 0;
        
        /**
         * All variables (non constraint variables + constraint variables), including nested variables,
         * but no instances nested in container.
         */
        private int nVariablesNoContainers = 0;
        
        /**
         * Non constraint variables, including nested variables.
         */
        private int nNormalVariables = 0;
        private int nNormalVariablesNoContainer = 0;
        
        /**
         * Only constraint variables, including nested variables.
         */
        private int nConstraintVariables = 0;
        private int nConstraintVariablesNoContainer = 0;
        
        /**
         * Number of constraints in compound instances.
         */
        private int nConstraintInstances = 0;
        
        /**
         * The number of annotation instances.
         */
        private int nAnnotations = 0;
    
        /**
         * Returns the number of non nested top level variables of the configuration.
         * Does not consider annotations.
         * @return 0 &le; {@link #noOfToplevelVariables()} &le; {@link #noOfVariables()}.
         */
        public int noOfToplevelVariables() {
            return nToplevelVariables;
        }

        /**
         * Returns the number of all variables of the configuration (nested, nested in container, and not nested).
         * Does not consider annotations.
         * @return {@link #noOfVariables()} = {@link #noOfNormalVariables()} + {@link #noOfConstraintVariables()}.
         */
        public int noOfVariables() {
            return nVariables;
        }
        
        /**
         * Returns the number of all variables of the configuration (nested, and not nested).
         * Does not consider annotations. Does also not consider instances nested in a container.
         * @return {@link #noOfVariables()} &ge; {@link #noOfVariablesWithoutContainer()}.
         */
        public int noOfVariablesWithoutContainer() {
            return nVariablesNoContainers;
        }

        /**
         * Returns the number of all variables, which are no constraint variables. Does not differentiate between 
         * toplevel and nested variables.
         * @return Will be &ge; 0.
         */
        public int noOfNormalVariables() {
            return nNormalVariables;
        }
        
        /**
         * Returns the number of all variables, which are no constraint variables. Does not differentiate between 
         * toplevel and nested variables. Does not count instances inside a container.
         * @return Will be &le; {@link #noOfNormalVariables()}.
         */
        public int noOfNormalVariablesNoContainer() {
            return nNormalVariablesNoContainer;
        }

        /**
         * Returns the number of all constraint variables. Does not differentiate between 
         * toplevel and nested variables.
         * @return Will be &ge; 0.
         */
        public int noOfConstraintVariables() {
            return nConstraintVariables;
        }
        
        /**
         * Returns the number of all constraint variables. Does not differentiate between 
         * toplevel and nested variables. Does not count instances inside a container
         * @return Will be &le; {@link #noOfConstraintVariables()}.
         */
        public int noOfConstraintVariablesNoContainer() {
            return nConstraintVariablesNoContainer;
        }

        /**
         * Returns the number of instantiated {@link Compound} constraints.
         * @return Will be &ge; 0.
         */
        public int noOfConstraintInstances() {
            return nConstraintInstances;
        }

        /**
         * Returns the number of all annotation instances.
         * @return Will be &ge; 0.
         */
        public int noOfAnnotations() {
            return nAnnotations;
        }
    }
    
    private ConfigStatistics statistics;
    
    /**
     * Sole constructor of this class.
     * @param statistics A data object to store the statistical information.
     */
    protected AbstractConfigurationStatisticsVisitor(ConfigStatistics statistics) {
        this.statistics = statistics;
    }
    
    @Override
    public void visitConfiguration(Configuration configuration) {
        specialTreatment(configuration.getProject());
        super.visitConfiguration(configuration);
    }
    
    @Override
    public void visitDecisionVariable(IDecisionVariable variable) {
        statistics.nToplevelVariables++;
        visitVariable(variable, false);
    }
    
    /**
     * Recursive part to visit all (nested) variables.
     * @param variable The visited decision variable instance.
     * @param nestedInContainer <tt>true</tt> if the parent is a container, <tt>false</tt> otherwiese.
     */
    public void visitVariable(IDecisionVariable variable, boolean nestedInContainer) {
        statistics.nVariables++;
        if (!nestedInContainer) {
            statistics.nVariablesNoContainers++;
        }
        statistics.nAnnotations += variable.getAttributesCount();
        specialTreatment(variable);
        
        // Special treatment depending on its type
        IDatatype type = variable.getDeclaration().getType();
        if (ConstraintType.TYPE.isAssignableFrom(type)) {
            statistics.nConstraintVariables++;
            if (!nestedInContainer) {
                statistics.nConstraintVariablesNoContainer++;
            }
        } else {
            statistics.nNormalVariables++;
            if (!nestedInContainer) {
                statistics.nNormalVariablesNoContainer++;
            }
        }
        if (Compound.TYPE.isAssignableFrom(type)) {
            IDatatype dereferedType = Reference.dereference(type);
            if (dereferedType instanceof Compound) {
                visitRefines((Compound) dereferedType);
            }
        }
        
        nestedInContainer |= Container.TYPE.isAssignableFrom(type);
        
        // Visit nested variables
        for (int i = 0, end = variable.getNestedElementsCount(); i < end; i++) {
            IDecisionVariable nestedVar = variable.getNestedElement(i);
            visitVariable(nestedVar, nestedInContainer);
        }
    }

    /**
     * Visits all refined compounds and collects statistics.
     * 
     * @param cmp the compound to visit
     */
    private void visitRefines(Compound cmp) {
        for (int r = 0; r < cmp.getRefinesCount(); r++) {
            Compound cType = cmp.getRefines(r);
            statistics.nConstraintInstances += cType.getConstraintsCount();
            visitRefines(cType);
        }
    }
    
    /**
     * Returns the collected statistics.
     * @return The collected statistics, will be empty if the visit method was not called before.
     */
    public ConfigStatistics getStatistics() {
        return statistics;
    }

    /**
     * Optional hook to realize additional statistics for (nested) variables.
     * @param variable A visited variable. This will be called for all variables, independently if they are
     *    m toplevel variables or if they are nested.
     */
    protected abstract void specialTreatment(IDecisionVariable variable);
    
    /**
     * Optional hook to realize additional statistics for the underlying IVML project.
     * @param mainProject {@link Configuration#getProject()}.
     */
    protected abstract void specialTreatment(Project mainProject);

}
