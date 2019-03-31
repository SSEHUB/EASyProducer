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
package net.ssehub.easy.varModel.cst;

import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * A variable which represents an attribute. However, access to an attribute
 * may be qualified, e.g. via a {@link CompoundAccess}, i.e., <code>qualifier.attribute</code>
 * whereby qualifier may even be <code>c.a.attribute</code> of unlimited nesting. 
 * However, the attribute shall point to the original definition of the attribute
 * variable. This class is a (polymorphic)
 * subclass of {@link Variable} as it just adds an attribute (and helps saving
 * memory in case that the qualifying attribute is not needed).
 * 
 * @author Holger Eichelberger
 */
public class AttributeVariable extends Variable {

    private ConstraintSyntaxTree qualifier;
    
    /**
     * Creates an attribute variable.
     * 
     * @param qualifier an optional expression required to uniquely address the specific
     *   variable the <code>attribute</code> is referring to (may be <b>null</b>)
     * @param attribute the attribute (as variable)
     */
    public AttributeVariable(ConstraintSyntaxTree qualifier, Attribute attribute) {
        super(attribute);
        this.qualifier = qualifier;
    }

    /**
     * Returns the qualifier for accessing the variable, e.g., an expression
     * to be put before.
     * 
     * @return the qualifier (may be <b>null</b>)
     */
    @Override
    public ConstraintSyntaxTree getQualifier() {
        return qualifier;
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj instanceof AttributeVariable) {
            equals = super.equals(obj);
            if (null != qualifier) {
                equals &= qualifier.equals(((AttributeVariable) obj).qualifier);
            }
        }
        return equals;        
    }
    
    @Override
    public int hashCode() {
        return super.hashCode() + (null != qualifier ? qualifier.hashCode() : 0);
    }
    
    @Override
    public String toString() {
        return qualifier != null ? qualifier.toString() + "." + getVariable().getName() : super.toString();
    }
    
    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitAnnotationVariable(this);
    }
    
    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        if (null != qualifier) {
            qualifier.inferDatatype();
        }
        return super.inferDatatype();
    }
}
