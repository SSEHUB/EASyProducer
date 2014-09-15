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
package de.uni_hildesheim.sse.utils.modelManagement;

/**
 * Represents possible version conflicts, i.e. version restrictions.
 * 
 * @author Marcel Lueder
 * @author Holger Eichelberger
 */
public class VersionRestriction {
    
    /**
     * Defines the operators for version conflicts.
     * 
     * @author Holger Eichelberger
     */
    public enum Operator {
   
        /**
         * The given versions must be equal.
         */
        EQUALS,
        
        /**
         * The left version must be greater than the right.
         */
        GREATER,

        /**
         * The left version must be less than the right.
         */
        LESS,

        /**
         * The left version must be greater or equal than the right.
         */
        GREATER_EQUALS,

        /**
         * The left version must be less or equal than the right.
         */
        LESS_EQUALS,
        
        /**
         * The version numbers must not be equal.
         */
        UNEQUALS
    }
    
    private String name;
    private Operator operator;
    private Version version;
    
    /**
     * Creates a new version restriction.
     * 
     * @param name the name of the model this restriction applies to
     * @param operator the operator for comparing the version of <code>name</code> to <code>version</code>
     * @param version the version to compare to
     */
    public VersionRestriction(String name, Operator operator, Version version) {
        this.name = name;
        this.operator = operator;
        this.version = version;
    }
    
    /**
     * Returns the name of the model to which the restriction applies.
     * 
     * @return the name of the model
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the restriction operator.
     * 
     * @return the restriction operator
     */
    public Operator getOperator() {
        return operator;
    }
    
    /**
     * Returns the restricting version.
     * 
     * @return the restricting version
     */
    public Version getVersion() {
        return version;
    }
    
}
