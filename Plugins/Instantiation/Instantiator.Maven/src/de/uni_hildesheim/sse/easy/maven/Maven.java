package de.uni_hildesheim.sse.easy.maven;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.cli.MavenCli;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileUtils;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileUtils.ScanResult;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.PathUtils;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators.AbstractFileInstantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Sequence;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Builds Java applications with Maven.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("maven")
public class Maven extends AbstractFileInstantiator {

    /**
     * Executes a specific MAVEN build specification with "clean" and "install" targets.
     * 
     * @param root the root-path
     * @return the created artifacts
     * @throws ArtifactException in case of artifact / parameter problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> maven(Path root) throws ArtifactException {
        return maven(root, (String) null);
    }    
    
    /**
     * Executes a specific MAVEN build specification with "clean" and "install" targets.
     * 
     * @param root the root-path
     * @param buildFilePath the path where the MAVEN file is located
     * @return the created artifacts
     * @throws ArtifactException in case of artifact / parameter problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, String buildFilePath) throws ArtifactException {
        return build(root, buildFilePath, new String[] {"clean", "install"});
    }    

    /**
     * Executes a specific MAVEN build specification.
     * 
     * @param root the root-path
     * @param buildtargets the targets to be executed
     * @return the created artifacts
     * @throws ArtifactException in case of artifact / parameter problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, Sequence<String> buildtargets) 
        throws ArtifactException {
        return build(root, null, toTargets(buildtargets));
    }

    /**
     * Executes a specific MAVEN build specification.
     * 
     * @param root the root-path
     * @param buildFilePath the path where the MAVEN file is located
     * @param buildtargets the targets to be executed
     * @return the created artifacts
     * @throws ArtifactException in case of artifact / parameter problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, String buildFilePath, Sequence<String> buildtargets) 
        throws ArtifactException {
        return build(root, buildFilePath, toTargets(buildtargets));
    }

    /**
     * Turns the given targets into an array.
     * 
     * @param buildtargets
     * @return
     */
    private static String[] toTargets(Sequence<String> buildtargets) {
        int targetsCount = buildtargets.size();
        String[] targets = new String[targetsCount];
        for (int i = 0; i < targetsCount; i++) {
            targets[i] = buildtargets.get(i);
        }
        return targets;
    }
    
    /**
     * Executes a specific MAVEN build specification.
     * 
     * @param root the root-path
     * @param buildFilePath the path where the MAVEN file is located
     * @param targets the targets to be executed
     * @return the created artifacts
     * @throws ArtifactException in case of artifact / parameter problems
     */
    private static Set<FileArtifact> build(Path root, String buildFilePath, String[] targets) 
        throws ArtifactException {
        // TODO pass maven options http://maven.apache.org/ref/3.2.3/maven-embedder/cli.html

        File targetPath = determineTargetPath(root);
        if (null != buildFilePath) {
            buildFilePath = new File(targetPath, buildFilePath).toString();
        } else {
            buildFilePath = targetPath.toString();
        }
        long timestamp = PathUtils.normalizedTime();
        MavenCli cli = new MavenCli();
        int cliResult = cli.doMain(targets, buildFilePath, System.out, System.out); // TODO check streams
        if (0 != cliResult) {
            throw new ArtifactException("maven build failed", ArtifactException.ID_RUNTIME_EXECUTION);
        }
        List<FileArtifact> result = new ArrayList<FileArtifact>();
        ScanResult<FileArtifact> scanResult = new ScanResult<FileArtifact>(result);
        FileUtils.scan(targetPath.getAbsoluteFile(), root.getArtifactModel(), timestamp, scanResult, 
            FileArtifact.class);
        scanResult.checkForException();
        return new ListSet<FileArtifact>(result, FileArtifact.class);
    }
    
}