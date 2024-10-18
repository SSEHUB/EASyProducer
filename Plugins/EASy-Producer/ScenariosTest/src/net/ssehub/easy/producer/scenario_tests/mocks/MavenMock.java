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
package net.ssehub.easy.producer.scenario_tests.mocks;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.ComponentContext;

import net.ssehub.easy.dslCore.DefaultLib;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.defaultInstantiators.AbstractFileInstantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.ReturnGenerics;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;
import net.ssehub.easy.instantiation.maven.Activator;
import net.ssehub.easy.instantiation.maven.Maven;

/**
 * Simple manual mocking of the Maven instantiator, currently with .
 * 
 * @author Holger Eichelberger
 */
@Instantiator("maven")
public class MavenMock extends AbstractFileInstantiator {

    private static boolean registered = false;
    private static boolean passThrough = false;
    private static List<FileArtifact> result = new ArrayList<FileArtifact>();

    /**
     * Registers the Java artifacts and instantiators.
     */
    public static final void register() {
        if (!registered) {
            ComponentContext context = null;
            registered = true;
            TypeRegistry.DEFAULT.register(MavenMock.class);
            DefaultLib.appendDefaultLibURLQuietly(MavenMock.class.getClassLoader(), 
                Activator.BUNDLE_ID, context, "Instantiator.Maven");
        }
    }
    
    /**
     * Function interfaces for original Maven function to be mocked.
     * 
     * @author Holger Eichelberger
     */
    private interface MavenFunction {
        
        public Set<FileArtifact> apply() throws VilException;
        
    }

    /**
     * Mocks an original function returning a set of file artifacts.
     * 
     * @param original the original function to be called if not {@link #passThrough}
     * @return the result, may be {@link #result}
     * @throws VilException if the execution fails
     */
    private static Set<FileArtifact> mock(MavenFunction original) throws VilException {
        if (passThrough) {
            return original.apply();
        } else {
            return new ListSet<FileArtifact>(result, FileArtifact.class);
        }
    }
    
    /**
     * Executes a specific MAVEN build specification with "clean" and "install" targets.
     * 
     * @param root the root-path
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @ReturnGenerics(FileArtifact.class)
    public static Set<FileArtifact> maven(Path root) throws VilException {
        return mock(() -> Maven.maven(root));
    }    

    /**
     * Executes a specific MAVEN build specification with "clean" and "install" targets.
     * 
     * @param root the root-path
     * @param updateSnapshots whether snapshots shall be updated
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @ReturnGenerics(FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, boolean updateSnapshots) throws VilException {
        return mock(() -> Maven.maven(root, updateSnapshots));
    }    

    /**
     * Executes a specific MAVEN build specification with "clean" and "install" targets.
     * 
     * @param root the root-path
     * @param mvnArgs optional maven arguments
     * @param updateSnapshots whether snapshots shall be updated
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @ReturnGenerics(FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, Sequence<String> mvnArgs, boolean updateSnapshots) 
        throws VilException {
        return mock(() -> Maven.maven(root, mvnArgs, updateSnapshots));
    }    

    /**
     * Executes a specific MAVEN build specification with "clean" and "install" targets.
     * 
     * @param root the root-path
     * @param buildFilePath the path where the MAVEN file is located
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @ReturnGenerics(FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, String buildFilePath) throws VilException {
        return mock(() -> Maven.maven(root, buildFilePath));
    }    

    /**
     * Executes a specific MAVEN build specification with "clean" and "install" targets.
     * 
     * @param root the root-path
     * @param updateSnapshots whether snapshots shall be updated
     * @param buildFilePath the path where the MAVEN file is located
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @ReturnGenerics(FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, String buildFilePath, boolean updateSnapshots) 
        throws VilException {
        return mock(() -> Maven.maven(root, buildFilePath, updateSnapshots));
    }    

    /**
     * Executes a specific MAVEN build specification with "clean" and "install" targets.
     * 
     * @param root the root-path
     * @param updateSnapshots whether snapshots shall be updated
     * @param mvnArgs additional maven arguments
     * @param buildFilePath the path where the MAVEN file is located
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @ReturnGenerics(FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, String buildFilePath, Sequence<String> mvnArgs, 
        boolean updateSnapshots) throws VilException {
        return mock(() -> Maven.maven(root, buildFilePath, mvnArgs, updateSnapshots));
    }    

    /**
     * Executes a specific MAVEN build specification.
     * 
     * @param root the root-path
     * @param buildtargets the targets to be executed
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @ReturnGenerics(FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, Sequence<String> buildtargets) 
        throws VilException {
        return mock(() -> Maven.maven(root, buildtargets));
    }

    /**
     * Executes a specific MAVEN build specification.
     * 
     * @param root the root-path
     * @param updateSnapshots whether snapshots shall be updated
     * @param buildtargets the targets to be executed
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @ReturnGenerics(FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, boolean updateSnapshots, Sequence<String> buildtargets) 
        throws VilException {
        return mock(() -> Maven.maven(root, updateSnapshots, buildtargets));
    }
    
    /**
     * Executes a specific MAVEN build specification.
     * 
     * @param root the root-path
     * @param updateSnapshots whether snapshots shall be updated
     * @param buildtargets the targets to be executed
     * @param mvnArgs additional maven arguments, may be <b>null</b> for none
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @ReturnGenerics(FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, Sequence<String> mvnArgs, boolean updateSnapshots, 
        Sequence<String> buildtargets) throws VilException {
        return mock(() -> Maven.maven(root, mvnArgs, updateSnapshots, buildtargets));
    }

    /**
     * Executes a specific MAVEN build specification.
     * 
     * @param root the root-path
     * @param buildFilePath the path where the MAVEN file is located
     * @param buildtargets the targets to be executed
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @ReturnGenerics(FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, String buildFilePath, Sequence<String> buildtargets) 
        throws VilException {
        return mock(() -> Maven.maven(root, buildFilePath, buildtargets));
    }

    /**
     * Executes a specific MAVEN build specification.
     * 
     * @param root the root-path
     * @param buildFilePath the path where the MAVEN file is located
     * @param updateSnapshots whether snapshots shall be updated
     * @param buildtargets the targets to be executed
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @ReturnGenerics(FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, String buildFilePath, boolean updateSnapshots, 
        Sequence<String> buildtargets) 
        throws VilException {
        return mock(() -> Maven.maven(root, buildFilePath, updateSnapshots, buildtargets));
    }
    
    /**
     * Changes the pass-through state.
     * 
     * @param pass shall calls be passed-through to the original implementation or mocked here
     * @return the original value of the flag before calling this method
     */
    public static boolean setPassThrough(boolean pass) {
        boolean orig = passThrough;
        passThrough = pass;
        return orig;
    }
    
    /**
     * Changes the mocked result for the following calls.
     * 
     * @param res the result values
     * @return the original value before calling this method
     */
    public static List<FileArtifact> setResult(List<FileArtifact> res) {
        List<FileArtifact> orig = result;
        result = res;
        return orig;
    }

}
