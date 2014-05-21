package de.java.instantiator.prototype;

import org.eclipse.swt.widgets.Composite;

import de.uni_hildesheim.sse.easy.ui.productline_editor.AbstractEASyEditorPage;
import de.uni_hildesheim.sse.easy.ui.productline_editor.IEASyEditorPageCreator;
import de.uni_hildesheim.sse.easy_producer.model.ProductLineProject;

/**
 * Creates a new Page.
 * 
 * @author Sass
 *
 */
public class PageFactory implements IEASyEditorPageCreator {

    @Override
    public AbstractEASyEditorPage createPage(ProductLineProject plp, Composite parent) {
        return new EditorPage(plp, parent);
    }

}
