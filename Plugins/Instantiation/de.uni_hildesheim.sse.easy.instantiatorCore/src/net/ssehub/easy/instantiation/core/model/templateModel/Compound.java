/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.CompoundTypeDescriptor;

/**
 * Implements a compound type declaration for VIL.
 * 
 * @author Holger Eichelberger
 */
public class Compound extends net.ssehub.easy.instantiation.core.model.common.Compound implements ITemplateLangElement {

    private Template parent;

    /**
     * Creates a compound.
     * 
     * @param type the type of the compound
     * @param parent the parent template
     */
    public Compound(CompoundTypeDescriptor type, Template parent) {
        super(type);
        this.parent = parent;
    }

    @Override
    public Template getParent() {
        return parent;
    }

    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return super.accept(visitor);
    }

}
