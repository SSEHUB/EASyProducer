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
package net.ssehub.easy.varModel.model.rewrite.modifier;

import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.rewrite.RewriteContext;

/**
 * A {@link IModelElementFilter} to specify that a certain sub class of {@link ContainableModelElement} should be
 * generally omitted.
 * @author El-Sharkawy
 *
 */
public class ModelElementFilter implements IModelElementFilter<ContainableModelElement> {

    private Class<? extends ContainableModelElement> ommitingClass;
    
    /**
     * Default constructor for this class.
     * @param ommitingClass The sub class of {@link ContainableModelElement}, which shall be filtered while copying a
     * {@link net.ssehub.easy.varModel.model.Project}.
     */
    public ModelElementFilter(Class<? extends ContainableModelElement> ommitingClass) {
        this.ommitingClass = ommitingClass;
    }
    
    @Override
    public Class<? extends ContainableModelElement> getModifyingModelClass() {
        return ommitingClass;
    }

    @Override
    public ContainableModelElement handleModelElement(ContainableModelElement element, RewriteContext context) {
        return null;
    }

}
