package net.ssehub.easy.producer.ui.productline_editor.configuration;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

import net.ssehub.easy.producer.ui.confModel.GUIVariable;

/**
 * Abstract filter for the {@link ConfigurationTableEditor}.
 * @author El-Sharkawy
 *
 */
public abstract class AbstractConfigurationFilter extends ViewerFilter {
    
    private boolean showAllNestedElements;
    
    /**
     * Constructor for inherited classes.<br/>
     * All nested elements of a displayed variable will be shown independently whether they matches this
     * filter criteria.
     * @see #AbstractConfigurationFilter(boolean)
     */
    protected AbstractConfigurationFilter() {
        this(true);
    }
    
    /**
     * Constructor for inherited classes.
     * Depending on the given parameter, nested elements of a shown variable will also be filtered.
     * @param showAllNestedElements
     * <ul>
     * <li><code>true</code>: If the parent is shown, than all nested elements will be shown.
     * Same behavior as {@link #AbstractConfigurationFilter()} </li>
     * <li><code>false</code>: If the parent is shown, than the filter is also applied to nested elements.
     * Consequently, not all nested elements must be shown.</li>
     * </ul>
     */
    protected AbstractConfigurationFilter(boolean showAllNestedElements) {
        this.showAllNestedElements = showAllNestedElements;
    }

    @Override
    public final boolean select(Viewer viewer, Object parentElement, Object element) {
        GUIVariable variable = (GUIVariable) element;
        return recursiveCheck(variable);
    }
    
    /**
     * Determines whether a given variable should be shown inside the editor or not.
     * This function ensures that parents of of displayed nested elements will <b>not</b> be filtered.
     * @param variable The variable which should be tested whether it should be displayed inside the editor
     * @return <code>true</code> if the variable should be displayed, <code>false</code> otherwise.
     * @see #checkVariable(GUIVariable)
     */
    private boolean recursiveCheck(GUIVariable variable) {
        boolean displayVariable = checkVariable(variable);
        
        boolean displayParent = false;
        if (!displayVariable && null != variable.getParent()) {
            displayParent = recursiveCheck(variable.getParent());
        }
        return displayVariable || (displayParent && showAllNestedElements);
    }
    
    /**
     * Determines whether a given variable should be shown inside the editor or not.
     * Parents of variables which shall be shown should not be filtered. The {@link AbstractConfigurationFilter}
     * ensures that.<br/>
     * This method must also ensure that nested elements of a shown variable are also displayed.
     * Therefore, this method should also be written in a recursive manner to check nested elements of
     * displayed variables. This should be done in the following way:<br/>
     * <code>
     * if(checkVariable(variable)) {<br/>
     * &nbsp;&nbsp;for(GUIVariable nestedVariable : variable.getNestedVars()) {<br/>
     * &nbsp;&nbsp;&nbsp;&nbsp;checkVariable(nestedVariable);<br/>
     * &nbsp;&nbsp;}<br/>
     * }
     * </code>
     * @param variable The variable which should be tested whether it should be displayed inside the editor
     * @return <code>true</code> if the variable should be displayed, <code>false</code> otherwise.
     */
    protected abstract boolean checkVariable(GUIVariable variable);

    /**
     * Calls {@link #checkVariable(GUIVariable)} recursively on <code>variable</code>.
     * 
     * @param variable the variable to check
     * @return <code>true</code> if the variable should be displayed, <code>false</code> otherwise.
     */
    protected boolean checkVariableRecursivley(GUIVariable variable) {
        boolean matches = false;
        for (int i = 0; i < variable.getNestedElementsCount() && !matches; i++) {
            GUIVariable nestedVariable = variable.getNestedElement(i);
            if (null != nestedVariable) {
                matches = checkVariable(variable.getNestedElement(i));
            }
        }
        return matches;
    }
}
