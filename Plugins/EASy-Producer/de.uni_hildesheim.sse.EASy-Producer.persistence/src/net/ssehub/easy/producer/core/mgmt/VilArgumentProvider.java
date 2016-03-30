package net.ssehub.easy.producer.core.mgmt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.execution.Executor;

/**
 * An argument provider for VIL execution. This class provides an extension point for EASy plugins.
 * 
 * @author Holger Eichelberger
 */
public abstract class VilArgumentProvider {
    
    private static List<VilArgumentProvider> instances = new ArrayList<VilArgumentProvider>();
    private boolean active = true;
    
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
     * Returns the number of providers.
     * 
     * @return the number of providers
     */
    public static int getProviderCount() {
        return instances.size();
    }
    
    /**
     * Returns the provider specified by the given index.
     * 
     * @param index the 0-based index of the provider to return
     * @return the provider
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getProviderCount()}</code>
     */
    public static VilArgumentProvider getProvider(int index) {
        return instances.get(index);
    }
    
    /**
     * Returns all registered instances as an iterator.
     * 
     * @return all provider instances
     */
    public static Iterator<VilArgumentProvider> instances() {
        return instances.iterator();
    }
    
    /**
     * Actually provides the arguments for <code>executor</code>.
     * 
     * @param plp the PLP to add arguments for
     * @param executor the executor to be provided with arguments
     */
    protected abstract void provideArgumentsImpl(PLPInfo plp, Executor executor);
    
    /**
     * Returns the name(s) of the parameter(s) provided by this instance. The returned information
     * is just for displaying information to the user.
     * 
     * @return the name(s) of the parameters(s)
     */
    public abstract String getParameterName();

    /**
     * Returns the type(s) of the parameter(s) provided by this instance. The returned information
     * is just for displaying information to the user.
     * 
     * @return the type(s) of the parameters(s)
     */
    public abstract String getParameterType();
    
    /**
     * Returns the name of this provider. The returned information
     * is just for displaying information to the user.
     * 
     * @return the name of this provider
     */
    public abstract String getName();
    
    /**
     * Returns whether this provider accepts free arguments.
     * 
     * @return <code>true</code> if it accepts free arguments, <code>false</code> else
     * @see #setFreeArguments(String)
     * @see #getFreeArguments()
     */
    public abstract boolean acceptsFreeArguments();
    
    /**
     * Returns the free arguments used by this instance.
     *  
     * @return the free arguments or <b>null</b> or an empty string if there are none
     * @see #setFreeArguments(String)
     * @see #acceptsFreeArguments()
     */
    public abstract String getFreeArguments();
    
    /**
     * Defines the free arguments to be used by this instance.
     * 
     * @param arguments the arguments (in the format supported by this instance)
     * @see #acceptsFreeArguments()
     * @see #getFreeArguments()
     * */
    public abstract void setFreeArguments(String arguments);
    
    /**
     * Returns whether this provider is active.
     * 
     * @return <code>true</code> if it is active, <code>false</code> else
     */
    public boolean isActive() {
        return active;
    }
    
    /**
     * Changes the active state of this provider.
     * 
     * @param active <code>true</code> if this provider is active, <code>false</code> else
     */
    public void setActive(boolean active) {
        this.active = active;
    }

}
