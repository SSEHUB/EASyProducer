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
package net.ssehub.easy.instantiation.core.model.buildlangModel;

import java.util.List;

import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule.Side;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.AbstractRuleMatchExpression;
import net.ssehub.easy.instantiation.core.model.common.IResolvableOperation;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.IStringValueProvider;
import net.ssehub.easy.varModel.model.datatypes.CustomOperation;

/**
 * Defines an abstract VIL rule.
 * 
 * @author Holger Eichelberger
 */
public abstract class AbstractRule extends RuleBlock implements IResolvableOperation<VariableDeclaration>, 
    IStringValueProvider {

    private String[] annotations;
    
    /**
     * Creates the rule.
     * 
     * @param name the name
     * @param body the body
     */
    protected AbstractRule(String name, IRuleElement[] body) {
        super(name, body);
    }

    /**
     * Get the number of match conditions on the given side of this rule.
     * 
     * @param side the side (LHS, RHS)
     * @return The number of preconditions (match conditions) of this rule.
     */
    public abstract int getRuleConditionCount(Side side);

    /**
     * Get the match conditions of this rule on the given side at the specified index.
     * 
     * @param side the side (LHS, RHS)
     * @param index The 0-based index of the match condition to be returned. 
     * @return The match condition at the given index.
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getRuleConditionCount(Side)}</code>
     */
    public abstract AbstractRuleMatchExpression getRuleCondition(Side side, int index);

    /**
     * Returns whether the specified side has either rule calls or a matching condition.
     * 
     * @param side the side (LHS, RHS)
     * @return whether the specified side has cinditions at all
     */
    public abstract boolean hasCondition(Side side);
    
    /**
     * Get the number of rule calls on the given side of this rule.
     * 
     * @param side the side (LHS, RHS)
     * @return The number of postconditions of this rule.
     */
    public abstract int getRuleCallCount(Side side);
    
    /**
     * Get the rule call on the given side of this rule at the specified index.
     * 
     * @param side the side (LHS, RHS)
     * @param index The 0-based index of the rule element to be returned. 
     * @return The rule element at the given index.
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 || index &gt;={@link #getRuleCallCount(Side)}</code>
     */
    public abstract RuleCallExpression getRuleCall(Side side, int index);

    /**
     * Returns whether a rule is declared as protected regarding its visibility.
     * 
     * @return <code>true</code> if it is protected, <code>false</code> else
     */
    public abstract boolean isProtected();

    /**
     * Appends a call to <code>target</code> to the rule body. Currently, this method considers
     * parameters only in the sequence of the parameters of this rule.
     * 
     * @param target the rule to append the call to
     * @param qualifiedCall insert a qualified call if <code>true</code>, an unqualified call if <code>false</code>
     * @throws VilException in case that creating / resolving the rule call fails
     */
    public abstract void appendCallTo(AbstractRule target, boolean qualifiedCall) throws VilException;

    /**
     * Returns the parent script this rule is member of.
     * 
     * @return the parent
     */
    public abstract Script getParent();

    @Override
    public boolean isConstructor() {
        return false;
    }

    /**
     * Defines the operation annotations.
     * 
     * @param annotations the annotations
     */
    public void setAnnotations(List<String> annotations) {
        if (null != annotations) {
            this.annotations = annotations.toArray(new String[annotations.size()]);
        }
    }

    /**
     * Returns the number of declared annotations.
     * 
     * @return the number of declared annotations
     */
    public int getAnnotationCount() {
        return null == annotations ? 0 : annotations.length;
    }
    
    /**
     * Returns the specified annotation.
     * 
     * @param index the 0-based index of the annotation
     * @return the specified annotation
     * @throws IndexOutOfBoundsException if no annotations are defined or if the index is not 
     *     in[0;{@link #getAnnotationCount()})
     */
    public String getAnnotation(int index) {
        if (null == annotations) {
            throw new IndexOutOfBoundsException("no annotations defined");
        } else {
            return annotations[index];
        }
    }

    @Override
    public boolean hasAnnotation(String annotation) {
        return CustomOperation.hasAnnotation(annotations, annotation);
    }

}
