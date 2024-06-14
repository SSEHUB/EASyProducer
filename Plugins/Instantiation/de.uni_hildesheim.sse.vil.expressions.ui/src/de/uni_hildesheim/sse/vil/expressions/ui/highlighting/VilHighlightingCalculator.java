package de.uni_hildesheim.sse.vil.expressions.ui.highlighting;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.ide.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ide.editor.syntaxcoloring.ISemanticHighlightingCalculator;


/**
 * This class enables the customization of syntax-highlighting in the VIL build and template language editors.
 *  
 * @author dernek
 * @author kroeher
 *
 */
public class VilHighlightingCalculator implements ISemanticHighlightingCalculator {

    /**
     * The regex which identifies the string to be highlighted (within a common string).
     * Example: "Hello ${w} world!" --> identifies: ${w}
     */
    private static final String COMPLEX_HIGHLIGHT_REGEX = "\\$\\s*\\{\\s*.*?\\s*\\}";
    
    /**
     * The regex which identifies the string to be highlighted (single string).
     * Example: "$target/resources/" --> identifies: $target
     */
    private static final String SIMPLE_HIGHLIGHT_REGEX = "\\$\\s*.*?[/\"]"; 

    @Override
    public void provideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor, 
        CancelIndicator indicator) {
        if (hasRootNode(resource)) {
            provideStringPatternHighlight(resource.getParseResult().getRootNode(), acceptor);
        }
    }
    
    /**
     * Provide the highlighting of the referred variables. This includes the determination of all
     * strings that match the regular expressions "\\$\\s*\\{\\s*.*?\\s*\\}" or "\\$\\s*.*?/".
     * By default, referred variables will be highlighted in bold. This highlighting may be customized
     * by the user using the VIL/VTL preference page in Eclipse
     *  
     * @param rootNode the root node of the parse tree which holds the text of the entire VIL-file.
     * @param acceptor the acceptor for adding the positions that should be highlighted individually.
     */
    private void provideStringPatternHighlight(INode rootNode, IHighlightedPositionAcceptor acceptor) {
        String fullText = rootNode.getText();
        Matcher matcher = Pattern.compile(COMPLEX_HIGHLIGHT_REGEX).matcher(fullText);
        while (matcher.find()) {
            acceptor.addPosition(matcher.start(),  matcher.end() - matcher.start(), VilHighlightingConfiguration.REFERRED_VARIABLES);
        }
        matcher = Pattern.compile(SIMPLE_HIGHLIGHT_REGEX).matcher(fullText);
        while (matcher.find()) {
            acceptor.addPosition(matcher.start(),  matcher.end() - matcher.start() - 1, VilHighlightingConfiguration.REFERRED_VARIABLES);
        }
    }
    
    /**
     * Check whether the given resource is not <code>null</code> and provides root-node.
     * 
     * @param resource the resource (the actual document in the editor) to be checked.
     * @return <code>True</code> if the given resource was parsed successfully and, thus, a root-node exists. <code>False</code> otherwise.
     */
    private boolean hasRootNode(XtextResource resource) {
        return resource != null
                && resource.getParseResult() != null
                && resource.getParseResult().getRootNode() != null;
    }
}