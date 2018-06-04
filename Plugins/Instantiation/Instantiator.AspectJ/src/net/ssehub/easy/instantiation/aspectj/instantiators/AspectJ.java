package net.ssehub.easy.instantiation.aspectj.instantiators;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.IOUtils;
import org.aspectj.bridge.IMessage;
import org.aspectj.bridge.MessageHandler;
import org.aspectj.bridge.context.CompilationAndWeavingContext;
import org.aspectj.tools.ajc.Main;
import org.aspectj.weaver.Dump;

import net.ssehub.easy.instantiation.aspectj.Registration;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileUtils;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.artifactModel.PathUtils;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileUtils.ScanResult;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.defaultInstantiators.AbstractFileInstantiator;
import net.ssehub.easy.instantiation.core.model.execution.IInstantiatorTracer;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;
import net.ssehub.easy.instantiation.core.model.vilTypes.Collection;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Compiles java files using the AspectJ compiler.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("aspectJ")
public class AspectJ extends AbstractFileInstantiator {

    private static final String CLASSPATH_ARG_NAME = "classpath"; 

    /**
     * A completion runner for AspectJ.
     * 
     * @author Holger Eichelberger
     */
    private static class CompletionRunner implements Runnable {

        private boolean completed = false;
        
        /**
         * Waits for the completion of the compilation.
         */
        void waitForCompletion() {
            while (!completed) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                }
            }
        }

        @Override
        public void run() {
            completed = true;
        }
        
    }
    
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
    public static Set<FileArtifact> aspectJ(Path source, Path target, Map<String, Object> other) 
        throws VilException {
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
     * @throws VilException in case that artifact creation fails
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> aspectJ(Collection<FileArtifact> source, Path target, Map<String, Object> other) 
        throws VilException {
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
     * @throws VilException in case that artifact creation fails
     */
    private static Set<FileArtifact> aspectJ(Collection<FileArtifact> source, File sourceRoot, Path target, 
        Map<String, Object> other) throws VilException {
        
        String envErr = Registration.checkEnvironment();
        if (null != envErr) {
            throw new VilException("Sorry, but... " + envErr, VilException.ID_RUNTIME);
        }
        
        long timestamp = PathUtils.normalizedTime();
        File targetPath = determineTargetPath(target);
        if (!source.isEmpty()) { // be tolerant!
            Main compiler = new Main();
    
            List<String> args = new ArrayList<String>();
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
            args.add("1.7");
            if (null != sourceRoot) {
                addAll(sourceRoot, args);
            } else {
                for (FileArtifact fa : source) {
                    args.add(fa.getPath().getAbsolutePath().getAbsolutePath());
                }
            }
            if (null == sourceRoot && source.isEmpty()) {
                throw new VilException("no source files to compile", VilException.ID_INSUFFICIENT_ARGUMENT);
            }
            MessageHandler m = new MessageHandler();
            String[] tmpArgs = new String[args.size()];
            args.toArray(tmpArgs);
            compiler.setHolder(m);
            CompletionRunner completion = new CompletionRunner();
            compiler.setCompletionRunner(completion);
            compiler.runMain(tmpArgs, false);
            completion.waitForCompletion();
            CompilationAndWeavingContext.reset();
            Dump.reset();
            handleMessages(m);
        }

        List<FileArtifact> result = new ArrayList<FileArtifact>();
        ScanResult<FileArtifact> scanResult = new ScanResult<FileArtifact>(result);
        FileUtils.scan(targetPath.getAbsoluteFile(), target.getArtifactModel(), timestamp, scanResult, 
            FileArtifact.class);
        scanResult.checkForException();
        
        return new ListSet<FileArtifact>(result, FileArtifact.class);
    }

    /**
     * Handles AspectJ messages.
     * 
     * @param handler the message handler
     * @throws VilException in case that abort of processing is needed
     */
    private static void handleMessages(MessageHandler handler) throws VilException {
        IInstantiatorTracer tracer = TracerFactory.createInstantiatorTracer();
        for (IMessage msg : handler.getUnmodifiableListView()) {
            if (msg.isDebug() || msg.isInfo() || msg.isWarning()) {
                tracer.traceMessage(msg.getMessage());
            } else {
                tracer.traceError(msg.getMessage());
            }
        }
        if (handler.getErrors().length > 0) {
            StringBuilder tmp = new StringBuilder();
            for (IMessage message : handler.getMessages(null, true)) {
                tmp.append(message.toString());
                tmp.append("\r\n");
            }
            throw new VilException(tmp.toString(), VilException.ID_RUNTIME_EXECUTION);
        }
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
     * @throws VilException are required resources such as aspectj.rt available
     */
    private static String prepareAspectJClasspath(String classpath) throws VilException {

        // the aspectjrt is required in execution classpath - prerequisite is availabe via classpath
        InputStream aspectJRt = AspectJ.class.getClassLoader().getResourceAsStream("lib/aspectJ/runtime/aspectjrt.jar");
        if (null == aspectJRt) {
            throw new VilException("aspectj.rt not found - cannot execute aspectj", 
                VilException.ID_RUNTIME_RESOURCE);
        }
        File tmpJar = new File(FileUtils.getTempDirectory(), "aspectjrt.jar");
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
                throw new VilException(e.getMessage(), VilException.ID_RUNTIME_RESOURCE);
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
