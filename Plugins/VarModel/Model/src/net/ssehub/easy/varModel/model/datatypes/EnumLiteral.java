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
package net.ssehub.easy.varModel.model.datatypes;

import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.ModelElement;

/** 
 * Objects represents the literal of an enum.
 * 
 * @author heiko beck
 * @author Holger Eichelberger
 **/

public class EnumLiteral extends ModelElement {

    private int ordinal;
    private IModelElement parent;
    
    /**
     * Constructor for the enum literal.
     * @param name Name of the enum literal
     * @param ord the ordinal number of this literal
     * @param parent the parent enum
     */
    public EnumLiteral(String name, int ord, Enum parent) {
        super(name);
        this.ordinal = ord;
        this.parent = parent;
    }
    
    /**
     * Returns the ordinal number of this literal.
     * 
     * @return the ordinal number
     */
    public int getOrdinal() {
        return ordinal;
    }
    
    @Override
    public void accept(IModelVisitor visitor) {
        visitor.visitEnumLiteral(this);
    }
    
    @Override
    public IModelElement getParent() {
        return parent;
    }

    @Override
    public boolean equals(Object object) {
        boolean result;
        if (object instanceof EnumLiteral) {
            EnumLiteral lit = (EnumLiteral) object;
            result = getName().equals(lit.getName()) && ordinal == lit.getOrdinal() && parent == lit.getParent();
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return getName().hashCode() + ordinal + parent.hashCode();
    }

}
