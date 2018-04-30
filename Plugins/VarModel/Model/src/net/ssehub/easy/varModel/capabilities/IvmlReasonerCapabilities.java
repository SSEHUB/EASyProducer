/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.varModel.capabilities;

/**
 * Defines some differentiating reasoner capabilities to react in EASy on provided
 * capabilities in an abstract way. The IVML editor may utilize these
 * enum constants to display reasoner-specific warnings if capabilities for a utilized IVML
 * concept are missing.
 * 
 * @author Holger Eichelberger
 */
public enum IvmlReasonerCapabilities implements IReasonerCapability {
    
    /**
     * Whether the reasoner works with null values.
     */
    NULL_VALUE,

    /**
     * Whether the reasoner works with top-level quantified compound access, i.e., turns expressions like
     * <code>Cmp.i...</code> for compound type <code>Cmp</code> into <code>allInstances(Cmp)->forAll(c|c.i...)</code>.
     */
    QUALIFIED_COMPOUND_ACCESS,
    
    /**
     * Whether the reasoner works with quantors.
     */
    QUANTORS,
    
    /**
     * Whether the reasoner works with iterators.
     */
    ITERATORS,
    
    /**
     * Whether the reasoner works with user-defined functions.
     */
    USER_DEF_FUNCTIONS,

    /**
     * Whether the reasoner works with attributes.
     */
    ATTRIBUTES,

    /**
     * Whether the reasoner can work with "eval".
     */
    EVAL;
    
    // further may be added

}
