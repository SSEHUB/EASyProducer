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
import java.util.List;

import de.uni_hildesheim.sse.model.cst.ConstraintSyntaxTree;
import de.uni_hildesheim.sse.model.varModel.Constraint;
import de.uni_hildesheim.sse.model.varModel.Project;


/**
 * Class for extracting the constraints out of a <code>Project</code>. <br/>
 * This class is also able to separate constraints into the following categories:
 * <ul>
 * <li>AssignmentConstraints - Assigning one value to exactly one variable</li>
 * <li>Constraints - all other constraints without the AssignmentConstraints</li>
 * <li>All constraints</li>
 * </ul> 
 * @author El-Sharkawy
 *
 */
public class ConstraintSeparator {
    private List<Constraint> allConstraints;
    private List<Constraint> assignmentConstraints;
    private List<Constraint> normalConstraints;
    
    /**
     * This constructor will consider imported projects.
     * @param project The project, where all constraints should be found.
     */
    public ConstraintSeparator(Project project) {
        this(project, true);
    }
    
    /**
     * Constructor for specifying whether imported projects should be considered while finding the constraints.
     * @param project The project, where all constraints should be found
     * and separated into the categories mentioned above.
     * @param considerImports <tt>true</tt> if constraints of imported projects should also be found
     */
    public ConstraintSeparator(Project project, boolean considerImports) {
        ConstraintFinder finder = new ConstraintFinder(project, considerImports);
        allConstraints = finder.getConstraints();
        assignmentConstraints = new ArrayList<Constraint>();
        normalConstraints = new ArrayList<Constraint>();
        
        //Classify all constraints
        for (int i = 0; i < allConstraints.size(); i++) {
            Constraint constraint = allConstraints.get(i);
            ConstraintSyntaxTree cst = constraint.getConsSyntax();
            /* First check whether the constraint have a correct syntax,
             * otherwise it could be a constraint created by an user -> normalConstraint
             */
            if (null != cst) {
                ConstraintClassifier classifier = new ConstraintClassifier(cst);
                if (classifier.isAssingmentConstraint()) {
                    assignmentConstraints.add(constraint);
                } else {
                    normalConstraints.add(constraint);
                }
            } else {
                normalConstraints.add(constraint);                
            }
        }
    }
    
    /**
     * Getter for returning all constraints of an ivml project.
     * @return A list of all constraints in the specified ivml project.
     */
    public List<Constraint> getAllConstraints() {
        return allConstraints;
    }
    
    /**
     * Getter for returning all AssignmentConstraints of an ivml project.
     * @return A list of all AssignmentConstraints in the specified ivml project.
     */
    public List<Constraint> getAssingmentConstraints() {
        return assignmentConstraints;
    }
    
    /**
     * Getter for returning all non AssignmentConstraints of an ivml project.
     * @return A list of all non AssignmentConstraints in the specified ivml project.
     */
    public List<Constraint> getNormalConstraints() {
        return normalConstraints;
    }
}
