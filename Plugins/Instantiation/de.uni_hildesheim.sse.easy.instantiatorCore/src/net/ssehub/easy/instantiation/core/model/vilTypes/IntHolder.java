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
package net.ssehub.easy.instantiation.core.model.vilTypes;

/**
 * Represents a modifiable int.
 * 
 * @author Holger Eichelberger
 */
public class IntHolder {
    
    private int value;

    /**
     * Creates the int holder with default initial value of 0.
     */
    public IntHolder() {
        this(0);
    }
    
    /**
     * Creates the int holder.
     * 
     * @param value the initial value
     */
    public IntHolder(int value) {
        setValue(value);
    }
    
    /**
     * Changes the int value.
     * 
     * @param value the new value
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    /**
     * Returns the int value.
     * 
     * @return the int value
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Returns the int value incremented by 1.
     * 
     * @return the int value
     */
    public int getAndInc() {
        return value++;
    }

    /**
     * Returns the int value decremented by 1.
     * 
     * @return the int value
     */
    public int getAndDec() {
        return value--;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }

}
