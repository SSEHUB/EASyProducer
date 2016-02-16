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
package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;

/**
 * Implements a reflection constructor descriptor.
 * 
 * @author Holger Eichelberger
 */
public class ReflectionConstructorDescriptor extends OperationDescriptor implements ILazyDescriptor {

    private Constructor<?> constructor;

    /**
     * Creates a reflection constructor descriptor.
     * 
     * @param declaringType the declaring type
     * @param constructor the constructor
     */
    public ReflectionConstructorDescriptor(TypeDescriptor<?> declaringType, Constructor<?> constructor) {
        super(declaringType, "create", true);
        this.constructor = constructor;
    }
    
    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public boolean isFirstParameterOperand() {
        return false;
    }

    @Override
    public boolean isPlaceholder() {
        return false;
    }

    @Override
    protected void initializeParameters() {
        Class<?>[] params = constructor.getParameterTypes();
        ArrayList<TypeDescriptor<?>> parameters = new ArrayList<TypeDescriptor<?>>();
        for (int i = 0; i < params.length; i++) {
            parameters.add(ReflectionResolver.resolveType(params[i], getParameterGenerics(i)));
        }
        setParameters(parameters, false, false);
    }
    
    /**
     * Determines the generic type of a parameter.
     * 
     * @param index the index of the parameter
     * @return the generics (<b>null</b> if none are specified)
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;= {@link #getParameterCount()}</code>
     */
    protected Class<?>[] getParameterGenerics(int index) {
        return null; // legacy
    }

    @Override
    protected void initializeReturnType() {
        setReturnType(getDeclaringType());
    }

    @Override
    protected String getDeclaringTypeNameFallback() {
        return constructor.getDeclaringClass().getName();
    }

    @Override
    public String getJavaSignature() {
        return SignatureUtils.getJavaSignature("<init>", constructor.getParameterTypes(), null, false);
    }

    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        Class<?>[] par = constructor.getParameterTypes();
        boolean cannotEvaluate = true;
        boolean compatible = (null == params ? 0 : params.length) == par.length;
        if (null != retType) {
            compatible &= constructor.getDeclaringClass().isAssignableFrom(retType);
        }
        for (int p = 0; p < par.length; p++) { // no early end!
            Class<?> cls;
            if (null != params[p]) {
                if (params[p] instanceof Class) {
                    cls = (Class<?>) params[p];
                } else {
                    cls = params[p].getClass();
                }
            } else {
                cls = Void.TYPE;
            }
            boolean parCompatible = par[p].isAssignableFrom(cls) // instances match?
                || (par[p] == Class.class && params[p] instanceof Class); // parameter is class
            if (!parCompatible) {
                cannotEvaluate &= params[p] == null;
            }
            compatible &= parCompatible;
        }
        CompatibilityResult result;
        if (compatible) {
            result = CompatibilityResult.COMPATIBLE;
        } else {
            if (cannotEvaluate) {
                result = CompatibilityResult.ARG_EVALUATION_FAILED;
            } else {
                result = CompatibilityResult.INCOMPATIBLE;
            }
        }
        return result;
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        try {
            convertVariables(args);
            return constructor.newInstance(args);
        } catch (InstantiationException e) {
            throw new VilException(composeExceptionMessage(e, args), VilException.ID_RUNTIME);
        } catch (IllegalAccessException e) {
            throw new VilException(composeExceptionMessage(e, args), VilException.ID_RUNTIME);
        } catch (IllegalArgumentException e) {
            throw new VilException(composeExceptionMessage(e, args), VilException.ID_RUNTIME);
        } catch (InvocationTargetException e) {
            throw new VilException(composeExceptionMessage(e, args), VilException.ID_RUNTIME);
        }
    }

    @Override
    public int useGenericParameterAsReturn() {
        return -1; // never, is constructor
    }
    
    @Override
    public int useParameterAsReturn() {
        return -1; // never, is constructor
    }

    @Override
    public boolean storeArtifactsBeforeExecution() {
        return false;
    }

    @Override
    public void forceInitialization() {
        initializeParameters();
    }
    
    /**
     * Returns the wrapped constructor.
     * 
     * @return the wrapped constructor
     */
    protected Constructor<?> getConstructor() {
        return constructor;
    }

}
