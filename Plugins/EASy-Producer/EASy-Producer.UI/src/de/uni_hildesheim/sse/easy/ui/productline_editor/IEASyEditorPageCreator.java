package de.uni_hildesheim.sse.easy.ui.productline_editor;


import org.eclipse.swt.widgets.Composite;

import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;

/**
 * "Factory" for creating a specialized editor for a given {@link ProductLineProject}.
 * This interface is for supporting specialized {@link AbstractEASyEditorPage}s of other projects.
 * 
 * @author El-Sharkawy
 *
 */
public interface IEASyEditorPageCreator {
    
    /**
     * Creates a new {@link AbstractEASyEditorPage} for the given {@link ProductLineProject}. 
     * @param plp The {@link ProductLineProject} for which the editor shall be created.
     * @param parent The parent, holding this editor page.
     * @return A new Editor for the {@link Editor}.
     */
    public AbstractEASyEditorPage createPage(ProductLineProject plp, Composite parent);

}
