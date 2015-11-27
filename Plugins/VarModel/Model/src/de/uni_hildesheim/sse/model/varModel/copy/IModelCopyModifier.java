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
package de.uni_hildesheim.sse.model.varModel.copy;

import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;

/**
 * Optional Rule how to handle elements of a {@link de.uni_hildesheim.sse.model.varModel.Project}, while creating a
 * copy using the {@link ProjectCopyVisitor}.
 * @param <M> Type of {@link ContainableModelElement}s, which shall be handled by this class.
 * @author El-Sharkawy
 *
 */
public interface IModelCopyModifier<M extends ContainableModelElement> {
    
    /**
     * Specification for which kind of classes this may be applied to.
     * @return The {@link ContainableModelElement}s which shall be modified by this class.
     */
    public Class<? extends ContainableModelElement> getModifyingModelClass();
    
    /**
     * Specification how to handle {@link ContainableModelElement}s. 
     * @param element A {@link ContainableModelElement} which may be modified by this class.
     * @return The modified element. Maybe the same instance as passed as parameter (if nothing should be changed) or
     * <tt>null</tt> if the element should be deleted.
     */
    public ContainableModelElement handleModelElement(ContainableModelElement element);

}
