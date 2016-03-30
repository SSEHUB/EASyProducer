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
package net.ssehub.easy.producer.examples;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

import net.ssehub.easy.basics.Environment;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.producer.examples.internal.Bundle;
import net.ssehub.easy.producer.ui.productline_editor.EasyProducerDialog;

/**
 * Lists examples provides by this Plug-in.
 * @author El-Sharkawy
 *
 */
public class AvailableExamples {
    
    /**
     * Singleton instance of this class.
     */
    public static final AvailableExamples INSTANCE = new AvailableExamples();  
    
    private ExampleDescriptor[] availableExamples;
    
    /**
     * Descriptor for managing available and selected examples.
     * @author El-Sharkawy
     *
     */
    public static class ExampleDescriptor implements Comparable<ExampleDescriptor> {
        private File location;
        private String name;
        private File description;
        
        @Override
        public int compareTo(ExampleDescriptor other) {
            return name.compareTo(other.name);
        }
        
        /**
         * USed by Eclipe's {@link org.eclipse.jface.viewers.LabelProvider}.
         */
        @Override
        public String toString() {
            return name;
        }
        
        /**
         * Returns the location of the zipped example inside this bundle.
         * @return The location of the zipped example.
         */
        public File getSource() {
            return location;
        }
        
        /**
         * A description about containing examples in HTML format.
         * @return The description or <tt>null</tt>.
         */
        public File getDescription() {
            return description;
        }
    }
    
    /**
     * Sole constructor of this singleton.
     */
    private AvailableExamples() {
        availableExamples = null;
        Map<String, ExampleDescriptor> tmpExamples = new HashMap<String, ExampleDescriptor>();
        
        // Find provided Examples
        org.osgi.framework.Bundle bundle = Platform.getBundle(Bundle.PLUGIN_ID);
        URL fileURL = bundle.getEntry("examples");
        File folder = null;
        try {
            URL url = FileLocator.resolve(fileURL);
            folder = Environment.toFile(url);
        } catch (IOException e1) {
            EasyProducerDialog.showErrorDialog("Could not load examples from: " + fileURL.getPath());
            EASyLoggerFactory.INSTANCE.getLogger(AvailableExamples.class, Bundle.PLUGIN_ID).exception(e1);
        }
        
        if (null != folder && folder.isDirectory()) {
            File[] containedFiles = folder.listFiles();
            if (null != containedFiles) {
                // First find zip archives
                for (int i = 0; i < containedFiles.length; i++) {
                    String fileName = containedFiles[i].getName();
                    if (fileName.toLowerCase().endsWith("zip")) {
                        ExampleDescriptor descriptor = new ExampleDescriptor();
                        descriptor.name = fileName.substring(0, fileName.length() - 4);
                        descriptor.location = containedFiles[i];
                        tmpExamples.put(descriptor.name, descriptor);
                    }
                }
                // Second find optional description.
                for (int i = 0; i < containedFiles.length; i++) {
                    String fileName = containedFiles[i].getName();
                    if (fileName.toLowerCase().endsWith("html")) {
                        String descriptorName = fileName.substring(0, fileName.length() - 5);
                        ExampleDescriptor descriptor = tmpExamples.get(descriptorName);
                        if (null != descriptor) {
                            descriptor.description = containedFiles[i]; 
                        }
                    }
                }
            }
            availableExamples = new ExampleDescriptor[tmpExamples.size()];
            availableExamples = tmpExamples.values().toArray(availableExamples);
            Arrays.sort(availableExamples);
        }
    }
    
    /**
     * Returns all available zipped examples shipped with this bundle.
     * @return All available zipped examples shipped with this bundle
     */
    public ExampleDescriptor[] getExamples() {
        return availableExamples;
    }

}
