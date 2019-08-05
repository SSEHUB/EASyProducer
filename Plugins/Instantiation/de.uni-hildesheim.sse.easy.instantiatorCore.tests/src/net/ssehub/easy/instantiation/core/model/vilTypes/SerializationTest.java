/*
 * Copyright 2009-2019 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.core.model.vilTypes;

import org.junit.Test;

import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlAccessorFieldDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlAnnotationFieldDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlComparisonOperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlConfigurationConversionOperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlConfigurationFieldDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlConstructorOperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlConversionOperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlOrderedEnumComparisonOperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlOrderedEnumMinMaxOperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlProjectTypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlSequenceConversionOperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlSetConversionOperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlToStringConversionOperationDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.configuration.IvmlTypeDescriptor;
import net.ssehub.easy.varModel.varModel.testSupport.ClassTestUtils;

/**
 * Test for required no-arg constructors.
 * 
 * @author Holger Eichelberger
 */
public class SerializationTest {
    
    /**
     * Tests for required no-arg constructors.
     */
    @Test
    public void testNoArgConstructors() {
        ClassTestUtils.assertNoArgConstructor(IvmlAccessorFieldDescriptor.class, IvmlAnnotationFieldDescriptor.class, 
            IvmlComparisonOperationDescriptor.class, IvmlConfigurationConversionOperationDescriptor.class, 
            IvmlConfigurationFieldDescriptor.class, IvmlConfigurationConversionOperationDescriptor.class, 
            IvmlConstructorOperationDescriptor.class, IvmlConversionOperationDescriptor.class, 
            IvmlSequenceConversionOperationDescriptor.class, IvmlSetConversionOperationDescriptor.class, 
            IvmlToStringConversionOperationDescriptor.class, IvmlOrderedEnumComparisonOperationDescriptor.class, 
            IvmlOrderedEnumMinMaxOperationDescriptor.class, IvmlProjectTypeDescriptor.class, IvmlTypeDescriptor.class);
    }

}
