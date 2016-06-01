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
package test.de.uni_hildesheim.sse.cycletest;

import java.util.HashSet;

import net.ssehub.easy.varModel.cst.AbstractConstraintTreeVisitor;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ContainerOperationCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;

/**
 * Searches for used Projects in a {@link net.ssehub.easy.varModel.cst.ConstraintSyntaxTree}.
 * @author El-Sharkawy
 */
public class ProjectsInCSTFinder extends AbstractConstraintTreeVisitor implements IUsedProjectFinder {

    private java.util.Set<Project> usedProjects = new HashSet<Project>();

    @Override
    public java.util.Set<Project> getUsedProjects() {
        return usedProjects;
    }
    
    @Override
    public void visitConstantValue(ConstantValue value) {
        UsedProjectFinder.visitType(value.getContainedType(), usedProjects);
    }

    @Override
    public void visitVariable(Variable variable) {
        AbstractVariable decl = variable.getVariable();
        UsedProjectFinder.visitAbstractDeclaration(decl, usedProjects);
    }
    
    @Override
    public void visitContainerOperationCall(ContainerOperationCall call) {
        for (int i = 0, end = call.getDeclaratorsCount(); i < end; i++) {
            DecisionVariableDeclaration declarator = call.getDeclarator(i);
            UsedProjectFinder.visitAbstractDeclaration(declarator, usedProjects);
        }
        super.visitContainerOperationCall(call);
    }
}
