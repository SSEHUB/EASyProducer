package de.uni_hildesheim.sse.utils.modelManagement;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import de.uni_hildesheim.sse.utils.messages.IMessage;
import de.uni_hildesheim.sse.utils.messages.Message;
import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * A model imports resolver. Don't store information in attributes!
 * 
 * @param <M> the specific model type
 * 
 * @author Holger Eichelberger
 */
public abstract class DefaultImportResolver<M extends IModel> extends ImportResolver<M> {

    /** 
     * (De-)Activates the untested import validation code.
     */
    private static boolean patricksTestFlagIsActive = false;

    /**
     * Creates the resolver instance.
     */
    protected DefaultImportResolver() {
        super();
    }
    
    @Override
    protected List<IMessage> resolveImportsImpl(M model, URI uri, List<ModelInfo<M>> inProgress, 
        IModelRepository<M> repository, ModelPaths paths) {
        List<IMessage> messages = new ArrayList<IMessage>();
        ResolutionContext<M> context = new ResolutionContext<M>(model, uri, inProgress, repository, paths);
        resolveImports(context, new HashSet<M>(), messages);
        return messages;
    }
    
    /**
     * Resolves the imports of the model in the given <code>context</code> and returns
     * messages on failures. Exceptions might be appropriate here but the
     * caller shall be able to decide how to handle the level of detail, i.e.
     * whether the first message shall be emitted or all.
     * 
     * @param context the context of the models to be resolved
     * @param done for detecting cyclic imports (modified as a side effect)
     * @param messages which occur during resolution, <code>null</code> or empty 
     *   if none (modified as a side effect)
     */
    private void resolveImports(ResolutionContext<M> context, HashSet<M> done, List<IMessage> messages) {
        M model = context.getModel();
        if (done.contains(model)) {
            String ver;
            if (null == model.getVersion()) {
                ver = "";
            } else {
                ver = " version '" + model.getVersion().getVersion() + "'";
            }
            messages.add(new Message("Cyclic import with '" 
                + model.getName() + ver + ". Importing stopped here.", Status.ERROR));
        } else {
            for (int i = 0; i < model.getImportsCount(); i++) {
                @SuppressWarnings("unchecked")
                ModelImport<M> imp = (ModelImport<M>) model.getImport(i);
                if (null == imp.getResolved()) {
                    context.setToResolve(imp);
                    // currently unresolved
                    resolve(context, done, messages);
                }
            }
            if (null != model.getSuper()) {
                @SuppressWarnings("unchecked")
                ModelImport<M> imp = (ModelImport<M>) model.getSuper();
                if (null == imp.getResolved()) {
                    context.setToResolve(imp);
                    // currently unresolved
                    resolve(context, done, messages);
                }
            }
        }
    }
    
    /**
     * Resolves the import represented by <code>context</code> with already known model information.
     * 
     * @param context the import context
     * @param done for detecting cyclic imports (modified as a side effect)
     * @param messages which occur during resolution, <code>null</code> or empty 
     *   if none (modified as a side effect)
     * @param versions the already known and matching model information objects
     */
    private void resolve(ResolutionContext<M> context, HashSet<M> done, List<IMessage> messages, 
        List<VersionedModelInfos<M>> versions) {
        ModelImport<M> imp = context.getToResolve();
        // TODO HE: here goes patrickJ
        // @patrickJ this part does not throw exceptions as all problems are collected in a message
        // list and handled by the caller.
        
        if (patricksTestFlagIsActive) {

            IModelRepository<M> repository = context.getModelRepository();
            ArrayList<ModelInfo<M>> modelImportList;
            ImportValidation<M> importValidator = new ImportValidation<M>(repository, messages);
            modelImportList = importValidator.validateModel(context);
            ModelInfo<M> toLoad = null;
            
            if (importValidator.wasSuccessful()) {

                for (ModelInfo<M> modelInfo : modelImportList) {
                    if (modelInfo.getName().compareTo(imp.getName()) == 0) {
                        toLoad = modelInfo;
                    }
                }
            } else {
                toLoad = null;
            }
            if (null != toLoad) {
                M found = toLoad.getResolved();
                if (null == found || repository.isOutdated(toLoad)) { // do not use is actual here!
                    if (!context.isLoop(toLoad)) {
                        found = repository.load(toLoad, messages);
                    } else {
                        messages.add(new Message("model '" + imp.getName()
                                + "' cannot be resolved here due to errors in the imported model", Status.ERROR));
                    }
                }
                if (null != found) {
                    if (checkImported(imp, found, messages)) {
                        try {
                            imp.setResolved(found);
                        } catch (ModelManagementException e) {
                            messages.add(new Message(e.getMessage(), Status.ERROR));
                        }
                    }
                    resolveImports(new ResolutionContext<M>(found, toLoad.getLocation(), context), done, messages);
                }
            } else {
                messages.add(new Message("model '" + imp.getName() + "' cannot be found", Status.ERROR));
            }
            
        } else { // TODO: Delete, if my (=Patrick) method is working
            oldMechanismWithoutImportValidation(context, done, messages, versions, imp); 
        }    
    }

    /**
     * This method is only run, if the testflag is inactive. <=> backup
     * @param context the import context
     * @param done for detecting cyclic imports (modified as a side effect)
     * @param messages which occur during resolution, <code>null</code> or empty 
     *   if none (modified as a side effect)
     * @param versions the already known and matching model information objects
     * @param imp the import to be resolved
     */
    private void oldMechanismWithoutImportValidation(ResolutionContext<M> context, HashSet<M> done,
            List<IMessage> messages, List<VersionedModelInfos<M>> versions, ModelImport<M> imp) {
        // TODO CK: currently, as a fall-back mechanism!
        // currently we just pick the first one according to the URI
        URI contextURI = context.getModelURI();
        ModelInfo<M> toLoad = versions.get(0).getByClosestUri(contextURI, context.getModelPaths());
        // is it already loaded?
        //boolean isLoop = false;
        if (null != toLoad) {
            IModelRepository<M> repository = context.getModelRepository();
            M found = toLoad.getResolved();
            if (null == found || repository.isOutdated(toLoad)) { // do not use is actual here!
                if (!context.isLoop(toLoad)) {
                    found = repository.load(toLoad, messages);
                } else {
                    messages.add(new Message("model '" + imp.getName() 
                        + "' cannot be resolved here due to errors in the imported model", 
                        Status.ERROR));                    
                }
            }
            if (null != found) {
                if (checkImported(imp, found, messages)) {
                    try {
                        imp.setResolved(found);
                    } catch (ModelManagementException e) {
                        messages.add(new Message(e.getMessage(), Status.ERROR));
                    }
                }
                resolveImports(new ResolutionContext<M>(found, toLoad.getLocation(), context), done, messages);
            }
        } else {
            messages.add(new Message("model '" + imp.getName() 
                + "' cannot be found", Status.ERROR));
        }
    }

    /**
     * Checks the imported interfaces for obvious import problems, such as importing models
     * with interfaces as a whole.
     * 
     * @param imp the import to be resolved
     * @param model the model which may resolve the import
     * @param messages which occur during resolution, <code>null</code> or empty 
     *   if none (modified as a side effect)
     * @return <code>true</code> if the import is fine, <code>true</code> if problems were detected
     */
    protected boolean checkImported(ModelImport<M> imp, M model, List<IMessage> messages) {
        return true;
    }

    /**
     * Resolves the import represented by <code>context</code>.
     * 
     * @param context the context to resolve (including the import to resolve)
     * @param done for detecting cyclic imports (modified as a side effect)
     * @param messages which occur during resolution, <code>null</code> or empty 
     *   if none (modified as a side effect)
     */
    private void resolve(ResolutionContext<M> context, HashSet<M> done, List<IMessage> messages) {
        ModelImport<M> imp = context.getToResolve();
        if (null == imp.getResolved()) {
            List<VersionedModelInfos<M>> versions = context.getModelRepository().getAvailable(imp.getName());
            if (null != versions && versions.size() > 0) {
                resolve(context, done, messages, versions);
            } else {
                messages.add(new Message("model '" + imp.getName() 
                    + "' cannot be found", Status.ERROR));
            }
        }
    }

}
