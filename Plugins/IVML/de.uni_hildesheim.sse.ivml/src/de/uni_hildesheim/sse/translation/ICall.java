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
package de.uni_hildesheim.sse.translation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uni_hildesheim.sse.ivml.ActualParameterList;

/**
 * Abstracts over calls (feature call, set op).
 * 
 * @author Holger Eichelberger
 */
interface ICall {

    /**
     * Returns the name of the call.
     *  
     * @return the name
     */
    public String getName();

    /**
     * Returns the arguments.
     *  
     * @return the arguments (may be <b>null</b>)
     */
    public ActualParameterList getArguments();
    
    /**
     * Returns the cause in case of errors/warnings.
     * 
     * @return the cause
     */
    public EObject getCause();

    /**
     * Returns the exposed name feature in case of errors/warnings.
     * 
     * @return the name feature
     */
    public EStructuralFeature getNameFeature();

    /**
     * Returns the exposed argument feature in case of errors/warnings.
     * 
     * @return the name feature
     */
    public EStructuralFeature getArgumentsFeature();
    
}