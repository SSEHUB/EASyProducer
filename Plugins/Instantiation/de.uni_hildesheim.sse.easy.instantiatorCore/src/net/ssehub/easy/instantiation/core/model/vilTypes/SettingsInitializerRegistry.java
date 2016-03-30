package net.ssehub.easy.instantiation.core.model.vilTypes;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.artifactModel.ProjectSettings;

/**
 * Implementation of {@link ISettingsInitializer}.
 * 
 * @author Aike Sass
 *
 */
public class SettingsInitializerRegistry {
    
    private static List<ISettingsInitializer> settingsInitializer = new ArrayList<ISettingsInitializer>();
    
    /**
     * Register the interface.
     * 
     * @param initializer the interface to be registered
     */
    public static void register(ISettingsInitializer initializer) {
        settingsInitializer.add(initializer);
    }
    
    /**
     * Initializes all settings.
     * 
     * @param base  the project to be initialized.
     * @return  Map with settings
     */
    public static java.util.Map<ProjectSettings, Object> initializeSettings(File base) {
        java.util.Map<ProjectSettings, Object> settings = new HashMap<ProjectSettings, Object>();
        for (ISettingsInitializer initializer : settingsInitializer) {
            initializer.initialize(base, settings);
        }
        return settings;
    }

}
