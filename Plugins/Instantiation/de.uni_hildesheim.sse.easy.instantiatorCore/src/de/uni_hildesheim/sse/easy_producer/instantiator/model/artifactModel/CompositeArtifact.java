package de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Binary;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.representation.Text;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.common.VilException;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.OperationMeta;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes.Set;

/**
 * The (abstract) top-level decomposable artifact of this package.
 * 
 * @author Holger Eichelberger
 */
public abstract class CompositeArtifact implements IArtifact, IArtifactChangedListener {

    private Text textRepresentation;
    private Binary binaryRepresentation;
    private IArtifactChangedListenerQueue listeners = new ArtifactChangedListenerQueue();
    private boolean representationChanged;
    
    /**
     * Returns all artifacts this composite artifact is composed of.
     * 
     * @return all fragments
     */
    @OperationMeta(returnGenerics = FragmentArtifact.class)
    public abstract Set<? extends FragmentArtifact> selectAll();
    
    @Override
    public final Text getText() throws VilException {
        if (null == textRepresentation) {
            textRepresentation = createText();
            listeners.registerListener(textRepresentation);
            textRepresentation.getListeners().registerListener(this);
        }
        return textRepresentation;
    }

    @Override
    public final Binary getBinary() throws VilException {
        if (null == binaryRepresentation) {
            binaryRepresentation = createBinary();
            listeners.registerListener(binaryRepresentation);
            binaryRepresentation.getListeners().registerListener(this);
        }
        return binaryRepresentation;
    }
    
    @Override
    public void artifactChanged(Object cause) throws VilException {
        representationChanged = true;
    }
    
    /**
     * Returns whether the representation changed.
     * 
     * @param reset reset the current status of the flag to not changed
     * @return <code>true</code> if the representation (either binary or text) changed or not
     */
    protected boolean getRepresentationChanged(boolean reset) {
        boolean result = representationChanged;
        if (reset) {
            representationChanged = false;
        }
        return result;
    }
    
    /**
     * Returns the plain text representation instance.
     * 
     * @return the plain instance (may be <b>null</b>)
     */
    protected Text getTextInstance() {
        return textRepresentation;
    }

    /**
     * Returns the plain binary representation instance.
     * 
     * @return the plain instance (may be <b>null</b>)
     */
    protected Binary getBinaryInstance() {
        return binaryRepresentation;
    }

    /**
     * Actually creates the text representation. Please note that {@link #getText()} calls
     * this method and registers the listeners appropriately.
     * 
     * @return the created text representation
     * @throws VilException in case of serious problems creating the representation
     */
    protected abstract Text createText() throws VilException;

    /**
     * Actually creates the binary representation. Please note that {@link #getBinary()} calls
     * this method and registers the listeners appropriately.
     * 
     * @return the created binary representation
     * @throws VilException in case of serious problems creating the representation
     */
    protected abstract Binary createBinary() throws VilException;

    @Override
    public void update() throws VilException {
        if (null != binaryRepresentation) {
            binaryRepresentation.updateContents();
        }
        if (null != textRepresentation) {
            textRepresentation.updateContents();
        }
    }

}
