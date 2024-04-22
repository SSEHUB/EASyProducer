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
package net.ssehub.easy.varModel.model.filter;

import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.CompoundAccessStatement;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.Project;

/**
 * This filter class searches all top level {@link DecisionVariableDeclaration}s and stores them into a Map.
 * The Map is in form of:
 * <ul>
 * <li>Key: (Not qualified) Name of the {@link DecisionVariableDeclaration}</li>
 * <li>Value: The {@link DecisionVariableDeclaration} itself</li>
 * </ul>
 * 
 * @author El-Sharkawy
 *
 */
public class DeclarationMapper extends AbstractDeclarationFinder {
    private Map<String, DecisionVariableDeclaration> declarations;
    
    /**
     * Sole constructor for this class.
     * @param project The project where the visiting shall start
     * @param filterType Specifies whether project imports shall be considered or not.
     */
    public DeclarationMapper(Project project, FilterType filterType) {
        super(project, filterType);
        declarations = new HashMap<String, DecisionVariableDeclaration>();
        project.accept(this);
    }
    
    /**
     * Returns a Hashmap of all top-level {@link DecisionVariableDeclaration}s.
     * The Map is in form of:
     * <ul>
     * <li>Key: (Not qualified) Name of the {@link DecisionVariableDeclaration}</li>
     * <li>Value: The {@link DecisionVariableDeclaration} itself</li>
     * </ul>
     * @return Hashmap of all top-level {@link DecisionVariableDeclaration}s, must not be <b>null</b>.
     */
    public Map<String, DecisionVariableDeclaration> getDeclarationMap() {
        return declarations;
    }


    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        declarations.put(decl.getName(), decl);
    }
    
    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        // Not needed method, since this class should only find DecisionVariableDeclaration
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // Not needed method, since this class should only find DecisionVariableDeclaration
    }

}
