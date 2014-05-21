package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import de.uni_hildesheim.sse.easy.ui.confModel.GUIConfiguration;
import de.uni_hildesheim.sse.easy.ui.confModel.GUIVariable;
import de.uni_hildesheim.sse.easy.ui.productline_editor.AbstractEASyEditorPage;
import de.uni_hildesheim.sse.easy.ui.productline_editor.AbstractHeaderMenu;
import de.uni_hildesheim.sse.easy.ui.productline_editor.configuration.ConfigurationTableEditor.IUpdateListener;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.ConfigurationException;
import de.uni_hildesheim.sse.model.confModel.IAssignmentState;
import de.uni_hildesheim.sse.model.confModel.IConfigurationChangeListener;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.IvmlDatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.ModelQuery;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.reasoning.core.reasoner.AttributeException;
import de.uni_hildesheim.sse.reasoning.core.reasoner.AttributeValues;
import de.uni_hildesheim.sse.reasoning.core.reasoner.ReasonerConfiguration;

/**
 * Editor for displaying and editing the temporary attribute settings to be passed configuration of the current project.
 * 
 * @author Holger Eichelberger
 */
public class AttributeValuesPage extends AbstractEASyEditorPage implements IConfigurationChangeListener,
    IUpdateListener {
    
    private ConfigurationTableEditor configEditor;
    private AttributeHeaderMenu headerMenu; //Should be moved in another editor in future
    private TemporaryAttributesConfiguration config;

    /**
     * Creates a new attribute values page.
     * 
     * @param plp The {@link ProductLineProject} edited in this editor page.
     * @param parent The parent, holding this editor page
     */
    public AttributeValuesPage(ProductLineProject plp, Composite parent) {
        super(plp, "Attribute Setting Editor", parent);
        headerMenu = new AttributeHeaderMenu(getContentPane(), plp, this);
        ReasonerConfiguration conf = plp.getReasonerConfig();
        AttributeValues values = conf.getAttributeValues();
        if (null == values) {
            values = new AttributeValues();
            conf.setAttributeValues(values);
        }
        config = new TemporaryAttributesConfiguration(plp.getProject(), values, getGroupSelection());
        configEditor = new AttributeTableEditor(config, this);
        configEditor.setUpdateListener(this);
    }
    
    /**
     * The header menu for attribute values.
     * 
     * @author Holger Eichelberger
     */
    private static class AttributeHeaderMenu extends AbstractHeaderMenu {
        // @SE: I defined this here in order to have as little as possible global changes. May be moved ;)

        private static final Image IMG_ADD = PlatformUI.getWorkbench().getSharedImages()
                .getImage(ISharedImages.IMG_OBJ_ADD);
        private static final Image IMG_REMOVE = PlatformUI.getWorkbench().getSharedImages()
                .getImage(ISharedImages.IMG_ETOOL_DELETE);
        private static final Image IMG_CLEAR = PlatformUI.getWorkbench().getSharedImages()
                .getImage(ISharedImages.IMG_ETOOL_CLEAR);

        private Button btnAddAttribute;
        private Button btnRemoveAttribute;
        private Button btnClearAttributes;
        private Button checkGroup;
        private ComboViewer comboAttributes;
        private AttributeValuesPage relatedEditor;
        
        
        /**
         * Sole constructor for this class.
         * @param parent The parent holding this menu.
         * @param plp The current edited {@link ProductLineProject}
         * @param relatedEditor The editor holding this menu, will be refreshed after some operations.
         */
        protected AttributeHeaderMenu(Composite parent, ProductLineProject plp, AttributeValuesPage relatedEditor) {
            super(parent, plp);
            this.relatedEditor = relatedEditor; 
            createButtons();            
        }
        
        /**
         * Sets the Layout for this Composite.
         */
        protected void setLayout() {
            GridLayout layout = new GridLayout();
            layout.numColumns = 4;
            layout.marginWidth = 0;
            layout.marginHeight = 0;
            setLayout(layout);
        }
        
        /**
         * Creates the buttons.
         */
        private void createButtons() {
            GridData data = new GridData();
            
            Composite comboComposite = new Composite(this, 0);
            comboComposite.setLayout(new FillLayout(SWT.VERTICAL));
            data.widthHint = 200;
            data.minimumWidth = 200;
            comboComposite.setLayoutData(data);
            
            comboAttributes = new ComboViewer(comboComposite, SWT.READ_ONLY);
            comboAttributes.setContentProvider(ArrayContentProvider.getInstance());
            
            checkGroup = new Button(comboComposite, SWT.CHECK);
            checkGroup.setText("Group by type and name");
            checkGroup.setSelection(true);
            createCheckGroupListener();

            comboAttributes.setLabelProvider(new LabelProvider() {
                
                public String getText(Object element) {
                    String result;
                    if (element instanceof Attribute) {
                        Attribute attr = (Attribute) element;
                        result = attr.getName();
                        if (!checkGroup.getSelection()) {
                            result += getQualifiedAppendix(attr);
                        }
                    } else {
                        result = super.getText(element);
                    }
                    return result;
                }
                
            });
            
            btnAddAttribute = new Button(this, SWT.PUSH);
            btnAddAttribute.setText("Add attribute value");
            btnAddAttribute.setImage(IMG_ADD);
            createAddAttributeListener();
            
            btnRemoveAttribute = new Button(this, SWT.PUSH);
            btnRemoveAttribute.setText("Remove attribute value");
            btnRemoveAttribute.setImage(IMG_REMOVE);
            createRemoveAttributeListener();

            btnClearAttributes = new Button(this, SWT.PUSH);
            btnClearAttributes.setText("Clear all values");
            btnClearAttributes.setImage(IMG_CLEAR);
            createClearAttributeListener();
            
            revalidateButtons();
        }

        /**
         * Creates and adds an <tt>SelectionListener</tt> to the checkGroup button.
         */
        private void createCheckGroupListener() {
            checkGroup.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent event) {
                    boolean doConversion = true;
                    if (checkGroup.getSelection()) {
                        if (relatedEditor.getDecisionCount() > 0) {
                            MessageBox mb = new MessageBox(getShell(), SWT.YES | SWT.NO);
                            mb.setText("Possible data loss");
                            mb.setMessage("Switching to group-based configuration may cause loss of individual " 
                                + "configuration. Continue?");
                            if (SWT.NO == mb.open()) {
                                doConversion = false;
                                checkGroup.setSelection(false);
                            }
                        }
                    }
                    if (doConversion) {
                        relatedEditor.convert(checkGroup.getSelection());
                        revalidateButtons();
                    }
                }
            });
        }
        
        /**
         * Creates the Listener for the Add button.
         */
        private void createAddAttributeListener() {
            btnAddAttribute.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent event) {
                    ISelection selection = comboAttributes.getSelection();
                    if (selection instanceof IStructuredSelection) {
                        Object selected = ((IStructuredSelection) selection).getFirstElement();
                        if (selected instanceof Attribute) {
                            relatedEditor.addAttribute((Attribute) selected);
                        }
                    }
                }
            });
        }
        
        /**
         * Creates the Listener for the Remove button.
         */
        private void createRemoveAttributeListener() {
            btnRemoveAttribute.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent event) {
                    relatedEditor.removeSelected();
                }
            });
        }
        
        /**
         * Creates the Listener for the Remove button.
         */
        private void createClearAttributeListener() {
            btnClearAttributes.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent event) {
                    relatedEditor.clear();
                }
            });
        }

        
        /**
         * {@inheritDoc}
         */
        @Override
        public void revalidateButtons() {
            Project project = getProductLineProject().getProject();
            java.util.List<Attribute> attributes = ModelQuery.getAllAttributes(project);
            if (checkGroup.getSelection()) {
                HashSet<String> known = new HashSet<String>();
                Iterator<Attribute> iter = attributes.iterator();
                while (iter.hasNext()) {
                    String key = getKey(iter.next());
                    if (known.contains(key)) {
                        iter.remove();
                    } else {
                        known.add(key);
                    }
                }
            }
            comboAttributes.setInput(attributes);
            if (attributes.size() > 0) {
                Combo combo = comboAttributes.getCombo();
                if (combo.getSelectionIndex() < 0) {
                    combo.select(0);
                }
            }
            btnAddAttribute.setEnabled(!attributes.isEmpty());
            boolean doEntriesExist = relatedEditor.getConfigurationEntriesSize() > 0;
            btnRemoveAttribute.setEnabled(doEntriesExist);
            btnClearAttributes.setEnabled(doEntriesExist);
        }
        
        /**
         * Returns the check group selection state.
         * 
         * @return the check group selection state
         */
        public boolean getCheckGroupSelection() {
            return checkGroup.getSelection();
        }
        
    }

    /**
     * Defines a specific assignment state for user-provided attribute values.
     * 
     * @author Holger Eichelberger
     */
    private enum AttributeAssignmentState implements IAssignmentState {

        /**
         * User-specified attribute values.
         */
        USER_ATTRIBUTE;
        
    }
    
    /**
     * Returns an internal key for retrieving duplicates.
     * 
     * @param attribute the attribute to return the key for
     * @return the key
     */
    public static String getKey(Attribute attribute) {
        return attribute.getName() + "_" + IvmlDatatypeVisitor.getQualifiedType(attribute.getType());
    }

    /**
     * Returns the display appendix for the qualified name.
     * 
     * @param attribute the attribute to return the appendix for
     * @return the appendix
     */
    public static String getQualifiedAppendix(Attribute attribute) {
        return " on " + attribute.getElement().getQualifiedName();                    
    }
    
    /**
     * Represents a temporary configuration for defining attribute values and acts
     * as a controller for the model-level modifications.
     * 
     * @author Holger Eichelberger
     */
    private class TemporaryAttributesConfiguration extends Configuration {
        
        private AttributeValues values;
        private boolean group;
        
        /**
         * Creates a new configuration for the given project. <br/>
         * Please take a look in <tt>VarModel#addProject(Project)</tt> for more information.
         * @param project The project, where this configuration belongs to.
         * This project should already be registered at the VarModel
         * @param values the attributes with values
         * @param group group the attributes
         */
        public TemporaryAttributesConfiguration(Project project, AttributeValues values, boolean group) {
            super(project);
            this.values = values;
            convert(group, true);
        }
        
        /**
         * Converts values to a group or non-group attribute values configuration.
         * Converting to a grouped configuration may imply data loss.
         * 
         * @param group convert to a group or non-group configuration
         * @param force the execution (initial call)
         * @return <code>true</code> if the conversion was done, <code>false</code> else
         */
        private boolean convert(boolean group, boolean force) {
            boolean result = false;
            if (force || this.group != group) {
                super.clear();
                HashMap<String, Attribute> done;
                if (group) {
                    done = new HashMap<String, Attribute>();
                } else {
                    done = null;
                }
                Iterator<Attribute> iter = values.getAttributes();
                while (iter.hasNext()) {
                    Attribute attribute = iter.next();
                    if (group) {
                        String key = getKey(attribute);
                        Attribute mapped = done.get(key);
                        if (null == mapped) {
                            addAttribute(attribute);
                            done.put(key, attribute);
                        } else {
                            values.setValues(attribute, mapped);
                        }
                    } else {
                        addAttribute(attribute);
                    }
                }                
                this.group = group;
                result = true;
            }
            return result;
        }

        /**
         * Adds the given attribute and its values to this configuration.
         * 
         * @param attribute the attribute to add
         */
        private void addAttribute(Attribute attribute) {
            int vSize = values.getAttributeValuesCount(attribute);
            for (int v = 0; vSize >= 0 && v < vSize; v++) {
                Value value = values.getAttributeValue(attribute, v);
                try {
                    addAttributeDecision(attribute, value);
                } catch (ConfigurationException e) {
                    // shall not happen as attribute values shall be consistent
                    e.printStackTrace();
                }
            }
        }

        /**
         * Converts values to a group or non-group attribute values configuration.
         * Converting to a grouped configuration may imply data loss.
         * 
         * @param group convert to a group or non-group configuration
         * @return <code>true</code> if the conversion was done, <code>false</code> else
         */
        public boolean convert(boolean group) {
            return convert(group, false);
        }
        
        /**
         * Returns whether two given attributes are in the same group, i.e. same (non-qualified) name and same type.
         * 
         * @param attr1 the first attribute
         * @param attr2 the same attribute
         * @return <code>true</code> if <code>attr1</code> and <code>attr2</code> are in the same group,
         *   <code>false</code> else
         */
        private boolean sameGroup(Attribute attr1, Attribute attr2) {
            // no qualified names here, abstract attributes
            return attr1.getName().equals(attr2.getName()) && attr1.getType().equals(attr2.getType());
        }
        
        /**
         * Adds an attribute decision to this configuration.
         * This method is a specific functionality for user interaction. 
         * Subclass this class and make it accessible if needed, otherwise it may break the value protection provided
         * by this class. 
         * 
         * @param attribute the attribute for which the decision shall be created
         * @param value the value of the attribute (may be <b>null</b>)
         * @throws ConfigurationException in case of type conflicts
         */
        public void addAttributeDecision(Attribute attribute, Value value) 
            throws ConfigurationException {
            super.addAttributeDecision(attribute, value, AttributeAssignmentState.USER_ATTRIBUTE);
            if (group) {
                java.util.List<Attribute> attributes = ModelQuery.getAllAttributes(getProject());
                for (int a = 0; a < attributes.size(); a++) {
                    Attribute attr = attributes.get(a);
                    if (sameGroup(attribute, attr)) {
                        try {
                            values.addValue(attr, value);
                        } catch (AttributeException e) {
                            // shall not happen
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        
        /**
         * {@inheritDoc}
         */
        public void clear() {
            super.clear();
            values.clear();
        }

        /**
         * {@inheritDoc}
         */
        public boolean removeDecision(IDecisionVariable variable) {
            boolean result = false;
            if (variable.getDeclaration().isAttribute()) {
                Attribute attribute = (Attribute) variable.getDeclaration();
                Value value = variable.getValue();
                values.removeValue(attribute, value);
                if (group) {
                    Iterator<Attribute> iter = values.getAttributes();
                    while (iter.hasNext()) {
                        Attribute attr = iter.next();
                        if (sameGroup(attribute, attr)) {
                            values.removeValue(attr, value);
                        }
                    }
                }
                result = super.removeDecision(variable);
            }            
            return result;
        }

        /**
         * In case that the configuration was refreshed.
         * 
         * @param config the new configuration
         */
        public void refreshed(Configuration config) {
            values.clear();
            Iterator<IDecisionVariable> iter = config.iterator();
            while (iter.hasNext()) {
                IDecisionVariable var = iter.next();
                if (var.getDeclaration().isAttribute()) {
                    Attribute attr = (Attribute) var.getDeclaration();
                    try {
                        values.addValue(attr, var.getValue());
                    } catch (AttributeException e) {
                        // shall not happen
                        e.printStackTrace();
                    }
                }
//                else {
//                    // shall not happen
//                }
            }
        }
        
        /**
         * To be called when a value changed.
         * 
         * @param changedVariable the changed variable carrying the new value
         * @param oldValue the old value
         */
        public void valueChanged(IDecisionVariable changedVariable, Value oldValue) {
            AbstractVariable var = changedVariable.getDeclaration();
            if (var.isAttribute()) {
                Attribute attribute = (Attribute) var;
                int count = values.getAttributeValuesCount((Attribute) var);
                if (count >= 0) {
                    boolean done = false;
                    for (int v = 0; !done && v < count; v++) {
                        Value val = values.getAttributeValue(attribute, v);
                        if ((null == val && val == oldValue) 
                            || (null != val && val.equals(oldValue))) {
                            done = true;
                            try {
                                values.setValue(attribute, changedVariable.getValue(), v);
                            } catch (AttributeException e) {
                                // shall not happen
                                e.printStackTrace();
                            }
                        }
                    }
                } 
//                else {
//                    // mismatch?
//                }
            }
        }
        
    }

    /**
     * Defines a customized table editor.
     * 
     * @author Holger Eichelberger
     */
    private class AttributeTableEditor extends ConfigurationTableEditor {
        
        /**
         * Sole constructor for this editor.
         * @param configuration The configuration which should be edited in this editor.
         * @param parent The {@link AbstractEASyEditorPage} holding this table.
         */
        AttributeTableEditor(Configuration configuration, AbstractEASyEditorPage parent) {
            super(configuration, parent);
        }

        /**
         * {@inheritDoc}
         */
        protected CellLabelProvider createColumnLabelProvider() {
            return new AttributeLabelProvider(getGuiConfig());
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void itemChanged(Configuration config, IDecisionVariable changedVariable, Value oldValue) {
            AttributeValuesPage.this.config.valueChanged(changedVariable, oldValue);
        }

    }
    
    /**
     * Concrete label provider for the attribute editor.
     * @author Holger Eichelberger
     *
     */
    private class AttributeLabelProvider extends ConfigurationLabelProvider {
        
        /**
         * Sole constructor for this class.
         * 
         * @param config The configuration, which should be edited.
         */
        AttributeLabelProvider(GUIConfiguration config) {
            super(config);
        }

        /**
         * {@inheritDoc}
         */
        public String getColumnText(Object element, int columnIndex) {
            String result = null;
            GUIVariable var = (GUIVariable) element;
            ColumnType columnType = columType(columnIndex);
            if (ColumnType.NAME == columnType) {
                result = var.getName();
                if (!AttributeValuesPage.this.getGroupSelection()) {
                    AbstractVariable dVar = var.getVariable().getDeclaration();
                    if (dVar.isAttribute()) {
                        Attribute attr = (Attribute) dVar;
                        result += getQualifiedAppendix(attr);                    
                    }
                } 
            } else {
                result = super.getColumnText(element, columnIndex);
            }
            return result;
        }

    }
    
   
    @Override
    public void refresh() {
        //TODO SE: check whether this is still needed or whether pageActivated() is sufficient.
        configEditor.refresh();
    }

    @Override
    public final String getPageText() {
        return "Attribute Setting Editor";
    }

    @Override
    protected void pageActivated() {
        refresh();
        headerMenu.revalidateButtons();       
    }

    @Override
    public void propertyChanged(Object source, int propId) {
        // TODO SE: check whether we need this
        // This is called when the page becomes dirty.
    }

    @Override
    public void close() {
        configEditor.close();
    }
    
    /**
     * Returns the number of configuration entries.
     * 
     * @return the number of configuration entries
     */
    public int getConfigurationEntriesSize() {
        int size = 0;
        if (null != configEditor) {
            size = configEditor.getItemCount();
        }
        return size;
    }
    
    /**
     * Adds an attribute to the configuration (via editing).
     * 
     * @param attribute the new attribute
     */
    void addAttribute(Attribute attribute) {
        try {
            config.addAttributeDecision(attribute, null);
            refreshConfigEditor();
        } catch (ConfigurationException e) {
            // shall not occur
            e.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void itemChanged(Configuration config, IDecisionVariable changedVariable, Value oldValue) {
        // however, this is not called anymore
        this.config.valueChanged(changedVariable, oldValue);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void configurationRefreshed(Configuration config) {
        this.config.refreshed(config);
    }

    /**
     * Clears all value assignments.
     */
    void clear() {
        config.clear();
        refreshConfigEditor();
    }
    
    /**
     * Remove the selected value assignment.
     */
    void removeSelected() {
        ISelection selection = configEditor.getSelection();
        if (selection instanceof IStructuredSelection) {
            Object selected = ((IStructuredSelection) selection).getFirstElement();
            if (selected instanceof GUIVariable) {
                GUIVariable guiVar = (GUIVariable) selected;
                if (config.removeDecision(guiVar.getVariable())) {
                    refreshConfigEditor();
                }
            }
        }
    }

    /**
     * Converts values to a group or non-group attribute values configuration.
     * Converting to a grouped configuration may imply data loss.
     * 
     * @param group convert to a group or non-group configuration
     */
    void convert(boolean group) {
        if (config.convert(group)) {
            refreshConfigEditor();
        }
    }

    /**
     * Refreshes the configuration editor.
     */
    private void refreshConfigEditor() {
        // hack... we call the listener method here
        configEditor.configurationRefreshed(config);    
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateTriggered() {
        headerMenu.revalidateButtons();
    }
    
    /**
     * Returns the number of configured decisions.
     * 
     * @return the number of decisions
     */
    public int getDecisionCount() {
        return config.getDecisionCount();
    }
    
    /**
     * Returns the group selection state.
     * 
     * @return the group selection state
     */
    public boolean getGroupSelection() {
        return headerMenu.getCheckGroupSelection();
    }

    @Override
    public void stateChanged(Configuration config, IDecisionVariable changedVariable) {
        // TODO SE: No idea whether we need functionality here.       
    } 
}
