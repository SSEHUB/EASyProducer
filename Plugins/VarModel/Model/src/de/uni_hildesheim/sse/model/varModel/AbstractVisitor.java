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
package de.uni_hildesheim.sse.model.varModel;

import de.uni_hildesheim.sse.model.varModel.datatypes.Compound;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.OrderedEnum;

/**
 * An abstract visitor which performs a default traversal
 * of the various sets of elements in the model. Sets of 
 * elements are visited in the order they are stored.
 * This class is intended for reuse of frequently used visiting
 * sequences, i.e. a convenience class. You may implement your own
 * visitor from scratch or override individual methods if needed.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractVisitor implements IModelVisitor {

    /**
     * {@inheritDoc}
     * <i>Sequence:</i> imports, contained elements.
     */
    public void visitProject(Project project) {
        int count;
        //Projects imports
        count = project.getImportsCount();
        for (int p = 0; p < count; p++) {
            project.getImport(p).accept(this);
        }
        //Elements on top layer inside the project
        count = project.getElementCount();
        for (int c = 0; c < count; c++) {
            project.getElement(c).accept(this);
        }
    }
    
    /**
     * {@inheritDoc}
     * <i>Sequence:</i> literals.
     */
    public void visitEnum(Enum eenum) {
        int count = eenum.getLiteralCount();
        for (int e = 0; e < count; e++) {
            eenum.getLiteral(e).accept(this);
        }
    }

    /**
     * {@inheritDoc}
     * <i>Sequence:</i> literals.
     */
    public void visitOrderedEnum(OrderedEnum eenum) {
        int count = eenum.getLiteralCount();
        for (int e = 0; e < count; e++) {
            eenum.getLiteral(e).accept(this);
        }
    }
    
    /**
     * {@inheritDoc}
     * <i>Sequence:</i> elements.
     */
    public void visitCompound(Compound compound) {
        int count = compound.getElementCount();
        for (int e = 0; e < count; e++) {
            compound.getElement(e).accept(this);
        }
        count = compound.getConstraintsCount();
        for (int c = 0; c < count; c++) {
            compound.getConstraint(c).accept(this);
        }
    }
    
}
