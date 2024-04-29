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

package net.ssehub.easy.instantiation.core.model.buildlangModel;

import java.util.Map;

import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.AbstractRuleMatchExpression;
import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.CallArgument;
import net.ssehub.easy.instantiation.core.model.expressions.VariableExpression;
import net.ssehub.easy.instantiation.core.model.vilTypes.Constants;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeRegistry;

/**
 * Represents a VIL build rule (production strategy).
 * 
 * @author kroeher
 */
public class Rule extends AbstractRule {
    
    private AbstractRuleMatchExpression[] lhsRuleMatches;
    private RuleCallExpression[] lhsRuleCalls;
    private AbstractRuleMatchExpression[] rhsRuleMatches;
    private RuleCallExpression[] rhsRuleCalls;
    private VariableDeclaration[] parameters;
    private Map<String, VariableDeclaration> namedParam;
    private boolean isProtected = false;
    private Script parent;
    private VariableDeclaration[] lhsVars;
    private VariableDeclaration[] rhsVars;
    private VariableDeclaration[] rhsMatchVars;
    private TypeDescriptor<?> returnType;

    /**
     * Constructor for serialization.
     */
    public Rule() {
        super(null, null);
    }
    
    /**
     * Create a new rule with the given name. As no descriptor is given,
     * call {@link #setDescriptorInformation(RuleDescriptor)} somewhen before using this rule.
     * 
     * @param name The name of the rule.
     * @param isProtected if the visibility of the rule is actually restricted 
     * @param returnType the return type (may be <b>null</b> to use the default)
     * @param parameters the parameters of this rule (may be <b>null</b>)
     * @param parent the parent rule
     */
    public Rule(String name, boolean isProtected, TypeDescriptor<?> returnType, VariableDeclaration[] parameters, 
        Script parent) {
        super(name, null);
        this.isProtected = isProtected;
        this.parent = parent;
        this.parameters = parameters;
        this.namedParam = VariableDeclaration.mapDefaultedParameters(this.namedParam, this.parameters);
        if (null != returnType) {
            this.returnType = returnType;
        } else {
            this.returnType = getDefaultReturnType();
        }
    }
    
    /**
     * Create a new rule with the given name.
     * 
     * @param name The name of the rule.
     * @param isProtected if the visibility of the rule is actually restricted 
     * @param parameters the parameters of this rule (may be <b>null</b>)
     * @param descriptor the descriptor
     * @param parent the parent rule
     * @see #setDescriptorInformation(RuleDescriptor)
     */
    public Rule(String name, boolean isProtected, VariableDeclaration[] parameters, RuleDescriptor descriptor, 
        Script parent) {
        this(name, isProtected, null, parameters, parent);
        setDescriptorInformation(descriptor);
    }
    
    /**
     * Sets the information from the given rule <code>descriptor</code>.
     * 
     * @param descriptor the descriptor to be used
     */
    public void setDescriptorInformation(RuleDescriptor descriptor) {
        this.lhsRuleMatches = descriptor.getRuleMatches(Side.LHS);
        this.lhsRuleCalls = descriptor.getRuleCalls(Side.LHS);
        this.rhsRuleMatches = descriptor.getRuleMatches(Side.RHS);
        this.rhsRuleCalls = descriptor.getRuleCalls(Side.RHS);
        this.lhsVars = descriptor.getVariables(Side.LHS);
        this.rhsVars = descriptor.getVariables(Side.RHS);
        //this.lhsMatchVars = descriptor.getMatchVariables(Side.LHS);
        this.rhsMatchVars = descriptor.getMatchVariables(Side.RHS);
        if (null != descriptor.getReturnType()) {
            this.returnType = descriptor.getReturnType();
        }
    }

    @Override
    public Script getParent() {
        return parent;
    }

    @Override
    public int getParameterCount() {
        return null == parameters ? 0 : parameters.length;
    }

    @Override
    public VariableDeclaration getParameter(int index) {
        if (null == parameters) {
            throw new IndexOutOfBoundsException();
        }
        return parameters[index];
    }
    

    @Override
    public int getRequiredParameterCount() {
        return VariableDeclaration.getRequiredParameterCount(namedParam, parameters);
    }

    @Override
    public VariableDeclaration getParameter(String name) {
        return VariableDeclaration.getParameter(namedParam, name, parameters);
    }

    /**
     * Returns the specified variable.
     * 
     * @param side the side (LHS, RHS)
     * @param index The 0-based index of the rule element to be returned. 
     * @return the variable or <b>null</b> if there is none
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getVariablesCount(Side)}</code>
     */
    public VariableDeclaration getVariable(Side side, int index) {
        VariableDeclaration[] vars = selectVars(side);
        return vars[index];
    }
    
    /**
     * Returns the specified match variable.
     * 
     * @param side the side (LHS, RHS)
     * @param index The 0-based index of the rule element to be returned. 
     * @return the match variable or <b>null</b> if there is none
     */
    public VariableDeclaration getMatchVariable(Side side, int index) {
        VariableDeclaration[] vars = selectMatchVars(side);
        VariableDeclaration result = null;
        if (null != vars && index < vars.length) { // as lhs is currently unused
            result = vars[index];
        }
        return result;
    }

    /**
     * Get the number of variables of this rule on the specified side.
     * 
     * @param side the side (LHS, RHS)
     * @return the number of variables .
     */
    public int getVariablesCount(Side side) {
        VariableDeclaration[] vars = selectVars(side);
        return null == vars ? 0 : vars.length;
    }

    /**
     * Returns the LHS/RHS variables on the specified side of this rule.
     * 
     * @param side the side (LHS, RHS)
     * @return the rule calls
     */
    private VariableDeclaration[] selectVars(Side side) {
        VariableDeclaration[] result;
        if (Side.LHS == side) {
            result = lhsVars;
        } else {
            result = rhsVars;
        }
        return result;
    }

    /**
     * Returns the LHS/RHS match variables on the specified side of this rule.
     * 
     * @param side the side (LHS, RHS)
     * @return the rule calls
     */
    private VariableDeclaration[] selectMatchVars(Side side) {
        VariableDeclaration[] result;
        if (Side.LHS == side) {
            result = null; //lhsMatchVars;
        } else {
            result = rhsMatchVars;
        }
        return result;
    }

    /**
     * Defines the rule sides.
     * 
     * @author Holger Eichelberger
     */
    public enum Side {
        
        /**
         * The left hand side (LHS), i.e., the post conditions.
         */
        LHS, 

        /**
         * The right hand side (LHS), i.e., the pre conditions.
         */
        RHS;
    }

    /**
     * Returns the match conditions on the specified side of this rule.
     * 
     * @param side the side (LHS, RHS)
     * @return the select conditions
     */
    private AbstractRuleMatchExpression[] selectConditions(Side side) {
        AbstractRuleMatchExpression[] result;
        if (Side.LHS == side) {
            result = lhsRuleMatches;
        } else {
            result = rhsRuleMatches;
        }
        return result;
    }

    /**
     * Returns the rule calls on the specified side of this rule.
     * 
     * @param side the side (LHS, RHS)
     * @return the rule calls
     */
    private RuleCallExpression[] selectCalls(Side side) {
        RuleCallExpression[] result;
        if (Side.LHS == side) {
            result = lhsRuleCalls;
        } else {
            result = rhsRuleCalls;
        }
        return result;
    }
    
    @Override
    public boolean hasCondition(Side side) {
        return getRuleCallCount(side) + getRuleConditionCount(side) > 0;
    }

    @Override
    public int getRuleConditionCount(Side side) {
        AbstractRuleMatchExpression[] conditions = selectConditions(side);
        return null == conditions ? 0 : conditions.length;
    }

    @Override
    public AbstractRuleMatchExpression getRuleCondition(Side side, int index) {
        AbstractRuleMatchExpression[] conditions = selectConditions(side);
        if (null == conditions) {
            throw new IndexOutOfBoundsException();
        }
        return conditions[index];
    }    

    @Override
    public int getRuleCallCount(Side side) {
        RuleCallExpression[] conditions = selectCalls(side);
        return null == conditions ? 0 : conditions.length;
    }

    @Override
    public RuleCallExpression getRuleCall(Side side, int index) {
        RuleCallExpression[] conditions = selectCalls(side);
        if (null == conditions) {
            throw new IndexOutOfBoundsException();
        }
        return conditions[index];
    }

    @Override
    public boolean isProtected() {
        return isProtected;
    }
    
    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitRule(this);
    }

    @Override
    public IMetaType getParameterType(int index) {
        return parameters[index].getType();
    }
    
    @Override
    public String getJavaSignature() {
        return getSignature(); // shall print out full signature!
    }

    @Override
    public String getSignature() {
        StringBuilder signature = new StringBuilder(getName());
        signature.append("(");
        if (null != parameters) {
            for (int p = 0; p < parameters.length; p++) {
                signature.append(parameters[p].getType().getVilName());
                if (p < parameters.length - 1) {
                    signature.append(",");
                }
            }
        }
        signature.append(")");
        return signature.toString();
    }

    /**
     * Returns the default return type that shall not be emitted / does not require return expressions.
     * 
     * @return the default return type
     */
    public TypeDescriptor<?> getDefaultReturnType() {
        return RuleExecutionResult.TYPE;
    }
    
    /**
     * Returns whether this rule shall return an actual value (function) or a rule execution result.
     * 
     * @return <code>true</code> in case of an actual value, <code>false</code> else
     */
    @Override
    public boolean returnActualValue() {
        return !TypeRegistry.equals(getDefaultReturnType(), getReturnType());
    }
    
    @Override
    public TypeDescriptor<?> getReturnType() {
        return returnType;
    }

    @Override
    public boolean acceptsNamedParameters() {
        return false;
    }

    @Override
    public boolean isStatic() {
        return false;
    }
    
    @Override
    public boolean isFirstParameterOperand() {
        return false;
    }

    @Override
    public IMetaType getDeclaringType() {
        return parent;
    }

    @Override
    public void appendCallTo(AbstractRule target, boolean qualifiedCall) throws VilException {
        if (null != target) {
            CallArgument[] args = new CallArgument[getParameterCount()];
            for (int p = 0; p < args.length; p++) {
                args[p] = new CallArgument(new VariableExpression(getParameter(p)));
            }
            String name = target.getName();
            if (qualifiedCall) {
                name = target.getParent().getName() + Constants.QUALIFICATION_SEPARATOR + name;
            }
            RuleCallExpression call = new RuleCallExpression(target.getParent(), false, name, args);
            call.inferType(); // resolve the call
            ExpressionStatement stmt = new ExpressionStatement(call);
            stmt.setParent(this);
            append(stmt);
        }
    }

    @Override
    public boolean isPlaceholder() {
        return false;
    }

    @Override
    public boolean isVirtual() {
        return false;
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return getSignature();
    }
    
    @Override
    protected void setParent(ILanguageElement parent) {
        super.setParent(parent);
        for (int v = 0; v < getParameterCount(); v++) {
            getParameter(v).setParent(this);
        }
        setParentFor(lhsVars);
        setParentFor(rhsVars);
        setParentFor(rhsMatchVars);
    }
    
    /**
     * Changes the parents for <code>vars</code> to <b>this</b>. [convenience]
     * 
     * @param vars the variables
     */
    protected void setParentFor(VariableDeclaration[] vars) {
        if (null != vars) {
            for (int v = 0; v < vars.length; v++) {
                setParentFor(vars[v]);
            }
        }
    }
    
    /**
     * Changes the parent of the given variable to <b>this</b>. [access modifiers]
     * 
     * @param var the variable
     */
    protected void setParentFor(VariableDeclaration var) {
        var.setParent(this);
    }

    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        return null; // not implemented, done by visitor
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        return null; // not implemented, done by visitor
    }

}
