/*
 * Copyright 2009-2014 University of Hildesheim, Software Systems Engineering
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
package net.ssehub.easy.instantiation.rt.core.model.rtVil;

import net.ssehub.easy.instantiation.core.model.buildlangModel.ExpressionStatement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IVisitor;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleDescriptor;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionResult;
import net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.ILanguageElement;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Implements a tactic, i.e., a sequence of adaptive changes.
 * 
 * @author Holger Eichelberger
 */
public class Tactic extends Rule implements IRtVilConcept {

    private ExpressionStatement intent;
    
    /**
     * Create a new tactic with the given name. As no descriptor is given,
     * call {@link #setDescriptorInformation(RuleDescriptor)} somewhen before using this rule.
     * 
     * @param name The name of the tactic.
     * @param parent the parent tactic
     * @param isProtected if the visibility of the rule is actually restricted 
     * @param parameters the parameters of this rule (may be <b>null</b>)
     */
    public Tactic(String name, boolean isProtected, VariableDeclaration[] parameters, Script parent) {
        super(name, isProtected, null, parameters, parent);
    }
    
    /**
     * Create a new tactic with the given name.
     * 
     * @param name The name of the tactic.
     * @param isProtected if the visibility of the rule is actually restricted 
     * @param parameters the parameters of this rule (may be <b>null</b>)
     * @param descriptor the descriptor
     * @param parent the parent rule
     * @see #setDescriptorInformation(RuleDescriptor)
     */
    public Tactic(String name, boolean isProtected, VariableDeclaration[] parameters, RuleDescriptor descriptor, 
        Script parent) {
        super(name, isProtected, parameters, descriptor, parent);
    }
    
    @Override
    public TypeDescriptor<?> getDefaultReturnType() {
        return RuleExecutionResult.TYPE; // just as a reminder as this may change in the future
    }
    
    @Override
    public Object accept(IVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IRtVilVisitor) {
            result = ((IRtVilVisitor) visitor).visitTactic(this);
        } else {
            result = super.accept(visitor);
        }
        return result;
    }
    
    /**
     * Defines the intent of this tactic.
     * 
     * @param intent the intent
     */
    public void setIntent(ExpressionStatement intent) {
        this.intent = intent;
    }
    
    /**
     * Returns the intent of this tactic.
     * 
     * @return the intent
     */
    public ExpressionStatement getIntent() {
        return intent;
    }

    @Override
    public String toString() {
        return "Tactic " + getSignature();
    }
    
    @Override
    protected void setParent(ILanguageElement parent) {
        super.setParent(parent);
    }

}
