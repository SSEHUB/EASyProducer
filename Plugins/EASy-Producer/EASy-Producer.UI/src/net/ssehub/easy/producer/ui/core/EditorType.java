package net.ssehub.easy.producer.ui.core;


/**
 * Specification which Editor should be opened for a
 * {@link net.ssehub.easy.producer.eclipse.model.ProductLineProject}.
 * @author El-Sharkawy
 *
 */
public enum EditorType {

    /**
     * Specification that the Product Line Editor should be opened.
     */
    PRODUCT_LINE_PROJECT,
    
    /**
     * Specification that the Variability Model should be opened, i.e. the main IVML file.
     */
    VARMODEL,
    
    /**
     * Specification that the Build Script should be opened, i.e. the main VIL file.
     */
    BUILD_SCRIPT;
}
