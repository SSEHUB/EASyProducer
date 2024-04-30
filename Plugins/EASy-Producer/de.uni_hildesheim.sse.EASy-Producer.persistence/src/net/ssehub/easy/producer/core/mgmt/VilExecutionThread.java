/*
 * Copyright 2009-2016 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.producer.core.mgmt;

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.basics.progress.ProgressObserver;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.execution.Executor;
import net.ssehub.easy.instantiation.core.model.vilTypes.IProjectDescriptor;
import net.ssehub.easy.producer.core.persistence.internal.Activator;

/**
 * Responsible class for the execution of VIL scripts, i.e., instantiation of product line artifacts.
 * Runs the VIL execution in an own thread.
 * 
 * Usage:
 * <ol>
 *   <li>Create new thread (one per {@link PLPInfo} object, should be called by the PLPInfo):<br/>
 *     <code>vilExecutor = new VilExecutionThread(this);</code></li>
 *   <li>Register listener to get informed when the instantiation is finished/aborted:<br/>
 *     <code>vilExecutor.addListener(newListener);</code></li>
 *   <li>Start the instantiation:<br/>
 *     <code>vilExecutor.startInstantiation(observer);</code></li>
 *   <li>Abort the instantiation if necessary, e.g. in an endless loop:<br/>
 *     <code>vilExecutor.abortInstantiation(observer);</code></li>
 * </ol>
 * @author El-Sharkawy
 */
public class VilExecutionThread implements Runnable {

    private Executor executor;
    private PLPInfo plp;
    private ProgressObserver observer;
    private boolean successful;
    
    private List<IVilExecutionListener> listeners;
    
    /**
     * Creates a new VIL execution thread for the given {@link PLPInfo}, but will not start the instantiation.
     * @param plp The {@link PLPInfo}, which may be instantiated (must <b>not</b> be <code>null</code>).
     */
    public VilExecutionThread(PLPInfo plp) {
        this.plp = plp;
        listeners = new ArrayList<IVilExecutionListener>();
    }
    
    /**
     * Creates a VIL executor for the contained PLP.
     * 
     * @return the created executor
     */
    protected Executor createExecutor() {
        ProjectDescriptor me = new ProjectDescriptor(plp);
        Executor executor = new Executor(plp.getBuildScript())
            .addTarget(me)
            .addConfiguration(plp.getConfiguration());
        int predCount = plp.getMemberController().getPredecessorsCount();
        if (0 == predCount) {
            // no predecessors - assume self-instantiation
            executor.addSource(me);
        } else {
            IProjectDescriptor[] pred = new IProjectDescriptor[predCount + 1];
            int i = 0;
            pred[i++] = me;
            for (PLPInfo p : plp.getMemberController().getPredecessors()) {
                pred[i++] = new ProjectDescriptor(p);
            }
            executor.addSources(pred);
        }
        VilArgumentProvider.provideArguments(plp, executor);
        return executor;
    }
    
    /**
     * Adds a new {@link IVilExecutionListener} to get informed when the instantiation was finished/aborted.
     * @param listener The listener to be informed.
     * @see #removeListener(IVilExecutionListener)
     */
    public void addListener(IVilExecutionListener listener) {
        if (null != listener) {
            listeners.add(listener);
        }
    }
    
    /**
     * Removes an {@link IVilExecutionListener}.
     * @param listener The old listener, to be removed.
     * @see #addListener(IVilExecutionListener)
     */
    public void removeListener(IVilExecutionListener listener) {
        if (null != listener) {
            listeners.remove(listener);
        }
    }
    
    /**
     * Starts the execution of the underlying VIL script ({@link PLPInfo#getBuildScript()}) in an own thread. 
     * @param observer The observer to inform about the current progress (in case of <code>null</code>
     * {@link ProgressObserver#NO_OBSERVER} will be used).
     * @param waitFor <code>true</code> This method will wait until the script was processed completely (blocking 
     *   method), <code>false</code> script will be processed in an asynchronous manner (usually used in an GUI 
     *   environment).
     * @see #abortInstantiation()
     */
    public void startInstantiation(ProgressObserver observer, boolean waitFor) {
        if (null == executor) {
            successful = true;
            this.observer = (observer != null) ? observer : ProgressObserver.NO_OBSERVER;
            executor = createExecutor();
            Thread executionThread = new Thread(this);
            executionThread.start();
            if (waitFor) {
                try {
                    executionThread.join();
                } catch (InterruptedException e) {
                    Activator.getLogger(VilExecutionThread.class).exception(e);
                }
            }
        }
    }
    
    /**
     * Aborts the current execution of the VIL script at the next possible point (that is not any time possible, e.g.,
     * during the execution of third party tools like embedded <code>maven</code> scripts).
     * @see #startInstantiation(ProgressObserver, boolean)
     */
    public void abortInstantiation() {
        if (null != executor) {
            successful = false;
            executor.stop();
        }
    }
    
    @Override
    public void run() {
        boolean informFinished = false;
        try {
            // VIL output is handled via the TracerFactory configured in UI.Startup
            executor.execute(observer, true);
            informFinished = true;
        } catch (VilException e) {
            for (int i = 0; i < listeners.size(); i++) {
                listeners.get(i).vilExecutionAborted(plp, e);
            }
        } finally {
            executor = null;
            observer = null;
            plp.refresh();
        }
        
        // Inform only if no exception occurred and after executor is shut down (set to null)
        if (informFinished) {
            for (int i = 0; i < listeners.size(); i++) {
                listeners.get(i).vilExecutionFinished(plp, successful);
            }
        }
    }
}
