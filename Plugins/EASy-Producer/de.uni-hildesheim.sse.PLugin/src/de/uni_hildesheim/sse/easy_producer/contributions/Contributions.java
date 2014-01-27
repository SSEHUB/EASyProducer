package de.uni_hildesheim.sse.easy_producer.contributions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;

import de.uni_hildesheim.sse.easy_producer.persistence.mgmt.PLPInfo;

/**
 * For contributions to the EASY core. (preliminary, to be aligned with self-bootstrapping 
 * capabilities in future)
 * Please do not change the name or the location of this class as it is populated via OSGI-DS.
 * 
 * @author Holger Eichelberger
 */
public abstract class Contributions {

    /**
     * Denotes individual core functions.
     * 
     * @author Holger Eichelberger
     */
    public enum CoreFunction {
        
        /**
         * The button for deriving PL members.
         */
        DERIVE_NEW_MEMBER(true),
        
        /**
         * The button for pulling the configuration.
         */
        PULL_CONFIGURATION(true);
        
        /**
         * Stores the default behavior if no contribution is present.
         */
        private boolean enabled;
        
        /**
         * Creates a new UI element constant.
         * 
         * @param enabled the default behavior if no contribution is present
         */
        private CoreFunction(boolean enabled) {
            this.enabled = enabled;
        }
        
        /**
         * Returns the default behavior of no contribution is present.
         * 
         * @return the default behavior
         */
        public boolean getEnabled() {
            return enabled;
        }

        /**
         * Combines two enabled values.
         * @param val1 the first value
         * @param val2 the second value
         * @return the combined result
         */
        boolean combine(boolean val1, boolean val2) {
            boolean result;
            if (enabled) {
                result = val1 & val2;
            } else {
                result = val1 | val2;
            }
            return result;
        }
    }

    
    /**
     * Stores the registered UI contributions.
     */
    private static final List<Contributions> REGISTERED = new ArrayList<Contributions>();
    
    /**
     * Registers a particular contribution.
     * 
     * @param contribution the new contribution
     */
    public static synchronized void register(Contributions contribution) {
        if (null == contribution) {
            throw new IllegalArgumentException("null");
        }
        REGISTERED.add(contribution);
    }

    /**
     * Unregisters a particular contribution.
     * 
     * @param contribution the contribution to be unregisted
     */
    public static synchronized void unregister(Contributions contribution) {
        if (null == contribution) {
            throw new IllegalArgumentException("null");
        }
        REGISTERED.remove(contribution);
    }
    
    /**
     * Returns whether the specified UI element is enabled (at least one
     * contribution must request this).
     * 
     * @param element the UI element 
     * @return <code>true</code> if it shall be enabled, <code>false</code> else
     */
    public static final synchronized boolean isEnabled(CoreFunction element) {
        boolean enabled = element.getEnabled();
        for (int c = 0; c < REGISTERED.size(); c++) {
            enabled = element.combine(enabled, REGISTERED.get(c).isEnabledImpl(element));
        }
        return enabled;
    }

    /**
     * Returns whether this contribution requires that the given core function shall be enabled.
     * 
     * @param coreFunction the core function descriptor
     * @return <code>true</code> if it shall be enabled, <code>false</code> else
     */
    protected abstract boolean isEnabledImpl(CoreFunction coreFunction);

    
    /**
     * Determines the most appropriate EASy configuration path.
     * 
     * @param project the project to determine the configuration path for
     * @return the configuration path or <b>null</b> if there is no suggestion
     */
    public static String determineEasyConfigPath(IProject project) {
        String result = null;
        for (int c = 0; null == result && c < REGISTERED.size(); c++) {
            result = REGISTERED.get(c).determineEasyConfigPathImpl(project);
        }
        return result;
    }
    
    /**
     * Determines the EASy configuration path from the given <code>project</code>.
     * 
     * @param project the project to consider
     * @return the relative configuration path or <b>null</b> if no path shall be suggested
     */
    protected abstract String determineEasyConfigPathImpl(IProject project);

    /**
     * Initializes a recently created PLP.
     * 
     * @param project the physical project the PLP is located in
     * @param plp the PLP to be initialized
     * @param plps information about predecessor PLPs (to be modified as a side effect)
     * @throws IOException in case of any IO related problems
     */
    public static void initializePLP(IProject project, PLPInfo plp, List<PLPInfo> plps) throws IOException {
        for (int c = 0; c < REGISTERED.size(); c++) {
            REGISTERED.get(c).initializePLPImpl(project, plp, plps);
        }
    }
    
    /**
     * Initializes a recently created PLP.
     * 
     * @param project the physical project the PLP is located in
     * @param plp the PLP to be initialized
     * @param plps information about predecessor PLPs (to be modified as a side effect)
     * @throws IOException in case of any IO related problems
     */
    protected abstract void initializePLPImpl(IProject project, PLPInfo plp, List<PLPInfo> plps) 
        throws IOException;
    
    /**
     * Returns the default copy mechanism ID.
     * 
     * @return the default copy mechanism ID, use EASy default if <b>null</b>
     */
    protected abstract String getDefaultCopyMechanismIDImpl();
    
    /**
     * Returns the default copy mechanism ID.
     * 
     * @return the default copy mechanism ID, use EASy default if <b>null</b>
     */
    public static final synchronized String getDefaultCopyMechanismID() {
        String result = null;
        for (int c = 0; null == result && c < REGISTERED.size(); c++) {
            result = REGISTERED.get(c).getDefaultCopyMechanismIDImpl();
        }
        return result;
    }

}
