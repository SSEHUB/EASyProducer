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
package net.ssehub.easy.instantiation.core.model.templateModel;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/**
 * Specialized code writer collecting the results in a String.
 * 
 * @author Holger Eichelberger
 */
public class CodeToStringWriter extends CodeWriter {

    private ByteArrayOutputStream bos;

    /**
     * Creates an instance with default stream.
     */
    public CodeToStringWriter() {
        this(new ByteArrayOutputStream());
    }

    /**
     * Collects to the given stream (for reuse).
     * 
     * @param bos the target stream
     */
    public CodeToStringWriter(ByteArrayOutputStream bos) {
        super(new PrintWriter(bos));
        this.bos = bos;
    }
    
    /**
     * Returns the collected results as String.
     * 
     * @return the results
     */
    public String getString() {
        flush();
        String result = bos.toString(Charset.defaultCharset());
        bos.reset();
        return result;
    }
 
}
