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
package net.ssehub.easy.instantiation.core.model.templateModel;

import net.ssehub.easy.instantiation.core.model.common.Typedef;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * A specific typedef version for VTL.
 * 
 * @author Holger Eichelberger
 */
public class TypeDef extends Typedef implements ITemplateLangElement {

    private Template parent;

    /**
     * Creates a typedef.
     * 
     * @param name the alias name
     * @param type the type to be used for <code>name</code>
     * @param parent the parent template
     * @throws VilException if one  of the arguments is invalid
     */
    public TypeDef(String name, TypeDescriptor<?> type, Template parent) throws VilException {
        super(name, type);
        this.parent = parent;
    }

    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return super.accept(visitor);
    }

    @Override
    public Template getParent() {
        return parent;
    }

}
