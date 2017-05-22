
package net.ssehub.easy.producer.ui.internal;

import java.util.Iterator;
import java.util.Locale;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;
import org.osgi.service.prefs.BackingStoreException;

import net.ssehub.easy.basics.DefaultLocale;
import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.producer.core.mgmt.VilArgumentProvider;
import net.ssehub.easy.producer.core.persistence.Configuration;
import net.ssehub.easy.producer.core.persistence.Configuration.PathKind;
import net.ssehub.easy.reasoning.core.frontend.ReasonerFrontend;
import net.ssehub.easy.reasoning.core.reasoner.ReasonerDescriptor;
import net.ssehub.easy.varModel.persistency.AbstractVarModelWriter;

/**
 * Implements a frontend for EASy-specific Eclipse preference store values.
 * 
 * @author Holger Eichelberger
 * @author Niko Nowatzki
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
     * Loads default information on startup. To be called by an activator.
     */
    public static void loadOnStart() {
        loadDefaultConfiguration();
        loadVilArgumentProviderStates();
        loadIvmlPreferences();
        ReasonerDescriptor desc = getDefaultReasoner();
        if (null != desc) {
            ReasonerFrontend.getInstance().setReasonerHint(desc);
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
    
    /**
     * Loads the properties for indentation.
     */
    public static void loadIvmlPreferences() {
        try {
            AbstractVarModelWriter.setIndentStep(getIvmlIndentStep());
            AbstractVarModelWriter.setUseIvmlWhitespace(getUseIvmlWhitespace());
        } catch (NullPointerException e) {
            AbstractVarModelWriter.setIndentStep(4);
            AbstractVarModelWriter.setUseIvmlWhitespace(true);
            setIvmlPrefs(4, true);
        }
        AbstractVarModelWriter.setOclCompliance(getOclCompliance());
        DefaultLocale.setDefaultLocale(getDefaultLocale());
    }
    
    /**
     * Save the indentation and the permission of whitespaces in preferences.
     * 
     * @param indentStep Amount of spaces for indentation.
     * @param useWhitespaces true - whitespaces are allowed.
     *                    false - whitespaces are not allowed.
     */
    public static void setIvmlPrefs(int indentStep, boolean useWhitespaces) {
        IEclipsePreferences prefs = getPreferences();
        prefs.putInt("ivml.indent", indentStep);
        prefs.putBoolean("ivml.useWhitespaces", useWhitespaces);
        flush(prefs);
    }
    
    /**
     * Get the indentation.
     * @return indent the stored indentation.
     */
    public static int getIvmlIndentStep() {
        return getPreferences().getInt("ivml.indent", 4);
    }
    
    /**
     * Get to know whether tabs are allowed or not.
     * @return useWhitespaces Returns true - whitespaces are allowed.
     *                             false - whitespaces are not allowed.
     */
    public static boolean getUseIvmlWhitespace() {
        return getPreferences().getBoolean("ivml.useWhitespaces", false);
    }

    /**
     * Returns whether OCL compliance settings shall be enabled.
     * 
     * @return <code>true</code> for OCL compliance settings, <code>false</code> (default) else
     */
    public static boolean getOclCompliance() {
        return getPreferences().getBoolean("easy.oclCompliance", false);
    }
    
    /**
     * Returns the default locale from preferences.
     * 
     * @return the default locale
     */
    public static Locale getDefaultLocale() {
        String tmp = getPreferences().get("easy.oclLocale", getInitialLocaleAsString());
        return DefaultLocale.toLocale(tmp);
    }
    
    /**
     * Returns the default locale as string.
     * 
     * @return the default locale
     */
    public static String getDefaultLocaleAsString() {
        return DefaultLocale.toString(getDefaultLocale());
    }
    
    /**
     * Changes the default locale.
     * 
     * @param loc the textual description for the default locale (ignored if <b>null</b> or empty)
     */
    public static void setDefaultLocale(String loc) {
        if (null != loc && !loc.isEmpty()) {
            getPreferences().put("easy.oclLocale", loc);
            Locale l = DefaultLocale.toLocale(loc);
            DefaultLocale.setDefaultLocale(l);
        }
    }

    /**
     * Returns the initial locale as string.
     * 
     * @return the initial locale
     */
    public static String getInitialLocaleAsString() {
        return DefaultLocale.toString(DefaultLocale.INITIAL_LOCALE);
    }

    /**
     * Defines the actual OCL compliance state for EASy-Producer.
     * 
     * @param compliance the compliance state (default <code>false</code>, i.e., no compliance checking)
     */
    public static void setOclCompliance(boolean compliance) {
        getPreferences().putBoolean("easy.oclCompliance", compliance);
        AbstractVarModelWriter.setOclCompliance(compliance);
    }

    /**
     * Sets the default reasoner. Propagates the default reasoner into the reasoner frontend.
     * 
     * @param desc the new default reasoner (may be <b>null</b> to clear the default reasoner) 
     */
    public static void setDefaultReasoner(ReasonerDescriptor desc) {
        IEclipsePreferences prefs = getPreferences();
        if (null == desc) {
            prefs.remove("easy.reasoner");
        } else {
            prefs.put("easy.reasoner", desc.getClass().getName());
            ReasonerFrontend.getInstance().setReasonerHint(desc);
        }
        flush(prefs);        
    }
    
    /**
     * Returns the default reasoner via the preferences store.
     * 
     * @return the default reasoner (may be <b>null</b> if no default reasoner is selected)
     */
    public static ReasonerDescriptor getDefaultReasoner() {
        ReasonerDescriptor result = null;
        IEclipsePreferences prefs = getPreferences();
        String defltReasonerClass = prefs.get("easy.reasoner", null);
        if (null != defltReasonerClass) {
            ReasonerFrontend frontend = ReasonerFrontend.getInstance();
            for (int r = 0; r < frontend.getReasonersCount(); r++) {
                ReasonerDescriptor desc = frontend.getReasonerDescriptor(r);
                if (desc.getClass().getName().equals(defltReasonerClass)) {
                    result = desc;
                }
            }
        }
        return result;
    }
}
