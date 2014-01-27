package de.uni_hildesheim.sse.easy.ui.productline_editor;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import de.uni_hildesheim.sse.easy.ui.internal.Activator;


/**
 * A graphical component to inform the user that a functional component, e.g. a 
 * {@link de.uni_hildesheim.sse.easy.ui.productline_editor.configuration.AbstractConfigurationFilter},
 * is (de-)avtivated.
 * 
 * @author El-Sharkawy
 *
 */
public class IOButton extends Composite {
    
    private static final Image IMG_ON = Activator.getImageDescriptor("icons/checkmark.png").createImage();
    private static final Image IMG_OFF =
        PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_TOOL_DELETE_DISABLED);
    
    private Label lblInfoImage;
    
    /**
     * Sole constructor for this class.
     * @param parent The parent holding this button.
     * @param description An optional description, can be empty but not <tt>null</tt>.
     */
    public IOButton(Composite parent, String description) {
        super(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        setLayout(layout);
        
        lblInfoImage = new Label(this, SWT.NONE);
        Label lblDescription = new Label(this, SWT.NONE);
        lblDescription.setText(description);
        
        setActivated(false);
    }
    
    /**
     * changes the state (and the displayed image) of this {@link IOButton}.
     * @param activate <tt>true</tt> to indicate that the related functionality was enabled.
     */
    public void setActivated(boolean activate) {
        if (activate) {
            lblInfoImage.setImage(IMG_ON);
        } else {
            lblInfoImage.setImage(IMG_OFF);            
        }
    }

}
