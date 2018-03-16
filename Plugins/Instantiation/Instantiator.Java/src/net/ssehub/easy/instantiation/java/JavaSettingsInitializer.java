package net.ssehub.easy.instantiation.java;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.instantiation.core.model.artifactModel.Path;
import net.ssehub.easy.instantiation.core.model.artifactModel.ProjectSettings;
import net.ssehub.easy.instantiation.core.model.vilTypes.ISettingsInitializer;
import net.ssehub.easy.instantiation.core.model.vilTypes.Set;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

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
    public static String[] determineClasspath(Object classpath) {
        // In case the classpath is set via VIL
        String[] result = null;
        if (null != classpath) {
            if (classpath instanceof String) {
                result = normalizePath(new String[] {String.valueOf(classpath)});
            } else if (classpath instanceof Set<?>) {
                Set<?> classpathSet = (Set<?>) classpath;
                HashSet<String> tmpClasspath = new HashSet<String>();
                int parameterCount = classpathSet.getGenericParameterCount();
                TypeDescriptor<?> typeDescriptorParameter = classpathSet.getGenericParameterType(parameterCount - 1);
                for (Iterator<?> iterator = classpathSet.iterator(); iterator.hasNext();) {
                    // Validate String; if file does not exists it won't be
                    // added to the classpath
                    if (TypeRegistry.stringType().isSame(typeDescriptorParameter)) {
                        String string = (String) iterator.next();
                        File file = new File(string);
                        if (file.exists()) {
                            add(tmpClasspath, normalizePath(file.getAbsolutePath()));
                        }
                    } else if (typeDescriptorParameter.isSame(TypeRegistry.DEFAULT.findType(Path.class))) {
                        // Path
                        Path path = (Path) iterator.next();
                        if (path.exists()) {
                            add(tmpClasspath, normalizePath(path.getAbsolutePath().getAbsolutePath()));
                        }
                    } else {
                        // fallback: do nothing
                        iterator.next();
                    }
                }
                String[] tmpResult = new String[tmpClasspath.size()];
                result = tmpClasspath.toArray(tmpResult);
            }
        } else {
            // Get the classpath from eclipse
            String[] systemClasspath = normalizePath(JAVA_CLASSPATH.split(File.pathSeparator));
            result = systemClasspath;
        }
        return result;
    }
    
    /**
     * Converts a path to unix file pattern.
     * 
     * WARNING: The JDT/AST parser expects a "/" as separator!
     * 
     * @param allPaths array containing all path elements
     * @return array with converted path elements
     */
    private static String[] normalizePath(String [] allPaths) {
        List<String> tmp = new ArrayList<String>();
        for (int i = 0; i < allPaths.length; i++) {
            String normalized = normalizePath(allPaths[i]);
            if (null != normalized) {
                tmp.add(normalized);
            }
        }
        String[] result = new String[tmp.size()];
        return tmp.toArray(result);
    }

    /**
     * Filters <code>allPaths</code> for resolvable paths.
     * 
     * @param allPaths the paths to be filtered
     * @return the filtered paths
     */
    public static String[] filterPath(String [] allPaths) {
        List<String> tmp = new ArrayList<String>();
        for (int i = 0; i < allPaths.length; i++) {
            String path = resolve(allPaths[i]);
            if (null != path) {
                tmp.add(allPaths[i]);
            }
        }
        String[] result = new String[tmp.size()];
        return tmp.toArray(result);
    }

    /**
     * Adds <code>elt</code> to <code>elts</code>.
     * 
     * @param elts the elements
     * @param elt the element to add (may be <b>null</b>, ignored then)
     */
    private static void add(HashSet<String> elts, String elt) {
        if (null != elt) {
            elts.add(elt);
        }
    }
    
    /**
     * Converts a path to unix file pattern.
     * 
     * WARNING: The JDT/AST parser expects a "/" as separator!
     * 
     * @param path path as string
     * @return converted path (may be <b>null</b> if <code>path</code> does not exist)
     */
    private static String normalizePath(String path) {
        String result = resolve(path);
        if (null != result) {
            result = result.replace("\\", "/");
        }
        return result;
    }

    /**
     * Returns a resolved path.
     * 
     * @param path the path to resolve
     * @return the resolved path or <b>null</b> if the path cannot be resolved
     */
    private static String resolve(String path) {
        String resolved = null;
        if (null != path) {
            // primitive, cannot handle Eclipse workspace root
            File f = new File(path);
            if (f.exists()) {
                resolved = path;
            }
        }
        return resolved;
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
