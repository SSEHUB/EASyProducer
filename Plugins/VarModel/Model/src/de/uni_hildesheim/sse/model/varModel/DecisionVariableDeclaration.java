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

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.Bundle;
import de.uni_hildesheim.sse.model.cst.CSTSemanticException;
import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.modelManagement.IVariable;

/**
 * Implements a decision variable.
 * 
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public class DecisionVariableDeclaration extends AbstractVariable 
    implements IFreezable, IAttributableElement, IVariable {

    // lazy initialization
    private List<Attribute> attributes;
    
    /**
     * Constructor for decision variable declaration.
     * @param name Name of the decision variable declaration
     * @param type type of the new VariableDeclaration
     * @param parent the object, in which this specific one is embedded
     */
    public DecisionVariableDeclaration(String name, IDatatype type, IModelElement parent) {
        super(name, type, null, parent);
    }
    
    @Override
    public void accept(IModelVisitor visitor) {
        visitor.visitDecisionVariableDeclaration(this);
    }

    /**
     * Adds an attribute.
     * 
     * @param attribute the attribute to be added
     * @return <code>true</code> if the operation was successful,
     *   <code>false</code> if the element is about being attributed 
     *   multiple times with the same attribute
     */
    private boolean addAttribute(Attribute attribute) {
        if (null == attributes) {
            attributes = new ArrayList<Attribute>();
        }
        boolean found = false;
        for (int a = 0; !found && a < attributes.size(); a++) {
            found = attributes.get(a).getName().equals(attribute.getName());
            // consider namespace?
        }
        if (!found) {
            attributes.add(attribute);
        }
        return !found;
    }
    
    /**
     * Attributes this element.
     * 
     * @param attribute the attribute to be added
     * @return <code>true</code> if the operation was successful,
     *   <code>false</code> if the element is about being attributed 
     *   multiple times with the same attribute
     */
    public boolean attribute(Attribute attribute) {
        return addAttribute(attribute);
    }
    
    /**
     * Returns the number of attributes.
     * 
     * @return the number of attributes
     */
    public int getAttributesCount() {
        return null == attributes ? 0 : attributes.size();
    }
    
    /**
     * Returns a specific attribute.
     * 
     * @param index the index of the attribute
     * @return the attribute
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getAttributesCount()}</code>
     */
    public Attribute getAttribute(int index) {
        if (null == attributes) {
            throw new IndexOutOfBoundsException();
        }
        return attributes.get(index);
    }
    
    /**
     * Returns a specific attribute.
     * 
     * @param name the name of the attribute
     * @return the attribute (or <b>null</b> if not found)
     */
    public Attribute getAttribute(String name) {
        Attribute result = null;
        if (null != attributes) {
            for (int a = 0; null == result && a < attributes.size(); a++) {
                Attribute attr = attributes.get(a);
                if (attr.getName().equals(name)) {
                    result = attr;
                }
            }
        }
        return result;
    }
    
    @Override
    public boolean isTemporaryVariable() {
        return getParent() instanceof Constraint; // not nice :(
    }
    
    /**
     * Returns whether this variable is an attribute.
     * 
     * @return <code>true</code> if it is an attribute, <code>false</code> else
     */
    public boolean isAttribute() {
        return false;
    }

    @Override
    public boolean propagateAttribute(Attribute attribute) {
        Attribute att = new Attribute(attribute.getName(), attribute.getType(), getParent(), this);
        ConstraintSyntaxTree deflt = attribute.getDefaultValue();
        if (null != deflt) {
            try {
                att.setValue(deflt);
            } catch (ValueDoesNotMatchTypeException e) {
                logger().exception(e);
            } catch (CSTSemanticException e) {
                logger().exception(e);
            }
        }
        return addAttribute(att);
    }
    
    /**
     * Logger.
     * @return logger
     */
    private static EASyLogger logger() {
        return EASyLoggerFactory.INSTANCE.getLogger(DecisionVariableDeclaration.class, Bundle.ID);
    }
    
}
