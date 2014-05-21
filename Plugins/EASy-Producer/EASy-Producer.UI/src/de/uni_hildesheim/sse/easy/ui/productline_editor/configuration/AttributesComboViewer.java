package de.uni_hildesheim.sse.easy.ui.productline_editor.configuration;

import java.util.HashSet;
import java.util.Iterator;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import de.uni_hildesheim.sse.model.varModel.Attribute;
import de.uni_hildesheim.sse.model.varModel.IvmlDatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.ModelQuery;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.VoidType;

/**
 * A combobox for displaying and selecting attributes. Attributes may be grouped.
 * 
 * @author Holger Eichelberger
 */
public class AttributesComboViewer extends ComboViewer {

    /**
     * A value provider for the group value (to be considered at runtime).
     * 
     * @author Holger Eichelberger
     */
    public interface IGroupValueProvider {
        
        /**
         * Returns whether the group (value) is selected.
         * 
         * @return <code>true</code> if the group (value) is selected
         */
        public boolean isSelected();
    }
    
    /**
     * Default value provider for enabled groups.
     */
    public static final IGroupValueProvider DEFAULT_TRUE = new IGroupValueProvider() {
        
        @Override
        public boolean isSelected() {
            return true;
        }
    };
    
    public static final Attribute ALL = new Attribute("[all]", VoidType.TYPE, null, null);
    
    private IGroupValueProvider groupValueProvider;
    
    private boolean all;
    
    /**
     * Creates a viewer without value provider and without "all" entry.
     * 
     * @param parent the parent composite
     */
    public AttributesComboViewer(Composite parent) {
        this(parent, null, false);
    }
    
    /**
     * Creates a viewer without value provider.
     * 
     * @param parent the parent composite
     * @param all whether an entry for "all" attributes shall be displayed
     */
    public AttributesComboViewer(Composite parent, boolean all) {
        this(parent, null, all);
    }
    
    /**
     * Creates a viewer.
     * 
     * @param parent the parent composite
     * @param groupValueProvider the group value provider (may be <b>null</b>)
     * @param all whether an entry for "all" attributes shall be displayed
     */
    public AttributesComboViewer(Composite parent, IGroupValueProvider groupValueProvider, boolean all) {
        super(parent, SWT.READ_ONLY);
        this.all = all;
        this.groupValueProvider = groupValueProvider;
        setContentProvider(ArrayContentProvider.getInstance());
        setLabelProvider(new LabelProvider() {
            
            public String getText(Object element) {
                String result;
                if (element instanceof Attribute) {
                    Attribute attr = (Attribute) element;
                    result = attr.getName();
                    if (null == AttributesComboViewer.this.groupValueProvider 
                        || !AttributesComboViewer.this.groupValueProvider.isSelected()) {
                        result = getQualifiedAppendix(attr);
                    }
                } else {
                    result = super.getText(element);
                }
                return result;
            }
            
        });
    }
    
    /**
     * Changes the group value provider.
     * 
     * @param groupValueProvider the group value provider (may be <b>null</b>)
     */
    public void setGroupValueProvider(IGroupValueProvider groupValueProvider) {
        this.groupValueProvider = groupValueProvider;
    }

    /**
     * Populates the view with attributes from <code>project</code>.
     * 
     * @param project the project to take the attributes from
     * @return <code>true</code> if the view was populated, <code>false</code> if the view is empty
     */
    public boolean populate(Project project) {
        java.util.List<Attribute> attributes = ModelQuery.getAllAttributes(project);
        if (null != groupValueProvider && groupValueProvider.isSelected()) {
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
        if (all) {
            attributes.add(0, ALL);
        }
        if (!getControl().isDisposed()) {
            setInput(attributes);
            if (attributes.size() > 0) {
                Combo combo = getCombo();
                if (combo.getSelectionIndex() < 0) {
                    combo.select(0);
                }
            }
        }
        return attributes.size() > 0;
    }
    
    /**
     * Returns an internal key for retrieving duplicates.
     * 
     * @param attribute the attribute to return the key for
     * @return the key
     */
    public static String getKey(Attribute attribute) {
        return attribute.getName()  + "_" + IvmlDatatypeVisitor.getQualifiedType(attribute.getType());
    }
    
    /**
     * Returns the display appendix for the qualified name.
     * 
     * @param attribute the attribute to return the appendix for
     * @return the appendix
     */
    public static String getQualifiedAppendix(Attribute attribute) {
        String name = null;
        if (attribute == ALL) {
            name = attribute.getName();
        } else {
            //TODO SE: check whether attribute.getTopLevelParent() is better than attribute.getElement()
            name = attribute.getName() + " on " + attribute.getTopLevelParent().getQualifiedName();
        }
        return name;                    
    }
    
    /**
     * Returns the selected attribute.
     * 
     * @return the selected attribute, <code>null</code> if none was selected
     */
    public Attribute getSelectedAttribute() {
        Attribute result = null;
        ISelection selection = getSelection();
        if (selection instanceof IStructuredSelection) {
            Object selected = ((IStructuredSelection) selection).getFirstElement();
            if (selected instanceof Attribute) {
                result = (Attribute) selected;
            }
        }
        return result;
    }


}