package de.uni_hildesheim.sse.easy.ui.productline_editor.instantiator;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.FileInstantiator;

/**
 * Content provider for a single instantiator model. This provider handles a file tree. The root file is determined
 * depending on the context of the instantiator.
 * 
 * @author gawenda
 * 
 */
class InstantiatorTreeContentProvider implements ITreeContentProvider {

    /**
     * Variation Point. Filters the view of an single instantiator. The files directly located at the root folder of a
     * project are not considered for migration and instantiation and therefore they might as well just not be
     * displayed. They are still found at the package explorer of course. Reducing the view to increse the overview over
     * the actual selectable files for instantiation is the goal of this setting. True: Only folders are displayed
     * within the root of a project. False: All files and folders are displayed.
     */
    private static final boolean FILTER_ROOT = true;

    /**
     * Constant for the the selection "unfiltered".
     */
    private static final String UNFILTERED = "unfiltered";

    /**
     * The chosen model is stored here to determine later whether the content should be editable by user.
     */
    private FileInstantiator instantiator;

    /**
     * Ignored files and folders. No child elements will be shown for them.
     */
    private List<String> ignored;

    /**
     * The files(optional) and folders within the root of the given project for the instantiator. Also depending on the
     * current context.
     */
    private File[] roots;

    /**
     * The user selected file filter. Default is "unfiltered";
     */
    private String filter = UNFILTERED;

    /**
     * Constructor for the provider. Solely used to provide a list of ignored files and folders
     * 
     * @param ignored the list of files and folders to be ignored
     */
    InstantiatorTreeContentProvider(List<String> ignored) {
        this.ignored = ignored;
    }

    @Override
    public Object[] getElements(Object inputElement) {
        Object[] result = null;
        // assuming it is an instantiator, like it should be
        if (inputElement instanceof FileInstantiator) {
            instantiator = (FileInstantiator) inputElement;
            File file = new File(instantiator.getOperationalPath()); // Project
                                                                     // root
            roots = file.listFiles(); // Files and folders in project root
            // no valid operational path if null is returned
            if (roots != null) {
                result = roots;
            } else {
                result = new File(instantiator.getCurrentPath()).listFiles();
            }
            // filter out the files
            if (FILTER_ROOT) {
                roots = filterRoot(roots);
            }
        }
        return result;
    }

    /**
     * This method filters all files in the root folder which won't be used for project migration and instantiation
     * anyways. This avoids user confusion and helps to maintain a better overview.
     * 
     * @param roots the files and folders within the project root
     * @return only the folders within the project root
     */
    private File[] filterRoot(File[] roots) {
        List<File> onlyFolders = new ArrayList<File>(roots.length);
        for (File toCheck : roots) {
            if (toCheck.isDirectory()) {
                onlyFolders.add(toCheck);
            }
        }
        return onlyFolders.toArray(new File[onlyFolders.size()]);
    }

    @Override
    public Object[] getChildren(Object parentElement) {
        Object[] result = null;
        if (parentElement != null) {
            File toInspect = (File) parentElement;
            result = applyFilter(toInspect.listFiles());
        }
        return result;
        // return parentElement == null ? null : ((File)
        // parentElement).listFiles();
    }

    @Override
    public Object getParent(Object element) {
        return element == null ? null : ((File) element).getParentFile();
    }

    @Override
    public boolean hasChildren(Object element) {
        boolean hasChildren = true;
        // filter the ignored folders
        if (ignored.contains(((File) element).getName())) {
            hasChildren = false;
        }
        
        if (hasChildren) {
            // Get the children
            Object[] obj = getChildren(element);
    
            // Return whether the parent has children
            hasChildren = obj == null ? false : obj.length > 0;
        }
        
        return hasChildren;
    }

    @Override
    public void dispose() {
        // Nothing to dispose
    }

    @Override
    public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
        // Nothing to change
    }

    /**
     * Returns whether the content is editable. This is true, if the instantiator was defined in the same project.
     * 
     * @return whether the content is editable
     */
    public boolean isContentEditAble() {
        return instantiator.getInheritanceChain().size() == 1;
    }

    /**
     * Calculates the filetypes within this project all filetypes will be returnes as a HashSet containing the distinct
     * extensions.
     * 
     * @return the extensions
     */
    public HashSet<String> getFileTypes() {
        List<File> files = new ArrayList<File>();
        Stack<File> dirs = new Stack<File>();
        for (File file : roots) {
            // Only folders, regardless whether the filter(FILTER_ROOT) is set
            // or not
            if (file.isDirectory() && !ignored.contains(file.getName())) {
                dirs.push(file);
            }
        }
        while (dirs.size() > 0) {
            for (File file : dirs.pop().listFiles()) {
                if (file.isDirectory()) {
                    dirs.push(file);
                }
                files.add(file);
            }
        }
        HashSet<String> set = new HashSet<String>(files.size());
        // add the "unfiltered" per default
        set.add(UNFILTERED);
        for (File file : files) {
            String fileType = getFileType(file);
            //Only add file extension and not folders.
            if (null != fileType) {
                set.add(fileType);
            }
        }
        return set;
    }

    /**
     * Determines the file extension for a single given file.
     * 
     * @param file The file for which the file type shall be determined.
     * @return The file type of the given file or <tt>null</tt> if the given file is a directory.
     */
    private String getFileType(File file) {
        String result = null;
        String path = file.getPath();
        //Consider only files
        if (!file.isDirectory()) {
            int index = path.lastIndexOf('.');
            if (index == -1) {
                // File without extension
                result = "empty Extension";
            } else {
                result = path.substring(index + 1);
            }
        }
        return result;
    }

    /**
     * Filters a given list of files based on the filter setting.
     * 
     * @param files the given files
     * @return a filtered list
     */
    private File[] applyFilter(File[] files) {
        
        if (filter.equals(UNFILTERED) || files == null) {
            return files;
        }
        List<File> result = new ArrayList<File>(files.length);
        for (File file : files) {
            if (file.isDirectory()) {
                result.add(file);
                // only add files if they do match the filter
            } else if (matchesFileType(file)) {
                result.add(file);
            }
        }
        return result.toArray(new File[result.size()]);
    }

    /**
     * Checks whether a file is filtered and may not be displayed.
     * 
     * @param file the file to check
     * @return true if the file extension matches the selected filter
     */
    private boolean matchesFileType(File file) {
        return getFileType(file).equals(filter);
    }

    /**
     * Sets a file type filter.
     * @param filter The file extension which shall be used as filter for files.
     */
    public void setFilter(String filter) {
        this.filter = filter;
    }
}
