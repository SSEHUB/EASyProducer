package de.uni_hildesheim.sse.easy.ui.productline_editor.instantiator;

import java.io.File;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import de.uni_hildesheim.sse.easy.ui.productline_editor.AbstractEASyEditorPage;
import de.uni_hildesheim.sse.easy.ui.productline_editor.EditorConstants;
import de.uni_hildesheim.sse.easy_producer.instantiator.Transformator;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.FileInstantiator;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;

/**
 * Creates the editor page for linking files with a file instantiator.<br>
 * This page allows the user to:
 * <ul>
 * <li>Add and delete instantiator engines</li>
 * <li>See configured instantiator engines</li>
 * <li>Change the files bound to an instantiator if that instantiator had been created in this ProductLineProject</li>
 * <li>See informations about the instantiator that is currently shown</li>
 * <li>See the filetype an instantiator will handle, after clicking save, if there are multiple filetypes to be handled,
 * the type will be shown as "various"</li>
 * </ul>
 * <li>To check for files that might be instantiated by multiple instantiator engines</li>
 * 
 * @author gawenda
 * @author El-Sharkawy
 */
public class InstantiatorConfigPage extends AbstractEASyEditorPage {
    private Button addFileTypeButton;
    private ComboViewer addInstantiatorCombo;
    private Button deleteFileTypeButton;

    private ListViewer multipleList;
    private ListViewer instantiatorList;

    private Button undoButton;
    private Button multipleButton;
    private InstantiatorTreeViewer instantiatorViewer;

    private ComboViewer filter;

    private final Image addImg = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ADD);
    private final Image delImg = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_ETOOL_DELETE);
    private final Image undoImg = PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_UNDO);
    private final Image multipleImg = PlatformUI.getWorkbench().getSharedImages()
            .getImage(ISharedImages.IMG_ELCL_SYNCED);

    /**
     * Sole constructor for this class.
     * 
     * @param parent the parent control
     * @param plp The ProductLineProject which will be edited
     */
    public InstantiatorConfigPage(Composite parent, ProductLineProject plp) {
        super(plp, EditorConstants.INSTANTIATOR_PAGE, parent);

        createButtons();
        createSelectionBar();
        createContent();
    }

    /**
     * Creates the add and delete button.
     */
    private void createButtons() {
        // Create Composite, which holds the two buttons
        Composite headerButtonComposite = getToolkit().createComposite(getContentPane(), SWT.NONE);
        headerButtonComposite.setLayout(new GridLayout(4, false));

        // create Buttons
        getToolkit().createLabel(headerButtonComposite, "Choose an instantiator to add:", SWT.NONE);
        //new Label(headerButtonComposite, SWT.NONE).setText("Choose an instantiator to add:");

        addInstantiatorCombo = new ComboViewer(new Combo(headerButtonComposite, SWT.DROP_DOWN | SWT.READ_ONLY));
        addInstantiatorCombo.setContentProvider(new ArrayContentProvider());
        addInstantiatorCombo.setInput(Transformator.getAvailableInstantiators().toArray(new String[0]));

        addFileTypeButton = new Button(headerButtonComposite, SWT.NONE);
        addFileTypeButton.setText("Add Instantiator");
        addFileTypeButton.setImage(addImg);
        deleteFileTypeButton = new Button(headerButtonComposite, SWT.NONE);
        deleteFileTypeButton.setText("Remove Instantiator");
        deleteFileTypeButton.setImage(delImg);

        // Add Listeners
        addAddListener();
        addDeleteListener();
    }

    /**
     * The selection bar contains some labels, the save and dependency button.
     */
    private void createSelectionBar() {
        Composite comboComposite = getToolkit().createComposite(getContentPane(), SWT.NONE);
        comboComposite.setLayout(new GridLayout(3, false));

        getToolkit().createLabel(comboComposite, "Pick an instantiator to configure it's filetree", SWT.NONE);

        undoButton = new Button(comboComposite, SWT.NONE);
        undoButton.setText("Undo file selection");
        undoButton.setImage(undoImg);
        undoButton.setEnabled(false);

        multipleButton = new Button(comboComposite, SWT.NONE);
        multipleButton.setText("Calculate files that will be instantiated multiple times");
        multipleButton.setImage(multipleImg);

        addUndoListener();
        addMultipleListener();
    }

    /**
     * Creates the main content with the list of instantiators, a tree for a chosen instantiator, and a list of multiple
     * instantiated files, which is only shown, if the user decides to have them calculated.
     * 
     */
    private void createContent() {
        Composite instantiatorComposite = getToolkit().createComposite(getContentPane());
        //new Composite(getContentPane(), SWT.NONE);
        instantiatorComposite.setLayout(new GridLayout(2, false));

        Composite listAndCombo = getToolkit().createComposite(instantiatorComposite);
        GridLayout gl = new GridLayout(1, false);
        gl.marginHeight = 0;
        gl.marginWidth = 0;
        listAndCombo.setLayout(gl);
        
        List list = new List(listAndCombo, SWT.BORDER | SWT.SINGLE | SWT.H_SCROLL | SWT.V_SCROLL);
        GridData gdList = new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false);
        gdList.widthHint = 250;
        gdList.heightHint = 250;
        list.setLayoutData(gdList);
        instantiatorList = new ListViewer(list);
        instantiatorList.setContentProvider(new InstantiatorListContentProvider());
        instantiatorList.setLabelProvider(new InstantiatorListLabelProvider());
        // Initialize with inherited Instantiators (if any)
        instantiatorList.setInput(getProductLineProject().getInstantiatorController().getTransformators());

        getToolkit().createLabel(listAndCombo, "Filter files by extension", SWT.NONE);

        filter = new ComboViewer(new Combo(listAndCombo, SWT.DROP_DOWN | SWT.READ_ONLY));
        filter.setContentProvider(new ArrayContentProvider());
        Combo combo = filter.getCombo();
        GridData gdCombo = new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false);
        combo.setLayoutData(gdCombo);

        int style = SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER;
        style |= SWT.FULL_SELECTION;
        
        instantiatorViewer = new InstantiatorTreeViewer(instantiatorComposite, style,
            getProductLineProject().getProjectID());
        Tree tree = instantiatorViewer.getTree();
        GridData gdTree = new GridData(SWT.BEGINNING, SWT.FILL, true, false);
        gdTree.widthHint = 500;
        tree.setLayoutData(gdTree);

        List list2 = new List(listAndCombo, SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
        GridData gdList2 = new GridData(SWT.BEGINNING, SWT.BEGINNING, true, false);
        gdList2.widthHint = 250;
        gdList2.heightHint = 200;
        list2.setLayoutData(gdList2);
        multipleList = new ListViewer(list2);
        multipleList.setContentProvider(new ArrayContentProvider());
        multipleList.setLabelProvider(new LabelProvider());

        addInstantiatorListListener();
        addFiltenerListener();
    }

    /**
     * A listener for the list of instantiators. On user selection a file tree is generated based on the context of the
     * instantiator and files will be preselected based on the model data of the chosen instantiator.
     */
    private void addInstantiatorListListener() {
        instantiatorList.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                StructuredSelection selection = (StructuredSelection) event.getSelection();
                if (!selection.isEmpty()) {
                    FileInstantiator tmp = (FileInstantiator) selection.getFirstElement();
                    tmp.checkContext(getProductLineProject().getProjectID());
                    instantiatorViewer.setInput(tmp);
                    undoButton.setEnabled(true);

                    java.util.List<File> files = tmp.getFilesToInstantiate();
                    instantiatorViewer.setCheckedElements(files.toArray());
                    multipleList.setInput(tmp.inspect());

                    filter.setInput(instantiatorViewer.getFileTypes().toArray(new String[0]));
                }
            }
        });
    }

    /**
     * Creates a listener for the add button.
     */
    private void addAddListener() {
        addFileTypeButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                StructuredSelection selection = (StructuredSelection) addInstantiatorCombo.getSelection();
                if (!selection.isEmpty()) {
                    String engine = (String) selection.getFirstElement();
                    FileInstantiator n = getProductLineProject().getInstantiatorController().addFileTransformator(
                            getProductLineProject().getProjectID(), engine);
                    instantiatorViewer.setInput(n);
                    refresh();
                    instantiatorList.setSelection(new StructuredSelection(n), true);
                }
            }
        });
    }

    /**
     * Creates a listener for the filter combobox.
     */
    private void addFiltenerListener() {
        filter.addSelectionChangedListener(new ISelectionChangedListener() {
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                StructuredSelection selection = (StructuredSelection) filter.getSelection();
                if (!selection.isEmpty()) {
                    String type = (String) selection.getFirstElement();
                    instantiatorViewer.setFilter(type);
                    instantiatorViewer.setInput(instantiatorViewer.getInput());
                    instantiatorList.setSelection(new StructuredSelection(instantiatorViewer.getInput()), true);
                }
            }
        });
    }

    /**
     * Creates a listener for the delete button.
     */
    private void addDeleteListener() {
        deleteFileTypeButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent event) {
                IStructuredSelection selection = (IStructuredSelection) instantiatorList.getSelection();
                if (!selection.isEmpty()) {
                    FileInstantiator i = (FileInstantiator) selection.getFirstElement();
                    getProductLineProject().getInstantiatorController().deleteFileTypeTransformator(i);
                    refresh();
                    // Reset the Dataviews until User selects a new
                    instantiatorViewer.setInput(null);
                    undoButton.setEnabled(false);
                    multipleList.setInput(null);
                }
            }
        });
    }
    
    /**
     * Creates a listener for the save button. Changes made to the filetree won't be saved without using this button.
     */
    private void addUndoListener() {
        undoButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent evt) {
                IStructuredSelection selection = (IStructuredSelection) instantiatorList.getSelection();
                if (!selection.isEmpty()) {
                    FileInstantiator i = (FileInstantiator) selection.getFirstElement();
                    i.setFilesToInstantiateTemporary(i.getFilesToInstantiatePersistency());
                    java.util.List<File> files = i.getFilesToInstantiatePersistency();
                    instantiatorViewer.setCheckedElements(files.toArray());
                    // do not loose the selection
                    instantiatorList.setSelection(selection, true);
                    // restore the user expanded tree
                    instantiatorViewer.setExpandedElements(files.toArray());
                }
            }
        });
    }

    /**
     * Creates a listener for the multiple files calculation button.
     */
    private void addMultipleListener() {
        multipleButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent evt) {
                multipleList.setInput(getProductLineProject().getInstantiatorController()
                        .getListofMultipleInstantiatedFiles(getProductLineProject().getProjectName()));
            }
        });
    }

    @Override
    public void refresh() {
        instantiatorList.setInput(getProductLineProject().getInstantiatorController().getTransformators());
    }

    @Override
    public final String getPageText() {
        return EditorConstants.INSTANTIATOR_PAGE;
    }

    @Override
    protected void pageActivated() {
        refresh();
    }

    @Override
    public void propertyChanged(Object source, int propId) {
        // Not needed    
    }

    @Override
    public void close() {
        // No action needed
    }
}