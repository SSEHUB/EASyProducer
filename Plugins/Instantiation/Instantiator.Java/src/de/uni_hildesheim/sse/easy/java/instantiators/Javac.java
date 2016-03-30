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

import net.ssehub.easy.instantiation.core.JavaUtilities;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileUtils;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.artifactModel.PathUtils;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileUtils.ScanResult;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.defaultInstantiators.AbstractFileInstantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Compiles java files using Javac.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
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
     * @throws VilException in case that artifact creation fails
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> javac(Path source, Path target, Map<String, Object> other) 
        throws VilException {
        return javac(source.selectAll(), target, other);
    }

    /**
     * Compiles a source path to a target path.
     * 
     * @param source the source artifacts
     * @param target the target path
     * @param other the other parameter for the Java compiler, without leading "-"
     * @return the created artifacts
     * @throws VilException in case that artifact creation fails
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> javac(Collection<FileArtifact> source, Path target, Map<String, Object> other) 
        throws VilException {
        long timestamp = PathUtils.normalizedTime();
        JavaCompiler compiler = getJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        if (source.isEmpty()) {
            throw new VilException("no source files to compile", VilException.ID_INSUFFICIENT_ARGUMENT);
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
            throw new VilException(e.getMessage(), VilException.ID_IO);
        }
        if (!success) {
            throw new VilException(writer.toString(), VilException.ID_RUNTIME_EXECUTION);
        }

        List<FileArtifact> result = new ArrayList<FileArtifact>();
        ScanResult<FileArtifact> scanResult = new ScanResult<FileArtifact>(result);
        FileUtils.scan(targetPath.getAbsoluteFile(), target.getArtifactModel(), timestamp, scanResult, 
            FileArtifact.class);
        scanResult.checkForException();
        return new ListSet<FileArtifact>(result, FileArtifact.class);
    }

    /**
     * Gets the Java&trade; programming language compiler provided
     * with this platform. <br/>
     * If Java cannot find the compiler, this method will also try to use the <b><tt>JAVA_HOME</tt></b> variable
     * to detect the compiler.
     * @return The Java&trade; programming language compiler or <tt>null</tt> if the compiler could not be found.
     */
    private static synchronized JavaCompiler getJavaCompiler() {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        if (null == compiler) {
            String homeVariable = JavaUtilities.JDK_PATH;
            if (null != homeVariable) {
                String homeProperty = System.getProperty("java.home");
                System.setProperty("java.home", homeVariable);
                compiler = ToolProvider.getSystemJavaCompiler();
                System.setProperty("java.home", homeProperty);
            }
        }
        return compiler;
    }

}
