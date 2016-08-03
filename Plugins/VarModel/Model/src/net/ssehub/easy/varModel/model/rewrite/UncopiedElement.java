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
package net.ssehub.easy.varModel.model.rewrite;

import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.rewrite.UncopiedElementsContainer.UnresolvedSyntaxContainer;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Containes description over elements which could not be copied by the {@link ProjectCopyVisitor}.
 * @author El-Sharkawy
 *
 */
public class UncopiedElement {
    
    private String type;
    private String name;
    private String parentName;
    private String uncopiedPart;

    /**
     * Constructor for a containable model element.
     * @param originalElement An element which could not be copied.
     */
    UncopiedElement(ContainableModelElement originalElement) {
        type = originalElement.getClass().getSimpleName();
        name = originalElement.getName();
        IModelElement parent = originalElement.getParent();
        parentName = null != parent ? parent.getName() : null;
        uncopiedPart = StringProvider.toIvmlString(originalElement);
    }
    
    /**
     * Constructor for an {@link UnresolvedSyntaxContainer}.
     * @param cstContainer An element which could not be copied.
     */
    UncopiedElement(UncopiedElementsContainer.UnresolvedSyntaxContainer cstContainer) {
        this(cstContainer.getCopiedParent());
        uncopiedPart = StringProvider.toIvmlString(cstContainer.getOriginalSyntax());
    }
    
    /**
     * Constructor for an {@link UnresolvedAnnotationAssignment}.
     * @param assignment An element which could not be copied.
     */
    UncopiedElement(UncopiedElementsContainer.UnresolvedAnnotationAssignment assignment) {
        this(assignment.getCopiedParent());
        type = assignment.getUnresolvedAssignment().getClass().getSimpleName();
        uncopiedPart = StringProvider.toIvmlString(assignment.getUnresolvedAssignment().getExpression());
    }
    
    /**
     * Returns the type (class), which could not be copied.
     * @return The type (class).
     */
    public String getType() {
        return type;
    }
    
    /**
     * The name of the element, which could not be copied.
     * @return The name of the element
     */
    public String getName() {
        return name;
    }
    
    /**
     * The name of the parent.
     * @return The name of the parent
     */
    public String getParentName() {
        return parentName;
    }
    
    /**
     * The element itself, whoch could not be copied.
     * @return {@link StringProvider#toIvmlString(net.ssehub.easy.varModel.model.ModelElement)}.
     */
    public String getUncopiedPart() {
        return uncopiedPart;
    }
    
    /**
     * Returns a default description of the element, using all the other getters.
     * @return A default message, which may be used for debugging.
     */
    public String getDescription() {
        StringBuffer description = new StringBuffer("Element \"");
        description.append(type);
        description.append(" ");
        description.append(name);
        description.append("\" in parent \"");
        description.append(parentName);
        description.append("\" problematic part: ");
        description.append(uncopiedPart);
        
        return description.toString();
    }
    
    @Override
    public String toString() {
        return getDescription();
    }
}
