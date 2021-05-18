/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.maven;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import net.ssehub.easy.basics.Environment;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.basics.logger.EASyLoggerFactory.EASyLogger;
import net.ssehub.easy.instantiation.core.JavaUtilities;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileArtifact;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileUtils;
import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.artifactModel.PathUtils;
import net.ssehub.easy.instantiation.core.model.artifactModel.FileUtils.ScanResult;
import net.ssehub.easy.instantiation.core.model.common.CommandLineProgramRegistry;
import net.ssehub.easy.instantiation.core.model.common.ICommandLineProgram;
import net.ssehub.easy.instantiation.core.model.common.StreamGobbler;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.common.StreamGobbler.IMsgManipulator;
import net.ssehub.easy.instantiation.core.model.defaultInstantiators.AbstractFileInstantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.Instantiator;
import net.ssehub.easy.instantiation.core.model.vilTypes.ListSet;
import net.ssehub.easy.instantiation.core.model.vilTypes.OperationMeta;
import net.ssehub.easy.instantiation.core.model.vilTypes.Sequence;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;

/**
 * Builds Java applications with Maven.
 * 
 * @author Holger Eichelberger
 */
@Instantiator("maven")
public class Maven extends AbstractFileInstantiator {

    // folder without /lib!
    private static final boolean AS_PROCESS = Boolean.valueOf(System.getProperty("easy.maven.asProcess", "true"));
    private static final String MAVEN_HOME = System.getProperty("easy.maven.home", null);
    // running the instantiator as a JUnit test from Eclipse may carry unsigned dependencies - exclude Eclipse path
    private static final String CLASSPATH_EXCLUDE = System.getProperty("easy.maven.classpathExclude", null);

    /**
     * Executes a specific MAVEN build specification with "clean" and "install" targets.
     * 
     * @param root the root-path
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> maven(Path root) throws VilException {
        return maven(root, (String) null);
    }    

    /**
     * Executes a specific MAVEN build specification with "clean" and "install" targets.
     * 
     * @param root the root-path
     * @param updateSnapshots whether snapshots shall be updated
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, boolean updateSnapshots) throws VilException {
        return maven(root, (String) null, updateSnapshots);
    }    

    /**
     * Executes a specific MAVEN build specification with "clean" and "install" targets.
     * 
     * @param root the root-path
     * @param buildFilePath the path where the MAVEN file is located
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, String buildFilePath) throws VilException {
        return maven(root, buildFilePath, false);
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
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, String buildFilePath, boolean updateSnapshots) 
        throws VilException {
        return build(root, buildFilePath, updateSnapshots, new String[] {"clean", "install"});
    }    
    
    /**
     * Executes a specific MAVEN build specification.
     * 
     * @param root the root-path
     * @param buildtargets the targets to be executed
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, Sequence<String> buildtargets) 
        throws VilException {
        return maven(root, false, buildtargets);
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
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, boolean updateSnapshots, Sequence<String> buildtargets) 
        throws VilException {
        return build(root, null, updateSnapshots, toTargets(buildtargets));
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
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, String buildFilePath, Sequence<String> buildtargets) 
        throws VilException {
        return maven(root, buildFilePath, false, buildtargets);
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
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, String buildFilePath, boolean updateSnapshots, 
        Sequence<String> buildtargets) 
        throws VilException {
        return build(root, buildFilePath, updateSnapshots, toTargets(buildtargets));
    }
    
    /**
     * Turns the given targets into an array.
     * 
     * @param buildtargets the targets as VIL sequence
     * @return the targets as string array
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
     * @param updateSnapshots whether snapshots shall be updated (-U)
     * @param targets the targets to be executed
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    private static Set<FileArtifact> build(Path root, String buildFilePath, boolean updateSnapshots, String[] targets) 
        throws VilException {
        File targetPath = determineTargetPath(root);
        if (null != buildFilePath) {
            buildFilePath = new File(targetPath, buildFilePath).toString();
        } else {
            buildFilePath = targetPath.toString();
        }
        long timestamp = PathUtils.normalizedTime();
        int cliResult = -1;
        boolean asProcess = AS_PROCESS;
        if (!AS_PROCESS) {
            ICommandLineProgram prg = CommandLineProgramRegistry.getRegisteredProgram("mvn");
            if (null != prg) {
                List<String> arguments = new ArrayList<String>();
                if (updateSnapshots) {
                    arguments.add("-U");
                }
                for (String t: targets) {
                    arguments.add(t);
                }
                String[] args = new String[arguments.size()];
                cliResult = prg.prepare().execute(arguments.toArray(args), buildFilePath, System.out, System.out);
            } else {
                getLogger().warn(
                    "Cannot obtain Maven command line instance. Trying to run Maven as process (fallback).");
                asProcess = true;
            }
        }
        if (asProcess) {
            try {
                cliResult = runAsProcess(buildFilePath, updateSnapshots, targets);
            } catch (IOException | InterruptedException e) {
                throw new VilException("maven build failed: " + e.getMessage(), 
                    VilException.ID_RUNTIME_EXECUTION);
            }
        }
        if (0 != cliResult) {
            throw new VilException("maven build failed", VilException.ID_RUNTIME_EXECUTION);
        }
        List<FileArtifact> result = new ArrayList<FileArtifact>();
        ScanResult<FileArtifact> scanResult = new ScanResult<FileArtifact>(result);
        FileUtils.scan(targetPath.getAbsoluteFile(), root.getArtifactModel(), timestamp, scanResult, 
            FileArtifact.class);
        scanResult.checkForException();
        return new ListSet<FileArtifact>(result, FileArtifact.class);
    }

    /**
     * ANT is a bit different regarding its class loader...
     * 
     * @return the classpath if available
     */
    private static String getClasspath() {
        String result = null;
        ClassLoader loader = Maven.class.getClassLoader();
        Class<?> loaderClass = loader.getClass();
        if (loaderClass.getName().indexOf("AntClassLoader") > 0) {
            Method method = null;
            try {
                method = loaderClass.getMethod("getClasspath");
                method.setAccessible(true);
                Object tmp = method.invoke(loader);
                if (null != tmp) {
                    result = tmp.toString();
                }
            } catch (NoSuchMethodException e) {
                // ignore
            } catch (IllegalAccessException e) {
                // ignore
            } catch (IllegalArgumentException e) {
                // ignore
            } catch (InvocationTargetException e) {
                // ignore
            }
        }
        return result;
    }
    
    /**
     * In case that we have the standalone and a classpath that does not contain any (expected) maven library, 
     * take either {@link #MAVEN_HOME}, the easy-headless or the first jar as location into account 
     * and add the contents of the library folder in this location.
     * 
     * @param classpath the classpath
     * @return the rewritten classpath
     */
    private static String rewriteIfUnbundled(String classpath) {
        // runsInEclipse() method did not work for RCP
        if (null != classpath && null == System.getProperty("eclipse.home.location", null)) {
            int pos = classpath.indexOf("maven-"); // do we have any maven library on the classpath?
            if (pos < 0) {
                pos = Math.max(0, classpath.indexOf("easy-headless.jar")); // assume easy-headless or take the first one
                int start = pos;
                // search start of classpath entry
                while (start > 0 && classpath.charAt(start) != File.pathSeparatorChar) {
                    start--;
                }
                // are we at the path separator char
                if (start > 0) {
                    start++;
                }
                // search end of classpath entry
                while (pos < classpath.length() && classpath.charAt(pos) != File.pathSeparatorChar) {
                    pos++;
                }
                if (start < pos) {
                    classpath = classpath.substring(start, pos);
                    File mavenHome = null == MAVEN_HOME ? new File(classpath).getParentFile() : new File(MAVEN_HOME);
                    classpath = addFilesToClasspath("", new File(mavenHome, "lib"));
                }
            }
        }
        return classpath;
    }

    /**
     * Adds files in <code>base</code> to classpath.
     * 
     * @param classpath the classpath the file names shall be added to
     * @param base the base file/folder to list the file names from
     * @return the augmented classpath if files were found
     */
    private static String addFilesToClasspath(String classpath, File base) {
        File[] mavenLib = base.listFiles();
        if (null != mavenLib) {
            for (File f: mavenLib) {
                if (f.getName().endsWith(".jar")) {
                    if (classpath.length() > 0) {
                        classpath += File.pathSeparator;
                    }
                    classpath += f.getAbsolutePath();
                }
            }
        }
        return classpath;
    }
    
    /**
     * Runs Maven as a separate process. This might be needed to avoid unnecessary file locks caused by Maven.
     * 
     * @param buildFilePath the path where the MAVEN file is located
     * @param updateSnapshots whether snapshots shall be updated (-U)
     * @param targets the targets to be executed
     * @return the command line execution code of Maven
     * @throws IOException in case that execution or process creation fails 
     * @throws InterruptedException in case that the created process was interrupted
     */
    private static int runAsProcess(String buildFilePath, boolean updateSnapshots, String[] targets) 
        throws IOException, InterruptedException {
        List<String> params = new ArrayList<String>();
        String jdkHome = JavaUtilities.JDK_PATH;
        if (null == jdkHome) {
            jdkHome = System.getProperty("java.home"); // risk that this is a JRE and that Maven complains
        }
        params.add(jdkHome + File.separator + "bin" + File.separator + "java");

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        String classpath = obtainProcessClasspath(contextClassLoader);       
        if (classpath.length() > 0) {
            params.add("-cp");
            params.add(classpath);
        }
        
        IMsgManipulator manipulator = null;
        URL m2Conf = Activator.resolve(contextClassLoader.getResource("conf/m2.conf"));
        if (Activator.isFileProtocol(m2Conf)) { // available if unpacked, not in Standalone
//            try {
            File confFile = Environment.toFile(m2Conf);
//                File confFile = new File(m2Conf.toURI());
            File mavenHome = confFile.getParentFile().getParentFile();
            params.add("-Dmaven.home=" + mavenHome.getAbsolutePath());
            params.add("-Dclassworlds.conf=" + confFile.getAbsolutePath());
            params.add("org.codehaus.plexus.classworlds.launcher.Launcher");
            manipulator = new PlexusMessageManipulator();
//            } catch (URISyntaxException e) {
//                m2Conf = null; // enable fallback
//            }
        } else {
            m2Conf = null; // enable fallback
        }
        if (null == m2Conf) { // fallback for standalone (does not work in linux so far)
            params.add("org.apache.maven.cli.MavenCli");
            manipulator = new CliMessageManipulator();
        }
        if (updateSnapshots) {
            params.add("-U");
        }
        for (String target : targets) {
            params.add(target);
        }
        getLogger().debug("Maven command line: " + params);        
        ProcessBuilder builder = new ProcessBuilder(params);
        if (null == System.getenv("JAVA_HOME") && null != JavaUtilities.JDK_PATH) {
            File jdkFolder = new File(JavaUtilities.JDK_PATH);
            if (jdkFolder.exists()) {
                builder.environment().put("JAVA_HOME", JavaUtilities.JDK_PATH);
            }
        }        
        
        builder.directory(new File(buildFilePath));
        Process proc = builder.start();
        StreamGobbler.gobble(proc, manipulator);
        return proc.waitFor();
    }
    
    /**
     * Returns the logger instance.
     * 
     * @return the logger instance
     */
    private static EASyLogger getLogger() {
        return EASyLoggerFactory.INSTANCE.getLogger(Maven.class, Activator.BUNDLE_ID);        
    }
    
    /**
     * Obtains the classpath for running Maven as a process.
     * 
     * @param contextClassLoader the context class loader to obtain the classpath from if possible at all
     * @return the classpath
     */
    private static String obtainProcessClasspath(ClassLoader contextClassLoader) {
        Pattern classpathExclude = null;
        if (null != CLASSPATH_EXCLUDE) {
            try {
                classpathExclude = Pattern.compile(CLASSPATH_EXCLUDE);
            } catch (PatternSyntaxException e) {
                // ignore
            }
        }
        String classpath = getClasspath();       
        URL[] urls = Activator.getJars(); // null if not OSGi or not found
        if (null == classpath && null == urls && contextClassLoader instanceof URLClassLoader) {
            // for running EASy in standalone mode
            urls = ((URLClassLoader) contextClassLoader).getURLs();
        } 
        if (null == classpath && null != urls) {
            classpath = "";
            for (URL u : urls) {
                if (null == classpathExclude || !classpathExclude.matcher(u.toString()).matches()) {
//                    try {
//                        File f = new File(u.toURI());
                    File f = Environment.toFile(u);
                    if (classpath.length() > 0) {
                        classpath += File.pathSeparator;
                    }
                    classpath += f.getAbsolutePath();
//                    } catch (URISyntaxException e) {
//                    }
                }
            }
        }
        if (null == classpath) { // classpath fallback
            classpath = System.getProperty("java.class.path");
        }
        classpath = rewriteIfUnbundled(classpath);
        return classpath;
    }
    
    /**
     * Gets rid of the logging level. There seems to be no SLF4J option.
     * 
     * @author Holger Eichelberger
     */
    private static class PlexusMessageManipulator implements IMsgManipulator {

        @Override
        public String manipulate(String message) {
            if (message.startsWith("[")) {
                int pos = message.indexOf("] ");
                if (pos > 0 && pos + 2 < message.length()) {
                    message = message.substring(pos + 2);
                }
            }
            return message;
        }
        
    }
    
    /**
     * Gets rid of the class name / logging level in Maven CLI mode. There seems to be no SLF4J option.
     * 
     * @author Holger Eichelberger
     */
    private static class CliMessageManipulator implements IMsgManipulator {

        @Override
        public String manipulate(String message) {
            int pos = message.indexOf(" - ");
            if (pos > 0 && pos + 2 < message.length()) {
                message = message.substring(pos + 2);
            }
            return message;
        }
        
    }
    
}