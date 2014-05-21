package de.uni_hildesheim.sse.easy.ui.internal;

import java.util.Iterator;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;

import de.uni_hildesheim.sse.easy_producer.core.mgmt.PLPInfo;
import de.uni_hildesheim.sse.easy_producer.core.mgmt.VilArgumentProvider;
import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration;
import de.uni_hildesheim.sse.easy_producer.core.persistence.Configuration.PathKind;
import de.uni_hildesheim.sse.easy_producer.instantiator.model.execution.Executor;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;

/**
 * Implements a frontend for EASy-specific Eclipse preference store values.
 * 
 * @author Holger Eichelberger
 */
public class EASyPreferenceStore {

    /**
     * Returns the actual preferences.
     * 
     * @return the preferences
     */
    private static IEclipsePreferences getPreferences() {
        IEclipsePreferences prefs = InstanceScope.INSTANCE.getNode(Activator.PLUGIN_ID);
        try {
            prefs.sync();
        } catch (BackingStoreException e) {
            EASyLoggerFactory.INSTANCE.getLogger(EASyPreferenceStore.class, Activator.PLUGIN_ID).exception(e);
        }
        return prefs;
    }
    
    /**
     * Returns the key used for a path kind.
     * 
     * @param kind the path kind to return the key for
     * @return the key
     */
    private static String getKey(PathKind kind) {
        return "path." + kind.name();
    }
    
    /**
     * Persists the default configuration into the preference store. All constants defined
     * in {@link PathKind} will be considered.
     */
    public static void persistDefaultConfiguration() {
        IEclipsePreferences prefs = getPreferences();
        for (PathKind kind : Configuration.PathKind.values()) {
            prefs.put(getKey(kind), Configuration.DEFAULT.getPath(kind));    
        }
        flush(prefs);
    }
    
    /**
     * Flushes (and saves) the given preferences object.
     * 
     * @param prefs the preferences to be flushed
     */
    private static void flush(IEclipsePreferences prefs) {
        try {
            prefs.flush();
        } catch (BackingStoreException e) {
            EASyLoggerFactory.INSTANCE.getLogger(EASyPreferenceStore.class, Activator.PLUGIN_ID).exception(e);
        }
        
    }
    
    /**
     * Loads the default configuration from the preference store. Values in {@link Configuration#DEFAULT}
     * are only overwritten if actual values are given in the preference store. All constants defined
     * in {@link PathKind} will be considered.
     */
    public static void loadDefaultConfiguration() {
        IEclipsePreferences prefs = getPreferences();
        for (PathKind kind : Configuration.PathKind.values()) {
            String path = prefs.get(getKey(kind), null);
            if (null != path && !path.isEmpty()) {
                Configuration.DEFAULT.setPathDirect(kind, path);
            }
        }
    }
    
    /**
     * Returns the key for the free arguments of a VIL argument provider.
     * 
     * @param provider the provider
     * @return the key
     */
    private static final String getArgumentsKey(VilArgumentProvider provider) {
        return provider.getClass().getName() + ".args";
    }

    /**
     * Returns the key for the state of a VIL argument provider.
     * 
     * @param provider the provider
     * @return the key
     */
    private static final String getStateKey(VilArgumentProvider provider) {
        return provider.getClass().getName() + ".active";
    }
    
    /**
     * Stores the state of all VIL argument providers.
     */
    public static void persistVilArgumentProviderStates() {
        IEclipsePreferences prefs = getPreferences();
        Iterator<VilArgumentProvider> iter = VilArgumentProvider.instances();
        while (iter.hasNext()) {
            VilArgumentProvider provider = iter.next();
            prefs.putBoolean(getStateKey(provider), provider.isActive());
            if (provider.acceptsFreeArguments()) {
                String args = provider.getFreeArguments();
                if (null == args) {
                    args = "";
                }
                prefs.put(getArgumentsKey(provider), args);
            }
        }
        flush(prefs);
    }
    
    /**
     * Loads the state of all VIL argument providers.
     */
    public static void loadVilArgumentProviderStates() {
        IEclipsePreferences prefs = getPreferences();
        Iterator<VilArgumentProvider> iter = VilArgumentProvider.instances();
        while (iter.hasNext()) {
            VilArgumentProvider provider = iter.next();
            provider.setActive(prefs.getBoolean(getStateKey(provider), true));
            String args = prefs.get(getArgumentsKey(provider), null);
            if (null != args) {
                provider.setFreeArguments(args);
            }
        }        
    }
}
