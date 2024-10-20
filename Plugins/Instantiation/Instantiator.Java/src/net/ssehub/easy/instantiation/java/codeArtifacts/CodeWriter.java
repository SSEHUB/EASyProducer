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

import net.ssehub.easy.basics.modelManagement.IndentationConfiguration;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.templateModel.ContentFormatter;
import net.ssehub.easy.instantiation.core.model.templateModel.Formatting;
import net.ssehub.easy.instantiation.core.model.templateModel.FormattingConfiguration;

/**
 * Writes code to a file or a print writer.
 * 
 * @author Holger Eichelberger
 */
class CodeWriter implements Closeable {

    private static final boolean DEBUG = true;
    private PrintWriter out;
    private String indent = "";
    private String indentStep = "  ";
    private String lineEnd = System.lineSeparator();
    @SuppressWarnings("unused")
    private int lineLength = -1;  // TODO consider line breaks/formatting??
    private ContentFormatter contentFormatter;
    private StringBuilder buffer = new StringBuilder();
    
    /**
     * Creates a code writer for a {@code file}. This method creates parents of {@code file} if they yet do not exist.
     * 
     * @param file the file 
     * @throws VilException if creating/opening the file fails
     */
    CodeWriter(File file) throws VilException {
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
            }
            this.out = new PrintWriter(file);
            initializeFormatting();
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
        initializeFormatting();
    }
    
    /**
     * Initializes the formatting from the using (top-level) template once.
     */
    private void initializeFormatting() {
        FormattingConfiguration fCfg = Formatting.getFormattingConfiguration();
        IndentationConfiguration iCfg = Formatting.getIndentationConfiguration();
        
        int iStep = fCfg.getIndentSteps() >= 0 ? fCfg.getIndentSteps() : iCfg.getIndentationStep(); 
        indentStep = "";
        for (int i = 1; i <= iStep; i++) {
            indentStep += " ";
        }
        if (fCfg.getLineEnding() != null) {
            lineEnd = fCfg.getLineEnding();
        }
        if (fCfg.getLineLength() > 0) {
            lineLength = fCfg.getLineLength();
        }
        contentFormatter = Formatting.getContentFormatter();
    }

    /**
     * Prints the actual indentation.
     */
    void printIndent() {
        buffer.append(indent);
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
        buffer.append(lineEnd);
    }

    /**
     * Prints the {@code text} as a new line without indentation. Line separator is the system line separator.
     * 
     * @param text the text to print
     */
    void println(String text) {
        buffer.append(text);
        buffer.append(lineEnd);
        emit();
    }
    
    /**
     * Formats/emits the output buffer if it contains characters.
     */
    void emit() {
        if (buffer.length() > 0) {
            String formatted = contentFormatter.format(buffer.toString());
            buffer.setLength(0); // clear
            out.print(formatted);
            if (DEBUG) {
                System.out.print(formatted);
            }
        }
    }

    /**
     * Prints the text without line end/indentation.
     * 
     * @param text the text to print
     */
    void print(String text) {
        buffer.append(text);
    }

    /**
     * Increases the indentation by a step.
     */
    void increaseIndent() {
        indent += indentStep;
    }
    
    /**
     * Decreases the indentation by a step.
     */
    void decreaseIndent() {
        if (indent.length() >= indentStep.length()) {
            indent = indent.substring(indentStep.length());
        }
    }
    
    @Override
    public void close() {
        emit();
        if (null != out) {
            this.out.close();
        }
    }
    
    /**
     * Flushes the underlying stream.
     */
    protected void flush() {
        emit();
        if (null != out) {
            this.out.flush();
        }
    }

}
