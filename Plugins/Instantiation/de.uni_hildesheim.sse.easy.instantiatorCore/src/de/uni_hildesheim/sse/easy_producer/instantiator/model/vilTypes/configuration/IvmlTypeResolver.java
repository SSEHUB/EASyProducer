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

package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.Advice;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IDirectTypeRegistryAccess;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ITypeResolver;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.IVilType;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.ContainableModelElement;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.ModelQuery;
import de.uni_hildesheim.sse.model.varModel.ModelQueryException;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.CustomDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;

/**
 * A type resolver for IVML models.
 * 
 * @author Holger Eichelberger
 */
public class IvmlTypeResolver implements ITypeResolver {

    // switch to static creation of types for content assist
    private static final boolean STATIC = true;
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(IvmlTypeResolver.class, Bundle.ID);
    
    private IDirectTypeRegistryAccess access;
    private Project project;
    private TypeRegistry typeRegistry;
    private Map<IDatatype, Set<Attribute>> attributes = new HashMap<IDatatype, Set<Attribute>>();
    private Map<IDatatype, TypeDescriptor<?>> ivmlMap = new HashMap<IDatatype, TypeDescriptor<?>>();

    /**
     * Creates an IVML type resolver.
     * 
     * @param project the IVML model
     * @param typeRegistry the type registry this resolver is working for
     */
    public IvmlTypeResolver(Project project, TypeRegistry typeRegistry) {
        this.project = project;
        this.typeRegistry = typeRegistry;
        
        int eCount = project.getElementCount();
        for (int e = 0; e < eCount; e++) {
            ContainableModelElement elt = project.getElement(e);
            if (elt instanceof DecisionVariableDeclaration) {
                cacheVariable((DecisionVariableDeclaration) elt);
            }
        }
    }
    
    /**
     * Cache data about a variable.
     * 
     * @param var the variable to be cached
     */
    private void cacheVariable(DecisionVariableDeclaration var) {
        IDatatype type = var.getType();
        int aCount = var.getAttributesCount();
        if (aCount > 0) {
            Set<Attribute> aList = attributes.get(type);
            if (null == aList) {
                aList = new HashSet<Attribute>();
                attributes.put(type, aList);
            }
            for (int a = 0; a < aCount; a++) {
                aList.add(var.getAttribute(a));
            }
        }
    }
    
    @Override
    public TypeDescriptor<?> resolveType(String name, boolean addIfMissing) {
        TypeDescriptor<?> result = access.get(name);
        if (null == result) {
            try {
                IDatatype type = ModelQuery.findType(project, name, null);
                if (null != type) {
                    result = obtainType(type);
                } else {
                    Project tmp = ModelQuery.findProject(project, name);
                    if (null != tmp) {
                        result = new IvmlProjectTypeDescriptor(tmp, this);
                        ivmlMap.put(tmp.getType(), result);
                    }
                }
            } catch (ModelQueryException e) {
                LOGGER.warn(e.getMessage());
            } catch (VilException e) {
                LOGGER.warn(e.getMessage());
            }
        }
        if (null == result && addIfMissing) {
            try {
                if (null == Advice.getIvmlElement(project, name)) {
                    // automatically create fake types as having an IVML type resolver implies @advice
                    // but only for non-IVML-IDs such as enum values
                    result = new FakeTypeDescriptor(typeRegistry, name);
                    addType(name, result);
                }
            } catch (VilException e) {
                LOGGER.warn(e.getMessage()); // shall not occur
            }
        }
        return result;
    }
    
    /**
     * Obtains the VIL/VTL type for the given <code>type</code>. Create the type descriptor
     * dynamically if required. 
     * 
     * @param type the type to look for
     * @return the type descriptor
     * @throws VilException in case that creating the type descriptor fails
     */
    TypeDescriptor<?> obtainType(IDatatype type) throws VilException {
        TypeDescriptor<?> result = null;
        if (null != type) {
            result = access.get(type.getQualifiedName());
            if (null == result) {
                result = access.get(type.getName());
                if (null != result && !result.getQualifiedName().equals(type.getQualifiedName())) {
                    result = null;
                }
            }
            if (null == result) {
                IvmlTypeDescriptor itd = new IvmlTypeDescriptor(project, type, this);
                ivmlMap.put(type, itd);
                itd.resolve(project, type, attributes.get(type));
                result = itd;
            }
        }
        return result;
    }

    /**
     * Adds a type via a given name.
     * 
     * @param name the name of the type
     * @param type the type to be registered
     */
    void addType(String name, TypeDescriptor<?> type) {
        if (!isKnown(name)) {
            access.add(name, type);
        }
    }

    @Override
    public TypeDescriptor<? extends IVilType> resolveInstantiator(String name) {
        return null; // Do not create FakeType -> Serialization
    }
    
    /**
     * Returns whether the given type is already known.
     * 
     * @param name the name of the type
     * @return <code>true</code> if the type is already known, <code>false</code> else
     */
    public boolean isKnown(String name) {
        return access.contains(name);
    }

    @Override
    public TypeRegistry getTypeRegistry() {
        return typeRegistry;
    }

    @Override
    public void setRegistryAccess(IDirectTypeRegistryAccess access) {
        this.access = access;
        if (STATIC) {
            int eCount = project.getElementCount();
            for (int e = 0; e < eCount; e++) {
                ContainableModelElement elt = project.getElement(e);
                if (elt instanceof CustomDatatype) {
                    try {
                        obtainType((CustomDatatype) elt);
                    } catch (VilException ex) {
                        LOGGER.exception(ex);
                    }
                }
            }
        }
    }

    @Override
    public TypeDescriptor<?> resolveType(IDatatype type) {
        TypeDescriptor<?> result = ivmlMap.get(type);
        if (null == result) {
            try {
                result = obtainType(type);
            } catch (VilException e) {
                LOGGER.warn(e.getMessage()); // shall not occur
            }
        }
        return result;
    }
    
}
