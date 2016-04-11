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

import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.IModelVisitor;

/**
 * Temporary wrapper variable holding a variable which could not be translated at this point.
 * @author El-Sharkawy
 */
class UntranslatedDeclaration extends AbstractVariable {

    private AbstractVariable orgDeclaration;
    
    /**
     * Creates a new wrapper for a variable, which could not be translated at this point.
     * @param orgDeclaration The declaration, which could not be translated.
     */
    UntranslatedDeclaration(AbstractVariable orgDeclaration) {
        super(orgDeclaration.getName(), orgDeclaration.getType(), orgDeclaration.getParent());
        this.orgDeclaration = orgDeclaration;
    }
    
    /**
     * Returns the declaration, which could not be translated.
     * @return The declaration, which could not be translated.
     */
    AbstractVariable getDeclaration() {
        return orgDeclaration;
    }

    @Override
    public int getAttributesCount() {
        return orgDeclaration.getAttributesCount();
    }

    @Override
    public Attribute getAttribute(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Attribute getAttribute(int index) {
        return orgDeclaration.getAttribute(index);
    }

    @Override
    public void accept(IModelVisitor visitor) {
        orgDeclaration.accept(visitor);
    }

    @Override
    public boolean isTemporaryVariable() {
        return orgDeclaration.isTemporaryVariable();
    }

    @Override
    public boolean isAttribute() {
        return orgDeclaration.isAttribute();
    }
}
