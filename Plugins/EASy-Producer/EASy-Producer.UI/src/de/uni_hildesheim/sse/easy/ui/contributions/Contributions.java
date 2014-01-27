package de.uni_hildesheim.sse.easy.ui.contributions;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.window.DefaultToolTip;
import org.eclipse.jface.window.ToolTip;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

import de.uni_hildesheim.sse.easy_producer.contributions.Contributions.CoreFunction;

/**
 * For contributions to the EASY UI. (preliminary, to be aligned with self-bootstrapping 
 * capabilities in future)
 * Please do not change the name or the location of this class as it is populated via OSGI-DS.
 * 
 * @author Holger Eichelberger
 */
public abstract class Contributions {

    /**
     * Denotes individual UI elements.
     * 
     * @author Holger Eichelberger
     */
    public enum UIElement {
        
        /**
         * The attributes value page.
         */
        ATTRIBUTES_VALUE_PAGE(false, null),
        
        /**
         * The button for deriving PL members.
         */
        DERIVE_NEW_MEMBER(true, CoreFunction.DERIVE_NEW_MEMBER),
        
        /**
         * The button for pulling the configuration.
         */
        PULL_CONFIGURATION(true, CoreFunction.PULL_CONFIGURATION),
        
        /**
         * The selection list for copy mechanisms.
         */
        COPY_MECHANISMS(true, null);
        
        /**
         * Stores the default behavior if no contribution is present.
         */
        private boolean enabled;
        
        /**
         * Stores the core function this element depends on.
         */
        private CoreFunction coreFunction;
        
        /**
         * Creates a new UI element constant.
         * 
         * @param enabled <tt>true</tt> if contribution shall be present by default, otherwise <tt>false</tt>.
         * @param coreFunction depending core function, may be <b>null</b>
         */
        private UIElement(boolean enabled, CoreFunction coreFunction) {
            this.enabled = enabled;
            this.coreFunction = coreFunction;
        }
        
        /**
         * Returns the default behavior of no contribution is present.
         * 
         * @return the default behavior
         */
        public boolean getEnabled() {
            return enabled;
        }
        
        /**
         * Returns the depending core function.
         * 
         * @return the depending core function (or <b>null</b> if this UI element does 
         *   not depend on any core function)
         */
        public CoreFunction getCoreFunction() {
            return coreFunction;
        }

        /**
         * Combines two enabled values.
         * @param val1 the first value
         * @param val2 the second value
         * @return the combined result
         */
        boolean combine(boolean val1, boolean val2) {
            boolean result;
            if (enabled) {
                result = val1 & val2;
            } else {
                result = val1 | val2;
            }
            return result;
        }
    }
    
    /**
     * Stores the registered UI contributions.
     */
    private static final List<Contributions> REGISTERED = new ArrayList<Contributions>();
    
    /**
     * Registers a particular contribution.
     * 
     * @param contribution the new contribution
     */
    public static synchronized void register(Contributions contribution) {
        if (null == contribution) {
            throw new IllegalArgumentException("null");
        }
        REGISTERED.add(contribution);
    }

    /**
     * Unregisters a particular contribution.
     * 
     * @param contribution the contribution to be unregisted
     */
    public static synchronized void unregister(Contributions contribution) {
        if (null == contribution) {
            throw new IllegalArgumentException("null");
        }
        REGISTERED.remove(contribution);
    }
    
    /**
     * Returns whether the specified UI element is enabled (at least one
     * contribution must request this).
     * 
     * @param element the UI element 
     * @return <code>true</code> if it shall be enabled, <code>false</code> else
     */
    public  static final synchronized boolean isEnabled(UIElement element) {
        boolean enabled = element.getEnabled();
        for (int c = 0; c < REGISTERED.size(); c++) {
            boolean tmp;
            if (null != element.getCoreFunction()) {
                tmp = de.uni_hildesheim.sse.easy_producer.contributions.Contributions.isEnabled(
                    element.getCoreFunction());
            } else {
                tmp = REGISTERED.get(c).isEnabledImpl(element);
            }
            enabled = element.combine(enabled, tmp);
        }
        return enabled;
    }

    /**
     * Returns whether this contribution requires that the given UI element shall be enabled.
     * 
     * @param element the UI element 
     * @return <code>true</code> if it shall be enabled, <code>false</code> else
     */
    protected abstract boolean isEnabledImpl(UIElement element);
    
    /**
     * Returns the tool tip for the specified UI element (composed from all contributions).
     * 
     * @param element the UI element 
     * @return <code>true</code> if it shall be enabled, <code>false</code> else
     */
    public static final synchronized String getToolTip(UIElement element) {
        StringBuilder builder = null;
        for (int c = 0; c < REGISTERED.size(); c++) {
            String tmp = REGISTERED.get(c).getToolTipImpl(element);
            if (null != tmp && tmp.length() > 0) {
                if (null == builder) {
                    builder = new StringBuilder();
                }
                if (builder.length() > 0) {
                    builder.append(" ");
                }
                builder.append(tmp);
            }
        }
        return (null == builder) ? null : builder.toString();
    }

    /**
     * Returns the tool tip of the given UI element .
     * 
     * @param element the UI element 
     * @return the tool tip (part) for the given UI element (may be <b>null</b>)
     */
    protected abstract String getToolTipImpl(UIElement element);

    /**
     * Configures the given <code>control</code> dependent on {@link #isEnabled(UIElement)} 
     * and {@link #getToolTip(UIElement)}. [convenience method]
     * 
     * @param control the control to be configured
     * @param element the UI element the control represents
     */
    public static final void configure(final Control control, UIElement element) {
        boolean enabled = isEnabled(element);
        control.setEnabled(enabled);
        final String tooltip = getToolTip(element);
        if (null != tooltip) {
            if (!enabled) {
                control.getParent().addListener(SWT.MouseHover, new ToolTipListener(control, tooltip));
            } else {
                control.setToolTipText(tooltip);
            }
        }
    }

    /**
     * A listener showing a tooltip on a disabled button.
     * 
     * @author Holger Eichelberger
     */
    private static class ToolTipListener implements Listener {

        private Control control;
        private DefaultToolTip tooltip;

        /**
         * Creates a tooltip listener.
         * 
         * @param control the control to attach to
         * @param tooltip the tooltip string
         */
        public ToolTipListener(Control control, String tooltip) {
            this.control = control;
            this.tooltip = new DefaultToolTip(control, ToolTip.NO_RECREATE, true);
            this.tooltip.setText(tooltip);
            this.tooltip.setHideDelay(0);
        }
        
        /**
         * {@inheritDoc}
         */
        @Override
        public void handleEvent(Event event) {
            Rectangle bounds = control.getBounds();
            if (bounds.contains(event.x, event.y)) {
                tooltip.show(new Point(0, 0));
            } else {
                tooltip.hide();
            }
        }

    }

}
