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
package net.ssehub.easy.varModel.model.filter.mandatoryVars;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Stores knowledge about the current constraint visitation (the context of earlier elements).
 * @author El-Sharkawy
 */
class Context {
    private Deque<String> currentParents;
    private int depth;
    private boolean elementsFound;
    
    /**
     * Constructor for this class.
     */
    Context() {
        depth = 0;
        currentParents = new ArrayDeque<String>();
        elementsFound = false;
    }

    /**
     * Should be called after a constraint was visited completly, to clear the data.
     */
    void clear() {
        depth = 0;
        currentParents.clear();
        elementsFound = false;
    }
    
    /**
     * Marks that a compound(access) was visited and that now a slot is visited of the compound.
     * @see #compoundUp()
     */
    void compoundDown() {
        depth++;
    }
    
    /**
     * A compound(slot) was visited, back to upper compound.
     * @see #compoundDown()
     */
    void compoundUp() {
        depth--;
    }
    
    /**
     * Returns the depth, a depth &gt; 0 means that currently a slot of a compound is visited).
     * @return A value &gt;= 0.
     */
    int depth() {
        return depth;
    }
    
    /**
     * Returns whether currently a qualified name for a
     * {@link net.ssehub.easy.varModel.confModel.IDecisionVariable} as parent is stored
     * for the current visitation.
     * @return <tt>true</tt> a parent exists for the current visited variable.
     * @see #getParent()
     * @see #addParent(String)
     */
    boolean hasParent() {
        return !currentParents.isEmpty();
    }
    
    /**
     * Returns the current visited parent of the current variable.
     * @return The parent.
     * @see #hasParent()
     * @see #addParent(String)
     */
    String getParent() {
        return currentParents.peekFirst();
    }
    
    /**
     * Adds a parent, e.g. if a compound access is visited.
     * @param parent The current visited variable, before the visitation of the slot starts.
     * @see #getParent()
     * @see #hasParent()
     */
    void addParent(String parent) {
        currentParents.addFirst(parent);
    }
    
    /**
     * Marks that at least one variable was found during the current constraint visitation.
     * @see #elementsWereFound()
     */
    void elementFound() {
        elementsFound = true;
    }
    
    /**
     * Returns whether variables were changed during the current constraint visitation.
     * @return <tt>true</tt>At least one variable was found.
     * @see #elementFound()
     */
    boolean elementsWereFound() {
        return elementsFound;
    }
}
