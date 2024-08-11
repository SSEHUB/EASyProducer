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

import net.ssehub.easy.varModel.model.OperationAnnotations;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Calculates the dynamic dispatch of a custom operation.
 * 
 * @author Holger Eichelberger
 */
public class DispatchInformation {
    
    private CustomOperation operation;
    private IDatatype[] argTypes;
    private int bestDiff;
    private CustomOperation bestMatch;
    private Set<String> candidates;
    private Set<Project> doneProjects;
    private String opName;
    private int opParamCount;
    private IDatatype returnType;
    private int overrideCount;
    private int dispatchBasisCount;
    private boolean countAnnotations;

    /**
     * Creates a dispatch information object (not counting annotations).
     * 
     * @param operation the operation to dispatch
     * @param args the operation arguments
     */
    DispatchInformation(CustomOperation operation, EvaluationAccessor[] args) {
        this(operation, getArgTypes(args), false);
    }

    /**
     * Creates a dispatch information object.
     * 
     * @param operation the operation to dispatch
     * @param argTypes the argument types
     * @param countAnnotations shall annotations be counted or not
     */
    public DispatchInformation(CustomOperation operation, IDatatype[] argTypes, boolean countAnnotations) {
        this.operation = operation;
        this.countAnnotations = countAnnotations;
        opName = operation.getName();
        opParamCount = operation.getParameterCount();
        returnType = operation.getReturns();
        this.argTypes = argTypes;
        bestMatch = operation;
        bestDiff = EvaluationUtils.calculateDiff(operation, returnType, argTypes);
        candidates = new HashSet<String>();
        candidates.add(operation.getSignature());
        updateCounts(operation);
        doneProjects = new HashSet<Project>();
    }
    
    /**
     * Extracts the argument types.
     * 
     * @param args the arguments
     * @return the argument types
     */
    private static IDatatype[] getArgTypes(EvaluationAccessor[] args) {
        IDatatype[] argTypes = new IDatatype[args.length];
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
        return argTypes;
    }

    /**
     * Returns the best matching operation.
     * 
     * @return the best matching operation
     */
    public CustomOperation getBestMatch() {
        return bestMatch;
    }
    
    /**
     * Checks the given scope for dispatch candidates.
     * 
     * @param scope the scope to check for
     */
    public void checkForDispatch(Project scope) {
        if (!doneProjects.contains(scope)) {
            doneProjects.add(scope);
            for (int o = 0, n = scope.getOperationCount(); (bestDiff > 0 || countAnnotations) && o < n; o++) {
                CustomOperation tmp = scope.getOperation(o);
                if (tmp != operation && opName.equals(tmp.getName()) && opParamCount == tmp.getParameterCount()) {
                    String tmpSignature = tmp.getSignature();
                    if (!candidates.contains(tmpSignature)) {
                        int diff = EvaluationUtils.calculateDiff(tmp, returnType, argTypes);
                        if (diff < 0) {
                            continue;
                        }
                        candidates.add(tmpSignature);
                        if (diff < bestDiff) {
                            bestMatch = tmp;
                            bestDiff = diff;
                        }
                        updateCounts(tmp);
                    }
                }
            }
            for (int i = 0, n = scope.getImportsCount(); (bestDiff > 0 || countAnnotations) && i < n; i++) {
                Project imp = scope.getImport(i).getResolved();
                if (null != imp) {
                    checkForDispatch(imp);
                }
            }
        }
    }
    
    /**
     * Updates the annotation counts if desired.
     * 
     * @param op the operation to take the annotations from
     */
    private void updateCounts(CustomOperation op) {
        if (countAnnotations) {
            overrideCount += op.hasAnnotation(OperationAnnotations.OVERRIDE) ? 1 : 0;
            dispatchBasisCount += op.hasAnnotation(OperationAnnotations.DISPATCH_BASIS) ? 1 : 0;
        }
    }

    /**
     * Returns the number of overridden annotated operations (after calling {@link #checkForDispatch(Project)}).
     * 
     * @return the number of overridden operations, always 0 if no annotations shall 
     *     be {@link #DispatchInformation(CustomOperation, IDatatype[], boolean) counted}
     */
    public int getOverrideCount() {
        return overrideCount;
    }
    
    /**
     * Returns the number of dispatch basis annotated operations  (after calling {@link #checkForDispatch(Project)}).
     * 
     * @return the number of annotated operations, always 0 if no annotations shall 
     *     be {@link #DispatchInformation(CustomOperation, IDatatype[], boolean) counted}
     */
    public int getDispatchBasisCount() {
        return dispatchBasisCount;
    }
    
    /**
     * Returns the number of candidates (after calling {@link #checkForDispatch(Project)}).
     * 
     * @return the number of candidates
     */
    public int getCandidatesCount() {
        return candidates.size();
    }
    
}