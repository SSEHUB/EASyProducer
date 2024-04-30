package net.ssehub.easy.producer.ui.productline_editor.instantiator;

import java.io.InputStream;

import org.eclipse.swt.graphics.Device;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

/**
 * Provides {@link Image}s for the {@link InstantiatorConfigPage}.
 * 
 * @author kroeher
 *
 */
public class ImageProvider {

    public static final ImageProvider INSTANCE = new ImageProvider();
    
    private static final String VIL_ICONS_DIR = "/icons/";
    
    private Device displayDevice;
    
    /**
     * Constructs the singleton object of this {@link ImageProvider}.
     */
    private ImageProvider() {
        displayDevice = Display.getCurrent();
    }
    
    /**
     * Retrieves the corresponding {@link Image} for the given {@link TreeNode} and
     * returns that image.
     * 
     * @param node the {@link TreeNode} for which an {@link Image} should be returned.
     * @return the the corresponding {@link Image} for the given {@link TreeNode}. May
     * return <code>null</code> if the given <code>node</code> is <code>null</code>
     */
    public Image getImage(TreeNode node) {
        Image nodeImage = null;
        if (displayDevice != null && node != null) {
            String imgResourcePath = getImagePath(node);
            if (imgResourcePath != null) {
                InputStream imgStream = 
                    de.uni_hildesheim.sse.vil.buildlang.ui.resources.Images.class.getResourceAsStream(imgResourcePath);
                nodeImage = new Image(displayDevice, imgStream);
            }
        }
        return nodeImage;
    }
    
    /**
     * Returns the path to the image resource that corresponds to the actual type
     * of the given {@link TreeNode}.
     * 
     * @param node the {@link TreeNode} for which the path to the image resource should
     * be returned. Should <b>never</b> be <code>null</code>.
     * @return the path to the image resource as a {@link String}. May return <code>null</code>
     * if the type of the given <code>node</code> is unknown.
     */
    private String getImagePath(TreeNode node) {
        StringBuilder resourcePathBuilder = new StringBuilder();
        resourcePathBuilder.append(VIL_ICONS_DIR);
        
        if (node instanceof AlternativeExpressionTreeNode) {
            resourcePathBuilder.append(de.uni_hildesheim.sse.vil.buildlang.ui.resources.Images.NAME_ADVICE);
        } else if (node instanceof CallExpressionTreeNode) {
            resourcePathBuilder.append(de.uni_hildesheim.sse.vil.buildlang.ui.resources.Images.NAME_OPERATION);
        } else if (node instanceof InstantiateExpressionTreeNode) {
            resourcePathBuilder.append(de.uni_hildesheim.sse.vil.buildlang.ui.resources.Images.NAME_INSTANTIATE);
        } else if (node instanceof JoinExpressionTreeNode) {
            resourcePathBuilder.append(de.uni_hildesheim.sse.vil.buildlang.ui.resources.Images.NAME_JOIN);
        } else if (node instanceof LoopExpressionTreeNode) {
            resourcePathBuilder.append(de.uni_hildesheim.sse.vil.buildlang.ui.resources.Images.NAME_MAP);
        } else if (node instanceof RuleCallExpressionTreeNode) {
            resourcePathBuilder.append(de.uni_hildesheim.sse.vil.buildlang.ui.resources.Images.NAME_RULE_INSTANCE);
        } else if (node instanceof VariableDeclarationTreeNode) {
            resourcePathBuilder.append(de.uni_hildesheim.sse.vil.buildlang.ui.resources.Images.
                NAME_VARIABLEDECLARATION);
        } else if (node instanceof RuleTreeNode) {
            resourcePathBuilder.append(de.uni_hildesheim.sse.vil.buildlang.ui.resources.Images.NAME_RULE);
        } else if (node instanceof TextTreeNode) {
            resourcePathBuilder.append(de.uni_hildesheim.sse.vil.buildlang.ui.resources.Images.NAME_PATHPATTERN);
        }
        
        String resourcePath = null;
        if (resourcePathBuilder.length() > VIL_ICONS_DIR.length()) {
            resourcePath = resourcePathBuilder.toString();
        }
        
        return resourcePath;
    }
}
