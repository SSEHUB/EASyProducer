package net.ssehub.easy.instantiation.core.model.buildlangModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule.Side;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.AbstractRuleMatchExpression;
import net.ssehub.easy.instantiation.core.model.common.VilException;

/**
 * Stores information about executable rules.
 * 
 * @author Holger Eichelberger
 */
class ExecutableRules {

    private List<AbstractRule> rules = new ArrayList<AbstractRule>();
    
    /**
     * Creates the executable rules structure.
     */
    public ExecutableRules() {
    }
    
    /**
     * Collects the executable rules for <code>script</code>.
     * 
     * @param script the script to collect the rules for
     */
    public void collect(Script script) {
        Set<Script> processed = new HashSet<Script>();
        Set<String> knownSignatures = new HashSet<String>();
        collect(script, false, processed, knownSignatures);
    }
    
    /**
     * Collects the executable rules for <code>script</code>.
     * 
     * @param script the script to collect the rules for
     * @param asParent was this reached via a parent relationship
     * @param processed the already processed scripts to avoid loops
     * @param knownSignatures the known signatures to exclude rules shadowed by inheritance
     */
    private void collect(Script script, boolean asParent, Set<Script> processed, Set<String> knownSignatures) {
        if (!processed.contains(script)) {
            processed.add(script);
            if (null != script.getParent()) {
                collect(script.getParent(), true, processed, knownSignatures);
            }
            for (int i = 0; i < script.getImportsCount(); i++) {
                Script imp = script.getImport(i).getResolved();
                if (null != imp) {
                    collect(imp, false, processed, knownSignatures);
                }
            }
            
            for (int r = 0; r < script.getRuleCount(); r++) {
                AbstractRule rule = script.getRule(r);
                String signature = rule.getSignature();
                if (asParent) {
                    if (knownSignatures.contains(signature)) {
                        continue;
                    }
                }
                knownSignatures.add(signature);
                rules.add(rule);
            }
        }
    }
    
    /**
     * Aims at building contributing match expressions if the given expression fails.
     * 
     * @param expression the failing expression which shall match after the contributing ones are built
     * @param visitor the execution visitor
     * @return the result of <code>expression</code> after the contributing ones are considered, may be <b>null</b>
     * @throws VilException in case of any execution error
     */
    public Object buildContributing(AbstractRuleMatchExpression expression, BuildlangExecution visitor) 
        throws VilException {
        List<AbstractRule> contributing = new ArrayList<AbstractRule>();
        for (int r = 0; r < rules.size(); r++) {
            AbstractRule candidate = rules.get(r);
            if (!visitor.isOnStack(candidate)) {
                try {
                    visitor.resolveMatches(candidate, Side.LHS);
                } catch (VilException e1) {
                }
                for (int c = 0; c < candidate.getRuleConditionCount(Side.LHS); c++) {
                    AbstractRuleMatchExpression lhsEx = candidate.getRuleCondition(Side.LHS, c);
                    if (lhsEx.contributesTo(expression)) {
                        contributing.add(candidate);
                    }
                }
            }
        }
        // build contributing, do not add if on stack
        for (int c = 0; c < contributing.size(); c++) {
            contributing.get(c).accept(visitor);
        }
        Object value = expression.accept(visitor);
        assert expression.inferType().isCollection();
        //assert value instanceof Collection; // not needed, subsequent calls can handle null
        return value;
    }
    
}
