/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.model.varModel.rewrite;

import java.util.Iterator;
import java.util.Set;

import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.FreezeBlock;
import de.uni_hildesheim.sse.model.varModel.IFreezable;
import de.uni_hildesheim.sse.model.varModel.IModelElement;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.ConstraintType;
import de.uni_hildesheim.sse.model.varModel.filter.DeclrationInConstraintFinder;
import de.uni_hildesheim.sse.model.varModel.filter.FilterType;
import de.uni_hildesheim.sse.model.varModel.filter.FrozenElementsFinder;
import de.uni_hildesheim.sse.model.varModel.values.ConstraintValue;

/**
 * Removes frozen {@link ConstraintType} variables if they are only pointing to frozen variable.
 * @author El-Sharkawy
 *
 */
public class FrozenConstraintVarFilter extends AbstractFrozenChecker<DecisionVariableDeclaration> {

    private Project project;
    
    /**
     * Default constructor of this class.
     * @param config A already initialized {@link Configuration}, needed for checking whether an arbitrary variable is
     * already frozen.
     */
    public FrozenConstraintVarFilter(Configuration config) {
        super(config);
        project = config.getProject();
    }

    @Override
    public Class<? extends ContainableModelElement> getModifyingModelClass() {
        return DecisionVariableDeclaration.class;
    }

    @Override
    public ContainableModelElement handleModelElement(ContainableModelElement element, RewriteContext context) {
        DecisionVariableDeclaration declaration = (DecisionVariableDeclaration) element;
        if (declaration.getType() == ConstraintType.TYPE && isFrozen(declaration)) {
            boolean allDeclarationsAreFrozen = true;

            IDecisionVariable constraintVar = getVariable(declaration);
            ConstraintValue constraintValue = (ConstraintValue) constraintVar.getValue();
            DeclrationInConstraintFinder finder = new DeclrationInConstraintFinder(constraintValue.getValue());
            Set<AbstractVariable> usedDeclarations = finder.getDeclarations();
            Iterator<AbstractVariable> itr = usedDeclarations.iterator();
            while (itr.hasNext() && allDeclarationsAreFrozen) {
                allDeclarationsAreFrozen = isFrozen(itr.next());
            }
                    
            if (allDeclarationsAreFrozen) {
                FrozenElementsFinder freezeBlockFinder = new FrozenElementsFinder(project, FilterType.ALL);
                FreezeBlock block = freezeBlockFinder.getFreezeBlock(declaration);
                if (null != block) {
                    IFreezable[] filteredFreezeables = new IFreezable[block.getFreezableCount() - 1];
                    for (int i = 0, n = block.getFreezableCount(), pos = 0; i < n; i++) {
                        IFreezable frozenElement = block.getFreezable(i);
                        if (!declaration.getName().equals(frozenElement.getName())) {
                            filteredFreezeables[pos] = frozenElement;
                            pos++;
                        }
                    }
                    IModelElement parent = block.getParent(); 
                    if (parent instanceof Project) {
                        /*
                         * TODO SE: Check whether Freezeblock can also be contained in other ModelElements
                         * (I don't think so)
                         */
                        FreezeBlock clonedBlock = new FreezeBlock(filteredFreezeables, block.getIter(),
                            block.getSelector(), parent);
                        Project parentAsProject = (Project) parent;
                        parentAsProject.removeElement(block);
                        parentAsProject.add(clonedBlock);
                    }
                }
                
                declaration = null;
            }
        }
        return declaration;
    }

}
