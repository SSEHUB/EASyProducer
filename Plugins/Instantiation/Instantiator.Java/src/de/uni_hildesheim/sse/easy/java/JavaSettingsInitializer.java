package de.uni_hildesheim.sse.easy.java;

import java.io.File;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ProjectSettings;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.ISettingsInitializer;

/**
 * Initializes the settings for java.
 * 
 * @author Aike Sass
 *
 */
public class JavaSettingsInitializer implements ISettingsInitializer {
    
//    private static Set<String> classpathEntries;

    @Override
    public void initialize(File base, Map<ProjectSettings, Object> settings) {
//        // Default fallback: Add the path of base to the classpath
//        String seperator = String.valueOf(File.pathSeparatorChar);
//        String[] splitClasspath = System.getProperty("java.class.path").split(seperator);
//        classpathEntries = new HashSet<String>(Arrays.asList(splitClasspath));
//        System.out.println("BASE: " +  base.getAbsolutePath());
//        classpathEntries.add(base.getAbsolutePath());
//        String newClasspath = "";
//        for (String string : classpathEntries) {
//            newClasspath += string + seperator;
//        }
//        System.out.println("CP: " + newClasspath);
//        System.setProperty("java.class.path", newClasspath);
    }

//    @Override
//    public void initialize(File base, Map<ProjectSettings, Object> settings) {
//        // TODO: THIS IS EXPERIMENTAL AND DOES CURRENTLY NOT WORK DUE TO HOW ECLIPSE HANDLES THE WORKSPACE.
//        // Catch every exception in case something goes wrong. Prevents the plugin from crashing.
//        try {
//            // Outside of eclipse environment
//            if (!Environment.runsInEclipse()) {
//                ProjectMock project = new ProjectMock(base.getAbsoluteFile());
//                // CRITICAL! If it does not exist, then the EASy-Standalone will CRASH AND BURN!
//                System.out.println(project.classPathFileExists());
//                if (project.classPathFileExists()) {
//                    IJavaProject javaProject = JavaCore.create(project);
//                    try {
//                        System.out.println(ClasspathEntry.TAG_ATTRIBUTE);
////                        Field workspace = ResourcesPlugin.class.getDeclaredField("workspace");
////                        workspace.setAccessible(true);
////                        workspace.set(null, new WorkspaceMock(base.getParentFile()));
//                        IClasspathEntry[] entries = javaProject.getRawClasspath();
//                        System.out.println(entries.length);
////                        String[] cpEntries = new String[entries.length];
//                        List<String> list = new ArrayList<String>();
//                        for (IClasspathEntry entry : entries) {
//                            list.add(entry.toString());
//                            System.out.println("Entry: " + entry.toString());
//                        }
//                        Set<PseudoString> entriesSet = new ArraySet<PseudoString>(list.toArray(
//                            new PseudoString[list.size()]), PseudoString.class);
//                        settings.put(JavaSettings.CLASSPATH, entriesSet);
//                    } catch (JavaModelException e) {
//                        logger.exception(e);
//                    }
//                }
//            } else if (Environment.runsInEclipse()) {
//                // We are inside of eclipse environment so we can access the workspace and open the IProject
//                IWorkspace workspace = ResourcesPlugin.getWorkspace();
//                IWorkspaceRoot root = workspace.getRoot();
//                IProject project = root.getProject(base.getName());
//                try {
//                    project.create(null);
//                    project.open(null);
//                } catch (CoreException e) {
//                    logger.exception(e);
//                }
//                // Add java nature
//                IProjectDescription desc;
//                try {
//                    desc = project.getDescription();
//                    desc.setNatureIds(new String[] {JavaCore.NATURE_ID });
//                    project.setDescription(desc, null);
//                } catch (CoreException e) {
//                    logger.exception(e);
//                }
//                // Set java builders output folder
//                IJavaProject javaProj = JavaCore.create(project);
//                IFolder binDir = project.getFolder("bin");
//                IPath binPath = binDir.getFullPath();
//                try {
//                    javaProj.setOutputLocation(binPath, null);
//                } catch (JavaModelException e) {
//                    logger.exception(e);
//                }
//                // Set classpath
//                IPath path = new Path(JavaUtilities.JDK_PATH);
//                IClasspathEntry cpe = JavaCore.newLibraryEntry(path, null, null);
//                try {
//                    javaProj.setRawClasspath(new IClasspathEntry[] {cpe}, null);
//                } catch (JavaModelException e) {
//                    logger.exception(e);
//                }
//            }
//        //checkstyle: stop exception type check
//        } catch (Exception e) {
//            logger.exception(e);
//            e.printStackTrace();
//        }
//        //checkstyle: resume exception type check
//    }

}
