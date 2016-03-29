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
package net.ssehub.easy.basics.os;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Utility functions for operations on a Unix/Linux/(Mac) operating system. 
 * @author Sascha El-Sharkawy
 *
 */
public class UnixOperations {
    
    /**
     * Avoid initialization of utility class.
     */
    private UnixOperations() {}

    /**
     * Detect symbolic links and to resolve the original file, recursively.
     * @param file A file or folder which may be a symbolic link.
     * @return The same file if it is <tt>null</tt> or if it is not a symbolic link, otherwise
     * the target of the link will be returned.
     * @throws IOException If an I/O error occurs, e.g. this command was executed on Windows
     * @see <a href="http://docs.oracle.com/javase/tutorial/essential/io/links.html#detect">
     * http://docs.oracle.com/javase/tutorial/essential/io/links.html#detect</a>
     */
    public static File resolveSymbolicLink(File file) throws IOException {
        File resolvedFile = file;

        if (null != file) {
            Path fileAsPath = file.toPath();
            if (Files.isSymbolicLink(fileAsPath)) {
                Path originalPath = Files.readSymbolicLink(file.toPath());
                if (null != originalPath) {
                    resolvedFile = resolveSymbolicLink(originalPath.toFile());
                }
            }
        }
        
        return resolvedFile;
    }
}
