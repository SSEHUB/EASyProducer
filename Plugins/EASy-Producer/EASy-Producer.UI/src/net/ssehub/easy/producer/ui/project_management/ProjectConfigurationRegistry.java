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
package net.ssehub.easy.producer.ui.project_management;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Registry for {@link AbstractProjectCreationDescriptor}s to allow EASy projects directly configured as arbitrary
 * Eclipse projects.
 * @author El-Sharkawy
 */
public class ProjectConfigurationRegistry {
    
    private static List<AbstractProjectCreationDescriptor> descriptors
        = new ArrayList<AbstractProjectCreationDescriptor>();

    /**
     * Registers a new {@link AbstractProjectCreationDescriptor}.
     * @param descriptor A new {@link AbstractProjectCreationDescriptor}, must not be <tt>null</tt> or added multiple
     * times.
     */
    public static synchronized void registerProjectDescriptor(AbstractProjectCreationDescriptor descriptor) {
        descriptors.add(descriptor);
        Collections.sort(descriptors);
    }
    
    /**
     * Returns the number or registered {@link AbstractProjectCreationDescriptor}s.
     * @return A number greater or equal to 0.
     */
    public static int getDescriptorSize() {
        return descriptors.size();
    }
    
    /**
     * Returns the selected {@link AbstractProjectCreationDescriptor}.
     * @param index A 0-based index.
     * @return The selected {@link AbstractProjectCreationDescriptor}.
     */
    public static AbstractProjectCreationDescriptor getDescriptor(int index) {
        return descriptors.get(index);
    }
}
