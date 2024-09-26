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
package net.ssehub.easy.standalone.cmd;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import net.ssehub.easy.producer.core.persistence.Configuration;
import net.ssehub.easy.producer.core.persistence.EASyPersistencer;
import net.ssehub.easy.producer.core.persistence.PersistenceUtils;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;

/**
 * Project creation flavours. The mechanism around IEASyProjectConfigurator cannot be applied
 * here as it is tightly linked to Eclipse.
 * 
 * @author Holger Eichelberger
 */
public abstract class ProjectCreationFlavour {
    
    private static Map<String, ProjectCreationFlavour> flavours = new HashMap<>();

    /**
     * Registers a flavour.
     * 
     * @param flavour the flavour
     */
    public static void registerFlavour(ProjectCreationFlavour flavour) {
        if (null != flavour) {
            flavours.put(flavour.getName(), flavour);
        }
    }
    
    /**
     * Applies {@code consumer} to a name-sorted list of all flavor names.
     * 
     * @param consumer the consumer
     */
    public static void forEach(Consumer<ProjectCreationFlavour> consumer) {
        List<ProjectCreationFlavour> fl = new ArrayList<>(flavours.values());
        Collections.sort(fl, (f1, f2) -> f1.getName().compareTo(f2.getName()));
        fl.stream().forEach(consumer);
    }
    
    /**
     * Returns a flavour.
     * 
     * @param name the name 
     * @return the flavour, may be <b>null</b>
     */
    public static ProjectCreationFlavour getFlavour(String name) {
        return flavours.get(name);
    }
    
    /**
     * Returns a flavours.
     * 
     * @param names the names
     * @return the flavours, may be empty
     */
    public static List<ProjectCreationFlavour> getFlavours(String... names) {
        List<ProjectCreationFlavour> flavours = new ArrayList<>();
        for (int a = 1; a < names.length; a++) {
            ProjectCreationFlavour fl = ProjectCreationFlavour.getFlavour(names[a]);
            if (null != fl) {
                flavours.add(fl);
            }
        }
        return flavours;
    }

    /**
     * Applies {@code consumer} to all {@code flavours}.
     * 
     * @param flavours the flavours
     * @param consumer the consumer
     */
    public static void forEach(List<ProjectCreationFlavour> flavours, Consumer<ProjectCreationFlavour> consumer) {
        flavours.stream().forEach(consumer);
    }
    
    /**
     * Returns the name.
     * 
     * @return the name
     */
    public abstract String getName();
    
    /**
     * Returns a short description.
     * 
     * @return the description
     */
    public abstract String getDescription();

    /**
     * Applies the flavour.
     * 
     * @param projectFolder the folder to apply the flavour
     */
    public abstract void apply(File projectFolder);
    
    /**
     * Configures the given persistencer for application.
     * +
     * @param persistencer the persistencer
     */
    public void configure(EASyPersistencer persistencer) {
    }
    
    static {
        registerFlavour(new ProjectCreationFlavour() {
            
            @Override
            public String getName() {
                return "java";
            }
            
            @Override
            public String getDescription() {
                return "Classical src/bin setup";
            }
            
            @Override
            public void apply(File projectFolder) {
                new File(projectFolder, "src").mkdirs();
                new File(projectFolder, "bin").mkdirs();
            }
            
        });
        
        registerFlavour(new ProjectCreationFlavour() {
            
            private static final String MAIN = "src/main/EASy";
            private static final String TEST = "src/test/EASy";
            
            @Override
            public String getName() {
                return "mvn";
            }

            @Override
            public String getDescription() {
                return "Classical Java/Maven setup";
            }

            @Override
            public void apply(File projectFolder) {
                new File(projectFolder, MAIN).mkdirs();
                new File(projectFolder, "src/main/java").mkdirs();
                new File(projectFolder, TEST).mkdirs();
                new File(projectFolder, "src/test/java").mkdirs();
                new File(projectFolder, "target").mkdirs();
            }

            @Override
            public void configure(EASyPersistencer persistencer) {
                Configuration cfg = PersistenceUtils.getConfiguration(persistencer.getProjectFolder());
                String path = MAIN + "/" + File.pathSeparator + TEST + "/";
                cfg.setPathDirect(PathKind.IVML, path);
                cfg.setPathDirect(PathKind.VIL, path);
                cfg.setPathDirect(PathKind.VTL, path);
                cfg.store();
                persistencer.refreshConfiguration();
            }

        });
    }
    
}

