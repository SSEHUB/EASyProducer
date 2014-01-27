package de.uni_hildesheim.sse.easy_producer.persistence.mgmt;

import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.Executor;

/**
 * An argument provider for VIL execution. This class provides an extension point for EASy plugins.
 * 
 * @author Holger Eichelberger
 */
public abstract class VilArgumentProvider {
    
    private static List<VilArgumentProvider> instances = new ArrayList<VilArgumentProvider>();
    
    /**
     * Adds an argument provider.
     * 
     * @param provider the argument provider to be added
     */
    public static void add(VilArgumentProvider provider) {
        if (null != provider) {
            instances.add(provider);
        }
    }

    /**
     * Removes an argument provider.
     * 
     * @param provider the argument provider to be removed
     */
    public static void remove(VilArgumentProvider provider) {
        if (null != provider) {
            instances.remove(provider);
        }
    }
    
    /**
     * Provides arguments via the registered argument providers.
     * 
     * @param plp the PLP to add arguments for
     * @param executor the executor to be provided with arguments
     */
    public static void provideArguments(PLPInfo plp , Executor executor) {
        for (VilArgumentProvider provider : instances) {
            provider.provideArgumentsImpl(plp, executor);
        }
    }
    
    /**
     * Actually provides the arguments for <code>executor</code>.
     * 
     * @param plp the PLP to add arguments for
     * @param executor the executor to be provided with arguments
     */
    protected abstract void provideArgumentsImpl(PLPInfo plp, Executor executor);

}
