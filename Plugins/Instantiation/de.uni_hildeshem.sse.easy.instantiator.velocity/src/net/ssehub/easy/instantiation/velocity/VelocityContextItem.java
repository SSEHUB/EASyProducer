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
package net.ssehub.easy.instantiation.velocity;

/**
 * Datatype for initializing velocity's context.
 * Stored the name and the related value of configured elements.
 * Compounds will be flattened (using {@link VelocityContextInitializer#SLOT_ACCESS}).
 * @author Sascha El-Sharkawy
 *
 */
public class VelocityContextItem {
    
    private String variableName;
    private Object value;
    
    /**
     * Sole constructor for this class.
     * @param variableName The name of a variable as it is used inside the code fragments.
     * @param value The value which shall replace the name.
     */
    public VelocityContextItem(String variableName, Object value) {
        this.variableName = variableName;
        this.value = value;
    }
    
    /**
     * Returns the name of the variable as it is used inside the code fragments.
     * @return The name of the variable as it is used inside the code fragments.
     */
    String getName() {
        return variableName;
    }

    /**
     * Returns the value which shall replace the name inside the code fragments.
     * @return The value which shall replace the name inside the code fragments
     */
    Object getValue() {
        return value;
    }
    
    /**
     * Returns {@link #getValue()} as String. This facilitates the direct usage of the variable inside the code
     * to insert its value as expected by an pre-processor.
     */
    @Override
    public final String toString() {
        return getValue().toString();
    }
}
