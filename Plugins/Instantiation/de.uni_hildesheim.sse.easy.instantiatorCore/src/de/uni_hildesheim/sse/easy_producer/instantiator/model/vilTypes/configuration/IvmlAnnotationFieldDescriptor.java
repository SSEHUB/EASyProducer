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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.configuration;

import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationDescriptor.CompatibilityResult;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;

/**
 * Defines a pseudo field descriptor which enables comfortable access to an individual annotation
 * via its name.
 * 
 * @author Holger Eichelberger
 */
public class IvmlAnnotationFieldDescriptor extends AbstractIvmlFieldDescriptor {

    /**
     * Creates the operation descriptor for an annotation access.
     * 
     * @param declaringType the declaring type
     * @param annotation the annotation to create the descriptor for
     * @param registry the actual type registry 
     * @throws VilException in case that creating the descriptor fails
     */
    IvmlAnnotationFieldDescriptor(TypeDescriptor<?> declaringType, 
        de.uni_hildesheim.sse.model.varModel.Attribute annotation, TypeRegistry registry) throws VilException {
        super(declaringType, annotation, registry);
    }

    @Override
    public Object getValue(Object owner) throws VilException {
        Object result;
        if (null == owner) {
            result = null;
        } else {
            if (CompatibilityResult.COMPATIBLE == Utils.isCompatible(owner, DecisionVariable.class)) {
                result = ((DecisionVariable) owner).getAttribute(getName());
            } else if (CompatibilityResult.COMPATIBLE == Utils.isCompatible(owner, Configuration.class)) {
                result = ((Configuration) owner).getAttribute(getName());
            } else {
                throw new VilException("incompatible arguments", VilException.ID_TYPE_INCOMPATIBILITY);
            }
            if (result instanceof AbstractIvmlVariable) {
                AbstractIvmlVariable annotation = (AbstractIvmlVariable) result;
                if (getType().isCollection()) {
                    result = annotation.variables();
                } else {
                    Object tmp = getSpecificBaseValue(annotation);
                    if (null != tmp && annotation.isConfigured()) {
                        result = tmp;
                    }
                }
            }
        }
        return result;
    }
    
    @Override
    public void setValue(Object owner, Object value) throws VilException {
        if (null != owner) {
            IvmlElement elt;
            if (CompatibilityResult.COMPATIBLE == Utils.isCompatible(owner, DecisionVariable.class)) {
                elt = ((DecisionVariable) owner).getAttribute(getName());
            } else if (CompatibilityResult.COMPATIBLE == Utils.isCompatible(owner, Configuration.class)) {
                elt = ((Configuration) owner).getAttribute(getName());
            } else {
                throw new VilException("incompatible arguments", VilException.ID_TYPE_INCOMPATIBILITY);
            }
            if (elt instanceof AbstractIvmlVariable) {
                ((AbstractIvmlVariable) elt).setValue(value);
            } else {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).info("Configuration field " + getName() 
                    + " not accessible via byName");
            }
        }
    }

    @Override
    public Object getMetaValue(Object owner) throws VilException {
        Object result;
        if (CompatibilityResult.COMPATIBLE == Utils.isCompatible(owner, DecisionVariable.class)) {
            result = ((DecisionVariable) owner).getAttribute(getName());
        } else if (CompatibilityResult.COMPATIBLE == Utils.isCompatible(owner, Configuration.class)) {
            result = ((Configuration) owner).getAttribute(getName());
        } else {
            throw new VilException("incompatible arguments", VilException.ID_TYPE_INCOMPATIBILITY);
        }
        return result;
    }
    
}
