package de.uni_hildesheim.sse.vil.templatelang.ui.hyperlinking;

import de.uni_hildesheim.sse.vil.templatelang.templateLang.LanguageUnit;
import net.ssehub.easy.dslCore.ui.hyperlinking.GenericHyperlinkHelper;

/**
 * This class enables the creation of hyperlinks for any
 * VIL-element in an VIL-file if the user selects such an element either via
 * pressing the "F3"-key or by clicking on that element while pressing the
 * "CTRL"-key.
 * 
 * @author Holger Eichelberger
 */
public class VtlHyperlinkHelper extends GenericHyperlinkHelper<LanguageUnit> {

    /**
     * Creates an instance of this {@link VtlHyperlinkHelper}.
     */
    public VtlHyperlinkHelper() {
        super(VtlHyperlinkFactory.MODEL_QUERY_INSTANCE, VtlHyperlinkFactory.INSTANCE);
    }

}
