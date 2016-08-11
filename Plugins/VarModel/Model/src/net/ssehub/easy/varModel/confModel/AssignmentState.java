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
package net.ssehub.easy.varModel.confModel;

/**
 * Defines the default and global assignment states.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
public enum AssignmentState implements IAssignmentState {

    /**
     * An undefined value. The decision must be taken in future. 
     */
    UNDEFINED,
    
    /**
     * The value is set by the user, but not yet frozen.
     */
    ASSIGNED,
    
    /**
     * The value is set by the user, should not be changed by the reasoner.
     */
    USER_ASSIGNED,
    
    /**
     * The default value is (still) assigned.
     */
    DEFAULT,
    
    /**
     * A (reasoning) mechanism defined the value.
     */
    DERIVED,
    
    /**
     * The value is frozen and cannot be changed.
     */
    FROZEN;
}
