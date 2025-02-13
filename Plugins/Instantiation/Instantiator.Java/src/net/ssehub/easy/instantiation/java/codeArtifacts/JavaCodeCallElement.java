/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.java.codeArtifacts;

import net.ssehub.easy.instantiation.core.model.vilTypes.IVilType;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;

/**
 * An element to which we can add a method call. The code may be nested, chained, depending on the semantics of the
 * implementing element.
 * 
 * @author Holger Eichelberger
 */
public interface JavaCodeCallElement extends IVilType {

    /**
     * Adds a non-static method call.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @return the method call (for chaining)
     */
    @OperationMeta(name = {"addCall", "call"})
    public JavaCodeMethodCall addCall(String methodName);

    /**
     * Adds a qualified non-static method call where the class (but not the method) shall be imported, i.e., calls 
     * {@link #addCall(String, JavaCodeImportScope)} with {@link JavaCodeImportScope#METHOD_CLASS_IMPORT}.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @return the method call (for chaining)
     */
    @OperationMeta(name = "callQualified")
    public JavaCodeMethodCall addCallQualified(String methodName);

    /**
     * Adds a method call.
     * 
     * @param methodName the method name, qualified or statically qualified expression to call the method
     * @param scope the import scope
     * @return the method call (for chaining)
     */
    @OperationMeta(name = {"addCall", "call"})
    public JavaCodeMethodCall addCall(String methodName, JavaCodeImportScope scope);

}
