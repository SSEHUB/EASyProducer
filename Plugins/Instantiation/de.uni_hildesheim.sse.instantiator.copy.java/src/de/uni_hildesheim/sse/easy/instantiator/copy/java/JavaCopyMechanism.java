package de.uni_hildesheim.sse.easy.instantiator.copy.java;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRunnable;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IImportDeclaration;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ImportDeclaration;

import de.uni_hildesheim.sse.easy.instantiator.copy.core.AbstractCopyMechanism;

/**
 * Objects of this class copy files of a project to another project and
 * add the namespace of the origin project to the package structure. 
 * @author El-Sharkawy
 * @author Gawenda
 *
 */
public class JavaCopyMechanism extends AbstractCopyMechanism {

    @Override
    public void copy(String sourceProjectName, String targetProjectName) {
        IProject sourceProject = getResourceManager().getProject(sourceProjectName);
        IProject targetProject = getResourceManager().getProject(targetProjectName);
        try {
            // make project resources accesible
            sourceProject.open(null);
            targetProject.open(null);
            // java project? proceed with java copy
            if (sourceProject.isNatureEnabled(JavaCore.NATURE_ID)
                    && targetProject.isNatureEnabled(JavaCore.NATURE_ID)) {
                copyJavaSourceFiles(sourceProject, targetProject);
            } else {
                // for non javaprojects
                genericCopy(sourceProject, targetProject, new HashSet<String>(), true);
            }
        } catch (CoreException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Is responsible for copying java resources from one project to another. It maintains correct package declarations,
     * import declarations and also updates the classpath of the target project to maintain library entries. Multiple
     * steps are involved in this process.
     * <ul>
     * <li>the classpath of the source project is analyzed for source and library entries</li>
     * <li>the output folder is created at the target project with a new namespace</li>
     * <li>the packages are read in and cached from each source folder</li>
     * <li>all java and non java resources are read from each package</li>
     * <li>... and eventually copied to the target project with a new package structure</li>
     * <li>
     * afterwards all remaining folders are copied using a generic approach</li>
     * <li>The next step includes adapting the library source entries at the target project</li>
     * <li>Eventually the imports at the target project are adapted to the new structure</li>
     * </ul>
     * See also repairIMports {@link #repairImports(IPackageFragmentRoot, String, List)} and updateClasspathEntries
     * {@link #updateLibaryEntries(IJavaProject, List, String)}
     * 
     * @param sourceProject source project
     * @param targetProject target project
     * @throws CoreException is thrown when a java model modification or copy operation failed
     */
    private void copyJavaSourceFiles(IProject sourceProject, IProject targetProject) throws CoreException {
        IJavaProject javaSourceProject = JavaCore.create(sourceProject);
        IJavaProject javaTargetProject = JavaCore.create(targetProject);
        // get the PackageFragmentRoots
        List<IPackageFragmentRoot> roots = new ArrayList<IPackageFragmentRoot>();
        // prepare a list of ignores for the copy of remaining folders
        Set<String> ignoredFolders = new HashSet<String>();
        // do not copy the outputfolders of the sourceproject
        ignoredFolders.addAll(getBinaryFolders(sourceProject.getName()));
        ignoredFolders.add(getResourceManager().getConfigFolder());
        // prepare a list of librarys
        List<IClasspathEntry> libs = getClasspathEntries(javaSourceProject, IClasspathEntry.CPE_LIBRARY);
        // determine each source folder
        for (IClasspathEntry entry : getClasspathEntries(javaSourceProject, IClasspathEntry.CPE_SOURCE)) {
            String name = sourceProject.getFolder(entry.getPath()).getName();
            IFolder folder = sourceProject.getFolder(name);
            // convention: Resources folder is a source folder but most not be
            // migrated into the target
            // source
            if (!name.equals(getResourceManager().getResourcesFolder())) {
                IPackageFragmentRoot test = javaSourceProject.getPackageFragmentRoot(folder);
                roots.add(test);
                ignoredFolders.add(name);
            }
        }
        // prepare the new destination, it is always the main source folder per
        // convention
        IFolder folder = targetProject.getFolder(getResourceManager().getMainSourceFolder());
        IPackageFragmentRoot destination = javaTargetProject.getPackageFragmentRoot(folder);
        // handle the case that for some reason the convention is not met
        if (!destination.exists()) {
            if (!folder.exists()) {
                folder.create(false, true, null);
            }
            addNewSourcEntry(javaTargetProject, folder);
        }
        // handle the resources convention
        IFolder resTarget = targetProject.getFolder(getResourceManager().getResourcesFolder());
        // handle the case that for some reason the convention is not met
        if (!resTarget.exists()) {
            resTarget.create(false, true, null);
            addNewSourcEntry(javaTargetProject, resTarget);
        }
        // create the name space
        IPackageFragment newBase = destination.createPackageFragment(sourceProject.getName(), false, null);

        List<String> packagesList = new ArrayList<String>();
        // copy every packageFragment from every found Resource folder
        for (IPackageFragmentRoot root : roots) {
            System.out.print("Attempting to get files from this root folder:");
            System.out.println(root.getPath());
            List<IPackageFragment> packages = getPackagesFromRoot(root, "");
            System.out.println("Number of packages:" + packages.size());
            for (IPackageFragment packageFragment : packages) {
                System.out.println("DEBUG: handling package: " + packageFragment.getElementName());
                // prepare the packageFilterCache
                String packageName = getPackageBase(packageFragment.getElementName());
                if (!packagesList.contains(packageName)) {
                    packagesList.add(packageName);
                }
                // get the java sources
                ICompilationUnit[] units = packageFragment.getCompilationUnits();
                System.out.println("DEBUG: compilationunits found: " + units.length);
                // get the non java resources
                Object[] nonJava = packageFragment.getNonJavaResources();
                System.out.println("DEBUG: non java resources found: " + nonJava.length);
                List<IResource> files = new ArrayList<IResource>();
                for (Object object : nonJava) {
                    if (object instanceof IResource) {
                        files.add((IResource) object);
                    } else {
                        System.out.println("DEBUG: incompatible resource found: " + object.getClass());
                    }
                }
                // Create target packageStructure with new namespace in mind
                String renameTo = newBase.getElementName() + "." + packageFragment.getElementName();
                // contents of the default package will be inserted directly to
                // the new namespace
                if (packageFragment.isDefaultPackage()) {
                    renameTo = newBase.getElementName();
                }
                IPackageFragment destinationFragment = destination.createPackageFragment(renameTo, false, null);
                // Copy all the classes and resources!
                for (ICompilationUnit unit : units) {
                    unit.copy(destinationFragment, null, null, true, null);
                }
                // the non java resources
                if (files.size() > 0) {
                    getResourceManager().getWorkspace().copy(files.toArray(new IResource[files.size()]),
                        destinationFragment.getPath(), IResource.REPLACE | IResource.FORCE, null);
                }
            }
        }
        // copy remaining files
        genericCopy(sourceProject, targetProject, ignoredFolders, true);
        // update the classpaths by adding the copied libs
        updateLibaryEntries(javaTargetProject, libs, sourceProject.getName());
        // repair the imports at the targetProject
        repairImports(destination, sourceProject.getName(), packagesList);
    }

    /**
     * Repairs the import declarations. It relies on a cached package structure of the source project and uses them to
     * heuristically determine a package declaration that needs to be updated. Before any change is made it's binding is
     * resolved to make sure, that the package declaration will not changed to a broken state.
     * 
     * @param destination the main source root to inspect
     * @param sourceName the name of the source project which is also the namespace
     * @param packagesList the cached list of base packages
     * @throws CoreException is thrown when the AST parser or a java model change operation fails
     */
    private static void repairImports(final IPackageFragmentRoot destination, final String sourceName,
            final List<String> packagesList) throws CoreException {
        JavaCore.run(new IWorkspaceRunnable() {
            @SuppressWarnings("unchecked")
            public void run(IProgressMonitor monitor) throws CoreException {
                ASTParser parser = ASTParser.newParser(AST.JLS3);
                for (IPackageFragment packageFragment : getPackagesFromRoot(destination, sourceName)) {
                    for (ICompilationUnit unit : packageFragment.getCompilationUnits()) {
                        parser.setSource(unit);
                        // the AST compilation unit
                        CompilationUnit result = (CompilationUnit) parser.createAST(null);

                        List<ImportDeclaration> imports = result.imports();
                        for (ImportDeclaration iDec : imports) {
                            String currentName = iDec.getName().getFullyQualifiedName();
                            String currentBase = getPackageBase(currentName);
                            // match the import
                            if (packagesList.contains(currentBase)) {
                                // can the import be resolved?
                                if (iDec.resolveBinding() == null) {
                                    String renameTo = sourceName + "." + currentName;

                                    IImportDeclaration dec = unit.getImport(currentName);
                                    int flags = dec.getFlags();
                                    // FIXME due to eclipse bug rename is not
                                    // possible
                                    // see:
                                    // stackoverflow.com/questions/6671977/
                                    //how-to-redefine-an-import-using-eclipse-jdt-core
                                    // see:
                                    // https://bugs.eclipse.org/bugs/show_bug.cgi?id=351940
                                    // Still applicable for 3.7.2
                                    // try {
                                    // dec.rename(renameTo, true, null);
                                    // } catch(JavaModelException e) {
                                    // System.out.println(e.getMessage());
                                    // }
                                    unit.createImport(renameTo, dec, flags, null);
                                    dec.delete(false, null);
                                }
                            }
                        }
                    }
                }
            }
        }, null);
    }

    /**
     * Determines the base package Fragment of a package. Each package path is composed of path elements like this:
     * "org.eclipse.jdt.core" This method returns the base of the path "org".
     * 
     * @param packageName the package to inspect
     * @return the base of the package
     */
    private static String getPackageBase(String packageName) {
        int index = packageName.indexOf(".");
        if (index > 0) {
            packageName = packageName.substring(0, packageName.indexOf("."));
        }
        return packageName;
    }

    /**
     * Makes a list of IClasspathEntry of the chosen kind.
     * 
     * @param project the java project which classpath shall be analyzed
     * @param kind the kind e.g. IClasspathEntry.CPE.SOURCE
     * @return the list of classpathentries of the given kind
     * @throws JavaModelException unlikely resource exception thrown when the java project is not accesible
     */
    private static List<IClasspathEntry> getClasspathEntries(IJavaProject project, int kind) throws JavaModelException {
        IClasspathEntry[] classpath = project.getRawClasspath();
        List<IClasspathEntry> result = new ArrayList<IClasspathEntry>(classpath.length);
        for (IClasspathEntry entry : classpath) {
            if (entry.getEntryKind() == kind) {
                result.add(entry);
            }
        }
        return result;
    }

    /**
     * Returns all package fragments within a root source folder. If the namespace parameter is used, it will only
     * return packages from the namespace found in the root source folder provided.
     * 
     * @param source the root source folder
     * @param namespace the name space which may be "" but not null
     * @return a list of packages found at the source
     */
    private static List<IPackageFragment> getPackagesFromRoot(IPackageFragmentRoot source, String namespace) {
        List<IPackageFragment> packageFragmentList = new ArrayList<IPackageFragment>();
        boolean normalMode = namespace.length() == 0;
        try {
            IJavaElement[] children = source.getChildren();
            packageFragmentList = new ArrayList<IPackageFragment>(children.length);
            for (IJavaElement child : children) {
                if (child.getElementType() == IJavaElement.PACKAGE_FRAGMENT) {
                    if (normalMode) {
                        packageFragmentList.add((IPackageFragment) child);
                    } else {
                        if (child.getElementName().startsWith(namespace)) {
                            packageFragmentList.add((IPackageFragment) child);
                        }
                    }
                }
            }
        } catch (JavaModelException e) {
            e.printStackTrace();
        }
        return packageFragmentList;
    }

    /**
     * The classpath of the target project needs to be updated to reflect the copied libraries. The paths of each libary
     * can't just be copied, they need to be adapted for the new namespace.
     * 
     * @param target the target java project which classpath needs to be updated
     * @param libs the library classpathentries of the source java project
     */
    private void updateLibaryEntries(IJavaProject target, List<IClasspathEntry> libs, String namespace) {
        if (null != target) {
            String projectPath = target.getProject().getLocation().toOSString();
            System.out.println("DEBUG: Will add libraries now");
            System.out.println("DEBUG: projectpath: " + projectPath);
            List<IClasspathEntry> libsAdapted = new ArrayList<IClasspathEntry>(libs.size());
            for (IClasspathEntry lib : libs) {
                String libPath = lib.getPath().toOSString();
                System.out.println("DEBUG: LibPath is " + libPath);
                String libName = new File(libPath).getName();
                System.out.println("DEBUG: Library name is " + libName);
                // if the path is absolute, the workspace path needs to be cut
                // out
                String workspacePath = getResourceManager().getWorkspace().getRoot().getLocation().toOSString();
                if (libPath.contains(workspacePath)) {
                    libPath = libPath.substring(workspacePath.length());
                }
                // cut off the origin name and readd it as a namespace after the
                // base folder
                libPath = libPath.substring(namespace.length() + 1);
                // basefolder + namespace + remaining libpath
                StringTokenizer nizer = new StringTokenizer(libPath, "\\ /");
                String token = nizer.nextToken();
                System.out.println("DEBUG: TOKEN FOUND " + token);
                libPath = libPath.substring(token.length() + 1);
                String adaptedPath = projectPath + File.separatorChar + token + File.separatorChar + namespace
                        + libPath;
                System.out.println("DEBUG: adapted libpath: " + adaptedPath);
                libsAdapted.add(JavaCore.newLibraryEntry(new Path(adaptedPath), null, null));
            }
            setNewClassPathEntries(target, libsAdapted);
        }
    }
    
    /**
     * Determines the binary folders for the given project name. It requires a project with javanature enabled.
     * 
     * @param projectName the name of the java project
     * @return a list with binary folders or an empty list
     */
    public Set<String> getBinaryFolders(String projectName) {
        Set<String> result = new HashSet<String>();
        IProject project = getResourceManager().getProject(projectName);
        try {
            if (project.isNatureEnabled(JavaCore.NATURE_ID)) {
                IJavaProject javaProject = JavaCore.create(project);
                for (IClasspathEntry entry : getClasspathEntries(javaProject, IClasspathEntry.CPE_SOURCE)) {
                    IPath bin = entry.getOutputLocation();
                    // default outputpath("bin") is used
                    if (bin == null) {
                        result.add(javaProject.getOutputLocation().toFile().getName());
                    } else {
                        result.add(bin.toFile().getName());
                    }
                }
            }
        } catch (JavaModelException e) {
            e.printStackTrace();
        } catch (CoreException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Adds a new source entry to the classpath of the target java project.
     * 
     * @param target the java project
     * @param folder the folder that is added to the classpath
     */
    private static void addNewSourcEntry(IJavaProject target, IFolder folder) {
        List<IClasspathEntry> entryList = new ArrayList<IClasspathEntry>(1);
        entryList.add(JavaCore.newSourceEntry(folder.getFullPath()));
        setNewClassPathEntries(target, entryList);
    }

    /**
     * Updates the classpath of the target java project by adding the chosen entries to it. Adding the same
     * classpathentries multiple times will have no effect.
     * 
     * @param target the target java project which classpath needs to be updated
     * @param entries the classpathentries of the source java project
     */
    private static void setNewClassPathEntries(IJavaProject target, List<IClasspathEntry> entries) {
        try {
            IClasspathEntry[] oldEntries = target.getRawClasspath();
            IClasspathEntry[] newEntries = new IClasspathEntry[oldEntries.length + entries.size()];
            System.arraycopy(oldEntries, 0, newEntries, 0, oldEntries.length);
            for (int i = oldEntries.length; i < oldEntries.length + entries.size(); i++) {
                newEntries[i] = entries.get(i - oldEntries.length);
            }
            target.setRawClasspath(newEntries, null);
        } catch (JavaModelException e) {
            // Is thrown if the same classpath entries are added multiple times
            // this is the case when the same project is instantiated over and
            // over
            // silently fail, the user does not have to worry
        }
    }

    @Override
    public String getID() {
        return "de.uni_hildesheim.sse.instantiator.copy.java";
    }

    @Override
    public String getName() {
        return "Java copy";
    }

    @Override
    public boolean useNameSpace() {
        return true;
    }

}
