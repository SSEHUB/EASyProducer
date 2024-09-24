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
import java.util.stream.Collectors;

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
     * Returns the sorted list of all flavor names.
     * 
     * @return the flavour names
     */
    public static String getFlavourNames() {
        List<String> fl = new ArrayList<>(flavours.keySet());
        Collections.sort(fl);
        return fl.stream().collect(Collectors.joining(", "));
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
     * Applies all {@code flavours} to {@code projectFolder}.
     * 
     * @param flavours the flavours
     * @param projectFolder the folder
     */
    public static void apply(List<ProjectCreationFlavour> flavours, File projectFolder) {
        for (ProjectCreationFlavour f : flavours) {
            f.apply(projectFolder);
        }
    }
    
    /**
     * Returns the name.
     * 
     * @return the name
     */
    public abstract String getName();

    /**
     * Applies the flavour.
     * 
     * @param projectFolder the folder to apply the flavour
     */
    public abstract void apply(File projectFolder);
    
    static {
        registerFlavour(new ProjectCreationFlavour() {
            
            @Override
            public String getName() {
                return "java";
            }
            
            @Override
            public void apply(File projectFolder) {
                new File(projectFolder, "src").mkdirs();
                new File(projectFolder, "bin").mkdirs();
            }
        });
    }
    
}

