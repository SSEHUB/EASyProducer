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


import java.lang.reflect.Field;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.varModel.model.datatypes.AnyType;
import net.ssehub.easy.varModel.model.datatypes.BooleanType;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.ConstraintType;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.DerivedDatatype;
import net.ssehub.easy.varModel.model.datatypes.Enum;
import net.ssehub.easy.varModel.model.datatypes.FreezeVariableType;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.datatypes.MetaType;
import net.ssehub.easy.varModel.model.datatypes.OrderedEnum;
import net.ssehub.easy.varModel.model.datatypes.RealType;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.Sequence;
import net.ssehub.easy.varModel.model.datatypes.Set;
import net.ssehub.easy.varModel.model.datatypes.StringType;
import net.ssehub.easy.varModel.model.datatypes.TypeMapper;

/**
 * Tests for the {@link TypeMapper}.
 * @author El-Sharkawy
 *
 */
public class TypeMapperTests {
    
    /**
     * List of all supported {@link IDatatype}s.
     */
    private static final IDatatype[] ALL_TYPES = {IntegerType.TYPE, RealType.TYPE, BooleanType.TYPE, StringType.TYPE,
        MetaType.TYPE, AnyType.TYPE, Container.TYPE, Set.TYPE, Sequence.TYPE, Compound.TYPE, DerivedDatatype.TYPE,
        Enum.TYPE, OrderedEnum.TYPE, Reference.TYPE, ConstraintType.TYPE, FreezeVariableType.TYPE};
    
    /**
     * Internal helper method for converting the name of a {@link IDatatype} to a name as it should be supported
     * by the {@link TypeMapper}.
     * @param type A {@link IDatatype} of {@link #ALL_TYPES}.
     * @return The name of the given {@link IDatatype} as it should be used inside the {@link TypeMapper}.
     */
    private static String normalizeName(IDatatype type) {
        String name =  type.getName();
        return name.replace("Type", "").replace("<", "").replaceAll(">", "").replaceAll("Datatype", "");
    }
    
    /**
     * Tests the {@link TypeMapper#getName(IDatatype)} method.
     */
    @Test
    public void testGetName() {
        for (IDatatype type : ALL_TYPES) {
            String expectedName = normalizeName(type);
            String actualName = TypeMapper.getName(type);
            Assert.assertEquals(expectedName, actualName);
        }
        
    }
    
    /**
     * Tests the {@link TypeMapper#getType(String)} method.
     */
    @Test
    public void testGetType() {
        for (IDatatype type : ALL_TYPES) {
            String name = normalizeName(type);
            IDatatype actualType = TypeMapper.getType(name);
            Assert.assertEquals(type, actualType);
        }
    }
    
    /**
     * Tests whether the {@link TypeMapper} knows mappings for all {@link IDatatype}s of {@link #ALL_TYPES}.
     * Also tests that the {@link TypeMapper} does not know more mappings...
     */
    @Test
    public void testIsComplete() {
        Class<TypeMapper> clazz = TypeMapper.class;
        Field[] maps = clazz.getDeclaredFields();
        int mapsFound = 0;
        for (Field field : maps) {
            if (field.getType().isAssignableFrom(Map.class)) {
                mapsFound++;
                field.setAccessible(true);
                try {
                    Map<?, ?> map = (Map<?, ?>) field.get(null);
                    Assert.assertEquals("Error: More/Less Datatypes known inside the TypeMapper", ALL_TYPES.length,
                        map.size());
                } catch (IllegalArgumentException e) {
                    Assert.fail(e.getLocalizedMessage());
                } catch (IllegalAccessException e) {
                    Assert.fail(e.getLocalizedMessage());
                }
            }
        }
        Assert.assertEquals("Error: Expected 2 maps inside of TypeMapper.", 2, mapsFound);
    }

}
