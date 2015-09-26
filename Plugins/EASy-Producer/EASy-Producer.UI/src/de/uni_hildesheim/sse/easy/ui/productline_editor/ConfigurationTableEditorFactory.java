package de.uni_hildesheim.sse.easy.ui.productline_editor;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;

import de.uni_hildesheim.sse.dslcore.ui.ConfigurationEditorFactory.IConfigurationEditorCreator;
import de.uni_hildesheim.sse.easy.ui.confModel.GUIConfiguration;
import de.uni_hildesheim.sse.easy.ui.confModel.GUIEditor;
import de.uni_hildesheim.sse.easy.ui.confModel.GUIValueFactory;
import de.uni_hildesheim.sse.easy.ui.confModel.GUIVariable;
import de.uni_hildesheim.sse.easy.ui.productline_editor.configuration.AttributeRegExFilter;
import de.uni_hildesheim.sse.easy.ui.productline_editor.configuration.ConfigNameFilter;
import de.uni_hildesheim.sse.easy.ui.productline_editor.configuration.ConfigurationTableEditor;
import de.uni_hildesheim.sse.easy.ui.productline_editor.configuration.NonFrozenFilter;
import de.uni_hildesheim.sse.easy_producer.instantiator.Bundle;
import de.uni_hildesheim.sse.model.confModel.AssignmentState;
import de.uni_hildesheim.sse.model.confModel.Configuration;
import de.uni_hildesheim.sse.model.confModel.DisplayNameProvider;
import de.uni_hildesheim.sse.model.confModel.IDecisionVariable;
import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.IvmlDatatypeVisitor;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.datatypes.Container;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.Reference;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.modelManagement.IModelListener;

/**
 * An UI element factory (preliminary).
 * 
 * @author Holger Eichelberger
 */
public class ConfigurationTableEditorFactory implements IConfigurationEditorCreator {

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

        /**
         * Updates the display text of the value in the editor.
         * 
         * @param text the text to be displayed
         */
        public void updateText(String text);
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
     * Defines a simple UI parameter with name and default value.
     * 
     * @author Holger Eichelberger
     */
    public static class UIParameter {
        
        private String name;
        private Object defaultValue;
        
        /**
         * Creates a UI parameter.
         * 
         * @param name the name of the parameter
         * @param defaultValue the optional default value (may be <b>null</b> for none)
         */
        public UIParameter(String name, Object defaultValue) {
            this.name = name;
            this.defaultValue = defaultValue;
        }
        
        /**
         * Returns the default value.
         * 
         * @return the default value (may be <b>null</b> for none)
         */
        public Object getDefaultValue() {
            return defaultValue;
        }
        
        /**
         * Returns the name of the parameter.
         * 
         * @return the name
         */
        public String getName() {
            return name;
        }
        
        @Override
        public String toString() {
            return name + "(default:" + defaultValue + ")";
        }
    }

    /**
     * A UI configuration class wrapping the internally used configuration instance.
     * Please call {@link #release()} for cleanup.
     * 
     * @author Holger Eichelberger
     */
    public static class UIConfiguration implements IModelListener<Project> {
        
        private GUIConfiguration config;
        private IEASyEditorPage parent;
        private Map<GUIVariable, GUIEditor> map = new HashMap<GUIVariable, GUIEditor>();
        private Map<UIParameter, Object> parameter;

        /**
         * Creates a configuration instance.
         * 
         * @param config the IVML configuration
         * @param parent the editor parent instance
         * @param parameter optional parameter (may be <b>null</b>)
         */
        UIConfiguration(Configuration config, IEASyEditorPage parent, Map<UIParameter, Object> parameter) {
            this.config = new GUIConfiguration(config, parent.getContentPane());
            this.parent = parent;
            if (null != parameter) {
                this.parameter = new HashMap<UIParameter, Object>();
                this.parameter.putAll(parameter);
            } else {
                this.parameter = null;
            }
            VarModel.INSTANCE.events().addModelListener(config.getProject(), this);
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
         * Returns a configuration parameter.
         * 
         * @param key the key to return the parameter for
         * @return the parameter or its default value, may be <b>null</b> if no parameters are specified, 
         *   <code>key</code> is null or the key does not exist
         */
        public Object getParameter(UIParameter key) {
            Object result;
            if (null == parameter || null == key) {
                result = null;
            } else {
                if (!parameter.containsKey(key)) {
                    result = key.getDefaultValue();
                } else {
                    result = parameter.get(key);
                }
            }
            return result;
        }
        
        /**
         * Returns (a copy) of the configuration parameters.
         * 
         * @return the parameters (may be <b>null</b>
         */
        public Map<UIParameter, Object> getParameters() {
            Map<UIParameter, Object> result;
            if (null == parameter) {
                result = null;
            } else {
                result = new HashMap<UIParameter, Object>();
                result.putAll(parameter);
            }
            return result;
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
            VarModel.INSTANCE.events().removeModelListener(config.getConfig().getProject(), this);
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
        
        /**
         * Deconfigures the given control.
         * 
         * @param control the control to be deconfigured
         */
        public void deconfigure(Control control) {
            for (Map.Entry<GUIVariable, GUIEditor> entry : map.entrySet()) {
                if (entry.getValue().getControl().equals(control)) {
                    entry.getKey().setEmptyValue();
                    entry.getValue().refreshContents();
                    if (control instanceof Text) {
                        ((Text) control).setText(entry.getKey().getNullLabel());
                    }
                    break;
                }
            }
        }

        @Override
        public void notifyReplaced(Project oldModel, Project newModel) {
            // needed to update the variables upon a model change :o otherwise UI changes do not have any effect
            Configuration cfg = config.getConfig();
            for (Map.Entry<GUIVariable, GUIEditor> entry : map.entrySet()) {
                GUIVariable guiVar = entry.getKey();
                IDecisionVariable newVar = Configuration.mapVariable(guiVar.getVariable(), cfg);
                if (null != newVar) {
                    guiVar.setVariable(newVar);
                } else {
                    EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID)
                        .error("No variable found in new configuratio, i.e., discontinued mapping!");
                }
            }
        }
        
        /**
         * Returns the control (of the editor for) <code>var</code>.
         * 
         * @param var the variable to search for
         * @return the control (may be <b>null</b> if not found)
         */
        public Control getEditorFor(AbstractVariable var) {
            GUIEditor editor = null;
            // currently not really efficient, let's see. Having a second map would increase the effort 
            // in notifyReplaced.
            for (Map.Entry<GUIVariable, GUIEditor> entry : map.entrySet()) {
                if (var.equals(entry.getKey().getVariable().getDeclaration())) {
                    editor = entry.getValue();
                    break;
                }
            }
            Control result = null;
            if (null != editor) {
                result = editor.getControl();
            }
            return result;
        }

        /**
         * Returns the control (of the editor for) <code>var</code>.
         * 
         * @param var the variable to search for
         * @return the control (may be <b>null</b> if not found)
         */
        public Control getEditorFor(IDecisionVariable var) {
            GUIEditor editor = null;
            // currently not really efficient, let's see. Having a second map would increase the effort 
            // in notifyReplaced.
            for (Map.Entry<GUIVariable, GUIEditor> entry : map.entrySet()) {
                if (var.equals(entry.getKey().getVariable())) {
                    editor = entry.getValue();
                    break;
                }
            }
            Control result = null;
            if (null != editor) {
                result = editor.getControl();
            }
            return result;            
        }
        
    }

    /**
     * Creates a configuration instance holding UI configuration elements without parameters. The returned instance may
     * be used to create multiple editors.
     * 
     * @param config the IVML configuration
     * @param parent the editor parent instance
     * @return the UI configuration
     */
    public static final UIConfiguration createConfiguration(Configuration config, IEASyEditorPage parent) {
        return new UIConfiguration(config, parent, null);
    }
    
    /**
     * Creates a configuration instance holding UI configuration elements. The returned instance may
     * be used to create multiple editors.
     * 
     * @param config the IVML configuration
     * @param parent the editor parent instance
     * @param parameter optional parameter (may be <b>null</b>)
     * @return the UI configuration
     */
    public static final UIConfiguration createConfiguration(Configuration config, IEASyEditorPage parent, 
        Map<UIParameter, Object> parameter) {
        return new UIConfiguration(config, parent, parameter);
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

    @Override
    public TreeViewer createEditor(Configuration config, Composite parent) {
        return createConfigurationTableEditor(config, new DelegatingEasyEditorPage(parent));
    }

    @Override
    public ViewerFilter createNameFilter(String nameRegEx, boolean showAllNestedElements) {
        return new ConfigNameFilter(nameRegEx, showAllNestedElements);
    }

    @Override
    public ViewerFilter createAttributeFilter(String attributeNameRegEx, String valueRegEx, 
        boolean showAllNestedElements) {
        return new AttributeRegExFilter(attributeNameRegEx, valueRegEx, showAllNestedElements);
    }

    @Override
    public ViewerFilter createNonFrozenFilter(boolean showAllNestedElements) {
        return new NonFrozenFilter(showAllNestedElements);
    }

}
