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
package net.ssehub.easy.instantiation.core;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.io.FileUtils;
import net.ssehub.easy.basics.io.JarUtils;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.modelManagement.ModelManagementException;
import net.ssehub.easy.basics.modelManagement.ModelLocations.Location;
import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.dslCore.DefaultLib;
import net.ssehub.easy.instantiation.core.model.buildlangModel.BuildModel;
import net.ssehub.easy.instantiation.core.model.templateModel.TemplateModel;
import net.ssehub.easy.varModel.management.VarModel;

/**
 * Utilities to handle/load the default libraries.
 * 
 * @author Holger Eichelberger
 */
public class DefaultLibUtils {

    /**
     * A default library registrar for IVML/VIL/VTL.
     */
    public static final LocationRegistrar DEFAULT_REGISTRAR = new LocationRegistrar() {
        
        @Override
        public void register(File location, ProgressObserver observer) throws ModelManagementException {
            ModelManagementException returnExc = null;
            try {
                VarModel.INSTANCE.locations().addLocation(location, observer).toDefaultLibLocation();
            } catch (ModelManagementException exc) {
                returnExc = exc;
            }
            try {
                BuildModel.INSTANCE.locations().addLocation(location, observer).toDefaultLibLocation();
            } catch (ModelManagementException exc) {
                returnExc = exc;
            }
            try {
                TemplateModel.INSTANCE.locations().addLocation(location, observer).toDefaultLibLocation();
            } catch (ModelManagementException exc) {
                returnExc = exc;
            }
            if (null != returnExc) {
                throw returnExc;
            }
        }
    };
    
    /**
     * Registers file locations for IVML/VIL/VTL.
     * 
     * @author Holger Eichelberger
     */
    public interface LocationRegistrar {
        
        /**
         * Registers file locations for IVML/VIL/VTL.
         * 
         * @param location the location
         * @param observer the progress observer
         * @throws ModelManagementException if the registration fails
         */
        public void register(File location, ProgressObserver observer) 
            throws ModelManagementException;
        
    }

    /**
     * Loads the default models if existent using {@link #DEFAULT_REGISTRAR}, the class loader of this class and no 
     * additional libraries .
     * 
     * @param observer the progress observer
     * @param pluginId the plugin ID of the plugin loading the libraries
     */
    public static void loadDefaultModels(ProgressObserver observer, String pluginId) {
        loadDefaultModels(DefaultLibUtils.class.getClassLoader(), observer, null, pluginId);
    }
    
    /**
     * Loads the default models if existent using {@link #DEFAULT_REGISTRAR} and no additional libraries.
     * 
     * @param loader the loader to take the resources from
     * @param observer the progress observer
     * @param pluginId the plugin ID of the plugin loading the libraries
     */
    public static void loadDefaultModels(ClassLoader loader, ProgressObserver observer, String pluginId) {
        loadDefaultModels(loader, observer, null, pluginId);
    }
    
    /**
     * Loads the default models if existent using {@link #DEFAULT_REGISTRAR}.
     * 
     * @param loader the loader to take the resources from
     * @param observer the progress observer
     * @param additionalLibs further library URLs to consider, may be <b>null</b> for none
     * @param pluginId the plugin ID of the plugin loading the libraries
     */
    public static void loadDefaultModels(ClassLoader loader, ProgressObserver observer, 
        List<URL> additionalLibs, String pluginId) {
        loadDefaultModels(loader, observer, DEFAULT_REGISTRAR, additionalLibs, pluginId);
    }
    
    /**
     * Loads the default models if existent.
     * 
     * @param loader the loader to take the resources from
     * @param observer the progress observer
     * @param registrar a function registring individual IVML/VIL/VTL locations containing default library fragments
     * @param additionalLibs further library URLs to consider, may be <b>null</b> for none
     * @param pluginId the plugin ID of the plugin loading the libraries
     */
    public static void loadDefaultModels(ClassLoader loader, ProgressObserver observer, 
        LocationRegistrar registrar, List<URL> additionalLibs, String pluginId) {
        List<URL> libs = new ArrayList<URL>();
        if (null != additionalLibs) {
            libs.addAll(additionalLibs);
        }
        DefaultLib.appendAll(libs);
        int count = 0;
        for (URL url : libs) { // all shall be different from null by construction
            EASyLoggerFactory.INSTANCE.getLogger(DefaultLibUtils.class, pluginId).info(
                "Trying to load default IVML/VIL library from '" + url);
            try {
                String urlString = url.toString().replace(" ", "%20"); // space problem :(
                URI uri = new URI(urlString);
                if (JarUtils.isJarURL(url)) {
                    File file = FileUtils.createTmpDir("easyDefaultLib_" + count);
                    JarUtils.unpackJar(url, file);
                    uri = file.toURI();
                }
                Location defltLibLocation = VarModel.INSTANCE.locations().getLocationFor(uri);
                if (null == defltLibLocation && FileUtils.isFileURI(uri)) {
                    File defltLibFolder = new File(uri);
                    if (defltLibFolder.exists()) {
                        registrar.register(defltLibFolder, observer);
                        EASyLoggerFactory.INSTANCE.getLogger(DefaultLibUtils.class, pluginId).info(
                            "Loaded default IVML/VIL library from '" + url);
                    }
                }
                count++;
            } catch (URISyntaxException | ModelManagementException | IOException e) {
                EASyLoggerFactory.INSTANCE.getLogger(DefaultLibUtils.class, pluginId).error(
                    "While loading default library in '" + url + "': " + e.getMessage());
            }
        }
    }
   
}
