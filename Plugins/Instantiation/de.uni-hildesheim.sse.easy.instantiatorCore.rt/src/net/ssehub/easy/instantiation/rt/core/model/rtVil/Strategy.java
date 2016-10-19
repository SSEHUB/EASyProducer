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

import java.util.ArrayList;
import java.util.List;

import net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleBlock;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleElement;
import net.ssehub.easy.instantiation.core.model.buildlangModel.IVisitor;
import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleDescriptor;
import net.ssehub.easy.instantiation.core.model.buildlangModel.RuleExecutionResult;
import net.ssehub.easy.instantiation.core.model.buildlangModel.VariableDeclaration;
import net.ssehub.easy.instantiation.core.model.common.IVariableDeclarationReceiver;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.expressions.Expression;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Implements an adaptation strategy, i.e., a potentially dynamic selection of sub-strategies and tactics
 * if a given objective fails. The {@link 
 * #setBody(net.ssehub.easy.instantiation.core.model.buildlangModel.IRuleElement[]) body} is considered 
 * as the breakdown statements.
 * 
 * @author Holger Eichelberger
 */
public class Strategy extends Rule implements IVariableDeclarationReceiver<VariableDeclaration>, IRtVilConcept {

    private Expression objective;
    private List<VariableDeclaration> declarations;
    private IRuleBlock postProcessing;
    private WeightingFunction weightingFunction;
    
    /**
     * Create a new strategy with the given name. As no descriptor is given,
     * call {@link #setDescriptorInformation(RuleDescriptor)} somewhen before using this rule.
     * 
     * @param name The name of the strategy.
     * @param parent the parent strategy
     * @param isProtected if the visibility of the rule is actually restricted 
     * @param parameters the parameters of this rule (may be <b>null</b>)
     */
    public Strategy(String name, boolean isProtected, VariableDeclaration[] parameters, Script parent) {
        super(name, isProtected, null, parameters, parent);
    }
    
    /**
     * Create a new strategy with the given name.
     * 
     * @param name The name of the strategy.
     * @param isProtected if the visibility of the rule is actually restricted 
     * @param parameters the parameters of this rule (may be <b>null</b>)
     * @param descriptor the descriptor
     * @param parent the parent rule
     * @see #setDescriptorInformation(RuleDescriptor)
     */
    public Strategy(String name, boolean isProtected, VariableDeclaration[] parameters, RuleDescriptor descriptor, 
        Script parent) {
        super(name, isProtected, parameters, descriptor, parent);
    }

    @Override
    public TypeDescriptor<?> getDefaultReturnType() {
        return RuleExecutionResult.TYPE; // just as a reminder as this may change in the future
    }
    
    /**
     * Defines the objective of this strategy.
     * 
     * @param objective the objective (may be <b>null</b>)
     */
    public void setObjective(Expression objective) {
        this.objective = objective;
    }
    
    /**
     * Returns the objective of this strategy.
     * 
     * @return the objective (may be <b>null</b> if there is none)
     */
    public Expression getObjective() {
        return objective;
    }

    @Override
    public void addVariableDeclaration(VariableDeclaration var) {
        if (null == declarations) {
            declarations = new ArrayList<VariableDeclaration>();
        }
        declarations.add(var);
    }
    
    /**
     * Returns the number of variable declarations.
     * 
     * @return the number of variable declarations
     */
    public int getVariableDeclarationCount() {
        return null == declarations ? 0 : declarations.size();
    }
    
    /**
     * Returns the specified variable declaration.
     * 
     * @param index the 0-based index of the variable declaration to be returned
     * @return the specified variable declaration
     * @throws IndexOutOfBoundsException if <code>index < 0 || index &gt;= {@link #getVariableDeclarationCount()}</code>
     */
    public VariableDeclaration getVariableDeclaration(int index) {
        if (null == declarations) {
            throw new IndexOutOfBoundsException();
        }
        return declarations.get(index);
    }
    
    /**
     * Returns the post processing block.
     * 
     * @return the post processing block (may be <b>null</b> if there is none)
     */
    public IRuleBlock getPostprocessing() {
        return postProcessing;
    }
    
    /**
     * Defines the element of the postprocessing part.
     * 
     * @param block the elements of the postprocessing part
     */
    public void setPostprocessing(final IRuleElement[] block) {
        if (null != block) {
            postProcessing = new IRuleBlock() {

                private IRuleElement[] elements = block;
                
                @Override
                public boolean isVirtual() {
                    return true;
                }
                
                @Override
                public int getBodyElementCount() {
                    return elements.length;
                }
                
                @Override
                public IRuleElement getBodyElement(int index) {
                    return elements[index];            
                }

                @Override
                public void addBodyElement(int index, IRuleElement element) throws VilException {
                    throw new VilException("unsupported", VilException.ID_INTERNAL);
                }
                
                @Override
                public boolean returnActualValue() {
                    return false;
                }
                
            };
        }
    }
    
    /**
     * Get the number of body elements of the postprocessing part.
     * 
     * @return The number of body elements of the postprocessing part.
     */
    /*public int getPostprocessingElementCount() {
        return null == postProcessing ? 0 : postProcessing.length;
    }*/
    
    /**
     * Get the element of the postprocessing at the specified index.
     * 
     * @param index The 0-based index of the postprocessing element to be returned. 
     * @return The postprocessing element at the given index.
     * @throws IndexOutOfBoundsException if <code>index &lt; 0 
     *     || index &gt;={@link #getPostprocessingElementCount()}</code>
     */
    /*public IRuleElement getPostprocessingElement(int index) {
        if (null == postProcessing) {
            throw new IndexOutOfBoundsException();
        }
        return postProcessing[index];
    }*/

    /**
     * Defines the weighting function.
     * 
     * @param weightingFunction the weighting function (may be <b>null</b>)
     */
    public void setWeightingFunction(WeightingFunction weightingFunction) {
        this.weightingFunction = weightingFunction;
    }
    
    /**
     * Returns the weighting function.
     * 
     * @return the weighting function (may be <b>null</b>)
     */
    public WeightingFunction getWeightingFunction() {
        return weightingFunction;
    }

    @Override
    public Object accept(IVisitor visitor) throws VilException {
        Object result;
        if (visitor instanceof IRtVilVisitor) {
            result = ((IRtVilVisitor) visitor).visitStrategy(this);
        } else {
            result = super.accept(visitor);
        }
        return result;
    }
    
}
