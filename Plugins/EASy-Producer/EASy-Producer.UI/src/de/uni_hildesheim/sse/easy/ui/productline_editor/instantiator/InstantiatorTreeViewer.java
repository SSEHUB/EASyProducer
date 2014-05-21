package de.uni_hildesheim.sse.easy.ui.productline_editor.instantiator;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ContainerCheckedTreeViewer;

import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.SPLsManager;
import de.uni_hildesheim.sse.easy_producer.core.persistence.standard.PersistenceConstants;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.FileInstantiator;

/**
 * A tree viewer for an instantiator model. It does not only show the file tree but also computes checked files.
 * 
 * @author gawenda
 */
class InstantiatorTreeViewer extends ContainerCheckedTreeViewer {

    /**
     * Contains a list of entries which may not be selected for instantiation.
     */
    private List<String> ignored;

    /**
     * The context project for this viewer.
     */
    private PLPInfo plp;

    /**
     * Constructor for the tree viewer. It adds a listener and set's content and label providers.
     * 
     * @param parent parent composite
     * @param style style settings
     * @param projectID the ID of the project which shall be edited here.
     */
    InstantiatorTreeViewer(Composite parent, int style, String projectID) {
        super(parent, style);
        this.plp = SPLsManager.INSTANCE.getPLP(projectID);
        ignored = new ArrayList<String>();
        ignored.add(PersistenceConstants.CONFIG_FILE);
        //TODO SE: Method moved to java copy plugin. Check whether we do not need this filter option here.
        //ignored.addAll(ResourcesMgmt.getBinaryFolders(plp.getProjectName()));
        addCheckStateListener(new MyListener());
        setContentProvider(new InstantiatorTreeContentProvider(ignored));
        setLabelProvider(new InstantiatorTreeLabelProvider());
    }

    /**
     * Creates a listener that handles CheckStateChangedEvent events. If a folder is selected all the contained files
     * are automatically selected. If an ignored file is selected the user selection is undone immediately.
     */
    private class MyListener implements ICheckStateListener {
        @Override
        public void checkStateChanged(CheckStateChangedEvent event) {
            InstantiatorTreeContentProvider contentProvider = (InstantiatorTreeContentProvider) getContentProvider();
            File element = (File) event.getElement();
            String name = element.getName();
            boolean validchange = true;
            if (contentProvider.isContentEditAble() && !ignored.contains(name) && !name.startsWith(".")) {
                // If the item is checked...
                if (event.getChecked()) {
                    // ...check all its children
                    setSubtreeChecked(element, true);
                } else {
                    // ... or uncheck them
                    setSubtreeChecked(element, false);
                }
            } else {
                validchange = false;
                // User may not change anything
                if (event.getChecked()) {
                    setChecked(element, false);
                } else {
                    setChecked(event.getElement(), true);
                }
            }
            if (validchange) {
                // temporary save the model data
                FileInstantiator model = (FileInstantiator) getInput();
                plp.getInstantiatorController().changeFI(model, getCheckedFiles());
            }
        }

    }

    /**
     * Checks all the checked elements and sorts out the folders as only their contents can be used for instantiation.
     * 
     * @return the checked files.
     */
    public List<File> getCheckedFiles() {
        Object[] tmp = getCheckedElements();
        File[] checkedElements = Arrays.copyOf(tmp, tmp.length, File[].class);
        List<File> result = new ArrayList<File>(checkedElements.length);
        // Sort out folders
        for (File file : checkedElements) {
            if (file.isFile()) {
                result.add(file);
            }
        }
        return result;
    }

    /**
     * Calculates and returns all filetypes found in the current context of the instanitator. It does ignore the files
     * directly located at the root folder of the project.
     * 
     * @return the distinct file extensions
     */
    public HashSet<String> getFileTypes() {
        InstantiatorTreeContentProvider contentProvider = (InstantiatorTreeContentProvider) getContentProvider();
        return contentProvider.getFileTypes();
    }

    /**
     * Delegates the filter setting to the underlying content provider.
     * 
     * @param fileType the file type to filter
     */
    public void setFilter(String fileType) {
        InstantiatorTreeContentProvider contentProvider = (InstantiatorTreeContentProvider) getContentProvider();
        contentProvider.setFilter(fileType);
    }
}
