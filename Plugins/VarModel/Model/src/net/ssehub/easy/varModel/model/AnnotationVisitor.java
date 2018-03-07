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
package net.ssehub.easy.varModel.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Visits a certain set of annotation declarations and assignments (applying to a given scope) and allows processing 
 * all of them. 
 * 
 * @author Holger Eichelberger
 */
public abstract class AnnotationVisitor {

    /**
     * Processes an attribute assignment.
     * 
     * @param assng the assignment to be processed
     * @throws IvmlException in case of processing problems
     */
    protected abstract void processAttributeAssignment(AttributeAssignment assng) throws IvmlException;
   
        /**
     * Processes an attribute.
     * 
     * @param attr the attribute to process
     * @throws IvmlException in case of processing problems
     */
    protected abstract void processAttribute(Attribute attr) throws IvmlException;
    
    /**
     * Adds <code>element</code> to <code>scope</code> for starting iteration at <code>access</code>.
     * May be used to filter the scope. Called only for parents of <code>access</code>. 
     * <code>access</code> is included by default
     * 
     * @param scope the scope elements
     * @param element the element to be added
     * @param access the attribute access where to start at
     */
    protected void addToScope(Set<Object> scope, IModelElement element, IAttributeAccess access) {
        scope.add(element);
    }
    
    /**
     * Creates a new decision variable representing a specific decision.
     * 
     * @param access the element declaring the attributes 
     * @throws IvmlException in case of processing problems
     */
    public void visitAnnotations(IAttributeAccess access) throws IvmlException {
        if (!(access instanceof Attribute)) { // attributes of attributes are not allowed in IVML
            Set<Object> scope = new HashSet<Object>();
            scope.add(access);
            IModelElement parent = access.getParent();
            while (null != parent) {
                addToScope(scope, parent, access);
                if (parent instanceof AttributeAssignment) {
                    processAttributeAssignment((AttributeAssignment) parent);
                }
                parent = parent.getParent();
            }
            visitAnnotations(access, scope);
            parent = access.getParent();
            while (null != parent) {
                if (parent instanceof IAttributeAccess) {
                    visitAnnotations((IAttributeAccess) parent, scope);
                }
                parent = parent.getParent();
            }
        }
    }

    /**
     * Visits all annotations in <code>access</code>.
     * 
     * @param access the annotations to visit
     * @param scope valid elements an annotation may be attached to
     * @throws IvmlException in case of processing problems
     */ 
    private void visitAnnotations(IAttributeAccess access, Set<Object> scope) throws IvmlException {
        for (int a = 0; a < access.getAttributesCount(); a++) {
            Attribute attr = access.getAttribute(a);
            IAttributableElement elt = attr.getElement();
            if (null == elt || scope.contains(elt)) {
                processAttribute(access.getAttribute(a));
            }
        }
    }
    
}
