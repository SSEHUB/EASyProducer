package de.uni_hildesheim.sse.easy.ui.productline_editor;
//package de.uni_hildesheim.sse.easy_producer.ui.ide.productline_editor;
//
//import java.util.UUID;
//
//import org.eclipse.swt.SWT;
//import org.eclipse.swt.custom.ScrolledComposite;
//import org.eclipse.swt.layout.GridLayout;
//import org.eclipse.swt.widgets.Composite;
//import org.eclipse.swt.widgets.Event;
//import org.eclipse.swt.widgets.ExpandBar;
//import org.eclipse.swt.widgets.ExpandItem;
//import org.eclipse.swt.widgets.Listener;
//import org.eclipse.swt.widgets.TabFolder;
//import org.eclipse.swt.widgets.TabItem;
//
//import de.uni_hildesheim.sse.easy_producer.ui.ide.productline_editor.decision.DecisionEditor;
//import de.uni_hildesheim.sse.easy_producer.ui.ide.productline_editor.dependency.DependencyEditor;
//import de.uni_hildesheim.sse.easy_producer.ui.ide.productline_editor.dependency_relevancy.RelevancyEditor;
//import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
//import de.uni_hildesheim.sse.easy_producer.model.SPLsManager;
//
///**
// * One editor page for the configuration of a ProductLineProject.<br>
// * This page allows the user to:
// * <ul>
// * <li>Create new Decisions</li>
// * <li>Rename Decisions</li>
// * <li>Delete Decisions</li>
// * <li>Configure Decision types</li>
// * <li>Derive new Product Nodes</li>
// * <li>Add Predecessors to this Project</li>
// * <li>Pull configuration</li>
// * <li>Create new Dependency rules</li>
// * <li>Rename Dependency rules</li>
// * <li>Delete Dependency rules</li>
// * <li>Configure Dependency rules</li>
// * <li>Create Decision Groups</li>
// * <li>Delete Decision Groups</li>
// * <li>Configure Decision Groups</li>
// * </ul>
// * 
// * @author EL-Sharkawy
// * @author Kapeluch
// * @see DecisionEditor
// * @see DependencyEditor
// * @see DecisionGroupEditor
// * 
// */
//class ProductlineConfigurationPage extends ScrolledComposite {
//    private ProductLineProject plp;
//
//    private ExpandBar bar;
//    private TabFolder tabFolder;
//    private DecisionEditor decisionEditor;
//    private DependencyEditor dependencyEditor;
//    private RelevancyEditor relevancyEditor;
//    private ProductLineConfigurationEditor plce;
//    private Composite mainBarComposite;
//    private Composite mainExpandBarComposite;
//    private UUID projectID;
//
//    /**
//     * Sole constructor for this class.
//     * 
//     * @param plce The parent control
//     * @param currentPTN The ProductLineProject which will be edited
//     */
//    ProductlineConfigurationPage(ProductLineConfigurationEditor plce, UUID projectID) {
//        super(plce.getContainer(), SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
//        plp = SPLsManager.INSTANCE.getPLP(projectID);
//        this.plce = plce;
//        this.projectID = projectID;
//        createLayout();
//
//        // Editors
//        createDecisionEditor();
//        createDependencyEditor();
//
//        tabFolder.addListener(SWT.Selection, new Listener() {
//
//            public void handleEvent(Event event) {
//
//                relevancyEditor.refreshData();
//                dependencyEditor.refreshData();
//            }
//
//        });
//
//        ExpandItem item0 = new ExpandItem(bar, SWT.NONE, 0);
//        item0.setText("Product Line Editor");
//        item0.setControl(mainExpandBarComposite);
//        item0.setExpanded(true);
//        item0.setHeight(700);
//
//        refresh();
//        refreshData();
//    }
//
//    /**
//     * Creates the Layout for this Composite.
//     */
//    private void createLayout() {
//
//        bar = new ExpandBar(this, SWT.NONE);
//
//        // setting size and content of scroll bar
//        setContent(bar);
//        setExpandHorizontal(true);
//        setExpandVertical(true);
//        setMinSize(900, 735);
//
//        mainExpandBarComposite = new Composite(bar, SWT.NONE);
//        GridLayout mainExpandBarCompositeLayout = new GridLayout();
//        mainExpandBarComposite.setLayout(mainExpandBarCompositeLayout);
//        mainExpandBarCompositeLayout.numColumns = 1;
//
//        tabFolder = new TabFolder(mainExpandBarComposite, SWT.NONE);
//
//        // setting size and content of scroll bar
//
//        mainBarComposite = new Composite(tabFolder, SWT.NONE);
//        GridLayout layout = new GridLayout();
//        mainBarComposite.setLayout(layout);
//        layout.numColumns = 1;
//
//    }
//
//    /**
//     * This method creates the DecisionEditor
//     * 
//     * @see DecisionEditor
//     */
//    private void createDecisionEditor() {
//
//        Composite composite = new Composite(tabFolder, SWT.NONE);
//        GridLayout layout = new GridLayout();
//        layout.numColumns = 1;
//        composite.setLayout(layout);
//
//        decisionEditor = new DecisionEditor(composite, plp.getProjectID(), plce);
//
//        TabItem tab = new TabItem(tabFolder, SWT.NONE);
//        tab.setText("Product Line Decision Editor");
//        tab.setControl(composite);
//    }
//
//    /**
//     * This method creates the DependencyEditor
//     * 
//     * @see DependencyEditor
//     */
//    private void createDependencyEditor() {
//        Composite composite = new Composite(tabFolder, SWT.NONE);
//        GridLayout layout = new GridLayout();
//        layout.numColumns = 1;
//        composite.setLayout(layout);
//
//        dependencyEditor = new DependencyEditor(composite, projectID, plce);
//        relevancyEditor = new RelevancyEditor(composite, projectID, plce);
//
//        TabItem tab = new TabItem(tabFolder, SWT.NONE);
//        tab.setText("Dependency Editor");
//        tab.setControl(composite);
//    }
//
//    /**
//     * Refreshes the data inside the two editors.
//     */
//    private void refresh() {
//        decisionEditor.refresh();
//        dependencyEditor.refresh();
//        relevancyEditor.refresh();
//    }
//
//    /**
//     * Refreshes Decisionlist and Dependencylist (data model).<br>
//     * This is necessarily after some references changed during clone operations. For example, this occur during the
//     * pull operation.
//     */
//    void refreshData() {
//        decisionEditor.refreshData();
//        dependencyEditor.refreshData();
//        relevancyEditor.refreshData();
//    }
//}