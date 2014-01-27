package de.uni_hildesheim.sse.easy.ui.core;


/**
 * Specification which Editor should be opened for a
 * {@link de.uni_hildesheim.sse.easy_producer.model.ProductLineProject}.
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
