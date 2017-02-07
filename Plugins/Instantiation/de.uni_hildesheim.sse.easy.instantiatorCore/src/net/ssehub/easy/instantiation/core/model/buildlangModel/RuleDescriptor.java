package net.ssehub.easy.instantiation.core.model.buildlangModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule.Side;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.AbstractRuleMatchExpression;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.MatchFactory;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Defines the complex parts of a rule. Instances of this class are just for
 * creating rules. More or less direct access to the attributes is ok for this class.
 * 
 * @author Holger Eichelberger
 */
public class RuleDescriptor {
    
    public static final String MATCH_VAR_POSTFIX = "MATCH";
    
    private AbstractRuleMatchExpression[] lhsRuleMatches;
    private RuleCallExpression[] lhsRuleCalls;
    private AbstractRuleMatchExpression[] rhsRuleMatches;
    private RuleCallExpression[] rhsRuleCalls;
    private VariableDeclaration[] lhsVariables;
    private VariableDeclaration[] rhsVariables;
    private VariableDeclaration[] lhsMatchVariables;
    private VariableDeclaration[] rhsMatchVariables;
    private TypeDescriptor<?> returnType;

    /**
     * Creates an empty descriptor.
     */
    public RuleDescriptor() {
    }
    
    /**
     * Defines the rule conditions on the given side. Rule calls and rule condition expressions
     * are separated in here. 
     * 
     * @param side the side to return the calls for (LHS, RHS)
     * @param conditions the conditions (may be <b>null</b> if there are none)
     * @throws RuleDescriptorException in case that the given expressions cannot be applied (in the given sequence)
     */
    public void setRuleExpressions(Side side, List<Expression> conditions) throws RuleDescriptorException {
        AbstractRuleMatchExpression[] matches = null;
        RuleCallExpression[] calls = null;
        if (null != conditions) {
            List<AbstractRuleMatchExpression> matchTmp = new ArrayList<AbstractRuleMatchExpression>();
            List<RuleCallExpression> callsTmp = new ArrayList<RuleCallExpression>();
            for (int c = 0; c < conditions.size(); c++) {
                Expression expr = conditions.get(c);
                try {
                    AbstractRuleMatchExpression matchExpr = MatchFactory.INSTANCE.create(expr);
                    if (null != matchExpr) {
                        matchTmp.add(matchExpr);
                        if (!callsTmp.isEmpty()) {
                            throw new RuleDescriptorException("conditions must not be mixed with calls", c);
                        }
                    } else if (expr instanceof RuleCallExpression) {
                        callsTmp.add((RuleCallExpression) expr);
                        // can only be added at the end
                    } else {
                        throw new RuleDescriptorException("unrecongnized expression of type " 
                            + expr.inferType().getVilName(), c);
                    }
                } catch (VilException e) {
                    throw new RuleDescriptorException(e, c);
                }
            }
            if (!matchTmp.isEmpty()) {
                matches = new AbstractRuleMatchExpression[matchTmp.size()];
                matchTmp.toArray(matches);
            }
            if (!callsTmp.isEmpty()) {
                calls = new RuleCallExpression[callsTmp.size()];
                callsTmp.toArray(calls);
            }
        }
        if (Side.LHS == side) {
            lhsRuleMatches = matches;
            lhsRuleCalls = calls;
        } else {
            rhsRuleMatches = matches;
            rhsRuleCalls = calls;
        }
    }

    /**
     * Returns the rule match conditions on the specified side.
     * 
     * @param side the side to return the calls for (LHS, RHS)
     * @return the rule match conditions (may be <b>null</b>)
     */
    public AbstractRuleMatchExpression[] getRuleMatches(Side side) {
        AbstractRuleMatchExpression[] result;
        if (Side.LHS == side) {
            result = lhsRuleMatches;
        } else {
            result = rhsRuleMatches;
        }
        return result;
    }
    
    /**
     * Returns the number of match expressions on the specified side.
     * 
     * @param side the side to return the calls for (LHS, RHS)
     * 
     * @return the number of match expressions
     */
    public int getRuleMatchCount(Side side) {
        AbstractRuleMatchExpression[] calls = getRuleMatches(side);
        return null == calls ? 0 : calls.length;
    }

    /**
     * Returns the rule calls on the specified side.
     * 
     * @param side the side to return the calls for (LHS, RHS)
     * 
     * @return the rule calls (may be <b>null</b>)
     */
    public RuleCallExpression[] getRuleCalls(Side side) {
        RuleCallExpression[] result;
        if (Side.LHS == side) {
            result = lhsRuleCalls;
        } else {
            result = rhsRuleCalls;
        }
        return result;
    }

    /**
     * Returns the number of rule calls on the specified side.
     * 
     * @param side the side to return the calls for (LHS, RHS)
     * 
     * @return the number of rule calls
     */
    public int getRuleCallCount(Side side) {
        RuleCallExpression[] calls = getRuleCalls(side);
        return null == calls ? 0 : calls.length;
    }

    /**
     * Registers the LHS/RHS variables in <code>resolver</code> if applicable.
     * 
     * @param resolver the resolver instance
     * @throws VilException in case that resolving one of the expressions fails
     */
    public void registerVariables(Resolver resolver) throws VilException {
        Map<String, Integer> known = new HashMap<String, Integer>();
        registerVariables(Side.LHS, resolver, known);
        registerVariables(Side.RHS, resolver, known);
    }
    
    /**
     * Registers the variables in <code>resolver</code> if applicable.
     * 
     * @param side the side to register variables for (LHS, RHS)
     * @param res the resolver instance
     * @param names a mapping of names and a related counter how often the variable name (without number) has been used
     *    so far in this rule head
     * @throws VilException in case that resolving one of the expressions fails
     */
    private void registerVariables(Side side, Resolver res, Map<String, Integer> names) throws VilException {
        VariableDeclaration[] result;
        VariableDeclaration[] matchResult;
        String predefined = Side.LHS == side ? "LHS" : "RHS";
        String predefinedAlias = Side.LHS == side ? "TO" : "FROM";
        List<VariableDeclaration> vars = null;
        List<VariableDeclaration> matchVars = null; // match vars only in front if needed
        AbstractRuleMatchExpression[] matches = getRuleMatches(side);
        if (null != matches) {
            vars = new ArrayList<VariableDeclaration>();
            if (Side.RHS == side) {
                matchVars = new ArrayList<VariableDeclaration>();
            }
            for (int m = 0; m < matches.length; m++) {
                String name = predefined;
                String nameAlias = predefinedAlias;
                if (m > 0) {
                    name += m;
                    nameAlias += m;
                }
                if (Side.RHS == side) { // register the match expression itself
                    VariableDeclaration matchDecl = new VariableDeclaration(name + MATCH_VAR_POSTFIX, 
                        matches[m].inferType());
                    matchVars.add(matchDecl);
                    res.add(matchDecl);
                    res.addAlias(nameAlias + "_" + MATCH_VAR_POSTFIX, matchDecl);
                } // register the iterator expression
                VariableDeclaration varDecl = new VariableDeclaration(name, matches[m].getEntryType());
                vars.add(varDecl);
                res.add(varDecl);
                res.addAlias(nameAlias, varDecl);
            }
        }
        RuleCallExpression[] calls = getRuleCalls(side);
        if (null != calls) {
            if (null == vars) {
                vars = new ArrayList<VariableDeclaration>();    
            }
            for (int c = 0; c < calls.length; c++) {
                RuleCallExpression call = calls[c];
                String name = call.getName();
                if (!names.containsKey(name)) {
                    names.put(name, 1);
                } else {
                    int count = names.get(name) + 1;
                    names.put(name, count);
                    name += count;
                }
                VariableDeclaration varDecl = new VariableDeclaration(name, call.inferType());
                vars.add(varDecl);
                res.add(varDecl);
            }            
        }
        result = toArray(vars);
        matchResult = toArray(matchVars);
        if (Side.LHS == side) {
            lhsVariables = result;
            lhsMatchVariables = matchResult;
        } else {
            rhsVariables = result;
            rhsMatchVariables = matchResult;
        }
    }
    
    /**
     * Turns a list of variable declarations into an array and considers <b>null</b> as input.
     * 
     * @param vars the list of variables to be turned into an array
     * @return the array, <b>null</b> if the input is empty or <b>null</b>
     */
    private static VariableDeclaration[] toArray(List<VariableDeclaration> vars) {
        VariableDeclaration[] result;
        if (null != vars && !vars.isEmpty()) {
            result = new VariableDeclaration[vars.size()];
            vars.toArray(result);
        } else {
            result = null;
        }
        return result;
    }
    
    /**
     * Returns the variables on the given side.
     * 
     * @param side the side to return the variables for (LHS, RHS)
     * @return the LHS variables or <b>null</b> if there is none
     */
    public VariableDeclaration[] getVariables(Side side) {
        VariableDeclaration[] result;
        if (Side.LHS == side) {
            result = lhsVariables;
        } else {
            result = rhsVariables;
        }
        return result;
    }

    /**
     * Returns the match variables on the given side.
     * 
     * @param side the side to return the match variables for (LHS, RHS)
     * @return the LHS variables or <b>null</b> if there is none
     */
    public VariableDeclaration[] getMatchVariables(Side side) {
        VariableDeclaration[] result;
        if (Side.LHS == side) {
            result = lhsMatchVariables;
        } else {
            result = rhsMatchVariables;
        }
        return result;
    }
    
    /**
     * Defines the return type of this rule descriptor.
     * 
     * @param returnType the return type (may be <b>null</b> if undefined, use default instead)
     */
    public void setReturnType(TypeDescriptor<?> returnType) {
        this.returnType = returnType;
    }
    
    /**
     * Returns the return type of this rule descriptor.
     * 
     * @return the return type (may be <b>null</b> if undefined, use default instead)
     */
    public TypeDescriptor<?> getReturnType() {
        return returnType;
    }
 
}