package net.ssehub.easy.integration.common.impl;

import net.ssehub.easy.integration.common.IDecisionVariable;
import net.ssehub.easy.integration.common.ModelException;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.cst.ConstraintSyntaxTree;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.DecisionVariableDeclaration;
import net.ssehub.easy.varModel.model.IModelElement;
import net.ssehub.easy.varModel.model.IvmlDatatypeVisitor;
import net.ssehub.easy.varModel.model.Project;
import net.ssehub.easy.varModel.model.datatypes.EnumLiteral;
import net.ssehub.easy.varModel.model.datatypes.IDatatype;
import net.ssehub.easy.varModel.model.values.Value;
import net.ssehub.easy.varModel.model.values.ValueDoesNotMatchTypeException;
import net.ssehub.easy.varModel.persistency.StringProvider;

/**
 * Implements a decision variable (delegate).
 *  
 * @author Holger Eichelberger
 */
public class DecisionVariable implements IDecisionVariable {

    private static final String ATTRIBUTE_NAME_BINDING_TIME = "bindingTime";
    private DecisionVariableDeclaration variable;
    private net.ssehub.easy.varModel.confModel.IDecisionVariable value;
    private EnumLiteral bindingTime;
    
    /**
     * Creates a decision variable.
     * 
     * @param variable the IVML variable
     * @param value the related decision variable
     */
    DecisionVariable(DecisionVariableDeclaration variable, 
            net.ssehub.easy.varModel.confModel.IDecisionVariable value) {
        assert null == value || value.getDeclaration() == variable;
        this.variable = variable;
        this.value = value;
    }
    
    /**
     * Creates a new decision variable.
     * 
     * @param name the name of the variable
     * @param type the type of the variable
     * @param defaultValue the default value (may be <b>null</b>)
     * @param parent the parent of the variable, i.e. the project
     * @throws ModelException in case that the given value does not match to <code>type</code>
     */
    public DecisionVariable(String name, IDatatype type, String defaultValue, 
        Project parent) throws ModelException {
        Util.assertValidIdentifier(name);
        variable = new DecisionVariableDeclaration(name, type, parent);
        if (null != defaultValue) {
            try {
                variable.setValue(defaultValue);
            } catch (ValueDoesNotMatchTypeException e) {
                throw new ModelException(e);
            }
        }
    }
    
    @Override
    public String getName() {
        return variable.getName();
    }

    @Override
    public String getType() {
        return IvmlDatatypeVisitor.getUniqueType(variable.getType());
    }

    @Override
    public String getBindingTime() {
        String result = null;
        if (null != bindingTime) {
            result = bindingTime.getName();
        }
        return result;
    }

    @Override
    public String getDefaultValue() {
        String result;
        ConstraintSyntaxTree dflt = variable.getDefaultValue();
        if (null != dflt) {
            result = StringProvider.toIvmlString(dflt); 
        } else {
            result = null;
        }
        return result;
    }

    @Override
    public String getValue() {
        String result;
        Value val;
        if (null != value) {
            val = value.getValue();
        } else {
            val = null;
        }
        if (null == val) {
            result = null;
        } else {
            result = StringProvider.toIvmlString(val);
        }
        return result;
    }

    @Override
    public boolean hasValue() {
        return null != value && AssignmentState.UNDEFINED != value.getState();
    }
    
    @Override
    public boolean hasFrozenValue() {
        return null != value && AssignmentState.FROZEN == value.getState();
    }
    
    /**
     * Changes the binding time.
     * 
     * @param bindingTimes the binding times enum
     * @param bindingTime the new binding time
     * @throws ModelException in case that the value cannot be set
     */
    public void setBindingTime(net.ssehub.easy.varModel.model.datatypes.Enum bindingTimes,
        EnumLiteral bindingTime) throws ModelException {
        
        this.bindingTime = bindingTime;
        Attribute attr = getBindingTimeAttribute();
        if (null == attr) {
            attr = new Attribute(ATTRIBUTE_NAME_BINDING_TIME, 
                bindingTimes, bindingTimes.getParent(), variable);
            this.variable.attribute(attr);
            IModelElement elt = this.variable.getTopLevelParent();
            if (elt instanceof Project) {
                // shall be always the case in the IRET integration
                ((Project) elt).add(attr);
            }
        }
        try {
            attr.setValue(bindingTime);
        } catch (ValueDoesNotMatchTypeException e) {
            throw new ModelException(e);
        }
    }
    
    /**
     * Returns the binding time attribute if there is any.
     * 
     * @return the binding times attribute 
     */
    Attribute getBindingTimeAttribute() {
        Attribute result = null;
        int size = variable.getAttributesCount();
        for (int a = 0; null == result && a < size; a++) {
            Attribute tmp = variable.getAttribute(a);
            if (tmp.getName().equals(ATTRIBUTE_NAME_BINDING_TIME)) {
                result = tmp;
            }
        }
        return result;
    }
    
    /**
     * Returns the corresponding IVML model instance.
     * 
     * @return the corresponding model instance
     */
    public DecisionVariableDeclaration getInstance() {
        return variable;
    }

}
