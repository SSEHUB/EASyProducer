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
package de.uni_hildesheim.sse.easy.ant.modelcopy;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.filefilter.IOFileFilter;

/**
 * Filter for collecting all relevant EASy-Producer model files in a given folder, considering sub folders.
 * @author El-Sharkawy
 *
 */
public class EASyModelFilter implements IOFileFilter {

    private static final Set<String> EXTENSIONS_WHITELIST = new HashSet<String>();
    
    private static final boolean COPY_ALL_FILES = false;
    
    static {
        // Insert here all files which shall be copied.
        EXTENSIONS_WHITELIST.add("vil");
        EXTENSIONS_WHITELIST.add("rtvil");
        EXTENSIONS_WHITELIST.add("vtl");
        EXTENSIONS_WHITELIST.add("text");
        EXTENSIONS_WHITELIST.add("EASyConfig");
        EXTENSIONS_WHITELIST.add("ivml");
//        EXTENSIONS_WHITELIST.add("pipeline_diagram");
//        EXTENSIONS_WHITELIST.add("pipeline");
    }
    
    @Override
    public boolean accept(File arg0, String arg1) {
        return accept(arg0);
    }
    
    @Override
    public boolean accept(File arg0) {
        boolean accept = arg0.isDirectory() || COPY_ALL_FILES;
        if (!accept) {
            String fileName = arg0.getAbsolutePath();
            int pos = fileName.lastIndexOf('.');
            
            if (-1 != pos) {
                String extension = fileName.substring(pos + 1);
                accept = EXTENSIONS_WHITELIST.contains(extension);
            }
        }
        return accept;
    }
}
