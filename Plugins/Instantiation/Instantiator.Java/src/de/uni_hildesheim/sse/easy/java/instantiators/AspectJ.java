package de.uni_hildesheim.sse.easy.java.instantiators;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.MessageHandler;
import org.aspectj.bridge.context.CompilationAndWeavingContext;
import org.aspectj.tools.ajc.Main;
import org.aspectj.weaver.Dump;

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
 * Compiles java files using the AspectJ compiler.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("aspectJ")
public class AspectJ extends AbstractFileInstantiator {

    private static final String CLASSPATH_ARG_NAME = "classpath"; 
    
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
    public static Set<FileArtifact> aspectJ(Path source, Path target, Map<String, Object> other) 
        throws ArtifactException {
        Set<FileArtifact> result;
        if (source.getAbsolutePath().isDirectory()) {
            result = aspectJ(null, source.getAbsolutePath(), target, other);
        } else {
            result = aspectJ(source.selectAll(), null, target, other);
        }
        return result;
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
    public static Set<FileArtifact> aspectJ(Collection<FileArtifact> source, Path target, Map<String, Object> other) 
        throws ArtifactException {
        return aspectJ(source, null, target, other);
    }

    /**
     * Compiles a source path to a target path.
     * 
     * @param source the source artifacts
     * @param sourceRoot optional source root to search Java and AspectJ files within, may be <b>null</b>, 
     *     supersedes <code>source</code> if given
     * @param target the target path
     * @param other the other parameter for the Java compiler, without leading "-"
     * @return the created artifacts
     * @throws ArtifactException in case that artifact creation fails
     */
    private static Set<FileArtifact> aspectJ(Collection<FileArtifact> source, File sourceRoot, Path target, 
        Map<String, Object> other) throws ArtifactException {
        
        long timestamp = PathUtils.normalizedTime();
        Main compiler = new Main();

        List<String> args = new ArrayList<String>();
        File targetPath = determineTargetPath(target);
        if (null != targetPath) {
            args.add("-d");
            args.add(targetPath.getAbsolutePath());
        }
        String classpath = "";
        for (Map.Entry<String, Object> param : other.entrySet()) {
            String argName = param.getKey();
            String val = toString(param.getValue());
            if (argName.equals(CLASSPATH_ARG_NAME)) {
                classpath = val;
            } else {
                args.add("-" + param.getKey());
                args.add(val);
            }
        }
        classpath = prepareAspectJClasspath(classpath);
        if (classpath.length() > 0) {
            args.add("-" + CLASSPATH_ARG_NAME);
            args.add(classpath);
        }
        args.add("-source");
        args.add("1.5");
        if (null != sourceRoot) {
            addAll(sourceRoot, args);
        } else {
            for (FileArtifact fa : source) {
                args.add(fa.getPath().getAbsolutePath().getAbsolutePath());
            }
        }
        if (null == sourceRoot && source.isEmpty()) {
            throw new ArtifactException("no source files to compile", ArtifactException.ID_INSUFFICIENT_ARGUMENT);
        }
        
        MessageHandler m = new MessageHandler();
        String[] tmpArgs = new String[args.size()];
        args.toArray(tmpArgs);
        compiler.run(tmpArgs, m);
        if (m.getErrors().length > 0) {
            StringBuilder tmp = new StringBuilder();
            for (IMessage message : m.getMessages(null, true)) {
                tmp.append(message.toString());
                tmp.append("\r\n"); // TODO replace by constant
            }
            throw new ArtifactException(tmp.toString(), ArtifactException.ID_RUNTIME_EXECUTION);
        }
        compiler.quit();
        CompilationAndWeavingContext.reset();
        Dump.reset();
        try {
            // try to wait for file system sync - some class files are sometimes missing
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        List<FileArtifact> result = new ArrayList<FileArtifact>();
        ScanResult<FileArtifact> scanResult = new ScanResult<FileArtifact>(result);
        FileUtils.scan(targetPath.getAbsoluteFile(), target.getArtifactModel(), timestamp, scanResult, 
            FileArtifact.class);
        scanResult.checkForException();
        
        return new ListSet<FileArtifact>(result, FileArtifact.class);
    }
    
    /**
     * Adds all Java and AJ files to <code>args</code>.
     * 
     * @param file the file or folder to start from
     * @param args the arguments to be modified as a side effect
     */
    private static final void addAll(File file, List<String> args) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (null != files) {
                for (int f = 0; f < files.length; f++) {
                    addAll(files[f], args);
                }
            }
        } else {
            String name = file.getName();
            if (name.endsWith(".java") || name.endsWith(".aj")) {
                args.add(file.getAbsolutePath());
            }
        }
    }

    /**
     * Prepares the AspectJ classpath.
     * 
     * @param classpath the actual classpath as specified (may be empty)
     * @return the classpath to use
     * @throws ArtifactException are required resources such as aspectj.rt available
     */
    private static String prepareAspectJClasspath(String classpath) throws ArtifactException {

        // the aspectjrt is required in execution classpath - prerequisite is availabe via classpath
        InputStream aspectJRt = AspectJ.class.getClassLoader().getResourceAsStream("aspectjrt.jar");
        if (null == aspectJRt) {
            throw new ArtifactException("aspectj.rt not found - cannot execute aspectj", 
                 ArtifactException.ID_RUNTIME_RESOURCE);
        }
        File tmpJar = new File(FileUtils.getTempDirectory(), "easyVilAspectJRt.jar");
        tmpJar.deleteOnExit();
        if (!tmpJar.exists()) {
            FileOutputStream out = null;
            try {
                out = new FileOutputStream(tmpJar);
                IOUtils.copy(aspectJRt, out);
                aspectJRt.close();
                aspectJRt = null;
                out.close();
                out = null;
            } catch (IOException e) {
                if (null != aspectJRt) {
                    try {
                        aspectJRt.close();
                    } catch (IOException e1) { 
                        // ignore
                    }
                }
                if (null != out) {
                    try {
                        aspectJRt.close();
                    } catch (IOException e1) { 
                        // ignore
                    }
                }
                throw new ArtifactException(e.getMessage(), ArtifactException.ID_RUNTIME_RESOURCE);
            }
        }
        List<String> entries = new ArrayList<String>();
        String[] tmpEntries = classpath.split(File.pathSeparator);
        for (int i = 0; i < tmpEntries.length; i++) {
            entries.add(tmpEntries[i]);
        }
        entries.add(tmpJar.getAbsolutePath());

        // add further JARs if required
        
        StringBuilder tmp = new StringBuilder();
        for (int e = 0; e < entries.size(); e++) {
            if (e > 0) {
                tmp.append(File.pathSeparator);
            }
            tmp.append(entries.get(e));
        }
        return tmp.toString();
    }
    
}
