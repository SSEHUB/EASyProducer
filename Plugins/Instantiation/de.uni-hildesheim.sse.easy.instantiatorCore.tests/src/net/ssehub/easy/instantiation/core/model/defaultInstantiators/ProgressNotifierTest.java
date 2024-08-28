/*
 * Copyright 2009-2024 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.defaultInstantiators;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.basics.progress.BasicProgressObserver;
import net.ssehub.easy.basics.progress.BasicProgressObserver.IProgressMonitor;
import net.ssehub.easy.instantiation.core.model.execution.TracerFactory;

/**
 * Tests {@link ProgressNotifier}.
 * 
 * @author Holger Eichelberger
 */
public class ProgressNotifierTest {

    private int worked = -1;
    private String subTask = null;
    private String subTaskName = null;
    private String task = null;
    private int max = -1;

    /**
     * Tests {@link ProgressNotifier}.
     */
    @Test
    public void testProgressNotifier() {
        IProgressMonitor pm = new IProgressMonitor() {
            
            @Override
            public void worked(int wo) {
                worked = wo;
            }
            
            @Override
            public void subTask(String st) {
                subTask = st;
            }
            
            @Override
            public void setTaskName(String stn) {
                subTaskName = stn;
            }
            
            @Override
            public void beginTask(String ta, int ma) {
                task = ta;
                max = ma;
            }
        };
        BasicProgressObserver obs = new BasicProgressObserver();
        obs.register(pm);
        TracerFactory.registerProgressObserver(obs);
        ProgressNotifier.notifyProgress(0, 10, "Task");
        assertTask("Task", -1, 10, null, "Task");
        ProgressNotifier.notifyProgress(1, 10, "Task: Test");
        assertTask(null, 1, -1, "Task: Test", null);
        ProgressNotifier.notifyProgress(5, 10, "Task: Test3");
        assertTask(null, 5, -1, "Task: Test3", "Task");
        ProgressNotifier.notifyProgress(5, 11, "Task: Test3");
        assertTask(null, 5, 11, null, null);
        ProgressNotifier.notifyProgress(10, 11, "Task");
        assertTask(null, 10, -1, null, null);
        ProgressNotifier.notifyProgress(11, 11, "Task");
        assertTask("Task", 11, 11, null, "Task"); // subtask end + task end
    }
    
    /**
     * Asserts incremental task information.
     * 
     * @param task the task name
     * @param worked the worked units
     * @param max the maximum (updated) units
     * @param subTask
     * @param subTaskName
     */
    private void assertTask(String task, Integer worked, Integer max, String subTask, String subTaskName) {
        if (null != task) {
            Assert.assertEquals(task, this.task);
        } else {
            Assert.assertNull(this.task);
        }
        if (null != worked) {
            Assert.assertEquals(worked.intValue(), this.worked);
        } else {
            Assert.assertEquals(-1, this.worked);
        }
        if (null != subTask) {
            Assert.assertEquals(subTask, this.subTask);
        } else {
            Assert.assertNull(this.subTask);
        }
        if (null != subTaskName) {
            Assert.assertEquals(subTaskName, this.subTaskName);
        } else {
            Assert.assertEquals(subTaskName, this.task);
        }
        if (null != max) {
            Assert.assertEquals(max.intValue(), this.max);
        } else {
            Assert.assertEquals(-1, this.max);
        }
        this.task = null;
        this.subTask = null;
        this.subTaskName = null;
        this.worked = -1;
        this.max = -1;
    }
    
}
