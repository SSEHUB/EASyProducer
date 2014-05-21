package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.PatternSyntaxException;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import de.uni_hildesheim.sse.easy.ui.productline_editor.EasyProducerDialog;
import de.uni_hildesheim.sse.easy.ui.productline_editor.IOButton;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;
import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Enum;
import de.uni_hildesheim.sse.model.varModel.datatypes.EnumLiteral;
import de.uni_hildesheim.sse.model.varModel.filter.NamespaceFinder;
import de.uni_hildesheim.sse.model.varModel.values.Value;
import de.uni_hildesheim.sse.model.varModel.values.ValueDoesNotMatchTypeException;
import de.uni_hildesheim.sse.model.varModel.values.ValueFactory;

/**
 * Graphical Menu for filtering configuration items (variables) displayed inside the GUI.
 * Supported filters are:
 * <ul>
 * <li>{@link ConfigNameFilter}</li>
 * <li>{@link NamespaceFilter}</li>
 * <li>{@link AttributeFilter}</li>
 * </ul>
 * @author El-Sharkawy
 *
 */
public class FilterMenu extends AbstractConfigMenu {

    private GUIConfigurationFilter filters;
    private AttributesComboViewer attributesCombo;
    private ComboViewer attributeValueCombo;
    private Combo comboProjectSelection;
    private Combo comboAssignmentSelection;
    private IAttributeSelectionChangedListener attributeChangedListener;
    private IOButton chkNameFilterActive;
    private IOButton chkNamespaceFilterActive;
    private IOButton chkAttributeFilterActive;
    private IOButton chkAssignmentFilterActive;
    private Button btnAddFilter;
    
    /**
     * Defines a listener which is notified about the changed value of an attribute.
     * 
     * @author Holger Eichelberger
     */
    public interface IAttributeSelectionChangedListener {
        
        /**
         * Is called when the current value of <code>attribute</code> is being changed
         * to <code>value</code>.
         * 
         * @param attribute the attribute being changed
         * @param value the new value for <code>attribute</code>
         */
        public void selectionChanged(Attribute attribute, Value value);
    }
    
    /**
     * Sole constructor for this class, creates a new graphical filter menu, which can be (un-)folded.
     * @param parent The parent holding this menu.
     * @param plp The current edited {@link ProductLineProject}
     */
    public FilterMenu(Composite parent, ProductLineProject plp) {
        super(parent, plp);
        FillLayout layout = new FillLayout();
        layout.type = SWT.VERTICAL;
        setLayout(layout);
        filters = new GUIConfigurationFilter();
        createNameFilter();
        createNamespaceFilter();
        createAttributeFilter();
        createAssignmentStateFilter();     
    }

    /**
     * Defines the listener which reacts on changed attributes.
     * 
     * @param attributeChangedListener the listener which reacts on changed attributes
     */
    public void setAttributeChangedListener(IAttributeSelectionChangedListener attributeChangedListener) {
        this.attributeChangedListener = attributeChangedListener;
    }
    
    /**
     * Created GUI elements for filtering the configuration for variables where a certain
     * attribute value was set.
     */
    private void createAttributeFilter() {
        Composite pnlAttributeFilter = new Composite(this, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 4;
        pnlAttributeFilter.setLayout(layout);
        chkAttributeFilterActive = new IOButton(pnlAttributeFilter, "Filter variable by attribute:");   
        attributesCombo = new AttributesComboViewer(pnlAttributeFilter, true);
        attributesCombo.populate(getProductLineProject().getProject());
        Label labelValue = new Label(pnlAttributeFilter, SWT.NONE);
        labelValue.setText("Value:");
        attributeValueCombo = new ComboViewer(pnlAttributeFilter, 0);
        attributeValueCombo.setContentProvider(ArrayContentProvider.getInstance());
        createAttributeComboListeners();
    }

    /**
     * Creates the listeners for the two combo boxes of the attribute value filter selection.
     */
    private void createAttributeComboListeners() {
        attributesCombo.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                notifyAttributeChangedListener();
                Attribute attr = attributesCombo.getSelectedAttribute();
                if (null != attr && !attr.getName().equals("[all]")) {
                    if (attr.getType().isAssignableFrom(Enum.TYPE)) {
                        Enum e = (Enum) attr.getType();
                        List<EnumLiteral> literals = new ArrayList<EnumLiteral>();
                        for (int l = 0; l < e.getLiteralCount(); l++) {
                            literals.add(e.getLiteral(l));
                        }
                        attributeValueCombo.setInput(literals);
                        attributeValueCombo.getCombo().select(Math.max(0, literals.size()));
                    } else {
                        attributeValueCombo.setInput(new Object[0]);
                    }
                } else if (attr.getName().equals("[all]")) {
                    filters.setAttributeFilter(null);
                    chkAttributeFilterActive.setActivated(false);
                    setFilter(filters);
                }
            }
        });
        
        attributeValueCombo.addSelectionChangedListener(new ISelectionChangedListener() {
            
            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                Object selectedValue = selection.getFirstElement();
                Attribute attr = attributesCombo.getSelectedAttribute();
                AttributeFilter filter = null;
                if (null != selectedValue && null != attr) {
                    Value value;
                    try {
                        value = ValueFactory.createValue(attr.getType(), selectedValue);
                        filter = new AttributeFilter();
                        filter.add(attr, value);
                    } catch (ValueDoesNotMatchTypeException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                chkAttributeFilterActive.setActivated(null != filter);
                filters.setAttributeFilter(filter);
                setFilter(filters);
            }
        });
    }
    
    /**
     * Notifies the attribute changed listener in case that the selection changed.
     */
    private void notifyAttributeChangedListener() {
        if (null != attributeChangedListener) {
            Attribute attr = attributesCombo.getSelectedAttribute();
            Value value = null;
            if (null != attr && AttributesComboViewer.ALL != attr) {
                try {
                    value = ValueFactory.createValue(attr.getType(), attributeValueCombo.getCombo().getText());
                } catch (ValueDoesNotMatchTypeException e1) {
                }
            }
            attributeChangedListener.selectionChanged(attr, value);
        }
    }

    /**
     * Created GUI elements for filtering the configuration for variables having a certain variable name.
     */
    private void createNameFilter() {
        Composite pnlNameFilter = new Composite(this, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 3;
        layout.verticalSpacing = SWT.FILL;
        pnlNameFilter.setLayout(layout);
        chkNameFilterActive = new IOButton(pnlNameFilter, "Filter variable by name:");
        final Text txtNameFilter = new Text(pnlNameFilter, SWT.BORDER);
        btnAddFilter = new Button(pnlNameFilter, SWT.PUSH);
        btnAddFilter.setText("Add Filter");        
        GridData data = new GridData();
        data.widthHint = 95;
        btnAddFilter.setLayoutData(data);        
        
        txtNameFilter.addKeyListener(new KeyListener() {

            @Override
            public void keyReleased(KeyEvent evt) {
                // TODO Auto-generated method stub

            }

            @Override
            public void keyPressed(KeyEvent evt) {
                if (evt.keyCode == 13) {
                    setNameFilter(txtNameFilter);
                }
            }
        });
        
        btnAddFilter.addSelectionListener(new SelectionListener() {
            
            @Override
            public void widgetSelected(SelectionEvent evt) {
                if ("Remove Filter".equals(btnAddFilter.getText())) {
                    txtNameFilter.setText("");
                }
                setNameFilter(txtNameFilter);            
            }
            
            @Override
            public void widgetDefaultSelected(SelectionEvent evt) {
            }
        });
    }

    /**
     * Sets the variable name filter.
     * @param txtNameFilter The text field of the namefilter.
     */
    private void setNameFilter(final Text txtNameFilter) {
        String name = txtNameFilter.getText();
        ConfigNameFilter namefilter = null;
        if (null != name && !name.isEmpty()) {
            try {
                namefilter = new ConfigNameFilter(name);
            } catch (PatternSyntaxException exc) {
                EasyProducerDialog.showErrorDialog("Not supported filter pattern:\n" + exc.getLocalizedMessage());
            }
        }
        if (null != namefilter) {
            btnAddFilter.setText("Remove Filter");
        } else {
            btnAddFilter.setText("Add Filter");
        }
        chkNameFilterActive.setActivated(null != namefilter);
        filters.setNameFilter(namefilter);
        setFilter(filters);
    }

    /**
     * Created GUI elements for filtering the configuration for variables having a specific assignment state.
     */
    private void createAssignmentStateFilter() {
        Composite pnlAssignmentFilter = new Composite(this, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        pnlAssignmentFilter.setLayout(layout);
        chkAssignmentFilterActive = new IOButton(pnlAssignmentFilter, "Show variables in state:");
        comboAssignmentSelection = new Combo(pnlAssignmentFilter, SWT.NONE);
        // List possible states
        String[] possibleStates = {"[all]", "undefined", "assigned", "derived", "frozen"};
        comboAssignmentSelection.setItems(possibleStates);
        comboAssignmentSelection.addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent evt) {
                AssignmentStateFilter statefilter = null;
                switch (comboAssignmentSelection.getSelectionIndex()) {
                case 1:
                    statefilter = new AssignmentStateFilter(AssignmentState.UNDEFINED);
                    break;
                case 2:
                    statefilter = new AssignmentStateFilter(AssignmentState.ASSIGNED);
                    break;
                case 3:
                    statefilter = new AssignmentStateFilter(AssignmentState.DERIVED);
                    break;
                case 4:
                    statefilter = new AssignmentStateFilter(AssignmentState.FROZEN);
                    break;
                default:
                    //no further action needed
                    break;
                        
                }
                chkAssignmentFilterActive.setActivated(null != statefilter);
                filters.setAssignmentStateFilter(statefilter);
                setFilter(filters);
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent evt) {
                // Not needed
            }
        });
    }
    
    /**
     * Created GUI elements for filtering the configuration for variables created in a specific project.
     */
    private void createNamespaceFilter() {
        Composite pnlNamespaceFilter = new Composite(this, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        pnlNamespaceFilter.setLayout(layout);
        chkNamespaceFilterActive = new IOButton(pnlNamespaceFilter, "Show only variables of project:");
        comboProjectSelection = new Combo(pnlNamespaceFilter, SWT.NONE);
        NamespaceFinder finder = new NamespaceFinder(getProductLineProject().getProject());
        // Sort namespaces
        List<String> namespaces = finder.getNamespaces();
        Collections.sort(namespaces);
        // Needed for removing the selection (should not be a valid IVML identifier)
        namespaces.add(0, "[all]");
        comboProjectSelection.setItems(namespaces.toArray(new String[namespaces.size()]));
        comboProjectSelection.addSelectionListener(new SelectionListener() {
            
            @Override
            public void widgetSelected(SelectionEvent evt) {
                String name = comboProjectSelection.getText();
                NamespaceFilter namefilter = null;
                if (null != name && !name.equals("[all]")) {
                    namefilter = new NamespaceFilter(name);                        
                }
                chkNamespaceFilterActive.setActivated(null != namefilter);
                filters.setNamespaceFilter(namefilter);
                setFilter(filters);
            }
            
            @Override
            public void widgetDefaultSelected(SelectionEvent evt) {
                // Not needed
            }
        });
    }

    @Override
    public void revalidateButtons() {
        Display.getDefault().asyncExec(new Runnable() {
            
            @Override
            public void run() {
                if (null != attributesCombo) {
                    Project project = getProductLineProject().getProject();
                    attributesCombo.populate(project);
                }
            }
        });
        
    }
}
