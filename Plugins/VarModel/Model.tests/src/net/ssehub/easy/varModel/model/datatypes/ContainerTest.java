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
package net.ssehub.easy.varModel.model.datatypes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.validation.IvmlValidationVisitor;

/**
 * This class tests the commonalities of {@link Set}s and {@link Sequence}s, implemented in the super class
 * {@link Container}.
 * 
 * @author El-Sharkawy
 *
 */
public class ContainerTest {
    
    private Project project;
    private Set setType;
    private Sequence seqType;
    
    /**
     * setUp for all test cases. 
     */
    @Before
    public void setUp() {
        // Create project and datatypes.
        project = new Project("a_project");
        setType = new Set("SetType", IntegerType.TYPE, project);
        seqType = new Sequence("SeqType", IntegerType.TYPE, project);
        project.add(setType);
        project.add(seqType);
        
        //Check whether project is valid and can be used for testing.
        IvmlValidationVisitor validator = new IvmlValidationVisitor();
        project.accept(validator);
        Assert.assertEquals("Project is not valid, and cannot be used for testing other components",
            0, validator.getMessageCount());
    }
    
    /**
     * Tests the correct behavior of the isAssignableFrom method of sub classes of the container class.
     */
    @Test
    public void testIsAssignableFrom() {
        // Check whether inherited class are assignable from a container
        Assert.assertTrue("Error: Set is not a container", Container.TYPE.isAssignableFrom(setType));
        Assert.assertTrue("Error: Sequence is not a container", Container.TYPE.isAssignableFrom(seqType));
    }

    /**
     * Tests {@link Container#isContainer(IDatatype)}.
     */
    @Test
    public void testIsContainer() {
        Set set = new Set("s1", IntegerType.TYPE, null);
        Sequence seq = new Sequence("s1", IntegerType.TYPE, null);
        Assert.assertTrue(Container.isContainer(Container.TYPE));
        Assert.assertTrue(Container.isContainer(set));
        Assert.assertTrue(Container.isContainer(seq));
    }

}
