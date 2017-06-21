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
package net.ssehub.easy.varModel.cstEvaluation;

import java.util.HashSet;
import java.util.Set;

import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Stores dispatch information for dynamically dispatching a custom operation.
 * 
 * @author Holger Eichelberger
 */
class DispatchInformation {
    private CustomOperation operation;
    private IDatatype[] argTypes;
    private int bestDiff;
    private CustomOperation bestMatch;
    private Set<String> candidates;
    private Set<Project> doneProjects;
    private String opName;
    private int opParamCount;
    private IDatatype returnType;
    
    /**
     * Creates a dispatch information object.
     * 
     * @param operation the operation to dispatch
     * @param args the operation arguments
     */
    DispatchInformation(CustomOperation operation, EvaluationAccessor[] args) {
        this.operation = operation;
        opName = operation.getName();
        opParamCount = operation.getParameterCount();
        returnType = operation.getReturns();
        argTypes = new IDatatype[args.length];
        for (int a = 0, n = args.length; a < n; a++) {
            Value val = args[a].getValue();
            if (null != val) {
                // use actual type with precedence
                argTypes[a] = val.getType();
            } else if (args[a].getVariable() != null) {
                // Use declaration to get type if it's a variable
                argTypes[a] = args[a].getVariable().getDeclaration().getType();
            }
        }

        bestMatch = operation;
        bestDiff = EvaluationVisitor.calculateDiff(operation, returnType, argTypes);
        candidates = new HashSet<String>();
        candidates.add(operation.getSignature());
        doneProjects = new HashSet<Project>();
    }

    /**
     * Returns the best matching operation.
     * 
     * @return the best matching operation
     */
    CustomOperation getBestMatch() {
        return bestMatch;
    }

    /**
     * Checks the given scope for dispatch candidates.
     * 
     * @param scope the scope to check for
     */
    void checkForDispatch(Project scope) {
        if (!doneProjects.contains(scope)) {
            doneProjects.add(scope);
            for (int o = 0, n = scope.getOperationCount(); bestDiff > 0 && o < n; o++) {
                CustomOperation tmp = scope.getOperation(o);
                if (tmp != operation && opName.equals(tmp.getName()) && opParamCount == tmp.getParameterCount()) {
                    String tmpSignature = tmp.getSignature();
                    if (!candidates.contains(tmpSignature)) {
                        int diff = EvaluationVisitor.calculateDiff(tmp, returnType, argTypes);
                        if (diff < 0) {
                            continue;
                        }
                        candidates.add(tmpSignature);
                        if (diff < bestDiff) {
                            bestMatch = tmp;
                            bestDiff = diff;
                        }
                    }
                }
            }
            for (int i = 0, n = scope.getImportsCount(); bestDiff > 0 && i < n; i++) {
                Project imp = scope.getImport(i).getResolved();
                if (null != imp) {
                    checkForDispatch(imp);
                }
            }
        }
    }
    
}