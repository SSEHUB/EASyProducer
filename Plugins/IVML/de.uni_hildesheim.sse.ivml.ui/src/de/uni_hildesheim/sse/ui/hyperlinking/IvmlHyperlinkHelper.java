package de.uni_hildesheim.sse.ui.hyperlinking;

import de.uni_hildesheim.sse.ivml.Project;
import net.ssehub.easy.dslCore.ui.hyperlinking.GenericHyperlinkHelper;

/**
 * This class enables the creation of hyperlinks for any
 * IVML-element in an IVML-file if the user selects such an element either via
 * pressing the "F3"-key or by clicking on that element while pressing the
 * "CTRL"-key.
 * 
 * @author kroeher
 */
public class IvmlHyperlinkHelper extends GenericHyperlinkHelper<Project> {

    /**
     * Creates an instance of this {@link IvmlHyperlinkHelper}.
     */
    public IvmlHyperlinkHelper() {
        super(EcoreModelQuery.INSTANCE, IvmlHyperlinkFactory.INSTANCE);
    }

}
