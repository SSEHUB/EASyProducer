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
package net.ssehub.easy.instantiation.core.model.common;

import java.text.Collator;
import java.util.Locale;

import net.ssehub.easy.basics.DefaultLocale;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.Configuration;

/**
 * Provides access to execution global information that is available via registered tracers for instances that
 * do not have references to the execution visitor.
 * 
 * @author Holger Eichelberger
 */
public class ExecutionLocal {

    /**
     * Returns the current (top-level) configuration known during execution.
     * 
     * @return the current configuration (may be <b>null</b> if unknown)
     */
    public static Configuration getCurrentConfiguration() {
        Configuration result = null;
        RuntimeEnvironment env = getCurrentRuntimeEnvironment();
        if (null != env) {
            result = env.getTopLevelConfiguration();
        }
        return result;
    }
    
    /**
     * Returns the current locale for this thread used during evaluation.
     * 
     * @return the current locale
     */
    public static Locale getCurrentLocale() {
        return doCurrentLocale(null);
    }

    /**
     * Changes and returns the current locale for this thread used during evaluation.
     * 
     * @param locale the new locale (ignored if <b>null</b>, then only the current locale 
     *   is returned)
     * @return the current locale (after a potential change)
     */
    private static Locale doCurrentLocale(Locale locale) {
        Locale result;
        ITracer tracer = getCurrentTracer();
        if (null != tracer) {
            if (null != locale) {
                tracer.setLocale(locale);
            }
            result = tracer.getLocale();
        } else {
            if (null != locale) {
                DefaultLocale.setDefaultLocale(locale);
            }
            result = DefaultLocale.getDefaultLocale();
        }
        return result;
    }
    
    /**
     * Returns the current tracer for this thread.
     * 
     * @return the current tracer (may be <b>null</b>)
     */
    public static ITracer getCurrentTracer() {
        // more specific one / nested one goes first
        ITracer tracer = TracerFactory.getRegisteredTemplateLanguageTracer();
        if (null == tracer) {
            tracer = TracerFactory.getRegisteredBuildLanguageTracer();
        }
        return tracer;
    }
    
    /**
     * Returns the current type registry for this thread.
     * 
     * @return the current type registry
     */
    public static TypeRegistry getCurrentTypeRegistry() {
        TypeRegistry result = TypeRegistry.DEFAULT;
        RuntimeEnvironment env = getCurrentRuntimeEnvironment();
        if (null != env) {
            result = env.getTypeRegistry();
        }
        return result;
    }
    
    /**
     * Returns the current runtime environment for this thread.
     * 
     * @return the current runtime environment
     */
    private static RuntimeEnvironment getCurrentRuntimeEnvironment() {
        RuntimeEnvironment result = null;
        ITracer tracer = getCurrentTracer();
        if (null != tracer) {
            result = tracer.getRuntimeEnvironment();
        }
        return result;
    }

    /**
     * Changes and returns the current locale for this thread used during evaluation.
     * 
     * @param locale the new locale (ignored if <b>null</b>)
     * @return the new locale
     */
    public static Locale setCurrentLocale(Locale locale) {
        return doCurrentLocale(locale);
    }

    /**
     * Returns the collator for {@link #getCurrentLocale()}.
     * 
     * @return the collator
     */
    public static Collator getCurrentCollator() {
        return Collator.getInstance(getCurrentLocale());
    }

}
