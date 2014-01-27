package de.uni_hildesheim.sse.easy.ui.productline_editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;

import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;

/**
 * Abstract super class for header menus (buttons), which are parts different editor pages.
 * @author El-Sharkawy
 *
 */
public abstract class AbstractHeaderMenu extends Composite {
    private ProductLineProject plp;

    /**
     * Sole constructor for this class.
     * @param parent The parent holding this menu.
     * @param plp The current edited {@link ProductLineProject}
     */
    protected AbstractHeaderMenu(Composite parent, ProductLineProject plp) {
        super(parent, SWT.NONE);
        this.plp = plp;
        setBackground(parent.getBackground());
        setLayout();
    }
    
    /**
     * Sets the Layout for this Composite.
     */
    protected void setLayout() {
        GridLayout headerButtonCompositeLayout = new GridLayout();
        setLayout(headerButtonCompositeLayout);
        headerButtonCompositeLayout.numColumns = 4;
    }
    
    /**
     * Returns the current edited {@link ProductLineProject}.
     * @return The current edited {@link ProductLineProject}
     */
    protected final ProductLineProject getProductLineProject() {
        return plp;
    }
    
    /**
     * Enables or disables the buttons, depending on whether a the related action is possible.
     * This check should be performed whenever the page becomes activated.
     */
    public abstract void revalidateButtons();
}
