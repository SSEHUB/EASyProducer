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
package de.uni_hildesheim.sse.model.varModel.rewrite.modifier;

import java.util.Iterator;
import java.util.Set;

import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IAssignmentState;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.filter.DeclrationInConstraintFinder;
import de.uni_hildesheim.sse.model.varModel.rewrite.RewriteContext;

/**
 * Super class for Filters which should remove elements based on already frozen variables.
 * @author El-Sharkawy
 *
 * @param <M> Type of {@link ContainableModelElement}s, which shall be handled by this class.
 */
public abstract class AbstractFrozenChecker<M extends ContainableModelElement> implements IModelElementFilter<M> {

    private Configuration config;
    
    /**
     * Single constructor of this class.
     * @param config A already initialized {@link Configuration}, needed for checking whether an arbitrary variable is
     * already frozen.
     */
    protected AbstractFrozenChecker(Configuration config) {
        this.config = config;
    }

    /**
     * Checks whether the given declaration is already frozen.
     * @param declaration A declaration to test.
     * @return <tt>true</tt> if the declaration is clearly frozen, <tt>false</tt> otherwise.
     */
    protected boolean isFrozen(AbstractVariable declaration) {
        boolean isFrozen = false;
        IDecisionVariable configVar = config.getDecision(declaration);
        if (null != configVar && null != configVar.getState()) {
            IAssignmentState state = configVar.getState();
            isFrozen = AssignmentState.FROZEN == state;
        }

        return isFrozen;
    }
    
    /**
     * Returns the specified {@link IDecisionVariable}.
     * 
     * @param declaration The declaration for which the configuration entity should be returned.
     * @return The {@link IDecisionVariable} for the given declaration
     */
    protected IDecisionVariable getVariable(AbstractVariable declaration) {
        return config.getDecision(declaration);
    }
    
    /**
     * Getter for the configuration (passed to the constructor).
     * @return The currently used configuration.
     */
    protected Configuration getConfioguration() {
        return config;
    }

    /**
     * Checks whether the given constraint contains only constant values or frozen variables.
     * @param constraint The constraint to check.
     * @param context Knowledge of the current translation, comes from the
     * {@link de.uni_hildesheim.sse.model.varModel.rewrite.ProjectRewriteVisitor}
     * @return <tt>true</tt> if the constraint contains only frozen/constant elements or is <tt>null</tt>,
     * <tt>false</tt> if it contain at least one open variable.
     */
    protected boolean constraintIsFrozen(ConstraintSyntaxTree constraint, RewriteContext context) {
        boolean allFrozen = true;
        if (null != constraint) {
            DeclrationInConstraintFinder finder = new DeclrationInConstraintFinder(constraint);
            Set<AbstractVariable> usedDeclarations = finder.getDeclarations();
            Iterator<AbstractVariable> declItr = usedDeclarations.iterator();
            while (declItr.hasNext() && allFrozen) {
                allFrozen = allInstancesAreFrozen(declItr.next(), context);
            }
        }
        return allFrozen;
    }

    /**
     * Checks whether all instances of the given declaration are already frozen.
     * @param declaration The declaration to check (if it is nested, it can have multiple instances).
     * @param context Knowledge of the current translation, comes from the
     * {@link de.uni_hildesheim.sse.model.varModel.rewrite.ProjectRewriteVisitor}
     * @return <tt>true</tt> if all instances are frozen or if it has no instances, <ttfalse</tt> otherwise.
     */
    protected boolean allInstancesAreFrozen(AbstractVariable declaration, RewriteContext context) {
        boolean allFrozen = true;
        Set<IDecisionVariable> instances = context.getInstancesForDeclaration(config, declaration);
        Iterator<IDecisionVariable> varItr = instances.iterator();
        while (varItr.hasNext() && allFrozen) {
            IDecisionVariable usedInstance = varItr.next();
            allFrozen = (AssignmentState.FROZEN == usedInstance.getState());
        }
        return allFrozen;
    }
}
