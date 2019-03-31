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
package test.net.ssehub.easy.reasoning.sseReasoner.reasoner;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import net.ssehub.easy.reasoning.core.reasoner.ConstraintList;
import net.ssehub.easy.reasoning.sseReasoner.model.ContextStack;
import net.ssehub.easy.reasoning.sseReasoner.model.SubstitutionVisitor;
import net.ssehub.easy.reasoning.sseReasoner.model.TypeCache;
import net.ssehub.easy.reasoning.sseReasoner.model.TypeCache.IConstraintTarget;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.cst.CSTSemanticException;
import net.ssehub.easy.varModel.cst.CompoundAccess;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Constraint;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.datatypes.Compound;
import net.ssehub.easy.varModel.model.datatypes.IntegerType;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;

/**
 * Basic {@link TypeCache} test.
 *  
 * @author Holger Eichelberger
 */
public class TypeCacheTests {

    /**
     * Implements a constraint target for receiving constraints.
     * 
     * @author Holger Eichelberger
     */
    private static class ConstraintTarget implements IConstraintTarget {
        
        private boolean inRescheduling;
        
        /**
         * Changes the rescheduling answer.
         * 
         * @param inRescheduling the new answer/flag value
         */
        void setInRescheduling(boolean inRescheduling) {
            this.inRescheduling = inRescheduling;
        }

        @Override
        public boolean inRescheduling() {
            return inRescheduling;
        }
        
        @Override
        public void addConstraint(ConstraintList target, boolean first, Constraint constraint, 
            IDecisionVariable register) {
            if (first) {
                target.addFirst(constraint);
            } else {
                target.add(constraint);
            }
        }

    }
    
    /**
     * Does some basic cache tests.
     * 
     * @throws ValueDoesNotMatchTypeException shall not occur 
     * @throws CSTSemanticException shall not occur
     */
    @Test
    public void testTypeCache() throws CSTSemanticException, ValueDoesNotMatchTypeException {
        // build some types and a constraint
        Compound oCmp = new Compound("OtherCompound", null);
        Compound cmp = new Compound("MyCompound", null);
        DecisionVariableDeclaration slot = new DecisionVariableDeclaration("slot", IntegerType.TYPE, cmp);
        cmp.add(slot);
        DecisionVariableDeclaration iVar = new DecisionVariableDeclaration("iVar", IntegerType.TYPE, cmp);
        DecisionVariableDeclaration var = new DecisionVariableDeclaration("var", cmp, null);
        Constraint cst = new Constraint(new OCLFeatureCall(
            new CompoundAccess(new Variable(var), slot.getName()), "==", new Variable(iVar)), null);
        ConstraintList target = new ConstraintList();

        // create an empty type cache
        TypeCache cache = new TypeCache();
        Assert.assertFalse(cache.contains(cmp));
        Assert.assertFalse(cache.contains(oCmp));

        // create a type cache entry for cmp, not for oCmp and add the constraint
        TypeCache.Entry entry = cache.createEntryFor(cmp, var);
        Assert.assertNotNull(entry);
        Assert.assertTrue(entry.toString().length() > 0);
        Assert.assertTrue(cache.contains(cmp));
        Assert.assertFalse(cache.contains(oCmp));
        Assert.assertFalse(entry.hasMapping());
        entry.addConstraint(target, true, cst, false);
        Assert.assertEquals(entry, cache.get(cmp));
        
        // cause a constraint translation/transfer without mapping
        DecisionVariableDeclaration var2 = new DecisionVariableDeclaration("var2", cmp, null);
        ConstraintTarget tgt = new ConstraintTarget();
        Assert.assertFalse(cache.transferConstraints(oCmp, tgt, null, var2));
        Assert.assertTrue(target.size() == 0);  // unchanged, oCmp not registered
        Assert.assertTrue(cache.transferConstraints(cmp, tgt, null, var2));
        Assert.assertTrue(target.size() == 1);
        // var1 changed, iVar unchanged, op unchanged
        assertOperationConstraint(target.getFirst(), var2, "==", iVar);
        
        tgt.setInRescheduling(true); // shall not make differences as we do not have default constraints here
        // cause a constraint translation/transfer with mapping
        DecisionVariableDeclaration i1Var = new DecisionVariableDeclaration("i1Var", IntegerType.TYPE, cmp);
        // this accessor does not really make sense, just for syntactical checks
        ConstraintSyntaxTree i1VarAcc = new Variable(i1Var);
        Map<AbstractVariable, ConstraintSyntaxTree> varMap = new HashMap<AbstractVariable, ConstraintSyntaxTree>();
        varMap.put(iVar, i1VarAcc);
        Map<String, ConstraintSyntaxTree> nameMap = new HashMap<String, ConstraintSyntaxTree>();
        nameMap.put(iVar.getName(), i1VarAcc);
        cache.transferContext(oCmp, varMap, nameMap);
        Assert.assertFalse(cache.contains(oCmp));
        cache.transferContext(cmp, varMap, nameMap);
        Assert.assertTrue(entry.hasMapping());
        Assert.assertNotNull(entry.getMapping(iVar, i1Var));
        Assert.assertNotNull(entry.getLocalMapping(iVar.getName(), i1Var));

        ContextStack contexts = new ContextStack();
        cache.transferToContext(oCmp, contexts, var2);
        cache.transferToContext(cmp, contexts, var2);
        Assert.assertFalse(cache.transferConstraints(oCmp, tgt, null, var2));
        Assert.assertTrue(target.size() == 1); // unchanged, oCmp not registered
        Assert.assertTrue(cache.transferConstraints(cmp, tgt, null, var2));
        Assert.assertTrue(target.size() == 2);
        // var1 changed, iVar now also changed via mapping, op unchanged
        SubstitutionVisitor sVis = new SubstitutionVisitor();
        sVis.setMappings(contexts);
        ConstraintSyntaxTree tmp = sVis.accept(target.getFirst().getConsSyntax());
        Constraint cst2 = cst.createConstraint(tmp);
        assertOperationConstraint(cst2, var2, "==", i1Var);

        checkParents(cache, cmp);
    }

    /**
     * Checks basic entry parent operations.
     * 
     * @param cache the type cache
     * @param cmp the base compound
     * @throws CSTSemanticException in case of constraint failures (shall not occur)
     */
    private void checkParents(TypeCache cache, Compound cmp) throws CSTSemanticException {
        Compound cmp2 = new Compound("MySubCompound", null, cmp);
        DecisionVariableDeclaration oVar = new DecisionVariableDeclaration("oVar", cmp, null);
        DecisionVariableDeclaration oVar1 = new DecisionVariableDeclaration("oVar1", cmp, null);
        Constraint cst = new Constraint(new OCLFeatureCall(
            new Variable(oVar), "==", new ConstantValue(NullValue.INSTANCE)), null);

        ConstraintList target = new ConstraintList();
        TypeCache.Entry oEntry = cache.createEntryFor(cmp2, oVar);
        Assert.assertTrue(cache.contains(cmp2));
        Assert.assertEquals(oEntry, cache.get(cmp2));
        oEntry.addConstraint(target, false, cst, false);
        TypeCache.Entry entry = cache.get(cmp);
        Assert.assertNotEquals(entry, oEntry);
        ConstraintTarget tgt = new ConstraintTarget();
        entry.addParent(oEntry, tgt, null, oVar1);
        Assert.assertEquals(1, target.size());
    }

    /**
     * Asserts a simple operation constraint structure with operand/parameter as given variables.
     * 
     * @param constraint the constraint
     * @param lhs the LHS variable
     * @param operation the operation name
     * @param rhs the RHS variable
     */
    private static void assertOperationConstraint(Constraint constraint, AbstractVariable lhs, String operation, 
        AbstractVariable rhs) {
        
        ConstraintSyntaxTree cst = constraint.getConsSyntax();
        Assert.assertTrue(cst instanceof OCLFeatureCall);
        OCLFeatureCall call = (OCLFeatureCall) cst;
        Assert.assertEquals(operation, call.getOperation());
        ConstraintSyntaxTree operand = call.getOperand();
        if (operand instanceof CompoundAccess) {
            // we are only interested in the compound variable due to construction of the test
            operand = ((CompoundAccess) operand).getCompoundExpression();
        }
        Assert.assertTrue(operand instanceof Variable);
        Assert.assertTrue(lhs == ((Variable) operand).getVariable());
        Assert.assertEquals(call.getParameterCount(), 1);
        Assert.assertTrue(call.getParameter(0) instanceof Variable);
        Assert.assertTrue(rhs == ((Variable) call.getParameter(0)).getVariable());
    }

}
