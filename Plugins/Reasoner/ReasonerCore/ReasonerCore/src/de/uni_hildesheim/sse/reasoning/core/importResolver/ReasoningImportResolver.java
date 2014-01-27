package de.uni_hildesheim.sse.reasoning.core.importResolver;

import java.net.URI;
import java.util.List;

import de.uni_hildesheim.sse.model.management.VarModel;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.reasoning.core.Bundle;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;
import de.uni_hildesheim.sse.utils.messages.IMessage;
import de.uni_hildesheim.sse.utils.modelManagement.IModelRepository;
import de.uni_hildesheim.sse.utils.modelManagement.ImportResolver;
import de.uni_hildesheim.sse.utils.modelManagement.ModelInfo;
import de.uni_hildesheim.sse.utils.modelManagement.ModelPaths;

/**
 * A project imports resolver. Don't store information in attributes!
 * 
 * @author Holger Eichelberger
 */
public class ReasoningImportResolver extends ImportResolver<Project> {

    /**
     * Creates a resolver instance.
     * 
     * @param parent parent resolver
     */
    private ReasoningImportResolver(ImportResolver<Project> parent) {
        super(parent);
        EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID);
        logger.info("ReasonerCore.DefaultImportResolver chained");
    }
    
    /**
     * Registers this resolver as top-level resolver.
     */
    public static final void registerAsTopResolver() {
        if (canBeNewTopLevelResolver(ReasoningImportResolver.class, VarModel.getResolver())) {
            new ReasoningImportResolver(VarModel.getResolver());
        }
    }
    
    @Override
    protected List<IMessage> resolveImportsImpl(Project project, URI uri, List<ModelInfo<Project>> inProgress, 
        IModelRepository<Project> repository, ModelPaths paths) {
        return null; // jump over this until a reasoning based mechanism is introduced
    }

    @Override
    protected ImportResolver<Project> getTopResolver() {
        return VarModel.getResolver();
    }

    @Override
    protected void setTopResolver(ImportResolver<Project> resolver) {
        VarModel.setResolver(resolver);
    }

}
