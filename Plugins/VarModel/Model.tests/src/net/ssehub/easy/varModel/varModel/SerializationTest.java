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
package net.ssehub.easy.varModel.varModel;

import org.junit.Test;

import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.Comment;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.EvaluationBlock;
import net.ssehub.easy.varModel.model.ExplicitTypeVariableDeclaration;
import net.ssehub.easy.varModel.model.FreezeBlock;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.ProjectDecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.ProjectImport;
import net.ssehub.easy.varModel.model.ProjectType;
import net.ssehub.easy.varModel.model.StructuredComment;
import net.ssehub.easy.varModel.model.OperationDefinition;
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
        ClassTestUtils.assertNoArgConstructor(Attribute.class, AttributeAssignment.class,
            Comment.class, Constraint.class, DecisionVariableDeclaration.class, EvaluationBlock.class,
            ExplicitTypeVariableDeclaration.class, FreezeBlock.class, 
            OperationDefinition.class, Project.class, ProjectDecisionVariableDeclaration.class, ProjectImport.class, 
            ProjectType.class, StructuredComment.class);
    }

}
