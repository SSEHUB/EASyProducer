package de.uni_hildesheim.sse.easy_producer.instantiator.model.templateModel;

import net.ssehub.easy.basics.modelManagement.DefaultImportResolver;
import net.ssehub.easy.basics.modelManagement.ImportResolver;
import net.ssehub.easy.basics.modelManagement.ModelManagement;

/**
 * Provides mechanisms for loading, linking, referring, searching and storing template models
 * according to their name, their version and their location. The name was chosen according
 * to the established naming in the variability model implementation.
 * 
 * @author Holger Eichelberger
 */
public class TemplateModel extends ModelManagement<Template> {

    /**
     * Stores the singleton instance.
     */
    public static final TemplateModel INSTANCE = new TemplateModel();

    /**
     * Singleton.
     */
    private TemplateModel() {
    }

    @Override
    protected ImportResolver<Template> createResolver() {
        return new DefaultImportResolver<Template>();
    }

}
