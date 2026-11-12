package net.ssehub.easy.instantiation.yaml;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * This class contains methods for editing configuration files.
 * 
 * @author Aike Sass
 *
 */
public class YamlEditor {
    
    private Map<Object, Object> data;
    
    /**
     *  Thread-safe singleton.
     * @author Aike Sass
     */
    private static final class InstanceHolder {
        static final YamlEditor INSTANCE = new YamlEditor();
    }

    /**
     * Private constructor.
     */
    private YamlEditor() {
    }

    /**
     * Gets the instance of {@link InstanceHolder}.
     * @return Instance of {@link InstanceHolder}
     */
    public static YamlEditor getInstance() {
        return InstanceHolder.INSTANCE;
    }
    
    /**
     * Updates an entry. Does not save the entries to the file system.
     * 
     * @param file The configuration file
     * @param key The key in the configuration file
     * @param value The value for the key
     * @throws IOException exception
     */
    public void updateEntry(File file, Object key, Object value) throws IOException {
        if (null == data) {
            data = YamlDeserializer.getInstance().loadFile(file);
        }
        data.put(key, value);
    }
    
    /**
     * Gets the value for a given key.
     * 
     * @param key The key in the configuration file
     * @param file The configuration file 
     * @return Object containing the values for the given key
     * @throws IOException exception
     */
    public Object getEntry(Object key, File file) throws IOException {
        if (null == data) {
            data = YamlDeserializer.getInstance().loadFile(file);
        }
        return data.get(key);
    }
    
    /**
     * Gets all key value pairs in the configuration file. Needs to be loaded first.
     * @return Map with all key value pairs as objects
     */
    public Map<Object, Object> getData() {
        return data;
    }
    
    /**
     * Reloads the configuration from the file system.
     * @param file The configurationfile
     * @throws IOException exception
     */
    public void refreshData(File file) throws IOException {
        data = YamlDeserializer.getInstance().loadFile(file);
    }

}
