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
package de.uni_hildesheim.sse.model.varModel.filter;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import de.uni_hildesheim.sse.model.varModel.AbstractVariable;
import de.uni_hildesheim.sse.model.varModel.AttributeAssignment;
import de.uni_hildesheim.sse.model.varModel.CompoundAccessStatement;
import de.uni_hildesheim.sse.model.varModel.DecisionVariableDeclaration;
import de.uni_hildesheim.sse.model.varModel.Project;
import de.uni_hildesheim.sse.model.varModel.ProjectImport;
import de.uni_hildesheim.sse.model.varModel.datatypes.IDatatype;
import de.uni_hildesheim.sse.model.varModel.datatypes.IResolutionScope;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory;
import de.uni_hildesheim.sse.utils.logger.EASyLoggerFactory.EASyLogger;


/**
 * This class locates all top-level DecisionVariableDeclaration in a project.
 * @author beck
 * @author El-Sharkawy
 *
 */
public class DeclarationFinder extends AbstractDeclarationFinder {
    
    private List<AbstractVariable> visibleDeclarations;
    private List<AbstractVariable> hiddenDeclarations;
    private List<AbstractVariable> allDeclarations;
    private IDatatype type;
    private Stack<Set<AbstractVariable>> interfaces;
    
    /**
     * Specifies which kind of found declarations shall by returned.
     * @author El-Sharkawy
     *
     */
    public enum VisibilityType {
        ONLY_EXPORTED, ONLY_HIDDEN, ALL;
    }
    
    /**
     * Constructor for specifying whether search results should be filtered regarding the specified
     * {@link IDatatype}.
     * @param project The project where all DecisionVariableDeclarations should be found.
     * @param filterType Specifies whether project imports shall be considered or not.
     * @param type If type is not <tt>null</tt> only declarations matching the specified type will be found
     */
    public DeclarationFinder(Project project, FilterType filterType, IDatatype type) {
        super(project, filterType);
        visibleDeclarations = new ArrayList<AbstractVariable>();
        hiddenDeclarations = new ArrayList<AbstractVariable>();
        allDeclarations = new ArrayList<AbstractVariable>();
        this.type = type;
        interfaces = new Stack<Set<AbstractVariable>>();
        project.accept(this);
    }
    
    /**
     * Getter for returning all DecisionVariableDeclarations of a Project.
     * @param type Specification whether only exported, not exported, or all declarations shall be returned:
     * <ul>
     * <li>{@link VisibilityType#ONLY_EXPORTED}: All variables which are not hidden by an interface will be returned.
     * </li>
     * <li>{@link VisibilityType#ONLY_HIDDEN}: All variables which are hidden by an interface will be returned.</li>
     * <li>{@link VisibilityType#ALL}: All variables be returned.</li>
     * </ul>
     * @return A List with all top-level DecisionVariableDeclarations
     */
    public List<AbstractVariable> getVariableDeclarations(VisibilityType type) {
        List<AbstractVariable> returnedList = allDeclarations;
        switch (type) {
        case ONLY_EXPORTED:
            returnedList = visibleDeclarations;
            break;
        case ONLY_HIDDEN:
            returnedList = hiddenDeclarations;
            break;
        case ALL:
            returnedList = allDeclarations;
            break;
        default:
            returnedList = allDeclarations;
            break;
        }
        
        return returnedList;
    }
    
    @Override
    public void visitProjectImport(ProjectImport pImport) {
        if (null != pImport.getResolved()) {
            //Check whether import has interface
            IResolutionScope scope = pImport.getScope();
            boolean considerInterface = null != scope && scope.isInterface();

            // Add interface
            if (considerInterface) {
                Set<AbstractVariable> currentScope = new HashSet<AbstractVariable>();
                for (int i = 0; i < scope.getElementCount(); i++) {
                    // Currently, an interface can only contain Abstract variables -> cast is ok/save
                    currentScope.add((AbstractVariable) scope.getElement(i));
                }
                interfaces.add(currentScope);                
            }
            
            // Visit interface
            pImport.getResolved().accept(this);
            
            //Remove interface
            if (considerInterface) {
                try {
                    interfaces.pop();
                } catch (EmptyStackException emptyExc) {
                    EASyLogger logger = EASyLoggerFactory.INSTANCE.getLogger(DeclarationFinder.class, "VarModel");
                    logger.warn(emptyExc.getLocalizedMessage());
                }
            }
        }
    }

    @Override
    public void visitDecisionVariableDeclaration(DecisionVariableDeclaration decl) {
        if (type == null || type.isAssignableFrom(decl.getType())) {
            addDeclaration(decl);    
        }
    }
    
    @Override
    public void visitAttributeAssignment(AttributeAssignment assignment) {
        for (int v = 0; v < assignment.getElementCount(); v++) {
            assignment.getElement(v).accept(this);
        }
        // may be nested, even on top-level
        for (int a = 0; a < assignment.getAssignmentCount(); a++) {
            assignment.getAssignment(a).accept(this);
        }
    }
    
    /**
     * Checks whether a given variables is hidden by an interface or visible.
     * @param decl The {@link AbstractVariable} to check.
     * @return <tt>false</tt> if the variable is hidden by an interface, <tt>true</tt> otherwise
     */
    private boolean isVisible(AbstractVariable decl) {
        // Threat all variables as visible if no interfaces are used.
        boolean visible = true;
        
        if (!interfaces.isEmpty()) {
            Set<AbstractVariable> currentScope = interfaces.peek();
            visible = currentScope.contains(decl);
        }
        
        return visible;
    }
    
    /**
     * Adds a visited {@link AbstractVariable} to the correct list of found declarations, depending on whether
     * the variable is visible (no interface or exported by an interface) or is hidden.
     * @param decl A {@link AbstractVariable} which shall be added to the list found declarations
     * ({@link #getVariableDeclarations(VisibilityType)}.
     * @see #isVisible(AbstractVariable)
     */
    private void addDeclaration(AbstractVariable decl) {
        if (isVisible(decl)) {
            visibleDeclarations.add(decl);
        } else {
            hiddenDeclarations.add(decl);
        }
        allDeclarations.add(decl);
    }

    @Override
    public void visitCompoundAccessStatement(CompoundAccessStatement access) {
        // this is no declaration
    }
    
}
