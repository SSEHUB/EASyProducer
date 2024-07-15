/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.java.codeArtifacts;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import net.ssehub.easy.instantiation.core.model.common.VilException;

class CodeWriter implements Closeable {
    
    private PrintWriter out;
    private String indent = "";
    
    CodeWriter(File file) throws VilException {
        try {
            this.out = new PrintWriter(file);
        } catch (IOException e) {
            throw new VilException(e, VilException.ID_INTERNAL);
        }
    }
    
    CodeWriter(PrintWriter out) {
        this.out = out;
    }

    void printIndent() {
        out.print(indent);
    }

    void printlnwi(String text) {
        printIndent();
        println(text);
    }

    void printwi(String text) {
        printIndent();
        print(text);
    }

    void println() {
        out.println(); // TODO linenend, consider line breaks/formatting
    }

    void println(String text) {
        out.println(text);
    }

    void print(String text) {
        out.print(text);
    }

    void increaseIndent() {
        indent += "  "; // TODO indentation config
    }
    
    void decreaseIndent() {
        if (indent.length() >= 2) { // TODO indentation config
            indent = indent.substring(2);
        }
    }
    
    @Override
    public void close() {
        if (null != out) {
            this.out.close();
        }
    }

}
