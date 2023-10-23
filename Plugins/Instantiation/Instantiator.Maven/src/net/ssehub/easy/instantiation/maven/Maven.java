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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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

    private static final String TMP_FOLDER = "easy-maven363";
    private static final boolean CMD_TEST = true;
    // folder without /lib!
    private static final boolean AS_PROCESS = Boolean.valueOf(System.getProperty("easy.maven.asProcess", "true"));
    private static final String MAVEN_HOME = System.getProperty("easy.maven.home", null);
    private static final String CLASSPATH = System.getProperty("easy.maven.classpath", null);
    private static final String SETTINGS = System.getProperty("easy.maven.settings", 
        System.getenv("MAVEN_SETTINGS_PATH"));
    private static final String REPO_LOCAL = System.getProperty("easy.maven.repo.local", null);
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
     * @param mvnArgs optional maven arguments
     * @param updateSnapshots whether snapshots shall be updated
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, Sequence<String> mvnArgs, boolean updateSnapshots) 
        throws VilException {
        return maven(root, (String) null, mvnArgs, updateSnapshots);
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
        return maven(root, buildFilePath, null, updateSnapshots);
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
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, String buildFilePath, Sequence<String> mvnArgs, 
        boolean updateSnapshots) throws VilException {
        return build(root, buildFilePath, updateSnapshots, new String[] {"clean", "install"}, mvnArgs);
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
        return maven(root, (Sequence<String>) null, updateSnapshots, buildtargets);
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
    @OperationMeta(returnGenerics = FileArtifact.class)
    public static Set<FileArtifact> maven(Path root, Sequence<String> mvnArgs, boolean updateSnapshots, 
        Sequence<String> buildtargets) throws VilException {
        return build(root, null, updateSnapshots, toTargets(buildtargets), mvnArgs);
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
        return build(root, buildFilePath, updateSnapshots, toTargets(buildtargets), null);
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
     * Adds {@code updateSnapshots} and {@code mvnArgs} to {@code arguments}.
     * 
     * @param arguments the arguments to be modified as a side effect
     * @param updateSnapshots whether snapshots will be updated
     * @param mvnArgs additional maven arguments, may contain {@code -U} added then only once, may be <b>null</b> 
     *     for none
     */
    private static void addArguments(List<String> arguments, boolean updateSnapshots, Sequence<String> mvnArgs) {
        final String mvnUpdateArg = "-U"; // also -s, localrepo?
        boolean doUpdate = false;
        if (null != mvnArgs) {
            for (String arg: mvnArgs) {
                arg = arg.trim();
                doUpdate = mvnUpdateArg.equals(arg);
                arguments.add(arg);
            }
        }
        if (!doUpdate && updateSnapshots) {
            arguments.add(mvnUpdateArg);
        }
    }

    /**
     * Executes a specific MAVEN build specification.
     * 
     * @param root the root-path
     * @param buildFilePath the path where the MAVEN file is located
     * @param updateSnapshots whether snapshots shall be updated (-U)
     * @param targets the targets to be executed
     * @param mvnArgs additional maven args, may be <b>null</b>
     * @return the created artifacts
     * @throws VilException in case of artifact / parameter problems
     */
    private static Set<FileArtifact> build(Path root, String buildFilePath, boolean updateSnapshots, String[] targets, 
        Sequence<String> mvnArgs) throws VilException {
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
                addArguments(arguments, updateSnapshots, mvnArgs);
                for (String t: targets) {
                    arguments.add(t);
                }
                splitArgs(System.getenv("MAVEN_ARGS"), arguments);
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
                cliResult = runAsProcess(buildFilePath, updateSnapshots, targets, mvnArgs);
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
            int pos = classpath.indexOf("maven-embedder-"); // do we have any maven library on the classpath?
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
                    if (null != CLASSPATH) {
                        classpath = addToClasspath(classpath, CLASSPATH);
                    } else {
                        File mavenHome = null == MAVEN_HOME ? tryUnpack(classpath) : new File(MAVEN_HOME);
                        classpath = addFilesToClasspath("", new File(mavenHome, "lib"));
                    }
                }
            }
        }
        return classpath;
    }
    
    private static InputStream getResourceAsStream(String name) {
        InputStream result = Maven.class.getResourceAsStream(name);
        if (CMD_TEST && null == result) { // fallback for main-testing
            if (name.startsWith("/")) {
                name = "." + name;
            }
            File f = new File(name);
            if (f.exists()) {
                try {
                    result = new FileInputStream(name);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return result;
    }
    
    private static void closeQuietly(InputStream stream) {
        if (null != stream) {
            try {
                stream.close();
            } catch (IOException e) {
            }
        }
    }
    
    /**
     * Tries to unpack the Maven libraries to <i>tmpDir</i>{@link #TMP_FOLDER} by reading <code>lib/dir.list</code>.
     * 
     * @param classpath the classpath (assuming a single entry) as fallback result
     * @return the folder with the unpacked libraries or the fallback folder based on <code>classpath</code>
     */
    private static File tryUnpack(String classpath) {
        File result = new File(classpath).getParentFile();
        InputStream list = getResourceAsStream("/lib/dir.list");
        if (list != null) {
            result = new File(FileUtils.getTempDirectory(), TMP_FOLDER);
            File target = new File(result, "lib");
            target.mkdirs();
            try (LineNumberReader files = new LineNumberReader(new InputStreamReader(list))) {
                String line;
                do {
                    line = files.readLine();
                    if (null != line) {
                        line = line.trim();
                        if (line.length() > 0) {
                            File f = new File(target, line);
                            if (!f.exists()) {
                                copyResourceToFile("/lib/" + line, f, getSub(line));
                            }
                        }
                    }
                } while (null != line);
            } catch (IOException e) {
                getLogger().warn("Maven: Cannot read lib/dir.list: " + e.getMessage());
            }
            closeQuietly(list);
        }
        return result;
    }
    
    /**
     * Returns the target sub-directory in line.
     * 
     * @param line the line
     * @return the sub-directory, may be <b>null</b> for none
     */
    private static String getSub(String line) {
        int pos = line.lastIndexOf("/");
        String sub;
        if (pos > 0) {
            sub = line.substring(0, pos);
        } else {
            sub = null;
        }
        return sub;
    }

    /**
     * Copies a resource to a target file.
     * 
     * @param resource the resource
     * @param target the target file
     * @param sub optional target sub-directory within {@code target}, may be <b>null</b> for none
     */
    private static void copyResourceToFile(String resource, File target, String sub) {
        InputStream fIn = getResourceAsStream(resource);
        if (fIn != null) {
            try {
                if (sub != null) {
                    File dir = new File(target, sub);
                    dir.mkdirs();
                    dir.deleteOnExit();
                }
                Files.copy(fIn, target.toPath(), StandardCopyOption.REPLACE_EXISTING);
                fIn.close();
                target.deleteOnExit();
            } catch (IOException e) {
                getLogger().error("Maven: Cannot write library " + target + ": " + e.getMessage());
            }
        }
    }

    /**
     * Adds <code>path</code> to <code>classpath</code>.
     * 
     * @param classpath the classpath the <code>path</code> shall be added to
     * @param path the file be added
     * @return the augmented classpath
     */
    private static String addToClasspath(String classpath, String path) {
        if (classpath.length() > 0) {
            classpath += File.pathSeparator;
        }
        classpath += path;
        return classpath;
    }

    /**
     * Adds files in <code>base</code> to <code>classpath</code>.
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
                    classpath = addToClasspath(classpath, f.getAbsolutePath());
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
     * @param mvnArgs additional maven args, may be <b>null</b> for none
     * @return the command line execution code of Maven
     * @throws IOException in case that execution or process creation fails 
     * @throws InterruptedException in case that the created process was interrupted
     */
    private static int runAsProcess(String buildFilePath, boolean updateSnapshots, String[] targets, 
        Sequence<String> mvnArgs) throws IOException, InterruptedException {
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
            File confFile = Environment.toFile(m2Conf);
            File mavenHome = confFile.getParentFile().getParentFile();
            params.add("-Dmaven.home=" + mavenHome.getAbsolutePath());
            params.add("-Dclassworlds.conf=" + confFile.getAbsolutePath());
            params.add("org.codehaus.plexus.classworlds.launcher.Launcher");
            manipulator = new PlexusMessageManipulator();
        } else {
            m2Conf = null; // enable fallback
        }
        params.add("-Dmaven.multiModuleProjectDirectory=false"); // seems to be required since 3.3.1
        if (null == m2Conf) { // fallback for standalone (does not work in linux so far)
            params.add("org.apache.maven.cli.MavenCli");
            manipulator = new CliMessageManipulator();
        }
        addArguments(params, updateSnapshots, mvnArgs);
        if (null != SETTINGS) {
            params.add("-s");
            params.add(SETTINGS);
        }
        if (null != REPO_LOCAL) {
            params.add("-Dmaven.repo.local=" + REPO_LOCAL);
        }
        for (String target : targets) {
            params.add(target);
        }
        splitArgs(System.getenv("MAVEN_ARGS"), params);
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
     * Splits {@code args} into individual params and adds them to {@code params}. {@code args} may contain quotes.
     * 
     * @param args the arguments, may be <b>null</b> or empty
     * @param params the parameters, modified as side effect by adding
     */
    private static void splitArgs(String args, List<String> params) {
        if (args != null && args.length() > 0) {
            boolean inQuote = false;
            int lastPos = 0;
            for (int i = 0; i < args.length(); i++) {
                char c = args.charAt(i);
                if (Character.isWhitespace(c) && !inQuote) {
                    params.add(args.substring(lastPos, i).trim());
                    lastPos = i + 1;
                } else if (c == '"') {
                    inQuote = !inQuote;
                }
            }
            if (lastPos < args.length()) {
                params.add(args.substring(lastPos, args.length()).trim());
            }
        }
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
                    File f = Environment.toFile(u);
                    if (classpath.length() > 0) {
                        classpath += File.pathSeparator;
                    }
                    classpath += f.getAbsolutePath();
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