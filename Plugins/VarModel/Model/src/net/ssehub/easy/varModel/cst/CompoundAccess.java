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

import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.values.MetaTypeValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Represents an expression which accesses a compound slot where
 * the compound is specified as a {@link ConstraintSyntaxTree}.
 * 
 * @author Holger Eichelberger
 */
public class CompoundAccess extends ConstraintSyntaxTree {
    
    private ConstraintSyntaxTree compoundExpression;
    private String slotName;
    private AbstractVariable slot; // lazy
    
    /**
     * Creates a compound access node.
     * 
     * @param compoundExpression an expression denoting a compound
     * @param slotName the name of the accessed slot
     */
    public CompoundAccess(ConstraintSyntaxTree compoundExpression, String slotName) {
        this.compoundExpression = compoundExpression;
        this.slotName = slotName;
    }

    /**
     * Searches for a slot in <code>comp</code> or its refined compounds.
     * @param comp the compound to search
     * @param slotName the name to search
     * @return the containing compound or <b>null</b>
     */
    private DecisionVariableDeclaration searchSlot(Compound comp, String slotName) {
        DecisionVariableDeclaration slot = comp.getElement(slotName);
        for (int r = 0; null == slot && r < comp.getRefinesCount(); r++) {
            slot = searchSlot(comp.getRefines(r), slotName);
        }
        return slot;
    }
    
    /**
     * Returns the static type in case that this compound access is a static access.
     * 
     * @return the static type or <b>null</b>
     * @throws CSTSemanticException in case of semantic errors
     */
    public IDatatype getStaticType() throws CSTSemanticException {
        IDatatype result = null;
        IDatatype cExpression = compoundExpression.inferDatatype();
        if (cExpression.isAssignableFrom(MetaType.TYPE)) {
            if (compoundExpression instanceof ConstantValue) {
                // ugly!
                Value value = ((ConstantValue) compoundExpression).getConstantValue();
                if (value instanceof MetaTypeValue) {
                    result = ((MetaTypeValue) value).getValue();
                }
            }
        }
        return result;
    }
    
    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        IDatatype result = null;
        if (null == slot) {
            IDatatype cExpression;
            IDatatype staticType = getStaticType();
            if (null != staticType) {
                cExpression = staticType;
            } else {
                cExpression = compoundExpression.inferDatatype();
            }
            cExpression = Reference.dereference(cExpression);
            if (cExpression.isAssignableFrom(MetaType.TYPE)) {
                if (cExpression instanceof ConstantValue) {
                    // ugly!
                    Value value = ((ConstantValue) cExpression).getConstantValue();
                    if (value instanceof MetaTypeValue) {
                        cExpression = ((MetaTypeValue) value).getValue();
                    }
                }
            }
            if (cExpression.isAssignableFrom(Compound.TYPE) && cExpression instanceof Compound) {
                Compound comp = (Compound) cExpression;
                slot = searchSlot(comp, slotName);
                if (null == slot) {
                    throw new CSTSemanticException("type '" + comp.getName() 
                        + "' does not have a slot named '" + slotName + "'", 
                        CSTSemanticException.UNKNOWN_ELEMENT);
                }
            } else {
                throw new CSTSemanticException("expression does not evaluate to a compound", 
                    CSTSemanticException.TYPE_MISMATCH);
            }
        } 
        if (null != slot) {
            result = slot.getType();
        }
        return result;
    }
    
    /**
     * The expression denoting the compound to access.
     * 
     * @return the compound expression
     */
    public ConstraintSyntaxTree getCompoundExpression() {
        return compoundExpression;
    }
    
    /**
     * Returns the name of the slot.
     * 
     * @return the name of the slot
     */
    public String getSlotName() {
        return slotName;
    }
    
    /**
     * Returns the resolved compound slot. The result is only valid if
     * {@link #inferDatatype()} was called before this operation.
     * 
     * @return the resolved slot, <b>null</b> if the slot cannot
     *   be resolved or {@link #inferDatatype()} was not called before
     */
    public AbstractVariable getResolvedSlot() {
        return slot;
    }

    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitCompoundAccess(this); // no further operations!
    }

    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj instanceof CompoundAccess) {
            CompoundAccess other = (CompoundAccess) obj;
            equals = slotName.equals(other.slotName);
            equals &= compoundExpression.equals(other.compoundExpression);
            if (null == slot) {
                equals &= null == other.slot;
            } else {
                equals &= slot.equals(other.slot);
            }
        }
        return equals;        
    }
    
    @Override
    public int hashCode() {
        int result = slotName.hashCode() + compoundExpression.hashCode();
        if (null != slot) {
            result += slot.hashCode();
        }
        return result;
    }

}
