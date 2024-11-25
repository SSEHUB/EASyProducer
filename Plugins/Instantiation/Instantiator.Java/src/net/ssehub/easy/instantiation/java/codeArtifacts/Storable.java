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

import java.util.function.Consumer;

import net.ssehub.easy.instantiation.core.model.templateModel.CodeToStringWriter;
import net.ssehub.easy.instantiation.core.model.templateModel.CodeWriter;
import net.ssehub.easy.instantiation.core.model.vilTypes.Invisible;

/**
 * A storable element, an element that can be stored through a {@link CodeWriter}.
 * 
 * @author Holger Eichelberger
 */
public interface Storable {

    /**
     * Stores the element at the current position in {@code out}.
     * 
     * @param out the output writer
     */
    @Invisible
    public void store(CodeWriter out);

    /**
     * Special actions to store this expression as qualifier, e.g., for a method call.
     * Calls {@link #store(CodeWriter)} by default.
     * 
     * @param out the code writer
     */
    @Invisible
    public default void storeAsQualifier(CodeWriter out) {
        store(out);
    }
    
    /**
     * Returns the number of contained line-relevant elements (potentially including <b>this</b>), i.e., a rough 
     * estimation of the lines without considering advanced formatting.
     * 
     * @return the number of contained line-relevant elements, formatting may differ; may be {@code 0}
     */
    public default int getElementCount() {
        return 1;
    }

    /**
     * Returns whether this element (block) is empty and could be removed.
     * 
     * @return {@code true} for empty, {@code false} else
     */
    public default boolean isEmpty() {
        return false;
    }

    /**
     * Turns this Storable to code.
     * 
     * @return the string representation
     */
    public default String toCode() {
        return getString(o -> store(o));
    }

    /**
     * Turns the consumer {@code store}, e.g., {@link #store(CodeWriter)} to a String.
     * 
     * @param store the consumer
     * @return the string
     */
    public static String getString(Consumer<CodeWriter> store) {
        CodeToStringWriter out = new CodeToStringWriter();
        store.accept(out);
        return out.getString();
    }

}
