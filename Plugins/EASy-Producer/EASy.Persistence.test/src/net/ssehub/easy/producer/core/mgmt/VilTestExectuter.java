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

import org.junit.Assert;

import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.producer.core.mgmt.IVilExecutionListener;
import net.ssehub.easy.producer.core.mgmt.PLPInfo;

/**
 * Needed to test {@link PLPInfo#instantiate(de.uni_hildesheim.sse.utils.progress.ProgressObserver)}
 * to ensure that the thread has been finished before the test is finished by Junit.
 * @author El-Sharkawy
 */
class VilTestExectuter implements IVilExecutionListener {

    /**
     * Listener for testing the instantiation.
     * @author El-Sharkawy
     *
     */
    abstract static class AbstractVilListener {
        
        /**
         * Will be called in case of error detected during instantiation.
         * Overwrite it if errors shall be detected.
         * @param plp The {@link PLPInfo}, which should be instantiated and is the source for this error.
         * @param exc The error which lead to the abortion.
         */
        public void vilExecutionAborted(PLPInfo plp, VilException exc) {
            Assert.fail("Instantiation of " + plp.getProjectName() + " failed: " + exc.getMessage());
        }
        
        /**
         * Will be called after instantiation was finished successfully.
         * Maybe overwritten if needed.
         * @param plp The {@link PLPInfo} which was used for instantiation
         */
        public void vilExecutionFinished(PLPInfo plp) {
            
        }
    }
    
    private AbstractVilListener listener;
    private boolean finished;
    
    /**
     * Performs the instantiation.
     * @param plp The {@link PLPInfo} which shall be instantiated
     * @param listener A listener for asserting the correct behavior of the instantiation process.
     */
    public void assertInstantiation(PLPInfo plp, AbstractVilListener listener) {
        assertInstantiation(plp, 1000, listener);
    }
    
    /**
     * Performs the instantiation.
     * @param plp The {@link PLPInfo} which shall be instantiated
     * @param timeout Timeout in milliseconds for the whole instantiation
     * @param listener A listener for asserting the correct behavior of the instantiation process.
     */
    public void assertInstantiation(PLPInfo plp, long timeout, AbstractVilListener listener) {
        finished = false;
        this.listener = listener; 
        
        plp.addVilExecutionListener(this);
        plp.instantiate(null);
        
        long startTime = System.currentTimeMillis();
        while (!finished) {
            if (System.currentTimeMillis() - startTime < timeout) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Assert.fail(e.getMessage());
                }
            } else {
                finished = true;
                Assert.fail("Timeout occured during instantiation of " + plp.getProjectName());
            }
        }
        
        plp.removeVilExecutionListener(this);
        Assert.assertTrue("Instantiation was not finished.", finished);
    }

    @Override
    public void vilExecutionAborted(PLPInfo plp, VilException exc) {
        plp.removeVilExecutionListener(this);
        listener.vilExecutionAborted(plp, exc);
        finished = true;
    }

    @Override
    public void vilExecutionFinished(PLPInfo plp, boolean successful) {
        plp.removeVilExecutionListener(this);
        listener.vilExecutionFinished(plp);
        finished = true;
    }
}
