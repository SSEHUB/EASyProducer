/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.reasoning.core.reasoner;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

import net.ssehub.easy.varModel.model.Constraint;

/**
 * Implements the constraint base, a combination of linked list and map in order to 
 * quickly store, retrieve and delete constraints to be evaluated.
 * 
 * @author Holger Eichelberger
 */
public class ConstraintBase extends ConstraintList {

    private Map<Constraint, Node> mapping = new HashMap<Constraint, Node>();

    /**
     * Constructs an empty constraint base.
     */
    public ConstraintBase() {
        setModificationListener(new IModificationListener() {
            
            @Override
            public void notifyRemoved(Constraint constraint, Node node) {
                mapping.remove(constraint);
            }
            
            @Override
            public void notifyAdded(Constraint constraint, Node node) {
                mapping.put(constraint, node);
            }

            @Override
            public void notifyRemovedAll() {
                mapping.clear();
            }
            
        });
    }

    @Override
    public boolean contains(Constraint constraint) {
        return mapping.containsKey(constraint);
    }
    
    @Override
    public boolean removeAll(Collection<? extends Constraint> constraints) {
        Objects.requireNonNull(constraints);
        boolean modified = false;
        Iterator<?> it = constraints.iterator();
        while (it.hasNext()) {
            Node node = mapping.get(it.next());
            if (null != node) {
                unlink(node);
                modified = true;
            }
        }
        return modified;
    }

}
