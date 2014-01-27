package de.uni_hildesheim.sse.easy.instantiator.copy.core;

/**
 * Model representing the copy configuration for exactly one project.
 * @author El-Sharkawy
 *
 */
public class CopyModel {
    private String name;
    private String id;
    
    /**
     * Default constructor for this class, creating a model with the default {@link ICopyMechanism} selected.
     * @see CopyMechansimRegistry#getDefaultCopyMechanism()
     */
    public CopyModel() {
        setCopyMechanism(CopyMechansimRegistry.INSTANCE.getDefaultCopyMechanism());
    }

    /**
     * Getter for the name of the chosen {@link ICopyMechanism}.
     * @return The name of the {@link ICopyMechanism}.
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the ID of the chosen {@link ICopyMechanism}.
     * @return The ID of the {@link ICopyMechanism}.
     */
    public String getID() {
        return id;
    }

    /**
     * Setter for the {@link ICopyMechanism}.
     * @param copyMechansim The {@link ICopyMechanism} which is currently selected.
     */
    public void setCopyMechanism(ICopyMechanism copyMechansim) {
        id = copyMechansim.getID();
        name = copyMechansim.getName();
    }
    
    /**
     * Setter for the {@link ICopyMechanism}.
     * @param copyMechansimID The ID for an {@link ICopyMechanism}, which is currently selected.
     */
    public void setCopyMechanism(String copyMechansimID) {
        ICopyMechanism mechanism = CopyMechansimRegistry.INSTANCE.getCopyMechanism(copyMechansimID);
        if (null != mechanism) {
            setCopyMechanism(mechanism);
        }
    }
    
    /**
     * Getter for the selected {@link ICopyMechanism}.
     * @return The {@link ICopyMechanism} which is stored in this model.
     */
    public ICopyMechanism getCopyMechanism() {
        return CopyMechansimRegistry.INSTANCE.getCopyMechanism(id);
    }
}
