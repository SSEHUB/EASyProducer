package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MenuEvent;
import org.eclipse.swt.events.MenuListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Tree;

import de.uni_hildesheim.sse.easy.ui.confModel.GUIConfiguration;
import de.uni_hildesheim.sse.easy.ui.confModel.GUIVariable;
import de.uni_hildesheim.sse.easy.ui.confModel.IGUIConfigChangeListener;
import de.uni_hildesheim.sse.easy.ui.contributions.Contributions;
import de.uni_hildesheim.sse.easy.ui.productline_editor.IEASyEditorPage;
import de.uni_hildesheim.sse.easy.ui.productline_editor.configuration.EditorContextMenuListener.Action;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IConfigurationChangeListener;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.values.Value;

/**
 * The table for editing the configuration, without surrounding buttons or other stuff.
 * @author El-Sharkawy
 *
 */
public class ConfigurationTableEditor extends TreeViewer implements IGUIConfigChangeListener, 
    IConfigurationChangeListener, IGUIConfigurationContainer {

    private Configuration config;
    private GUIConfiguration guiConfig;
    private IEASyEditorPage parentPage;
    private IUpdateListener listener;

    /**
     * A listener which is called when the editor performs (async) updates.
     * 
     * @author Holger Eichelberger
     */
    public interface IUpdateListener {

        /**
         * Called during an update.
         */
        public void updateTriggered();
    }
    
    /**
     * Sole constructor for this editor.
     * @param configuration The configuration which should be edited in this editor.
     * @param parent The {@link IEASyEditorPage} holding this table.
     */
    protected ConfigurationTableEditor(Configuration configuration, IEASyEditorPage parent) {
        super(parent.getContentPane(), SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL | SWT.FULL_SELECTION);
        parentPage = parent;
        setContentProvider(new ConfigurationContentProvider());
        guiConfig = new GUIConfiguration(configuration, this.getTree());
        guiConfig.register(this);
        createProductEditorTableColumns();
        createContextMenu();
        setInput(guiConfig);
        super.refresh();
        config = configuration;
        config.register(this);
    }
    
    /**
     * Changes the update listener.
     * 
     * @param listener the new update listener (may be <b>null</b>)
     */
    public void setUpdateListener(IUpdateListener listener) {
        this.listener = listener;
    }
    
    /**
     * Creates a label provider for a column. [customization]
     * 
     * @return the label provider instance (need to comply with {@link #getColumnWidths()} 
     *   and {@link #getColumnTitles()}
     */
    protected CellLabelProvider createColumnLabelProvider() {
        return new ConfigurationLabelProvider(getGuiConfig());
    }

    /**
     * Returns the titles of the columns. [customization]
     * 
     * @return the titles of the columns (need to comply with {@link #getColumnWidths()} 
     *   and {@link #createColumnLabelProvider()}
     */
    protected String[] getColumnTitles() {
        return new String[] {"Decision Name", "Current value", "+", "-", "Freeze", "Comment", "Errors"};
    }
    
    /**
     * Returns the widths of the columns. [customization]
     * 
     * @return the widths of the columns (need to comply with {@link #getColumnTitles()} 
     *   and {@link #createColumnLabelProvider()}
     */
    protected int[] getColumnWidths() {
        return new int[] {225, 225, 25, 25, 50, 225, 100};
    }
    
    /**
     * Method creates the columns for the product table.
     */
    private void createProductEditorTableColumns() {
        String[] titles = getColumnTitles();
        int[] bounds = getColumnWidths();

        for (int i = 0; i < titles.length; i++) {
            TreeViewerColumn column = new TreeViewerColumn(this, SWT.NONE);
            column.setLabelProvider(createColumnLabelProvider());

            column.getColumn().setText(titles[i]);
            column.getColumn().setWidth(bounds[i]);
            column.getColumn().setResizable(true);
            column.getColumn().setMoveable(true);
            if (1 == i) {
                column.setEditingSupport(new ConfigurationCellEditor(this, ColumnType.VALUE));
            }
            if (2 == i) {
                column.setEditingSupport(new ConfigurationCellEditor(this, ColumnType.EXTEND));
            }
            if (3 == i) {
                column.setEditingSupport(new ConfigurationCellEditor(this, ColumnType.REMOVE));
            }
            if (4 == i) {
                column.setEditingSupport(new ConfigurationCellEditor(this, ColumnType.FREEZE));
            }
        }
        Tree table = this.getTree();
        table.setHeaderVisible(true);
        table.setLinesVisible(true);

        GridData data = new GridData(SWT.FILL, SWT.FILL, true, true);
        /*
         * Show scroll bars of parent composite only if less then approx. 3 rows are shown in the table
         * Otherwise the scroll bars of the table are used.
         */
        data.heightHint = 60;
        table.setLayoutData(data);
    }
    
    /**
     * Creates a context menu inside the cells.
     * Part of the constructor.
     */
    private void createContextMenu() {
        final Menu menu = new Menu(getControl());
        menu.addMenuListener(new MenuListener() {
            
            @Override
            public void menuShown(MenuEvent evt) {
                // Clear (old) menu
                MenuItem[] items = menu.getItems();
                for (int i = items.length - 1; i >= 0; i--) {
                    items[i].dispose();
                }

                // (Re-) build menu (unfortunately there is no setVisible method) 
                IStructuredSelection selection = (IStructuredSelection) getSelection();
                GUIVariable var = (GUIVariable) selection.getFirstElement();
                if (Contributions.UIElement.ANNOTATIONS_VIEW.getEnabled() && var.isAnnotated()) {
                    final MenuItem annotationMenu = new MenuItem(menu, SWT.PUSH);
                    annotationMenu.setText("show Annotations");
                    annotationMenu.addSelectionListener(new EditorContextMenuListener(ConfigurationTableEditor.this,
                        Action.ANNOTATION_VIEW));
                }
                if (var.hasValue()) {
                    final MenuItem removeValues = new MenuItem(menu, SWT.PUSH);
                    removeValues.setText("remove value"); 
                    removeValues.addSelectionListener(new EditorContextMenuListener(ConfigurationTableEditor.this,
                        Action.REMOVE_VALUE));       
                }
                if (!var.hasValue() || !var.hasNullValue()) {
                    final MenuItem nullValues = new MenuItem(menu, SWT.PUSH);
                    nullValues.setText("set NULL");
                    nullValues.addSelectionListener(new EditorContextMenuListener(ConfigurationTableEditor.this,
                        Action.SET_NULL));
                }
            }
            
            @Override
            public void menuHidden(MenuEvent evt) {
                
            }
        });
        getTree().setMenu(menu);
    }
    
    @Override
    public void refresh() {
        execOnParent(new Runnable() {
            @Override
            public void run() {
                ConfigurationTableEditor.super.refresh();
            }
        }, false);
    }

    @Override
    public void changed(GUIConfiguration changedConfiguration) {
        parentPage.setDirty();
    }

    @Override
    public void itemChanged(Configuration config, IDecisionVariable changedVariable, Value oldValue) {
        // TODO SE: Check whether we need this
    }
    
    /**
     * Executes a runnable on the parent display.
     * 
     * @param runnable the runnable to be executed
     * @param async whether execution shall happen asynchronously or synchronously
     */
    private void execOnParent(Runnable runnable, boolean async) {
        if (!parentPage.isDisposed()) {
            Display parentDisplay = parentPage.getDisplay();
            if (null != parentDisplay) {
                if (async) {
                    parentDisplay.asyncExec(runnable);
                } else {
                    parentDisplay.syncExec(runnable);
                }
            }
        }
    }

    @Override
    public void configurationRefreshed(final Configuration config) {   
        
        execOnParent(new Runnable() {
            @Override
            public void run() {
                if (null != ConfigurationTableEditor.this.guiConfig) {
                    ConfigurationTableEditor.this.guiConfig.initMap();
                    ConfigurationTableEditor.this.refresh();
                    if (null != ConfigurationTableEditor.this.listener) {
                        ConfigurationTableEditor.this.listener.updateTriggered();
                    }
                }
            }
        }, true);
    }
    
    /**
     * On-close method for this table editor, release allocated ressources.
     */
    public void close() {
        config.unregister(this);
        guiConfig = null;
    }

    @Override
    public void imtemsChanged(GUIConfiguration changedConfiguration) {
        refresh();
    }
    
    /**
     * Returns the number of items.
     * 
     * @return the number of items
     */
    public int getItemCount() {
        return guiConfig.getItemCount();
    }
    
    @Override
    public GUIConfiguration getGuiConfig() {
        return guiConfig;
    }
    
    @Override
    public Configuration getConfig() {
        return config;
    }

    @Override
    public void stateChanged(Configuration config, IDecisionVariable changedVariable) {
//        // Dirty, please do not commit this
//        
//        execOnParent(new Runnable() {
//            @Override
//            public void run() {
//                refresh();
//            }
//        }, true);
    }
}
