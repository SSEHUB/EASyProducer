package de.uni_hildesheim.sse.easy.instantiator.copy.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uni_hildesheim.sse.easy.instantiator.copy.core.internal.NormalCopyMechanism;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;


/**
 * The CopyMechansimRegistry provides a global registry for all supported {@link AbstractCopyMechanism}s.
 * @author El-Sharkawy
 *
 */
public class CopyMechansimRegistry {
    
    /**
     * The singleton instance of this class.
     */
    public static final CopyMechansimRegistry INSTANCE = new CopyMechansimRegistry();
    
    private static final EASyLogger LOGGER = EASyLoggerFactory.INSTANCE.getLogger(CopyMechansimRegistry.class,
        "de.uni_hildesheim.sse.easy.instantiator.copy.core");
    
    private String defaultId = NormalCopyMechanism.ID;
    private IResourceMgmt resMgmt = null;
    private Map<String, AbstractCopyMechanism> copyMechanisms = new HashMap<String, AbstractCopyMechanism>();
    
    /**
     * Registers a new {@link AbstractCopyMechanism} to this registry.
     * @param copyMechanism The {@link AbstractCopyMechanism} it self, which should be registered.
     */
    public void register(AbstractCopyMechanism copyMechanism) {
        LOGGER.info("New CopyMechanism registered: " + copyMechanism.getID());
        copyMechanisms.put(copyMechanism.getID(), copyMechanism);
        copyMechanism.setResourceMgmt(resMgmt);
    }
    
    /**
     * Setter for for the {@link IResourceMgmt}, sets also the {@link IResourceMgmt} of all registered
     * {@link AbstractCopyMechanism}s.
     * @param resMgmt The new abstraction layer for file system/project operations
     */
    public void setResourceMgmt(IResourceMgmt resMgmt) {
        this.resMgmt = resMgmt;
        for (AbstractCopyMechanism copyMechanism : copyMechanisms.values()) {
            copyMechanism.setResourceMgmt(resMgmt);
        }
    }
    
    /**
     * Returns the {@link ICopyMechanism} to which the specified <tt>mechanismID</tt> is mapped,
     * or {@link NormalCopyMechanism} if this map contains no mapping for the <tt>mechanismID</tt>.
     *
     * @param mechanismID the <tt>mechanismID</tt> whose associated {@link ICopyMechanism} is to be returned
     * @return The {@link ICopyMechanism} to which the specified <tt>mechanismID</tt> is mapped, or
     * the {@link NormalCopyMechanism} if this registry contains no {@link ICopyMechanism} for the
     * <tt>mechanismID</tt>
     */
    public ICopyMechanism getCopyMechanism(String mechanismID) {
        ICopyMechanism copyMechanism = copyMechanisms.get(mechanismID);
        if (null == copyMechanism) {
            copyMechanism = getDefaultCopyMechanism();
        }
        
        return copyMechanisms.get(mechanismID);
    }
    
    /**
     * Returns a default CopyMechanism, which can be used if no other was found.
     * @return {@link NormalCopyMechanism}.
     */
    public ICopyMechanism getDefaultCopyMechanism() {
        return getCopyMechanism(defaultId);
    }
    
    /**
     * Returns a list of all available copy mechanisms.
     * @return A list of 2-tuples (name, id) for all available copy mechanisms.
     */
    public List<String[]> getMechnisms() {
        List<String[]> allMechanisms = new ArrayList<String[]>();
        for (ICopyMechanism copyMechanism : copyMechanisms.values()) {
            String name = copyMechanism.getName();
            String id = copyMechanism.getID();
            allMechanisms.add(new String[]{name, id});
        }
        
        return allMechanisms;
    }

    /**
     * Changes the default copy mechanism id. Please note that the default ID is only
     * overtaken if the related mechanism is already registered.
     * 
     * @param defaultId the new default id (may be <b>null</b> but <b>null</b> is ignored)
     */
    public void setDefaultID(String defaultId) {
        if (null != defaultId && null != copyMechanisms.get(defaultId)) {
            this.defaultId = defaultId;
        }
    }
}
