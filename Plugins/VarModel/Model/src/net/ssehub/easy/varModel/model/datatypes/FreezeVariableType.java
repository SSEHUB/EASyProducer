/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.model.datatypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.ContainableModelElement;
import net.ssehub.easy.varModel.model.IFreezable;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IModelVisitor;
import net.ssehub.easy.varModel.model.Project;

/**
 * An internal type for freezes to iterate / specify expressions on freezables.
 * 
 * @author Holger Eichelberger
 */
public class FreezeVariableType extends StructuredDatatype {
    
    // DO !NOT! touch the // checkstyle: comments!

    // checkstyle: stop declaration order check
    static final DelegatingType DTYPE = new DelegatingType(AnyType.DTYPE);

    /**
     * This constant represents the common type of all freeze variables. Each specific freeze variable type 
     * is assignable to this type.
     */
    public static final IDatatype TYPE = DTYPE;

    public static final Operation NAME = new Operation(StringType.TYPE, "name", TYPE);
    public static final Operation NAME2 = new Operation(StringType.TYPE, "getName", TYPE);
    public static final Operation QNAME = new Operation(StringType.TYPE, "qualifiedName", TYPE);
    public static final Operation QNAME2 = new Operation(StringType.TYPE, "getQualifiedName", TYPE);

    // checkstyle: resume declaration order check

    static {
        DTYPE.setDelegate(new FreezeVariableType());
        DTYPE.addOperation(NAME);
        DTYPE.addOperation(NAME2);
        DTYPE.addOperation(QNAME);
        DTYPE.addOperation(QNAME2);
    }
    
    private List<Attribute> attributes = new ArrayList<Attribute>();

    /**
     * Creates the singleton instance for {@link #TYPE}.
     */
    private FreezeVariableType() {
        this(null, null);
    }

    /**
     * Constructor for a specific freeze variable type.
     * 
     * @param freezables the freezables to derive the structure of this type from
     * @param parent the object, in which this specific one is embedded
     */
    public FreezeVariableType(IFreezable[] freezables, IModelElement parent) {
        super("<FreezeVariable>", DTYPE, parent);
        if (null != freezables) {
            Map<String, Attribute> attributes = new HashMap<String, Attribute>();
            for (IFreezable freezable : freezables) {
                indexAttributes(freezable, attributes);
            }
            if (parent instanceof Project) {
                Project prj = (Project) parent;
                for (int e = 0; e < prj.getElementCount(); e++) {
                    ContainableModelElement elt = prj.getElement(e);
                    if (elt instanceof Attribute) {
                        Attribute attr = (Attribute) elt;
                        Attribute known = attributes.get(attr.getName());
                        if (null == known) {
                            attributes.put(attr.getName(), attr);
                        }
                    }
                }
            }
            for (Attribute attr : attributes.values()) {
                addAttribute(attr);
            }
        }
    }
    
    /**
     * Indexes all attributes for adding them to the internal type.
     * 
     * @param freezable the freezable to be analyzed
     * @param attributes the name-attributes map (modified as a side effect)
     */
    private void indexAttributes(IFreezable freezable, Map<String, Attribute> attributes) {
        IFreezable elt = freezable;
        do {
            for (int a = 0; a < freezable.getAttributesCount(); a++) {
                Attribute attr = freezable.getAttribute(a);
                Attribute known = attributes.get(attr.getName());
                if (null == known) {
                    attributes.put(attr.getName(), attr);
                } /*else if (!TypeQueries.sameTypes(attr.getType(), known.getType())) {
                    // TODO handle warning
                }*/
            }
            IModelElement par = elt.getParent();
            if (par instanceof IFreezable) {
                elt = (IFreezable) par;
            } else {
                elt = null;
            }
        } while (null != elt);
    }

    @Override
    public void accept(IModelVisitor visitor) {
        // not visitable as internal/temporary
    }
    
    @Override
    public boolean isAssignableFrom(IDatatype type) {
        return super.isAssignableFrom(type) || this == type;
    }
    
    /**
     * Adds an attribute to this type.
     * 
     * @param attribute the attribute to be added
     */
    void addAttribute(Attribute attribute) {
        attributes.add(attribute);
    }
    
    /**
     * Returns the number of attributes.
     * 
     * @return the number of attributes
     */
    public int getAttributesCount() {
        return attributes.size();
    }

    /**
     * Returns the specified attribute.
     * 
     * @param index the 0-based index of the attribute to return
     * @return the specified attribute
     * @throws IndexOutOfBoundsException if <code>index&lt;0 || index&gt;={@link #getAttributesCount()}</code>
     */
    public Attribute getAttribute(int index) {
        return attributes.get(index);
    }
    
    /**
     * Returns the attribute of the given <code>name</code>.
     * 
     * @param name the name of the attribute
     * @return the attribute or <b>null</b> if none was found
     */
    public Attribute getAttribute(String name) {
        Attribute result = null;
        for (int a = 0; null == result && a < attributes.size(); a++) {
            Attribute attr = attributes.get(a);
            if (attr.getName().equals(name)) {
                result = attr;
            }
        }
        return result;
    }
    
}