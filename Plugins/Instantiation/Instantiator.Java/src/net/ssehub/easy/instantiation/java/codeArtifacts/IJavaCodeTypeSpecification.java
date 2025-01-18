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

import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * Interface for a Java type specification/use. Qualified type specifications shall potentially lead to an import.
 *  
 * @author Holger Eichelberger
 */
public interface IJavaCodeTypeSpecification extends IJavaCodeElement, Storable {

    public static final String VARARG_TYPE_POSTFIX = "...";

    /**
     * Returns the output type name (plain name, potentially unqualified, without generics).
     * 
     * @return the name
     */
    @Invisible(inherit = true)
    public String getOutputTypeName();
    
    /**
     * Changes the output type name, e.g., upon import registration.
     * 
     * @param typeName the new output type name
     */
    @Invisible(inherit = true)
    public void setOutputTypeName(String typeName);

    /**
     * Changes the vararg flag.
     * 
     * @param varArg whether the type is a vararg type
     */
    @Invisible(inherit = true)
    public void setVarArg(boolean varArg);
    
    /**
     * Returns the number of generics.
     * 
     * @return the number of generics
     */
    @Invisible(inherit = true)
    public int getGenericCount();
    
    /**
     * Returns the specific generic type specification.
     * 
     * @param index the 0-based index of the generic
     * @return the generic
     * @throws IndexOutOfBoundsException if {@code index}&lt;0 || {@code index}&gt;{@link #getGenericCount()}
     */
    @Invisible(inherit = true)
    public IJavaCodeTypeSpecification getGeneric(int index);
    
}
