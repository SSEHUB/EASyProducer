package de.uni_hildesheim.sse.easy.ui.productline_editor;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

import de.uni_hildesheim.sse.easy.ui.internal.Activator;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;

/**
 * Editor Input for the ProductLine Configuration Editor of the EASy-Producer tool suite.
 * @author El-Sharkawy
 *
 */
public class ProductLineEditorInput implements IEditorInput {
    private static final Image IMAGE = Activator.getImageDescriptor("icons/logo_icon.gif").createImage();
    
    private ProductLineProject plp;
    
    /**
     * Sole constructor for this class.
     * @param plp The project, which should be edited.
     */
    public ProductLineEditorInput(ProductLineProject plp) {
        this.plp = plp;
    }
    
    /**
     * Getter for the project, which should be edited.
     * @return The project, which should be edited
     */
    public ProductLineProject getPLP() {
        return plp;
    }
    
    @Override
    public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean exists() {
        return null != plp;
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return new ImageDescriptor() {
            
            @Override
            public ImageData getImageData() {
                return IMAGE.getImageData();
            }
        };
    }

    @Override
    public String getName() {
        return plp.getProjectName();
    }

    @Override
    public IPersistableElement getPersistable() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getToolTipText() {
        return plp.getProjectName();
    }

    @Override
    public int hashCode() {
        return plp.getProjectID().hashCode();
    }
    
    @Override
    public boolean equals(Object otherEditor) {
        boolean equals = false;
        if (otherEditor instanceof ProductLineEditorInput) {
            equals = otherEditor.hashCode() == this.hashCode();         
        }
        
        return equals;
    }
}
