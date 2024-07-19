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

/**
 * Writes code to a file or a print writer.
 * 
 * @author Holger Eichelberger
 */
class CodeWriter implements Closeable {
    
    private PrintWriter out;
    private String indent = "";
    
    /**
     * Creates a code writer for a {@code file}.
     * 
     * @param file the file
     * @throws VilException if creating/opening the file fails
     */
    CodeWriter(File file) throws VilException {
        try {
            this.out = new PrintWriter(file);
        } catch (IOException e) {
            throw new VilException(e, VilException.ID_INTERNAL);
        }
    }
    
    /**
     * Creates a code writer for an output writer.
     * 
     * @param out the output writer
     */
    CodeWriter(PrintWriter out) {
        this.out = out;
    }

    /**
     * Prints the actual indentation.
     */
    void printIndent() {
        out.print(indent);
    }

    /**
     * Prints the {@code text} as a new line with indentation (wi) before. Line separator is the system line separator.
     * 
     * @param text the text to print
     */
    void printlnwi(String text) {
        printIndent();
        println(text);
    }

    /**
     * Prints the text without line end but with indentation (wi) before.
     * 
     * @param text the text to print
     */
    void printwi(String text) {
        printIndent();
        print(text);
    }

    /**
     * Prints a line break (using the@code  system line break).
     */
    void println() {
        out.println(); // TODO linenend, consider line breaks/formatting
    }

    /**
     * Prints the {@code text} as a new line without indentation. Line separator is the system line separator.
     * 
     * @param text the text to print
     */
    void println(String text) {
        out.println(text);
    }

    /**
     * Prints the text without line end/indentation.
     * 
     * @param text the text to print
     */
    void print(String text) {
        out.print(text);
    }

    /**
     * Increases the indentation by a step.
     */
    void increaseIndent() {
        indent += "  "; // TODO indentation config
    }
    
    /**
     * Decreases the indentation by a step.
     */
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
    
    /**
     * Flushes the underlying stream.
     */
    protected void flush() {
        if (null != out) {
            this.out.flush();
        }
    }

}
