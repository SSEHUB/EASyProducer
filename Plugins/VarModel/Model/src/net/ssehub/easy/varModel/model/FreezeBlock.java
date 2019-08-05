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
package net.ssehub.easy.varModel.model;

import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;

/**
 * Handles frozen elements.
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public class FreezeBlock extends EvaluationBlock {
    
    private IFreezable[] freezables;
    private DecisionVariableDeclaration iter;
    private ConstraintSyntaxTree selector;

    /**
     * Constructor for serialization.
     */
    FreezeBlock() {
        super(null, null);
    }
    
    /**
     * Constructor for containable model element.
     * 
     * @param freezables the elements which may be frozen (depends on <code>buts</code>)
     * @param iter the iterator variable for <code>selector</code>, may be <b>null</b>
     * @param selector the selector expression using <code>iter</code>, may be <b>null</b>
     * @param parent the object, in which this specific one is embedded
     */
    public FreezeBlock(IFreezable[] freezables, DecisionVariableDeclaration iter, ConstraintSyntaxTree selector, 
        IModelElement parent) {
        super(null, parent);
        this.freezables = freezables;
        this.iter = iter;
        this.selector = selector;
    }

    @Override
    public void accept(IModelVisitor visitor) {
        visitor.visitFreezeBlock(this);
    }
    
    /**
     * Returns the internal type of this block.
     * 
     * @return the internal type
     */
    public IDatatype getType() {
        return null != iter ? iter.getType() : null;
    }
    
    /**
     * Returns the selector.
     * 
     * @return the selector (may be <b>null</b>)
     */
    public ConstraintSyntaxTree getSelector() {
        return selector;
    }
    
    /**
     * Returns the iterator variable.
     * 
     * @return the iterator variable (may be <b>null</b>)
     */
    public DecisionVariableDeclaration getIter() {
        return iter;
    }
    
    /**
     * Returns the number of freezables.
     * 
     * @return the number of freezables
     */
    public int getFreezableCount() {
        return freezables.length;
    }
    
    /**
     * Returns a specific freezable.
     * 
     * @param index the index of the freezable
     * @return the freezable
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getFreezableCount()}</code>
     */
    public IFreezable getFreezable(int index) {
        return freezables[index];
    }

    @Override
    public String toString() {
        return "FreezeBlock";
    }

}
