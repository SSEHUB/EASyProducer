package de.uni_hildesheim.sse.easy.ui.productline_editor;


/**
 * Listener for {@link AbstractEASyEditorPage}s.
 * This lister will be informed when the {@link AbstractEASyEditorPage} becomes dirty.
 * 
 * @author El-Sharkawy
 *
 */
interface IEASyPageListener {

    /**
     * Informs the listener that the page becomes dirty.
     * @param page The page which becomes dirty.
     */
    public void pageBecomesDirty(AbstractEASyEditorPage page);
}
