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
package net.ssehub.easy.varModel.cst;

/**
 * Searches a constraint for the occurrence of <code>self</code>.
 * 
 * @author Holger Eichelberger
 */
public class ContainsSelfVisitor extends AbstractConstraintTreeVisitor {

    private boolean containsSelf = false;

    /**
     * Creates the visitor instance.
     */
    public ContainsSelfVisitor() {
    }
    
    /**
     * Returns after accept whether the accepted constraint tree contains a <code>self</code>.
     * 
     * @return <code>true</code> for at least one self, <code>false</code> else
     */
    public boolean containsSelf() {
        return containsSelf;
    }
    
    /**
     * Clears the visitor for reuse.
     */
    public void clear() {
        containsSelf = false;
    }

    /**
     * Returns after accept whether the accepted constraint tree contains a <code>self</code>. Clears the visitor.
     * 
     * @return <code>true</code> for at least one self, <code>false</code> else
     */
    public boolean containsSelfAndClear() {
        boolean result = containsSelf;
        clear();
        return result;
    }
    
    @Override
    public void visitSelf(Self self) {
        containsSelf = true;
    }

}
