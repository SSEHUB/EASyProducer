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

import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;

/**
 * Testcases for attributes.
 * @author lueder
 *
 */
public class AttributeTest {

    private Project pro;
    private DecisionVariableDeclaration dec;
    
    /**
     * Sets up the project + DecV before the test runs.
     */
    @Before
    public void setUp() {
        pro = new Project("Name");
        dec = new DecisionVariableDeclaration("Name", StringType.TYPE, pro);
    }
    
    /**
     * First test.
     */
    @Test
    public void test() {
        Attribute att = new Attribute("Attribut1", StringType.TYPE, pro, dec);
        Assert.assertEquals(dec, att.getElement());
    }

}
