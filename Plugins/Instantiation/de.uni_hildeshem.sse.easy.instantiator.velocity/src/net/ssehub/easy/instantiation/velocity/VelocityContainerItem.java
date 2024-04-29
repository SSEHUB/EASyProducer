/*
 * Copyright 2017 University of Hildesheim, Software Systems Engineering
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

import java.util.List;

/**
 * {@link VelocityContextItem} for container, i.e., sets and sequences. This facilitates iteration through the
 * nested elements as well to return its size.
 * @author El-Sharkawy
 */
public class VelocityContainerItem extends VelocityContextItem {

    /**
     * Single constructor for this class.
     * @param variableName The name of the container.
     * @param values the nested values, must not be <b>null</b>.
     */
    public VelocityContainerItem(String variableName, List<Object> values) {
        super(variableName, values);
    }

    /**
     * Returns the number of nested values.
     * @return A value greater or equal to 0.
     */
    @SuppressWarnings("unchecked")
    public int size() {
        return ((List<Object>) getValue()).size();
    }
}
