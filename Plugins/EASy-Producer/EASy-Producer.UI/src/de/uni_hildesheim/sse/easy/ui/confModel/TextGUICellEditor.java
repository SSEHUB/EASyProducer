package de.uni_hildesheim.sse.easy.ui.confModel;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.ICellEditorValidator;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.widgets.Composite;

import de.uni_hildesheim.sse.easy.ui.productline_editor.IUpdateListener;
import de.uni_hildesheim.sse.easy.ui.productline_editor.IUpdateProvider;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;

/**
 * Implements an updating text cell editor.
 * 
 * @author Holger Eichelberger
 */
public class TextGUICellEditor extends TextCellEditor implements IUpdateProvider {

    /**
     * Stores all value converters. Value converters aim at returning the same value type as it has been set on this UI
     * object. Actually, it might be better to equip EASy with specific editors or, in case of 
     * tabbed values, on the internal editors rather than the EASy editors.
     */
    private static final Map<Class<?>, ValueConverter<?>> CONVERTERS = new HashMap<Class<?>, ValueConverter<?>>();
    
    private BasisGUIVariable variable;
    private IUpdateListener listener;
    private ValueConverter<?> converter;
    
    /**
     * Allows to perform specific value conversions to/from strings behind UI elements. This is typically required
     * in default tabbed property editors.
     * 
     * @param <T> the value type
     * @author Holger Eichelberger
     */
    private interface ValueConverter<T> extends ICellEditorValidator {

        /**
         * Turns a UI <code>value</code> into the property (object) value.
         * 
         * @param value the UI value
         * @return the property (object) value
         */
        public T fromUI(Object value);
        
        /**
         * Turns a property (object) value into UI.
         * 
         * @param value the value to be turned into the UI
         * @return the UI value (typically a string)
         */
        public Object toUI(Object value);
    }
    
    /**
     * Implements an abstract string value converter for turning an object into an UI string.
     * 
     * @param <T> the value type
     * @author Holger Eichelberger
     */
    private abstract static class AbstractStringValueConverter<T> implements ValueConverter<T> {
        
        @Override
        public Object toUI(Object value) {
            Object result;
            if (null != value) {
                result = value.toString();
            } else {
                result = "";
            }
            return result;
        }
    }
    
    /**
     * Implements a simple integer converter (currently ignoring input failures).
     * 
     * @author Holger Eichelberger
     */
    private static class IntegerValueConverter extends AbstractStringValueConverter<Integer> {

        @Override
        public Integer fromUI(Object value) {
            Integer result;
            if (null != value) {
                try {
                    result = Integer.parseInt(value.toString());
                } catch (NumberFormatException e) {
                    result = 0; // shall not occur if validator is properly used
                }
            } else {
                result = 0;
            }
            return result;
        }

        @Override
        public String isValid(Object value) {
            String result = null;
            try {
                Integer.parseInt(value.toString());
            } catch (NumberFormatException e) {
                result = e.getMessage(); 
            }
            return result;
        }

    }

    /**
     * Implements a simple float converter (currently ignoring input failures).
     * 
     * @author Holger Eichelberger
     */
    private static class FloatValueConverter extends AbstractStringValueConverter<Float> {

        @Override
        public Float fromUI(Object value) {
            Float result;
            if (null != value) {
                try {
                    result = Float.parseFloat(value.toString());
                } catch (NumberFormatException e) {
                    result = 0.0F; // shall not occur if validator is properly used
                }
            } else {
                result = 0.0f;
            }
            return result;
        }

        @Override
        public String isValid(Object value) {
            String result = null;
            try {
                Float.parseFloat(value.toString());
            } catch (NumberFormatException e) {
                result = e.getMessage(); 
            }
            return result;
        }

    }

    /**
     * Implements a simple double converter (currently ignoring input failures).
     * 
     * @author Holger Eichelberger
     */
    private static class DoubleValueConverter extends AbstractStringValueConverter<Double> {

        @Override
        public Double fromUI(Object value) {
            Double result;
            if (null != value) {
                try {
                    result = Double.parseDouble(value.toString());
                } catch (NumberFormatException e) {
                    result = 0.0; // default for the moment
                }
            } else {
                result = 0.0;
            }
            return result;
        }
        
        @Override
        public String isValid(Object value) {
            String result = null;
            try {
                Double.parseDouble(value.toString());
            } catch (NumberFormatException e) {
                result = e.getMessage(); 
            }
            return result;
        }

    }

    static {
        CONVERTERS.put(Integer.class, new IntegerValueConverter());
        CONVERTERS.put(Float.class, new FloatValueConverter());
        CONVERTERS.put(Double.class, new DoubleValueConverter());
    }
    
    /**
     * Creates a new text string cell editor parented under the given control.
     *
     * @param parent the parent control
     * @param variable the variable this editor was created for
     */
    public TextGUICellEditor(Composite parent, BasisGUIVariable variable) {
        super(parent);
        this.variable = variable;
    }

    @Override
    public void refresh() {
        // not relevant here, the value change is the interesting part
    }

    @Override
    public void setUpdateListener(IUpdateListener listener) {
        this.listener = listener;
    }

    @Override
    public IDecisionVariable getVariable() {
        return variable.getVariable();
    }
    

    @Override
    protected void doSetValue(Object value) {
        setValidator(null);
        converter = null;
        if (null != value) {
            converter = CONVERTERS.get(value.getClass());
            if (null != converter) {
                setValidator(converter);
                value = converter.toUI(value);
            }
        }
        super.doSetValue(value);
        if (null != listener) {
            listener.valueChanged(this);
        }
    }
    
    /**
     * The <code>TextCellEditor</code> implementation of
     * this <code>CellEditor</code> framework method returns
     * the text string.
     *
     * @return the text string
     */
    @Override
    protected Object doGetValue() {
        Object result = super.doGetValue();
        if (null != converter) {
            result = converter.fromUI(result);
        }
        return result;
    }

    
    @Override
    public void dispose() {
        if (null != listener) {
            listener.dispose();
        }
        super.dispose();
    }
    
}
