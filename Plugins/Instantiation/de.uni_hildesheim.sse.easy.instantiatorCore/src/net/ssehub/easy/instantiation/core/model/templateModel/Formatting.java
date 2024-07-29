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

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import net.ssehub.easy.basics.modelManagement.IndentationConfiguration;

/**
 * Provides access to the active formatting configuration of a template. For active formatting, we rely on the top-level
 * template describing artifact modifications rather than referenced/executed sub-templates. Access must be static for
 * VTL instantiators.
 * 
 * @author Holger Eichelberger
 */
public class Formatting {
    
    private static Map<Thread, Template> models = new HashMap<>();
    private static Supplier<FormattingConfiguration> defaultFormatting = 
        () -> new FormattingConfiguration(120, System.lineSeparator());
    private static Supplier<IndentationConfiguration> defaultIndentation = 
        () -> new IndentationConfiguration(4, 4, 0);

    /**
     * Registers the active template (for the current thread).
     * 
     * @param model the model to register, may be <b>null</b>
     */
    public static void register(Template model) {
        models.put(Thread.currentThread(), model); // might use thread-local instead
    }

    /**
     * Unregisters the active template (from the current thread).
     * 
     * @param model the model to register, may be <b>null</b>
     */
    public static void unregister(Template model) {
        Thread current = Thread.currentThread(); // might use thread-local instead
        if (models.get(current) == model) {
            models.remove(current);
        }
    }
    
    /**
     * Defines the default formatting configuration in terms of a supplier.
     * 
     * @param dflt the default formatting configuration supplier (ignored if <b>null</b>)
     */
    public static void setDefaultFormattingConfiguration(Supplier<FormattingConfiguration> dflt) {
        if (null != dflt) {
            defaultFormatting = dflt;
        }
    }

    /**
     * Defines the default indentation configuration in terms of a supplier.
     * 
     * @param dflt the default indentation configuration supplier (ignored if <b>null</b>)
     */
    public static void setDefaultIndentationConfiguration(Supplier<IndentationConfiguration> dflt) {
        if (null != dflt) {
            defaultIndentation = dflt;
        }
    }

    /**
     * Returns the actual indentation configuration.
     * 
     * @return the actual configuration; if there is none/no model, the default supplier is consulted 
     */
    public static IndentationConfiguration getIndentationConfiguration() {
        IndentationConfiguration result = null;
        Template model = models.get(Thread.currentThread());
        if (null != model) {
            result = model.getIndentationConfiguration();
        }
        if (null == result) {
            result = defaultIndentation.get();
        }
        return result;
    }

    /**
     * Returns the actual formatting configuration.
     * 
     * @return the actual configuration; if there is none/no model, the default supplier is consulted 
     */
    public static FormattingConfiguration getFormattingConfiguration() {
        FormattingConfiguration result = null;
        Template model = models.get(Thread.currentThread());
        if (null != model) {
            result = model.getFormattingConfiguration();
        }
        if (null == result) {
            result = defaultFormatting.get();
        }
        return result;
    }

}
