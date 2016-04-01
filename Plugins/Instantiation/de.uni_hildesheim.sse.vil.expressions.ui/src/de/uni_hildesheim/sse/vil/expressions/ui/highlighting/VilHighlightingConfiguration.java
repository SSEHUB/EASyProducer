package de.uni_hildesheim.sse.vil.expressions.ui.highlighting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * This class represents the initial configuration of the customized highlighting.
 * The values (colors) configured here might be overridden by the colors defined by
 * the user in the Eclipse configuration.
 * 
 * @author dernek
 * @author kroeher
 *
 */
public class VilHighlightingConfiguration extends DefaultHighlightingConfiguration {

    /**
     * The name of the configurable highlighting in the Eclipse preferences page.
     */
    public static final String REFERRED_VARIABLES = "Referred Variables";
    

    @Override
    public void configure(IHighlightingConfigurationAcceptor acceptor) {
        super.configure(acceptor);
        TextStyle textStyle = new TextStyle();
        textStyle.setBackgroundColor(new RGB(255, 255, 255));
        textStyle.setColor(new RGB(42, 0, 255));
        textStyle.setFontData(new FontData("Consolas-regular", 10, SWT.BOLD));
        acceptor.acceptDefaultHighlighting(REFERRED_VARIABLES, REFERRED_VARIABLES, textStyle);
    }
}