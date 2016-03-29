package net.ssehub.easy.reasonerCore.reasoner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.ssehub.easy.basics.messages.Status;
import net.ssehub.easy.varModel.confModel.AssignmentState;
import net.ssehub.easy.varModel.confModel.Configuration;
import net.ssehub.easy.varModel.confModel.IAssignmentState;
import net.ssehub.easy.varModel.confModel.IConfigurationElement;
import net.ssehub.easy.varModel.confModel.IConfigurationVisitor;
import net.ssehub.easy.varModel.confModel.IDecisionVariable;
import net.ssehub.easy.varModel.model.AbstractVariable;
import net.ssehub.easy.varModel.model.Attribute;
import net.ssehub.easy.varModel.model.ModelElement;
import net.ssehub.easy.varModel.model.values.Value;

/**
 * A visitor for checking frozen values for all variables which correspond
 * to a given (temporary) assignment of attribute values. 
 *  
 * @author Holger Eichelberger
 */
public class AttributesCheckVisitor implements IConfigurationVisitor {

    private ReasoningResult result;
    private Map<String, List<Value>> values = new HashMap<String, List<Value>>();
    private boolean isValid = true;
    
    /**
     * Creates a new visitor storing the given instances for processing.
     * 
     * @param values the attribute values used as basis for the check (may be <b>null</b>)
     * @param result the reasoning results (may be modified as a side effect)
     */
    private AttributesCheckVisitor(ReasoningResult result, AttributeValues values) {
        this.result = result;
        // check this in future with semantics of attributes! rather first version
        Iterator<Attribute> iter = values.getAttributes();
        while (iter.hasNext()) {
            Attribute attr = iter.next();
            int valueCount = values.getAttributeValuesCount(attr);
            if (valueCount > 0) {
                String key = attr.getName();
                List<Value> valueList = this.values.get(key);
                if (null == valueList) {
                    valueList = new ArrayList<Value>();
                    this.values.put(key, valueList);
                }
                for (int v = 0; v < valueCount; v++) {
                    valueList.add(values.getAttributeValue(attr, v));
                }
            }
        }
    }

    /**
     * Checks the given <code>configuration</code> with respect to <code>values</code>
     * and adjusts <code>result</code> if required.
     * 
     * @param configuration the configuration to be checked (will not be modified)
     * @param reasonerConfiguration the configuration holding the attribute values (may be <b>null</b>)
     * @param result the reasoning results (may be modified as a side effect)
     * @return <code>true</code> if the configuration is valid, <code>false</code> else
     */
    public static boolean check(Configuration configuration, ReasonerConfiguration reasonerConfiguration,
        ReasoningResult result) {
        return check(configuration, ReasonerConfiguration.getAttributeValues(reasonerConfiguration), result);
    }   
    
    /**
     * Checks the given <code>configuration</code> with respect to <code>values</code>
     * and adjusts <code>result</code> if required.
     * 
     * @param configuration the configuration to be checked (will not be modified)
     * @param values the attribute values used as basis for the check (may be <b>null</b>)
     * @param result the reasoning results (may be modified as a side effect)
     * @return <code>true</code> if the configuration is valid, <code>false</code> else
     */
    public static boolean check(Configuration configuration, AttributeValues values, 
        ReasoningResult result) {
        boolean isOk = true;
        if (null != values && !values.isEmpty()) {
            AttributesCheckVisitor visitor = new AttributesCheckVisitor(result, values);
            configuration.accept(visitor);
            isOk = visitor.isValid();
        }
        return isOk;
    }

    /**
     * Returns whether the given configuration is valid with respect to the given set of attributes
     * and the actual values of the attributes.
     *  
     * @return <code>true</code> if the configuration is valid, <code>false</code> else
     */
    public boolean isValid() {
        return isValid;
    }

    @Override
    public void visitConfiguration(Configuration configuration) {
        Iterator<IDecisionVariable> iter = configuration.iterator();
        while (iter.hasNext()) {
            iter.next().accept(this);
        }
    }

    @Override
    public void visitDecisionVariable(IDecisionVariable variable) {
        for (int n = 0; n < variable.getNestedElementsCount(); n++) {
            variable.getNestedElement(n).accept(this);
        }
        isValid &= checkDecisionVariable(variable);
    }

    /**
     * Checks a single variable.
     * 
     * @param variable the configuration value to be checked
     * @return <code>true</code> if the configuration is valid, <code>false</code> else
     */
    private boolean checkDecisionVariable(IDecisionVariable variable) {
        boolean isValid = true;
        AbstractVariable decl = variable.getDeclaration();
        if (!decl.isAttribute()) {
            int aCount = variable.getAttributesCount();
            for (int a = 0; a < aCount; a++) {
                IDecisionVariable attribute = variable.getAttribute(a);
                if (!checkDecisionVariable(attribute, variable.getState())) {
                    result.addMessage(createMessage(getQualifiedName(variable), 
                        attribute.getDeclaration().getQualifiedName(), attribute.getValue(), decl));
                    isValid = false;
                }
            }
        }
        return isValid;
    }

    /**
     * Returns the qualified name of the given decision <code>variable</code>.
     * 
     * @param variable the qualified name of the given decision variable
     * @return the qualified name
     */
    private static String getQualifiedName(IDecisionVariable variable) {
        // TODO consider as basic functionality of IDecisionVariable
        String result;
        IConfigurationElement parent = variable.getParent();
        if (parent instanceof Configuration) {
            result = ((Configuration) parent).getProject().getName() + "::";
        } else if (parent instanceof IDecisionVariable) {
            result = getQualifiedName((IDecisionVariable) parent) + "::";
        } else {
            result = "";
        }
        result += variable.getDeclaration().getName();
        return result;
    }
    
    
    /**
     * Checks a single variable.
     * 
     * @param attribute the variable representing the attribute
     * @param state the assignment state of the variable being attributed by <code>attribute</code>
     * @return <code>true</code> if the configuration is valid, <code>false</code> else
     */
    private boolean checkDecisionVariable(IDecisionVariable attribute, IAssignmentState state) {
        boolean isValid = true;
        Value val = attribute.getValue();
        if (null != val) {
            List<Value> valueList = values.get(attribute.getDeclaration().getName());
            // if this fails check equals and hashode of value
            if (null != valueList && valueList.contains(val)) {
                if (AssignmentState.FROZEN != state) {
                    isValid = false;
                }
            }
        }
        return isValid;
    }
    
    /**
     * Creates the error message in case that an attribute assignment is missing.
     * 
     * @param variableName the name of the variable causing the error
     * @param attributeName the name of the required attribute
     * @param value the value of the required attribute
     * @param conflictingModelElement the model element representing the conflict (may be <b>null</b> if irrelevant)
     * @return the message instance
     */
    public static Message createMessage(String variableName, String attributeName, Value value, 
        ModelElement conflictingModelElement) {
        return new Message("variable " + variableName + " is not frozen according to attribute " 
            + attributeName + " = " + AttributeValues.toString(value), 
            Message.createList(conflictingModelElement), Status.ERROR);
    }

}
