package de.uni_hildesheim.sse.easy_producer.instantiator.model.vilTypes;

import java.io.File;
import java.util.Map;

import de.uni_hildesheim.sse.easy_producer.instantiator.model.artifactModel.ProjectSettings;

/**
 * 
 * Interface to initialize settings.
 * 
 * @author Aike Sass
 *
 */
public interface ISettingsInitializer {

    /**
     * Initializes a project with a given map of settings.
     * 
     * @param base  Project to be initialized
     * @param settings the settings for the project
     */
    void initialize(File base, Map<ProjectSettings, Object> settings);

}
