package de.uni_hildesheim.sse.easy.ui.productline_editor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

import de.uni_hildesheim.sse.easy.ui.confModel.GUIConfiguration;
import de.uni_hildesheim.sse.easy.ui.confModel.GUIEditor;
import de.uni_hildesheim.sse.easy.ui.confModel.GUIValueFactory;
import de.uni_hildesheim.sse.easy.ui.confModel.GUIVariable;
import de.uni_hildesheim.sse.easy.ui.productline_editor.configuration.ConfigurationTableEditor;
import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.IvmlDatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;

/**
 * An UI element factory (preliminary).
 * 
 * @author Holger Eichelberger
 */
public class ConfigurationTableEditorFactory {

    private static final Map<String, IEditorCreator> CREATORS = new HashMap<String, IEditorCreator>();
    
    /**
     * An extensible editor creator for tailoring the general EASy mechanism.
     * 
     * @author Holger Eichelberger
     */
    public interface IEditorCreator {

        /**
         * Creates a cell editor for the given <code>variable</code>.
         * 
         * @param config the UI configuration
         * @param variable the decision variable to create the editor for
         * @param parent the UI parent element
         * @return the editor or <b>null</b> if the editor cannot be created for some reason
         */
        public CellEditor createCellEditor(UIConfiguration config, IDecisionVariable variable, Composite parent);

        /**
         * Creates a form editor for the given <code>variable</code>.
         * 
         * @param config the UI configuration
         * @param variable the decision variable to create the editor for
         * @param parent the UI parent element
         * @return the editor or <b>null</b> if the editor cannot be created for some reason
         */
        public Control createEditor(UIConfiguration config, IDecisionVariable variable, Composite parent);

    }
    
    /**
     * Just for now as the constructor of the target class is protected.
     * 
     * @author Holger Eichelberger
     */
    private static class ConfigTableEditor extends ConfigurationTableEditor {

        /**
         * Creates a configuration table editor.
         * 
         * @param configuration the actual configuration
         * @param parent the configuration parent
         */
        protected ConfigTableEditor(Configuration configuration, IEASyEditorPage parent) {
            super(configuration, parent);
        }
        
    }

    /**
     * Creates a configuration table editor.
     * 
     * @param configuration the configuration to be displayed / manipulated
     * @param parent the parent instance
     * @return the configuration table editor
     */
    public static final TreeViewer createConfigurationTableEditor(Configuration configuration, 
        IEASyEditorPage parent) {
        return new ConfigTableEditor(configuration, parent);
    }

    /**
     * A listener called when variables are changed.
     * 
     * @author Holger Eichelberger
     */
    public interface UIChangeListener {

        /**
         * Called when the given <code>variable</code> is updated/changed by the {@link UIConfiguration}.
         * 
         * @param variable the changed variable
         */
        public void valueChanged(IDecisionVariable variable);
        
    }

    /**
     * A UI configuration class wrapping the internally used configuration instance.
     * Please call {@link #release()} for cleanup.
     * 
     * @author Holger Eichelberger
     */
    public static class UIConfiguration {
        
        private GUIConfiguration config;
        private IEASyEditorPage parent;
        private Map<GUIVariable, GUIEditor> map = new HashMap<GUIVariable, GUIEditor>();

        /**
         * Creates a configuration instance.
         * 
         * @param config the IVML configuration
         * @param parent the editor parent instance
         */
        UIConfiguration(Configuration config, IEASyEditorPage parent) {
            this.config = new GUIConfiguration(config, parent.getContentPane());
            this.parent = parent;
        }

        /**
         * Returns the IVML configuration.
         * 
         * @return the configuration
         */
        GUIConfiguration getConfiguration() {
            return config;
        }
        
        /**
         * Returns the parent editor instance.
         * 
         * @return the parent editor instance
         */
        public IEASyEditorPage getParent() {
            return parent;
        }
        
        /**
         * Causes to freeze all values.
         */
        public void freezeAll() {
            config.freeze();
        }
        
        /**
         * Resets all values in the GUI editors.
         */
        public void resetValues() {
            for (Map.Entry<GUIVariable, GUIEditor> entry : map.entrySet()) {
                GUIVariable var = entry.getKey();
                GUIEditor ed = entry.getValue();
                ed.setValue(var.getValueText());
            }
        }
        
        /**
         * Commits all UI values to the GUI variables and, thus, enacts the new 
         * configuration values.
         * 
         * @param listener a change listener to notify about changed variables (may be <b>null</b>)
         */
        public void commitValues(UIChangeListener listener) {
            for (Map.Entry<GUIVariable, GUIEditor> entry : map.entrySet()) {
                GUIVariable var = entry.getKey();
                GUIEditor ed = entry.getValue();
                Object value = ed.getValue();
                boolean frozen = var.isFrozen();
                if (frozen) {
                    var.unfreeze(AssignmentState.ASSIGNED);
                }
                if (var.getNullLabel().equals(value)) {
                    var.setNULLValue();
                } else {
                    var.setValue(ed.getValue());
                }
                if (frozen) {
                    var.freeze();
                }
                if (null != listener) {
                    listener.valueChanged(var.getVariable());
                }
            }            
        }
        
        /**
         * Updates editors using variable that has recently been changed.
         * 
         * @param variable the variable that has recently been changed
         */
        public void updateEditor(IDecisionVariable variable) {
            IDatatype varType = variable.getDeclaration().getType();
            for (Map.Entry<GUIVariable, GUIEditor> entry : map.entrySet()) {
                IDecisionVariable tmp = entry.getKey().getVariable();
                IDatatype tmpType = tmp.getDeclaration().getType();
                if (variable == tmp // yes, the same
                    || Container.isContainer(tmpType, varType) // container of varType
                    || Container.isReferencesContainer(tmpType, varType)
                    || Reference.isReferenceTo(tmpType, varType)) { // container of refTo(varType)
                    entry.getValue().refreshContents();
                }
            }
        }
        
        /**
         * Release the internal structures, in particular the mapping of variables and editor.
         * This instance shall not be used afterwards.
         */
        public void release() {
            map.clear();
            map = null;
            config = null;
            parent = null;
        }
        
        /**
         * Adds a mapping between a GUI variable and a GUI editor.
         * 
         * @param variable the variable to be mapped
         * @param editor the editor
         */
        void add(GUIVariable variable, GUIEditor editor) {
            map.put(variable, editor);
        }
        
    }
    
    /**
     * Creates a configuration instance holding UI configuration elements. The returned instance may
     * be used to create multiple editors.
     * 
     * @param config the IVML configuration
     * @param parent the editor parent instance
     * @return the UI configuration
     */
    public static final UIConfiguration createConfiguration(Configuration config, IEASyEditorPage parent) {
        return new UIConfiguration(config, parent);
    }

    /**
     * Creates a form editor element for the given decision variable. 
     * 
     * @param config the UI configuration containing <code>variable</code>
     * @param variable the variable to return the editor for
     * @return the editor
     */
    public static final Control createEditor(UIConfiguration config, IDecisionVariable variable) {
        AbstractVariable decl = variable.getDeclaration();
        Control result = createEditor(config, variable, CREATORS.get(decl.getQualifiedName()));
        if (null == result) {
            result = createEditor(config, variable, CREATORS.get(IvmlDatatypeVisitor.getQualifiedType(decl.getType())));
        }
        if (null == result) {
            GUIVariable var = GUIValueFactory.createVariable(variable, config.getParent().getContentPane(), 
                config.getConfiguration(), null);
            GUIEditor editor = var.getEditor();
            if (!editor.isPseudoEditor()) {
                config.add(var, editor);
            }
            result = editor.getControl();
        }
        return result;
    }
    
    /**
     * Creates a cell editor element for the given decision variable. 
     * 
     * @param config the UI configuration containing <code>variable</code>
     * @param variable the variable to return the editor for
     * @return the editor
     */
    public static final CellEditor createCellEditor(UIConfiguration config, IDecisionVariable variable) {
        AbstractVariable decl = variable.getDeclaration();
        CellEditor result = null;
        result = createCellEditor(config, variable, CREATORS.get(decl.getQualifiedName()));
        if (null == result) {
            result = createCellEditor(config, variable, CREATORS.get(
                IvmlDatatypeVisitor.getQualifiedType(decl.getType())));
        }
        if (null == result) {
            GUIVariable var = GUIValueFactory.createVariable(variable, config.getParent().getContentPane(), 
                config.getConfiguration(), null);
            result = var.getCellEditor();
        }
        return result;
    }

    /**
     * Tries to create a form editor control from an editor creator.
     *
     * @param config the UI configuration
     * @param variable the variable to create the editor for
     * @param creator the creator to ask for the creation (may be <b>null</b>)
     * @return the editor or <b>null</b> if the given creator does not create the editor
     */
    private static final Control createEditor(UIConfiguration config, IDecisionVariable variable, 
        IEditorCreator creator) {
        Control result = null;
        if (null != creator) {
            result = creator.createEditor(config, variable, config.getParent().getContentPane());
        }
        return result;
    }

    /**
     * Tries to create a form editor control from an editor creator.
     *
     * @param config the UI configuration
     * @param variable the variable to create the editor for
     * @param creator the creator to ask for the creation (may be <b>null</b>)
     * @return the editor or <b>null</b> if the given creator does not create the editor
     */
    private static final CellEditor createCellEditor(UIConfiguration config, IDecisionVariable variable, 
        IEditorCreator creator) {
        CellEditor result = null;
        if (null != creator) {
            result = creator.createCellEditor(config, variable, config.getParent().getContentPane());
        }
        return result;
    }

    /**
     * Registers an editor creator, i.e., a plugin that supersedes the EASy way of creating editors for 
     * specific cases. Empty keys, null keys or null creators are ignored.
     * 
     * @param key (qualified) name or type to react on
     * @param creator the editor creator to register with
     */
    public static final void registerEditorCreator(String key, IEditorCreator creator) {
        if (null != key && key.length() > 0 && null != creator) {
            CREATORS.put(key, creator);
        }
    }
    
    /**
     * Changes the display name provider. [convenience]
     * 
     * @param provider the new name provider (considered only if not <b>null</b>)
     */
    public static final void setDisplayNameProvider(DisplayNameProvider provider) {
        DisplayNameProvider.setInstance(provider);
    }
    
    /**
     * Returns the current display name provider. [convenience]
     * 
     * @return the current display name provider
     */
    public static final DisplayNameProvider getDisplayNameProvider() {
        return DisplayNameProvider.getInstance();
    }
    
    /**
     * Defines whether updatable cell editors shall be created if possible.
     * 
     * @param updatable if <code>true</code>, updatable cell editors shall be created, 
     *   <code>false</code> for usual ones
     */
    public static final void createUpdatableCellEditors(boolean updatable) {
        GUIValueFactory.createUpdatableCellEditors(updatable);
    }
    
}
