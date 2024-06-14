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
package de.uni_hildesheim.sse.ui;

import java.util.Collections;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.util.Modules2;
import org.osgi.framework.BundleContext;

import com.google.common.collect.Maps;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * Originally generated class. Not part of since Xtext 2.34.0. 
 */
public class IvmlActivator extends AbstractUIPlugin {
        
        public static final String DE_UNI_HILDESHEIM_SSE_IVML = "de.uni_hildesheim.sse.Ivml";
        
        private static final Logger logger = Logger.getLogger(IvmlActivator.class);
        
        private static IvmlActivator INSTANCE;
        
        private Map<String, Injector> injectors = Collections.synchronizedMap(Maps.<String, Injector> newHashMapWithExpectedSize(1));
        
        @Override
        public void start(BundleContext context) throws Exception {
                super.start(context);
                INSTANCE = this;
        }
        
        @Override
        public void stop(BundleContext context) throws Exception {
                injectors.clear();
                INSTANCE = null;
                super.stop(context);
        }
        
        public static IvmlActivator getInstance() {
                return INSTANCE;
        }
        
        public Injector getInjector(String language) {
                synchronized (injectors) {
                        Injector injector = injectors.get(language);
                        if (injector == null) {
                                injectors.put(language, injector = createInjector(language));
                        }
                        return injector;
                }
        }
        
        protected Injector createInjector(String language) {
                try {
                        Module runtimeModule = getRuntimeModule(language);
                        Module sharedStateModule = getSharedStateModule();
                        Module uiModule = getUiModule(language);
                        Module mergedModule = Modules2.mixin(runtimeModule, sharedStateModule, uiModule);
                        return Guice.createInjector(mergedModule);
                } catch (Exception e) {
                        logger.error("Failed to create injector for " + language);
                        logger.error(e.getMessage(), e);
                        throw new RuntimeException("Failed to create injector for " + language, e);
                }
        }

        protected Module getRuntimeModule(String grammar) {
                if (DE_UNI_HILDESHEIM_SSE_IVML.equals(grammar)) {
                        return new de.uni_hildesheim.sse.IvmlRuntimeModule();
                }
                
                throw new IllegalArgumentException(grammar);
        }
        
        protected Module getUiModule(String grammar) {
                if (DE_UNI_HILDESHEIM_SSE_IVML.equals(grammar)) {
                        return new de.uni_hildesheim.sse.ui.IvmlUiModule(this);
                }
                
                throw new IllegalArgumentException(grammar);
        }
        
        protected Module getSharedStateModule() {
                return new SharedStateModule();
        }
        
}
