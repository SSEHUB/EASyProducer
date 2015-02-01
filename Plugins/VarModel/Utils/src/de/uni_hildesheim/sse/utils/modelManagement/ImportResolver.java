/*
 * Copyright 2009-2013 University of Hildesheim, Software Systems Engineering
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.uni_hildesheim.sse.utils.modelManagement;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import de.uni_hildesheim.sse.utils.messages.IMessage;
import de.uni_hildesheim.sse.utils.messages.Message;
import de.uni_hildesheim.sse.utils.messages.Status;

/**
 * Resolves imports in models. New resolvers are created as chained resolvers
 * from the current resolver {@link #getTopResolver()}.
 * 
 * @param <M> the specific model type
 * 
 * @author Holger Eichelberger
 */
public abstract class ImportResolver<M extends IModel> {

    private static final String END_OF_CHAIN_MSG 
        = "imports are not resolved as no appropriate import resolver registered";
    private ImportResolver<M> subResolver = null;
    
    /**
     * The root constructor.
     */
    ImportResolver() {
    }
    
    /**
     * Creates a new import resolver which is chained with the given <code>parent</code>
     * resolver. If <code>parent</code> is {@link #getTopResolver()}, then this instance
     * will be the new top-level resolver
     * 
     * @param parent the parent resolver (must not be <b>null</b>)
     * @throws IllegalArgumentException if <code>parent == <b>null</b></code>
     */
    public ImportResolver(ImportResolver<M> parent) {
        if (null == parent) {
            throw new IllegalArgumentException("'parent' must not be null");
        }
        subResolver = parent;
        if (parent == getTopResolver()) {
            setTopResolver(this);
        }
    }
    
    /**
     * Returns the actual top-level resolver.
     * 
     * @return the actual top-level resolver
     */
    protected abstract ImportResolver<M> getTopResolver();

    /**
     * Changes the actual top-level resolver.
     * 
     * @param resolver the actual top-level resolver
     */
    protected abstract void setTopResolver(ImportResolver<M> resolver);
    
    /**
     * Returns whether the given resolver class is suitable to be added as new top-level resolver.
     * Basically, this method checks whether the same class is currently on top.
     * 
     * @param <T> the specific resolver class
     * @param newResolverClass the class to be checked
     * @param topLevel the current (relevant) top level resolver
     * @return <code>true</code> if <code>newResolverClass</code> is suitable, <code>false</code> else
     */
    protected static final <T extends ImportResolver<?>> boolean canBeNewTopLevelResolver(Class<T> newResolverClass, 
        ImportResolver<?> topLevel) {
        return (newResolverClass != topLevel.getClass());
    }
    
    /**
     * Returns the actual sub-resolver.
     * 
     * @return the sub-resolver (may be <b>null</b> at the end of the resolver chain)
     */
    public ImportResolver<M> getSubResolver() {
        return subResolver;
    }
        
    /**
     * Resolves the imports of the given <code>model</code> and returns
     * messages on failures. Exceptions might be appropriate here but the
     * caller shall be able to decide how to handle the level of detail, i.e.
     * whether the first message shall be emitted or all. May modify <code>model</code>
     * as a side effect.
     * 
     * @param model the model to be resolved
     * @param uri the URI of the model to resolve (in order to find the closest 
     *   model, may be <b>null</b>)
     * @param inProgress the model information objects of the models currently being 
     *   processed at once (may be <b>null</b>)  
     * @param repository the model repository
     * @param evaluationContext the context for evaluating import restrictions (variable definitions... 
     *   interpreted locally)
     * @return messages which occur during resolution
     */
    public final List<IMessage> resolveImports(M model, URI uri, List<ModelInfo<M>> inProgress, 
        IModelRepository<M> repository, IRestrictionEvaluationContext evaluationContext) {
        List<IMessage> result = resolveImportsImpl(model, uri, inProgress, repository, evaluationContext);
        if (null == result) {
            if (null == subResolver) {
                result = createEndOfChainMessage();
            } else {
                result = subResolver.resolveImports(model, uri, inProgress, repository, evaluationContext);
            }
        }
        return result;
    }

    /**
     * Resolves the denoted model considering the given <code>restrictions</code>.
     * 
     * @param modelName the name of the model
     * @param restriction the version restriction (may be <b>null</b> if there is none)
     * @param baseUri the URI to start resolving from (may be the URI of a model)
     * @param repository the model repository
     * @param evaluationContext the context for evaluating import restrictions (variable definitions... 
     *   interpreted locally)
     * @return the resolved model
     * @throws ModelManagementException in case of resolution failures
     */
    public final M resolve(String modelName, IVersionRestriction restriction, URI baseUri, 
        IModelRepository<M> repository, IRestrictionEvaluationContext evaluationContext) 
        throws ModelManagementException {
        M result = resolveImpl(modelName, restriction, baseUri, repository, evaluationContext);
        if (null == result) {
            if (null == subResolver) {
                throw new ModelManagementException(END_OF_CHAIN_MSG, ModelManagementException.INTERNAL);
            } else {
                result = subResolver.resolve(modelName, restriction, baseUri, repository, evaluationContext);
            }
        }
        return result;
    }

    /**
     * Resolves the imports of the given <code>model</code> and returns
     * messages on failures. Exceptions might be appropriate here but the
     * caller shall be able to decide how to handle the level of detail, i.e.
     * whether the first message shall be emitted or all. May modify <code>model</code>
     * as a side effect.
     * 
     * @param model the model to be resolved
     * @param uri the URI of the model to resolve (in order to find the closest 
     *   model, may be <b>null</b>)
     * @param inProgress the model information objects of the models currently being 
     *   processed at once (may be <b>null</b>)  
     * @param repository the model repository
     * @param evaluationContext the context for evaluating import restrictions (variable definitions... 
     *   interpreted locally)
     * @return messages which occur during resolution, <code>null</code> if this resolver is not 
     *   able to resolve the imports for some reason
     */
    protected abstract List<IMessage> resolveImportsImpl(M model, URI uri, List<ModelInfo<M>> inProgress, 
        IModelRepository<M> repository, IRestrictionEvaluationContext evaluationContext);

    /**
     * Resolves the denoted model considering the given <code>restrictions</code>.
     * 
     * @param modelName the name of the model
     * @param restrictions the restrictions (may be <b>null</b>
     * @param baseUri the URI to start resolving from (may be the URI of a model)
     * @param repository the model repository
     * @return the resolved model
     * @param evaluationContext the context for evaluating import restrictions (variable definitions... 
     *   interpreted locally)
     * @throws ModelManagementException in case of resolution failures
     */
    protected abstract M resolveImpl(String modelName, IVersionRestriction restrictions, URI baseUri,
        IModelRepository<M> repository, IRestrictionEvaluationContext evaluationContext) 
        throws ModelManagementException;

    /**
     * Creates a message with an end-of-chain error.
     * 
     * @return the message
     */
    List<IMessage> createEndOfChainMessage() {
        List<IMessage> result = new ArrayList<IMessage>();
        result.add(new Message(END_OF_CHAIN_MSG, Status.ERROR));
        return result;
    }
    
}
