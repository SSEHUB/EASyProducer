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
package de.uni_hildesheim.sse.model.cst;

import java.util.Arrays;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;

/**
 * Represents a typed initializer for compounds. This initializer may contain expressions for initializing compound
 * slots. IVML: <code><i>Type</i>{<i>slot</i>=<i>expression</i>, ...}</code>. We need a special constraint tree 
 * node for this purpose as values form {@link de.uni_hildesheim.sse.model.varModel.values} are intended to be 
 * constants and, thus, cannot contain arbitrary expressions.
 * 
 * @author Holger Eichelberger
 */
public class CompoundInitializer extends ConstraintSyntaxTree {

    private Compound type;
    private ConstraintSyntaxTree[] expressions;
    private String[] slots;
    private AbstractVariable[] slotDecls;
   
    /**
     * Creates a new compound initializer. 
     * 
     * @param type the type of the compound
     * @param slots the names of the slots. Note that the index of the name denotes the slot related to the expression 
     *     at the same index position in <code>expressions</code>.
     * @param slotDecls the declarations of the slots. Note that the index of the name denotes the slot related to the 
     *     expression at the same index position in <code>expressions</code>.
     * @param expressions the initializing expressions. Note that the index of the expression denotes the slot related
     *     to the name at the same index position in <code>slots</code>.
     * @throws CSTSemanticException in case that the initialization fails
     */
    public CompoundInitializer(Compound type, String[] slots, AbstractVariable[] slotDecls, 
        ConstraintSyntaxTree[] expressions) throws CSTSemanticException {
        this.type = type;
        this.expressions = expressions;
        this.slots = slots;
        this.slotDecls = slotDecls;
        if (null == expressions) {
            throw new CSTSemanticException("expressions is null", CSTSemanticException.INTERNAL);
        }
        if (null == slots) {
            throw new CSTSemanticException("slots is null", CSTSemanticException.INTERNAL);
        }
        if (null == slotDecls) {
            throw new CSTSemanticException("slotDecls is null", CSTSemanticException.INTERNAL);
        }
        if (!(expressions.length == slots.length && slots.length == slotDecls.length)) {
            throw new CSTSemanticException("number of expressions is not equal to number of slots", 
                CSTSemanticException.INTERNAL);
        }
    }

    /**
     * Returns the type of the container.
     * 
     * @return the type of the container
     */
    public Compound getType() {
        return type;
    }
    
    /**
     * Returns the number of expressions / slots.
     * 
     * @return the number of expressions / slots
     */
    public int getSlotCount() {
        return slots.length;
    }

    /**
     * Returns the number of expressions / slots.
     * 
     * @return the number of expressions / slots
     */
    public int getExpressionCount() {
        return expressions.length;
    }
    
    /**
     * Returns the specified expression.
     * 
     * @param index the index of the expression to be returned
     * @return the specified expression
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getExpressionCount()}</code>
     */
    public ConstraintSyntaxTree getExpression(int index) {
        return expressions[index];
    }

    /**
     * Returns the specified slot name.
     * 
     * @param index the index of the expression to be returned
     * @return the specified slot name
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getSlotCount()}</code>
     */
    public String getSlot(int index) {
        return slots[index];
    }

    /**
     * Returns the declaration of the specified slot.
     * 
     * @param index the index of the expression to be returned
     * @return the specified slot declaration
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getSlotCount()}</code>
     */
    public AbstractVariable getSlotDeclaration(int index) {
        return slotDecls[index];
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(IConstraintTreeVisitor visitor) {
        visitor.visitCompoundInitializer(this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public IDatatype inferDatatype() throws CSTSemanticException {
        return type;
    }
    
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (obj instanceof CompoundInitializer) {
            CompoundInitializer other = (CompoundInitializer) obj;
            equals = type.getQualifiedName().equals(other.type.getQualifiedName()); // simple form of considering type
            equals &= Arrays.equals(expressions, other.expressions);
            equals &= Arrays.equals(slotDecls, other.slotDecls);
            equals &= Arrays.equals(slots, other.slots);
        }
        return equals;
    }
    
    @Override
    public int hashCode() {
        int hashCode = type.getQualifiedName().hashCode(); // simple form of considering type
        hashCode *= Arrays.hashCode(expressions);
        return hashCode;
    }

}
