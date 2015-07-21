package de.uni_hildesheim.sse.persistency.xml;

import java.util.ArrayList;
import java.util.List;

/**
 * Extension to activate the serialization of runtime VIL files.
 * 
 * @author Sass
 *
 */
public class Extensions {
    
    private static List<ISerializerPlugin<?>> pluginList = new ArrayList<ISerializerPlugin<?>>();
    
    /**
     * Register the plug-in.
     * 
     * @param plugin    The plug-in to be registered
     */
    public static void register(ISerializerPlugin<?> plugin) {
        pluginList.add(plugin);
    }
    
    /**
     * Getter for the plug-in list.
     * 
     * @return list with all plug-ins
     */
    public static Iterable<ISerializerPlugin<?>> getPluginList() {
        return pluginList;
    }

}
