package net.ssehub.easy.producer.ui.confModel;

/**
 * Interface for all configurable elements of the {@link GUIConfiguration}. This comprise
 * this {@link GUIConfiguration} and the {@link GUIVariable}s. 
 * @author El-Sharkawy
 *
 */
public interface IGUIConfigurableElement {

    /**
     * Returns the related {@link GUIConfiguration} where this items belongs to.
     * @return The {@link GUIConfiguration} which holds this element. In case this is the {@link GUIConfiguration}
     * <code>this</code> will be returned.
     */
    public GUIConfiguration getConfiguration();
}
