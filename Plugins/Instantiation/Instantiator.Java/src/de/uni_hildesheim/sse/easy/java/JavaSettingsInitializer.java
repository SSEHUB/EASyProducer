package de.uni_hildesheim.sse.easy.java;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.Path;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ProjectSettings;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ISettingsInitializer;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeDescriptor;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.TypeRegistry;

/**
 * Initializes the settings for java.
 * 
 * @author Aike Sass
 *
 */
public class JavaSettingsInitializer implements ISettingsInitializer {

    private static final String JAVA_CLASSPATH = System.getProperty("java.class.path");

    // private static Set<String> classpathEntries;

    @Override
    public void initialize(File base, Map<ProjectSettings, Object> settings) {
        // // Default fallback: Add the path of base to the classpath
        // String seperator = String.valueOf(File.pathSeparatorChar);
        // String[] splitClasspath =
        // System.getProperty("java.class.path").split(seperator);
        // classpathEntries = new
        // HashSet<String>(Arrays.asList(splitClasspath));
        // System.out.println("BASE: " + base.getAbsolutePath());
        // classpathEntries.add(base.getAbsolutePath());
        // String newClasspath = "";
        // for (String string : classpathEntries) {
        // newClasspath += string + seperator;
        // }
        // System.out.println("CP: " + newClasspath);
        // System.setProperty("java.class.path", newClasspath);
    }

    /**
     * Determines the classpath. A given classpath via VIL will be parsed
     * accordingly.
     * 
     * @param classpath
     *            classpath object
     * @return classpath as string
     */
    public static String determineClasspath(Object classpath) {
        // In case the classpath is set via VIL
        String result = null;
        if (null != classpath) {
            if (classpath instanceof String) {
                result = String.valueOf(classpath);
            } else if (classpath instanceof Set<?>) {
                Set<?> classpathSet = (Set<?>) classpath;
                String tmpClasspath = "";
                int parameterCount = classpathSet.getGenericParameterCount();
                TypeDescriptor<?> typeDescriptorSet = classpathSet.getGenericParameterType(parameterCount - 1);
                TypeDescriptor<?> typeDescriptorParameter = typeDescriptorSet
                        .getGenericParameterType(typeDescriptorSet.getGenericParameterCount() - 1);
                for (Iterator<?> iterator = classpathSet.iterator(); iterator.hasNext();) {
                    // Validate String; if file does not exists it won't be
                    // added to the classpath
                    if (TypeRegistry.stringType().isSame(typeDescriptorParameter)) {
                        String string = (String) iterator.next();
                        File file = new File(string);
                        if (file.exists()) {
                            // TODO: Do we need this? extremely slow
                            // tmpClasspath = scanForJars(tmpClasspath, file);
                            tmpClasspath += string + File.pathSeparatorChar;
                        }
                    } else if (typeDescriptorParameter.isSame(TypeRegistry.DEFAULT.findType(Path.class))) {
                        // Path
                        Path path = (Path) iterator.next();
                        if (path.exists()) {
                            // TODO: Do we need this? extremely slow
                            // tmpClasspath = scanForJars(tmpClasspath,
                            // path.getAbsolutePath());
                            tmpClasspath += path.getAbsolutePath().getAbsolutePath() + File.pathSeparatorChar;
                        }
                    } else {
                        // fallback: do nothing
                        iterator.next();
                    }
                }
                result = tmpClasspath;
            }
        } else {
            // Get the classpath from eclipse
            String systemClasspath = JAVA_CLASSPATH;
            result = systemClasspath;
        }
        return result;
    }

    /**
     * Collect all jars inside the directory and add them to the classpath.
     * 
     * @param tmpClasspath
     *            the currently classpath
     * @param file
     *            directory to be scanned.
     * @return classpath containing all jars
     */
    private static String scanForJars(String tmpClasspath, File file) {
        if (file.isDirectory()) {
            // Scan for jars assuming the directory is the
            // root dir
            String[] extensions = new String[] {"jar" };
            List<File> jars = (List<File>) FileUtils.listFiles(file, extensions, true);
            if (null != jars && jars.size() > 0) {
                for (File file2 : jars) {
                    tmpClasspath += file2.getAbsolutePath() + File.pathSeparator;
                }
            }
        }
        return tmpClasspath;
    }

    // @Override
    // public void initialize(File base, Map<ProjectSettings, Object> settings)
    // {
    // // TODO: THIS IS EXPERIMENTAL AND DOES CURRENTLY NOT WORK DUE TO HOW
    // ECLIPSE HANDLES THE WORKSPACE.
    // // Catch every exception in case something goes wrong. Prevents the
    // plugin from crashing.
    // try {
    // // Outside of eclipse environment
    // if (!Environment.runsInEclipse()) {
    // ProjectMock project = new ProjectMock(base.getAbsoluteFile());
    // // CRITICAL! If it does not exist, then the EASy-Standalone will CRASH
    // AND BURN!
    // System.out.println(project.classPathFileExists());
    // if (project.classPathFileExists()) {
    // IJavaProject javaProject = JavaCore.create(project);
    // try {
    // System.out.println(ClasspathEntry.TAG_ATTRIBUTE);
    //// Field workspace = ResourcesPlugin.class.getDeclaredField("workspace");
    //// workspace.setAccessible(true);
    //// workspace.set(null, new WorkspaceMock(base.getParentFile()));
    // IClasspathEntry[] entries = javaProject.getRawClasspath();
    // System.out.println(entries.length);
    //// String[] cpEntries = new String[entries.length];
    // List<String> list = new ArrayList<String>();
    // for (IClasspathEntry entry : entries) {
    // list.add(entry.toString());
    // System.out.println("Entry: " + entry.toString());
    // }
    // Set<PseudoString> entriesSet = new ArraySet<PseudoString>(list.toArray(
    // new PseudoString[list.size()]), PseudoString.class);
    // settings.put(JavaSettings.CLASSPATH, entriesSet);
    // } catch (JavaModelException e) {
    // logger.exception(e);
    // }
    // }
    // } else if (Environment.runsInEclipse()) {
    // // We are inside of eclipse environment so we can access the workspace
    // and open the IProject
    // IWorkspace workspace = ResourcesPlugin.getWorkspace();
    // IWorkspaceRoot root = workspace.getRoot();
    // IProject project = root.getProject(base.getName());
    // try {
    // project.create(null);
    // project.open(null);
    // } catch (CoreException e) {
    // logger.exception(e);
    // }
    // // Add java nature
    // IProjectDescription desc;
    // try {
    // desc = project.getDescription();
    // desc.setNatureIds(new String[] {JavaCore.NATURE_ID });
    // project.setDescription(desc, null);
    // } catch (CoreException e) {
    // logger.exception(e);
    // }
    // // Set java builders output folder
    // IJavaProject javaProj = JavaCore.create(project);
    // IFolder binDir = project.getFolder("bin");
    // IPath binPath = binDir.getFullPath();
    // try {
    // javaProj.setOutputLocation(binPath, null);
    // } catch (JavaModelException e) {
    // logger.exception(e);
    // }
    // // Set classpath
    // IPath path = new Path(JavaUtilities.JDK_PATH);
    // IClasspathEntry cpe = JavaCore.newLibraryEntry(path, null, null);
    // try {
    // javaProj.setRawClasspath(new IClasspathEntry[] {cpe}, null);
    // } catch (JavaModelException e) {
    // logger.exception(e);
    // }
    // }
    // //checkstyle: stop exception type check
    // } catch (Exception e) {
    // logger.exception(e);
    // e.printStackTrace();
    // }
    // //checkstyle: resume exception type check
    // }

}
