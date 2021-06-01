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
package net.ssehub.easy.varModel.confModel;

import java.util.HashMap;
import java.util.Map;

import net.ssehub.easy.basics.logger.EASyLoggerFactory;
import net.ssehub.easy.varModel.Bundle;
import net.ssehub.easy.varModel.confModel.paths.IResolutionPathElement;
import net.ssehub.easy.varModel.confModel.paths.IndexAccessPathElement;
import net.ssehub.easy.varModel.confModel.paths.StartPathElement;
import net.ssehub.easy.varModel.cst.ConstantValue;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.cst.OCLFeatureCall;
import net.ssehub.easy.varModel.cst.Variable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.AnnotationVisitor;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.AttributeAssignment;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IAttributeAccess;
import net.ssehub.easy.varModel.model.IvmlException;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.datatypes.OclKeyWords;
import net.ssehub.easy.varModel.model.values.NullValue;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * Implements a decision variable representing a specific decision.
 * Initializes and stores attributes on decision variables.
 * 
 * @author Holger Eichelberger
 * @author El-Sharkawy
 */
abstract class DecisionVariable implements IDecisionVariable {

    private IConfigurationElement parent;
    private VariableConfigProvider configProvider;
    private AbstractVariable declaration;
    private IDecisionVariable[] attributes;
    private boolean isVisible;
    private boolean isAttribute;
    private boolean wasAssigned;
    
    /**
     * Creates a new decision variable representing a specific decision.
     * The assignment state will be {@link AssignmentState#UNDEFINED}.
     * 
     * @param parent the parent this variable is part of, typically the {@link Configuration}
     *   instance, but in case of compounds/container also the holding {@link IDecisionVariable}
     * @param varDeclaration the variable declaration instantiated by this decision
     * @param isVisible Specifies whether this variables is exported by an interface or not:
     * <ul>
     * <li><tt>true</tt>: The variable is exported by an interface or there is no interface</li>.
     * <li><tt>false</tt>: There is an interface which does not export this variable</li>.
     * </ul>
     * @param isAttribute whether this variable represents (a part of) an attribute or a variable
     */
    protected DecisionVariable(IConfigurationElement parent, AbstractVariable varDeclaration, boolean isVisible, 
        boolean isAttribute) {
        attributes = new IDecisionVariable[0];
        this.declaration = varDeclaration;
        this.parent = parent;
        this.isVisible = isVisible;
        this.isAttribute = isAttribute;
        configProvider = VariableConfigProviderFactory.createDelegate(this);
        if (!isAttribute) {
            try {
                new InitializationAnnotationVisitor().visitAnnotations(varDeclaration);
            } catch (IvmlException e) {
                EASyLoggerFactory.INSTANCE.getLogger(getClass(), Bundle.ID).exception(e);
            }
        }
    }

    /**
     * Initializes annotation variables of the containing decision variable.
     * 
     * @author Holger Eichelberger
     */
    private class InitializationAnnotationVisitor extends AnnotationVisitor {

        private Map<String, Value> values = new HashMap<String, Value>();
        private Map<String, IDecisionVariable> tmp = new HashMap<String, IDecisionVariable>();

        @Override
        public void visitAnnotations(IAttributeAccess access) throws IvmlException {
            super.visitAnnotations(access);
            DecisionVariable.this.attributes = new IDecisionVariable[tmp.size()];
            int a = 0;
            for (IDecisionVariable var : tmp.values()) {
                attributes[a++] = var;
            }
        }
        
        @Override
        protected void processAttributeAssignment(AttributeAssignment assng) throws IvmlException {
            // unpack constraints
            for (int r = 0; r < assng.getRealizingCount(); r++) {
                ConstraintSyntaxTree constr = assng.getRealizing(r).getConsSyntax();
                if (constr instanceof OCLFeatureCall) {
                    OCLFeatureCall call = (OCLFeatureCall) constr;
                    if (1 == call.getParameterCount() && OclKeyWords.ASSIGNMENT.equals(call.getOperation())) {
                        ConstraintSyntaxTree p0 = call.getOperand();
                        ConstraintSyntaxTree p1 = call.getParameter(0);
                        if (p0 instanceof Variable && p1 instanceof ConstantValue) {
                            AbstractVariable var = ((Variable) p0).getVariable();
                            String key = var.getName();
                            if (!values.containsKey(key)) {
                                values.put(key, ((ConstantValue) p1).getConstantValue());
                            }
                        }
                    }
                }
            }
        }

        @Override
        protected void processAttribute(Attribute attr) throws IvmlException {
            String key = attr.getName();
            if (!tmp.containsKey(key)) {
                VariableCreator creator = new VariableCreator(attr, DecisionVariable.this, isVisible, true);
                IDecisionVariable var = creator.getVariable();
                if (values.containsKey(key)) {
                    var.setValue(values.get(key), AssignmentState.DERIVED);
                } else if (null != attr.getDefaultValue()) {
                    if (attr.getDefaultValue() instanceof ConstantValue) {
                        Value val = ((ConstantValue) attr.getDefaultValue()).getConstantValue();
                        var.setValue(val, AssignmentState.DEFAULT);
                    }
                }
                tmp.put(key, var);
            }
        }
        
    }
    
    /**
     * Returns the number of attributes.
     * 
     * @return the number of attributes
     */
    public int getAttributesCount() {
        return attributes.length;
    }
    
    /**
     * Returns a specific attribute.
     * 
     * @param index the index of the attribute
     * @return the attribute
     * @throws IndexOutOfBoundsException if 
     *   <code>index&lt;0 || index&gt;={@link #getAttributesCount()}</code>
     */
    public IDecisionVariable getAttribute(int index) {
        return attributes[index];
    }
    
    @Override
    public final boolean isNested() {
        return !(parent instanceof Configuration);
    }
    
    @Override
    public final IConfigurationElement getParent() {
        return parent;
    }
    
    @Override
    public final Configuration getConfiguration() {
        Configuration config = null;
        if (isNested()) {
            config = parent.getConfiguration();
        } else {
            config = (Configuration) parent;
        }
        
        return config;
    }
    
    @Override
    public void accept(IConfigurationVisitor visitor) {
        visitor.visitDecisionVariable(this);
    }

    @Override
    public Value getValue() {
        Value returnValue = null;
        if (configProvider != null) {
            returnValue = configProvider.getValue();
        }
        return returnValue;
    }

    @Override
    public void setValue(Value value, IAssignmentState state) throws ConfigurationException {
        wasAssigned = true;        
        configProvider.setValue(value, state);
    }
    
    @Override
    public void setValue(Value value, IAssignmentState state, boolean asAssignment) throws ConfigurationException {
        setValue(value, state); // difference does not matter here, just in local decision variables
    }    
    
    @Override
    public IDecisionVariable getNestedElement(String name) {
        return Configuration.getNestedElement(this, name);
    }

    @Override
    public IAssignmentState getState() {
        return configProvider.getState();
    }

    @Override
    public AbstractVariable getDeclaration() {
        return declaration;
    }
    
    @Override
    public void freeze(IFreezeSelector selector) {
        if (null == selector || selector.shallFreeze(this)) {
            configProvider.freeze(selector);
            for (int a = 0; a < getAttributesCount(); a++) {
                getAttribute(a).freeze(selector);
            }
        }
    }

    @Override
    public void unfreeze(IAssignmentState state) {
        if (CommandAssignmentState.ASSIGNED_CLEAR == state) {
            wasAssigned = false;
            state = AssignmentState.ASSIGNED;
        }
        configProvider.unfreeze(state);
        for (int a = 0; a < getAttributesCount(); a++) {
            getAttribute(a).unfreeze(state);
        }
    }
    
    @Override
    public String toString() {
        String result = declaration.getName();
        if (null != getValue()) {
            result += " = " + getValue().toString();
        }
        return result;
    }
    
    @Override
    public final int getNestedDepth() {
        int depth = 0;
        
        if (isNested()) {
            IDecisionVariable parent = (IDecisionVariable) this.parent;
            depth = parent.getNestedDepth() + 1;
        } 
        
        return depth;
    }
    
    /**
     * Changes the index of the nested {@link DecisionVariable}. This method is only supported if this variable
     * is nested inside a {@link ContainerVariable}.
     * This method must be called after a nested element was removed out of the container, to ensure
     * that this variable will retrieve the correct sub value of the related {@link ContainerVariable}.
     * this method will also ensure that this nested Variable will display the correct name.
     * @param newIndex The new index inside the parent {@link IDecisionVariable}.
     * This value must be in the range (this is not checked):
     * (<tt>0 &lt;= newIndex &lt; getParent().getNestedElementsCount()</tt>)
     */
    void setIndex(int newIndex) {
        if (configProvider instanceof ContainerItemConfigProvider) {
            ContainerItemConfigProvider conItemProvider = (ContainerItemConfigProvider) configProvider;
            ContainerVariable parent = conItemProvider.getParent();
            String newName = parent.getElementName(newIndex);
            declaration = new DecisionVariableDeclaration(newName, declaration.getType(), declaration.getParent());
            conItemProvider.setIndex(newIndex);
        }
    }
    
    /**
     * Getter for the {@link VariableConfigProvider}.
     * @return Returns the {@link VariableConfigProvider} used in this class.
     * This {@link VariableConfigProvider} should not be <tt>null</tt>, however,
     * it can be <tt>null</tt> during initialization it can be <tt>null</tt>.
     */
    VariableConfigProvider getConfigProvider() {
        return configProvider;
    }
    
    /**
     * Returns whether this variable can have its own {@link IAssignmentState}.
     * @return <tt>false</tt> if one of the parents is a {@link ContainerVariable},
     * otherwise it should be <tt>true</tt>.
     */
    boolean ownStateAllowed() {
        boolean ownStateallowed = configProvider.isStateChangeAllowed();
        if (ownStateallowed && isNested() && null != getParent()) {
            ownStateallowed = ((DecisionVariable) getParent()).ownStateAllowed();
        }
        return ownStateallowed;
    }
    
    @Override
    public boolean isVisible() {
        return isVisible;
    }
    
    /**
     * Returns whether this decision variable represents an attribute.
     * 
     * @return <code>true</code> for attribute, <code>false</code> else
     */
    protected boolean isAttribute() {
        return isAttribute;
    }
    
    @Override
    public void setHistoryValue(Value value, IAssignmentState state) throws ConfigurationException {
        configProvider.setHistoryValue(value, state);
    }
    
    @Override
    public boolean hasValue() {
        return null != getValue() && null != getValue().getValue();
    }
    
    @Override
    public boolean hasNullValue() {
        return getValue() instanceof NullValue;
    }
    
    /**
     * For setting states of nested variables.
     * @param state The state of the parent, which should the nested variable also have.
     */
    void setState(IAssignmentState state) {
        configProvider.setState(state);
        for (int i = 0, n = getNestedElementsCount(); i < n; i++) {
            ((DecisionVariable) getNestedElement(i)).setState(state);
        }
    }
    
    @Override
    public String getQualifiedName() {
        return isNested() ? ((IDecisionVariable) getParent()).getQualifiedName() + "::" + getDeclaration().getName()
            : getDeclaration().getQualifiedName();
    }

    @Override
    public IResolutionPathElement getResolutionPath() {
        IResolutionPathElement result = null;
        IConfigurationElement par = getParent();
        if (par instanceof DecisionVariable) {
            result = ((DecisionVariable) par).getPathForNestedElement(this);
        } else {
            result = new StartPathElement(getDeclaration());
        }
        return result;
    }
    
    /**
     * Returns the resolution path for a nested element.
     * 
     * @param nested the nested element
     * @return the resolution path
     */
    protected IResolutionPathElement getPathForNestedElement(IDecisionVariable nested) {
        IResolutionPathElement result = null;
        for (int n = 0; null == result && n < getNestedElementsCount(); n++) {
            IDecisionVariable tmp = getNestedElement(n);
            if (tmp == nested) {
                result = new IndexAccessPathElement(getResolutionPath(), n);
            }
        }
        return result;
    }
    
    /**
     * Returns one of the actual types required to instantiate this variable. This is typically the
     * type of the underlying variable declaration, but, in case of abstract variables, may
     * also be one of the subtypes if defined. As changing the value with a different permitted
     * type leads to a take over of the respective dynamic type, the indeterminism shall not lead
     * to problems.
     * 
     * @return the instantiatable type
     */
    public IDatatype getInstantiatableType() {
        return declaration.getType();
    }
    
    @Override
    public boolean isLocal() {
        return false;
    }
    
    @Override
    public boolean wasCreated() {
        return true; // ok for all except for compound
    }

    @Override
    public void notifyCreated() {
    }

    // not really nice stuff, but the getState is too inconsistent/coarse grained to correctly answer isDefined for 
    // compounds
    
    @Override    
    public boolean notifyWasAssigned(Value value) {
        boolean old = wasAssigned;
        wasAssigned = true;
        return old;
    }

    @Override
    public boolean wasAssigned() {
        return wasAssigned;
    }

    @Override
    public boolean enableWasAssignedForIsDefined() {
        return false; // disable in general, used by IVML isDefined operation
    }

}
