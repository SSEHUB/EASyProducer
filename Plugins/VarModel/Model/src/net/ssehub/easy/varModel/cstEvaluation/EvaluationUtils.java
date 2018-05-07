/*
 * Copyright 2009-2018 University of Hildesheim, Software Systems Engineering
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.modelManagement.IVariable;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.cst.CopyVisitor.IVariableReplacer;
import net.ssehub.easy.varModel.cst.Self;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.Container;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.Reference;
import net.ssehub.easy.varModel.model.datatypes.TypeQueries;

/**
 * Some evaluation utility methods.
 * 
 * @author Holger Eichelberger
 */
class EvaluationUtils {

    /**
     * Creates a string of <code>count</code> spaces. (debugging)
     * 
     * @param count the number of spaces
     * @return the string
     */
    static String createSpaces(int count) {
        String res = "";
        for (int i = 1; i <= count; i++) {
            res += " ";
        }
        return res;
    }
    
    /**
     * Releases a bunch of accessors.
     * 
     * @param accessors the accessors to be released
     */
    static void release(EvaluationAccessor[] accessors) {
        for (int a = 0; a < accessors.length; a++) {
            if (null != accessors[a]) {
                accessors[a].release();
            }
        }
    }

    /**
     * Returns the declaring compound type.
     * 
     * @param decl the variable declaration to return the compound parent for
     * @return the compound parent or <b>null</b> if there is none
     */
    static Compound getDeclaringCompound(AbstractVariable decl) {
        IModelElement parent = decl.getParent();
        while (!(parent instanceof Project || parent instanceof Compound)) {
            parent = parent.getParent();
        }
        return parent instanceof Compound ? (Compound) parent : null;
    }

    /**
     * Turns the statically accessed variables into groups of variables belonging to the same compound.
     * These groups will then be bound by the same quantor (iterator).
     * 
     * @param staticIter the iterator providing access to the statically accessed variables
     * @return a mapping of compound types to used variables forming the quantor groups
     */
    static Map<IDatatype, List<AbstractVariable>> groupQuantors(Iterator<AbstractVariable> staticIter) {
        Map<IDatatype, List<AbstractVariable>> iterGroups 
            = new HashMap <IDatatype, List<AbstractVariable>>();
        while (staticIter.hasNext()) {
            AbstractVariable var = staticIter.next();
            Compound declaring = getDeclaringCompound(var);
            if (null != declaring) {
                List<AbstractVariable> group = iterGroups.get(declaring);
                if (null == group) {
                    group = new ArrayList<AbstractVariable>();
                    iterGroups.put(declaring, group);
                }
                group.add(var);
            }
        }
        return iterGroups;
    }

    /**
     * Implements a variable replacer.
     * 
     * @author Holger Eichelberger
     */
    static class VariableReplacer implements IVariableReplacer {

        private Variable iter;
        private List<AbstractVariable> decls;

        /**
         * Creates a variable replacer.
         * 
         * @param iter the iter declaration to be replaced
         * @param decls the replacing declarations
         */
        VariableReplacer(DecisionVariableDeclaration iter, List<AbstractVariable> decls) {
            this.iter = new Variable(iter);
            try {
                this.iter.inferDatatype();
            } catch (CSTSemanticException e) {
                // Should not be possible that Variable throws an exception 
                Bundle.getLogger(EvaluationVisitor.class).exception(e);
            }
            this.decls = decls;
        }
        
        @Override
        public IVariable map(IVariable variable) {
            return null;
        }

        @Override
        public ConstraintSyntaxTree mapLeaf(Variable variable) {
            ConstraintSyntaxTree result = null;
            AbstractVariable var = variable.getVariable();
            for (int i = 0; null == result && i < decls.size(); i++) { // put into map???
                if (decls.get(i) == var) {
                    result = new CompoundAccess(iter, var.getName());
                }
            }
            return result;
        }

        @Override
        public ConstraintSyntaxTree mapSelf(Self self) {
            return null;
        }
        
    }

    /**
     * Finds an attribute decision variable for the given decision variable and attribute declaration.
     * 
     * @param var the variable to search the decision variable for
     * @param decl the attribute declaration
     * @param byName compare by name or by declaration
     * @return the attribute decision variable or <b>null</b> if not found
     */
    static IDecisionVariable findAttribute(IDecisionVariable var, AbstractVariable decl, boolean byName) {
        IDecisionVariable result = null;
        if (null != var) {
            for (int a = 0, n = var.getAttributesCount(); null == result && a < n; a++) {
                IDecisionVariable attribute = var.getAttribute(a);
                if (byName && attribute.getDeclaration().getName().equals(decl.getName())) {
                    result = attribute;
                } else if (!byName && attribute.getDeclaration().equals(decl)) {
                    result = attribute;
                }
            }
        }
        return result;
    }

    /**
     * Returns the difference of the operations in terms of different (assignable) types.
     * 
     * @param operation the candidate operation for dispatch
     * @param returns the return type of the operation to be dispatched (for checking)
     * @param argTypes the actual argument types
     * @return the difference, <code>0</code> in case of signature equality, <code>-1</code> if the signature
     *   does not match the required types, a the number of assignable (not equal) types else
     */
    static int calculateDiff(CustomOperation operation, IDatatype returns, IDatatype[] argTypes) {
        int diff = diff(returns, operation.getReturns()); // if no match -1
        if (diff >= 0) {
            for (int a = 0, n = argTypes.length; diff >= 0 && a < n; a++) {
                int tmp = diff(operation.getParameterType(a).getType(), argTypes[a]);
                if (tmp < 0) {
                    diff = -1;
                } else {
                    diff += tmp;
                }
            }
        }
        return diff;        
    }
    
    /**
     * Returns the difference indicator between two types.
     * 
     * @param opType the operation type
     * @param paramType the parameter type
     * @return <code>0</code> in case of type equality, <code>-1</code> if the signature
     *   does not match the required types, <code>1</code> in case of assignable (not equal) types else
     */
    private static int diff(IDatatype opType, IDatatype paramType) {
        int result = -1;
        if (opType.isAssignableFrom(paramType)) {
            if (paramType.isAssignableFrom(opType)) {
                result = 0; // both are equal
            } else {
                result = 1; // actually, there is a distance
                if (Compound.TYPE.isAssignableFrom(paramType)) {
                    // in case of compounds, also consider the distance to the refined types so that not only
                    // direct matches but also intermediary refined types can be specified
                    result += diff((Compound) paramType, opType);
                }
                if (Container.TYPE.isAssignableFrom(opType) && Container.TYPE.isAssignableFrom(paramType)) {
                    // in case of container, also take the generic types into account 
                    result = diffContainer((Container) opType, (Container) paramType);
                }
            }
        }
        if (result != 0 && paramType instanceof Reference) {
            result = diff(opType, Reference.dereference(paramType));
        }
        return result;
    }
    
    /**
     * Calculates the difference between the compound <code>type</code> and its refinement hierarcy and 
     * <code>opType</code>.
     * 
     * @param type the compound type to iterate over
     * @param opType the type to compare
     * @return the difference count
     */
    private static int diff(Compound type, IDatatype opType) {
        int result = 0;
        if (!TypeQueries.sameTypes(type, opType)) {
            result++;
            for (int r = 0; r < type.getRefinesCount(); r++) {
                result += diff(type.getRefines(r), opType);
            }
        }
        return result;
    }
    
    /**
     * Returns the difference of container types in terms of assignable types.
     * 
     * @param opCont the container from the operation signature
     * @param paramCont the parameter / argument container type allowed to iterate to compare refined types
     * @return the difference, <code>-1</code> in case of a type mismatch
     */
    private static int diffContainer(Container opCont, Container paramCont) {
        int result = 0;
        // the container difference is not relevant as container is not a visible type in IVML 
        int opContGen = opCont.getGenericTypeCount();
        int paramContGen = paramCont.getGenericTypeCount();
        if (opContGen != paramContGen) {
            result = -1;
        } else {
            for (int i = 0; i < opContGen; i++) {
                int tmp = diff(opCont.getGenericType(i), paramCont.getGenericType(i));
                if (tmp < 0) {
                    result = -1;
                    break;
                } else {
                    result += tmp;
                }
            }
        }
        return result;
    }

}
