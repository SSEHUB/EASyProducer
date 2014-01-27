package de.uni_hildesheim.sse.easy.ui.confModel;


/**
 * Listener interface for informing listeners that the {@link GUIConfiguration} contains unsaved data.
 * @author El-Sharkawy
 *
 */
public interface IGUIConfigChangeListener {

    /**
     * Will be called when something inside the {@link GUIConfiguration} was changed.
     * @param changedConfiguration A reference of the {@link GUIConfiguration} which was changed.
     */
    public void changed(GUIConfiguration changedConfiguration);
    
    /**
     * Will be called when something inside the {@link GUIConfiguration} was changed.
     * Contrary to {@link #changed(GUIConfiguration)}, this method should be used if only the view shall be updated.
     * @param changedConfiguration A reference of the {@link GUIConfiguration} which was changed.
     */
    public void imtemsChanged(GUIConfiguration changedConfiguration);
}
