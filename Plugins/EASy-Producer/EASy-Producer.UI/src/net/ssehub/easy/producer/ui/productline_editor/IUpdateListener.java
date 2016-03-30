package net.ssehub.easy.producer.ui.productline_editor;

/**
 * A listener to be informed about editor updates.
 * 
 * @author Holger Eichelberger
 */
public interface IUpdateListener {

    /**
     * Called for cleanup.
     */
    public void dispose();

    /**
     * Called when the value changed.
     * 
     * @param provider the provider
     */
    public void valueChanged(IUpdateProvider provider);
    
}
