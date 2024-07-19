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

import net.ssehub.easy.instantiation.core.model.buildlangModel.Rule.Side;
import net.ssehub.easy.instantiation.core.model.buildlangModel.ruleMatch.AbstractRuleMatchExpression;
import net.ssehub.easy.instantiation.core.model.common.VilException;
import net.ssehub.easy.instantiation.core.model.templateModel.Def;
import net.ssehub.easy.instantiation.core.model.vilTypes.IMetaType;
import net.ssehub.easy.instantiation.core.model.vilTypes.TypeDescriptor;

/**
 * Maps a VTL rule into VIL.
 * 
 * @author Holger Eichelberger
 */
public class VtlRule extends AbstractRule {

    private Script parent;
    private Def def;
    private VariableDeclaration[] parameter;
    private java.util.Map<String, VariableDeclaration> namedParams;

    /**
     * Creates a new VTL rule mapper.
     * 
     * @param def the VTL definition
     * @param parent the script parent
     */
    protected VtlRule(Def def, Script parent) {
        super(def.getName(), null);
        this.parent = parent;
        this.def = def;
        this.parameter = new VariableDeclaration[def.getParameterCount()];
        for (int p = 0; p < this.parameter.length; p++) {
            net.ssehub.easy.instantiation.core.model.templateModel.VariableDeclaration para = def.getParameter(p);
            this.parameter[p] = new VariableDeclaration(para.getName(), para.getType(), para.isConstant(), 
                para.getExpression());
        }
        this.namedParams = VariableDeclaration.mapDefaultedParameters(this.namedParams, this.parameter);
    }

    @Override
    public TypeDescriptor<?> getReturnType() {
        return def.getReturnType();
    }

    @Override
    public int getParameterCount() {
        return parameter.length;
    }

    @Override
    public VariableDeclaration getParameter(int index) {
        return parameter[index];
    }

    @Override
    public int getRequiredParameterCount() {
        return VariableDeclaration.getRequiredParameterCount(namedParams, parameter);
    }

    @Override
    public VariableDeclaration getParameter(String name) {
        return VariableDeclaration.getParameter(namedParams, name, parameter);
    }

    @Override
    public boolean isStatic() {
        return def.isStatic();
    }

    @Override
    public boolean isFirstParameterOperand() {
        return def.isFirstParameterOperand();
    }

    @Override
    public IMetaType getParameterType(int index) {
        return def.getParameterType(index);
    }

    @Override
    public String getJavaSignature() {
        return def.getJavaSignature();
    }

    @Override
    public String getSignature() {
        return def.getSignature();
    }

    @Override
    public boolean acceptsNamedParameters() {
        return def.acceptsNamedParameters();
    }

    @Override
    public IMetaType getDeclaringType() {
        return def.getDeclaringType();
    }

    @Override
    public boolean isPlaceholder() {
        return def.isPlaceholder();
    }

    @Override
    public CompatibilityResult isCompatible(Class<?> retType, Object... params) {
        return def.isCompatible(retType, params);
    }

    @Override
    public Object invoke(Object... args) throws VilException {
        return def.invoke(args);
    }

    @Override
    public String getStringValue(StringComparator comparator) {
        return def.getStringValue(comparator);
    }

    @Override
    public boolean isVirtual() {
        return false;
    }

    @Override
    public boolean returnActualValue() {
        return true;
    }

    @Override
    public Object accept(IVisitor visitor) throws VilException {
        return visitor.visitRule(this);
    }

    @Override
    public int getRuleConditionCount(Side side) {
        return 0;
    }

    @Override
    public AbstractRuleMatchExpression getRuleCondition(Side side, int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean hasCondition(Side side) {
        return false;
    }

    @Override
    public int getRuleCallCount(Side side) {
        return 0;
    }

    @Override
    public RuleCallExpression getRuleCall(Side side, int index) {
        throw new IndexOutOfBoundsException();
    }

    @Override
    public boolean isProtected() {
        return def.isProtected();
    }

    /**
     * Appends a call to <code>target</code> to the rule body. Currently, this method considers
     * parameters only in the sequence of the parameters of this rule.
     * 
     * @param target the rule to append the call to
     * @param qualifiedCall insert a qualified call if <code>true</code>, an unqualified call if <code>false</code>
     * @throws VilException in case that creating / resolving the rule call fails
     */
    public void appendCallTo(AbstractRule target, boolean qualifiedCall) throws VilException {
        throw new VilException("Appending a call is not supported", VilException.ID_UNKNOWN);
    }

    @Override
    public Script getParent() {
        return parent;
    }
    
    /**
     * Returns the def stored in this instance.
     * 
     * @return the def
     */
    public Def getDef() {
        return def;
    }

}
