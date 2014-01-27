package de.uni_hildesheim.sse.easy.java.instantiators;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileArtifact;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileUtils;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.FileUtils.ScanResult;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.PathUtils;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.defaultInstantiators.AbstractFileInstantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ArtifactException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Collection;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Instantiator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ListSet;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * Compiles java files using Javac.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("javac")
public class Javac extends AbstractFileInstantiator {

    /**
     * Compiles a source path to a target path.
     * 
     * @param source the source path
     * @param target the target path
     * @param other the other parameter for the Java compiler, without leading "-"
     * @return the created artifacts
     * @throws ArtifactException in case that artifact creation fails
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> javac(Path source, Path target, Map<String, Object> other) 
        throws ArtifactException {
        return javac(source.selectAll(), target, other);
    }

    /**
     * Compiles a source path to a target path.
     * 
     * @param source the source artifacts
     * @param target the target path
     * @param other the other parameter for the Java compiler, without leading "-"
     * @return the created artifacts
     * @throws ArtifactException in case that artifact creation fails
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> javac(Collection<FileArtifact> source, Path target, Map<String, Object> other) 
        throws ArtifactException {
        long timestamp = PathUtils.normalizedTime();
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        if (source.isEmpty()) {
            throw new ArtifactException("no source files to compile", ArtifactException.ID_INSUFFICIENT_ARGUMENT);
        }
        List<File> files = new ArrayList<File>();
        for (FileArtifact fa : source) {
            files.add(fa.getPath().getAbsolutePath());
        }
        List<String> options = new ArrayList<String>();
        File targetPath = determineTargetPath(target);
        if (null != targetPath) {
            options.add("-d");
            options.add(targetPath.getAbsolutePath());
        }
        for (Map.Entry<String, Object> param : other.entrySet()) {
            options.add("-" + param.getKey());
            String val = toString(param.getValue());
            /*if (val.contains(" ")) {
                val = "\"" + val + "\"";
            }*/
            options.add(val);
        }

        StringWriter writer = new StringWriter();
        Iterable<? extends JavaFileObject> compilationUnits = fileManager.getJavaFileObjectsFromFiles(files);
        boolean success = compiler.getTask(writer, fileManager, null, options, null, compilationUnits).call();
        try {
            fileManager.close(); 
        } catch (IOException e) {
            throw new ArtifactException(e.getMessage(), ArtifactException.ID_IO);
        }
        if (!success) {
            throw new ArtifactException(writer.toString(), ArtifactException.ID_RUNTIME_EXECUTION);
        }

        List<FileArtifact> result = new ArrayList<FileArtifact>();
        ScanResult<FileArtifact> scanResult = new ScanResult<FileArtifact>(result);
        FileUtils.scan(targetPath.getAbsoluteFile(), target.getArtifactModel(), timestamp, scanResult, 
            FileArtifact.class);
        scanResult.checkForException();
        return new ListSet<FileArtifact>(result, FileArtifact.class);
    }

}
