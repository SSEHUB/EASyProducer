/*
 * Copyright 2009-2015 University of Hildesheim, Software Systems Engineering
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
package de.uni_hildesheim.sse.dslcore.ui.listeners;

import org.eclipse.xtext.util.Arrays;

import net.ssehub.easy.basics.modelManagement.IModel;
import net.ssehub.easy.basics.modelManagement.IModelProcessingListener;
import net.ssehub.easy.basics.modelManagement.ModelInfo;
import net.ssehub.easy.basics.modelManagement.ModelManagement;

/**
 * Generically implements a model processing (loading) listener which disables UI controls.
 * 
 * @param <M> the model type
 * @author Holger Eichelberger
 */
public class BasicModelLoadingListener<M extends IModel> implements IModelProcessingListener<M>, 
    IAggregatableListener {

    private IControl control;
    private ModelInfo<M> info;
    private ModelManagement<M> mgt;
    private Type[] types;

    /**
     * Creates a generic listener. Either use {@link AggregatingModelLoadingListener} or call {@link #initialize()} 
     * afterwards (but not both). Reacts on all message types.
     * 
     * @param info the model information object to listen on
     * @param mgt the related model management object
     * @param control the control to be enabled and disabled
     */
    public BasicModelLoadingListener(ModelInfo<M> info, ModelManagement<M> mgt, IControl control) {
        this(info, mgt, control, null);
    }
    
    /**
     * Creates a generic listener. Either use {@link AggregatingModelLoadingListener} or call {@link #initialize()} 
     * afterwards (but not both).
     * 
     * @param info the model information object to listen on
     * @param mgt the related model management object
     * @param control the control to be enabled and disabled
     * @param types message types causing enabled messages (may be <b>null</b>)
     */
    public BasicModelLoadingListener(ModelInfo<M> info, ModelManagement<M> mgt, IControl control, Type[] types) {
        this.info = info;
        this.control = control;
        this.mgt = mgt;
        this.types = types;
    }
    
    /**
     * Creates a generic listener. [convenience method]
     * 
     * @param <M> the model type
     * @param info the model information object to listen on
     * @param mgt the related model management object
     * @param control the control to be enabled and disabled
     * @param types message types causing enabled messages (may be <b>null</b>)
     * @return the created listener
     */
    public static <M extends IModel> BasicModelLoadingListener<M> createListener(ModelInfo<M> info, 
        ModelManagement<M> mgt, IControl control, Type... types) {
        return new BasicModelLoadingListener<M>(info, mgt, control, types);
    }
    
    /**
     * Creates a model loading listener. [convenience method]
     * 
     * @param <M> the model type
     * @param info the model information object to listen on
     * @param mgt the related model management object
     * @param control the control to be enabled and disabled
     * @return the created listener
     */
    public static <M extends IModel> BasicModelLoadingListener<M> createLoadingListener(ModelInfo<M> info, 
        ModelManagement<M> mgt, IControl control) {
        return createListener(info, mgt, control, Type.LOADING);
    }

    /**
     * Initializes this listener.
     */
    public void initialize() {
        mgt.events().addProcessingListener(info, this);        
        control.setEnabled(this, !mgt.isLoading(info));
    }

    /**
     * Whether <code>type</code> is in {@link #types}.
     * 
     * @param type the type to look for
     * @return <code>true</code> if type is a contained type, <code>false</code> else
     */
    private boolean inTypes(Type type) {
        return null == types || Arrays.contains(types, type);
    }
    
    @Override
    public void notifyProcessingStarted(ModelInfo<M> info, Type type) {
        if (inTypes(type)) {
            this.control.setEnabled(this, false);
        }
    }

    @Override
    public void notifyProcessingEnded(ModelInfo<M> info, Type type) {
        if (inTypes(type)) {
            this.control.setEnabled(this, true);
        }
    }
    
    /**
     * Disposes this listener, i.e., deregisters it.
     */
    public void dispose() {
        mgt.events().removeProcessingListener(info, this);
    }

}
