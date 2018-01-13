/*
 * Copyright 2009-2017 University of Hildesheim, Software Systems Engineering
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
import org.junit.Test;

/**
 * Tests {@link TypeQueries}.
 * 
 * @author Holger Eichelberger
 */
public class TypeQueriesTest {

    /**
     * Tests {@link TypeQueries#isCompound(IDatatype)}.
     */
    @Test
    public void testIsCompound() {
        Compound c = new Compound("c1", null);
        Assert.assertTrue(TypeQueries.isCompound(Compound.TYPE));
        Assert.assertTrue(TypeQueries.isCompound(c));
        Assert.assertFalse(TypeQueries.isCompound(IntegerType.TYPE));
    }
    
    /**
     * Tests {@link TypeQueries#isContainer(IDatatype)}.
     */
    @Test
    public void testIsContainer() {
        Set set = new Set("s1", IntegerType.TYPE, null);
        Sequence seq = new Sequence("s1", IntegerType.TYPE, null);

        Assert.assertTrue(TypeQueries.isContainer(Container.TYPE));
        Assert.assertTrue(TypeQueries.isContainer(set));
        Assert.assertTrue(TypeQueries.isContainer(seq));
        Assert.assertFalse(TypeQueries.isContainer(IntegerType.TYPE));
    }
    
    /**
     * Tests {@link TypeQueries#isEnum(IDatatype)}.
     */
    @Test
    public void testIsEnum() {
        Enum e = new Enum("myEnum", null);
        
        Assert.assertTrue(TypeQueries.isEnum(e));
        Assert.assertFalse(TypeQueries.isEnum(IntegerType.TYPE));
    }

}
